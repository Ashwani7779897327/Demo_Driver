package com.apporio.demotaxiappdriver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.libraries.places.api.model.Place;
import com.google.android.material.snackbar.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelHomeAddressActivate;
import com.apporio.demotaxiappdriver.samwork.ApiManager;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeAddressActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.address_text)
    TextView addressText;
    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.edit_image)
    ImageView editImage;
    @Bind(R.id.button)
    TextView button;
    @Bind(R.id.ll_set_home_sddress)
    LinearLayout ll_set_home_sddress;

    private SessionManager sessionManager;
    private ApiManager apiManager;
    private Place place = null;
    private ProgressDialog progressDialog;
    private final String TAG = "HomeAddressActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home_address);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this,this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(this.getResources().getString(R.string.loading));

        addressText.setText("" + getIntent().getExtras().getString("" + IntentKeys.ADDRESS));

        if(getIntent().getExtras().getString("" + IntentKeys.HOME_LOCATION_ACTIVE_STATUS).equals("1")){
            button.setText(""+HomeAddressActivity.this.getResources().getString(R.string.activated));
            button.setTextColor(Color.parseColor("#2ecc71"));
        }else{
            button.setText(""+HomeAddressActivity.this.getResources().getString(R.string.deactivated));
        }

        back.setOnClickListener((View view) -> {
            finish();
        });

        ll_set_home_sddress.setOnClickListener((View view) -> {
            startActivity(new Intent(HomeAddressActivity.this, HomeAddressListActivity.class));
            finish();
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (addressText.getText().equals("")) {

                    Toast.makeText(HomeAddressActivity.this, "Please add your home address.", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        HashMap<String, String> data = new HashMap<>();
                        if (button.getText().toString().equals("" + HomeAddressActivity.this.getResources().getString(R.string.deactivated))) {
                            data.put("status", "1");
                        } else if (button.getText().toString().equals("" + HomeAddressActivity.this.getResources().getString(R.string.activated))) {
                            data.put("status", "2");
                        }
                        apiManager._post(API_S.Tags.ACTIVE_DEACTIVE_HOME_ADDRESS, API_S.Endpoints.ACTIVE_DEACTIVE_HOME_ADDRESS, data, sessionManager);
                    } catch (Exception e) {
                        Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }

                }
            }
        });
    }


    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if(a == ApiManager.APIFETCHER.KEY_API_IS_STARTED){
            progressDialog.show();
        }else if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            ModelHomeAddressActivate modelHomeAddressActivate = SingletonGson.getInstance().fromJson(""+script,ModelHomeAddressActivate.class);
            if(modelHomeAddressActivate.isData()){
                button.setText(""+HomeAddressActivity.this.getResources().getString(R.string.activated));
                button.setTextColor(Color.parseColor("#2ecc71"));
            }else{
                button.setText(""+HomeAddressActivity.this.getResources().getString(R.string.deactivated));
                button.setTextColor(Color.parseColor("#e74c3c"));
            }
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.e("" + TAG, "Exception caught while parsing " + e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
    }


}
