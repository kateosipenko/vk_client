package com.example;

import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("error_code")
    public int code;

    @SerializedName("error_msg")
    public String message;
}
