// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.util;


public class ArrayEncoder
{

    private static final int aPm[] = {
        0, 0, 0, 1, 1, 1, -1, -1
    };
    private static final int aPn[] = {
        0, 1, -1, 0, 1, -1, 0, 1
    };
    private static final int aPo[] = {
        1, 1, 1, 0, 0, 0, 1, 0, 1
    };
    private static final int aPp[] = {
        1, 1, 1, 1, 0, 0, 0, 1, 0
    };
    private static final int aPq[] = {
        1, 0, 1, 0, 0, 1, 1, 1, 0
    };

    public ArrayEncoder()
    {
    }

    public static byte[] _mth02BC(int ai[], int i)
    {
        int j1 = 31 - Integer.numberOfLeadingZeros(i);
        byte abyte0[] = new byte[(ai.length * j1 + 7) / 8];
        int l = 0;
        i = 0;
        for (int j = 0; j < ai.length; j++)
        {
            for (int k = 0; k < j1;)
            {
                int i1 = ai[j];
                abyte0[i] = (byte)(abyte0[i] | (i1 >> k & 1) << l);
                if (l == 7)
                {
                    l = 0;
                    i1 = i + 1;
                    i = l;
                } else
                {
                    l++;
                    i1 = i;
                    i = l;
                }
                k++;
                l = i;
                i = i1;
            }

        }

        return abyte0;
    }

    public static byte[] FE73(int ai[])
    {
        byte abyte0[] = new byte[((ai.length * 3 + 1) / 2 + 7) / 8];
        int i = 0;
        int j = 0;
        int l;
        for (int k = 0; k < ai.length / 2 << 1; k = l)
        {
            int i1 = k + 1;
            k = ai[k] + 1;
            l = i1 + 1;
            i1 = ai[i1] + 1;
            if (k == 0 && i1 == 0)
            {
                throw new IllegalStateException("Illegal encoding!");
            }
            k = k * 3 + i1;
            i1 = aPo[k];
            int j1 = aPp[k];
            int k1 = aPq[k];
            for (k = 0; k < 3; k++)
            {
                abyte0[j] = (byte)(abyte0[j] | (new int[] {
                    i1, j1, k1
                })[k] << i);
                if (i == 7)
                {
                    i = 0;
                    j++;
                } else
                {
                    i++;
                }
            }

        }

        return abyte0;
    }

    public static int[] FE76(byte abyte0[], int i, int j)
    {
        int ai[] = new int[i];
        int i1 = 31 - Integer.numberOfLeadingZeros(j);
        int l = 0;
        for (j = 0; j < i * i1;)
        {
            int k = l;
            if (j > 0)
            {
                k = l;
                if (j % i1 == 0)
                {
                    k = l + 1;
                }
            }
            l = abyte0[j / 8];
            ai[k] = ai[k] + (((l & 0xff) >> j % 8 & 1) << j % i1);
            j++;
            l = k;
        }

        return ai;
    }

    public static int[] FF70(byte abyte0[], int i)
    {
        int ai[] = new int[i];
        int k = 0;
        int j = 0;
        do
        {
            int l = j;
            if (l >= abyte0.length << 3)
            {
                break;
            }
            int i1 = l + 1;
            byte byte0 = abyte0[l / 8];
            int j1 = i1 + 1;
            byte byte1 = abyte0[i1 / 8];
            j = j1 + 1;
            l = (((byte0 & 0xff) >> l % 8 & 1) << 2) + (((byte1 & 0xff) >> i1 % 8 & 1) << 1) + ((abyte0[j1 / 8] & 0xff) >> j1 % 8 & 1);
            i1 = k + 1;
            ai[k] = aPm[l];
            k = i1 + 1;
            ai[i1] = aPn[l];
        } while (k <= i - 2);
        return ai;
    }

}
