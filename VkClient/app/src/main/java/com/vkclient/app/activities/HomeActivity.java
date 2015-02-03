package com.vkclient.app.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.models.app.Newsfeed;
import com.models.app.User;
import com.vkapi.app.core.ApiRequest;
import com.vkapi.app.core.IApiCallback;
import com.vkapi.app.managers.VkClient;
import com.vkclient.app.R;
import com.vkclient.app.utils.AppSettings;

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

        VkClient.instance().newsfeed().getNewsfeed(new IApiCallback<Newsfeed>() {
            @Override
            public void onResponseGot(ApiRequest<Newsfeed> request) {
                if (request.response != null) {

                }
            }
        });
    }

}