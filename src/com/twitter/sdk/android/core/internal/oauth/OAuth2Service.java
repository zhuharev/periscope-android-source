// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import javax.net.ssl.SSLSocketFactory;
import retrofit.RestAdapter;

// Referenced classes of package com.twitter.sdk.android.core.internal.oauth:
//            OAuthService, OAuth2Token

public class OAuth2Service extends OAuthService
{
    static interface OAuth2Api
    {

        public abstract void getAppAuthToken(String s, String s1, Callback callback);

        public abstract void getGuestToken(String s, Callback callback);
    }


    OAuth2Api api;

    public OAuth2Service(TwitterCore twittercore, SSLSocketFactory sslsocketfactory, TwitterApi twitterapi)
    {
        super(twittercore, sslsocketfactory, twitterapi);
        api = (OAuth2Api)getApiAdapter().create(com/twitter/sdk/android/core/internal/oauth/OAuth2Service$OAuth2Api);
    }

    private String getAuthHeader()
    {
        TwitterAuthConfig twitterauthconfig = getTwitterCore().getAuthConfig();
        return (new StringBuilder("Basic ")).append(o.ug.if.encode((new StringBuilder()).append(o._cls141D.if._mth02CF(twitterauthconfig.getConsumerKey())).append(":").append(o._cls141D.if._mth02CF(twitterauthconfig.getConsumerSecret())).toString())).toString();
    }

    public static String getAuthorizationHeader(OAuth2Token oauth2token)
    {
        return (new StringBuilder("Bearer ")).append(oauth2token.getAccessToken()).toString();
    }

    public void requestAppAuthToken(Callback callback)
    {
        api.getAppAuthToken(getAuthHeader(), "client_credentials", callback);
    }

    public void requestGuestAuthToken(final Callback callback)
    {
        requestAppAuthToken(new _cls1());
    }

    public void requestGuestToken(Callback callback, OAuth2Token oauth2token)
    {
        api.getGuestToken(getAuthorizationHeader(oauth2token), callback);
    }

    private class _cls1 extends Callback
    {

        final OAuth2Service this$0;
        final Callback val$callback;

        public void failure(TwitterException twitterexception)
        {
            ra._mth0454()._mth02CB("Twitter", "Failed to get app auth token", twitterexception);
            if (callback != null)
            {
                callback.failure(twitterexception);
            }
        }

        public void success(final Result appAuthToken)
        {
            appAuthToken = (OAuth2Token)appAuthToken.data;
            class _cls1 extends Callback
            {

                final _cls1 this$1;
                final OAuth2Token val$appAuthToken;

                public void failure(TwitterException twitterexception)
                {
                    ra._mth0454()._mth02CB("Twitter", "Your app may not allow guest auth. Please talk to us regarding upgrading your consumer key.", twitterexception);
                    callback.failure(twitterexception);
                }

                public void success(Result result)
                {
                    result = new GuestAuthToken(appAuthToken.getTokenType(), appAuthToken.getAccessToken(), ((GuestTokenResponse)result.data).guestToken);
                    callback.success(new Result(result, null));
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    appAuthToken = oauth2token;
                    super();
                }
            }

            _cls1 _lcls1 = new _cls1();
            requestGuestToken(_lcls1, appAuthToken);
        }

        _cls1()
        {
            this$0 = OAuth2Service.this;
            callback = callback1;
            super();
        }
    }

}
