package com.apporio.demotaxiappdriver;


import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import android.util.Log;

import com.apporio.demotaxiappdriver.models.ModelAppConfiguration;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Position;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

@Layout(R.layout.yourtrip_segment)
public class YourUpcoming_trips {


    @View(R.id.imageview)
    AppCompatImageView imageView;

    Context mContext;

    ModelAppConfiguration.DataBean.SegmentsBean segmentsBean;

    @Position
    int pos;


    public YourUpcoming_trips(Context context, ModelAppConfiguration.DataBean.SegmentsBean segmentsBean){
        this.mContext =context;
        this.segmentsBean =segmentsBean;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Resolve
    public void onResolve() {


        if(pos==0){
            imageView.setBackgroundResource(R.drawable.ic_taxi_delivery);
        }
        if (pos==1){

            imageView.setBackgroundResource(R.drawable.ic_delivery);
        }


    }

    @Click(R.id.sagment_view)
    public void onRootClick() {
        if(segmentsBean.getSlag().equalsIgnoreCase("TAXI")){

            if (mContext instanceof NewRequestActivity) {
                ((NewRequestActivity) mContext).Data(String.valueOf(segmentsBean.getId()));
                Log.d("id999",""+segmentsBean.getId());

            }

        }else if(segmentsBean.getSlag().equalsIgnoreCase("DELIVERY")){

            if (mContext instanceof NewRequestActivity) {
                ((NewRequestActivity) mContext).Data(String.valueOf(segmentsBean.getId()));
                Log.d("id1",""+segmentsBean.getId());

            }
        }
    }
    }



