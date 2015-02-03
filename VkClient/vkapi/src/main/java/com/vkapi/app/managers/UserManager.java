package com.vkapi.app.managers;

import com.models.app.User;
import com.vkapi.app.core.VKClientTask;
import com.loopj.android.http.RequestParams;

public class UserManager extends ApiManager {

    public User getCurrentUser() {
        VKClientTask rest = new VKClientTask();
        RequestParams params = new RequestParams();
        return new User();
    }
}
