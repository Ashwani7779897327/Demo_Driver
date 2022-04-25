package com.apporio.atslocation;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import org.json.JSONObject;

import java.net.InetAddress;

public class NetworkInfoManager {

    private static final String TAG = "NetworkInfoManager";


    private static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;



    }


    public static boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return !ipAddr.equals("");
        } catch (Exception e) {
            return false;
        }
    }


    public static JSONObject getNetworkConnectionState(Context context){
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("network_connected", isNetworkConnected(context));
            jsonObject.put("internet_conneted",isInternetAvailable());
            jsonObject.put("socket_connected",ATSApplication.isSocketConnected());
        }catch (Exception e){
            Log.e(TAG , ""+e.getMessage());
        }
        return jsonObject ;
    }



}
