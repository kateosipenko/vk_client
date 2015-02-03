package com.example.catherine.vkclient.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ApiConstants;
import com.example.catherine.vkclient.R;
import com.example.catherine.vkclient.utils.AppSettings;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.util.List;

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
        AppSettings.getInstance().saveAccessToken(uri.getQueryParameter(ApiConstants.Parameters.AccessToken));
        AppSettings.getInstance().saveUserId(Integer.parseInt(uri.getQueryParameter(ApiConstants.Parameters.UserId)));
    }

    private void startHome() {
        startActivity(new Intent(this, HomeActivity.class));
        this.finish();
    }

}
