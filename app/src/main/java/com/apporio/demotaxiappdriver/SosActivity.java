package com.apporio.demotaxiappdriver;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.location.SamLocationRequestService;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;
import com.sampermissionutils.AfterPermissionGranted;
import com.sampermissionutils.EasyPermissions;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SosActivity extends Activity implements ApiManager.APIFETCHER {


    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.placeholder)
    PlaceHolderView placeholder;
    @Bind(R.id.add_phone_layout)
    CardView add_phone_layout;
    @Bind(R.id.edt_phone_txt)
    EditText edt_phone_txt;
    @Bind(R.id.cancel_phone)
    TextView cancel_phone;
    @Bind(R.id.save_phone)
    TextView save_phone;
    @Bind(R.id.btn_add_phone)
    Button btn_add_phone;

    ApiManager apiManager;
    SessionManager sessionManager;
    SamLocationRequestService samLocationRequestService;

    private static final int TELEPHONE_PERM = 657;
    String NUMBER_TO_CALL = "", BOOKING_ID = "", LATITUDE = "", LONGITUDE = "";
    private final String TAG = "SosActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this, this);
        samLocationRequestService = new SamLocationRequestService(this);

        try {
            String[] SOS_IDS, SOS_NAMES, SOS_NUMBERS;
            SOS_IDS = getIntent().getExtras().getString("" + IntentKeys.SOS_ID).trim().split("__");
            SOS_NAMES = getIntent().getExtras().getString("" + IntentKeys.SOS_NAMES).trim().split("__");
            SOS_NUMBERS = getIntent().getExtras().getString("" + IntentKeys.SOS_NUMBERS).trim().split("__");
            BOOKING_ID = getIntent().getExtras().getString("" + IntentKeys.BOOKING_ID);

            for (int i = 0; i < SOS_IDS.length; i++) {
                placeholder.addView(new HolderSosNumbers(SOS_IDS[i], SOS_NAMES[i], SOS_NUMBERS[i]));
            }
        } catch (Exception e) {
            Toast.makeText(this, "caught exeption -- " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        back.setOnClickListener((View view) -> {
            finish();
        });


        btn_add_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                add_phone_layout.setVisibility(View.VISIBLE);


            }
        });


        cancel_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                add_phone_layout.setVisibility(View.GONE);

            }
        });

        save_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }


    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        finish();
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }


    @AfterPermissionGranted(TELEPHONE_PERM)
    public void callingTask(String number, String latitude, String longitude, String booking_id) throws Exception {
        Toast.makeText(this, "calling task ", Toast.LENGTH_SHORT).show();
        if (EasyPermissions.hasPermissions(this, android.Manifest.permission.CALL_PHONE)) {
            try { // Have permission, do the thing!
                HashMap<String, String> data = new HashMap<>();
                data.put("booking_id", "" + booking_id);
                data.put("number", "" + number);
                data.put("latitude", "" + latitude);
                data.put("longitude", "" + longitude);
                apiManager._post(API_S.Tags.SOS_REQUEST, API_S.Endpoints.SOS_REQUEST, data, sessionManager);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            } catch (Exception e) {
            }
        } else {
            EasyPermissions.requestPermissions(this, getString(R.string.this_app_need_telephony_permission), TELEPHONE_PERM, Manifest.permission.CALL_PHONE);
        }
    }


    @Layout(R.layout.item_for_sos)
    class HolderSosNumbers {

        @com.sam.placer.annotations.View(R.id.service_name_txt)
        TextView serviceNameTxt;
        @com.sam.placer.annotations.View(R.id.phone_number)
        TextView phoneNumber;

        private String SOS_ID = "";
        private String SOS_NAME = "";
        private String SOS_NUMBER = "";


        public HolderSosNumbers(String sos_id, String sos_name, String sos_number) {
            SOS_ID = sos_id;
            SOS_NAME = sos_name;
            SOS_NUMBER = sos_number;
        }


        @Resolve
        public void setData() {
            serviceNameTxt.setText("" + SOS_NAME);
            phoneNumber.setText("" + SOS_NUMBER);
        }


        @Click(R.id.root_element)
        private void onItemClick() {
            samLocationRequestService.executeService(new SamLocationRequestService.SamLocationListener() {
                @Override
                public void onLocationUpdate(Location location) {
                    LATITUDE = "" + location.getLatitude();
                    LONGITUDE = "" + location.getLongitude();
                    NUMBER_TO_CALL = "" + SOS_NUMBER;
                    try {
                        callingTask(NUMBER_TO_CALL, LATITUDE, LONGITUDE, BOOKING_ID);
                    } catch (Exception e) {
                        Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }
                }
            });
        }

    }
}
