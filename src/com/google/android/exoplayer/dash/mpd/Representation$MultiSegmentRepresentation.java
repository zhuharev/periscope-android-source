// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.dash.DashSegmentIndex;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            Representation, RangedUri

public static class segmentBase extends Representation
    implements DashSegmentIndex
{

    private final segmentBase segmentBase;

    public long getDurationUs(int i, long l)
    {
        return segmentBase.ationUs(i, l);
    }

    public int getFirstSegmentNum()
    {
        return segmentBase.ntNum();
    }

    public DashSegmentIndex getIndex()
    {
        return this;
    }

    public RangedUri getIndexUri()
    {
        return null;
    }

    public int getLastSegmentNum(long l)
    {
        return segmentBase.tNum(l);
    }

    public int getSegmentNum(long l, long l1)
    {
        return segmentBase.(l, l1);
    }

    public RangedUri getSegmentUrl(int i)
    {
        return segmentBase.(this, i);
    }

    public long getTimeUs(int i)
    {
        return segmentBase.eUs(i);
    }

    public boolean isExplicit()
    {
        return segmentBase.segmentBase();
    }

    public (String s, long l, Format format,  )
    {
        super(s, l, format, , null);
        segmentBase = ;
    }
}
