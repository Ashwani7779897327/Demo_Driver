package com.apporio.demotaxiappdriver.currentwork.holders;

import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.models.ModelSpecificTripDetails;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

@Layout(R.layout.holder_booking_description)
public class HolderBookingDescription {

    @com.sam.placer.annotations.View(R.id.highligted_left_text)
    TextView highligtedLeftText;
    @com.sam.placer.annotations.View(R.id.small_left_text)
    TextView smallLeftText;
    @com.sam.placer.annotations.View(R.id.highligted_right_text)
    TextView highligtedRightText;
    @com.sam.placer.annotations.View(R.id.small_right_text)
    TextView smallRightText;
    private ModelSpecificTripDetails.DataBeanXXXXXX.HolderBookingDescriptionBean.DataBeanX mData;
    private String TAG = "TAG";

    public HolderBookingDescription(ModelSpecificTripDetails.DataBeanXXXXXX.HolderBookingDescriptionBean.DataBeanX data) {
        this.mData = data;
    }

    @Resolve
    private void setData(){
        try{
            highligtedLeftText.setText(""+mData.getHighlighted_left_text());
            smallLeftText.setText(""+mData.getSmall_left_text());
            highligtedRightText.setText(""+mData.getHighlighted_right_text());
            smallRightText.setText(""+mData.getSmall_right_text());
            setColor();
            setStyle();
        }catch (Exception e){
            Log.d("" +TAG , "Exception caught while calling API "+e.getMessage());}
    }



    private void setColor() throws Exception {
        highligtedLeftText.setTextColor(Color.parseColor("#"+mData.getHighlighted_left_text_color()));
        highligtedRightText.setTextColor(Color.parseColor("#"+mData.getHighlighted_right_text_color()));
        smallLeftText.setTextColor(Color.parseColor("#"+mData.getSmall_left_text_color()));
        smallRightText.setTextColor(Color.parseColor("#"+mData.getSmall_right_text_color()));

    }


    private void setStyle()throws Exception {
        if(mData.getHighlighted_left_text_style().equals("BOLD")){highligtedLeftText.setTypeface(null, Typeface.BOLD); }
        else{ highligtedLeftText.setTypeface(null, Typeface.NORMAL); }

        if(mData.getHighlighted_right_text_style().equals("BOLD")){highligtedRightText.setTypeface(null, Typeface.BOLD); }
        else{ highligtedRightText.setTypeface(null, Typeface.NORMAL); }


        if(mData.getSmall_left_text_style().equals("BOLD")){smallLeftText.setTypeface(null, Typeface.BOLD); }
        else{ smallLeftText.setTypeface(null, Typeface.NORMAL); }


        if(mData.getSmall_right_text_style().equals("BOLD")){smallRightText.setTypeface(null, Typeface.BOLD); }
        else{ smallRightText.setTypeface(null, Typeface.NORMAL); }

    }
}
