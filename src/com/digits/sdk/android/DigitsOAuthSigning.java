// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.net.Uri;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import o.uf;

public class DigitsOAuthSigning
{

    protected static final String VERIFY_CREDENTIALS_URL = "https://api.digits.com/1.1/sdk/account.json";
    protected final TwitterAuthConfig authConfig;
    protected final TwitterAuthToken authToken;
    protected final OAuth1aHeaders oAuth1aHeaders;

    public DigitsOAuthSigning(TwitterAuthConfig twitterauthconfig, TwitterAuthToken twitterauthtoken)
    {
        this(twitterauthconfig, twitterauthtoken, new OAuth1aHeaders());
    }

    DigitsOAuthSigning(TwitterAuthConfig twitterauthconfig, TwitterAuthToken twitterauthtoken, OAuth1aHeaders oauth1aheaders)
    {
        if (twitterauthconfig == null)
        {
            throw new IllegalArgumentException("authConfig must not be null");
        }
        if (twitterauthtoken == null)
        {
            throw new IllegalArgumentException("authToken must not be null");
        } else
        {
            authConfig = twitterauthconfig;
            authToken = twitterauthtoken;
            oAuth1aHeaders = oauth1aheaders;
            return;
        }
    }

    private String createProviderUrlWithQueryParams(Map map)
    {
        if (map == null)
        {
            return "https://api.digits.com/1.1/sdk/account.json";
        }
        android.net.Uri.Builder builder = Uri.parse("https://api.digits.com/1.1/sdk/account.json").buildUpon();
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); builder.appendQueryParameter(s, (String)map.get(s)))
        {
            s = (String)iterator.next();
        }

        return builder.toString();
    }

    public Map getOAuthEchoHeadersForVerifyCredentials()
    {
        return oAuth1aHeaders.getOAuthEchoHeaders(authConfig, authToken, null, uf.Tr.name(), "https://api.digits.com/1.1/sdk/account.json", null);
    }

    public Map getOAuthEchoHeadersForVerifyCredentials(Map map)
    {
        return oAuth1aHeaders.getOAuthEchoHeaders(authConfig, authToken, null, uf.Tr.name(), createProviderUrlWithQueryParams(map), null);
    }
}
