package com.apporio.demotaxiappdriver;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.apporio.demotaxiappdriver.location.UpdateServiceClass;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;

import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.activities.ExpiryModule.ExpiryDocumentActivity;
import com.apporio.demotaxiappdriver.activities.subscriptionModule.SubscriptionModuleList;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelDriverDetails;
import com.apporio.demotaxiappdriver.models.ModelEditProfile;
import com.apporio.demotaxiappdriver.others.AppUtils;
import com.apporio.demotaxiappdriver.others.ImageCompressMode;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.bumptech.glide.Glide;
import com.sampermissionutils.AfterPermissionGranted;
import com.sampermissionutils.EasyPermissions;

import java.io.File;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.driver_image)
    CircleImageView driverImage;
    @Bind(R.id.driver_name)
    TextView driverName;
    @Bind(R.id.driver_email)
    TextView driverEmail;
    @Bind(R.id.driver_phone)
    TextView driverPhone;
    @Bind(R.id.change_password)
    LinearLayout changePassword;
    @Bind(R.id.change_bank_details)
    LinearLayout changeBankDetails;
    @Bind(R.id.change_home_address)
    LinearLayout changeHomeAddress;
    @Bind(R.id.llSubscription)
    LinearLayout llSubscription;
    @Bind(R.id.logout)
    LinearLayout logout;
    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.manage_personal_doc)
    LinearLayout managePersonalDoc;
    @Bind(R.id.edit)
    TextView edit;
    @Bind(R.id.total_rides)
    TextView totalRides;
    @Bind(R.id.total_rating)
    TextView totalRating;
    @Bind(R.id.total_earning)
    TextView totalEarning;
    @Bind(R.id.some_doc_expire_text)
    TextView someDocExpireText;
    TextView phone_code;
    @Bind(R.id.emergency_contacts)
    LinearLayout emergency_contacts;

    EditText editting_phone;
    String SelectedPhoneNumber = "";
    String id;
    AlertDialog.Builder builderSingle;

    String vehicleId = "";
    private AlertDialog.Builder builder;
    ImageView circular_image;
    private final String TAG = "ProfileActivity";
    private SessionManager sessionManager;
    private ApiManager apiManager;
    private ProgressDialog progressDialog;
    private static final int RC_CAMERA_PERM = 123;
    private static final int CAMERS_PICKER = 122;
    Uri selectedImage;
    Bitmap bitmap1;
    String imagePath = "", imagePathCompressed = "";
    private ContentValues values;
    private Uri imageUri;
    private Bitmap thumbnail;
    private DialogInterface di;
    private ModelDriverDetails modelDriverDetails;
    int radioSelectedValue;
    int radioSelectedForSmoker;
    int checkedAllowSmoker;
    EditText edt_phone, edt_email;
    private int MAX_PHONE_LENGTH = 10;
    String commision_type = "";

    String ifsc_placeholder, ifsc_visibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(this.getResources().getString(R.string.loading));
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this, this);
        back.setOnClickListener((View view) -> {
            finish();
        });


        setProfileData();


        logout.setOnClickListener((View view) -> {
            AlertDialog.Builder builder_alert = new AlertDialog.Builder(ProfileActivity.this);
            builder_alert.setCancelable(false);
            builder_alert.setTitle(R.string.PROFILE_ACTIVITY__logout);
            builder_alert.setMessage(R.string.are_you_sure_to_log_out)
                    .setPositiveButton(R.string.ok, (dialog, id) -> {
                        try {
                            apiManager._post("" + API_S.Tags.LOGOUT, "" + API_S.Endpoints.LOGOUT, null, sessionManager);
                        } catch (Exception e) {
                            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                        }
                    })
                    .setNegativeButton(R.string.cancel, (dialog, id) -> {
                        // User cancelled the dialog
                    });
            builder_alert.create().show();
        });

        changeHomeAddress.setOnClickListener((View view) -> {
            startActivity(new Intent(ProfileActivity.this, HomeAddressActivity.class)
                    .putExtra("" + IntentKeys.HOME_LOCATION_ACTIVE_STATUS, "" + modelDriverDetails.getData().getHome_location_active())
                    .putExtra("" + IntentKeys.ADDRESS, "" + modelDriverDetails.getData().getSelected_address()));
        });

        changePassword.setOnClickListener((View view) -> {
            startActivity(new Intent(ProfileActivity.this, ChangePasswordActivity.class));
        });

        managePersonalDoc.setOnClickListener((View view) -> {

            startActivity(new Intent(ProfileActivity.this, PersonalDocumentActivity.class));
        });
        changeBankDetails.setOnClickListener((View view) -> {

            try {
                if (modelDriverDetails.getData().getAccount_holder_name() == null) {
                    Toast.makeText(this, "efrfrecr", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(ProfileActivity.this, BankDetailsActivity.class)
                            .putExtra("" + IntentKeys.BANK_NAME, "" + modelDriverDetails.getData().getBank_name())
                            .putExtra("" + IntentKeys.IFSC_VISIBILITY, "" + ifsc_visibility)
                            .putExtra("" + IntentKeys.IFSC_PLACEHOLDER, "" + ifsc_placeholder)
                            .putExtra("" + IntentKeys.IFSC_CODE, "" + modelDriverDetails.getData().getOnline_code())
                            .putExtra("" + IntentKeys.BANK_HOLDER_NAME, "" + modelDriverDetails.getData().getAccount_holder_name())
                            .putExtra("" + IntentKeys.BANK_ACCOUNT_NUMBER, "" + modelDriverDetails.getData().getAccount_number()));
                }
            } catch (Exception e) {

            }
        });

        llSubscription.setOnClickListener(v -> startActivity(new Intent(ProfileActivity.this, SubscriptionModuleList.class)));


        emergency_contacts.setOnClickListener(v -> startActivity(new Intent(ProfileActivity.this, EmergencyContatcsActivity.class)));


        edit.setOnClickListener((View view) -> {
            builder = new AlertDialog.Builder(ProfileActivity.this);
            LayoutInflater inflater = ProfileActivity.this.getLayoutInflater();

            View v = inflater.inflate(R.layout.dialog_eidt_basic_profile, null);
            circular_image = v.findViewById(R.id.image);
            EditText edt_name = v.findViewById(R.id.edt_name);
            EditText edt_last_name = v.findViewById(R.id.edt_last_name);
            edt_email = v.findViewById(R.id.edt_email);
            edt_phone = v.findViewById(R.id.edt_phone);
            LinearLayout change_phone = v.findViewById(R.id.chnage_phone);
            RadioGroup radioGroup = v.findViewById(R.id.radio_group);
            RadioButton radio1 = v.findViewById(R.id.radio1);
            RadioButton radio2 = v.findViewById(R.id.radio2);
            RadioGroup smoker_radio_group = v.findViewById(R.id.smoker_radio_group);
            RadioButton smk_radio = v.findViewById(R.id.smk_radio);
            RadioButton nonsmk_radio = v.findViewById(R.id.nonsmk_radio);
            LinearLayout genderLayout = v.findViewById(R.id.genderLayout);
            LinearLayout smokerLayout = v.findViewById(R.id.smokerLayout);
            LinearLayout llAllowSmoke = v.findViewById(R.id.llAllowSmoke);
            LinearLayout email_chnage = v.findViewById(R.id.email_change);
            CheckBox checkBox = v.findViewById(R.id.checkbox);
            LinearLayout phone_layout = v.findViewById(R.id.phone_layout);
            phone_code = v.findViewById(R.id.phone_code);
            editting_phone = v.findViewById(R.id.editting_phone);
            TextView subscription_plan = v.findViewById(R.id.subscription_plan);


            builder.setCancelable(false);

            if (sessionManager.getAppConfig().getData().getRegister().isDriver_phone_otp()) {

                phone_layout.setVisibility(View.GONE);
            } else {

                phone_layout.setVisibility(View.VISIBLE);
                change_phone.setVisibility(View.GONE);

            }


            if (!sessionManager.getTaxiCompany()) {
                subscription_plan.setVisibility(sessionManager.getAppConfig().getData().getRegister().isDriver_commission_choice() ? View.VISIBLE : View.GONE);
            } else {
                subscription_plan.setVisibility(View.GONE);
            }


            if (sessionManager.getAppConfig().getData().getGeneral_config().isEmergency_contact()) {

                emergency_contacts.setVisibility(View.VISIBLE);

            } else {

                emergency_contacts.setVisibility(View.GONE);
            }

            setCountryCodeWithValidation(0);


            phone_code.setOnClickListener(view14 -> builderSingle.show());


            //subscription module


            subscription_plan.setOnClickListener(view1 -> {

                if (sessionManager.getAppConfig().getData().getDriver_commission_choices().size() <= 0) {
                    Toast.makeText(ProfileActivity.this, R.string.no_subscription_plan, Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builderSingle = new AlertDialog.Builder(ProfileActivity.this);
                    builderSingle.setTitle(R.string.select_service);
                    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ProfileActivity.this, android.R.layout.select_dialog_singlechoice);
                    for (int i = 0; i < sessionManager.getAppConfig().getData().getDriver_commission_choices().size(); i++) {
                        arrayAdapter.add("" + sessionManager.getAppConfig().getData().getDriver_commission_choices().get(i).getLang_data());
                    }
                    builderSingle.setNegativeButton(ProfileActivity.this.getResources().getString(R.string.cancel), (dialog, which) -> dialog.dismiss());
                    builderSingle.setAdapter(arrayAdapter, (dialog, which) -> {
                        try {

                            subscription_plan.setText("" + sessionManager.getAppConfig().getData().getDriver_commission_choices().get(which).getLang_data());
                            commision_type = "" + sessionManager.getAppConfig().getData().getDriver_commission_choices().get(which).getId();
                            dialog.dismiss();
                        } catch (Exception e) {
                            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                        }

                    });
                    builderSingle.show();
                    builderSingle.show();
                }

            });


            if (sessionManager.getAppConfig().getData().getLogin().isPhone()) {

                edt_email.setFocusable(true);

                if (sessionManager.getAppConfig().getData().getGeneral_config().isOtp_from_firebase()) {
                    change_phone.setOnClickListener(view12 -> startActivityForResult(new Intent(ProfileActivity.this, OTPVerifierActivity.class)
                            .putExtra("" + IntentKeys.VERIFIER_MODE, "FIREBASE")
                            .putExtra("" + IntentKeys.VERIFIER_TYPE, "" + OTPVerifierActivity.SIGNUP_VERIFIER), 110));
                } else {
                    change_phone.setOnClickListener(view12 -> startActivityForResult(new Intent(ProfileActivity.this, OTPVerifierActivity.class)
                            .putExtra("" + IntentKeys.VERIFIER_MODE, "PHONE")
                            .putExtra("" + IntentKeys.VERIFIER_TYPE, "" + OTPVerifierActivity.SIGNUP_VERIFIER), 110));
                }


            } else {

                edt_email.setFocusable(false);

                email_chnage.setOnClickListener(view13 -> startActivityForResult(new Intent(ProfileActivity.this, OTPVerifierActivity.class)
                        .putExtra("" + IntentKeys.VERIFIER_MODE, "EMAIL")
                        .putExtra("" + IntentKeys.VERIFIER_TYPE, "" + OTPVerifierActivity.SIGNUP_VERIFIER), 111));

            }

            try {
                genderLayout.setVisibility(sessionManager.getAppConfig().getData().getRegister().isGender() ? View.VISIBLE : View.GONE);
                smokerLayout.setVisibility(sessionManager.getAppConfig().getData().getRegister().isSmoker() ? View.VISIBLE : View.GONE);
                llAllowSmoke.setVisibility(sessionManager.getAppConfig().getData().getRegister().isSmoker() ? View.VISIBLE : View.GONE);
            } catch (Exception e) {

            }

            Glide.with(ProfileActivity.this).load("" + sessionManager.getUserDetails().get(SessionManager.KEY_DriverImage)).into(circular_image);
            edt_name.setText("" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_NAME));
            edt_last_name.setText("" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_LAST_NAME));
            edt_email.setText("" + sessionManager.getUserDetails().get(SessionManager.KEY_DriverEmail));
            edt_phone.setText("" + (sessionManager.getUserDetails().get(SessionManager.KEY_PHONE_CODE) + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_PHONE)));
            phone_code.setText("" + sessionManager.getUserDetails().get(SessionManager.KEY_PHONE_CODE));
            editting_phone.setText("" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_PHONE));

            // radio1.setChecked(sessionManager.getUserDetails().get(SessionManager.KEY_DriverGender).equals("1"));
            //  radio2.setChecked(sessionManager.getUserDetails().get(SessionManager.KEY_DriverGender).equals("2"));

//            smk_radio.setChecked(sessionManager.getUserDetails().get(SessionManager.KEY_DriverSmokerType).equals("1"));
//            nonsmk_radio.setChecked(sessionManager.getUserDetails().get(SessionManager.KEY_DriverSmokerType).equals("2"));

            checkBox.setChecked(sessionManager.getUserDetails().get(SessionManager.KEY_DriverSmokerAllow).equals("1"));

            if (sessionManager.getUserDetails().get(SessionManager.KEY_DriverGender).equals("1")) {
                radioSelectedValue = 1;
                radio1.setChecked(true);
            } else {
                radioSelectedValue = 2;
                radio2.setChecked(true);
            }

            if (sessionManager.getUserDetails().get(SessionManager.KEY_DriverSmokerType).equals("1")) {
                radioSelectedForSmoker = 1;
                smk_radio.setChecked(true);
            } else {
                radioSelectedForSmoker = 2;
                nonsmk_radio.setChecked(true);
            }

            if (sessionManager.getAppConfig().getData().getDriver_commission_choices().size() > 0) {

                if (sessionManager.getUserDetails().get(SessionManager.KEY_SUBSCRIPTION).equals("1")) {

                    subscription_plan.setText("" + sessionManager.getAppConfig().getData().getDriver_commission_choices().get(0).getLang_data());

                } else {
                    subscription_plan.setText("" + sessionManager.getAppConfig().getData().getDriver_commission_choices().get(1).getLang_data());
                }

            }

            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {

                if (isChecked) {
                    checkedAllowSmoker = 1;
                } else {
                    checkedAllowSmoker = 0;
                }

            });
            radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

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
            });

            smoker_radio_group.setOnCheckedChangeListener((group, checkedId) -> {

                View radioButton = smoker_radio_group.findViewById(checkedId);
                int index = smoker_radio_group.indexOfChild(radioButton);

                // Add logic here

                switch (index) {
                    case 0: // first button
                        radioSelectedForSmoker = 1;
                        break;
                    case 1: // secondbutton
                        radioSelectedForSmoker = 2;
                        break;
                }
            });

            circular_image.setOnClickListener((View vieew) -> {
                String[] arr = {"Camera", "Gallery"};
                AlertDialog.Builder dg = new AlertDialog.Builder(ProfileActivity.this);
                dg.setTitle(R.string.upload_photo)
                        .setItems(arr, (dialog, which) -> {
                            if (which == 0) {
                                try {
                                    cameraTask();
                                } catch (Exception e) {
                                }
                            } else if (which == 1) {
                                Intent i1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                i1.setType("image/*");
                                startActivityForResult(i1, 101);
                            }
                            dialog.dismiss();
                        });
                dg.create().show();
            });


            builder.setView(v)
                    .setPositiveButton(R.string.save, (DialogInterface dialog, int id) -> {
                        di = dialog;

                        try {

                            /*if (!edt_phone.getText().toString().equals(MAX_PHONE_LENGTH)){
//                                edt_phone.setError("valid phone no");
                                Toast.makeText(builder.getContext(),getResources().getText(R.string.valid_phone_number), Toast.LENGTH_SHORT).show();
                                return;
                            }*/

                            HashMap<String, String> data = new HashMap<>();
                            data.put("first_name", "" + edt_name.getText().toString());
                            data.put("last_name", "" + edt_last_name.getText().toString());
                            data.put("email", "" + edt_email.getText().toString());
                            data.put("driver_gender", "" + radioSelectedValue);
                            data.put("smoker_type", "" + radioSelectedForSmoker);
                            data.put("allow_other_smoker", "" + checkedAllowSmoker);
                            data.put("driver_commission_type", "" + commision_type);


                            if (sessionManager.getAppConfig().getData().getRegister().isDriver_phone_otp()) {
                                data.put("phone", "" + edt_phone.getText().toString());
                            } else {
                                data.put("phone", "" + phone_code.getText().toString() + editting_phone.getText().toString());
                            }

                            HashMap<String, File> data_image = new HashMap<>();
                            data_image.put("profile_image", new File(imagePathCompressed));


                            if (imagePathCompressed.equals("")) {
                                apiManager._post(API_S.Tags.EDIT_PROFILE, API_S.Endpoints.EDIT_PROFILE, data, sessionManager);
                            } else {
                                apiManager._post_image(API_S.Tags.EDIT_PROFILE, API_S.Endpoints.EDIT_PROFILE, data, data_image, sessionManager);

                            }

                        } catch (Exception e) {
                            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                        }

                    })
                    .setNegativeButton(R.string.cancel, (dialog, id) -> dialog.dismiss());
            builder.create();
            builder.show();
        });


    }


    private void setCountryCodeWithValidation(int selected_Country_position) {

        sessionManager.setCurrencyCode("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getIsoCode(), "" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getIsoCode());
        phone_code.setText("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getPhonecode());
        MAX_PHONE_LENGTH = Integer.parseInt("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getMaxNumPhone());
        editting_phone.setText("" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_PHONE));
        sessionManager.setDistanceUnit(sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getDistance_unit());
//        edt_phone_login.setFilters(new InputFilter[]{AppUtils.filter, new InputFilter.LengthFilter(MAX_PHONE_LENGTH)});

        setLoginMethodViaConfig();
    }

    protected void setLoginMethodViaConfig() {

        if (sessionManager.getAppConfig().getData().getLogin().isEmail()) {
            phone_code.setVisibility(View.INVISIBLE);
            editting_phone.setHint(getResources().getString(R.string.please_enter_email));
            editting_phone.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        } else {
            phone_code.setVisibility(View.VISIBLE);
            editting_phone.setHint(getResources().getString(R.string.LOGIn_ACTIVITY__phone));
            editting_phone.setInputType(InputType.TYPE_CLASS_NUMBER);
            editting_phone.setFilters(new InputFilter[]{AppUtils.filter, new InputFilter.LengthFilter(MAX_PHONE_LENGTH)});

        }
    }


    protected String getPrefrenceSmoker() {
        CheckBox checkBox = findViewById(R.id.checkbox);

        if (checkBox.isActivated())
            return "1";
        else
            return "0";

    }

    @Override
    protected void onResume() {
        super.onResume();

        builderSingle = new AlertDialog.Builder(ProfileActivity.this);
        builderSingle.setTitle(R.string.select_country);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ProfileActivity.this, android.R.layout.select_dialog_singlechoice);
        for (int i = 0; i < sessionManager.getAppConfig().getData().getCountries().size(); i++) {
            arrayAdapter.add(sessionManager.getAppConfig().getData().getCountries().get(i).getPhonecode() + " " + sessionManager.getAppConfig().getData().getCountries().get(i).getName());
        }
        builderSingle.setNegativeButton(ProfileActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setCountryCodeWithValidation(which);
                dialog.dismiss();
            }
        });
        try {
            apiManager._post(API_S.Tags.DRIVER_DETAILS, API_S.Endpoints.DRIVER_DETAILS, null, sessionManager);
        } catch (Exception e) {
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

    }

    private void setProfileData() {

        driverName.setText("" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_NAME) + " " + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_LAST_NAME));
        driverEmail.setText("" + sessionManager.getUserDetails().get(SessionManager.KEY_DriverEmail));
        driverPhone.setText("" + (sessionManager.getUserDetails().get(SessionManager.KEY_PHONE_CODE) + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_PHONE)));
        Glide.with(this).load("" + sessionManager.getUserDetails().get(SessionManager.KEY_DriverImage)).into(driverImage);

        if (!sessionManager.getTaxiCompany()) {
            llSubscription.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isSubscription_package() ? View.VISIBLE : View.GONE);
        } else {
            llSubscription.setVisibility(View.GONE);
        }
        changeBankDetails.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isBank_details_enable() ? View.VISIBLE : View.GONE);
        changeHomeAddress.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isHome_address_enable() ? View.VISIBLE : View.GONE);
        emergency_contacts.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isEmergency_contact() ? View.VISIBLE : View.GONE);

        try {
            radioSelectedValue = Integer.parseInt(sessionManager.getUserDetails().get(SessionManager.KEY_DriverGender));
        } catch (Exception e) {

        }
        try {
            ifsc_visibility = getIntent().getStringExtra("" + IntentKeys.IFSC_VISIBILITY);
            ifsc_placeholder = getIntent().getStringExtra("" + IntentKeys.IFSC_PLACEHOLDER);
        } catch (Exception e) {

        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            progressDialog.show();
        } else if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public void stopService() {
        stopService(new Intent(this, UpdateServiceClass.class));
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {

            switch (APINAME) {
                case API_S.Tags.LOGOUT:
                    stopService();
                    sessionManager.logoutUser();
                    sessionManager.clearAccessToken("");
                    ProfileActivity.this.finish();
                    MainActivity.activity.finish();
                    startActivity(new Intent(ProfileActivity.this, SplashActivity.class));
                    break;
                case API_S.Tags.EDIT_PROFILE:
                    ModelEditProfile modelEditProfile = SingletonGson.getInstance().fromJson("" + script, ModelEditProfile.class);
                    try {
                        apiManager._post(API_S.Tags.DRIVER_DETAILS, API_S.Endpoints.DRIVER_DETAILS, null, sessionManager);
                    } catch (Exception e) {
                        Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }
                    sessionManager.createLoginSession(true, "" + modelEditProfile.getData().getId()
                            , ""
                            , modelEditProfile.getData().getFirst_name()
                            , modelEditProfile.getData().getLast_name()
                            , modelEditProfile.getData().getPhone_without_code()
                            , modelEditProfile.getData().getPhone_code()
                            , modelEditProfile.getData().getEmail()
                            , String.valueOf(modelEditProfile.getData().getDriver_gender())
                            , modelEditProfile.getData().getSmoker_type()
                            , modelEditProfile.getData().getAllow_other_smoker()
                            , modelEditProfile.getData().getProfile_image()
                            , String.valueOf(modelEditProfile.getData().getCountry_area_id())
                            , modelEditProfile.getData().getCreated_at()
                            , String.valueOf(modelEditProfile.getData().getLogin_logout())
                            , String.valueOf(modelEditProfile.getData().getFree_busy())
                            , String.valueOf(modelEditProfile.getData().getOnline_offline())
                            , "3"
                            , modelEditProfile.getData().getAuto_accept_enable()
                            , modelEditProfile.getData().getSubscription_wise_commission(),
                            modelEditProfile.getData().getPhone_without_code());

                    setProfileData();
                    di.dismiss();
                    Snackbar.make(root, "" + modelEditProfile.getMessage(), Snackbar.LENGTH_SHORT).show();
                    break;
                case API_S.Tags.DRIVER_DETAILS:
                    modelDriverDetails = SingletonGson.getInstance().fromJson("" + script, ModelDriverDetails.class);
                    totalRides.setText("" + modelDriverDetails.getData().getTotalEarning().getTotal_ride());
                    totalEarning.setText("" + modelDriverDetails.getData().getTotalEarning().getTotal_earning());
                    totalRating.setText("" + modelDriverDetails.getData().getTotalEarning().getRating());
                    if (modelDriverDetails.getData().isAny_document_expire()) {
                        someDocExpireText.setVisibility(View.VISIBLE);
                    } else {
                        someDocExpireText.setVisibility(View.GONE);
                    }

                    try {
                        if (modelDriverDetails.getData().getDriverVehicle().size() > 0) {
                            vehicleId = String.valueOf(modelDriverDetails.getData().getDriverVehicle().get(0).getId());
                            sessionManager.setVehicleId(vehicleId);
                        } else {
                            vehicleId = "";
                        }
                    } catch (Exception e) {

                    }


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
                            , modelDriverDetails.getData().getAuto_accept_enable()
                            , modelDriverDetails.getData().getSubscription_wise_commission(),
                            modelDriverDetails.getData().getPhoneNumber());


                    setProfileData();


                    break;

            }


        } catch (Exception e) {
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(this, "" + script, Toast.LENGTH_SHORT).show();
    }

    @AfterPermissionGranted(RC_CAMERA_PERM)
    public void cameraTask() throws Exception {
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
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        try {
            cameraTask();
        } catch (Exception e) {
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case 110:
                    //area.setText("" + ProfileActivity.this.getResources().getString(R.string.select_area));
                    SelectedPhoneNumber = data.getExtras().getString("phone_number");
                    edt_phone.setText(data.getExtras().getString("phone_number"));
                    // Selected_Country_position = data.getExtras().getInt("position");
                    break;
                case 111:
                    edt_email.setText(data.getExtras().getString("phone_number"));
                    break;
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
                    circular_image.setImageBitmap(bitmap1);
//                    if(resultCode!=0){
//                        circular_image.setImageBitmap(null);
//                        circular_image.setBackgroundDrawable(null);
//                        circular_image.setBackgroundDrawable(getResources().getDrawable(R.drawable.dummy_pic));
//
//                    }


                    break;
                case CAMERS_PICKER:
                    ImageCompressMode imageCompressModee = new ImageCompressMode(this);
//                    if(resultCode!=0){
//                        circular_image.setImageBitmap(null);
//                        circular_image.setBackgroundDrawable(null);
//                        circular_image.setBackgroundDrawable(getResources().getDrawable(R.drawable.dummy_pic));
//                        Bitmap photo = (Bitmap)data.getExtras().get("data");
//                        Drawable drawable=new BitmapDrawable(photo);
//                        circular_image.setBackgroundDrawable(drawable);
//                        imagePathCompressed = imageCompressModee.compressImage(imagePath);
//                    }

                    thumbnail = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
//                    circular_image.setImageBitmap(thumbnail);
                    imagePath = getRealPathFromURI(imageUri);

                    ExifInterface ei = new ExifInterface(imagePath);
                    int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                            ExifInterface.ORIENTATION_UNDEFINED);

                    Bitmap rotatedBitmap = null;
                    switch (orientation) {

                        case ExifInterface.ORIENTATION_ROTATE_90:
                            rotatedBitmap = rotateImage(thumbnail, 90);
                            break;

                        case ExifInterface.ORIENTATION_ROTATE_180:
                            rotatedBitmap = rotateImage(thumbnail, 180);
                            break;

                        case ExifInterface.ORIENTATION_ROTATE_270:
                            rotatedBitmap = rotateImage(thumbnail, 270);
                            break;

                        case ExifInterface.ORIENTATION_NORMAL:
                        default:
                            rotatedBitmap = thumbnail;
                    }
                    circular_image.setImageBitmap(rotatedBitmap);

                    imagePathCompressed = imageCompressModee.compressImage(imagePath);

                    break;
            }
        } catch (Exception e) {
            Log.e("Exception", "" + e.getMessage());
        }

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

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }

}