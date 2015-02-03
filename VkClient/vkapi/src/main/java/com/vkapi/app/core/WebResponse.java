package com.vkapi.app.core;

import com.google.gson.annotations.SerializedName;
import com.models.app.BaseModel;

public class WebResponse<T extends BaseModel> {

    @SerializedName("response")
    public T response;

    @SerializedName("error")
    public Error error;
}
