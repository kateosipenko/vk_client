package com.example.apiParameters;

import com.example.ApiConstants;
import com.loopj.android.http.RequestParams;

public class NewsfeedParameters extends RequestParameters {

    private int offset;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        offset = value;
    }

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
