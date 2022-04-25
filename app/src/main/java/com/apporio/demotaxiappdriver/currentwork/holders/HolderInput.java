package com.apporio.demotaxiappdriver.currentwork.holders;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.models.ModelReceipt;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Position;
import com.sam.placer.annotations.Resolve;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;


@Layout(R.layout.holder_input)
public class HolderInput {
    @com.sam.placer.annotations.View(R.id.container)
    LinearLayout container;
    @com.sam.placer.annotations.View(R.id.highlighted_text)
    TextView highlightedText;
    @com.sam.placer.annotations.View(R.id.highlighted_small_text)
    TextView highlightedSmallText;

    @Position
    int mPosition;
    private Context context;
    private LayoutInflater mInflater;
    private ModelReceipt.DataBean.HolderInputInfoBean mData;
    private String TAG = "HolderInput";
    showButton showButton;
    private HashMap<String , String> inputVal = new HashMap<>();
    private ArrayList<String> edt_Strings = new ArrayList<>();

    public HolderInput(Context context, ModelReceipt.DataBean.HolderInputInfoBean holder_input_info,showButton showButton) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mData = holder_input_info;
        this.showButton = showButton;
    }


    @Resolve
    private void setdata() {
        try{

            highlightedText.setText(""+mData.getHeadline_major());
            highlightedSmallText.setText(""+mData.getHeadline_small_text());
            setColor();
            setStyle();
            setVisibilityOfElement();
            for (int i = 0; i < mData.getFields().size(); i++) {
                edt_Strings.add("");
                container.addView(getView(mData.getFields().get(i), i));
            }
        }catch (Exception e){
            Log.d("" +TAG , "Exception caught while calling API "+e.getMessage());}


    }


    public String getInputsFromFields() throws  Exception{

        JSONArray jsonArray = new JSONArray() ;

        for(int i =0 ; i < edt_Strings.size() ; i ++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("parameter",""+mData.getFields().get(i).getField_id());
            jsonObject.put("amount",""+edt_Strings.get(i));
            jsonArray.put(jsonObject);
        }

        return ""+jsonArray;
    }


    private View getView(final ModelReceipt.DataBean.HolderInputInfoBean.FieldsBean fieldsBean, int pos) throws  Exception {
        View v = mInflater.inflate(R.layout.holder_input_layout, null, true);
        TextView label_text = (TextView) v.findViewById(R.id.label_text);
        final EditText input_edt = (EditText) v.findViewById(R.id.input_edt);
        ImageView info = (ImageView) v.findViewById(R.id.info);
        final TextView position = v.findViewById(R.id.position);
        input_edt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER);

        label_text.setText(""+fieldsBean.getField_name());
        input_edt.setHint(""+fieldsBean.getField_hint());
        position.setText(""+pos);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+fieldsBean.getField_info(), Toast.LENGTH_SHORT).show();
            }
        });


        input_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                edt_Strings.set(Integer.parseInt(""+position.getText().toString()),""+input_edt.getText().toString());
                showButton.callback();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return v;

    }

    public interface showButton{

    public void callback();
    }


    private void setColor() throws Exception {
        highlightedText.setTextColor(Color.parseColor("#"+mData.getHeadline_major_color()));
        highlightedSmallText.setTextColor(Color.parseColor("#"+mData.getHeadline_small_text_color()));
    }


    private void setStyle()throws Exception {
        if(mData.getHeadline_major_style().equals("BOLD")){highlightedText.setTypeface(null, Typeface.BOLD); }
        else{ highlightedText.setTypeface(null, Typeface.NORMAL); }

        if(mData.getHeadline_small_text_style().equals("BOLD")){highlightedSmallText.setTypeface(null, Typeface.BOLD); }
        else{ highlightedSmallText.setTypeface(null, Typeface.NORMAL); }

    }


    private void setVisibilityOfElement()throws Exception{
        if(mData.isHeadline_major_visibility()){highlightedText.setVisibility(View.VISIBLE);}
        else{highlightedText.setVisibility(View.GONE);}


        if(mData.isHeadline_small_text_visibility()){highlightedSmallText.setVisibility(View.VISIBLE);}
        else{highlightedSmallText.setVisibility(View.GONE);}

    }

}
