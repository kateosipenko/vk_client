package com.vkapi.app.managers;

import android.os.AsyncTask;

import com.models.app.User;
import com.vkapi.app.ApiConstants;
import com.vkapi.app.storage.CacheProvider;

public class VkClient {

    private static VkClient sInstance;

    private VkClient() {
        mNewsfeed = new NewsfeedManager();

        // this operation should invoke in the ui thread
        // current user is needed for checking for authorization
        mCurrentUser = CacheProvider.readData(ApiConstants.CacheKeys.CurrentUser, User.class);
    }

    public static VkClient instance() {
        if (sInstance == null) {
            synchronized (VkClient.class) {
                if(sInstance == null) {
                    sInstance = new VkClient();
                }
            }
        }

        return sInstance;
    }

    private User mCurrentUser;

    public User getCurrentUser() {
        return mCurrentUser;
    }

    public void setAuthorizationData(String accessToken, int userId) {
        mCurrentUser = new User();
        mCurrentUser.mAccessToken = accessToken;
        mCurrentUser.mUserId = userId;

        AsyncTask<User, Void, Void> task = new AsyncTask<User, Void, Void>() {
            @Override
            protected Void doInBackground(User... params) {
                CacheProvider.writeData(ApiConstants.CacheKeys.CurrentUser, params[0]);
                return null;
            }
        };

        task.execute(mCurrentUser);
    }

    private NewsfeedManager mNewsfeed;

    public NewsfeedManager newsfeed() {
        return mNewsfeed;
    }

}
