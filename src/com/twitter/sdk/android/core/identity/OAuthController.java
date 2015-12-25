// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import o.ra;
import o.rl;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            WebViewException

class OAuthController
    implements OAuthWebViewClient.Listener
{
    static interface Listener
    {

        public abstract void onComplete(int i, Intent intent);
    }


    private final TwitterAuthConfig authConfig;
    final Listener listener;
    private final OAuth1aService oAuth1aService;
    TwitterAuthToken requestToken;
    private final ProgressBar spinner;
    private final WebView webView;

    OAuthController(ProgressBar progressbar, WebView webview, TwitterAuthConfig twitterauthconfig, OAuth1aService oauth1aservice, Listener listener1)
    {
        spinner = progressbar;
        webView = webview;
        authConfig = twitterauthconfig;
        oAuth1aService = oauth1aservice;
        listener = listener1;
    }

    private void dismissSpinner()
    {
        spinner.setVisibility(8);
    }

    private void dismissWebView()
    {
        webView.stopLoading();
        dismissSpinner();
    }

    private void handleWebViewError(WebViewException webviewexception)
    {
        ra._mth0454()._mth02CB("Twitter", "OAuth web view completed with an error", webviewexception);
        handleAuthError(1, new TwitterAuthException("OAuth web view completed with an error"));
    }

    private void handleWebViewSuccess(Bundle bundle)
    {
        ra._mth0454()._mth02BE("Twitter", "OAuth web view completed successfully");
        if (bundle != null)
        {
            String s = bundle.getString("oauth_verifier");
            if (s != null)
            {
                ra._mth0454()._mth02BE("Twitter", "Converting the request token to an access token.");
                oAuth1aService.requestAccessToken(newRequestAccessTokenCallback(), requestToken, s);
                return;
            }
        }
        ra._mth0454()._mth02CB("Twitter", (new StringBuilder("Failed to get authorization, bundle incomplete ")).append(bundle).toString(), null);
        handleAuthError(1, new TwitterAuthException("Failed to get authorization, bundle incomplete"));
    }

    protected void handleAuthError(int i, TwitterAuthException twitterauthexception)
    {
        Intent intent = new Intent();
        intent.putExtra("auth_error", twitterauthexception);
        listener.onComplete(i, intent);
    }

    Callback newRequestAccessTokenCallback()
    {
        return new _cls2();
    }

    Callback newRequestTempTokenCallback()
    {
        return new _cls1();
    }

    public void onError(WebViewException webviewexception)
    {
        handleWebViewError(webviewexception);
        dismissWebView();
    }

    public void onPageFinished(WebView webview, String s)
    {
        dismissSpinner();
        webview.setVisibility(0);
    }

    public void onSuccess(Bundle bundle)
    {
        handleWebViewSuccess(bundle);
        dismissWebView();
    }

    void setUpWebView(WebView webview, WebViewClient webviewclient, String s, WebChromeClient webchromeclient)
    {
        WebSettings websettings = webview.getSettings();
        websettings.setAllowFileAccess(false);
        websettings.setJavaScriptEnabled(false);
        websettings.setSaveFormData(false);
        webview.setVerticalScrollBarEnabled(false);
        webview.setHorizontalScrollBarEnabled(false);
        webview.setWebViewClient(webviewclient);
        webview.loadUrl(s);
        webview.setVisibility(4);
        webview.setWebChromeClient(webchromeclient);
    }

    void startAuth()
    {
        ra._mth0454()._mth02BE("Twitter", "Obtaining request token to start the sign in flow");
        oAuth1aService.requestTempToken(newRequestTempTokenCallback());
    }




    private class _cls2 extends Callback
    {

        final OAuthController this$0;

        public void failure(TwitterException twitterexception)
        {
            ra._mth0454()._mth02CB("Twitter", "Failed to get access token", twitterexception);
            handleAuthError(1, new TwitterAuthException("Failed to get access token"));
        }

        public void success(Result result)
        {
            Intent intent = new Intent();
            result = (OAuthResponse)result.data;
            intent.putExtra("screen_name", ((OAuthResponse) (result)).userName);
            intent.putExtra("user_id", ((OAuthResponse) (result)).userId);
            intent.putExtra("tk", ((OAuthResponse) (result)).authToken.token);
            intent.putExtra("ts", ((OAuthResponse) (result)).authToken.secret);
            listener.onComplete(-1, intent);
        }

        _cls2()
        {
            this$0 = OAuthController.this;
            super();
        }
    }


    private class _cls1 extends Callback
    {

        final OAuthController this$0;

        public void failure(TwitterException twitterexception)
        {
            ra._mth0454()._mth02CB("Twitter", "Failed to get request token", twitterexception);
            handleAuthError(1, new TwitterAuthException("Failed to get request token"));
        }

        public void success(Result result)
        {
            requestToken = ((OAuthResponse)result.data).authToken;
            result = oAuth1aService.getAuthorizeUrl(requestToken);
            ra._mth0454()._mth02BE("Twitter", "Redirecting user to web view to complete authorization flow");
            setUpWebView(webView, new OAuthWebViewClient(oAuth1aService.buildCallbackUrl(authConfig), OAuthController.this), result, new OAuthWebChromeClient());
        }

        _cls1()
        {
            this$0 = OAuthController.this;
            super();
        }
    }

}
