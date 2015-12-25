// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.MpegAudioHeader;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            ElementaryStreamReader

final class MpegAudioReader extends ElementaryStreamReader
{

    private static final int HEADER_SIZE = 4;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_FRAME = 2;
    private static final int STATE_READING_HEADER = 1;
    private int frameBytesRead;
    private long frameDurationUs;
    private int frameSize;
    private boolean hasOutputFormat;
    private final MpegAudioHeader header = new MpegAudioHeader();
    private final ParsableByteArray headerScratch = new ParsableByteArray(4);
    private boolean lastByteWasFF;
    private int state;
    private long timeUs;

    public MpegAudioReader(TrackOutput trackoutput)
    {
        super(trackoutput);
        state = 0;
        headerScratch.data[0] = -1;
    }

    private void findHeader(ParsableByteArray parsablebytearray)
    {
        byte abyte0[] = parsablebytearray.data;
        int i = parsablebytearray.getPosition();
        int j;
        for (j = parsablebytearray.limit(); i < j; i++)
        {
            boolean flag1;
            if ((abyte0[i] & 0xff) == 255)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            boolean flag;
            if (lastByteWasFF && (abyte0[i] & 0xe0) == 224)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            lastByteWasFF = flag1;
            if (flag)
            {
                parsablebytearray.setPosition(i + 1);
                lastByteWasFF = false;
                headerScratch.data[1] = abyte0[i];
                frameBytesRead = 2;
                state = 1;
                return;
            }
        }

        parsablebytearray.setPosition(j);
    }

    private void readFrameRemainder(ParsableByteArray parsablebytearray)
    {
        int i = Math.min(parsablebytearray.bytesLeft(), frameSize - frameBytesRead);
        output.sampleData(parsablebytearray, i);
        frameBytesRead = frameBytesRead + i;
        if (frameBytesRead < frameSize)
        {
            return;
        } else
        {
            output.sampleMetadata(timeUs, 1, frameSize, 0, null);
            timeUs = timeUs + frameDurationUs;
            frameBytesRead = 0;
            state = 0;
            return;
        }
    }

    private void readHeaderRemainder(ParsableByteArray parsablebytearray)
    {
        int i = Math.min(parsablebytearray.bytesLeft(), 4 - frameBytesRead);
        parsablebytearray.readBytes(headerScratch.data, frameBytesRead, i);
        frameBytesRead = frameBytesRead + i;
        if (frameBytesRead < 4)
        {
            return;
        }
        headerScratch.setPosition(0);
        if (!MpegAudioHeader.populateHeader(headerScratch.readInt(), header))
        {
            frameBytesRead = 0;
            state = 1;
            return;
        }
        frameSize = header.frameSize;
        if (!hasOutputFormat)
        {
            frameDurationUs = ((long)header.samplesPerFrame * 0xf4240L) / (long)header.sampleRate;
            parsablebytearray = MediaFormat.createAudioFormat(-1, header.mimeType, -1, 4096, -1L, header.channels, header.sampleRate, null, null);
            output.format(parsablebytearray);
            hasOutputFormat = true;
        }
        headerScratch.setPosition(0);
        output.sampleData(headerScratch, 4);
        state = 2;
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
                findHeader(parsablebytearray);
                break;

            case 1: // '\001'
                readHeaderRemainder(parsablebytearray);
                break;

            case 2: // '\002'
                readFrameRemainder(parsablebytearray);
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
        frameBytesRead = 0;
        lastByteWasFF = false;
    }
}
