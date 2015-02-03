package com.example.catherine.vkclient.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.example.User;
import com.example.catherine.vkclient.R;
import com.example.catherine.vkclient.utils.AppSettings;
import com.example.managers.VkClient;

public class HomeActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.home);
        User currentUser = new User();
        // TODO: remove fake. Implement storing user info in db in api project
        currentUser.setAccessToken(AppSettings.getInstance().getAccessToken());
        currentUser.setUserId(AppSettings.getInstance().getUserId());
        VkClient.instance().setCurrentUser(currentUser);

        VkClient.instance().newsfeed().getNewsfeed();
    }

}
