// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.BehindLiveWindowException;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.dash.mpd.RangedUri;
import com.google.android.exoplayer.dash.mpd.Representation;
import com.google.android.exoplayer.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer.extractor.webm.WebmExtractor;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DashChunkSource, DashSegmentIndex

static final class segmentIndex
{

    public final ChunkExtractorWrapper extractorWrapper;
    public MediaFormat mediaFormat;
    private long periodDurationUs;
    private final long periodStartTimeUs;
    public Representation representation;
    public DashSegmentIndex segmentIndex;
    private int segmentNumShift;

    public final int getFirstAvailableSegmentNum()
    {
        return segmentIndex.getFirstSegmentNum() + segmentNumShift;
    }

    public final long getSegmentEndTimeUs(int i)
    {
        return getSegmentStartTimeUs(i) + segmentIndex.getDurationUs(i - segmentNumShift, periodDurationUs);
    }

    public final int getSegmentNum(long l)
    {
        return segmentIndex.getSegmentNum(l - periodStartTimeUs, periodDurationUs) + segmentNumShift;
    }

    public final long getSegmentStartTimeUs(int i)
    {
        return segmentIndex.getTimeUs(i - segmentNumShift) + periodStartTimeUs;
    }

    public final RangedUri getSegmentUrl(int i)
    {
        return segmentIndex.getSegmentUrl(i - segmentNumShift);
    }

    public final boolean isLastSegment(int i)
    {
        int j = segmentIndex.getLastSegmentNum(periodDurationUs);
        return j != -1 && i == segmentNumShift + j;
    }

    public final void updateRepresentation(long l, Representation representation1)
    {
        DashSegmentIndex dashsegmentindex = representation.getIndex();
        DashSegmentIndex dashsegmentindex1 = representation1.getIndex();
        periodDurationUs = l;
        representation = representation1;
        if (dashsegmentindex == null)
        {
            return;
        }
        segmentIndex = dashsegmentindex1;
        if (!dashsegmentindex.isExplicit())
        {
            return;
        }
        int i = dashsegmentindex.getLastSegmentNum(periodDurationUs);
        l = dashsegmentindex.getTimeUs(i) + dashsegmentindex.getDurationUs(i, periodDurationUs);
        i = dashsegmentindex1.getFirstSegmentNum();
        long l1 = dashsegmentindex1.getTimeUs(i);
        if (l == l1)
        {
            segmentNumShift = segmentNumShift + ((dashsegmentindex.getLastSegmentNum(periodDurationUs) + 1) - i);
            return;
        }
        if (l < l1)
        {
            throw new BehindLiveWindowException();
        } else
        {
            segmentNumShift = segmentNumShift + (dashsegmentindex.getSegmentNum(l1, periodDurationUs) - i);
            return;
        }
    }

    public (long l, long l1, Representation representation1)
    {
        periodStartTimeUs = l;
        periodDurationUs = l1;
        representation = representation1;
        Object obj = representation1.format.mimeType;
        if (DashChunkSource.mimeTypeIsRawText(((String) (obj))))
        {
            obj = null;
        } else
        {
            if (DashChunkSource.mimeTypeIsWebm(((String) (obj))))
            {
                obj = new WebmExtractor();
            } else
            {
                obj = new FragmentedMp4Extractor();
            }
            obj = new ChunkExtractorWrapper(((com.google.android.exoplayer.extractor.Extractor) (obj)));
        }
        extractorWrapper = ((ChunkExtractorWrapper) (obj));
        segmentIndex = representation1.getIndex();
    }
}
