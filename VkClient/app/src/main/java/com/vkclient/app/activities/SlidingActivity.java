package com.vkclient.app.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class SlidingActivity extends ActionBarActivity {

    protected SlidingMenu mSlidingMenu;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setupSlidingMenu();
    }

    private void setupSlidingMenu() {
        mSlidingMenu = new SlidingMenu(this);
        mSlidingMenu.setMode(SlidingMenu.LEFT);
        mSlidingMenu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        mSlidingMenu.setShadowDrawable(R.drawable.aslidingmenu_shadowgradient);
        mSlidingMenu.setShadowWidth(15);
        mSlidingMenu.setFadeDegree(0.0f);
        mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        mSlidingMenu.setBehindWidth(200);
//        mSlidingMenu.setMenu(R.layout.menu_frame);
    }

}
