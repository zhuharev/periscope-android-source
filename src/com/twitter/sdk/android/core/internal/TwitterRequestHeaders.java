// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import android.text.TextUtils;
import com.twitter.sdk.android.core.AuthToken;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwitterRequestHeaders
{

    public static final String HEADER_USER_AGENT = "User-Agent";
    private final TwitterAuthConfig authConfig;
    private final String method;
    private final Map postParams;
    private final Session session;
    private final String url;
    private final String userAgent;

    public TwitterRequestHeaders(String s, String s1, TwitterAuthConfig twitterauthconfig, Session session1, String s2, Map map)
    {
        method = s;
        url = s1;
        authConfig = twitterauthconfig;
        session = session1;
        userAgent = s2;
        postParams = map;
    }

    public Map getAuthHeaders()
    {
        if (session != null && session.getAuthToken() != null)
        {
            return session.getAuthToken().getAuthHeaders(authConfig, getMethod(), url, getPostParams());
        } else
        {
            return Collections.emptyMap();
        }
    }

    protected Map getExtraHeaders()
    {
        return Collections.emptyMap();
    }

    public final Map getHeaders()
    {
        HashMap hashmap = new HashMap();
        hashmap.putAll(getExtraHeaders());
        if (!TextUtils.isEmpty(userAgent))
        {
            hashmap.put("User-Agent", userAgent);
        }
        hashmap.putAll(getAuthHeaders());
        return hashmap;
    }

    protected String getMethod()
    {
        return method;
    }

    protected Map getPostParams()
    {
        return postParams;
    }
}
