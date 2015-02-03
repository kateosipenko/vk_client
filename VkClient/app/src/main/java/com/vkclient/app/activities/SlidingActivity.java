package com.vkclient.app.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.vkclient.app.R;

public class SlidingActivity extends ActionBarActivity {

    protected SlidingMenu slidingMenu;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setupSlidingMenu();
    }

    private void setupSlidingMenu() {
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        slidingMenu.setShadowDrawable(R.drawable.aslidingmenu_shadowgradient);
        slidingMenu.setShadowWidth(15);
        slidingMenu.setFadeDegree(0.0f);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        slidingMenu.setBehindWidth(200);
//        slidingMenu.setMenu(R.layout.menu_frame);
    }

}
