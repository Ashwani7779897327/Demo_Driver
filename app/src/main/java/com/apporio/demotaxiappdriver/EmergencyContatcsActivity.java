package com.apporio.demotaxiappdriver;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelDeleteEmergencyContact;
import com.apporio.demotaxiappdriver.models.ModelEmergencyContactList;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EmergencyContatcsActivity extends BaseActivity implements ApiManager.APIFETCHER{

   @Bind(R.id.placeholder_emergency_contacts)
    PlaceHolderView placeHolder;
   @Bind(R.id.add_new_contact)
    Button add_new_contact;
   @Bind(R.id.back)
    ImageView back;
   ApiManager apiManager;
   SessionManager sessionManager;
   ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_emergency_contatcs);
        ButterKnife.bind(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));
        apiManager = new ApiManager(this,this);
        sessionManager = new SessionManager(this);


        try {
            progressDialog.show();
            apiManager._post(API_S.Tags.EMERGENCY_CONTACT_LIST , API_S.Endpoints.EMERGENCY_CONTACT_LIST ,null,sessionManager);
        } catch (Exception e) {
            e.printStackTrace();
        }

        add_new_contact.setVisibility(sessionManager.getAppConfig().getData().getGeneral_config().isEmergency_contact()?View.VISIBLE:View.GONE);

        add_new_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(EmergencyContatcsActivity.this,AddEmergencyContactFieldActivity.class),100);

            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK && requestCode ==100) {


            if (data.getStringExtra("success").equals("success")) {

                try {
                    progressDialog.show();
                    apiManager._post(API_S.Tags.EMERGENCY_CONTACT_LIST , API_S.Endpoints.EMERGENCY_CONTACT_LIST ,null,sessionManager);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

        switch(APINAME)
        {
            case API_S.Tags.EMERGENCY_CONTACT_LIST :

                ModelEmergencyContactList modelEmergencyContactList = SingletonGson.getInstance().fromJson(""+script, ModelEmergencyContactList.class);

                progressDialog.dismiss();

                if(modelEmergencyContactList.getResult().equals("1")){
                    placeHolder.removeAllViews();
                     for (int i = 0; i<modelEmergencyContactList.getData().size();i++)
                    {

                        placeHolder.addView(new ContactView(modelEmergencyContactList.getData().get(i).getNumber(),
                                apiManager,sessionManager,
                                modelEmergencyContactList.getData().get(i).getId(),this,
                                modelEmergencyContactList.getData().get(i).getName(),modelEmergencyContactList.getData().get(i).getUser_id(),progressDialog));
                        }
                        placeHolder.getViewAdapter().notifyDataSetChanged();
                }else {

                    Toast.makeText(this, ""+modelEmergencyContactList.getMessage(), Toast.LENGTH_SHORT).show();
                }

                break;



            case API_S.Tags.DELETE_EMERGENCY_CONTACT :

                ModelDeleteEmergencyContact modelDeleteEmergencyContact = SingletonGson.getInstance().fromJson(""+script , ModelDeleteEmergencyContact.class);

                progressDialog.dismiss();

                if(modelDeleteEmergencyContact.getResult().equals("1"))
                {
                    Toast.makeText(this, ""+modelDeleteEmergencyContact.getMessage(), Toast.LENGTH_SHORT).show();

                    placeHolder.refresh();
                    placeHolder.getAdapter().notifyDataSetChanged();
                    try {
                        apiManager._post(API_S.Tags.EMERGENCY_CONTACT_LIST , API_S.Endpoints.EMERGENCY_CONTACT_LIST ,null,sessionManager);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        try {
            progressDialog.dismiss();
            Toast.makeText(EmergencyContatcsActivity.this, ""+script, Toast.LENGTH_SHORT).show();

        }catch (Exception e){

        }
    }

}




@Layout(R.layout.emergency_contact_view)
class ContactView {
    String phone;
    ApiManager apiManager;
    SessionManager sessionManager;
    int id;
    Context context;
    String contact_name;
    ModelEmergencyContactList modelEmergencyContactList;
    Object user_id;
    ProgressDialog progressDialog;





   public ContactView(String phone, ApiManager apiManager, SessionManager sessionManager,int id,
                      Context context,String name,Object user_id, ProgressDialog progressDialog)
    {
        this.phone= phone;
        this.apiManager = apiManager;
        this.sessionManager = sessionManager;
        this.id = id;
        this.context = context;
        this.contact_name = name;
        this.user_id = user_id;
        this.progressDialog =progressDialog;



    }

    @com.sam.placer.annotations.View(R.id.phone_contact)
    TextView phone_contact;
    @com.sam.placer.annotations.View(R.id.delete_contact)
    TextView delete_contact;
    @com.sam.placer.annotations.View(R.id.contact_name)
    TextView contact_name_txt;


    @Click(R.id.delete_contact)
    public void delete(){


        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(com.apporio.demotaxiappdriver.R.string.do_you_really_want_to_delete_this_contact);

        builder.setPositiveButton(R.string.DIALOG_LOGOUT__yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                HashMap<String, String> data = new HashMap();
                data.put("id",String.valueOf(id));

                try {
                    progressDialog.show();
                    apiManager._post(API_S.Tags.DELETE_EMERGENCY_CONTACT , API_S.Endpoints.DELETE_EMERGENCY_CONTACT,data,sessionManager);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        builder.setNegativeButton(R.string.DIALOG_LOGOUT__no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });


        builder.show();

    }


        @Resolve
    public void onResolve()
    {

        phone_contact.setText(""+phone);
        contact_name_txt.setText(""+contact_name);

        if(user_id == null || user_id.equals(""))
        {
            delete_contact.setVisibility(View.GONE);

        }else {

            delete_contact.setVisibility(View.VISIBLE);

        }
    }



}
