package com.apporio.demotaxiappdriver;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;

import com.apporio.demotaxiappdriver.holder.HolderChildDetails;
import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.currentwork.holders.HolderBookingDescription;
import com.apporio.demotaxiappdriver.currentwork.holders.HolderDriver;
import com.apporio.demotaxiappdriver.currentwork.holders.HolderMapImage;
import com.apporio.demotaxiappdriver.currentwork.holders.HolderMetering;
import com.apporio.demotaxiappdriver.currentwork.holders.HolderPickDropLocation;
import com.apporio.demotaxiappdriver.currentwork.holders.HolderReceipt;
import com.apporio.demotaxiappdriver.location.SamLocationRequestService;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelCancelReasion;
import com.apporio.demotaxiappdriver.models.ModelRideInfo;
import com.apporio.demotaxiappdriver.models.ModelSpecificTripDetails;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SpecificTripDetailsActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.back) ImageView back;
    @Bind(R.id.placeholder) PlaceHolderView placeholder;
    @Bind(R.id.swiperefreshLayout)
    SwipeRefreshLayout swiperefreshLayout;
    @Bind(R.id.root) LinearLayout root;
    @Bind(R.id.bottom_text) TextView bottomText;
    @Bind(R.id.cancel_btn_triphistory)
    Button cancel_btn_triphistory;

    private ApiManager apiManagerNew;
    private SessionManager sessionManager;

    int alreadyApiHit=0;

    private final String TAG = "SpecificTripDetailsActivity";
    private HashMap<String, String> data = new HashMap<>();
    private ModelSpecificTripDetails modelSpecificTripDetails ;
    private SamLocationRequestService samLocationRequestService ;
    public Location LOCATION = null;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_specific_trip_details);
        ButterKnife.bind(this);
        apiManagerNew = new ApiManager(this,this);
        sessionManager = new SessionManager(this);
        samLocationRequestService = new SamLocationRequestService(this);
        samLocationRequestService.executeService(new SamLocationRequestService.SamLocationListener() {
            @Override
            public void onLocationUpdate(Location location) {
                LOCATION = location;
            }
        });

        back.setOnClickListener(view -> finish());



        cancel_btn_triphistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    apiManagerNew._post(API_S.Tags.CANCEL_REASION, API_S.Endpoints.CANCLE_REASION, null, sessionManager);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        try {
            callAPI();
        } catch (Exception e) {
           // Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

        bottomText.setOnClickListener((View view)->{
            if(modelSpecificTripDetails.getData().getButton_visibility().getAction().equals("PARTIAL_ACCEPT_API")){
                try{
                    HashMap<String , String > data = new HashMap<>();
                    data.put("booking_id",""+ getIntent().getExtras().getString(IntentKeys.BOOKING_ID));
                    if(alreadyApiHit==0){
                        apiManagerNew._post(API_S.Tags.PARTIAL_ACCEPT, API_S.Endpoints.PARTIAL_ACCEPT,data, sessionManager);
                        alreadyApiHit = 1;
                    }
                }catch (Exception e){
                    Snackbar.make(root,""+e.getMessage(),Snackbar.LENGTH_SHORT).show();
                    Log.d("" +TAG , "Exception caught while calling API "+e.getMessage());}


            }
            if(modelSpecificTripDetails.getData().getButton_visibility().getAction().equals("START_TO_PICK")){
                try {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("booking_id", "" + getIntent().getExtras().getString(IntentKeys.BOOKING_ID));
                    data.put("latitude", "" + LOCATION.getLatitude());
                    data.put("longitude", "" + LOCATION.getLongitude());
                    data.put("accuracy", "" + LOCATION.getAccuracy());
                     apiManagerNew._post(API_S.Tags.ACCEPT_RIDE, API_S.Endpoints.ACCEPT_RIDE, data, sessionManager);
                } catch (Exception e) {
                    Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                }
            }
            if(modelSpecificTripDetails.getData().getButton_visibility().getAction().equals("OPEN_TRACKSCREEN")){
                startActivity(new Intent(SpecificTripDetailsActivity.this,TrackingActivity.class).putExtra(""+IntentKeys.BOOKING_ID,""+getIntent().getExtras().getString(""+IntentKeys.BOOKING_ID)));

            }
        });

        swiperefreshLayout.setOnRefreshListener(() -> {
            try {
                placeholder.removeAllViews();
                callAPI();
            } catch (Exception e) {
                Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
            }
        });
    }

    private void callAPI() throws Exception {
        data.clear();
        data.put("booking_id", "" + getIntent().getExtras().getString(IntentKeys.BOOKING_ID));
        apiManagerNew._post(API_S.Tags.TRIP_SPECIFIC_DETAIL, API_S.Endpoints.TRIP_SPECIFIC_DETAIL, data, sessionManager);
        placeholder.removeAllViews();
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            swiperefreshLayout.setRefreshing(true);
        } else {
            swiperefreshLayout.setRefreshing(false);
        }
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            switch (APINAME){
                case API_S.Tags.TRIP_SPECIFIC_DETAIL:
                    modelSpecificTripDetails = SingletonGson.getInstance().fromJson("" + script, ModelSpecificTripDetails.class);
                    addHolder(modelSpecificTripDetails);
                    setBottomButton(modelSpecificTripDetails.getData().getButton_visibility());
                    break;
                case API_S.Tags.PARTIAL_ACCEPT:
                    callAPI();
                    break;
                case API_S.Tags.ACCEPT_RIDE:
                    ModelRideInfo modelAcceptRide = SingletonGson.getInstance().fromJson("" + script, ModelRideInfo.class);
                    startActivity(new Intent(this, TrackingActivity.class).putExtra("" + IntentKeys.BOOKING_ID, "" + modelAcceptRide.getData().getId())
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));

                    try {
                        NewRequestActivity.activity.finish();
                        TripHistoryActivity.activity.finish();
                        SpecificTripDetailsActivity.this.finish();
                    }catch (Exception e){

                    }

                    break;

                case API_S.Tags.CANCEL_REASION:

                    ModelCancelReasion modelCancelReasion = SingletonGson.getInstance().fromJson("" + script, ModelCancelReasion.class);

                    if (modelCancelReasion.getResult().equals("1")) {
                        try {
                            AlertDialog.Builder builderSingle = new AlertDialog.Builder(SpecificTripDetailsActivity.this);
                            builderSingle.setTitle(R.string.cancel_ride);
                            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SpecificTripDetailsActivity.this, android.R.layout.select_dialog_singlechoice);
                            for (int i = 0; i < modelCancelReasion.getData().size(); i++) {
                                arrayAdapter.add("" + modelCancelReasion.getData().get(i).getReason());
                            }
                            builderSingle.setNegativeButton(SpecificTripDetailsActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    try {
                                        data.clear();
                                        data.put("booking_id", "" + getIntent().getExtras().getString("" + IntentKeys.BOOKING_ID));
                                        data.put("cancel_reason_id", "" + modelCancelReasion.getData().get(which).getId());
                                        apiManagerNew._post(API_S.Tags.CANCEL_RIDE, API_S.Endpoints.CANCEL_RIDE, data, sessionManager);
                                    } catch (Exception e) {
                                        Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                                        Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
                                    }
                                    dialog.dismiss();
                                }
                            });
                            builderSingle.show();
                        } catch (Exception e) {
                            Log.d("" + TAG, "" + e.getMessage());
                        }
                    }

                    break;


                case API_S.Tags.CANCEL_RIDE :

                    callAPI();

                    break;



            }

        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
    }

    private void addHolder(ModelSpecificTripDetails modelSpecificTripDetails) {

        if (modelSpecificTripDetails.getData().getHolder_map_image().isVisibility()) {
            placeholder.addView(new HolderMapImage(this,this, modelSpecificTripDetails.getData().getHolder_map_image().getData().getMap_image()));
        }
        if (modelSpecificTripDetails.getData().getHolder_booking_description().isVisibility()) {
            placeholder.addView(new HolderBookingDescription(modelSpecificTripDetails.getData().getHolder_booking_description().getData()));
        }
        if (modelSpecificTripDetails.getData().getHolder_pickdrop_location().isVisibility()) {
            placeholder.addView(new HolderPickDropLocation(modelSpecificTripDetails.getData().getHolder_pickdrop_location().getData()));
        }
        try{
            if (modelSpecificTripDetails.getData().getHolder_family_member().getVisibility()) {
                placeholder.addView(new HolderChildDetails(modelSpecificTripDetails.getData().getHolder_family_member()));
            }
        }catch (Exception e){

        }
        if (modelSpecificTripDetails.getData().getHolder_user().isVisibility()) {
            placeholder.addView(new HolderDriver(this, modelSpecificTripDetails.getData().getHolder_user()));
        }
        if (modelSpecificTripDetails.getData().getHolder_metering().isVisibility()) {
            placeholder.addView(new HolderMetering(modelSpecificTripDetails.getData().getHolder_metering()));
        }
        if (modelSpecificTripDetails.getData().getHolder_receipt().isVisibility()) {
            placeholder.addView(new HolderReceipt(this, modelSpecificTripDetails.getData().getHolder_receipt()));
        }
        if(modelSpecificTripDetails.getData().getCancel_button_visibility().isVisibility()){

            cancel_btn_triphistory.setText(modelSpecificTripDetails.getData().getCancel_button_visibility().getButton_text());
            cancel_btn_triphistory.setBackgroundColor(Color.parseColor("#"+modelSpecificTripDetails.getData().getCancel_button_visibility().getText_back_ground()));
            cancel_btn_triphistory.setTextColor(Color.parseColor("#"+modelSpecificTripDetails.getData().getCancel_button_visibility().getText_color()));
            cancel_btn_triphistory.setVisibility(View.VISIBLE);

        }else {
            cancel_btn_triphistory.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private void setBottomButton(final ModelSpecificTripDetails.DataBeanXXXXXX.ButtonVisibilityBean data) {
        if(data.isVisibility()){bottomText.setVisibility(View.VISIBLE);}
        else{bottomText.setVisibility(View.GONE);}

        bottomText.setText(""+data.getButton_text());
        bottomText.setBackgroundColor(Color.parseColor("#"+data.getText_back_ground()));
        bottomText.setTextColor(Color.parseColor("#"+data.getText_color()));

    }
}
