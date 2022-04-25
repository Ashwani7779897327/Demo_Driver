package com.apporio.demotaxiappdriver;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.cardview.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ReferAndEarnActivity extends BaseActivity implements ApiManager.APIFETCHER {

    private SessionManager sessionManager;
    private ApiManager apiManagerNew;
    private final String TAG = "ReferAndEarnActivity";
    private ModelReferAndEarn modelReferAndEarn;

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.share_button)
    Button shareButton;
    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.refer_image)
    ImageView referImage;
    @Bind(R.id.refer_headline)
    TextView referHeadline;
    @Bind(R.id.refer_description)
    TextView referDescription;
    @Bind(R.id.start_date)
    TextView startDate;
    @Bind(R.id.end_dte)
    TextView endDte;
    @Bind(R.id.refer_code)
    TextView referCode;
    @Bind(R.id.main_layout)
    LinearLayout mainLayout;
    @Bind(R.id.llReferData)
    LinearLayout llReferData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_and_earn);
        getSupportActionBar().hide();

        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        apiManagerNew = new ApiManager(this, this);
        callAPI();

        back.setOnClickListener((View view) -> {
            finish();
        });

        shareButton.setOnClickListener((View view) -> {
            try {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "" + modelReferAndEarn.getData().getSharing_text());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } catch (Exception e) {
                Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            }


        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callAPI();
            }
        });


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

        Log.d("**MODEL_REFER", ""+script);

        modelReferAndEarn = SingletonGson.getInstance().fromJson("" + script, ModelReferAndEarn.class);
        mainLayout.setVisibility(View.VISIBLE);
        Glide.with(this).load("" + modelReferAndEarn.getData().getRefer_image()).into(referImage);
        referHeadline.setText("" + modelReferAndEarn.getData().getRefer_heading());
        referDescription.setText("" + modelReferAndEarn.getData().getRefer_explanation());

        if (!modelReferAndEarn.getData().getStart_date().equals("")) {
            llReferData.setVisibility(View.VISIBLE);
            startDate.setText("" + modelReferAndEarn.getData().getStart_date());
            endDte.setText("" + modelReferAndEarn.getData().getEnd_date());
        } else {
            llReferData.setVisibility(View.GONE);
        }
        referCode.setText("" + modelReferAndEarn.getData().getRefer_code());
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
    }

    private void callAPI() {
        try {
            apiManagerNew._post(API_S.Tags.REFER_AND_EARN, API_S.Endpoints.REFER_AND_EARN, null, sessionManager);

            Log.d("**MODEL_REFER-API", ""+API_S.Endpoints.REFER_AND_EARN);

            mainLayout.setVisibility(View.GONE);
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
        }

    }
}
