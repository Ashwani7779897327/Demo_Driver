package com.apporio.demotaxiappdriver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.restmodels.NewRidehistoryModel;
import com.apporio.demotaxiappdriver.models.restmodels.ResultStatusChecker;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.apporio.demotaxiappdriver.urls.Apis;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import java.util.HashMap;


public class RidesActivity extends BaseActivity implements ApiManager.APIFETCHER {

    LinearLayout ll_back_rides;
    public static Activity ridesActivity;
    SessionManager sessionManager;
    ApiManager apiManager;
    ProgressBar progressBar;
    PlaceHolderView place_holder;

    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        apiManager = new ApiManager(this,this);
        sessionManager = new SessionManager(this);
        ridesActivity = this;
        setContentView(R.layout.activity_rides);
        getSupportActionBar().hide();
        ll_back_rides = (LinearLayout) findViewById(R.id.ll_back_rides);
        progressBar = (ProgressBar) findViewById(R.id.progress_wheel);
        place_holder = (PlaceHolderView) findViewById(R.id.place_holder);

        try {
            RentalTrackRideActivity.activity.finish();
        } catch (Exception e) {
        }
        try {
//            TrackRideActivity.activity.finish();
        } catch (Exception e) {
        }

        ll_back_rides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        HashMap<String, String> data = new HashMap<>();
        data.put("driver_id", "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID));
        apiManager.execution_method_post("" + Config.ApiKeys.KEY_REST_UPCOMING, "" + Apis.UpcomingRides, data);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            place_holder.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STOPPED) {
            place_holder.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            ResultStatusChecker rs = gson.fromJson("" + script, ResultStatusChecker.class);
            if (rs.getStatus() == 1) {
                NewRidehistoryModel rideshistory_response = gson.fromJson("" + script, NewRidehistoryModel.class);

                for (int i = 0; i < rideshistory_response.getDetails().size(); i++) {

                    if (rideshistory_response.getDetails().get(i).getRide_mode().equals("1")) {   // ride type normal

                        if (rideshistory_response.getDetails().get(i).getNormal_Ride().getRide_status().equals("1") || rideshistory_response.getDetails().get(i).getNormal_Ride().getRide_status().equals("8") || rideshistory_response.getDetails().get(i).getNormal_Ride().getRide_status().equals("10")) {
                            place_holder.addView(new HolderRideHistoryNormal(this, rideshistory_response.getDetails().get(i).getNormal_Ride()));

                        }
                    } else if (rideshistory_response.getDetails().get(i).getRide_mode().equals("2")) {   // ride type Rentals

                        if (rideshistory_response.getDetails().get(i).getRental_Ride().getBooking_status().equals("1") || rideshistory_response.getDetails().get(i).getRental_Ride().getBooking_status().equals("10")) {
                            place_holder.addView(new HolderRentalRideHistory(this, rideshistory_response.getDetails().get(i).getRental_Ride()));

                        }
                    }
                }
            }
        } catch (Exception e) {
        }


    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }

    @Layout(R.layout.rides_item_new)
    public class HolderRideHistoryNormal {
        @com.sam.placer.annotations.View(R.id.tv_date_time)
        private TextView tv_date_time;
        @com.sam.placer.annotations.View(R.id.tv_pickup_addresss)
        private TextView tv_pickup_addresss;
        @com.sam.placer.annotations.View(R.id.tv_drop_addresss)
        private TextView tv_drop_addresss;
        @com.sam.placer.annotations.View(R.id.customer_name_txt)
        private TextView customer_name_txt;
        @com.sam.placer.annotations.View(R.id.customer_phone_txt)
        private TextView customer_phone_txt;
        @com.sam.placer.annotations.View(R.id.tv_status)
        private TextView tv_status;

        NewRidehistoryModel.DetailsBean.NormalRideBean mNormalRideResponse;

        public HolderRideHistoryNormal(Context context, NewRidehistoryModel.DetailsBean.NormalRideBean normalRideResponse) {
            mNormalRideResponse = normalRideResponse;
        }

        @Resolve
        private void onResolved() {
            tv_date_time.setText("#" + mNormalRideResponse.getRide_id() + "  " + mNormalRideResponse.getLater_date() + " | " + mNormalRideResponse.getLater_time());
            tv_pickup_addresss.setText("" + mNormalRideResponse.getPickup_location());
            tv_drop_addresss.setText("" + mNormalRideResponse.getDrop_location());
            customer_name_txt.setText("" + mNormalRideResponse.getUser_name());
            customer_phone_txt.setText("" + mNormalRideResponse.getUser_phone());
            tv_status.setText(R.string.accept_pass);
        }

        @Click(R.id.root)
        private void onclick() {
            String date_time = mNormalRideResponse.getRide_date() + ", " + mNormalRideResponse.getRide_time();

//            activity.startActivity(new Intent(activity.getBaseContext(), AcceptPassActivity.class)
//                    .putExtra("ride_id", "" + mNormalRideResponse.getRide_id())
//                    .putExtra("ride_status", "" + mNormalRideResponse.getRide_status())
//                    .putExtra("ride_type", "1")
//                    .putExtra("later_date", mNormalRideResponse.getLater_date())
//                    .putExtra("later_time", mNormalRideResponse.getLater_time())
//                    .putExtra("booking_date", mNormalRideResponse.getRide_date())
//                    .putExtra("booking_time", mNormalRideResponse.getRide_time())
//                    .putExtra("user_name", mNormalRideResponse.getUser_name())
//                    .putExtra("user_phone", mNormalRideResponse.getUser_phone())
//                    .putExtra("user_rating", mNormalRideResponse.getUser_rating())
//                    .putExtra("user_image", "" + mNormalRideResponse.getUser_image())
//                    .putExtra("pick_up_location", "" + mNormalRideResponse.getPickup_location())
//                    .putExtra("drop_off_location", "" + mNormalRideResponse.getDrop_location()));
//            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        }
    }


    @Layout(R.layout.ride_history_rental_item)
    public class HolderRentalRideHistory {

        @com.sam.placer.annotations.View(R.id.tv_date_time)
        private TextView tv_date_time;
        @com.sam.placer.annotations.View(R.id.tv_pickup_addresss)
        private TextView tv_pickup_addresss;
        @com.sam.placer.annotations.View(R.id.tv_drop_addresss)
        private TextView tv_drop_addresss;
        @com.sam.placer.annotations.View(R.id.customer_name_txt)
        private TextView customer_name_txt;
        @com.sam.placer.annotations.View(R.id.customer_phone_txt)
        private TextView customer_phone_txt;
        @com.sam.placer.annotations.View(R.id.tv_status)
        private TextView tv_status;
        @com.sam.placer.annotations.View(R.id.drop_locatipon_layout)
        private LinearLayout drop_locatipon_layout;


        NewRidehistoryModel.DetailsBean.RentalRideBean mRentalRideResponse;


        private Context mContext;

        public HolderRentalRideHistory(Context context, NewRidehistoryModel.DetailsBean.RentalRideBean rental_ride) {
            mContext = context;
            mRentalRideResponse = rental_ride;
        }

        @Resolve
        private void onResolved() {
            tv_date_time.setText("" + mRentalRideResponse.getBooking_date());
            tv_pickup_addresss.setText("" + mRentalRideResponse.getPickup_location());
            tv_drop_addresss.setText("" + mRentalRideResponse.getEnd_location());
            customer_name_txt.setText("" + mRentalRideResponse.getUser_name());
            customer_phone_txt.setText("" + mRentalRideResponse.getUser_phone());
            tv_status.setText("" + Config.getStatustext("" + mRentalRideResponse.getBooking_status()));

            if (mRentalRideResponse.getEnd_location().equals("")) {
                drop_locatipon_layout.setVisibility(View.GONE);
            }
        }


        @Click(R.id.root)
        private void onclick() {
            String date_time = mRentalRideResponse.getBooking_date() + ", " + mRentalRideResponse.getBooking_time();
//
//            activity.startActivity(new Intent(activity.getBaseContext(), AcceptPassActivity.class)
//                    .putExtra("ride_id", "" + mRentalRideResponse.getRental_booking_id())
//                    .putExtra("ride_status", "" + mRentalRideResponse.getBooking_status())
//                    .putExtra("ride_type", "2")
//                    .putExtra("later_date", mRentalRideResponse.getBooking_date())
//                    .putExtra("later_time", mRentalRideResponse.getBooking_time())
//                    .putExtra("booking_date", mRentalRideResponse.getUser_booking_date_time())
//                    .putExtra("booking_time", "")
//                    .putExtra("user_name", mRentalRideResponse.getUser_name())
//                    .putExtra("user_phone", mRentalRideResponse.getUser_phone())
//                    .putExtra("user_rating", mRentalRideResponse.getRating())
//                    .putExtra("user_image", "" + mRentalRideResponse.getUser_image())
//                    .putExtra("pick_up_location", "" + mRentalRideResponse.getPickup_location())
//                    .putExtra("drop_off_location", "" + mRentalRideResponse.getEnd_location()));
////            startActivity(new Intent(RidesActivity.this, SelectedRentalRideActivity.class)
////                    .putExtra("ride_id", "" + mRentalRideResponse.getRental_booking_id())
////                    .putExtra("ride_status", "" + mRentalRideResponse.getBooking_status())
////                    .putExtra("date_time", date_time)
////                    .putExtra("ride_mode", "2"));
//            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        }

    }


}
