package com.apporio.demotaxiappdriver.activities.chooseAddVehicleType;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.AddVehicleActivity;
import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.DocumentActivity;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.RegisterActivity;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.SplashActivity;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelMatchOtp;
import com.apporio.demotaxiappdriver.models.ModelRegister;
import com.apporio.demotaxiappdriver.models.ModelVehicleRequest;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.io.File;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class AddExistingVehicleActivity extends BaseActivity implements View.OnClickListener, ApiManager.APIFETCHER {

    @Bind(R.id.estVehicleCode)
    EditText estVehicleCode;
    @Bind(R.id.btnSubmit)
    TextView btnSubmit;
    @Bind(R.id.driver_image)
    CircleImageView driver_image;
    @Bind(R.id.tvDriverName)
    TextView tvDriverName;
    @Bind(R.id.tvVehicleName)
    TextView tvVehicleName;
    @Bind(R.id.btnAddExistingVehicle)
    Button btnAddExistingVehicle;
    @Bind(R.id.llEnterCodeLayout)
    LinearLayout llEnterCodeLayout;
    @Bind(R.id.llExistingVehicleDetails)
    LinearLayout llExistingVehicleDetails;
    @Bind(R.id.edtVerifyOtp)
    EditText edtVerifyOtp;
    @Bind(R.id.ll_back_about)
    LinearLayout ll_back_about;

    ProgressDialog pd;
    ApiManager apimanager;
    SessionManager sessionManager;

    String driver_id, area_id, driver_vehicle_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apimanager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        setContentView(R.layout.activity_add_existing_vehicle);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        pd = new ProgressDialog(this);
        pd.setMessage(AddExistingVehicleActivity.this.getResources().getString(R.string.loading));
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);

        driver_id = getIntent().getStringExtra(IntentKeys.DRIVER_ID);
        area_id = getIntent().getStringExtra(IntentKeys.AREA_ID);

        btnSubmit.setOnClickListener(this);
        btnAddExistingVehicle.setOnClickListener(this);
        ll_back_about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ll_back_about:
                AddExistingVehicleActivity.this.finish();
                break;

            case R.id.btnAddExistingVehicle:
                if (edtVerifyOtp.getText().toString().equals("")) {
                    Toast.makeText(AddExistingVehicleActivity.this, R.string.otp_not_match, Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("driver_vehicle_id", "" + driver_vehicle_id);
                    data.put("driver_id", "" + driver_id);
                    data.put("otp", "" + edtVerifyOtp.getText().toString());
                    try {
                        apimanager._post(API_S.Tags.MATCH_VEHICLE_OTP, API_S.Endpoints.MATCH_VEHICLE_OTP, data, sessionManager);
                    } catch (Exception e) {
                    }
                }

                break;

            case R.id.btnSubmit:

                if (estVehicleCode.getText().toString().equals("")) {
                    Toast.makeText(AddExistingVehicleActivity.this, R.string.existing_vehiicle_code, Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("code", "" + estVehicleCode.getText().toString());
                    data.put("driver_id", "" + driver_id);
                    try {
                        apimanager._post(API_S.Tags.REQUEST_FOR_VEHICLE, API_S.Endpoints.REQUEST_FOR_VEHICLE, data, sessionManager);
                    } catch (Exception e) {
                    }
                }
                break;
        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        try {
            if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                pd.show();
            } else if (pd.isShowing()) {
                pd.dismiss();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

        try {
            if (APINAME.equals(API_S.Tags.REQUEST_FOR_VEHICLE)) {
                ModelVehicleRequest modelVehicleRequest = SingletonGson.getInstance().fromJson("" + script, ModelVehicleRequest.class);

                if (modelVehicleRequest.getResult().equals("1")) {
                    driver_vehicle_id = String.valueOf(modelVehicleRequest.getData().getId());
                    llExistingVehicleDetails.setVisibility(View.VISIBLE);
                    btnAddExistingVehicle.setVisibility(View.VISIBLE);
                    Glide.with(this).load("" + modelVehicleRequest.getData().getOwner_driver().getProfile_image()).into(driver_image);
                    tvDriverName.setText("" + modelVehicleRequest.getData().getOwner_driver().getFirst_name());
                    tvVehicleName.setText("" + modelVehicleRequest.getData().getVehicleTypeName());
                }
            }

            if (APINAME.equals(API_S.Tags.MATCH_VEHICLE_OTP)) {
                ModelMatchOtp modelMatchOtp = SingletonGson.getInstance().fromJson("" + script, ModelMatchOtp.class);
                if (modelMatchOtp.getResult().equals("1")) {
                    startActivity(new Intent(AddExistingVehicleActivity.this, DocumentActivity.class)
                            .putExtra("" + IntentKeys.DRIVER_ID, "" + driver_id)
                            .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + driver_vehicle_id));
                    finish();
                    ChooseVehicleType.chooseVehicleType.finish();
                   // SplashActivity.splash.finish();
                    finish();
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }
}
