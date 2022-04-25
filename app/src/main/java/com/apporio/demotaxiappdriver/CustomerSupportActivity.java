package com.apporio.demotaxiappdriver;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CustomerSupportActivity extends BaseActivity implements ApiManager.APIFETCHER {


    @Bind(R.id.user_name_edt)
    EditText user_name_edt;
    @Bind(R.id.email_edt)
    EditText email_edt;
    @Bind(R.id.pone_edt)
    EditText pone_edt;
    @Bind(R.id.query_edt)
    EditText query_edt;
    @Bind(R.id.root)
    LinearLayout root;

    SessionManager sessionManager;
    ProgressDialog progress_dialoge;
    ApiManager apiManager;
    HashMap<String, String> data = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sessionManager = new SessionManager(this);
        progress_dialoge = new ProgressDialog(this);
        progress_dialoge.setMessage("" + this.getResources().getString(R.string.loading));
        apiManager = new ApiManager(this,this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_support);
        ButterKnife.bind(this);
        getSupportActionBar().hide();


        findViewById(R.id.ll_back_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        findViewById(R.id.send_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_name_edt.getText().toString().equals("") || email_edt.getText().toString().equals("") || query_edt.getText().toString().equals("")) {
                    Snackbar.make(root, R.string.please_enter_the_maindatory_details, Snackbar.LENGTH_SHORT).show();
                } else {
                    data.put("name", "" + user_name_edt.getText().toString());
                    data.put("email", "" + email_edt.getText().toString());
                    data.put("phone", "" + pone_edt.getText().toString());
                    data.put("message", "" + query_edt.getText().toString());
                    try {
                        apiManager._post(API_S.Tags.CUSTOMER_SUPPORT, API_S.Endpoints.CUSTOMER_SUPPORT, data, sessionManager);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }


    public void dialogForQueryComplete(String message) {

        final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        dialog.setContentView(R.layout.dialog_for_query_complete);
        dialog.setCancelable(false);
        TextView quer_response_message = (TextView) dialog.findViewById(R.id.quer_response_message);
        quer_response_message.setText("" + message);

        LinearLayout ll_update = (LinearLayout) dialog.findViewById(R.id.ll_ok);
        ll_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });
        dialog.show();
    }

    //////////////////////////////

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            progress_dialoge.show();
        } else {
            progress_dialoge.dismiss();
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            if (APINAME.equals("" + API_S.Tags.CUSTOMER_SUPPORT)) {
                QueryResponseModel data_response;
                data_response = gson.fromJson("" + script, QueryResponseModel.class);
                if (data_response.getResult().equals("1")) {
                    data.clear();
                    dialogForQueryComplete("" + data_response.getMessage());

                }else {

                }
            }
        } catch (Exception e) {
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }

    public class QueryResponseModel {


        private String result;
        private String message;
        private List<?> data;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<?> getData() {
            return data;
        }

        public void setData(List<?> data) {
            this.data = data;
        }
    }


}
