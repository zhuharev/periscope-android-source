// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            PtsTimestampAdjuster, Id3Reader, ElementaryStreamReader, MpegAudioReader, 
//            AdtsReader, Ac3Reader, H264Reader, SeiReader, 
//            H265Reader

public final class TsExtractor
    implements Extractor
{
    class PatReader extends TsPayloadReader
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
                tsPayloadReaders.put(l, new PmtReader());
            }

        }

        public void seek()
        {
        }

        public PatReader()
        {
            this$0 = TsExtractor.this;
            super();
        }
    }

    class PesReader extends TsPayloadReader
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
                    ptsTimestampAdjuster.adjustTimestamp(l3 << 30 | l4 | l5);
                    seenFirstDts = true;
                }
                timeUs = ptsTimestampAdjuster.adjustTimestamp(l << 30 | l1 | l2);
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

        public PesReader(ElementaryStreamReader elementarystreamreader)
        {
            this$0 = TsExtractor.this;
            super();
            pesPayloadReader = elementarystreamreader;
            state = 0;
        }
    }

    class PmtReader extends TsPayloadReader
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
                        obj = new H264Reader(extractoroutput.track(27), new SeiReader(extractoroutput.track(256)), idrKeyframesOnly);
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
                        tsPayloadReaders.put(i1, new PesReader(((ElementaryStreamReader) (obj))));
                    }
                    i = k;
                }
            } while (true);
            extractoroutput.endTracks();
        }

        public void seek()
        {
        }

        public PmtReader()
        {
            this$0 = TsExtractor.this;
            super();
        }
    }

    static abstract class TsPayloadReader
    {

        public abstract void consume(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput);

        public abstract void seek();

        private TsPayloadReader()
        {
        }

    }


    private static final String TAG = "TsExtractor";
    private static final int TS_PACKET_SIZE = 188;
    private static final int TS_PAT_PID = 0;
    private static final int TS_STREAM_TYPE_AAC = 15;
    private static final int TS_STREAM_TYPE_ATSC_AC3 = 129;
    private static final int TS_STREAM_TYPE_ATSC_E_AC3 = 135;
    private static final int TS_STREAM_TYPE_EIA608 = 256;
    private static final int TS_STREAM_TYPE_H264 = 27;
    private static final int TS_STREAM_TYPE_H265 = 36;
    private static final int TS_STREAM_TYPE_ID3 = 21;
    private static final int TS_STREAM_TYPE_MPA = 3;
    private static final int TS_STREAM_TYPE_MPA_LSF = 4;
    private static final int TS_SYNC_BYTE = 71;
    Id3Reader id3Reader;
    private final boolean idrKeyframesOnly;
    private ExtractorOutput output;
    private final PtsTimestampAdjuster ptsTimestampAdjuster;
    final SparseBooleanArray streamTypes;
    private final ParsableByteArray tsPacketBuffer;
    final SparseArray tsPayloadReaders;
    private final ParsableBitArray tsScratch;

    public TsExtractor()
    {
        this(new PtsTimestampAdjuster(0L));
    }

    public TsExtractor(PtsTimestampAdjuster ptstimestampadjuster)
    {
        this(ptstimestampadjuster, true);
    }

    public TsExtractor(PtsTimestampAdjuster ptstimestampadjuster, boolean flag)
    {
        idrKeyframesOnly = flag;
        tsScratch = new ParsableBitArray(new byte[3]);
        tsPacketBuffer = new ParsableByteArray(188);
        streamTypes = new SparseBooleanArray();
        tsPayloadReaders = new SparseArray();
        tsPayloadReaders.put(0, new PatReader());
        ptsTimestampAdjuster = ptstimestampadjuster;
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        output = extractoroutput;
        extractoroutput.seekMap(SeekMap.UNSEEKABLE);
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        if (!extractorinput.readFully(tsPacketBuffer.data, 0, 188, true))
        {
            return -1;
        }
        tsPacketBuffer.setPosition(0);
        tsPacketBuffer.setLimit(188);
        if (tsPacketBuffer.readUnsignedByte() != 71)
        {
            return 0;
        }
        tsPacketBuffer.readBytes(tsScratch, 3);
        tsScratch.skipBits(1);
        boolean flag = tsScratch.readBit();
        tsScratch.skipBits(1);
        int i = tsScratch.readBits(13);
        tsScratch.skipBits(2);
        boolean flag1 = tsScratch.readBit();
        boolean flag2 = tsScratch.readBit();
        if (flag1)
        {
            int j = tsPacketBuffer.readUnsignedByte();
            tsPacketBuffer.skipBytes(j);
        }
        if (flag2)
        {
            extractorinput = (TsPayloadReader)tsPayloadReaders.get(i);
            if (extractorinput != null)
            {
                extractorinput.consume(tsPacketBuffer, flag, output);
            }
        }
        return 0;
    }

    public final void seek()
    {
        ptsTimestampAdjuster.reset();
        for (int i = 0; i < tsPayloadReaders.size(); i++)
        {
            ((TsPayloadReader)tsPayloadReaders.valueAt(i)).seek();
        }

    }

    public final boolean sniff(ExtractorInput extractorinput)
    {
        byte abyte0[] = new byte[1];
        for (int i = 0; i < 5; i++)
        {
            extractorinput.peekFully(abyte0, 0, 1);
            if ((abyte0[0] & 0xff) != 71)
            {
                return false;
            }
            extractorinput.advancePeekPosition(187);
        }

        return true;
    }


}
