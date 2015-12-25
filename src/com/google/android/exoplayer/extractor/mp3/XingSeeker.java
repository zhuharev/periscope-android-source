// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.util.MpegAudioHeader;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;

final class XingSeeker
    implements Mp3Extractor.Seeker
{

    private final long durationUs;
    private final long firstFramePosition;
    private final long inputLength;
    private final long sizeBytes;
    private final long tableOfContents[];

    private XingSeeker(long l, long l1, long l2)
    {
        this(l, l1, l2, null, 0L);
    }

    private XingSeeker(long l, long l1, long l2, long al[], 
            long l3)
    {
        tableOfContents = al;
        firstFramePosition = l1;
        sizeBytes = l3;
        durationUs = l2;
        inputLength = l;
    }

    public static XingSeeker create(MpegAudioHeader mpegaudioheader, ParsableByteArray parsablebytearray, long l, long l1)
    {
        int i;
        int k;
        int i1;
        int j1;
label0:
        {
            i = mpegaudioheader.samplesPerFrame;
            k = mpegaudioheader.sampleRate;
            l += mpegaudioheader.frameSize;
            i1 = parsablebytearray.readInt();
            if ((i1 & 1) == 1)
            {
                j1 = parsablebytearray.readUnsignedIntToInt();
                if (j1 != 0)
                {
                    break label0;
                }
            }
            return null;
        }
        long l2 = Util.scaleLargeTimestamp(j1, (long)i * 0xf4240L, k);
        if ((i1 & 6) != 6)
        {
            return new XingSeeker(l1, l, l2);
        }
        long l3 = parsablebytearray.readUnsignedIntToInt();
        parsablebytearray.skipBytes(1);
        mpegaudioheader = new long[99];
        for (int j = 0; j < 99; j++)
        {
            mpegaudioheader[j] = parsablebytearray.readUnsignedByte();
        }

        return new XingSeeker(l1, l, l2, mpegaudioheader, l3);
    }

    private long getTimeUsForTocIndex(int i)
    {
        return (durationUs * (long)(i + 1)) / 100L;
    }

    public final long getDurationUs()
    {
        return durationUs;
    }

    public final long getPosition(long l)
    {
        if (!isSeekable())
        {
            return firstFramePosition;
        }
        float f2 = ((float)l * 100F) / (float)durationUs;
        float f;
        if (f2 <= 0.0F)
        {
            f = 0.0F;
        } else
        if (f2 >= 100F)
        {
            f = 256F;
        } else
        {
            int i = (int)f2;
            if (i == 0)
            {
                f = 0.0F;
            } else
            {
                f = tableOfContents[i - 1];
            }
            float f1;
            if (i < 99)
            {
                f1 = tableOfContents[i];
            } else
            {
                f1 = 256F;
            }
            f += (f1 - f) * (f2 - (float)i);
        }
        l = (long)((double)f * 0.00390625D * (double)sizeBytes) + firstFramePosition;
        if (inputLength != -1L)
        {
            return Math.min(l, inputLength - 1L);
        } else
        {
            return l;
        }
    }

    public final long getTimeUs(long l)
    {
        if (!isSeekable())
        {
            return 0L;
        }
        double d = ((double)(l - firstFramePosition) * 256D) / (double)sizeBytes;
        int i = Util.binarySearchFloor(tableOfContents, (long)d, true, false);
        long l1 = getTimeUsForTocIndex(i);
        if (i == 98)
        {
            return l1;
        }
        if (i == -1)
        {
            l = 0L;
        } else
        {
            l = tableOfContents[i];
        }
        long l2 = tableOfContents[i + 1];
        long l3 = getTimeUsForTocIndex(i + 1);
        if (l2 == l)
        {
            l = 0L;
        } else
        {
            l = (long)(((double)(l3 - l1) * (d - (double)l)) / (double)(l2 - l));
        }
        return l1 + l;
    }

    public final boolean isSeekable()
    {
        return tableOfContents != null;
    }
}
