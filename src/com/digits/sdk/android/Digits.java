// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.PersistedSessionManager;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.MigrationHelper;
import com.twitter.sdk.android.core.internal.SessionMonitor;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import o.ra;
import o.ri;
import o.up;

// Referenced classes of package com.digits.sdk.android:
//            NoOpScribeService, DigitsClient, ContactsClient, DigitsSessionVerifier, 
//            ActivityClassManagerFactory, DigitsScribeServiceImp, ActivityClassManager, DigitsScribeService, 
//            AuthCallback, SessionListener

public class Digits extends ri
{

    private static final String KIT_SCRIBE_NAME = "Digits";
    static final String PREF_KEY_ACTIVE_SESSION = "active_session";
    static final String PREF_KEY_SESSION = "session";
    static final String SESSION_PREF_FILE_NAME = "session_store";
    public static final String TAG = "Digits";
    private ActivityClassManager activityClassManager;
    private volatile ContactsClient contactsClient;
    private volatile DigitsClient digitsClient;
    private DigitsSessionVerifier digitsSessionVerifier;
    private DigitsScribeService scribeService;
    private SessionManager sessionManager;
    private int themeResId;
    private SessionMonitor userSessionMonitor;

    public Digits()
    {
        scribeService = new NoOpScribeService();
    }

    public static void authenticate(AuthCallback authcallback)
    {
        authenticate(authcallback, 0);
    }

    public static void authenticate(AuthCallback authcallback, int i)
    {
        getInstance().setTheme(i);
        getInstance().getDigitsClient().startSignUp(authcallback);
    }

    public static void authenticate(AuthCallback authcallback, int i, String s)
    {
        getInstance().setTheme(i);
        getInstance().getDigitsClient().startSignUp(authcallback, s);
    }

    public static void authenticate(AuthCallback authcallback, String s)
    {
        authenticate(authcallback, 0, s);
    }

    private void createContactsClient()
    {
        this;
        JVM INSTR monitorenter ;
        if (contactsClient == null)
        {
            contactsClient = new ContactsClient();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void createDigitsClient()
    {
        this;
        JVM INSTR monitorenter ;
        if (digitsClient == null)
        {
            digitsClient = new DigitsClient();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static Digits getInstance()
    {
        return (Digits)ra._mth02BE(com/digits/sdk/android/Digits);
    }

    public static SessionManager getSessionManager()
    {
        return getInstance().sessionManager;
    }

    private DefaultScribeClient setUpScribing()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(sessionManager);
        return new DefaultScribeClient(this, "Digits", arraylist, getIdManager());
    }

    public void addSessionListener(SessionListener sessionlistener)
    {
        if (sessionlistener == null)
        {
            throw new NullPointerException("sessionListener must not be null");
        } else
        {
            digitsSessionVerifier.addSessionListener(sessionlistener);
            return;
        }
    }

    protected void createActivityClassManager()
    {
        activityClassManager = (new ActivityClassManagerFactory()).createActivityClassManager(getContext(), themeResId);
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    protected Void doInBackground()
    {
        sessionManager.getActiveSession();
        createDigitsClient();
        createContactsClient();
        scribeService = new DigitsScribeServiceImp(setUpScribing());
        userSessionMonitor = new SessionMonitor(getSessionManager(), getExecutorService(), digitsSessionVerifier);
        userSessionMonitor.triggerVerificationIfNecessary();
        userSessionMonitor.monitorActivityLifecycle(getFabric().QH);
        return null;
    }

    protected ActivityClassManager getActivityClassManager()
    {
        if (activityClassManager == null)
        {
            createActivityClassManager();
        }
        return activityClassManager;
    }

    public TwitterAuthConfig getAuthConfig()
    {
        return TwitterCore.getInstance().getAuthConfig();
    }

    public ContactsClient getContactsClient()
    {
        if (contactsClient == null)
        {
            createContactsClient();
        }
        return contactsClient;
    }

    DigitsClient getDigitsClient()
    {
        if (digitsClient == null)
        {
            createDigitsClient();
        }
        return digitsClient;
    }

    protected ExecutorService getExecutorService()
    {
        return getFabric().QF;
    }

    public String getIdentifier()
    {
        return "com.digits.sdk.android:digits";
    }

    protected DigitsScribeService getScribeService()
    {
        return scribeService;
    }

    int getTheme()
    {
        if (themeResId != 0)
        {
            return themeResId;
        } else
        {
            return R.style.Digits_default;
        }
    }

    public String getVersion()
    {
        return "1.8.0.78";
    }

    protected boolean onPreExecute()
    {
        (new MigrationHelper()).migrateSessionStore(getContext(), getIdentifier(), (new StringBuilder()).append(getIdentifier()).append(":session_store").append(".xml").toString());
        sessionManager = new PersistedSessionManager(new up(getContext(), "session_store"), new DigitsSession.Serializer(), "active_session", "session");
        digitsSessionVerifier = new DigitsSessionVerifier();
        return super.onPreExecute();
    }

    public void removeSessionListener(SessionListener sessionlistener)
    {
        if (sessionlistener == null)
        {
            throw new NullPointerException("sessionListener must not be null");
        } else
        {
            digitsSessionVerifier.removeSessionListener(sessionlistener);
            return;
        }
    }

    protected void setTheme(int i)
    {
        themeResId = i;
        createActivityClassManager();
    }
}
