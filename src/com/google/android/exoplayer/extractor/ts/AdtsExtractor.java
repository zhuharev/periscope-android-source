// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            AdtsReader

public final class AdtsExtractor
    implements Extractor
{

    private static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
    private static final int MAX_PACKET_SIZE = 200;
    private static final int MAX_SNIFF_BYTES = 8192;
    private AdtsReader adtsReader;
    private boolean firstPacket;
    private final long firstSampleTimestampUs;
    private final ParsableByteArray packetBuffer;

    public AdtsExtractor()
    {
        this(0L);
    }

    public AdtsExtractor(long l)
    {
        firstSampleTimestampUs = l;
        packetBuffer = new ParsableByteArray(200);
        firstPacket = true;
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        adtsReader = new AdtsReader(extractoroutput.track(0));
        extractoroutput.endTracks();
        extractoroutput.seekMap(SeekMap.UNSEEKABLE);
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        int i = extractorinput.read(packetBuffer.data, 0, 200);
        if (i == -1)
        {
            return -1;
        } else
        {
            packetBuffer.setPosition(0);
            packetBuffer.setLimit(i);
            adtsReader.consume(packetBuffer, firstSampleTimestampUs, firstPacket);
            firstPacket = false;
            return 0;
        }
    }

    public final void seek()
    {
        firstPacket = true;
        adtsReader.seek();
    }

    public final boolean sniff(ExtractorInput extractorinput)
    {
        ParsableByteArray parsablebytearray = new ParsableByteArray(10);
        ParsableBitArray parsablebitarray = new ParsableBitArray(parsablebytearray.data);
        int i = 0;
        do
        {
            extractorinput.peekFully(parsablebytearray.data, 0, 10);
            parsablebytearray.setPosition(0);
            if (parsablebytearray.readUnsignedInt24() != ID3_TAG)
            {
                break;
            }
            int j = (parsablebytearray.data[6] & 0x7f) << 21 | (parsablebytearray.data[7] & 0x7f) << 14 | (parsablebytearray.data[8] & 0x7f) << 7 | parsablebytearray.data[9] & 0x7f;
            i += j + 10;
            extractorinput.advancePeekPosition(j);
        } while (true);
        extractorinput.resetPeekPosition();
        extractorinput.advancePeekPosition(i);
        int i1 = i;
        int k = 0;
        int l = 0;
        do
        {
            extractorinput.peekFully(parsablebytearray.data, 0, 2);
            parsablebytearray.setPosition(0);
            if ((parsablebytearray.readUnsignedShort() & 0xfff6) != 65520)
            {
                l = 0;
                k = 0;
                extractorinput.resetPeekPosition();
                i1++;
                if (i1 - i >= 8192)
                {
                    return false;
                }
                extractorinput.advancePeekPosition(i1);
            } else
            {
                l++;
                if (l >= 4 && k > 188)
                {
                    return true;
                }
                extractorinput.peekFully(parsablebytearray.data, 0, 4);
                parsablebitarray.setPosition(14);
                int j1 = parsablebitarray.readBits(13);
                extractorinput.advancePeekPosition(j1 - 6);
                k += j1;
            }
        } while (true);
    }

}
