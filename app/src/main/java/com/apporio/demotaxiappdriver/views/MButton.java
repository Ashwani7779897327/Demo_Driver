package com.apporio.demotaxiappdriver.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Bhuvneshwar on 9/1/2017.
 */

public class MButton extends Button {

    public MButton(Context context) {
        super(context);
        init();
    }

    public MButton(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

    }

    public MButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        this.setAllCaps(false);
    }
}
