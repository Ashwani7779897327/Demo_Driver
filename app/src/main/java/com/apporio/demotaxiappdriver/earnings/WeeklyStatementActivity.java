package com.apporio.demotaxiappdriver.earnings;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelWeeklyStatement;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WeeklyStatementActivity extends BaseActivity implements ApiManager.APIFETCHER {


    @Bind(R.id.place_holder) PlaceHolderView placeHolder;
    @Bind(R.id.root) LinearLayout root;
    @Bind(R.id.swiperefreshLayout)
    SwipeRefreshLayout swiperefreshLayout;
    @Bind(R.id.back) ImageView back;

    private SessionManager sessionManager;
    private ApiManager apiManager;
    private final String TAG = "WeeklyStatementActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_statement);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this,this);

        back.setOnClickListener((View view) -> {
            finish();
        });

        swiperefreshLayout.setOnRefreshListener(() -> {
            callAPI();
        });
        callAPI();

    }


    private void callAPI() {
        try {
            HashMap<String , String > data = new HashMap<>();
            data.put("date",""+getIntent().getExtras().getString(""+ IntentKeys.DATE));
            apiManager._post(API_S.Tags.WEEKLY_STATEMENTS, API_S.Endpoints.WEEKLY_STATEMENTS, data, sessionManager);
            placeHolder.removeAllViews();
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            swiperefreshLayout.setRefreshing(true);
        } else {
            swiperefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            ModelWeeklyStatement modelWeeklyStatement = SingletonGson.getInstance().fromJson("" + script, ModelWeeklyStatement.class);
            placeHolder.addView(new HolderWeeklyTopLayout(modelWeeklyStatement.getData()));
            placeHolder.addView(new HolderWeekDayLayout(modelWeeklyStatement.getData().getWeekly_data()));
        } catch (Exception e) {
            Log.d("" + TAG, "Exception caught while parsing " + e.getMessage());
        }


    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
    }

    @Layout(R.layout.holder_top_layout)
    private class HolderWeeklyTopLayout {

        @com.sam.placer.annotations.View(R.id.weekDatesTV)
        TextView weekDatesTV;
        @com.sam.placer.annotations.View(R.id.totalEarningTV)
        TextView totalEarningTV;
        @com.sam.placer.annotations.View(R.id.completedTripsTV)
        TextView completedTripsTV;
        @com.sam.placer.annotations.View(R.id.consumer_billed)
        TextView consumerBilled;
        @com.sam.placer.annotations.View(R.id.commision_text)
        TextView commisionText;
        @com.sam.placer.annotations.View(R.id.net_earning)
        TextView netEarning;

        private ModelWeeklyStatement.DataBean mData;

        public HolderWeeklyTopLayout(ModelWeeklyStatement.DataBean data) {
            this.mData = data;
        }


        @Resolve
        private void setdata() {
            weekDatesTV.setText("" + mData.getDate_text());
            totalEarningTV.setText("" + mData.getTotal_earning());
            completedTripsTV.setText("" + mData.getTotal_ride());
            consumerBilled.setText("" + mData.getTotal_billed_to_consumer());
            commisionText.setText("" + mData.getTotal_commision_deducted());
            netEarning.setText("" + mData.getTotal_earning());
        }


    }

    @Layout(R.layout.holder_week_day_layout)
    private class HolderWeekDayLayout {

        LayoutInflater mInflater;
        @com.sam.placer.annotations.View(R.id.container)
        LinearLayout container;
        private List<ModelWeeklyStatement.DataBean.WeeklyDataBean> mData;

        public HolderWeekDayLayout(List<ModelWeeklyStatement.DataBean.WeeklyDataBean> weekly_data) {
            mInflater = (LayoutInflater) WeeklyStatementActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.mData = weekly_data ;
        }

        @Resolve
        public void setData() {
            for (int i = 0; i < mData.size(); i++) {
                container.addView(getView(mData.get(i)));
            }
        }


        private View getView(ModelWeeklyStatement.DataBean.WeeklyDataBean weeklyDataBean) {
            View v = mInflater.inflate(R.layout.item_weekly, null, true);
            TextView day_text = (TextView) v.findViewById(R.id.day_text);
            TextView rides_text = (TextView) v.findViewById(R.id.rides_text);
            TextView value_text = (TextView) v.findViewById(R.id.value_text);
            day_text.setText(""+weeklyDataBean.getDay_name());
            rides_text.setText(""+weeklyDataBean.getRides());
            rides_text.setTextColor(Color.parseColor("#"+weeklyDataBean.getRides_color()));
            value_text.setText(""+weeklyDataBean.getDay_earning());
            v.findViewById(R.id.root).setOnClickListener((View view)->{
                startActivity(new Intent(WeeklyStatementActivity.this,DailyStatementActivity.class).putExtra(""+IntentKeys.DATE,""+weeklyDataBean.getDate()));
            });
            return v;

        }


    }


}
