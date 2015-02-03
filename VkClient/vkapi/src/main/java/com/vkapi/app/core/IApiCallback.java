package com.vkapi.app.core;

import com.models.app.BaseModel;

public interface IApiCallback <T extends BaseModel> {
    void onResponseGot(ApiRequest<T> request);
}
