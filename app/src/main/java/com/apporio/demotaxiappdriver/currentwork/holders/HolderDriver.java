package com.apporio.demotaxiappdriver.currentwork.holders;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.models.ModelSpecificTripDetails;
import com.bumptech.glide.Glide;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import de.hdodenhof.circleimageview.CircleImageView;

@Layout(R.layout.holder_driver_layout)
public class HolderDriver {
    @com.sam.placer.annotations.View(R.id.circular_image)
    CircleImageView circularImage;
    @com.sam.placer.annotations.View(R.id.highlighted_text)
    TextView highlightedText;
    @com.sam.placer.annotations.View(R.id.small_text)
    TextView smallText;
    @com.sam.placer.annotations.View(R.id.ratingBar)
    RatingBar ratingBar;
    @com.sam.placer.annotations.View(R.id.rating_text)
    TextView ratingText;
    @com.sam.placer.annotations.View(R.id.rating_driver_btn)
    TextView ratingDriverBtn;




    private final String TAG = "HolderDriver";
    private Context context ;
    private ModelSpecificTripDetails.DataBeanXXXXXX.HolderUserBean mData ;
    public  HolderDriver(Context context, ModelSpecificTripDetails.DataBeanXXXXXX.HolderUserBean holder_driver){
        this.context = context;
        this.mData = holder_driver;
    }

    @Resolve
    private void setData (){
        try{
            setVisibility();
            setDataAccordingy();
        }catch (Exception e){
            Log.d(""+TAG , ""+e.getMessage());
        }


        ratingDriverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    private void setVisibility() throws Exception {
        if(mData.getData().isRating_button_visibility()){ratingDriverBtn.setVisibility(View.VISIBLE);}
        else{ratingDriverBtn.setVisibility(View.GONE);}

        if(mData.getData().isRating_visibility(

        )){
            ratingText.setVisibility(View.VISIBLE);
            ratingBar.setVisibility(View.VISIBLE);
        }else{
            ratingText.setVisibility(View.GONE);
            ratingBar.setVisibility(View.GONE);
        }
    }

    private void setDataAccordingy()throws Exception {
        Glide.with(context).load(""+mData.getData().getCircular_image()).into(circularImage);
        highlightedText.setText(""+mData.getData().getHighlighted_text());
        smallText.setText(""+mData.getData().getSmall_text());
        ratingDriverBtn.setText(""+mData.getData().getRating_button_text());
//        ratingDriverBtn.setTextColor(Color.parseColor("#"+mData.getData().getRating_button_text_color()));
        if(mData.getData().getRating_button_text_style().equals("BOLD")){ratingDriverBtn.setTypeface(null, Typeface.BOLD);}
        else{ratingDriverBtn.setTypeface(null, Typeface.NORMAL);}
        ratingBar.setRating(Float.parseFloat(""+mData.getData().getRating()));
        ratingText.setText(""+mData.getData().getRating());
    }



}
