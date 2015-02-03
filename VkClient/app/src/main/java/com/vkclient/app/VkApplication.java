package com.vkclient.app;

import android.app.Application;
import android.content.Context;

public class VkApplication extends Application {

    private static Context context;

    // TODO: implement logic for getting actual context
    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        context = this;
    }
}
