package com.vkapi.app.managers;

import com.google.gson.reflect.TypeToken;
import com.models.app.Group;
import com.models.app.NewsItem;
import com.models.app.Newsfeed;
import com.models.app.Profile;
import com.vkapi.app.apiParameters.NewsfeedParameters;
import com.vkapi.app.core.ApiRequest;
import com.vkapi.app.core.IApiCallback;
import com.vkapi.app.core.VKClientTask;
import com.vkapi.app.core.WebResponse;

import java.util.ArrayList;
import java.util.List;

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

    public List<NewsItem> processNews(Newsfeed feed) {

        // TODO: improve algorithm

        List<NewsItem> result = new ArrayList<>();
        for (NewsItem item : feed.items) {
            if (item.sourceId > 0) {
                for (Profile profile : feed.profiles) {
                    if (item.sourceId == profile.id) {
                        item.profile = profile;
                        break;
                    }
                }
            } else {
                long groupId = item.sourceId * -1;
                for (Group group : feed.groups) {
                    if (groupId == group.id) {
                        item.group = group;
                        break;
                    }
                }
            }

            result.add(item);
        }

        return result;
    }
}
