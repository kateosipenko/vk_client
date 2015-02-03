package com.vkclient.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.models.app.NewsItem;
import com.vkclient.app.R;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends BaseAdapter {

    private List<NewsItem> news = new ArrayList<>();

    public void setNews(List<NewsItem> value) {
        news = value;
        notifyDataSetChanged();
        notifyDataSetInvalidated();
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int position) {
        return position >= 0 && position < news.size()
                ? news.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // TODO: implemented displaying news
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, null);
        }

        return convertView;
    }
}
