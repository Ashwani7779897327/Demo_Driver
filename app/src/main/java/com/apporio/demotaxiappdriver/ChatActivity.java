package com.apporio.demotaxiappdriver;

import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.baseClass.BaseActivity;
import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelNotificationChat;
import com.apporio.demotaxiappdriver.models.ModelNotificationType;
import com.apporio.demotaxiappdriver.models.ModelSendMessage;
import com.apporio.demotaxiappdriver.models.ModelViewChat;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.bumptech.glide.Glide;

import com.sam.placer.PlaceHolderView;
import com.sam.placer.annotations.Layout;
import com.sam.placer.annotations.Resolve;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import morxander.zaman.ZamanTextView;

public class ChatActivity extends BaseActivity implements ApiManager.APIFETCHER {

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.driver_image)
    CircleImageView driverImage;
    @Bind(R.id.driver_name_txt)
    TextView driverNameTxt;
    @Bind(R.id.driver_riding_status)
    TextView driverRidingStatus;
    @Bind(R.id.placeholder)
    PlaceHolderView placeholder;
    @Bind(R.id.message_edt)
    EditText messageEdt;
    @Bind(R.id.send_btn)
    LinearLayout sendBtn;
    @Bind(R.id.root)
    LinearLayout root;
    @Bind(R.id.loading_dot)
    TextView loadingDot;
    @Bind(R.id.fetching_text)
    CardView fetchingText;

    private ApiManager apiManager;
    private SessionManager sessionManager;
    private HashMap<String, String> data = new HashMap<>();
    private final String TAG = "ChatActivity";
    private int TOTAL_ITEMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        apiManager = new ApiManager(this,this);
        sessionManager = new SessionManager(this);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        placeholder.setLayoutManager(linearLayoutManager);


        try {
            driverRidingStatus.setText("" + getIntent().getExtras().getString("" + IntentKeys.STATUS));
            driverNameTxt.setText("" + getIntent().getExtras().getString(IntentKeys.USER_NAME));
            Glide.with(this).load(""+ getIntent().getExtras().getString("" + IntentKeys.USER_IMAGE)).into(driverImage);
        } catch (Exception e) {
            Toast.makeText(ChatActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!messageEdt.getText().toString().trim().equals("")) {

                    try {
                        sendBtn.setEnabled(false);
                        data.clear();
                        data.put("booking_id", "" + getIntent().getExtras().getString("" + IntentKeys.BOOKING_ID));
                        data.put("message", "" + messageEdt.getText().toString());
                        apiManager._post(API_S.Tags.SEND_CHAT_MESSAGE, API_S.Endpoints.SEND_CHAT_MESSAGE, data, sessionManager);
                    } catch (Exception e) {
                        Toast.makeText(ChatActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
                    }
                }
            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        callAPi();
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String message) {
        try {
            ModelNotificationType modelNotificationType = SingletonGson.getInstance().fromJson("" + message, ModelNotificationType.class);
            if (modelNotificationType.getType() == 5) {
                ModelNotificationChat modelNotificationChat = SingletonGson.getInstance().fromJson("" + message, ModelNotificationChat.class);
                placeholder.addView(new HolderMessage("" + modelNotificationChat.getData().getSender(), "" + modelNotificationChat.getData().getMessage()));
                TOTAL_ITEMS = TOTAL_ITEMS + 1;
                placeholder.scrollToPosition(TOTAL_ITEMS);
            }
        } catch (Exception e) {
            Toast.makeText(ChatActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
        }
    }

    @Override
    public void onAPIRunningState(int a, String APINAME) {
        switch (APINAME) {
            case API_S.Tags.SEND_CHAT_MESSAGE:
                if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                    loadingDot.setVisibility(View.VISIBLE);
                } else {
                    loadingDot.setVisibility(View.GONE);
                }
                break;
            case API_S.Tags.VIEW_CHAT:
                if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                    sendBtn.setBackgroundColor(Color.parseColor("#FFCFD2D2"));
                    fetchingText.setVisibility(View.VISIBLE);

                } else {
                    sendBtn.setBackgroundColor(Color.parseColor("#2ecc71"));
                    fetchingText.setVisibility(View.GONE);

                }
                break;
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {
        try {
            switch (APINAME) {
                case API_S.Tags.VIEW_CHAT:
                    ModelViewChat modelViewChat = SingletonGson.getInstance().fromJson("" + script, ModelViewChat.class);
                    try {
                        placeholder.refresh();
                        placeholder.removeAllViews();
                        placeholder.getAdapter().notifyDataSetChanged();
                    }catch (Exception e){

                    }
                    for (int i = 0; i < modelViewChat.getData().getChat().size(); i++) {
                        placeholder.addView(new HolderMessage("" + modelViewChat.getData().getChat().get(i).getSender(), "" + modelViewChat.getData().getChat().get(i).getMessage()));
                        placeholder.scrollToPosition(placeholder.getChildCount() - 1);
                        TOTAL_ITEMS = modelViewChat.getData().getChat().size() - 1;
                    }
                    break;
                case API_S.Tags.SEND_CHAT_MESSAGE:
                    ModelSendMessage modelSendMessage = SingletonGson.getInstance().fromJson("" + script, ModelSendMessage.class);
                    sendBtn.setEnabled(true);
                    placeholder.addView(new HolderMessage("DRIVER", "" + modelSendMessage.getData().getChat().getMessage()));
                    messageEdt.setText("");
                    TOTAL_ITEMS = TOTAL_ITEMS + 1;
                    placeholder.scrollToPosition(TOTAL_ITEMS);
                    break;
            }

        } catch (Exception e) {
            Toast.makeText(ChatActivity.this, ""+ e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {

    }


    @Layout(R.layout.holder_message_layout)
    class HolderMessage {

        @com.sam.placer.annotations.View(R.id.left_txt)
        TextView leftTxt;
        @com.sam.placer.annotations.View(R.id.left_date)
        ZamanTextView leftDate;
        @com.sam.placer.annotations.View(R.id.left_side_msg_layout)
        CardView leftSideMsgLayout;
        @com.sam.placer.annotations.View(R.id.right_text)
        TextView rightText;
        @com.sam.placer.annotations.View(R.id.right_date)
        ZamanTextView rightDate;
        @com.sam.placer.annotations.View(R.id.right_side_msg_layout)
        CardView rightSideMsgLayout;

        private String TYPE = "";
        private String message = "";

        public HolderMessage(String type, String message) {
            this.TYPE = type;
            this.message = message;
        }


        @Resolve
        private void setdata() {
            if (TYPE.equals("USER")) {
                leftSideMsgLayout.setVisibility(View.VISIBLE);
                rightSideMsgLayout.setVisibility(View.GONE);
            } else if (TYPE.equals("DRIVER")) {
                leftSideMsgLayout.setVisibility(View.GONE);
                rightSideMsgLayout.setVisibility(View.VISIBLE);
            }
            rightText.setText("" + this.message);
            leftTxt.setText("" + message);
        }

    }

    private void callAPi() {
        try {
            data.clear();
            data.put("booking_id", "" + getIntent().getExtras().getString("" + IntentKeys.BOOKING_ID));
            apiManager._post(API_S.Tags.VIEW_CHAT, API_S.Endpoints.VIEW_CHAT, data, sessionManager);
        } catch (Exception e) {
            Log.d("" + TAG, "Exception caught while calling API " + e.getMessage());
        }

    }


}
