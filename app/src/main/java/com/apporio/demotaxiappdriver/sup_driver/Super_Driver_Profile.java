package com.apporio.demotaxiappdriver.sup_driver;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.models.ModelSuperDriver;
import com.apporio.demotaxiappdriver.typeface.TextTypeBold;
import com.bumptech.glide.Glide;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

import java.util.List;

@Layout(R.layout.super_driver_profile)
public class Super_Driver_Profile {

    @View(R.id.driver_profile)
    ImageView driver_profile;
    @View(R.id.driver_name)
    TextView driver_name;
    @View(R.id.total_trips)
    TextView total_trips;

    Context context;
    ModelSuperDriver.DataBean dataBean;


    public Super_Driver_Profile(Context context, ModelSuperDriver.DataBean dataBean) {
        this.context = context;
        this.dataBean = dataBean;
    }

    @Resolve
    public void OnResole(){
        driver_name.setText(""+(dataBean.getDriver().getFirst_name()+" "+dataBean.getDriver().getLast_name()));
        total_trips.setText(""+dataBean.getDriver().getTotal_trips());
        Glide.with(context).load( "" + dataBean.getDriver().getProfile_image()).into(driver_profile);

    }
}
