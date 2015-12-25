// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.Closeable;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.codahale.metrics:
//            Timer, Clock

public static class <init>
    implements Closeable
{

    private final Clock clock;
    private final long startTime;
    private final Timer timer;

    public void close()
    {
        stop();
    }

    public long stop()
    {
        long l = clock.getTick() - startTime;
        timer.update(l, TimeUnit.NANOSECONDS);
        return l;
    }

    private (Timer timer1, Clock clock1)
    {
        timer = timer1;
        clock = clock1;
        startTime = clock1.getTick();
    }

    startTime(Timer timer1, Clock clock1, startTime starttime)
    {
        this(timer1, clock1);
    }
}
