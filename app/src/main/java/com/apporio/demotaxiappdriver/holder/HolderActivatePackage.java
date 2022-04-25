package com.apporio.demotaxiappdriver.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.activities.subscriptionModule.SubscriptionModuleDetails;
import com.apporio.demotaxiappdriver.activities.subscriptionModule.SubscriptionModuleList;
import com.apporio.demotaxiappdriver.models.ModelSubscriptionList;
import com.bumptech.glide.Glide;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import java.io.Serializable;

import butterknife.Bind;

@Layout(R.layout.activate_package_layout)
public class HolderActivatePackage {

    private Context context;
    ModelSubscriptionList.ActivePackDetailBean activePackDetailBean;
    ModelSubscriptionList modelSubscriptionList;


    @com.sam.placer.annotations.View(R.id.ivPackageImage)
    ImageView ivPackageImage;
    @com.sam.placer.annotations.View(R.id.tvpackageName)
    TextView tvpackageName;
    @com.sam.placer.annotations.View(R.id.tvMaxRides)
    TextView tvMaxRides;
    @com.sam.placer.annotations.View(R.id.tvRideLeft)
    TextView tvRideLeft;
    @com.sam.placer.annotations.View(R.id.tvValidTill)
    TextView tvValidTill;
    @com.sam.placer.annotations.View(R.id.progerssBar)
    ProgressBar progerssBar;
    @com.sam.placer.annotations.View(R.id.view_details)
    TextView view_details;


    public HolderActivatePackage(Context context, ModelSubscriptionList.ActivePackDetailBean activePackDetailBean, ModelSubscriptionList modelSubscriptionList) {
        this.context = context;
        this.activePackDetailBean = activePackDetailBean;
        this.modelSubscriptionList = modelSubscriptionList;

    }


    @Resolve
    public void onResolve() {

        Glide.with(context).load("" + activePackDetailBean.getImage()).into(ivPackageImage);

//            if (modelSubscriptionList.isExpiry_status()) {
//                view_details.setText(R.string.renew);
//            } else {
//                view_details.setText(R.string.view_details_subscription);
//            }

        tvpackageName.setText(activePackDetailBean.getName());
        tvMaxRides.setText(String.valueOf(activePackDetailBean.getPackage_total_trips()));
        tvRideLeft.setText(String.valueOf(activePackDetailBean.getRides_left()));
        tvValidTill.setText(String.valueOf(activePackDetailBean.getEnd_date_time()));

        try {
            progerssBar.setMax(activePackDetailBean.getPackage_total_trips());
            progerssBar.setProgress(activePackDetailBean.getUsed_trips());
        } catch (Exception e) {
        }

    }

    @Click(R.id.view_details)
    public void onClcik() {
        for (int i = 0; i < modelSubscriptionList.getData().size(); i++) {
            if (modelSubscriptionList.isActivated_pack()) {

                if (activePackDetailBean.getPackage_type() == 1) {
                    context.startActivity(new Intent(context, SubscriptionModuleDetails.class)
                            .putExtra("modelSubscription", (Serializable) modelSubscriptionList)
                            .putExtra("FROM", "0")
                            .putExtra("methods", (Serializable) modelSubscriptionList.getPayment_method())
                            .putExtra("package_type", "free")
                            .putExtra("details", (Serializable) activePackDetailBean));
                } else {
                    if (modelSubscriptionList.isActivated_pack()) {
                        context.startActivity(new Intent(context, SubscriptionModuleDetails.class)
                                .putExtra("modelSubscription", (Serializable) modelSubscriptionList)
                                .putExtra("FROM", "0")
                                .putExtra("package_type", "not_free")
                                .putExtra("methods", (Serializable) modelSubscriptionList.getPayment_method())
                                .putExtra("details", (Serializable) activePackDetailBean));
                    }

                    break;
                }

            }
        }
    }
}
