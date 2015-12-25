// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.ParsableByteArray;

public final class ChunkExtractorWrapper
    implements ExtractorOutput, TrackOutput
{
    public static interface SingleTrackOutput
        extends TrackOutput
    {

        public abstract void drmInitData(DrmInitData drminitdata);

        public abstract void seekMap(SeekMap seekmap);
    }


    private final Extractor extractor;
    private boolean extractorInitialized;
    private SingleTrackOutput output;
    private boolean seenTrack;

    public ChunkExtractorWrapper(Extractor extractor1)
    {
        extractor = extractor1;
    }

    public final void drmInitData(DrmInitData drminitdata)
    {
        output.drmInitData(drminitdata);
    }

    public final void endTracks()
    {
        Assertions.checkState(seenTrack);
    }

    public final void format(MediaFormat mediaformat)
    {
        output.format(mediaformat);
    }

    public final void init(SingleTrackOutput singletrackoutput)
    {
        output = singletrackoutput;
        if (!extractorInitialized)
        {
            extractor.init(this);
            extractorInitialized = true;
            return;
        } else
        {
            extractor.seek();
            return;
        }
    }

    public final int read(ExtractorInput extractorinput)
    {
        int i = extractor.read(extractorinput, null);
        boolean flag;
        if (i != 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return i;
    }

    public final int sampleData(ExtractorInput extractorinput, int i, boolean flag)
    {
        return output.sampleData(extractorinput, i, flag);
    }

    public final void sampleData(ParsableByteArray parsablebytearray, int i)
    {
        output.sampleData(parsablebytearray, i);
    }

    public final void sampleMetadata(long l, int i, int j, int k, byte abyte0[])
    {
        output.sampleMetadata(l, i, j, k, abyte0);
    }

    public final void seekMap(SeekMap seekmap)
    {
        output.seekMap(seekmap);
    }

    public final TrackOutput track(int i)
    {
        boolean flag;
        if (!seenTrack)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        seenTrack = true;
        return this;
    }
}
