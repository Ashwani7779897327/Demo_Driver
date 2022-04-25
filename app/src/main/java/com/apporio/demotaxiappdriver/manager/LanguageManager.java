package com.apporio.demotaxiappdriver.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;
import java.util.Locale;

public class LanguageManager {

    SharedPreferences prefDevice;
    SharedPreferences.Editor editorDevice;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME_DEVICE = "DevicePreferences";

    public static final String LANGUAGE_ID = "language_id";

    private String TAG  = "SessionManager";
    public static final String LANGUAGE = "Languagae";


    public LanguageManager(Context context) {
        this._context = context;
        prefDevice = _context.getSharedPreferences(PREF_NAME_DEVICE, PRIVATE_MODE);
        editorDevice = prefDevice.edit();
    }

    public void createLanguageSession() {
        String language_is = Locale.getDefault().getDisplayLanguage();
//        if(language_is.equals("français")){
//            editorDevice.putString(LANGUAGE_ID, "2");
//        }else {
//            editorDevice.putString(LANGUAGE_ID, "1");
//        }
        editorDevice.putString(LANGUAGE_ID, "1");

        editorDevice.commit();
    }

    public String getLanguage() {
        HashMap<String, String> data = new HashMap<>();
        Log.d("" + TAG, "Getting language = " + prefDevice.getString(LANGUAGE, ""));
        return prefDevice.getString(LANGUAGE, "");
    }


    public void setLanguage(String locale) {
        Log.d("" + TAG, "Setting languge = " + locale);
        editorDevice.putString(LANGUAGE, "" + locale);
        editorDevice.commit();

        Locale myLocale = new Locale("" + locale);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        _context.getResources().updateConfiguration(config, _context.getResources().getDisplayMetrics());

    }

    public HashMap<String, String> getLanguageDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(LANGUAGE_ID, prefDevice.getString(LANGUAGE_ID, ""));
        return user;
    }

}