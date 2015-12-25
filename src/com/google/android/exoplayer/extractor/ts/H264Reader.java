// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.CodecSpecificDataUtil;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            ElementaryStreamReader, NalUnitTargetBuffer, SeiReader

final class H264Reader extends ElementaryStreamReader
{
    static final class IfrParserBuffer
    {

        private static final int DEFAULT_BUFFER_SIZE = 128;
        private static final int NOT_SET = -1;
        private byte ifrData[];
        private int ifrLength;
        private boolean isFilling;
        private final ParsableBitArray scratchSliceType;
        private int sliceType;

        public final void appendToNalUnit(byte abyte0[], int i, int j)
        {
            if (!isFilling)
            {
                return;
            }
            j -= i;
            if (ifrData.length < ifrLength + j)
            {
                ifrData = Arrays.copyOf(ifrData, ifrLength + j << 1);
            }
            System.arraycopy(abyte0, i, ifrData, ifrLength, j);
            ifrLength = ifrLength + j;
            scratchSliceType.reset(ifrData, ifrLength);
            scratchSliceType.skipBits(8);
            i = scratchSliceType.peekExpGolombCodedNumLength();
            if (i == -1 || i > scratchSliceType.bitsLeft())
            {
                return;
            }
            scratchSliceType.skipBits(i);
            i = scratchSliceType.peekExpGolombCodedNumLength();
            if (i == -1 || i > scratchSliceType.bitsLeft())
            {
                return;
            } else
            {
                sliceType = scratchSliceType.readUnsignedExpGolombCodedInt();
                isFilling = false;
                return;
            }
        }

        public final int getSliceType()
        {
            return sliceType;
        }

        public final boolean isCompleted()
        {
            return sliceType != -1;
        }

        public final void reset()
        {
            isFilling = false;
            ifrLength = 0;
            sliceType = -1;
        }

        public final void startNalUnit(int i)
        {
            if (i == 1)
            {
                reset();
                isFilling = true;
            }
        }

        public IfrParserBuffer()
        {
            ifrData = new byte[128];
            scratchSliceType = new ParsableBitArray(ifrData);
            reset();
        }
    }


    private static final int FRAME_TYPE_ALL_I = 7;
    private static final int FRAME_TYPE_I = 2;
    private static final int NAL_UNIT_TYPE_AUD = 9;
    private static final int NAL_UNIT_TYPE_IDR = 5;
    private static final int NAL_UNIT_TYPE_IFR = 1;
    private static final int NAL_UNIT_TYPE_PPS = 8;
    private static final int NAL_UNIT_TYPE_SEI = 6;
    private static final int NAL_UNIT_TYPE_SPS = 7;
    private boolean foundFirstSample;
    private boolean hasOutputFormat;
    private final IfrParserBuffer ifrParserBuffer;
    private boolean isKeyframe;
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(8, 128);
    private final boolean prefixFlags[] = new boolean[3];
    private long samplePosition;
    private long sampleTimeUs;
    private final NalUnitTargetBuffer sei = new NalUnitTargetBuffer(6, 128);
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper = new ParsableByteArray();
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(7, 128);
    private long totalBytesWritten;

    public H264Reader(TrackOutput trackoutput, SeiReader seireader, boolean flag)
    {
        super(trackoutput);
        seiReader = seireader;
        if (flag)
        {
            trackoutput = null;
        } else
        {
            trackoutput = new IfrParserBuffer();
        }
        ifrParserBuffer = trackoutput;
    }

    private void feedNalUnitTargetBuffersData(byte abyte0[], int i, int j)
    {
        if (ifrParserBuffer != null)
        {
            ifrParserBuffer.appendToNalUnit(abyte0, i, j);
        }
        if (!hasOutputFormat)
        {
            sps.appendToNalUnit(abyte0, i, j);
            pps.appendToNalUnit(abyte0, i, j);
        }
        sei.appendToNalUnit(abyte0, i, j);
    }

    private void feedNalUnitTargetBuffersStart(int i)
    {
        if (ifrParserBuffer != null)
        {
            ifrParserBuffer.startNalUnit(i);
        }
        if (!hasOutputFormat)
        {
            sps.startNalUnit(i);
            pps.startNalUnit(i);
        }
        sei.startNalUnit(i);
    }

    private void feedNalUnitTargetEnd(long l, int i)
    {
        sps.endNalUnit(i);
        pps.endNalUnit(i);
        if (sei.endNalUnit(i))
        {
            i = NalUnitUtil.unescapeStream(sei.nalData, sei.nalLength);
            seiWrapper.reset(sei.nalData, i);
            seiWrapper.setPosition(4);
            seiReader.consume(seiWrapper, l, true);
        }
    }

    private void parseMediaFormat(NalUnitTargetBuffer nalunittargetbuffer, NalUnitTargetBuffer nalunittargetbuffer1)
    {
        byte abyte0[] = new byte[nalunittargetbuffer.nalLength];
        byte abyte1[] = new byte[nalunittargetbuffer1.nalLength];
        System.arraycopy(nalunittargetbuffer.nalData, 0, abyte0, 0, nalunittargetbuffer.nalLength);
        System.arraycopy(nalunittargetbuffer1.nalData, 0, abyte1, 0, nalunittargetbuffer1.nalLength);
        nalunittargetbuffer1 = new ArrayList();
        nalunittargetbuffer1.add(abyte0);
        nalunittargetbuffer1.add(abyte1);
        NalUnitUtil.unescapeStream(nalunittargetbuffer.nalData, nalunittargetbuffer.nalLength);
        nalunittargetbuffer = new ParsableBitArray(nalunittargetbuffer.nalData);
        nalunittargetbuffer.skipBits(32);
        nalunittargetbuffer = CodecSpecificDataUtil.parseSpsNalUnit(nalunittargetbuffer);
        output.format(MediaFormat.createVideoFormat(-1, "video/avc", -1, -1, -1L, ((com.google.android.exoplayer.util.CodecSpecificDataUtil.SpsData) (nalunittargetbuffer)).width, ((com.google.android.exoplayer.util.CodecSpecificDataUtil.SpsData) (nalunittargetbuffer)).height, nalunittargetbuffer1, -1, ((com.google.android.exoplayer.util.CodecSpecificDataUtil.SpsData) (nalunittargetbuffer)).pixelWidthAspectRatio));
        hasOutputFormat = true;
    }

    public final void consume(ParsableByteArray parsablebytearray, long l, boolean flag)
    {
        while (parsablebytearray.bytesLeft() > 0) 
        {
            int i = parsablebytearray.getPosition();
            int j = parsablebytearray.limit();
            byte abyte0[] = parsablebytearray.data;
            totalBytesWritten = totalBytesWritten + (long)parsablebytearray.bytesLeft();
            output.sampleData(parsablebytearray, parsablebytearray.bytesLeft());
            while (i < j) 
            {
                int k = NalUnitUtil.findNalUnit(abyte0, i, j, prefixFlags);
                if (k < j)
                {
                    int j1 = k - i;
                    if (j1 > 0)
                    {
                        feedNalUnitTargetBuffersData(abyte0, i, k);
                    }
                    int i1 = NalUnitUtil.getNalUnitType(abyte0, k);
                    int k1 = j - k;
                    switch (i1)
                    {
                    case 5: // '\005'
                        isKeyframe = true;
                        break;

                    case 9: // '\t'
                        if (foundFirstSample)
                        {
                            if (ifrParserBuffer != null && ifrParserBuffer.isCompleted())
                            {
                                i = ifrParserBuffer.getSliceType();
                                flag = isKeyframe;
                                if (i == 2 || i == 7)
                                {
                                    i = 1;
                                } else
                                {
                                    i = 0;
                                }
                                isKeyframe = flag | i;
                                ifrParserBuffer.reset();
                            }
                            if (isKeyframe && !hasOutputFormat && sps.isCompleted() && pps.isCompleted())
                            {
                                parseMediaFormat(sps, pps);
                            }
                            if (isKeyframe)
                            {
                                i = 1;
                            } else
                            {
                                i = 0;
                            }
                            int l1 = (int)(totalBytesWritten - samplePosition);
                            output.sampleMetadata(sampleTimeUs, i, l1 - k1, k1, null);
                        }
                        foundFirstSample = true;
                        samplePosition = totalBytesWritten - (long)k1;
                        sampleTimeUs = l;
                        isKeyframe = false;
                        break;
                    }
                    if (j1 < 0)
                    {
                        i = -j1;
                    } else
                    {
                        i = 0;
                    }
                    feedNalUnitTargetEnd(l, i);
                    feedNalUnitTargetBuffersStart(i1);
                    i = k + 3;
                } else
                {
                    feedNalUnitTargetBuffersData(abyte0, i, j);
                    i = j;
                }
            }
        }
    }

    public final void packetFinished()
    {
    }

    public final void seek()
    {
        seiReader.seek();
        NalUnitUtil.clearPrefixFlags(prefixFlags);
        sps.reset();
        pps.reset();
        sei.reset();
        if (ifrParserBuffer != null)
        {
            ifrParserBuffer.reset();
        }
        foundFirstSample = false;
        totalBytesWritten = 0L;
    }
}
