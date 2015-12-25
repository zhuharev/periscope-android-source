// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            ElementaryStreamReader

final class Id3Reader extends ElementaryStreamReader
{

    private int sampleSize;
    private long sampleTimeUs;
    private boolean writingSample;

    public Id3Reader(TrackOutput trackoutput)
    {
        super(trackoutput);
        trackoutput.format(MediaFormat.createFormatForMimeType(-1, "application/id3", -1, -1L));
    }

    public final void consume(ParsableByteArray parsablebytearray, long l, boolean flag)
    {
        if (flag)
        {
            writingSample = true;
            sampleTimeUs = l;
            sampleSize = 0;
        }
        if (writingSample)
        {
            sampleSize = sampleSize + parsablebytearray.bytesLeft();
            output.sampleData(parsablebytearray, parsablebytearray.bytesLeft());
        }
    }

    public final void packetFinished()
    {
        output.sampleMetadata(sampleTimeUs, 1, sampleSize, 0, null);
        writingSample = false;
    }

    public final void seek()
    {
        writingSample = false;
    }
}
