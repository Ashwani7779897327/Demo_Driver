package com.apporio.demotaxiappdriver.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.apporio.demotaxiappdriver.AboutActivity;
import com.apporio.demotaxiappdriver.CustomerSupportActivity;
import com.apporio.demotaxiappdriver.MainActivity;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.ReferAndEarnActivity;
import com.apporio.demotaxiappdriver.SetRadiusActivity;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.SplashActivity;
import com.apporio.demotaxiappdriver.TermsAndCondition;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelAutoUpgrade;
import com.apporio.demotaxiappdriver.rating_module.DriverRatingActivity;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.apporio.demotaxiappdriver.sup_driver.SuperDriver;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import customviews.typefacesviews.TypeFaceGoogle;

public class SettingsActivity extends BaseActivity implements View.OnClickListener, ApiManager.APIFETCHER {

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.ll_language_btn)
    TypeFaceGoogle llLanguageBtn;
    @Bind(R.id.ll_customer_btn)
    TypeFaceGoogle llCustomerBtn;
    @Bind(R.id.ll_report_issue_btn)
    TypeFaceGoogle llReportIssueBtn;
    @Bind(R.id.ll_terms_btn)
    TypeFaceGoogle llTermsBtn;
    @Bind(R.id.ll_about_btn)
    TypeFaceGoogle llAboutBtn;
    @Bind(R.id.textView_version_name)
    TypeFaceGoogle textViewVersionName;
    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.switchAutoUpgrade)
    Switch switchAutoUpgrade;
    @Bind(R.id.switchPoolRide)
    Switch switchPoolRide;
    @Bind(R.id.rlAutoUpgradation)
    LinearLayout rlAutoUpgradation;
    @Bind(R.id.rlPoolRide)
    LinearLayout rlPoolRide;
    @Bind(R.id.ll_privacy_policy)
    TypeFaceGoogle ll_privacy_policy;
    @Bind(R.id.super_driver)
    LinearLayout super_driver;
    @Bind(R.id.driver_rating)
    TypeFaceGoogle driver_rating;
    @Bind(R.id.refer_menu_btn)
    LinearLayout refer_menu_btn;
    @Bind(R.id.set_radius_btn)
    LinearLayout set_radius_btn;
    @Bind(R.id.driverRating)
    LinearLayout driverRating;


    private SessionManager sessionManager;
    private ApiManager apiManager;
    private final String TAG = "SettingsActivity";

    private String versionName = "";

    Integer autoUpgrade;
    Boolean poolRideStatusShow;
    private HashMap<String, String> data = new HashMap<>();
    String autoUpgradeShow, poolRideStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        apiManager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        try {
            versionName = getPackageManager()
                    .getPackageInfo(getPackageName(), 0).versionName;

            textViewVersionName.setText(getString(R.string.version) + " (" + versionName + ")");

            getActionStatus();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        onClickListeners();
    }

    private void getActionStatus() {

        autoUpgrade = Integer.valueOf(getIntent().getStringExtra("" + IntentKeys.AUTO_UPGRADATION));
        poolRideStatusShow = getIntent().getBooleanExtra(IntentKeys.POOL_RIDE_ACTIVATE_SHOW, false);
        autoUpgradeShow = getIntent().getStringExtra("" + IntentKeys.AUTO_UPGRADATION_SHOW);
        poolRideStatus = getIntent().getStringExtra("" + IntentKeys.POOL_RIDE_ACTIVATE);
        super_driver.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isEnable_super_driver()?View.VISIBLE:View.GONE);
        set_radius_btn.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isDriver_limit()?View.VISIBLE:View.GONE);

        // driver_rating.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().is);
        if (autoUpgrade == 1) {
            switchAutoUpgrade.setChecked(true);
        } else {
            switchAutoUpgrade.setChecked(false);
        }

        if (poolRideStatus.equals("1")) {
            switchPoolRide.setChecked(true);
        } else {
            switchPoolRide.setChecked(false);
        }

        rlAutoUpgradation.setVisibility(autoUpgradeShow.equals("1") ? View.VISIBLE : View.GONE);
        rlPoolRide.setVisibility(poolRideStatusShow ? View.VISIBLE : View.GONE);

        super_driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SettingsActivity.this, SuperDriver.class);
                startActivity(intent);
            }
        });

        switchAutoUpgrade.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch State=", "" + isChecked);

                if (isChecked) {

                    data.put("status", "1");
                    try {
                        apiManager._post(API_S.Tags.AUTO_UPGRADE, API_S.Endpoints.AUTO_UPGRADE, data, sessionManager);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                } else {

                    data.put("status", "2");
                    try {
                        apiManager._post(API_S.Tags.AUTO_UPGRADE, API_S.Endpoints.AUTO_UPGRADE, data, sessionManager);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

            }

        });


        switchPoolRide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch State=", "" + isChecked);

                if (isChecked) {

                    data.put("pool_status", "1");
                    try {
                        apiManager._post(API_S.Tags.ACTIVE_POOL, API_S.Endpoints.ACTIVE_POOL, data, sessionManager);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                } else {

                    data.put("pool_status", "2");
                    try {
                        apiManager._post(API_S.Tags.ACTIVE_POOL, API_S.Endpoints.ACTIVE_POOL, data, sessionManager);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

            }

        });


    }


    private void onClickListeners() {

        back.setOnClickListener(this);
        llLanguageBtn.setOnClickListener(this);
        llCustomerBtn.setOnClickListener(this);
        llReportIssueBtn.setOnClickListener(this);
        llTermsBtn.setOnClickListener(this);
        llAboutBtn.setOnClickListener(this);
        ll_privacy_policy.setOnClickListener(this);
        driver_rating.setOnClickListener(this);
        refer_menu_btn.setOnClickListener(this);
        set_radius_btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.driver_rating:
                startActivity(new Intent(SettingsActivity.this, DriverRatingActivity.class));
                break;
            case R.id.ll_language_btn:
                String[] array = new String[sessionManager.getAppConfig().getData().getLanguages().size()];


                for (int i = 0; i < sessionManager.getAppConfig().getData().getLanguages().size(); i++) {
                    array[i] = sessionManager.getAppConfig().getData().getLanguages().get(i).getName();
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle(R.string.select_language)
                        .setItems(array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                sessionManager.setUpdatedStringVersion("0.0");
                                sessionManager.setLanguage("" + sessionManager.getAppConfig().getData().getLanguages().get(which).getLocale());
                                finish();
                                MainActivity.activity.finish();
                                startActivity(new Intent(SettingsActivity.this, SplashActivity.class));
                            }
                        });
                builder.create().show();
                break;
            case R.id.ll_customer_btn:
                startActivity(new Intent(SettingsActivity.this, CustomerSupportActivity.class));
                break;

            case R.id.ll_report_issue_btn:

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "" + sessionManager.getAppConfig().getData().getCustomer_support().getMail(), null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "" + SettingsActivity.this.getResources().getString(R.string.report_issue));
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "" + SettingsActivity.this.getResources().getString(R.string.send_email)));
                emailIntent.setType("text/plain");

                break;

            case R.id.ll_terms_btn:
                startActivity(new Intent(SettingsActivity.this, TermsAndCondition.class));
                break;

            case R.id.ll_about_btn:
                startActivity(new Intent(SettingsActivity.this, AboutActivity.class).putExtra("from", "1"));
                break;

            case R.id.ll_privacy_policy:
                startActivity(new Intent(SettingsActivity.this, AboutActivity.class).putExtra("from", "2"));
                break;

            case R.id.back:
                finish();
                break;

            case R.id.refer_menu_btn:
                startActivity(new Intent(SettingsActivity.this, ReferAndEarnActivity.class));
                break;

            case R.id.set_radius_btn :
                startActivity(new Intent(SettingsActivity.this, SetRadiusActivity.class));
                break;
        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            switch (APINAME) {
                case API_S.Tags.AUTO_UPGRADE:
                    ModelAutoUpgrade modelAutoUpgrade = SingletonGson.getInstance().fromJson("" + script, ModelAutoUpgrade.class);
                    if (modelAutoUpgrade.getResult().equals("1")) {
                        Snackbar.make(root, "" + modelAutoUpgrade.getMessage(), Snackbar.LENGTH_SHORT).show();
                    } else {
                        Snackbar.make(root, "" + modelAutoUpgrade.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                    break;

                case API_S.Tags.ACTIVE_POOL:
                    ModelAutoUpgrade modelAutoUpgrade1 = SingletonGson.getInstance().fromJson("" + script, ModelAutoUpgrade.class);
                    if (modelAutoUpgrade1.getResult().equals("1")) {
                        Snackbar.make(root, "" + modelAutoUpgrade1.getMessage(), Snackbar.LENGTH_SHORT).show();
                    } else {
                        Snackbar.make(root, "" + modelAutoUpgrade1.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                    break;
            }
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
    }
}
