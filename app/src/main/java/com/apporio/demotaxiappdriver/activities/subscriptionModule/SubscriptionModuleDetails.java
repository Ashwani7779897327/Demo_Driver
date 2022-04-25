package com.apporio.demotaxiappdriver.activities.subscriptionModule;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.AddMoneyToWalletActivity;
import com.apporio.demotaxiappdriver.CardListActivity;
import com.apporio.demotaxiappdriver.HolderServicelayoutSubscription;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelActiveSubscription;
import com.apporio.demotaxiappdriver.models.ModelSubscriptionList;
import com.apporio.demotaxiappdriver.others.PlaceHolderZoomOutAnimation;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.apporio.demotaxiappdriver.samwork.ModelResultCheck;
import com.bumptech.glide.Glide;
import com.sam.placer.PlaceHolderView;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubscriptionModuleDetails extends BaseActivity implements ApiManager.APIFETCHER {

    ModelSubscriptionList.DataBean databean;
    List<ModelSubscriptionList.PaymentMethodBean> payment_method;
    private final String TAG = "SubscriptionModuleDetails";

    @Bind(R.id.package_name1)
    TextView package_name;
    @Bind(R.id.rides_left)
    TextView rides_left;
    @Bind(R.id.valid_till)
    TextView valid_till;
    @Bind(R.id.about_package)
    TextView about_package;
    @Bind(R.id.validity)
    TextView validity;
    @Bind(R.id.image_show1)
    ImageView image_show;
    @Bind(R.id.placeholder_services)
    PlaceHolderView placeHolderViewServices;
    @Bind(R.id.llActivatedPackage)

    LinearLayout llActivatedPackage;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.btnBuyNow)
    Button btnBuyNow;
    @Bind(R.id.maximum_rides1)
    TextView maximum_rides1;
    SessionManager sessionManager;
    ApiManager apiManager;
    ProgressDialog progressDialog;
    @Bind(R.id.tvActivate)
    TextView tvActivate;
    @Bind(R.id.llExpiryDate)
    LinearLayout llExpiryDate;
    @Bind(R.id.expiryDate)
    TextView expiryDate;

    int selectPaymentMethod;
    String FROM = "";

    ModelSubscriptionList modelSubscriptionList;
    ModelSubscriptionList.ActivePackDetailBean activePackDetailBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_subscription_module_details);

        ButterKnife.bind(this);

        try {

            FROM = getIntent().getStringExtra("FROM");

            if (FROM.equals("0")) {
                payment_method = (List<ModelSubscriptionList.PaymentMethodBean>) getIntent().getSerializableExtra("methods");
                activePackDetailBean = (ModelSubscriptionList.ActivePackDetailBean) getIntent().getSerializableExtra("details");
                modelSubscriptionList = (ModelSubscriptionList) getIntent().getSerializableExtra("modelSubscription");
                llExpiryDate.setVisibility(View.GONE);
            } else {
                databean = (ModelSubscriptionList.DataBean) getIntent().getSerializableExtra("details");
                payment_method = (List<ModelSubscriptionList.PaymentMethodBean>) getIntent().getSerializableExtra("methods");
                modelSubscriptionList = (ModelSubscriptionList) getIntent().getSerializableExtra("modelSubscription");
                llExpiryDate.setVisibility(View.VISIBLE);
            }

            if (FROM.equals("0")) {
                if (activePackDetailBean.getPackage_type() == 1) {
                    btnBuyNow.setText(getString(R.string.activate));
                } else {

                }
            } else {
                if (databean.getPackage_type() == 1) {
                    btnBuyNow.setText(getString(R.string.activate));
                } else {

                }
            }

        } catch (Exception e) {

        }


        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this, this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));

        setData();

        findViewById(R.id.ivBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubscriptionModuleDetails.this.finish();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void setData() {


        if (getIntent().getStringExtra("package_type").equals("free")) {
            btnBuyNow.setText("Activate");
        } else {
            btnBuyNow.setText("" + getResources().getString(R.string.buy_now));
        }

        //  llActivatedPackage.setVisibility(modelSubscriptionList.isActivated_pack() ? View.VISIBLE : View.GONE);

        if (FROM.equals("0")) {
            llActivatedPackage.setVisibility(View.GONE);
        } else {
            llActivatedPackage.setVisibility(View.GONE);
        }

        if (modelSubscriptionList.isActivated_pack()) {

            if (FROM.equals("0")) {
                package_name.setText(activePackDetailBean.getName());
                //  valid_till.setText(modelSubscriptionList.getActive_pack_detail().getEnd_date_time());
                //rides_left.setText(String.valueOf(modelSubscriptionList.getActive_pack_detail().getRides_left()));
                about_package.setText(activePackDetailBean.getDescription());
                validity.setText(activePackDetailBean.getPackage_duration_name());
                maximum_rides1.setText("" + activePackDetailBean.getPackage_total_trips());
                Glide.with(this).load("" + activePackDetailBean.getImage()).into(image_show);

                placeHolderViewServices.setLayoutManager(new PlaceHolderZoomOutAnimation(this, LinearLayoutManager.HORIZONTAL, false));

                for (int i = 0; i < activePackDetailBean.getService_type().size(); i++) {
                    placeHolderViewServices.addView(new HolderServicelayoutSubscription(this, activePackDetailBean.getService_type().get(i).getServiceName(), activePackDetailBean.getService_type().get(i).getIcon()));
                }
            } else {
                package_name.setText(databean.getName());
                //  valid_till.setText(modelSubscriptionList.getActive_pack_detail().getEnd_date_time());
                //rides_left.setText(String.valueOf(modelSubscriptionList.getActive_pack_detail().getRides_left()));
                about_package.setText(databean.getDescription());
                validity.setText(databean.getPackage_duration_name());
                maximum_rides1.setText("" + databean.getMax_trip());
                Glide.with(this).load("" + databean.getImage()).into(image_show);

                placeHolderViewServices.setLayoutManager(new PlaceHolderZoomOutAnimation(this, LinearLayoutManager.HORIZONTAL, false));

                for (int i = 0; i < databean.getService_type().size(); i++) {
                    placeHolderViewServices.addView(new HolderServicelayoutSubscription(this, databean.getService_type().get(i).getServiceName(), databean.getService_type().get(i).getIcon()));
                }

                expiryDate.setText(""+ databean.getExpire_date());
            }

//            try {
//                progressBar.setProgress(modelSubscriptionList.getActive_pack_detail().getUsed_trips());
//            } catch (Exception e) {
//
//            }

//            if (modelSubscriptionList.getActive_pack_detail().isExpiry_status()) {
//
//                tvActivate.setText("" + modelSubscriptionList.getActive_pack_detail().getExpiry_message());
//            }


        } else {
            if (FROM.equals("0")) {
                package_name.setText("" + activePackDetailBean.getName());
                about_package.setText("" + activePackDetailBean.getDescription());
                validity.setText(activePackDetailBean.getPackage_duration_name());
                Glide.with(this).load("" + activePackDetailBean.getImage()).into(image_show);
                maximum_rides1.setText("" + activePackDetailBean.getPackage_total_trips());
                placeHolderViewServices.setLayoutManager(new PlaceHolderZoomOutAnimation(this, LinearLayoutManager.HORIZONTAL, false));

                for (int i = 0; i < activePackDetailBean.getService_type().size(); i++) {
                    placeHolderViewServices.addView(new HolderServicelayoutSubscription(this, activePackDetailBean.getService_type().get(i).getServiceName(), activePackDetailBean.getService_type().get(i).getIcon()));
                }

            } else {
                package_name.setText("" + databean.getName());
                about_package.setText("" + databean.getDescription());
                validity.setText(databean.getPackage_duration_name());
                Glide.with(this).load("" + databean.getImage()).into(image_show);
                maximum_rides1.setText("" + databean.getMax_trip());
                placeHolderViewServices.setLayoutManager(new PlaceHolderZoomOutAnimation(this, LinearLayoutManager.HORIZONTAL, false));

                for (int i = 0; i < databean.getService_type().size(); i++) {
                    placeHolderViewServices.addView(new HolderServicelayoutSubscription(this, databean.getService_type().get(i).getServiceName(), databean.getService_type().get(i).getIcon()));
                }

                expiryDate.setText(""+ databean.getExpire_date());
            }

        }


        //  tvPackagePrice.setText("" + databean.getShow_price());
        // tvPackageDuration.setText("" + databean.getPackage_duration_name());
        // tvMaxTrips.setText("" + databean.getMax_trip());
        // tvDescription.setText("" + databean.getDescription());


    }


    //
    @OnClick(R.id.btnBuyNow)
    protected void onBuyNow(View view) {


        if (btnBuyNow.getText().toString().equals("Activate")) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getResources().getString(R.string.actiavte_package));
            builder.setPositiveButton("Yes", (dialog, which) -> {
                HashMap<String, String> datas = new HashMap<>();

                datas.put("subscription_package_id", "" + databean.getId());
                datas.put("payment_method_id", "");
                datas.put("payment_status", "" + "SUCCESS");
                datas.put("package_type", "" + databean.getPackage_type());


                try {
                    apiManager._post("" + API_S.Tags.ACTIVE_SUBSCRIPTION, "" + API_S.Endpoints.ACTIVE_SUBSCRIPTION, datas, sessionManager);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).setNegativeButton("No", (dialog, which) -> dialog.dismiss());
            builder.show();
        } else {
            onSelectMethodsForOpen();
        }


//        if (btnBuyNow.getText().toString().equals(getResources().getString(R.string.activate))) {
//            try {
//                HashMap<String, String> datas = new HashMap<>();
//                datas.put("subscription_package_id", "" + databean.getId());
//                datas.put("payment_method_id", "" + selectPaymentMethod);
//                datas.put("payment_status", "" + "SUCCESS");
//                apiManager._post("" + API_S.Tags.ACTIVATE_PACKAGE, "" + API_S.Endpoints.ACTIVATE_PACKAGE, datas, sessionManager);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            onSelectMethodsForOpen();
//        }
    }

    //
    public void onSelectMethodsForOpen() {
        android.app.AlertDialog.Builder builderSingle = new android.app.AlertDialog.Builder(SubscriptionModuleDetails.this);
        builderSingle.setTitle(R.string.RIDE_SELECTED_ACTIVITY__payment);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SubscriptionModuleDetails.this, android.R.layout.select_dialog_singlechoice);

        for (int i = 0; i < payment_method.size(); i++) {
            arrayAdapter.add("" + payment_method.get(i).getPayment_method());
        }

        builderSingle.setNegativeButton(SubscriptionModuleDetails.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
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

                    selectPaymentMethod = payment_method.get(which).getId();

                    if (payment_method.get(which).getId() == 3) { // wallet
                        HashMap<String, String> datas = new HashMap<>();

                        datas.put("subscription_package_id", "" + databean.getId());
                        datas.put("payment_method_id", "" + payment_method.get(which).getId());
                        datas.put("package_type", "" + databean.getPackage_type());
                        datas.put("payment_status", "" + "SUCCESS");


                        try {
                            apiManager._post("" + API_S.Tags.ACTIVE_SUBSCRIPTION, "" + API_S.Endpoints.ACTIVE_SUBSCRIPTION, datas, sessionManager);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else if (payment_method.get(which).getId() == 4) {  //online Payment
                        // set Method For Online Payment
                        onSelectMethod();
                    } else { // Credit Card etc
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


    //
    public void onSelectMethodPaymentMethod() {
        android.app.AlertDialog.Builder builderSingle = new android.app.AlertDialog.Builder(SubscriptionModuleDetails.this);
        builderSingle.setTitle(R.string.RIDE_SELECTED_ACTIVITY__payment);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SubscriptionModuleDetails.this, android.R.layout.select_dialog_singlechoice);

        for (int i = 0; i < sessionManager.getAppConfig().getData().getPaymentOption().size(); i++) {
            arrayAdapter.add("" + sessionManager.getAppConfig().getData().getPaymentOption().get(i).getName());
        }

        builderSingle.setNegativeButton(SubscriptionModuleDetails.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
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
//                       Intent intent = new Intent(SubscriptionModuleDetails.this, RazorpayPaymentGateway.class)
//                               .putExtra("wallet_amount", databean.getPrice())
//                                .putExtra("activity", "wallet")
//                               .putExtra("currency", "" + sessionManager.getCurrencyCode());
//                       startActivityForResult(intent, 112);
                    } else if (sessionManager.getAppConfig().getData().getPaymentOption().get(which).getName().equals("M-PESA")) {
//                        Intent intent = new Intent(SubscriptionModuleDetails.this, MainMpesa.class)
//                                .putExtra("amount", "" + databean.getPrice())
//                                .putExtra("phone", "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_PHONE));
//                        startActivityForResult(intent, 112);
                    } else if (sessionManager.getAppConfig().getData().getPaymentOption().get(which).getName().equals("CC-AVENUE")) {
                        // selectCCAvenueMethod();
                    } else if (sessionManager.getAppConfig().getData().getPaymentOption().get(which).getName().equals("PAYTM")) {
//
//                        Intent intent = new Intent(SubscriptionModuleDetails.this, PaytmPayment.class)
//                                .putExtra("amount", "" + databean.getPrice());
//                        startActivityForResult(intent, 112);


                    } else if (sessionManager.getAppConfig().getData().getPaymentOption().get(which).getName().equals("PAYTM")) {

//                        Intent intent = new Intent(SubscriptionModuleDetails.this, PaypalPaymentActivity.class)
//                                .putExtra("amount", "" + databean.getPrice());
//                        startActivityForResult(intent, 112);

                    } else {
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

    private void onSelectMethod() {
        final String[] payments = {"Credit Card"};
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(SubscriptionModuleDetails.this);
        builderSingle.setTitle("" + SubscriptionModuleDetails.this.getResources().getString(R.string.select_payment_method));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SubscriptionModuleDetails.this, android.R.layout.select_dialog_singlechoice);

        for (int i = 0; i < payments.length; i++) {
            arrayAdapter.add("" + payments[i]);
        }
        builderSingle.setNegativeButton("" + "" + SubscriptionModuleDetails.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    startActivity(new Intent(SubscriptionModuleDetails.this, CardListActivity.class)
                            .putExtra("ADD_MONEY", "2")
                            .putExtra("sub_id", "" + databean.getId())
                            .putExtra("payment_method_id", "" + selectPaymentMethod)
                            .putExtra("" + IntentKeys.TOP_UP_AMOUNT, "" + databean.getPrice()));
                    finish();
                }
                dialog.dismiss();
            }
        });
        builderSingle.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 112 && resultCode == RESULT_OK) {
            if (data.getStringExtra("success").equals("success")) {

                if (selectPaymentMethod != 0) {
                    HashMap<String, String> datas = new HashMap<>();
                    datas.put("subscription_package_id", "" + databean.getId());
                    datas.put("payment_method_id", "" + selectPaymentMethod);
                    datas.put("payment_status", "" + "SUCCESS");
                    datas.put("package_type", "" + databean.getPackage_type());

                    try {
                        apiManager._post("" + API_S.Tags.ACTIVE_SUBSCRIPTION, "" + API_S.Endpoints.ACTIVE_SUBSCRIPTION, datas, sessionManager);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            } else if (data.getStringExtra("failed").equals("failed")) {

            }
        } else if (requestCode == 100 && resultCode == RESULT_OK) {
            if (data.getStringExtra("success").equals("success")) {
                Intent intent = new Intent();
                intent.putExtra("success", "success");
                setResult(RESULT_OK, intent);
                finish();

            } else if (data.getStringExtra("failed").equals("failed")) {

            }
        }
    }

    //
    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (APINAME.equals(API_S.Tags.ACTIVE_SUBSCRIPTION)) {
            if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                progressDialog.show();
            } else if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        if (APINAME.equals("" + API_S.Tags.ACTIVE_SUBSCRIPTION)) {
            ModelActiveSubscription modelActiveSubscription = SingletonGson.getInstance().fromJson("" + script, ModelActiveSubscription.class);
            Toast.makeText(this, "" + modelActiveSubscription.getMessage(), Toast.LENGTH_SHORT).show();

            SubscriptionModuleDetails.this.finish();
        } else if (APINAME.equals("" + API_S.Tags.ACTIVATE_PACKAGE)) {
            ModelResultCheck modelResultCheck = SingletonGson.getInstance().fromJson("" + script, ModelResultCheck.class);

            if (modelResultCheck.result.equals("1")) {
                Toast.makeText(this, "" + modelResultCheck.message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SubscriptionModuleDetails.this);

        builder.create();
        builder.setTitle(script);
        builder.setPositiveButton("OK", (dialogInterface, i) -> {

            Intent intent = new Intent(SubscriptionModuleDetails.this, AddMoneyToWalletActivity.class);
            startActivity(intent);

        });
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss());

        builder.show();

    }

//    private void selectCCAvenueMethod() {
//
//        String vAccessCode = ServiceUtility.chkNull("AVWG83GA03BW24GWWB").toString().trim();
//        String vMerchantId = ServiceUtility.chkNull("187905").toString().trim();
//        String vCurrency = ServiceUtility.chkNull(sessionManager.getCurrencyCode()).toString().trim();
//        //  String vAmount =       ServiceUtility.chkNull(edEnterMoney.getText()).toString().trim();
//        String vAmount = ServiceUtility.chkNull(databean.getPrice().trim();
//        if (!vAccessCode.equals("") && !vMerchantId.equals("") && !vCurrency.equals("") && !vAmount.equals("")) {
//            Intent intent = new Intent(SubscriptionModuleDetails.this, WebViewActivity.class);
//            intent.putExtra(AvenuesParams.ACCESS_CODE, ServiceUtility.chkNull(vAccessCode).toString().trim());
//            intent.putExtra(AvenuesParams.MERCHANT_ID, ServiceUtility.chkNull(vMerchantId).toString().trim());
//            intent.putExtra(AvenuesParams.ORDER_ID, ServiceUtility.chkNull(65790).toString().trim());
//            intent.putExtra(AvenuesParams.CURRENCY, ServiceUtility.chkNull(vCurrency).toString().trim());
//            intent.putExtra(AvenuesParams.AMOUNT, ServiceUtility.chkNull(vAmount).toString().trim());
//            intent.putExtra(AvenuesParams.REDIRECT_URL, ServiceUtility.chkNull("" + ccVenueModel.getReturn_url()).toString().trim());
//            intent.putExtra(AvenuesParams.CANCEL_URL, ServiceUtility.chkCNull("" + ccVenueModel.getCancel_url()).toString().trim());
//            intent.putExtra(AvenuesParams.RSA_KEY_URL, ServiceUtility.chkNull("" + ccVenueModel.getRsakey()).toString().trim());
//            startActivityForResult(intent, 101);
//        }
//    }
}
