// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;


// Referenced classes of package com.google.android.exoplayer.util:
//            Assertions

public final class ParsableBitArray
{

    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte data[];

    public ParsableBitArray()
    {
    }

    public ParsableBitArray(byte abyte0[])
    {
        this(abyte0, abyte0.length);
    }

    public ParsableBitArray(byte abyte0[], int i)
    {
        data = abyte0;
        byteLimit = i;
    }

    private void assertValidOffset()
    {
        boolean flag;
        if (byteOffset >= 0 && bitOffset >= 0 && bitOffset < 8 && (byteOffset < byteLimit || byteOffset == byteLimit && bitOffset == 0))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
    }

    private int readExpGolombCodeNum()
    {
        int i;
        for (i = 0; !readBit(); i++) { }
        int j;
        if (i > 0)
        {
            j = readBits(i);
        } else
        {
            j = 0;
        }
        return ((1 << i) - 1) + j;
    }

    public final int bitsLeft()
    {
        return (byteLimit - byteOffset << 3) - bitOffset;
    }

    public final int getPosition()
    {
        return (byteOffset << 3) + bitOffset;
    }

    public final int peekExpGolombCodedNumLength()
    {
        int j = byteOffset;
        int k = bitOffset;
        int i;
        for (i = 0; byteOffset < byteLimit && !readBit(); i++) { }
        boolean flag;
        if (byteOffset == byteLimit)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        byteOffset = j;
        bitOffset = k;
        if (flag)
        {
            return -1;
        } else
        {
            return (i << 1) + 1;
        }
    }

    public final boolean readBit()
    {
        return readBits(1) == 1;
    }

    public final int readBits(int i)
    {
        if (i == 0)
        {
            return 0;
        }
        boolean flag = false;
        int i1 = i / 8;
        int k = 0;
        int j = i;
        i = ((flag) ? 1 : 0);
        for (; k < i1; k++)
        {
            int l;
            if (bitOffset != 0)
            {
                l = (data[byteOffset] & 0xff) << bitOffset | (data[byteOffset + 1] & 0xff) >>> 8 - bitOffset;
            } else
            {
                l = data[byteOffset];
            }
            j -= 8;
            i |= (l & 0xff) << j;
            byteOffset = byteOffset + 1;
        }

        k = i;
        if (j > 0)
        {
            k = bitOffset + j;
            j = (byte)(255 >> 8 - j);
            if (k > 8)
            {
                i |= ((data[byteOffset] & 0xff) << k - 8 | (data[byteOffset + 1] & 0xff) >> 16 - k) & j;
                byteOffset = byteOffset + 1;
            } else
            {
                j = i | (data[byteOffset] & 0xff) >> 8 - k & j;
                i = j;
                if (k == 8)
                {
                    byteOffset = byteOffset + 1;
                    i = j;
                }
            }
            bitOffset = k % 8;
            k = i;
        }
        assertValidOffset();
        return k;
    }

    public final int readSignedExpGolombCodedInt()
    {
        int i = readExpGolombCodeNum();
        byte byte0;
        if (i % 2 == 0)
        {
            byte0 = -1;
        } else
        {
            byte0 = 1;
        }
        return byte0 * ((i + 1) / 2);
    }

    public final int readUnsignedExpGolombCodedInt()
    {
        return readExpGolombCodeNum();
    }

    public final void reset(byte abyte0[])
    {
        reset(abyte0, abyte0.length);
    }

    public final void reset(byte abyte0[], int i)
    {
        data = abyte0;
        byteOffset = 0;
        bitOffset = 0;
        byteLimit = i;
    }

    public final void setPosition(int i)
    {
        byteOffset = i / 8;
        bitOffset = i - (byteOffset << 3);
        assertValidOffset();
    }

    public final void skipBits(int i)
    {
        byteOffset = byteOffset + i / 8;
        bitOffset = bitOffset + i % 8;
        if (bitOffset > 7)
        {
            byteOffset = byteOffset + 1;
            bitOffset = bitOffset - 8;
        }
        assertValidOffset();
    }
}
