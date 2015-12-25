// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;


public final class MpegAudioHeader
{

    private static final int BITRATE_V1_L1[] = {
        32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 
        352, 384, 416, 448
    };
    private static final int BITRATE_V1_L2[] = {
        32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 
        224, 256, 320, 384
    };
    private static final int BITRATE_V1_L3[] = {
        32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 
        192, 224, 256, 320
    };
    private static final int BITRATE_V2[] = {
        8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 
        112, 128, 144, 160
    };
    private static final int BITRATE_V2_L1[] = {
        32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 
        176, 192, 224, 256
    };
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    private static final String MIME_TYPE_BY_LAYER[] = {
        "audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"
    };
    private static final int SAMPLING_RATE_V1[] = {
        44100, 48000, 32000
    };
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;

    public MpegAudioHeader()
    {
    }

    public static int getFrameSize(int i)
    {
        if ((0xffe00000 & i) != 0xffe00000)
        {
            return -1;
        }
        int i1 = i >>> 19 & 3;
        if (i1 == 1)
        {
            return -1;
        }
        int j1 = i >>> 17 & 3;
        if (j1 == 0)
        {
            return -1;
        }
        int k1 = i >>> 12 & 0xf;
        if (k1 == 0 || k1 == 15)
        {
            return -1;
        }
        int j = i >>> 10 & 3;
        if (j == 3)
        {
            return -1;
        }
        int k = SAMPLING_RATE_V1[j];
        if (i1 == 2)
        {
            j = k / 2;
        } else
        {
            j = k;
            if (i1 == 0)
            {
                j = k / 4;
            }
        }
        int l = i >>> 9 & 1;
        if (j1 == 3)
        {
            if (i1 == 3)
            {
                i = BITRATE_V1_L1[k1 - 1];
            } else
            {
                i = BITRATE_V2_L1[k1 - 1];
            }
            return (i * 12000) / j + l << 2;
        }
        if (i1 == 3)
        {
            if (j1 == 2)
            {
                i = BITRATE_V1_L2[k1 - 1];
            } else
            {
                i = BITRATE_V1_L3[k1 - 1];
            }
        } else
        {
            i = BITRATE_V2[k1 - 1];
        }
        if (i1 == 3)
        {
            return (0x23280 * i) / j + l;
        }
        if (j1 == 1)
        {
            k = 0x11940;
        } else
        {
            k = 0x23280;
        }
        return (k * i) / j + l;
    }

    public static boolean populateHeader(int i, MpegAudioHeader mpegaudioheader)
    {
        int j;
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
label0:
        {
            int l;
            int i2;
label1:
            {
                if ((0xffe00000 & i) != 0xffe00000)
                {
                    return false;
                }
                k1 = i >>> 19 & 3;
                if (k1 == 1)
                {
                    return false;
                }
                l1 = i >>> 17 & 3;
                if (l1 == 0)
                {
                    return false;
                }
                l = i >>> 12 & 0xf;
                if (l == 0 || l == 15)
                {
                    return false;
                }
                j = i >>> 10 & 3;
                if (j == 3)
                {
                    return false;
                }
                j = SAMPLING_RATE_V1[j];
                if (k1 == 2)
                {
                    k = j / 2;
                } else
                {
                    k = j;
                    if (k1 == 0)
                    {
                        k = j / 4;
                    }
                }
                i2 = i >>> 9 & 1;
                if (l1 == 3)
                {
                    if (k1 == 3)
                    {
                        j = BITRATE_V1_L1[l - 1];
                    } else
                    {
                        j = BITRATE_V2_L1[l - 1];
                    }
                    i1 = (j * 12000) / k + i2 << 2;
                    j1 = 384;
                    break label0;
                }
                if (k1 == 3)
                {
                    if (l1 == 2)
                    {
                        l = BITRATE_V1_L2[l - 1];
                    } else
                    {
                        l = BITRATE_V1_L3[l - 1];
                    }
                    i1 = 1152;
                } else
                {
                    j1 = BITRATE_V2[l - 1];
                    if (l1 == 1)
                    {
                        j = 576;
                    } else
                    {
                        j = 1152;
                    }
                    l = j1;
                    i1 = j;
                    if (l1 == 1)
                    {
                        i1 = 0x11940;
                        l = j1;
                        break label1;
                    }
                }
                j1 = 0x23280;
                j = i1;
                i1 = j1;
            }
            i1 = i2 + (i1 * l) / k;
            j1 = j;
            j = l;
        }
        String s = MIME_TYPE_BY_LAYER[3 - l1];
        if ((i >> 6 & 3) == 3)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        mpegaudioheader.setValues(k1, s, i1, k, i, j, j1);
        return true;
    }

    private void setValues(int i, String s, int j, int k, int l, int i1, int j1)
    {
        version = i;
        mimeType = s;
        frameSize = j;
        sampleRate = k;
        channels = l;
        bitrate = i1;
        samplesPerFrame = j1;
    }

}
