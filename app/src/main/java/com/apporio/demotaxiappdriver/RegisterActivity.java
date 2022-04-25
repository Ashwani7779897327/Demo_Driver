package com.apporio.demotaxiappdriver;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.activities.vehicleModule.SampleVehicleActivity;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelRegister;
import com.apporio.demotaxiappdriver.others.AppUtils;
import com.apporio.demotaxiappdriver.others.Cpf;
import com.apporio.demotaxiappdriver.others.ImageCompressMode;
import com.apporio.demotaxiappdriver.others.Mask;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.onesignal.OSPermissionSubscriptionState;
import com.onesignal.OneSignal;
import com.sampermissionutils.AfterPermissionGranted;
import com.sampermissionutils.EasyPermissions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker;
import com.nguyenhoanglam.imagepicker.model.Config;
import com.nguyenhoanglam.imagepicker.model.Image;
import com.theartofdev.edmodo.cropper.CropImage;

public class RegisterActivity extends BaseActivity implements ApiManager.APIFETCHER {

    private static final int FIREBASE_OTP_REQUEST_CODE = 1000;
    @Bind(R.id.ll_back_signup)
    LinearLayout ll_back_signup;
    @Bind(R.id.ll_register)
    CardView ll_register;
    @Bind(R.id.driver_image)
    CircleImageView driver_image;
    @Bind(R.id.edt_username_signup)
    EditText edt_username_signup;
    @Bind(R.id.edt_lastname_signup)
    EditText edt_lastname_signup;
    @Bind(R.id.edt_email_signup)
    EditText edt_email_signup;
    @Bind(R.id.txt_phone_signup)
    TextView txt_phone_signup;
    @Bind(R.id.edt_phone)
    EditText edt_phone;
    @Bind(R.id.edt_pass_signup)
    EditText edt_pass_signup;
    @Bind(R.id.edt__confpass_signup)
    EditText edt__confpass_signup;
    @Bind(R.id.area)
    TextView area;
    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.radio_group)
    RadioGroup radioGroup;
    @Bind(R.id.genderLayout)
    LinearLayout genderLayout;
    @Bind(R.id.pink_smoke)
    LinearLayout pink_smoke;
    @Bind(R.id.llShowSmokerLayout)
    LinearLayout llShowSmokerLayout;
    @Bind(R.id.smoker_radio_group)
    RadioGroup smoker_radio_group;
    @Bind(R.id.smk_radio)
    RadioButton smk_radio;
    @Bind(R.id.nonsmk_radio)
    RadioButton nonsmk_radio;
    @Bind(R.id.checkbox)
    CheckBox checkbox;
    @Bind(R.id.terms_and_conditions_checkbox)
    CheckBox terms_and_conition_checkbox;
    @Bind(R.id.terms_and_conditions_arrow)
    FrameLayout terms_and_condition_arrow;
    @Bind(R.id.terms_and_conditions_txt)
    TextView terms_and_condition_txt;
    @Bind(R.id.terms_and_conditions_layout)
    LinearLayout terms_and_condition_layout;
    @Bind(R.id.edt_referal)
    EditText edt_referal;
    @Bind(R.id.phone_layout)
    LinearLayout phone_ediiting;
    @Bind(R.id.phone_code)
    TextView phone_code;
    @Bind(R.id.edtCpfNumber)
    EditText edtCpfNumber;
    @Bind(R.id.llCpfNumber)
    LinearLayout llCpfNumber;
    @Bind(R.id.viewGender)
    View viewGender;
    @Bind(R.id.inputReferralCode)
    TextInputLayout inputReferralCode;
    int radioSelectedValue = -1;
    int radiosmokr = -1;
    OSPermissionSubscriptionState status;
    Uri selectedImage;
    Bitmap bitmap1;
    String imagePath = "";
    String imagePathCompressed = "";
    String Selected_Area = "";
    String SelectedPhoneNumber = "";
    String id;
    ProgressDialog pd;
    ApiManager apimanager;
    SessionManager sessionManager;
    private ContentValues values;
    private Bitmap thumbnail;
    private static final int CAMERS_PICKER = 122;
    private Uri imageUri;
    private int Selected_Country_position = 9999999;
    private static final int KEY_REGISTER = 110;
    private static final int RC_CAMERA_PERM = 123;

    private static int MAX_PHONE_LENGTH = 10;
    private static int MIN_PHONE_LENGTH = 6;
    @Bind(R.id.subscription_plan)
    TextView rd_subscreption_plan;
    String[] PERMISSIONS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
    private TextWatcher cpfMask;
    AlertDialog.Builder builderSingle;
    String DOCUMENT_IMAGE =  "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apimanager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        getSupportActionBar().hide();


        pd = new ProgressDialog(this);
        pd.setMessage(RegisterActivity.this.getResources().getString(R.string.loading));
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);


        status = OneSignal.getPermissionSubscriptionState();


        try {

            if (sessionManager.getAppConfig().getData().getRegister().isDriver_phone_otp()) {

                txt_phone_signup.setVisibility(View.VISIBLE);
                phone_ediiting.setVisibility(View.GONE);

            } else {

                txt_phone_signup.setVisibility(View.GONE);
                phone_ediiting.setVisibility(View.VISIBLE);
                Selected_Country_position = 0;
                setCountryCodeWithValidation(0);
            }
            if (sessionManager.getAppConfig().getData().getRegister().isDriver_email_otp()) {
                edt_email_signup.setFocusable(false);

            } else {

                edt_email_signup.setFocusable(true);

            }

            if (sessionManager.getAppConfig().getData().getGeneral_config().isReferral_code_mandatory_driver_signup()) {
                edt_referal.setHint(getResources().getString(R.string.enter_referral_code));
            } else {
                edt_referal.setHint(getResources().getString(R.string.enter_referral_code_if_any));
            }
        } catch (NullPointerException e) {

        }

        try {
            genderLayout.setVisibility(sessionManager.getAppConfig().getData().getRegister().isGender() ? View.VISIBLE : View.GONE);
            viewGender.setVisibility(sessionManager.getAppConfig().getData().getRegister().isGender() ? View.VISIBLE : View.GONE);
            llCpfNumber.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isDriver_cpf_number_enable() ? View.VISIBLE : View.GONE);
            //  edtCpfNumber.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isDriver_cpf_number_enable() ? View.VISIBLE : View.GONE);

            cpfMask = Mask.insert("###.###.###-##", edtCpfNumber);
            edtCpfNumber.addTextChangedListener(cpfMask);
        } catch (Exception e) {

        }

        try {
            pink_smoke.setVisibility(sessionManager.getAppConfig().getData().getRegister().isSmoker() ? View.VISIBLE : View.GONE);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (!AppUtils.hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
        } else {
        }

        rd_subscreption_plan.setVisibility(sessionManager.getAppConfig().getData().getRegister().isDriver_commission_choice() ? View.VISIBLE : View.GONE);

        terms_and_condition_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(RegisterActivity.this, TermsAndCondition.class));
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);

                // Add logic here

                switch (index) {
                    case 0: // first button
                        radioSelectedValue = 1;
                        break;
                    case 1: // secondbutton
                        radioSelectedValue = 2;
                        break;
                }
            }
        });

        if (sessionManager.getAppConfig().getData().getRegister().isSmoker()) {
            llShowSmokerLayout.setVisibility(View.VISIBLE);
        } else
            llShowSmokerLayout.setVisibility(View.GONE);


        smoker_radio_group.setOnCheckedChangeListener((radioGroup, i) -> {

            View smokr = smoker_radio_group.findViewById(i);
            int index = smoker_radio_group.indexOfChild(smokr);

            switch (index) {

                case 0:

                    radiosmokr = 1;
                    break;
                case 1:
                    radiosmokr = 2;
                    break;

            }

        });

        driver_image.setOnClickListener(view -> {
//            AlertDialog.Builder builderSingle = new AlertDialog.Builder(RegisterActivity.this);
//            builderSingle.setTitle(R.string.upload_photo);
//            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.select_dialog_singlechoice);
//            arrayAdapter.add("Camera");
//            arrayAdapter.add("Gallery");
//            builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            });
//            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    if (which == 0) {
//                        try {
//                            cameraTask();
//                        } catch (Exception e) {
//                        }
//                    } else if (which == 1) {
//                        Intent i1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                        i1.setType("image/*");
//                        startActivityForResult(i1, 101);
//                    }
//                    dialog.dismiss();
//                }
//            });
//            builderSingle.show();

            ImagePicker.with(RegisterActivity.this)                         //  Initialize ImagePicker with activity or fragment context
                    .setToolbarColor("#212121")         //  Toolbar color
                    .setStatusBarColor("#000000")       //  StatusBar color (works with SDK >= 21  )
                    .setToolbarTextColor("#FFFFFF")     //  Toolbar text color (Title and Done button)
                    .setToolbarIconColor("#FFFFFF")     //  Toolbar icon color (Back and Camera button)
                    .setProgressBarColor("#4CAF50")     //  ProgressBar color
                    .setBackgroundColor("#212121")      //  Background color
                    .setCameraOnly(false)               //  Camera mode
                    .setMultipleMode(false)              //  Select multiple images or single image
                    .setFolderMode(false)                //  Folder mode
                    .setShowCamera(true)                //  Show camera button
                    .setFolderTitle("album")           //  Folder title (works with FolderMode = true)
                    .setImageTitle("album")         //  Image title (works with FolderMode = false)
                    .setDoneTitle("done")               //  Done button title
                    .setLimitMessage("You have reached selection limit")    // Selection limit message
                    .setMaxSize(1)                     //  Max images can be selected
                    .setSavePath("ImagePicker")         //  Image capture folder name
                    .setAlwaysShowDoneButton(true)      //  Set always show done button in multiple mode
                    .setRequestCode(100)                //  Set request code, default Config.RC_PICK_IMAGES
                    .setKeepScreenOn(true)              //  Keep screen on when selecting images
                    .start();
        });


        area.setOnClickListener(view -> {
            if (Selected_Country_position == 9999999) {
                Toast.makeText(RegisterActivity.this, RegisterActivity.this.getResources().getString(R.string.please_enter_phone), Toast.LENGTH_SHORT).show();
            } else {

                if (sessionManager.getAppConfig().getData().getCountries().get(Selected_Country_position).getCountry_area().size() <= 0) {
                    Toast.makeText(RegisterActivity.this, R.string.no_cities_found_inselected_country, Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builderSingle = new AlertDialog.Builder(RegisterActivity.this);
                    builderSingle.setTitle(R.string.select_service);
                    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.select_dialog_singlechoice);
                    for (int i = 0; i < sessionManager.getAppConfig().getData().getCountries().get(Selected_Country_position).getCountry_area().size(); i++) {
                        arrayAdapter.add("" + sessionManager.getAppConfig().getData().getCountries().get(Selected_Country_position).getCountry_area().get(i).getAreaName());
                    }
                    builderSingle.setNegativeButton(RegisterActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builderSingle.setAdapter(arrayAdapter, (dialog, which) -> {
                        try {
                            int selected_counry_position = Integer.parseInt("" + Selected_Country_position);
                            area.setText("" + sessionManager.getAppConfig().getData().getCountries().get(selected_counry_position).getCountry_area().get(which).getAreaName());
                            Selected_Area = "" + sessionManager.getAppConfig().getData().getCountries().get(selected_counry_position).getCountry_area().get(which).getId();
                            dialog.dismiss();
                        } catch (Exception e) {
                            Toast.makeText(RegisterActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            //  Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                        }

                    });
                    builderSingle.show();
                }
            }
        });

        //subscrition


        rd_subscreption_plan.setOnClickListener(view -> {
            if (Selected_Country_position == 9999999) {
                Toast.makeText(RegisterActivity.this, RegisterActivity.this.getResources().getString(R.string.please_enter_phone), Toast.LENGTH_SHORT).show();
            } else {

                if (sessionManager.getAppConfig().getData().getDriver_commission_choices().size() <= 0) {
                    Toast.makeText(RegisterActivity.this, R.string.no_subscription_plan, Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builderSingle = new AlertDialog.Builder(RegisterActivity.this);
                    builderSingle.setTitle(R.string.select_service);
                    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.select_dialog_singlechoice);
                    for (int i = 0; i < sessionManager.getAppConfig().getData().getDriver_commission_choices().size(); i++) {
                        arrayAdapter.add("" + sessionManager.getAppConfig().getData().getDriver_commission_choices().get(i).getLang_data());
                    }
                    builderSingle.setNegativeButton(RegisterActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builderSingle.setAdapter(arrayAdapter, (dialog, which) -> {
                        try {

                            rd_subscreption_plan.setText("" + sessionManager.getAppConfig().getData().getDriver_commission_choices().get(which).getLang_data());
                            id = "" + sessionManager.getAppConfig().getData().getDriver_commission_choices().get(which).getId();
                            dialog.dismiss();
                        } catch (Exception e) {
                            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                        }

                    });
                    builderSingle.show();
                }
            }
        });

        terms_and_conition_checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (terms_and_conition_checkbox.isChecked()) {
                try {

                    ll_register.setEnabled(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(RegisterActivity.this, "" + getResources().getString(R.string.please_check), Toast.LENGTH_SHORT).show();

                //ll_register.setEnabled(false);
            }

        });


        txt_phone_signup.setOnClickListener(view -> {

            if (sessionManager.getAppConfig().getData().getGeneral_config().isOtp_from_firebase()) {
//                callFirebaseOtpMethod();
                startActivityForResult(new Intent(RegisterActivity.this, OTPVerifierActivity.class)
                        .putExtra("" + IntentKeys.VERIFIER_MODE, "FIREBASE")
                        .putExtra("" + IntentKeys.VERIFIER_TYPE, "" + OTPVerifierActivity.SIGNUP_VERIFIER),110);

            } else {
                startActivityForResult(new Intent(RegisterActivity.this, OTPVerifierActivity.class)
                        .putExtra("" + IntentKeys.VERIFIER_MODE, "PHONE")
                        .putExtra("" + IntentKeys.VERIFIER_TYPE, "" + OTPVerifierActivity.SIGNUP_VERIFIER), 110);

            }


        });

        if (sessionManager.getAppConfig().getData().getRegister().isDriver_email_otp()) {

            edt_email_signup.setOnClickListener(view -> startActivityForResult(new Intent(RegisterActivity.this, OTPVerifierActivity.class)
                    .putExtra("" + IntentKeys.VERIFIER_MODE, "EMAIL")
                    .putExtra("" + IntentKeys.VERIFIER_TYPE, "" + OTPVerifierActivity.SIGNUP_VERIFIER), 111));
        } else {
            edt_email_signup.setFocusable(true);
        }

        phone_code.setOnClickListener(view -> {

            builderSingle.show();
        });


        ll_register.setOnClickListener(v -> {

            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+.[a-z]+";

            if (DOCUMENT_IMAGE.equals("")) {
                Toast.makeText(RegisterActivity.this, R.string.please_upload_a_good_quality_image_for_your_profile, Toast.LENGTH_SHORT).show();
            } else if (edt_username_signup.getText().toString().trim().equals("")) {
                Toast.makeText(RegisterActivity.this, RegisterActivity.this.getResources().getString(R.string.please_enter_name), Toast.LENGTH_SHORT).show();
            } else if (!edt_email_signup.getText().toString().trim().matches(emailPattern) && sessionManager.getAppConfig().getData().getRegister().isEmail()) {
                edt_email_signup.setText("");
                Toast.makeText(getApplicationContext(), RegisterActivity.this.getResources().getString(R.string.please_enter_correct_email), Toast.LENGTH_SHORT).show();
            } else if (!edt_email_signup.getText().toString().trim().matches(emailPattern) && !sessionManager.getAppConfig().getData().getRegister().isEmail()) {
                edt_email_signup.setText("");
                Toast.makeText(getApplicationContext(), RegisterActivity.this.getResources().getString(R.string.please_enter_correct_email), Toast.LENGTH_SHORT).show();
            } else if (txt_phone_signup.getText().toString().trim().equals("") && sessionManager.getAppConfig().getData().getRegister().isDriver_phone_otp()) {
                Toast.makeText(RegisterActivity.this, RegisterActivity.this.getResources().getString(R.string.please_enter_phone), Toast.LENGTH_SHORT).show();
            } else if (edt_phone.getText().toString().isEmpty() && !sessionManager.getAppConfig().getData().getRegister().isDriver_phone_otp()) {
                Toast.makeText(RegisterActivity.this, RegisterActivity.this.getResources().getString(R.string.please_enter_phone), Toast.LENGTH_SHORT).show();
            } else if (!isValidPhoneNumber(edt_phone.getText().toString()) && !sessionManager.getAppConfig().getData().getRegister().isDriver_phone_otp()) {
                Toast.makeText(RegisterActivity.this, RegisterActivity.this.getResources().getString(R.string.valid_phone_number), Toast.LENGTH_SHORT).show();
            } else if (edt_pass_signup.getText().toString().trim().equals("")) {
                Toast.makeText(RegisterActivity.this, RegisterActivity.this.getResources().getString(R.string.please_enter_password), Toast.LENGTH_SHORT).show();
            } else if (edt_pass_signup.getText().toString().length() < 6) {
                Toast.makeText(this, getResources().getString(R.string.enter_correct_password), Toast.LENGTH_SHORT).show();
            } else if (edtCpfNumber.getText().toString().equals("") && sessionManager.getAppConfig().getData().getGeneral_config().isDriver_cpf_number_enable()) {
                Toast.makeText(RegisterActivity.this, "" + getString(R.string.please_enter_cpf_number), Toast.LENGTH_SHORT).show();
            } else if (!Cpf.isValid(edtCpfNumber.getText().toString()) && sessionManager.getAppConfig().getData().getGeneral_config().isDriver_cpf_number_enable()) {
                Toast.makeText(RegisterActivity.this, "" + getString(R.string.please_enter_cpf_number), Toast.LENGTH_SHORT).show();
            } else if (Selected_Area.equals("")) {
                Toast.makeText(RegisterActivity.this, R.string.select_area_of_your_service, Toast.LENGTH_SHORT).show();
            } /*else if (radiosmokr == 0 && sessionManager.getAppConfig().getData().getRegister().isSmoker()) {
                Toast.makeText(RegisterActivity.this, R.string.error_in_smoke, Toast.LENGTH_SHORT).show();
            } else if (sessionManager.getAppConfig().getData().getRegister().isGender() && radioSelectedValue == 0) {
                Toast.makeText(RegisterActivity.this, R.string.select_smoke_string, Toast.LENGTH_SHORT).show();
            }*/ else if (!terms_and_conition_checkbox.isChecked()) {
                Toast.makeText(RegisterActivity.this, "" + getResources().getString(R.string.please_check), Toast.LENGTH_SHORT).show();
                //     ll_register.setEnabled(false);
            } else if (edt_referal.getText().toString().equals("") && sessionManager.getAppConfig().getData().getGeneral_config().isReferral_code_mandatory_driver_signup()) {
                Toast.makeText(RegisterActivity.this, "" + getResources().getString(R.string.enter_referral_code), Toast.LENGTH_SHORT).show();
            } else if (edt__confpass_signup.getText().toString().equals(edt_pass_signup.getText().toString())) {
                HashMap<String, String> data = new HashMap<>();
                data.put("first_name", "" + edt_username_signup.getText().toString());
                data.put("last_name", "" + edt_lastname_signup.getText().toString());
                data.put("email", "" + edt_email_signup.getText().toString());
                data.put("password", "" + edt_pass_signup.getText().toString());
                data.put("player_id", "" + status.getSubscriptionStatus().getUserId());
                data.put("area", "" + Selected_Area);

                if (sessionManager.getAppConfig().getData().getRegister().isDriver_commission_choice()) {
                    data.put("driver_commission_type", "" + id);
                }
                if (sessionManager.getAppConfig().getData().getRegister().isGender()) {
                    data.put("driver_gender", "" + radioSelectedValue);
                }

                if (sessionManager.getAppConfig().getData().getGeneral_config().isDriver_cpf_number_enable()) {
                    data.put("driver_cpf_number", "" + edtCpfNumber.getText().toString());
                }


                if (sessionManager.getAppConfig().getData().getRegister().isDriver_phone_otp()) {
                    data.put("phone", "" + txt_phone_signup.getText().toString());
                } else {
                    data.put("phone", "" + phone_code.getText().toString() + edt_phone.getText().toString());
                }
                if (sessionManager.getAppConfig().getData().getRegister().isSmoker()) {
                    data.put("smoker_type", String.valueOf(radiosmokr));
                    data.put("allow_other_smoker", getPrefrenceSmoker());
                } else {

                }
                data.put("referral_code", "" + edt_referal.getText().toString());

                HashMap<String, File> images = new HashMap<>();
                images.put("image", new File(DOCUMENT_IMAGE));
                try {
                    apimanager._post_image_with_secreteonly(API_S.Tags.REGISTER_DRIVER, API_S.Endpoints.REGISTER_DRIVER, data, images);
                } catch (Exception e) {
                }

            }


//                 else if (radioSelectedValue == -1 && sessionManager.getAppConfig().getData().getRegister().isGender()) {
//                     Toast.makeText(RegisterActivity.this, R.string.please_select_gender, Toast.LENGTH_SHORT).show();
//                 }
//                 else if (radiosmokr == -1 && sessionManager.getAppConfig().getData().getRegister().isSmoker()) {
//                    Toast.makeText(RegisterActivity.this, R.string.error_in_smoke, Toast.LENGTH_SHORT).show();
//                }
            else {
                Toast.makeText(RegisterActivity.this, R.string.password_not_match, Toast.LENGTH_SHORT).show();
            }
        });

        ll_back_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

       builderSingle  = new AlertDialog.Builder(RegisterActivity.this);
        builderSingle.setTitle(R.string.select_country);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.select_dialog_singlechoice);
        for (int i = 0; i < sessionManager.getAppConfig().getData().getCountries().size(); i++) {
            arrayAdapter.add(sessionManager.getAppConfig().getData().getCountries().get(i).getPhonecode() + " " + sessionManager.getAppConfig().getData().getCountries().get(i).getName());
        }
        builderSingle.setNegativeButton(RegisterActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Selected_Country_position = which;
                Selected_Area = "";
                area.setText("" + getResources().getString(R.string.select_area));
                setCountryCodeWithValidation(which);
                dialog.dismiss();
            }
        });
    }

    private void setCountryCodeWithValidation(int selected_Country_position) {

        sessionManager.setCurrencyCode("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getIsoCode(), "" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getIsoCode());
        phone_code.setText("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getPhonecode());
        MAX_PHONE_LENGTH = Integer.parseInt("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getMaxNumPhone());
        MIN_PHONE_LENGTH = Integer.parseInt("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getMinNumPhone());
        edt_phone.setText("");
//        edt_phone_login.setFilters(new InputFilter[]{AppUtils.filter, new InputFilter.LengthFilter(MAX_PHONE_LENGTH)});

        setLoginMethodViaConfig();
    }

    @AfterPermissionGranted(RC_CAMERA_PERM)
    public void cameraTask() throws Exception {
//        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(cameraIntent, CAMERS_PICKER);

        if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
            try { // Have permission, do the thing!
                values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, "New Picture");
                values.put(MediaStore.Images.Media.DESCRIPTION, "From your Camera");
                imageUri = getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, CAMERS_PICKER);


            } catch (Exception e) {
            }
        } else {
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_camera), RC_CAMERA_PERM, Manifest.permission.CAMERA);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        try {
//            cameraTask();
//        } catch (Exception e) {
//        }
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
            if (APINAME.equals(API_S.Tags.REGISTER_DRIVER)) {
                ModelRegister modelRegister = SingletonGson.getInstance().fromJson("" + script, ModelRegister.class);

                sessionManager.createLoginSession(false,
                        "" + modelRegister.getData().getId()
                        ,""
                        , ""
                        , ""
                        , modelRegister.getData().getPhoneNumber()
                        , ""
                        , modelRegister.getData().getEmail()
                        , ""
                        , ""
                        , ""
                        , ""
                        , String.valueOf(modelRegister.getData().getCountry_area_id())
                        , String.valueOf(modelRegister.getData().getCreated_at())
                        , ""
                        , ""
                        , ""
                        , "1"
                        , ""
                        , ""
                        , modelRegister.getData().getPhoneNumber());

                startActivity(new Intent(RegisterActivity.this, SampleVehicleActivity.class)
                        .putExtra("documentScreenApi", "0")
                        .putExtra("" + IntentKeys.DRIVER_ID, "" + modelRegister.getData().getId())
                        .putExtra("" + IntentKeys.AREA_ID, "" + modelRegister.getData().getCountry_area_id()));


//                startActivity(new Intent(RegisterActivity.this, ChooseVehicleType.class)
//                        .putExtra("" + IntentKeys.DRIVER_ID, "" + modelRegister.getData().getId())
//                        .putExtra("" + IntentKeys.AREA_ID, "" + modelRegister.getData().getCountry_area_id()));

//                startActivity(new Intent(RegisterActivity.this, AddVehicleActivity.class)
//                        .putExtra("" + IntentKeys.DRIVER_ID, "" + modelRegister.getData().getId())
//                        .putExtra("" + IntentKeys.AREA_ID, "" + modelRegister.getData().getCountry_area_id()));
                SplashActivity.splash.finish();
                finish();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(this, "" + script, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {
                case Config.RC_PICK_IMAGES :
                    ArrayList<Image> images = data.getParcelableArrayListExtra(Config.EXTRA_IMAGES);
                    CropImage.activity(Uri.fromFile(new File("" + images.get(0).getPath()))).start(this);

                    break;

                case CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE :
                    CropImage.ActivityResult result = CropImage.getActivityResult(data);
                    if (resultCode == RESULT_OK) {
                        Uri resultUri = result.getUri();
                        comppressImageFile(resultUri);
                    } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                        Exception error = result.getError();
                    }
                    break;
                case 110:
                    area.setText("" + RegisterActivity.this.getResources().getString(R.string.select_area));
                    Selected_Area = "";
                    SelectedPhoneNumber = data.getExtras().getString("phone_number");
                    txt_phone_signup.setText(data.getExtras().getString("phone_number"));
                    Selected_Country_position = data.getExtras().getInt("position");
                    break;
                case 111:
                    edt_email_signup.setText(data.getExtras().getString("phone_number"));
                case 101:
                    selectedImage = data.getData();
                    imagePath = getPath(selectedImage);
                    ImageCompressMode imageCompressMode = new ImageCompressMode(this);
                    imagePathCompressed = imageCompressMode.compressImage(imagePath);
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();
                    // Set the Image in ImageView after decoding the String
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(filePath, options);
                    final int REQUIRED_SIZE = 300;
                    int scale = 1;
                    while (options.outWidth / scale / 2 >= REQUIRED_SIZE && options.outHeight / scale / 2 >= REQUIRED_SIZE)
                        scale *= 2;
                    options.inSampleSize = scale;
                    options.inJustDecodeBounds = false;
                    bitmap1 = BitmapFactory.decodeFile(filePath, options);
                    driver_image.setImageBitmap(bitmap1);
                    break;

                case CAMERS_PICKER:

//                    Bitmap bitmap;
//                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//                    bitmap = BitmapFactory.decodeFile(imageUri,
//                            bitmapOptions);
//                    driver_image.setImageBitmap(bitmap);

                    thumbnail = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                    driver_image.setImageBitmap(thumbnail);
                    imagePath = getRealPathFromURI(imageUri);

                    ExifInterface ei = new ExifInterface(imagePath);
                    int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                            ExifInterface.ORIENTATION_UNDEFINED);

                    Bitmap rotatedBitmap = null;
                    switch (orientation) {

                        case ExifInterface.ORIENTATION_ROTATE_90:
                            rotatedBitmap = rotateImage(thumbnail, 90);
                            driver_image.setImageBitmap(rotatedBitmap);
                            break;

                        case ExifInterface.ORIENTATION_ROTATE_180:
                            rotatedBitmap = rotateImage(thumbnail, 180);
                            driver_image.setImageBitmap(rotatedBitmap);
                            break;

                        case ExifInterface.ORIENTATION_ROTATE_270:
                            rotatedBitmap = rotateImage(thumbnail, 270);
                            driver_image.setImageBitmap(rotatedBitmap);
                            break;

                        case ExifInterface.ORIENTATION_NORMAL:
                            rotatedBitmap = thumbnail;
                            driver_image.setImageBitmap(rotatedBitmap);
                            break;
                        default:
                            rotatedBitmap = thumbnail;
                            driver_image.setImageBitmap(rotatedBitmap);
                    }

                    ImageCompressMode imageCompressModee = new ImageCompressMode(this);
                    imagePathCompressed = imageCompressModee.compressImage(imagePath);


//                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
//                            byte[] b = baos.toByteArray();
//                            String base64 = Base64.encodeToString(b, Base64.DEFAULT);
//
//                            b = Base64.decode(base64, Base64.DEFAULT);
//                            Bitmap decodedImage = BitmapFactory.decodeByteArray(b, 0, b.length);
//                            driver_image.setImageBitmap(decodedImage);

                    break;

                case FIREBASE_OTP_REQUEST_CODE:

                    IdpResponse response = IdpResponse.fromResultIntent(data);
                    if (resultCode == Activity.RESULT_OK) {
                        if (!FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().isEmpty()) {
                            String phoneNumber = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
                            txt_phone_signup.setText(phoneNumber);

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
                    break;
            }
        } catch (Exception e) {
        }
    }

    private void comppressImageFile(Uri uri ){
        Compressor.getDefault(this)
                .compressToFileAsObservable(new File(uri.getPath()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<File>() {
                    @Override
                    public void call(File file) {
                        try{
                            driver_image.setImageBitmap(AppUtils.handleSamplingAndRotationBitmap(RegisterActivity.this, file.getPath()));
                            DOCUMENT_IMAGE = file.getPath();
                        }catch (Exception e){
//                            showSnackbar(""+e.getMessage());
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        // showErrorDialoge("comppressImageFile()",""+throwable.getMessage());
                    }
                });
    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }


    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }


    protected String getPrefrenceSmoker() {
        CheckBox checkBox = findViewById(R.id.checkbox);

        if (checkBox.isChecked())
            return "1";
        else
            return "0";

    }


    protected void setLoginMethodViaConfig() {

        phone_code.setVisibility(View.VISIBLE);
        edt_phone.setHint(getResources().getString(R.string.LOGIn_ACTIVITY__phone));
        edt_phone.setInputType(InputType.TYPE_CLASS_NUMBER);
        edt_phone.setFilters(new InputFilter[]{AppUtils.filter, new InputFilter.LengthFilter(MAX_PHONE_LENGTH)});

//        if (sessionManager.getAppConfig().getData().getLogin().isEmail()) {
//            phone_code.setVisibility(View.INVISIBLE);
//            edt_phone.setHint(getResources().getString(R.string.please_enter_email));
//            edt_phone.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
//
//        } else {
//            phone_code.setVisibility(View.VISIBLE);
//            edt_phone.setHint(getResources().getString(R.string.LOGIn_ACTIVITY__phone));
//            edt_phone.setInputType(InputType.TYPE_CLASS_NUMBER);
//            edt_phone.setFilters(new InputFilter[]{AppUtils.filter, new InputFilter.LengthFilter(MAX_PHONE_LENGTH)});
//
//        }
    }

    public final static boolean isValidPhoneNumber(CharSequence target) {
        if (target == null || target.length() < MIN_PHONE_LENGTH || target.length() > MAX_PHONE_LENGTH) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(target).matches();
        }

    }

    private void callFirebaseOtpMethod() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build())).build(), FIREBASE_OTP_REQUEST_CODE);
    }
}