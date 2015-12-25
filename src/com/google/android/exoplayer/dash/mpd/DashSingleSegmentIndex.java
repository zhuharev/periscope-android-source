// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.dash.DashSegmentIndex;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            RangedUri

final class DashSingleSegmentIndex
    implements DashSegmentIndex
{

    private final RangedUri uri;

    public DashSingleSegmentIndex(RangedUri rangeduri)
    {
        uri = rangeduri;
    }

    public final long getDurationUs(int i, long l)
    {
        return l;
    }

    public final int getFirstSegmentNum()
    {
        return 0;
    }

    public final int getLastSegmentNum(long l)
    {
        return 0;
    }

    public final int getSegmentNum(long l, long l1)
    {
        return 0;
    }

    public final RangedUri getSegmentUrl(int i)
    {
        return uri;
    }

    public final long getTimeUs(int i)
    {
        return 0L;
    }

    public final boolean isExplicit()
    {
        return true;
    }
}
