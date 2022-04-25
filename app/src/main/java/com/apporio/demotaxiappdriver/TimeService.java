package com.apporio.demotaxiappdriver;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.EventLocation;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.database.DBHelper;
import com.apporio.demotaxiappdriver.fcmclasses.OneSignalServiceClass;
import com.apporio.demotaxiappdriver.location.SamLocationRequestService;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelDriverDetails;
import com.apporio.demotaxiappdriver.models.ModelNotificationOnLocation;
import com.apporio.demotaxiappdriver.models.ModelRideNotifications;
import com.apporio.demotaxiappdriver.models.ModelTimeStamp;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.onesignal.OneSignal;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by samirgoel3@gmail.com on 4/28/2017.
 */

public class TimeService extends Service implements ApiManager.APIFETCHER {

    NotificationManager mNM;

    Double latitude = 0.0;
    Double longitude = 0.0;

    private static final String TAG = "TimeService";
    SamLocationRequestService sam_location;
    LocationSession app_location_mamanger;
    SessionManager sessionManager;
    DBHelper dbHelper;
    ApiManager apiManager;
    HashMap<String, String> data = new HashMap<>();
    private boolean isApiRunnign = false;

    private Handler mHandler = new Handler();
    private Timer mTimer = null;

    public static int openScreen = 0;
    Context context;

    private static Socket mSocket = null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        app_location_mamanger = new LocationSession(this);
        sam_location = new SamLocationRequestService(this);
        apiManager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        dbHelper = new DBHelper(this);
        Log.i("" + TAG, "Time Service Created with band value: " + sessionManager.getAppConfig().getData().getRide_config().getLocation_update_timeband() + "Seconds");


        if (mTimer != null) {
            mTimer.cancel();
        } else {
            mTimer = new Timer();
        }




        mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, 4000);

       // mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, (40 * 1000));

        mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Display a notification about us starting.

    }

    double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.#####");
        return Double.valueOf(twoDForm.format(d));
    }


    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            isApiRunnign = true;
        } else {
            isApiRunnign = false;
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

//        try {
//            ModelNotificationOnLocation modelNotificationOnLocation = SingletonGson.getInstance().fromJson("" + script, ModelNotificationOnLocation.class);
//            if (modelNotificationOnLocation.getResult().equals("2")) {
//                if (openScreen == 0) {
//                    Log.e("####Step_1", "STEP_!");
//                    checkTimeStampAndOpenScreen(script, modelNotificationOnLocation.getData().getDriver_request_timeout());
//                }
//            }
//
//        } catch (Exception e) {
//
//        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }


    class TimeDisplayTimerTask extends TimerTask {

        @Override
        public void run() {
            try {
                mHandler.post(() -> {
                    if (Config.isConnectingToInternet(TimeService.this)) {
                        if (sessionManager.isLoggedIn()) {
                            updateLocation();
                        }
                    } else {
                        //  Toast.makeText(TimeService.this, getResources().getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (Exception e) {

            }

        }

        private void updateLocation() {
            Log.d("" + TAG, "Fetching and updating location in TimeService");
            sam_location.executeService(new SamLocationRequestService.SamLocationListener() {
                @Override
                public void onLocationUpdate(Location location) {


                    if (latitude == 0.0) {

                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    }
                    updateLocationToSession(location);

                    if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                        callApiForUpdateDriverLocation(location);
                        if (Double.parseDouble(sessionManager.getDistance()) > 20.0) {

                        }

                    }
                    LatLng targetLocation = new LatLng(location.getLatitude(), location.getLongitude());//provider name is unnecessary
                    LatLng targetLocation1 = new LatLng(latitude, longitude);//provider name is unnecessary
                    getDistance(targetLocation, targetLocation1);

                    Log.e("SessionDistance", "" + getDistance(targetLocation, targetLocation1));
                    sessionManager.setDistance(String.valueOf(getDistance(targetLocation, targetLocation1)));

                    if (getDistance(targetLocation, targetLocation1) > 20) {
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    } else {
                        Log.e("***Distance", "Not Updated");
                    }
                }

            });
        }


        private void updateLocationToSession(Location location) {
            Log.d("****" + TAG, "UpdatingLocationToSession");
            if (location.getBearing() != 0.0) {
                app_location_mamanger.setBearingFactor("" + location.getBearing());
            }
            app_location_mamanger.setLocationLatLong(location);
        }
    }

    private void callApiForUpdateDriverLocation(Location location) {

        EventBus.getDefault().post(new EventLocation(location));
        try {
            if (!isApiRunnign) {
                data.clear();
                data.put("latitude", "" + location.getLatitude());
                data.put("longitude", "" + location.getLongitude());
                data.put("bearing", "" + location.getBearing());
                data.put("accuracy", "" + location.getAccuracy());
                apiManager._postForTracking(API_S.Tags.DRIVER_LOCATION_UPDATER, API_S.Endpoints.DRIVER_LOCATION_UPDATER, data, sessionManager);
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception caught while running API " + e.getMessage());
        }


    }

    private void callSocketForLocationUpdate() {

        mSocket.on("sucess", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.d("**Socket News ", new Gson().toJson(args));

            }
        });


    }

    private void makeFile(double latitude, double longitude, String mydate) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
        Date now = new Date();
        String fileName = formatter.format(now) + ".txt";//like 2016_01_12.txt


        try {
            File root = new File(Environment.getExternalStorageDirectory() + File.separator + "Driver_Logs", "Report Files");
            //File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, fileName);


            FileWriter writer = new FileWriter(gpxfile, true);
            writer.append("\n" + "Sent" + " " + latitude + " " + "," + longitude + " " + "," + "CurrentTime : " + "" + mydate);
            writer.flush();
            writer.close();

            // Toast.makeText(this, "Data has been written to Report File", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            mHandler = null;
            mTimer.cancel();
            mTimer.purge();
        } catch (Exception e) {

        }
    }

    private void checkTimeStampAndOpenScreen(final Object script, double driverTimeOutValue) {
        final ModelNotificationOnLocation modelNotificationOnLocation = SingletonGson.getInstance().fromJson("" + script, ModelNotificationOnLocation.class);
        if (modelNotificationOnLocation.getData().getBooking_status() == 1001) {

            try {
                if (sessionManager.isLoggedIn()) {
                    openReceivePassengerScreen("" + script);
                }
            } catch (Exception e) {
                openReceivePassengerScreen("" + script);
            }

//            AndroidNetworking.get(API_S.Endpoints.SERVER_TIMESTAMP)
//                    .setTag(this).setPriority(Priority.HIGH)
//                    .build().getAsString(new StringRequestListener() {
//                @Override
//                public void onResponse(String response) {
//                    try {
//                        Log.e("####Step_1","STEP_!");
//                        ModelTimeStamp modelTimeStamp = SingletonGson.getInstance().fromJson("" + response, ModelTimeStamp.class);
//                        if ((Long.parseLong("" + modelTimeStamp.getTime()) - Long.parseLong("" + modelNotificationOnLocation.getData().getTimestamp())) <= driverTimeOutValue) {  // time stamp criteria matches
//
//                        } else {
//                            Log.d("" + TAG, "Notification bypass as it delayed by 60 sec");
//                        }
//                    } catch (Exception e) {
//                        Log.d("" + TAG, "Exception caught while parsing response " + e.getMessage());
//                    }
//                }
//
//                @Override
//                public void onError(ANError anError) {
//                }
//            });
        }
    }

    private void openReceivePassengerScreen(String script) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            openScreen = 1;
            Config.ReceiverPassengerActivity = true;
            Intent broadcastIntent = new Intent();
            broadcastIntent.putExtra(IntentKeys.NAVIGATION, "2");
            broadcastIntent.putExtra("" + IntentKeys.SCRIPT, "" + script);
            broadcastIntent.setAction("" + BuildConfig.APPLICATION_ID);
            sendBroadcast(broadcastIntent);
        } else {
            openScreen = 1;
            Config.ReceiverPassengerActivity = true;
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            @SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "" + TAG);
            wl.acquire(30 * 1000);
            KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
            KeyguardManager.KeyguardLock lock = keyguardManager.newKeyguardLock(Context.KEYGUARD_SERVICE);
            lock.disableKeyguard();
            startActivity(new Intent(getApplicationContext(), ReceivePassengerActivity.class)
                    .putExtra(IntentKeys.NAVIGATION, "2")
                    .putExtra("" + IntentKeys.SCRIPT, script)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));


        }
    }

    public double getDistance(LatLng LatLng1, LatLng LatLng2) {
        double distance = 0;
        Location locationA = new Location("A");
        locationA.setLatitude(LatLng1.latitude);
        locationA.setLongitude(LatLng1.longitude);
        Location locationB = new Location("B");
        locationB.setLatitude(LatLng2.latitude);
        locationB.setLongitude(LatLng2.longitude);
        distance = locationA.distanceTo(locationB);

        return distance;
    }


}
