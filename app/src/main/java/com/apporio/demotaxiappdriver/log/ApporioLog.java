package com.apporio.demotaxiappdriver.log;

import android.util.Log;


public class ApporioLog {

    public static void LOG_DEBUG(String tag, String message) {
        Log.d(tag, message);
    }


    public static void LOG_VERBOSE(String tag, String message) {
        Log.v(tag, message);
    }


    public static void LOG_ERROR(String tag, String message) {
        Log.e(tag, message);
    }


    public static void LOG_INFO(String tag, String message) {
        Log.i(tag, message);
    }


    public static void HYPER_LOG_DEBUG(String tag, String message) {
//        HyperLog.d(tag, message);
    }

    public static void HYPER_LOG_INFO(String tag, String message) {
//        HyperLog.i(tag, message);
    }

    public static void HYPER_LOG_ERROR(String tag, String message) {

//        HyperLog.e(tag, message);
    }

    public static void HYPER_LOG_VERBOSE(String tag, String message) {
//        HyperLog.v(tag, message);
    }

    public static void HYPER_LOG_WARNING(String tag, String message) {
//        HyperLog.w(tag, message);
    }

    public static void HYPER_LOG_ASSERT(String tag, String message) {
//        HyperLog.a(message);
    }

    public static void HYPER_LOG_EXCEPTION(String tag, Throwable message) {
//        HyperLog.exception(tag, "exception", message);
    }
}
