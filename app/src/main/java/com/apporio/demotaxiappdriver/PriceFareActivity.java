package com.apporio.demotaxiappdriver;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.manager.LanguageManager;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.urls.Apis;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.apporio.demotaxiappdriver.models.DoneRideInfo;
import com.apporio.demotaxiappdriver.models.deviceid.DeviceId;
import com.apporio.demotaxiappdriver.samwork.ApiManager;

public class PriceFareActivity extends BaseActivity implements ApiManager.APIFETCHER {

    public static Activity pricefare;

    ProgressDialog pd;

    SessionManager sessionManager;
    String driver_token;
    LanguageManager languageManager;
    String language_id;
    TextView pay_mode, pick_location_txt, drop_location_txt, total_payble_fare_txt_large,tv_payment_status,tv_payment_text;
    ApiManager apiManager;
    DoneRideInfo doneRideInfo;
    EditText comments;
    Button btn_rate_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiManager = new ApiManager(this,this);
        languageManager = new LanguageManager(this);
        setContentView(R.layout.activity_new_price_fare);
        getSupportActionBar().hide();
        pricefare = this;
        pd = new ProgressDialog(this);
        pd.setMessage("" + this.getResources().getString(R.string.loading));


        language_id = languageManager.getLanguageDetail().get(LanguageManager.LANGUAGE_ID);

        sessionManager = new SessionManager(this);
        driver_token = sessionManager.getUserDetails().get(SessionManager.KEY_DriverToken);

        btn_rate_user = (Button) findViewById(R.id.btn_rate_user);
        pay_mode = (TextView) findViewById(R.id.pay_mode);
        tv_payment_status = (TextView) findViewById(R.id.tv_payment_status);
        tv_payment_text = (TextView) findViewById(R.id.tv_payment_text);
        drop_location_txt = (TextView) findViewById(R.id.drop_location_txt);
        pick_location_txt = (TextView) findViewById(R.id.pick_location_txt);
        comments = (EditText) findViewById(R.id.comments);
        total_payble_fare_txt_large = (TextView) findViewById(R.id.total_payble_fare_txt_large);
        //ride_id = getIntent().getExtras().getString("ride_id");

//        findViewById(R.id.pay_try).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                apiManager.execution_method_get(Config.ApiKeys.KEY_View_done_ride_info, Apis.baseDomain + "?done_ride_id=" + ride_id + "&language_id=" + languageManager.getLanguageDetail().get(LanguageManager.LANGUAGE_ID));
//
//            }
//        });

        findViewById(R.id.btn_view_receipt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialofForViewReceipt();
            }
        });

        findViewById(R.id.ll_reload_ride_fare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiManager.execution_method_get(Config.ApiKeys.KEY_View_done_ride_info, Apis.viewDoneRide + "?done_ride_id=" + getIntent().getExtras().getString("done_ride_id") + "&language_id=" + languageManager.getLanguageDetail().get(LanguageManager.LANGUAGE_ID));
            }
        });


        btn_rate_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialofForRating();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        apiManager.execution_method_get(Config.ApiKeys.KEY_View_done_ride_info, Apis.viewDoneRide + "?done_ride_id=" + getIntent().getExtras().getString("done_ride_id") + "&language_id=" + languageManager.getLanguageDetail().get(LanguageManager.LANGUAGE_ID));

    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            pd.show();
        } else {
            pd.dismiss();
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            if (APINAME.equals(Config.ApiKeys.KEY_View_done_ride_info)) {
                doneRideInfo = new DoneRideInfo();
                doneRideInfo = gson.fromJson("" + script, DoneRideInfo.class);

                if (doneRideInfo.getResult() == 1) {

                    if (doneRideInfo.getMsg().getPayment_option_id().equals("1")) {
                        pay_mode.setText(getResources().getString(R.string.PRICE_FARE_payment_mode)+" "+ getResources().getString(R.string.PRICE_FARE_payment_cash));
                    } else if (doneRideInfo.getMsg().getPayment_option_id().equals("2")) {
                        pay_mode.setText(getResources().getString(R.string.PRICE_FARE_payment_mode)+" "+ getResources().getString(R.string.PRICE_FARE_payment_paypal));
                    } else if (doneRideInfo.getMsg().getPayment_option_id().equals("3")) {
                        pay_mode.setText(getResources().getString(R.string.PRICE_FARE_payment_mode)+" "+ getResources().getString(R.string.PRICE_FARE_payment_card));
                    } else if (doneRideInfo.getMsg().getPayment_option_id().equals("4")) {
                        pay_mode.setText(getResources().getString(R.string.PRICE_FARE_payment_mode)+" "+ getResources().getString(R.string.PRICE_FARE_payment_wallet));
                    }

                    if(doneRideInfo.getMsg().getPayment_status().equals("0")){
                        btn_rate_user.setVisibility(View.GONE);
                    }
                    else if(doneRideInfo.getMsg().getPayment_status().equals("1")){
                        btn_rate_user.setVisibility(View.VISIBLE);
                    }

                    pick_location_txt.setText("" + doneRideInfo.getMsg().getBegin_location());
                    drop_location_txt.setText("" + doneRideInfo.getMsg().getEnd_location());

                    tv_payment_text.setText(doneRideInfo.getMsg().getPayment_status_message().toString());
                    tv_payment_status.setText(getResources().getString(R.string.PRICE_FARE_payment_status)+ " "+doneRideInfo.getMsg().getPayment_status_show());
                    total_payble_fare_txt_large.setText("" + sessionManager.getCurrencyCode() + doneRideInfo.getMsg().getAmount_show());

                } else {
                    Toast.makeText(PriceFareActivity.this, "" + doneRideInfo.getMsg().toString(), Toast.LENGTH_SHORT).show();
                }
            }
            if (APINAME.equals(Config.ApiKeys.KEY_RATING_DRIVER)) {
                DeviceId deviceId = new DeviceId();
                deviceId = gson.fromJson("" + script, DeviceId.class);

                if (deviceId.getResult().toString().equals("1")) {
                    Toast.makeText(this, "" + deviceId.getMsg(), Toast.LENGTH_SHORT).show();

                    finalizeOtherActivities();
                } else if (deviceId.getResult().toString().equals("419")) {
//                    sessionManager.logoutUser();
//                    Intent intent = new Intent(this, SplashActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
//                    finish();
                } else {
                    Toast.makeText(this, "" + deviceId.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }

    private void finalizeOtherActivities() {
        finish();
        try {
            TripHistoryActivity.activity.finish();
        } catch (Exception e) {

        }
        try {
//            SelectedRidesActivity.activity.finish();
        } catch (Exception e) {

        }

    }


    private void showDialofForViewReceipt() {
        final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Setting dialogview
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
        dialog.setTitle(null);
        dialog.setContentView(R.layout.dialog_rate_us);
        dialog.setCancelable(false);

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_view_receipt);


        TextView tv_ride_distance = (TextView) dialog.findViewById(R.id.tv_ride_distance);
        TextView tv_waiting_time = (TextView) dialog.findViewById(R.id.tv_waiting_time);
        TextView tv_total_time = (TextView) dialog.findViewById(R.id.tv_total_time);

        TextView fare_txt = (TextView) dialog.findViewById(R.id.fare_txt);
        TextView ride_time_charges_txt = (TextView) dialog.findViewById(R.id.ride_time_charges_txt);
        TextView waiting_charge_txt = (TextView) dialog.findViewById(R.id.waiting_charge_txt);
        TextView coupon_price_txt = (TextView) dialog.findViewById(R.id.coupon_price_txt);
        TextView coupon_code_txt = (TextView) dialog.findViewById(R.id.coupon_code_txt);
        TextView tv_ride_fare = (TextView) dialog.findViewById(R.id.tv_ride_fare);

        LinearLayout coupon_layout = (LinearLayout) dialog.findViewById(R.id.coupon_layout);
        TextView night_charge_txt = (TextView) dialog.findViewById(R.id.night_charge_txt);
        TextView peak__charge_txt_charge_txt = (TextView) dialog.findViewById(R.id.peak__charge_txt_charge_txt);

        fare_txt.setText("" + sessionManager.getCurrencyCode() + doneRideInfo.getMsg().getAmount());

        tv_ride_fare.setText("" + sessionManager.getCurrencyCode() + doneRideInfo.getMsg().getTotal_amount());
        waiting_charge_txt.setText("" + sessionManager.getCurrencyCode() + doneRideInfo.getMsg().getWaiting_price());

        tv_ride_distance.setText("" + doneRideInfo.getMsg().getDistance());
        tv_waiting_time.setText("" + doneRideInfo.getMsg().getWaiting_time());
        tv_total_time.setText("" + doneRideInfo.getMsg().getTot_time() + "min");
        ride_time_charges_txt.setText("" + sessionManager.getCurrencyCode() + doneRideInfo.getMsg().getRide_time_price());
        night_charge_txt.setText("" + sessionManager.getCurrencyCode() + doneRideInfo.getMsg().getNight_time_charge());
        peak__charge_txt_charge_txt.setText("" + sessionManager.getCurrencyCode() + doneRideInfo.getMsg().getPeak_time_charge());
        if (doneRideInfo.getMsg().getCoupons_code().equals("")) {
            coupon_layout.setVisibility(View.GONE);
        } else {
            coupon_layout.setVisibility(View.VISIBLE);
            coupon_code_txt.setText(getString(R.string.PRICE_FARE_coupon) + doneRideInfo.getMsg().getCoupons_code() + ")");
            coupon_price_txt.setText("-" + sessionManager.getCurrencyCode() + doneRideInfo.getMsg().getCoupons_price());
        }

        dialog.findViewById(R.id.rl_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    private void showDialofForRating() {
        final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Setting dialogview
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
        dialog.setTitle(null);
        dialog.setContentView(R.layout.dialog_rate_us);
        dialog.setCancelable(true);


//        Window window = dialog.getWindow();
//        dialog.setCancelable(true);
//        window.setGravity(Gravity.CENTER);
//        window.setGravity(Gravity.CENTER_VERTICAL);

        final RatingBar rating_bar = (RatingBar) dialog.findViewById(R.id.rating_bar);

        dialog.findViewById(R.id.ll_submit_rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = String.valueOf(rating_bar.getRating());
                if (rating.equals("0.0")) {
                    Toast.makeText(PriceFareActivity.this, PriceFareActivity.this.getResources().getString(R.string.please_select_stars), Toast.LENGTH_SHORT).show();
                } else {
                    String user_id = doneRideInfo.getMsg().getUser_id().toString();
                    Log.d("user_id===", doneRideInfo.getMsg().getUser_id().toString());
                    apiManager.execution_method_get(Config.ApiKeys.KEY_RATING_DRIVER, Apis.ratingDriver + "?ride_id=" + doneRideInfo.getMsg().getRide_id().toString() + "&driver_id=" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID) + "&user_id=" + user_id + "&rating_star=" + rating + "&comment=" + comments.getText().toString() + "&driver_token=" + sessionManager.getUserDetails().get(SessionManager.KEY_DriverToken) + "&language_id=" + languageManager.getLanguageDetail().get(LanguageManager.LANGUAGE_ID));
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }

}
