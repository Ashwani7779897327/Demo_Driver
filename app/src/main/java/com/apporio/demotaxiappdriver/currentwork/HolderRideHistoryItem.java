package com.apporio.demotaxiappdriver.currentwork;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import androidx.cardview.widget.CardView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SpecificTripDetailsActivity;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelFragmenRides;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.bumptech.glide.Glide;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;

@Layout(R.layout.rides_item_new)
public class HolderRideHistoryItem implements ApiManager.APIFETCHER {

    @View(R.id.highligted_left_text)
    TextView highligtedLeftText;
    @View(R.id.small_left_text)
    TextView smallLeftText;
    @View(R.id.highligted_right_text)
    TextView highligtedRightText;
    @View(R.id.small_right_text)
    TextView smallRightText;
    @View(R.id.tv_pickup_addresss)
    TextView tvPickupAddresss;
    @View(R.id.tv_dropp_addresss)
    TextView tvDroppAddresss;
    @View(R.id.circular_image)
    CircleImageView circularImage;
    @View(R.id.highlighted_text)
    TextView name_tex;
    @View(R.id.small_text)
    TextView description_text;
    @View(R.id.status__txt)
    TextView status__txt;
    @View(R.id.root)
    CardView root;
    @View(R.id.user_description_layout)
    LinearLayout userDescriptionLayout;
    ApiManager apiManager;
    SessionManager sessionManager;
    @Bind(R.id.est_fare)
    TextView est_fare;

    private Boolean IS_LAST = false;
    private OnBottomReachedListener onBottomReachedListener ;


    private String TAG = "HolderRideHistoryItem";
    private Context context;
    private ModelFragmenRides.DataBean mData;

    public HolderRideHistoryItem(Context context, ModelFragmenRides.DataBean dataBean, boolean isLast, OnBottomReachedListener onBottomReachedListener) {
        this.context = context;
        mData = dataBean;
        apiManager = new ApiManager(this,context);
        sessionManager = new SessionManager(context);
        this.IS_LAST = isLast ;
        this.onBottomReachedListener = onBottomReachedListener;
    }

    @Resolve
    private void setData() {
        try {
            setDataAccordingly();
            if(IS_LAST){
                onBottomReachedListener.onBottomReached();
            }
            setColor();
            setStyle();
            setVisibility();
        } catch (Exception e) {
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
        }
    }


    @Click(R.id.root)
    private void setOnClick() {

            try {
                apiManager._post(API_S.Tags.NEW_UPCOMING_OUSTATIONS, API_S.Endpoints.NEW_OUTSTATION_UPCOMING, null, sessionManager);
            } catch (Exception e) {
                e.printStackTrace();
            }

        context.startActivity(new Intent(context, SpecificTripDetailsActivity.class)
                .putExtra("" + IntentKeys.BOOKING_ID, "" + mData.getBooking_id()));
    }


    private void setColor() throws Exception {
        highligtedLeftText.setTextColor(Color.parseColor(mData.getHighlighted_left_text_color()));
        highligtedRightText.setTextColor(Color.parseColor("#" + mData.getHighlighted_right_text_color()));
        smallLeftText.setTextColor(Color.parseColor("#" + mData.getSmall_left_text_color()));
        smallRightText.setTextColor(Color.parseColor("#" + mData.getSmall_right_text_color()));
        status__txt.setTextColor(Color.parseColor("#" + mData.getStatus_text_color()));
    }


    private void setStyle() throws Exception {
        if (mData.getHighlighted_left_text_style().equals("BOLD")) {
            highligtedLeftText.setTypeface(null, Typeface.BOLD);
        } else {
            highligtedLeftText.setTypeface(null, Typeface.NORMAL);
        }

        if (mData.getHighlighted_right_text_style().equals("BOLD")) {
            highligtedRightText.setTypeface(null, Typeface.BOLD);
        } else {
            highligtedRightText.setTypeface(null, Typeface.NORMAL);
        }


        if (mData.getSmall_left_text_style().equals("BOLD")) {
            smallLeftText.setTypeface(null, Typeface.BOLD);
        } else {
            smallLeftText.setTypeface(null, Typeface.NORMAL);
        }


        if (mData.getSmall_right_text_style().equals("BOLD")) {
            smallRightText.setTypeface(null, Typeface.BOLD);
        } else {
            smallRightText.setTypeface(null, Typeface.NORMAL);
        }


        if (mData.getStatus_text_syle().equals("BOLD")) {
            status__txt.setTypeface(null, Typeface.BOLD);
        } else {
            status__txt.setTypeface(null, Typeface.NORMAL);
        }

    }

    private void setVisibility() throws Exception {
        if (mData.isDrop_location_visibility()) {
            tvDroppAddresss.setVisibility(android.view.View.VISIBLE);
        } else {
            tvDroppAddresss.setVisibility(android.view.View.GONE);
        }


        if (mData.isPick_location_visibility()) {
            tvPickupAddresss.setVisibility(android.view.View.VISIBLE);
        } else {
            tvPickupAddresss.setVisibility(android.view.View.GONE);
        }


        if (mData.isUser_description_layout_visibility()) {
            userDescriptionLayout.setVisibility(android.view.View.VISIBLE);
        } else {
            userDescriptionLayout.setVisibility(android.view.View.GONE);
        }


    }

    private void setDataAccordingly() throws Exception {
        highligtedLeftText.setText("" + mData.getHighlighted_left_text());
        smallLeftText.setText("" + mData.getSmall_left_text());
        highligtedRightText.setText("" + mData.getHighlighted_right_text());
        smallRightText.setText("" + mData.getSmall_right_text());
        name_tex.setText("" + mData.getUser_name_text());
        description_text.setText("" + mData.getUser_descriptive_text());
        status__txt.setText("" + mData.getStatus_text());
        tvPickupAddresss.setText("  " + mData.getPick_location());
        tvDroppAddresss.setText("  " + mData.getDrop_location());
        Glide.with(context).load("" + mData.getCircular_image()).into(circularImage);
        try{
            est_fare.setText(""+mData.getEstimate_bill());
        }catch (Exception e){

        }

    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }

    public interface OnBottomReachedListener{
        void onBottomReached();
    }

}
