//package com.apporio.demotaxiappdriver.customization.Paypal;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.apporio.demotaxiappdriver.R;
//import com.paypal.android.sdk.payments.PayPalConfiguration;
//import com.paypal.android.sdk.payments.PayPalPayment;
//import com.paypal.android.sdk.payments.PayPalService;
//import com.paypal.android.sdk.payments.PaymentActivity;
//import com.paypal.android.sdk.payments.PaymentConfirmation;
////import com.paypal.android.sdk.payments.PayPalConfiguration;
////import com.paypal.android.sdk.payments.PayPalPayment;
////import com.paypal.android.sdk.payments.PayPalService;
////import com.paypal.android.sdk.payments.PaymentActivity;
////import com.paypal.android.sdk.payments.PaymentConfirmation;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.math.BigDecimal;
//
//public class PaypalPaymentActivity extends AppCompatActivity {
//
//    public static  String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
//    public static  String CONFIG_CLIENT_ID = "AXSPlitp8x3UVUV2ImqN10KI8ck1OSpHiS1rwnCEBUSMJ2yk25H3ZcrezXKrnFM1eDaQZ2LBa5bIuQim";
//
//    private static  int REQUEST_CODE_PAYMENT = 1;
//    public static PayPalConfiguration config = new PayPalConfiguration()
//            .environment(CONFIG_ENVIRONMENT)
//            .clientId(CONFIG_CLIENT_ID);
//
//    String paypal_id,paypal_state,paypal_amount,paypal_currency_code;
//    String amount;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_paypal_payment);
//
//
//        amount = getIntent().getStringExtra("amount");
//
//
//        PayPalPayment thingToBuy = getThingToBuy(PayPalPayment.PAYMENT_INTENT_SALE);
//        Intent intent = new Intent(PaypalPaymentActivity.this, PaymentActivity.class);
//        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
//        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);
//        startActivityForResult(intent, REQUEST_CODE_PAYMENT);
//
//
//    }
//
//
//    private PayPalPayment getThingToBuy(String paymentIntent) {
//        return new PayPalPayment(new BigDecimal(""+amount), "BRL", "Rodeganhe Payments",
//                paymentIntent);
//    }
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == Activity.RESULT_OK) {
//            PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
//            if (confirm != null) {
//                try {
//                    Log.e("Show", confirm.toJSONObject().toString(4));
//                    Log.e("Show", confirm.getPayment().toJSONObject().toString(4));
//
//                    JSONObject json=confirm.toJSONObject();
//                    JSONObject responce = json.getJSONObject("response");
//                    paypal_id = responce.getString("id");
//                    paypal_state = responce.getString("state");
//                    JSONObject payment=confirm.getPayment().toJSONObject();
//                    paypal_amount=payment.getString("amount");
//                    paypal_currency_code=payment.getString("currency_code");
//
//
//                    Toast.makeText(this, "Payment successfully done!", Toast.LENGTH_SHORT).show();
//                    Intent output = new Intent();
//                    output.putExtra("success", "success");
//                    setResult(RESULT_OK, output);
//                    finish();
//
//                    // Toast.makeText(getApplicationContext(), "PaymentConfirmation info received" + " from PayPal", Toast.LENGTH_LONG).show();
//
//
//
//                } catch (JSONException e) {
//                    Toast.makeText(getApplicationContext(), "an extremely unlikely failure" +
//                            " occurred:", Toast.LENGTH_LONG).show();
//                }
//            }
//        } else if (resultCode == Activity.RESULT_CANCELED) {
//
//        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
//            Toast.makeText(getApplicationContext(), "An invalid Payment or PayPalConfiguration" +
//                    " was submitted.", Toast.LENGTH_LONG).show();
//        }else {
//
//            try {
//                Toast.makeText(this, "Payment error please try again", Toast.LENGTH_SHORT).show();
//                Intent output = new Intent();
//                output.putExtra("failed", "failed");
//                setResult(RESULT_OK, output);
//                finish();
//
//
//            } catch (Exception e) {
//                Log.e("OnPaymentError", "Exception in onPaymentError", e);
//            }
//
//        }
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        stopService(new Intent(this, PayPalService.class));
//        finish();
//    }
//}
//
