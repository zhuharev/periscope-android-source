// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import android.net.Uri;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.FormatWrapper;
import com.google.android.exoplayer.dash.DashSegmentIndex;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            SegmentBase, RangedUri, DashSingleSegmentIndex

public abstract class Representation
    implements FormatWrapper
{
    public static class MultiSegmentRepresentation extends Representation
        implements DashSegmentIndex
    {

        private final SegmentBase.MultiSegmentBase segmentBase;

        public long getDurationUs(int i, long l)
        {
            return segmentBase.getSegmentDurationUs(i, l);
        }

        public int getFirstSegmentNum()
        {
            return segmentBase.getFirstSegmentNum();
        }

        public DashSegmentIndex getIndex()
        {
            return this;
        }

        public RangedUri getIndexUri()
        {
            return null;
        }

        public int getLastSegmentNum(long l)
        {
            return segmentBase.getLastSegmentNum(l);
        }

        public int getSegmentNum(long l, long l1)
        {
            return segmentBase.getSegmentNum(l, l1);
        }

        public RangedUri getSegmentUrl(int i)
        {
            return segmentBase.getSegmentUrl(this, i);
        }

        public long getTimeUs(int i)
        {
            return segmentBase.getSegmentTimeUs(i);
        }

        public boolean isExplicit()
        {
            return segmentBase.isExplicit();
        }

        public MultiSegmentRepresentation(String s, long l, Format format1, SegmentBase.MultiSegmentBase multisegmentbase)
        {
            super(s, l, format1, multisegmentbase, null);
            segmentBase = multisegmentbase;
        }
    }

    public static class SingleSegmentRepresentation extends Representation
    {

        public final long contentLength;
        private final RangedUri indexUri;
        private final DashSingleSegmentIndex segmentIndex;
        public final Uri uri;

        public static SingleSegmentRepresentation newInstance(String s, long l, Format format1, String s1, long l1, long l2, long l3, long l4, long l5)
        {
            return new SingleSegmentRepresentation(s, l, format1, new SegmentBase.SingleSegmentBase(new RangedUri(s1, null, l1, (l2 - l1) + 1L), 1L, 0L, s1, l3, (l4 - l3) + 1L), l5);
        }

        public DashSegmentIndex getIndex()
        {
            return segmentIndex;
        }

        public RangedUri getIndexUri()
        {
            return indexUri;
        }

        public SingleSegmentRepresentation(String s, long l, Format format1, SegmentBase.SingleSegmentBase singlesegmentbase, long l1)
        {
            super(s, l, format1, singlesegmentbase, null);
            uri = Uri.parse(singlesegmentbase.uri);
            indexUri = singlesegmentbase.getIndex();
            contentLength = l1;
            if (indexUri != null)
            {
                s = null;
            } else
            {
                s = new DashSingleSegmentIndex(new RangedUri(singlesegmentbase.uri, null, 0L, l1));
            }
            segmentIndex = s;
        }
    }


    public final String contentId;
    public final Format format;
    private final RangedUri initializationUri;
    public final long presentationTimeOffsetUs;
    public final long revisionId;

    private Representation(String s, long l, Format format1, SegmentBase segmentbase)
    {
        contentId = s;
        revisionId = l;
        format = format1;
        initializationUri = segmentbase.getInitialization(this);
        presentationTimeOffsetUs = segmentbase.getPresentationTimeOffsetUs();
    }

    Representation(String s, long l, Format format1, SegmentBase segmentbase, _cls1 _pcls1)
    {
        this(s, l, format1, segmentbase);
    }

    public static Representation newInstance(String s, long l, Format format1, SegmentBase segmentbase)
    {
        if (segmentbase instanceof SegmentBase.SingleSegmentBase)
        {
            return new SingleSegmentRepresentation(s, l, format1, (SegmentBase.SingleSegmentBase)segmentbase, -1L);
        }
        if (segmentbase instanceof SegmentBase.MultiSegmentBase)
        {
            return new MultiSegmentRepresentation(s, l, format1, (SegmentBase.MultiSegmentBase)segmentbase);
        } else
        {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }

    public String getCacheKey()
    {
        return (new StringBuilder()).append(contentId).append(".").append(format.id).append(".").append(revisionId).toString();
    }

    public Format getFormat()
    {
        return format;
    }

    public abstract DashSegmentIndex getIndex();

    public abstract RangedUri getIndexUri();

    public RangedUri getInitializationUri()
    {
        return initializationUri;
    }
}
