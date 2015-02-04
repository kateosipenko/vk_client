package com.vkapi.app.core;

import com.models.app.BaseModel;
import com.vkapi.app.apiParameters.RequestParameters;

import java.lang.reflect.Type;

public class ApiRequest<T extends BaseModel> {

    public RequestParameters mParameters;

    public Type mResponseType;

    public IApiCallback mApiManagerCallback;

    public IApiCallback mCallback;

    public WebResponse<T> mResponse;
}
