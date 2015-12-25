// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


public final class LittleEndianConversions
{

    private LittleEndianConversions()
    {
    }

    public static byte[] _mth027E(int i)
    {
        return (new byte[] {
            (byte)i, (byte)(i >>> 8), (byte)(i >>> 16), i >> 24
        });
    }

    public static void _mth02CF(int i, byte abyte0[], int j, int k)
    {
        for (k--; k >= 0; k--)
        {
            abyte0[j + k] = (byte)(i >>> k * 8);
        }

    }

    public static byte[] _mth02CF(int ai[], int i)
    {
        int i1 = ai.length;
        byte abyte0[] = new byte[i];
        int j = 0;
        for (int k = 0; k <= i1 - 2;)
        {
            _mth037A(ai[k], abyte0, j);
            k++;
            j += 4;
        }

        int l = ai[i1 - 1];
        for (i = i - j - 1; i >= 0; i--)
        {
            abyte0[j + i] = (byte)(l >>> i * 8);
        }

        return abyte0;
    }

    public static void _mth037A(int i, byte abyte0[], int j)
    {
        int k = j + 1;
        abyte0[j] = (byte)i;
        j = k + 1;
        abyte0[k] = (byte)(i >>> 8);
        abyte0[j] = (byte)(i >>> 16);
        abyte0[j + 1] = i >> 24;
    }

    public static int[] _mth15AE(byte abyte0[])
    {
        int i1 = (abyte0.length + 3) / 4;
        int j1 = abyte0.length & 3;
        int ai[] = new int[i1];
        int i = 0;
        for (int j = 0; j <= i1 - 2;)
        {
            ai[j] = FE76(abyte0, i);
            j++;
            i += 4;
        }

        if (j1 != 0)
        {
            int l = 0;
            for (int k = j1 - 1; k >= 0; k--)
            {
                l |= (abyte0[i + k] & 0xff) << k * 8;
            }

            ai[i1 - 1] = l;
            return ai;
        } else
        {
            ai[i1 - 1] = FE76(abyte0, i);
            return ai;
        }
    }

    private static int FE76(byte abyte0[], int i)
    {
        int j = i + 1;
        i = abyte0[i];
        int k = j + 1;
        return i & 0xff | (abyte0[j] & 0xff) << 8 | (abyte0[k] & 0xff) << 16 | (abyte0[k + 1] & 0xff) << 24;
    }
}
