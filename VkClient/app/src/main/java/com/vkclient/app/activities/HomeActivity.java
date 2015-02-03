package com.vkclient.app.activities;

import android.os.Bundle;

import com.vkclient.app.R;
import com.vkclient.app.activities.fragments.NewsFragment;

public class HomeActivity extends SlidingActivity {

    private NewsFragment news = new NewsFragment();

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.home);
        showNews();
    }

    private void showNews() {
        news.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(news, "TAG").commit();
    }

}
