// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

public abstract class AuthHandler
{

    static final String EXTRA_AUTH_ERROR = "auth_error";
    static final String EXTRA_SCREEN_NAME = "screen_name";
    static final String EXTRA_TOKEN = "tk";
    static final String EXTRA_TOKEN_SECRET = "ts";
    static final String EXTRA_USER_ID = "user_id";
    static final int RESULT_CODE_ERROR = 1;
    private final Callback callback;
    private final TwitterAuthConfig config;
    protected final int requestCode;

    AuthHandler(TwitterAuthConfig twitterauthconfig, Callback callback1, int i)
    {
        config = twitterauthconfig;
        callback = callback1;
        requestCode = i;
    }

    public abstract boolean authorize(Activity activity);

    TwitterAuthConfig getAuthConfig()
    {
        return config;
    }

    Callback getCallback()
    {
        return callback;
    }

    public boolean handleOnActivityResult(int i, int j, Intent intent)
    {
        if (requestCode != i)
        {
            return false;
        }
        Callback callback1 = getCallback();
        if (callback1 != null)
        {
            if (j == -1)
            {
                String s = intent.getStringExtra("tk");
                String s1 = intent.getStringExtra("ts");
                String s2 = intent.getStringExtra("screen_name");
                long l = intent.getLongExtra("user_id", 0L);
                callback1.success(new TwitterSession(new TwitterAuthToken(s, s1), l, s2), null);
            } else
            if (intent != null && intent.hasExtra("auth_error"))
            {
                callback1.failure((TwitterAuthException)intent.getSerializableExtra("auth_error"));
            } else
            {
                callback1.failure(new TwitterAuthException("Authorize failed."));
            }
        }
        return true;
    }
}
