package com.models.app;

import com.google.gson.annotations.SerializedName;

public class VkError {

    @SerializedName("error_code")
    public int code;

    @SerializedName("error_msg")
    public String message;
}
