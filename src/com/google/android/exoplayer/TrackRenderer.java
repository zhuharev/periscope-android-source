// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import com.google.android.exoplayer.util.Assertions;

// Referenced classes of package com.google.android.exoplayer:
//            MediaFormat, MediaClock

public abstract class TrackRenderer
    implements ExoPlayer.ExoPlayerComponent
{

    public static final long END_OF_TRACK_US = -3L;
    public static final long MATCH_LONGEST_US = -2L;
    protected static final int STATE_ENABLED = 2;
    protected static final int STATE_PREPARED = 1;
    protected static final int STATE_RELEASED = -1;
    protected static final int STATE_STARTED = 3;
    protected static final int STATE_UNPREPARED = 0;
    public static final long UNKNOWN_TIME_US = -1L;
    private int state;

    public TrackRenderer()
    {
    }

    final void disable()
    {
        boolean flag;
        if (state == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 1;
        onDisabled();
    }

    protected abstract boolean doPrepare(long l);

    public abstract void doSomeWork(long l, long l1);

    final void enable(int i, long l, boolean flag)
    {
        boolean flag1;
        if (state == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        state = 2;
        onEnabled(i, l, flag);
    }

    public abstract long getBufferedPositionUs();

    protected abstract long getDurationUs();

    protected abstract MediaFormat getFormat(int i);

    protected MediaClock getMediaClock()
    {
        return null;
    }

    public final int getState()
    {
        return state;
    }

    protected abstract int getTrackCount();

    public void handleMessage(int i, Object obj)
    {
    }

    public abstract boolean isEnded();

    public abstract boolean isReady();

    protected abstract void maybeThrowError();

    public void onDisabled()
    {
    }

    public void onEnabled(int i, long l, boolean flag)
    {
    }

    protected void onReleased()
    {
    }

    protected void onStarted()
    {
    }

    protected void onStopped()
    {
    }

    final int prepare(long l)
    {
        boolean flag;
        if (state == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        int i;
        if (doPrepare(l))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        state = i;
        return state;
    }

    final void release()
    {
        boolean flag;
        if (state != 2 && state != 3 && state != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = -1;
        onReleased();
    }

    public abstract void seekTo(long l);

    final void start()
    {
        boolean flag;
        if (state == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 3;
        onStarted();
    }

    final void stop()
    {
        boolean flag;
        if (state == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 2;
        onStopped();
    }
}
