// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.util.ParsableBitArray;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            H264Reader

static final class reset
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

    public ()
    {
        ifrData = new byte[128];
        scratchSliceType = new ParsableBitArray(ifrData);
        reset();
    }
}
