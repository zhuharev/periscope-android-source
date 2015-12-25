// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            Period, UtcTimingElement

public class MediaPresentationDescription
    implements com.google.android.exoplayer.util.ManifestFetcher.RedirectingManifest
{

    public final long availabilityStartTime;
    public final long duration;
    public final boolean dynamic;
    public final String location;
    public final long minBufferTime;
    public final long minUpdatePeriod;
    private final List periods;
    public final long timeShiftBufferDepth;
    public final UtcTimingElement utcTiming;

    public MediaPresentationDescription(long l, long l1, long l2, boolean flag, 
            long l3, long l4, UtcTimingElement utctimingelement, String s, List list)
    {
        availabilityStartTime = l;
        duration = l1;
        minBufferTime = l2;
        dynamic = flag;
        minUpdatePeriod = l3;
        timeShiftBufferDepth = l4;
        utcTiming = utctimingelement;
        location = s;
        if (list == null)
        {
            list = Collections.emptyList();
        }
        periods = list;
    }

    public final String getNextManifestUri()
    {
        return location;
    }

    public final Period getPeriod(int i)
    {
        return (Period)periods.get(i);
    }

    public final int getPeriodCount()
    {
        return periods.size();
    }

    public final long getPeriodDuration(int i)
    {
        if (i == periods.size() - 1)
        {
            if (duration == -1L)
            {
                return -1L;
            } else
            {
                return duration - ((Period)periods.get(i)).startMs;
            }
        } else
        {
            return ((Period)periods.get(i + 1)).startMs - ((Period)periods.get(i)).startMs;
        }
    }
}
