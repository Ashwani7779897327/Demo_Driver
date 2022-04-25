package com.apporio.demotaxiappdriver.currentwork;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.baseClass.BaseFragment;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelFragmenRides;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sam.placer.PlaceHolderView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActiveRideFragment extends BaseFragment implements ApiManager.APIFETCHER,HolderRideHistoryItem.OnBottomReachedListener {

    @Bind(R.id.no_record_trips)
    TextView no_record_active_rides;
    @Bind(R.id.place_holder)
    PlaceHolderView placeHolder;
    @Bind(R.id.root)
    FrameLayout root;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    ApiManager apiManager;
    private SessionManager sessionManager;
    private final String TAG = "ActiveRideFragment";

    public ActiveRideFragment() {
    }

    public static ActiveRideFragment newInstance() {
        ActiveRideFragment fragment = new ActiveRideFragment();
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
        View rootView = inflater.inflate(R.layout.active_ride_fragment, container, false);
        ButterKnife.bind(this, rootView);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callActiveAPI();
            }
        });


        return rootView;
    }

    private void callActiveAPI() {
        try {
            apiManager._post(API_S.Tags.RIDE_HISTORY_ACTIVE, API_S.Endpoints.RIDE_HISTORY_ACTIVE, null, sessionManager);
            placeHolder.removeAllViews();
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
            ModelFragmenRides modelFragmenRides = SingletonGson.getInstance().fromJson("" + script, ModelFragmenRides.class);

            for (int i = 0; i < modelFragmenRides.getData().size(); i++) {
                placeHolder.addView(new HolderRideHistoryItem(getActivity(), modelFragmenRides.getData().get(i),true,this));
            }
        } catch (Exception e) {
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        try {
            placeHolder.setVisibility(View.GONE);
            no_record_active_rides.setText(script);
            no_record_active_rides.setVisibility(View.VISIBLE);
        } catch (Exception e) {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        callActiveAPI();
    }

    @Override
    public void onBottomReached() {

    }
}
