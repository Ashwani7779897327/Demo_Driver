package com.apporio.demotaxiappdriver;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.RequiresPermission;
import androidx.core.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.apporio.demotaxiappdriver.MainActivity.LOCATION_PERMISSION_REQUEST_CODE;

public class SetRadiusActivity extends BaseActivity implements OnMapReadyCallback, View.OnClickListener, ApiManager.APIFETCHER {

    @Bind(R.id.ll_get_started)
    LinearLayout ll_get_started;

    @Bind(R.id.ll_radius_intro)
    LinearLayout ll_radius_intro;

    @Bind(R.id.txt_address)
    TextView txt_address;

    @Bind(R.id.iv_back)
    ImageView iv_back;

    @Bind(R.id.et_radius)
    EditText et_radius;

    @Bind(R.id.submit)
    LinearLayout submit;

    @Bind(R.id.rl_map)
    RelativeLayout rl_map;

    private GoogleMap mGoogleMap;
    SupportMapFragment mapFragment;
    private SessionManager sessionManager;
    private ApiManager apiManager;
    View locationButtonView;
    private FusedLocationProviderClient mFusedLocationClient;
    Location driverLocation;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_radius);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_frag_main);
        locationButtonView = mapFragment.getView();
        mapFragment.getMapAsync(this);
        apiManager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(this.getResources().getString(R.string.loading));

        setListeners();
    }

    private void setListeners() {
        ll_get_started.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        submit.setOnClickListener(this);
    }


    //get the location from map
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;

        mGoogleMap.setMaxZoomPreference(20);

        if (checkPermission())
            onLocationPermissionGranted();


        googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {

                //calling API
                try {
                    HashMap<String, String> data = new HashMap<>();
                    data.clear();
                        data.put("latitude", "" + mGoogleMap.getCameraPosition().target.latitude);
                        data.put("longitude", "" + mGoogleMap.getCameraPosition().target.longitude);
                        apiManager._post(API_S.Tags.REVERSE_GEOCODE, API_S.Endpoints.REVERSE_GEOCODE, data, sessionManager);

                } catch (Exception e) {
                    Log.d("**", "Exception caught while calling API " + e.getMessage());
                }
            }
        });

    }

    //give the permission for the google map
    private boolean checkPermission() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //Ask for the permission
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            Toast.makeText(this, "Please give location permission", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    //fetch the current location and then zoom in the map to that location
    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    private void onLocationPermissionGranted() {
        if (!checkPermission()) return;

        mGoogleMap.setMyLocationEnabled(true);

        View locationButton = ((View) locationButtonView.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
        // and next place it, on bottom right (as Google Maps app)
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)
                locationButton.getLayoutParams();
        // position on right bottom
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        layoutParams.setMargins(0, 0, 30, 200);

        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if (location != null) {
                            driverLocation = location;

                            CameraPosition cameraPosition = new CameraPosition.Builder()
                                    .target(new LatLng(driverLocation.getLatitude(), driverLocation.getLongitude()))
                                    .zoom(17)
                                    .build();

                        //    CURRENT_LOCATION = new LatLng(location.getLatitude(), location.getLongitude());
                            mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        } else {
                            driverLocation = null;
                        }
                    }
                });
    }

    //apply the actions on clicks
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.ll_get_started :
                //hiding the layout on getstarted btn click
                ll_radius_intro.setVisibility(View.GONE);
                rl_map.setVisibility(View.VISIBLE);
                break;

            case R.id.iv_back :
                finish();
                break;

            case  R.id.submit :

                if (!et_radius.getText().toString().equals("")) {
                    HashMap<String, String> data = new HashMap<>();
                    data.clear();
                    data.put("latitude", "" + mGoogleMap.getCameraPosition().target.latitude);
                    data.put("longitude", "" + mGoogleMap.getCameraPosition().target.longitude);
                    data.put("radius", "" + et_radius.getText().toString());
                    try {
                        progressDialog.show();
                        apiManager._post(API_S.Tags.DRIVER_LIMIT, API_S.Endpoints.DRIVER_LIMIT_API, data, sessionManager);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(this, "Please set the Radius first.", Toast.LENGTH_SHORT).show();
                }
                break;

        }


    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

        switch (APINAME) {

            case API_S.Tags.REVERSE_GEOCODE:

                Log.d("**CURRENT LOC-- fetch", "" + script);
                ModelReverseGeocode modelReverseGeocode = SingletonGson.getInstance().fromJson("" + script, ModelReverseGeocode.class);
                txt_address.setText("" + modelReverseGeocode.getData().getAddress());

                break;


            case API_S.Tags.DRIVER_LIMIT:

                try {
                    ModelDriverLimit modelDriverLimit = SingletonGson.getInstance().fromJson("" + script, ModelDriverLimit.class);

                    if (modelDriverLimit.getResult().equals("1")){
                        progressDialog.hide();
                        Toast.makeText(this, ""+modelDriverLimit.getMessage(), Toast.LENGTH_SHORT).show();
                        SetRadiusActivity.this.finish();
                    }
                }catch (Exception e){

                }
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Log.d("**CURRENT LOC-- zero", ""+script);
        progressDialog.hide();

    }
}
