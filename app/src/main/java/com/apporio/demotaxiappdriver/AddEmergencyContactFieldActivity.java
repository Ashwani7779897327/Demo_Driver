package com.apporio.demotaxiappdriver;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import android.text.InputFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelAddEmergencyContact;
import com.apporio.demotaxiappdriver.samwork.ApiManager;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddEmergencyContactFieldActivity extends BaseActivity implements ApiManager.APIFETCHER{

    @Bind(R.id.country_id)
    TextView country_idd;
    @Bind(R.id.edt_enter_phone)
    EditText edt_enter_phone;
    @Bind(R.id.submit_emergency_contact)
    Button submit_emergency_contact;
    @Bind(R.id.back)
    ImageView back;
    SessionManager sessionManager;
    ApiManager apiManager;
    @Bind(R.id.enter_name)
    EditText enter_name;
    ProgressDialog progressDialog;

    int countryid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_emergency_contact_field);
        ButterKnife.bind(this);

        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this,this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));

        country_idd.setText("" + sessionManager.getAppConfig().getData().getCountries().get(0).getPhonecode());


        country_idd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(AddEmergencyContactFieldActivity.this);
                builderSingle.setTitle(R.string.select_country);
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddEmergencyContactFieldActivity.this, android.R.layout.select_dialog_singlechoice);
                for (int i = 0; i < sessionManager.getAppConfig().getData().getCountries().size(); i++) {
                    arrayAdapter.add(sessionManager.getAppConfig().getData().getCountries().get(i).getPhonecode() + " " + sessionManager.getAppConfig().getData().getCountries().get(i).getName());
                }
                builderSingle.setNegativeButton(AddEmergencyContactFieldActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    //    phone_number.setText("");
//                        country_id.setText("" + sessionManager.getAppConfig().getData().getCountries().get(which).getPhonecode());
                        countryid = sessionManager.getAppConfig().getData().getCountries().get(which).getId();
                        sessionManager.setcountryid(countryid);
                       setCountryCodeWithValidation(which);
                       // Selected_Country_position = which;
                        dialog.dismiss();
                    }
                });
                builderSingle.show();
            }
        });


        submit_emergency_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             
                if(enter_name.getText().equals(""))
                {
                    Toast.makeText(AddEmergencyContactFieldActivity.this, ""+getResources().getString(R.string.required_field_missing), Toast.LENGTH_SHORT).show();

                }else if(edt_enter_phone.getText().toString().equals("")){

                    Toast.makeText(AddEmergencyContactFieldActivity.this, ""+getResources().getString(R.string.required_field_missing), Toast.LENGTH_SHORT).show();
                }
                else {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("name",""+enter_name.getText().toString());
                    data.put("number",  country_idd.getText().toString() +""+edt_enter_phone.getText().toString());
                    try {
                        progressDialog.show();
                        apiManager._post(API_S.Tags.ADD_EMERGENCY_CONTACT, API_S.Endpoints.ADD_EMERGENCY_CONTACT,data,sessionManager);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }



            }
        });

          back.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  finish();

              }
          });

    }


    private void setCountryCodeWithValidation(int position) {

        try {
            sessionManager.setCurrencyCode("" + sessionManager.getAppConfig().getData().getCountries().get(position).getIsoCode(), "" + sessionManager.getAppConfig().getData().getCountries().get(position).getIsoCode());
            country_idd.setText("" + sessionManager.getAppConfig().getData().getCountries().get(position).getPhonecode());

            int maxLength = Integer.parseInt("" + sessionManager.getAppConfig().getData().getCountries().get(position).getMaxNumPhone());
            InputFilter[] FilterArray = new InputFilter[1];
            FilterArray[0] = new InputFilter.LengthFilter(maxLength);
           // phone_number.setFilters(FilterArray);
        } catch (Exception e) {
       //     Snackbar.make(root, "No Country Added", Snackbar.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

        switch (APINAME)
        {
            case API_S.Tags.ADD_EMERGENCY_CONTACT :


                ModelAddEmergencyContact modelAddEmergencyContact = SingletonGson.getInstance().fromJson(""+script, ModelAddEmergencyContact.class);


                progressDialog.dismiss();
                if(modelAddEmergencyContact.getResult().equals("1")){

                    Toast.makeText(this, ""+modelAddEmergencyContact.getMessage(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    intent.putExtra("success","success");
                    setResult(RESULT_OK,intent);

                    finish();
                    }

        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }

}
