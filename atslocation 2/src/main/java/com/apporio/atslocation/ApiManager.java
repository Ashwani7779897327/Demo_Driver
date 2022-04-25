package com.apporio.atslocation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

public class ApiManager {

    public static Context context;
    String url;
    private static final String TAG = "APIExecution";
    private APIFETCHER apifetcher ;

    public ApiManager(APIFETCHER apifetcher, Context context) {
        this.context = context;
        this.apifetcher = apifetcher;
    }


    public interface APIFETCHER {

        public static int KEY_API_IS_STARTED = 0;
        public static int KEY_API_IS_RUNNING = 1;
        public static int KEY_API_IS_STOPPED = 2;
        public static int KEY_API_IS_ERRORED = 3;

        public static int KEY_ERRORED = 4;

        void onAPIRunningState(int a, String APINAME);  // state - API_S Starts(0) , API_S Running(1) , API_S Stops(2)  API_S Error(3)


        void onFetchComplete(Object script, String APINAME); // This will give the full script

        void onFetchResultZero(String script, String APINAME);

    }


    @SuppressLint("LongLogTag")
    public void execution_method_post(final String tag, String url, JSONObject jsonbody) {
        apifetcher.onAPIRunningState(APIFETCHER.KEY_API_IS_STARTED, tag);
        AndroidNetworking.post("" + url)
                .addJSONObjectBody(jsonbody)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(final JSONObject jsonObject) {
                        Log.d(tag + " **Response Response==> ", "" + jsonObject);
                        apifetcher.onAPIRunningState(APIFETCHER.KEY_API_IS_STOPPED, tag);
                        apifetcher.onFetchComplete(jsonObject, tag);
                    }

                    @Override
                    public void onError(ANError anError) {
                        apifetcher.onAPIRunningState(APIFETCHER.KEY_API_IS_STOPPED, tag);
                        Log.d("errror", "" + anError.getErrorBody());
                    }
                });
    }




}
