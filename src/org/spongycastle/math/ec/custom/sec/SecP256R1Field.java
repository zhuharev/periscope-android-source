// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class SecP256R1Field
{

    private static int aJj[] = {
        1, 0, 0, -2, -1, -1, -2, 1, -2, 1, 
        -2, 1, 1, -2, 2, -2
    };
    static final int aqr[] = {
        -1, -1, -1, 0, 0, 0, 1, -1
    };

    public SecP256R1Field()
    {
    }

    public static void _mth02BB(int i, int ai[])
    {
        long l = 0L;
        if (i != 0)
        {
            long l3 = (long)i & 0xffffffffL;
            l = 0L + (((long)ai[0] & 0xffffffffL) + l3);
            ai[0] = (int)l;
            long l2 = l >> 32;
            l = l2;
            long l1 = l;
            if (l2 != 0L)
            {
                l += (long)ai[1] & 0xffffffffL;
                ai[1] = (int)l;
                l = (l >> 32) + ((long)ai[2] & 0xffffffffL);
                ai[2] = (int)l;
                l1 = l >> 32;
            }
            l = l1 + (((long)ai[3] & 0xffffffffL) - l3);
            ai[3] = (int)l;
            l2 = l >> 32;
            l = l2;
            l1 = l;
            if (l2 != 0L)
            {
                l += (long)ai[4] & 0xffffffffL;
                ai[4] = (int)l;
                l = (l >> 32) + ((long)ai[5] & 0xffffffffL);
                ai[5] = (int)l;
                l1 = l >> 32;
            }
            l = l1 + (((long)ai[6] & 0xffffffffL) - l3);
            ai[6] = (int)l;
            l = (l >> 32) + (((long)ai[7] & 0xffffffffL) + l3);
            ai[7] = (int)l;
            l >>= 32;
        }
        if (l != 0L || ai[7] == -1 && Nat256._mth02BE(ai, aqr))
        {
            _mth02BD(ai);
        }
    }

    public static void _mth02BB(int ai[], int ai1[])
    {
        if (Nat256._mth02C8(ai))
        {
            Nat256._mth02CC(ai1);
            return;
        } else
        {
            Nat256._mth02BF(aqr, ai, ai1);
            return;
        }
    }

    public static void _mth02BC(int ai[], int ai1[])
    {
        long l1 = ai[8];
        long l6 = (long)ai[9] & 0xffffffffL;
        long l4 = (long)ai[10] & 0xffffffffL;
        long l8 = (long)ai[11] & 0xffffffffL;
        long l7 = (long)ai[12] & 0xffffffffL;
        long l5 = (long)ai[13] & 0xffffffffL;
        long l3 = (long)ai[14] & 0xffffffffL;
        long l = (long)ai[15] & 0xffffffffL;
        l1 = (l1 & 0xffffffffL) - 6L;
        long l2 = l1 + l6;
        l6 += l4;
        l4 = (l4 + l8) - l;
        long l10 = l8 + l7;
        l7 += l5;
        l8 = l5 + l3;
        long l9 = l3 + l;
        long l11 = 0L + ((((long)ai[0] & 0xffffffffL) + l2) - l10 - l8);
        ai1[0] = (int)l11;
        l11 = (l11 >> 32) + ((((long)ai[1] & 0xffffffffL) + l6) - l7 - l9);
        ai1[1] = (int)l11;
        l11 = (l11 >> 32) + ((((long)ai[2] & 0xffffffffL) + l4) - l8);
        ai1[2] = (int)l11;
        l5 = (l11 >> 32) + ((((long)ai[3] & 0xffffffffL) + (l10 << 1) + l5) - l - l2);
        ai1[3] = (int)l5;
        l3 = (l5 >> 32) + ((((long)ai[4] & 0xffffffffL) + (l7 << 1) + l3) - l6);
        ai1[4] = (int)l3;
        l3 = (l3 >> 32) + ((((long)ai[5] & 0xffffffffL) + (l8 << 1)) - l4);
        ai1[5] = (int)l3;
        l2 = (l3 >> 32) + ((((long)ai[6] & 0xffffffffL) + (l9 << 1) + l8) - l2);
        ai1[6] = (int)l2;
        l = (l2 >> 32) + ((((long)ai[7] & 0xffffffffL) + (l << 1) + l1) - l4 - l7);
        ai1[7] = (int)l;
        _mth02BB((int)((l >> 32) + 6L), ai1);
    }

    private static void _mth02BD(int ai[])
    {
        long l = ((long)ai[0] & 0xffffffffL) + 1L;
        ai[0] = (int)l;
        long l2 = l >> 32;
        l = l2;
        long l1 = l;
        if (l2 != 0L)
        {
            l += (long)ai[1] & 0xffffffffL;
            ai[1] = (int)l;
            l = (l >> 32) + ((long)ai[2] & 0xffffffffL);
            ai[2] = (int)l;
            l1 = l >> 32;
        }
        l = l1 + (((long)ai[3] & 0xffffffffL) - 1L);
        ai[3] = (int)l;
        l2 = l >> 32;
        l = l2;
        l1 = l;
        if (l2 != 0L)
        {
            l += (long)ai[4] & 0xffffffffL;
            ai[4] = (int)l;
            l = (l >> 32) + ((long)ai[5] & 0xffffffffL);
            ai[5] = (int)l;
            l1 = l >> 32;
        }
        l = l1 + (((long)ai[6] & 0xffffffffL) - 1L);
        ai[6] = (int)l;
        ai[7] = (int)((l >> 32) + (((long)ai[7] & 0xffffffffL) + 1L));
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        int ai2[] = Nat256._mth05E7();
        Nat256._mth02BD(ai, ai2);
        _mth02BC(ai2, ai1);
    }

    public static int[] _mth02BE(BigInteger biginteger)
    {
        biginteger = Nat256._mth02BE(biginteger);
        if (biginteger[7] == -1 && Nat256._mth02BE(biginteger, aqr))
        {
            Nat256._mth02BF(aqr, biginteger);
        }
        return biginteger;
    }

    public static void _mth02CA(int ai[], int i, int ai1[])
    {
        int ai2[] = Nat256._mth05E7();
        Nat256._mth02BD(ai, ai2);
        _mth02BC(ai2, ai1);
        do
        {
            i--;
            if (i > 0)
            {
                Nat256._mth02BD(ai1, ai2);
                _mth02BC(ai2, ai1);
            } else
            {
                return;
            }
        } while (true);
    }

    public static void _mth02CB(int ai[], int ai1[], int ai2[])
    {
        if (Nat256._mth02BD(ai, ai1, ai2) != 0 || ai2[7] == -1 && Nat256._mth02BE(ai2, aqr))
        {
            _mth02BD(ai2);
        }
    }

    public static void _mth02CE(int ai[], int ai1[], int ai2[])
    {
        int ai3[] = Nat256._mth05E7();
        Nat256._mth1FBE(ai, ai1, ai3);
        _mth02BC(ai3, ai2);
    }

    public static void _mth02CF(int ai[], int ai1[], int ai2[])
    {
        if (Nat256._mth02BE(ai, ai1, ai2) != 0 || ai2[15] == -1 && Nat._mth02CF(16, ai2, aJj))
        {
            Nat._mth02BB(16, aJj, ai2);
        }
    }

    public static void _mth037A(int ai[], int ai1[])
    {
        if (Nat._mth02CA(8, ai, 0, ai1) != 0 || ai1[7] == -1 && Nat256._mth02BE(ai1, aqr))
        {
            _mth02BD(ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[])
    {
        if (Nat._mth141D(8, ai, ai1) != 0 || ai1[7] == -1 && Nat256._mth02BE(ai1, aqr))
        {
            _mth02BD(ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[], int ai2[])
    {
        if (Nat256._mth02BF(ai, ai1, ai2) != 0)
        {
            long l = ((long)ai2[0] & 0xffffffffL) - 1L;
            ai2[0] = (int)l;
            long l2 = l >> 32;
            l = l2;
            long l1 = l;
            if (l2 != 0L)
            {
                l += (long)ai2[1] & 0xffffffffL;
                ai2[1] = (int)l;
                l = (l >> 32) + ((long)ai2[2] & 0xffffffffL);
                ai2[2] = (int)l;
                l1 = l >> 32;
            }
            l = l1 + (((long)ai2[3] & 0xffffffffL) + 1L);
            ai2[3] = (int)l;
            l2 = l >> 32;
            l = l2;
            l1 = l;
            if (l2 != 0L)
            {
                l += (long)ai2[4] & 0xffffffffL;
                ai2[4] = (int)l;
                l = (l >> 32) + ((long)ai2[5] & 0xffffffffL);
                ai2[5] = (int)l;
                l1 = l >> 32;
            }
            l = l1 + (((long)ai2[6] & 0xffffffffL) + 1L);
            ai2[6] = (int)l;
            ai2[7] = (int)((l >> 32) + (((long)ai2[7] & 0xffffffffL) - 1L));
        }
    }

}
