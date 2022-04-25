package com.apporio.demotaxiappdriver;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

import java.io.Serializable;

@Layout(R.layout.holder_service_layout_subscription)
public class HolderServicelayoutSubscription implements Serializable {

@View(R.id.package_service_name)
    TextView package_service_name;
@View(R.id.package_service_image)
ImageView package_service_image;


    Context context;
    String name;
    String image;



  public HolderServicelayoutSubscription(Context context, String name , String image){

        this.context = context;
        this.name = name;
        this.image = image;

    }


    @Resolve
    public void onResolve()
    {

        package_service_name.setText(name);
        Glide.with(context).load( image).into(package_service_image);

    }



}
