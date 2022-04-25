package com.apporio.demotaxiappdriver;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelAccountType;
import com.apporio.demotaxiappdriver.models.ModelUpdateBankDetails;
import com.apporio.demotaxiappdriver.samwork.ApiManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BankDetailsActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.bank_name)
    EditText bankName;
    @Bind(R.id.bank_account_name)
    EditText bankAccountName;
    @Bind(R.id.bank_Account_number)
    EditText bankAccountNumber;
    @Bind(R.id.bank_ifsc_code)
    TextInputLayout hint_iFC;
    @Bind(R.id.ifc_edittext)
    EditText bankIFSCode;
    @Bind(R.id.submit)
    TextView submit;
    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.accounttype_spinner)
    Spinner accounTypeSpinner;
    ModelAccountType modelAccountType;


    private SessionManager sessionManager;
    private ApiManager apiManager;
    private ProgressDialog progressBar;
    private final String TAG = "BankDetailsActivity";

    String ifsc_visibility, ifsc_placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_bank_details);
        ButterKnife.bind(this);
        apiManager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        progressBar = new ProgressDialog(this);
        progressBar.setMessage(this.getResources().getString(R.string.loading));

        try {
            apiManager._post_with_secreteonly(API_S.Tags.ACCOUNT_TYPE, API_S.Endpoints.ACCOUNT_TYPE_API, null);
        } catch (Exception e) {
            Log.d(TAG, "Exception Caught while calling login method " + e.getMessage());
        }


        back.setOnClickListener((View view) -> {
            finish();
        });


        bankName.setText("" + getIntent().getExtras().getString("" + IntentKeys.BANK_NAME));
        bankAccountName.setText("" + getIntent().getExtras().getString("" + IntentKeys.BANK_HOLDER_NAME));
        bankAccountNumber.setText("" + getIntent().getExtras().getString("" + IntentKeys.BANK_ACCOUNT_NUMBER));

        try {
            bankIFSCode.setText("" + getIntent().getStringExtra("" + IntentKeys.IFSC_CODE));

            ifsc_visibility = getIntent().getStringExtra("" + IntentKeys.IFSC_VISIBILITY);
            ifsc_placeholder = getIntent().getStringExtra("" + IntentKeys.IFSC_PLACEHOLDER);

          //  hint_iFC.setHint(ifsc_placeholder);

            hint_iFC.setHint(""+sessionManager.getAppConfig().getData().getGeneral_config().getOnline_transaction_code().getPlaceholder());


        } catch (Exception e) {

        }


        submit.setOnClickListener((View view) -> {
            if (bankAccountName.getText().toString().equals("") || bankName.getText().toString().equals("") || bankAccountNumber.getText().toString().equals("")) {

                Toast.makeText(BankDetailsActivity.this, R.string.please_enter_details, Toast.LENGTH_SHORT).show();

            } else if (bankIFSCode.getText().toString().equals("")) {

                Toast.makeText(this, "" + sessionManager.getAppConfig().getData().getGeneral_config().getOnline_transaction_code().getPlaceholder(), Toast.LENGTH_SHORT).show();
            } else {
                try {
                    int pos = accounTypeSpinner.getSelectedItemPosition();


                    HashMap<String, String> data = new HashMap<>();
                    data.put("bank_name", "" + bankName.getText().toString());
                    data.put("account_holder_name", "" + bankAccountName.getText().toString());
                    data.put("account_number", "" + bankAccountNumber.getText().toString());
                    data.put("online_code", "" + bankIFSCode.getText().toString());
                    data.put("account_type", "" + modelAccountType.getAccount_types().get(pos).getId());
                    apiManager._post(API_S.Tags.SAVE_BANK_DETAILS, API_S.Endpoints.SAVE_BANK_DETAILS, data, sessionManager);

                } catch (Exception e) {
                    Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
                }
            }
        });


    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
            progressBar.show();
        } else if (progressBar.isShowing()) {
            progressBar.dismiss();
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            if (APINAME.equals("" + API_S.Tags.SAVE_BANK_DETAILS)) {
                ModelUpdateBankDetails modelUpdateBankDetails = SingletonGson.getInstance().fromJson("" + script, ModelUpdateBankDetails.class);
                Toast.makeText(this, "" + modelUpdateBankDetails.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            } else if (APINAME.equals(API_S.Tags.ACCOUNT_TYPE)) {
                modelAccountType = SingletonGson.getInstance().fromJson("" + script, ModelAccountType.class);

                if (modelAccountType.getResult().equals("1")) {
                    List<String> list = new ArrayList<>();

                    for (int i = 0; i < modelAccountType.getAccount_types().size(); i++) {
                        list.add(modelAccountType.getAccount_types().get(i).getName());
                    }
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_item, list);

                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    accounTypeSpinner.setAdapter(dataAdapter);


                    accounTypeSpinner.setSelection(0);
                } else {
                    Toast.makeText(this, "" + modelAccountType.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.d("" + TAG, "Exception caught while parsing " + e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
    }
}
