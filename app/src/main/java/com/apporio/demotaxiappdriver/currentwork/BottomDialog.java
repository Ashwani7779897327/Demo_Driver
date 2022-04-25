package com.apporio.demotaxiappdriver.currentwork;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.others.AnimationUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

@SuppressLint("ValidFragment")
public class BottomDialog extends DialogFragment {

    public BottomDialogListener listener;
    @Bind(R.id.ok)
    TextView ok;

    @SuppressLint("ValidFragment")
    public BottomDialog(String some_message, BottomDialogListener bottomDialogListener) {
        listener = bottomDialogListener;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_bottom, container, false);
        AnimationUtils.slideToUp(view);
        ButterKnife.bind(this, view);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onOKClick();
                BottomDialog.this.dismiss();
            }
        });
        return view;
    }


    public void attachListener(BottomDialogListener listener) {
        this.listener = listener;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    public interface BottomDialogListener {
        void onOKClick();
    }


}
