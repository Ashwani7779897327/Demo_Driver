package com.apporio.demotaxiappdriver.holder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.TrackingActivity;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.models.ModelMainScreen;
import com.bumptech.glide.Glide;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

import de.hdodenhof.circleimageview.CircleImageView;

@Layout(R.layout.holder_active_ride_layout)
public class HolderActiveRide {

    @View(R.id.image)
    CircleImageView image;
    @View(R.id.title)
    TextView title;
    @View(R.id.username_phone)
    TextView usernamePhone;
    @View(R.id.ride_Status_text)
    TextView rideStatusText;
    private ModelMainScreen.DataBean.ActiveRidesBean mData;
    private Context context ;

    public HolderActiveRide(Context context, ModelMainScreen.DataBean.ActiveRidesBean activeRidesBean) {
        this.mData = activeRidesBean;
        this.context = context ;
    }

    @Resolve
    private void setData() {
        Glide.with(context).load(""+mData.getUserProfileImage()).into(image);
        title.setText(context.getString(R.string.on_going_ride)+mData.getBooking_id());
        usernamePhone.setText(""+mData.getUserName()+" | "+mData.getUserPhone());
        rideStatusText.setText(""+mData.getRide_status_text());
        rideStatusText.setTextColor(Color.parseColor("#"+mData.getRide_status_color()));
    }





    @Click(R.id.go_to_ride_btn)
    private void setgoToRideButton(){
        context.startActivity(new Intent(context, TrackingActivity.class).putExtra(""+ IntentKeys.BOOKING_ID, ""+mData.getBooking_id()));
    }
}
