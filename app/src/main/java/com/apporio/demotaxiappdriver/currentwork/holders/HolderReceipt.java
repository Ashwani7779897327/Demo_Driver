package com.apporio.demotaxiappdriver.currentwork.holders;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.models.ModelSpecificTripDetails;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;


@Layout(R.layout.holder_receipt_layout)
public class HolderReceipt {

    @com.sam.placer.annotations.View(R.id.linearlayout)
    LinearLayout highllinearlayoutightedText;

    private Context context;
    private final String TAG ="HolderReceipt";
    LayoutInflater mInflater;
    private ModelSpecificTripDetails.DataBeanXXXXXX.HolderReceiptBean data ;

    public HolderReceipt(Context context, ModelSpecificTripDetails.DataBeanXXXXXX.HolderReceiptBean hoder_receipt){
        this.context = context;
        this.data = hoder_receipt;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Resolve
    private void setData(){
        for(int i = 0 ; i < data.getData().size() ; i ++){
            highllinearlayoutightedText.addView(getView(data.getData().get(i)));
        }
    }



    private View getView(ModelSpecificTripDetails.DataBeanXXXXXX.HolderReceiptBean.DataBeanXXXXX dataBean){
        View v =  mInflater.inflate(R.layout.item_receipt, null, true);
        TextView highlighted_text = (TextView) v.findViewById(R.id.highlighted_text);
        TextView highlighted_smalltext = (TextView) v.findViewById(R.id.highlighted_small_text);
        TextView value_text = (TextView) v.findViewById(R.id.value_text);

        try{
            setViewVisibility(dataBean, highlighted_text, highlighted_smalltext,value_text);
            setViewStyle(dataBean, highlighted_text, highlighted_smalltext,value_text);
            setViewData(dataBean, highlighted_text, highlighted_smalltext,value_text);
            setViewColor(dataBean, highlighted_text, highlighted_smalltext,value_text);
        }catch (Exception e){
            Log.d("" +TAG, ""+e.getMessage());
        }
        return v;

    }

    private void setViewData(ModelSpecificTripDetails.DataBeanXXXXXX.HolderReceiptBean.DataBeanXXXXX dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text) {
        highlighted_text.setText(""+dataBean.getHighlighted_text());
        highlighted_smalltext.setText(""+dataBean.getSmall_text());
        value_text.setText(""+dataBean.getValue_text());
    }

    private void setViewStyle(ModelSpecificTripDetails.DataBeanXXXXXX.HolderReceiptBean.DataBeanXXXXX dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text) {
        if(dataBean.getHighlighted_style().equals("BOLD")){ highlighted_text.setTypeface(null, Typeface.BOLD); }
        else{ highlighted_text.setTypeface(null, Typeface.NORMAL); }


        if(dataBean.getSmall_text_style().equals("BOLD")){ highlighted_smalltext.setTypeface(null, Typeface.BOLD); }
        else{ highlighted_smalltext.setTypeface(null, Typeface.NORMAL); }



        if(dataBean.getValue_text_style().equals("BOLD")){ value_text.setTypeface(null, Typeface.BOLD); }
        else{ value_text.setTypeface(null, Typeface.NORMAL); }
    }

    private void setViewVisibility(ModelSpecificTripDetails.DataBeanXXXXXX.HolderReceiptBean.DataBeanXXXXX dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text){
        if(dataBean.isHighlighted_visibility()){ highlighted_text.setVisibility(View.VISIBLE); }
        else{ highlighted_text.setVisibility(View.GONE); }

        if(dataBean.isSmall_text_visibility()){ highlighted_smalltext.setVisibility(View.VISIBLE); }
        else{ highlighted_smalltext.setVisibility(View.GONE); }

        if(dataBean.isValue_textvisibility()){ value_text.setVisibility(View.VISIBLE); }
        else{ value_text.setVisibility(View.GONE); }

    }

    private void setViewColor(ModelSpecificTripDetails.DataBeanXXXXXX.HolderReceiptBean.DataBeanXXXXX dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text){
       highlighted_text.setTextColor(Color.parseColor("#"+dataBean.getHighlighted_text_color()));
       highlighted_smalltext.setTextColor(Color.parseColor("#"+dataBean.getSmall_text_color()));
       value_text.setTextColor(Color.parseColor("#"+dataBean.getValue_text_color()));
    }

}
