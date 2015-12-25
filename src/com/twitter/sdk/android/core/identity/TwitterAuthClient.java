// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;
import o.ra;
import o.rl;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            OAuthHandler, AuthState, SSOAuthHandler, ShareEmailActivity, 
//            ShareEmailResultReceiver, AuthHandler

public class TwitterAuthClient
{
    static class AuthStateLazyHolder
    {

        private static final AuthState INSTANCE = new AuthState();



        private AuthStateLazyHolder()
        {
        }
    }

    static class CallbackWrapper extends Callback
    {

        private final Callback callback;
        private final SessionManager sessionManager;

        public void failure(TwitterException twitterexception)
        {
            ra._mth0454()._mth02CB("Twitter", "Authorization completed with an error", twitterexception);
            callback.failure(twitterexception);
        }

        public void success(Result result)
        {
            ra._mth0454()._mth02BE("Twitter", "Authorization completed successfully");
            sessionManager.setActiveSession((Session)result.data);
            callback.success(result);
        }

        public CallbackWrapper(SessionManager sessionmanager, Callback callback1)
        {
            sessionManager = sessionmanager;
            callback = callback1;
        }
    }


    private static final String SCRIBE_ACTION = "impression";
    private static final String SCRIBE_CLIENT = "android";
    private static final String SCRIBE_COMPONENT = "";
    private static final String SCRIBE_ELEMENT = "";
    private static final String SCRIBE_LOGIN_PAGE = "login";
    private static final String SCRIBE_SECTION = "";
    private static final String SCRIBE_SHARE_EMAIL_PAGE = "shareemail";
    private final TwitterAuthConfig authConfig;
    final AuthState authState;
    private final Context context;
    final SessionManager sessionManager;

    public TwitterAuthClient()
    {
        this(TwitterCore.getInstance().getContext(), TwitterCore.getInstance().getAuthConfig(), TwitterCore.getInstance().getSessionManager(), AuthStateLazyHolder.INSTANCE);
    }

    TwitterAuthClient(Context context1, TwitterAuthConfig twitterauthconfig, SessionManager sessionmanager, AuthState authstate)
    {
        authState = authstate;
        context = context1;
        authConfig = twitterauthconfig;
        sessionManager = sessionmanager;
    }

    private boolean authorizeUsingOAuth(Activity activity, CallbackWrapper callbackwrapper)
    {
        ra._mth0454()._mth02BE("Twitter", "Using OAuth");
        return authState.beginAuthorize(activity, new OAuthHandler(authConfig, callbackwrapper, authConfig.getRequestCode()));
    }

    private boolean authorizeUsingSSO(Activity activity, CallbackWrapper callbackwrapper)
    {
        if (SSOAuthHandler.isAvailable(activity))
        {
            ra._mth0454()._mth02BE("Twitter", "Using SSO");
            return authState.beginAuthorize(activity, new SSOAuthHandler(authConfig, callbackwrapper, authConfig.getRequestCode()));
        } else
        {
            return false;
        }
    }

    private void handleAuthorize(Activity activity, Callback callback)
    {
        scribeAuthorizeImpression();
        callback = new CallbackWrapper(sessionManager, callback);
        if (!authorizeUsingSSO(activity, callback) && !authorizeUsingOAuth(activity, callback))
        {
            callback.failure(new TwitterAuthException("Authorize failed."));
        }
    }

    private void scribeAuthorizeImpression()
    {
        DefaultScribeClient defaultscribeclient = getScribeClient();
        if (defaultscribeclient == null)
        {
            return;
        } else
        {
            defaultscribeclient.scribeSyndicatedSdkImpressionEvents(new EventNamespace[] {
                (new com.twitter.sdk.android.core.internal.scribe.EventNamespace.Builder()).setClient("android").setPage("login").setSection("").setComponent("").setElement("").setAction("impression").builder()
            });
            return;
        }
    }

    private void scribeRequestEmail()
    {
        DefaultScribeClient defaultscribeclient = getScribeClient();
        if (defaultscribeclient == null)
        {
            return;
        } else
        {
            defaultscribeclient.scribeSyndicatedSdkImpressionEvents(new EventNamespace[] {
                (new com.twitter.sdk.android.core.internal.scribe.EventNamespace.Builder()).setClient("android").setPage("shareemail").setSection("").setComponent("").setElement("").setAction("impression").builder()
            });
            return;
        }
    }

    public void authorize(Activity activity, Callback callback)
    {
        if (activity == null)
        {
            throw new IllegalArgumentException("Activity must not be null.");
        }
        if (callback == null)
        {
            throw new IllegalArgumentException("Callback must not be null.");
        }
        if (activity.isFinishing())
        {
            ra._mth0454()._mth02CB("Twitter", "Cannot authorize, activity is finishing.", null);
            return;
        } else
        {
            handleAuthorize(activity, callback);
            return;
        }
    }

    public int getRequestCode()
    {
        return authConfig.getRequestCode();
    }

    protected DefaultScribeClient getScribeClient()
    {
        return TwitterCoreScribeClientHolder.getScribeClient();
    }

    Intent newShareEmailIntent(TwitterSession twittersession, Callback callback)
    {
        return (new Intent(context, com/twitter/sdk/android/core/identity/ShareEmailActivity)).setFlags(0x10000000).putExtra("session_id", twittersession.getId()).putExtra("result_receiver", new ShareEmailResultReceiver(callback));
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        ra._mth0454()._mth02BE("Twitter", (new StringBuilder("onActivityResult called with ")).append(i).append(" ").append(j).toString());
        if (!authState.isAuthorizeInProgress())
        {
            ra._mth0454()._mth02CB("Twitter", "Authorize not in progress", null);
            return;
        }
        AuthHandler authhandler = authState.getAuthHandler();
        if (authhandler != null && authhandler.handleOnActivityResult(i, j, intent))
        {
            authState.endAuthorize();
        }
    }

    public void requestEmail(TwitterSession twittersession, Callback callback)
    {
        if (twittersession == null)
        {
            throw new IllegalArgumentException("Session must not be null.");
        }
        if (callback == null)
        {
            throw new IllegalArgumentException("Callback must not be null.");
        } else
        {
            scribeRequestEmail();
            context.startActivity(newShareEmailIntent(twittersession, callback));
            return;
        }
    }
}
