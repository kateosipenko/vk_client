package com.models.app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Newsfeed extends BaseModel {

    @SerializedName("next_from")
    public String nextFrom;

    @SerializedName("items")
    public List<NewsItem> items;

    @SerializedName("profiles")
    public List<Profile> profiles;

    @SerializedName("groups")
    public List<Group> groups;

}
