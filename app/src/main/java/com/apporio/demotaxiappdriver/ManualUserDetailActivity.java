package com.apporio.demotaxiappdriver;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.activities.placepicker.PlacePickerActivity;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.location.SamLocationRequestService;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelManualCheckOut;
import com.apporio.demotaxiappdriver.models.ModelManualEstimate;
import com.apporio.demotaxiappdriver.models.ModelRideInfo;
import com.apporio.demotaxiappdriver.others.AppUtils;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.google.android.gms.common.api.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ManualUserDetailActivity extends BaseActivity implements ApiManager.APIFETCHER {

    private static final int OTP_REQUEST_CODE = 9;
    private final String TAG = "ManualDispatchActivity";
    private final int PLACE_PICKER_ACTIVITY = 111;

    LocationSession locationSession;
    SessionManager sessionManager;

    @Bind(R.id.ll_back_rides)
    LinearLayout ll_back_rides;

    @Bind(R.id.textView_dropPoint)
    TextView textView_dropPoint;

    @Bind(R.id.ll_dropLocation)
    LinearLayout ll_dropLocation;

    @Bind(R.id.textView_pickUp)
    TextView textView_pickUp;

    @Bind(R.id.ll_pickUpLocation)
    LinearLayout ll_pickUpLocation;

    @Bind(R.id.edt_cus_number)
    EditText edt_cus_number;

    @Bind(R.id.edt_cus_name)
    EditText edt_cus_name;

    @Bind(R.id.est_card)
    CardView estCard;

    @Bind(R.id.est_price_tv)
    TextView estPriceTV;

    @Bind(R.id.est_time_tv)
    TextView estTimeTV;

    @Bind(R.id.phone_code)
    TextView phone_code;

    private ModelRideInfo modelRideInfo = null;
    private SamLocationRequestService samLocationRequestService;
    private static int MAX_PHONE_LENGTH = 10;
    private static int MIN_PHONE_LENGTH = 5;
    Button button_startRide;
    JSONArray jsArray;

    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
    String manualDropLat = "", manualDropLng = "", manualPickLat = "", manualPickLng = "", manualPickLocation = "", manualDropLocation = "", bookingId = "";
    ApiManager apiManager;
    ProgressDialog pd;
    GsonBuilder builder;
    ModelManualEstimate modelManualEstimate;
    Gson gson;
    private HashMap<String, String> data = new HashMap<>();

    boolean otpManual = false;

    int openTrackScreen;

    int apiCheckDropArea;
    int apiCheckEstimate;
    int apiCheckOutManual;
    int apiManualBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_user_detail);

        ButterKnife.bind(this);
        getSupportActionBar().hide();

        initialization();


        phone_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(ManualUserDetailActivity.this);
                builderSingle.setTitle(R.string.select_country);
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ManualUserDetailActivity.this, android.R.layout.select_dialog_singlechoice);
                for (int j = 0; j < sessionManager.getAppConfig().getData().getCountries().size(); j++) {
                    arrayAdapter.add(sessionManager.getAppConfig().getData().getCountries().get(j).getPhonecode() + " " + sessionManager.getAppConfig().getData().getCountries().get(j).getName());
                }
                builderSingle.setNegativeButton(ManualUserDetailActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
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
                builderSingle.show();
            }
        });
    }

    private void initialization() {

        samLocationRequestService = new SamLocationRequestService(this);

        locationSession = new LocationSession(this);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this, this);
        pd = new ProgressDialog(this);
        builder = new GsonBuilder();
        gson = builder.create();
        pd.setMessage(ManualUserDetailActivity.this.getResources().getString(R.string.loading));

        button_startRide = (Button) findViewById(R.id.button_startRide);

        initialClickListeners();
        setPickUpView();

        setCountryCodeWithValidation(0);

    }

    private void setCountryCodeWithValidation(int selected_Country_position) {

        Thread thread = new Thread() {
            @Override
            public void run() {

                sessionManager.setCurrencyCode("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getIsoCode(), "" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getIsoCode());
                MAX_PHONE_LENGTH = sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getMaxNumPhone();
                MIN_PHONE_LENGTH = sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getMinNumPhone();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        edt_cus_number.setFilters(new InputFilter[]{AppUtils.filter,
                                new InputFilter.LengthFilter(Integer.parseInt("" + MAX_PHONE_LENGTH))});

                        phone_code.setText("" + sessionManager.getAppConfig().getData().getCountries().get(selected_Country_position).getPhonecode());
                        edt_cus_number.setText("");
                    }
                });
            }
        };

        thread.start();

    }

    private void setPickUpView() {

        try {
            manualPickLat = locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT);
            manualPickLng = locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LONG);

            data.clear();
            data.put("latitude", "" + manualPickLat);
            data.put("longitude", "" + manualPickLng);
            apiManager._post(API_S.Tags.REVERSE_GEOCODE, API_S.Endpoints.REVERSE_GEOCODE, data, sessionManager);

        } catch (Exception e) {

        }
    }


    private void initialClickListeners() {

        ll_dropLocation.setOnClickListener(new setOnClickList());
        ll_back_rides.setOnClickListener(new setOnClickList());
        button_startRide.setOnClickListener(new setOnClickList());
    }

    //StartRideMethod
    private void startRideMethod() {

        try {
            if(apiManualBooking==0){
                apiManualBooking=1;
                HashMap<String, String> data = new HashMap<>();
                data.put("checkout_id", bookingId);
                apiManager._post(API_S.Tags.MANUAL_BOOKING, API_S.Endpoints.MANUAL_BOOKING, data, sessionManager);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //// GooglePlaceApiDialog
    private void openGooglePlaceAPiDialoge() {

                Intent intent = new Intent(ManualUserDetailActivity.this, PlacePickerActivity.class)
                .putExtra("" + IntentKeys.LATITUDE, "" + manualPickLat)
                .putExtra("" + IntentKeys.LONGITUDE, "" + manualPickLng);
        startActivityForResult(intent, PLACE_PICKER_ACTIVITY);

//        try {
//            Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN).build(ManualUserDetailActivity.this);
//            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
//        } catch (GooglePlayServicesRepairableException e) {
//            // TODO: Handle the error.
//        } catch (GooglePlayServicesNotAvailableException e) {
//            // TODO: Handle the error.
//        }
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {

            if (requestCode == PLACE_PICKER_ACTIVITY) {

                if (!data.getExtras().getString(IntentKeys.ADDRESS_NAME).equals("")) {

                    textView_dropPoint.setText("" + data.getExtras().getString(IntentKeys.ADDRESS_NAME));

                    manualDropLat = String.valueOf(data.getExtras().getString(IntentKeys.LATITUDE));
                    manualDropLng = String.valueOf(data.getExtras().getString(IntentKeys.LONGITUDE));

                    manualDropLocation = data.getExtras().getString(IntentKeys.ADDRESS_NAME);

                    //TODO: run api to get estimate fare and time.

                    Thread thread = new Thread() {

                        @Override
                        public void run() {
                            jsArray = new JSONArray();

                            JSONObject jsonObject = new JSONObject();
                            try {

                                jsonObject.put("stop", "1");

                                jsonObject.put("drop_latitude", "" + manualDropLat);
                                jsonObject.put("drop_longitude", "" + manualDropLng);
                                jsonObject.put("drop_location", manualDropLocation);
                                jsonObject.put("status", "1");
                                jsArray.put(jsonObject);

                                HashMap<String, String> manualRequest = new HashMap<>();
                                manualRequest.put("pickup_longitude", manualPickLng);
                                manualRequest.put("pickup_latitude", manualPickLat);
                                manualRequest.put("service_type", "1");
                                manualRequest.put("drop_location", String.valueOf(jsArray));

                                runOnUiThread(() -> {
                                    try {
                                        if(apiCheckEstimate==0){
                                            apiCheckEstimate=1;
                                            apiManager._post(API_S.Tags.CHECK_ESTIMATE_TAG, API_S.Endpoints.CHECK_ESTIMATE_URL, manualRequest, sessionManager);
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                });


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    thread.start();


                }  else if (resultCode == RESULT_CANCELED) {
                }
            }

//            if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
//                if (resultCode == RESULT_OK) {
//                    Place place = PlaceAutocomplete.getPlace(this, data);
//                    Log.d("*#*# getAddress", "" + place.getAddress());
//                    Log.d("*#*# getAttributions", "" + place.getAttributions());
//                    Log.d("*#*# getLocale", "" + place.getLocale());
//                    Log.d("*#*# getname", "" + place.getName());
//                    Log.d("*#*# getId", "" + place.getId());
//                    Log.d("*#*# geWebsiteURI", "" + place.getWebsiteUri());
//
//                    textView_dropPoint.setText("" + place.getName());
//
//                    manualDropLat = String.valueOf(place.getLatLng().latitude);
//                    manualDropLng = String.valueOf(place.getLatLng().longitude);
//
//                    manualDropLocation = place.getName().toString();
//
//                    //TODO: run api to get estimate fare and time.
//
//                    Thread thread = new Thread() {
//
//                        @Override
//                        public void run() {
//                            jsArray = new JSONArray();
//
//                            JSONObject jsonObject = new JSONObject();
//                            try {
//
//                                jsonObject.put("stop", "1");
//
//                                jsonObject.put("drop_latitude", "" + manualDropLat);
//                                jsonObject.put("drop_longitude", "" + manualDropLng);
//                                jsonObject.put("drop_location", manualDropLocation);
//                                jsonObject.put("status", "1");
//                                jsArray.put(jsonObject);
//
//                                HashMap<String, String> manualRequest = new HashMap<>();
//                                manualRequest.put("pickup_longitude", manualPickLng);
//                                manualRequest.put("pickup_latitude", manualPickLat);
//                                manualRequest.put("service_type", "1");
//
//                                manualRequest.put("drop_location", String.valueOf(jsArray));
//
//                                runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        try {
//                                            apiManager._post(API_S.Tags.CHECK_ESTIMATE_TAG, API_S.Endpoints.CHECK_ESTIMATE_URL, manualRequest, sessionManager);
//                                        } catch (Exception e) {
//                                            e.printStackTrace();
//                                        }
//                                    }
//                                });
//
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    };
//
//                    thread.start();
//
//
//                } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
//                    Status status = PlaceAutocomplete.getStatus(this, data);
//                    Log.i("*****", status.getStatusMessage());
//                } else if (resultCode == RESULT_CANCELED) {
//                }
//            }
            else if (requestCode == OTP_REQUEST_CODE && resultCode == RESULT_OK) {
                startRideMethod();
            }

        } catch (Exception e) {
            Log.e("Manual_Exception_Place_AutoComplete", "" + e);
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

    @SuppressLint("LongLogTag")
    @Override
    public void onFetchComplete(Object script, String APINAME) {


        try {
            switch (APINAME) {
                case API_S.Tags.CHECK_DROP_AREA:

                    callBookingApi();

                    break;

                case API_S.Tags.REVERSE_GEOCODE:
                    GetAddressResponse getAddressResponse = gson.fromJson("" + script, GetAddressResponse.class);
                    if (getAddressResponse.getResult().equals("1")) {
                        textView_pickUp.setText("" + getAddressResponse.getData().getAddress().toString());
                        manualPickLocation = getAddressResponse.getData().getAddress().toString();
                    } else {

                    }
                    break;

                case API_S.Tags.MANUAL_BOOKING:
                    modelRideInfo = SingletonGson.getInstance().fromJson("" + script, ModelRideInfo.class); // getting same response as details api and refresh screen

                    if (modelRideInfo.getResult().equals("1")) {
                        if(openTrackScreen==0){
                            openTrackScreen=1;
                            startActivity(new Intent(ManualUserDetailActivity.this, TrackingActivity.class)
                                    .putExtra("" + IntentKeys.BOOKING_ID, "" + modelRideInfo.getData().getId()));

                            ManualUserDetailActivity.this.finish();
                        }
                    }
                    break;

                case API_S.Tags.CHECK_ESTIMATE_TAG:
                    modelManualEstimate = SingletonGson.getInstance().fromJson("" + script, ModelManualEstimate.class);

                    if (modelManualEstimate.getResult().equals("1")) {
                        estCard.setVisibility(View.VISIBLE);
                        estPriceTV.setText("" + getResources().getString(R.string.estimate_price) + " " + modelManualEstimate.getData().getAmount());
                        estTimeTV.setText("" + getResources().getString(R.string.estimate_time) + " " + modelManualEstimate.getData().getTime());

                        otpManual = modelManualEstimate.isOtp_manual_dispatch();

                    } else {
                        estCard.setVisibility(View.GONE);
                    }

                    break;

                case API_S.Tags.MANUAL_DETAILS_CHECKOUT:

                    ModelManualCheckOut modelManualCheckOut = SingletonGson.getInstance().fromJson("" + script, ModelManualCheckOut.class);


                    if (modelManualCheckOut.getResult().equals("1")) {

                        bookingId = "" + modelManualCheckOut.getData().getId();
                        if (otpManual) {
                            Intent intent = new Intent(ManualUserDetailActivity.this, ManualRide_Otp_activity.class).putExtra("ride_otp", "" + modelManualCheckOut.getOtp());
                            startActivityForResult(intent, OTP_REQUEST_CODE);
                        } else {
                            startRideMethod();
                        }
                    }
                    break;

            }

        } catch (Exception e) {
            Log.e("" + TAG, "" + e.getMessage());

        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(ManualUserDetailActivity.this, "" + script, Toast.LENGTH_SHORT).show();
    }

    public class setOnClickList implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int i = view.getId();
            if (i == button_startRide.getId()) {
                if (textView_pickUp.getText().toString().equals("")) {
                    Toast.makeText(ManualUserDetailActivity.this, getResources().getString(R.string.Manual_Activity_select_pick_location), Toast.LENGTH_SHORT).show();
                    ManualUserDetailActivity.this.finish();
                } else if (manualDropLat.equals("") && manualDropLng.equals("")) {
                    Toast.makeText(ManualUserDetailActivity.this, getResources().getString(R.string.Manual_Activity_select_drop_location), Toast.LENGTH_SHORT).show();
                }
                else if (!isValidPhoneNumber(edt_cus_number.getText().toString())) {
                    Toast.makeText(ManualUserDetailActivity.this, getResources().getString(R.string.valid_phone_number), Toast.LENGTH_SHORT).show();
                }
                else if (edt_cus_name.getText().toString().trim().isEmpty()) {
                    Toast.makeText(ManualUserDetailActivity.this, getResources().getString(R.string.name_can_not_be_empty), Toast.LENGTH_SHORT).show();
                } else {

                    checkDropLocation();
                }

            } else if (i == ll_dropLocation.getId()) {
                openGooglePlaceAPiDialoge();

            } else if (i == ll_back_rides.getId()) {

                ManualUserDetailActivity.this.finish();

            }
        }
    }

    private void checkDropLocation() {
        samLocationRequestService.executeService(location -> {
            try {
                if(apiCheckDropArea==0){
                    apiCheckDropArea=1;
                    HashMap<String, String> data = new HashMap<>();
                    data.put("latitude", manualDropLat);
                    data.put("longitude", manualDropLng);
                    data.put("service_type", "1");
                    data.put("area_id", sessionManager.getUserDetails().get(SessionManager.KEY_AREA_ID));
                    apiManager._post(API_S.Tags.CHECK_DROP_AREA, API_S.Endpoints.CHECK_DROP_AREA, data, sessionManager);
                }

            } catch (Exception e) {
            }
        });
    }

    public final static boolean isValidPhoneNumber(CharSequence target) {
        if (target == null || target.length() < MIN_PHONE_LENGTH || target.length() > MAX_PHONE_LENGTH) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(target).matches();
        }

    }


    private void callBookingApi() {
        samLocationRequestService.executeService(location -> {
            try {
                Thread thread = new Thread() {

                    @Override
                    public void run() {

                        jsArray = new JSONArray();

                        if (manualDropLat != null) {

                            try {
                                JSONObject jsonObject = new JSONObject();
                                jsonObject.put("stop", "1");
                                jsonObject.put("drop_latitude", "" + manualDropLat);
                                jsonObject.put("drop_longitude", "" + manualDropLng);
                                jsonObject.put("drop_location", manualDropLocation);
                                jsonObject.put("status", "1");
                                jsArray.put(jsonObject);
                            } catch (Exception e) {

                            }
                        }
                        if(apiCheckOutManual==0){
                            apiCheckOutManual=1;
                            HashMap<String, String> data = new HashMap<>();
                            data.put("pickup_latitude", manualPickLat);
                            data.put("estimate_time", modelManualEstimate.getData().getTime());
                            data.put("estimate_bill", modelManualEstimate.getData().getAmount());
                            data.put("estimate_distance", modelManualEstimate.getData().getDistance());
                            data.put("pickup_longitude", manualPickLng);
                            data.put("pickup_location", manualPickLocation);
                            data.put("drop_location", String.valueOf(jsArray));
                            data.put("accuracy", String.valueOf(location.getAccuracy()));
                            data.put("phone", phone_code.getText().toString()+edt_cus_number.getText().toString());
                            data.put("name", edt_cus_name.getText().toString());

                            runOnUiThread(() -> {
                                try {
                                    apiManager._post(API_S.Tags.MANUAL_DETAILS_CHECKOUT, API_S.Endpoints.checkoutBooking_url, data, sessionManager);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                        }

                    }
                };

                thread.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
