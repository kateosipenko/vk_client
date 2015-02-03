package com.example.managers;

import com.example.User;
import com.example.core.VkRestClient;
import com.loopj.android.http.RequestParams;

public class UserManager extends ApiManager {

    public User getCurrentUser() {
        VkRestClient rest = new VkRestClient();
        RequestParams params = new RequestParams();
        return new User();
    }
}
