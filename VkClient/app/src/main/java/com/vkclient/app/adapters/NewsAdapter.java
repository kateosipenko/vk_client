package com.vkclient.app.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.models.app.NewsItem;
import com.vkclient.app.R;
import com.vkclient.app.utils.TemplateFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends BaseAdapter {

    private List<NewsItem> news = new ArrayList<>();
    private Handler mHandler = new Handler();

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
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder = null;
        NewsItem item = (NewsItem) getItem(position);
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, null);
            holder = new ViewHolder();
            holder.userImage = (ImageView) view.findViewById(R.id.user_icon);
            holder.templateContainer = (FrameLayout) view.findViewById(R.id.template);
            holder.userName = (TextView) view.findViewById(R.id.user_name);
            holder.layoutTemplateId = TemplateFactory.getNewsTemplate(item.type);
            holder.templateView = LayoutInflater.from(parent.getContext()).inflate(holder.layoutTemplateId, null);
            holder.templateContainer.addView(holder.templateView);
            holder.newsItem = item;
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // TODO: implement lazy images loading
        holder.userName.setText(item.getName());

        if (holder.bitmap == null) {
            AsyncTask<ViewHolder, Void, Void> task = new AsyncTask<ViewHolder, Void, Void>() {
                @Override
                protected Void doInBackground(ViewHolder... params) {
                    final ViewHolder viewHolder = params[0];
                    String url = viewHolder.newsItem.getPhotoMedium();
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    try {
                        HttpGet request = new HttpGet(url);
                        HttpResponse response = httpClient.execute(request);
                        InputStream stream = response.getEntity().getContent();
                        Bitmap bitmap = BitmapFactory.decodeStream(stream);
                        viewHolder.bitmap = bitmap;
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                viewHolder.userImage.setImageBitmap(viewHolder.bitmap);
                            }
                        });
                    } catch (IOException ex) {
                        Log.wtf(ex.getMessage(), ex);
                    }

                    return null;
                }
            };
            task.execute(holder);
        } else {
            holder.userImage.setImageBitmap(holder.bitmap);
        }

        return view;
    }

    static class ViewHolder {

        ImageView userImage;
        TextView userName;
        FrameLayout templateContainer;
        View templateView;
        int layoutTemplateId;
        Bitmap bitmap;
        NewsItem newsItem;
    }

}
