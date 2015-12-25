// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.util:
//            Assertions, ParsableBitArray, NalUnitUtil

public final class CodecSpecificDataUtil
{
    public static final class SpsData
    {

        public final int height;
        public final float pixelWidthAspectRatio;
        public final int width;

        public SpsData(int i, int j, float f)
        {
            width = i;
            height = j;
            pixelWidthAspectRatio = f;
        }
    }


    private static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[] = {
        0, 1, 2, 3, 4, 5, 6, 8
    };
    private static final int AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[] = {
        0x17700, 0x15888, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 
        11025, 8000, 7350
    };
    private static final byte NAL_START_CODE[] = {
        0, 0, 0, 1
    };
    private static final String TAG = "CodecSpecificDataUtil";

    private CodecSpecificDataUtil()
    {
    }

    public static byte[] buildAacAudioSpecificConfig(int i, int j)
    {
        int i1 = -1;
        for (int k = 0; k < AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE.length; k++)
        {
            if (i == AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[k])
            {
                i1 = k;
            }
        }

        int l = -1;
        for (i = 0; i < AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE.length; i++)
        {
            if (j == AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[i])
            {
                l = i;
            }
        }

        return (new byte[] {
            (byte)(i1 >> 1 | 0x10), (byte)((i1 & 1) << 7 | l << 3)
        });
    }

    public static byte[] buildAacAudioSpecificConfig(int i, int j, int k)
    {
        return (new byte[] {
            (byte)(i << 3 & 0xf8 | j >> 1 & 7), (byte)(j << 7 & 0x80 | k << 3 & 0x78)
        });
    }

    public static byte[] buildNalUnit(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[NAL_START_CODE.length + j];
        System.arraycopy(NAL_START_CODE, 0, abyte1, 0, NAL_START_CODE.length);
        System.arraycopy(abyte0, i, abyte1, NAL_START_CODE.length, j);
        return abyte1;
    }

    private static int findNalStartCode(byte abyte0[], int i)
    {
        int j = abyte0.length;
        for (int k = NAL_START_CODE.length; i <= j - k; i++)
        {
            if (isNalStartCode(abyte0, i))
            {
                return i;
            }
        }

        return -1;
    }

    private static boolean isNalStartCode(byte abyte0[], int i)
    {
        if (abyte0.length - i <= NAL_START_CODE.length)
        {
            return false;
        }
        for (int j = 0; j < NAL_START_CODE.length; j++)
        {
            if (abyte0[i + j] != NAL_START_CODE[j])
            {
                return false;
            }
        }

        return true;
    }

    public static Pair parseAacAudioSpecificConfig(byte abyte0[])
    {
        int i = abyte0[0] >> 3 & 0x1f;
        if (i == 5 || i == 29)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        int j = (abyte0[i] & 7) << 1 | abyte0[i + 1] >> 7 & 1;
        boolean flag;
        if (j < 13)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return Pair.create(Integer.valueOf(AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[j]), Integer.valueOf(abyte0[i + 1] >> 3 & 0xf));
    }

    public static SpsData parseSpsNalUnit(ParsableBitArray parsablebitarray)
    {
        int i = parsablebitarray.readBits(8);
        parsablebitarray.skipBits(16);
        parsablebitarray.readUnsignedExpGolombCodedInt();
        int j = 1;
        if (i == 100 || i == 110 || i == 122 || i == 244 || i == 44 || i == 83 || i == 86 || i == 118 || i == 128 || i == 138)
        {
            j = parsablebitarray.readUnsignedExpGolombCodedInt();
            i = j;
            if (j == 3)
            {
                parsablebitarray.skipBits(1);
            }
            parsablebitarray.readUnsignedExpGolombCodedInt();
            parsablebitarray.readUnsignedExpGolombCodedInt();
            parsablebitarray.skipBits(1);
            j = i;
            if (parsablebitarray.readBit())
            {
                byte byte0;
                if (i != 3)
                {
                    byte0 = 8;
                } else
                {
                    byte0 = 12;
                }
                int i1 = 0;
                do
                {
                    j = i;
                    if (i1 >= byte0)
                    {
                        break;
                    }
                    if (parsablebitarray.readBit())
                    {
                        if (i1 < 6)
                        {
                            j = 16;
                        } else
                        {
                            j = 64;
                        }
                        skipScalingList(parsablebitarray, j);
                    }
                    i1++;
                } while (true);
            }
        }
        parsablebitarray.readUnsignedExpGolombCodedInt();
        long l3 = parsablebitarray.readUnsignedExpGolombCodedInt();
        if (l3 == 0L)
        {
            parsablebitarray.readUnsignedExpGolombCodedInt();
        } else
        if (l3 == 1L)
        {
            parsablebitarray.skipBits(1);
            parsablebitarray.readSignedExpGolombCodedInt();
            parsablebitarray.readSignedExpGolombCodedInt();
            long l4 = parsablebitarray.readUnsignedExpGolombCodedInt();
            for (i = 0; (long)i < l4; i++)
            {
                parsablebitarray.readUnsignedExpGolombCodedInt();
            }

        }
        parsablebitarray.readUnsignedExpGolombCodedInt();
        parsablebitarray.skipBits(1);
        int j1 = parsablebitarray.readUnsignedExpGolombCodedInt();
        int l = parsablebitarray.readUnsignedExpGolombCodedInt();
        boolean flag = parsablebitarray.readBit();
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!flag)
        {
            parsablebitarray.skipBits(1);
        }
        parsablebitarray.skipBits(1);
        j1 = j1 + 1 << 4;
        int l1 = (2 - i) * (l + 1) << 4;
        l = l1;
        i = j1;
        if (parsablebitarray.readBit())
        {
            int k2 = parsablebitarray.readUnsignedExpGolombCodedInt();
            int l2 = parsablebitarray.readUnsignedExpGolombCodedInt();
            int i2 = parsablebitarray.readUnsignedExpGolombCodedInt();
            int j2 = parsablebitarray.readUnsignedExpGolombCodedInt();
            if (j == 0)
            {
                j = 1;
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                i = 2 - i;
            } else
            {
                if (j == 3)
                {
                    i = 1;
                } else
                {
                    i = 2;
                }
                if (j == 1)
                {
                    j = 2;
                } else
                {
                    j = 1;
                }
                if (flag)
                {
                    l = 1;
                } else
                {
                    l = 0;
                }
                l = j * (2 - l);
                j = i;
                i = l;
            }
            j = j1 - (k2 + l2) * j;
            l = l1 - (i2 + j2) * i;
            i = j;
        }
        float f1 = 1.0F;
        float f = f1;
        if (parsablebitarray.readBit())
        {
            f = f1;
            if (parsablebitarray.readBit())
            {
                int k = parsablebitarray.readBits(8);
                if (k == 255)
                {
                    k = parsablebitarray.readBits(16);
                    int k1 = parsablebitarray.readBits(16);
                    f = f1;
                    if (k != 0)
                    {
                        f = f1;
                        if (k1 != 0)
                        {
                            f = (float)k / (float)k1;
                        }
                    }
                } else
                if (k < NalUnitUtil.ASPECT_RATIO_IDC_VALUES.length)
                {
                    f = NalUnitUtil.ASPECT_RATIO_IDC_VALUES[k];
                } else
                {
                    Log.w("CodecSpecificDataUtil", (new StringBuilder("Unexpected aspect_ratio_idc value: ")).append(k).toString());
                    f = f1;
                }
            }
        }
        return new SpsData(i, l, f);
    }

    private static void skipScalingList(ParsableBitArray parsablebitarray, int i)
    {
        int l = 8;
        int i1 = 8;
        for (int k = 0; k < i;)
        {
            int j = i1;
            if (i1 != 0)
            {
                j = (l + parsablebitarray.readSignedExpGolombCodedInt() + 256) % 256;
            }
            if (j != 0)
            {
                l = j;
            }
            k++;
            i1 = j;
        }

    }

    public static byte[][] splitNalUnits(byte abyte0[])
    {
        if (!isNalStartCode(abyte0, 0))
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        int i = 0;
        int k;
        do
        {
            arraylist.add(Integer.valueOf(i));
            k = findNalStartCode(abyte0, NAL_START_CODE.length + i);
            i = k;
        } while (k != -1);
        byte abyte1[][] = new byte[arraylist.size()][];
        for (int j = 0; j < arraylist.size(); j++)
        {
            int i1 = ((Integer)arraylist.get(j)).intValue();
            int l;
            if (j < arraylist.size() - 1)
            {
                l = ((Integer)arraylist.get(j + 1)).intValue();
            } else
            {
                l = abyte0.length;
            }
            byte abyte2[] = new byte[l - i1];
            System.arraycopy(abyte0, i1, abyte2, 0, abyte2.length);
            abyte1[j] = abyte2;
        }

        return abyte1;
    }

}
