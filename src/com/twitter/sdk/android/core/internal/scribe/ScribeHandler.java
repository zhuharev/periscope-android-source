// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import o.tn;
import o.tq;
import o.ts;
import o.tx;

// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            ScribeEvent

class ScribeHandler extends ts
{

    public ScribeHandler(Context context, tx tx, tq tq, ScheduledExecutorService scheduledexecutorservice)
    {
        super(context, tx, tq, scheduledexecutorservice);
    }

    protected tx getDisabledEventsStrategy$34c68017()
    {
        return new tn();
    }

    public void scribe(ScribeEvent scribeevent)
    {
        recordEventAsync(scribeevent, false);
    }

    public void scribeAndFlush(ScribeEvent scribeevent)
    {
        recordEventAsync(scribeevent, true);
    }
}
