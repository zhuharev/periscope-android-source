// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.extractor.TrackOutput;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            H265Reader

static final class output
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

    public (TrackOutput trackoutput)
    {
        output = trackoutput;
    }
}
