// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import android.net.Uri;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.dash.DashSegmentIndex;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            Representation, DashSingleSegmentIndex, RangedUri

public static class segmentIndex extends Representation
{

    public final long contentLength;
    private final RangedUri indexUri;
    private final DashSingleSegmentIndex segmentIndex;
    public final Uri uri;

    public static segmentIndex newInstance(String s, long l, Format format, String s1, long l1, long l2, long l3, long l4, long l5)
    {
        return new <init>(s, l, format, new <init>(new RangedUri(s1, null, l1, (l2 - l1) + 1L), 1L, 0L, s1, l3, (l4 - l3) + 1L), l5);
    }

    public DashSegmentIndex getIndex()
    {
        return segmentIndex;
    }

    public RangedUri getIndexUri()
    {
        return indexUri;
    }

    public (String s, long l, Format format,  , long l1)
    {
        super(s, l, format, , null);
        uri = Uri.parse(.uri);
        indexUri = .indexUri();
        contentLength = l1;
        if (indexUri != null)
        {
            s = null;
        } else
        {
            s = new DashSingleSegmentIndex(new RangedUri(.indexUri, null, 0L, l1));
        }
        segmentIndex = s;
    }
}
