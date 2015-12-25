// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import java.util.Map;

// Referenced classes of package com.twitter.sdk.android.core.internal.oauth:
//            OAuth2Token

public class GuestAuthToken extends OAuth2Token
{

    private static final long EXPIRES_IN_MS = 0xa4cb80L;
    public static final String HEADER_GUEST_TOKEN = "x-guest-token";
    private final String guestToken;

    public GuestAuthToken(String s, String s1, String s2)
    {
        super(s, s1);
        guestToken = s2;
    }

    public GuestAuthToken(String s, String s1, String s2, long l)
    {
        super(s, s1, l);
        guestToken = s2;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        if (!super.equals(obj))
        {
            return false;
        }
        obj = (GuestAuthToken)obj;
        return guestToken == null ? ((GuestAuthToken) (obj)).guestToken == null : guestToken.equals(((GuestAuthToken) (obj)).guestToken);
    }

    public Map getAuthHeaders(TwitterAuthConfig twitterauthconfig, String s, String s1, Map map)
    {
        twitterauthconfig = super.getAuthHeaders(twitterauthconfig, s, s1, map);
        twitterauthconfig.put("x-guest-token", getGuestToken());
        return twitterauthconfig;
    }

    public String getGuestToken()
    {
        return guestToken;
    }

    public int hashCode()
    {
        int j = super.hashCode();
        int i;
        if (guestToken != null)
        {
            i = guestToken.hashCode();
        } else
        {
            i = 0;
        }
        return j * 31 + i;
    }

    public boolean isExpired()
    {
        return System.currentTimeMillis() >= createdAt + 0xa4cb80L;
    }
}
