package com.apporio.demotaxiappdriver.location;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import android.util.Log;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.Config;
import com.apporio.demotaxiappdriver.LocationSession;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.ReceivePassengerActivity;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.TrackingActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.EventLocation;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelNotificationOnLocation;
import com.apporio.demotaxiappdriver.others.EventSendLocation;
import com.apporio.demotaxiappdriver.others.EventSocketConnectionState;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.apporio.demotaxiappdriver.socketManager.AtsConnectionManager;
import com.apporio.demotaxiappdriver.socketManager.AtsEventManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class LocationUpdateService extends JobService implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener, ApiManager.APIFETCHER,
        ResultCallback<Status> {

    /**
     * Update interval of location request
     */
    private final int UPDATE_INTERVAL = 3000;

    /**
     * fastest possible interval of location request
     */
    private final int FASTEST_INTERVAL = 900;

    /**
     * The Job scheduler.
     */
    JobScheduler jobScheduler;

    /**
     * The Tag.
     */
    String TAG = "MyService";

    /**
     * LocationRequest instance
     */
    private LocationRequest locationRequest;

    /**
     * GoogleApiClient instance
     */
    private GoogleApiClient googleApiClient;

    /**
     * Location instance
     */
    private Location lastLocation;

    /**
     * Method is called when location is changed
     *
     * @param location - location from fused location provider
     */

    SessionManager sessionManager;
    ApiManager apiManager;
    LocationSession app_location_mamanger;
    ApporioLocationListener apporioLocationListener;

    public static int openScreen = 0;

    private boolean isApiRunnign = false;
    HashMap<String, String> data = new HashMap<>();
    Double latitude = 0.0;
    Double longitude = 0.0;


    @Override
    public void onCreate() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                Log.e("Error" + Thread.currentThread().getStackTrace()[2], paramThrowable.getLocalizedMessage());
            }
        });
        app_location_mamanger = new LocationSession(this);
        apiManager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
    }

    @Override
    public void onLocationChanged(Location location) {

        Log.d(TAG, "onLocationChanged [" + location + "]");
        lastLocation = location;
        writeActualLocation(location);

    }

    /**
     * extract last location if location is not available
     */
    @SuppressLint("MissingPermission")
    private void getLastKnownLocation() {
        //Log.d(TAG, "getLastKnownLocation()");
        lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (lastLocation != null) {
            Log.i(TAG, "LasKnown location. " +
                    "Long: " + lastLocation.getLongitude() +
                    " | Lat: " + lastLocation.getLatitude());
            writeLastLocation();
            startLocationUpdates();

        } else {
            Log.w(TAG, "No location retrieved yet");
            startLocationUpdates();

            //here we can show Alert to start location
        }
    }

    /**
     * this method writes location to text view or shared preferences
     *
     * @param location - location from fused location provider
     */

    @SuppressLint("SetTextI18n")
    private void writeActualLocation(Location location) {
        Log.d(TAG, location.getLatitude() + ", " + location.getLongitude());
        //here in this method you can use web service or any other thing

//        apporioLocationListener.onLocationUpdate(location);

        EventBus.getDefault().post(new EventLocation(location));
        updateLocationToSession(location);


        if (sessionManager.isLoggedIn()) {

            if (latitude == 0.0) {

                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }

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

    }

    private void callApiForUpdateDriverLocation(Location location) {

        EventBus.getDefault().post(new EventLocation(location));
        try {
            updateLocationToSession(location);

//            if (!isApiRunnign) {
//                final JSONObject obj = new JSONObject();
//                try {
//
//                    try {
//                        if (TrackingActivity.trackScreenOpen == 1) {
//                            obj.put("background_booking_id", "");
//
//                        } else {
//                            obj.put("background_booking_id", ""+sessionManager.getbooking_Id());
//                        }
//                    } catch (Exception e) {
//                        obj.put("background_booking_id", "");
//                    }
//
//                    try {
//                        obj.put("google_key", "" + getResources().getString(R.string.google_api_key));
//                    } catch (Exception e) {
//
//                    }
//                    obj.put("driver_id", sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID));
//                    obj.put("latitude", "" + location.getLatitude());
//                    obj.put("longitude", "" + location.getLongitude());
//                    obj.put("bearing", "" + location.getBearing());
//                    obj.put("accuracy", "" + location.getAccuracy());
//                    obj.put("sent_by", "Vishal");
//                    obj.put("live_status", "" + sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE));
//
//                    Log.e("***obj", "" + obj);
//
//                    EventBus.getDefault().post(new EventSendLocation(obj.toString()));
//
//                } catch (Exception e) {
//                }
//
//                try {
//                    if (AtsConnectionManager.isConnected()) {
//                        try {
//                            AtsEventManager.emitLocation(IntentKeys.SAVE_DRIVER_LAT_LONG, obj, new AtsEventManager.AtsEmitterListener() {
//                                @SuppressLint("LongLogTag")
//                                @Override
//                                public void onAcknowledge(Object location) {
//
//                                    try {
//                                        EventBus.getDefault().post(new EventSocketConnectionState(location.toString()));
//                                    }catch (Exception e){
//
//                                    }
//                                    Log.e("Acknowledgw", "" + location);
//
////                                    ((sendAck) arg -> {
////                                    }).sendAcknn(location);
//
//
//                                }
//
//                                @Override
//                                public void onError(String error) {
//                                    Log.e("Error", "" + error);
//                                }
//                            });
//
//                        } catch (Exception e) {
//
//                        }
//                    } else {
//
//                    }
//                    // listenDriverUpdateLatLong();
//                } catch (Exception e) {
//
//                }
//
//            }


            if (!isApiRunnign) {
                data.clear();
                String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

//                try {
//                    makeFile(location.getLatitude(), location.getLongitude(), mydate);
//                } catch (Exception e) {
//
//                }
//
                data.put("latitude", "" + location.getLatitude());
                data.put("longitude", "" + location.getLongitude());
                data.put("bearing", "" + location.getBearing());
                data.put("accuracy", "" + location.getAccuracy());
                apiManager._postForTracking(API_S.Tags.DRIVER_LOCATION_UPDATER, API_S.Endpoints.DRIVER_LOCATION_UPDATER, data, sessionManager);
            }

        } catch (Exception e) {

        }
    }

    /**
     * this method only provokes writeActualLocation().
     */
    private void writeLastLocation() {
        writeActualLocation(lastLocation);
    }


    /**
     * this method fetches location from fused location provider and passes to writeLastLocation
     */
    @SuppressLint("MissingPermission")
    private void startLocationUpdates() {
        //Log.i(TAG, "startLocationUpdates()");
        locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                .setFastestInterval(FASTEST_INTERVAL);

        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    /**
     * Default method of service
     *
     * @param params - JobParameters params
     * @return boolean
     */
    @Override
    public boolean onStartJob(JobParameters params) {
        startJobAgain();

        createGoogleApi();

        return false;
    }

    /**
     * Create google api instance
     */
    private void createGoogleApi() {
        //Log.d(TAG, "createGoogleApi()");
        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        //connect google api
        googleApiClient.connect();

    }

    /**
     * disconnect google api
     *
     * @param params - JobParameters params
     * @return result
     */
    @Override
    public boolean onStopJob(JobParameters params) {
        googleApiClient.disconnect();
        return false;
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


    /**
     * starting job again
     */
    private void startJobAgain() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.d(TAG, "Job Started");
            ComponentName componentName = new ComponentName(getApplicationContext(),
                    LocationUpdateService.class);
            jobScheduler = (JobScheduler) getApplicationContext().getSystemService(JOB_SCHEDULER_SERVICE);
            JobInfo jobInfo = new JobInfo.Builder(1, componentName)
                    .setMinimumLatency(10000) //10 sec interval
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY).setRequiresCharging(false).build();
            jobScheduler.schedule(jobInfo);
        }
    }

    /**
     * this method tells whether google api client connected.
     *
     * @param bundle - to get api instance
     */
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //Log.i(TAG, "onConnected()");
        getLastKnownLocation();
    }

    /**
     * this method returns whether connection is suspended
     *
     * @param i - 0/1
     */
    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "connection suspended");
    }

    /**
     * this method checks connection status
     *
     * @param connectionResult - connected or failed
     */
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "connection failed");
    }

    /**
     * this method tells the result of status of google api client
     *
     * @param status - success or failure
     */
    @Override
    public void onResult(@NonNull Status status) {
        Log.d(TAG, "result of google api client : " + status);
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
//                    checkTimeStampAndOpenScreen(script);
////                    if (!Config.ReceiverPassengerActivity) {
////
////                    }
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

    public void executeService(ApporioLocationListener apporioLocationListener) {
        this.apporioLocationListener = apporioLocationListener;
        startLocationUpdates();
    }

    public interface ApporioLocationListener {

        public void onLocationUpdate(Location location);
    }


    private void updateLocationToSession(Location location) {
        Log.d("****" + TAG, "UpdatingLocationToSession");
        if (location.getBearing() != 0.0) {
            app_location_mamanger.setBearingFactor("" + location.getBearing());
        }
        app_location_mamanger.setLocationLatLong(location);
    }


    private void checkTimeStampAndOpenScreen(final Object script) {
        final ModelNotificationOnLocation modelNotificationOnLocation = SingletonGson.getInstance().fromJson("" + script, ModelNotificationOnLocation.class);
        if (modelNotificationOnLocation.getData().getBooking_status() == 1001) {
            openReceivePassengerScreen("" + script);
        }
    }

    private void openReceivePassengerScreen(String script) {
        if (openScreen == 0) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                Config.ReceiverPassengerActivity = true;

                if (openScreen == 0) {
                    openScreen = 1;
                    Intent broadcastIntent = new Intent();
                    broadcastIntent.putExtra(IntentKeys.NAVIGATION, "2");
                    broadcastIntent.putExtra("" + IntentKeys.SCRIPT, "" + script);
                    broadcastIntent.setAction("" + BuildConfig.APPLICATION_ID);
                    sendBroadcast(broadcastIntent);
                }
            } else {
                Config.ReceiverPassengerActivity = true;
                if (openScreen == 0) {
                    openScreen = 1;
                    PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
                    @SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "" + TAG);
                    wl.acquire(30 * 1000);
                    KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
                    KeyguardManager.KeyguardLock lock = keyguardManager.newKeyguardLock(Context.KEYGUARD_SERVICE);
                    lock.disableKeyguard();

                    startActivity(new Intent(getApplicationContext(), ReceivePassengerActivity.class)
                            .putExtra(IntentKeys.NAVIGATION, "2")
                            .putExtra("" + IntentKeys.SCRIPT, script)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                }

            }
        }
//        if (!Config.ReceiverPassengerActivity) {
//
//        }
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

    public interface sendAck {
        void sendAcknn(Object arg);
    }

}