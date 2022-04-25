package com.apporio.demotaxiappdriver.currentwork.holders;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import androidx.appcompat.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.models.ModelReceipt;
import com.bumptech.glide.Glide;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import de.hdodenhof.circleimageview.CircleImageView;

@Layout(R.layout.holder_ride_info_layout)
public class HolderRideFareInfo {
    @com.sam.placer.annotations.View(R.id.circular_image) CircleImageView circularImage;
    @com.sam.placer.annotations.View(R.id.text_service_type) TextView text_service_type;
    @com.sam.placer.annotations.View(R.id.image_name) TextView circularText;
    @com.sam.placer.annotations.View(R.id.price_text) TextView valueText;
    @com.sam.placer.annotations.View(R.id.left_text) TextView leftText;
    @com.sam.placer.annotations.View(R.id.right_text) TextView rightText;
    @com.sam.placer.annotations.View(R.id.pick_location) TextView pickLocation;
    @com.sam.placer.annotations.View(R.id.drop_location_txt) TextView dropLocationTxt;
    @com.sam.placer.annotations.View(R.id.receipt_layout) LinearLayout receiptLayout;
    @com.sam.placer.annotations.View(R.id.receipt_view) LinearLayout receiptView;



    private ModelReceipt.DataBean.HolderRideInfoBean mData ;
    private final String TAG = "HolderRideFareInfo";
    private Context context;
    private LayoutInflater mInflater;
    private Activity activity ;
    public HolderRideFareInfo(Context context, Activity activity, ModelReceipt.DataBean.HolderRideInfoBean holder_ride_info) {
        mData = holder_ride_info;
        this.context = context;
        this.activity = activity ;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @SuppressLint("SetTextI18n")
    @Resolve
    private void setData(){
        try{
            setColor();
            setStyle();
            setVisibility();

            Glide.with(context).load(""+mData.getCircular_image()).into(circularImage);
            text_service_type.setText(""+ mData.getCircular_text_one());
            circularText.setText(""+mData.getCircular_text());
            valueText.setText(""+mData.getValue_text());
            leftText.setText(""+mData.getLeft_text());
            rightText.setText(""+mData.getRight_text());
            pickLocation.setText(""+mData.getPick_locaion());
            dropLocationTxt.setText(""+mData.getDrop_location());
            for(int i = 0 ; i < mData.getStatic_values().size() ; i ++){

                receiptLayout.addView(getView(mData.getStatic_values().get(i)));
            }
        }catch (Exception e){
            Log.e("" + TAG, "Exception caught while calling API " + e.getMessage());}

    }

    @Click(R.id.view_receipt_btn)
    private void setOnReceiptClick(){
        AlertDialog alertDialog = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_receipt, null);
        TextView left_text  = dialogView.findViewById(R.id.left_text);
        TextView right_text  = dialogView.findViewById(R.id.right_text);
        LinearLayout receiptLayout  = dialogView.findViewById(R.id.receipt_layout);
        left_text.setText(""+mData.getLeft_text());
        right_text.setText(""+mData.getRight_text());

        for(int i = 0 ; i < mData.getStatic_values().size() ; i ++){
            receiptLayout.addView(getView(mData.getStatic_values().get(i)));
        }
        dialogBuilder.setView(dialogView);
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }



    private void setColor() throws Exception {
        circularText.setTextColor(Color.parseColor("#"+mData.getCircular_text_color()));
        valueText.setTextColor(Color.parseColor("#"+mData.getValue_text_color()));
        leftText.setTextColor(Color.parseColor("#"+mData.getLeft_text_color()));
        rightText.setTextColor(Color.parseColor("#"+mData.getRight_text_color()));
    }


    private void setStyle()throws Exception {
        if(mData.getCircular_text_style().equals("BOLD")){
            circularText.setTypeface(null, Typeface.BOLD); }
        else{ circularText.setTypeface(null, Typeface.NORMAL); }

        if(mData.getValue_text_style().equals("BOLD")){
            valueText.setTypeface(null, Typeface.BOLD); }
        else{ valueText.setTypeface(null, Typeface.NORMAL); }


        if(mData.getLeft_text_style().equals("BOLD")){leftText.setTypeface(null, Typeface.BOLD); }
        else{ leftText.setTypeface(null, Typeface.NORMAL); }


        if(mData.getRight_text_style().equals("BOLD")){rightText.setTypeface(null, Typeface.BOLD); }
        else{ rightText.setTypeface(null, Typeface.NORMAL); }

    }


    private void setVisibility()throws Exception{

        if(mData.isCircular_image_visibility()){circularImage.setVisibility(View.VISIBLE);}
        else{circularImage.setVisibility(View.GONE);}

        if(mData.isCircular_text_visibility()){ circularText.setVisibility(View.VISIBLE);}
        else{ circularText.setVisibility(View.GONE);}

        if(mData.isValue_text_visibility()){ valueText.setVisibility(View.VISIBLE);}
        else{ valueText.setVisibility(View.GONE);}



        if(mData.isLeft_text_visibility()){leftText.setVisibility(View.VISIBLE);}
        else{leftText.setVisibility(View.GONE);}


        if(mData.isRight_text_visibility()){rightText.setVisibility(View.VISIBLE);}
        else{rightText.setVisibility(View.GONE);}

        if(mData.isPick_location_visibility()){pickLocation.setVisibility(View.VISIBLE);}
        else{pickLocation.setVisibility(View.GONE);}

        if(mData.isDrop_location_visibility()){dropLocationTxt.setVisibility(View.VISIBLE);}
        else{dropLocationTxt.setVisibility(View.GONE);}


    }



    private View getView(ModelReceipt.DataBean.HolderRideInfoBean.StaticValuesBean dataBean){
        View v =  mInflater.inflate(R.layout.item_receipt, null, true);
        TextView highlighted_text = (TextView) v.findViewById(R.id.highlighted_text);
        TextView highlighted_smalltext = (TextView) v.findViewById(R.id.highlighted_small_text);
        TextView value_text = (TextView) v.findViewById(R.id.value_text);

        try{
            setViewData(dataBean, highlighted_text, highlighted_smalltext,value_text);
            setViewVisibility(dataBean, highlighted_text, highlighted_smalltext,value_text);
            setViewStyle(dataBean, highlighted_text, highlighted_smalltext,value_text);
            setViewColor(dataBean, highlighted_text, highlighted_smalltext,value_text);
        }catch (Exception e){
            Log.e("" +TAG, ""+e.getMessage());
        }
        return v;

    }

    private void setViewStyle(ModelReceipt.DataBean.HolderRideInfoBean.StaticValuesBean dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text) {
        if(dataBean.getHighlighted_style().equals("BOLD")){ highlighted_text.setTypeface(null, Typeface.BOLD); }
        else{ highlighted_text.setTypeface(null, Typeface.NORMAL); }


        if(dataBean.getSmall_text_style().equals("BOLD")){ highlighted_smalltext.setTypeface(null, Typeface.BOLD); }
        else{ highlighted_smalltext.setTypeface(null, Typeface.NORMAL); }



        if(dataBean.getValue_text_style().equals("BOLD")){ value_text.setTypeface(null, Typeface.BOLD); }
        else{ value_text.setTypeface(null, Typeface.NORMAL); }
    }

    private void setViewVisibility(ModelReceipt.DataBean.HolderRideInfoBean.StaticValuesBean dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text){
        if(dataBean.isHighlighted_visibility()){ highlighted_text.setVisibility(View.VISIBLE); }
        else{ highlighted_text.setVisibility(View.GONE); }
        if(dataBean.isSmall_text_visibility()){ highlighted_smalltext.setVisibility(View.VISIBLE); }
        else{ highlighted_smalltext.setVisibility(View.GONE); }

        if(dataBean.isValue_textvisibility()){ value_text.setVisibility(View.VISIBLE); }
        else{ value_text.setVisibility(View.GONE); }

    }

    private void setViewColor(ModelReceipt.DataBean.HolderRideInfoBean.StaticValuesBean dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text){
        highlighted_text.setTextColor(Color.parseColor("#"+dataBean.getHighlighted_text_color()));
        highlighted_smalltext.setTextColor(Color.parseColor("#"+dataBean.getSmall_text_color()));
        value_text.setTextColor(Color.parseColor("#"+dataBean.getValue_text_color()));
    }


    private void setViewData(ModelReceipt.DataBean.HolderRideInfoBean.StaticValuesBean dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text) {
        highlighted_text.setText(""+dataBean.getHighlighted_text());
        highlighted_smalltext.setText(""+dataBean.getSmall_text());
        value_text.setText(""+dataBean.getValue_text());
    }

}
