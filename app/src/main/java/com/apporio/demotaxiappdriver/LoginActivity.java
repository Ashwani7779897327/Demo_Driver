package com.apporio.demotaxiappdriver;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.apporio.demotaxiappdriver.activities.vehicleModule.SampleVehicleActivity;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelDriverDetails;
import com.apporio.demotaxiappdriver.models.ModelLogin;
import com.apporio.demotaxiappdriver.models.ModelOTPVerifier;
import com.apporio.demotaxiappdriver.others.AppUtils;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.onesignal.OSPermissionSubscriptionState;
import com.onesignal.OneSignal;

import java.util.Arrays;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements ApiManager.APIFETCHER {

    private static final int FIREBASE_OTP_REQUEST_CODE = 1000;
    public static Activity loginactivity1;
    ProgressDialog pd;
    SessionManager sessionManager;
    ApiManager apiManager;
    private String TAG = "LoginActivity";
    private ModelLogin modelLogin;
    OSPermissionSubscriptionState status;
    private int MAX_PHONE_LENGTH = 10;

    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.ll_back_login)
    LinearLayout ll_back_login;
    @Bind(R.id.phone_code)
    TextView phone_code;
    @Bind(R.id.edt_phone_login)
    EditText edt_phone_login;
    @Bind(R.id.phone_layout)
    LinearLayout phone_layout;
    @Bind(R.id.edt_pass_login)
    EditText edt_pass_login;
    @Bind(R.id.tv_forgot)
    TextView tv_forgot;
    @Bind(R.id.ll_login)
    CardView ll_login;
    private String phoneNumber = "";
    AlertDialog.Builder builderSingle1;


    String vehicleId="";

    String[] PERMISSIONS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this, this);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        loginactivity1 = this;

        pd = new ProgressDialog(this);
        pd.setMessage("" + this.getResources().getString(R.string.loading));

        status = OneSignal.getPermissionSubscriptionState();
        if (status == null) {
            showPlayerIdNullDialog();
        }

        setCountryCodeWithValidation(0);

        // btnDemo.setVisibility(sessionManager.getAppConfig().getData().get.equals("1") ? View.VISIBLE : View.GONE);


        ll_back_login.setOnClickListener(v -> finish());

        phone_code.setOnClickListener(view -> {

            builderSingle1.show();
        });




        ll_login.setOnClickListener(v -> {
            if (edt_phone_login.getText().toString().equals("") || edt_pass_login.getText().toString().equals("")) {
                Toast.makeText(LoginActivity.this, "Required Field missing", Toast.LENGTH_SHORT).show();
            } else {
                HashMap<String, String> data = new HashMap<>();
                if (sessionManager.getAppConfig().getData().getLogin().isEmail()) {
                    data.put("phone", "" + edt_phone_login.getText().toString());

                } else {
                    data.put("phone", "" + phone_code.getText().toString() + edt_phone_login.getText().toString());

                }
                data.put("password", "" + edt_pass_login.getText().toString());
                data.put("player_id", "" + status.getSubscriptionStatus().getUserId());
                try {
                    apiManager._post_with_secreteonly(API_S.Tags.LOGIN, API_S.Endpoints.LOGIN, data);
                } catch (Exception e) {
                    Log.d(TAG, "Exception Caught while calling login method " + e.getMessage());
                }

            }
        });

        tv_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sessionManager.getAppConfig().getData().getLogin().isEmail()) {
                    startActivity(new Intent(LoginActivity.this, OTPVerifierActivity.class)
                            .putExtra("" + IntentKeys.VERIFIER_MODE, "EMAIL")
                            .putExtra("" + IntentKeys.VERIFIER_TYPE, "" + OTPVerifierActivity.FORGOT_VERIFIER));
                } else {
                    if (sessionManager.getAppConfig().getData().getGeneral_config().isOtp_from_firebase()) {
                        startActivity(new Intent(LoginActivity.this, OTPVerifierActivity.class)
                                .putExtra("" + IntentKeys.VERIFIER_MODE, "FIREBASE")
                                .putExtra("" + IntentKeys.VERIFIER_TYPE, "" + OTPVerifierActivity.FORGOT_VERIFIER));
                    } else {
                        startActivity(new Intent(LoginActivity.this, OTPVerifierActivity.class)
                                .putExtra("" + IntentKeys.VERIFIER_MODE, "PHONE")
                                .putExtra("" + IntentKeys.VERIFIER_TYPE, "" + OTPVerifierActivity.FORGOT_VERIFIER));
                    }

                }

            }
        });

        if (!AppUtils.hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
        } else {
        }

    }

    // load country code data  in dialoge box
    @Override
    protected void onResume() {
        super.onResume();

        builderSingle1 = new AlertDialog.Builder(LoginActivity.this);
        builderSingle1.setTitle(R.string.select_country);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(LoginActivity.this, android.R.layout.select_dialog_singlechoice);
        for (int i = 0; i < sessionManager.getAppConfig().getData().getCountries().size(); i++) {
            arrayAdapter.add(sessionManager.getAppConfig().getData().getCountries().get(i).getPhonecode() + " " + sessionManager.getAppConfig().getData().getCountries().get(i).getName());
        }
        builderSingle1.setNegativeButton(LoginActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builderSingle1.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setCountryCodeWithValidation(which);
                dialog.dismiss();
            }
        });
    }

    private void setCountryCodeWithValidation(int selected_Country_position) {

        sessionManager.setCurrencyCode("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getIsoCode(), "" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getIsoCode());
        phone_code.setText("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getPhonecode());
        MAX_PHONE_LENGTH = Integer.parseInt("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getMaxNumPhone());
        edt_phone_login.setText("");
//        edt_phone_login.setFilters(new InputFilter[]{AppUtils.filter, new InputFilter.LengthFilter(MAX_PHONE_LENGTH)});

        sessionManager.setDistanceUnit(sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getDistance_unit());
        setLoginMethodViaConfig();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (AppUtils.hasPermissions(LoginActivity.this, PERMISSIONS)) {

                } else {
                    Log.i("" + TAG, "Some Permissions are missing");
                }
                return;
            }
        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            pd.show();
        }
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STOPPED) {
            pd.dismiss();
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            switch (APINAME) {
                case API_S.Tags.LOGIN:
                    modelLogin = SingletonGson.getInstance().fromJson("" + script, ModelLogin.class);
                    sessionManager.setAccessToken("" + modelLogin.getData().getAccess_token());
                    try {
                        sessionManager.setTaxiCompany(modelLogin.getData().isTaxi_company());
                    }catch (Exception e){

                    }
                    apiManager._post(API_S.Tags.DRIVER_DETAILS, API_S.Endpoints.DRIVER_DETAILS, null, sessionManager);
                    break;

                case API_S.Tags.DRIVER_DETAILS:
                    ModelDriverDetails modelDriverDetails = SingletonGson.getInstance().fromJson("" + script, ModelDriverDetails.class);

                    sessionManager.setcountryid(Integer.parseInt(modelDriverDetails.getData().getCountry_id()));
                    sessionManager.setDemoOrNot("2");
                    try{
                        if(modelDriverDetails.getData().getDriverVehicle().size()>0){
                            vehicleId = String.valueOf(modelDriverDetails.getData().getDriverVehicle().get(0).getId());
                            sessionManager.setVehicleId(vehicleId);
                        }else{
                            vehicleId = "";
                        }
                    }catch(Exception e){

                    }

                    if (modelDriverDetails.getData().getSignupStep().equals("1")) { // basic registration is done open add car screen

                        sessionManager.createLoginSession(false, "" + modelDriverDetails.getData().getId()
                                ,""+vehicleId
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
                                , String.valueOf(modelDriverDetails.getData().getCreated_at())
                                , String.valueOf(modelDriverDetails.getData().getLogin_logout())
                                , String.valueOf(modelDriverDetails.getData().getFree_busy())
                                , String.valueOf(modelDriverDetails.getData().getOnline_offline())
                                , modelDriverDetails.getData().getSignupStep()
                                , modelDriverDetails.getData().getAuto_accept_enable()
                                , modelDriverDetails.getData().getSubscription_wise_commission()
                                , "");
                        startActivity(new Intent(LoginActivity.this, SampleVehicleActivity.class)
                                .putExtra("documentScreenApi", "0")
                                .putExtra("" + IntentKeys.DRIVER_ID, "" + modelDriverDetails.getData().getId())
                                .putExtra("" + IntentKeys.AREA_ID, "" + modelDriverDetails.getData().getCountry_area_id()));
                        SplashActivity.splash.finish();
                    }
                    if (modelDriverDetails.getData().getSignupStep().equals("2")) { // documents not uploaded or all are verified

                        sessionManager.createLoginSession(false, "" + modelDriverDetails.getData().getId()
                                ,""+vehicleId
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
                                , String.valueOf(modelDriverDetails.getData().getCreated_at())
                                , String.valueOf(modelDriverDetails.getData().getLogin_logout())
                                , String.valueOf(modelDriverDetails.getData().getFree_busy())
                                , String.valueOf(modelDriverDetails.getData().getOnline_offline())
                                , modelDriverDetails.getData().getSignupStep()
                                , modelDriverDetails.getData().getAuto_accept_enable()
                                , ""
                                , modelDriverDetails.getData().getSubscription_wise_commission());
                        if (modelDriverDetails.getData().getDriverVehicle().size() > 0) {
                            startActivity(new Intent(LoginActivity.this, DocumentActivity.class)
                                    .putExtra("documentScreenApi", "0")
                                    .putExtra("" + IntentKeys.DRIVER_ID, "" + modelDriverDetails.getData().getId())
                                    .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + modelDriverDetails.getData().getDriverVehicle().get(0).getId()));
                            SplashActivity.splash.finish();
                            finish();
                        } else {
                            startActivity(new Intent(LoginActivity.this, DocumentActivity.class)
                                    .putExtra("documentScreenApi", "0")
                                    .putExtra("" + IntentKeys.DRIVER_ID, "" + modelDriverDetails.getData().getId())
                                    .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + "0"));
                            SplashActivity.splash.finish();
                            finish();
                        }

                    }
                    if (modelDriverDetails.getData().getSignupStep().equals("3")) { // all things are set and ready to go
                        sessionManager.createLoginSession(true, "" + modelDriverDetails.getData().getId()
                                ,""+vehicleId
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
                                , String.valueOf(modelDriverDetails.getData().getCreated_at())
                                , String.valueOf(modelDriverDetails.getData().getLogin_logout())
                                , String.valueOf(modelDriverDetails.getData().getFree_busy())
                                , String.valueOf(modelDriverDetails.getData().getOnline_offline())
                                , modelDriverDetails.getData().getSignupStep()
                                , modelDriverDetails.getData().getAuto_accept_enable()
                                , modelDriverDetails.getData().getSubscription_wise_commission(),
                                modelDriverDetails.getData().getPhoneNumber());
                        startActivity(new Intent(LoginActivity.this, MainActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        SplashActivity.splash.finish();
                        finish();
                    }
                    break;

                case API_S.Tags.OTP:
                    ModelOTPVerifier modelOTPVerifier = SingletonGson.getInstance().fromJson("" + script, ModelOTPVerifier.class);
                    if (modelOTPVerifier.getResult().equalsIgnoreCase("1")) {
                        startActivity(new Intent(LoginActivity.this, UpdatePasswordActivity.class)
                                .putExtra("" + IntentKeys.VERIFIER_MODE, "PHONE")
                                .putExtra("" + IntentKeys.PHONE, phoneNumber));
                    }
                    break;
            }

        } catch (Exception e) {
            Log.d("" + TAG, "Exception caught while parsing in login " + e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(LoginActivity.this, "" + script, Toast.LENGTH_SHORT).show();
    }

    private void showPlayerIdNullDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setCancelable(false);
        builder.setMessage(R.string.it_seems_you_are_out_of_internet_connection)
                .setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        startActivity(new Intent(LoginActivity.this, SplashActivity.class));
                        finish();
                    }
                });
        builder.create().show();


    }

    protected void setLoginMethodViaConfig() {

        if (sessionManager.getAppConfig().getData().getLogin().isEmail()) {
            phone_code.setVisibility(View.INVISIBLE);
            edt_phone_login.setHint(getResources().getString(R.string.please_enter_email));
            edt_phone_login.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        } else {
            phone_code.setVisibility(View.VISIBLE);
            edt_phone_login.setHint(getResources().getString(R.string.LOGIn_ACTIVITY__phone));
            edt_phone_login.setInputType(InputType.TYPE_CLASS_NUMBER);
            edt_phone_login.setFilters(new InputFilter[]{AppUtils.filter, new InputFilter.LengthFilter(MAX_PHONE_LENGTH)});

        }
    }

    private void callFirebaseOtpMethod() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build())).build(), FIREBASE_OTP_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FIREBASE_OTP_REQUEST_CODE) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == Activity.RESULT_OK) {
                if (!FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().isEmpty()) {
                    phoneNumber = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();

                    HashMap<String, String> data1 = new HashMap<>();
                    data1.put("type", "" + OTPVerifierActivity.FORGOT_VERIFIER);
                    data1.put("for", "PHONE");
                    data1.put("user_name", phoneNumber);

                    try {
                        apiManager._post_with_secreteonly("" + API_S.Tags.OTP, "" + API_S.Endpoints.OTP, data1);
                    } catch (Exception e) {
                        Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }

                    return;

                } else {
                    if (response == null) {
                        Toast.makeText(this, getResources().getString(R.string.signinfailed_string), Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                        Toast.makeText(this, getResources().getString(R.string.nonetwork_string), Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                        Toast.makeText(this, getResources().getString(R.string.unkown_error_string), Toast.LENGTH_SHORT).show();

                        return;
                    }
                }
            }
        }
    }
}
