// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.exoplayer.util:
//            ParsableBitArray, Assertions

public final class ParsableByteArray
{

    public byte data[];
    private int limit;
    private int position;

    public ParsableByteArray()
    {
    }

    public ParsableByteArray(int i)
    {
        data = new byte[i];
        limit = data.length;
    }

    public ParsableByteArray(byte abyte0[])
    {
        data = abyte0;
        limit = abyte0.length;
    }

    public ParsableByteArray(byte abyte0[], int i)
    {
        data = abyte0;
        limit = i;
    }

    public final int bytesLeft()
    {
        return limit - position;
    }

    public final int capacity()
    {
        if (data == null)
        {
            return 0;
        } else
        {
            return data.length;
        }
    }

    public final int getPosition()
    {
        return position;
    }

    public final int limit()
    {
        return limit;
    }

    public final void readBytes(ParsableBitArray parsablebitarray, int i)
    {
        readBytes(parsablebitarray.data, 0, i);
        parsablebitarray.setPosition(0);
    }

    public final void readBytes(ByteBuffer bytebuffer, int i)
    {
        bytebuffer.put(data, position, i);
        position = position + i;
    }

    public final void readBytes(byte abyte0[], int i, int j)
    {
        System.arraycopy(data, position, abyte0, i, j);
        position = position + j;
    }

    public final int readInt()
    {
        byte abyte0[] = data;
        int i = position;
        position = i + 1;
        i = abyte0[i];
        abyte0 = data;
        int j = position;
        position = j + 1;
        j = abyte0[j];
        abyte0 = data;
        int k = position;
        position = k + 1;
        k = abyte0[k];
        abyte0 = data;
        int l = position;
        position = l + 1;
        return (i & 0xff) << 24 | (j & 0xff) << 16 | (k & 0xff) << 8 | abyte0[l] & 0xff;
    }

    public final long readLong()
    {
        byte abyte0[] = data;
        int i = position;
        position = i + 1;
        long l = abyte0[i];
        abyte0 = data;
        i = position;
        position = i + 1;
        long l1 = abyte0[i];
        abyte0 = data;
        i = position;
        position = i + 1;
        long l2 = abyte0[i];
        abyte0 = data;
        i = position;
        position = i + 1;
        long l3 = abyte0[i];
        abyte0 = data;
        i = position;
        position = i + 1;
        long l4 = abyte0[i];
        abyte0 = data;
        i = position;
        position = i + 1;
        long l5 = abyte0[i];
        abyte0 = data;
        i = position;
        position = i + 1;
        long l6 = abyte0[i];
        abyte0 = data;
        i = position;
        position = i + 1;
        return (l & 255L) << 56 | (l1 & 255L) << 48 | (l2 & 255L) << 40 | (l3 & 255L) << 32 | (l4 & 255L) << 24 | (l5 & 255L) << 16 | (l6 & 255L) << 8 | (long)abyte0[i] & 255L;
    }

    public final int readSynchSafeInt()
    {
        return readUnsignedByte() << 21 | readUnsignedByte() << 14 | readUnsignedByte() << 7 | readUnsignedByte();
    }

    public final int readUnsignedByte()
    {
        byte abyte0[] = data;
        int i = position;
        position = i + 1;
        return abyte0[i] & 0xff;
    }

    public final int readUnsignedFixedPoint1616()
    {
        byte abyte0[] = data;
        int i = position;
        position = i + 1;
        i = abyte0[i];
        abyte0 = data;
        int j = position;
        position = j + 1;
        j = abyte0[j];
        position = position + 2;
        return (i & 0xff) << 8 | j & 0xff;
    }

    public final long readUnsignedInt()
    {
        byte abyte0[] = data;
        int i = position;
        position = i + 1;
        long l = abyte0[i];
        abyte0 = data;
        i = position;
        position = i + 1;
        long l1 = abyte0[i];
        abyte0 = data;
        i = position;
        position = i + 1;
        long l2 = abyte0[i];
        abyte0 = data;
        i = position;
        position = i + 1;
        return (l & 255L) << 24 | (l1 & 255L) << 16 | (l2 & 255L) << 8 | (long)abyte0[i] & 255L;
    }

    public final int readUnsignedInt24()
    {
        byte abyte0[] = data;
        int i = position;
        position = i + 1;
        i = abyte0[i];
        abyte0 = data;
        int j = position;
        position = j + 1;
        j = abyte0[j];
        abyte0 = data;
        int k = position;
        position = k + 1;
        return (i & 0xff) << 16 | (j & 0xff) << 8 | abyte0[k] & 0xff;
    }

    public final int readUnsignedIntToInt()
    {
        int i = readInt();
        if (i < 0)
        {
            throw new IllegalStateException((new StringBuilder("Top bit not zero: ")).append(i).toString());
        } else
        {
            return i;
        }
    }

    public final long readUnsignedLongToLong()
    {
        long l = readLong();
        if (l < 0L)
        {
            throw new IllegalStateException((new StringBuilder("Top bit not zero: ")).append(l).toString());
        } else
        {
            return l;
        }
    }

    public final int readUnsignedShort()
    {
        byte abyte0[] = data;
        int i = position;
        position = i + 1;
        i = abyte0[i];
        abyte0 = data;
        int j = position;
        position = j + 1;
        return (i & 0xff) << 8 | abyte0[j] & 0xff;
    }

    public final void reset()
    {
        position = 0;
        limit = 0;
    }

    public final void reset(byte abyte0[], int i)
    {
        data = abyte0;
        limit = i;
        position = 0;
    }

    public final void setLimit(int i)
    {
        boolean flag;
        if (i >= 0 && i <= data.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        limit = i;
    }

    public final void setPosition(int i)
    {
        boolean flag;
        if (i >= 0 && i <= limit)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        position = i;
    }

    public final void skipBytes(int i)
    {
        setPosition(position + i);
    }
}
