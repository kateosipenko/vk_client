package com.vkclient.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.vkclient.app.R;
import com.vkclient.app.utils.AppSettings;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (AppSettings.getInstance().isAuthorized()) {
                    startHome();
                } else {
                    startLogin();
                }
            }
        }, 2000);
    }

    private void startHome() {
        startActivity(new Intent(this, HomeActivity.class));
        this.finish();
    }

    private void startLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        this.finish();
    }
}
