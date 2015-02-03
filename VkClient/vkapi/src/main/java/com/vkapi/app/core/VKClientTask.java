package com.vkapi.app.core;

import android.os.AsyncTask;

import com.models.app.BaseModel;
import com.vkapi.app.ApiConstants;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

public class VKClientTask<T extends BaseModel> extends AsyncTask<ApiRequest, Void, Void> {

    private static AsyncHttpClient webClient = new AsyncHttpClient();

    private ApiRequest apiRequest;

    private AsyncHttpResponseHandler responseHandler = new AsyncHttpResponseHandler() {
        @Override
        public void onSuccess(int i, Header[] headers, byte[] bytes) {
            processResponse(headers, bytes);
        }

        @Override
        public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            // TODO: implement correct error handling
            processResponse(headers, bytes);
        }

        private void processResponse(Header[] headers, byte[] bytes) {
            apiRequest.response = ResponseParser.tryParseResponse(bytes, headers, apiRequest.responseType);
            if (apiRequest.apiManagerCallback != null) {
                apiRequest.apiManagerCallback.onResponseGot(apiRequest);
            }
        }
    };

    @Override
    protected Void doInBackground(ApiRequest... params) {
        // TODO: implement sending multiple apiRequests with api method execute
        apiRequest = params[0];
        String url = ApiConstants.ServerUrl.concat(apiRequest.parameters.getApiMethod());
        webClient.post(url, apiRequest.parameters.getParams(), responseHandler);
        return null;
    }
}
