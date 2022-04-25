package com.apporio.demotaxiappdriver.currentwork.holders;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.apporio.demotaxiappdriver.R;
import com.bumptech.glide.Glide;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

@Layout(R.layout.holder_map_image)
public class HolderMapImage {


    @com.sam.placer.annotations.View(R.id.map_mage)
    ImageView map_mage;

    private Context context;
    private String mapImage;
    private Activity activity ;
    private String TAG = "HolderMapImage";
    int imagewidth;
    int imageheight;

    public HolderMapImage(Context context, Activity activity, String map_image) {
        this.context = context;
        this.activity = activity;
        this.mapImage = map_image;
    }

    @Resolve
    private void setData(){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());

      //  Glide.with(context).load(""+mapImage+"&size="+height+"x"+width).into(map_mage);

        int densityDpi = context.getResources().getDisplayMetrics().densityDpi;
        imagewidth = context.getResources().getDisplayMetrics().widthPixels;


        if(densityDpi <= DisplayMetrics.DENSITY_260)   //mdpi
        {
            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 600;
            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);

        }else if(densityDpi <= DisplayMetrics.DENSITY_300)     //hdpi
        {
            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 580;
            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);

        }else if(densityDpi <= DisplayMetrics.DENSITY_340)
        {
            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 560;
            Log.e("Image",""+mapImage+"&size="+imagewidth+"x"+imageheight);
            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);
        }
        else if(densityDpi <= DisplayMetrics.DENSITY_360)      //xhdpi
        {

            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 530;
            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);

        }else if(densityDpi <= DisplayMetrics.DENSITY_400)     //xxhdpi
        {
            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 500;
            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);

        }else if(densityDpi <= DisplayMetrics.DENSITY_420)     //xxxhdpi
        {
            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 480;
            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);

        }else if (densityDpi <= 460 ){

            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 450;
            //   imagewidth = map_mage.getLayoutParams().width = 550;

            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);

        }
        else if (densityDpi <= 480){

            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 400;
            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);

        }
        else if(densityDpi <= 520)
        {
            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 350;
            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);
        }
        else if(densityDpi <= DisplayMetrics.DENSITY_560){

            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 300;
            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);

        }else if(densityDpi < 700){

            map_mage.requestLayout();
            imageheight =  map_mage.getLayoutParams().height = 250;
            Glide.with(context).load(""+mapImage+"&size="+imagewidth+"x"+imageheight).into(map_mage);

        }else {
             Glide.with(context).load(""+mapImage+"&size="+height+"x"+width).into(map_mage);
        }

    }
}
