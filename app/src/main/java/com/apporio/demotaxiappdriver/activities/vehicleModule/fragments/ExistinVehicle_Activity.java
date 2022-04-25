package com.apporio.demotaxiappdriver.activities.vehicleModule.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.DocumentActivity;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.SplashActivity;
import com.apporio.demotaxiappdriver.activities.chooseAddVehicleType.AddExistingVehicleActivity;
import com.apporio.demotaxiappdriver.activities.chooseAddVehicleType.ChooseVehicleType;
import com.apporio.demotaxiappdriver.baseClass.BaseFragment;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelMatchOtp;
import com.apporio.demotaxiappdriver.models.ModelVehicleRequest;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.bumptech.glide.Glide;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class ExistinVehicle_Activity extends BaseFragment implements ApiManager.APIFETCHER {

    @Bind(R.id.estVehicleCode)
    EditText estVehicleCode;
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
    @Bind(R.id.btnSubmit)
    TextView btnSubmit;
    @Bind(R.id.driver_details)
    LinearLayout driver_details;

    ProgressDialog pd;
    ApiManager apimanager;
    SessionManager sessionManager;

    String driver_id, area_id, driver_vehicle_id;
    public static String documentScreenApi;

    public static ExistinVehicle_Activity newInstance(String area_id, String driver_id, String documentScreenApi) {
        ExistinVehicle_Activity fragmentFirst = new ExistinVehicle_Activity();

        Bundle args = new Bundle();
        args.putString(IntentKeys.AREA_ID, area_id);
        args.putString(IntentKeys.DRIVER_ID, driver_id);
        args.putString("documentScreenApi", documentScreenApi);
        fragmentFirst.setArguments(args);

        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    // Inflate the view for the fragment based on layout XML


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_existin_vehicle_, container, false);
        ButterKnife.bind(this, view);

        apimanager = new ApiManager(this, getContext());
        sessionManager = new SessionManager(getContext());


        pd = new ProgressDialog(getContext());
        pd.setMessage(getResources().getString(R.string.loading));
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);

        area_id = getArguments().getString(IntentKeys.AREA_ID);
        driver_id = getArguments().getString(IntentKeys.DRIVER_ID);

        documentScreenApi = getArguments().getString("documentScreenApi");

//        btnAddExistingVehicle.setOnClickListener(this);
//        btnSubmit.setOnClickListener(this);


        return view;
    }

    @OnClick({R.id.btnAddExistingVehicle, R.id.btnSubmit})
    protected void onSubmit(View view) {
        switch (view.getId()) {
            case R.id.btnAddExistingVehicle:
                if (edtVerifyOtp.getText().toString().equals("")) {
                    Toast.makeText(getContext(), R.string.otp_not_matchh, Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(getContext(), R.string.existing_vehiicle_code, Toast.LENGTH_SHORT).show();
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
                    Glide.with(this).load( "" + modelVehicleRequest.getData().getVehicle_image()).into(driver_image);
                    tvDriverName.setText("" + modelVehicleRequest.getData().getOwner_driver().getFirst_name() + " " + modelVehicleRequest.getData().getOwner_driver().getLast_name());
                    tvVehicleName.setText("" + modelVehicleRequest.getData().getVehicleTypeName());
                }
            }

            if (APINAME.equals(API_S.Tags.MATCH_VEHICLE_OTP)) {
                ModelMatchOtp modelMatchOtp = SingletonGson.getInstance().fromJson("" + script, ModelMatchOtp.class);
                if (modelMatchOtp.getResult().equals("1")) {

                    if(documentScreenApi.equals("1")){
                        Toast.makeText(getActivity(), ""+modelMatchOtp.getMessage(), Toast.LENGTH_SHORT).show();
                    }else {
                        startActivity(new Intent(getContext(), DocumentActivity.class)
                                .putExtra("documentScreenApi", documentScreenApi)
                                .putExtra("" + IntentKeys.DRIVER_ID, "" + driver_id)
                                .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + driver_vehicle_id));
                        getActivity().finish();
                        ChooseVehicleType.chooseVehicleType.finish();                    }
                    // SplashActivity.splash.finish();
                    getActivity().finish();
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(getActivity(), "" + script, Toast.LENGTH_SHORT).show();
        if(APINAME.equals(API_S.Tags.REQUEST_FOR_VEHICLE)){
            llExistingVehicleDetails.setVisibility(View.GONE);
        }
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//
//
//            case R.id.btnAddExistingVehicle:
//                if (edtVerifyOtp.getText().toString().equals("")) {
//                    Toast.makeText(getContext(), R.string.otp_not_match, Toast.LENGTH_SHORT).show();
//                } else {
//                    HashMap<String, String> data = new HashMap<>();
//                    data.put("driver_vehicle_id", "" + driver_vehicle_id);
//                    data.put("driver_id", "" + driver_id);
//                    data.put("otp", "" + edtVerifyOtp.getText().toString());
//                    try {
//                        apimanager._post(API_S.Tags.MATCH_VEHICLE_OTP, API_S.Endpoints.MATCH_VEHICLE_OTP, data, sessionManager);
//                    } catch (Exception e) {
//                    }
//                }
//
//                break;
//
//            case R.id.btnSubmit:
//
//                if (estVehicleCode.getText().toString().equals("")) {
//                    Toast.makeText(getContext(), R.string.existing_vehiicle_code, Toast.LENGTH_SHORT).show();
//                } else {
//                    HashMap<String, String> data = new HashMap<>();
//                    data.put("code", "" + estVehicleCode.getText().toString());
//                    data.put("driver_id", "" + driver_id);
//                    try {
//                        apimanager._post(API_S.Tags.REQUEST_FOR_VEHICLE, API_S.Endpoints.REQUEST_FOR_VEHICLE, data, sessionManager);
//                    } catch (Exception e) {
//                    }
//                }
//                break;
//        }
//
//    }

}
