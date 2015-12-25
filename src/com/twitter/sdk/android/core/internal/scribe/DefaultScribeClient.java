// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterCore;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import o.hy;
import o.ig;
import o.im;
import o.ra;
import o.ri;
import o.rr;
import o.si;
import o.ut;
import o.ve;
import o.vh;

// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            ScribeClient, ScribeConfig, SyndicatedSdkImpressionEvent, ScribeEvent, 
//            EventNamespace

public class DefaultScribeClient extends ScribeClient
{

    private static final String DEBUG_BUILD = "debug";
    private static final String SCRIBE_PATH_TYPE = "sdk";
    private static final String SCRIBE_PATH_VERSION = "i";
    private static final String SCRIBE_URL = "https://syndication.twitter.com";
    private static volatile ScheduledExecutorService executor;
    private final String advertisingId;
    private final ri kit;
    private final List sessionManagers;

    public DefaultScribeClient(ri ri1, String s, List list, si si1)
    {
        this(ri1, s, getGson(), list, si1);
    }

    public DefaultScribeClient(ri ri1, String s, ig ig, List list, si si1)
    {
        super(ri1, getExecutor(), getScribeConfig(o.ve.if._mth2148()._mth1F3B(), getUserAgent(s, ri1)), new ScribeEvent.Transform(ig), TwitterCore.getInstance().getAuthConfig(), list, TwitterCore.getInstance().getSSLSocketFactory(), si1);
        sessionManagers = list;
        kit = ri1;
        s = null;
        ri1 = s;
        if (si1.RW)
        {
            ig = si1._mth0646();
            ri1 = s;
            if (ig != null)
            {
                ri1 = ((rr) (ig)).advertisingId;
            }
        }
        advertisingId = ri1;
    }

    private static ScheduledExecutorService getExecutor()
    {
        if (executor != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        com/twitter/sdk/android/core/internal/scribe/DefaultScribeClient;
        JVM INSTR monitorenter ;
        if (executor == null)
        {
            executor = o._cls141D.if._mth02CA("scribe");
        }
        com/twitter/sdk/android/core/internal/scribe/DefaultScribeClient;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_35;
        Exception exception;
        exception;
        throw exception;
        return executor;
    }

    private static ig getGson()
    {
        im im1 = new im();
        im1.Gt = hy.Gc;
        return im1._mth0490();
    }

    static ScribeConfig getScribeConfig(vh vh1, String s)
    {
        int i;
        int j;
        if (vh1 != null && vh1.sW != null)
        {
            i = vh1.sW.Ua;
            j = vh1.sW.TX;
        } else
        {
            i = 100;
            j = 600;
        }
        vh1 = getScribeUrl("https://syndication.twitter.com", "");
        return new ScribeConfig(isEnabled(), vh1, "i", "sdk", "", s, i, j);
    }

    static String getScribeUrl(String s, String s1)
    {
        if (!TextUtils.isEmpty(s1))
        {
            return s1;
        } else
        {
            return s;
        }
    }

    static String getUserAgent(String s, ri ri1)
    {
        StringBuilder stringbuilder = new StringBuilder("Fabric/");
        ri1.getFabric();
        return stringbuilder.append(ra.getVersion()).append(" (Android ").append(android.os.Build.VERSION.SDK_INT).append(") ").append(s).append("/").append(ri1.getVersion()).toString();
    }

    private static boolean isEnabled()
    {
        return !"release".equals("debug");
    }

    Session getActiveSession()
    {
        Session session = null;
        Iterator iterator = sessionManagers.iterator();
        Session session1;
        do
        {
            session1 = session;
            if (!iterator.hasNext())
            {
                break;
            }
            session = ((SessionManager)iterator.next()).getActiveSession();
            session1 = session;
        } while (session == null);
        return session1;
    }

    long getScribeSessionId(Session session)
    {
        if (session != null)
        {
            return session.getId();
        } else
        {
            return 0L;
        }
    }

    public void scribe(ScribeEvent scribeevent)
    {
        super.scribe(scribeevent, getScribeSessionId(getActiveSession()));
    }

    public transient void scribeSyndicatedSdkImpressionEvents(EventNamespace aeventnamespace[])
    {
        String s;
        if (kit.getContext() != null)
        {
            s = kit.getContext().getResources().getConfiguration().locale.getLanguage();
        } else
        {
            s = "";
        }
        long l = System.currentTimeMillis();
        int j = aeventnamespace.length;
        for (int i = 0; i < j; i++)
        {
            scribe(new SyndicatedSdkImpressionEvent(aeventnamespace[i], l, s, advertisingId));
        }

    }
}
