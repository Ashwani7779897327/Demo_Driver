package com.apporio.demotaxiappdriver.rating_module;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelDriverRating;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.bumptech.glide.Glide;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DriverRatingActivity extends BaseActivity implements ApiManager.APIFETCHER, DatePickerDialog.OnDateSetListener {

    @Bind(R.id.ll_start_date)
    LinearLayout ll_start_date;
    @Bind(R.id.ll_end_date)
    LinearLayout ll_end_date;
    @Bind(R.id.start_date_txt)
    TextView start_date_txt;
    @Bind(R.id.end_date_txt)
    TextView end_date_txt;
    @Bind(R.id.btn_daily_rating)
    Button btn_daily_rating;
    @Bind(R.id.btn_weekly_rating)
    Button btn_weekly_rating;
    @Bind(R.id.btn_yearly_rating)
    Button btn_yearly_rating;
    @Bind(R.id.driver_name_rating)
    TextView driver_name;
    @Bind(R.id.driver_image_rating)
    ImageView driver_image;
    @Bind(R.id.rating_bar_rating)
    RatingBar ratingBar;

    String monthOfYear1;
    String dayOfMonth1;

    ApiManager apiManager;
    SessionManager sessionManager;
    boolean start_date_set = false;
    boolean btn_1 = false;
    boolean btn_2 = false;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_rating);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this, this);

        btn_daily_rating.setBackground(getDrawable(R.drawable.rating_button_dynamic_background));

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c);
        start_date_txt.setText("" + formattedDate);
        end_date_txt.setText("" + formattedDate);


        HashMap<String, String> data = new HashMap<>();
        data.put("start_date", "" + start_date_txt.getText().toString());
        data.put("end_date", "" + end_date_txt.getText().toString());
        try {
            apiManager._post("" + API_S.Tags.DRIVER_RATING, API_S.Endpoints.driver_rating, data, sessionManager);
        } catch (Exception e) {
            e.printStackTrace();
        }


        findViewById(R.id.ll_back_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverRatingActivity.this.finish();
            }
        });
        btn_daily_rating.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                btn_daily_rating.setBackground(getDrawable(R.drawable.rating_button_dynamic_background));
                btn_weekly_rating.setBackground(getDrawable(R.drawable.rating_button_background));
                btn_yearly_rating.setBackground(getDrawable(R.drawable.rating_button_background));
                ll_end_date.setVisibility(View.GONE);


//                btn_daily_rating.setBackgroundColor(Color.GREEN);
//                ll_end_date.setVisibility(View.GONE);
//                btn_yearly_rating.setBackgroundColor(Color.WHITE);
//                btn_weekly_rating.setBackgroundColor(Color.WHITE);

                btn_1 = true;

                Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = df.format(c);
                start_date_txt.setText("" + formattedDate);
                end_date_txt.setText("" + formattedDate);


                HashMap<String, String> data = new HashMap<>();
                data.put("start_date", "" + start_date_txt.getText().toString());
                data.put("end_date", "" + end_date_txt.getText().toString());
                try {
                    apiManager._post("" + API_S.Tags.DRIVER_RATING, API_S.Endpoints.driver_rating, data, sessionManager);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        btn_weekly_rating.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                btn_weekly_rating.setBackground(getDrawable(R.drawable.rating_button_dynamic_background));
                btn_daily_rating.setBackground(getDrawable(R.drawable.rating_button_background));
                btn_yearly_rating.setBackground(getDrawable(R.drawable.rating_button_background));
                ll_end_date.setVisibility(View.VISIBLE);


//                btn_weekly_rating.setBackgroundColor(Color.GREEN);
//                btn_daily_rating.setBackgroundColor(Color.WHITE);
//                btn_yearly_rating.setBackgroundColor(Color.WHITE);
                //            ll_end_date.setVisibility(View.VISIBLE);


            }
        });


        btn_yearly_rating.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {


                btn_yearly_rating.setBackground(getDrawable(R.drawable.rating_button_dynamic_background));
                btn_daily_rating.setBackground(getDrawable(R.drawable.rating_button_background));
                btn_weekly_rating.setBackground(getDrawable(R.drawable.rating_button_background));
                ll_end_date.setVisibility(View.VISIBLE);

//                btn_yearly_rating.setBackgroundColor(Color.GREEN);
//                ll_end_date.setVisibility(View.VISIBLE);
//                btn_daily_rating.setBackgroundColor(Color.WHITE);
//                btn_weekly_rating.setBackgroundColor(Color.WHITE);


            }
        });


        start_date_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(DriverRatingActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                //  dpd.setMinDate(calendar);
                dpd.setCancelText("" + getResources().getString(R.string.cancel));
                dpd.setOkText("" + getResources().getString(R.string.ok));
                dpd.setAccentColor(DriverRatingActivity.this.getResources().getColor(R.color.colorPrimary));
                dpd.show(getFragmentManager(), "dialog");
                btn_1 = true;

            }
        });


        end_date_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(DriverRatingActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                //    dpd.setMinDate(calendar);
                dpd.setCancelText("" + getResources().getString(R.string.cancel));
                dpd.setOkText("" + getResources().getString(R.string.ok));
                dpd.setAccentColor(DriverRatingActivity.this.getResources().getColor(R.color.colorPrimary));
                dpd.show(getFragmentManager(), "dialog");
                btn_2 = true;
            }
        });


    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

        try {
            ModelDriverRating modelDriverRating = SingletonGson.getInstance().fromJson("" + script, ModelDriverRating.class);

            if (modelDriverRating.getResult().equals("1")) {

                driver_name.setText("" + modelDriverRating.getData().getName());
                Glide.with(this).load("" + modelDriverRating.getData().getImage()).into(driver_image);
                ratingBar.setRating(Float.parseFloat(modelDriverRating.getData().getRating()));
                ratingBar.setEnabled(false);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        if (monthOfYear < 10) {
            monthOfYear1 = "0" + String.valueOf(monthOfYear);
        } else {
            monthOfYear1 = String.valueOf(monthOfYear);
        }
        if (dayOfMonth < 10) {
            dayOfMonth1 = "0" + String.valueOf(dayOfMonth);
        } else {
            dayOfMonth1 = String.valueOf(dayOfMonth);
        }


        if (btn_1 == true) {
            start_date_txt.setText("" + year + "-" + monthOfYear1 + "-" + dayOfMonth1);

            HashMap<String, String> data = new HashMap<>();
            data.put("start_date", "" + start_date_txt.getText().toString());
            data.put("end_date", "" + start_date_txt.getText().toString());
            try {
                apiManager._post("" + API_S.Tags.DRIVER_RATING, API_S.Endpoints.driver_rating, data, sessionManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
            btn_1 = false;
        } else if (btn_2 == true) {

            end_date_txt.setText("" + year + "-" + monthOfYear1 + "-" + dayOfMonth1);
            HashMap<String, String> data = new HashMap<>();
            data.put("start_date", "" + start_date_txt.getText().toString());
            data.put("end_date", "" + end_date_txt.getText().toString());
            try {
                apiManager._post("" + API_S.Tags.DRIVER_RATING, API_S.Endpoints.driver_rating, data, sessionManager);
                btn_1 = false;
            } catch (Exception e) {
                e.printStackTrace();
            }

            btn_2 = false;

        }

    }
}
