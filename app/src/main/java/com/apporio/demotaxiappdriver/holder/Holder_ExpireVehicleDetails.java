package com.apporio.demotaxiappdriver.holder;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.activities.ExpiryModule.ExpiryDocumentActivity;
import com.bumptech.glide.Glide;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

@Layout(R.layout.vehicle_expiry_layout)
public class Holder_ExpireVehicleDetails {

    @com.sam.placer.annotations.View(R.id.vehicle_image)
    private ImageView veh_image;

    @com.sam.placer.annotations.View(R.id.vehicle_no_text)
    private TextView vehicle_no_TextView;
    @com.sam.placer.annotations.View(R.id.vehicle_info_text)
    private TextView vehicle_info_TextView;

    String vehicle_image, vehicle_no, VehicleModelName,veh_car_make ;
    Context mContext;

    public Holder_ExpireVehicleDetails(String veh_image, String vehicle_no, String veh_car_make, String VehicleModelName,Context context) {
        this.vehicle_image = veh_image;
        this.vehicle_no = vehicle_no;
        this.veh_car_make = veh_car_make;
        this.VehicleModelName = VehicleModelName;
        mContext = context;
    }


    @Resolve
    private void onResolved() {

        Log.d("image->", BuildConfig.BASE_URL+veh_image);

        vehicle_info_TextView.setText(""+veh_car_make+" | " + VehicleModelName);
        vehicle_no_TextView.setText("Vehicle no - " + vehicle_no);

        Glide.with(mContext).load(""+vehicle_image).into(veh_image);
    }


}
