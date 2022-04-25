package com.apporio.demotaxiappdriver.others;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;

import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.Config;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.log.ApporioLog;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";
    PowerManager pm;

    @SuppressLint("NewApi")
    @Override
    public void onReceive(Context context, Intent intent) {
        pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        callActivities(context, intent);
    }

    @SuppressLint("LongLogTag")
    private void callActivities(Context context, Intent intent) {

        ApporioLog.HYPER_LOG_DEBUG(TAG, Constants.PASS_7 + " " + "Version below Oreo");
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "" + TAG);
        wl.acquire(30 * 1000);
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock lock = keyguardManager.newKeyguardLock(Context.KEYGUARD_SERVICE);
        lock.disableKeyguard();
        Intent i = new Intent();

//        i.setClassName("" + BuildConfig.APPLICATION_ID, "" + BuildConfig.APPLICATION_ID + ".ReceivePassengerActivity");

        i.setClassName("" + BuildConfig.APPLICATION_ID, "" + "com.apporio.demotaxiappdriver" + ".ReceivePassengerActivity");

//        i.setClassName("" + BuildConfig.APPLICATION_ID, "" + "com.apporio.demotaxiappdriver" + ".ReceivePassengerActivity");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra(IntentKeys.NAVIGATION, intent.getExtras().getString(IntentKeys.NAVIGATION));
        i.putExtra("" + IntentKeys.SCRIPT, intent.getExtras().getString("" + IntentKeys.SCRIPT));
        context.startActivity(i);
    }


}
