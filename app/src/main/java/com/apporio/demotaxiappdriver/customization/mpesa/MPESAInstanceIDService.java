package com.apporio.demotaxiappdriver.customization.mpesa;

import android.content.SharedPreferences;


import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static android.content.Context.MODE_PRIVATE;

public class MPESAInstanceIDService extends FirebaseInstanceIdService {


    @Override
    public void onTokenRefresh() {
//        // Get updated InstanceID token.
//        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//        SharedPreferences sharedPreferences = getSharedPreferences(MainMpesa.SHARED_PREFERENCES, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("InstanceID", refreshedToken);
//        editor.commit();

    }

}
