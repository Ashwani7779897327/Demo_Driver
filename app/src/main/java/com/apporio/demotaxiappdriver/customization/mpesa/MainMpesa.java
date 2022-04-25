//package com.apporio.demotaxiappdriver.customization.mpesa;
//
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.localbroadcastmanager.content.LocalBroadcastManager;
//
//import com.apporio.demotaxiappdriver.R;
//import com.apporio.demotaxiappdriver.manager.SessionManager;
//import com.bdhobare.mpesa.Mpesa;
//import com.bdhobare.mpesa.interfaces.AuthListener;
//import com.bdhobare.mpesa.interfaces.MpesaListener;
//import com.bdhobare.mpesa.models.STKPush;
//import com.bdhobare.mpesa.utils.Pair;
//import com.google.android.material.textfield.TextInputEditText;
//
//public class MainMpesa extends AppCompatActivity implements AuthListener, MpesaListener {
//
//
//
//    public static final String BUSINESS_SHORT_CODE = "174379";
//    public static final String PASSKEY = "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
//    public static final String CONSUMER_KEY = "oiQRJ3T1jpuZwdR80K1yri8QmURaDxpa";
//    public static final String CONSUMER_SECRET = "XQnU7qKJsSpwven9";
//    public static final String CALLBACK_URL = "https://makara.co.ke:8443/odt/checkout";
//
//
//    public static final String NOTIFICATION = "PushNotification";
//    public static final String SHARED_PREFERENCES = "com.bdhobare.mpesa_android_sdk";
//
//    Button pay;
//    ProgressDialog dialog;
//    TextInputEditText phone;
//    TextInputEditText amount;
//    TextView country_code;
//    SessionManager sessionManager;
//    String number;
//    private int MAX_PHONE_LENGTH = 10;
//
//    private BroadcastReceiver mRegistrationBroadcastReceiver;
//    int a;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main_mpesa);
//
//        pay = (Button) findViewById(R.id.pay);
//        phone = (TextInputEditText) findViewById(R.id.phone);
//        amount = (TextInputEditText) findViewById(R.id.amount);
//        // country_code=(TextView) findViewById(R.id.country);
//        Mpesa.with(this, CONSUMER_KEY, CONSUMER_SECRET);
//        dialog = new ProgressDialog(this);
//        dialog.setMessage("Processing");
//
//        sessionManager = new SessionManager(this);
//        String payment = getIntent().getStringExtra("amount");
//        number = getIntent().getStringExtra("phone");
//        dialog.setIndeterminate(true);
//
//        String sep = number.substring(1,number.length());
//        amount.setText("" + payment);
//        phone.setText("" + sep);
//
//        String[] separated = payment.split(" ");
//
//        pay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String p = phone.getText().toString();
//                if(payment.contains(" ")){
//                     a = Integer.valueOf(separated[1]);
//                } else {
//                    if(payment.contains(".")){
//                        Double d = Double.parseDouble(payment);
//                        a = Integer.parseInt(String.valueOf(d.intValue()));
//                    }else {
//                        a = Integer.parseInt(payment);
//                    }
//                }
//                if (p.isEmpty()) {
//                    phone.setError("Enter phone.");
//                    return;
//                }
//                pay(p, a);
//            }
//        });
//
//        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                if (intent.getAction().equals(NOTIFICATION)) {
//                    String title = intent.getStringExtra("title");
//                    String message = intent.getStringExtra("message");
//                    int code = intent.getIntExtra("code", 0);
//
//                    Toast.makeText(MainMpesa.this, ""+message+code, Toast.LENGTH_SHORT).show();
//                 //   showDialog(title, message, code);
//
//                }
//            }
//        };
//    }
//
//    @Override
//    public void onAuthError(Pair<Integer, String> result) {
//        Log.e("Error", result.message);
//
//    }
//
//    @Override
//    public void onAuthSuccess() {
//        pay.setEnabled(true);
//    }
//
//    private void pay(String phone, int amount) {
//        dialog.show();
//        STKPush.Builder builder = new STKPush.Builder(BUSINESS_SHORT_CODE, PASSKEY, amount, BUSINESS_SHORT_CODE, phone);
//
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
//        String token = sharedPreferences.getString("InstanceID", "");
//
//        builder.setFirebaseRegID(token);
//        STKPush push = builder.build();
//
//
//        Mpesa.getInstance().pay(this, push);
//
//    }
//
//    @Override
//    public void onMpesaError(Pair<Integer, String> result) {
//
//        dialog.hide();
////        Intent intent = new Intent();
////        intent.putExtra("failed", "failed");
////        setResult(RESULT_OK, intent);
////        Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show();
//
//        if (!number.equals(phone)){
//            Toast.makeText(this, "Invalid phone number.", Toast.LENGTH_SHORT).show();
//        }
//
//        finish();
//    }
//
//    @Override
//    public void onMpesaSuccess(String MerchantRequestID, String CheckoutRequestID, String CustomerMessage) {
//
//        Intent intent = new Intent();
//        intent.putExtra("success", "success");
//        setResult(Activity.RESULT_OK, intent);
//
//        Toast.makeText(this, CustomerMessage, Toast.LENGTH_SHORT).show();
//        finish();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
//                new IntentFilter(NOTIFICATION));
//
//    }
//
//    @Override
//    protected void onPause() {
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
//        super.onPause();
//    }
//}
