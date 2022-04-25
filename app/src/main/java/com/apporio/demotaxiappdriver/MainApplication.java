package com.apporio.demotaxiappdriver;

import android.content.Context;
import android.util.Log;

import com.apporio.demotaxiappdriver.analytics.MyApplication;
import com.apporio.demotaxiappdriver.manager.RideSession;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.socketManager.AtsConnectionManager;
import com.apporio.demotaxiappdriver.socketManager.AtsEventManager;
import com.crashlytics.android.Crashlytics;
import com.onesignal.OneSignal;

import io.fabric.sdk.android.Fabric;


public class MainApplication extends MyApplication {


    private static RideSession rideSession = null;
    private static SessionManager sessionManager = null;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        context = this;
        Log.e("ApplicationCreated", "ApplicationCreated");
        OneSignal.startInit(this)
                .autoPromptLocation(false)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        try {
            OneSignal.sendTag("driver_id", "" + getSessionManager().getUserDetails().get(SessionManager.KEY_DRIVER_ID));
        } catch (Exception e) {
            Log.d("" + TAG, "Exception caught:" + e.getMessage());
        }



        //initSocketConnection();


    }

    private void initSocketConnection() {

        try {
            AtsConnectionManager atsConnectionManager = AtsConnectionManager.getConnectionInstance();
            if (atsConnectionManager != null) {
                atsConnectionManager.makeConnection(new AtsConnectionManager.AtsConnectionListener() {
                    @Override
                    public void onConnect(AtsEventManager atsEventManager) {


                        Log.e("Connected", "Connected");


                    }

                    @Override
                    public void onDisconnect() {

                        Log.e("Disconnected", "Disconnected");
                    }
                });
            }
        } catch (Exception e) {

        }
    }

    public static RideSession getRideSession() {
        if (rideSession == null) {
            rideSession = new RideSession(context);
            return rideSession;
        } else {
            return rideSession;
        }

    }


    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager(context);
            return sessionManager;
        } else {
            return sessionManager;
        }

    }


    public static Context getContext() {
        return context;
    }


//    @Override
//    protected void attachBaseContext(Context base) {
//        MultiDex.install(base);
//        super.attachBaseContext(base);
//    }
}
