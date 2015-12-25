// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;


public final class PtsTimestampAdjuster
{

    private static final long MAX_PTS_PLUS_ONE = 0x200000000L;
    private final long firstSampleTimestampUs;
    private long lastPts;
    private long timestampOffsetUs;

    public PtsTimestampAdjuster(long l)
    {
        firstSampleTimestampUs = l;
        lastPts = 0x8000000000000000L;
    }

    public final long adjustTimestamp(long l)
    {
        long l1 = l;
        if (lastPts != 0x8000000000000000L)
        {
            long l2 = (lastPts + 0x100000000L) / 0x200000000L;
            l1 = l + (l2 - 1L) * 0x200000000L;
            l += 0x200000000L * l2;
            if (Math.abs(l1 - lastPts) >= Math.abs(l - lastPts))
            {
                l1 = l;
            }
        }
        l = (0xf4240L * l1) / 0x15f90L;
        if (lastPts == 0x8000000000000000L)
        {
            timestampOffsetUs = firstSampleTimestampUs - l;
        }
        lastPts = l1;
        return timestampOffsetUs + l;
    }

    public final void reset()
    {
        lastPts = 0x8000000000000000L;
    }
}
