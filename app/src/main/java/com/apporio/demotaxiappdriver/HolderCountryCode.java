package com.apporio.demotaxiappdriver;


import android.content.Context;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.manager.ModelCountries;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelAppConfiguration;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Position;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

import java.util.List;

@Layout(R.layout.holder_countrycode)
public class HolderCountryCode {


    @View(R.id.countrycode_txt)
    TextView countrycode_txt;
    Context context;
    //ModelCountries.DataBean.CountriesBean countriesBean;


//    HolderCountryCode(Context context, ModelCountries.DataBean.CountriesBean countriesBean){
//        this.context = context;
//        this.countriesBean = countriesBean;
//
//
//    }





    @Resolve
    public void onResolve(){


     //   countrycode_txt.setText(" " + countriesBean.getPhonecode()+"   "+countriesBean.getName());


    }
}
