// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.BandwidthMeter;
import java.util.List;
import java.util.Random;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            Format, MediaChunk

public interface FormatEvaluator
{
    public static final class AdaptiveEvaluator
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

        public final void evaluate(List list, long l, Format aformat[], Evaluation evaluation)
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
                format = evaluation.format;
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
                            evaluation.queueSize = i;
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
                evaluation.trigger = 3;
            }
            evaluation.format = aformat;
        }

        public AdaptiveEvaluator(BandwidthMeter bandwidthmeter)
        {
            this(bandwidthmeter, 0xc3500, 10000, 25000, 25000, 0.75F);
        }

        public AdaptiveEvaluator(BandwidthMeter bandwidthmeter, int i, int j, int k, int l, float f)
        {
            bandwidthMeter = bandwidthmeter;
            maxInitialBitrate = i;
            minDurationForQualityIncreaseUs = (long)j * 1000L;
            maxDurationForQualityDecreaseUs = (long)k * 1000L;
            minDurationToRetainAfterDiscardUs = (long)l * 1000L;
            bandwidthFraction = f;
        }
    }

    public static final class Evaluation
    {

        public Format format;
        public int queueSize;
        public int trigger;

        public Evaluation()
        {
            trigger = 1;
        }
    }

    public static final class FixedEvaluator
        implements FormatEvaluator
    {

        public final void disable()
        {
        }

        public final void enable()
        {
        }

        public final void evaluate(List list, long l, Format aformat[], Evaluation evaluation)
        {
            evaluation.format = aformat[0];
        }

        public FixedEvaluator()
        {
        }
    }

    public static final class RandomEvaluator
        implements FormatEvaluator
    {

        private final Random random;

        public final void disable()
        {
        }

        public final void enable()
        {
        }

        public final void evaluate(List list, long l, Format aformat[], Evaluation evaluation)
        {
            list = aformat[random.nextInt(aformat.length)];
            if (evaluation.format != null && !evaluation.format.equals(list))
            {
                evaluation.trigger = 3;
            }
            evaluation.format = list;
        }

        public RandomEvaluator()
        {
            random = new Random();
        }

        public RandomEvaluator(int i)
        {
            random = new Random(i);
        }
    }


    public abstract void disable();

    public abstract void enable();

    public abstract void evaluate(List list, long l, Format aformat[], Evaluation evaluation);
}
