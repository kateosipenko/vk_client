package com.vkclient.app.activities.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.models.app.NewsItem;
import com.models.app.Newsfeed;
import com.models.app.User;
import com.vkapi.app.core.ApiRequest;
import com.vkapi.app.core.IApiCallback;
import com.vkapi.app.managers.VkClient;
import com.vkclient.app.R;
import com.vkclient.app.adapters.NewsAdapter;
import com.vkclient.app.utils.AppSettings;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private List<NewsItem> news = new ArrayList<>();
    private NewsAdapter adapter = new NewsAdapter();
    private Handler handler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.news_fragment, container);
        ListView list = (ListView) view.findViewById(R.id.news_list);
        list.setAdapter(adapter);
        loadMoreNews();
        return view;
    }

    private void loadMoreNews() {
        User currentUser = new User();
        // TODO: remove fake. Implement storing user info in db in api project
        currentUser.setAccessToken(AppSettings.getInstance().getAccessToken());
        currentUser.setUserId(AppSettings.getInstance().getUserId());
        VkClient.instance().setCurrentUser(currentUser);

        // TODO: implement infinite news loading
        VkClient.instance().newsfeed().getNewsfeed(new IApiCallback<Newsfeed>() {
            @Override
            public void onResponseGot(ApiRequest<Newsfeed> request) {
                if (request.response != null) {
                    List<NewsItem> result = VkClient.instance().newsfeed().processNews(request.response.response);
                    news.addAll(result);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            adapter.setNews(news);
                        }
                    });
                }
            }
        });
    }

}
