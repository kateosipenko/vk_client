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
import com.vkclient.app.utils.VkErrorHandler;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private final static String TAG = "news_fragment";

    private View mParentView;

    private List<NewsItem> mNews = new ArrayList<>();
    private NewsAdapter mAdapter = new NewsAdapter();
    private Handler mHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mParentView = inflater.inflate(R.layout.news_fragment, container, false);
        ListView list = (ListView) mParentView.findViewById(R.id.news_list);
        list.setAdapter(mAdapter);
        loadMoreNews();
        return mParentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mParentView != null) {
            ViewGroup parentViewGroup = (ViewGroup) mParentView.getParent();
            if (parentViewGroup != null) {
                parentViewGroup.removeAllViews();
            }
        }
    }

    private void loadMoreNews() {

        // TODO: implement infinite mNews loading
        VkClient.instance().newsfeed().getNewsfeed(new IApiCallback<Newsfeed>() {
            @Override
            public void onResponseGot(ApiRequest<Newsfeed> request) {
                if (request.mResponse != null && request.mResponse.response != null) {
                    List<NewsItem> result = VkClient.instance().newsfeed().processNews(request.mResponse.response);
                    mNews.addAll(result);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.setNews(mNews);
                        }
                    });
                } else {
                    VkErrorHandler.handleError(request.mResponse);
                }
            }
        });
    }
}
