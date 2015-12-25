// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            TsExtractor, Id3Reader, MpegAudioReader, AdtsReader, 
//            Ac3Reader, H264Reader, SeiReader, H265Reader

class eader extends eader
{

    private final ParsableBitArray pmtScratch = new ParsableBitArray(new byte[5]);
    final TsExtractor this$0;

    public void consume(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput)
    {
        if (flag)
        {
            parsablebytearray.skipBytes(parsablebytearray.readUnsignedByte());
        }
        parsablebytearray.readBytes(pmtScratch, 3);
        pmtScratch.skipBits(12);
        int i = pmtScratch.readBits(12);
        parsablebytearray.skipBytes(7);
        parsablebytearray.readBytes(pmtScratch, 2);
        pmtScratch.skipBits(4);
        int j = pmtScratch.readBits(12);
        parsablebytearray.skipBytes(j);
        if (id3Reader == null)
        {
            id3Reader = new Id3Reader(extractoroutput.track(21));
        }
        i = i - 9 - j - 4;
        do
        {
            if (i <= 0)
            {
                break;
            }
            parsablebytearray.readBytes(pmtScratch, 5);
            int l = pmtScratch.readBits(8);
            pmtScratch.skipBits(3);
            int i1 = pmtScratch.readBits(13);
            pmtScratch.skipBits(4);
            int k = pmtScratch.readBits(12);
            parsablebytearray.skipBytes(k);
            k = i - (k + 5);
            i = k;
            if (!streamTypes.get(l))
            {
                Object obj = null;
                switch (l)
                {
                case 3: // '\003'
                    obj = new MpegAudioReader(extractoroutput.track(3));
                    break;

                case 4: // '\004'
                    obj = new MpegAudioReader(extractoroutput.track(4));
                    break;

                case 15: // '\017'
                    obj = new AdtsReader(extractoroutput.track(15));
                    break;

                case 129: 
                case 135: 
                    obj = new Ac3Reader(extractoroutput.track(l));
                    break;

                case 27: // '\033'
                    obj = new H264Reader(extractoroutput.track(27), new SeiReader(extractoroutput.track(256)), TsExtractor.access$100(TsExtractor.this));
                    break;

                case 36: // '$'
                    obj = new H265Reader(extractoroutput.track(36), new SeiReader(extractoroutput.track(256)));
                    break;

                case 21: // '\025'
                    obj = id3Reader;
                    break;
                }
                if (obj != null)
                {
                    streamTypes.put(l, true);
                    tsPayloadReaders.put(i1, new <init>(TsExtractor.this, ((ElementaryStreamReader) (obj))));
                }
                i = k;
            }
        } while (true);
        extractoroutput.endTracks();
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
