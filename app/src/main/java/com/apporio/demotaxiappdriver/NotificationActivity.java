package com.apporio.demotaxiappdriver;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelPromotionalNotification;
import com.bumptech.glide.Glide;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Position;
import com.sam.placer.annotations.Resolve;
import com.apporio.demotaxiappdriver.samwork.ApiManager;

import com.apporio.demotaxiappdriver.urls.Apis;
import com.squareup.picasso.Picasso;

import java.util.HashMap;


import butterknife.Bind;
import butterknife.ButterKnife;

public class NotificationActivity extends BaseActivity implements ApiManager.APIFETCHER {


    @Bind(R.id.placeHolder)
    PlaceHolderView placeHolder;
    @Bind(R.id.back)
    LinearLayout back;
    @Bind(R.id.root)
    LinearLayout root;


    @Bind(R.id.swiperefreshLayout)
    SwipeRefreshLayout swiperefreshLayout;

    private final String TAG = "NotificationActivity";
    ApiManager apiManagerNew;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiManagerNew = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        callApi();

        swiperefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callApi();
            }
        });


    }

    private void callApi() {
        try {
            apiManagerNew._post(API_S.Tags.PROMOTIONAL_NOTIFICATION, API_S.Endpoints.PROMOTIONAL_NOTIFICATION, null, sessionManager);
            placeHolder.removeAllViews();
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
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
            ModelPromotionalNotification modelPromotionalNotification = SingletonGson.getInstance().fromJson("" + script, ModelPromotionalNotification.class);
            for (int i = 0; i < modelPromotionalNotification.getData().size(); i++) {
                placeHolder.addView(new HolderNotifications(modelPromotionalNotification.getData().get(i)));
            }
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
    }

    @Layout(R.layout.holder_notification)
    private class HolderNotifications {


        @com.sam.placer.annotations.View(R.id.image)
        private ImageView image;
        @com.sam.placer.annotations.View(R.id.heading_txt)
        private TextView heading_txt;
        @com.sam.placer.annotations.View(R.id.info_text)
        private TextView info_text;

        @Position
        private int mPosition;
        ModelPromotionalNotification.DataBean mDetailBean;

        public HolderNotifications(ModelPromotionalNotification.DataBean detailsBean) {
            mDetailBean = detailsBean;
        }


        @Resolve
        private void onResolved() {
            Log.d("" + TAG, "" + BuildConfig.BASE_URL + "" + mDetailBean.getImage());
           // Picasso.with(getApplicationContext()).load("" + mDetailBean.getImage()).into(image);
            Glide.with(NotificationActivity.this).load( "" + mDetailBean.getImage()).into(image);
            heading_txt.setText("" + mDetailBean.getTitle());
            info_text.setText("" + mDetailBean.getMessage());
        }

        @Click(R.id.root)
        private void OnClick() {
            if (!mDetailBean.getUrl().equals("")) {
                startActivity(new Intent(NotificationActivity.this, NotificationWebViewActivity.class).putExtra("web_url", "" + mDetailBean.getUrl()));
            } else {
                Toast.makeText(NotificationActivity.this, "No Url Found", Toast.LENGTH_SHORT).show();
            }

        }
    }


}
