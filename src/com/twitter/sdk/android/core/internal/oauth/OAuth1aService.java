// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import android.net.Uri;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;
import o.uf;
import retrofit.RestAdapter;

// Referenced classes of package com.twitter.sdk.android.core.internal.oauth:
//            OAuthService, OAuthResponse, OAuth1aHeaders

public class OAuth1aService extends OAuthService
{
    static interface OAuthApi
    {

        public abstract void getAccessToken(String s, String s1, Callback callback);

        public abstract void getTempToken(String s, Callback callback);
    }


    private static final String CALLBACK_URL = "twittersdk://callback";
    private static final String PARAM_SCREEN_NAME = "screen_name";
    private static final String PARAM_USER_ID = "user_id";
    private static final String RESOURCE_OAUTH = "oauth";
    OAuthApi api;

    public OAuth1aService(TwitterCore twittercore, SSLSocketFactory sslsocketfactory, TwitterApi twitterapi)
    {
        super(twittercore, sslsocketfactory, twitterapi);
        api = (OAuthApi)getApiAdapter().create(com/twitter/sdk/android/core/internal/oauth/OAuth1aService$OAuthApi);
    }

    public static OAuthResponse parseAuthResponse(String s)
    {
        s = o._cls141D.if._mth02CA(s, false);
        String s1 = (String)s.get("oauth_token");
        String s2 = (String)s.get("oauth_token_secret");
        String s3 = (String)s.get("screen_name");
        long l;
        if (s.containsKey("user_id"))
        {
            l = Long.parseLong((String)s.get("user_id"));
        } else
        {
            l = 0L;
        }
        if (s1 == null || s2 == null)
        {
            return null;
        } else
        {
            return new OAuthResponse(new TwitterAuthToken(s1, s2), s3, l);
        }
    }

    public static void signRequest(TwitterAuthConfig twitterauthconfig, TwitterAuthToken twitterauthtoken, HttpURLConnection httpurlconnection, Map map)
    {
        httpurlconnection.setRequestProperty("Authorization", (new OAuth1aHeaders()).getAuthorizationHeader(twitterauthconfig, twitterauthtoken, null, uf.valueOf(httpurlconnection.getRequestMethod()).name(), httpurlconnection.getURL().toString(), map));
    }

    public String buildCallbackUrl(TwitterAuthConfig twitterauthconfig)
    {
        return Uri.parse("twittersdk://callback").buildUpon().appendQueryParameter("version", getTwitterCore().getVersion()).appendQueryParameter("app", twitterauthconfig.getConsumerKey()).build().toString();
    }

    String getAccessTokenUrl()
    {
        return (new StringBuilder()).append(getApi().getBaseHostUrl()).append("/oauth/access_token").toString();
    }

    public String getAuthorizeUrl(TwitterAuthToken twitterauthtoken)
    {
        return getApi().buildUponBaseHostUrl(new String[] {
            "oauth", "authorize"
        }).appendQueryParameter("oauth_token", twitterauthtoken.token).build().toString();
    }

    Callback getCallbackWrapper(final Callback callback)
    {
        return new _cls1();
    }

    String getTempTokenUrl()
    {
        return (new StringBuilder()).append(getApi().getBaseHostUrl()).append("/oauth/request_token").toString();
    }

    public void requestAccessToken(Callback callback, TwitterAuthToken twitterauthtoken, String s)
    {
        String s1 = getAccessTokenUrl();
        twitterauthtoken = (new OAuth1aHeaders()).getAuthorizationHeader(getTwitterCore().getAuthConfig(), twitterauthtoken, null, "POST", s1, null);
        api.getAccessToken(twitterauthtoken, s, getCallbackWrapper(callback));
    }

    public void requestTempToken(Callback callback)
    {
        TwitterAuthConfig twitterauthconfig = getTwitterCore().getAuthConfig();
        String s = getTempTokenUrl();
        api.getTempToken((new OAuth1aHeaders()).getAuthorizationHeader(twitterauthconfig, null, buildCallbackUrl(twitterauthconfig), "POST", s, null), getCallbackWrapper(callback));
    }

    private class _cls1 extends Callback
    {

        final OAuth1aService this$0;
        final Callback val$callback;

        public void failure(TwitterException twitterexception)
        {
            callback.failure(twitterexception);
        }

        public void success(Result result)
        {
            Object obj;
            StringBuilder stringbuilder;
            obj = null;
            stringbuilder = new StringBuilder();
            result = new BufferedReader(new InputStreamReader(((Response)result.data).getBody().in()));
_L2:
            obj = result;
            String s = result.readLine();
            if (s == null)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = result;
            stringbuilder.append(s);
            if (true) goto _L2; else goto _L1
_L1:
            result.close();
            break MISSING_BLOCK_LABEL_83;
            result;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            ((BufferedReader) (obj)).close();
            throw result;
            result = stringbuilder.toString();
            obj = OAuth1aService.parseAuthResponse(result);
            if (obj == null)
            {
                try
                {
                    callback.failure(new TwitterAuthException((new StringBuilder("Failed to parse auth response: ")).append(result).toString()));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Result result)
                {
                    callback.failure(new TwitterAuthException(result.getMessage(), result));
                }
                break MISSING_BLOCK_LABEL_165;
            }
            callback.success(new Result(obj, null));
            return;
        }

        _cls1()
        {
            this$0 = OAuth1aService.this;
            callback = callback1;
            super();
        }
    }

}
