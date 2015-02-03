package com.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Newsfeed extends BaseModel {

    @SerializedName("items")
    public List<Object> items;

}
