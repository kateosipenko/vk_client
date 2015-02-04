package com.vkclient.app.activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.vkclient.app.R;
import com.vkclient.app.activities.fragments.NewsFragment;

public class HomeActivity extends SlidingActivity {

    private NewsFragment mNewsFragment = new NewsFragment();

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.home);
        showNews();
    }

    private void showNews() {
        mNewsFragment.setArguments(getIntent().getExtras());
        FrameLayout container = (FrameLayout) findViewById(R.id.news_container);
        getSupportFragmentManager().beginTransaction().add(container.getId(), mNewsFragment, mNewsFragment.getTag()).commit();
    }

}
