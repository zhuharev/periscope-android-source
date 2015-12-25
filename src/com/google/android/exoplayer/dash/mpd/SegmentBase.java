// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.util.Util;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            RangedUri, Representation, UrlTemplate

public abstract class SegmentBase
{
    public static abstract class MultiSegmentBase extends SegmentBase
    {

        final long duration;
        final List segmentTimeline;
        final int startNumber;

        public int getFirstSegmentNum()
        {
            return startNumber;
        }

        public abstract int getLastSegmentNum(long l);

        public final long getSegmentDurationUs(int i, long l)
        {
            if (segmentTimeline != null)
            {
                return (((SegmentTimelineElement)segmentTimeline.get(i - startNumber)).duration * 0xf4240L) / timescale;
            }
            if (i == getLastSegmentNum(l))
            {
                return l - getSegmentTimeUs(i);
            } else
            {
                return (duration * 0xf4240L) / timescale;
            }
        }

        public int getSegmentNum(long l, long l1)
        {
            int k = getFirstSegmentNum();
            int i1 = getLastSegmentNum(l1);
            int i = k;
            int j = i1;
            if (segmentTimeline == null)
            {
                l1 = (duration * 0xf4240L) / timescale;
                i = startNumber + (int)(l / l1);
                if (i < k)
                {
                    return k;
                }
                if (i1 != -1 && i > i1)
                {
                    return i1;
                } else
                {
                    return i;
                }
            }
            while (i <= j) 
            {
                int j1 = (i + j) / 2;
                l1 = getSegmentTimeUs(j1);
                if (l1 < l)
                {
                    i = j1 + 1;
                } else
                if (l1 > l)
                {
                    j = j1 - 1;
                } else
                {
                    return j1;
                }
            }
            if (i == k)
            {
                return i;
            } else
            {
                return j;
            }
        }

        public final long getSegmentTimeUs(int i)
        {
            long l;
            if (segmentTimeline != null)
            {
                l = ((SegmentTimelineElement)segmentTimeline.get(i - startNumber)).startTime - presentationTimeOffset;
            } else
            {
                l = (long)(i - startNumber) * duration;
            }
            return Util.scaleLargeTimestamp(l, 0xf4240L, timescale);
        }

        public abstract RangedUri getSegmentUrl(Representation representation, int i);

        public boolean isExplicit()
        {
            return segmentTimeline != null;
        }

        public MultiSegmentBase(RangedUri rangeduri, long l, long l1, int i, long l2, List list)
        {
            super(rangeduri, l, l1);
            startNumber = i;
            duration = l2;
            segmentTimeline = list;
        }
    }

    public static class SegmentList extends MultiSegmentBase
    {

        final List mediaSegments;

        public int getLastSegmentNum(long l)
        {
            return (startNumber + mediaSegments.size()) - 1;
        }

        public RangedUri getSegmentUrl(Representation representation, int i)
        {
            return (RangedUri)mediaSegments.get(i - startNumber);
        }

        public boolean isExplicit()
        {
            return true;
        }

        public SegmentList(RangedUri rangeduri, long l, long l1, int i, long l2, List list, List list1)
        {
            super(rangeduri, l, l1, i, l2, list);
            mediaSegments = list1;
        }
    }

    public static class SegmentTemplate extends MultiSegmentBase
    {

        private final String baseUrl;
        final UrlTemplate initializationTemplate;
        final UrlTemplate mediaTemplate;

        public RangedUri getInitialization(Representation representation)
        {
            if (initializationTemplate != null)
            {
                representation = initializationTemplate.buildUri(representation.format.id, 0, representation.format.bitrate, 0L);
                return new RangedUri(baseUrl, representation, 0L, -1L);
            } else
            {
                return super.getInitialization(representation);
            }
        }

        public int getLastSegmentNum(long l)
        {
            if (segmentTimeline != null)
            {
                return (segmentTimeline.size() + startNumber) - 1;
            }
            if (l == -1L)
            {
                return -1;
            } else
            {
                long l1 = (duration * 0xf4240L) / timescale;
                return (startNumber + (int)Util.ceilDivide(l, l1)) - 1;
            }
        }

        public RangedUri getSegmentUrl(Representation representation, int i)
        {
            long l;
            if (segmentTimeline != null)
            {
                l = ((SegmentTimelineElement)segmentTimeline.get(i - startNumber)).startTime;
            } else
            {
                l = (long)(i - startNumber) * duration;
            }
            representation = mediaTemplate.buildUri(representation.format.id, i, representation.format.bitrate, l);
            return new RangedUri(baseUrl, representation, 0L, -1L);
        }

        public SegmentTemplate(RangedUri rangeduri, long l, long l1, int i, long l2, List list, UrlTemplate urltemplate, UrlTemplate urltemplate1, String s)
        {
            super(rangeduri, l, l1, i, l2, list);
            initializationTemplate = urltemplate;
            mediaTemplate = urltemplate1;
            baseUrl = s;
        }
    }

    public static class SegmentTimelineElement
    {

        long duration;
        long startTime;

        public SegmentTimelineElement(long l, long l1)
        {
            startTime = l;
            duration = l1;
        }
    }

    public static class SingleSegmentBase extends SegmentBase
    {

        final long indexLength;
        final long indexStart;
        public final String uri;

        public RangedUri getIndex()
        {
            if (indexLength <= 0L)
            {
                return null;
            } else
            {
                return new RangedUri(uri, null, indexStart, indexLength);
            }
        }

        public SingleSegmentBase(RangedUri rangeduri, long l, long l1, String s, long l2, long l3)
        {
            super(rangeduri, l, l1);
            uri = s;
            indexStart = l2;
            indexLength = l3;
        }

        public SingleSegmentBase(String s)
        {
            this(null, 1L, 0L, s, 0L, -1L);
        }
    }


    final RangedUri initialization;
    final long presentationTimeOffset;
    final long timescale;

    public SegmentBase(RangedUri rangeduri, long l, long l1)
    {
        initialization = rangeduri;
        timescale = l;
        presentationTimeOffset = l1;
    }

    public RangedUri getInitialization(Representation representation)
    {
        return initialization;
    }

    public long getPresentationTimeOffsetUs()
    {
        return Util.scaleLargeTimestamp(presentationTimeOffset, 0xf4240L, timescale);
    }
}
