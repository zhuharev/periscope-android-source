// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Ac3Util;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            ElementaryStreamReader

final class Ac3Reader extends ElementaryStreamReader
{

    private static final int HEADER_SIZE = 8;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bitrate;
    private int bytesRead;
    private long frameDurationUs;
    private final ParsableBitArray headerScratchBits = new ParsableBitArray(new byte[8]);
    private final ParsableByteArray headerScratchBytes;
    private boolean lastByteWas0B;
    private MediaFormat mediaFormat;
    private int sampleSize;
    private int state;
    private long timeUs;

    public Ac3Reader(TrackOutput trackoutput)
    {
        super(trackoutput);
        headerScratchBytes = new ParsableByteArray(headerScratchBits.data);
        state = 0;
    }

    private boolean continueRead(ParsableByteArray parsablebytearray, byte abyte0[], int i)
    {
        int j = Math.min(parsablebytearray.bytesLeft(), i - bytesRead);
        parsablebytearray.readBytes(abyte0, bytesRead, j);
        bytesRead = bytesRead + j;
        return bytesRead == i;
    }

    private void parseHeader()
    {
        headerScratchBits.setPosition(0);
        sampleSize = Ac3Util.parseFrameSize(headerScratchBits);
        if (mediaFormat == null)
        {
            headerScratchBits.setPosition(0);
            mediaFormat = Ac3Util.parseFrameAc3Format(headerScratchBits, -1, -1L, null);
            output.format(mediaFormat);
            bitrate = Ac3Util.getBitrate(sampleSize, mediaFormat.sampleRate);
        }
        frameDurationUs = (int)(((long)sampleSize * 8000L) / (long)bitrate);
    }

    private boolean skipToNextSync(ParsableByteArray parsablebytearray)
    {
        while (parsablebytearray.bytesLeft() > 0) 
        {
            if (!lastByteWas0B)
            {
                boolean flag;
                if (parsablebytearray.readUnsignedByte() == 11)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                lastByteWas0B = flag;
            } else
            {
                int i = parsablebytearray.readUnsignedByte();
                if (i == 119)
                {
                    lastByteWas0B = false;
                    return true;
                }
                boolean flag1;
                if (i == 11)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                lastByteWas0B = flag1;
            }
        }
        return false;
    }

    public final void consume(ParsableByteArray parsablebytearray, long l, boolean flag)
    {
        if (flag)
        {
            timeUs = l;
        }
        do
        {
            if (parsablebytearray.bytesLeft() <= 0)
            {
                break;
            }
            switch (state)
            {
            case 0: // '\0'
                if (skipToNextSync(parsablebytearray))
                {
                    state = 1;
                    headerScratchBytes.data[0] = 11;
                    headerScratchBytes.data[1] = 119;
                    bytesRead = 2;
                }
                break;

            case 1: // '\001'
                if (continueRead(parsablebytearray, headerScratchBytes.data, 8))
                {
                    parseHeader();
                    headerScratchBytes.setPosition(0);
                    output.sampleData(headerScratchBytes, 8);
                    state = 2;
                }
                break;

            case 2: // '\002'
                int i = Math.min(parsablebytearray.bytesLeft(), sampleSize - bytesRead);
                output.sampleData(parsablebytearray, i);
                bytesRead = bytesRead + i;
                if (bytesRead == sampleSize)
                {
                    output.sampleMetadata(timeUs, 1, sampleSize, 0, null);
                    timeUs = timeUs + frameDurationUs;
                    state = 0;
                }
                break;
            }
        } while (true);
    }

    public final void packetFinished()
    {
    }

    public final void seek()
    {
        state = 0;
        bytesRead = 0;
        lastByteWas0B = false;
    }
}
