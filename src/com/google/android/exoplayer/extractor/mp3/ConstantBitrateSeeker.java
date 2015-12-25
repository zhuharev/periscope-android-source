// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp3;


final class ConstantBitrateSeeker
    implements Mp3Extractor.Seeker
{

    private static final int BITS_PER_BYTE = 8;
    private static final int MICROSECONDS_PER_SECOND = 0xf4240;
    private final int bitrate;
    private final long durationUs;
    private final long firstFramePosition;

    public ConstantBitrateSeeker(long l, int i, long l1)
    {
        firstFramePosition = l;
        bitrate = i;
        if (l1 == -1L)
        {
            l = -1L;
        } else
        {
            l = getTimeUs(l1);
        }
        durationUs = l;
    }

    public final long getDurationUs()
    {
        return durationUs;
    }

    public final long getPosition(long l)
    {
        if (durationUs == -1L)
        {
            return 0L;
        } else
        {
            return firstFramePosition + ((long)bitrate * l) / 0x7a1200L;
        }
    }

    public final long getTimeUs(long l)
    {
        return ((l - firstFramePosition) * 0xf4240L << 3) / (long)bitrate;
    }

    public final boolean isSeekable()
    {
        return durationUs != -1L;
    }
}
