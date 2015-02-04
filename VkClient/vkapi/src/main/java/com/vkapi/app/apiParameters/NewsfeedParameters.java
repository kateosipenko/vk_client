package com.vkapi.app.apiParameters;

import com.vkapi.app.ApiConstants;
import com.loopj.android.http.RequestParams;

public class NewsfeedParameters extends RequestParameters {

    public int mNextFrom;

    @Override
    public String getApiMethod() {
        return ApiConstants.Methods.NewsfeedGet;
    }

    @Override
    public RequestParams getParams() {
        RequestParams params = super.getParams();
        params.put(ApiConstants.Parameters.Count, 10);
        params.put(ApiConstants.Parameters.StartFrom, mNextFrom);
        return params;
    }

}
