package com.models.app;

import com.google.gson.annotations.SerializedName;

public class Group {

    @SerializedName("id")
    public long id;

    @SerializedName("name")
    public String name;

    @SerializedName("screen_name")
    public String screenName;

}
