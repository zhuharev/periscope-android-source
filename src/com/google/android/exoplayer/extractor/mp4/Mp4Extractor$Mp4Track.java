// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.extractor.TrackOutput;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            Mp4Extractor, TrackSampleTable, Track

static final class trackOutput
{

    public int sampleIndex;
    public final TrackSampleTable sampleTable;
    public final Track track;
    public final TrackOutput trackOutput;

    public (Track track1, TrackSampleTable tracksampletable, TrackOutput trackoutput)
    {
        track = track1;
        sampleTable = tracksampletable;
        trackOutput = trackoutput;
    }
}
