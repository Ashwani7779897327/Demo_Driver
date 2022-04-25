package com.apporio.demotaxiappdriver.activities.placepicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.apporio.demotaxiappdriver.BuildConfig;
import com.google.android.material.snackbar.Snackbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PlacePickerActivity extends BaseActivity implements ApiManager.APIFETCHER {


    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    @Bind(R.id.root)
    LinearLayout root;
    private ApiManager apiManagerNew;
    private SessionManager sessionManager;
    private String TAG = "PlacePickerActivity";
    private Handler handler;

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.edittext)
    EditText edittext;
    @Bind(R.id.placeholder)
    PlaceHolderView placeholder;

    String LATITUDE = "", LONGITUDE = "";

    String googlemapKey = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_place_picker);


        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        apiManagerNew = new ApiManager(this, this);

        try {
            LATITUDE = getIntent().getExtras().getString("" + IntentKeys.LATITUDE);
            LONGITUDE = getIntent().getExtras().getString("" + IntentKeys.LONGITUDE);
        } catch (Exception e) {
        }

        googlemapKey = getResources().getString(R.string.google_api_key);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Log.e("Lenghth", "" + s.length());
                try {
                    placeholder.removeAllViews();
                } catch (Exception e) {
                }
                Runnable run = new Runnable() {
                    @Override
                    public void run() {

                        try {
                            apiManagerNew._getgoogleAPI(API_S.Tags.GOOGLE_PLACE_PICKER, getPlaceAutoCompleteUrl(edittext.getText().toString()));
                        } catch (Exception e) {
                            Log.e("Exception", "" + e.getMessage());
                        }
                    }

                };
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                } else {
                    handler = new Handler();
                }
                handler.postDelayed(run, 800);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

    }


    public String getPlaceAutoCompleteUrl(String input) {

        StringBuilder urlString = new StringBuilder();
        urlString.append(API_S.Endpoints.GOOGLE_PLACE_PICKER);
        urlString.append("?input=");
        try {
            urlString.append(URLEncoder.encode(input, "utf8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        urlString.append("&location=");
        urlString.append(LATITUDE + "," + LONGITUDE); // append lat long of current location to show nearby results.
        urlString.append("&radius=1000&language=en");
        urlString.append("&key=" + getResources().getString(R.string.google_map_key));

        Log.d("FINAL URL:::   ", urlString.toString());
        return urlString.toString();
    }


    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            progressbar.setVisibility(View.VISIBLE);
        } else {
            progressbar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            switch (APINAME) {


                case API_S.Tags.GOOGLE_PLACE_PICKER:

                    ModelGoogleApiStatus modelGoogleApiStatus = SingletonGson.getInstance().fromJson("" + script, ModelGoogleApiStatus.class);
                    if (modelGoogleApiStatus.getStatus().equals("OK")) {
                        ModelGooglePlacePicker modelGooglePlacePicker = SingletonGson.getInstance().fromJson("" + script, ModelGooglePlacePicker.class);
                        for (int i = 0; i < modelGooglePlacePicker.getPredictions().size(); i++) {
                            placeholder.addView(new HolderAddress(modelGooglePlacePicker.getPredictions().get(i).getStructured_formatting().getMain_text(),
                                    "" + modelGooglePlacePicker.getPredictions().get(i).getDescription(),
                                    "longitude",
                                    "longitude",
                                    "" + modelGooglePlacePicker.getPredictions().get(i).getPlace_id()));
                        }
                    }
                    if (modelGoogleApiStatus.getStatus().equals("REQUEST_DENIED")) {
                        Snackbar.make(root, "Permission denied from google api console ", Snackbar.LENGTH_SHORT).show();
                    }


                    break;
            }


        } catch (Exception e) {
            Log.e("Exception", "" + e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }

    @Layout(R.layout.holder_address)
    class HolderAddress {

        private String addressName, addressdescription, mType, place_id, mLatitude, mLongitude;


        @com.sam.placer.annotations.View(R.id.address_image)
        ImageView addressImage;
        //        @com.sam.placer.annotations.View(R.id.main_address)
//        TextView mainAddress;
        @com.sam.placer.annotations.View(R.id.address_description)
        TextView addressDescription;

        HolderAddress(String address_name, String address_description, String latitude, String longitude, String place_id) {
            this.addressName = address_name;
            this.addressdescription = address_description;
            this.mLatitude = latitude;
            this.mLongitude = longitude;
            this.place_id = place_id;
        }


        @Resolve
        private void setdata() {
            addressDescription.setText("" + addressdescription);
        }

        @Click(R.id.rootitem)
        private void setOnClick() {
            String url = "" + API_S.Endpoints.GOOGLE_PLACE_ID_RESPONSE + "" + this.place_id + "&fields=geometry&key=" + googlemapKey;
            progressbar.setVisibility(View.VISIBLE);
            AndroidNetworking.get(url).build().getAsString(new StringRequestListener() {
                @Override
                public void onResponse(String response) {
                    try {
                        progressbar.setVisibility(View.GONE);
                        ModelPlaceIdResponse modelPlaceIdResponse = SingletonGson.getInstance().fromJson("" + response, ModelPlaceIdResponse.class);
                        finalizeActivity("" + HolderAddress.this.addressdescription, "" + modelPlaceIdResponse.getResult().getGeometry().getLocation().getLat(), "" + modelPlaceIdResponse.getResult().getGeometry().getLocation().getLng());

                    } catch (Exception e) {
                        Log.e("Exception", "" + e.getMessage());
                    }
                }

                @Override
                public void onError(ANError anError) {
                    Toast.makeText(PlacePickerActivity.this, "" + anError.getErrorBody(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void finalizeActivity(String addressdescription, String latitude, String longitude) {
        Intent intent = new Intent();
        intent.putExtra("" + IntentKeys.ADDRESS_NAME, "" + addressdescription);
        intent.putExtra("" + IntentKeys.LATITUDE, latitude);
        intent.putExtra("" + IntentKeys.LONGITUDE, longitude);
        setResult(Activity.RESULT_OK, intent);
        PlacePickerActivity.this.finish();
    }
}
