package com.models.app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Newsfeed extends BaseModel {

    @SerializedName("items")
    public List<Object> items;

}
