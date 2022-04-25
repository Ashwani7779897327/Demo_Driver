package com.apporio.demotaxiappdriver;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelAddressList;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.maps.model.LatLng;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeAddressListActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.placeholder)
    PlaceHolderView placeholder;
    @Bind(R.id.swiperefreshLayout)
    SwipeRefreshLayout swiperefreshLayout;
    @Bind(R.id.add_new)
    TextView addNew;
    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.hint_txt)
    TextView hint_txt;


    int PLACE_PICKER_REQUEST = 1;
    private final String TAG = "HomeAddressListActivity";
    private Place place = null;
    private SessionManager sessionManager;
    private ApiManager apiManager;
    private DialogInterface mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_address_list);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this,this);

        back.setOnClickListener((View view) -> {
            finish();
        });
        addNew.setOnClickListener((View view) -> {
                    if (!Places.isInitialized()) {
                        Places.initialize(getApplicationContext(),getResources().getString(R.string.google_map_key));
                    }

                    List<Place.Field> fields = Arrays.asList(Place.Field.NAME,Place.Field.LAT_LNG);

                    Intent intent = new Autocomplete.IntentBuilder(
                            AutocompleteActivityMode.FULLSCREEN, fields)
                            .build(this);
                    startActivityForResult(intent, PLACE_PICKER_REQUEST);
                });
//            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
//            try {
//                startActivityForResult(builder.build(HomeAddressListActivity.this), PLACE_PICKER_REQUEST);
//            } catch (GooglePlayServicesRepairableException e) {
//                Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
//                e.printStackTrace();
//            } catch (GooglePlayServicesNotAvailableException e) {
//                Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
//                e.printStackTrace();
//            }
//
//        });

        calAPI();
        swiperefreshLayout.setOnRefreshListener(() -> {
            calAPI();
        });

    }


    private void calAPI() {
        try {
            apiManager._post(API_S.Tags.ADDRESS_LIST, API_S.Endpoints.ADDRESS_LIST, null, sessionManager);
            placeholder.removeAllViews();
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
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
            switch (APINAME){
                case API_S.Tags.ADDRESS_LIST:
                    ModelAddressList modelAddressList = SingletonGson.getInstance().fromJson("" + script, ModelAddressList.class);
                    for (int i = 0; i < modelAddressList.getData().size(); i++) {
                        placeholder.addView(new HolderHomeAddressItem(modelAddressList.getData().get(i)));
                    }
                    break;
                case API_S.Tags.ADD_HOME_ADRESS:
                    mDialog.dismiss();
                    ModelAddressList modelAddressListe = SingletonGson.getInstance().fromJson("" + script, ModelAddressList.class);
                    for (int i = 0; i < modelAddressListe.getData().size(); i++) {
                        placeholder.addView(new HolderHomeAddressItem(modelAddressListe.getData().get(i)));
                    }
                    break;
                case API_S.Tags.DELETE_HOME_ADDRESS:
                    ModelAddressList modelAddressListt = SingletonGson.getInstance().fromJson("" + script, ModelAddressList.class);
                    for (int i = 0; i < modelAddressListt.getData().size(); i++) {
                        placeholder.addView(new HolderHomeAddressItem(modelAddressListt.getData().get(i)));
                    }
                    break;
                case API_S.Tags.SELECT_HOME_ADDRESS:
                    ModelAddressList modelAddressList3 = SingletonGson.getInstance().fromJson("" + script, ModelAddressList.class);

                    if (modelAddressList3.getResult().equals("1")){
                        hint_txt.setVisibility(View.GONE);
                    }else {
                        hint_txt.setVisibility(View.VISIBLE);
                    }
                    for (int i = 0; i < modelAddressList3.getData().size(); i++) {
                        placeholder.addView(new HolderHomeAddressItem(modelAddressList3.getData().get(i)));
                    }

                    HomeAddressListActivity.this.finish();
                    Toast.makeText(this, "Please activate your home address.", Toast.LENGTH_SHORT).show();

                    break;
            }
        } catch (Exception e) {
            Snackbar.make(root, "" + script, Snackbar.LENGTH_SHORT).show();
            Log.d("" + TAG, "Exception caught while parsing " + e.getMessage());
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Snackbar.make(root,""+script,Snackbar.LENGTH_SHORT).show();
    }

    @Layout(R.layout.holder_home_address_item)
    class HolderHomeAddressItem {

        @com.sam.placer.annotations.View(R.id.address_headline)
        TextView addressHeadline;
        @com.sam.placer.annotations.View(R.id.address_value)
        TextView addressValue;
        @com.sam.placer.annotations.View(R.id.check)
        FrameLayout check;

        @com.sam.placer.annotations.View(R.id.check_grey)
        ImageView checkGrey;

        @com.sam.placer.annotations.View(R.id.check_green)
        ImageView checkGreen;


        private ModelAddressList.DataBean mData;

        public HolderHomeAddressItem(ModelAddressList.DataBean dataBean) {
            this.mData = dataBean;
        }

        @Resolve
        private void setData() {
            addressHeadline.setText("" + mData.getAddress_name());
            addressValue.setText("" + mData.getAddress_value());
            if (mData.isCheck_visibility()) {
                checkGrey.setVisibility(View.GONE);
                checkGreen.setVisibility(View.VISIBLE);
            } else {
                checkGrey.setVisibility(View.VISIBLE);
                checkGreen.setVisibility(View.GONE);
            }
        }

        @Click(R.id.root)
        private void setOnClick(){
            try{
                HashMap<String , String > data = new HashMap<>();
                data.put("status","1");
                data.put("address_id",""+mData.getId());
                apiManager._post(API_S.Tags.SELECT_HOME_ADDRESS, API_S.Endpoints.SELECT_HOME_ADDRESS,data, sessionManager);
                placeholder.removeAllViews();
            }catch (Exception e){
                Snackbar.make(root,""+e.getMessage(),Snackbar.LENGTH_SHORT).show();
                Log.d("" +TAG , "Exception caught while calling API "+e.getMessage());}

        }

        @Click(R.id.delete)
        private void delete (){
            try{
                HashMap<String , String > data = new HashMap<>();
                data.put("address_id",""+mData.getId());
                apiManager._post(API_S.Tags.DELETE_HOME_ADDRESS, API_S.Endpoints.DELETE_HOME_ADDRESS,data, sessionManager);
                placeholder.removeAllViews();
            }catch (Exception e){
                Snackbar.make(root,""+e.getMessage(),Snackbar.LENGTH_SHORT).show();
                Log.d("" +TAG , "Exception caught while calling API "+e.getMessage());}
        }

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                place = Autocomplete.getPlaceFromIntent(data);
                String toastMsg = String.format("Place: %s", place.getName());
                try {
                    if (place != null) {
                        HashMap<String, String> dataa = new HashMap<>();
                        dataa.put("latitude", "" + place.getLatLng().latitude);
                        dataa.put("longitude", "" + place.getLatLng().longitude);
                        shownameInputDialog(place.getLatLng(), "" + place.getName());
                    }
                } catch (Exception e) {
                    Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
                }
            }
        }
    }


    private void shownameInputDialog(LatLng location, String addressgeographicname) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.save_address);
        builder.setMessage("" + addressgeographicname);

        final EditText input = new EditText(this);
        input.setHint(R.string.please_write_address_name);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton(R.string.save, (dialog, which) -> {
            mDialog = dialog;
            try{
                HashMap<String , String > data = new HashMap<>();
                data.put("address_name",""+input.getText().toString());
                data.put("location",""+addressgeographicname);
                data.put("latitude",""+location.latitude);
                data.put("longitude",""+location.longitude);
                apiManager._post(API_S.Tags.ADD_HOME_ADRESS, API_S.Endpoints.ADD_HOME_ADRESS, data, sessionManager);
                placeholder.removeAllViews();
            }catch (Exception e){
                Snackbar.make(root,""+e.getMessage(),Snackbar.LENGTH_SHORT).show();
                Log.d("" +TAG , "Exception caught while calling API "+e.getMessage());
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


}
