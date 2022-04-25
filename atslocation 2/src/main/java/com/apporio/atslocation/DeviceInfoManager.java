package com.apporio.atslocation;

import org.json.JSONObject;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import com.github.abara.library.batterystats.BatteryStats;

public class DeviceInfoManager {

    private final static String TAG = "DeviceInfoManager";
    private Context mContext ;
    private JSONObject batteryJsonObject ;
    private BatteryStats batteryStats ;

    public DeviceInfoManager(Context context){
        this.mContext = context ;
        batteryJsonObject = new JSONObject();
        batteryStats = new BatteryStats(context);
    }


    public static JSONObject getDeviceInfo(){
        JSONObject jsonObject = new JSONObject();

        try{
            jsonObject.put("serial",Build.SERIAL);
            jsonObject.put("model",Build.MODEL);
            jsonObject.put("device_id", Settings.Secure.getString(ATSApplication.mContext.getContentResolver(), Settings.Secure.ANDROID_ID));
            jsonObject.put("manufacture",Build.MANUFACTURER);
            jsonObject.put("brand",Build.BRAND);
            jsonObject.put("type",Build.TYPE);
            jsonObject.put("user",Build.USER);
            jsonObject.put("base",Build.VERSION_CODES.BASE);
            jsonObject.put("incremental",Build.VERSION.INCREMENTAL);
            jsonObject.put("sdk",Build.VERSION.SDK);
            jsonObject.put("board",Build.BOARD);
            jsonObject.put("host",Build.HOST);
            jsonObject.put("fingerprint",Build.FINGERPRINT);
            jsonObject.put("release",Build.VERSION.RELEASE);
        }catch (Exception e){
            Log.e(TAG, ""+e.getMessage());
        }


        return jsonObject;
    }


    public JSONObject getBatteryStat(){
        try {
            batteryJsonObject.put("battery_level",batteryStats.getLevel()).put("charging_status","NA");
        }catch (Exception e){
            Log.e(TAG , ""+e.getMessage());
        }
        return batteryJsonObject ;
    }

}


