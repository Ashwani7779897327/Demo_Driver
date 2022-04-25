package com.apporio.demotaxiappdriver.location;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.RequiresPermission;
import androidx.core.app.ActivityCompat;
import android.util.Log;

import com.apporio.demotaxiappdriver.SplashActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;


public class SamLocationRequestService implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    Context context;
    private static final long INTERVAL = 1000 * 10;
    private static final long FASTEST_INTERVAL = 1000 * 5;

    Address geolocation;

    public static final int LOCATION_PERMISSION_REQUEST_CODE = 858;

    SamLocationListener samLocationListener;

    Location userLocation;



    private FusedLocationProviderClient mFusedLocationClient;


    public SamLocationRequestService(Context context) {
        this.context = context;
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationRequest = new LocationRequest();
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

    }

    public interface SamLocationListener {

        public void onLocationUpdate(Location location);
    }






    public void executeService(final SamLocationListener samLocationListener) {
        this.samLocationListener=samLocationListener;
        mGoogleApiClient.connect();
        if (mGoogleApiClient.isConnected()) {
            startLocationUpdates();
            Log.d("", "Location update resumed .....................");
        }else {
            if(checkPermission()){
                onLocationPermissionGranted();
            }
        }
    }

    public void getsamlocationlistener(final SamLocationListener samLocationListener){
        this.samLocationListener=samLocationListener;
    }

    @Override
    public void onConnected(Bundle bundle) {
        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }



    @Override
    public void onLocationChanged(Location location) {
        Log.e("Lat", " " + String.valueOf(location.getLatitude()));
        Log.e("Long", " " + String.valueOf(location.getLongitude()));
        if ((String.valueOf(location.getLatitude())).equals(null)) {

        } else {
            stopLocationUpdates();
            samLocationListener.onLocationUpdate(location);
        }


    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        PendingResult<Status> pendingResult = LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
        Log.d("LocationRequestService", "Location update started ..............: ");
    }



    public void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
        Log.d("LocationRequestService", "Location update stopped .......................");
    }

    private boolean checkPermission() {

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //Ask for the permission
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            return false;
        }

        return true;
    }


    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    private void onLocationPermissionGranted() {
        if (!checkPermission()) return;
        try {
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(SplashActivity.splash, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {

                            if (location != null) {
                                userLocation = location;

                                samLocationListener.onLocationUpdate(location);
                            } else {
                                userLocation = null;
                            }
                        }
                    });
        }catch (Exception e){

        }

    }

}