// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import java.util.Map;

public interface AuthHeaders
{

    public static final String HEADER_AUTHORIZATION = "Authorization";

    public abstract Map getAuthHeaders(TwitterAuthConfig twitterauthconfig, String s, String s1, Map map);
}
