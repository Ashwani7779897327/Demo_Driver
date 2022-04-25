package com.apporio.demotaxiappdriver.baseClass;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.apporio.demotaxiappdriver.manager.SessionManager;
//import com.ice.restring.Restring;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        Locale myLocale = new Locale("" + new SessionManager(newBase).getLanguage());
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        newBase.getResources().updateConfiguration(config, newBase.getResources().getDisplayMetrics());
        super.attachBaseContext(newBase);
    }

}
