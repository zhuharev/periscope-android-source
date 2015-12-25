// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import android.util.Pair;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.CodecSpecificDataUtil;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.util.Collections;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            ElementaryStreamReader

final class AdtsReader extends ElementaryStreamReader
{

    private static final int CRC_SIZE = 2;
    private static final int HEADER_SIZE = 5;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private final ParsableBitArray adtsScratch = new ParsableBitArray(new byte[7]);
    private int bytesRead;
    private long frameDurationUs;
    private boolean hasCrc;
    private boolean hasOutputFormat;
    private boolean lastByteWasFF;
    private int sampleSize;
    private int state;
    private long timeUs;

    public AdtsReader(TrackOutput trackoutput)
    {
        super(trackoutput);
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
        adtsScratch.setPosition(0);
        if (!hasOutputFormat)
        {
            int i = adtsScratch.readBits(2);
            int j = adtsScratch.readBits(4);
            adtsScratch.skipBits(1);
            byte abyte0[] = CodecSpecificDataUtil.buildAacAudioSpecificConfig(i + 1, j, adtsScratch.readBits(3));
            Pair pair = CodecSpecificDataUtil.parseAacAudioSpecificConfig(abyte0);
            MediaFormat mediaformat = MediaFormat.createAudioFormat(-1, "audio/mp4a-latm", -1, -1, -1L, ((Integer)pair.second).intValue(), ((Integer)pair.first).intValue(), Collections.singletonList(abyte0), null);
            frameDurationUs = 0x3d090000L / (long)mediaformat.sampleRate;
            output.format(mediaformat);
            hasOutputFormat = true;
        } else
        {
            adtsScratch.skipBits(10);
        }
        adtsScratch.skipBits(4);
        sampleSize = adtsScratch.readBits(13) - 2 - 5;
        if (hasCrc)
        {
            sampleSize = sampleSize - 2;
        }
    }

    private boolean skipToNextSync(ParsableByteArray parsablebytearray)
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
            if (lastByteWasFF && !flag1 && (abyte0[i] & 0xf0) == 240)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            lastByteWasFF = flag1;
            if (flag)
            {
                boolean flag2;
                if ((abyte0[i] & 1) == 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                hasCrc = flag2;
                parsablebytearray.setPosition(i + 1);
                lastByteWasFF = false;
                return true;
            }
        }

        parsablebytearray.setPosition(j);
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
                    bytesRead = 0;
                    state = 1;
                }
                break;

            case 1: // '\001'
                byte byte0;
                if (hasCrc)
                {
                    byte0 = 7;
                } else
                {
                    byte0 = 5;
                }
                if (continueRead(parsablebytearray, adtsScratch.data, byte0))
                {
                    parseHeader();
                    bytesRead = 0;
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
                    bytesRead = 0;
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
        lastByteWasFF = false;
    }
}
