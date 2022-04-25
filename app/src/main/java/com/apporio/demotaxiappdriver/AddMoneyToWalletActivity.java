package com.apporio.demotaxiappdriver;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

//import com.apporio.demotaxiappdriver.customization.razorpay.RazorPayPaymentGateway;
import com.apporio.demotaxiappdriver.customization.razorpay.RazorPayPaymentGateway;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.customization.CCAvenue.CcVenueModel;
import com.apporio.demotaxiappdriver.customization.CCAvenue.WebViewActivity;
import com.apporio.demotaxiappdriver.customization.CCAvenue.utility.AvenuesParams;
import com.apporio.demotaxiappdriver.customization.CCAvenue.utility.ServiceUtility;
//import com.apporio.demotaxiappdriver.customization.Paypal.PaypalPaymentActivity;
//import com.apporio.demotaxiappdriver.customization.mpesa.MainMpesa;
//import com.apporio.demotaxiappdriver.customization.paytm.PaytmPayment;
//import com.apporio.demotaxiappdriver.customization.razorpay.RazorPayPaymentGateway;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelAddMoney;
import com.apporio.demotaxiappdriver.samwork.ApiManager;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddMoneyToWalletActivity extends BaseActivity implements ApiManager.APIFETCHER{

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.ed_enter_money)
    EditText edEnterMoney;
    @Bind(R.id.am_first_txt)
    TextView amFirstTxt;
    @Bind(R.id.am_second_txt)
    TextView amSecondTxt;
    @Bind(R.id.am_third_txt)
    TextView amThirdTxt;
    @Bind(R.id.txt_add_money)
    Button txtAddMoney;
    @Bind(R.id.root)
    LinearLayout root;
    ApiManager apiManager;
    CcVenueModel ccVenueModel;
    private final String TAG = "AddMoneyToWalletActivity";
    private SessionManager sessionManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_money_to_wallet);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this,this);

        try{
            amFirstTxt.setText(""+sessionManager.getAppConfig().getData().getGeneral_config().getDriver_wallet_package().get(0).getAmount()+" +");
            amSecondTxt.setText(""+sessionManager.getAppConfig().getData().getGeneral_config().getDriver_wallet_package().get(1).getAmount()+" +");
            amThirdTxt.setText(""+sessionManager.getAppConfig().getData().getGeneral_config().getDriver_wallet_package().get(2).getAmount()+" +");
        }catch (Exception e){}


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        amFirstTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    setAmount(Long.parseLong(""+sessionManager.getAppConfig().getData().getGeneral_config().getDriver_wallet_package().get(0).getAmount()));
                } catch (Exception e) {
                    Log.d("" + TAG, "" + e.getMessage());
                }
            }
        });


        amSecondTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    setAmount(Long.parseLong(""+sessionManager.getAppConfig().getData().getGeneral_config().getDriver_wallet_package().get(1).getAmount()));
                } catch (Exception e) {
                    Log.d("" + TAG, "" + e.getMessage());
                }
            }
        });

        amThirdTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    setAmount(Long.parseLong(""+sessionManager.getAppConfig().getData().getGeneral_config().getDriver_wallet_package().get(2).getAmount()));
                } catch (Exception e) {
                    Log.d("" + TAG, "" + e.getMessage());
                }
            }
        });

        txtAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onSelectMethod();
                Intent intent = new Intent(AddMoneyToWalletActivity.this, RazorPayPaymentGateway.class)
                        .putExtra("wallet_amount", edEnterMoney.getText().toString())
                        .putExtra("activity", "wallet")
                        .putExtra("currency", "" + sessionManager.getCurrencyCode());
                         startActivityForResult(intent, 112);

                //onSelectMethodPaymentMethod();

            }
        });
    }

    private void selectCCAvenueMethod() {

        if (edEnterMoney.getText().toString().equals("")) {
            Toast.makeText(AddMoneyToWalletActivity.this, R.string.please_enter_valid_amount, Toast.LENGTH_SHORT).show();
        } else {
            String vAccessCode = ServiceUtility.chkNull("AVWG83GA03BW24GWWB").toString().trim();
            String vMerchantId = ServiceUtility.chkNull("187905").toString().trim();
            String vCurrency = ServiceUtility.chkNull(sessionManager.getCurrencyCode()).toString().trim();
            //  String vAmount =       ServiceUtility.chkNull(edEnterMoney.getText()).toString().trim();
            String vAmount = ServiceUtility.chkNull(edEnterMoney.getText().toString()).toString().trim();
            if (!vAccessCode.equals("") && !vMerchantId.equals("") && !vCurrency.equals("") && !vAmount.equals("")) {
                Intent intent = new Intent(AddMoneyToWalletActivity.this, WebViewActivity.class);
                intent.putExtra(AvenuesParams.ACCESS_CODE, ServiceUtility.chkNull(vAccessCode).toString().trim());
                intent.putExtra(AvenuesParams.MERCHANT_ID, ServiceUtility.chkNull(vMerchantId).toString().trim());
                intent.putExtra(AvenuesParams.ORDER_ID, ServiceUtility.chkNull(65790).toString().trim());
                intent.putExtra(AvenuesParams.CURRENCY, ServiceUtility.chkNull(vCurrency).toString().trim());
                intent.putExtra(AvenuesParams.AMOUNT, ServiceUtility.chkNull(vAmount).toString().trim());
                intent.putExtra(AvenuesParams.REDIRECT_URL, ServiceUtility.chkNull("" + ccVenueModel.getReturn_url()).toString().trim());
                intent.putExtra(AvenuesParams.CANCEL_URL, ServiceUtility.chkNull("" + ccVenueModel.getCancel_url()).toString().trim());
                intent.putExtra(AvenuesParams.RSA_KEY_URL, ServiceUtility.chkNull("" + ccVenueModel.getRsakey()).toString().trim());
                startActivityForResult(intent, 101);
            }
        }
    }

    public void onSelectMethodPaymentMethod() {
        android.app.AlertDialog.Builder builderSingle = new android.app.AlertDialog.Builder(AddMoneyToWalletActivity.this);
        builderSingle.setTitle(R.string.RIDE_SELECTED_ACTIVITY__payment);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddMoneyToWalletActivity.this, android.R.layout.select_dialog_singlechoice);

        for (int i = 0; i < sessionManager.getAppConfig().getData().getPaymentOption().size(); i++) {
            arrayAdapter.add("" + sessionManager.getAppConfig().getData().getPaymentOption().get(i).getName());
        }

        builderSingle.setNegativeButton(AddMoneyToWalletActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {

                    if (sessionManager.getAppConfig().getData().getPaymentOption().get(which).getName().equals("RAZORPAY")) {
//                        Intent intent = new Intent(AddMoneyToWalletActivity.this, RazorPayPaymentGateway.class)
//                                .putExtra("wallet_amount", edEnterMoney.getText().toString())
//                                .putExtra("activity", "wallet")
//                                .putExtra("currency", "" + sessionManager.getCurrencyCode());
//                        startActivityForResult(intent, 112);
                    } else if (sessionManager.getAppConfig().getData().getPaymentOption().get(which).getName().equals("M-PESA")) {
//                        Intent intent = new Intent(AddMoneyToWalletActivity.this, MainMpesa.class)
//                                .putExtra("amount", "" + edEnterMoney.getText().toString())
//                                .putExtra("phone", "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_PHONE));
//                        startActivityForResult(intent, 112);
                    } else if (sessionManager.getAppConfig().getData().getPaymentOption().get(which).getName().equals("CC-AVENUE")) {
                        selectCCAvenueMethod();
                    }
                    else if (sessionManager.getAppConfig().getData().getPaymentOption().get(which).getName().equals("PAYTM")){

//                        Intent intent = new Intent(AddMoneyToWalletActivity.this, PaytmPayment.class)
//                                .putExtra("amount",""+edEnterMoney.getText().toString());
//                        startActivityForResult(intent,112);


                    }else if (sessionManager.getAppConfig().getData().getPaymentOption().get(which).getName().equals("PAYTM")){

//                        Intent intent = new Intent(AddMoneyToWalletActivity.this, PaypalPaymentActivity.class)
//                                .putExtra("amount",""+edEnterMoney.getText().toString());
//                        startActivityForResult(intent,112);

                    }
                    else {
                        onSelectMethod();
                    }
                    dialog.dismiss();
                } catch (Exception e) {
                    Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
                }
                dialog.dismiss();
            }
        });
        builderSingle.show();
    }

    
    private void onSelectMethod(){

        if(edEnterMoney.getText().toString().equals("")){
            Snackbar.make(root, R.string.please_enter_valid_amount,Snackbar.LENGTH_SHORT).show();
        }else{

            if(edEnterMoney.getText().toString().equals("")){
                Snackbar.make(root, R.string.please_enter_valid_amount,Snackbar.LENGTH_SHORT).show();
            }else{
                final String[] payments = {"Credit Card"};
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(AddMoneyToWalletActivity.this);
                builderSingle.setTitle("" + AddMoneyToWalletActivity.this.getResources().getString(R.string.select_payment_method));
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddMoneyToWalletActivity.this, android.R.layout.select_dialog_singlechoice);

                for (int i = 0; i < payments.length; i++) {
                    arrayAdapter.add("" + payments[i]);
                }
                builderSingle.setNegativeButton("" + "" + AddMoneyToWalletActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == 0){
                            startActivity(new Intent(AddMoneyToWalletActivity.this, CardListActivity.class)
                                    .putExtra("ADD_MONEY","1")
                                    .putExtra(""+ IntentKeys.TOP_UP_AMOUNT,""+edEnterMoney.getText().toString()));
                            finish();
                        }
                        dialog.dismiss();
                    }
                });
                builderSingle.show();
            }
        }
    }


    private void setAmount(double value) throws Exception {
        Double money = 0.0;

        if (!edEnterMoney.getText().toString().equals("")) {
            money = Double.parseDouble("" + edEnterMoney.getText().toString());
        }
        edEnterMoney.setText("" + (money + value));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        try{
            if (requestCode == 112 && resultCode == RESULT_OK) {


                if (data.getStringExtra("success").equals("success")) {
                    HashMap<String, String> datas = new HashMap<>();
                    datas.put("amount", "" + edEnterMoney.getText().toString());
                    datas.put("payment_method", "2");  // 1 for cash 2 for non cash
                    datas.put("receipt_number", "Application");
                    datas.put("description", "sending as per demo card only");
                    try {
                        apiManager._post(""+API_S.Tags.ADD_MONEY_IN_WALLET,""+API_S.Endpoints.ADD_MONEY_IN_WALLET,datas,sessionManager);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (data.getStringExtra("failed").equals("failed")) {

                }
            }else if (requestCode == 100 && resultCode == RESULT_OK) {
                if (data.getStringExtra("success").equals("success")) {
                    Intent intent = new Intent();
                    intent.putExtra("success","success");
                    setResult(RESULT_OK,intent);
                    finish();

                } else if (data.getStringExtra("failed").equals("failed")) {

                }
            }

        }



    catch (Exception e){

        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

        if (APINAME.equals("" + API_S.Tags.ADD_MONEY_IN_WALLET)) {
            ModelAddMoney modelAddMoney = SingletonGson.getInstance().fromJson("" + script, ModelAddMoney.class);
            Toast.makeText(this, "" + modelAddMoney.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.putExtra("ok", "Done");
            setResult(RESULT_OK, intent);
            finish();
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }

}