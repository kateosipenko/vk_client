package com.models.app;

import com.google.gson.annotations.SerializedName;

public class NewsItem {

    @SerializedName("source_id")
    public long sourceId;

    @SerializedName("post_id")
    public long postId;

    @SerializedName("text")
    public String text;

    @SerializedName("type")
    public NewsType type;

    @SerializedName("date")
    public String date;

    @SerializedName("post_type")
    public PostType postType;

    public Group group;

    public Profile profile;

    public String getName() {
        String result = "";
        if (group != null) {
            result = group.screenName;
        } else if (profile != null) {
            result = profile.getUserName();
        }

        return result;
    }

    public String getPhotoMedium() {
        String result = "";
        if (group != null) {
            result = group.photo100;
        } else if (profile != null) {
            result = profile.photoMediumRec;
        }

        return result;
    }

    public enum PostType {
        @SerializedName("post")
        POST,
        @SerializedName("copy")
        COPY
    }

    public enum NewsType {
        @SerializedName("post")
        POST,
        @SerializedName("photo")
        PHOTO,
        @SerializedName("photo_tag")
        PHOTO_TAG,
        @SerializedName("wall_photo")
        WALL_PHOTO,
        @SerializedName("friend")
        FRIEND,
        @SerializedName("note")
        NOTE;
    }

}
