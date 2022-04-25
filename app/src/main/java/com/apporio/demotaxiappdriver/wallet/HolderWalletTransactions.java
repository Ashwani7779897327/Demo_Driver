package com.apporio.demotaxiappdriver.wallet;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelWalletTransactionsResponse;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;
import com.apporio.demotaxiappdriver.manager.SessionManager;

import butterknife.Bind;

@Layout(R.layout.layout_holder_wallet_transaction)
public class HolderWalletTransactions {
    @View(R.id.iv_transaction)
    ImageView ivTransaction;
    @View(R.id.tv_title)
    TextView tvTitle;
    @View(R.id.tv_id)
    TextView tvId;
    @View(R.id.tv_amount)
    TextView tvAmount;
    @View(R.id.ll_wallet_transaction)
    RelativeLayout llWalletTransaction;
    SessionManager sessionManager;

    //  TemporaryWalletModel model;
    Context context;
    ModelWalletTransactionsResponse.TransactionsBean model;
    @View(R.id.tv_date_time)
    TextView tvDateTime;
    @View(R.id.tv_payment_method)
    TextView tvPaymentMethod;

    public HolderWalletTransactions(ModelWalletTransactionsResponse.TransactionsBean model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Resolve
    public void onResolved() {
        sessionManager = new SessionManager(context);
        if (model.getTransaction_type().equalsIgnoreCase("Credit")) {
            tvTitle.setText(model.getNarration());
            tvAmount.setText("+ " + sessionManager.getCurrencyCode() + model.getTotal_amount());
            tvAmount.setTextColor(context.getResources().getColor(R.color.green_text));
            ivTransaction.setImageDrawable(context.getResources().getDrawable(R.drawable.plus));
            if (!model.getAdded_by().equalsIgnoreCase("")) {
                tvId.setText("Credit by - " + model.getAdded_by());
                tvId.setVisibility(android.view.View.VISIBLE);
            } else {
                tvId.setVisibility(android.view.View.GONE);
            }
            tvDateTime.setText(model.getDate_time());
            tvPaymentMethod.setText("Payment Method - "+model.getPayment_method());

        } else {
            tvTitle.setText(model.getNarration());
            tvAmount.setText("- " + sessionManager.getCurrencyCode() + model.getTotal_amount());
            tvAmount.setTextColor(context.getResources().getColor(R.color.icons_8_muted_orange));
            ivTransaction.setImageDrawable(context.getResources().getDrawable(R.drawable.minus));
            if (!model.getAdded_by().equalsIgnoreCase("")) {
                tvId.setText("Rider Name - " + model.getAdded_by());
                tvId.setVisibility(android.view.View.VISIBLE);
            } else {
                tvId.setVisibility(android.view.View.GONE);
            }
            tvDateTime.setText(model.getDate_time());
            tvPaymentMethod.setText("Payment Method - "+model.getPayment_method());

        }
    }
}
