package com.example.apiParameters;

import com.example.ApiConstants;
import com.example.managers.VkClient;
import com.loopj.android.http.RequestParams;

public abstract class RequestParameters {

    public abstract String getApiMethod();

    public RequestParams getParams() {
        RequestParams params = new RequestParams();
        params.put(ApiConstants.Parameters.AccessToken, VkClient.instance().getCurrentUser().getAccessToken());
        params.put(ApiConstants.Parameters.ApiVersion, "5.28");
        return params;
    }
}
