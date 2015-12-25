// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import com.google.android.exoplayer.util.Clock;

public interface TimeRange
{
    public static final class DynamicTimeRange
        implements TimeRange
    {

        private final long bufferDepthUs;
        private final long elapsedRealtimeAtStartUs;
        private final long maxEndTimeUs;
        private final long minStartTimeUs;
        private final Clock systemClock;

        public final boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (DynamicTimeRange)obj;
            return ((DynamicTimeRange) (obj)).minStartTimeUs == minStartTimeUs && ((DynamicTimeRange) (obj)).maxEndTimeUs == maxEndTimeUs && ((DynamicTimeRange) (obj)).elapsedRealtimeAtStartUs == elapsedRealtimeAtStartUs && ((DynamicTimeRange) (obj)).bufferDepthUs == bufferDepthUs;
        }

        public final long[] getCurrentBoundsMs(long al[])
        {
            al = getCurrentBoundsUs(al);
            al[0] = al[0] / 1000L;
            al[1] = al[1] / 1000L;
            return al;
        }

        public final long[] getCurrentBoundsUs(long al[])
        {
            long al1[];
label0:
            {
                if (al != null)
                {
                    al1 = al;
                    if (al.length >= 2)
                    {
                        break label0;
                    }
                }
                al1 = new long[2];
            }
            long l2 = Math.min(maxEndTimeUs, systemClock.elapsedRealtime() * 1000L - elapsedRealtimeAtStartUs);
            long l1 = minStartTimeUs;
            long l = l1;
            if (bufferDepthUs != -1L)
            {
                l = Math.max(l1, l2 - bufferDepthUs);
            }
            al1[0] = l;
            al1[1] = l2;
            return al1;
        }

        public final int hashCode()
        {
            return ((((int)minStartTimeUs + 527) * 31 + (int)maxEndTimeUs) * 31 + (int)elapsedRealtimeAtStartUs) * 31 + (int)bufferDepthUs;
        }

        public final boolean isStatic()
        {
            return false;
        }

        public DynamicTimeRange(long l, long l1, long l2, long l3, Clock clock)
        {
            minStartTimeUs = l;
            maxEndTimeUs = l1;
            elapsedRealtimeAtStartUs = l2;
            bufferDepthUs = l3;
            systemClock = clock;
        }
    }

    public static final class StaticTimeRange
        implements TimeRange
    {

        private final long endTimeUs;
        private final long startTimeUs;

        public final boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (StaticTimeRange)obj;
            return ((StaticTimeRange) (obj)).startTimeUs == startTimeUs && ((StaticTimeRange) (obj)).endTimeUs == endTimeUs;
        }

        public final long[] getCurrentBoundsMs(long al[])
        {
            al = getCurrentBoundsUs(al);
            al[0] = al[0] / 1000L;
            al[1] = al[1] / 1000L;
            return al;
        }

        public final long[] getCurrentBoundsUs(long al[])
        {
            long al1[];
label0:
            {
                if (al != null)
                {
                    al1 = al;
                    if (al.length >= 2)
                    {
                        break label0;
                    }
                }
                al1 = new long[2];
            }
            al1[0] = startTimeUs;
            al1[1] = endTimeUs;
            return al1;
        }

        public final int hashCode()
        {
            return ((int)startTimeUs + 527) * 31 + (int)endTimeUs;
        }

        public final boolean isStatic()
        {
            return true;
        }

        public StaticTimeRange(long l, long l1)
        {
            startTimeUs = l;
            endTimeUs = l1;
        }
    }


    public abstract long[] getCurrentBoundsMs(long al[]);

    public abstract long[] getCurrentBoundsUs(long al[]);

    public abstract boolean isStatic();
}
