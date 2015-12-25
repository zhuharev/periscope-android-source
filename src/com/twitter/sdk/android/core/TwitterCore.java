// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import android.app.Activity;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.internal.MigrationHelper;
import com.twitter.sdk.android.core.internal.SessionMonitor;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.TwitterSessionVerifier;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSocketFactory;
import o.ra;
import o.ri;
import o.rl;
import o.up;

// Referenced classes of package com.twitter.sdk.android.core:
//            TwitterPinningInfoProvider, SessionManager, TwitterApiClient, GuestAuthClient, 
//            PersistedSessionManager, TwitterAuthConfig, Session, Callback

public class TwitterCore extends ri
{

    static final String PREF_KEY_ACTIVE_APP_SESSION = "active_appsession";
    static final String PREF_KEY_ACTIVE_TWITTER_SESSION = "active_twittersession";
    static final String PREF_KEY_APP_SESSION = "appsession";
    static final String PREF_KEY_TWITTER_SESSION = "twittersession";
    static final String SESSION_PREF_FILE_NAME = "session_store";
    public static final String TAG = "Twitter";
    private final ConcurrentHashMap apiClients;
    SessionManager appSessionManager;
    private final TwitterAuthConfig authConfig;
    SessionMonitor sessionMonitor;
    private volatile SSLSocketFactory sslSocketFactory;
    SessionManager twitterSessionManager;

    public TwitterCore(TwitterAuthConfig twitterauthconfig)
    {
        authConfig = twitterauthconfig;
        apiClients = new ConcurrentHashMap();
    }

    TwitterCore(TwitterAuthConfig twitterauthconfig, ConcurrentHashMap concurrenthashmap)
    {
        authConfig = twitterauthconfig;
        apiClients = concurrenthashmap;
    }

    private static void checkInitialized()
    {
        if (ra._mth02BE(com/twitter/sdk/android/core/TwitterCore) == null)
        {
            throw new IllegalStateException("Must start Twitter Kit with Fabric.with() first");
        } else
        {
            return;
        }
    }

    private void createSSLSocketFactory()
    {
        this;
        JVM INSTR monitorenter ;
        SSLSocketFactory sslsocketfactory = sslSocketFactory;
        if (sslsocketfactory != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        sslSocketFactory = o._cls141D.if._mth02CA(new TwitterPinningInfoProvider(getContext()));
        ra._mth0454()._mth02BE("Twitter", "Custom SSL pinning enabled");
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        ra._mth0454()._mth02CB("Twitter", "Exception setting up custom SSL pinning", ((Exception) (obj)));
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    private Session getActiveSession()
    {
        Session session1 = twitterSessionManager.getActiveSession();
        Session session = session1;
        if (session1 == null)
        {
            session = appSessionManager.getActiveSession();
        }
        return session;
    }

    public static TwitterCore getInstance()
    {
        checkInitialized();
        return (TwitterCore)ra._mth02BE(com/twitter/sdk/android/core/TwitterCore);
    }

    private void initializeScribeClient()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(twitterSessionManager);
        arraylist.add(appSessionManager);
        TwitterCoreScribeClientHolder.initialize(this, arraylist, getIdManager());
    }

    protected Boolean doInBackground()
    {
        twitterSessionManager.getActiveSession();
        appSessionManager.getActiveSession();
        getSSLSocketFactory();
        initializeScribeClient();
        sessionMonitor.triggerVerificationIfNecessary();
        sessionMonitor.monitorActivityLifecycle(getFabric().QH);
        return Boolean.valueOf(true);
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    public TwitterApiClient getApiClient()
    {
        checkInitialized();
        Session session = getActiveSession();
        if (session == null)
        {
            throw new IllegalStateException("Must have valid session. Did you authenticate with Twitter?");
        } else
        {
            return getApiClient(session);
        }
    }

    public TwitterApiClient getApiClient(Session session)
    {
        checkInitialized();
        if (!apiClients.containsKey(session))
        {
            apiClients.putIfAbsent(session, new TwitterApiClient(session));
        }
        return (TwitterApiClient)apiClients.get(session);
    }

    public SessionManager getAppSessionManager()
    {
        checkInitialized();
        return appSessionManager;
    }

    public TwitterAuthConfig getAuthConfig()
    {
        return authConfig;
    }

    public String getIdentifier()
    {
        return "com.twitter.sdk.android:twitter-core";
    }

    public SSLSocketFactory getSSLSocketFactory()
    {
        checkInitialized();
        if (sslSocketFactory == null)
        {
            createSSLSocketFactory();
        }
        return sslSocketFactory;
    }

    public SessionManager getSessionManager()
    {
        checkInitialized();
        return twitterSessionManager;
    }

    public String getVersion()
    {
        return "1.5.0.78";
    }

    public void logIn(Activity activity, Callback callback)
    {
        checkInitialized();
        (new TwitterAuthClient()).authorize(activity, callback);
    }

    public void logInGuest(Callback callback)
    {
        checkInitialized();
        (new GuestAuthClient(new OAuth2Service(this, null, new TwitterApi()))).authorize(appSessionManager, callback);
    }

    public void logOut()
    {
        checkInitialized();
        SessionManager sessionmanager = getSessionManager();
        if (sessionmanager != null)
        {
            sessionmanager.clearActiveSession();
        }
    }

    protected boolean onPreExecute()
    {
        (new MigrationHelper()).migrateSessionStore(getContext(), getIdentifier(), (new StringBuilder()).append(getIdentifier()).append(":session_store").append(".xml").toString());
        twitterSessionManager = new PersistedSessionManager(new up(getContext(), "session_store"), new TwitterSession.Serializer(), "active_twittersession", "twittersession");
        sessionMonitor = new SessionMonitor(twitterSessionManager, getFabric().QF, new TwitterSessionVerifier());
        appSessionManager = new PersistedSessionManager(new up(getContext(), "session_store"), new AppSession.Serializer(), "active_appsession", "appsession");
        return true;
    }
}
