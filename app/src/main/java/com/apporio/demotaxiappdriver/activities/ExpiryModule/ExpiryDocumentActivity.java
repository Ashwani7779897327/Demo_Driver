package com.apporio.demotaxiappdriver.activities.ExpiryModule;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.PhotoUploaderActivity;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.holder.Holder_ExpireVehicleDetails;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelExpiryDocuments;
import com.apporio.demotaxiappdriver.others.AppUtils;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.bumptech.glide.Glide;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ExpiryDocumentActivity extends BaseActivity implements ApiManager.APIFETCHER {

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
    private final String TAG = "ExpirylDocumentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expiry_document);
        ButterKnife.bind(this);

        getSupportActionBar().hide();

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
            apiManager._post(API_S.Tags.VIEW_EXPIRY_DOCUMENT, API_S.Endpoints.VIEW_EXPIRY_DOCUMENT, null, sessionManager);
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
        ModelExpiryDocuments modelExpiryDocuments = SingletonGson.getInstance().fromJson("" + script, ModelExpiryDocuments.class);

        if (modelExpiryDocuments.getExpired_personal_documents().size() > 0) {

            placeholder.addView(new HolderDocumentHeader(getString(R.string.personal_documents)));

            for (int i = 0; i < modelExpiryDocuments.getExpired_personal_documents().size(); i++) {
                placeholder.addView(new HolderExpiryDocument(modelExpiryDocuments.getExpired_personal_documents().get(i), modelExpiryDocuments.getExpired_personal_documents().get(i).getDocument_name(),
                        "" + modelExpiryDocuments.getExpired_personal_documents().get(i).getDocument_id(),
                        "" + modelExpiryDocuments.getExpired_personal_documents().get(i).getDocument_verification_status(),
                        "1",
                        modelExpiryDocuments.getExpired_personal_documents().get(i).getDocument_expiry_date(), "1",
                        modelExpiryDocuments.getExpired_personal_documents().get(i).getDocument_file(), ""));
            }

        }

        if (modelExpiryDocuments.getExpired_vehicle_documents().size() > 0) {

            placeholder.addView(new HolderDocumentHeader(getString(R.string.vehicle_documents)));

            for (int i = 0; i < modelExpiryDocuments.getExpired_vehicle_documents().size(); i++) {

                if (modelExpiryDocuments.getExpired_vehicle_documents().get(i).getDriver_vehicle_document().size() > 0) {

                    placeholder.addView(new Holder_ExpireVehicleDetails(modelExpiryDocuments.getExpired_vehicle_documents().get(i).getVehicle_image(),
                            modelExpiryDocuments.getExpired_vehicle_documents().get(i).getShareCode(),
                            modelExpiryDocuments.getExpired_vehicle_documents().get(i).getVehicleMakeName(),
                            modelExpiryDocuments.getExpired_vehicle_documents().get(i).getVehicleModelName(),
                            this));
                }

                for (int j = 0; j < modelExpiryDocuments.getExpired_vehicle_documents().get(i).getDriver_vehicle_document().size(); j++) {

                    ModelExpiryDocuments.ExpiredVehicleDocumentsBean.DriverVehicleDocumentBean expiredPersonalDocumentsBean = modelExpiryDocuments.getExpired_vehicle_documents().get(i).getDriver_vehicle_document().get(j);
                    placeholder.addView(new HolderExpiryVehiclesDocument(expiredPersonalDocumentsBean, expiredPersonalDocumentsBean.getDocument_name(),
                            "" + expiredPersonalDocumentsBean.getDocument_id(),
                            "" + expiredPersonalDocumentsBean.getDocument_verification_status(),
                            "2",
                            expiredPersonalDocumentsBean.getExpire_date(), "1",
                            expiredPersonalDocumentsBean.getDocument(),
                            "" + expiredPersonalDocumentsBean.getDriver_vehicle_id()));
                }
            }

        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();

    }

    @Layout(R.layout.holder_personal_document_item)
    class HolderExpiryDocument {

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
        ModelExpiryDocuments.ExpiredPersonalDocumentsBean expiredPersonalDocumentsBean;
        String mDocumentname, mDocumentid, mStatus, expiry_date, mDocumenttype, needStatus, mDocumentImage, vehicle_id;

        public HolderExpiryDocument(ModelExpiryDocuments.ExpiredPersonalDocumentsBean expiredPersonalDocumentsBean, String documentname, String doucument_id, String status, String documenttype, String expiry_date, String needStatus, String documentImage, String vehicle_id) {
            mDocumentname = documentname;
            mDocumentid = doucument_id;
            mStatus = status;
            mDocumenttype = documenttype;
            this.expiry_date = expiry_date;
            this.needStatus = needStatus;
            mDocumentImage = documentImage;
            this.vehicle_id = vehicle_id;
            this.expiredPersonalDocumentsBean = expiredPersonalDocumentsBean;
        }


        @Resolve
        private void setdata() {

            uploaded_ll.setVisibility(android.view.View.GONE);

            if (null == expiry_date || expiry_date.isEmpty()) {
                expiry_date = "";
                expiry_ll.setVisibility(android.view.View.GONE);
            } else
                expiry_ll.setVisibility(android.view.View.VISIBLE);

            Glide.with(ExpiryDocumentActivity.this).load("" + mDocumentImage).into(documentImage);
            documentName.setText("" + mDocumentname);
            expiryDate.setText("" + expiry_date);
            documentStatusTxt.setText("" + getResources().getString(AppUtils.setViewAccordingToStatus(Integer.parseInt(mStatus))));
        }

        @Click(R.id.root)
        private void OnClick() {

            String type = "";
            if (expiredPersonalDocumentsBean.getTemp_doc_upload()) {
                type = "2";
            } else {
                type = "1";
            }
            ExpiryDocumentActivity.this.startActivity(new Intent(ExpiryDocumentActivity.this, PhotoUploaderActivity.class)
                    .putExtra("" + IntentKeys.EXPIRY_DATE, "1")
                    .putExtra("" + IntentKeys.DRIVER_ID, "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID))
                    .putExtra("" + IntentKeys.DOCUMENT_ID, "" + mDocumentid)
                    .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + vehicle_id)
                    .putExtra("TYPE", ""+type)
                    .putExtra("" + IntentKeys.DOCUMENT_TYPE, "" + mDocumenttype));
        }
    }


    @Layout(R.layout.holder_personal_document_item)
    class HolderExpiryVehiclesDocument {

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

        String mDocumentname, mDocumentid, mStatus, expiry_date, mDocumenttype, needStatus, mDocumentImage, vehicle_id;
        ModelExpiryDocuments.ExpiredVehicleDocumentsBean.DriverVehicleDocumentBean expiredPersonalDocumentsBean;

        public HolderExpiryVehiclesDocument(ModelExpiryDocuments.ExpiredVehicleDocumentsBean.DriverVehicleDocumentBean expiredPersonalDocumentsBean, String documentname, String doucument_id, String status, String documenttype, String expiry_date, String needStatus, String documentImage, String vehicle_id) {
            mDocumentname = documentname;
            mDocumentid = doucument_id;
            mStatus = status;
            mDocumenttype = documenttype;
            this.expiry_date = expiry_date;
            this.needStatus = needStatus;
            mDocumentImage = documentImage;
            this.vehicle_id = vehicle_id;
            this.expiredPersonalDocumentsBean = expiredPersonalDocumentsBean;
        }

        @Resolve
        private void setdata() {

            uploaded_ll.setVisibility(android.view.View.GONE);

            if (null == expiry_date || expiry_date.isEmpty()) {
                expiry_date = "";
                expiry_ll.setVisibility(android.view.View.GONE);
            } else
                expiry_ll.setVisibility(android.view.View.VISIBLE);

            Glide.with(ExpiryDocumentActivity.this).load("" + mDocumentImage).into(documentImage);
            documentName.setText("" + mDocumentname);
            expiryDate.setText("" + expiry_date);
            documentStatusTxt.setText("" + getResources().getString(AppUtils.setViewAccordingToStatus(Integer.parseInt(mStatus))));
        }

        @Click(R.id.root)
        private void OnClick() {

            String type = "";
            if (expiredPersonalDocumentsBean.getTemp_doc_upload()) {
                type = "2";
            } else {
                type = "1";
            }
            ExpiryDocumentActivity.this.startActivity(new Intent(ExpiryDocumentActivity.this, PhotoUploaderActivity.class)
                    .putExtra("" + IntentKeys.EXPIRY_DATE, "1")
                    .putExtra("" + IntentKeys.DRIVER_ID, "" + sessionManager.getUserDetails().get(SessionManager.KEY_DRIVER_ID))
                    .putExtra("" + IntentKeys.DOCUMENT_ID, "" + mDocumentid)
                    .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + vehicle_id)
                    .putExtra("TYPE", ""+type)
                    .putExtra("" + IntentKeys.DOCUMENT_TYPE, "" + mDocumenttype));
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
