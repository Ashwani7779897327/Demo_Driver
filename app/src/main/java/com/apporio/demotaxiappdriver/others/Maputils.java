package com.apporio.demotaxiappdriver.others;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Location;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.Config;
import com.apporio.demotaxiappdriver.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import amitkma.stitch.annotations.CallOnUiThread;

/**
 * Created by samirgoel3@gmail.com on 4/8/2017.
 */

public class Maputils {

    static double brng;
    public static float getbearing(double in_lat , double in_long , double e_lat , double elong){
        Location startingLocation = new Location("starting point");
        startingLocation.setLatitude(in_lat);
        startingLocation.setLongitude(in_long);
        Location endingLocation = new Location("ending point");
        endingLocation.setLatitude(e_lat);
        endingLocation.setLongitude(elong);
        float targetBearing = startingLocation.bearingTo(endingLocation);
        return targetBearing ;
    }

    public static void moverCamera (GoogleMap googleMap , LatLng location ){
        try {
            CameraPosition cameraPosition = new CameraPosition.Builder().target(location).zoom(Config.MainScrenZoon).build();
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }catch (Exception e){

        }
    }

    public  static void setanimatedicon(LatLng current_latlong ,GoogleMap mMap , int ico_image  ){    //// 28.446890, 77.033478
        Marker currLocationMarker;
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(current_latlong);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.fromResource(ico_image));
        currLocationMarker = mMap.addMarker(markerOptions);

        float stroke_Width = (float) 2;
        Circle circle2 = mMap.addCircle(new CircleOptions()
                        .center(new LatLng(current_latlong.latitude, current_latlong.longitude))
                        .radius(600)
                        .fillColor(Color.parseColor("#4D3498DB"))
                        .strokeColor(Color.parseColor("#4D3498DB"))
                        .strokeWidth(stroke_Width)
                // .strokeColor(Color.parseColor("#3498db"))
                //     .strokeWidth(stroke_Width)
        );
        circle2.setCenter(current_latlong);


        final Circle circle = mMap.addCircle(new CircleOptions().center(current_latlong)
                .strokeColor(Color.parseColor("#3498db")).radius(600).strokeWidth(stroke_Width));

        ValueAnimator vAnimator = new ValueAnimator();
        vAnimator.setRepeatCount(ValueAnimator.INFINITE);
        vAnimator.setRepeatMode(ValueAnimator.RESTART);  /* PULSE */
        vAnimator.setIntValues(0, 100);
        vAnimator.setDuration(2000);
        vAnimator.setEvaluator(new IntEvaluator());
        vAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        vAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                // Log.e("", "" + animatedFraction);
                circle.setRadius(animatedFraction * 500);
            }
        });
        vAnimator.start();



    }

    public static void showViewToTop(View view ){
        view.animate().translationY(0);
    }

    public static Marker setDestinationmarker(Context context, GoogleMap mMap, LatLng markerLatLng, String destination_name){
        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.destination_marker_layout, null);
        TextView destination_txt = (TextView) marker.findViewById(R.id.destination_txt);
        destination_txt.setText(""+destination_name);

        Marker customMarker = mMap.addMarker(new MarkerOptions()
                .position(markerLatLng)
                .title(""+destination_name)
                .snippet("Description")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(context, marker))));
        return customMarker ;

    }



    public static Bitmap createDrawableFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }

    private static double bearingBetweenLocations(LatLng latLng1, LatLng latLng2) {

        double PI = 3.14159;
        double lat1 = latLng1.latitude * PI / 180;
        double long1 = latLng1.longitude * PI / 180;
        double lat2 = latLng2.latitude * PI / 180;
        double long2 = latLng2.longitude * PI / 180;

        double dLon = (long2 - long1);

        double y = Math.sin(dLon) * Math.cos(lat2);
        double x = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1)
                * Math.cos(lat2) * Math.cos(dLon);

         brng = Math.atan2(y, x);

        brng = Math.toDegrees(brng);
        brng = (brng + 360) % 360;

        return brng;
    }


    public static void animateMarker(final LatLng toPosition, GoogleMap googleMap, final Marker m, float bearingfactor,String icon_name) {
        Log.d("#########","animating marker on map ");
        Location startingLocation = new Location("starting point");
        startingLocation.setLatitude(m.getPosition().latitude);
        startingLocation.setLongitude(m.getPosition().longitude);
        Location endingLocation = new Location("ending point");
        endingLocation.setLatitude(toPosition.latitude);
        endingLocation.setLongitude(toPosition.longitude);
        float targetBearing = startingLocation.bearingTo(endingLocation);


     //   Log.d("***Target Bearnign ", "" + targetBearing);

        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        Projection proj = googleMap.getProjection();
        Point startPoint = proj.toScreenLocation(m.getPosition());
        final LatLng startLatLng = proj.fromScreenLocation(startPoint);
        final long duration = 1000;


        if(icon_name.equals("custom_mark.png")){

        }else {
            rotateMarker(m, bearingfactor, googleMap);
        }


       // rotateMarker(m, targetBearing, googleMap);

        final Interpolator interpolator = new LinearInterpolator();

        handler.post(new Runnable() {
            @Override
            public void run() {

                try {
                    long elapsed = SystemClock.uptimeMillis() - start;
                    float t = interpolator.getInterpolation((float) elapsed / duration);
                    double lng = t * toPosition.longitude + (1 - t) * startLatLng.longitude;
                    double lat = t * toPosition.latitude + (1 - t)
                            * startLatLng.latitude;
                    m.setPosition(new LatLng(lat, lng));

                    if (t < 1.0) {
                        // Post again 16ms later.
                        handler.postDelayed(this, 16);
                    }
                } catch (Exception e) {

                }
            }
        });
    }


    static public void rotateMarker(final Marker marker, final float toRotation, GoogleMap map) {
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        final float startRotation = marker.getRotation();
        final long duration = 1000;

        final Interpolator interpolator = new LinearInterpolator();


        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                float t = interpolator.getInterpolation((float) elapsed / duration);

                float rot = t * toRotation + (1 - t) * startRotation;

                marker.setRotation(-rot > 180 ? rot / 2 : rot);
                if (t < 1.0) {
                    // Post again 16ms later.
                    handler.postDelayed(this, 16);
                }
            }
        });
    }



    public static boolean isPackageExisted(String targetPackage, Activity activity) {
        PackageManager pm = activity.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }



    public static void slideiewToBottom(View view) {
        view.animate().translationY(view.getHeight()).alpha(1.0f);
    }
    public static void slideToTop(View view, int value){
        view.animate().translationY(value);
    }




    @CallOnUiThread
    public static void showViewtooriginalPosition(View view) {
        view.animate().translationY(0);
    }

}
