//package com.apporio.demotaxiappdriver.others;
//
//import android.content.Context;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.apporio.demotaxiappdriver.Config;
//import com.apporio.demotaxiappdriver.LocationSession;
//import com.apporio.demotaxiappdriver.manager.SessionManager;
//import com.apporio.demotaxiappdriver.models.ActiveRidesPool;
//import com.apporio.demotaxiappdriver.models.DriverLocation;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
///**
// * Created by samirgoel3@gmail.com on 3/31/2017.
// */
//
//public class FirebaseUtils {
//
//
//    FirebaseDatabase database;
//    DatabaseReference mDatabaseReference;
//    DatabaseReference mDatabaserefrenceActivePool ;
//    DatabaseReference mDatabaseReference_geofire;
//    SessionManager sessionmanager ;
//    LocationSession applocation_manager;
//    Context context ;
////    GeoFire geoFire ;
//    public static String NO_RIDES = "No Ride";
//    public static String NO_RIDE_STATUS= "No Ride Status";
//
//    private String TAG = "FireBaseUtil";
//
//
//    public FirebaseUtils(Context context){
//        this.context = context ;
//        database = FirebaseDatabase.getInstance();
//        mDatabaseReference = database.getReference(Config.DriverReference);
//        mDatabaseReference_geofire = database.getReference(Config.GeoFireReference);
//        mDatabaserefrenceActivePool = database.getReference(Config.ActiveRidesRefrence);
//       // geoFire = new GeoFire(mDatabaseReference_geofire);
//        applocation_manager  = new LocationSession(context);
//        sessionmanager = new SessionManager(context);
//    }
//
//
//    public void setDriverOnlineStatus(boolean val){
//        if(checkDriverExsistance()){
//            try{
//                DriverLocation driverLocation ;
//                if (val){
//                    driverLocation = new DriverLocation(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID),
//                            sessionmanager.getUserDetails().get(SessionManager.KEY_DriverToken),
//                            sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_CarTypeId),
//                            sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_login_logout),
//                            sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_Busy_Status),
//                            sessionmanager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE),
//                            applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT) ,
//                            applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LONG) ,
//                            ""+applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LOCATION_TEXT) ,
//                            ""+ (System.currentTimeMillis()/1000) ,
//                            ""+applocation_manager.getLocationDetails().get(LocationSession.KEY_BEARING_FACTOR));
//
//
////                    geoFire.setLocation(""+sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID),
////                            new GeoLocation(Double.parseDouble(applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT)) +0.000001,Double.parseDouble(applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LONG))), new GeoFire.CompletionListener() {
////                                @Override
////                                public void onComplete(String key, DatabaseError error) {
////                                    if (error != null) {
////                                        System.err.println("There was an error saving the location to GeoFire: " + error);
////                                    } else {
//////                            Log.d("##**##" , "Location saved successfully ");
////                                    }
////                                }
////                            });
////            mDatabaseReference.child(""+sessionmanager.getCurrentRideDetails().get(SessionManager.KEY_DRIVER_ID)).child("driver_online_offline_status").setValue("1");
//                }else {
//                    driverLocation = new DriverLocation(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID),
//
//                            sessionmanager.getUserDetails().get(SessionManager.KEY_DriverToken),
//                            sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_CarTypeId),
//                            sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_login_logout),
//                            sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_Busy_Status),
//                            sessionmanager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE),
//                            applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT) ,
//                            applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LONG) ,
//                            ""+applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LOCATION_TEXT) ,
//                            ""+ (System.currentTimeMillis()/1000) ,
//                            ""+applocation_manager.getLocationDetails().get(LocationSession.KEY_BEARING_FACTOR));
//
////            mDatabasrdeReference.child(""+sessionmanager.getCurrentRideDetails().get(SessionManager.KEY_DRIVER_ID)).child("driver_online_offline_status").setValue("2");
//                }
//
//                if(!sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID).equals("")){
//                    mDatabaseReference.child(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID)).setValue(driverLocation);
//                }
//            }catch (Exception e ){
//                Log.e(""+TAG , ""+e.getMessage());
//            }
//        }
//    }
//
//    public void setUpDriver ( ){
//
//        if(checkDriverExsistance()){
//
//            final DriverLocation mDriverLocation = new DriverLocation(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_DriverToken),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_CarTypeId),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_login_logout),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_Busy_Status),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE),
//                    applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT) ,
//                    applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LONG) ,
//                    ""+applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LOCATION_TEXT) ,
//                    ""+ (System.currentTimeMillis()/1000) ,
//                    ""+applocation_manager.getLocationDetails().get(LocationSession.KEY_BEARING_FACTOR));
//
//
//            mDatabaseReference.child(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID)).setValue(mDriverLocation);
//
//
////            try{
////                geoFire.setLocation(""+sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID),
////                        new GeoLocation(Double.parseDouble(applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT)) +0.000001,Double.parseDouble(applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LONG))), new GeoFire.CompletionListener() {
////                            @Override
////                            public void onComplete(String key, DatabaseError error) {
////                                if (error != null) {
////                                    System.err.println("There was an error saving the location to GeoFire: " + error);
////                                } else {
//////                            Log.d("##**##" , "Location saved successfully ");
////                                }
////                            }
////                        });
////            }catch (Exception e){
////
////            }
//        }
//    }
//
//    public  void updateLocation_with_text(){
//        if(checkDriverExsistance()){
//            final DriverLocation mDriverLocation = new DriverLocation(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_DriverToken),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_CarTypeId),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_login_logout),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_Busy_Status),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE),
//                    applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT) ,
//                    applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LONG) ,
//                    ""+applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LOCATION_TEXT) ,
//                    ""+ (System.currentTimeMillis()/1000) ,
//                    ""+applocation_manager.getLocationDetails().get(LocationSession.KEY_BEARING_FACTOR));
//            try {
//                // updating to main table of firebase
//                mDatabaseReference.child(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID)).setValue(mDriverLocation);
////                geoFire.setLocation(""+sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID),
////                        new GeoLocation(Double.parseDouble(applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT)),
////                                Double.parseDouble(applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LONG))),
////                        new GeoFire.CompletionListener() {
////                            @Override
////                            public void onComplete(String key, DatabaseError error) {
////                                if (error != null) {
////                                    System.err.println("There was an error saving the location to GeoFire: " + error);
////                                }
////                            }
////                        });
//            }catch (Exception e){
//                Log.e("" +TAG, ""+e.getMessage());
//            }
//        }
//
//    }
//
//    public void updateLocationOnCameramove (final String latitude  , final String longitude ){
//        if(checkDriverExsistance()){
//            final DriverLocation mDriverLocation = new DriverLocation(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_DriverToken),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_CarTypeId),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_login_logout),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_Busy_Status),
//                    sessionmanager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE),
//                    ""+latitude ,
//                    ""+longitude ,
//                    ""+applocation_manager.getLocationDetails().get(LocationSession.KEY_CURRENT_LOCATION_TEXT) ,
//                    ""+ (System.currentTimeMillis()/1000) ,
//                    ""+applocation_manager.getLocationDetails().get(LocationSession.KEY_BEARING_FACTOR));
//
//
//            mDatabaseReference.child(""+sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID)).addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    try {
//                        DriverLocation driverLocation = dataSnapshot.getValue(DriverLocation.class);
//
//                        if(driverLocation.driver_token.equals(""+sessionmanager.getUserDetails().get(SessionManager.KEY_DriverToken))){
//
//                            if(sessionmanager.isLoggedIn() && sessionmanager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")){
//                                // updating to main table of firebase
//                                mDatabaseReference.child(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID)).setValue(mDriverLocation);
//                                // creating event pool identity to operate it from admin app
//                                // updating to geo firebase table
////                                geoFire.setLocation(""+sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID),
////                                        new GeoLocation(Double.parseDouble(latitude),
////                                                Double.parseDouble(longitude)),
////                                        new GeoFire.CompletionListener() {
////                                            @Override
////                                            public void onComplete(String key, DatabaseError error) {
////                                                if (error != null) {
////                                                    System.err.println("There was an error saving the location to GeoFire: " + error);
////                                                }
////                                            }
////                                        });
//                            }
//                        }else{
//                            // log out the demotaxiappdriver
//                            Toast.makeText(context, "Driver is logged in other device.", Toast.LENGTH_SHORT).show();
//                            sessionmanager.logoutUser();
//                        }
//                    }catch (Exception e){
//                        Log.e("" +TAG, ""+e.getMessage());
//                    }
//                }
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//                }
//            });
//        }
//    }
//
//    public void setDriverLoginLogoutStatus(boolean b) {
//        if(checkDriverExsistance()){
//            if (b){
//                mDatabaseReference.child(""+sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID)).child("driver_login_logout").setValue("1");
//            }else {
//                mDatabaseReference.child(""+sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID)).child("driver_login_logout").setValue("2");
//            }
//        }
//
//    }
//
//
//
//    private String getDeviceType(){
//        String devicetype = "";
//        if(sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_flag).equals("1")){
//            devicetype = "I-PHONE";
//        }else if (sessionmanager.getUserDetails().get(SessionManager.KEY_Driver_flag).equals("2")){
//            devicetype = "ANDROID";
//        }
//        return devicetype ;
//    }
//
//
//    private boolean checkDriverExsistance(){
//        boolean retruning_value = false;
//        try{if(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID).equals("")  || sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID) == null){
//            retruning_value = false ;
//        }else{retruning_value = true ;}}catch (Exception e){}
//        return  retruning_value;
//    }
//
//
//    public void createRidePool(String ride_id  , String rifde_status){
//        ActiveRidesPool activeRidesPool = new ActiveRidesPool("No Ride" , "No Ride Status");
//        try {
//            mDatabaserefrenceActivePool.child(sessionmanager.getUserDetails().get(SessionManager.KEY_DRIVER_ID)).setValue(activeRidesPool);
//        }catch (Exception e){}
//
//    }
//
//}
