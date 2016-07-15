package com.example.jiawei.picassodemo;

import android.app.Application;

import com.yolanda.nohttp.NoHttp;

/**
 * Created by QYer on 2016/7/15.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        NoHttp.initialize(this);

    }
}
