// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            TsExtractor, PtsTimestampAdjuster, ElementaryStreamReader

class state extends eader
{

    private static final int HEADER_SIZE = 9;
    private static final int MAX_HEADER_EXTENSION_SIZE = 10;
    private static final int PES_SCRATCH_SIZE = 10;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_BODY = 3;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_HEADER_EXTENSION = 2;
    private boolean bodyStarted;
    private int bytesRead;
    private boolean dtsFlag;
    private int extendedHeaderLength;
    private int payloadSize;
    private final ElementaryStreamReader pesPayloadReader;
    private final ParsableBitArray pesScratch = new ParsableBitArray(new byte[10]);
    private boolean ptsFlag;
    private boolean seenFirstDts;
    private int state;
    final TsExtractor this$0;
    private long timeUs;

    private boolean continueRead(ParsableByteArray parsablebytearray, byte abyte0[], int i)
    {
        int j = Math.min(parsablebytearray.bytesLeft(), i - bytesRead);
        if (j <= 0)
        {
            return true;
        }
        if (abyte0 == null)
        {
            parsablebytearray.skipBytes(j);
        } else
        {
            parsablebytearray.readBytes(abyte0, bytesRead, j);
        }
        bytesRead = bytesRead + j;
        return bytesRead == i;
    }

    private boolean parseHeader()
    {
        pesScratch.setPosition(0);
        int i = pesScratch.readBits(24);
        if (i != 1)
        {
            Log.w("TsExtractor", (new StringBuilder("Unexpected start code prefix: ")).append(i).toString());
            payloadSize = -1;
            return false;
        }
        pesScratch.skipBits(8);
        i = pesScratch.readBits(16);
        pesScratch.skipBits(8);
        ptsFlag = pesScratch.readBit();
        dtsFlag = pesScratch.readBit();
        pesScratch.skipBits(6);
        extendedHeaderLength = pesScratch.readBits(8);
        if (i == 0)
        {
            payloadSize = -1;
        } else
        {
            payloadSize = (i + 6) - 9 - extendedHeaderLength;
        }
        return true;
    }

    private void parseHeaderExtension()
    {
        pesScratch.setPosition(0);
        timeUs = 0L;
        if (ptsFlag)
        {
            pesScratch.skipBits(4);
            long l = pesScratch.readBits(3);
            pesScratch.skipBits(1);
            long l1 = pesScratch.readBits(15) << 15;
            pesScratch.skipBits(1);
            long l2 = pesScratch.readBits(15);
            pesScratch.skipBits(1);
            if (!seenFirstDts && dtsFlag)
            {
                pesScratch.skipBits(4);
                long l3 = pesScratch.readBits(3);
                pesScratch.skipBits(1);
                long l4 = pesScratch.readBits(15) << 15;
                pesScratch.skipBits(1);
                long l5 = pesScratch.readBits(15);
                pesScratch.skipBits(1);
                TsExtractor.access$200(TsExtractor.this).adjustTimestamp(l3 << 30 | l4 | l5);
                seenFirstDts = true;
            }
            timeUs = TsExtractor.access$200(TsExtractor.this).adjustTimestamp(l << 30 | l1 | l2);
        }
    }

    private void setState(int i)
    {
        state = i;
        bytesRead = 0;
    }

    public void consume(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput)
    {
        if (flag)
        {
            switch (state)
            {
            case 0: // '\0'
            case 1: // '\001'
            default:
                break;

            case 2: // '\002'
                Log.w("TsExtractor", "Unexpected start indicator reading extended header");
                break;

            case 3: // '\003'
                if (payloadSize != -1)
                {
                    Log.w("TsExtractor", (new StringBuilder("Unexpected start indicator: expected ")).append(payloadSize).append(" more bytes").toString());
                }
                if (bodyStarted)
                {
                    pesPayloadReader.packetFinished();
                }
                break;
            }
            setState(1);
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
                parsablebytearray.skipBytes(parsablebytearray.bytesLeft());
                break;

            case 1: // '\001'
                if (continueRead(parsablebytearray, pesScratch.data, 9))
                {
                    byte byte0;
                    if (parseHeader())
                    {
                        byte0 = 2;
                    } else
                    {
                        byte0 = 0;
                    }
                    setState(byte0);
                }
                break;

            case 2: // '\002'
                int i = Math.min(10, extendedHeaderLength);
                if (continueRead(parsablebytearray, pesScratch.data, i) && continueRead(parsablebytearray, null, extendedHeaderLength))
                {
                    parseHeaderExtension();
                    bodyStarted = false;
                    setState(3);
                }
                break;

            case 3: // '\003'
                int l = parsablebytearray.bytesLeft();
                int j;
                if (payloadSize == -1)
                {
                    j = 0;
                } else
                {
                    j = l - payloadSize;
                }
                int k = l;
                if (j > 0)
                {
                    k = l - j;
                    parsablebytearray.setLimit(parsablebytearray.getPosition() + k);
                }
                extractoroutput = pesPayloadReader;
                long l1 = timeUs;
                if (!bodyStarted)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                extractoroutput.consume(parsablebytearray, l1, flag);
                bodyStarted = true;
                if (payloadSize != -1)
                {
                    payloadSize = payloadSize - k;
                    if (payloadSize == 0)
                    {
                        pesPayloadReader.packetFinished();
                        setState(1);
                    }
                }
                break;
            }
        } while (true);
    }

    public void seek()
    {
        state = 0;
        bytesRead = 0;
        bodyStarted = false;
        seenFirstDts = false;
        pesPayloadReader.seek();
    }

    public (ElementaryStreamReader elementarystreamreader)
    {
        this$0 = TsExtractor.this;
        super(null);
        pesPayloadReader = elementarystreamreader;
        state = 0;
    }
}
