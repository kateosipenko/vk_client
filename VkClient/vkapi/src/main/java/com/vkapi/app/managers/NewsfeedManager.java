package com.vkapi.app.managers;

import com.google.gson.reflect.TypeToken;
import com.models.app.Newsfeed;
import com.vkapi.app.apiParameters.NewsfeedParameters;
import com.vkapi.app.core.ApiRequest;
import com.vkapi.app.core.IApiCallback;
import com.vkapi.app.core.VKClientTask;
import com.vkapi.app.core.WebResponse;

public class NewsfeedManager extends ApiManager {

    public void getNewsfeed(IApiCallback callback) {

        ApiRequest<Newsfeed> request = new ApiRequest<>();
        request.parameters = new NewsfeedParameters();
        request.callback = callback;
        request.responseType = new TypeToken<WebResponse<Newsfeed>>(){}.getType();
        request.apiManagerCallback = new IApiCallback() {
            @Override
            public void onResponseGot(ApiRequest request) {
                // TODO: implement logic for caching data
                if (request.callback != null) {
                    request.callback.onResponseGot(request);
                }
            }
        };

        VKClientTask<Newsfeed> task = new VKClientTask<>();
        task.execute(request);
    }
}
