package com.apporio.demotaxiappdriver.analytics;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;

import com.apporio.demotaxiappdriver.LocationSession;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporioinfolabs.ats_sdk.ATS;
//import com.ice.restring.Restring;
//import com.ice.restring.RestringConfig;


public class MyApplication extends Application {

    public static final String TAG = MyApplication.class
            .getSimpleName();

    private static MyApplication mInstance;
    private static LocationSession locationSession = null;
    private static Context context ;

    SessionManager sessionManager;



    @Override
    public void onCreate() {
        String authToken  = "APP ID GOES HERE" ;

//        Restring.init(this,
//                new RestringConfig.Builder()
//                        .persist(true)
//                        // .stringsLoader(new SampleStringsLoader())
//                        .build());

        super.onCreate();

        context  = this ;
        locationSession = new LocationSession(this);

        mInstance = this;
        sessionManager = new SessionManager(this);

        locationSession = new LocationSession(this);

        ATS.startInit(this)
                .setAppId(""+authToken)
                .fetchLocationWhenVehicleIsStop(false)
                .enableLogs(true)
                .setLocationInterval(6000)
                .setDeveloperMode(true)
                .setNotificationTittle(getResources().getString(R.string.app_name))
                .setNotificationContent(getResources().getString(R.string.you_are_online_now))
                .setConnectedStateColor(Color.argb(0, 255, 255 , 255))
                .setDisconnectedColor(Color.argb(0 , 255, 255, 255))
                .setSocketEndPoint("http://192.168.1.33:3027")
                .setNotificationIcon(R.drawable.og_cab_notification_logo)
                .init();


    }


    public static LocationSession getLocationSession(){
        if(locationSession == null){
            locationSession = new LocationSession(context);
            return locationSession ;
        }else{
            return  locationSession;
        }
    }



    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

}
