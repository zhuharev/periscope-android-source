// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import com.google.android.exoplayer.MediaFormat;

// Referenced classes of package com.google.android.exoplayer.util:
//            ParsableByteArray, ParsableBitArray

public final class Ac3Util
{

    private static final int BITRATES[] = {
        32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 
        192, 224, 256, 320, 384, 448, 512, 576, 640
    };
    private static final int CHANNEL_COUNTS[] = {
        2, 1, 2, 3, 3, 4, 4, 5
    };
    private static final int FRMSIZECOD_TO_FRAME_SIZE_44_1[] = {
        69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 
        417, 487, 557, 696, 835, 975, 1114, 1253, 1393
    };
    private static final int SAMPLE_RATES[] = {
        48000, 44100, 32000
    };

    private Ac3Util()
    {
    }

    public static int getBitrate(int i, int j)
    {
        return ((i << 3) * j + 0xbb800) / 0x177000;
    }

    public static MediaFormat parseAnnexFAc3Format(ParsableByteArray parsablebytearray, int i, long l, String s)
    {
        int j = parsablebytearray.readUnsignedByte();
        int i1 = SAMPLE_RATES[(j & 0xc0) >> 6];
        int j1 = parsablebytearray.readUnsignedByte();
        int k = CHANNEL_COUNTS[(j1 & 0x38) >> 3];
        j = k;
        if ((j1 & 4) != 0)
        {
            j = k + 1;
        }
        return MediaFormat.createAudioFormat(i, "audio/ac3", -1, -1, l, j, i1, null, s);
    }

    public static MediaFormat parseAnnexFEAc3Format(ParsableByteArray parsablebytearray, int i, long l, String s)
    {
        parsablebytearray.skipBytes(2);
        int j = parsablebytearray.readUnsignedByte();
        int i1 = SAMPLE_RATES[(j & 0xc0) >> 6];
        int j1 = parsablebytearray.readUnsignedByte();
        int k = CHANNEL_COUNTS[(j1 & 0xe) >> 1];
        j = k;
        if ((j1 & 1) != 0)
        {
            j = k + 1;
        }
        return MediaFormat.createAudioFormat(i, "audio/eac3", -1, -1, l, j, i1, null, s);
    }

    public static MediaFormat parseFrameAc3Format(ParsableBitArray parsablebitarray, int i, long l, String s)
    {
        parsablebitarray.skipBits(32);
        int k = parsablebitarray.readBits(2);
        parsablebitarray.skipBits(14);
        int j = parsablebitarray.readBits(3);
        if ((j & 1) != 0 && j != 1)
        {
            parsablebitarray.skipBits(2);
        }
        if ((j & 4) != 0)
        {
            parsablebitarray.skipBits(2);
        }
        if (j == 2)
        {
            parsablebitarray.skipBits(2);
        }
        boolean flag = parsablebitarray.readBit();
        int i1 = CHANNEL_COUNTS[j];
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        return MediaFormat.createAudioFormat(i, "audio/ac3", -1, -1, l, i1 + j, SAMPLE_RATES[k], null, s);
    }

    public static int parseFrameSize(ParsableBitArray parsablebitarray)
    {
        parsablebitarray.skipBits(32);
        int j = parsablebitarray.readBits(2);
        int i = parsablebitarray.readBits(6);
        j = SAMPLE_RATES[j];
        int k = BITRATES[i / 2];
        if (j == 32000)
        {
            return k * 6;
        }
        if (j == 44100)
        {
            return (FRMSIZECOD_TO_FRAME_SIZE_44_1[i / 2] + i % 2) * 2;
        } else
        {
            return k * 4;
        }
    }

}
