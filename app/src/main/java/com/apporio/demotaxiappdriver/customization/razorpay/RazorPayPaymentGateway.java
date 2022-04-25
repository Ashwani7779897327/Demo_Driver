package com.apporio.demotaxiappdriver.customization.razorpay;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.razorpay.PaymentResultListener;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class RazorPayPaymentGateway extends AppCompatActivity implements PaymentResultListener {
    String intentvalue = "";
    SessionManager sessionManager;
    String currency= "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razor_pay_payment_gateway);


        sessionManager = new SessionManager(this);


        if(getIntent().getStringExtra("activity").equals("wallet"))
        {
            intentvalue = getIntent().getStringExtra("wallet_amount");
            Log.d("pppp","wallet money to be added : "+intentvalue);
            currency = getIntent().getStringExtra("currency");
            startPayment();

        }else if(getIntent().getStringExtra("activity").equals("Fare"))
        {
            String price[] = getIntent().getStringExtra("price").split(" ");
            String payment = price[1];
            intentvalue = payment;
            currency = price[0];
            Log.d("pppp","Fare to be paid : "+intentvalue);
            startPayment();

        }
    }




    public void startPayment() {
        /**
         * You need to pass current activity in order to let Razorpay create CheckoutActivity
         */
        final Activity activity = this;

        final Checkout co = new Checkout();

        try {
            JSONObject options = new JSONObject();
            options.put("name", ""+sessionManager.getUserDetails().get(""+SessionManager.KEY_DRIVER_NAME));
            options.put("description", "skylar payment");
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://rzp-mobile.s3.amazonaws.com/images/rzp.png");
            Log.d("pppp","currency : "+currency);
            options.put("currency", ""+currency);



            double total = Double.parseDouble(intentvalue);
            total = total * 100;
            options.put("amount", total);

            JSONObject preFill = new JSONObject();
            preFill.put("email", ""+sessionManager.getUserDetails().get(SessionManager.KEY_DriverEmail));
            preFill.put("contact", ""+sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_PHONE));

            options.put("prefill", preFill);

            co.open(activity, options);
        } catch (Exception e) {
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {
        Toast.makeText(this, "Payment successfully done! " + razorpayPaymentID, Toast.LENGTH_SHORT).show();
        Intent output = new Intent();
        output.putExtra("success", "success")
                .putExtra("payid",""+razorpayPaymentID);
        setResult(RESULT_OK, output);
        finish();

    }

    @Override
    public void onPaymentError(int code, String response) {
        try {
            Toast.makeText(this, "Payment error please try again", Toast.LENGTH_SHORT).show();
            Intent output = new Intent();
            output.putExtra("failed", "failed")
                    .putExtra("paycode",""+code);
            setResult(RESULT_OK, output);
            finish();

        } catch (Exception e) {
            Log.e("OnPaymentError", "Exception in onPaymentError", e);
        }
    }


}
