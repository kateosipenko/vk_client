package com.example.managers;

import com.example.*;
import com.example.apiParameters.NewsfeedParameters;
import com.example.core.ResponseParser;
import com.example.core.VkRestClient;
import com.example.core.WebResponse;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import java.lang.reflect.Type;

public class NewsfeedManager extends ApiManager {

    public void getNewsfeed() {
        NewsfeedParameters parameters = new NewsfeedParameters();
        VkRestClient.post(parameters, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                parseResponse(headers, bytes);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                parseResponse(headers, bytes);
            }

            private void parseResponse(Header[] headers, byte[] bytes) {
                Type type = new TypeToken<WebResponse<Newsfeed>>(){}.getType();
                WebResponse<Newsfeed> response = ResponseParser.tryParseResponse(bytes, headers, type);
                if (response != null) {

                }
            }
        });
    }
}
