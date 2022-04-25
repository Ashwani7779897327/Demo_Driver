//package com.apporio.demotaxiappdriver.customization.paystack;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.util.Log;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.Toast;
//
//import com.apporio.demotaxiappdriver.R;
//import com.apporio.demotaxiappdriver.SingletonGson;
//import com.apporio.demotaxiappdriver.currentwork.API_S;
//import com.apporio.demotaxiappdriver.manager.SessionManager;
//import com.apporio.demotaxiappdriver.models.ModelGetStripeToken;
//import com.apporio.demotaxiappdriver.samwork.ApiManager;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.util.Calendar;
//import java.util.HashMap;
//
//import co.paystack.android.Paystack;
//import co.paystack.android.PaystackSdk;
//import co.paystack.android.Transaction;
//import co.paystack.android.model.Card;
//import co.paystack.android.model.Charge;
//
//public class PayWithPaystackActivity extends AppCompatActivity implements View.OnClickListener, ApiManager.APIFETCHER {
//
//    //    private ProgressBar progressBar;
//    SessionManager sessionmanager;
//    ApiManager apiManagerNew;
//    ProgressDialog progressDialog;
//
//
//    private static final int GROUP_LEN = 4;
//    private static final String TAG = "PayWithPaystackActivity";
//    private EditText mEditCardNumber;
//    private EditText mEditExpiryMonth;
//    private EditText mEditExpiryYear;
//    private EditText mEditCVV;
//    private RelativeLayout pay_layout;
//    private ImageView backpress;
//    private static final int REQUEST_CODE_PAYMENT = 133;
//    private static final int REQUEST_RENTAL_CODE_PAYMENT = 144;
//    private String tokenVal, tokenAdd;
//    private Bundle bundle;
//    // TokenGenrator tokenGenrator;
//   // ApiManagerNew apiManager;
//    GsonBuilder gsonBuilder;
//    Gson gson;
//    String reference_number;
//    int status;
//    String received_token;
//    String email;
//    // PaystackResponseModel responseModel;
//    int result;
//    String amount = "";
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        setContentView(R.layout.activity_pay_with_paystack);
//        gsonBuilder = new GsonBuilder();
//        gson = gsonBuilder.create();
//
//        amount = getIntent().getStringExtra("amount");
//        sessionmanager = new SessionManager(this);
//        apiManagerNew = new ApiManager(this, this);
//        PaystackSdk.initialize(getApplicationContext());
//
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage(getResources().getString(R.string.loading));
//
//
//
//
//        //setup views
//        //   mEditEmail = (EditText) findViewById(R.id.edit_email);
//        mEditCardNumber = (EditText) findViewById(R.id.edit_card_number);
//        mEditExpiryMonth = (EditText) findViewById(R.id.edit_expiry_month);
//        mEditExpiryYear = (EditText) findViewById(R.id.edit_expiry_year);
//        mEditCVV = (EditText) findViewById(R.id.edit_cvv);
//        pay_layout = (RelativeLayout) findViewById(R.id.payLayout);
//        backpress = (ImageView)findViewById(R.id.backpress);
////        progressBar = (ProgressBar)findViewById(R.id.pay_progress);
//
//        //add text changed listener
//        mEditCardNumber.addTextChangedListener(cardWatcher);
//        mEditExpiryMonth.addTextChangedListener(new ExpiryWatcher(mEditExpiryMonth));
//        mEditExpiryYear.addTextChangedListener(new ExpiryWatcher(mEditExpiryYear));
//
//        //add clicklistener on pay layout
//        pay_layout.setOnClickListener(this);
//
//        backpress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                finish();
//            }
//        });
//
//    }
//
//    /**
//     * Text Watcher to format card number
//     */
//    private TextWatcher cardWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            String number = s.toString();
//            if (number.length() >= GROUP_LEN) {
//                String formatted = Utils.formatForViewing(number, GROUP_LEN);
//                if (!number.equalsIgnoreCase(formatted)) {
//                    mEditCardNumber.removeTextChangedListener(cardWatcher);
//                    mEditCardNumber.setText(formatted);
//                    mEditCardNumber.setSelection(formatted.length());
//                    mEditCardNumber.addTextChangedListener(cardWatcher);
//                }
//            }
//        }
//    };
//
//    @Override
//    public void onClick(View v) {
//
//
//
//
//        if (REQUEST_CODE_PAYMENT == 133) {
////validate fields
//            //String number, Integer expiryMonth, Integer expiryYear, String cvcT
//            try {
////                progressBar.setVisibility(View.VISIBLE);
//                String number = Utils.cleanNumber(mEditCardNumber.getText().toString().trim());
//                int expiryMonth = Integer.parseInt(mEditExpiryMonth.getText().toString().trim());
//                int expiryYear = Integer.parseInt(mEditExpiryYear.getText().toString().trim());
//                String cvv = mEditCVV.getText().toString().trim();
//
//                Card.Builder cardbuilder = new Card.Builder(number,expiryMonth,expiryYear,cvv);
//                createToken(cardbuilder.build());
//
//            } catch (Exception e) {
//                Log.e("**" + TAG, "" + e.getMessage());
//
//            }
//        }else {
//
//            try {
////                progressBar.setVisibility(View.VISIBLE);
//                String number = Utils.cleanNumber(mEditCardNumber.getText().toString().trim());
//                int expiryMonth = Integer.parseInt(mEditExpiryMonth.getText().toString().trim());
//                int expiryYear = Integer.parseInt(mEditExpiryYear.getText().toString().trim());
//                String cvv = mEditCVV.getText().toString().trim();
//
//            } catch (Exception e) {
//                Log.e("**" + TAG, "" + e.getMessage());
//
//            }
//        }
//    }
//
//    @Override
//    public void onAPIRunningState(int a, String APINAME) {
//
//    }
//
//    @Override
//    public void onFetchComplete(Object script, String APINAME) {
//
//        switch (APINAME) {
//            case API_S.Tags.SEND_STRIPE_TOKEN:
//                progressDialog.dismiss();
//                ModelGetStripeToken modelGetStripeToken = SingletonGson.getInstance().fromJson("" + script, ModelGetStripeToken.class);
//                if (modelGetStripeToken.getResult().equals("1")) {
//                    Toast.makeText(this, "" + modelGetStripeToken.getMessage(), Toast.LENGTH_SHORT).show();
//                    finish();
//                } else {
//                    Toast.makeText(this, "" + modelGetStripeToken.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//
//                break;
//        }
//
//
//    }
//
//    @Override
//    public void onFetchResultZero(String script) {
//
//    }
//
//
//    /**
//     * Expiry Watcher
//     */
//    private class ExpiryWatcher implements TextWatcher {
//
//        private EditText editText;
//
//        public ExpiryWatcher(EditText editText) {
//            this.editText = editText;
//        }
//
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            try{
//                int number = Integer.parseInt(s.toString());
//                int length = s.length();
//                switch (editText.getId()) {
//                    case R.id.edit_expiry_month:
//                        if(length == 1) {
//                            if(number > 1) {
//                                //add a 0 in front
//                                setText("0"+number);
//                            }
//                        } else {
//                            if(number > 12) {
//                                setText("12");
//                            }
//
//                            //request focus on the next field
//                            mEditExpiryYear.requestFocus();
//                        }
//                        break;
//                    case R.id.edit_expiry_year:
//                        String stringYear = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
//                        int currentYear = Integer.parseInt(stringYear);
//
//                        if(length == 1) {
//                            int firstDigit = Integer.parseInt(String.valueOf(currentYear).substring(0, length));
//                            if(number < firstDigit) {
//                                setText(firstDigit+"");
//                            }
//                        } else {
//                            if(number < currentYear){
//                                setText(currentYear+"");
//                            }
//
//                            mEditCVV.requestFocus();
//                        }
//                        break;
//                }
//            } catch (NumberFormatException nfe) {
//                nfe.printStackTrace();
//            }
//        }
//
//        private void setText(String text) {
//            editText.setText(text);
//            editText.setSelection(editText.getText().toString().trim().length());
//        }
//    }
//    private void SendTokenToServer(String userEmail, String token, String pay_amount) {
//        Log.e("USER_EMAIL---", userEmail);
//        Log.e("USER_TOKEN---", token);
//        Log.e("USER_PAYAMOUNT---", pay_amount);
//
//
//        received_token = token;
//
//        HashMap<String, String> hashMap = new HashMap<String, String>();
//        hashMap.put("reference_token",received_token);
//        hashMap.put("email",userEmail);
//        hashMap.put("amount",pay_amount);
//
//        Log.d("**HASHMAP===", String.valueOf(hashMap));
//
//
////        progressBar.setVisibility(View.GONE);
//
//        HashMap<String, String> data = new HashMap<>();
//        data.put("payment_option", "PAYSTACK");
//        data.put("token", "" + token);
//        try {
//            progressDialog.show();
//            apiManagerNew._post(API_S.Tags.SEND_STRIPE_TOKEN, API_S.Endpoints.SEND_STRIPE_TOKEN, data, sessionmanager);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        apiManager._post(Config.ApiKeys.KEY_PAY_WITH_PAYSTACK,  Apis.PAY_WITH_PAYSTACK, hashMap, true, ApiManager.ACTION_SHOW_DIALOG);
//
//        //  Log.e("**PAY_API==", Apis.PAY_WITH_PAYSTACK+"reference_token="+received_token+"&email="+userEmail+"&amount="+pay_amount);
//    }
//
//
//
//
//
//
//    private void finilalizeActivity() {
//
//        if (REQUEST_CODE_PAYMENT == 133){
//            //for now send the dummy response to the previous activity to get the payment done
//            Intent intent = new Intent();
//            intent.putExtra("response", status);
//            intent.putExtra("payment_result", result);
//            setResult(REQUEST_CODE_PAYMENT, intent);
//            finish();
//        }else {
//            Intent intent = new Intent();
//            intent.putExtra("response", status);
//            intent.putExtra("payment_result", result);
//            setResult(REQUEST_RENTAL_CODE_PAYMENT, intent);
//            finish();
//        }
//    }
//
//
//    private void createToken(final Card card) {
//        PaystackSdk.setPublicKey("pk_live_8f26d9278e6d91e0450b7e912b14c78740521a73");
//        Charge charge = new Charge();
//        charge.setAmount(200);
//        charge.setCurrency("NGN");
//        if(null== sessionmanager.getUserDetails().get(sessionmanager.getUserDetails().get(SessionManager.KEY_DriverEmail))){
//
//            charge.setEmail("");
//        }else{
//            charge.setEmail(sessionmanager.getUserDetails().get(sessionmanager.getUserDetails().get(SessionManager.KEY_DriverEmail)));
//        }
//        charge.setCard(card); //sets the card to charge
//
//
//
//
//        PaystackSdk.chargeCard(PayWithPaystackActivity.this, charge, new Paystack.TransactionCallback() {
//            @Override
//            public void onSuccess(co.paystack.android.Transaction transaction) {
//                progressDialog.dismiss();
//                // This is called only after transaction is deemed successful.
//                // Retrieve the transaction, and send its reference to your server
//                // for verification.
//
//
//                Log.d("*** onsucess","suc"+transaction.getReference()+"card_last4="+card.getLast4digits()+" card_month"+card.getExpiryMonth()+"card_year"+card.getExpiryYear());
//
//
//
//
//                HashMap<String, String> data = new HashMap<>();
//                data.put("payment_option", "PAYSTACK");
//                data.put("token", "" + transaction.getReference());
//                data.put("cc_number",mEditCardNumber.getText().toString());
//                data.put("exp_month",mEditExpiryMonth.getText().toString());
//                data.put("exp_year",mEditExpiryYear.getText().toString());
//                if(null == sessionmanager.getUserDetails().get(sessionmanager.getUserDetails().get(SessionManager.KEY_DriverEmail))){
//
//                    data.put("payment_email","");
//
//                }else {
//                    data.put("payment_email",sessionmanager.getUserDetails().get(sessionmanager.getUserDetails().get(SessionManager.KEY_DriverEmail)));
//                }
//                try {
//                    progressDialog.show();
//                    apiManagerNew._post(API_S.Tags.SEND_STRIPE_TOKEN, API_S.Endpoints.SEND_STRIPE_TOKEN, data, sessionmanager);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//
//
//
////                Intent intent = new Intent();
////                intent.putExtra("CREDIT_ID", transaction.getReference());
////                intent.putExtra("card_last4", card.getLast4digits());
////                intent.putExtra("card_month", card.getExpiryMonth());
////                intent.putExtra("card_year", card.getExpiryYear());
////                setResult(RESULT_OK, intent);
////                finish();
//                Log.d("*** onsucess","suc"+transaction.getReference()+" ddd"+card.getType());
//            }
//
//            @Override
//            public void beforeValidate(co.paystack.android.Transaction transaction) {
//                Log.d("*** before validate","befor"+transaction.getReference());
//                // This is called only before requesting OTP.
//                // Save reference so you may send to server. If
//                // error occurs with OTP, you should still verify on server.
//            }
//
//            @Override
//            public void onError(Throwable error, Transaction transaction) {
//                progressDialog.dismiss();
//                Log.d("*** error","err"+transaction.getReference()+"trow"+error);
//                //handle error here
//            }
//
//        });
//
//    }
//
//
//
//
//}
//
