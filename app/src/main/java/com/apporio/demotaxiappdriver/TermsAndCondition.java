package com.apporio.demotaxiappdriver;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelTermsAndCodition;
import com.apporio.demotaxiappdriver.models.Model_Terms_Conditions;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.apporio.demotaxiappdriver.typeface.TypefaceTextView;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TermsAndCondition extends BaseActivity implements ApiManager.APIFETCHER {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tc) TypefaceTextView tc;
    @Bind(R.id.accept_t_and_c)
    Button accept_t_and_c;
    @Bind(R.id.root)
    RelativeLayout root;

    SessionManager sessionManager;
    ApiManager apiManager;
    private final String TAG = "TermsAndCondition";
    int clickcount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tc);
        ButterKnife.bind(this);
        apiManager = new ApiManager(this,this);
        sessionManager = new SessionManager(this);


        try {
            HashMap<String , String > data = new HashMap<>();
            data.put("slug","terms_and_Conditions");
            data.put("country_id", ""+sessionManager.getcountryid());
            apiManager._post_with_secreteonly(API_S.Tags.CMS_PAGES, API_S.Endpoints.CMS_PAGES,data);
            MainActivity.openScreenTerms = 1;
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.btnShowDetails).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickcount>5)
                {
                    showDialofForViewReceipt();
                }
                clickcount++;
            }
        });

        if(getIntent().getStringExtra(Config.IntentKeys.TERMS_CONDITION) !=null && getIntent().getStringExtra(Config.IntentKeys.TERMS_CONDITION).equals("accept"))
        {
            accept_t_and_c.setVisibility(View.VISIBLE);

        }
        else if(getIntent().getStringExtra(Config.IntentKeys.TERMS_CONDITION) != null && getIntent().getStringExtra(Config.IntentKeys.TERMS_CONDITION).equals("acceptmain"))
        {
         accept_t_and_c.setVisibility(View.VISIBLE);

        }else {

            accept_t_and_c.setVisibility(View.GONE);
        }


        accept_t_and_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    apiManager._post(API_S.Tags.TERMS_AND_CONDITIONS, API_S.Endpoints.terms_and_conditions,null,sessionManager);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }



    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {

            switch (APINAME)
            {
                case API_S.Tags.CMS_PAGES :

                    ModelTermsAndCodition modelTermsAndCodition = SingletonGson.getInstance().fromJson(""+script, ModelTermsAndCodition.class);
                    tc.setText(Html.fromHtml("" + modelTermsAndCodition.getData().getDescription()));

                    if(modelTermsAndCodition.getResult().equals("1")){
                        tc.setText(Html.fromHtml("" + modelTermsAndCodition.getData().getDescription()));
                    }else {
                        Snackbar.make(root,"No Pages are added from admin panel",Snackbar.LENGTH_SHORT).show();
                    }

                    break;

                case API_S.Tags.TERMS_AND_CONDITIONS :

                    Model_Terms_Conditions model_terms_conditions = SingletonGson.getInstance().fromJson(""+script, Model_Terms_Conditions.class);

                    if(model_terms_conditions.getResult().equals("1"))
                    {


                        Toast.makeText(this, "Terms and conditions accepted", Toast.LENGTH_SHORT).show();
                        finish();

                    }

            }



        } catch (Exception e) {
          //  Snackbar.make(root,""+script,Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root,""+script,Snackbar.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    private void showDialofForViewReceipt() {
        Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Setting dialogview
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
        dialog.setTitle(null);
        dialog.setCancelable(false);

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.show_url_details);

        TextView textView = dialog.findViewById(R.id.tvUrl);
        TextView textView1 = dialog.findViewById(R.id.tvPublicKey);
        TextView textView2 = dialog.findViewById(R.id.tvSecretKey);
        TextView textView3 = dialog.findViewById(R.id.tvGoogleKey);
        TextView textView4 = dialog.findViewById(R.id.tvVersion);
        TextView tvOneSignal = dialog.findViewById(R.id.tvOneSignal);
        TextView tvCodeVersion = dialog.findViewById(R.id.tvCodeVersion);
        textView.setText("BaseUrl:- "+" "+BuildConfig.BASE_URL);
        textView1.setText("PublicKey:- "+" "+BuildConfig.PUBLIC_KEY);
        textView2.setText("SecretKey:- "+" "+BuildConfig.SECRET_KEY);
        textView3.setText("Google Key:- "+" "+getResources().getString(R.string.google_api_key));
        textView4.setText("Verison:- "+SplashActivity.app_version_name);
        tvCodeVersion.setText("Code Version:"+" "+"V_14-10-18Oct");
        tvOneSignal.setText("OneSignal:-"+"\n"+""+BuildConfig.One_SIgnal);
        dialog.findViewById(R.id.rl_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                clickcount = 0;
            }
        });

        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


        if(getIntent().getStringExtra(Config.IntentKeys.TERMS_CONDITION) !=null && getIntent().getStringExtra(Config.IntentKeys.TERMS_CONDITION).equals("accept"))
        {
            Toast.makeText(this, "Terms and conditions not accepted", Toast.LENGTH_SHORT).show();

        }
        else if(getIntent().getStringExtra(Config.IntentKeys.TERMS_CONDITION) != null && getIntent().getStringExtra(Config.IntentKeys.TERMS_CONDITION).equals("acceptmain"))
        {
            Toast.makeText(this, "Terms and conditions not accepted", Toast.LENGTH_SHORT).show();

        }



    }
}
