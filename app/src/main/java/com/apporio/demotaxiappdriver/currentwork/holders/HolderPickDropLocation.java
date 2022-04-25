package com.apporio.demotaxiappdriver.currentwork.holders;

import android.view.View;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.models.ModelSpecificTripDetails;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

@Layout(R.layout.holder_pickdrop_layout)
public class HolderPickDropLocation {


    @com.sam.placer.annotations.View(R.id.pick_address_txt)
    TextView pickAddressTxt;
    @com.sam.placer.annotations.View(R.id.drop_address_txt)
    TextView dropAddressTxt;
    private ModelSpecificTripDetails.DataBeanXXXXXX.HolderPickdropLocationBean.DataBeanXX mData;

    public HolderPickDropLocation(ModelSpecificTripDetails.DataBeanXXXXXX.HolderPickdropLocationBean.DataBeanXX data) {
        this.mData = data;
    }

    @Resolve
    private void setData() {
        pickAddressTxt.setText("  "+mData.getPick_text());
        dropAddressTxt.setText("  "+mData.getDrop_text());

        if(mData.isDrop_text_visibility()){dropAddressTxt.setVisibility(View.VISIBLE);}
        else{dropAddressTxt.setVisibility(View.GONE);}

        if(mData.isPick_text_visibility()){pickAddressTxt.setVisibility(View.VISIBLE);}
        else{pickAddressTxt.setVisibility(View.GONE);}
    }
}
