// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLSocketFactory;
import o.ri;
import o.rz;
import o.sc;
import o.si;
import o.tn;
import o.tx;
import o.ty;
import o.uo;

// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            ScribeFilesManager, ScribeConfig, ScribeHandler, EnabledScribeStrategy, 
//            ScribeFilesSender, ScribeEvent

public class ScribeClient
{

    private static final String STORAGE_DIR_BASE = "_se_to_send";
    private static final String WORKING_FILENAME_BASE = "_se.tap";
    private final TwitterAuthConfig authConfig;
    private final ScheduledExecutorService executor;
    private final si idManager;
    private final ri kit;
    private final ScribeConfig scribeConfig;
    final ConcurrentHashMap scribeHandlers = new ConcurrentHashMap(2);
    private final List sessionManagers;
    private final SSLSocketFactory sslSocketFactory;
    private final ScribeEvent.Transform transform;

    public ScribeClient(ri ri1, ScheduledExecutorService scheduledexecutorservice, ScribeConfig scribeconfig, ScribeEvent.Transform transform1, TwitterAuthConfig twitterauthconfig, List list, SSLSocketFactory sslsocketfactory, 
            si si)
    {
        kit = ri1;
        executor = scheduledexecutorservice;
        scribeConfig = scribeconfig;
        transform = transform1;
        authConfig = twitterauthconfig;
        sessionManagers = list;
        sslSocketFactory = sslsocketfactory;
        idManager = si;
    }

    private ScribeHandler newScribeHandler(long l)
    {
        Context context = kit.getContext();
        Object obj = new ty(context, uo._mth02BC((new uo(kit)).context.getFilesDir()), getWorkingFileNameForOwner(l), getStorageDirForOwner(l));
        obj = new ScribeFilesManager(context, transform, new sc(), ((ty) (obj)), scribeConfig.maxFilesToKeep);
        return new ScribeHandler(context, getScribeStrategy$5ef4b490(l, ((ScribeFilesManager) (obj))), ((o.tq) (obj)), executor);
    }

    ScribeHandler getScribeHandler(long l)
    {
        if (!scribeHandlers.containsKey(Long.valueOf(l)))
        {
            scribeHandlers.putIfAbsent(Long.valueOf(l), newScribeHandler(l));
        }
        return (ScribeHandler)scribeHandlers.get(Long.valueOf(l));
    }

    tx getScribeStrategy$5ef4b490(long l, ScribeFilesManager scribefilesmanager)
    {
        Context context = kit.getContext();
        if (scribeConfig.isEnabled)
        {
            rz._mth02BD(context, "Scribe enabled");
            return new EnabledScribeStrategy(context, executor, scribefilesmanager, scribeConfig, new ScribeFilesSender(context, scribeConfig, l, authConfig, sessionManagers, sslSocketFactory, executor, idManager));
        } else
        {
            rz._mth02BD(context, "Scribe disabled");
            return new tn();
        }
    }

    String getStorageDirForOwner(long l)
    {
        return (new StringBuilder()).append(l).append("_se_to_send").toString();
    }

    String getWorkingFileNameForOwner(long l)
    {
        return (new StringBuilder()).append(l).append("_se.tap").toString();
    }

    public boolean scribe(ScribeEvent scribeevent, long l)
    {
        try
        {
            getScribeHandler(l).scribe(scribeevent);
        }
        // Misplaced declaration of an exception variable
        catch (ScribeEvent scribeevent)
        {
            rz._mth037A(kit.getContext(), "Failed to scribe event");
            return false;
        }
        return true;
    }

    public boolean scribeAndFlush(ScribeEvent scribeevent, long l)
    {
        try
        {
            getScribeHandler(l).scribeAndFlush(scribeevent);
        }
        // Misplaced declaration of an exception variable
        catch (ScribeEvent scribeevent)
        {
            rz._mth037A(kit.getContext(), "Failed to scribe event");
            return false;
        }
        return true;
    }
}
