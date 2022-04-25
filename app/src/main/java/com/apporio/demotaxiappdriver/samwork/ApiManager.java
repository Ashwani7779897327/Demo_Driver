package com.apporio.demotaxiappdriver.samwork;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.AnalyticsListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import com.androidnetworking.interfaces.StringRequestListener;
import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.Config;
import com.apporio.demotaxiappdriver.MainActivity;
import com.apporio.demotaxiappdriver.ProfileActivity;
import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.SplashActivity;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ResultCheck;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;

import static com.apporio.demotaxiappdriver.samwork.ApiManager.APIFETCHER.KEY_API_IS_ERRORED;
import static com.apporio.demotaxiappdriver.samwork.ApiManager.APIFETCHER.KEY_API_IS_STARTED;
import static com.apporio.demotaxiappdriver.samwork.ApiManager.APIFETCHER.KEY_API_IS_STOPPED;


/**
 * Created by samir on 30/01/17.
 */

public class ApiManager {

    public static Context context;
    String url;
    HashMap map;
    GsonBuilder gsonBuilder;
    Gson gson;
    APIFETCHER apifetcher;
    SessionManager sessionManager;
    private static final String TAG = "APIExecution";

    public ApiManager(APIFETCHER apifetcher, Context context) {
        this.context = context;
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        map = new HashMap();
        this.apifetcher = apifetcher;
    }


    @SuppressLint("LongLogTag")
    public void execution_method_post(final String tag, String url, HashMap<String, String> bodyparameter) {
        bodyparameter.put("language_code", "" + Locale.getDefault().getLanguage());
        Log.d(tag + " **Body API_S Posting parameter ==> ", "" + bodyparameter);
        Log.d(tag + " **Url API_S Url executed ==> ", "" + url);
        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        AndroidNetworking.post("" + url)
                .addBodyParameter(bodyparameter)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                        Log.d(TAG, " timeTakenInMillis : " + timeTakenInMillis);
                        Log.d(TAG, " bytesSent : " + bytesSent);
                        Log.d(TAG, " bytesReceived : " + bytesReceived);
                        Log.d(TAG, " isFromCache : " + isFromCache);
                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(final JSONObject jsonObject) {
                        Log.d(tag + " **Response Response==> ", "" + jsonObject);
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        apifetcher.onFetchComplete(jsonObject, tag);
                    }

                    @Override
                    public void onError(ANError anError) {
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        Log.d("errror", "" + anError.getErrorBody());
                        Log.d("errror", "" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getMessage());
                        Log.d("error", "" + anError.getStackTrace());
                        Log.d("error", "" + anError.getCause());
                    }
                });
    }

    public void execution_method_get(final String tag, String url) {
        Log.d(tag + " **Url API_S Url executed ==> ", "" + url + "&language_code=" + Locale.getDefault().getLanguage());

        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        AndroidNetworking.get(url)
                .setTag(this).setPriority(Priority.MEDIUM)
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                        Log.d(TAG, " timeTakenInMillis : " + timeTakenInMillis);
                        Log.d(TAG, " bytesSent : " + bytesSent);
                        Log.d(TAG, " bytesReceived : " + bytesReceived);
                        Log.d(TAG, " isFromCache : " + isFromCache);
                    }
                }).getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(final JSONObject jsonObject) {
                Log.d(tag + " **Response Response==> ", "" + jsonObject);
                apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                apifetcher.onFetchComplete(jsonObject, tag);
            }

            @Override
            public void onError(ANError anError) {
                apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                Log.d("" + TAG, "" + anError.getErrorBody());
                Log.d("" + TAG, "" + anError.getErrorDetail());
                apifetcher.onAPIRunningState(KEY_API_IS_ERRORED, tag);
            }
        });
    }

    public void execution_method_multipart(final String tag, String url, HashMap<String, String> hashmapdetails, String image_key, String image) {
        hashmapdetails.put("language_code", "" + Locale.getDefault().getLanguage());

        Log.d(tag + " **Body API_S Posting parameter ==> ", "" + hashmapdetails);
        Log.d(tag + " **Body(Images) API_S Posting parameter ==> ", image_key + "  " + image);
        Log.d(tag + " **Url API_S Url executed ==> ", "" + url);
        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        AndroidNetworking.upload(url)
                .addMultipartParameter(hashmapdetails)
                .addMultipartFile("" + image_key, new File(image))
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.d(tag + " **Response Response==> ", "" + jsonObject);
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        apifetcher.onFetchComplete(jsonObject, tag);
                    }

                    @Override
                    public void onError(ANError anError) {
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        Log.d("errror", "" + anError.getErrorBody());
                        Log.d("errror", "" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getMessage());
                        Log.d("error", "" + anError.getStackTrace());
                        Log.d("error", "" + anError.getCause());
                    }
                });
    }

    public void _get(final String tag, String url) {

        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        AndroidNetworking.get(url)
                .setTag(this).setPriority(Priority.MEDIUM)
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                        Log.d(TAG, " timeTakenInMillis : " + timeTakenInMillis);
                        Log.d(TAG, " bytesSent : " + bytesSent);
                        Log.d(TAG, " bytesReceived : " + bytesReceived);
                        Log.d(TAG, " isFromCache : " + isFromCache);
                    }
                }).getAsJSONObject(new JSONObjectRequestListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(final JSONObject jsonObject) {
                Log.d(tag + " **Response Response==> ", "" + jsonObject);
                apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                apifetcher.onFetchComplete(jsonObject, tag);
            }

            @Override
            public void onError(ANError anError) {
                apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                Log.d("" + TAG, "" + anError.getErrorBody());
                Log.d("" + TAG, "" + anError.getErrorDetail());
                apifetcher.onAPIRunningState(KEY_API_IS_ERRORED, tag);
            }
        });
    }

    public static final Interceptor REWRITE_RESPONSE_INTERCEPTOR_OFFLINE = chain -> {
        Request request = chain.request();
        if (isOnline()) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
        } else {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        }
        Response response = chain.proceed(request);

        System.out.println("network: " + response.networkResponse());
        System.out.println("cache: " + response.cacheResponse());

        return response;
    };

    public static boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    @SuppressLint("LongLogTag")
    public void _post(final String tag, String url, HashMap<String, String> bodyparameter, SessionManager sessionManager) throws Exception {
        Log.d(tag + " **Body API_S Posting parameter ==> ", "" + bodyparameter);
        Log.d(tag + " **Url API_S Url executed ==> ", "" + url);
        Log.d("" + tag, "" + sessionManager.getHeader());
        Log.d("" + tag, "locale:" + sessionManager.getLanguage());


        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 Mi

        TimeUnit time = TimeUnit.MILLISECONDS;
        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)
                .cache(new Cache(httpCacheDirectory,cacheSize))
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                . writeTimeout(60, TimeUnit.SECONDS)
                .build();

        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);

        AndroidNetworking.post("" + url)
                .addBodyParameter(bodyparameter)
                .addHeaders(sessionManager.getHeader())
                .addHeaders("Accept","application/json")
                .setMaxAgeCacheControl(10,time)
                .addHeaders("locale", "" + sessionManager.getLanguage())
                .setTag(this)
                .setOkHttpClient(okHttpClient)
                .setPriority(Priority.HIGH)
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                        Log.d(TAG, " timeTakenInMillis : " + timeTakenInMillis);
                        Log.d(TAG, " bytesSent : " + bytesSent);
                        Log.d(TAG, " bytesReceived : " + bytesReceived);
                        Log.d(TAG, " isFromCache : " + isFromCache);
                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(final JSONObject jsonObject) {
                        Log.d(tag + " **Response Response==> ", "" + jsonObject);
                        Log.d(tag + " **Response Response==> ", "" + jsonObject.toString().length());
                        ResultCheck resultCheck = SingletonGson.getInstance().fromJson("" + jsonObject, ResultCheck.class);
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        if (resultCheck.result.equals("0")) {
                            apifetcher.onFetchResultZero("" + resultCheck.message,tag);
                        } else if (resultCheck.result.equals("999")) {
                            logoutUnAuthorizedDriver(sessionManager);  // Delete Driver from admin panel
                        } else {
                            apifetcher.onFetchComplete(jsonObject, tag);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        //  Toast.makeText(context, "" + anError.getErrorDetail(), Toast.LENGTH_SHORT).show();
//                        apifetcher.onFetchResultZero("" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getErrorBody());
                        Log.d("errror", "" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getMessage());
                        Log.d("error", "" + anError.getStackTrace());
                        Log.d("error", "" + anError.getCause());
                    }
                });
    }


    @SuppressLint("LongLogTag")
    public void _postIfCached(final String tag, String url, HashMap<String, String> bodyparameter) throws Exception {
        Log.d(tag + " **Body API_S Posting parameter ==> ", "" + bodyparameter);
        Log.d(tag + " **Url API_S Url executed ==> ", "" + url);
        Log.d("" + tag, "" + sessionManager.getHeader());
        Log.d("" + tag, "locale:" + sessionManager.getLanguage());

        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(180, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .build();

        AndroidNetworking.post("" + url)
                .addBodyParameter(bodyparameter)
                .addHeaders(Config.IntentKeys.PUBLIC_KEY, "" + BuildConfig.PUBLIC_KEY)
                .addHeaders(Config.IntentKeys.SECRET_KEY, "" + BuildConfig.SECRET_KEY)
                .addHeaders("locale", "" + sessionManager.getLanguage())
                .setTag(this)
                .getResponseOnlyIfCached()
                .setOkHttpClient(okHttpClient)
                .setPriority(Priority.HIGH)
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                        Log.d(TAG, " timeTakenInMillis : " + timeTakenInMillis);
                        Log.d(TAG, " bytesSent : " + bytesSent);
                        Log.d(TAG, " bytesReceived : " + bytesReceived);
                        Log.d(TAG, " isFromCache : " + isFromCache);
                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(final JSONObject jsonObject) {
                        Log.d(tag + " **Response Response==> ", "" + jsonObject);
                        Log.d(tag + " **Response Response==> ", "" + jsonObject.toString().length());
                        ResultCheck resultCheck = SingletonGson.getInstance().fromJson("" + jsonObject, ResultCheck.class);
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        if (resultCheck.result.equals("0")) {
                            apifetcher.onFetchResultZero("" + resultCheck.message,tag);
                        } else if (resultCheck.result.equals("999")) {
                            logoutUnAuthorizedDriver(sessionManager);  // Delete Driver from admin panel
                        } else {
                            apifetcher.onFetchComplete(jsonObject, tag);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        //  Toast.makeText(context, "" + anError.getErrorDetail(), Toast.LENGTH_SHORT).show();
//                        apifetcher.onFetchResultZero("" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getErrorBody());
                        Log.d("errror", "" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getMessage());
                        Log.d("error", "" + anError.getStackTrace());
                        Log.d("error", "" + anError.getCause());
                    }
                });
    }

    @SuppressLint("LongLogTag")
    public void _postForTracking(final String tag, String url, HashMap<String, String> bodyparameter, SessionManager sessionManager) throws Exception {
        Log.d(tag + " **Body API_S Posting parameter ==> ", "" + bodyparameter);
        Log.d(tag + " **Url API_S Url executed ==> ", "" + url);
        Log.d("" + tag, "" + sessionManager.getHeader());
        Log.d("" + tag, "locale:" + sessionManager.getLanguage());

        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(180, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .build();

        AndroidNetworking.post("" + url)
                .addBodyParameter(bodyparameter)
                .addHeaders(sessionManager.getHeader())
                .addHeaders("locale", "" + sessionManager.getLanguage())
                .setTag(this)
                .setOkHttpClient(okHttpClient)
                .setPriority(Priority.HIGH)
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                        Log.d(TAG, " timeTakenInMillis : " + timeTakenInMillis);
                        Log.d(TAG, " bytesSent : " + bytesSent);
                        Log.d(TAG, " bytesReceived : " + bytesReceived);
                        Log.d(TAG, " isFromCache : " + isFromCache);
                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(final JSONObject jsonObject) {
                        Log.d(tag + " **Response Response==> ", "" + jsonObject);
                        Log.d(tag + " **Response Response==> ", "" + jsonObject.toString().length());
                        ResultCheck resultCheck = SingletonGson.getInstance().fromJson("" + jsonObject, ResultCheck.class);
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        if (resultCheck.result.equals("0")) {
                            apifetcher.onFetchResultZero("" + resultCheck.message,tag);
                        } else {
                            apifetcher.onFetchComplete(jsonObject, tag);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
//                        apifetcher.onFetchResultZero("" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getErrorBody());
                        Log.d("errror", "" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getMessage());
                        Log.d("error", "" + anError.getStackTrace());
                        Log.d("error", "" + anError.getCause());
                    }
                });
    }


    @SuppressLint("LongLogTag")
    public void _post_image(final String tag, String url, HashMap<String, String> bodyparameter, HashMap<String, File> fileparams, SessionManager sessionManager) throws Exception {
        Log.d(tag + " **Body API_S Posting parameter ==> ", "" + bodyparameter);
        Log.d(tag + " **Url API_S Url executed ==> ", "" + url);
        Log.d("" + tag, "" + sessionManager.getHeader());
        Log.d("" + tag, "locale:" + sessionManager.getLanguage());
        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        AndroidNetworking.upload("" + url)
                .addMultipartFile(fileparams)
                .addQueryParameter(bodyparameter)
                .addHeaders(sessionManager.getHeader())
                .addHeaders("locale", "" + sessionManager.getLanguage()).setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                        Log.d(TAG, " timeTakenInMillis : " + timeTakenInMillis);
                        Log.d(TAG, " bytesSent : " + bytesSent);
                        Log.d(TAG, " bytesReceived : " + bytesReceived);
                        Log.d(TAG, " isFromCache : " + isFromCache);
                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(final JSONObject jsonObject) {
                        Log.d(tag + " **Response Response==> ", "" + jsonObject);
                        ResultCheck resultCheck = SingletonGson.getInstance().fromJson("" + jsonObject, ResultCheck.class);
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        if (resultCheck.result.equals("0")) {
                            apifetcher.onFetchResultZero("" + resultCheck.message,tag);
                        } else if (resultCheck.result.equals("999")) {
                            logoutUnAuthorizedDriver(sessionManager);  // Delete Driver from admin panel
                        } else {
                            apifetcher.onFetchComplete(jsonObject, tag);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        Log.d("errror", "" + anError.getErrorBody());
                        Log.d("errror", "" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getMessage());
                        Log.d("error", "" + anError.getStackTrace());
                        Log.d("error", "" + anError.getCause());
                    }
                });
    }

    @SuppressLint("LongLogTag")
    public void _getgoogleAPI(final String tag, String url) {
        Log.e(tag + " **Url API_S Url executed ==> ", "" + url);

        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        AndroidNetworking.get("" + url)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onResponse(final JSONObject jsonObject) {
                        Log.e(tag + " **Response Response==> ", "" + jsonObject);
                        ModelResultCheck modelResultCheck = SingletonGson.getInstance().fromJson("" + jsonObject, ModelResultCheck.class);
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        apifetcher.onFetchComplete(jsonObject, tag);

                    }

                    @Override
                    public void onError(ANError anError) {
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        if (anError.getErrorDetail().equals("connectionError")) {
                            apifetcher.onFetchResultZero("" + context.getResources().getString(R.string.no_internet_connection),tag);
                        }
                    }
                });
    }


    @SuppressLint("LongLogTag")
    public void _post_with_secretStrings(final String tag, String url, HashMap<String, String> bodyparameter) throws Exception {
        Log.d(tag + " **Body API_S Posting parameter ==> ", "" + bodyparameter);
        Log.d(tag + " **Url API_S Url executed ==> ", "" + url);
        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        AndroidNetworking.post("" + url)
                .addBodyParameter(bodyparameter)
                .addHeaders("locale", "" + new SessionManager(context).getLanguage())
                .addHeaders(Config.IntentKeys.PUBLIC_KEY, "" + BuildConfig.PUBLIC_KEY)
                .addHeaders(Config.IntentKeys.SECRET_KEY, "" + BuildConfig.SECRET_KEY)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                        Log.d(TAG, " timeTakenInMillis : " + timeTakenInMillis);
                        Log.d(TAG, " bytesSent : " + bytesSent);
                        Log.d(TAG, " bytesReceived : " + bytesReceived);
                        Log.d(TAG, " isFromCache : " + isFromCache);
                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(final JSONObject jsonObject) {
                        Log.d(tag + " **Response Response==> ", "" + jsonObject);
                        ResultCheckString resultCheck = SingletonGson.getInstance().fromJson("" + jsonObject, ResultCheckString.class);
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        if (resultCheck.result.equals("0")) {
                            apifetcher.onFetchResultZero("" + resultCheck.message,tag);
                        } else if (resultCheck.result.equals("999")) {
                            logoutUnAuthorizedDriver(sessionManager);   // Delete Driver from admin panel
                        } else {
                            apifetcher.onFetchComplete(jsonObject, tag);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        Log.d("errror", "" + anError.getErrorBody());
                        Log.d("errror", "" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getMessage());
                        Log.d("error", "" + anError.getStackTrace());
                        Log.d("error", "" + anError.getCause());
                    }
                });
    }


    @SuppressLint("LongLogTag")
    public void _post_with_secreteonly(final String tag, String url, HashMap<String, String> bodyparameter) throws Exception {
        Log.d(tag + " **Body API_S Posting parameter ==> ", "" + bodyparameter);
        Log.d(tag + " **Url API_S Url executed ==> ", "" + url);
        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);
        AndroidNetworking.post("" + url)
                .addBodyParameter(bodyparameter)
                .addHeaders("locale", "" + new SessionManager(context).getLanguage())
                .addHeaders(Config.IntentKeys.PUBLIC_KEY, "" + BuildConfig.PUBLIC_KEY)
                .addHeaders(Config.IntentKeys.SECRET_KEY, "" + BuildConfig.SECRET_KEY)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(final JSONObject jsonObject) {
                        Log.d(tag + " **Response Response==> ", "" + jsonObject);

                        try {
                            ResultCheck resultCheck = SingletonGson.getInstance().fromJson("" + jsonObject, ResultCheck.class);
                            apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                            if (resultCheck.result.equals("0")) {
                                apifetcher.onFetchResultZero("" + resultCheck.message,tag);
                            } else if (resultCheck.result.equals("999")) {
                                logoutUnAuthorizedDriver(sessionManager);   // Delete Driver from admin panel
                            } else {
                                apifetcher.onFetchComplete(jsonObject, tag);
                            }
                        }catch (Exception e){

                            Log.d("jhks",""+e.getMessage());

                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                        Log.d("errror", "" + anError.getErrorBody());
                        Log.d("errror", "" + anError.getErrorDetail());
                        Log.d("errror", "" + anError.getMessage());
                        Log.d("error", "" + anError.getStackTrace());
                        Log.d("error", "" + anError.getCause());
                    }
                });
    }

    @SuppressLint("LongLogTag")
    public void _post_image_with_secreteonly(final String tag, String url, HashMap<String, String> bodyparameter, HashMap<String, File> fileparams) throws Exception {
        Log.d(tag + " **Body API_S Posting parameter ==> ", "" + bodyparameter);
        Log.d(tag + " **Url API_S Url executed ==> ", "" + url);
        apifetcher.onAPIRunningState(KEY_API_IS_STARTED, tag);

        AndroidNetworking.upload("" + url)
                .addMultipartFile(fileparams)
                .addQueryParameter(bodyparameter)
                .addHeaders(Config.IntentKeys.PUBLIC_KEY, "" + BuildConfig.PUBLIC_KEY)
                .addHeaders(Config.IntentKeys.SECRET_KEY, "" + BuildConfig.SECRET_KEY)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .setAnalyticsListener((timeTakenInMillis, bytesSent, bytesReceived, isFromCache) -> {
                    Log.d(TAG, " timeTakenInMillis : " + timeTakenInMillis);
                    Log.d(TAG, " bytesSent : " + bytesSent);
                    Log.d(TAG, " bytesReceived : " + bytesReceived);
                    Log.d(TAG, " isFromCache : " + isFromCache);
                }).getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(final JSONObject jsonObject) {
                Log.d(tag + " **Response Response==> ", "" + jsonObject);
                ResultCheck resultCheck = SingletonGson.getInstance().fromJson("" + jsonObject, ResultCheck.class);
                apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                if (resultCheck.result.equals("0")) {
                    apifetcher.onFetchResultZero("" + resultCheck.message,tag);
                } else {
                    apifetcher.onFetchComplete(jsonObject, tag);
                }

            }

            @Override
            public void onError(ANError anError) {
                apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
                Log.d("errror", "" + anError.getErrorBody());
                Log.d("errror", "" + anError.getErrorDetail());
                Log.d("errror", "" + anError.getMessage());
                Log.d("error", "" + anError.getStackTrace());
                Log.d("error", "" + anError.getCause());
            }
        });

//                .getAsString(new StringRequestListener() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        JSONObject obj = null;
//
//                        try {
//                            obj = new JSONObject(response);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                        ResultCheck resultCheck = SingletonGson.getInstance().fromJson("" + obj, ResultCheck.class);
//                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
//                        if (resultCheck.result.equals("0")) {
//                            apifetcher.onFetchResultZero("" + resultCheck.message);
//                        } else {
//                            apifetcher.onFetchComplete(obj, tag);
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
//                        Log.d("errror", "" + anError.getErrorBody());
//                        Log.d("errror", "" + anError.getErrorDetail());
//                        Log.d("errror", "" + anError.getMessage());
//                        Log.d("error", "" + anError.getStackTrace());
//                        Log.d("error", "" + anError.getCause());
//                    }
//                });


//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(final JSONObject jsonObject) {
//                        Log.d(tag + " **Response Response==> ", "" + jsonObject);
//                        ResultCheck resultCheck = SingletonGson.getInstance().fromJson("" + jsonObject, ResultCheck.class);
//                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
//                        if (resultCheck.result.equals("0")) {
//                            apifetcher.onFetchResultZero("" + resultCheck.message);
//                        }
//                        else {
//                            apifetcher.onFetchComplete(jsonObject, tag);
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        apifetcher.onAPIRunningState(KEY_API_IS_STOPPED, tag);
//                        Log.d("errror", "" + anError.getErrorBody());
//                        Log.d("errror", "" + anError.getErrorDetail());
//                        Log.d("errror", "" + anError.getMessage());
//                        Log.d("error", "" + anError.getStackTrace());
//                        Log.d("error", "" + anError.getCause());
//                    }
//                });
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


    public void logoutUnAuthorizedDriver(SessionManager sessionManager) {
        sessionManager.logoutUser();
        sessionManager.clearAccessToken("");
        Intent intent = new Intent(context, SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
