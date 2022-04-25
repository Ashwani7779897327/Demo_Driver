package com.apporio.demotaxiappdriver;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AlertDialog;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelDriverDocument;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Position;
import com.sam.placer.annotations.Resolve;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DocumentActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.back)
    RelativeLayout back;
    @Bind(R.id.placeholder)
    PlaceHolderView placeholder;

    private ModelDriverDocument modelDriverDocument = null;
    ApiManager apiManager;
    ProgressDialog progressDialog;
    SessionManager sessionManager;

    String documentScreenApi = "0";
    String dialog_tittle = "", dialog_message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_document);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(this.getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);
        apiManager = new ApiManager(this, this);

        documentScreenApi = getIntent().getStringExtra("documentScreenApi");

        Log.e("****DocumenTParaDocu", "" + documentScreenApi);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (documentScreenApi.equals("0")) {
                    startActivity(new Intent(DocumentActivity.this, SplashActivity.class)
                            .putExtra("value", "1"));
                }
                DocumentActivity.this.finish();

            }
        });

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder dialog = new AlertDialog.Builder(DocumentActivity.this);
                dialog.setTitle(dialog_tittle);
                dialog.setMessage(dialog_message);
                dialog.setCancelable(false);
                dialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        paramDialogInterface.dismiss();
                        if (documentScreenApi.equals("0")) {
                            startActivity(new Intent(DocumentActivity.this, SplashActivity.class)
                                    .putExtra("value", "1"));
                        }
                        DocumentActivity.this.finish();
                    }
                }).show();

//                if (modelDriverDocument != null) {
//                    String status = "1";
//                    for (int i = 0; i < modelDriverDocument.getData().getPersonal().size();i++) {
//                        if (modelDriverDocument.getData().getPersonal().get(i).getDocument_verification_status().equals("0") &&
//                                (modelDriverDocument.getData().getPersonal().get(i).getDocumentNeed() == 1)) {
//                            status = "0";
//                        }
//                    }
//
//                    for (int i = 0; i < modelDriverDocument.getData().getVehicle().size(); i++) {
//                        if (modelDriverDocument.getData().getVehicle().get(i).getDocument_verification_status().equals("0") &&
//                                (modelDriverDocument.getData().getVehicle().get(i).getDocumentNeed() == 1) ) {
//                            status = "0";
//                        }
//                    }
//
//                    if (status.equals("0")) {
//                        final AlertDialog.Builder dialog = new AlertDialog.Builder(DocumentActivity.this);
//                        dialog.setTitle(R.string.document_not_uploaded);
//                        dialog.setTitle(R.string.document_under_review);
//                        dialog.setMessage(R.string.please_upload_required_document_first);
//                        dialog.setCancelable(false);
//                        dialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
//                                paramDialogInterface.dismiss();
//                            }
//                        }).show();
//
//                    } else {
//                        final AlertDialog.Builder dialog = new AlertDialog.Builder(DocumentActivity.this);
//                        dialog.setTitle(R.string.document_under_review);
//                        dialog.setTitle(R.string.document_under_review);
//                        dialog.setMessage(R.string.your_document_is_under_verification_process);
//                        dialog.setCancelable(false);
//                        dialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
//                                finish();
//                               // SampleVehicleActivity.sa.finish();
//                            }
//                        }).show();
//                    }
//                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            if (documentScreenApi.equals("1")) {
                HashMap<String, String> data = new HashMap<>();
                data.put("driver", "" + getIntent().getExtras().getString(IntentKeys.DRIVER_ID));
                data.put("driver_vehicle", "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_VEHICLE_ID));
                apiManager._post(API_S.Tags.DRIVER_DOCUMENT_INTERNAL, API_S.Endpoints.DRIVER_DOCUMENT_INTERNAL, data, sessionManager);
            } else {
                HashMap<String, String> data = new HashMap<>();
                data.put("driver", "" + getIntent().getExtras().getString(IntentKeys.DRIVER_ID));
//                data.put("driver_vehicle", "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_VEHICLE_ID));
                apiManager._post_with_secreteonly(API_S.Tags.DRIVER_DOCUMENT, API_S.Endpoints.DRIVER_DOCUMENT, data);
            }

        } catch (Exception e) {
        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {

        try {
            if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                progressDialog.show();
            } else if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
        }

    }

    @SuppressLint("LongLogTag")
    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            switch (APINAME) {
                case API_S.Tags.DRIVER_DOCUMENT:
                    modelDriverDocument = SingletonGson.getInstance().fromJson("" + script, ModelDriverDocument.class);
                    placeholder.removeAllViews();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (modelDriverDocument.getData().getPersonal().size() > 0) {
                                placeholder.addView(new HolderDocumentHeader(getString(R.string.personal_documents)));

                                for (int i = 0; i < modelDriverDocument.getData().getPersonal().size(); i++) {
                                    placeholder.addView(new HolderDocumentItem("" + modelDriverDocument.getData().getPersonal().get(i).getDocumentname(),
                                            "" + modelDriverDocument.getData().getPersonal().get(i).getId(),
                                            "" + modelDriverDocument.getData().getPersonal().get(i).getDocument_verification_status(),
                                            "1", "" + modelDriverDocument.getData().getPersonal().get(i).getExpire_date(),
                                            "" + modelDriverDocument.getData().getPersonal().get(i).getDocumentNeed(), ""));
                                }
                            }

                            if (modelDriverDocument.getData().getVehicle().size() > 0) {
                                placeholder.addView(new HolderDocumentHeader(getString(R.string.vehicle_documents)));

                                for (int i = 0; i < modelDriverDocument.getData().getVehicle().size(); i++) {
                                    placeholder.addView(new HolderDocumentItem("" + modelDriverDocument.getData().getVehicle().get(i).getDocumentname(),
                                            "" + modelDriverDocument.getData().getVehicle().get(i).getId(),
                                            "" + modelDriverDocument.getData().getVehicle().get(i).getDocument_verification_status()
                                            , "2", "" + modelDriverDocument.getData().getVehicle().get(i).getExpire_date(),
                                            "" + modelDriverDocument.getData().getVehicle().get(i).getDocumentNeed(), "" + modelDriverDocument.getData().getVehicle().get(i).getDriver_vehicle_id()));
                                }
                            }


                            placeholder.addView(new HolderMessage(modelDriverDocument.getData().getDocinfo()));
                        }
                    }, 1000);
                    break;

                case API_S.Tags.DRIVER_DOCUMENT_INTERNAL:
                    modelDriverDocument = SingletonGson.getInstance().fromJson("" + script, ModelDriverDocument.class);
                    placeholder.removeAllViews();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (modelDriverDocument.getData().getPersonal().size() > 0) {
                                placeholder.addView(new HolderDocumentHeader(getString(R.string.personal_documents)));

                                for (int i = 0; i < modelDriverDocument.getData().getPersonal().size(); i++) {
                                    placeholder.addView(new HolderDocumentItem("" + modelDriverDocument.getData().getPersonal().get(i).getDocumentname(),
                                            "" + modelDriverDocument.getData().getPersonal().get(i).getId(),
                                            "" + modelDriverDocument.getData().getPersonal().get(i).getDocument_verification_status(),
                                            "1", "" + modelDriverDocument.getData().getPersonal().get(i).getExpire_date(),
                                            "" + modelDriverDocument.getData().getPersonal().get(i).getDocumentNeed(), ""));
                                }
                            }

                            if (modelDriverDocument.getData().getVehicle().size() > 0) {
                                placeholder.addView(new HolderDocumentHeader(getString(R.string.vehicle_documents)));

                                for (int i = 0; i < modelDriverDocument.getData().getVehicle().size(); i++) {
                                    placeholder.addView(new HolderDocumentItem("" + modelDriverDocument.getData().getVehicle().get(i).getDocumentname(),
                                            "" + modelDriverDocument.getData().getVehicle().get(i).getId(),
                                            "" + modelDriverDocument.getData().getVehicle().get(i).getDocument_verification_status()
                                            , "2", "" + modelDriverDocument.getData().getVehicle().get(i).getExpire_date(),
                                            "" + modelDriverDocument.getData().getVehicle().get(i).getDocumentNeed(), "" + modelDriverDocument.getData().getVehicle().get(i).getDriver_vehicle_id()));
                                }
                            }


                            placeholder.addView(new HolderMessage(modelDriverDocument.getData().getDocinfo()));
                        }
                    }, 1000);
                    break;
            }
        } catch (Exception e) {
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(this, "" + script, Toast.LENGTH_LONG).show();
    }

    @Layout(R.layout.item_document_list)
    private class HolderDocumentItem {

        @com.sam.placer.annotations.View(R.id.document_name_txt)
        private TextView document_name_txt;
        @com.sam.placer.annotations.View(R.id.document_status_txt)
        private TextView document_status_txt;
        @com.sam.placer.annotations.View(R.id.mand_doc)
        private TextView mand_doc;

        @Position
        private int mPosition;
        String vehicleId = "";
        String mDocumentname, mDocumentid, mStatus, expiry_date, mDocumenttype, needStatus;

        public HolderDocumentItem(String documentname, String doucument_id, String status, String documenttype, String expiry_date, String needStatus, String vehicle_id) {
            mDocumentname = documentname;
            mDocumentid = doucument_id;
            mStatus = status;
            mDocumenttype = documenttype;
            this.expiry_date = expiry_date;
            this.needStatus = needStatus;
            this.vehicleId = vehicle_id;
        }

        @Resolve
        private void onResolved() {
            try {

                mand_doc.setVisibility(needStatus.equals("1") ? View.VISIBLE : View.GONE);
                document_name_txt.setText("" + mDocumentname);
                setViewAccordingToStatus(Integer.parseInt("" + mStatus));
            } catch (Exception e) {
            }
        }


        @Click(R.id.root_element)
        private void OnRootElementClick() {
            if (mStatus.equals("0") || mStatus.equals("3")) {
                if (vehicleId.equals("")) {
                    DocumentActivity.this.startActivity(new Intent(DocumentActivity.this, PhotoUploaderActivity.class)
                            .putExtra("" + IntentKeys.EXPIRY_DATE, "" + expiry_date)
                            .putExtra("" + IntentKeys.DRIVER_ID, "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_ID))
                            .putExtra("" + IntentKeys.DOCUMENT_ID, "" + mDocumentid)
                            .putExtra("TYPE", "1")
                            .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_VEHICLE_ID))
                            .putExtra("" + IntentKeys.DOCUMENT_TYPE, "" + mDocumenttype));
                } else {
                    DocumentActivity.this.startActivity(new Intent(DocumentActivity.this, PhotoUploaderActivity.class)
                            .putExtra("" + IntentKeys.EXPIRY_DATE, "" + expiry_date)
                            .putExtra("" + IntentKeys.DRIVER_ID, "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_ID))
                            .putExtra("" + IntentKeys.DOCUMENT_ID, "" + mDocumentid)
                            .putExtra("TYPE", "1")
                            .putExtra("" + IntentKeys.DRIVER_VEHICLE_ID, "" + vehicleId)
                            .putExtra("" + IntentKeys.DOCUMENT_TYPE, "" + mDocumenttype));
                }

            }
        }

        public void setViewAccordingToStatus(int status) {
            switch (status) {
                case 0:  // Document not yet uploaded
                    document_status_txt.setText(R.string.upload_document);
                    break;
                case 2:
                    document_status_txt.setText(R.string.verified);
                    break;
                case 1:
                    document_status_txt.setText(R.string.verification_pending);
                    break;
                case 3:
                    document_status_txt.setText(R.string.rejected);
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


    @Layout(R.layout.message_layout)
    private class HolderMessage {

        @com.sam.placer.annotations.View(R.id.message_text)
        private TextView message_text;
        private ModelDriverDocument.DataBean.DocinfoBean mData;


        public HolderMessage(ModelDriverDocument.DataBean.DocinfoBean data) {
            mData = data;
        }

        @Resolve
        private void onResolved() {
            message_text.setText("" + mData.getMessage());
            dialog_tittle = mData.getDialog_title();
            dialog_message = mData.getDialog_message();
            message_text.setTextColor(Color.parseColor("#" + mData.getColor()));

        }

    }

    @Override
    public void onBackPressed() {
        if (documentScreenApi.equals("0")) {
            startActivity(new Intent(DocumentActivity.this, SplashActivity.class)
                    .putExtra("value", "1"));
        }
        DocumentActivity.this.finish();
    }
}
