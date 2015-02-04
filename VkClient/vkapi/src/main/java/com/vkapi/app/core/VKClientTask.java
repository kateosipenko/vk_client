package com.vkapi.app.core;

import android.os.AsyncTask;

import com.models.app.BaseModel;
import com.vkapi.app.ApiConstants;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

public class VKClientTask<T extends BaseModel> extends AsyncTask<ApiRequest, Void, Void> {

    private static AsyncHttpClient sWebClient = new AsyncHttpClient();

    private ApiRequest mApiRequest;

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
            mApiRequest.mResponse = ResponseParser.tryParseResponse(bytes, headers, mApiRequest.mResponseType);
            if (mApiRequest.mApiManagerCallback != null) {
                mApiRequest.mApiManagerCallback.onResponseGot(mApiRequest);
            }
        }
    };

    @Override
    protected Void doInBackground(ApiRequest... params) {
        // TODO: implement sending multiple apiRequests with api method execute
        mApiRequest = params[0];
        String url = ApiConstants.ServerUrl.concat(mApiRequest.mParameters.getApiMethod());
        sWebClient.post(url, mApiRequest.mParameters.getParams(), responseHandler);
        return null;
    }
}
