package com.apporio.demotaxiappdriver;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.location.SamLocationRequestService;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelRideInfo;
import com.apporio.demotaxiappdriver.samwork.ApiManager;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ride_otp_Activity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.edit1)
    EditText editText1;
    @Bind(R.id.edit2)
    EditText editText2;
    @Bind(R.id.edit3)
    EditText editText3;
    @Bind(R.id.edit4)
    EditText editText4;
    private EditText[] editTexts;
    //    private OTPListener otpListener;
    private EditText view;
    //    String ride_otp;
    @Bind(R.id.start_trip)
    Button start_trip;

    String inputValue, booking_id;

    private ApiManager apiManager;
    private final String TAG = "RideOtpActivity";
    protected ProgressDialog progressDialog;
    private SamLocationRequestService samLocationRequestService;
    String value ="";
    SessionManager sessionManager;

    public Ride_otp_Activity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_otp_);

        ButterKnife.bind(this);
        getSupportActionBar().hide();
        apiManager = new ApiManager(this,this);
        sessionManager = new SessionManager(this);
        samLocationRequestService = new SamLocationRequestService(this);

        setStartTripEnable(false);

        try {
            value = getIntent().getStringExtra("value");
        }catch (Exception e){

        }

        editTexts = new EditText[]{editText1, editText2, editText3, editText4};

        editText1.addTextChangedListener(new PinTextWatcher(0));
        editText2.addTextChangedListener(new PinTextWatcher(1));
        editText3.addTextChangedListener(new PinTextWatcher(2));
        editText4.addTextChangedListener(new PinTextWatcher(3));

        editText1.setOnKeyListener(new PinOnKeyListener(0));
        editText2.setOnKeyListener(new PinOnKeyListener(1));
        editText3.setOnKeyListener(new PinOnKeyListener(2));
        editText4.setOnKeyListener(new PinOnKeyListener(3));

        progressDialog = new ProgressDialog(Ride_otp_Activity.this);
        progressDialog.setMessage("Verifying OTP");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);

        start_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String digit1 = editText1.getText().toString();
                String digit2 = editText2.getText().toString();
                String digit3 = editText3.getText().toString();
                String digit4 = editText4.getText().toString();

                inputValue = digit1 + digit2 + digit3 + digit4;
                if (inputValue.length() == 4) {

                    try {
                        progressDialog.show();
                        checkOtpApi(inputValue, getIntent().getStringExtra("booking_id"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(Ride_otp_Activity.this, "Please enter valid otp", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @OnClick(R.id.backbutton)
    protected void onBackButton() {
        onBackPressed();
    }

    public class PinTextWatcher implements TextWatcher {

        private int currentIndex;
        private boolean isFirst = false, isLast = false;
        private String newTypedString = "";

        PinTextWatcher(int currentIndex) {
            this.currentIndex = currentIndex;

            if (currentIndex == 0)
                this.isFirst = true;
            else if (currentIndex == editTexts.length - 1)
                this.isLast = true;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            newTypedString = s.subSequence(start, start + count).toString().trim();
        }

        @Override
        public void afterTextChanged(Editable s) {

            String text = newTypedString;

            /* Detect paste event and set first char */
            if (text.length() > 1) {
                text = String.valueOf(text.charAt(0)); // TODO: We can fill out other EditTexts
                moveToNext();
            }

            editTexts[currentIndex].removeTextChangedListener(this);
            editTexts[currentIndex].setText(text);
            editTexts[currentIndex].setSelection(text.length());
            editTexts[currentIndex].addTextChangedListener(this);

            if (text.length() == 1)
                moveToNext();
            else if (text.length() == 0)
                moveToPrevious();
        }

        private void moveToNext() {
            if (!isLast) {
                setStartTripEnable(false);
                editTexts[currentIndex + 1].requestFocus();
                if(editTexts[currentIndex + 1].getText().toString().length()>0){
                    moveToNext();
                }

            }



            if (isAllEditTextsFilled() && isLast) { // isLast is optional
                setStartTripEnable(true);
                editTexts[currentIndex].clearFocus();
                hideKeyboard();
            } else {
                setStartTripEnable(false);
            }
        }

        private void moveToPrevious() {
            if (!isFirst)
                editTexts[currentIndex - 1].requestFocus();
        }

        private boolean isAllEditTextsFilled() {
            for (EditText editText : editTexts)
                if (editText.getText().toString().trim().length() == 0)
                    return false;
            return true;
        }

        private void hideKeyboard() {
            if (getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                editText1.setCursorVisible(false);

            }
        }

    }

    public class PinOnKeyListener implements View.OnKeyListener {

        private int currentIndex;

        PinOnKeyListener(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                if (editTexts[currentIndex].getText().toString().isEmpty() && currentIndex != 0)
                    editTexts[currentIndex - 1].requestFocus();
            }
            return false;
        }

    }



    protected void checkOtpApi(String otp, String booking_id) throws Exception {

        if(value.equals("2")){

            HashMap<String, String> data = new HashMap<>();
            data.put("booking_id", "" + booking_id);
            data.put("otp", "" + otp);
            SessionManager sessionManager = new SessionManager(this);

            apiManager._post("" + API_S.Tags.RIDE_START_OTP, "" + API_S.Endpoints.RIDE_START_OTP, data, sessionManager);

        }else {
            HashMap<String, String> data = new HashMap<>();
            data.put("booking_id", "" + booking_id);
            data.put("otp", "" + otp);
            SessionManager sessionManager = new SessionManager(this);

            apiManager._post("" + API_S.Tags.RIDE_START_OTP, "" + API_S.Endpoints.RIDE_START_OTP, data, sessionManager);

        }

    }


    @Override
    public void onAPIRunningState(int a, String APINAME) {


    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {


        try {
            if (APINAME.equalsIgnoreCase(API_S.Tags.RIDE_START_OTP)) {

                ModelOpVerify modelOpVerify = SingletonGson.getInstance().fromJson("" + script, ModelOpVerify.class);

                if(progressDialog != null && progressDialog.isShowing())
                    progressDialog.dismiss();


                if (modelOpVerify.getResult().equalsIgnoreCase("1")) {
                    Intent intent = new Intent();
                    intent.putExtra("value",value);
                    setResult(Activity.RESULT_OK, intent);
                    finish();

                } else {
                    Toast.makeText(this, "" + modelOpVerify.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            Log.e("" + TAG, "" + e.getMessage());
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        if(progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
        Toast.makeText(this, "" + script, Toast.LENGTH_LONG).show();
    }

    protected void setStartTripEnable(boolean status){
        start_trip.setEnabled(status);
        if(status){
            start_trip.setVisibility(View.VISIBLE);
        } else {
            start_trip.setVisibility(View.GONE);
        }

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);

        super.onBackPressed();
    }

    class ModelOpVerify {

        /**
         * result : 1
         * message : OTP Verified Successfully.
         * data : []
         */

        private String result;
        private String message;
        private List<?> data;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<?> getData() {
            return data;
        }

        public void setData(List<?> data) {
            this.data = data;
        }
    }
}

