package com.apporio.demotaxiappdriver;

import android.app.ProgressDialog;

import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.samwork.ApiManager;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UpdatePasswordActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.back)
    LinearLayout back;
    @Bind(R.id.new_pass_edt)
    EditText newPassEdt;
    @Bind(R.id.confirm_pass_edt)
    EditText confirmPassEdt;
    @Bind(R.id.ll_done_change_password)
    CardView llDoneChangePassword;
    @Bind(R.id.root)
    LinearLayout root;
    private ApiManager apiManagerNew;
    private ProgressDialog progressDialog;
    private final String TAG = "UpdatePasswordActivity";

    String VERIFIER_MODE="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_update_password);
        ButterKnife.bind(this);
        apiManagerNew = new ApiManager(this,this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("" + this.getResources().getString(R.string.loading));

        VERIFIER_MODE = getIntent().getStringExtra(""+ IntentKeys.VERIFIER_MODE);

        back.setOnClickListener((View view) -> {
            finish();
        });
        llDoneChangePassword.setOnClickListener((View view) -> {
            try {
                if (newPassEdt.getText().toString().equals("") || confirmPassEdt.getText().toString().equals("")) {
                    Toast.makeText(UpdatePasswordActivity.this, R.string.please_enter_password, Toast.LENGTH_SHORT).show();
                   // Snackbar.make(root, R.string.please_enter_password, Snackbar.LENGTH_SHORT).show();
                } else {
                    if (newPassEdt.getText().toString().equals("" + confirmPassEdt.getText().toString())) {
                        HashMap<String, String> data = new HashMap<>();
                        data.put("password", "" + newPassEdt.getText().toString());
                        if(VERIFIER_MODE.equalsIgnoreCase("EMAIL")){
                            data.put("for", "EMAIL");
                        }else {
                            data.put("for", "PHONE");
                        }
                        data.put("phone", "" + getIntent().getExtras().getString("" + IntentKeys.PHONE));
                        apiManagerNew._post_with_secreteonly(API_S.Tags.FORGOT_PASSWORD, API_S.Endpoints.FORGOT_PASSWORD, data);
                    } else {
                        Toast.makeText(UpdatePasswordActivity.this, R.string.password_doees_not_matches, Toast.LENGTH_SHORT).show();
                       // Snackbar.make(root, R.string.password_doees_not_matches, Snackbar.LENGTH_SHORT).show();
                    }
                }
            } catch (Exception e) {
                Toast.makeText(UpdatePasswordActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
            }
        });
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            progressDialog.show();
        } else if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            ModelForgotPassword modelForgotPassword = SingletonGson.getInstance().fromJson("" + script, ModelForgotPassword.class);
            Toast.makeText(this, "" + modelForgotPassword.getMessage(), Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            Toast.makeText(UpdatePasswordActivity.this, ""+ e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(UpdatePasswordActivity.this, ""+script, Toast.LENGTH_SHORT).show();

    }
}
