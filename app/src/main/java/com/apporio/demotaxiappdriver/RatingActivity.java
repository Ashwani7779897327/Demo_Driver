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
import com.apporio.demotaxiappdriver.rating_module.WeeklyRatingFragment;
import com.apporio.demotaxiappdriver.rating_module.YearlyRatingFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import customviews.typefacesviews.TypeFaceGoogleBold;

public class RatingActivity extends BaseActivity {

    public static Activity activity;
    @Bind(R.id.back_rating)
    ImageView back;
    @Bind(R.id.activity_name_rating)
    TypeFaceGoogleBold activityName;
    @Bind(R.id.root_action_bar_rating)
    LinearLayout rootActionBar;
    @Bind(R.id.viewpagertab_rating)
    SmartTabLayout viewpagertab;
    @Bind(R.id.container_rating)
    ViewPager container;
    @Bind(R.id.root_rating)
    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ButterKnife.bind(this);
        activity = this;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        container.setAdapter(new PagerAdapterRating(getSupportFragmentManager()));
        viewpagertab.setViewPager(container);
    }

    public class PagerAdapterRating extends FragmentStatePagerAdapter {
        String[] fragmens_name = {getString(R.string.daily_rating), getString(R.string.weekly_rating), getString(R.string.yearly_rating)};


        public PagerAdapterRating(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0)
            {
                return null;

            }else if (position==1)
            {
                return WeeklyRatingFragment.newInstance("","");
            }else {

                return YearlyRatingFragment.newInstance("","");

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
