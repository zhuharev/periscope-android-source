// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;

final class VarintReader
{

    private static final int STATE_BEGIN_READING = 0;
    private static final int STATE_READ_CONTENTS = 1;
    private static final int VARINT_LENGTH_MASKS[] = {
        128, 64, 32, 16, 8, 4, 2, 1
    };
    private int length;
    private final byte scratch[] = new byte[8];
    private int state;

    public VarintReader()
    {
    }

    public final int getLastLength()
    {
        return length;
    }

    public final long readUnsignedVarint(ExtractorInput extractorinput, boolean flag, boolean flag1)
    {
        if (state == 0)
        {
            if (!extractorinput.readFully(scratch, 0, 1, flag))
            {
                return -1L;
            }
            byte byte0 = scratch[0];
            length = -1;
            int i = 0;
            do
            {
                if (i >= VARINT_LENGTH_MASKS.length)
                {
                    break;
                }
                if ((VARINT_LENGTH_MASKS[i] & (byte0 & 0xff)) != 0)
                {
                    length = i + 1;
                    break;
                }
                i++;
            } while (true);
            if (length == -1)
            {
                throw new IllegalStateException("No valid varint length mask found");
            }
            state = 1;
        }
        extractorinput.readFully(scratch, 1, length - 1);
        if (flag1)
        {
            extractorinput = scratch;
            extractorinput[0] = (byte)(extractorinput[0] & ~VARINT_LENGTH_MASKS[length - 1]);
        }
        long l = 0L;
        for (int j = 0; j < length; j++)
        {
            l = l << 8 | (long)(scratch[j] & 0xff);
        }

        state = 0;
        return l;
    }

    public final void reset()
    {
        state = 0;
        length = 0;
    }

}
