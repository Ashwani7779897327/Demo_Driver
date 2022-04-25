package com.apporio.atslocation;

import android.util.Log;

import org.json.JSONObject;

public class OnConnectionInfoManager {


    private static final String  TAG = "OnConnectionInfoManager";


    public static JSONObject getDeviceAndApplicationInfo(){
        try{
            ATSApplication.onConnectionObject.put("device_info", DeviceInfoManager.getDeviceInfo());
            ATSApplication.onConnectionObject.put("application_info", AppInfoManager.getApplicafionInfo());
        }catch (Exception e){
            Log.e(TAG , ""+e.getMessage());
        }
       return ATSApplication.onConnectionObject ;
    }
}
