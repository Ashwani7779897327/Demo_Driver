package com.apporio.demotaxiappdriver.customization.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.google.gson.Gson;
//import com.mercadopago.android.px.core.MercadoPagoCheckout;
//import com.mercadopago.android.px.model.Payment;

import java.util.HashMap;

public class MercadoPaymentActivity extends AppCompatActivity implements ApiManager.APIFETCHER {

    ProgressDialog progressDialog;
    ApiManager apiManagerNew;
    SessionManager sessionManager;
    String currency;
    String amount;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado_payment);


        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getResources().getString(R.string.loading));
        apiManagerNew = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        gson = new Gson();


        currency = getIntent().getStringExtra("currency");
        amount = getIntent().getStringExtra("amount");
        progressDialog.show();

        HashMap data = new HashMap();
        data.put("amount", "" + amount);
        data.put("for", "user");
        data.put("currency", "ARS");

        try {
            apiManagerNew._post(API_S.Tags.MERCADO_PREFRENCE_ID, API_S.Endpoints.MERCADO_PREFRENCE_ID, data, sessionManager);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 100) {
            if (resultCode == 7 && data != null) {

// Payment Ready
// Payment payment = JsonUtil.getInstance().fromJson(data.getStringExtra("payment"), Payment.class);


                //Payment payment = gson.fromJson(data.getStringExtra("payment"), Payment.class);


// if (payment != null) {
//
// Toast.makeText(this, "PaymentID: " + payment.getId() +
// " - PaymentStatus: " + payment.getPaymentStatus(), Toast.LENGTH_SHORT).show();
// } else {
//
//
// Toast.makeText(this, "The user did not make the payment", Toast.LENGTH_SHORT).show();
// }
//
                Toast.makeText(this, "Payment Done", Toast.LENGTH_SHORT).show();

                Intent output = new Intent();
                output.putExtra("success", "success");
                setResult(RESULT_OK, output);
                finish();


            } else {
                if ((data != null) && (data.hasExtra("mpException"))) {

                    Toast.makeText(this, "some exception", Toast.LENGTH_SHORT).show();
                    Intent output = new Intent();
                    output.putExtra("failed", "failed");
                    setResult(RESULT_OK, output);
                    finish();
// Manejá tus errores.
                } else {

                    Toast.makeText(this, "Payment Cancelled", Toast.LENGTH_SHORT).show();
                    Intent output = new Intent();
                    output.putExtra("failed", "failed");
                    setResult(RESULT_OK, output);
                    finish();
                }
            }
        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

        if (APINAME.equals(API_S.Tags.MERCADO_PREFRENCE_ID)) {

            progressDialog.hide();

            ModelPrefrenceid modelPrefrenceid = SingletonGson.getInstance().fromJson("" + script, ModelPrefrenceid.class);

//            final MercadoPagoCheckout checkout = new MercadoPagoCheckout.Builder("APP_USR-d31d6ebb-bf18-4ed4-b03b-6fb596851e3e",
//                    "" + modelPrefrenceid.getData().getId())
//                    .build();
//
//            checkout.startPayment(MercadoPaymentActivity.this, 100);

        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }
}
