package com.example.core;

import com.example.*;
import com.example.Error;
import com.google.gson.annotations.SerializedName;

public class WebResponse<T extends BaseModel> {

    @SerializedName("response")
    public T response;

    @SerializedName("error")
    public Error error;
}
