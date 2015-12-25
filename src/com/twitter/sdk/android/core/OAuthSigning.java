// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import java.util.Map;
import o.uf;

// Referenced classes of package com.twitter.sdk.android.core:
//            TwitterAuthConfig, TwitterAuthToken

public class OAuthSigning
{

    static final String VERIFY_CREDENTIALS_URL = "https://api.twitter.com/1.1/account/verify_credentials.json";
    protected final TwitterAuthConfig authConfig;
    protected final TwitterAuthToken authToken;
    protected final OAuth1aHeaders oAuth1aHeaders;

    public OAuthSigning(TwitterAuthConfig twitterauthconfig, TwitterAuthToken twitterauthtoken)
    {
        this(twitterauthconfig, twitterauthtoken, new OAuth1aHeaders());
    }

    public OAuthSigning(TwitterAuthConfig twitterauthconfig, TwitterAuthToken twitterauthtoken, OAuth1aHeaders oauth1aheaders)
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

    public Map getOAuthEchoHeaders(String s, String s1, Map map)
    {
        return oAuth1aHeaders.getOAuthEchoHeaders(authConfig, authToken, null, s, s1, map);
    }

    public Map getOAuthEchoHeadersForVerifyCredentials()
    {
        return oAuth1aHeaders.getOAuthEchoHeaders(authConfig, authToken, null, uf.Tr.name(), "https://api.twitter.com/1.1/account/verify_credentials.json", null);
    }
}
