// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.os.SystemClock;

// Referenced classes of package com.google.android.exoplayer:
//            MediaClock

final class StandaloneMediaClock
    implements MediaClock
{

    private long deltaUs;
    private long positionUs;
    private boolean started;

    StandaloneMediaClock()
    {
    }

    private long elapsedRealtimeMinus(long l)
    {
        return SystemClock.elapsedRealtime() * 1000L - l;
    }

    public final long getPositionUs()
    {
        if (started)
        {
            return elapsedRealtimeMinus(deltaUs);
        } else
        {
            return positionUs;
        }
    }

    public final void setPositionUs(long l)
    {
        positionUs = l;
        deltaUs = elapsedRealtimeMinus(l);
    }

    public final void start()
    {
        if (!started)
        {
            started = true;
            deltaUs = elapsedRealtimeMinus(positionUs);
        }
    }

    public final void stop()
    {
        if (started)
        {
            positionUs = elapsedRealtimeMinus(deltaUs);
            started = false;
        }
    }
}
