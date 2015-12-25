// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            SegmentBase, RangedUri, Representation

public static class mediaSegments extends Base
{

    final List mediaSegments;

    public int getLastSegmentNum(long l)
    {
        return (startNumber + mediaSegments.size()) - 1;
    }

    public RangedUri getSegmentUrl(Representation representation, int i)
    {
        return (RangedUri)mediaSegments.get(i - startNumber);
    }

    public boolean isExplicit()
    {
        return true;
    }

    public Base(RangedUri rangeduri, long l, long l1, int i, long l2, List list, List list1)
    {
        super(rangeduri, l, l1, i, l2, list);
        mediaSegments = list1;
    }
}
