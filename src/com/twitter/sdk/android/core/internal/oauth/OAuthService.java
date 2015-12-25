// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.DefaultClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import javax.net.ssl.SSLSocketFactory;
import retrofit.RestAdapter;

abstract class OAuthService
{

    private static final String CLIENT_NAME = "TwitterAndroidSDK";
    private final TwitterApi api;
    private final RestAdapter apiAdapter;
    private final SSLSocketFactory sslSocketFactory;
    private final TwitterCore twitterCore;
    private final String userAgent;

    public OAuthService(TwitterCore twittercore, SSLSocketFactory sslsocketfactory, TwitterApi twitterapi)
    {
        twitterCore = twittercore;
        sslSocketFactory = sslsocketfactory;
        api = twitterapi;
        userAgent = TwitterApi.buildUserAgent("TwitterAndroidSDK", twittercore.getVersion());
        apiAdapter = (new retrofit.RestAdapter.Builder()).setEndpoint(getApi().getBaseHostUrl()).setClient(new DefaultClient(sslSocketFactory)).setRequestInterceptor(new _cls1()).build();
    }

    protected TwitterApi getApi()
    {
        return api;
    }

    protected RestAdapter getApiAdapter()
    {
        return apiAdapter;
    }

    protected SSLSocketFactory getSSLSocketFactory()
    {
        return sslSocketFactory;
    }

    protected TwitterCore getTwitterCore()
    {
        return twitterCore;
    }

    protected String getUserAgent()
    {
        return userAgent;
    }

    private class _cls1
        implements RequestInterceptor
    {

        final OAuthService this$0;

        public void intercept(retrofit.RequestInterceptor.RequestFacade requestfacade)
        {
            requestfacade.addHeader("User-Agent", getUserAgent());
        }

        _cls1()
        {
            this$0 = OAuthService.this;
            super();
        }
    }

}
