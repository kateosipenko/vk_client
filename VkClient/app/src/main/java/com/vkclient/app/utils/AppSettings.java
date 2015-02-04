package com.vkclient.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.vkapi.app.ApiConstants;
import com.vkclient.app.VkApplication;

public class AppSettings {

    private final static String AppTag = "VkAppTag";

    private static AppSettings instance;

    private AppSettings() { }

    public static AppSettings getInstance() {
        if (instance == null) {
            synchronized (AppSettings.class) {
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }

        return instance;
    }

    private int getInt(String key) {
        return getPreferences().getInt(key, Integer.MAX_VALUE);
    }

    private void saveInt(String key, int value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private String getString(String key) {
        return getPreferences().getString(key, null);
    }

    private void saveString(String key, String value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }

    private SharedPreferences getPreferences() {
        return VkApplication.getContext().getSharedPreferences(AppTag, Context.MODE_PRIVATE);
    }

}
