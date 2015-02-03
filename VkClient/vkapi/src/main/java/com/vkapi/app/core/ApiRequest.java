package com.vkapi.app.core;

import com.models.app.BaseModel;
import com.vkapi.app.apiParameters.RequestParameters;

import java.lang.reflect.Type;

public class ApiRequest<T extends BaseModel> {

    public RequestParameters parameters;

    public Type responseType;

    public IApiCallback apiManagerCallback;

    public IApiCallback callback;

    public WebResponse<T> response;
}
