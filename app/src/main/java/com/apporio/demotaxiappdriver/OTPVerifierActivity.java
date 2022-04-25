package com.apporio.demotaxiappdriver;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelOTPVerifier;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;


public class OTPVerifierActivity extends BaseActivity implements ApiManager.APIFETCHER {

    ApiManager apiManager;
    GsonBuilder gsonBuilder;
    private final String TAG = "OTPVerifierActivity";
    private ModelOTPVerifier modelOTPVerifier = null;

    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.country_id)
    TextView country_id;
    @Bind(R.id.edt_enter_phone)
    EditText phone_number;
    @Bind(R.id.generate_otp)
    Button generate_otp;
    @Bind(R.id.edit_verify_otp)
    EditText otp_input;
    @Bind(R.id.otp_register)
    LinearLayout submit_otp_layout;
    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.phone_layout)
    CardView phoneLayout;
    @Bind(R.id.reenter_button)
    TextView reenterButton;
    @Bind(R.id.otp_layout)
    CardView otpLayout;
    private int country_idd;
    @Bind(R.id.otp_phone)
    LinearLayout otp_phone;
    @Bind(R.id.email_layout)
    LinearLayout email_layout;
    @Bind(R.id.edt_email)
    EditText edt_email;
    @Bind(R.id.otp_text)
    TextView otp_text;
    @Bind(R.id.tvOtpHeading)
    TextView tvOtpHeading;
    AlertDialog.Builder builderSingle;

    SessionManager sessionManager;
    ProgressDialog pd;
    private int Selected_Country_position;
    String input_OTP, otp, input_number, code, VERIFIER_TYPE = "", VERIFIER_MODE;
    public static String SIGNUP_VERIFIER = "1";
    public static String FORGOT_VERIFIER = "2";

    private FirebaseAuth mAuth;
    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gsonBuilder = new GsonBuilder();
        apiManager = new ApiManager(this, this);
        sessionManager = new SessionManager(OTPVerifierActivity.this);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_verify__otp);
        ButterKnife.bind(this);

        //progress bar
        pd = new ProgressDialog(this);
        pd.setMessage(OTPVerifierActivity.this.getResources().getString(R.string.loading));
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);

        VERIFIER_MODE = getIntent().getExtras().getString("" + IntentKeys.VERIFIER_MODE);

        if (VERIFIER_MODE.equals("EMAIL")) {
            otp_text.setText(R.string.verify_email);
            otp_phone.setVisibility(View.GONE);
            email_layout.setVisibility(View.VISIBLE);
            reenterButton.setText(getResources().getString(R.string.re_enter_email));
            tvOtpHeading.setText(getResources().getString(R.string.LOGIN_TEXT_verify_email));
        } else {
            otp_text.setText(R.string.verify_your_phone_number);
            email_layout.setVisibility(View.GONE);
            otp_phone.setVisibility(View.VISIBLE);
            reenterButton.setText(getResources().getString(R.string.re_enter_phone));
            tvOtpHeading.setText(getResources().getString(R.string.LOGIN_TEXT_verify));
        }


        if (VERIFIER_MODE.equalsIgnoreCase("FIREBASE")) {
            mAuth = FirebaseAuth.getInstance();
        }


        try {
            VERIFIER_TYPE = getIntent().getExtras().getString("" + IntentKeys.VERIFIER_TYPE);
            country_idd = sessionManager.getAppConfig().getData().getCountries().get(0).getId();
            sessionManager.setcountryid(country_idd);
        } catch (Exception e) {
            Toast.makeText(this, "No Purpose defined for OTP", Toast.LENGTH_SHORT).show();
            Log.d("" + TAG, "Exception caught while fetch intent " + e.getMessage());
        }

        setCountryCodeWithValidation(0);

        back.setOnClickListener(view -> finish());

        showTypeLayout(1);


        reenterButton.setOnClickListener(view -> {
            showTypeLayout(1);
            modelOTPVerifier = null;
        });

        country_id.setOnClickListener(view -> {

            builderSingle.show();
        });


        submit_otp_layout.setOnClickListener(v -> {
//                input_OTP = otp_input.getText().toString().trim();
//
//                if (input_OTP.equals("")) {
//                    Toast.makeText(OTPVerifierActivity.this, R.string.required_field_empty, Toast.LENGTH_SHORT).show();
//                } else if (!otp_input.getText().toString().equals(modelOTPVerifier.getData().getOtp())) {
//                    Toast.makeText(OTPVerifierActivity.this, R.string.invalid_otp, Toast.LENGTH_SHORT).show();
//                } else {
//                    Intent intent = new Intent();
//                    intent.putExtra("phone_number", country_id.getText().toString() + input_number);
//                    intent.putExtra("position", Selected_Country_position);
//                    setResult(Activity.RESULT_OK, intent);
//                    finish();
//                }

            if (VERIFIER_MODE.equalsIgnoreCase("FIREBASE")) {
                input_OTP = otp_input.getText().toString().trim();
                if (input_OTP.equals("")) {
                    Toast.makeText(OTPVerifierActivity.this, R.string.valid_otp, Toast.LENGTH_SHORT).show();
                } else {
                    verifyCode(otp_input.getText().toString());
                }
            } else {
                input_OTP = otp_input.getText().toString().trim();
                if (input_OTP.equals("")) {
                    Toast.makeText(OTPVerifierActivity.this, R.string.valid_otp, Toast.LENGTH_SHORT).show();
                } else if (!otp_input.getText().toString().equals(modelOTPVerifier.getData().getOtp())) {
                    Toast.makeText(OTPVerifierActivity.this, R.string.invalid_otp, Toast.LENGTH_SHORT).show();
                } else {
                    if (VERIFIER_TYPE.equals(FORGOT_VERIFIER)) {

                        if (VERIFIER_MODE.equals("PHONE")) {

                            startActivity(new Intent(OTPVerifierActivity.this, UpdatePasswordActivity.class)
                                    .putExtra("" + IntentKeys.VERIFIER_MODE, VERIFIER_MODE)
                                    .putExtra("" + IntentKeys.PHONE, country_id.getText().toString() + "" + phone_number.getText().toString()));

                        } else {

                            startActivity(new Intent(OTPVerifierActivity.this, UpdatePasswordActivity.class).putExtra("" + IntentKeys.EMAIL, edt_email.getText().toString()));

                        }
                        finish();
                    } else {
                        Intent intent = new Intent();
                        if (VERIFIER_MODE.equals("EMAIL")) {
                            intent.putExtra("phone_number", edt_email.getText().toString());
                        } else {
                            intent.putExtra("phone_number", country_id.getText().toString() + input_number);
                        }
                        intent.putExtra("position", Selected_Country_position);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    }

                }
            }
        });


        generate_otp.setOnClickListener(v -> {

            input_number = phone_number.getText().toString().trim();
            code = "" + country_id.getText().toString();

            if (VERIFIER_MODE.equals("PHONE")) {
                if (input_number.length() < Integer.parseInt("" + sessionManager.getAppConfig().getData().getCountries().get(Selected_Country_position).getMinNumPhone())) {
                    Toast.makeText(OTPVerifierActivity.this, R.string.valid_phone_number, Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("type", "" + VERIFIER_TYPE);
                    data.put("for", "PHONE");
                    data.put("user_name", country_id.getText().toString() + "" + phone_number.getText().toString());

                    try {
                        apiManager._post_with_secreteonly("" + API_S.Tags.OTP, "" + API_S.Endpoints.OTP, data);
                    } catch (Exception e) {
                        Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }

                }

            } else if (VERIFIER_MODE.equalsIgnoreCase("FIREBASE")) {
                Log.e("***Firebase sent number", "" + country_id.getText().toString() + "" + phone_number.getText().toString());
                sendVerificationCode(country_id.getText().toString() + "" + phone_number.getText().toString());
            } else {
                if (edt_email.getText().toString().equals("")) {
                    Toast.makeText(OTPVerifierActivity.this, R.string.enter_valid_email, Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("type", "" + VERIFIER_TYPE);
                    data.put("for", "EMAIL");
                    data.put("user_name", edt_email.getText().toString());
                    try {
                        apiManager._post_with_secreteonly("" + API_S.Tags.OTP, "" + API_S.Endpoints.OTP, data);
                    } catch (Exception e) {
                        Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }
                }
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        builderSingle = new AlertDialog.Builder(OTPVerifierActivity.this);
        builderSingle.setTitle(R.string.select_country);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(OTPVerifierActivity.this, android.R.layout.select_dialog_singlechoice);
        for (int i = 0; i < sessionManager.getAppConfig().getData().getCountries().size(); i++) {
            arrayAdapter.add(sessionManager.getAppConfig().getData().getCountries().get(i).getPhonecode() + " " + sessionManager.getAppConfig().getData().getCountries().get(i).getName());
        }
        builderSingle.setNegativeButton(OTPVerifierActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                phone_number.setText("");
//                        country_id.setText("" + sessionManager.getAppConfig().getData().getCountries().get(which).getPhonecode());
                country_idd = country_idd = sessionManager.getAppConfig().getData().getCountries().get(which).getId();
                sessionManager.setcountryid(country_idd);
                setCountryCodeWithValidation(which);
                Selected_Country_position = which;
                dialog.dismiss();
            }
        });
    }

    private void sendVerificationCode(String number) {
        pd.show();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );

    }


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            pd.hide();
            verificationId = s;

            showTypeLayout(2);

        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            pd.hide();
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            pd.hide();
            Toast.makeText(OTPVerifierActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };


    //verify code with firebase
    private void verifyCode(String code) {
        pd.show();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithCredential(credential);
    }

    // navigate after match code
    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        pd.hide();

                        if (VERIFIER_TYPE.equals(FORGOT_VERIFIER)) {
                            startActivity(new Intent(OTPVerifierActivity.this, UpdatePasswordActivity.class)
                                    .putExtra("" + IntentKeys.VERIFIER_MODE, VERIFIER_MODE)
                                    .putExtra("" + IntentKeys.PHONE, country_id.getText().toString() + "" + phone_number.getText().toString()));

                            finish();
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("phone_number", country_id.getText().toString() + input_number);
                            intent.putExtra("position", Selected_Country_position);
                            setResult(Activity.RESULT_OK, intent);
                            finish();
                        }
                    } else {
                        pd.hide();
                        Toast.makeText(OTPVerifierActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }


    private void setCountryCodeWithValidation(int position) {

        try {
            sessionManager.setCurrencyCode("" + sessionManager.getAppConfig().getData().getCountries().get(position).getIsoCode(), "" + sessionManager.getAppConfig().getData().getCountries().get(position).getIsoCode());
            country_id.setText("" + sessionManager.getAppConfig().getData().getCountries().get(position).getPhonecode());

            int maxLength = Integer.parseInt("" + sessionManager.getAppConfig().getData().getCountries().get(position).getMaxNumPhone());
            InputFilter[] FilterArray = new InputFilter[1];
            FilterArray[0] = new InputFilter.LengthFilter(maxLength);
            phone_number.setFilters(FilterArray);
        } catch (Exception e) {
            Snackbar.make(root, "No Country Added", Snackbar.LENGTH_SHORT).show();
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
            modelOTPVerifier = SingletonGson.getInstance().fromJson("" + script, ModelOTPVerifier.class);
            Toast.makeText(this, "" + modelOTPVerifier.getMessage(), Toast.LENGTH_SHORT).show();
            showTypeLayout(2);
            if (modelOTPVerifier.getData().isAuto_fill()) {
                otp_input.setText("" + modelOTPVerifier.getData().getOtp());
            }
        } catch (Exception e) {
            Log.d("" + TAG, "Exception caught while parsing " + e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(this, "" + script, Toast.LENGTH_SHORT).show();
    }


    private void showTypeLayout(int type) {
        if (type == 1) {
            phoneLayout.setVisibility(View.VISIBLE);
            otpLayout.setVisibility(View.GONE);
        } else if (type == 2) {
            phoneLayout.setVisibility(View.GONE);
            otpLayout.setVisibility(View.VISIBLE);
        }
    }

}

