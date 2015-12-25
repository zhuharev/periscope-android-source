// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.ParsableByteArray;

final class TrackFragment
{

    public boolean definesEncryptionData;
    public int length;
    public int sampleCompositionTimeOffsetTable[];
    public long sampleDecodingTimeTable[];
    public int sampleDescriptionIndex;
    public ParsableByteArray sampleEncryptionData;
    public int sampleEncryptionDataLength;
    public boolean sampleEncryptionDataNeedsFill;
    public boolean sampleHasSubsampleEncryptionTable[];
    public boolean sampleIsSyncFrameTable[];
    public int sampleSizeTable[];

    TrackFragment()
    {
    }

    public final void fillEncryptionData(ExtractorInput extractorinput)
    {
        extractorinput.readFully(sampleEncryptionData.data, 0, sampleEncryptionDataLength);
        sampleEncryptionData.setPosition(0);
        sampleEncryptionDataNeedsFill = false;
    }

    public final void fillEncryptionData(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.readBytes(sampleEncryptionData.data, 0, sampleEncryptionDataLength);
        sampleEncryptionData.setPosition(0);
        sampleEncryptionDataNeedsFill = false;
    }

    public final long getSamplePresentationTime(int i)
    {
        return sampleDecodingTimeTable[i] + (long)sampleCompositionTimeOffsetTable[i];
    }

    public final void initEncryptionData(int i)
    {
        if (sampleEncryptionData == null || sampleEncryptionData.limit() < i)
        {
            sampleEncryptionData = new ParsableByteArray(i);
        }
        sampleEncryptionDataLength = i;
        definesEncryptionData = true;
        sampleEncryptionDataNeedsFill = true;
    }

    public final void initTables(int i)
    {
        length = i;
        if (sampleSizeTable == null || sampleSizeTable.length < length)
        {
            i = (i * 125) / 100;
            sampleSizeTable = new int[i];
            sampleCompositionTimeOffsetTable = new int[i];
            sampleDecodingTimeTable = new long[i];
            sampleIsSyncFrameTable = new boolean[i];
            sampleHasSubsampleEncryptionTable = new boolean[i];
        }
    }

    public final void reset()
    {
        length = 0;
        definesEncryptionData = false;
        sampleEncryptionDataNeedsFill = false;
    }
}
