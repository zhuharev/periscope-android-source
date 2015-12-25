// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.util.Collections;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            ElementaryStreamReader, NalUnitTargetBuffer, SeiReader

final class H265Reader extends ElementaryStreamReader
{
    static final class SampleReader
    {

        private static final int FIRST_SLICE_FLAG_OFFSET = 2;
        private boolean firstSliceFlag;
        private boolean lookingForFirstSliceFlag;
        private int nalUnitBytesRead;
        private boolean nalUnitHasKeyframeData;
        private long nalUnitStartPosition;
        private final TrackOutput output;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;

        private void outputSample(int i)
        {
            int j;
            if (sampleIsKeyframe)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            int k = (int)(nalUnitStartPosition - samplePosition);
            output.sampleMetadata(sampleTimeUs, j, k, i, null);
        }

        public final void endNalUnit(long l, int i, long l1)
        {
            if (firstSliceFlag)
            {
                if (readingSample)
                {
                    outputSample(i + (int)(l - nalUnitStartPosition));
                }
                samplePosition = nalUnitStartPosition;
                sampleTimeUs = l1;
                readingSample = true;
                sampleIsKeyframe = nalUnitHasKeyframeData;
            }
        }

        public final void readNalUnitData(byte abyte0[], int i, int j)
        {
            if (lookingForFirstSliceFlag)
            {
                int k = (i + 2) - nalUnitBytesRead;
                if (k < j)
                {
                    boolean flag;
                    if ((abyte0[k] & 0x80) != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    firstSliceFlag = flag;
                    lookingForFirstSliceFlag = false;
                    return;
                }
                nalUnitBytesRead = nalUnitBytesRead + (j - i);
            }
        }

        public final void reset()
        {
            lookingForFirstSliceFlag = false;
            firstSliceFlag = false;
            readingSample = false;
        }

        public final void startNalUnit(long l, int i, int j)
        {
            firstSliceFlag = false;
            nalUnitBytesRead = 0;
            nalUnitStartPosition = l;
            if (j >= 32 && readingSample)
            {
                outputSample(i);
                readingSample = false;
            }
            boolean flag;
            if (j >= 16 && j <= 21)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            nalUnitHasKeyframeData = flag;
            if (nalUnitHasKeyframeData || j <= 9)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            lookingForFirstSliceFlag = flag;
        }

        public SampleReader(TrackOutput trackoutput)
        {
            output = trackoutput;
        }
    }


    private static final int BLA_W_LP = 16;
    private static final int CRA_NUT = 21;
    private static final int PPS_NUT = 34;
    private static final int PREFIX_SEI_NUT = 39;
    private static final int RASL_R = 9;
    private static final int SPS_NUT = 33;
    private static final int SUFFIX_SEI_NUT = 40;
    private static final String TAG = "H265Reader";
    private static final int VPS_NUT = 32;
    private boolean hasOutputFormat;
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(34, 128);
    private final boolean prefixFlags[] = new boolean[3];
    private final NalUnitTargetBuffer prefixSei = new NalUnitTargetBuffer(39, 128);
    private final SampleReader sampleReader;
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper = new ParsableByteArray();
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(33, 128);
    private final NalUnitTargetBuffer suffixSei = new NalUnitTargetBuffer(40, 128);
    private long totalBytesWritten;
    private final NalUnitTargetBuffer vps = new NalUnitTargetBuffer(32, 128);

    public H265Reader(TrackOutput trackoutput, SeiReader seireader)
    {
        super(trackoutput);
        seiReader = seireader;
        sampleReader = new SampleReader(trackoutput);
    }

    private void nalUnitData(byte abyte0[], int i, int j)
    {
        if (hasOutputFormat)
        {
            sampleReader.readNalUnitData(abyte0, i, j);
        } else
        {
            vps.appendToNalUnit(abyte0, i, j);
            sps.appendToNalUnit(abyte0, i, j);
            pps.appendToNalUnit(abyte0, i, j);
        }
        prefixSei.appendToNalUnit(abyte0, i, j);
        suffixSei.appendToNalUnit(abyte0, i, j);
    }

    private void nalUnitEnd(long l, int i, int j, long l1)
    {
        if (hasOutputFormat)
        {
            sampleReader.endNalUnit(l, i, l1);
        } else
        {
            vps.endNalUnit(j);
            sps.endNalUnit(j);
            pps.endNalUnit(j);
            if (vps.isCompleted() && sps.isCompleted() && pps.isCompleted())
            {
                parseMediaFormat(vps, sps, pps);
            }
        }
        if (prefixSei.endNalUnit(j))
        {
            i = NalUnitUtil.unescapeStream(prefixSei.nalData, prefixSei.nalLength);
            seiWrapper.reset(prefixSei.nalData, i);
            seiWrapper.skipBytes(5);
            seiReader.consume(seiWrapper, l1, true);
        }
        if (suffixSei.endNalUnit(j))
        {
            i = NalUnitUtil.unescapeStream(suffixSei.nalData, suffixSei.nalLength);
            seiWrapper.reset(suffixSei.nalData, i);
            seiWrapper.skipBytes(5);
            seiReader.consume(seiWrapper, l1, true);
        }
    }

    private void parseMediaFormat(NalUnitTargetBuffer nalunittargetbuffer, NalUnitTargetBuffer nalunittargetbuffer1, NalUnitTargetBuffer nalunittargetbuffer2)
    {
        byte abyte0[] = new byte[nalunittargetbuffer.nalLength + nalunittargetbuffer1.nalLength + nalunittargetbuffer2.nalLength];
        System.arraycopy(nalunittargetbuffer.nalData, 0, abyte0, 0, nalunittargetbuffer.nalLength);
        System.arraycopy(nalunittargetbuffer1.nalData, 0, abyte0, nalunittargetbuffer.nalLength, nalunittargetbuffer1.nalLength);
        System.arraycopy(nalunittargetbuffer2.nalData, 0, abyte0, nalunittargetbuffer.nalLength + nalunittargetbuffer1.nalLength, nalunittargetbuffer2.nalLength);
        NalUnitUtil.unescapeStream(nalunittargetbuffer1.nalData, nalunittargetbuffer1.nalLength);
        nalunittargetbuffer = new ParsableBitArray(nalunittargetbuffer1.nalData);
        nalunittargetbuffer.skipBits(44);
        int l1 = nalunittargetbuffer.readBits(3);
        nalunittargetbuffer.skipBits(1);
        nalunittargetbuffer.skipBits(88);
        nalunittargetbuffer.skipBits(8);
        int i = 0;
        for (int j1 = 0; j1 < l1; j1++)
        {
            int l = i;
            if (nalunittargetbuffer.readBits(1) == 1)
            {
                l = i + 89;
            }
            i = l;
            if (nalunittargetbuffer.readBits(1) == 1)
            {
                i = l + 8;
            }
        }

        nalunittargetbuffer.skipBits(i);
        if (l1 > 0)
        {
            nalunittargetbuffer.skipBits((8 - l1) * 2);
        }
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        int k3 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        if (k3 == 3)
        {
            nalunittargetbuffer.skipBits(1);
        }
        int k2 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        int j2 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        int k1 = j2;
        int i1 = k2;
        if (nalunittargetbuffer.readBit())
        {
            int i3 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            int j3 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            k1 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            int l2 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            if (k3 == 1 || k3 == 2)
            {
                i = 2;
            } else
            {
                i = 1;
            }
            if (k3 == 1)
            {
                i1 = 2;
            } else
            {
                i1 = 1;
            }
            i = k2 - (i3 + j3) * i;
            k1 = j2 - (k1 + l2) * i1;
            i1 = i;
        }
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        j2 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        if (nalunittargetbuffer.readBit())
        {
            i = 0;
        } else
        {
            i = l1;
        }
        for (; i <= l1; i++)
        {
            nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        }

        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        if (nalunittargetbuffer.readBit() && nalunittargetbuffer.readBit())
        {
            skipScalingList(nalunittargetbuffer);
        }
        nalunittargetbuffer.skipBits(2);
        if (nalunittargetbuffer.readBit())
        {
            nalunittargetbuffer.skipBits(8);
            nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            nalunittargetbuffer.skipBits(1);
        }
        skipShortTermRefPicSets(nalunittargetbuffer);
        if (nalunittargetbuffer.readBit())
        {
            for (int j = 0; j < nalunittargetbuffer.readUnsignedExpGolombCodedInt(); j++)
            {
                nalunittargetbuffer.skipBits(j2 + 4 + 1);
            }

        }
        nalunittargetbuffer.skipBits(2);
        float f1 = 1.0F;
        float f = f1;
        if (nalunittargetbuffer.readBit())
        {
            f = f1;
            if (nalunittargetbuffer.readBit())
            {
                int k = nalunittargetbuffer.readBits(8);
                if (k == 255)
                {
                    k = nalunittargetbuffer.readBits(16);
                    int i2 = nalunittargetbuffer.readBits(16);
                    f = f1;
                    if (k != 0)
                    {
                        f = f1;
                        if (i2 != 0)
                        {
                            f = (float)k / (float)i2;
                        }
                    }
                } else
                if (k < NalUnitUtil.ASPECT_RATIO_IDC_VALUES.length)
                {
                    f = NalUnitUtil.ASPECT_RATIO_IDC_VALUES[k];
                } else
                {
                    Log.w("H265Reader", (new StringBuilder("Unexpected aspect_ratio_idc value: ")).append(k).toString());
                    f = f1;
                }
            }
        }
        output.format(MediaFormat.createVideoFormat(-1, "video/hevc", -1, -1, -1L, i1, k1, Collections.singletonList(abyte0), -1, f));
        hasOutputFormat = true;
    }

    private void skipScalingList(ParsableBitArray parsablebitarray)
    {
        for (int i = 0; i < 4; i++)
        {
            byte byte0;
            for (int j = 0; j < 6; j += byte0)
            {
                if (!parsablebitarray.readBit())
                {
                    parsablebitarray.readUnsignedExpGolombCodedInt();
                } else
                {
                    int l = Math.min(64, 1 << (i << 1) + 4);
                    if (i > 1)
                    {
                        parsablebitarray.readSignedExpGolombCodedInt();
                    }
                    for (int k = 0; k < l; k++)
                    {
                        parsablebitarray.readSignedExpGolombCodedInt();
                    }

                }
                if (i == 3)
                {
                    byte0 = 3;
                } else
                {
                    byte0 = 1;
                }
            }

        }

    }

    private static void skipShortTermRefPicSets(ParsableBitArray parsablebitarray)
    {
        int j1 = parsablebitarray.readUnsignedExpGolombCodedInt();
        boolean flag = false;
        int j = 0;
label0:
        for (int i = 0; i < j1; i++)
        {
            if (i != 0)
            {
                flag = parsablebitarray.readBit();
            }
            if (flag)
            {
                parsablebitarray.skipBits(1);
                parsablebitarray.readUnsignedExpGolombCodedInt();
                int k = 0;
                do
                {
                    if (k > j)
                    {
                        continue label0;
                    }
                    if (parsablebitarray.readBit())
                    {
                        parsablebitarray.skipBits(1);
                    }
                    k++;
                } while (true);
            }
            int l = parsablebitarray.readUnsignedExpGolombCodedInt();
            int k1 = parsablebitarray.readUnsignedExpGolombCodedInt();
            int i1 = l + k1;
            for (j = 0; j < l; j++)
            {
                parsablebitarray.readUnsignedExpGolombCodedInt();
                parsablebitarray.skipBits(1);
            }

            l = 0;
            do
            {
                j = i1;
                if (l >= k1)
                {
                    continue label0;
                }
                parsablebitarray.readUnsignedExpGolombCodedInt();
                parsablebitarray.skipBits(1);
                l++;
            } while (true);
        }

    }

    private void startNalUnit(long l, int i, int j)
    {
        if (!hasOutputFormat)
        {
            vps.startNalUnit(j);
            sps.startNalUnit(j);
            pps.startNalUnit(j);
        }
        prefixSei.startNalUnit(j);
        suffixSei.startNalUnit(j);
        sampleReader.startNalUnit(l, i, j);
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
                        nalUnitData(abyte0, i, k);
                    }
                    int i1 = j - k;
                    long l1 = totalBytesWritten - (long)i1;
                    if (j1 < 0)
                    {
                        i = -j1;
                    } else
                    {
                        i = 0;
                    }
                    nalUnitEnd(l1, i1, i, l);
                    startNalUnit(l1, i1, NalUnitUtil.getH265NalUnitType(abyte0, k));
                    i = k + 3;
                } else
                {
                    nalUnitData(abyte0, i, j);
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
        vps.reset();
        sps.reset();
        pps.reset();
        prefixSei.reset();
        suffixSei.reset();
        sampleReader.reset();
        totalBytesWritten = 0L;
    }
}
