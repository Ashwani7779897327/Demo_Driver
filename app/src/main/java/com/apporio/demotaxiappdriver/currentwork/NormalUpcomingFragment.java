package com.apporio.demotaxiappdriver.currentwork;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.cardview.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.SpecificTripDetailsActivity;
import com.apporio.demotaxiappdriver.baseClass.BaseFragment;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelNewRequests;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.apporio.demotaxiappdriver.typeface.TypefaceTextView;
import com.bumptech.glide.Glide;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class NormalUpcomingFragment extends BaseFragment implements ApiManager.APIFETCHER {


    @Bind(R.id.no_record_found)
    TextView no_record_normal;
    @Bind(R.id.placeholder)
    PlaceHolderView placeHolder;
    @Bind(R.id.root)
    FrameLayout root;
    @Bind(R.id.swiperefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    ApiManager apiManager;
    private SessionManager sessionManager;
    private final String TAG = "NormalUpcomingFragment";

    static String selectModule1;


    public NormalUpcomingFragment() {
    }

    public static NormalUpcomingFragment newInstance(String selectModule) {
        NormalUpcomingFragment fragment = new NormalUpcomingFragment();
        selectModule1 = selectModule;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiManager = new ApiManager(this, getContext());
        sessionManager = new SessionManager(getActivity());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.normal_upcoming_fragment, container, false);
        ButterKnife.bind(this, rootView);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callActiveAPI();
            }
        });


        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().finish();
    }

    private void callActiveAPI() {
        try {
            if (selectModule1.equals("1")) {
                apiManager._post(API_S.Tags.NEW_REQUESTS, API_S.Endpoints.NEW_REQUESTS, null, sessionManager);
                placeHolder.removeAllViews();
            }else {
                apiManager._post(API_S.Tags.NEW_REQUESTS,API_S.Endpoints.DELIVERY_UPCOMING,null,sessionManager);
            }
        } catch (Exception e) {
            Snackbar.make(root, "" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        try {
            if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                swipeRefreshLayout.setRefreshing(true);
            } else {
                swipeRefreshLayout.setRefreshing(false);
            }
        } catch (Exception e) {

        }

    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            no_record_normal.setVisibility(View.GONE);
            placeHolder.setVisibility(View.VISIBLE);
            ModelNewRequests modelNewRequests = SingletonGson.getInstance().fromJson("" + script, ModelNewRequests.class);
            for (int i = 0; i < modelNewRequests.getData().size(); i++) {
                placeHolder.addView(new HolderNewRequest(getContext(), modelNewRequests.getData().get(i)));
            }
        } catch (Exception e) {

        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        try {
            placeHolder.setVisibility(View.GONE);
            no_record_normal.setText(script);
            no_record_normal.setVisibility(View.VISIBLE);
        } catch (Exception e) {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        callActiveAPI();
    }


    @Layout(R.layout.holder_new_request_layout)
    class HolderNewRequest {

        @com.sam.placer.annotations.View(R.id.highligted_left_text)
        TextView highligtedLeftText;
        @com.sam.placer.annotations.View(R.id.small_left_text)
        TextView smallLeftText;
        @com.sam.placer.annotations.View(R.id.highligted_right_text)
        TextView highligtedRightText;
        @com.sam.placer.annotations.View(R.id.small_right_text)
        TextView smallRightText;
        @com.sam.placer.annotations.View(R.id.tv_pickup_addresss)
        TypefaceTextView tvPickupAddresss;
        @com.sam.placer.annotations.View(R.id.tv_dropp_addresss)
        TypefaceTextView tvDroppAddresss;
        @com.sam.placer.annotations.View(R.id.circular_image)
        CircleImageView circularImage;
        @com.sam.placer.annotations.View(R.id.highlighted_text)
        TextView name_tex;
        @com.sam.placer.annotations.View(R.id.small_text)
        TextView description_text;
        @com.sam.placer.annotations.View(R.id.status__txt)
        TextView status__txt;
        @com.sam.placer.annotations.View(R.id.root)
        CardView root;
        @com.sam.placer.annotations.View(R.id.user_description_layout)
        LinearLayout userDescriptionLayout;
        @com.sam.placer.annotations.View(R.id.est)
        TextView est_fare;


        private String TAG = "HolderRideHistoryItem";
        private Context context;
        private ModelNewRequests.DataBean mData;

        public HolderNewRequest(Context context, ModelNewRequests.DataBean dataBean) {
            this.context = context;
            this.mData = dataBean;
        }


        @Resolve
        private void setData() {
            try {
                setDataAccordingly();
                setColor();
                setStyle();
                setVisibility();
            } catch (Exception e) {
                Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
            }
        }


        @Click(R.id.root)
        private void setOnClick() {
            context.startActivity(new Intent(context, SpecificTripDetailsActivity.class).putExtra("" + IntentKeys.BOOKING_ID, "" + mData.getBooking_id()));
        }


        private void setColor() throws Exception {
            highligtedLeftText.setTextColor(Color.parseColor("" + mData.getHighlighted_left_text_color()));
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
            est_fare.setText("" + mData.getEstimate_bill());
            Glide.with(context).load("" + mData.getCircular_image()).into(circularImage);
        }
    }

}
