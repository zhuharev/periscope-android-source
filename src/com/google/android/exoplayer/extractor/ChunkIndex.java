// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            SeekMap

public final class ChunkIndex
    implements SeekMap
{

    public final long durationsUs[];
    public final int length;
    public final long offsets[];
    public final int sizes[];
    public final long timesUs[];

    public ChunkIndex(int ai[], long al[], long al1[], long al2[])
    {
        length = ai.length;
        sizes = ai;
        offsets = al;
        durationsUs = al1;
        timesUs = al2;
    }

    public final int getChunkIndex(long l)
    {
        return Util.binarySearchFloor(timesUs, l, true, true);
    }

    public final long getPosition(long l)
    {
        return offsets[getChunkIndex(l)];
    }

    public final boolean isSeekable()
    {
        return true;
    }
}
