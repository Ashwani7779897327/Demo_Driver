package com.apporio.demotaxiappdriver;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.LanguageManager;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelDeviceOnlineIffline;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.apporio.demotaxiappdriver.urls.Apis;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;


public class OnlineOfflineActivity extends BaseActivity implements ApiManager.APIFETCHER {

    private String TAG = "OnlineOfflineActivity";
    @Bind(R.id.close_btn) RelativeLayout close_btn;
    @Bind(R.id.status_description_txt) TextView status_description_txt;
    @Bind(R.id.status__txt) TextView status__txt;
    @Bind(R.id.status_image) ImageView status_image;
    @Bind(R.id.status_btn) LinearLayout status_btn;
    @Bind(R.id.btn_txt)
    TextView btn_txt;


    SessionManager sessionManager ;
    ApiManager apiManager ;
    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(""+this.getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog = new ProgressDialog(this);
        apiManager = new ApiManager(this,this);
        setContentView(R.layout.activity_online_offline);
        sessionManager = new SessionManager(this);
        ButterKnife.bind(this);


        setViewAccrodingly ();

        this.setFinishOnTouchOutside(false);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        status_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String > data = new HashMap<>();
                if(sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")){
                    data.put("status", "2");
                }else{
                    data.put("status","1");
                }
                try {
                    apiManager._post(API_S.Tags.ONLINE_OFFLINE, API_S.Endpoints.ONLINE_OFFLINE,data,sessionManager);
                }catch (Exception e){
                    Log.d(TAG,"Exception caught while calling API "+e.getMessage());
                }

            }
        });
    }

    private void setViewAccrodingly() {
        if(sessionManager.getUserDetails().get(SessionManager.KEY_ONLINE_OFFLINE).equals("1")){
            status_image.setColorFilter(OnlineOfflineActivity.this.getResources().getColor(R.color.icons_8_muted_green_2_dark));
            status__txt.setText(""+OnlineOfflineActivity.this.getResources().getString(R.string.ONLINE_OFFLINE_ACTIVITY__on_duty));
            status__txt.setTextColor(OnlineOfflineActivity.this.getResources().getColor(R.color.icons_8_muted_green_2_dark));
            status_description_txt.setText(""+OnlineOfflineActivity.this.getResources().getString(R.string.online_status_description_txt));
            btn_txt.setText(""+OnlineOfflineActivity.this.getResources().getString(R.string.ONLINE_OFFLINE_ACTIVITY__go_offline));
        }else{
            status_image.setColorFilter(OnlineOfflineActivity.this.getResources().getColor(R.color.icons_8_muted_red));
            status__txt.setText(""+OnlineOfflineActivity.this.getResources().getString(R.string.ONLINE_OFFLINE_ACTIVITY__off_duty));
            status__txt.setTextColor(OnlineOfflineActivity.this.getResources().getColor(R.color.icons_8_muted_red));
            status_description_txt.setText(""+OnlineOfflineActivity.this.getResources().getString(R.string.ONLINE_OFFLINE_ACTIVITY__offline_status_description_txt));
            btn_txt.setText(""+OnlineOfflineActivity.this.getResources().getString(R.string.ONLINE_OFFLINE_ACTIVITY__go_online));
        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {

        if( a == ApiManager.APIFETCHER.KEY_API_IS_STARTED){
            progressDialog.show();
        }else {
            if(progressDialog != null){
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try{
            ModelDeviceOnlineIffline modelDeviceOnlineIffline = SingletonGson.getInstance().fromJson(""+script , ModelDeviceOnlineIffline.class);
            if(modelDeviceOnlineIffline.getData().getOnline_offline().equals("1")){
                sessionManager.setonline_offline(true);
            }else if (modelDeviceOnlineIffline.getData().getOnline_offline().equals("2")){
                sessionManager.setonline_offline(false);
            }
            Toast.makeText(this, ""+modelDeviceOnlineIffline.getMessage(), Toast.LENGTH_SHORT).show();
            finish();
        }catch (Exception e){
            Log.d("" +TAG , "Exception caught while parsing "+e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }

    @Override
    public void onBackPressed() {

    }
}
