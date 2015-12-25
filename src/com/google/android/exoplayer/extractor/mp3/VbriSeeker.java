// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.util.MpegAudioHeader;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;

final class VbriSeeker
    implements Mp3Extractor.Seeker
{

    private final long basePosition;
    private final long durationUs;
    private final long positions[];
    private final long timesUs[];

    private VbriSeeker(long al[], long al1[], long l, long l1)
    {
        timesUs = al;
        positions = al1;
        basePosition = l;
        durationUs = l1;
    }

    public static VbriSeeker create(MpegAudioHeader mpegaudioheader, ParsableByteArray parsablebytearray, long l)
    {
        parsablebytearray.skipBytes(10);
        int i = parsablebytearray.readInt();
        if (i <= 0)
        {
            return null;
        }
        int k = mpegaudioheader.sampleRate;
        long l2 = i;
        if (k >= 32000)
        {
            i = 1152;
        } else
        {
            i = 576;
        }
        long l3 = Util.scaleLargeTimestamp(l2, (long)i * 0xf4240L, k);
        int j1 = parsablebytearray.readUnsignedShort();
        int k1 = parsablebytearray.readUnsignedShort();
        int l1 = parsablebytearray.readUnsignedShort();
        long al[] = new long[j1];
        long al1[] = new long[j1];
        long l4 = l3 / (long)j1;
        l2 = 0L;
        for (int i1 = 0; i1 < j1; i1++)
        {
            int j;
            switch (l1)
            {
            case 1: // '\001'
                j = parsablebytearray.readUnsignedByte();
                break;

            case 2: // '\002'
                j = parsablebytearray.readUnsignedShort();
                break;

            case 3: // '\003'
                j = parsablebytearray.readUnsignedInt24();
                break;

            case 4: // '\004'
                j = parsablebytearray.readUnsignedIntToInt();
                break;

            default:
                return null;
            }
            l2 += l4;
            al[i1] = l2;
            l += j * k1;
            al1[i1] = l;
        }

        return new VbriSeeker(al, al1, l + (long)mpegaudioheader.frameSize, l3);
    }

    public final long getDurationUs()
    {
        return durationUs;
    }

    public final long getPosition(long l)
    {
        int i = Util.binarySearchFloor(timesUs, l, false, false);
        long l1 = basePosition;
        if (i == -1)
        {
            l = 0L;
        } else
        {
            l = positions[i];
        }
        return l1 + l;
    }

    public final long getTimeUs(long l)
    {
        return timesUs[Util.binarySearchFloor(positions, l, true, true)];
    }

    public final boolean isSeekable()
    {
        return true;
    }
}
