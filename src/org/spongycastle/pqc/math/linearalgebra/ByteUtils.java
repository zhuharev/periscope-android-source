// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


public final class ByteUtils
{

    private ByteUtils()
    {
    }

    public static boolean equals(byte abyte0[], byte abyte1[])
    {
        if (abyte0 == null)
        {
            return abyte1 == null;
        }
        if (abyte1 == null)
        {
            return false;
        }
        if (abyte0.length != abyte1.length)
        {
            return false;
        }
        boolean flag1 = true;
        for (int i = abyte0.length - 1; i >= 0; i--)
        {
            boolean flag;
            if (abyte0[i] == abyte1[i])
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 &= flag;
        }

        return flag1;
    }

    public static byte[] _mth0640(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length + abyte1.length];
        System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
        System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
        return abyte2;
    }

    public static byte[] _mth1D62(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, 0, abyte1, 0, j);
        return abyte1;
    }

    public static byte[][] _mth2071(byte abyte0[], int i)
    {
        if (i > abyte0.length)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            byte abyte1[][] = new byte[2][];
            abyte1[0] = new byte[i];
            abyte1[1] = new byte[abyte0.length - i];
            System.arraycopy(abyte0, 0, abyte1[0], 0, i);
            System.arraycopy(abyte0, i, abyte1[1], 0, abyte0.length - i);
            return abyte1;
        }
    }
}
