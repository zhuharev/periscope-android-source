// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.util.Util;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            SegmentBase, RangedUri, Representation

public static abstract class segmentTimeline extends SegmentBase
{

    final long duration;
    final List segmentTimeline;
    final int startNumber;

    public int getFirstSegmentNum()
    {
        return startNumber;
    }

    public abstract int getLastSegmentNum(long l);

    public final long getSegmentDurationUs(int i, long l)
    {
        if (segmentTimeline != null)
        {
            return (((ement)segmentTimeline.get(i - startNumber)).duration * 0xf4240L) / timescale;
        }
        if (i == getLastSegmentNum(l))
        {
            return l - getSegmentTimeUs(i);
        } else
        {
            return (duration * 0xf4240L) / timescale;
        }
    }

    public int getSegmentNum(long l, long l1)
    {
        int k = getFirstSegmentNum();
        int i1 = getLastSegmentNum(l1);
        int i = k;
        int j = i1;
        if (segmentTimeline == null)
        {
            l1 = (duration * 0xf4240L) / timescale;
            i = startNumber + (int)(l / l1);
            if (i < k)
            {
                return k;
            }
            if (i1 != -1 && i > i1)
            {
                return i1;
            } else
            {
                return i;
            }
        }
        while (i <= j) 
        {
            int j1 = (i + j) / 2;
            l1 = getSegmentTimeUs(j1);
            if (l1 < l)
            {
                i = j1 + 1;
            } else
            if (l1 > l)
            {
                j = j1 - 1;
            } else
            {
                return j1;
            }
        }
        if (i == k)
        {
            return i;
        } else
        {
            return j;
        }
    }

    public final long getSegmentTimeUs(int i)
    {
        long l;
        if (segmentTimeline != null)
        {
            l = ((ement)segmentTimeline.get(i - startNumber)).startTime - presentationTimeOffset;
        } else
        {
            l = (long)(i - startNumber) * duration;
        }
        return Util.scaleLargeTimestamp(l, 0xf4240L, timescale);
    }

    public abstract RangedUri getSegmentUrl(Representation representation, int i);

    public boolean isExplicit()
    {
        return segmentTimeline != null;
    }

    public ement(RangedUri rangeduri, long l, long l1, int i, long l2, List list)
    {
        super(rangeduri, l, l1);
        startNumber = i;
        duration = l2;
        segmentTimeline = list;
    }
}
