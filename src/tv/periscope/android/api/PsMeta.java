// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import o.atk;
import o.atx;

class PsMeta
{

    public double joinTimeAverage;
    public long joinTimeCount;
    public long lostBeforeEnd;
    public long nComments;
    public long nHearts;
    public long nReplayHearts;
    public long nReplayWatched;
    public long nWatched;
    public long nWatching;
    public long nWatchingWeb;
    public long nWebWatched;
    public long watchedTime;
    public long watchedTimeCalculated;
    public long watchedTimeImplied;

    PsMeta()
    {
    }

    public atx get()
    {
        long l;
        if (nWatched != 0L)
        {
            l = watchedTime / nWatched;
        } else
        {
            l = 0L;
        }
        return new atk(l, (int)nWatched, (int)lostBeforeEnd);
    }
}
