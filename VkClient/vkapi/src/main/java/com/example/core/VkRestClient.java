package com.example.core;

import com.example.ApiConstants;
import com.example.apiParameters.RequestParameters;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
//import android.os.AsyncTask;

public class VkRestClient
//      extends  AsyncTask<String, String, String>
{

    private static AsyncHttpClient webClient = new AsyncHttpClient();

    public static void post(RequestParameters parameters, AsyncHttpResponseHandler handler) {
        String url = ApiConstants.ServerUrl.concat(parameters.getApiMethod());
        webClient.post(url, parameters.getParams(), handler);
    }


}
