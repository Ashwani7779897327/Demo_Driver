//package com.apporio.demotaxiappdriver.customization.paytm;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.apporio.demotaxiappdriver.R;
//import com.apporio.demotaxiappdriver.SingletonGson;
//import com.apporio.demotaxiappdriver.currentwork.API_S;
//import com.apporio.demotaxiappdriver.manager.SessionManager;
//import com.apporio.demotaxiappdriver.samwork.ApiManager;
//import com.paytm.pgsdk.PaytmOrder;
//import com.paytm.pgsdk.PaytmPGService;
//import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
////import com.paytm.pgsdk.PaytmOrder;
////import com.paytm.pgsdk.PaytmPGService;
////import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
//
//import java.util.HashMap;
//
//public class PaytmPayment extends AppCompatActivity implements ApiManager.APIFETCHER, PaytmPaymentTransactionCallback {
//
//    SessionManager sessionManager;
//    ApiManager apiManagerNew;
//    PaytmPGService paytmPGService;   // for testing
//
//
//    String mid = "NagarS84844688963947";
//    String chanelId = "WAP";
//    String callback_url = "https://pguat.paytm.com/paytmchecksum/paytmCallback.jsp";
//    String industry_type_id="Retail";
//    String amount = "";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_paytm_payment);
//
//        sessionManager = new SessionManager(this);
//        apiManagerNew = new ApiManager(this,this);
//        amount = getIntent().getStringExtra("amount");
//
//        generateChecksum();
//
//    }
//
//
//    public void generateChecksum()
//    {
//        HashMap<String,String> params = new HashMap<>();
//        params.put("Authorization",""+sessionManager.getAccessToken());
//        params.put("txnAmount",amount);
//        params.put("for","user");
//
//        try {
//            apiManagerNew._post(API_S.Tags.PAYTM_CHECKSUM,API_S.Endpoints.Paytm_checksum,params,sessionManager);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//
//    @Override
//    public void onTransactionResponse(Bundle inResponse) {
//
//        String respcode = inResponse.getString("RESPCODE");
//
//        if(respcode.equals("01")){
//
//            Intent output = new Intent();
//            output.putExtra("success", "success");
//            setResult(RESULT_OK, output);
//            finish();
//
//        }else if (respcode.equals("227")){
//
//
//            Toast.makeText(this, "Your payment has been declined by your bank. Please contact your bank for any queries.", Toast.LENGTH_SHORT).show();
//            Intent output = new Intent();
//            output.putExtra("failed", "failed");
//            setResult(RESULT_OK, output);
//            finish();
//
//        }else if(respcode.equals("334"))
//        {
//            Toast.makeText(this, "Invalid Order ID", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, "Payment error please try again", Toast.LENGTH_SHORT).show();
//            Intent output = new Intent();
//            output.putExtra("failed", "failed");
//            setResult(RESULT_OK, output);
//            finish();
//
//        }else if (respcode.equals("400")){
//
//            Toast.makeText(this, "Transaction status not confirmed yet", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, "Invalid Order ID", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, "Payment error please try again", Toast.LENGTH_SHORT).show();
//            Intent output = new Intent();
//            output.putExtra("failed", "failed");
//            setResult(RESULT_OK, output);
//            finish();
//
//        }else if(respcode.equals("401"))
//        {
//
//            Toast.makeText(this, "Your payment has been declined by your bank. Please contact your bank for any queries.", Toast.LENGTH_SHORT).show();
//            Intent output = new Intent();
//            output.putExtra("failed", "failed");
//            setResult(RESULT_OK, output);
//            finish();
//        }else if(respcode.equals("402")){
//
//
//            Toast.makeText(this, "Looks like the payment is not complete. Please wait while we confirm the status with your bank", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, "Your payment has been declined by your bank. Please contact your bank for any queries.", Toast.LENGTH_SHORT).show();
//            Intent output = new Intent();
//            output.putExtra("failed", "failed");
//            setResult(RESULT_OK, output);
//            finish();
//        }
//        else if(respcode.equals("810"))
//        {
//
//            Toast.makeText(this, "Payment error", Toast.LENGTH_SHORT).show();
//            Intent output = new Intent();
//            output.putExtra("failed", "failed");
//            setResult(RESULT_OK, output);
//            finish();
//        }
//
//
//    }
//
//    @Override
//    public void networkNotAvailable() {
//
//        Toast.makeText(this, "Network not available", Toast.LENGTH_SHORT).show();
//        Log.d("pppp","networkNotAvailable()");
//        finish();
//    }
//
//    @Override
//    public void clientAuthenticationFailed(String inErrorMessage) {
//        Toast.makeText(this, "Client Authenitcation failed", Toast.LENGTH_SHORT).show();
//        finish();
//        Log.d("pppp","clientAuthenticationFailed : "+inErrorMessage);
//
//
//    }
//
//    @Override
//    public void someUIErrorOccurred(String inErrorMessage) {
//
//        Log.d("pppp","someUIErrorOccurred  : "+inErrorMessage);
//
//        finish();
//
//
//    }
//
//    @Override
//    public void onErrorLoadingWebPage(int iniErrorCode, String inErrorMessage, String inFailingUrl) {
//
//        Toast.makeText(this, "Unable to load web page", Toast.LENGTH_SHORT).show();
//
//        Log.d("pppp","onErrorLoadingWebPage  : "+inErrorMessage);
//        finish();
//
//    }
//
//    @Override
//    public void onBackPressedCancelTransaction() {
//
//        Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show();
//        Log.d("pppp","onBackPressedCancelTransaction  : ");
//
//    }
//
//    @Override
//    public void onTransactionCancel(String inErrorMessage, Bundle inResponse) {
//
//        Toast.makeText(this, "Transaction Cancelled", Toast.LENGTH_SHORT).show();
//        finish();
//        Log.d("pppp","onTransactionCancel  : ");
//
//
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
//        if(APINAME.equals(""+API_S.Tags.PAYTM_CHECKSUM))
//        {
//
//            ChecksumModel checksumModel = SingletonGson.getInstance().fromJson(""+script,ChecksumModel.class);
//
//            if(checksumModel.getGatewayCondition()==1){
//                paytmPGService = PaytmPGService.getProductionService();
//            }else {
//                paytmPGService = PaytmPGService.getStagingService();   // for testing
//            }
//
//
//            if(checksumModel.getResult().equals("1"))
//            {
//
//                HashMap<String,String> params = new HashMap<>();
//                params.put("MID", checksumModel.getMerchantId()); //MID provided by paytm
//                params.put("ORDER_ID", checksumModel.getOrder_id());
//                params.put("CUST_ID", checksumModel.getId());
//                params.put("INDUSTRY_TYPE_ID", industry_type_id);
//                params.put("CHANNEL_ID", chanelId);
//                params.put("TXN_AMOUNT", amount);
////               params.put("CALLBACK_URL","https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID="+checksumModel
////                 .getOrder_id());
//                //paramMap.put( "EMAIL" , "abc@gmail.com");   // no need
//                // paramMap.put( "MOBILE_NO" , "9144040888");  // no need
//                //paramMap.put("PAYMENT_TYPE_ID" ,"CC");    // no need
//                params.put("WEBSITE", "WEBSTAGING");
//                params.put("CALLBACK_URL" ,checksumModel.getCallbackURL());
//                params.put("CHECKSUMHASH" ,checksumModel.getPaytmChecksum());
//
//                Log.d("pppp","checksum and orderid "+checksumModel.getPaytmChecksum()+" , "+checksumModel.getOrder_id());
//
//                PaytmOrder paytmOrder = new PaytmOrder(params);
//                paytmPGService.initialize(paytmOrder,null);
//                paytmPGService.startPaymentTransaction(this,true,true,this);
//
//            }
//        }
//
//    }
//
//    @Override
//    public void onFetchResultZero(String script) {
//
//    }
//}
//
