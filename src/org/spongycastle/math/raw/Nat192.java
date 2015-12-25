// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.math.raw:
//            Nat

public abstract class Nat192
{

    public Nat192()
    {
    }

    public static int _mth02BD(int ai[], int ai1[], int ai2[])
    {
        long l = 0L + (((long)ai[0] & 0xffffffffL) + ((long)ai1[0] & 0xffffffffL));
        ai2[0] = (int)l;
        l = (l >>> 32) + (((long)ai[1] & 0xffffffffL) + ((long)ai1[1] & 0xffffffffL));
        ai2[1] = (int)l;
        l = (l >>> 32) + (((long)ai[2] & 0xffffffffL) + ((long)ai1[2] & 0xffffffffL));
        ai2[2] = (int)l;
        l = (l >>> 32) + (((long)ai[3] & 0xffffffffL) + ((long)ai1[3] & 0xffffffffL));
        ai2[3] = (int)l;
        l = (l >>> 32) + (((long)ai[4] & 0xffffffffL) + ((long)ai1[4] & 0xffffffffL));
        ai2[4] = (int)l;
        l = (l >>> 32) + (((long)ai[5] & 0xffffffffL) + ((long)ai1[5] & 0xffffffffL));
        ai2[5] = (int)l;
        return (int)(l >>> 32);
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        long l1 = (long)ai[0] & 0xffffffffL;
        int j = 0;
        int i = 5;
        int k = 12;
        int l;
        int i1;
        do
        {
            l = i - 1;
            long l2 = (long)ai[i] & 0xffffffffL;
            l2 *= l2;
            i = k - 1;
            ai1[i] = j << 31 | (int)(l2 >>> 33);
            k = i - 1;
            ai1[k] = (int)(l2 >>> 1);
            i1 = (int)l2;
            j = i1;
            i = l;
        } while (l > 0);
        long l4 = l1 * l1;
        long l6 = i1 << 31;
        ai1[0] = (int)l4;
        j = (int)(l4 >>> 32);
        long l3 = (long)ai[1] & 0xffffffffL;
        long l5 = ai1[2];
        long l8 = l3 * l1 + (l6 & 0xffffffffL | l4 >>> 33);
        i = (int)l8;
        ai1[1] = i << 1 | j & 1;
        l4 = (long)ai[2] & 0xffffffffL;
        long l7 = ai1[3];
        l6 = ai1[4];
        l5 = l4 * l1 + ((l5 & 0xffffffffL) + (l8 >>> 32));
        j = (int)l5;
        ai1[2] = j << 1 | i >>> 31;
        long l9 = (l7 & 0xffffffffL) + ((l5 >>> 32) + l4 * l3);
        l5 = (long)ai[3] & 0xffffffffL;
        l7 = ai1[5];
        l8 = ai1[6];
        long l10 = l5 * l1 + (l9 & 0xffffffffL);
        i = (int)l10;
        ai1[3] = i << 1 | j >>> 31;
        long l11 = (l6 & 0xffffffffL) + (l9 >>> 32) + ((l10 >>> 32) + l5 * l3);
        l10 = (l7 & 0xffffffffL) + ((l11 >>> 32) + l5 * l4);
        l6 = (long)ai[4] & 0xffffffffL;
        l9 = ai1[7];
        l7 = ai1[8];
        l11 = l6 * l1 + (l11 & 0xffffffffL);
        j = (int)l11;
        ai1[4] = j << 1 | i >>> 31;
        l11 = (l10 & 0xffffffffL) + ((l11 >>> 32) + l6 * l3);
        long l13 = (l8 & 0xffffffffL) + (l10 >>> 32) + ((l11 >>> 32) + l6 * l4);
        long l12 = (l9 & 0xffffffffL) + ((l13 >>> 32) + l6 * l5);
        l9 = (long)ai[5] & 0xffffffffL;
        l10 = ai1[9];
        l8 = ai1[10];
        l1 = l9 * l1 + (l11 & 0xffffffffL);
        i = (int)l1;
        ai1[5] = i << 1 | j >>> 31;
        l1 = (l13 & 0xffffffffL) + ((l1 >>> 32) + l9 * l3);
        l3 = (l12 & 0xffffffffL) + ((l1 >>> 32) + l9 * l4);
        l4 = (l7 & 0xffffffffL) + (l12 >>> 32) + ((l3 >>> 32) + l9 * l5);
        l5 = (l10 & 0xffffffffL) + ((l4 >>> 32) + l9 * l6);
        l6 = (l8 & 0xffffffffL) + (l5 >>> 32);
        j = (int)l1;
        ai1[6] = j << 1 | i >>> 31;
        i = (int)l3;
        ai1[7] = i << 1 | j >>> 31;
        j = (int)l4;
        ai1[8] = j << 1 | i >>> 31;
        i = (int)l5;
        ai1[9] = i << 1 | j >>> 31;
        j = (int)l6;
        ai1[10] = j << 1 | i >>> 31;
        ai1[11] = ai1[11] + (int)(l6 >> 32) << 1 | j >>> 31;
    }

    public static int _mth02BE(int ai[], int ai1[], int ai2[])
    {
        long l1 = ai1[0];
        long l2 = ai1[1];
        long l3 = ai1[2];
        long l4 = ai1[3];
        long l5 = ai1[4];
        long l6 = ai1[5];
        long l = 0L;
        for (int i = 0; i < 6; i++)
        {
            long l7 = (long)ai[i] & 0xffffffffL;
            long l8 = 0L + (l7 * (l1 & 0xffffffffL) + ((long)ai2[i] & 0xffffffffL));
            ai2[i] = (int)l8;
            l8 = (l8 >>> 32) + (l7 * (l2 & 0xffffffffL) + ((long)ai2[i + 1] & 0xffffffffL));
            ai2[i + 1] = (int)l8;
            l8 = (l8 >>> 32) + (l7 * (l3 & 0xffffffffL) + ((long)ai2[i + 2] & 0xffffffffL));
            ai2[i + 2] = (int)l8;
            l8 = (l8 >>> 32) + (l7 * (l4 & 0xffffffffL) + ((long)ai2[i + 3] & 0xffffffffL));
            ai2[i + 3] = (int)l8;
            l8 = (l8 >>> 32) + (l7 * (l5 & 0xffffffffL) + ((long)ai2[i + 4] & 0xffffffffL));
            ai2[i + 4] = (int)l8;
            l7 = (l8 >>> 32) + (l7 * (l6 & 0xffffffffL) + ((long)ai2[i + 5] & 0xffffffffL));
            ai2[i + 5] = (int)l7;
            l = (l7 >>> 32) + (((long)ai2[i + 6] & 0xffffffffL) + l);
            ai2[i + 6] = (int)l;
            l >>>= 32;
        }

        return (int)l;
    }

    public static boolean _mth02BE(int ai[], int ai1[])
    {
        for (int i = 5; i >= 0; i--)
        {
            int j = ai[i] ^ 0x80000000;
            int k = ai1[i] ^ 0x80000000;
            if (j < k)
            {
                return false;
            }
            if (j > k)
            {
                return true;
            }
        }

        return true;
    }

    public static int[] _mth02BE(BigInteger biginteger)
    {
        if (biginteger.signum() < 0 || biginteger.bitLength() > 192)
        {
            throw new IllegalArgumentException();
        }
        int ai[] = new int[6];
        int j;
        for (int i = 0; biginteger.signum() != 0; i = j)
        {
            j = i + 1;
            ai[i] = biginteger.intValue();
            biginteger = biginteger.shiftRight(32);
        }

        return ai;
    }

    public static int _mth02BF(int ai[], int ai1[])
    {
        long l = 0L + (((long)ai1[0] & 0xffffffffL) - ((long)ai[0] & 0xffffffffL));
        ai1[0] = (int)l;
        l = (l >> 32) + (((long)ai1[1] & 0xffffffffL) - ((long)ai[1] & 0xffffffffL));
        ai1[1] = (int)l;
        l = (l >> 32) + (((long)ai1[2] & 0xffffffffL) - ((long)ai[2] & 0xffffffffL));
        ai1[2] = (int)l;
        l = (l >> 32) + (((long)ai1[3] & 0xffffffffL) - ((long)ai[3] & 0xffffffffL));
        ai1[3] = (int)l;
        l = (l >> 32) + (((long)ai1[4] & 0xffffffffL) - ((long)ai[4] & 0xffffffffL));
        ai1[4] = (int)l;
        l = (l >> 32) + (((long)ai1[5] & 0xffffffffL) - ((long)ai[5] & 0xffffffffL));
        ai1[5] = (int)l;
        return (int)(l >> 32);
    }

    public static int _mth02BF(int ai[], int ai1[], int ai2[])
    {
        long l = 0L + (((long)ai[0] & 0xffffffffL) - ((long)ai1[0] & 0xffffffffL));
        ai2[0] = (int)l;
        l = (l >> 32) + (((long)ai[1] & 0xffffffffL) - ((long)ai1[1] & 0xffffffffL));
        ai2[1] = (int)l;
        l = (l >> 32) + (((long)ai[2] & 0xffffffffL) - ((long)ai1[2] & 0xffffffffL));
        ai2[2] = (int)l;
        l = (l >> 32) + (((long)ai[3] & 0xffffffffL) - ((long)ai1[3] & 0xffffffffL));
        ai2[3] = (int)l;
        l = (l >> 32) + (((long)ai[4] & 0xffffffffL) - ((long)ai1[4] & 0xffffffffL));
        ai2[4] = (int)l;
        l = (l >> 32) + (((long)ai[5] & 0xffffffffL) - ((long)ai1[5] & 0xffffffffL));
        ai2[5] = (int)l;
        return (int)(l >> 32);
    }

    public static boolean _mth02BF(int ai[])
    {
        if (ai[0] != 1)
        {
            return false;
        }
        for (int i = 1; i < 6; i++)
        {
            if (ai[i] != 0)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean _mth02C8(int ai[])
    {
        for (int i = 0; i < 6; i++)
        {
            if (ai[i] != 0)
            {
                return false;
            }
        }

        return true;
    }

    public static BigInteger _mth02C9(int ai[])
    {
        byte abyte0[] = new byte[24];
        for (int i = 0; i < 6; i++)
        {
            int j = ai[i];
            if (j != 0)
            {
                Pack._mth1FBE(j, abyte0, 5 - i << 2);
            }
        }

        return new BigInteger(1, abyte0);
    }

    public static int _mth02CA(int i, long l, int ai[], int j)
    {
        long l1 = l & 0xffffffffL;
        long l2 = 0L + (4553L * l1 + ((long)ai[0] & 0xffffffffL));
        ai[0] = (int)l2;
        l >>>= 32;
        l1 = (l2 >>> 32) + (4553L * l + l1 + ((long)ai[1] & 0xffffffffL));
        ai[1] = (int)l1;
        l = (l1 >>> 32) + (((long)ai[2] & 0xffffffffL) + l);
        ai[2] = (int)l;
        l = (l >>> 32) + ((long)ai[3] & 0xffffffffL);
        ai[3] = (int)l;
        if (l >>> 32 == 0L)
        {
            return 0;
        } else
        {
            return Nat._mth02CA(6, ai, 0, 4);
        }
    }

    public static int _mth02CA(int ai[], int i, int ai1[], int j)
    {
        long l = 0L + (((long)ai[6] & 0xffffffffL) + ((long)ai1[12] & 0xffffffffL));
        ai[6] = (int)l;
        ai1[12] = (int)l;
        l = (l >>> 32) + (((long)ai[7] & 0xffffffffL) + ((long)ai1[13] & 0xffffffffL));
        ai[7] = (int)l;
        ai1[13] = (int)l;
        l = (l >>> 32) + (((long)ai[8] & 0xffffffffL) + ((long)ai1[14] & 0xffffffffL));
        ai[8] = (int)l;
        ai1[14] = (int)l;
        l = (l >>> 32) + (((long)ai[9] & 0xffffffffL) + ((long)ai1[15] & 0xffffffffL));
        ai[9] = (int)l;
        ai1[15] = (int)l;
        l = (l >>> 32) + (((long)ai[10] & 0xffffffffL) + ((long)ai1[16] & 0xffffffffL));
        ai[10] = (int)l;
        ai1[16] = (int)l;
        l = (l >>> 32) + (((long)ai[11] & 0xffffffffL) + ((long)ai1[17] & 0xffffffffL));
        ai[11] = (int)l;
        ai1[17] = (int)l;
        return (int)(l >>> 32);
    }

    public static int _mth02CA(int ai[], int i, int ai1[], int j, int k)
    {
        long l = ((long)k & 0xffffffffL) + (((long)ai[i] & 0xffffffffL) + ((long)ai1[j] & 0xffffffffL));
        ai1[j] = (int)l;
        l = (l >>> 32) + (((long)ai[i + 1] & 0xffffffffL) + ((long)ai1[j + 1] & 0xffffffffL));
        ai1[j + 1] = (int)l;
        l = (l >>> 32) + (((long)ai[i + 2] & 0xffffffffL) + ((long)ai1[j + 2] & 0xffffffffL));
        ai1[j + 2] = (int)l;
        l = (l >>> 32) + (((long)ai[i + 3] & 0xffffffffL) + ((long)ai1[j + 3] & 0xffffffffL));
        ai1[j + 3] = (int)l;
        l = (l >>> 32) + (((long)ai[i + 4] & 0xffffffffL) + ((long)ai1[j + 4] & 0xffffffffL));
        ai1[j + 4] = (int)l;
        l = (l >>> 32) + (((long)ai[i + 5] & 0xffffffffL) + ((long)ai1[j + 5] & 0xffffffffL));
        ai1[j + 5] = (int)l;
        return (int)(l >>> 32);
    }

    public static long _mth02CA(int i, int ai[], int j, int ai1[], int k, int ai2[], int l)
    {
        long l2 = (long)ai[6] & 0xffffffffL;
        long l3 = 0L + (4553L * l2 + ((long)ai1[0] & 0xffffffffL));
        ai2[0] = (int)l3;
        long l1 = (long)ai[7] & 0xffffffffL;
        l3 = (l3 >>> 32) + (4553L * l1 + l2 + ((long)ai1[1] & 0xffffffffL));
        ai2[1] = (int)l3;
        l2 = (long)ai[8] & 0xffffffffL;
        l3 = (l3 >>> 32) + (4553L * l2 + l1 + ((long)ai1[2] & 0xffffffffL));
        ai2[2] = (int)l3;
        l1 = (long)ai[9] & 0xffffffffL;
        l3 = (l3 >>> 32) + (4553L * l1 + l2 + ((long)ai1[3] & 0xffffffffL));
        ai2[3] = (int)l3;
        l2 = (long)ai[10] & 0xffffffffL;
        l3 = (l3 >>> 32) + (4553L * l2 + l1 + ((long)ai1[4] & 0xffffffffL));
        ai2[4] = (int)l3;
        l1 = (long)ai[11] & 0xffffffffL;
        l2 = (l3 >>> 32) + (4553L * l1 + l2 + ((long)ai1[5] & 0xffffffffL));
        ai2[5] = (int)l2;
        return (l2 >>> 32) + l1;
    }

    public static boolean _mth02CA(int ai[], int i, int ai1[], int j, int ai2[], int k)
    {
        boolean flag;
label0:
        {
            i = 5;
            do
            {
                if (i < 0)
                {
                    break;
                }
                j = ai[i + 6] ^ 0x80000000;
                k = ai1[i + 0] ^ 0x80000000;
                if (j < k)
                {
                    flag = false;
                    break label0;
                }
                if (j > k)
                {
                    break;
                }
                i--;
            } while (true);
            flag = true;
        }
        if (flag)
        {
            _mth02CE(ai, 6, ai1, 0, ai2, 0);
            return flag;
        } else
        {
            _mth02CE(ai1, 0, ai, 6, ai2, 0);
            return flag;
        }
    }

    public static int _mth02CB(int i, int j, int ai[], int k)
    {
        long l = (long)j & 0xffffffffL;
        long l1 = 0L + (4553L * l + ((long)ai[0] & 0xffffffffL));
        ai[0] = (int)l1;
        l = (l1 >>> 32) + (((long)ai[1] & 0xffffffffL) + l);
        ai[1] = (int)l;
        l = (l >>> 32) + ((long)ai[2] & 0xffffffffL);
        ai[2] = (int)l;
        if (l >>> 32 == 0L)
        {
            return 0;
        } else
        {
            return Nat._mth02CA(6, ai, 0, 3);
        }
    }

    public static void _mth02CB(int ai[], int i, int ai1[], int j)
    {
        long l1 = (long)ai[6] & 0xffffffffL;
        j = 0;
        i = 5;
        int k = 12;
        int l;
        int i1;
        do
        {
            l = i - 1;
            long l2 = (long)ai[i + 6] & 0xffffffffL;
            l2 *= l2;
            i = k - 1;
            ai1[i + 12] = j << 31 | (int)(l2 >>> 33);
            k = i - 1;
            ai1[k + 12] = (int)(l2 >>> 1);
            i1 = (int)l2;
            i = l;
            j = i1;
        } while (l > 0);
        long l4 = l1 * l1;
        long l6 = i1 << 31;
        ai1[12] = (int)l4;
        j = (int)(l4 >>> 32);
        long l3 = (long)ai[7] & 0xffffffffL;
        long l5 = ai1[14];
        long l8 = l3 * l1 + (l6 & 0xffffffffL | l4 >>> 33);
        i = (int)l8;
        ai1[13] = i << 1 | j & 1;
        l4 = (long)ai[8] & 0xffffffffL;
        long l7 = ai1[15];
        l6 = ai1[16];
        l5 = l4 * l1 + ((l5 & 0xffffffffL) + (l8 >>> 32));
        j = (int)l5;
        ai1[14] = j << 1 | i >>> 31;
        long l9 = (l7 & 0xffffffffL) + ((l5 >>> 32) + l4 * l3);
        l5 = (long)ai[9] & 0xffffffffL;
        l7 = ai1[17];
        l8 = ai1[18];
        long l10 = l5 * l1 + (l9 & 0xffffffffL);
        i = (int)l10;
        ai1[15] = i << 1 | j >>> 31;
        long l11 = (l6 & 0xffffffffL) + (l9 >>> 32) + ((l10 >>> 32) + l5 * l3);
        l10 = (l7 & 0xffffffffL) + ((l11 >>> 32) + l5 * l4);
        l6 = (long)ai[10] & 0xffffffffL;
        l9 = ai1[19];
        l7 = ai1[20];
        l11 = l6 * l1 + (l11 & 0xffffffffL);
        j = (int)l11;
        ai1[16] = j << 1 | i >>> 31;
        l11 = (l10 & 0xffffffffL) + ((l11 >>> 32) + l6 * l3);
        long l13 = (l8 & 0xffffffffL) + (l10 >>> 32) + ((l11 >>> 32) + l6 * l4);
        long l12 = (l9 & 0xffffffffL) + ((l13 >>> 32) + l6 * l5);
        l9 = (long)ai[11] & 0xffffffffL;
        l10 = ai1[21];
        l8 = ai1[22];
        l1 = l9 * l1 + (l11 & 0xffffffffL);
        i = (int)l1;
        ai1[17] = i << 1 | j >>> 31;
        l1 = (l13 & 0xffffffffL) + ((l1 >>> 32) + l9 * l3);
        l3 = (l12 & 0xffffffffL) + ((l1 >>> 32) + l9 * l4);
        l4 = (l7 & 0xffffffffL) + (l12 >>> 32) + ((l3 >>> 32) + l9 * l5);
        l5 = (l10 & 0xffffffffL) + ((l4 >>> 32) + l9 * l6);
        l6 = (l8 & 0xffffffffL) + (l5 >>> 32);
        j = (int)l1;
        ai1[18] = j << 1 | i >>> 31;
        i = (int)l3;
        ai1[19] = i << 1 | j >>> 31;
        j = (int)l4;
        ai1[20] = j << 1 | i >>> 31;
        i = (int)l5;
        ai1[21] = i << 1 | j >>> 31;
        j = (int)l6;
        ai1[22] = j << 1 | i >>> 31;
        ai1[23] = ai1[23] + (int)(l6 >> 32) << 1 | j >>> 31;
    }

    public static void _mth02CB(int ai[], int i, int ai1[], int j, int ai2[], int k)
    {
        long l = (long)ai1[6] & 0xffffffffL;
        long l1 = (long)ai1[7] & 0xffffffffL;
        long l2 = (long)ai1[8] & 0xffffffffL;
        long l3 = (long)ai1[9] & 0xffffffffL;
        long l4 = (long)ai1[10] & 0xffffffffL;
        long l5 = (long)ai1[11] & 0xffffffffL;
        long l6 = (long)ai[6] & 0xffffffffL;
        long l8 = 0L + l6 * l;
        ai2[12] = (int)l8;
        l8 = (l8 >>> 32) + l6 * l1;
        ai2[13] = (int)l8;
        l8 = (l8 >>> 32) + l6 * l2;
        ai2[14] = (int)l8;
        l8 = (l8 >>> 32) + l6 * l3;
        ai2[15] = (int)l8;
        l8 = (l8 >>> 32) + l6 * l4;
        ai2[16] = (int)l8;
        l6 = (l8 >>> 32) + l6 * l5;
        ai2[17] = (int)l6;
        ai2[18] = (int)(l6 >>> 32);
        for (i = 1; i < 6; i++)
        {
            k++;
            long l7 = (long)ai[i + 6] & 0xffffffffL;
            long l9 = 0L + (l7 * l + ((long)ai2[k] & 0xffffffffL));
            ai2[k] = (int)l9;
            l9 = (l9 >>> 32) + (l7 * l1 + ((long)ai2[k + 1] & 0xffffffffL));
            ai2[k + 1] = (int)l9;
            l9 = (l9 >>> 32) + (l7 * l2 + ((long)ai2[k + 2] & 0xffffffffL));
            ai2[k + 2] = (int)l9;
            l9 = (l9 >>> 32) + (l7 * l3 + ((long)ai2[k + 3] & 0xffffffffL));
            ai2[k + 3] = (int)l9;
            l9 = (l9 >>> 32) + (l7 * l4 + ((long)ai2[k + 4] & 0xffffffffL));
            ai2[k + 4] = (int)l9;
            l7 = (l9 >>> 32) + (l7 * l5 + ((long)ai2[k + 5] & 0xffffffffL));
            ai2[k + 5] = (int)l7;
            ai2[k + 6] = (int)(l7 >>> 32);
        }

    }

    public static void _mth02CC(int ai[])
    {
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        ai[3] = 0;
        ai[4] = 0;
        ai[5] = 0;
    }

    public static int _mth02CE(int ai[], int i)
    {
        return ai[0] & 1;
    }

    private static int _mth02CE(int ai[], int i, int ai1[], int j, int ai2[], int k)
    {
        long l = 0L + (((long)ai[i] & 0xffffffffL) - ((long)ai1[j] & 0xffffffffL));
        ai2[k] = (int)l;
        l = (l >> 32) + (((long)ai[i + 1] & 0xffffffffL) - ((long)ai1[j + 1] & 0xffffffffL));
        ai2[k + 1] = (int)l;
        l = (l >> 32) + (((long)ai[i + 2] & 0xffffffffL) - ((long)ai1[j + 2] & 0xffffffffL));
        ai2[k + 2] = (int)l;
        l = (l >> 32) + (((long)ai[i + 3] & 0xffffffffL) - ((long)ai1[j + 3] & 0xffffffffL));
        ai2[k + 3] = (int)l;
        l = (l >> 32) + (((long)ai[i + 4] & 0xffffffffL) - ((long)ai1[j + 4] & 0xffffffffL));
        ai2[k + 4] = (int)l;
        l = (l >> 32) + (((long)ai[i + 5] & 0xffffffffL) - ((long)ai1[j + 5] & 0xffffffffL));
        ai2[k + 5] = (int)l;
        return (int)(l >> 32);
    }

    public static int _mth037A(int ai[], int ai1[], int ai2[])
    {
        long l = 0L + (((long)ai[0] & 0xffffffffL) + ((long)ai1[0] & 0xffffffffL) + ((long)ai2[0] & 0xffffffffL));
        ai2[0] = (int)l;
        l = (l >>> 32) + (((long)ai[1] & 0xffffffffL) + ((long)ai1[1] & 0xffffffffL) + ((long)ai2[1] & 0xffffffffL));
        ai2[1] = (int)l;
        l = (l >>> 32) + (((long)ai[2] & 0xffffffffL) + ((long)ai1[2] & 0xffffffffL) + ((long)ai2[2] & 0xffffffffL));
        ai2[2] = (int)l;
        l = (l >>> 32) + (((long)ai[3] & 0xffffffffL) + ((long)ai1[3] & 0xffffffffL) + ((long)ai2[3] & 0xffffffffL));
        ai2[3] = (int)l;
        l = (l >>> 32) + (((long)ai[4] & 0xffffffffL) + ((long)ai1[4] & 0xffffffffL) + ((long)ai2[4] & 0xffffffffL));
        ai2[4] = (int)l;
        l = (l >>> 32) + (((long)ai[5] & 0xffffffffL) + ((long)ai1[5] & 0xffffffffL) + ((long)ai2[5] & 0xffffffffL));
        ai2[5] = (int)l;
        return (int)(l >>> 32);
    }

    public static int[] _mth05E4()
    {
        return new int[6];
    }

    public static int[] _mth05E7()
    {
        return new int[12];
    }

    public static void _mth1FBE(int ai[], int ai1[], int ai2[])
    {
        long l = (long)ai1[0] & 0xffffffffL;
        long l1 = (long)ai1[1] & 0xffffffffL;
        long l2 = (long)ai1[2] & 0xffffffffL;
        long l3 = (long)ai1[3] & 0xffffffffL;
        long l4 = (long)ai1[4] & 0xffffffffL;
        long l5 = (long)ai1[5] & 0xffffffffL;
        long l6 = (long)ai[0] & 0xffffffffL;
        long l8 = 0L + l6 * l;
        ai2[0] = (int)l8;
        l8 = (l8 >>> 32) + l6 * l1;
        ai2[1] = (int)l8;
        l8 = (l8 >>> 32) + l6 * l2;
        ai2[2] = (int)l8;
        l8 = (l8 >>> 32) + l6 * l3;
        ai2[3] = (int)l8;
        l8 = (l8 >>> 32) + l6 * l4;
        ai2[4] = (int)l8;
        l6 = (l8 >>> 32) + l6 * l5;
        ai2[5] = (int)l6;
        ai2[6] = (int)(l6 >>> 32);
        for (int i = 1; i < 6; i++)
        {
            long l7 = (long)ai[i] & 0xffffffffL;
            long l9 = 0L + (l7 * l + ((long)ai2[i] & 0xffffffffL));
            ai2[i] = (int)l9;
            l9 = (l9 >>> 32) + (l7 * l1 + ((long)ai2[i + 1] & 0xffffffffL));
            ai2[i + 1] = (int)l9;
            l9 = (l9 >>> 32) + (l7 * l2 + ((long)ai2[i + 2] & 0xffffffffL));
            ai2[i + 2] = (int)l9;
            l9 = (l9 >>> 32) + (l7 * l3 + ((long)ai2[i + 3] & 0xffffffffL));
            ai2[i + 3] = (int)l9;
            l9 = (l9 >>> 32) + (l7 * l4 + ((long)ai2[i + 4] & 0xffffffffL));
            ai2[i + 4] = (int)l9;
            l7 = (l9 >>> 32) + (l7 * l5 + ((long)ai2[i + 5] & 0xffffffffL));
            ai2[i + 5] = (int)l7;
            ai2[i + 6] = (int)(l7 >>> 32);
        }

    }

    public static boolean _mth1FBE(int ai[], int ai1[])
    {
        for (int i = 5; i >= 0; i--)
        {
            if (ai[i] != ai1[i])
            {
                return false;
            }
        }

        return true;
    }
}
