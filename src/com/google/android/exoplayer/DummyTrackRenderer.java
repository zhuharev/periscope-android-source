// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            TrackRenderer, MediaFormat

public final class DummyTrackRenderer extends TrackRenderer
{

    public DummyTrackRenderer()
    {
    }

    protected final boolean doPrepare(long l)
    {
        return true;
    }

    protected final void doSomeWork(long l, long l1)
    {
        throw new IllegalStateException();
    }

    protected final long getBufferedPositionUs()
    {
        throw new IllegalStateException();
    }

    protected final long getDurationUs()
    {
        throw new IllegalStateException();
    }

    protected final MediaFormat getFormat(int i)
    {
        throw new IllegalStateException();
    }

    protected final int getTrackCount()
    {
        return 0;
    }

    protected final boolean isEnded()
    {
        throw new IllegalStateException();
    }

    protected final boolean isReady()
    {
        throw new IllegalStateException();
    }

    protected final void maybeThrowError()
    {
        throw new IllegalStateException();
    }

    protected final void seekTo(long l)
    {
        throw new IllegalStateException();
    }
}
