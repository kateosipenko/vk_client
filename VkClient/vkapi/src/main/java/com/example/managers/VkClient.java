package com.example.managers;

import com.example.User;

public class VkClient {

    private static VkClient instance;

    private VkClient() {
        newsfeed = new NewsfeedManager();
    }

    public static VkClient instance() {
        if (instance == null) {
            synchronized (VkClient.class) {
                if(instance == null) {
                    instance = new VkClient();
                }
            }
        }

        return instance;
    }

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    // TODO: implement logic for storing current user in api project
    public void setCurrentUser(User user) {
        currentUser = user;
    }

    private NewsfeedManager newsfeed;

    public NewsfeedManager newsfeed() {
        return newsfeed;
    }

}
