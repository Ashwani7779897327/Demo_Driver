package com.apporio.demotaxiappdriver.location;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;

import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.Config;
import com.apporio.demotaxiappdriver.LocationSession;
import com.apporio.demotaxiappdriver.ReceivePassengerActivity;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.analytics.MyApplication;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.EventLocation;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.fcmclasses.OneSignalServiceClass;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelNotificationOnLocation;
import com.apporio.demotaxiappdriver.others.Constants;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.apporioinfolabs.ats_sdk.AtsLocationServiceClass;
import com.google.android.gms.maps.model.LatLng;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

public class UpdateServiceClass extends AtsLocationServiceClass implements ApiManager.APIFETCHER {

    private static final String TAG = "UpdateService";

    SessionManager sessionManager;
    LocationSession app_location_mamanger;
    ApiManager apiManager;
    HashMap<String, String> data = new HashMap<>();
    private boolean isApiRunnign = false;

    public static int openScreen = 0;

    @Override
    public void onCreate() {
        super.onCreate();

        app_location_mamanger = new LocationSession(this);
        apiManager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
    }

    @Override
    public void onReceiveLocation(Location location) {
        updateLocation(location);
        MyApplication.getLocationSession().setLocationLatLong(location);
        MyApplication.getLocationSession().setBearingFactor(""+location.getBearing());
    }

    private void updateLocation(Location location) {
        callApiForUpdateDriverLocation(location);
        //        if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
//            if (latitude == 0.0) {
//                latitude = location.getLatitude();
//                longitude = location.getLongitude();
//            }
//            updateLocationToSession(location);
//        }
//
//
//        if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
//
//            try {
//                if (sessionManager.getbooking_Id() != null || !sessionManager.getbooking_Id().equals("")) {
//                    try {
//                        if (Double.parseDouble(sessionManager.getDistance()) > 20.0) {
//                            callApiForUpdateDriverLocation(location);
//                        } else {
//                            callApiForUpdateDriverLocation(location);
//                        }
//                    } catch (Exception e) {
//                        if (Double.parseDouble(sessionManager.getDistance()) > 20.0) {
//                            callApiForUpdateDriverLocation(location);
//                        } else {
//                            callApiForUpdateDriverLocation(location);
//                        }
//                    }
//                } else {
//                    callApiForUpdateDriverLocation(location);
//                }
//            } catch (Exception e) {
//                callApiForUpdateDriverLocation(location);
//            }
//            callApiForUpdateDriverLocation(location);
//
//        }
//
//
//
//        if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
//            LatLng targetLocation = new LatLng(location.getLatitude(), location.getLongitude());//provider name is unnecessary
//            LatLng targetLocation1 = new LatLng(latitude, longitude);//provider name is unnecessary
//            getDistance(targetLocation, targetLocation1);
//
//            Log.e("SessionDistance", "" + getDistance(targetLocation, targetLocation1));
//            sessionManager.setDistance(String.valueOf(getDistance(targetLocation, targetLocation1)));
//
//            if (getDistance(targetLocation, targetLocation1) > 20) {
//                latitude = location.getLatitude();
//                longitude = location.getLongitude();
//            } else {
//                Log.e("***Distance", "Not Updated");
//            }
//
//        }
//
//
//        if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
//            callApiForUpdateDriverLocation(location);
//        }
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
        try {
            ModelNotificationOnLocation modelNotificationOnLocation = SingletonGson.getInstance().fromJson("" + script, ModelNotificationOnLocation.class);
            if (modelNotificationOnLocation.getResult().equals("2")) {
                try {
                    if (OneSignalServiceClass.openScreen == 0) {
                        if (openScreen == 0) {
                            checkTimeStampAndOpenScreen(script, modelNotificationOnLocation.getData().getDriver_request_timeout());
                        }
                    }
                } catch (Exception e) {
                    if (openScreen == 0) {
                        checkTimeStampAndOpenScreen(script, modelNotificationOnLocation.getData().getDriver_request_timeout());
                    }
                }
            }

        } catch (Exception e) {

        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }

    private void updateLocationToSession(Location location) {
        Log.d("****" + TAG, "UpdatingLocationToSession");
        if (location.getBearing() != 0.0) {
            app_location_mamanger.setBearingFactor("" + location.getBearing());
        }
        app_location_mamanger.setLocationLatLong(location);
    }

    private void callApiForUpdateDriverLocation(Location location) {

        Log.d(TAG, "Calling location update API with location"+location.getLatitude()+", "+location.getLongitude());


        EventBus.getDefault().post(new EventLocation(location));
        try {
            if (!isApiRunnign) {
                data.clear();



                data.put("latitude", "" + location.getLatitude());
                data.put("longitude", "" + location.getLongitude());
                data.put("bearing", "" + location.getBearing());
                data.put("accuracy", "" + location.getAccuracy());
                apiManager._postForTracking(API_S.Tags.DRIVER_LOCATION_UPDATER, API_S.Endpoints.DRIVER_LOCATION_UPDATER, data, sessionManager);
                try {
                    if (!Constants.IS_TRACKING_ACTIVITY_OPEN) {
                        if (sessionManager.getbooking_Id() != null) {
                            data.put("app_in_background", "1");
                        }
                    }
                } catch (Exception e) {

                }

            }
        } catch (Exception e) {
            Log.e(TAG, "Exception caught while running API " + e.getMessage());
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
}
