// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat384;

public class SecP384R1Field
{

    private static int aJj[] = {
        1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 
        0, 0, -2, 1, 0, -2, -3, -1, -1, -1, 
        -1, -1, -1, -1
    };
    private static final int aJn[] = {
        -1, 1, -1, -3, -1, 1, -1, -3, -2, -1, 
        -1, -1, 1, -2, -1, 1, 2
    };
    static final int aqr[] = {
        -1, 0, 0, -1, -2, -1, -1, -1, -1, -1, 
        -1, -1
    };

    public SecP384R1Field()
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
            l = (l >> 32) + (((long)ai[1] & 0xffffffffL) - l3);
            ai[1] = (int)l;
            long l2 = l >> 32;
            l = l2;
            long l1 = l;
            if (l2 != 0L)
            {
                l += (long)ai[2] & 0xffffffffL;
                ai[2] = (int)l;
                l1 = l >> 32;
            }
            l = l1 + (((long)ai[3] & 0xffffffffL) + l3);
            ai[3] = (int)l;
            l = (l >> 32) + (((long)ai[4] & 0xffffffffL) + l3);
            ai[4] = (int)l;
            l >>= 32;
        }
        if (l != 0L && Nat._mth02CE(12, ai, 5) != 0 || ai[11] == -1 && Nat._mth02CF(12, ai, aqr))
        {
            _mth02BD(ai);
        }
    }

    public static void _mth02BB(int ai[], int ai1[])
    {
        if (Nat._mth02BE(12, ai))
        {
            Nat._mth02C8(12, ai1);
            return;
        } else
        {
            Nat._mth02CE(12, aqr, ai, ai1);
            return;
        }
    }

    public static void _mth02BB(int ai[], int ai1[], int ai2[])
    {
        if ((Nat._mth02CA(24, ai, ai1, ai2) != 0 || ai2[23] == -1 && Nat._mth02CF(24, ai2, aJj)) && Nat._mth02CB(17, aJn, ai2) != 0)
        {
            Nat._mth02CE(24, ai2, 17);
        }
    }

    public static void _mth02BC(int ai[], int ai1[])
    {
        long l6 = (long)ai[16] & 0xffffffffL;
        long l7 = (long)ai[17] & 0xffffffffL;
        long l2 = (long)ai[18] & 0xffffffffL;
        long l = (long)ai[19] & 0xffffffffL;
        long l1 = (long)ai[20] & 0xffffffffL;
        long l11 = (long)ai[21] & 0xffffffffL;
        long l4 = (long)ai[22] & 0xffffffffL;
        long l13 = (long)ai[23] & 0xffffffffL;
        long l12 = (((long)ai[12] & 0xffffffffL) + l1) - 1L;
        long l10 = ((long)ai[13] & 0xffffffffL) + l4;
        long l9 = ((long)ai[14] & 0xffffffffL) + l4 + l13;
        long l8 = ((long)ai[15] & 0xffffffffL) + l13;
        long l5 = l7 + l11;
        long l3 = l11 - l13;
        l4 -= l13;
        long l14 = 0L + (((long)ai[0] & 0xffffffffL) + l12 + l3);
        ai1[0] = (int)l14;
        l13 = (l14 >> 32) + (((((long)ai[1] & 0xffffffffL) + l13) - l12) + l10);
        ai1[1] = (int)l13;
        l13 = (l13 >> 32) + ((((long)ai[2] & 0xffffffffL) - l11 - l10) + l9);
        ai1[2] = (int)l13;
        l13 = (l13 >> 32) + (((((long)ai[3] & 0xffffffffL) + l12) - l9) + l8 + l3);
        ai1[3] = (int)l13;
        l11 = (l13 >> 32) + (((((long)ai[4] & 0xffffffffL) + l6 + l11 + l12 + l10) - l8) + l3);
        ai1[4] = (int)l11;
        l10 = (l11 >> 32) + ((((long)ai[5] & 0xffffffffL) - l6) + l10 + l9 + l5);
        ai1[5] = (int)l10;
        l9 = (l10 >> 32) + (((((long)ai[6] & 0xffffffffL) + l2) - l7) + l9 + l8);
        ai1[6] = (int)l9;
        l8 = (l9 >> 32) + (((((long)ai[7] & 0xffffffffL) + l6 + l) - l2) + l8);
        ai1[7] = (int)l8;
        l6 = (l8 >> 32) + ((((long)ai[8] & 0xffffffffL) + l6 + l7 + l1) - l);
        ai1[8] = (int)l6;
        l5 = (l6 >> 32) + (((((long)ai[9] & 0xffffffffL) + l2) - l1) + l5);
        ai1[9] = (int)l5;
        l2 = (l5 >> 32) + (((((long)ai[10] & 0xffffffffL) + l2 + l) - l3) + l4);
        ai1[10] = (int)l2;
        l = (l2 >> 32) + ((((long)ai[11] & 0xffffffffL) + l + l1) - l4);
        ai1[11] = (int)l;
        _mth02BB((int)((l >> 32) + 1L), ai1);
    }

    private static void _mth02BD(int ai[])
    {
        long l = ((long)ai[0] & 0xffffffffL) + 1L;
        ai[0] = (int)l;
        l = (l >> 32) + (((long)ai[1] & 0xffffffffL) - 1L);
        ai[1] = (int)l;
        long l2 = l >> 32;
        l = l2;
        long l1 = l;
        if (l2 != 0L)
        {
            l += (long)ai[2] & 0xffffffffL;
            ai[2] = (int)l;
            l1 = l >> 32;
        }
        l = l1 + (((long)ai[3] & 0xffffffffL) + 1L);
        ai[3] = (int)l;
        l = (l >> 32) + (((long)ai[4] & 0xffffffffL) + 1L);
        ai[4] = (int)l;
        if (l >> 32 != 0L)
        {
            Nat._mth02CE(12, ai, 5);
        }
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        int ai2[] = Nat._mth1D37(24);
        Nat384._mth02BD(ai, ai2);
        _mth02BC(ai2, ai1);
    }

    public static int[] _mth02BE(BigInteger biginteger)
    {
        biginteger = Nat._mth141D(384, biginteger);
        if (biginteger[11] == -1 && Nat._mth02CF(12, biginteger, aqr))
        {
            Nat._mth02BB(12, aqr, biginteger);
        }
        return biginteger;
    }

    public static void _mth02CA(int ai[], int i, int ai1[])
    {
        int ai2[] = Nat._mth1D37(24);
        Nat384._mth02BD(ai, ai2);
        _mth02BC(ai2, ai1);
        do
        {
            i--;
            if (i > 0)
            {
                Nat384._mth02BD(ai1, ai2);
                _mth02BC(ai2, ai1);
            } else
            {
                return;
            }
        } while (true);
    }

    public static void _mth02CB(int ai[], int ai1[], int ai2[])
    {
        if (Nat._mth02CA(12, ai, ai1, ai2) != 0 || ai2[11] == -1 && Nat._mth02CF(12, ai2, aqr))
        {
            _mth02BD(ai2);
        }
    }

    public static void _mth02CE(int ai[], int ai1[], int ai2[])
    {
        int ai3[] = Nat._mth1D37(24);
        Nat384._mth1FBE(ai, ai1, ai3);
        _mth02BC(ai3, ai2);
    }

    public static void _mth037A(int ai[], int ai1[])
    {
        if (Nat._mth02CA(12, ai, 0, ai1) != 0 || ai1[11] == -1 && Nat._mth02CF(12, ai1, aqr))
        {
            _mth02BD(ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[])
    {
        if (Nat._mth141D(12, ai, ai1) != 0 || ai1[11] == -1 && Nat._mth02CF(12, ai1, aqr))
        {
            _mth02BD(ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[], int ai2[])
    {
        if (Nat._mth02CE(12, ai, ai1, ai2) != 0)
        {
            long l = ((long)ai2[0] & 0xffffffffL) - 1L;
            ai2[0] = (int)l;
            l = (l >> 32) + (((long)ai2[1] & 0xffffffffL) + 1L);
            ai2[1] = (int)l;
            long l2 = l >> 32;
            l = l2;
            long l1 = l;
            if (l2 != 0L)
            {
                l += (long)ai2[2] & 0xffffffffL;
                ai2[2] = (int)l;
                l1 = l >> 32;
            }
            l = l1 + (((long)ai2[3] & 0xffffffffL) - 1L);
            ai2[3] = (int)l;
            l = (l >> 32) + (((long)ai2[4] & 0xffffffffL) - 1L);
            ai2[4] = (int)l;
            if (l >> 32 != 0L)
            {
                Nat._mth02CB(12, ai2, 5);
            }
        }
    }

}
