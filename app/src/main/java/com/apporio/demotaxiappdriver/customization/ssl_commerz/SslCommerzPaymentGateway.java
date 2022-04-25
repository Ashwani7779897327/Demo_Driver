//package com.apporio.demotaxiappdriver.customization.ssl_commerz;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.apporio.demotaxiappdriver.R;
//import com.sslcommerz.library.payment.model.datafield.MandatoryFieldModel;
//import com.sslcommerz.library.payment.model.dataset.TransactionInfo;
//import com.sslcommerz.library.payment.model.util.CurrencyType;
//import com.sslcommerz.library.payment.model.util.ErrorKeys;
//import com.sslcommerz.library.payment.model.util.SdkCategory;
//import com.sslcommerz.library.payment.model.util.SdkType;
//import com.sslcommerz.library.payment.viewmodel.listener.OnPaymentResultListener;
//import com.sslcommerz.library.payment.viewmodel.management.PayUsingSSLCommerz;
//
//import java.util.Random;
//
//public class SslCommerzPaymentGateway extends AppCompatActivity {
//    String TAG = "ssl";
//    TextView tv;
//    EditText et;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ssl_commerz_payment_gateway);
//
//
//        try {
//
//            doPay(getIntent().getStringExtra("amount"));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    private void doPay(String amount) {
//
//        int rand = new Random().nextInt();
//
//        /*Mandatory Field*/
//        MandatoryFieldModel mandatoryFieldModel = new MandatoryFieldModel("angel5c99d0c7d63dc", "angel5c99d0c7d63dc@ssl", amount,
//                "trans_" + rand, CurrencyType.BDT, SdkType.TESTBOX, SdkCategory.BANK_LIST);
//
//        /*Call for the payment*/
//        PayUsingSSLCommerz.getInstance().setData(this, mandatoryFieldModel, new OnPaymentResultListener() {
//
//
//                    @Override
//                    public void transactionSuccess(TransactionInfo transactionInfo) {
//                        if (transactionInfo.getRiskLevel().equals("0")) {
//
//                            Log.d(TAG, "Transaction Successfully completed");
//                            Log.d(TAG, transactionInfo.getTranId());
//                            Log.d(TAG, transactionInfo.getBankTranId());
//                            Log.d(TAG, transactionInfo.getAmount());
//                            Log.d(TAG, transactionInfo.getStoreAmount());
//                            Log.d(TAG, transactionInfo.getTranDate());
//                            Log.d(TAG, transactionInfo.getStatus());
//
//                            Toast.makeText(SslCommerzPaymentGateway.this, "Payment Successfully Done!", Toast.LENGTH_SHORT).show();
//                            Intent output = new Intent();
//                            output.putExtra("success", "success");
//                            setResult(RESULT_OK, output);
//                            finish();
//                        }
//                        // Payment is success but payment is not complete yet. Card on hold now.
//                        else {
//                            Log.d(TAG, "Transaction in risk. Risk Title : " + transactionInfo.getRiskTitle().toString());
//                            Toast.makeText(SslCommerzPaymentGateway.this, "Payment is success but payment is not complete yet. Card on hold now.", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//
//                    @Override
//                    public void transactionFail(String s) {
//                        Log.e(TAG, "Transaction Fail");
//
//                        Toast.makeText(SslCommerzPaymentGateway.this, "Payment error ! please try again", Toast.LENGTH_SHORT).show();
//                        Intent output = new Intent();
//                        output.putExtra("failed", "failed");
//                        setResult(RESULT_OK, output);
//                        finish();
//
//                    }
//
//                    @Override
//                    public void error(int i) {
//
//
//                        switch (i) {
//                            // Your provides information is not valid.
//                            case ErrorKeys.USER_INPUT_ERROR:
//                                Log.e(TAG, "User Input Error");
//                                Toast.makeText(SslCommerzPaymentGateway.this, "User Input Error", Toast.LENGTH_SHORT).show();
//                                break;
//                            // Internet is not connected.
//                            case ErrorKeys.INTERNET_CONNECTION_ERROR:
//                                Log.e(TAG, "Internet Connection Error");
//                                Toast.makeText(SslCommerzPaymentGateway.this, "Internet Connection Error", Toast.LENGTH_SHORT).show();
//                                break;
//                            // Server is not giving valid data.
//                            case ErrorKeys.DATA_PARSING_ERROR:
//                                Log.e(TAG, "Data Parsing Error");
//                                break;
//                            // User press back button or canceled the transaction.
//                            case ErrorKeys.CANCEL_TRANSACTION_ERROR:
//                                Log.e(TAG, "User Cancel The Transaction");
//                                Toast.makeText(SslCommerzPaymentGateway.this, "Transaction cancelled", Toast.LENGTH_SHORT).show();
//                                break;
//                            // Server is not responding.
//                            case ErrorKeys.SERVER_ERROR:
//                                Log.e(TAG, "Server Error");
//                                Toast.makeText(SslCommerzPaymentGateway.this, "Server Error", Toast.LENGTH_SHORT).show();
//                                break;
//                            // For some reason network is not responding
//                            case ErrorKeys.NETWORK_ERROR:
//                                Log.e(TAG, "Network Error");
//                                Toast.makeText(SslCommerzPaymentGateway.this, "Network Error", Toast.LENGTH_SHORT).show();
//                                break;
//                        }
//                        // et.setText(null);
//                    }
//
//
//                }
//
//        );
//
//    }
//
//}