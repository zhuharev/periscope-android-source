// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.text.eia608.Eia608Parser;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            ElementaryStreamReader

final class SeiReader extends ElementaryStreamReader
{

    public SeiReader(TrackOutput trackoutput)
    {
        super(trackoutput);
        trackoutput.format(MediaFormat.createTextFormat(-1, "application/eia-608", -1, -1L, null));
    }

    public final void consume(ParsableByteArray parsablebytearray, long l, boolean flag)
    {
        while (parsablebytearray.bytesLeft() > 1) 
        {
            int i = 0;
            int j;
            int k;
            do
            {
                k = parsablebytearray.readUnsignedByte();
                j = i + k;
                i = j;
            } while (k == 255);
            i = 0;
            int i1;
            do
            {
                i1 = parsablebytearray.readUnsignedByte();
                k = i + i1;
                i = k;
            } while (i1 == 255);
            if (Eia608Parser.isSeiMessageEia608(j, k, parsablebytearray))
            {
                output.sampleData(parsablebytearray, k);
                output.sampleMetadata(l, 1, k, 0, null);
            } else
            {
                parsablebytearray.skipBytes(k);
            }
        }
    }

    public final void packetFinished()
    {
    }

    public final void seek()
    {
    }
}
