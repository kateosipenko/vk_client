package com.vkapi.app.apiParameters;

import com.vkapi.app.ApiConstants;
import com.vkapi.app.managers.VkClient;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;

public abstract class RequestParameters {

    public abstract String getApiMethod();

    public RequestParams getParams() {
        RequestParams params = new RequestParams();
        params.put(ApiConstants.Parameters.AccessToken, VkClient.instance().getCurrentUser().getAccessToken());
        params.put(ApiConstants.Parameters.ApiVersion, "5.28");
        return params;
    }
}
