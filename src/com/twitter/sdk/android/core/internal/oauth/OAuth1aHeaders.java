// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.twitter.sdk.android.core.internal.oauth:
//            OAuth1aParameters

public class OAuth1aHeaders
{

    public static final String HEADER_AUTH_CREDENTIALS = "X-Verify-Credentials-Authorization";
    public static final String HEADER_AUTH_SERVICE_PROVIDER = "X-Auth-Service-Provider";

    public OAuth1aHeaders()
    {
    }

    public String getAuthorizationHeader(TwitterAuthConfig twitterauthconfig, TwitterAuthToken twitterauthtoken, String s, String s1, String s2, Map map)
    {
        return getOAuth1aParameters(twitterauthconfig, twitterauthtoken, s, s1, s2, map).getAuthorizationHeader();
    }

    OAuth1aParameters getOAuth1aParameters(TwitterAuthConfig twitterauthconfig, TwitterAuthToken twitterauthtoken, String s, String s1, String s2, Map map)
    {
        return new OAuth1aParameters(twitterauthconfig, twitterauthtoken, s, s1, s2, map);
    }

    public Map getOAuthEchoHeaders(TwitterAuthConfig twitterauthconfig, TwitterAuthToken twitterauthtoken, String s, String s1, String s2, Map map)
    {
        HashMap hashmap = new HashMap(2);
        hashmap.put("X-Verify-Credentials-Authorization", getAuthorizationHeader(twitterauthconfig, twitterauthtoken, s, s1, s2, map));
        hashmap.put("X-Auth-Service-Provider", s2);
        return hashmap;
    }
}
