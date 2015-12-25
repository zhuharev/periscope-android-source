// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.math.raw:
//            Nat

public abstract class Nat224
{

    public Nat224()
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
        l = (l >>> 32) + (((long)ai[6] & 0xffffffffL) + ((long)ai1[6] & 0xffffffffL));
        ai2[6] = (int)l;
        return (int)(l >>> 32);
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        long l1 = (long)ai[0] & 0xffffffffL;
        int j = 0;
        int i = 6;
        int k = 14;
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
        l8 = ai1[7];
        l9 = ai1[8];
        l11 = l6 * l1 + (l11 & 0xffffffffL);
        j = (int)l11;
        ai1[4] = j << 1 | i >>> 31;
        l11 = (l10 & 0xffffffffL) + ((l11 >>> 32) + l6 * l3);
        long l12 = (l7 & 0xffffffffL) + (l10 >>> 32) + ((l11 >>> 32) + l6 * l4);
        long l13 = (l8 & 0xffffffffL) + ((l12 >>> 32) + l6 * l5);
        l7 = (long)ai[5] & 0xffffffffL;
        l10 = ai1[9];
        l8 = ai1[10];
        l11 = l7 * l1 + (l11 & 0xffffffffL);
        i = (int)l11;
        ai1[5] = i << 1 | j >>> 31;
        long l14 = (l12 & 0xffffffffL) + ((l11 >>> 32) + l7 * l3);
        l12 = (l13 & 0xffffffffL) + ((l14 >>> 32) + l7 * l4);
        long l15 = (l9 & 0xffffffffL) + (l13 >>> 32) + ((l12 >>> 32) + l7 * l5);
        l13 = (l10 & 0xffffffffL) + ((l15 >>> 32) + l7 * l6);
        l10 = (long)ai[6] & 0xffffffffL;
        l11 = ai1[11];
        l9 = ai1[12];
        l1 = l10 * l1 + (l14 & 0xffffffffL);
        j = (int)l1;
        ai1[6] = j << 1 | i >>> 31;
        l1 = (l12 & 0xffffffffL) + ((l1 >>> 32) + l10 * l3);
        l3 = (l15 & 0xffffffffL) + ((l1 >>> 32) + l10 * l4);
        l4 = (l13 & 0xffffffffL) + ((l3 >>> 32) + l10 * l5);
        l5 = (l8 & 0xffffffffL) + (l13 >>> 32) + ((l4 >>> 32) + l10 * l6);
        l6 = (l11 & 0xffffffffL) + ((l5 >>> 32) + l10 * l7);
        l7 = (l9 & 0xffffffffL) + (l6 >>> 32);
        i = (int)l1;
        ai1[7] = i << 1 | j >>> 31;
        j = (int)l3;
        ai1[8] = j << 1 | i >>> 31;
        i = (int)l4;
        ai1[9] = i << 1 | j >>> 31;
        j = (int)l5;
        ai1[10] = j << 1 | i >>> 31;
        i = (int)l6;
        ai1[11] = i << 1 | j >>> 31;
        j = (int)l7;
        ai1[12] = j << 1 | i >>> 31;
        ai1[13] = ai1[13] + (int)(l7 >> 32) << 1 | j >>> 31;
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
        long l = 0L;
        for (int i = 0; i < 7; i++)
        {
            long l8 = (long)ai[i] & 0xffffffffL;
            long l9 = 0L + (l8 * (l1 & 0xffffffffL) + ((long)ai2[i] & 0xffffffffL));
            ai2[i] = (int)l9;
            l9 = (l9 >>> 32) + (l8 * (l2 & 0xffffffffL) + ((long)ai2[i + 1] & 0xffffffffL));
            ai2[i + 1] = (int)l9;
            l9 = (l9 >>> 32) + (l8 * (l3 & 0xffffffffL) + ((long)ai2[i + 2] & 0xffffffffL));
            ai2[i + 2] = (int)l9;
            l9 = (l9 >>> 32) + (l8 * (l4 & 0xffffffffL) + ((long)ai2[i + 3] & 0xffffffffL));
            ai2[i + 3] = (int)l9;
            l9 = (l9 >>> 32) + (l8 * (l5 & 0xffffffffL) + ((long)ai2[i + 4] & 0xffffffffL));
            ai2[i + 4] = (int)l9;
            l9 = (l9 >>> 32) + (l8 * (l6 & 0xffffffffL) + ((long)ai2[i + 5] & 0xffffffffL));
            ai2[i + 5] = (int)l9;
            l8 = (l9 >>> 32) + (l8 * (l7 & 0xffffffffL) + ((long)ai2[i + 6] & 0xffffffffL));
            ai2[i + 6] = (int)l8;
            l = (l8 >>> 32) + (((long)ai2[i + 7] & 0xffffffffL) + l);
            ai2[i + 7] = (int)l;
            l >>>= 32;
        }

        return (int)l;
    }

    public static boolean _mth02BE(int ai[], int ai1[])
    {
        for (int i = 6; i >= 0; i--)
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
        if (biginteger.signum() < 0 || biginteger.bitLength() > 224)
        {
            throw new IllegalArgumentException();
        }
        int ai[] = new int[7];
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
        return (int)(l >> 32);
    }

    public static boolean _mth02BF(int ai[])
    {
        if (ai[0] != 1)
        {
            return false;
        }
        for (int i = 1; i < 7; i++)
        {
            if (ai[i] != 0)
            {
                return false;
            }
        }

        return true;
    }

    public static void _mth02C8(int ai[], int ai1[])
    {
        ai1[0] = ai[0];
        ai1[1] = ai[1];
        ai1[2] = ai[2];
        ai1[3] = ai[3];
        ai1[4] = ai[4];
        ai1[5] = ai[5];
        ai1[6] = ai[6];
    }

    public static boolean _mth02C8(int ai[])
    {
        for (int i = 0; i < 7; i++)
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
        byte abyte0[] = new byte[28];
        for (int i = 0; i < 7; i++)
        {
            int j = ai[i];
            if (j != 0)
            {
                Pack._mth1FBE(j, abyte0, 6 - i << 2);
            }
        }

        return new BigInteger(1, abyte0);
    }

    public static int _mth02CA(int i, long l, int ai[], int j)
    {
        long l1 = l & 0xffffffffL;
        long l2 = 0L + (6803L * l1 + ((long)ai[0] & 0xffffffffL));
        ai[0] = (int)l2;
        l >>>= 32;
        l1 = (l2 >>> 32) + (6803L * l + l1 + ((long)ai[1] & 0xffffffffL));
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
            return Nat._mth02CA(7, ai, 0, 4);
        }
    }

    public static long _mth02CA(int i, int ai[], int j, int ai1[], int k, int ai2[], int l)
    {
        long l2 = (long)ai[7] & 0xffffffffL;
        long l3 = 0L + (6803L * l2 + ((long)ai1[0] & 0xffffffffL));
        ai2[0] = (int)l3;
        long l1 = (long)ai[8] & 0xffffffffL;
        l3 = (l3 >>> 32) + (6803L * l1 + l2 + ((long)ai1[1] & 0xffffffffL));
        ai2[1] = (int)l3;
        l2 = (long)ai[9] & 0xffffffffL;
        l3 = (l3 >>> 32) + (6803L * l2 + l1 + ((long)ai1[2] & 0xffffffffL));
        ai2[2] = (int)l3;
        l1 = (long)ai[10] & 0xffffffffL;
        l3 = (l3 >>> 32) + (6803L * l1 + l2 + ((long)ai1[3] & 0xffffffffL));
        ai2[3] = (int)l3;
        l2 = (long)ai[11] & 0xffffffffL;
        l3 = (l3 >>> 32) + (6803L * l2 + l1 + ((long)ai1[4] & 0xffffffffL));
        ai2[4] = (int)l3;
        l1 = (long)ai[12] & 0xffffffffL;
        l3 = (l3 >>> 32) + (6803L * l1 + l2 + ((long)ai1[5] & 0xffffffffL));
        ai2[5] = (int)l3;
        l2 = (long)ai[13] & 0xffffffffL;
        l1 = (l3 >>> 32) + (6803L * l2 + l1 + ((long)ai1[6] & 0xffffffffL));
        ai2[6] = (int)l1;
        return (l1 >>> 32) + l2;
    }

    public static int _mth02CB(int i, int j, int ai[], int k)
    {
        long l = (long)j & 0xffffffffL;
        long l1 = 0L + (6803L * l + ((long)ai[0] & 0xffffffffL));
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
            return Nat._mth02CA(7, ai, 0, 3);
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
    }

    public static int _mth02CE(int ai[], int i)
    {
        return ai[0] & 1;
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
        return (int)(l >>> 32);
    }

    public static int[] _mth05E4()
    {
        return new int[7];
    }

    public static int[] _mth05E7()
    {
        return new int[14];
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
        long l7 = (long)ai[0] & 0xffffffffL;
        long l9 = 0L + l7 * l;
        ai2[0] = (int)l9;
        l9 = (l9 >>> 32) + l7 * l1;
        ai2[1] = (int)l9;
        l9 = (l9 >>> 32) + l7 * l2;
        ai2[2] = (int)l9;
        l9 = (l9 >>> 32) + l7 * l3;
        ai2[3] = (int)l9;
        l9 = (l9 >>> 32) + l7 * l4;
        ai2[4] = (int)l9;
        l9 = (l9 >>> 32) + l7 * l5;
        ai2[5] = (int)l9;
        l7 = (l9 >>> 32) + l7 * l6;
        ai2[6] = (int)l7;
        ai2[7] = (int)(l7 >>> 32);
        for (int i = 1; i < 7; i++)
        {
            long l8 = (long)ai[i] & 0xffffffffL;
            long l10 = 0L + (l8 * l + ((long)ai2[i] & 0xffffffffL));
            ai2[i] = (int)l10;
            l10 = (l10 >>> 32) + (l8 * l1 + ((long)ai2[i + 1] & 0xffffffffL));
            ai2[i + 1] = (int)l10;
            l10 = (l10 >>> 32) + (l8 * l2 + ((long)ai2[i + 2] & 0xffffffffL));
            ai2[i + 2] = (int)l10;
            l10 = (l10 >>> 32) + (l8 * l3 + ((long)ai2[i + 3] & 0xffffffffL));
            ai2[i + 3] = (int)l10;
            l10 = (l10 >>> 32) + (l8 * l4 + ((long)ai2[i + 4] & 0xffffffffL));
            ai2[i + 4] = (int)l10;
            l10 = (l10 >>> 32) + (l8 * l5 + ((long)ai2[i + 5] & 0xffffffffL));
            ai2[i + 5] = (int)l10;
            l8 = (l10 >>> 32) + (l8 * l6 + ((long)ai2[i + 6] & 0xffffffffL));
            ai2[i + 6] = (int)l8;
            ai2[i + 7] = (int)(l8 >>> 32);
        }

    }

    public static boolean _mth1FBE(int ai[], int ai1[])
    {
        for (int i = 6; i >= 0; i--)
        {
            if (ai[i] != ai1[i])
            {
                return false;
            }
        }

        return true;
    }
}
