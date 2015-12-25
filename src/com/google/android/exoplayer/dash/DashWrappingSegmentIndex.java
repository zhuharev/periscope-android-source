// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.dash.mpd.RangedUri;
import com.google.android.exoplayer.extractor.ChunkIndex;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DashSegmentIndex

final class DashWrappingSegmentIndex
    implements DashSegmentIndex
{

    private final ChunkIndex chunkIndex;
    private final String uri;

    public DashWrappingSegmentIndex(ChunkIndex chunkindex, String s)
    {
        chunkIndex = chunkindex;
        uri = s;
    }

    public final long getDurationUs(int i, long l)
    {
        return chunkIndex.durationsUs[i];
    }

    public final int getFirstSegmentNum()
    {
        return 0;
    }

    public final int getLastSegmentNum(long l)
    {
        return chunkIndex.length - 1;
    }

    public final int getSegmentNum(long l, long l1)
    {
        return chunkIndex.getChunkIndex(l);
    }

    public final RangedUri getSegmentUrl(int i)
    {
        return new RangedUri(uri, null, chunkIndex.offsets[i], chunkIndex.sizes[i]);
    }

    public final long getTimeUs(int i)
    {
        return chunkIndex.timesUs[i];
    }

    public final boolean isExplicit()
    {
        return true;
    }
}
