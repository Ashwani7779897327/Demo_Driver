package com.apporio.demotaxiappdriver;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.apporio.demotaxiappdriver.activities.demo.DemoActivity;
import com.apporio.demotaxiappdriver.activities.vehicleModule.SampleVehicleActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.LanguageManager;
import com.apporio.demotaxiappdriver.manager.ModelCountries;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelAppConfiguration;
import com.apporio.demotaxiappdriver.models.ModelDriverDetails;
import com.apporio.demotaxiappdriver.models.ModelLogin;
import com.apporio.demotaxiappdriver.models.register.Register;
import com.apporio.demotaxiappdriver.others.AppUtils;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ice.restring.Restring;
import com.onesignal.OneSignal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

// Hierarchy
// Check Permission --> Check GPS Connectivity --> Check Internet Connectivity --> fetch Remote Config --> Check Build variant --> Check Session Login Status --> Run Handler (2 sec )--> main Activity
public class SplashActivity extends BaseInternetCheckActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.register_btn)
    LinearLayout registerBtn;
    @Bind(R.id.login_btn)
    LinearLayout loginBtn;
    @Bind(R.id.LoginBox)
    LinearLayout LoginBox;
    //    @Bind(R.id.loading_text)
//    TextView loadingText;
    @Bind(R.id.demo_login)
    CardView demoLogin;
    @Bind(R.id.tvGettingYourLocation)
    TextView tvGettingYourLocation;

    private static final String TAG = "SplashActivity";
    @Bind(R.id.root)
    CoordinatorLayout root;
    private boolean is_gps_dialog_shown = false;
    private boolean is_internet_dialog_is_shown = false;
    private boolean is_version_dialog_is_shown = false;
    ApiManager apiManager;
    String[] PERMISSIONS = {};
    public static Activity splash;
    public static String app_version_name;
    SessionManager sessionManager;
    String appVersionName, PLAYER_ID;
    private ModelLogin modelLogin;
    public static ModelAppConfiguration modelAppConfiguration;
    ProgressDialog progressDialog;
    @Bind(R.id.splash_screen)
    ImageView splash_screen;
    String value;
    ObjectMapper mapper = new ObjectMapper();
    String vehicleId = "";
    int FLAG ;

//    static {
//        System.loadLibrary("native-lib");
//    }


//    public native String getAPIKey();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        apiManager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        setlanguage();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        splash = this;

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));

        new LanguageManager(this).createLanguageSession();

        try {
//            storeSecret();
            value = getIntent().getStringExtra("value");
        } catch (Exception e) { }


        if (!sessionManager.isAutoStartIsOn()) {
            openAppSettingInCaseOfXiomiPhone(Build.MANUFACTURER);
        }



//        if (!AppUtils.hasPermissions(this, PERMISSIONS)) {
//            Log.i(TAG, "Checking Permission On Splash");
//            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
//        } else {
//            startGPSCheck();
//        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            PERMISSIONS = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_BACKGROUND_LOCATION};
        }else {
            PERMISSIONS = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
        }

        if (!AppUtils.hasPermissions(SplashActivity.this, PERMISSIONS)) {

            FLAG = 1;
            infodialog();
        }
        else {
            startGPSCheck();
        }

        getAppVersionCode();


        OneSignal.idsAvailable((userId, registrationId) -> PLAYER_ID = userId);
        OneSignal.setSubscription(true);

        loginBtn.setOnClickListener(v -> {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        });


        registerBtn.setOnClickListener(v -> {
            startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        });


        demoLogin.setOnClickListener(view -> startActivity(new Intent(SplashActivity.this, DemoActivity.class)));

        //  setUpdateStringMethod();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        if (!AppUtils.checkGPSisOnOrNot(SplashActivity.this)) {
//            showGPSDialog();
//        } else {
//            Log.i(TAG, "Now GPS Status = " + true);
//            startInternetCheckProcess();
//        }

        if (FLAG == 1){
            if (!AppUtils.checkGPSisOnOrNot(SplashActivity.this)) {
                showGPSDialog();
            } else {
                Log.i(TAG, "Now GPS Status = " + true);
                startInternetCheckProcess();
            }
        }else {
            if (!AppUtils.hasPermissions(SplashActivity.this, PERMISSIONS)) {

                infodialog();
            }else {
                if (!AppUtils.checkGPSisOnOrNot(SplashActivity.this)) {
                    showGPSDialog();
                } else {
                    Log.i(TAG, "Now GPS Status = " + true);
                    startInternetCheckProcess();
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (!AppUtils.hasPermissions(this, PERMISSIONS)) {
//            Log.i(TAG, "Checking Permission On Splash");
//            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
//        } else {
//            startGPSCheck();
//        }

        if (modelAppConfiguration != null) {
            demoLogin.setVisibility(modelAppConfiguration.getData().getGeneral_config().isDemo() ? View.VISIBLE : View.GONE);
        }
    }

    public void infodialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setCancelable(false);
        builder.setTitle(""+getResources().getString(R.string.important_note));
        builder.setMessage(""+getResources().getString(R.string.info_content))
                .setPositiveButton(""+getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        OneSignal.startInit(SplashActivity.this)
                                .autoPromptLocation(true)
                                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                                .unsubscribeWhenNotificationsAreDisabled(true)
                                .init();

//                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                        SplashActivity.this.startActivity(myIntent);
//                        dialog.dismiss();
//                        is_gps_dialog_shown = false;

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if(!Settings.canDrawOverlays(SplashActivity.this)){
                                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                                startActivityForResult(intent, 181);
                            }
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
                            PERMISSIONS = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_BACKGROUND_LOCATION};
                        }else {
                            PERMISSIONS = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
                        }

                        if (!AppUtils.hasPermissions(SplashActivity.this, PERMISSIONS)) {
                            Log.i(TAG, "Checking Permission On Splash");
                            ActivityCompat.requestPermissions(SplashActivity.this, PERMISSIONS, 101);

                        } else {

                            startGPSCheck();
                        }
                    }
                });

        builder.create().show();
        // is_gps_dialog_shown = true;
    }



    private void getAppVersionCode() {

        PackageManager manager = getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(SplashActivity.this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        appVersionName = info.versionName;
        app_version_name = appVersionName;
    }

    private void showDemoUserDialog() {
        final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        dialog.setContentView(R.layout.demo_driver_dialog);
        dialog.setCancelable(false);

        final EditText demo_name = (EditText) dialog.findViewById(R.id.demo_name);
        final EditText demo_phone_email = (EditText) dialog.findViewById(R.id.demo_phone_email);

        dialog.findViewById(R.id.back_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        final HashMap<String, String> data = new HashMap<String, String>();
        data.put("unique_number", "" + Settings.Secure.getString(SplashActivity.this.getContentResolver(), Settings.Secure.ANDROID_ID));
        data.put("player_id", "" + PLAYER_ID);


        dialog.findViewById(R.id.skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();
                if (demo_phone_email.getText().toString().contains("@")) {
                    data.put("name", "" + demo_name.getText().toString());
                    data.put("email", "" + demo_phone_email.getText().toString());
                    data.put("phone", "");
                    try {
                        apiManager._post_with_secreteonly(API_S.Tags.DEMO_LOGIN, API_S.Endpoints.DEMO_LOGIN, data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    data.put("name", "" + demo_name.getText().toString());
                    data.put("email", "");
                    data.put("phone", "" + demo_phone_email.getText().toString());
                    try {
                        apiManager._post_with_secreteonly(API_S.Tags.DEMO_LOGIN, API_S.Endpoints.DEMO_LOGIN, data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.demo_ok_btn).setOnClickListener(v -> {

            progressDialog.show();
            if (demo_phone_email.getText().toString().contains("@")) {
                data.put("name", "" + demo_name.getText().toString());
                data.put("email", "" + demo_phone_email.getText().toString());
                data.put("phone", "");
                try {
                    apiManager._post_with_secreteonly(API_S.Tags.DEMO_LOGIN, API_S.Endpoints.DEMO_LOGIN, data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                data.put("name", "" + demo_name.getText().toString());
                data.put("email", "");
                data.put("phone", "" + demo_phone_email.getText().toString());
                try {
                    apiManager._post_with_secreteonly(API_S.Tags.DEMO_LOGIN, API_S.Endpoints.DEMO_LOGIN, data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            dialog.dismiss();
        });


        dialog.show();
    }

    private void startInternetCheckProcess() {
        Log.i(TAG, "Now Checking net Connectivity");
        if (AppUtils.isNetworkConnected(this)) {
            Log.i(TAG, "Internet Connectivity Status " + true);
            try {
                fetchRemoteConfig();
            } catch (Exception e) {
            }
        } else {
            // fetchRemoteConfigCache();
            Log.i(TAG, "Internet Connectivity Status " + false + ", Now Showing Internet Dialog");
            if (!is_internet_dialog_is_shown) {
                showInternetDialog();
            }
        }

    }

    private void fetchRemoteConfig() throws Exception {
        Log.i("" + TAG, "Started fetching Configurations");
        HashMap<String, String> data = new HashMap<>();
//        data.put("unique_no", "" + Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID));
//        data.put("player_id", PLAYER_ID);
//        data.put("c_lat", "latitude");
//        data.put("c_long", "longitude");
        data.put("device", "1"); // 1 for Android and 2 for IOS
        data.put("apk_version", BuildConfig.VERSION_NAME);
//        data.put("app_package_name", "" + BuildConfig.APPLICATION_ID);
//        data.put("language_code", "");
        apiManager._post_with_secreteonly(API_S.Tags.APP_CONFIGURATIONS, "" + API_S.Endpoints.APP_CONFIGURATIONS, data);
    }

    private void fetchRemoteConfigCache() throws Exception {
        Log.i("" + TAG, "Started fetching Configurations");
        HashMap<String, String> data = new HashMap<>();
//        data.put("unique_no", "" + Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID));
//        data.put("player_id", PLAYER_ID);
//        data.put("c_lat", "latitude");
//        data.put("c_long", "longitude");
        data.put("device", "1"); // 1 for Android and 2 for IOS
        data.put("apk_version", BuildConfig.VERSION_NAME);
//        data.put("app_package_name", "" + BuildConfig.APPLICATION_ID);
//        data.put("language_code", "");
        apiManager._postIfCached(API_S.Tags.APP_CONFIGURATIONS, "" + API_S.Endpoints.APP_CONFIGURATIONS, data);
    }


    private void startCheckingLoginProcedure() {

        if (sessionManager.getUserDetails().get(SessionManager.KEY_SIGNUP_STEP).equals("1")) {
            if (value == null || value.equals("0")) {
                LoginBox.setVisibility(View.VISIBLE);
//                startActivity(new Intent(SplashActivity.this, SampleVehicleActivity.class)
//                        .putExtra("documentScreenApi", "0")
//                        .putExtra("" + IntentKeys.DRIVER_ID, "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID))
//                        .putExtra("" + IntentKeys.AREA_ID, "" + sessionManager.getUserDetails().get(SessionManager.KEY_AREA_ID)));
//                tvGettingYourLocation.setVisibility(View.GONE);
//                finish();
            } else {
                LoginBox.setVisibility(View.VISIBLE);
            }
        } else if (sessionManager.getUserDetails().get(SessionManager.KEY_SIGNUP_STEP).equals("2")) {

            if (value == null || value.equals("0")) {
                LoginBox.setVisibility(View.VISIBLE);
//                startActivity(new Intent(SplashActivity.this, DocumentActivity.class)
//                        .putExtra("" + IntentKeys.DRIVER_ID, "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID))
//                        .putExtra("documentScreenApi", "0"));
//                tvGettingYourLocation.setVisibility(View.GONE);
//                finish();
            } else {
                LoginBox.setVisibility(View.VISIBLE);
            }

        } else {
            Log.i(TAG, "Checking login status in session");
            if (new SessionManager(this).isLoggedIn()) {
                Log.i(TAG, "Driver is logged in and now launching MainActivity");
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                tvGettingYourLocation.setVisibility(View.GONE);
                SplashActivity.splash.finish();
                finish();
            } else {
                Log.i(TAG, "Driver is not logged in and now launching Login Screen");
                LoginBox.setVisibility(View.VISIBLE);
            }

        }

    }

    private void setlanguage() {
        try {
            sessionManager.setLanguage(sessionManager.getLanguage() == null || sessionManager.getLanguage().equals("") ? "en" : sessionManager.getLanguage());

        } catch (Exception e) {
        }
    }

    public void showGPSDialog() {
        if (!is_gps_dialog_shown) {

            Log.i(TAG, "Now GPS Status = " + false + ", Now Showing Dialog");
            AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
            builder.setCancelable(false);
            builder.setTitle(R.string.enable_app_location);
            builder.setMessage(R.string.in_order_to_use_app_settings)
                    .setPositiveButton(R.string.open_location_settings, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            SplashActivity.this.startActivity(myIntent);
                            dialog.dismiss();
                            is_gps_dialog_shown = false;
                        }
                    })
                    .setNegativeButton(R.string.cancel, (dialog, id) -> {
                        // User cancelled the dialog
                    });
            builder.create().show();
            is_gps_dialog_shown = true;
        }

    }

    private void showInternetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setMessage(R.string.it_seems_you_are_out_of_internet_connection)
                .setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        is_internet_dialog_is_shown = false;
                        startInternetCheckProcess();
                    }
                })
                .setNegativeButton(R.string.cancel, (dialog, id) -> finish());
        builder.create().show();
        is_internet_dialog_is_shown = true;

    }

    private void showUpdationDialog(final boolean is_maindatory, String message) {
        try {
            if (!is_version_dialog_is_shown) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setMessage(message);
                dialog.setCancelable(false);
                dialog.setPositiveButton(R.string.ok, (paramDialogInterface, paramInt) -> {
                    is_version_dialog_is_shown = false;

                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                });

                if (!is_maindatory) {
                    dialog.setNegativeButton(R.string.do_it_later, (paramDialogInterface, paramInt) -> {
                        is_version_dialog_is_shown = false;
                        startCheckingLoginProcedure();
                    });
                }
                dialog.show();
                is_version_dialog_is_shown = true;
            }
        } catch (Exception e) {
        }
    }


    private void showAppmaintainanceDialog() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(R.string.your_app_is_in_maintainance);
        dialog.setCancelable(false);
        dialog.setPositiveButton(R.string.ok, (paramDialogInterface, paramInt) -> finish());
        dialog.show();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (AppUtils.hasPermissions(SplashActivity.this, PERMISSIONS)) {
                    startGPSCheck();
                } else {
                    Log.i("" + TAG, "Some Permissions are missing");
                }
                return;
            }
        }
    }

    private void startGPSCheck() {
        Log.i(TAG, "Checking GPS status");
        if (!AppUtils.checkGPSisOnOrNot(SplashActivity.this)) {
            showGPSDialog();
        } else {
            Log.i(TAG, "Now GPS Status = " + true);
            startInternetCheckProcess();
        }
    }




//    @Override
//    public void onFetchResultZero(String script) {

//        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
//        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
//        builder.setCancelable(false);
//        builder.setTitle(R.string.alert);
//        builder.setMessage(R.string.it_seems_no_proper_data_added_from_admin)
//                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        finish();
//                        if (!AppUtils.hasPermissions(SplashActivity.this, PERMISSIONS)) {
//                            Log.i(TAG, "Checking Permission On Splash");
//                            ActivityCompat.requestPermissions(SplashActivity.this, PERMISSIONS, 1);
//                        } else {
//                            startGPSCheck();
//                        }
//                    }
//                });
//        builder.create().show();


    private void createDriverSession(Register register) {
//        if (register.getDetails().getDetail_status().equals("1")) {
//            Toast.makeText(splash, "Document of driver not register", Toast.LENGTH_SHORT).show();
//        } else if (register.getDetails().getDetail_status().equals("2")) {
//            new SessionManager(this).createLoginSession(register.getDetails().getDriver_id(),
//                    register.getDetails().getDriver_name(), register.getDetails().getDriver_phone(),
//                    register.getDetails().getDriver_email(), register.getDetails().getDriver_image(),
//                    register.getDetails().getDriver_password(), register.getDetails().getDriver_token(),
//                    register.getDetails().getDevice_id(), Config.Devicetype, register.getDetails().getRating(),
//                    register.getDetails().getCar_type_id(), register.getDetails().getCar_model_id(),
//                    register.getDetails().getCar_number(), register.getDetails().getCity_id(),
//                    register.getDetails().getRegister_date(), register.getDetails().getLicense(),
//                    register.getDetails().getRc(), register.getDetails().getInsurance(), "other_doc", "getlast update", "last update date ",
//                    register.getDetails().getCompleted_rides(), register.getDetails().getReject_rides(),
//                    register.getDetails().getCancelled_rides(),
//                    register.getDetails().getLogin_logout(), register.getDetails().getBusy(),
//                    register.getDetails().getOnline_offline(), register.getDetails().getDetail_status(),
//                    register.getDetails().getDriver_admin_status(), register.getDetails().getCar_type_name(),
//                    register.getDetails().getCar_model_name(), "", "" + register.getDetails().getCity_name(),
//                    register.getDetails().getDriver_bank_name(), register.getDetails().getDriver_account_number(),
//                    register.getDetails().getDriver_account_name());
//
//            startActivity(new Intent(SplashActivity.this, MainActivity.class));
//            finish();
//        } else if (register.getDetails().getDetail_status().equals("3")) {
//            Toast.makeText(splash, "Driver Document not yet verified hence detail dtatus = 3", Toast.LENGTH_SHORT).show();
//        }
    }

    void openAppSettingInCaseOfXiomiPhone(String deviceManufacturer) {
        String xiaomi = "Xiaomi";
        final String CALC_PACKAGE_NAME = "com.miui.securitycenter";
        final String CALC_PACKAGE_ACITIVITY = "com.miui.permcenter.autostart.AutoStartManagementActivity";
        if (deviceManufacturer.equalsIgnoreCase(xiaomi)) {

            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage(R.string.in_order_to_get_request_in_background);
            dialog.setCancelable(false);
            dialog.setPositiveButton(R.string.ok, (paramDialogInterface, paramInt) -> {
                try {
//                    Intent intent = new Intent();
//                    intent.setComponent(new ComponentName(CALC_PACKAGE_NAME, CALC_PACKAGE_ACITIVITY));
//                    startActivity(intent);

                    Intent intent = new Intent();
                    String manufacturer = android.os.Build.MANUFACTURER;
                    if ("xiaomi".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                    } else if ("oppo".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
                    } else if ("vivo".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
                    } else if ("Letv".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
                    } else if ("Honor".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
                    }

                    sessionManager.turnOnAutoStart(true);
                    startActivity(intent);
                    List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                    if (list.size() > 0) {

                    }

                } catch (ActivityNotFoundException e) {
                    Log.e("MainActivity", "Failed to launch AutoStart Screen ", e);
                } catch (Exception e) {
                    Log.e("mainActivity", "Failed to launch AutoStart Screen ", e);
                }
            }).show();
        }
    }


    private void showInstructionsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setCancelable(false);
        builder.setTitle("For Demo Testing");
        builder.setMessage("Make Sure you logged as Demo in User app as well.")
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        showDemoUserDialog();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(R.string.cancel, (dialog, id) -> {
                    // User cancelled the dialog
                });

        builder.create().show();
    }

    private void setUpdateStringMethod() {
        String val = "[\n" +
                "  {\n" +
                "    \"type\": \"es\",\n" +
                "    \"value\": {\n" +
                "      \"demand_spot\": \"La demanda \\n del punto\",\n" +
                "      \"past\": \"Past\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"type\": \"fr\",\n" +
                "    \"value\": {\n" +
                "     \"on_going_trips\": \"Active french\",\n" +
                "      \"past\": \"Past french\"\n" +
                "    }\n" +
                "  }\n" +
                "]";
        try {
            JSONArray obj = new JSONArray(val);
            Log.e("**", obj.length() + "");

            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj1 = new JSONObject(obj.get(i) + "");
                Map<String, String> stringmap = mapper.readValue(obj1.get("value") + "", new TypeReference<Map<String, String>>() {
                });
                //Restring.setStrings("" + sessionManager.getLanguage(), stringmap);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        Locale myLocale = new Locale("" + new SessionManager(newBase).getLanguage());
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        newBase.getResources().updateConfiguration(config, newBase.getResources().getDisplayMetrics());
        super.attachBaseContext(newBase);
    }

//    private void storeSecret() {
//
//        if (sessionManager.getAppSecret() == null) {
//            byte[] data = Base64.decode(getAPIKey(), Base64.DEFAULT);
//            try {
//                sessionManager.setAppSecret(new String(data, "UTF-8"));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }




    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            //  loadingText.setText(R.string.fetching_versions);
        } else {
            //  loadingText.setText(R.string.checking_new_versions);
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

        switch (APINAME) {
            case API_S.Tags.DEMO_LOGIN:
                modelLogin = SingletonGson.getInstance().fromJson("" + script, ModelLogin.class);
                sessionManager.setAccessToken("" + modelLogin.getData().getAccess_token());
                try {
                    apiManager._post(API_S.Tags.DRIVER_DETAILS, API_S.Endpoints.DRIVER_DETAILS, null, sessionManager);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case API_S.Tags.DRIVER_DETAILS:
                progressDialog.hide();
                ModelDriverDetails modelDriverDetails = SingletonGson.getInstance().fromJson("" + script, ModelDriverDetails.class);

                try {
                    if (modelDriverDetails.getData().getDriverVehicle().size() > 0) {
                        vehicleId = String.valueOf(modelDriverDetails.getData().getDriverVehicle().get(0).getId());
                    } else {
                        vehicleId = "";
                    }
                } catch (Exception e) {

                }

                if (modelDriverDetails.getData().getSignupStep().equals("1")) { // basic registration is done open add car screen
                    startActivity(new Intent(SplashActivity.this, AddVehicleActivity.class)
                            .putExtra("" + IntentKeys.DRIVER_ID, "" + modelDriverDetails.getData().getId())
                            .putExtra("" + IntentKeys.AREA_ID, "" + modelDriverDetails.getData().getCountry_area_id()));
                    // SplashActivity.splash.finish();
                }
                if (modelDriverDetails.getData().getSignupStep().equals("2")) { // documents not uploaded or all are verified
                    startActivity(new Intent(SplashActivity.this, DocumentActivity.class)
                            .putExtra("" + IntentKeys.DRIVER_ID, "" + modelDriverDetails.getData().getId())
                            .putExtra("documentScreenApi", "0")
                            .putExtra("" + IntentKeys.DRIVER_ID, "" + modelDriverDetails.getData().getId())
                            .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + modelDriverDetails.getData().getDriverVehicle().get(0).getId()));
                    //  SplashActivity.splash.finish();
                    finish();
                }
                if (modelDriverDetails.getData().getSignupStep().equals("3")) { // all things are set and ready to go
                    sessionManager.createLoginSession(true, "" + modelDriverDetails.getData().getId()
                            , "" + vehicleId
                            , modelDriverDetails.getData().getFirst_name()
                            , modelDriverDetails.getData().getLast_name()
                            , modelDriverDetails.getData().getPhoneNumber()
                            , modelDriverDetails.getData().getPhone_code()
                            , modelDriverDetails.getData().getEmail()
                            , String.valueOf(modelDriverDetails.getData().getDriver_gender())
                            , String.valueOf(modelDriverDetails.getData().getSmoker_type())
                            , String.valueOf(modelDriverDetails.getData().getAllow_other_smoker())
                            , modelDriverDetails.getData().getProfile_image()
                            , String.valueOf(modelDriverDetails.getData().getCountry_area_id())
                            , modelDriverDetails.getData().getCreated_at()
                            , String.valueOf(modelDriverDetails.getData().getLogin_logout())
                            , String.valueOf(modelDriverDetails.getData().getFree_busy())
                            , String.valueOf(modelDriverDetails.getData().getOnline_offline())
                            , "3"
                            , ""
                            , modelDriverDetails.getData().getAuto_accept_enable()
                            , modelDriverDetails.getData().getSubscription_wise_commission());
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    tvGettingYourLocation.setVisibility(View.GONE);
                    SplashActivity.splash.finish();
                    finish();
                }
                break;
            case API_S.Tags.SET_STRING:
                try {

                    ModelUpdateString modelUpdateString = SingletonGson.getInstance().fromJson("" + script, ModelUpdateString.class);

                    sessionManager.setUpdatedStringVersion(modelUpdateString.getLatest_version());
                    JSONObject obj = new JSONObject(script + "");


                    Map<String, String> stringmap = mapper.readValue(obj.get("data") + "", new TypeReference<Map<String, String>>() {
                    });
                    //Restring.setStrings("" + obj.get("locale"), stringmap);


                    try {
                        //Log.e("Demo", modelAppConfiguration.getData().getDemo());
                        if (modelAppConfiguration != null) {
                            demoLogin.setVisibility(modelAppConfiguration.getData().getGeneral_config().isDemo() ? View.VISIBLE : View.GONE);
                        }
                    } catch (Exception e) {

                    }

                    if (modelAppConfiguration != null) {
                        if (modelAppConfiguration.getData().getApp_version_dialog().isShow_dialog()) { // show dialog here
                            showUpdationDialog(modelAppConfiguration.getData().getApp_version_dialog().isMandatory(), modelAppConfiguration.getData().getApp_version_dialog().getDialog_message());
                        } else if (modelAppConfiguration.getData().getApp_maintainance().isShow_dialog()) {
                            showAppmaintainanceDialog();
                        } else {
                            startCheckingLoginProcedure();
                        }
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case API_S.Tags.APP_CONFIGURATIONS:
                modelAppConfiguration = SingletonGson.getInstance().fromJson("" + script, ModelAppConfiguration.class);
                sessionManager.setAppConfig("" + script);

                tvGettingYourLocation.setVisibility(View.GONE);

                HashMap<String, String> data = new HashMap<>();
                data.put("version", sessionManager.getUpdateStringVersion()); // 1 for Android and 2 for IOS
                data.put("loc", sessionManager.getLanguage());
                data.put("platform", "android");
                data.put("app", "DRIVER");

                try {
                    apiManager._post_with_secreteonly(API_S.Tags.SET_STRING, "" + API_S.Endpoints.SET_STRING, data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        switch (APINAME) {
            case API_S.Tags.APP_CONFIGURATIONS:

                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setCancelable(false);
                builder.setTitle(R.string.alert);
                builder.setMessage(R.string.it_seems_no_proper_data_added_from_admin)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                if (!AppUtils.hasPermissions(SplashActivity.this, PERMISSIONS)) {
                                    Log.i(TAG, "Checking Permission On Splash");
                                    ActivityCompat.requestPermissions(SplashActivity.this, PERMISSIONS, 1);
                                } else {
                                    startGPSCheck();
                                }
                            }
                        });
                builder.create().show();
                break;

            case API_S.Tags.SET_STRING:

                if (modelAppConfiguration != null) {
                    try {
                        //Log.e("Demo", modelAppConfiguration.getData().getDemo());
                        demoLogin.setVisibility(modelAppConfiguration.getData().getGeneral_config().isDemo() ? View.VISIBLE : View.GONE);

                    } catch (Exception e) {

                    }
                    if (modelAppConfiguration.getData().getApp_version_dialog().isShow_dialog()) { // show dialog here
                        showUpdationDialog(modelAppConfiguration.getData().getApp_version_dialog().isMandatory(), modelAppConfiguration.getData().getApp_version_dialog().getDialog_message());
                    } else if (modelAppConfiguration.getData().getApp_maintainance().isShow_dialog()) {
                        showAppmaintainanceDialog();
                    } else {
                        startCheckingLoginProcedure();
                    }
                }


                break;


        }

    }






}
