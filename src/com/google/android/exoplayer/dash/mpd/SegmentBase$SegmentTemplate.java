// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.util.Util;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            SegmentBase, Representation, UrlTemplate, RangedUri

public static class baseUrl extends 
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
            l = ((lement)segmentTimeline.get(i - startNumber)).startTime;
        } else
        {
            l = (long)(i - startNumber) * duration;
        }
        representation = mediaTemplate.buildUri(representation.format.id, i, representation.format.bitrate, l);
        return new RangedUri(baseUrl, representation, 0L, -1L);
    }

    public lement(RangedUri rangeduri, long l, long l1, int i, long l2, List list, UrlTemplate urltemplate, UrlTemplate urltemplate1, String s)
    {
        super(rangeduri, l, l1, i, l2, list);
        initializationTemplate = urltemplate;
        mediaTemplate = urltemplate1;
        baseUrl = s;
    }
}
