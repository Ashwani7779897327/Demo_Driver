package com.apporio.atslocation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

public class AtsLocationManager {

    private FusedLocationProviderClient fusedLocationClient;
    private final int REQUEST_CHECK_SETTINGS = 34523;
    private LocationCallback locationCallback;
    private LocationRequest locationRequest;
    private Context mContext;
    private final static String TAG = "AtsLocationManager";
    private static EventLocation eventLocation;
    private static JSONObject locationJsonObject ;


    public AtsLocationManager(final Context context) {
        this.mContext = context;
        eventLocation = new EventLocation();
        locationJsonObject = new JSONObject();
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    Log.d(TAG, "Getting null Location");
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    try{
                        eventLocation.setPojolocation(location);
                        eventLocation.setLocation(getLocationObject(location, locationJsonObject));
                        EventBus.getDefault().post(eventLocation);
                    }catch (Exception e){Log.d(TAG, ""+e.getMessage());
                    }
                    Log.d(TAG, "Location: " + location.getLatitude() + "," + location.getLatitude());
                }
            }
        };
        createLocationRequest();
    }


    private void createLocationRequest() {
        locationRequest = LocationRequest.create();
        locationRequest.setInterval(ATSApplication.locationFetchInterval);
        locationRequest.setFastestInterval(ATSApplication.locationFetchInterval);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);

        SettingsClient client = LocationServices.getSettingsClient(mContext);
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());


        task.addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                Log.i(TAG, "Location Settings are satisfied");
            }
        });


        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "Location Settings are not satisfied , Please show some dialog over this event to take location properly");
            }
        });

    }


    public void startLocationUpdates() {
        if(fusedLocationClient == null){
            Log.e(TAG , "Fused Location Client haven't yet created.");
        }else{
            if (checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Log.e(TAG, "Found Location permission are missing ");
                return;
            }else{
                Log.i(TAG , "Location service started");
                fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null /* Looper */);
            }
        }


    }


    public void stopLocationUpdates(){
        try{
            fusedLocationClient.removeLocationUpdates(locationCallback);
        }catch (Exception e){
            Log.e(TAG , ""+e.getMessage());
        }

    }



    private JSONObject getLocationObject(Location location, JSONObject locationJsonObject) throws Exception {
        locationJsonObject.put("latitude", location.getLatitude());
        locationJsonObject.put("longitude", location.getLongitude());
        locationJsonObject.put("accuracy", location.getAccuracy());
        locationJsonObject.put("bearing", location.getBearing());
        locationJsonObject.put("device_time", location.getTime());
        return locationJsonObject ;

    }




}
