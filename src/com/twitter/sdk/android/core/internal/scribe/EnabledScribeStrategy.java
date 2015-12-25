// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import o.to;
import o.ub;

// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            ScribeConfig, ScribeFilesManager, ScribeFilesSender

class EnabledScribeStrategy extends to
{

    private final ub filesSender;

    public EnabledScribeStrategy(Context context, ScheduledExecutorService scheduledexecutorservice, ScribeFilesManager scribefilesmanager, ScribeConfig scribeconfig, ScribeFilesSender scribefilessender)
    {
        super(context, scheduledexecutorservice, scribefilesmanager);
        filesSender = scribefilessender;
        configureRollover(scribeconfig.sendIntervalSeconds);
    }

    public ub getFilesSender()
    {
        return filesSender;
    }
}
