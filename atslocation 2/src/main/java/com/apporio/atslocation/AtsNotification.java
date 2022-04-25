package com.apporio.atslocation;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.apporio.atslocation.db.SqliteDBHelper;

public class AtsNotification {

    public static final int NOTIF_ID = 1234;
    private static NotificationCompat.Builder mBuilder;
    private static NotificationManager mNotificationManager;
    private static RemoteViews mSmallRemoteViews;
    private static RemoteViews mBigRemoteViews;
    private static Notification mNotification;
    private static  Context mContext ;
    private NotificationManager manager ;
    private SharedPreferences sharedPref;
    private final String TAG = "AtsNotification";
    private SqliteDBHelper sqliteDBHelper ;


    public static final String CHANNEL_ID = "ForegroundServiceChannel";



    public AtsNotification(Context context){
        mContext = context ;
        sqliteDBHelper = new SqliteDBHelper(context);
        sharedPref = context.getSharedPreferences(ATSApplication.SHARED_PREFRENCE, Context.MODE_PRIVATE);
        mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        mSmallRemoteViews = new RemoteViews(mContext.getPackageName(), R.layout.custom_notification_small);
        mBigRemoteViews = new RemoteViews(mContext.getPackageName(), R.layout.custom_notification_big);
        mBuilder = new NotificationCompat.Builder(mContext,CHANNEL_ID);

    }


    //////////////// DEVELOPMENT VIEWS  ///////////////////////
    private Notification getDevelopmentNotificationForLessThanHoneyComb(){
        mNotification = new Notification(ATSApplication.small_Icon, "Ticker text", System.currentTimeMillis());
        mNotification.contentView = mSmallRemoteViews;
//        mNotification.contentIntent = getIntent();
        mNotification.flags |= Notification.FLAG_NO_CLEAR; //Do not clear the notification
        mNotification.defaults |= Notification.DEFAULT_LIGHTS;
        return mNotification ;
    }

    private NotificationCompat.Builder getDevelopmentNotificationForMoreThanHoneyComb(){

        mBuilder.setSmallIcon(ATSApplication.small_Icon)
                .setAutoCancel(false)
                .setOngoing(true)
                .setContentIntent(ATSApplication.notificationClickIntent)
                .setContent(mSmallRemoteViews)
                .setCustomBigContentView(mBigRemoteViews)
                .setTicker("Ticker Text");
        return mBuilder ;
    }

    private NotificationCompat.Builder getDevelopmentNotificationForOreoAndAbove(){

        createNotificationChannel();
        Intent notificationIntent = new Intent(mContext, ATSLocationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, notificationIntent, 0);


        Intent intentAction = new Intent(mContext,NotificationActionReceiver.class);
        intentAction.putExtra("action",NotificationActionReceiver.ACTION_SYNC_CASHED);
        PendingIntent pending_sync_Action = PendingIntent.getBroadcast(mContext,1,intentAction,PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intent_online = new Intent(mContext,NotificationActionReceiver.class);
        intent_online.putExtra("action",NotificationActionReceiver.ACTION_ONLINE);
        PendingIntent pending_intent_online = PendingIntent.getBroadcast(mContext,2,intent_online,PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intentOffline = new Intent(mContext,NotificationActionReceiver.class);
        intentOffline.putExtra("action",NotificationActionReceiver.ACTION_OFFLINE);
        PendingIntent pending_intent_offline = PendingIntent.getBroadcast(mContext,3,intentOffline,PendingIntent.FLAG_UPDATE_CURRENT);
        return mBuilder
                .setSmallIcon(ATSApplication.small_Icon )
                .setContentTitle(sharedPref.getBoolean(ATSApplication.DEVELOPER_MODE_KEY,false)?"Development Mode":"You are on duty now.")
                    .setContentIntent(ATSApplication.notificationClickIntent)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Please wait system is fetching your location . . . ."));
//                .addAction(R.drawable.apporio_logo,"ONLINE", pending_intent_online)
//                .addAction(R.drawable.apporio_logo,"OFFLINE", pending_intent_offline)
//                .addAction(R.drawable.apporio_logo,"Sync Cached", pending_sync_Action);
    }

    private void startDevelopmentNotificationView(Service service){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            service.startForeground(1, getDevelopmentNotificationForOreoAndAbove().build());
        }else{
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB){
                service.startForeground(AtsNotification.NOTIF_ID, getDevelopmentNotificationForLessThanHoneyComb()); }
            else{
                service.startForeground(AtsNotification.NOTIF_ID, getDevelopmentNotificationForMoreThanHoneyComb().build());
            }
        }
    }

    private void updateDevelopmentNotificationView(EventLocation event){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            updateOreoAboveNotification(event.getPojolocation());
        }else{
            NotifyNotification("Development Mode"
                    , "Loc.:"+event.getPojolocation().getLatitude()+","+event.getPojolocation().getLongitude()+", Ac:"+event.getPojolocation().getAccuracy()
                    , event.pojolocation,ATSApplication.getSocket().connected(),sqliteDBHelper.getAllOfflineStats().size());
        }
    }






    //////////////// RELEASE VIEWS  ///////////////////////
    private Notification getReleaseNotificationForLessThanHoneyComb(){
        mNotification = new Notification(ATSApplication.small_Icon, "* * * * *", System.currentTimeMillis());
        mNotification.contentView = mSmallRemoteViews;
//        mNotification.contentIntent = getIntent();
        mNotification.flags |= Notification.FLAG_NO_CLEAR; //Do not clear the notification
        mNotification.defaults |= Notification.DEFAULT_LIGHTS;
        return mNotification ;
    }

    private NotificationCompat.Builder getReleaseNotificationForMoreThanHoneyComb(){

        mSmallRemoteViews.setImageViewResource(R.id.notification_icon, ATSApplication.large_icon);
        mBuilder.setSmallIcon(ATSApplication.small_Icon)
                .setAutoCancel(false)
                .setOngoing(true)
                .setContentIntent(ATSApplication.notificationClickIntent)
                .setContent(mSmallRemoteViews)
                .setTicker("* * * * * *");
        return mBuilder ;
    }

    private NotificationCompat.Builder getReleaseNotificationForOreoAndAbove() throws Exception{

        createNotificationChannel();
        Intent notificationIntent = new Intent(mContext, ATSLocationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, notificationIntent, 0);

        return mBuilder
                .setSmallIcon(ATSApplication.small_Icon)
                .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),ATSApplication.large_icon))
                .setContentTitle(""+AppInfoManager.getApplicafionInfo().get("app_name"))
                    .setContentIntent(ATSApplication.notificationClickIntent)
                .setStyle(new NotificationCompat.InboxStyle().addLine(ATSApplication.notificatioMakingOnlineText));
    }

    private void startReleasedNotificationView(Service service) throws Exception{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            service.startForeground(1, getReleaseNotificationForOreoAndAbove().build());
        }else{
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB){
                service.startForeground(AtsNotification.NOTIF_ID, getReleaseNotificationForLessThanHoneyComb()); }
            else{
                service.startForeground(AtsNotification.NOTIF_ID, getReleaseNotificationForMoreThanHoneyComb().build());
            }
        }
    }

    private void updateReleasedNotificationView(EventLocation event) throws Exception{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            updateOreoAboveNotification(event.getPojolocation());
        }else{
            NotifyNotification(""+AppInfoManager.getApplicafionInfo().get("app_name")
                    , ""+ATSApplication.notificatioOnlineText
                    , event.pojolocation,ATSApplication.getSocket().connected(),sqliteDBHelper.getAllOfflineStats().size());
        }
    }



    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(CHANNEL_ID, "Foreground Service Channel", NotificationManager.IMPORTANCE_DEFAULT);
            serviceChannel.setSound(null, null);
            manager = mContext.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }

    private void updateOreoAboveNotification(Location location){

        if (sharedPref.getBoolean(ATSApplication.DEVELOPER_MODE_KEY, false)) {
            mBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(
                    "Loc. Interval: "+ATSApplication.locationFetchInterval
                    + ", Lat:"+location.getLatitude()
                    +", Long:"+location.getLongitude()
                    +", Accuracy:"+location.getAccuracy()
                    +", Speed:"+location.getSpeed()+"m/sec"+ ",   Bearing:"+location.getBearing()
                    +", Socket state: "+(ATSApplication.getSocket().connected()? "Connected":"Disconnected")
                    +", Local Cashed: "+sqliteDBHelper.getAllOfflineStats().size()));
            manager.notify(1, mBuilder.build());
        } else {

            mBuilder.setStyle(new NotificationCompat.InboxStyle().addLine(""+ATSApplication.notificatioOnlineText));
            manager.notify(1, mBuilder.build());
        }




    }

    private   void NotifyNotification(String title, String smallContent, Location location , boolean socket_Status, int totalCashedData){

        if (sharedPref.getBoolean(ATSApplication.DEVELOPER_MODE_KEY, false)) {
            mSmallRemoteViews.setImageViewResource(R.id.notification_icon,ATSApplication.large_icon);
            mSmallRemoteViews.setTextViewText(R.id.tittle_text, ""+title);
            mSmallRemoteViews.setTextViewText(R.id.content_text, ""+smallContent);
            mBigRemoteViews.setImageViewResource(R.id.notification_logo, ATSApplication.large_icon);
            mBigRemoteViews.setTextViewText(R.id.tittle_text, ""+title);
            mBigRemoteViews.setTextViewText(R.id.location,   "Loc Interval: "+ATSApplication.locationFetchInterval+ ""+location.getLatitude()+","+location.getLongitude());
            mBigRemoteViews.setTextViewText(R.id.accuracy, String.format("%.2f", location.getAccuracy())   +" meter");
            mBigRemoteViews.setTextViewText(R.id.socket_connectivity, "Socket: "+ (socket_Status?"Connected":"Disconnected"));
            mBigRemoteViews.setTextViewText(R.id.other_info, "Speed:"+location.getSpeed()+",  bearing:"+location.getBearing()+" m/sec"+", Cashed Data: "+totalCashedData);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                mNotificationManager.notify(NOTIF_ID, mNotification);
            }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                mNotificationManager.notify(NOTIF_ID, mBuilder.build());
            }
        } else {
            mSmallRemoteViews.setTextViewText(R.id.tittle_text, ""+title);
            mSmallRemoteViews.setTextViewText(R.id.content_text, ""+smallContent);

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                mNotificationManager.notify(NOTIF_ID, mNotification);
            }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                mNotificationManager.notify(NOTIF_ID, mBuilder.build());
            }

        }

    }



    private PendingIntent getIntent(){
        Intent intentNotif = new Intent(mContext, ATSLocationActivity.class);
        intentNotif.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendIntent = PendingIntent.getActivity(mContext, 0, intentNotif, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendIntent ;
    }





    public void startNotificationView(Service service) throws Exception{

        Log.d(TAG , "DEVELOPER MODE --->  "+sharedPref.getBoolean(ATSApplication.DEVELOPER_MODE_KEY, false));

        if (sharedPref.getBoolean(ATSApplication.DEVELOPER_MODE_KEY, false)) {
            startDevelopmentNotificationView(service);
        } else {
            startReleasedNotificationView(service);
        }
    }

    public void updateNotificationView(EventLocation event) throws Exception{
        if (sharedPref.getBoolean(ATSApplication.DEVELOPER_MODE_KEY, false)) {
            updateDevelopmentNotificationView(event);
        } else {
            updateReleasedNotificationView(event);
        }

    }






}
