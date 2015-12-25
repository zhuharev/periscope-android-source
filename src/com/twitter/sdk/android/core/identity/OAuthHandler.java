// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterAuthConfig;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            AuthHandler, OAuthActivity

class OAuthHandler extends AuthHandler
{

    public OAuthHandler(TwitterAuthConfig twitterauthconfig, Callback callback, int i)
    {
        super(twitterauthconfig, callback, i);
    }

    public boolean authorize(Activity activity)
    {
        activity.startActivityForResult(newIntent(activity), requestCode);
        return true;
    }

    Intent newIntent(Activity activity)
    {
        activity = new Intent(activity, com/twitter/sdk/android/core/identity/OAuthActivity);
        activity.putExtra("auth_config", getAuthConfig());
        return activity;
    }
}
