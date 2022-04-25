package com.apporio.demotaxiappdriver;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.earnings.DayAxisValueFormatter;
import com.apporio.demotaxiappdriver.earnings.MyAxisValueFormatter;
import com.apporio.demotaxiappdriver.earnings.WeeklyStatementActivity;
import com.apporio.demotaxiappdriver.earnings.XYMarkerView;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;
import com.sam.placer.annotations.View;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EarningActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.placeholder) PlaceHolderView placeholder;
    @Bind(R.id.swiperefreshLayout)
    SwipeRefreshLayout swiperefreshLayout;
    @Bind(R.id.root) LinearLayout root;
    @Bind(R.id.back) ImageView back;

    private String DATE = "";
    private SessionManager sessionManager;
    private ApiManager apiManager;
    private final String TAG = "EarningActivity";
    HashMap<String, String> data = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_earning2);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        apiManager = new ApiManager(this,this);


        try {
            Calendar now = Calendar.getInstance();
            DATE = "" + now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH)+1 )+ "-" + now.get(Calendar.DAY_OF_MONTH);
            callApi("" + DATE);
        } catch (Exception e) {
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

        back.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                finish();
            }
        });

        swiperefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {

                    callApi("" + DATE);
                } catch (Exception e) {
                    Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
                }
            }
        });

    }


    private void callApi(String date) throws Exception {
        data.clear();
        data.put("date", "" + date);
        apiManager._post(API_S.Tags.EARNING, API_S.Endpoints.EARNING, data, sessionManager);
        placeholder.removeAllViews();
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        try {
            if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                swiperefreshLayout.setRefreshing(true);
            } else {
                swiperefreshLayout.setRefreshing(false);
            }
        }catch (Exception e) {

        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            ModelEarning modelEarning = SingletonGson.getInstance().fromJson("" + script, ModelEarning.class);
            placeholder.addView(new HolderGraph(modelEarning));
            placeholder.addView(new HolderOutstanding(modelEarning.getData().getOutstand_amount(), modelEarning.getData().getOutstand_color()));
        } catch (Exception e) {
            Log.d("" + TAG, "Exception caught while parsing " + e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(EarningActivity.this, ""+script, Toast.LENGTH_SHORT).show();
    }

    @Layout(R.layout.holder_graph_layout)
    class HolderGraph implements DatePickerDialog.OnDateSetListener {
        @View(R.id.chart)
        BarChart mChart;
        ModelEarning mData;
        @View(R.id.weekly_trips)
        TextView weeklyTrips;
        @View(R.id.weekly_earning)
        TextView weeklyEarning;
        @View(R.id.date_range_txt)
        TextView dateRangeTxt;

        public HolderGraph(ModelEarning detail) {
            this.mData = detail;
        }



        @Click(R.id.select_data)
        private void setDateClick() {
            Calendar now = Calendar.getInstance();
            DatePickerDialog dpd = DatePickerDialog.newInstance(
                    this,
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH)
            );
            dpd.show(getFragmentManager(), "Datepickerdialog");
        }

        @Click(R.id.weekly_earning_btn)
        private void viewEarningButton() {
            startActivity(new Intent(EarningActivity.this, WeeklyStatementActivity.class).putExtra("" + IntentKeys.DATE, "" + DATE));
        }


        @Resolve
        private void setData() {
            weeklyTrips.setText("" + mData.getData().getTotal_weekly_rides());
            weeklyEarning.setText("" + mData.getData().getTotal_weekly_amount());
            dateRangeTxt.setText("" + mData.getData().getStart_date() + "-" + mData.getData().getLast_date());
            mChart.setDrawBarShadow(false);
            mChart.setDrawValueAboveBar(true);
            mChart.getDescription().setEnabled(false);
            mChart.setMaxVisibleValueCount(7);
            mChart.setPinchZoom(false);
            mChart.setDrawGridBackground(false);
            // mChart.setDrawYLabels(false);
            mChart.setDoubleTapToZoomEnabled(false);
            mChart.setDrawGridBackground(false);
            mChart.getXAxis().setDrawAxisLine(false);
            mChart.getAxisRight().setEnabled(false);
            mChart.getAxisLeft().setAxisLineColor(EarningActivity.this.getResources().getColor(R.color.pure_white));
            mChart.getAxisLeft().setLabelCount(2);
            mChart.getAxisLeft().setTextColor(EarningActivity.this.getResources().getColor(R.color.pure_white));
            mChart.getAxisLeft().setTextSize(12f);
//        mChart.getAxisLeft().setTypeface(Typeface.createFromAsset(this.getAssets(), "Monix-Regular.otf"));
            mChart.getAxisLeft().setGridColor(EarningActivity.this.getResources().getColor(R.color.icon_8_muted_black));
            mChart.getAxisLeft().setValueFormatter(new MyAxisValueFormatter(sessionManager));
            mChart.setDrawGridBackground(false);
            mChart.getLegend().setEnabled(false);
            mChart.getXAxis().setDrawLabels(false);
            mChart.getXAxis().setAxisLineColor(EarningActivity.this.getResources().getColor(R.color.icon_8_muted_black));
            mChart.getXAxis().setGridColor(EarningActivity.this.getResources().getColor(R.color.icon_8_muted_black));

            IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(mChart);
            XAxis xAxis = mChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setDrawGridLines(false);
            xAxis.setGranularity(1f); // only intervals of 1 day
            xAxis.setLabelCount(7);
            xAxis.setValueFormatter(xAxisFormatter);

            XYMarkerView mv = new XYMarkerView(EarningActivity.this, xAxisFormatter, sessionManager);
            mv.setChartView(mChart); // For bounds control
            mChart.setMarker(mv); // Set the marker to the chart

//
//            for (int i = 0; i < mData.size(); i++) {
//
//                amount = Float.valueOf(weeklyEarningModel.getDetails().get(i).getDetail().getAmount().trim());
//            }
//            setData( amount, weeklyEarningModel);
            setDataOnGraph(100, mData);
        }

        private void setDataOnGraph(float range, ModelEarning modelEarning) {

            ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

            for (int i = 0; i < modelEarning.getData().getDetail().size(); i++) {
                float mult = (range + 1);
                float val = (float) (Math.random() * mult);

                yVals1.add(new BarEntry(i, Float.parseFloat(""+modelEarning.getData().getDetail().get(i).getDetails().getDriver_amount())));
            }


            BarDataSet set1;

            if (mChart.getData() != null && mChart.getData().getDataSetCount() > 0) {
                set1 = (BarDataSet) mChart.getData().getDataSetByIndex(0);
                set1.setValues(yVals1);
                mChart.getData().notifyDataChanged();
                mChart.notifyDataSetChanged();
            } else

            {
                set1 = new BarDataSet(yVals1, "");
                set1.setDrawIcons(false);

                set1.setColors(EarningActivity.this.getResources().getColor(R.color.icons_8_muted_green_1_dark));

                ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
                dataSets.add(set1);

                BarData data = new BarData(dataSets);
                data.setValueTextSize(10f);
//            data.setValueTypeface(mTfLight);
                data.setBarWidth(0.9f);
                data.setDrawValues(false);

                mChart.setData(data);
                mChart.animateY(1050);
            }

        }


        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
            DATE = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            try {
                callApi(DATE);
            } catch (Exception e) {
                Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
            }
        }
    }


    @Layout(R.layout.holder_layout_outstanding)
    class HolderOutstanding {

        @View(R.id.outstanding_amount)
        TextView outstandingAmounttxt;
        private String outStandingAmount;
        private String mColor;

        public HolderOutstanding(String outstand_amount, String color) {
            this.outStandingAmount = outstand_amount;
            this.mColor = color;
        }

        @Resolve
        private void setData() {
            outstandingAmounttxt.setText("" + outStandingAmount);
            outstandingAmounttxt.setTextColor(Color.parseColor("#" + mColor));
        }
    }


}
