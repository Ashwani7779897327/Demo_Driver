package com.apporio.demotaxiappdriver;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AlertDialog;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.currentwork.STATUS;
import com.apporio.demotaxiappdriver.currentwork.holders.HolderInput;
import com.apporio.demotaxiappdriver.currentwork.holders.HolderPaymentPending;
import com.apporio.demotaxiappdriver.currentwork.holders.HolderRideFareInfo;
import com.apporio.demotaxiappdriver.holder.HolderCashCollection;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelCashCollection;
import com.apporio.demotaxiappdriver.models.ModelNotificationType;
import com.apporio.demotaxiappdriver.models.ModelRateUser;
import com.apporio.demotaxiappdriver.models.ModelReceipt;
import com.apporio.demotaxiappdriver.models.ModelRideCLose;
import com.apporio.demotaxiappdriver.models.ModelRideNotifications;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FareActivity extends BaseActivity implements ApiManager.APIFETCHER, HolderInput.showButton {

    @Bind(R.id.placeholder)
    PlaceHolderView placeholder;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.bottom_text_btn)
    TextView bottomTextBtn;

    private SessionManager sessionManager;
    private ApiManager apiManager;
    private HolderInput holderInput;
    private HolderCashCollection holderCashCollection;
    private String TAG = "FareActivity";
    private ModelReceipt modelReceipt;
    private ProgressDialog progressDialog;
    AlertDialog alertDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fare);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this, this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("" + this.getResources().getString(R.string.loading));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    callApi();
                } catch (Exception e) {
                    Toast.makeText(FareActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    //  Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                }
            }
        });

        bottomTextBtn.setOnClickListener((View view) -> {
            try {

                if (modelReceipt.getData().getBottom_button().getAction().equals("RATE_USER")) {
                    ShowDialogForRateUser();
                }
                if (modelReceipt.getData().getBottom_button().getAction().equals("INPUT_PRICES")) {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("input_values", "" + holderInput.getInputsFromFields());
                    data.put("booking_id", "" + getIntent().getExtras().getString("" + IntentKeys.BOOKING_ID));
                    apiManager._post(API_S.Tags.RIDE_CLOSE, API_S.Endpoints.RIDE_CLOSE, data, sessionManager);
                }
                if (modelReceipt.getData().getBottom_button().getAction().equals("COMPLETE")) {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("booking_id", "" + getIntent().getExtras().getString("" + IntentKeys.BOOKING_ID));
                    apiManager._post(API_S.Tags.RIDE_CLOSE, API_S.Endpoints.RIDE_CLOSE, data, sessionManager);
                }


            } catch (Exception e) {
                Toast.makeText(FareActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                // Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
            }
        });

    }


    private void callApi() throws Exception {
        try{
            placeholder.removeAllViews();
            placeholder.getAdapter().notifyDataSetChanged();
            placeholder.refresh();
        }catch (Exception e){

        }
        Log.e("CallReceiptApi", "CallReceiptAPi");
        HashMap<String, String> data = new HashMap<>();
        data.put("booking_id", "" + getIntent().getExtras().getString("" + IntentKeys.BOOKING_ID));
        apiManager._post("" + API_S.Tags.RECEIPT, "" + API_S.Endpoints.RECEIPT, data, sessionManager);
    }


    public static void cancelAllNotification(Context ctx) {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) ctx.getSystemService(ns);
        nMgr.cancelAll();
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        try {
            switch (APINAME) {
                case API_S.Tags.RECEIPT:
                    break;
                case API_S.Tags.RIDE_CLOSE:
                    break;
                case API_S.Tags.RATE_USER:
                    if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                        progressDialog.show();
                    } else if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    break;

                case API_S.Tags.CASH_COLLECTION:
                    if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                        progressDialog.show();
                    } else if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    break;
            }


            if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                swipeRefreshLayout.setRefreshing(true);
            } else {
                swipeRefreshLayout.setRefreshing(false);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            switch (APINAME) {

                case API_S.Tags.CASH_COLLECTION:
                    ModelCashCollection modelCashCollection = SingletonGson.getInstance().fromJson("" + script, ModelCashCollection.class);
                    if (modelCashCollection.getResult() == 1) {
                        callApi();
                    }
                    break;

                case API_S.Tags.RECEIPT:
                    modelReceipt = SingletonGson.getInstance().fromJson("" + script, ModelReceipt.class);
                    placeholder.addView(new HolderPaymentPending(this, modelReceipt.getData().getPayment_holder()));

                    placeholder.addView(new HolderRideFareInfo(this, this, modelReceipt.getData().getHolder_ride_info()));
                    holderInput = new HolderInput(this, modelReceipt.getData().getHolder_input_info(), this);

                    placeholder.addView(holderInput);
                    bottomTextBtn.setText("" + modelReceipt.getData().getBottom_button().getText());
                    bottomTextBtn.setBackgroundColor(Color.parseColor("#" + modelReceipt.getData().getBottom_button().getText_back_ground_Color()));
                    if (modelReceipt.getData().getBottom_button().isVisibility()) {
                        bottomTextBtn.setVisibility(View.VISIBLE);
                    } else {
                        bottomTextBtn.setVisibility(View.GONE);
                    }

                    try{
                     //   holderCashCollection = new HolderCashCollection(this, modelReceipt.getData().getHolder_driver_ride_payment());
                        if(modelReceipt.getData().getHolder_driver_ride_payment().getVisiblity()){
                            placeholder.addView(new HolderCashCollection(this, modelReceipt.getData().getHolder_driver_ride_payment()));
                        }
                    }catch (Exception e){

                    }
                    break;
                case API_S.Tags.RIDE_CLOSE:

                    try {
                        ModelRideCLose modelRideClose = SingletonGson.getInstance().fromJson("" + script, ModelRideCLose.class);
                        //try {
                        //  hideKeyboard();
                        //}catch (Exception e){

                        // }
                        // FareActivity.this.finish();

                        if (sessionManager.getBookingType().equals("2")) {

                            //  startActivity(new Intent(FareActivity.this, MainActivity.class));
                            hideKeyboard();
                            FareActivity.this.finish();

                        } else {

                            hideKeyboard();
                            FareActivity.this.finish();
                        }
                    } catch (Exception e) {

                    }


//                    if (modelRideClose.getData().isRefresh_screen()) {
//                        callApi();
//                    } else {
//
//                    }
                    break;
                case API_S.Tags.RATE_USER:
                    ModelRateUser modelRateUser = SingletonGson.getInstance().fromJson("" + script, ModelRateUser.class);
                    HashMap<String, String> data = new HashMap<>();
                    data.put("booking_id", "" + getIntent().getExtras().getString("" + IntentKeys.BOOKING_ID));
                    apiManager._post(API_S.Tags.RIDE_CLOSE, API_S.Endpoints.RIDE_CLOSE, data, sessionManager);
                    break;
            }

        } catch (Exception e) {
            Toast.makeText(FareActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            //  Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(FareActivity.this, "" + script, Toast.LENGTH_SHORT).show();
    }

    private void ShowDialogForRateUser() {


        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_rate_us, null);

        EditText comments = dialogView.findViewById(R.id.comments);
        RatingBar rating_bar = dialogView.findViewById(R.id.rating_bar);
        Button ll_submit_rating = dialogView.findViewById(R.id.ll_submit_rating);


        ll_submit_rating.setOnClickListener((View view) -> {

            try {
                HashMap<String, String> data = new HashMap<>();
                data.put("booking_id", "" + getIntent().getExtras().getString("" + IntentKeys.BOOKING_ID));
                data.put("rating", "" + rating_bar.getRating());
                data.put("comment", "" + comments.getText().toString());
                apiManager._post(API_S.Tags.RATE_USER, API_S.Endpoints.RATE_USER, data, sessionManager);
                try {
                    hideKeyboard();

                } catch (Exception e) {
                }
                alertDialog.hide();
            } catch (Exception e) {
                Toast.makeText(FareActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                // Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
            }
        });

        try {
            dialogBuilder.setView(dialogView);
            alertDialog = dialogBuilder.create();
            alertDialog.show();
        } catch (Exception e) {

        }
    }

    public void hideKeyboard() {
        View view = findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String data) {
        ModelNotificationType modelNotificationType = SingletonGson.getInstance().fromJson("" + data, ModelNotificationType.class);
        if (modelNotificationType.getType() == 1) { // Ride related notification
            try {
                ModelRideNotifications modelRideNotifications = SingletonGson.getInstance().fromJson("" + data, ModelRideNotifications.class);
                if (modelRideNotifications.getData().getBooking_status().equals("" + STATUS.MAKE_PAYMENT)) {
                    callApi();
                }
            } catch (Exception e) {
                Toast.makeText(FareActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                //Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            callApi();
        } catch (Exception e) {
            Toast.makeText(FareActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            //  Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
        }
    }

    @Override
    public void callback() {

        bottomTextBtn.setVisibility(View.VISIBLE);
        bottomTextBtn.setText(getResources().getString(R.string.completed));
    }

    public void onClickYesButton(String dialog_message) {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(FareActivity.this);
        builder1.setMessage(dialog_message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                getResources().getString(R.string.ok),
                (dialog, id) -> {

                    try {
                        HashMap<String, String> data = new HashMap<>();
                        data.put("booking_id", "" + getIntent().getExtras().getString("" + IntentKeys.BOOKING_ID));
                        apiManager._post(API_S.Tags.CASH_COLLECTION, API_S.Endpoints.CASH_COLLECTION, data, sessionManager);
                        try {
                            hideKeyboard();

                        } catch (Exception e) {
                        }
                        alertDialog.hide();
                    } catch (Exception e) {
                        // Toast.makeText(FareActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        // Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                        Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }

                    dialog.cancel();
                });

        builder1.setNegativeButton(
                getResources().getString(R.string.cancel),
                (dialog, id) -> dialog.cancel());

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
}

