package com.apporio.demotaxiappdriver.currentwork.holders;

import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.models.ModelSpecificTripDetails;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

@Layout(R.layout.holder_metering_layout)
public class HolderMetering {

   @com.sam.placer.annotations.View(R.id.text_one)
   TextView textOne;
   @com.sam.placer.annotations.View(R.id.text_two)
   TextView textTwo;
   @com.sam.placer.annotations.View(R.id.text_three)
   TextView textThree;
    private ModelSpecificTripDetails.DataBeanXXXXXX.HolderMeteringBean mData;

    public HolderMetering(ModelSpecificTripDetails.DataBeanXXXXXX.HolderMeteringBean holder_metering) {
        this.mData = holder_metering;
    }


    @Resolve
    private void setData() {
        textOne.setText(""+mData.getData().getText_one());
        textTwo.setText(""+mData.getData().getText_two());
        textThree.setText(""+mData.getData().getText_three());
    }
}
