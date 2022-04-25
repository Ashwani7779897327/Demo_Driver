package com.apporio.demotaxiappdriver.customization;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelGetStripeToken;

import java.util.HashMap;

public class BancardPaymentGateway extends AppCompatActivity  {

    WebView webView;
    SessionManager sessionManager;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bancard_payment_gateway);

        webView = (WebView)findViewById(R.id.webview_bancard);
        sessionManager = new SessionManager(this);
        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setDisplayZoomControls(true);

        progressDialog.show();



        try {
            callApi(API_S.Endpoints.BANCARD_URL,new HashMap<String, String>(), API_S.Tags.BANCARD_URL);
        }catch (Exception e){
            Log.d("exception",""+e);
        }


    }


    public void callApi(String url,HashMap<String,String> data, String apiname){


        AndroidNetworking.post(url).addHeaders("Authorization",sessionManager.getAccessToken()).addBodyParameter(data).build().getAsString(new StringRequestListener() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();


                switch (apiname){

                    case API_S.Tags.BANCARD_URL :



                        Log.d("bancard",""+response);
                        progressDialog.dismiss();
                        webView.loadData(response,"text/html", "UTF-8");

                        webView.setWebViewClient(new WebViewClient(){

                            @Override
                            public void onPageFinished(WebView view, String url) {
                                super.onPageFinished(view, url);



                                view.evaluateJavascript("(function() { return ('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>'); })();", new ValueCallback<String>() {
                                    @Override
                                    public void onReceiveValue(String html) {

                                        Log.d("HTML",""+html);

                                        if(html.contains("add_new_card_success")){


                                            HashMap<String, String> data = new HashMap<>();
                                            data.put("payment_option", "BANCARD");

                                            progressDialog.show();
                                            callApi(API_S.Endpoints.SEND_STRIPE_TOKEN , data,API_S.Tags.SEND_STRIPE_TOKEN);

                                        }else {

                                            //   Toast.makeText(BancardPaymentGateway.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });
                            }
                        });


                        break;


                    case API_S.Tags.SEND_STRIPE_TOKEN:
                        ModelGetStripeToken modelGetStripeToken = SingletonGson.getInstance().fromJson("" + response, ModelGetStripeToken.class);
                        if (modelGetStripeToken.getResult().equals("1")) {
                            Toast.makeText(BancardPaymentGateway.this, "" + modelGetStripeToken.getMessage(), Toast.LENGTH_SHORT).show();
                            BancardPaymentGateway.this.finish();
                        } else {
                            Toast.makeText(BancardPaymentGateway.this, "" + modelGetStripeToken.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        break;
                }
            }

            @Override
            public void onError(ANError anError) {

                Log.d("bancard","error :"+anError.getErrorBody());
            }
        });

    }


}

