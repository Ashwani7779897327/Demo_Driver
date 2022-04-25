package com.apporio.demotaxiappdriver.activities.subscriptionModule;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import com.apporio.demotaxiappdriver.HolderSubscriptionPackageList;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.holder.HolderActivatePackage;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelSubscriptionList;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;
import java.io.Serializable;
import butterknife.Bind; 
import butterknife.ButterKnife;

public class SubscriptionModuleList extends BaseActivity implements ApiManager.APIFETCHER, Serializable {

    private final String TAG = "VehicleListActivity";
    ApiManager apiManager;
    SessionManager sessionManager;
    ModelSubscriptionList modelSubscriptionList;
    @Bind(R.id.placeholder_package_list)
    PlaceHolderView placeHolderView;
    @Bind(R.id.placeholder_activate_package)
    PlaceHolderView placeholder_activate_package;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_module_list);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        apiManager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));

        findViewById(R.id.ivBack).setOnClickListener(v -> SubscriptionModuleList.this.finish());
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (APINAME.equals(API_S.Tags.SUBSCRIPTION_LIST)) {
            if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                progressDialog.show();
            } else if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            modelSubscriptionList = SingletonGson.getInstance().fromJson("" + script, ModelSubscriptionList.class);
            if (modelSubscriptionList.getResult().equals("1")) {
                placeholder_activate_package.getAdapter().notifyDataSetChanged();
                placeholder_activate_package.refresh();
                placeholder_activate_package.removeAllViews();
                if(modelSubscriptionList.getActive_pack_detail().size()>0){
                    for (int i = 0; i < modelSubscriptionList.getActive_pack_detail().size(); i++) {
                        placeholder_activate_package.addView(new HolderActivatePackage(this, modelSubscriptionList.getActive_pack_detail().get(i), modelSubscriptionList));
                    }
                }

                placeHolderView.getAdapter().notifyDataSetChanged();
                placeHolderView.refresh();
                placeHolderView.removeAllViews();
                for (int i = 0; i < modelSubscriptionList.getData().size(); i++) {
                    placeHolderView.addView(new HolderSubscriptionPackageList(this, modelSubscriptionList, modelSubscriptionList.getData().get(i), modelSubscriptionList.getPayment_method()));
                }
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(this, "" + script, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        callApi();
    }

    private void callApi() {
        try {
            apiManager._post(API_S.Tags.SUBSCRIPTION_LIST, API_S.Endpoints.SUBSCRIPTION_LIST, null, sessionManager);
        } catch (Exception e) {
//            Log.e("Exception", "" + e);
        }
    }

    public void Data() {
        try {
            apiManager._post(API_S.Tags.ACTIVATE_PACKAGE, API_S.Endpoints.ACTIVATE_PACKAGE, null, sessionManager);
        } catch (Exception e) {
//            Log.e("Exception", "" + e);
        }
    }
}

          