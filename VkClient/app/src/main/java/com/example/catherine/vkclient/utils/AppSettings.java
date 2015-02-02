package com.example.catherine.vkclient.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ApiConstants;
import com.example.catherine.vkclient.VkApplication;

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

    public boolean isAuthorized() {
        String accessToken = getAccessToken();
        return accessToken != null && !accessToken.isEmpty();
    }

    public String getAccessToken() {
        return getString(ApiConstants.AccessToken);
    }

    public void saveAccessToken(String value) {
        saveString(ApiConstants.AccessToken, value);
    }

    public int getUserId() {
        return getInt(ApiConstants.UserId);
    }

    public void saveUserId(int userId) {
        saveInt(ApiConstants.UserId, userId);
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