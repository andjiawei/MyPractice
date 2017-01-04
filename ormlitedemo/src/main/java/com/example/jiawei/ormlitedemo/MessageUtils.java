package com.example.jiawei.ormlitedemo;

import android.content.Context;

import java.util.Locale;

/**
 * Created by QYer on 2016/7/13.
 */
public class MessageUtils {

    public static String getLocalMessageDB(Context context){

        Locale locale = context.getResources().getConfiguration().locale;

        String language = locale.getLanguage();

        if("en".equals(language)){
            return "chineselearn.db";
        }

        return "";
    }

}
