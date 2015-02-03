package com.models.app;

public class User {

    private String accessToken;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        userId = value;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String value) {
        accessToken= value;
    }

}
