package com.vkclient.app.utils;

import com.models.app.NewsItem;
import com.vkclient.app.R;

public class TemplateFactory {

    public static int getNewsTemplate(NewsItem.NewsType type) {

        int layoutId = R.layout.news_item;

        switch (type) {
            case FRIEND:
                break;
            case PHOTO:
                break;
            case POST:
                break;
            case WALL_PHOTO:
                break;
            case PHOTO_TAG:
                break;
        }

        return layoutId;
    }

}
