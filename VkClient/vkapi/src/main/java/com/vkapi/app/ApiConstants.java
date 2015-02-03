package com.vkapi.app;

public class ApiConstants {

    public static final String ServerUrl = "https://api.vk.com/method/";

    public static final String LoginUrl = "https://oauth.vk.com/authorize?" +
            "client_id=4762081&" +
            "scope=wall,friends&" +
            "redirect_uri=https://oauth.vk.com/blank.html&" +
            "display=mobile&" +
            "v=5.28&" +
            "response_type=token";

    public class Parameters {

        public static final String AccessToken = "access_token";
        public static final String UserId = "user_id";
        public static final String Count = "count";
        public static final String StartFrom = "start_from";
        public static final String ApiVersion = "v";
    }

    public class Methods {
        public static final String NewsfeedGet = "newsfeed.get";
    }
}
