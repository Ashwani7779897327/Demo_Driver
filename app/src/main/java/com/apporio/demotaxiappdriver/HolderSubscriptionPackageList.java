package com.apporio.demotaxiappdriver;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.activities.subscriptionModule.SubscriptionModuleDetails;
import com.apporio.demotaxiappdriver.activities.subscriptionModule.SubscriptionModuleList;
import com.apporio.demotaxiappdriver.models.ModelSubscriptionList;
import com.bumptech.glide.Glide;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

import java.io.Serializable;
import java.util.List;

import butterknife.Bind;

@Layout(R.layout.holder_subscription_package_list)
public class HolderSubscriptionPackageList {

    @View(R.id.image_show)
    ImageView image_show;
    @View(R.id.package_name)
    TextView package_name;
    @View(R.id.maximum_rides)
    TextView maximum_rides;
    @View(R.id.pacakge_price)
    TextView package_price;
    @View(R.id.image_show_package)
    LinearLayout image_show_package;
    @View(R.id.activated_or_not)
    TextView activated_or_not;
    @Bind(R.id.view_details)
    TextView view_details;

    private Context context;
    ModelSubscriptionList modelSubscriptionList;
    ModelSubscriptionList.DataBean dataBean;
    List<ModelSubscriptionList.PaymentMethodBean> payment_method;

    public HolderSubscriptionPackageList(Context context, ModelSubscriptionList modelSubscriptionList, ModelSubscriptionList.DataBean dataBean, List<ModelSubscriptionList.PaymentMethodBean> payment_method) {
        this.context = context;
        this.dataBean = dataBean;
        this.payment_method = payment_method;
        this.modelSubscriptionList = modelSubscriptionList;
    }

    @Resolve
    public void onResolve() {

        try {
            Glide.with(context).load("" + dataBean.getImage()).into(image_show);
            package_name.setText(dataBean.getName());
            maximum_rides.setText(String.valueOf(dataBean.getMax_trip()));
            package_price.setText(String.valueOf(dataBean.getShow_price()));

            if (dataBean.getPackage_type() == 1)
                package_price.setText(context.getResources().getString(R.string.free_subscription));
            else package_price.setText(String.valueOf(dataBean.getShow_price()));

//            if (dataBean.isActive())
//                activated_or_not.setText(context.getResources().getString(R.string.activated_subscription));
//            else activated_or_not.setVisibility(android.view.View.GONE);

        } catch (Exception e) {
            Log.e("Excepton", "" + e);
        }
    }


    @Click(R.id.image_show_package)
    public void onClcik() {

        if (dataBean.getPackage_type() == 1) {

            context.startActivity(new Intent(context, SubscriptionModuleDetails.class)
                    .putExtra("modelSubscription", (Serializable) modelSubscriptionList)
                    .putExtra("FROM", "1")
                    .putExtra("methods", (Serializable) payment_method)
                    .putExtra("details", (Serializable) dataBean)
                    .putExtra("package_type", "free"));

        } else {
            context.startActivity(new Intent(context, SubscriptionModuleDetails.class)
                    .putExtra("modelSubscription", (Serializable) modelSubscriptionList)
                    .putExtra("FROM", "1")
                    .putExtra("methods", (Serializable) payment_method)
                    .putExtra("details", (Serializable) dataBean)
                    .putExtra("package_type", "not_free"));

        }

//        context.startActivity(new Intent(context, SubscriptionModuleDetails.class)
//                .putExtra("modelSubscription", (Serializable) modelSubscriptionList)
//                .putExtra("FROM", "1")
//                .putExtra("methods", (Serializable) payment_method)
//                .putExtra("details", (Serializable) dataBean));


//        if (dataBean.getPackage_type() == 1) {
//            if (context instanceof SubscriptionModuleList) {
//                ((SubscriptionModuleList) context).Data();
//            } else {
//
//
//            }
//        }
    }
}
