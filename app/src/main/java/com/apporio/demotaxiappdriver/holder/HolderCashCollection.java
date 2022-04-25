package com.apporio.demotaxiappdriver.holder;


import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.FareActivity;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.models.ModelReceipt;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Position;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

@Layout(R.layout.holder_cash_collection)
public class HolderCashCollection {

    @com.sam.placer.annotations.View(R.id.tvFailedMessge)
    TextView tvFailedMessge;
    @com.sam.placer.annotations.View(R.id.failedButton)
    Button failedButton;

    ModelReceipt.DataBean.HolderDriverRidePaymentBean holder_driver_ride_payment;

    @Position
    int mPosition;
    Context context;
    ModelReceipt.DataBean.PaymentHolderBean payment_holder;

    public HolderCashCollection(Context context, ModelReceipt.DataBean.HolderDriverRidePaymentBean holder_driver_ride_payment) {

        this.holder_driver_ride_payment = holder_driver_ride_payment;
        this.context = context;
    }

    @Resolve
    private void setData() {
        tvFailedMessge.setText(holder_driver_ride_payment.getMessage());
        failedButton.setText(holder_driver_ride_payment.getButton_text());


    }

    @Click(R.id.failedButton)
    private void onClickYesButton() {
        if (context instanceof FareActivity) {
            ((FareActivity) context).onClickYesButton(holder_driver_ride_payment.getDialog_text());
        }
    }

}
