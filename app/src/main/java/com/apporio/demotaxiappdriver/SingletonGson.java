package com.apporio.demotaxiappdriver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by lenovo-pc on 9/3/2017.
 */

public class SingletonGson {
    private static final Gson instance = new GsonBuilder().create();

    // Private constructor prevents instantiation from other classes
    private SingletonGson() {
    }

    public static Gson getInstance() {
        return instance;
    }

}
