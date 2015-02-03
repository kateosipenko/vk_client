package com.models.app;

import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("id")
    public long id;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

}
