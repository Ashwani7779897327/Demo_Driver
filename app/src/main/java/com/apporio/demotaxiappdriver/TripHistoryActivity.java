package com.apporio.demotaxiappdriver;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.ActiveRideFragment;
import com.apporio.demotaxiappdriver.currentwork.FragmentPastRides;
import com.apporio.demotaxiappdriver.currentwork.FragmentScheduleRides;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import customviews.typefacesviews.TypeFaceGoogleBold;

public class TripHistoryActivity extends BaseActivity {


    public static Activity activity;
    public static boolean isActivityOpen = false;
    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.activity_name)
    TypeFaceGoogleBold activityName;
    @Bind(R.id.root_action_bar)
    LinearLayout rootActionBar;
    @Bind(R.id.viewpagertab)
    SmartTabLayout viewpagertab;
    @Bind(R.id.container)
    ViewPager container;
    @Bind(R.id.root)
    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_trip_history);
        ButterKnife.bind(this);
        activity = this;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        container.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        viewpagertab.setViewPager(container);
    }


    @Override
    protected void onResume() {
        super.onResume();

        isActivityOpen = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        isActivityOpen = false;
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        String[] fragmens_name = {getString(R.string.on__going), getString(R.string.schedule), getString(R.string.past_trips)};

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return ActiveRideFragment.newInstance();
            }
            if (position == 1) {
                return FragmentScheduleRides.newInstance();
            } else {
                return FragmentPastRides.newInstance();
            }
        }

        @Override
        public int getCount() {
            return fragmens_name.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmens_name[position];
        }
    }

}
