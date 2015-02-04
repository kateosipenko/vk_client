package com.vkapi.app.core;

import com.google.gson.annotations.SerializedName;
import com.models.app.BaseModel;
import com.models.app.VkError;

public class WebResponse<T extends BaseModel> {

    @SerializedName("response")
    public T response;

    @SerializedName("error")
    public VkError error;
}
