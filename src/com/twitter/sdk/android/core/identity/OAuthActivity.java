// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            OAuthController

public class OAuthActivity extends Activity
    implements OAuthController.Listener
{

    static final String EXTRA_AUTH_CONFIG = "auth_config";
    private static final String STATE_PROGRESS = "progress";
    OAuthController oAuthController;
    private ProgressBar spinner;
    private WebView webView;

    public OAuthActivity()
    {
    }

    public void onBackPressed()
    {
        oAuthController.handleAuthError(0, new TwitterAuthException("Authorization failed, request was canceled."));
    }

    public void onComplete(int i, Intent intent)
    {
        setResult(i, intent);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(com.twitter.sdk.android.core.R.layout.tw__activity_oauth);
        spinner = (ProgressBar)findViewById(com.twitter.sdk.android.core.R.id.tw__spinner);
        webView = (WebView)findViewById(com.twitter.sdk.android.core.R.id.tw__web_view);
        boolean flag;
        if (bundle != null)
        {
            flag = bundle.getBoolean("progress", false);
        } else
        {
            flag = true;
        }
        bundle = spinner;
        byte byte0;
        if (flag)
        {
            byte0 = 0;
        } else
        {
            byte0 = 8;
        }
        bundle.setVisibility(byte0);
        bundle = TwitterCore.getInstance();
        oAuthController = new OAuthController(spinner, webView, (TwitterAuthConfig)getIntent().getParcelableExtra("auth_config"), new OAuth1aService(bundle, bundle.getSSLSocketFactory(), new TwitterApi()), this);
        oAuthController.startAuth();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (spinner.getVisibility() == 0)
        {
            bundle.putBoolean("progress", true);
        }
        super.onSaveInstanceState(bundle);
    }
}
