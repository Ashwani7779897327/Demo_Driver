package com.apporio.demotaxiappdriver.earnings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.SpecificTripDetailsActivity;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelDailyEarning;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DailyStatementActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.place_holder)
    PlaceHolderView placeHolder;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.root)
    LinearLayout root;

    private SessionManager sessionManager;
    private ApiManager apiManager;
    private final String TAG = "WeeklyStatementActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_daily_statement);
        ButterKnife.bind(this);

        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this,this);

        back.setOnClickListener((View view) -> {
            finish();
        });

        swipeRefreshLayout.setOnRefreshListener(() -> {
            callAPI();
        });
        callAPI();

    }

    private void callAPI() {
        try {
            HashMap<String , String> data = new HashMap<>();
            data.put("bill_period",""+getIntent().getExtras().get(""+ IntentKeys.DATE));
            apiManager._post(API_S.Tags.DAILY_STATEMENT, API_S.Endpoints.DAILY_STATEMENT, data, sessionManager);
            placeHolder.removeAllViews();
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

    }


    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            swipeRefreshLayout.setRefreshing(true);
        } else {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            ModelDailyEarning modelDailyEarning = SingletonGson.getInstance().fromJson("" + script, ModelDailyEarning.class);
            placeHolder.addView(new HolderDailyTopLayout(modelDailyEarning.getData()));
            placeHolder.addView(new HolderDayLayout(modelDailyEarning.getData().getRides_data()));
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.e("" + TAG, "Exception caught while parsing " + e.getMessage());
        }


    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
    }

    @Layout(R.layout.holder_daily_statement_top_layout)
    private class HolderDailyTopLayout {

        @com.sam.placer.annotations.View(R.id.headDateTV)
        TextView headDateTV;
        @com.sam.placer.annotations.View(R.id.totalEarningTV)
        TextView totalEarningTV;
        @com.sam.placer.annotations.View(R.id.totalRidesTV)
        TextView totalRidesTV;
        @com.sam.placer.annotations.View(R.id.acceptance_rate)
        TextView acceptanceRate;
        @com.sam.placer.annotations.View(R.id.online_time)
        TextView onlineTime;
        @com.sam.placer.annotations.View(R.id.overall_rating)
        TextView overallRating;
        @com.sam.placer.annotations.View(R.id.consumer_billed)
        TextView consumerBilled;
        @com.sam.placer.annotations.View(R.id.commision_text)
        TextView commisionText;
        @com.sam.placer.annotations.View(R.id.net_earning)
        TextView netEarning;
        private ModelDailyEarning.DataBean mData;

        public HolderDailyTopLayout(ModelDailyEarning.DataBean data) {
            this.mData = data;
        }

        @Resolve
        private void setData(){
            headDateTV.setText(""+mData.getDate());
            totalEarningTV.setText(""+mData.getTotal_earning());
            totalRidesTV.setText(""+mData.getCompleted_trip());
            acceptanceRate.setText(""+mData.getAcceptance_rate());
            onlineTime.setText(""+mData.getOnline_time());
            overallRating.setText(""+mData.getOverall_rating());
            consumerBilled.setText(""+mData.getTotal_billed_to_customer());
            commisionText.setText(""+mData.getComission_deducted());
            netEarning.setText(""+mData.getTotal_earning());
        }
    }


    @Layout(R.layout.holder_day_layout)
    private class HolderDayLayout {


        @com.sam.placer.annotations.View(R.id.container)
        LinearLayout container;
        @com.sam.placer.annotations.View(R.id.day_name)
        TextView dayName;
        LayoutInflater mInflater;
        Calendar sCalendar;


        private List<ModelDailyEarning.DataBean.RidesDataBean> mDataBeans;

        public HolderDayLayout(List<ModelDailyEarning.DataBean.RidesDataBean> rides_data) {
            mInflater = (LayoutInflater) DailyStatementActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mDataBeans = rides_data;
        }

        @Resolve
        private void setData() {
            for (int i = 0; i < mDataBeans.size(); i++) {
                container.addView(getView(mDataBeans.get(i)));
                sCalendar = Calendar.getInstance();
                String dayLongName = sCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
                dayName.setText(""+dayLongName);
            }
        }


        private View getView(ModelDailyEarning.DataBean.RidesDataBean ridesDataBean) {
            View v = mInflater.inflate(R.layout.item_daily, null, true);

            TextView ride_text = v.findViewById(R.id.ride_text);
            TextView status_text = v.findViewById(R.id.status_text);
            TextView valueText = v.findViewById(R.id.value_text);
            LinearLayout root = v.findViewById(R.id.root);
            ride_text.setText("" + ridesDataBean.getRide_name());
            valueText.setText("" + ridesDataBean.getRide_earning());
            root.setOnClickListener((View view)->{
                startActivity(new Intent(DailyStatementActivity.this, SpecificTripDetailsActivity.class)
                        .putExtra(""+IntentKeys.BOOKING_ID,""+ridesDataBean.getRide_id()));
            });
            return v;

        }


    }


}
