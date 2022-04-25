package com.apporio.demotaxiappdriver.rating_module.rating_holders;


import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;

import com.apporio.demotaxiappdriver.R;
import com.sam.placer.annotations.Click;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import java.util.Calendar;

import butterknife.Bind;

@Layout(R.layout.daily_rating_select_date)
public class DailyRaing_selectdate implements DatePickerDialog.OnDateSetListener{

    @Bind(R.id.select_date_txt)
    TextView select_date_txt;

    Context context;
    Dailty_rating_listner dailty_rating_listner;

    public DailyRaing_selectdate(Dailty_rating_listner dailty_rating_listner, Context context)
    {
        this.dailty_rating_listner = dailty_rating_listner;
        this.context = context;

    }


    @Resolve
    public void onResolve()
    {


    }

    @Click(R.id.select_date_txt)
    public void onclick()
    {
        dailty_rating_listner.OnSelectDateClick();

    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    public interface Dailty_rating_listner{

        public void OnSelectDateClick();

    }
}
