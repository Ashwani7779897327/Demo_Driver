package com.apporio.demotaxiappdriver.earnings;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.ModelNewEarnings;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.holder.HolderShowNetEarnings;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewEarningActivity extends AppCompatActivity implements ApiManager.APIFETCHER, android.view.View.OnClickListener {

    @Bind(R.id.placeHoder)
    PlaceHolderView placeHoder;
    @Bind(R.id.rightClick)
    LinearLayout rightClick;
    @Bind(R.id.leftClick)
    LinearLayout leftClick;
    @Bind(R.id.selectedDate)
    TextView selectedDate;

    private final String TAG = "EarningActivity";
    HashMap<String, String> data = new HashMap<>();

    private SessionManager sessionManager;
    private ApiManager apiManager;
    ProgressDialog progressDialog;
    ModelNewEarnings modelNewEarnings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_earning);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this, this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));

        ButterKnife.bind(this);
        setToolbar();
        try {
            callApi();
        } catch (Exception e) {
            e.printStackTrace();
        }

        leftClick.setOnClickListener(this);
        rightClick.setOnClickListener(this);
    }

    private void setToolbar() {
        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.earnings));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        mToolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                onBackPressed();
            }
        });
    }

    private void callApi() throws Exception {
        apiManager._post(API_S.Tags.NEW_EARNING, API_S.Endpoints.NEW_EARNING, null, sessionManager);
        placeHoder.removeAllViews();
    }


    private void callApiForSelect(String value) throws Exception {
        data.clear();
        data.put("bill_period", "" + value);
        apiManager._post(API_S.Tags.NEW_EARNING, API_S.Endpoints.NEW_EARNING, data, sessionManager);
        placeHoder.removeAllViews();
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        try {
            if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                progressDialog.show();
            } else {
                progressDialog.hide();
            }
        }catch (Exception e) {

        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

        try {
            modelNewEarnings = SingletonGson.getInstance().fromJson("" + script, ModelNewEarnings.class);
            selectedDate.setText(modelNewEarnings.getData().getCurrent_period());
            placeHoder.addView(new HolderSetEarnings(this, modelNewEarnings));

            if(modelNewEarnings.getData().getPrevious_period()==null||modelNewEarnings.getData().getPrevious_period().equals("")){
                leftClick.setVisibility(android.view.View.GONE);
            }else {
                leftClick.setVisibility(android.view.View.VISIBLE);
            }

            if(modelNewEarnings.getData().getNext_period()==null||modelNewEarnings.getData().getNext_period().equals("")){
                rightClick.setVisibility(android.view.View.GONE);
            }else {
                rightClick.setVisibility(android.view.View.VISIBLE);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }

    @Override
    public void onClick(android.view.View view) {

        switch (view.getId()) {

            case R.id.leftClick:
                try {
                    callApiForSelect(modelNewEarnings.getData().getPrevious_period());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.rightClick:

                try {
                    callApiForSelect(modelNewEarnings.getData().getNext_period());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }
    }


    @Layout(R.layout.holder_earning_top_view)
    public class HolderSetEarnings {

        @View(R.id.placeHolder)
        PlaceHolderView placeHolderData;

        @View(R.id.tvTotalEarnings)
        TextView tvTotalEarnings;
        @View(R.id.tvTotalRides)
        TextView tvTotalRides;
        @View(R.id.tvBalanceDue)
        TextView tvBalanceDue;
        @View(R.id.tvBillMessage)
                TextView tvBillMessage;
        @View(R.id.ivInfoDetails)
                ImageView ivInfoDetails;

        Context context;
        ModelNewEarnings modelNewEarnings;

        public HolderSetEarnings(Context context, ModelNewEarnings modelNewEarnings) {
            this.context = context;
            this.modelNewEarnings = modelNewEarnings;
        }


        @Click(R.id.ivInfoDetails)
        private void onClickInfoDetails(){
            startActivity(new Intent(NewEarningActivity.this,DailyStatementActivity.class).putExtra(""+IntentKeys.DATE,""+modelNewEarnings.getData().getCurrent_period_forsend()));
        }

        @SuppressLint("SetTextI18n")
        @Resolve
        private void setData() {

            if(modelNewEarnings.getData().getHolder_data().size()>0){
                ivInfoDetails.setVisibility(android.view.View.VISIBLE);
            }
            tvTotalEarnings.setText("" + modelNewEarnings.getData().getTotal_earnings());
            tvTotalRides.setText("" + modelNewEarnings.getData().getTrips());
            tvBalanceDue.setText("" + modelNewEarnings.getData().getBalance_due());
            tvBillMessage.setText(""+ modelNewEarnings.getData().getSettled_message());

            placeHolderData.addView(new HolderShowNetEarnings(context, modelNewEarnings.getData().getHolder_data()));
            tvBillMessage.setTextColor(Color.parseColor("#"+modelNewEarnings.getData().getSettled_message_colour()));
        }

    }
}
