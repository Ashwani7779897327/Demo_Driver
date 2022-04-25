package com.apporio.demotaxiappdriver.holder;


import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.ModelNewEarnings;
import com.apporio.demotaxiappdriver.R;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import java.util.List;

@Layout(R.layout.holder_receipt_layout)
public class HolderShowNetEarnings {


    @com.sam.placer.annotations.View(R.id.linearlayout)
    LinearLayout highllinearlayoutightedText;

    private Context context;
    private final String TAG ="HolderReceipt";
    LayoutInflater mInflater;
    List<ModelNewEarnings.DataBean.HolderDataBean> estimate_receipt;

    public HolderShowNetEarnings(Context context, List<ModelNewEarnings.DataBean.HolderDataBean> estimate_receipt) {
        this.context = context;
        this.estimate_receipt = estimate_receipt;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Resolve
    private void setData(){
        for(int i = 0 ; i < estimate_receipt.size() ; i ++){
            highllinearlayoutightedText.addView(getView(estimate_receipt.get(i)));
        }
    }



    private View getView(ModelNewEarnings.DataBean.HolderDataBean dataBean){

        View v =  mInflater.inflate(R.layout.item_earnings, null, true);

        TextView highlighted_text = (TextView) v.findViewById(R.id.highlighted_text);
        TextView highlighted_smalltext = (TextView) v.findViewById(R.id.highlighted_small_text);
        TextView value_text = (TextView) v.findViewById(R.id.value_text);

        try{
            setViewData(dataBean, highlighted_text, highlighted_smalltext,value_text);
            setViewVisibility(dataBean, highlighted_text, highlighted_smalltext,value_text);
            setViewStyle(dataBean, highlighted_text, highlighted_smalltext,value_text);
            setViewColor(dataBean, highlighted_text, highlighted_smalltext,value_text);
        }catch (Exception e){

        }
        return v;

    }

    private void setViewData(ModelNewEarnings.DataBean.HolderDataBean dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text) {
        highlighted_text.setText(""+dataBean.getLeft_text());
      //  highlighted_smalltext.setText(""+dataBean.getRight_text());
        value_text.setText(""+dataBean.getRight_text());
    }

    private void setViewStyle(ModelNewEarnings.DataBean.HolderDataBean dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text) {
        if(dataBean.getLeft_text_style().equals("BOLD")){ highlighted_text.setTypeface(null, Typeface.BOLD); }
        else{ highlighted_text.setTypeface(null, Typeface.NORMAL); }


//        if(dataBean.getLeft_text_style().equals("BOLD")){ highlighted_smalltext.setTypeface(null, Typeface.BOLD); }
//        else{ highlighted_smalltext.setTypeface(null, Typeface.NORMAL); }
//


        if(dataBean.getLeft_text_style().equals("BOLD")){ value_text.setTypeface(null,Typeface.BOLD); }
        else{ value_text.setTypeface(null,Typeface.NORMAL); }
    }

    private void setViewVisibility(ModelNewEarnings.DataBean.HolderDataBean dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text){
        if(dataBean.isLeft_text_visibility()){ highlighted_text.setVisibility(View.VISIBLE); }
        else{ highlighted_text.setVisibility(View.GONE); }
//
//        if(dataBean.isSmall_text_visibility()){ highlighted_smalltext.setVisibility(View.VISIBLE); }
//        else{ highlighted_smalltext.setVisibility(View.GONE); }

        if(dataBean.isRight_text_visibility()){ value_text.setVisibility(View.VISIBLE); }
        else{ value_text.setVisibility(View.GONE); }

    }

    private void setViewColor(ModelNewEarnings.DataBean.HolderDataBean dataBean, TextView highlighted_text, TextView highlighted_smalltext, TextView value_text){
        highlighted_text.setTextColor(Color.parseColor("#"+dataBean.getLeft_text_color()));
      //  highlighted_smalltext.setTextColor(Color.parseColor("#"+dataBean.getSmall_text_color()));
        value_text.setTextColor(Color.parseColor("#"+dataBean.getRight_text_color()));
    }

}
