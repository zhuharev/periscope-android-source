// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.BandwidthMeter;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            FormatEvaluator, Format, MediaChunk

public static final class bandwidthFraction
    implements FormatEvaluator
{

    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75F;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_INITIAL_BITRATE = 0xc3500;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final long maxDurationForQualityDecreaseUs;
    private final int maxInitialBitrate;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;

    private Format determineIdealFormat(Format aformat[], long l)
    {
        if (l == -1L)
        {
            l = maxInitialBitrate;
        } else
        {
            l = (long)((float)l * bandwidthFraction);
        }
        for (int i = 0; i < aformat.length; i++)
        {
            Format format = aformat[i];
            if ((long)format.bitrate <= l)
            {
                return format;
            }
        }

        return aformat[aformat.length - 1];
    }

    public final void disable()
    {
    }

    public final void enable()
    {
    }

    public final void evaluate(List list, long l, Format aformat[], bandwidthFraction bandwidthfraction)
    {
        Format format;
label0:
        {
            long l1;
            if (list.isEmpty())
            {
                l1 = 0L;
            } else
            {
                l1 = ((MediaChunk)list.get(list.size() - 1)).endTimeUs - l;
            }
            format = bandwidthfraction.bandwidthFraction;
            Format format1 = determineIdealFormat(aformat, bandwidthMeter.getBitrateEstimate());
            boolean flag;
            if (format1 != null && format != null && format1.bitrate > format.bitrate)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean flag1;
            if (format1 != null && format != null && format1.bitrate < format.bitrate)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag)
            {
                if (l1 < minDurationForQualityIncreaseUs)
                {
                    aformat = format;
                    break label0;
                }
                aformat = format1;
                if (l1 < minDurationToRetainAfterDiscardUs)
                {
                    break label0;
                }
                int i = 1;
                do
                {
                    if (i >= list.size())
                    {
                        break;
                    }
                    aformat = (MediaChunk)list.get(i);
                    if (((MediaChunk) (aformat)).startTimeUs - l >= minDurationToRetainAfterDiscardUs && ((MediaChunk) (aformat)).format.bitrate < format1.bitrate && ((MediaChunk) (aformat)).format.height < format1.height && ((MediaChunk) (aformat)).format.height < 720 && ((MediaChunk) (aformat)).format.width < 1280)
                    {
                        bandwidthfraction.ze = i;
                        aformat = format1;
                        break label0;
                    }
                    i++;
                } while (true);
                aformat = format1;
            } else
            {
                aformat = format1;
                if (flag1)
                {
                    aformat = format1;
                    if (format != null)
                    {
                        aformat = format1;
                        if (l1 >= maxDurationForQualityDecreaseUs)
                        {
                            aformat = format;
                        }
                    }
                }
            }
        }
        if (format != null && aformat != format)
        {
            bandwidthfraction. = 3;
        }
        bandwidthfraction. = aformat;
    }

    public (BandwidthMeter bandwidthmeter)
    {
        this(bandwidthmeter, 0xc3500, 10000, 25000, 25000, 0.75F);
    }

    public <init>(BandwidthMeter bandwidthmeter, int i, int j, int k, int l, float f)
    {
        bandwidthMeter = bandwidthmeter;
        maxInitialBitrate = i;
        minDurationForQualityIncreaseUs = (long)j * 1000L;
        maxDurationForQualityDecreaseUs = (long)k * 1000L;
        minDurationToRetainAfterDiscardUs = (long)l * 1000L;
        bandwidthFraction = f;
    }
}
