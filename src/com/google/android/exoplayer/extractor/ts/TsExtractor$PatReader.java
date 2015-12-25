// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            TsExtractor

class eader extends eader
{

    private final ParsableBitArray patScratch = new ParsableBitArray(new byte[4]);
    final TsExtractor this$0;

    public void consume(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput)
    {
        if (flag)
        {
            parsablebytearray.skipBytes(parsablebytearray.readUnsignedByte());
        }
        parsablebytearray.readBytes(patScratch, 3);
        patScratch.skipBits(12);
        int i = patScratch.readBits(12);
        parsablebytearray.skipBytes(5);
        int k = (i - 9) / 4;
        for (int j = 0; j < k; j++)
        {
            parsablebytearray.readBytes(patScratch, 4);
            patScratch.skipBits(19);
            int l = patScratch.readBits(13);
            tsPayloadReaders.put(l, new <init>(TsExtractor.this));
        }

    }

    public void seek()
    {
    }

    public eader()
    {
        this$0 = TsExtractor.this;
        super(null);
    }
}
