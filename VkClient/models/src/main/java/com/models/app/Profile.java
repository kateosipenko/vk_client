package com.models.app;

import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("id")
    public long id;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("photo_medium_rec ")
    public String photoMediumRec;

    private String userName;

    public String getUserName() {
        if (userName == null || userName.isEmpty()) {
            userName = firstName.concat(" ").concat(lastName);
        }

        return userName;
    }

}
