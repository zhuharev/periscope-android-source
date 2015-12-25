// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer
{

    private boolean isCompleted;
    private boolean isFilling;
    public byte nalData[];
    public int nalLength;
    private final int targetType;

    public NalUnitTargetBuffer(int i, int j)
    {
        targetType = i;
        nalData = new byte[j + 3];
        nalData[2] = 1;
    }

    public final void appendToNalUnit(byte abyte0[], int i, int j)
    {
        if (!isFilling)
        {
            return;
        }
        j -= i;
        if (nalData.length < nalLength + j)
        {
            nalData = Arrays.copyOf(nalData, nalLength + j << 1);
        }
        System.arraycopy(abyte0, i, nalData, nalLength, j);
        nalLength = nalLength + j;
    }

    public final boolean endNalUnit(int i)
    {
        if (!isFilling)
        {
            return false;
        } else
        {
            nalLength = nalLength - i;
            isFilling = false;
            isCompleted = true;
            return true;
        }
    }

    public final boolean isCompleted()
    {
        return isCompleted;
    }

    public final void reset()
    {
        isFilling = false;
        isCompleted = false;
    }

    public final void startNalUnit(int i)
    {
        boolean flag;
        if (!isFilling)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (i == targetType)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isFilling = flag;
        if (isFilling)
        {
            nalLength = 3;
            isCompleted = false;
        }
    }
}
