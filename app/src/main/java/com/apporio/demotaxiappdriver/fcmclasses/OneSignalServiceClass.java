package com.apporio.demotaxiappdriver.fcmclasses;

import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;

import androidx.core.app.NotificationCompat;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.ChatActivity;
import com.apporio.demotaxiappdriver.Config;
import com.apporio.demotaxiappdriver.FareActivity;
import com.apporio.demotaxiappdriver.MainActivity;
import com.apporio.demotaxiappdriver.MainApplication;
import com.apporio.demotaxiappdriver.NewRequestActivity;
import com.apporio.demotaxiappdriver.NotificationActivity;
import com.apporio.demotaxiappdriver.PersonalDocumentActivity;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.ReceivePassengerActivity;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.SplashActivity;
import com.apporio.demotaxiappdriver.TermsAndCondition;
import com.apporio.demotaxiappdriver.activities.ExpiryModule.ExpiryDocumentActivity;
import com.apporio.demotaxiappdriver.activities.subscriptionModule.SubscriptionModuleList;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.currentwork.NOTIFICATION_TYPES;
import com.apporio.demotaxiappdriver.currentwork.STATUS;
import com.apporio.demotaxiappdriver.location.UpdateServiceClass;
import com.apporio.demotaxiappdriver.log.ApporioLog;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ChatNotification;
import com.apporio.demotaxiappdriver.models.ModelNotificationType;
import com.apporio.demotaxiappdriver.models.ModelRideNotifications;
import com.apporio.demotaxiappdriver.others.Constants;
import com.apporio.demotaxiappdriver.wallet.WalletActivity;

import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationReceivedResult;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;


/**
 * Created by samirgoel3@gmail.com on 26-04-2018.
 */

public class OneSignalServiceClass extends NotificationExtenderService {

    private String TAG = "OneSignalServiceClass";
    private int NOTIFICATION_BYPASS_TIME = 60;
    private int TRACK_RIDE_INTENT = 1, TRIP_HISTORY = 2, LOGOUT = 3, PROMOTIONAL = 4, SPLAHACTIVITY = 5, UPCOMING_TRIP = 6, LATER_REASSIGNED = 7, RECEIPT_EVENT = 8, MAIN_ACTIVITY = 9;

    public static int openScreen = 0;

    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult receivedResult) {
        try {
            ApporioLog.HYPER_LOG_DEBUG(TAG + "ADDITIONAL DATA:", "" + receivedResult.payload.additionalData + " " + Constants.PASS_1);
            ApporioLog.LOG_DEBUG(TAG + "ADDITIONAL DATA:", "" + receivedResult.payload.additionalData);
            ApporioLog.LOG_DEBUG(TAG + "BODY  ", "" + receivedResult.payload.body);
            ThreeStepBbuisnessLogic("" + receivedResult.payload.additionalData, "" + receivedResult.payload.body);
        } catch (Exception e) {
            ApporioLog.LOG_DEBUG("" + TAG, "Exception caught while parsing " + e.getMessage());
        }
        return true;
    }


    private void ThreeStepBbuisnessLogic(String data, String notificationtittle) throws Exception {
        // the logic to call this function , is to divide notification in  three part  (1) that open screen   (2) That create notification with intent  (3) that passes info to screen via Event Bus
        ApporioLog.LOG_DEBUG("" + TAG, "" + data);
        ModelNotificationType modelNotificationType = SingletonGson.getInstance().fromJson("" + data, ModelNotificationType.class);
        ApporioLog.LOG_DEBUG("" + TAG, "Model Notification Type:" + modelNotificationType.getType());
        EventBus.getDefault().post("" + data);
        ApporioLog.HYPER_LOG_DEBUG(TAG, "" + openScreen + " " + Constants.PASS_2);
        if (modelNotificationType.getType() == NOTIFICATION_TYPES.RIDE) { // RIde elated Notification
            ModelRideNotifications modelRideNotifications = SingletonGson.getInstance().fromJson("" + data, ModelRideNotifications.class);
            if (modelRideNotifications.getData().getBooking_status().equals("" + STATUS.BOOKED)) {
                if (new SessionManager(this).isLoggedIn()) {

                    ApporioLog.HYPER_LOG_DEBUG(TAG, "" + openScreen + " " + Constants.PASS_3);

                    if (modelRideNotifications.getData().getBooking_type().equals("1")) {
                        if (openScreen == 0) {
                            ApporioLog.HYPER_LOG_DEBUG(TAG, "" + openScreen + " " + modelRideNotifications.getData().getBooking_type() + " " + Constants.PASS_4);
                            ApporioLog.LOG_DEBUG(TAG + "******PassBookingType_1", "" + modelRideNotifications.getData().getBooking_type());
                            checkTimeStampAndOpenScreen(data, Double.parseDouble("" + modelRideNotifications.getData().getDriver_request_timeout())); // open screen
                        } else {
                            ApporioLog.HYPER_LOG_DEBUG(TAG, "" + openScreen + " " + " " + Constants.FAIL_1);
                        }
                    } else if (modelRideNotifications.getData().getBooking_type().equals("2")) {
                        generateNotification("" + notificationtittle, new Intent(this, NewRequestActivity.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    }
                }

            } else if (modelRideNotifications.getData().getBooking_status().equals("" + STATUS.MAKE_PAYMENT)) {
                if (new SessionManager(this).isLoggedIn()) {
                    generateNotification("" + notificationtittle, new Intent(this, FareActivity.class)
                            .putExtra("" + IntentKeys.BOOKING_ID, "" + modelRideNotifications.getData().getBooking_id())
                            .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                }
            } else {
                if (!modelRideNotifications.getData().getBooking_status().equals("" + STATUS.RIDE_EXPIRE)) {
                    if (!Constants.IS_TRACKING_ACTIVITY_OPEN) { // if tracking is not open then create notification
                        generateNotification("" + notificationtittle, new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    }
                }
            }
        }
        if (modelNotificationType.getType() == NOTIFICATION_TYPES.PROMOTIONAL) { // promotional notification
            if (new SessionManager(this).isLoggedIn()) {
                generateNotification("" + notificationtittle, new Intent(this, NotificationActivity.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }

        }
        if (modelNotificationType.getType() == NOTIFICATION_TYPES.DOCUMENT_EXPIRY_REMAINDER) { // promotional notification
            if (new SessionManager(this).isLoggedIn()) {
                generateNotification("" + notificationtittle, new Intent(this, PersonalDocumentActivity.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }

        }
        if (modelNotificationType.getType() == NOTIFICATION_TYPES.WALLET) {
            generateNotification("" + notificationtittle, new Intent(this, WalletActivity.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }
        if (modelNotificationType.getType() == NOTIFICATION_TYPES.CHAT) {
            if (new SessionManager(this).isLoggedIn()) {
                ChatNotification chatNotification = SingletonGson.getInstance().fromJson("" + data, ChatNotification.class);
                generateNotification("" + notificationtittle, new Intent(this, ChatActivity.class)
                        .putExtra(IntentKeys.USER_NAME, "" + chatNotification.getData().getUsername())
                        .putExtra("" + IntentKeys.BOOKING_ID, "" + chatNotification.getData().getBooking_id())
                        .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }

        }
        if (modelNotificationType.getType() == NOTIFICATION_TYPES.REQUEST_VEHICLE_TYPE) {
            generateNotification("" + notificationtittle, new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }
        if (modelNotificationType.getType() == NOTIFICATION_TYPES.LOGIN_LOGOUT) {
            runLogOut();
        }

        if (modelNotificationType.getType() == NOTIFICATION_TYPES.TERMS_CONDITION_TYPE) {
            generateNotification("" + notificationtittle, new Intent(this, TermsAndCondition.class)
                    .putExtra(Config.IntentKeys.TERMS_CONDITION, "accept"));
        }

        if (modelNotificationType.getType() == NOTIFICATION_TYPES.DRIVER_APPROVAL || modelNotificationType.getType() == NOTIFICATION_TYPES.DRIVER_REJECTED) {
            generateNotification("" + notificationtittle, new Intent(this, SplashActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }

        if (modelNotificationType.getType() == NOTIFICATION_TYPES.VEHICLE_APPROVAL || modelNotificationType.getType() == NOTIFICATION_TYPES.VEHICLE_REJECTED) {
            generateNotification("" + notificationtittle, new Intent(this, SplashActivity.class));
        }

        if (modelNotificationType.getType() == NOTIFICATION_TYPES.PERSONAL_EXPIRY || modelNotificationType.getType() == NOTIFICATION_TYPES.VEHICLE_EXPIRY) {
            generateNotification("" + notificationtittle, new Intent(this, PersonalDocumentActivity.class));
        }
        if (modelNotificationType.getType() == NOTIFICATION_TYPES.SUBSCRIPTION_EXPIRED) {
            generateNotification("" + notificationtittle, new Intent(this, SubscriptionModuleList.class));
        }
        if (modelNotificationType.getType() == NOTIFICATION_TYPES.CASHBACK) {
            generateNotification("" + notificationtittle, new Intent(this, SplashActivity.class));
        }
        if (modelNotificationType.getType() == NOTIFICATION_TYPES.ACTIVATED_DEACTIVATED) {
            generateNotification("" + notificationtittle, new Intent(this, SplashActivity.class));
        }

    }

    private void generateNotification(String message, Intent intent) {


        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            long[] pattern = {500, 500, 500, 500, 500, 500, 500, 500, 500};
            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.app_logo);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.app_logo)
                    .setLargeIcon(largeIcon)
                    .setContentTitle(getString(R.string.app_name))
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setSound(alarmSound)
                    .setVibrate(pattern)
                    .setContentIntent(pendingIntent);
            notificationManager.notify(0, notificationBuilder.build());
        } else {


            NotificationChannel channel = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                channel = new NotificationChannel("my_channel_01",
                        "Channel human readable title",
                        NotificationManager.IMPORTANCE_DEFAULT);
            }

            String mChannel = "Message";
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(channel);
            }
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            long[] pattern = {500, 500, 500, 500, 500, 500, 500, 500, 500};
            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.app_logo);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.app_logo)
                    .setLargeIcon(largeIcon)
                    .setContentTitle(getString(R.string.app_name))
                    .setContentText(message)
                    .setAutoCancel(true)
//                    .setColor(Color.parseColor("#0x008000"))
                    .setSound(alarmSound)
                    .setVibrate(pattern)
                    .setContentIntent(pendingIntent)
                    .setChannelId("my_channel_01");
            notificationManager.notify(0, notificationBuilder.build());
        }
    }


    // OPEN SCREEN
    private void checkTimeStampAndOpenScreen(final String script, double driverTimeOutValue) {
        final ModelRideNotifications modelRideNotifications = SingletonGson.getInstance().fromJson("" + script, ModelRideNotifications.class);
        if (modelRideNotifications.getData().getBooking_status().equals("1001")) {
            try {
                if (MainApplication.getSessionManager().isLoggedIn()) {
                    ApporioLog.HYPER_LOG_DEBUG(TAG, "" + openScreen + " " + MainApplication.getSessionManager().isLoggedIn() + " " + Constants.PASS_5);
                    openReceivePassengerScreen(script);
                }
            } catch (Exception e) {
                openReceivePassengerScreen(script);
            }
//            AndroidNetworking.get(API_S.Endpoints.SERVER_TIMESTAMP)
//                    .setTag(this).setPriority(Priority.HIGH)
//                    .build().getAsString(new StringRequestListener() {
//                @Override
//                public void onResponse(String response) {
//                    try {
//                        ModelTimeStamp modelTimeStamp = SingletonGson.getInstance().fromJson("" + response, ModelTimeStamp.class);
//                        if ((Long.parseLong("" + modelTimeStamp.getTime()) - Long.parseLong("" + modelRideNotifications.getData().getTimestamp())) <= driverTimeOutValue) {  // time stamp criteria matches
//
//                        } else {
//                            ApporioLog.LOG_DEBUG("" + TAG, "Notification bypass as it delayed by 60 sec");
//                        }
//                    } catch (Exception e) {
//                        ApporioLog.LOG_DEBUG("" + TAG, "Exception caught while parsing response " + e.getMessage());
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
            if (openScreen == 0) {
                ApporioLog.HYPER_LOG_DEBUG(TAG, "" + openScreen + " " + Constants.PASS_6 + " " + "Version below Oreo" + " " + script);
//                Config.ReceiverPassengerActivity = true;
                Intent broadcastIntent = new Intent();
                broadcastIntent.putExtra(IntentKeys.NAVIGATION, "1");
                broadcastIntent.putExtra("" + IntentKeys.SCRIPT, "" + script);
                broadcastIntent.setAction("" + BuildConfig.APPLICATION_ID);
                sendBroadcast(broadcastIntent);
            }
        } else {
            if (openScreen == 0) {
                ApporioLog.HYPER_LOG_DEBUG(TAG, "" + openScreen + " " + Constants.PASS_6 + " " + "Version above Oreo" + " " + script);
//                Config.ReceiverPassengerActivity = true;
                PowerManager pm = (PowerManager) OneSignalServiceClass.this.getSystemService(Context.POWER_SERVICE);
                PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "" + TAG);
                wl.acquire(30 * 1000);
                KeyguardManager keyguardManager = (KeyguardManager) OneSignalServiceClass.this.getSystemService(OneSignalServiceClass.this.KEYGUARD_SERVICE);
                KeyguardManager.KeyguardLock lock = keyguardManager.newKeyguardLock(Context.KEYGUARD_SERVICE);
                lock.disableKeyguard();
                OneSignalServiceClass.this.startActivity(new Intent(OneSignalServiceClass.this, ReceivePassengerActivity.class)
                        .putExtra("" + IntentKeys.SCRIPT, script)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        .putExtra(IntentKeys.NAVIGATION, "1"));

            }
        }
    }

    private void runLogOut() throws Exception {

        try {
            stopService(new Intent(this, UpdateServiceClass.class));
            MainApplication.getSessionManager().logoutUser();
            Intent it = OneSignalServiceClass.this.getApplicationContext().getPackageManager()
                    .getLaunchIntentForPackage(OneSignalServiceClass.this.getApplicationContext().getPackageName());
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            it.putExtra("EXIT", true);
            OneSignalServiceClass.this.startActivity(it);


//            AndroidNetworking.post(API_S.Endpoints.LOGOUT)
//                    .addHeaders(MainApplication.getSessionManager().getHeader())
//                    .setTag(this).setPriority(Priority.MEDIUM)
//                    .build()
//                    .getAsJSONObject(new JSONObjectRequestListener() {
//                        @Override
//                        public void onResponse(final JSONObject jsonObject) {
//
//
//                        }
//
//                        @Override
//                        public void onError(ANError anError) {
//
//                        }
//                    });

        } catch (Exception e) {

        }

    }

}