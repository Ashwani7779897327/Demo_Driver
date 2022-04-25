package com.apporio.demotaxiappdriver.wallet;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AlertDialog;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.AddMoneyToWalletActivity;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelAddMoney;
import com.apporio.demotaxiappdriver.models.ModelWalletBalance;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.bumptech.glide.Glide;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Position;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WalletActivity extends BaseActivity implements ApiManager.APIFETCHER {


    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.placeholder)
    PlaceHolderView placeholder;
    @Bind(R.id.swiperefreshLayout)
    SwipeRefreshLayout swiperefreshLayout;
    @Bind(R.id.root)
    LinearLayout root;

    private ApiManager apiManager;
    private SessionManager sessionManager;
    private final String TAG = "WalletActivity";
    private String TRANSACTION_TYPE = "3";
    private int LOADING_FACTOR = 9;
    ModelWalletBalance modelWalletBalance;
    ModelAddMoney modelAddMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);

        apiManager = new ApiManager(this,this);
        sessionManager = new SessionManager(this);

        back.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                finish();
            }
        });

        swiperefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    callAPI();
                } catch (Exception e) {
                   Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                }
            }
        });


    }


    private void callAPI() throws Exception {
        LOADING_FACTOR = 9;
        HashMap<String, String> data = new HashMap<>();
        data.put("filter", "" + TRANSACTION_TYPE);
        apiManager._post(API_S.Tags.WALLET_BALANCE, API_S.Endpoints.WALLET_BALANCE, data, sessionManager);
        placeholder.removeAllViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            callAPI();
        } catch (Exception e) {
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            swiperefreshLayout.setRefreshing(true);
        } else {
            swiperefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {

            switch (APINAME) {
                case API_S.Tags.ADD_MONEY_IN_WALLET:
                    modelAddMoney = SingletonGson.getInstance().fromJson("" + script, ModelAddMoney.class);
                    Toast.makeText(this, "" + modelAddMoney.getMessage(), Toast.LENGTH_SHORT).show();
                    callAPI();
                    break;
                case API_S.Tags.WALLET_BALANCE:
                    modelWalletBalance = SingletonGson.getInstance().fromJson("" + script, ModelWalletBalance.class);
                    placeholder.addView(new HolderTopWalletLayout(modelWalletBalance.getData().getWallet_money(), modelWalletBalance.getData().getRecent_transactoin().size() > 0 ? true : false));
                    if (modelWalletBalance.getData().getRecent_transactoin().size() > 0) {
                        for (int i = 0; i < modelWalletBalance.getData().getRecent_transactoin().size(); i++) {
                            placeholder.addView(new HolderRecentTransaction(modelWalletBalance.getData().getRecent_transactoin().get(i), placeholder, "" + modelWalletBalance.getNext_page_url()));
                        }
                    } else {

                        Snackbar.make(root, com.apporio.demotaxiappdriver.R.string.no_view_for_receent_items, Snackbar.LENGTH_SHORT).show();
                    }
                    break;
                case API_S.Tags.LOAD_MORE_TRANSACTION:

                    ModelWalletBalance transaction = SingletonGson.getInstance().fromJson("" + script, ModelWalletBalance.class);
                    if (transaction.getData().getRecent_transactoin().size() > 0) {
                        for (int i = 0; i < transaction.getData().getRecent_transactoin().size(); i++) {
                            placeholder.addView(new HolderRecentTransaction(transaction.getData().getRecent_transactoin().get(i), placeholder, "" + transaction.getNext_page_url()));
                        }
                    } else {
                        Snackbar.make(root, "No View For recent items", Snackbar.LENGTH_SHORT).show();
                    }

                    break;
            }


        } catch (Exception e) {
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
    }

    @Layout(R.layout.holder_wallet_top_layout)
    class HolderTopWalletLayout {
        @View(R.id.wallet_amount_text)
        TextView walletAmountText;
        @View(R.id.add_money_btn)
        TextView addMoneyBtn;
        @View(R.id.promo_code_btn)
        TextView promoCodeBtn;
        @View(R.id.recent_layout_transaction)
        LinearLayout recent_layout;


        private String mWalletBalance;
        private boolean showRecentTransaction;

        public HolderTopWalletLayout(String wallet_balance, boolean showrecenttrans) {
            this.mWalletBalance = wallet_balance;
            this.showRecentTransaction = showrecenttrans;
        }


        @Resolve
        private void setdata() {
            walletAmountText.setText("" + mWalletBalance);
            if (showRecentTransaction) {
                recent_layout.setVisibility(android.view.View.VISIBLE);
            } else {
                recent_layout.setVisibility(android.view.View.GONE);
            }
        }


        @Click(R.id.add_money_btn)
        private void onAddMneyClick() {
            Intent intent = new Intent(WalletActivity.this, AddMoneyToWalletActivity.class);
            startActivityForResult(intent, 100);
        }

        @Click(R.id.filter)
        private void onFilterClick() {
            AlertDialog.Builder builderSingle = new AlertDialog.Builder(WalletActivity.this);
            builderSingle.setTitle("" + WalletActivity.this.getResources().getString(R.string.filter_transactions));
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(WalletActivity.this, android.R.layout.select_dialog_singlechoice);
            arrayAdapter.add(getString(R.string.all));
            arrayAdapter.add(getString(R.string.paid));
            arrayAdapter.add(getString(R.string.received));

            builderSingle.setNegativeButton("" + "" + WalletActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            TRANSACTION_TYPE = "3";
                            break;
                        case 1:
                            TRANSACTION_TYPE = "2";
                            break;
                        case 2:
                            TRANSACTION_TYPE = "1";
                            break;
                    }

                    try {
                        callAPI();
                    } catch (Exception e) {
                        Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                        Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }
                    dialog.dismiss();
                }
            });
            builderSingle.show();
        }


    }


    @Layout(R.layout.holder_recent_transaction_layout)
    class HolderRecentTransaction {

        @View(R.id.payment_image)
        ImageView paymentImage;
        @View(R.id.payment_heading)
        TextView paymentHeading;
        @View(R.id.payment_date)
        TextView paymentDate;
        @View(R.id.payment_valur_txt)
        TextView paymentValurTxt;
        @Position
        private int mPosition;
        private ModelWalletBalance.DataBean.RecentTransactoinBean mData;
        private PlaceHolderView placeHolderView;
        private String NEXT_URL;

        public HolderRecentTransaction(ModelWalletBalance.DataBean.RecentTransactoinBean recentTransactoinBean, PlaceHolderView placeHolderView, String nextUrl) {
            this.mData = recentTransactoinBean;
            this.placeHolderView = placeHolderView;
            this.NEXT_URL = nextUrl;
        }


        @Resolve
        private void setdata() {
            paymentHeading.setText("" + mData.getNarration());
            paymentDate.setText("" + mData.getDate());
            paymentValurTxt.setText("" + mData.getAmount());
            paymentValurTxt.setTextColor(Color.parseColor("#" + mData.getValue_color()));
            Glide.with(WalletActivity.this).load( "" + mData.getIcon()).into(paymentImage);

            if (mPosition == LOADING_FACTOR) {
                if (!NEXT_URL.equals("")) {
                    try {
                        HashMap<String, String> data = new HashMap<>();
                        data.put("filter", "" + TRANSACTION_TYPE);
                        apiManager._post(API_S.Tags.LOAD_MORE_TRANSACTION, "" + NEXT_URL, data, sessionManager);
                        LOADING_FACTOR = LOADING_FACTOR + 9;
                    } catch (Exception e) {
                        Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                        Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }
                }
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (data.getStringExtra("success").equals("success")) {
                try{
                    HashMap<String , String> data1 = new HashMap<>();
                    data1.put("amount",""+modelWalletBalance.getData().getWallet_money());
                    data1.put("payment_method","2");  // 1 for cash 2 for non cash
                    data1.put("receipt_number","Application");
                    data1.put("description","sending as per demo card only");

                    apiManager._post(""+API_S.Tags.ADD_MONEY_IN_WALLET, ""+API_S.Endpoints.ADD_MONEY_IN_WALLET,data1, sessionManager);
                }catch (Exception e){Log.e("" +TAG , "Exception caught while calling API "+e.getMessage());}
            } else if (data.getStringExtra("failure").equals("failure")) {
                Toast.makeText(this, com.apporio.demotaxiappdriver.R.string.payment_failed, Toast.LENGTH_SHORT).show();


            } else if (data.getStringExtra("aborted").equals("aborted")) {

                Toast.makeText(this, com.apporio.demotaxiappdriver.R.string.payment_aborted, Toast.LENGTH_SHORT).show();

            }

        } catch (Exception e) {


        }
    }

}
