// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.math.raw:
//            Nat

public abstract class Nat256
{

    public Nat256()
    {
    }

    public static int _mth02BC(int i, int ai[], int ai1[])
    {
        long l = 0L + (((long)ai1[0] & 0xffffffffL) * 19L + ((long)ai[0] & 0xffffffffL));
        ai1[0] = (int)l;
        l = (l >>> 32) + (((long)ai1[1] & 0xffffffffL) * 19L + ((long)ai[1] & 0xffffffffL));
        ai1[1] = (int)l;
        l = (l >>> 32) + (((long)ai1[2] & 0xffffffffL) * 19L + ((long)ai[2] & 0xffffffffL));
        ai1[2] = (int)l;
        l = (l >>> 32) + (((long)ai1[3] & 0xffffffffL) * 19L + ((long)ai[3] & 0xffffffffL));
        ai1[3] = (int)l;
        l = (l >>> 32) + (((long)ai1[4] & 0xffffffffL) * 19L + ((long)ai[4] & 0xffffffffL));
        ai1[4] = (int)l;
        l = (l >>> 32) + (((long)ai1[5] & 0xffffffffL) * 19L + ((long)ai[5] & 0xffffffffL));
        ai1[5] = (int)l;
        l = (l >>> 32) + (((long)ai1[6] & 0xffffffffL) * 19L + ((long)ai[6] & 0xffffffffL));
        ai1[6] = (int)l;
        l = (l >>> 32) + (((long)ai1[7] & 0xffffffffL) * 19L + ((long)ai[7] & 0xffffffffL));
        ai1[7] = (int)l;
        return (int)(l >>> 32);
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
        l = (l >>> 32) + (((long)ai[6] & 0xffffffffL) + ((long)ai1[6] & 0xffffffffL));
        ai2[6] = (int)l;
        l = (l >>> 32) + (((long)ai[7] & 0xffffffffL) + ((long)ai1[7] & 0xffffffffL));
        ai2[7] = (int)l;
        return (int)(l >>> 32);
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        long l1 = (long)ai[0] & 0xffffffffL;
        int j = 0;
        int i = 7;
        int k = 16;
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
        l8 = ai1[5];
        l7 = ai1[6];
        long l10 = l5 * l1 + (l9 & 0xffffffffL);
        i = (int)l10;
        ai1[3] = i << 1 | j >>> 31;
        long l11 = (l6 & 0xffffffffL) + (l9 >>> 32) + ((l10 >>> 32) + l5 * l3);
        l10 = (l8 & 0xffffffffL) + ((l11 >>> 32) + l5 * l4);
        l6 = (long)ai[4] & 0xffffffffL;
        l9 = ai1[7];
        l8 = ai1[8];
        l11 = l6 * l1 + (l11 & 0xffffffffL);
        j = (int)l11;
        ai1[4] = j << 1 | i >>> 31;
        l11 = (l10 & 0xffffffffL) + ((l11 >>> 32) + l6 * l3);
        long l12 = (l7 & 0xffffffffL) + (l10 >>> 32) + ((l11 >>> 32) + l6 * l4);
        long l14 = (l9 & 0xffffffffL) + ((l12 >>> 32) + l6 * l5);
        l7 = (long)ai[5] & 0xffffffffL;
        l9 = ai1[9];
        l10 = ai1[10];
        l11 = l7 * l1 + (l11 & 0xffffffffL);
        i = (int)l11;
        ai1[5] = i << 1 | j >>> 31;
        long l13 = (l12 & 0xffffffffL) + ((l11 >>> 32) + l7 * l3);
        l12 = (l14 & 0xffffffffL) + ((l13 >>> 32) + l7 * l4);
        long l16 = (l8 & 0xffffffffL) + (l14 >>> 32) + ((l12 >>> 32) + l7 * l5);
        l14 = (l9 & 0xffffffffL) + ((l16 >>> 32) + l7 * l6);
        l8 = (long)ai[6] & 0xffffffffL;
        l11 = ai1[11];
        l9 = ai1[12];
        l13 = l8 * l1 + (l13 & 0xffffffffL);
        j = (int)l13;
        ai1[6] = j << 1 | i >>> 31;
        long l15 = (l12 & 0xffffffffL) + ((l13 >>> 32) + l8 * l3);
        l16 = (l16 & 0xffffffffL) + ((l15 >>> 32) + l8 * l4);
        l13 = (l14 & 0xffffffffL) + ((l16 >>> 32) + l8 * l5);
        long l17 = (l10 & 0xffffffffL) + (l14 >>> 32) + ((l13 >>> 32) + l8 * l6);
        l14 = (l11 & 0xffffffffL) + ((l17 >>> 32) + l8 * l7);
        l11 = (long)ai[7] & 0xffffffffL;
        l12 = ai1[13];
        l10 = ai1[14];
        l1 = l11 * l1 + (l15 & 0xffffffffL);
        i = (int)l1;
        ai1[7] = i << 1 | j >>> 31;
        l1 = (l16 & 0xffffffffL) + ((l1 >>> 32) + l11 * l3);
        l3 = (l13 & 0xffffffffL) + ((l1 >>> 32) + l11 * l4);
        l4 = (l17 & 0xffffffffL) + ((l3 >>> 32) + l11 * l5);
        l5 = (l14 & 0xffffffffL) + ((l4 >>> 32) + l11 * l6);
        l6 = (l9 & 0xffffffffL) + (l14 >>> 32) + ((l5 >>> 32) + l11 * l7);
        l7 = (l12 & 0xffffffffL) + ((l6 >>> 32) + l11 * l8);
        l8 = (l10 & 0xffffffffL) + (l7 >>> 32);
        j = (int)l1;
        ai1[8] = j << 1 | i >>> 31;
        i = (int)l3;
        ai1[9] = i << 1 | j >>> 31;
        j = (int)l4;
        ai1[10] = j << 1 | i >>> 31;
        i = (int)l5;
        ai1[11] = i << 1 | j >>> 31;
        j = (int)l6;
        ai1[12] = j << 1 | i >>> 31;
        i = (int)l7;
        ai1[13] = i << 1 | j >>> 31;
        j = (int)l8;
        ai1[14] = j << 1 | i >>> 31;
        ai1[15] = ai1[15] + (int)(l8 >> 32) << 1 | j >>> 31;
    }

    public static int _mth02BE(int ai[], int ai1[], int ai2[])
    {
        long l1 = ai1[0];
        long l2 = ai1[1];
        long l3 = ai1[2];
        long l4 = ai1[3];
        long l5 = ai1[4];
        long l6 = ai1[5];
        long l7 = ai1[6];
        long l8 = ai1[7];
        long l = 0L;
        for (int i = 0; i < 8; i++)
        {
            long l9 = (long)ai[i] & 0xffffffffL;
            long l10 = 0L + (l9 * (l1 & 0xffffffffL) + ((long)ai2[i] & 0xffffffffL));
            ai2[i] = (int)l10;
            l10 = (l10 >>> 32) + (l9 * (l2 & 0xffffffffL) + ((long)ai2[i + 1] & 0xffffffffL));
            ai2[i + 1] = (int)l10;
            l10 = (l10 >>> 32) + (l9 * (l3 & 0xffffffffL) + ((long)ai2[i + 2] & 0xffffffffL));
            ai2[i + 2] = (int)l10;
            l10 = (l10 >>> 32) + (l9 * (l4 & 0xffffffffL) + ((long)ai2[i + 3] & 0xffffffffL));
            ai2[i + 3] = (int)l10;
            l10 = (l10 >>> 32) + (l9 * (l5 & 0xffffffffL) + ((long)ai2[i + 4] & 0xffffffffL));
            ai2[i + 4] = (int)l10;
            l10 = (l10 >>> 32) + (l9 * (l6 & 0xffffffffL) + ((long)ai2[i + 5] & 0xffffffffL));
            ai2[i + 5] = (int)l10;
            l10 = (l10 >>> 32) + (l9 * (l7 & 0xffffffffL) + ((long)ai2[i + 6] & 0xffffffffL));
            ai2[i + 6] = (int)l10;
            l9 = (l10 >>> 32) + (l9 * (l8 & 0xffffffffL) + ((long)ai2[i + 7] & 0xffffffffL));
            ai2[i + 7] = (int)l9;
            l = (l9 >>> 32) + (((long)ai2[i + 8] & 0xffffffffL) + l);
            ai2[i + 8] = (int)l;
            l >>>= 32;
        }

        return (int)l;
    }

    public static boolean _mth02BE(int ai[], int ai1[])
    {
        for (int i = 7; i >= 0; i--)
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
        if (biginteger.signum() < 0 || biginteger.bitLength() > 256)
        {
            throw new IllegalArgumentException();
        }
        int ai[] = new int[8];
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
        l = (l >> 32) + (((long)ai1[6] & 0xffffffffL) - ((long)ai[6] & 0xffffffffL));
        ai1[6] = (int)l;
        l = (l >> 32) + (((long)ai1[7] & 0xffffffffL) - ((long)ai[7] & 0xffffffffL));
        ai1[7] = (int)l;
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
        l = (l >> 32) + (((long)ai[6] & 0xffffffffL) - ((long)ai1[6] & 0xffffffffL));
        ai2[6] = (int)l;
        l = (l >> 32) + (((long)ai[7] & 0xffffffffL) - ((long)ai1[7] & 0xffffffffL));
        ai2[7] = (int)l;
        return (int)(l >> 32);
    }

    public static boolean _mth02BF(int ai[])
    {
        if (ai[0] != 1)
        {
            return false;
        }
        for (int i = 1; i < 8; i++)
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
        for (int i = 0; i < 8; i++)
        {
            if (ai[i] != 0)
            {
                return false;
            }
        }

        return true;
    }

    public static int _mth02C9(int ai[], int ai1[])
    {
        long l = 0L + (((long)ai[0] & 0xffffffffL) + ((long)ai1[0] & 0xffffffffL));
        ai1[0] = (int)l;
        l = (l >>> 32) + (((long)ai[1] & 0xffffffffL) + ((long)ai1[1] & 0xffffffffL));
        ai1[1] = (int)l;
        l = (l >>> 32) + (((long)ai[2] & 0xffffffffL) + ((long)ai1[2] & 0xffffffffL));
        ai1[2] = (int)l;
        l = (l >>> 32) + (((long)ai[3] & 0xffffffffL) + ((long)ai1[3] & 0xffffffffL));
        ai1[3] = (int)l;
        l = (l >>> 32) + (((long)ai[4] & 0xffffffffL) + ((long)ai1[4] & 0xffffffffL));
        ai1[4] = (int)l;
        l = (l >>> 32) + (((long)ai[5] & 0xffffffffL) + ((long)ai1[5] & 0xffffffffL));
        ai1[5] = (int)l;
        l = (l >>> 32) + (((long)ai[6] & 0xffffffffL) + ((long)ai1[6] & 0xffffffffL));
        ai1[6] = (int)l;
        l = (l >>> 32) + (((long)ai[7] & 0xffffffffL) + ((long)ai1[7] & 0xffffffffL));
        ai1[7] = (int)l;
        return (int)(l >>> 32);
    }

    public static BigInteger _mth02C9(int ai[])
    {
        byte abyte0[] = new byte[32];
        for (int i = 0; i < 8; i++)
        {
            int j = ai[i];
            if (j != 0)
            {
                Pack._mth1FBE(j, abyte0, 7 - i << 2);
            }
        }

        return new BigInteger(1, abyte0);
    }

    public static int _mth02CA(int i, long l, int ai[], int j)
    {
        long l1 = l & 0xffffffffL;
        long l2 = 0L + (977L * l1 + ((long)ai[0] & 0xffffffffL));
        ai[0] = (int)l2;
        l >>>= 32;
        l1 = (l2 >>> 32) + (977L * l + l1 + ((long)ai[1] & 0xffffffffL));
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
            return Nat._mth02CA(8, ai, 0, 4);
        }
    }

    public static int _mth02CA(int ai[], int i, int ai1[], int j)
    {
        long l = 0L + (((long)ai[8] & 0xffffffffL) + ((long)ai1[16] & 0xffffffffL));
        ai[8] = (int)l;
        ai1[16] = (int)l;
        l = (l >>> 32) + (((long)ai[9] & 0xffffffffL) + ((long)ai1[17] & 0xffffffffL));
        ai[9] = (int)l;
        ai1[17] = (int)l;
        l = (l >>> 32) + (((long)ai[10] & 0xffffffffL) + ((long)ai1[18] & 0xffffffffL));
        ai[10] = (int)l;
        ai1[18] = (int)l;
        l = (l >>> 32) + (((long)ai[11] & 0xffffffffL) + ((long)ai1[19] & 0xffffffffL));
        ai[11] = (int)l;
        ai1[19] = (int)l;
        l = (l >>> 32) + (((long)ai[12] & 0xffffffffL) + ((long)ai1[20] & 0xffffffffL));
        ai[12] = (int)l;
        ai1[20] = (int)l;
        l = (l >>> 32) + (((long)ai[13] & 0xffffffffL) + ((long)ai1[21] & 0xffffffffL));
        ai[13] = (int)l;
        ai1[21] = (int)l;
        l = (l >>> 32) + (((long)ai[14] & 0xffffffffL) + ((long)ai1[22] & 0xffffffffL));
        ai[14] = (int)l;
        ai1[22] = (int)l;
        l = (l >>> 32) + (((long)ai[15] & 0xffffffffL) + ((long)ai1[23] & 0xffffffffL));
        ai[15] = (int)l;
        ai1[23] = (int)l;
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
        l = (l >>> 32) + (((long)ai[i + 6] & 0xffffffffL) + ((long)ai1[j + 6] & 0xffffffffL));
        ai1[j + 6] = (int)l;
        l = (l >>> 32) + (((long)ai[i + 7] & 0xffffffffL) + ((long)ai1[j + 7] & 0xffffffffL));
        ai1[j + 7] = (int)l;
        return (int)(l >>> 32);
    }

    public static long _mth02CA(int i, int ai[], int j, int ai1[], int k, int ai2[], int l)
    {
        long l2 = (long)ai[8] & 0xffffffffL;
        long l3 = 0L + (977L * l2 + ((long)ai1[0] & 0xffffffffL));
        ai2[0] = (int)l3;
        long l1 = (long)ai[9] & 0xffffffffL;
        l3 = (l3 >>> 32) + (977L * l1 + l2 + ((long)ai1[1] & 0xffffffffL));
        ai2[1] = (int)l3;
        l2 = (long)ai[10] & 0xffffffffL;
        l3 = (l3 >>> 32) + (977L * l2 + l1 + ((long)ai1[2] & 0xffffffffL));
        ai2[2] = (int)l3;
        l1 = (long)ai[11] & 0xffffffffL;
        l3 = (l3 >>> 32) + (977L * l1 + l2 + ((long)ai1[3] & 0xffffffffL));
        ai2[3] = (int)l3;
        l2 = (long)ai[12] & 0xffffffffL;
        l3 = (l3 >>> 32) + (977L * l2 + l1 + ((long)ai1[4] & 0xffffffffL));
        ai2[4] = (int)l3;
        l1 = (long)ai[13] & 0xffffffffL;
        l3 = (l3 >>> 32) + (977L * l1 + l2 + ((long)ai1[5] & 0xffffffffL));
        ai2[5] = (int)l3;
        l2 = (long)ai[14] & 0xffffffffL;
        l3 = (l3 >>> 32) + (977L * l2 + l1 + ((long)ai1[6] & 0xffffffffL));
        ai2[6] = (int)l3;
        l1 = (long)ai[15] & 0xffffffffL;
        l2 = (l3 >>> 32) + (977L * l1 + l2 + ((long)ai1[7] & 0xffffffffL));
        ai2[7] = (int)l2;
        return (l2 >>> 32) + l1;
    }

    public static boolean _mth02CA(int ai[], int i, int ai1[], int j, int ai2[], int k)
    {
        boolean flag;
label0:
        {
            i = 7;
            do
            {
                if (i < 0)
                {
                    break;
                }
                j = ai[i + 8] ^ 0x80000000;
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
            _mth02CE(ai, 8, ai1, 0, ai2, 0);
            return flag;
        } else
        {
            _mth02CE(ai1, 0, ai, 8, ai2, 0);
            return flag;
        }
    }

    public static int _mth02CB(int i, int j, int ai[], int k)
    {
        long l = (long)j & 0xffffffffL;
        long l1 = 0L + (977L * l + ((long)ai[0] & 0xffffffffL));
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
            return Nat._mth02CA(8, ai, 0, 3);
        }
    }

    public static void _mth02CB(int ai[], int i, int ai1[], int j)
    {
        long l1 = (long)ai[8] & 0xffffffffL;
        j = 0;
        i = 7;
        int k = 16;
        int l;
        int i1;
        do
        {
            l = i - 1;
            long l2 = (long)ai[i + 8] & 0xffffffffL;
            l2 *= l2;
            i = k - 1;
            ai1[i + 16] = j << 31 | (int)(l2 >>> 33);
            k = i - 1;
            ai1[k + 16] = (int)(l2 >>> 1);
            i1 = (int)l2;
            i = l;
            j = i1;
        } while (l > 0);
        long l4 = l1 * l1;
        long l6 = i1 << 31;
        ai1[16] = (int)l4;
        j = (int)(l4 >>> 32);
        long l3 = (long)ai[9] & 0xffffffffL;
        long l5 = ai1[18];
        long l8 = l3 * l1 + (l6 & 0xffffffffL | l4 >>> 33);
        i = (int)l8;
        ai1[17] = i << 1 | j & 1;
        l4 = (long)ai[10] & 0xffffffffL;
        long l7 = ai1[19];
        l6 = ai1[20];
        l5 = l4 * l1 + ((l5 & 0xffffffffL) + (l8 >>> 32));
        j = (int)l5;
        ai1[18] = j << 1 | i >>> 31;
        long l9 = (l7 & 0xffffffffL) + ((l5 >>> 32) + l4 * l3);
        l5 = (long)ai[11] & 0xffffffffL;
        l8 = ai1[21];
        l7 = ai1[22];
        long l10 = l5 * l1 + (l9 & 0xffffffffL);
        i = (int)l10;
        ai1[19] = i << 1 | j >>> 31;
        long l11 = (l6 & 0xffffffffL) + (l9 >>> 32) + ((l10 >>> 32) + l5 * l3);
        l10 = (l8 & 0xffffffffL) + ((l11 >>> 32) + l5 * l4);
        l6 = (long)ai[12] & 0xffffffffL;
        l9 = ai1[23];
        l8 = ai1[24];
        l11 = l6 * l1 + (l11 & 0xffffffffL);
        j = (int)l11;
        ai1[20] = j << 1 | i >>> 31;
        l11 = (l10 & 0xffffffffL) + ((l11 >>> 32) + l6 * l3);
        long l12 = (l7 & 0xffffffffL) + (l10 >>> 32) + ((l11 >>> 32) + l6 * l4);
        long l14 = (l9 & 0xffffffffL) + ((l12 >>> 32) + l6 * l5);
        l7 = (long)ai[13] & 0xffffffffL;
        l9 = ai1[25];
        l10 = ai1[26];
        l11 = l7 * l1 + (l11 & 0xffffffffL);
        i = (int)l11;
        ai1[21] = i << 1 | j >>> 31;
        long l13 = (l12 & 0xffffffffL) + ((l11 >>> 32) + l7 * l3);
        l12 = (l14 & 0xffffffffL) + ((l13 >>> 32) + l7 * l4);
        long l16 = (l8 & 0xffffffffL) + (l14 >>> 32) + ((l12 >>> 32) + l7 * l5);
        l14 = (l9 & 0xffffffffL) + ((l16 >>> 32) + l7 * l6);
        l8 = (long)ai[14] & 0xffffffffL;
        l11 = ai1[27];
        l9 = ai1[28];
        l13 = l8 * l1 + (l13 & 0xffffffffL);
        j = (int)l13;
        ai1[22] = j << 1 | i >>> 31;
        long l15 = (l12 & 0xffffffffL) + ((l13 >>> 32) + l8 * l3);
        l16 = (l16 & 0xffffffffL) + ((l15 >>> 32) + l8 * l4);
        l13 = (l14 & 0xffffffffL) + ((l16 >>> 32) + l8 * l5);
        long l17 = (l10 & 0xffffffffL) + (l14 >>> 32) + ((l13 >>> 32) + l8 * l6);
        l14 = (l11 & 0xffffffffL) + ((l17 >>> 32) + l8 * l7);
        l11 = (long)ai[15] & 0xffffffffL;
        l12 = ai1[29];
        l10 = ai1[30];
        l1 = l11 * l1 + (l15 & 0xffffffffL);
        i = (int)l1;
        ai1[23] = i << 1 | j >>> 31;
        l1 = (l16 & 0xffffffffL) + ((l1 >>> 32) + l11 * l3);
        l3 = (l13 & 0xffffffffL) + ((l1 >>> 32) + l11 * l4);
        l4 = (l17 & 0xffffffffL) + ((l3 >>> 32) + l11 * l5);
        l5 = (l14 & 0xffffffffL) + ((l4 >>> 32) + l11 * l6);
        l6 = (l9 & 0xffffffffL) + (l14 >>> 32) + ((l5 >>> 32) + l11 * l7);
        l7 = (l12 & 0xffffffffL) + ((l6 >>> 32) + l11 * l8);
        l8 = (l10 & 0xffffffffL) + (l7 >>> 32);
        j = (int)l1;
        ai1[24] = j << 1 | i >>> 31;
        i = (int)l3;
        ai1[25] = i << 1 | j >>> 31;
        j = (int)l4;
        ai1[26] = j << 1 | i >>> 31;
        i = (int)l5;
        ai1[27] = i << 1 | j >>> 31;
        j = (int)l6;
        ai1[28] = j << 1 | i >>> 31;
        i = (int)l7;
        ai1[29] = i << 1 | j >>> 31;
        j = (int)l8;
        ai1[30] = j << 1 | i >>> 31;
        ai1[31] = ai1[31] + (int)(l8 >> 32) << 1 | j >>> 31;
    }

    public static void _mth02CB(int ai[], int i, int ai1[], int j, int ai2[], int k)
    {
        long l = (long)ai1[8] & 0xffffffffL;
        long l1 = (long)ai1[9] & 0xffffffffL;
        long l2 = (long)ai1[10] & 0xffffffffL;
        long l3 = (long)ai1[11] & 0xffffffffL;
        long l4 = (long)ai1[12] & 0xffffffffL;
        long l5 = (long)ai1[13] & 0xffffffffL;
        long l6 = (long)ai1[14] & 0xffffffffL;
        long l7 = (long)ai1[15] & 0xffffffffL;
        long l8 = (long)ai[8] & 0xffffffffL;
        long l10 = 0L + l8 * l;
        ai2[16] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l1;
        ai2[17] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l2;
        ai2[18] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l3;
        ai2[19] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l4;
        ai2[20] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l5;
        ai2[21] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l6;
        ai2[22] = (int)l10;
        l8 = (l10 >>> 32) + l8 * l7;
        ai2[23] = (int)l8;
        ai2[24] = (int)(l8 >>> 32);
        for (i = 1; i < 8; i++)
        {
            k++;
            long l9 = (long)ai[i + 8] & 0xffffffffL;
            long l11 = 0L + (l9 * l + ((long)ai2[k] & 0xffffffffL));
            ai2[k] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l1 + ((long)ai2[k + 1] & 0xffffffffL));
            ai2[k + 1] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l2 + ((long)ai2[k + 2] & 0xffffffffL));
            ai2[k + 2] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l3 + ((long)ai2[k + 3] & 0xffffffffL));
            ai2[k + 3] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l4 + ((long)ai2[k + 4] & 0xffffffffL));
            ai2[k + 4] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l5 + ((long)ai2[k + 5] & 0xffffffffL));
            ai2[k + 5] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l6 + ((long)ai2[k + 6] & 0xffffffffL));
            ai2[k + 6] = (int)l11;
            l9 = (l11 >>> 32) + (l9 * l7 + ((long)ai2[k + 7] & 0xffffffffL));
            ai2[k + 7] = (int)l9;
            ai2[k + 8] = (int)(l9 >>> 32);
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
        ai[6] = 0;
        ai[7] = 0;
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
        l = (l >> 32) + (((long)ai[i + 6] & 0xffffffffL) - ((long)ai1[j + 6] & 0xffffffffL));
        ai2[k + 6] = (int)l;
        l = (l >> 32) + (((long)ai[i + 7] & 0xffffffffL) - ((long)ai1[j + 7] & 0xffffffffL));
        ai2[k + 7] = (int)l;
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
        l = (l >>> 32) + (((long)ai[6] & 0xffffffffL) + ((long)ai1[6] & 0xffffffffL) + ((long)ai2[6] & 0xffffffffL));
        ai2[6] = (int)l;
        l = (l >>> 32) + (((long)ai[7] & 0xffffffffL) + ((long)ai1[7] & 0xffffffffL) + ((long)ai2[7] & 0xffffffffL));
        ai2[7] = (int)l;
        return (int)(l >>> 32);
    }

    public static int[] _mth05E4()
    {
        return new int[8];
    }

    public static int[] _mth05E7()
    {
        return new int[16];
    }

    public static void _mth1FBE(int ai[], int ai1[], int ai2[])
    {
        long l = (long)ai1[0] & 0xffffffffL;
        long l1 = (long)ai1[1] & 0xffffffffL;
        long l2 = (long)ai1[2] & 0xffffffffL;
        long l3 = (long)ai1[3] & 0xffffffffL;
        long l4 = (long)ai1[4] & 0xffffffffL;
        long l5 = (long)ai1[5] & 0xffffffffL;
        long l6 = (long)ai1[6] & 0xffffffffL;
        long l7 = (long)ai1[7] & 0xffffffffL;
        long l8 = (long)ai[0] & 0xffffffffL;
        long l10 = 0L + l8 * l;
        ai2[0] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l1;
        ai2[1] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l2;
        ai2[2] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l3;
        ai2[3] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l4;
        ai2[4] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l5;
        ai2[5] = (int)l10;
        l10 = (l10 >>> 32) + l8 * l6;
        ai2[6] = (int)l10;
        l8 = (l10 >>> 32) + l8 * l7;
        ai2[7] = (int)l8;
        ai2[8] = (int)(l8 >>> 32);
        for (int i = 1; i < 8; i++)
        {
            long l9 = (long)ai[i] & 0xffffffffL;
            long l11 = 0L + (l9 * l + ((long)ai2[i] & 0xffffffffL));
            ai2[i] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l1 + ((long)ai2[i + 1] & 0xffffffffL));
            ai2[i + 1] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l2 + ((long)ai2[i + 2] & 0xffffffffL));
            ai2[i + 2] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l3 + ((long)ai2[i + 3] & 0xffffffffL));
            ai2[i + 3] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l4 + ((long)ai2[i + 4] & 0xffffffffL));
            ai2[i + 4] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l5 + ((long)ai2[i + 5] & 0xffffffffL));
            ai2[i + 5] = (int)l11;
            l11 = (l11 >>> 32) + (l9 * l6 + ((long)ai2[i + 6] & 0xffffffffL));
            ai2[i + 6] = (int)l11;
            l9 = (l11 >>> 32) + (l9 * l7 + ((long)ai2[i + 7] & 0xffffffffL));
            ai2[i + 7] = (int)l9;
            ai2[i + 8] = (int)(l9 >>> 32);
        }

    }

    public static boolean _mth1FBE(int ai[], int ai1[])
    {
        for (int i = 7; i >= 0; i--)
        {
            if (ai[i] != ai1[i])
            {
                return false;
            }
        }

        return true;
    }
}
