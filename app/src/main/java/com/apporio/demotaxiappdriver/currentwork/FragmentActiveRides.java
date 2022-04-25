package com.apporio.demotaxiappdriver.currentwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.baseClass.BaseFragment;
import com.sam.placer.PlaceHolderView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FragmentActiveRides extends BaseFragment {

    @Bind(R.id.place_holder)
    PlaceHolderView placeHolder;


    public static FragmentActiveRides newInstance() {
        FragmentActiveRides fragment = new FragmentActiveRides();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.new_request_fragments, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }



}
