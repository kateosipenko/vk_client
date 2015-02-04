package com.vkclient.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.models.app.User;
import com.vkapi.app.ApiConstants;
import com.vkapi.app.managers.VkClient;
import com.vkclient.app.R;
import com.vkclient.app.utils.AppSettings;

public class LoginActivity extends Activity {

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.login);
        final WebView webView = (WebView) findViewById(R.id.web_view);
        webView.loadUrl(ApiConstants.LoginUrl);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url.contains(ApiConstants.Parameters.AccessToken)) {
                    parseAccessToken(url);
                    clearCookie(webView);
                    startHome();
                }
            }
        });
    }

    private void clearCookie(WebView webView) {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(false);

        WebSettings ws = webView.getSettings();
        ws.setSaveFormData(false);
    }

    private void parseAccessToken(String url) {
        url = url.replace("#", "?");
        Uri uri = Uri.parse(url);
        String accessToken = uri.getQueryParameter(ApiConstants.Parameters.AccessToken);
        int userId = Integer.parseInt(uri.getQueryParameter(ApiConstants.Parameters.UserId));
        VkClient.instance().setAuthorizationData(accessToken, userId);
    }

    private void startHome() {
        startActivity(new Intent(this, HomeActivity.class));
        this.finish();
    }

}
