package com.apporio.demotaxiappdriver;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import com.apporio.demotaxiappdriver.activities.subscriptionModule.SubscriptionModuleList;
import com.apporio.demotaxiappdriver.baseClass.BaseClassFragmentActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.EventLocation;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.currentwork.NOTIFICATION_TYPES;
import com.apporio.demotaxiappdriver.earnings.NewEarningActivity;
import com.apporio.demotaxiappdriver.fcmclasses.OneSignalServiceClass;
import com.apporio.demotaxiappdriver.holder.HolderActiveRide;
import com.apporio.demotaxiappdriver.location.LocationUpdateService;
import com.apporio.demotaxiappdriver.location.SamLocationRequestService;
import com.apporio.demotaxiappdriver.location.UpdateServiceClass;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelActive;
import com.apporio.demotaxiappdriver.models.ModelAutoAccept;
import com.apporio.demotaxiappdriver.models.ModelDemandSpot;
import com.apporio.demotaxiappdriver.models.ModelDeviceOnlineIffline;
import com.apporio.demotaxiappdriver.models.ModelDriverDetails;
import com.apporio.demotaxiappdriver.models.ModelHomeAddressActivate;
import com.apporio.demotaxiappdriver.models.ModelMainScreen;
import com.apporio.demotaxiappdriver.models.ModelRideNotifications;
import com.apporio.demotaxiappdriver.others.AppUtils;
import com.apporio.demotaxiappdriver.others.EventSendLocation;
import com.apporio.demotaxiappdriver.others.EventSocketConnected;
import com.apporio.demotaxiappdriver.others.EventSocketConnectionState;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.apporio.demotaxiappdriver.settings.SettingsActivity;
import com.apporio.demotaxiappdriver.wallet.WalletActivity;
import com.bumptech.glide.Glide;
import com.github.nkzawa.socketio.client.Socket;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.sam.placer.PlaceHolderView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseClassFragmentActivity implements ApiManager.APIFETCHER, OnMapReadyCallback {
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 858;

    public static MediaPlayer mediaPlayer;

    private boolean doubleBackToExitPressedOnce = false;

    boolean isGoingToHomeActive = false;
    private ModelDriverDetails modelDriverDetails;



    private SamLocationRequestService samLocationRequestService;

    @Bind(R.id.docs_alert)
    LinearLayout docs_alert;
    @Bind(R.id.expiry_msg)
    TextView expire_msg;
    @Bind(R.id.see_docs)
    TextView see_docs;
    @Bind(R.id.close_docs)
    ImageView close_docs;
    @Bind(R.id.online_offline_text)
    TextView onlineOfflineText;
    @Bind(R.id.todays_booking)
    TextView todaysBooking;
    @Bind(R.id.todays_earning)
    TextView todaysEarning;
    @Bind(R.id.activated_car_image)
    ImageView activatedCarImage;
    @Bind(R.id.activated_car_text)
    TextView activatedCarText;
    @Bind(R.id.demand_Spot)
    CardView demandSpot;
    @Bind(R.id.todays_schedule_text)
    FrameLayout main_screen_counter_layout;
    @Bind(R.id.btn_upcomming_ride)
    CardView upcoming_ride_btn;
    @Bind(R.id.trips_btn)
    LinearLayout tripsBtn;
    @Bind(R.id.earning_btn)
    LinearLayout earningBtn;
    @Bind(R.id.accounts_btn)
    LinearLayout accountsBtn;
    @Bind(R.id.settings_btn)
    LinearLayout settingsBtn;
    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.switch_btn)
    SwitchCompat switchBtn;
    @Bind(R.id.switch_btn_auto)
    SwitchCompat switch_btn_auto;
    @Bind(R.id.switch_controll)
    RelativeLayout switchControll;
    @Bind(R.id.frameAuto)
    FrameLayout frameAuto;
    @Bind(R.id.switch_controll_auto)
    RelativeLayout switch_controll_auto;
    @Bind(R.id.view_cars)
    LinearLayout viewCars;
    @Bind(R.id.notification_btn)
    LinearLayout notificationBtn;
    @Bind(R.id.wallet_btn)
    LinearLayout walletBtn;
    @Bind(R.id.placeholder)
    PlaceHolderView placeholder;
    @Bind(R.id.placeholder_layout)
    CardView placeholderLayout;
    @Bind(R.id.main_screen_conter_text)
    TextView mainScreenConterText;
    @Bind(R.id.bottom_bell)
    ImageView bottomBell;
    @Bind(R.id.bottom_cross)
    CardView bottomCross;
    @Bind(R.id.btn_manual_dispatch)
    CardView btn_manual_dispatch;


    @Bind(R.id.switch_btn_goto_home)
    SwitchCompat sc_goto_home;

    @Bind(R.id.goto_home_text)
    TextView gotoHomeText;


    @Bind(R.id.switch_controll_go_to_home)
    RelativeLayout rl_go_to_home;


    @Bind(R.id.activated_car_number)
    TextView activatedCarNumber;
    @Bind(R.id.auto_text)
    TextView auto_text;
    @Bind(R.id.connection_status)
    TextView connectionStatus;

    @Bind(R.id.tvSocketConnection)
    TextView tvSocketConnection;
    @Bind(R.id.tvLocation)
    TextView tvLocation;
    @Bind(R.id.socketAck)
    TextView socketAck;
    @Bind(R.id.tvVehicleStatus)
    TextView tvVehicleStatus;


    @Bind(R.id.no_of_count)
    TextView no_of_count;

    private ArrayList<Integer> SELECTED_SERVICES_TYPES = new ArrayList<>();


    @Bind(R.id.llViewBottomLayout)
    LinearLayout llViewBottomLayout;
    private HashMap<String, String> data = new HashMap<>();
    private SessionManager sessionManager;
    private ModelMainScreen modelMainScreen = null;
    private ApiManager apiManager;
    private GoogleMap mGoogleMap;
    private final String TAG = "MainActivity";
    public static Activity activity;

    SamLocationRequestService sam_location;

    ProgressDialog progressDialog;
    Location userLocation;
    private FusedLocationProviderClient mFusedLocationClient;
    private boolean DEMANDSPOT = false;

    public static int openScreenTerms = 0;

    private static Socket mSocket = null;

    private JobScheduler jobScheduler;
    private ComponentName componentName;

    int mainViewLoader = 0;

    boolean vehicle_id_code = false;
    static String vehicle_id = "";
    ArrayList<String> vehicle_list = new ArrayList<>();

    int openDialog = 1;
    static int clearVehicleId = 1;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sessionManager = new SessionManager(this);
        super.onCreate(savedInstanceState);

        Thread.setDefaultUncaughtExceptionHandler((paramThread, paramThrowable) -> Log.e("Error" + Thread.currentThread().getStackTrace()[2], paramThrowable.getLocalizedMessage()));

        setContentView(R.layout.activity_main);


        clearVehicleId = 1;

        samLocationRequestService = new SamLocationRequestService(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);
        ButterKnife.bind(this);
        activity = this;
        sam_location = new SamLocationRequestService(this);
        apiManager = new ApiManager(this, this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        //startBackgroundTask();

        try {
            callApiForUpdateDriverLocation();
            OneSignalServiceClass.openScreen = 0;
            UpdateServiceClass.openScreen = 0;

        } catch (Exception e) {

        }

        if(sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE)!=null){
            if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                startService();
            } else {
                stopService();
            }
        }else{
            startService();
        }


//        try {
//            if (sessionManager.getAppSecret() != null)
//                sessionManager.getAppSecret();
//
//            Log.e("AppSecretKey", "" + sessionManager.getAppSecret());
//
//        } catch (Exception e) {
//
//        }


        setDataAccordingToConfig();
        // Explaining github session


        //demand spot

        if (sessionManager.getAppConfig().getData().getGeneral_config().isDemand_spot_enable()) {

            demandSpot.setVisibility(View.VISIBLE);
        } else {
            demandSpot.setVisibility(View.GONE);
        }

        btn_manual_dispatch.setOnClickListener(v -> {
            // startActivity(new Intent(MainActivity.this, SubscriptionModuleList.class));

            if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("2")) {
                Toast.makeText(MainActivity.this, getString(R.string.make_online), Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(MainActivity.this, ManualUserDetailActivity.class));
            }
        });


        switchControll.setOnClickListener((View view) -> {
            if (sessionManager.getAppConfig().getData().getGeneral_config().isService_type_selection()) {
                if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("2")) {

                    if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
                        if (sessionManager.getDemoOrNot().equals("2")) {
                            SELECTED_SERVICES_TYPES.clear();
                            startActivityForResult(new Intent(MainActivity.this, VehicleListActivity.class)
                                    .putExtra("SHOW_VEHICLE_LIST", "YES"), 113);
                        } else {
                            openSelectServiceDialog();
                        }
                    } else {
                        openSelectServiceDialog();
                    }

                } else {

                    HashMap<String, String> data = new HashMap<>();
                    if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                        data.put("status", "2");
                    } else if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("2")) {
                        data.put("status", "1");
                    } else {
                        data.put("status", "2");
                    }

                    data.put("vehicle_id", "" + vehicle_id);
                    try {
                        apiManager._post(API_S.Tags.ONLINE_OFFLINE, API_S.Endpoints.ONLINE_OFFLINE, data, sessionManager);
                    } catch (Exception e) {
                        Log.e(TAG, "Exception caught while calling API " + e.getMessage());
                    }
                }
            } else {
                if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("2")) {

                    if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
                        if (sessionManager.getDemoOrNot().equals("2")) {
                            startActivityForResult(new Intent(MainActivity.this, VehicleListActivity.class)
                                    .putExtra("SHOW_VEHICLE_LIST", "YES"), 113);
                        } else {
                            HashMap<String, String> data = new HashMap<>();
                            if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                                data.put("status", "2");
                            } else if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("2")) {
                                data.put("status", "1");
                            } else {
                                data.put("status", "2");
                            }

                            data.put("vehicle_id", "" + vehicle_id);

                            try {
                                apiManager._post(API_S.Tags.ONLINE_OFFLINE, API_S.Endpoints.ONLINE_OFFLINE, data, sessionManager);
                            } catch (Exception e) {
                                Log.e(TAG, "Exception caught while calling API " + e.getMessage());
                            }
                        }
                    } else {
                        HashMap<String, String> data = new HashMap<>();
                        if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                            data.put("status", "2");
                        } else if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("2")) {
                            data.put("status", "1");
                        } else {
                            data.put("status", "2");
                        }

                        data.put("vehicle_id", "" + vehicle_id);

                        try {
                            apiManager._post(API_S.Tags.ONLINE_OFFLINE, API_S.Endpoints.ONLINE_OFFLINE, data, sessionManager);
                        } catch (Exception e) {
                            Log.e(TAG, "Exception caught while calling API " + e.getMessage());
                        }
                    }

                } else {
                    HashMap<String, String> data = new HashMap<>();
                    if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                        data.put("status", "2");
                    } else if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("2")) {
                        data.put("status", "1");
                    } else {
                        data.put("status", "2");
                    }

                    data.put("vehicle_id", "" + vehicle_id);

                    try {
                        apiManager._post(API_S.Tags.ONLINE_OFFLINE, API_S.Endpoints.ONLINE_OFFLINE, data, sessionManager);
                    } catch (Exception e) {
                        Log.e(TAG, "Exception caught while calling API " + e.getMessage());
                    }
                }
            }

        });

        switch_controll_auto.setOnClickListener((View view) -> {
            if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                data.put("status", "2");
            } else if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("2")) {
                data.put("status", "1");
            } else {
                data.put("status", "2");
            }


            try {
                apiManager._post(API_S.Tags.AUTO_ACCEPT, API_S.Endpoints.AUTO_ACCEPT, data, sessionManager);
            } catch (Exception e) {
                Log.e(TAG, "Exception caught while calling API " + e.getMessage());
            }
        });

        tripsBtn.setOnClickListener((View view) -> {
            startActivity(new Intent(MainActivity.this, TripHistoryActivity.class));
        });

        earningBtn.setOnClickListener((View view) -> {
            //  writeStringAsFile(this, "HELLo Punnet How are you I am fine Okay the", "vishal.txt");
            //   getTextFileData("hello.txt");
            startActivity(new Intent(MainActivity.this, NewEarningActivity.class));
        });

        try {
            accountsBtn.setOnClickListener((View view) -> {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class)
                        .putExtra("" + IntentKeys.IFSC_VISIBILITY, "" + modelMainScreen.getData().getAdditional_bank_data())
                        .putExtra("" + IntentKeys.IFSC_PLACEHOLDER, "" + modelMainScreen.getData().getAdditional_bank_data_placeholder()));
            });
        } catch (Exception e) {

        }


        settingsBtn.setOnClickListener((View view) -> {
            //  loadAssetTextAsString(this,"vishal.txt");

            //   Log.e("File",""+loadAssetTextAsString(this,"vishal.txt"));
            // readFileAsString(this,"vishal.txt");
            startActivity(new Intent(MainActivity.this, SettingsActivity.class)
                    .putExtra(IntentKeys.AUTO_UPGRADATION, modelMainScreen.getData().getRide_config().getAuto_upgradetion_status())
                    .putExtra(IntentKeys.AUTO_UPGRADATION_SHOW, modelMainScreen.getData().getRide_config().getAuto_upgradetion())
                    .putExtra(IntentKeys.POOL_RIDE_ACTIVATE, modelMainScreen.getData().getRide_config().getPool_enable_status())
                    .putExtra(IntentKeys.POOL_RIDE_ACTIVATE_SHOW, modelMainScreen.getData().getRide_config().isPool_enable()));
        });

        viewCars.setOnClickListener((View view) -> {
            startActivityForResult(new Intent(MainActivity.this, VehicleListActivity.class)
                    .putExtra("SHOW_VEHICLE_LIST", "NO"), 114);

        });

        notificationBtn.setOnClickListener((View view) -> {
            startActivity(new Intent(MainActivity.this, NotificationActivity.class));
        });

        walletBtn.setOnClickListener((View view) -> {
            startActivity(new Intent(MainActivity.this, WalletActivity.class));
        });

        demandSpot.setOnClickListener((View view) -> {
            if (DEMANDSPOT != true) {
                try {
                    apiManager._post(API_S.Tags.DEMAND_SPOT, API_S.Endpoints.DEMAND_SPOT, null, sessionManager);
                } catch (Exception e) {
                    Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                }
            } else {
                mGoogleMap.clear();
                DEMANDSPOT = false;
            }
        });

        upcoming_ride_btn.setOnClickListener((View view) -> {


            startActivity(new Intent(MainActivity.this, NewRequestActivity.class));


        });

        bottomBell.setOnClickListener((View view) -> {
            placeholderLayout.setVisibility(View.VISIBLE);
            AppUtils.enterReveal(placeholderLayout);
            bottomBell.setVisibility(View.GONE);
            mainScreenConterText.setVisibility(View.GONE);
            bottomCross.setVisibility(View.VISIBLE);
        });

        bottomCross.setOnClickListener((View view) -> {
            placeholderLayout.setVisibility(View.INVISIBLE);
            AppUtils.exitReveal(placeholderLayout);
            bottomBell.setVisibility(View.VISIBLE);
            mainScreenConterText.setVisibility(View.VISIBLE);
            bottomCross.setVisibility(View.GONE);
        });


        close_docs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                docs_alert.setVisibility(View.GONE);

            }
        });


        see_docs.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PersonalDocumentActivity.class)));
    }

    private void openSelectServiceDialog() {

        boolean[] checkedItems = new boolean[modelMainScreen.getData().getAvailable_services().size()];

        for (int i = 0; i < modelMainScreen.getData().getAvailable_services().size(); i++) {
            if (SELECTED_SERVICES_TYPES.contains(i)) {
                checkedItems[i] = true;
            } else {
                checkedItems[i] = false;
            }
        }

        ArrayList<String> services = new ArrayList<>();
        for (int i = 0; i < modelMainScreen.getData().getAvailable_services().size(); i++) {
            services.add("" + modelMainScreen.getData().getAvailable_services().get(i).getServiceName());
        }
        String[] stringArray = services.toArray(new String[0]);


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMultiChoiceItems(stringArray, checkedItems, (dialog, indexSelected, isChecked) -> {
            if (isChecked) {
                SELECTED_SERVICES_TYPES.add(indexSelected);
            } else if (SELECTED_SERVICES_TYPES.contains(indexSelected)) {
                SELECTED_SERVICES_TYPES.remove(Integer.valueOf(indexSelected));
            }
        }).setPositiveButton(getResources().getString(R.string.ok), (dialog, id) -> {

            String services1 = "";
            for (int i = 0; i < SELECTED_SERVICES_TYPES.size(); i++) {
                if (i == (SELECTED_SERVICES_TYPES.size() - 1)) {  // that is last element
                    //  services = services + modelvehicleConfiguration.getData().getService_type().get(SELECTED_SERVICES_TYPES.get(i)).getId();
                    services1 = services1 + modelMainScreen.getData().getAvailable_services().get(SELECTED_SERVICES_TYPES.get(i)).getService_id();
                } else {
                    //    services = services + modelvehicleConfiguration.getData().getService_type().get(SELECTED_SERVICES_TYPES.get(i)).getId() + ",";
                    services1 = services1 + modelMainScreen.getData().getAvailable_services().get(SELECTED_SERVICES_TYPES.get(i)).getService_id() + ",";
                }
            }

            if (modelMainScreen.getData().getActive_rides().size() > 0) {
                if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                    Toast.makeText(activity, "You can't be offline. YOu have active ride", Toast.LENGTH_SHORT).show();
                } else {
                    data.put("service_type", "" + services1);
                    if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                        data.put("status", "2");
                    } else {
                        data.put("status", "1");
                    }

                    data.put("vehicle_id", "" + vehicle_id);

                    if (SELECTED_SERVICES_TYPES.size() != 0) {
                        try {
                            apiManager._post(API_S.Tags.ONLINE_OFFLINE, API_S.Endpoints.ONLINE_OFFLINE, data, sessionManager);
                        } catch (Exception e) {
                            Log.e(TAG, "Exception caught while calling API " + e.getMessage());
                        }
                    } else {
                        Toast.makeText(MainActivity.this, R.string.select_service_online, Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                data.put("service_type", "" + services1);
                if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                    data.put("status", "2");
                } else {
                    data.put("status", "1");
                }

                data.put("vehicle_id", "" + vehicle_id);

                if (SELECTED_SERVICES_TYPES.size() != 0) {
                    try {
                        apiManager._post(API_S.Tags.ONLINE_OFFLINE, API_S.Endpoints.ONLINE_OFFLINE, data, sessionManager);
                    } catch (Exception e) {
                        Log.e(TAG, "Exception caught while calling API " + e.getMessage());
                    }
                } else {
                    Toast.makeText(MainActivity.this, R.string.select_service_online, Toast.LENGTH_SHORT).show();
                }
            }
        }).setNegativeButton(getResources().getString(R.string.cancel), (dialog, id) -> {
            if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
                if (sessionManager.getDemoOrNot().equals("2")) {
                    vehicle_id = "";
                    sessionManager.setVehicleId("");
                }

                try {
                    HashMap<String, String> data1 = new HashMap<>();
                    data1.put("vehicle_id", vehicle_id);
                    apiManager._post(API_S.Tags.MAIN_SCREEN, API_S.Endpoints.MAIN_SCREEN, data1, sessionManager);
                    placeholder.removeAllViews();
                } catch (Exception e) {
                    Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                }
            }

//
//            if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
//                activatedCarText.setText("");
//                activatedCarNumber.setText("");
//                tvVehicleStatus.setText(getResources().getString(R.string.no_vehicle_activated_message));
//                tvVehicleStatus.setTextColor(getResources().getColor(R.color.red_text));
//
//
//            } else {
//                activatedCarText.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_type());
//                activatedCarNumber.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_number());
//                tvVehicleStatus.setText(getResources().getString(R.string.live_now));
//                tvVehicleStatus.setTextColor(getResources().getColor(R.color.icons_8_muted_green_1));
//                Glide.with(this).load("" + modelMainScreen.getData().getActive_vehicle().getVehicleTypeImage()).into(activatedCarImage);
//            }
            dialog.dismiss();
        });

        builder.show();
    }


    private void setDataAccordingToConfig() {

        frameAuto.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isAuto_accept_mode() ? View.VISIBLE : View.GONE);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onResume() {
        super.onResume();

        try {
            OneSignalServiceClass.openScreen = 0;
        } catch (Exception e) {

        }

        clearVehicleId = 1;

        try {
            if (!sessionManager.getUserDetails().get(SessionManager.KEY_DriverVehicleId).equals("")) {
                vehicle_id = sessionManager.getUserDetails().get(SessionManager.KEY_DriverVehicleId);
                sessionManager.setVehicleIdForOnline(vehicle_id);
            } else {
                vehicle_id = sessionManager.getVehicleId();
                sessionManager.setVehicleIdForOnline(vehicle_id);
            }
        } catch (Exception e) {

        }


        this.doubleBackToExitPressedOnce = false;
        EventBus.getDefault().register(this);
        setStatusAccordingly();

        if (sessionManager.getAppConfig().getData().getGeneral_config().isAuto_accept_mode()) {
            setStatusForAutoAccept();
        }

        try {
            HashMap<String, String> data1 = new HashMap<>();
            data1.put("vehicle_id", vehicle_id);
            apiManager._post(API_S.Tags.MAIN_SCREEN, API_S.Endpoints.MAIN_SCREEN, data1, sessionManager);
            placeholder.removeAllViews();
        } catch (Exception e) {
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
        }



        try {
            apiManager._post(API_S.Tags.DRIVER_DETAILS, API_S.Endpoints.DRIVER_DETAILS, null, sessionManager);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setStatusAccordingly() {

        if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
//            startService();
            switchBtn.setChecked(true);
            onlineOfflineText.setText("" + this.getResources().getString(R.string.MAIN_ACTIVITY__online));
            onlineOfflineText.setTextColor(Color.parseColor("#2ecc71"));

            // startBackgroundTask();
        } else if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("2")) {
            switchBtn.setChecked(false);
            onlineOfflineText.setText("" + this.getResources().getString(R.string.MAIN_ACTIVITY__offline));
            onlineOfflineText.setTextColor(Color.parseColor("#e74c3c"));

            stopService();
            //   stopBackgroundTask();

        }
    }

    private void setData() {
        if (clearVehicleId == 1) {
            if (!vehicle_id.equals("")) {
                if (modelMainScreen.getData().getActive_vehicle().getVehicle_type() != null) {
                    activatedCarText.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_type());
                    activatedCarNumber.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_number());
                    tvVehicleStatus.setText(getResources().getString(R.string.live_now));
                    tvVehicleStatus.setTextColor(getResources().getColor(R.color.icons_8_muted_green_1));
                    Glide.with(this).load("" + modelMainScreen.getData().getActive_vehicle().getVehicleTypeImage()).into(activatedCarImage);
                } else {
                    if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
                        activatedCarText.setText("");
                        activatedCarNumber.setText("");
                        tvVehicleStatus.setText(getResources().getString(R.string.no_vehicle_activated_message));
                        tvVehicleStatus.setTextColor(getResources().getColor(R.color.red_text));
                    } else {
                        activatedCarText.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_type());
                        activatedCarNumber.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_number());
                        tvVehicleStatus.setText(getResources().getString(R.string.live_now));
                        tvVehicleStatus.setTextColor(getResources().getColor(R.color.icons_8_muted_green_1));
                        Glide.with(this).load("" + modelMainScreen.getData().getActive_vehicle().getVehicleTypeImage()).into(activatedCarImage);
                    }

                }
            } else {
                if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
                    activatedCarText.setText("");
                    activatedCarNumber.setText("");
                    tvVehicleStatus.setText(getResources().getString(R.string.no_vehicle_activated_message));
                    tvVehicleStatus.setTextColor(getResources().getColor(R.color.red_text));
                } else {
                    activatedCarText.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_type());
                    activatedCarNumber.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_number());
                    tvVehicleStatus.setText(getResources().getString(R.string.live_now));
                    tvVehicleStatus.setTextColor(getResources().getColor(R.color.icons_8_muted_green_1));
                    Glide.with(this).load("" + modelMainScreen.getData().getActive_vehicle().getVehicleTypeImage()).into(activatedCarImage);
                }
            }
        }
    }

    private void setStatusForAutoAccept() {

        if (sessionManager.getUserDetails().get(SessionManager.KEY_AUTO_ACCEPT).equals("1")) {
            switch_btn_auto.setChecked(true);
            auto_text.setTextColor(Color.parseColor("#2ecc71"));

        } else {
            switch_btn_auto.setChecked(false);
            auto_text.setTextColor(Color.parseColor("#e74c3c"));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setDataForMainScreen(String script) throws Exception {

        try {
            modelMainScreen = SingletonGson.getInstance().fromJson("" + script, ModelMainScreen.class);

            llViewBottomLayout.setVisibility(View.VISIBLE);
            for (int i = 0; i < modelMainScreen.getData().getActive_rides().size(); i++) {
                placeholder.addView(new HolderActiveRide(this, modelMainScreen.getData().getActive_rides().get(i)));
            }

            try {
                for (int i = 0; i < modelMainScreen.getData().getDocument_message().size(); i++) {

                    if (modelMainScreen.getData().getDocument_message().get(i).isShow()) {
                        sessionManager.setonline_offline(false);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            setStatusAccordingly();
                        }
                        showDialogForOpenEvent(modelMainScreen.getData().getDocument_message().get(i).getMessage(), modelMainScreen.getData().getDocument_message().get(i).getAction());
                    }
                }

            } catch (Exception e) {

            }

            for (int i = 0; i < modelMainScreen.getData().getAdmin_message().size(); i++) {

                Log.e("***clearVehicleId", "" + clearVehicleId);
//            if (modelMainScreen.getData().getAdmin_message().get(i).getShow()) {
//                placeholder.addView(new HolderSubscription(this, modelMainScreen.getData().getAdmin_message().get(i)));
//            }
                if (modelMainScreen.getData().getAdmin_message().get(i).getShow()) {
                    sessionManager.setonline_offline(false);
                    setStatusAccordingly();
                    if (modelMainScreen.getData().getAdmin_message().get(i).getAction().equals("SUBSCRIPTION_BUY")) {
//                        if (clearVehicleId != 2) {
//                            if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
//                                if (sessionManager.getDemoOrNot().equals("2")) {
//                                    vehicle_id = "";
//                                    sessionManager.setVehicleId("");
//                                }
//                            }
//                        }
                        sessionManager.setonline_offline(false);

                        setStatusAccordingly();
                        Toast.makeText(MainActivity.this, "" + modelMainScreen.getData().getAdmin_message().get(i).getMessage(), Toast.LENGTH_SHORT).show();
                    } else if (modelMainScreen.getData().getAdmin_message().get(i).getAction().equals("SUBSCRIPTION_EXPIRE")) {
//                        if (clearVehicleId != 2) {
//                            if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
//                                if (sessionManager.getDemoOrNot().equals("2")) {
//                                    vehicle_id = "";
//                                    sessionManager.setVehicleId("");
//                                }
//                            }
//                        }
                        sessionManager.setonline_offline(false);

                        setStatusAccordingly();
                        Toast.makeText(MainActivity.this, "" + modelMainScreen.getData().getAdmin_message().get(i).getMessage(), Toast.LENGTH_SHORT).show();
                    } else if (modelMainScreen.getData().getAdmin_message().get(i).getAction().equals("WALLET_BALANCE")) {

//                        if (clearVehicleId != 2) {
//                            if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
//                                if (sessionManager.getDemoOrNot().equals("2")) {
//                                    vehicle_id = "";
//                                    sessionManager.setVehicleId("");
//                                }
//                            }
//                        }

                        sessionManager.setonline_offline(false);

                        setStatusAccordingly();
                        Toast.makeText(MainActivity.this, "" + modelMainScreen.getData().getAdmin_message().get(i).getMessage(), Toast.LENGTH_SHORT).show();
                    } else {


//                        if (clearVehicleId != 2) {
//                            if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
//                                if (sessionManager.getDemoOrNot().equals("2")) {
//                                    vehicle_id = "";
//                                    sessionManager.setVehicleId("");
//                                }
//                            }
//                        }

                        sessionManager.setonline_offline(false);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            setStatusAccordingly();
                        }
                        showDialogForOpenEvent(modelMainScreen.getData().getAdmin_message().get(i).getMessage(), modelMainScreen.getData().getAdmin_message().get(i).getAction());
                    }
                }
            }
            bottomBell.setVisibility(View.VISIBLE);

            try {
                mainScreenConterText.setVisibility(View.VISIBLE);
                placeholderLayout.setVisibility(View.INVISIBLE);
                bottomCross.setVisibility(View.GONE);


                todaysBooking.setText("" + modelMainScreen.getData().getTodays().getTodays_rides());
                todaysBooking.setTextColor(Color.parseColor("#" + modelMainScreen.getData().getTodays().getTodays_rides_color()));
                todaysEarning.setText("" + modelMainScreen.getData().getTodays().getTodays_earning());
                //todaysEarning.setTextColor(Color.parseColor("#" + modelMainScreen.getData().getTodays().getTodays_earning_color()));
                //  mainScreenConterText.setText("" + (modelMainScreen.getData().getAdmin_message().size() + modelMainScreen.getData().getActive_rides().size() + modelMainScreen.getData().getScheduled_rides().size()));

                if (clearVehicleId != 2) {
                    if (!vehicle_id.equals("")) {
                        if (modelMainScreen.getData().getActive_vehicle().getVehicle_type() != null) {
                            activatedCarText.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_type());
                            activatedCarNumber.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_number());
                            tvVehicleStatus.setText(getResources().getString(R.string.live_now));
                            tvVehicleStatus.setTextColor(getResources().getColor(R.color.icons_8_muted_green_1));
                            Glide.with(this).load("" + modelMainScreen.getData().getActive_vehicle().getVehicleTypeImage()).into(activatedCarImage);
                        } else {
                            if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
                                activatedCarText.setText("");
                                activatedCarNumber.setText("");
                                tvVehicleStatus.setText(getResources().getString(R.string.no_vehicle_activated_message));
                                tvVehicleStatus.setTextColor(getResources().getColor(R.color.red_text));
                                Glide.with(this).load("").into(activatedCarImage);
                            } else {
                                activatedCarText.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_type());
                                activatedCarNumber.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_number());
                                tvVehicleStatus.setText(getResources().getString(R.string.live_now));
                                tvVehicleStatus.setTextColor(getResources().getColor(R.color.icons_8_muted_green_1));
                                Glide.with(this).load("" + modelMainScreen.getData().getActive_vehicle().getVehicleTypeImage()).into(activatedCarImage);
                            }
                        }
                    } else {
                        if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                            activatedCarText.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_type());
                            activatedCarNumber.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_number());
                            tvVehicleStatus.setText(getResources().getString(R.string.live_now));
                            tvVehicleStatus.setTextColor(getResources().getColor(R.color.icons_8_muted_green_1));
                            Glide.with(this).load("" + modelMainScreen.getData().getActive_vehicle().getVehicleTypeImage()).into(activatedCarImage);
                        } else {
                            if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
                                activatedCarText.setText("");
                                activatedCarNumber.setText("");
                                tvVehicleStatus.setText(getResources().getString(R.string.no_vehicle_activated_message));
                                tvVehicleStatus.setTextColor(getResources().getColor(R.color.red_text));
                                Glide.with(this).load("").into(activatedCarImage);
                            } else {
                                activatedCarText.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_type());
                                activatedCarNumber.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_number());
                                tvVehicleStatus.setText(getResources().getString(R.string.live_now));
                                tvVehicleStatus.setTextColor(getResources().getColor(R.color.icons_8_muted_green_1));
                                Glide.with(this).load("" + modelMainScreen.getData().getActive_vehicle().getVehicleTypeImage()).into(activatedCarImage);
                            }
                        }
                    }
                }

            } catch (Exception e) {

            }

            try {
                Log.e("Active Rides", "" + modelMainScreen.getData().getActive_rides().size());
                int a = Integer.parseInt(String.valueOf(modelMainScreen.getData().getActive_rides().size()));
                mainScreenConterText.setText(String.valueOf(a));
            } catch (Exception e) {

            }


            try {
                btn_manual_dispatch.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isManual_dispatch() ? View.VISIBLE : View.GONE);

                try {
                    if (!sessionManager.getTaxiCompany()) {
                        earningBtn.setVisibility(View.VISIBLE);
                        walletBtn.setVisibility(sessionManager.getAppConfig().getData().getNavigation_drawer().isWallet() ? View.VISIBLE : View.GONE);
                    } else {
                        walletBtn.setVisibility(View.GONE);
                        earningBtn.setVisibility(View.GONE);
                    }
                } catch (Exception e) {
                    walletBtn.setVisibility(sessionManager.getAppConfig().getData().getNavigation_drawer().isWallet() ? View.VISIBLE : View.GONE);
                }


                if (modelMainScreen.getData().getTerm_status() == 1) {
                    if (openScreenTerms == 0) {
                        startActivity(new Intent(this, TermsAndCondition.class)
                                .putExtra(Config.IntentKeys.TERMS_CONDITION, "acceptmain"));
                        openScreenTerms = 1;
                    }
                }





                rl_go_to_home.setOnClickListener((View view) -> {

//            if (modelDriverDetails.getData().getHome_location_active().equalsIgnoreCase("1")) {
//                data.put("status", "2");
//            } else {
//                data.put("status", "1");
//            }



                    if(modelDriverDetails.getData().getSelected_address().equalsIgnoreCase("")){
                        startActivity(new Intent(MainActivity.this, HomeAddressActivity.class)
                                .putExtra("" + IntentKeys.HOME_LOCATION_ACTIVE_STATUS, "" + modelDriverDetails.getData().getHome_location_active())
                                .putExtra("" + IntentKeys.ADDRESS, "" + modelDriverDetails.getData().getSelected_address()));
                    }else {
                        if (isGoingToHomeActive) {
                            data.put("status", "2");
                        } else {
                            data.put("status", "1");
                        }

                        try {
                            apiManager._post(API_S.Tags.ACTIVE_DEACTIVE_HOME_ADDRESS,API_S.Endpoints.ACTIVE_DEACTIVE_HOME_ADDRESS,data,sessionManager);
                        } catch (Exception e) {
                            Log.e(TAG, "Exception caught while calling API " + e.getMessage());
                        }
                    }

                });

            }













            catch (Exception e) {

            }

        } catch (Exception e) {

            Log.e("Exception", "" + e);
        }

        progressDialog.dismiss();
    }








    @Override
    public void onAPIRunningState(int a, String APINAME) {
        try {
            if (APINAME.equals(API_S.Tags.ONLINE_OFFLINE)) {
                if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                    progressDialog.show();
                } else if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
            if (APINAME.equals(API_S.Tags.MAIN_SCREEN)) {
                if (mainViewLoader == 0) {
                    if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                        progressDialog.show();
                    } else if (progressDialog.isShowing()) {
                    }
                    mainViewLoader = 1;
                }
            }
        } catch (Exception e) {

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            switch (APINAME) {
                case API_S.Tags.ONLINE_OFFLINE:
                    ModelDeviceOnlineIffline modelDeviceOnlineIffline = SingletonGson.getInstance().fromJson("" + script, ModelDeviceOnlineIffline.class);
                    if (modelDeviceOnlineIffline.getData().getOnline_offline().equals("1")) {
                        sessionManager.setonline_offline(true);
                        if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
                            activatedCarText.setText("");
                            activatedCarNumber.setText("");
                            tvVehicleStatus.setText(getResources().getString(R.string.no_vehicle_activated_message));
                            tvVehicleStatus.setTextColor(getResources().getColor(R.color.red_text));
                            Glide.with(this).load("").into(activatedCarImage);
                        } else {
                            activatedCarText.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_type());
                            activatedCarNumber.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_number());
                            tvVehicleStatus.setText(getResources().getString(R.string.live_now));
                            tvVehicleStatus.setTextColor(getResources().getColor(R.color.icons_8_muted_green_1));
                            Glide.with(this).load("" + modelMainScreen.getData().getActive_vehicle().getVehicleTypeImage()).into(activatedCarImage);
                        }
                        try {
                            startService();
                        } catch (Exception e) {

                        }
                    } else if (modelDeviceOnlineIffline.getData().getOnline_offline().equals("2")) {
                        if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
                            if (sessionManager.getDemoOrNot().equals("2")) {
                                vehicle_id = "";
                                sessionManager.setVehicleId("");
                            }
                        }
                        sessionManager.setonline_offline(false);

                    }

                    try {
                        HashMap<String, String> data1 = new HashMap<>();
                        data1.put("vehicle_id", vehicle_id);
                        apiManager._post(API_S.Tags.MAIN_SCREEN, API_S.Endpoints.MAIN_SCREEN, data1, sessionManager);
                        placeholder.removeAllViews();
                    } catch (Exception e) {
                        Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }

                    setStatusAccordingly();
                    break;

                case API_S.Tags.AUTO_ACCEPT:
                    ModelAutoAccept modelAutoAccept = SingletonGson.getInstance().fromJson("" + script, ModelAutoAccept.class);
                    if (modelAutoAccept.getAutoAccept().equals("1")) {
                        sessionManager.setAutoAccept(true);
                    } else if (modelAutoAccept.getAutoAccept().equals("2")) {
                        sessionManager.setAutoAccept(false);
                    }
                    setStatusForAutoAccept();
                    break;


                case API_S.Tags.ACTIVE_RIDE:
                    final ModelActive modelActive = SingletonGson.getInstance().fromJson("" + script, ModelActive.class);
                    if (modelActive.getData().size() > 0) {
                        Snackbar.make(root, getString(R.string.you_have_one_onegoing_ride) + " #" + modelActive.getData().get(0).getId(), Snackbar.LENGTH_SHORT)
                                .setAction(R.string.go_to_ride, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        startActivity(new Intent(MainActivity.this, TrackingActivity.class)
                                                .putExtra("" + IntentKeys.BOOKING_ID, "" + modelActive.getData().get(0).getId()));
                                    }
                                }).setActionTextColor(Color.parseColor("#ffffff")).show();
                    }
                    break;
                case API_S.Tags.DEMAND_SPOT:
                    ModelDemandSpot modelDemandSpot = SingletonGson.getInstance().fromJson("" + script, ModelDemandSpot.class);
                    DEMANDSPOT = true;
                    setheatmap(modelDemandSpot);
                    break;
                case API_S.Tags.MAIN_SCREEN:
                    try {
                        setDataForMainScreen("" + script);

                        modelMainScreen = SingletonGson.getInstance().fromJson(""+script,ModelMainScreen.class);

                       no_of_count.setText(modelMainScreen.getData().getUpcoming_bookings());


                    } catch (Exception e) {
                        // Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        //  Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                        Log.e("" + TAG, "Exception caught while setting data " + e.getMessage());
                    }

                    if (openDialog == 2) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                        }
                        openSelectServiceDialog();
                        openDialog = 1;
                    }

                    break;

                case API_S.Tags.LOGOUT:
                    sessionManager.setonline_offline(false);
                    sessionManager.logoutUser();
                    sessionManager.clearAccessToken("");
                    //    stopBackgroundTask();
                    stopService();
                    finish();
                    startActivity(new Intent(MainActivity.this, SplashActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    break;



                case API_S.Tags.DRIVER_DETAILS:

                    modelDriverDetails = SingletonGson.getInstance().fromJson("" + script, ModelDriverDetails.class);

//                    MainActivity.wallet_balance_main= modelDriverDetails.getData().getWallet_money();

                    if (modelDriverDetails.getData().getHome_location_active().equalsIgnoreCase("1")){
                        isGoingToHomeActive = true;
                    }else {
                        isGoingToHomeActive = false;
                    }
                    setGoHomeAccordingly();

                    break;



                case API_S.Tags.ACTIVE_DEACTIVE_HOME_ADDRESS:

                    try {
                        ModelHomeAddressActivate modelHomeAddressActivate = SingletonGson.getInstance().fromJson(""+script,ModelHomeAddressActivate.class);
                        if(modelHomeAddressActivate.isData()){

                            isGoingToHomeActive = true;

                        }else{
                            isGoingToHomeActive = false;
                        }
                        setGoHomeAccordingly();
                    } catch (Exception e) {
                        Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                        Log.e("" + TAG, "Exception caught while parsing " + e.getMessage());
                    }

                    break;





            }
        } catch (Exception e) {
            //  Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            //  Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(MainActivity.this, "" + script, Toast.LENGTH_SHORT).show();
        // Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStatusAccordingly();
        }
        if (sessionManager.getAppConfig().getData().getGeneral_config().isAuto_accept_mode()) {
            setStatusForAutoAccept();
        }

        if (APINAME.equals("ONLINE_OFFLINE")) {
            stopService();
            if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
                sessionManager.setVehicleId("");
                activatedCarText.setText("");
                vehicle_id = "";
                activatedCarNumber.setText("");
                tvVehicleStatus.setText(getResources().getString(R.string.no_vehicle_activated_message));
                tvVehicleStatus.setTextColor(getResources().getColor(R.color.red_text));
            } else {
                activatedCarText.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_type());
                activatedCarNumber.setText("" + modelMainScreen.getData().getActive_vehicle().getVehicle_number());
                tvVehicleStatus.setText(getResources().getString(R.string.live_now));
                tvVehicleStatus.setTextColor(getResources().getColor(R.color.icons_8_muted_green_1));
                Glide.with(this).load("" + modelMainScreen.getData().getActive_vehicle().getVehicleTypeImage()).into(activatedCarImage);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (sessionManager.getAppConfig().getData().getGeneral_config().isAdd_multiple_vehicle() || sessionManager.getAppConfig().getData().getGeneral_config().isExisting_vehicle_enable()) {
            if (sessionManager.getDemoOrNot().equals("2")) {
                if (requestCode == 113 && resultCode == RESULT_OK) {
                    vehicle_id = data.getExtras().getString("VEHICLE_ID");

                    if (vehicle_id == null || vehicle_id.equals("")) {
                        clearVehicleId = 1;
                    } else {
                        if (sessionManager.getAppConfig().getData().getGeneral_config().isService_type_selection()) {
                            openDialog = 2;
                        }
                        clearVehicleId = 2;
                        sessionManager.setVehicleId(vehicle_id);
                        sessionManager.setVehicleIdForOnline(vehicle_id);

                        if (!sessionManager.getAppConfig().getData().getGeneral_config().isService_type_selection()) {
                            if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("2")) {
                                HashMap<String, String> data1 = new HashMap<>();
                                if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
                                    data1.put("status", "2");
                                } else {
                                    data1.put("status", "1");
                                }

                                data1.put("vehicle_id", "" + vehicle_id);
                                try {
                                    apiManager._post(API_S.Tags.ONLINE_OFFLINE, API_S.Endpoints.ONLINE_OFFLINE, data1, sessionManager);
                                } catch (Exception e) {
                                    Log.e(TAG, "Exception caught while calling API " + e.getMessage());
                                }
                            }
                        }
                    }

                    try {
                        progressDialog.show();
                    } catch (Exception e) {
                        Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }
                }
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

        mGoogleMap.setMaxZoomPreference(20);

        if (checkPermission())
            progressDialog.show();
        onLocationPermissionGranted();
    }

    private boolean checkPermission() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //Ask for the permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            Toast.makeText(this, "Please give location permission", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    private void onLocationPermissionGranted() {
        if (!checkPermission()) return;
        mGoogleMap.setMyLocationEnabled(true);
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if (location != null) {
                            EventBus.getDefault().post(new EventLocation(location));
                            userLocation = location;

                            CameraPosition cameraPosition = new CameraPosition.Builder()
                                    .target(new LatLng(userLocation.getLatitude(), userLocation.getLongitude()))
                                    .zoom(17)
                                    .build();

                            //  mGoogleMap.clear();
                            mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                        } else {
                            userLocation = null;
                        }
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventLocation event) {

        //  Maputils.moverCamera(mGoogleMap, new LatLng(event.location.getLatitude(), event.location.getLongitude()));
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String data) {
        ModelRideNotifications modelRideNotifications = SingletonGson.getInstance().fromJson("" + data, ModelRideNotifications.class);
        if (modelRideNotifications.getType() == 6) {   // Delete Driver from admin panel
            try {
                apiManager._post("" + API_S.Tags.LOGOUT, "" + API_S.Endpoints.LOGOUT, null, sessionManager);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                // Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
            }
        } else if (modelRideNotifications.getType() == NOTIFICATION_TYPES.RIDE) {   // Delete Driver from admin panel

            if (modelRideNotifications.getData().getBooking_type().equals("2")) {
                try {
                    setMediaSound();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                showDialogForShowOutStation(modelRideNotifications.getData().getOutstation_msg(), modelRideNotifications);
            }
        }
    }


    private void setheatmap(ModelDemandSpot modelDemandSpot) throws Exception {
        List<LatLng> list = new ArrayList<>();

        try {
            for (int i = 0; i < modelDemandSpot.getData().size(); i++) {
                list.add(new LatLng(Double.parseDouble("" + modelDemandSpot.getData().get(i).getPickup_latitude()), Double.parseDouble("" + modelDemandSpot.getData().get(i).getPickup_longitude())));
            }

        } catch (Exception e) {

        }

        // Create a heat map tile provider, passing it the latlngs of the police stations.
        HeatmapTileProvider mProvider = new HeatmapTileProvider.Builder()
                .data(list)
                .build();
        // Add a tile overlay to the map, using the heat map tile provider.
        TileOverlay mOverlay = mGoogleMap.addTileOverlay(new TileOverlayOptions().tileProvider(mProvider));


        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (int i = 0; i < list.size(); i++) {
            builder.include(list.get(i));
        }
        LatLngBounds bounds = builder.build();
        Point displaySize = new Point();
        this.getWindowManager().getDefaultDisplay().getSize(displaySize);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, displaySize.x, 1300, 100));

    }

    private void showDialogForOpenEvent(String message, String action) {
        final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Setting dialogview
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
        dialog.setTitle(null);
        dialog.setCancelable(false);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_open_event);

        TextView textView = (TextView) dialog.findViewById(R.id.tvMessage);
        textView.setText(message);

        Button btnOkay = (Button) dialog.findViewById(R.id.btnOkay);

        btnOkay.setOnClickListener(v -> {
            if (action.equals("SUBSCRIPTION_BUY")) {
//                data.clear();
//                data.put("status", "2");
//
//                data.put("vehicle_id", "" + vehicle_id);
//                try {
//                    apiManager._post(API_S.Tags.ONLINE_OFFLINE, API_S.Endpoints.ONLINE_OFFLINE, data, sessionManager);
//                } catch (Exception e) {
//                    Log.e(TAG, "Exception caught while calling API " + e.getMessage());
//                }
                startActivity(new Intent(MainActivity.this, SubscriptionModuleList.class));
            } else if (action.equals("SUBSCRIPTION_EXPIRE")) {

                startActivity(new Intent(MainActivity.this, SubscriptionModuleList.class));
            } else if (action.equals("DOCUMENT_STATUS")) {
                startActivity(new Intent(MainActivity.this, PersonalDocumentActivity.class));
            } else if (action.equals("GENDER_UPDATE")) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            } else if (action.equals("")) {
            }

            dialog.dismiss();
        });


        dialog.show();
    }

    private void showDialogForShowOutStation(String message, ModelRideNotifications modelRideNotifications) {
        final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Setting dialogview
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
        dialog.setTitle(null);
        dialog.setCancelable(false);

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_open_event);

        TextView textView = (TextView) dialog.findViewById(R.id.tvMessage);
        textView.setText(message);
        Button btnOkay = (Button) dialog.findViewById(R.id.btnOkay);

        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                startActivity(new Intent(MainActivity.this, SpecificTripDetailsActivity.class)
                        .putExtra("" + IntentKeys.BOOKING_ID, "" + modelRideNotifications.getData().getBooking_id()));
                dialog.dismiss();
            }
        });


        dialog.show();
    }

    private void setMediaSound() throws Exception {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(this, Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.message_pops));
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_NOTIFICATION);
        mediaPlayer.prepare();
    }

    @SuppressLint("NewApi")
    public void startBackgroundTask() {

        //   startService(new Intent(MainActivity.this, TimeService.class));

        componentName = new ComponentName(getApplicationContext(), LocationUpdateService.class);
        JobInfo jobInfo = new JobInfo.Builder(1, componentName)
                .setPersisted(true)
                .setMinimumLatency(30000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY).setRequiresCharging(false).build();
        jobScheduler.schedule(jobInfo);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void stopBackgroundTask() {
        // stopService(new Intent(MainActivity.this, TimeService.class));
        jobScheduler.cancelAll();
    }

    public static void writeStringAsFile(Context context, final String fileContents, String fileName) {
        try {
            FileWriter out = new FileWriter(new File(context.getFilesDir(), fileName));
            out.write(fileContents);
            out.close();
        } catch (IOException e) {
            Log.e("Exception", "" + e);
        }
    }


    public static String readFileAsString(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(new File(context.getFilesDir(), fileName)));
            while ((line = in.readLine()) != null) stringBuilder.append(line);

        } catch (FileNotFoundException e) {
            Log.e("Exxception", "" + e);
        } catch (IOException e) {
            Log.e("Exception", "" + e);
        }

        return stringBuilder.toString();
    }

    private String loadAssetTextAsString(Context context, String name) {
        BufferedReader in = null;
        try {
            StringBuilder buf = new StringBuilder();
            InputStream is = context.getAssets().open(name);
            in = new BufferedReader(new InputStreamReader(is));

            String str;
            boolean isFirst = true;
            while ((str = in.readLine()) != null) {
                if (isFirst)
                    isFirst = false;
                else
                    buf.append('\n');
                buf.append(str);
            }
            return buf.toString();
        } catch (IOException e) {
            Log.e(TAG, "Error opening asset " + name);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Log.e(TAG, "Error closing asset " + name);
                }
            }
        }

        return null;
    }

    private void callApiForUpdateDriverLocation() {

        samLocationRequestService.executeService(location -> {
            EventBus.getDefault().post(new EventLocation(location));

            data.clear();
            data.put("latitude", "" + location.getLatitude());
            data.put("longitude", "" + location.getLongitude());
            data.put("bearing", "" + location.getBearing());
            data.put("accuracy", "" + location.getAccuracy());
            try {
                apiManager._postForTracking(API_S.Tags.DRIVER_LOCATION_UPDATER, API_S.Endpoints.DRIVER_LOCATION_UPDATER, data, sessionManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventSocketConnected event) {
        tvSocketConnection.setText(event.location);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventSocketConnectionState event) {
        socketAck.setText(event.connectoinstate);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventSendLocation event) {
        tvLocation.setText(event.connectoinstate);
    }

    public void startService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(new Intent(this, UpdateServiceClass.class));
        } else { // normal
            startService(new Intent(this, UpdateServiceClass.class));
        }
//        if (sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")) {
//
//        }
    }

    public void stopService() {
        stopService(new Intent(this, UpdateServiceClass.class));
    }

//    private void pushLogToServer() {
//        HyperLog.pushLogs(this, false, new HLCallback() {
//            @Override
//            public void onSuccess(@NonNull Object response) {
//                HyperLog.deleteLogs();
//                ApporioLog.LOG_DEBUG(TAG, " " + "Logs are pushed" + " " + response);
//            }
//
//            @Override
//            public void onError(@NonNull HLErrorResponse HLErrorResponse) {
//                ApporioLog.LOG_ERROR(TAG, " " + "Logs are not pushed error" + " " + HLErrorResponse.getErrorMessage());
//            }
//        });
//    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.click_back), Toast.LENGTH_SHORT).show();
    }



    private void setGoHomeAccordingly(){
        if (isGoingToHomeActive){
            sc_goto_home.setChecked(true);
            gotoHomeText.setTextColor(Color.parseColor("#2ecc71"));
        }else {
            sc_goto_home.setChecked(false);
            gotoHomeText.setTextColor(Color.parseColor("#e74c3c"));
        }
    }
}
