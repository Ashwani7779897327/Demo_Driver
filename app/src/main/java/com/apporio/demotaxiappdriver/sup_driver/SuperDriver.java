package com.apporio.demotaxiappdriver.sup_driver;

import android.app.DatePickerDialog;
import android.content.DialogInterface;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelDeviceOnlineIffline;
import com.apporio.demotaxiappdriver.models.ModelSuperDriver;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.apporio.demotaxiappdriver.urls.Apis;
import com.sam.placer.PlaceHolderView;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.wdullaer.materialdatetimepicker.time.Timepoint;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class SuperDriver extends BaseActivity implements com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener,ApiManager.APIFETCHER {

    TextView start_date,End_date,current_date,current_end_date;
    int SELECTED_DATE;
    String LEAVE_ON = "", RETURN_BY = "", LEAVE_ON_TIME = "", RETURN_BY_TIME = "";
    String SEND_LEAVE_ON = "", SEND_RETURN_BY = "", SEND_LEAVE_ON_TIME = "", SEND_RETURN_BY_TIME = "";
    SessionManager sessionManager;
    LinearLayout root;
    PlaceHolderView super_placeholder;
    ModelSuperDriver modelSuperDriver;
    ApiManager apiManager;
    private HashMap<String, String> data = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_driver);
        getSupportActionBar().hide();

        sessionManager = new SessionManager(this);
        start_date=findViewById(R.id.start_date);
        End_date=findViewById(R.id.end_date);
        current_date=findViewById(R.id.current_date);
        current_end_date=findViewById(R.id.current_end_date);
        root=findViewById(R.id.root);
        super_placeholder=findViewById(R.id.super_placeholder);
        apiManager=new ApiManager(this,this);

        String dt;
        Date cal = (Date) Calendar.getInstance().getTime();
        dt = cal.toLocaleString();
        current_date.setText(dt.toString());
        current_end_date.setText(dt.toString());

        try {
            data.put("start_date",""+current_date.getText().toString());
            data.put("end_date",""+current_end_date.getText().toString());
            apiManager._post(API_S.Tags.SUPER_DRIVER, API_S.Endpoints.SUPER_DRIVER, data, sessionManager);
        } catch (Exception e) {
            e.printStackTrace();
        }

        findViewById(R.id.ll_back_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SuperDriver.this.finish();
            }
        });
        start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SELECTED_DATE = 1;
                Calendar calendar = Calendar.getInstance();
                com.wdullaer.materialdatetimepicker.date.DatePickerDialog dpd = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(SuperDriver.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                dpd.setOkText(""+getResources().getString(R.string.ok));
                dpd.setCancelText(""+getResources().getString(R.string.cancel));
               // dpd.setMinDate(calendar);
                dpd.setAccentColor(SuperDriver.this.getResources().getColor(R.color.colorPrimary));
                dpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                    }
                });
                dpd.show(getFragmentManager(), "Date Picker Dialog");
            }
        });

        End_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    SELECTED_DATE = 2;
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.add(Calendar.DAY_OF_MONTH, 1);
                    com.wdullaer.materialdatetimepicker.date.DatePickerDialog dpd1 = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(SuperDriver.this, calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH));
                   // dpd1.setMinDate(calendar1);
                    dpd1.setAccentColor(SuperDriver.this.getResources().getColor(R.color.colorPrimary));
                    dpd1.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                        }
                    });
                    dpd1.show(getFragmentManager(), "Date Picker Dialog");
                }

        });

    }


    @Override
    public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        int month = monthOfYear + 1;

        final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        if (SELECTED_DATE == 2) {
            SEND_RETURN_BY = year + "/" + month + "/" + dayOfMonth;
            RETURN_BY = dayOfMonth + "  " + MONTHS[month - 1] + "  " + year;
        } else {
            SEND_LEAVE_ON = year + "/" + month + "/" + dayOfMonth;
            LEAVE_ON = dayOfMonth + " " + MONTHS[month - 1] + " " + year;
        }

        current_end_date.setText("" + RETURN_BY );
        current_date.setText("" + LEAVE_ON );

        try {
            data.put("start_date",""+current_date.getText().toString());
            data.put("end_date",""+current_end_date.getText().toString());
            apiManager._post(API_S.Tags.SUPER_DRIVER, API_S.Endpoints.SUPER_DRIVER, data, sessionManager);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        switch (APINAME) {
            case API_S.Tags.SUPER_DRIVER:
                ModelSuperDriver modelSuperDriver = SingletonGson.getInstance().fromJson("" + script, ModelSuperDriver.class);
              for (int i=0;i<modelSuperDriver.getData().size();i++){

                  super_placeholder.addView(new Super_Driver_Profile(this,modelSuperDriver.getData().get(i)));
              }
                break;

        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }
}
