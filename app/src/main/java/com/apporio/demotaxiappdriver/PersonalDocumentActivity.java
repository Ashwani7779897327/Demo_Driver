package com.apporio.demotaxiappdriver;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelPersonalDocument;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.bumptech.glide.Glide;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Position;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PersonalDocumentActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.placeholder)
    PlaceHolderView placeholder;
    @Bind(R.id.swiperefreshLayout)
    SwipeRefreshLayout swiperefreshLayout;
    @Bind(R.id.root)
    LinearLayout root;

    private SessionManager sessionManager;
    private ApiManager apiManager;
    private final String TAG = "PersonalDocumentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_personal_document);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this, this);
        swiperefreshLayout.setOnRefreshListener(() -> {
            callApi();
        });

        back.setOnClickListener((android.view.View view) -> {
            finish();
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        callApi();
    }

    @SuppressLint("LongLogTag")
    private void callApi() {
        try {
            apiManager._post(API_S.Tags.VIEW_PERSONAL_DOCUMENT, API_S.Endpoints.VIEW_PERSONAL_DOCUMENT, null, sessionManager);
            placeholder.removeAllViews();
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
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
        ModelPersonalDocument modelPersonalDocument = SingletonGson.getInstance().fromJson("" + script, ModelPersonalDocument.class);

        try{
            placeholder.getAdapter().notifyDataSetChanged();
            placeholder.notifyAll();
            placeholder.removeAllViews();
        }catch (Exception e){

        }


        if (modelPersonalDocument.getData().size() > 0) {
            placeholder.addView(new HolderDocumentHeader(getString(R.string.personal_documents)));
            for (int i = 0; i < modelPersonalDocument.getData().size(); i++) {
                placeholder.addView(new HolderpersonalDocumentItem(modelPersonalDocument.getData().get(i), modelPersonalDocument.getData().get(i).getExpire_date()));
            }

        }

        if (modelPersonalDocument.getVehicle_document().size() > 0) {

            placeholder.addView(new HolderDocumentHeader(getString(R.string.vehicle_documents)));

            for (int i = 0; i < modelPersonalDocument.getVehicle_document().size(); i++) {

                placeholder.addView(new HolderVehicleDocumentItem(modelPersonalDocument.getVehicle_document().get(i)));

            }
        }
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//
//
//            uploaded_ll}
//        },1000);
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
    }


    @Layout(R.layout.holder_personal_document_item)
    class HolderpersonalDocumentItem {

        @View(R.id.document_image)
        ImageView documentImage;
        @View(R.id.document_name)
        TextView documentName;
        @View(R.id.uploaded_on_date)
        TextView uploadedOnDate;
        @View(R.id.mand_layout)
        TextView mad_doc_tv;
        @View(R.id.expiry_date)
        TextView expiryDate;
        @View(R.id.document_status_txt)
        TextView documentStatusTxt;
        @View(R.id.root)
        LinearLayout root;
        @View(R.id.expiry_ll)
        LinearLayout expiry_ll;
        @View(R.id.uploaded_ll)
        LinearLayout uploaded_ll;

        private ModelPersonalDocument.DataBean mDataBean;
        String expiry_date;

        public HolderpersonalDocumentItem(ModelPersonalDocument.DataBean dataBean, String expiry_date) {
            this.mDataBean = dataBean;
            this.expiry_date = expiry_date;

        }

        @Resolve
        private void setdata() {

            if (null == mDataBean.getExpire_date() || mDataBean.getExpire_date().isEmpty()) {
                expiry_ll.setVisibility(android.view.View.GONE);
            } else
                expiry_ll.setVisibility(android.view.View.VISIBLE);

            mad_doc_tv.setVisibility(mDataBean.getDocumentNeed() == 1 ? android.view.View.VISIBLE : android.view.View.GONE);

            Glide.with(PersonalDocumentActivity.this).load("" + mDataBean.getImage()).into(documentImage);
            documentName.setText("" + mDataBean.getDocumentname());
            expiryDate.setText("" + mDataBean.getExpire_date());

            uploadedOnDate.setText("" + mDataBean.getUploaded_at());
            documentStatusTxt.setText("" + mDataBean.getStatus());
            documentStatusTxt.setTextColor(Color.parseColor("#" + mDataBean.getStatus_color()));

            if (null == mDataBean.getUpdated_at() || mDataBean.getExpire_date() == null || mDataBean.getExpire_date().isEmpty()) {
                uploaded_ll.setVisibility(android.view.View.GONE);
            } else {
                uploaded_ll.setVisibility(android.view.View.VISIBLE);
            }
        }

        @Click(R.id.root)
        private void OnClick() {

            String type = "";
            if (mDataBean.getTemp_doc_upload()) {
                type = "2";
            } else {
                type = "1";
            }
            if (mDataBean.getTemp_doc_upload()) {
                PersonalDocumentActivity.this.startActivity(new Intent(PersonalDocumentActivity.this, PhotoUploaderActivity.class)
                        .putExtra("" + IntentKeys.EXPIRY_DATE, "1")
                        .putExtra("" + IntentKeys.DRIVER_ID, "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID))
                        .putExtra("" + IntentKeys.DOCUMENT_ID, "" + mDataBean.getId())
                        .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "")
                        .putExtra("TYPE", "" + type)
                        .putExtra("" + IntentKeys.DOCUMENT_TYPE, "1"));
            } else {
                if (mDataBean.getDocument_verification_status() == 2) {
                    Toast.makeText(PersonalDocumentActivity.this, "" + getResources().getString(R.string.alreadyverified), Toast.LENGTH_LONG).show();
                    return;
                } else if (mDataBean.getDocument_verification_status() == 1) {

                } else {
                    PersonalDocumentActivity.this.startActivity(new Intent(PersonalDocumentActivity.this, PhotoUploaderActivity.class)
                            .putExtra("" + IntentKeys.EXPIRY_DATE, "1")
                            .putExtra("" + IntentKeys.DRIVER_ID, "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID))
                            .putExtra("" + IntentKeys.DOCUMENT_ID, "" + mDataBean.getId())
                            .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "")
                            .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "")
                            .putExtra("TYPE", "" + type)
                            .putExtra("" + IntentKeys.DOCUMENT_TYPE, "1"));
                }
            }

        }
    }


    @Layout(R.layout.holder_vehicle_documents_item)
    class HolderVehicleDocumentItem {
        @View(R.id.document_image)
        ImageView documentImage;
        @View(R.id.document_name)
        TextView documentName;
        @View(R.id.uploaded_on_date)
        TextView vehicleNumber;
        @View(R.id.root)
        LinearLayout root;
        @View(R.id.placeHolder)
        PlaceHolderView placeHolderNew;

        private ModelPersonalDocument.VehicleDocumentBean vehicleDocumentBean;

        public HolderVehicleDocumentItem(ModelPersonalDocument.VehicleDocumentBean vehicleDocumentBean) {
            this.vehicleDocumentBean = vehicleDocumentBean;
        }

        @Position
        int position;


        @Resolve
        private void setdata() {


            try{
                placeHolderNew.removeAllViews();
                placeHolderNew.getAdapter().notifyDataSetChanged();
                placeHolderNew.notifyAll();
            }catch (Exception e){

            }

            for (int i = 0; i < vehicleDocumentBean.getVehicle_documents().size(); i++) {
                placeHolderNew.addView(new HolderVehicleDocumentItemNew(vehicleDocumentBean.getVehicle_documents().get(i), vehicleDocumentBean.getId()));
            }

            Glide.with(PersonalDocumentActivity.this).load("" + vehicleDocumentBean.getVehicle_image()).into(documentImage);
            documentName.setText("" + vehicleDocumentBean.getVehicle_type() + "|" + vehicleDocumentBean.getVehicle_model());
            vehicleNumber.setText("" + vehicleDocumentBean.getVehicle_number());

        }
    }


    @Layout(R.layout.holder_vehicle_documents_item)
    class HolderVehicleDocumentItemNew {
        @View(R.id.document_image)
        ImageView documentImage;
        @View(R.id.document_name)
        TextView documentName;
        @View(R.id.uploaded_on_date)
        TextView uploadedOnDate;
        @View(R.id.mand_layout)
        TextView mad_doc_tv;
        @View(R.id.expiry_date)
        TextView expiryDate;
        @View(R.id.document_status_txt)
        TextView documentStatusTxt;
        @View(R.id.root)
        LinearLayout root;
        @View(R.id.expiry_ll)
        LinearLayout expiry_ll;
        @View(R.id.placeHolder)
        PlaceHolderView placeHolder;

        private ModelPersonalDocument.VehicleDocumentBean.VehicleDocumentsBean vehicleDocumentBean;
        int vehicle_id;

        public HolderVehicleDocumentItemNew(ModelPersonalDocument.VehicleDocumentBean.VehicleDocumentsBean vehicleDocumentBean, int vehicle_id) {

            this.vehicleDocumentBean = vehicleDocumentBean;
            this.vehicle_id = vehicle_id;

        }

        @Position
        int position;


        @Resolve
        private void setdata() {

            try{
                mad_doc_tv.setVisibility(vehicleDocumentBean.getDocumentNeed() == 1 ? android.view.View.VISIBLE: android.view.View.GONE);

            }catch (Exception e){

            }

            Glide.with(PersonalDocumentActivity.this).load("" + vehicleDocumentBean.getImage()).into(documentImage);
            documentName.setText("" + vehicleDocumentBean.getDocumentname());
            expiryDate.setText("" + vehicleDocumentBean.getExpire_date());
            uploadedOnDate.setText("" + vehicleDocumentBean.getUploaded_at());
            documentStatusTxt.setText("" + vehicleDocumentBean.getStatus());
            documentStatusTxt.setTextColor(Color.parseColor("#" + vehicleDocumentBean.getStatus_color()));

            if (null == vehicleDocumentBean.getExpire_date() || vehicleDocumentBean.getExpire_date() == null || vehicleDocumentBean.getExpire_date().isEmpty()) {
                expiry_ll.setVisibility(android.view.View.GONE);
            } else
                expiry_ll.setVisibility(android.view.View.VISIBLE);

        }

        @Click(R.id.root)
        private void OnClick() {
            String type = "";
            if (vehicleDocumentBean.getTemp_doc_upload()) {
                type = "2";
            } else {
                type = "1";
            }
            if (vehicleDocumentBean.getTemp_doc_upload()) {
                PersonalDocumentActivity.this.startActivity(new Intent(PersonalDocumentActivity.this, PhotoUploaderActivity.class)
                        .putExtra("" + IntentKeys.EXPIRY_DATE, "1")
                        .putExtra("" + IntentKeys.DRIVER_ID, "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID))
                        .putExtra("" + IntentKeys.DOCUMENT_ID, "" + vehicleDocumentBean.getId())
                        .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + vehicle_id)
                        .putExtra("TYPE", "" + type)
                        .putExtra("" + IntentKeys.DOCUMENT_TYPE, "2"));
            } else {
                if (vehicleDocumentBean.getDocument_verification_status() == 2) {
                    Toast.makeText(PersonalDocumentActivity.this, "" + getResources().getString(R.string.alreadyverified), Toast.LENGTH_LONG).show();
                    return;
                } else if (vehicleDocumentBean.getDocument_verification_status() == 1) {

                } else {
                    PersonalDocumentActivity.this.startActivity(new Intent(PersonalDocumentActivity.this, PhotoUploaderActivity.class)
                            .putExtra("" + IntentKeys.EXPIRY_DATE, "1")
                            .putExtra("" + IntentKeys.DRIVER_ID, "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID))
                            .putExtra("" + IntentKeys.DOCUMENT_ID, "" + vehicleDocumentBean.getId())
                            .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + vehicle_id)
                            .putExtra("TYPE", "" + type)
                            .putExtra("" + IntentKeys.DOCUMENT_TYPE, "2"));
                }
            }

        }
    }


    @Layout(R.layout.header_layout)
    private class HolderDocumentHeader {

        @com.sam.placer.annotations.View(R.id.header)
        private TextView header;
        private String mHeader;


        public HolderDocumentHeader(String header) {
            mHeader = header;
        }


        @Resolve
        private void onResolved() {
            header.setText("" + mHeader);
        }

    }

}
