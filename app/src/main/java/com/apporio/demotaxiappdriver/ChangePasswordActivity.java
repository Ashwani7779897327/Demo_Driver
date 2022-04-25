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
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelChangePassword;
import com.apporio.demotaxiappdriver.samwork.ApiManager;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChangePasswordActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.ll_back_change_password)
    LinearLayout back;
    @Bind(R.id.edt_o_pass)
    EditText edtOldPass;
    @Bind(R.id.edt_n_pass)
    EditText edtNewPass;
    @Bind(R.id.edt_c_pass)
    EditText edtConfirmPass;
    @Bind(R.id.ll_done_change_password)
    CardView doneButton;
    @Bind(R.id.root)
    LinearLayout root;

    private ApiManager apiManager;
    private SessionManager sessionManager;
    private final String TAG = "ChangePasswordActivity";
    private ProgressDialog progressDialog  ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);
        apiManager = new ApiManager(this,this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(""+this.getResources().getString(R.string.loading));
        sessionManager = new SessionManager(this);

        back.setOnClickListener((View view) -> {
            finish();
        });

        doneButton.setOnClickListener((View view )->{
            if(edtOldPass.getText().toString().equals("") ||
                    edtNewPass.getText().toString().equals("") ||
                    edtConfirmPass.getText().toString().equals("")){
                Toast.makeText(this, ""+ChangePasswordActivity.this.getResources().getString(R.string.required_field_missing), Toast.LENGTH_SHORT).show();
            }else{
                if(edtNewPass.getText().toString().equals(""+edtConfirmPass.getText().toString())){
                    try{
                        HashMap<String , String> data = new HashMap<>();
                        data.put("old_password",""+edtOldPass.getText().toString());
                        data.put("new_password",""+edtNewPass.getText().toString());
                        apiManager._post(""+ API_S.Tags.CHANGE_PASSWORD, ""+API_S.Endpoints.CHANGE_PASSWORD,data, sessionManager);
                    }catch (Exception e){
                        Log.d("" +TAG , "Exception caught while calling API "+e.getMessage());}


                }else{
                    Toast.makeText(this, R.string.password_doesnt_match, Toast.LENGTH_SHORT).show();
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
        ModelChangePassword modelChangePassword = SingletonGson.getInstance().fromJson(""+script, ModelChangePassword.class);
        Toast.makeText(this, ""+modelChangePassword.getMessage(), Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(ChangePasswordActivity.this, ""+script, Toast.LENGTH_SHORT).show();
    }

}
