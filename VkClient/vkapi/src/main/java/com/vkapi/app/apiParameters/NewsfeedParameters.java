package com.vkapi.app.apiParameters;

import com.google.gson.reflect.TypeToken;
import com.models.app.Newsfeed;
import com.vkapi.app.ApiConstants;
import com.loopj.android.http.RequestParams;
import com.vkapi.app.core.WebResponse;

import java.lang.reflect.Type;

public class NewsfeedParameters extends RequestParameters {

    public int offset;

    @Override
    public String getApiMethod() {
        return ApiConstants.Methods.NewsfeedGet;
    }

    @Override
    public RequestParams getParams() {
        RequestParams params = super.getParams();
        params.put(ApiConstants.Parameters.Count, 20);
        params.put(ApiConstants.Parameters.StartFrom, offset);
        return params;
    }

}
