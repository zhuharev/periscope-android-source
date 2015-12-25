// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class Curve25519Field
{

    private static final int aJj[] = {
        361, 0, 0, 0, 0, 0, 0, 0, -19, -1, 
        -1, -1, -1, -1, -1, 0x3fffffff
    };
    static final int aqr[] = {
        -19, -1, -1, -1, -1, -1, -1, 0x7fffffff
    };

    public Curve25519Field()
    {
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

    private static int _mth02BC(int ai[])
    {
        long l = ((long)ai[0] & 0xffffffffL) + 19L;
        ai[0] = (int)l;
        long l1 = l >> 32;
        l = l1;
        if (l1 != 0L)
        {
            l = Nat._mth02CE(7, ai, 1);
        }
        l += ((long)ai[7] & 0xffffffffL) - 0x80000000L;
        ai[7] = (int)l;
        return (int)(l >> 32);
    }

    public static void _mth02BC(int ai[], int ai1[])
    {
        int i = ai[7];
        Nat._mth02CA(8, ai, 8, i, ai1, 0);
        int j = Nat256._mth02BC(19, ai, ai1);
        int k = ai1[7];
        ai1[7] = (0x7fffffff & k) + Nat._mth02CE(7, ((j << 1) + ((k >>> 31) - (i >>> 31))) * 19, ai1);
        if (Nat256._mth02BE(ai1, aqr))
        {
            _mth02BC(ai1);
        }
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        int ai2[] = Nat256._mth05E7();
        Nat256._mth02BD(ai, ai2);
        _mth02BC(ai2, ai1);
    }

    public static int[] _mth02BE(BigInteger biginteger)
    {
        for (biginteger = Nat256._mth02BE(biginteger); Nat256._mth02BE(biginteger, aqr); Nat256._mth02BF(aqr, biginteger)) { }
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
        Nat256._mth02BD(ai, ai1, ai2);
        if (Nat256._mth02BE(ai2, aqr))
        {
            _mth02BC(ai2);
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
        Nat256._mth02BE(ai, ai1, ai2);
        if (Nat._mth02CF(16, ai2, aJj))
        {
            long l = ((long)ai2[0] & 0xffffffffL) - ((long)aJj[0] & 0xffffffffL);
            ai2[0] = (int)l;
            long l1 = l >> 32;
            l = l1;
            if (l1 != 0L)
            {
                l = Nat._mth02CB(8, ai2, 1);
            }
            l += ((long)ai2[8] & 0xffffffffL) + 19L;
            ai2[8] = (int)l;
            l1 = l >> 32;
            l = l1;
            if (l1 != 0L)
            {
                l = Nat._mth02CE(15, ai2, 9);
            }
            l += ((long)ai2[15] & 0xffffffffL) - ((long)(aJj[15] + 1) & 0xffffffffL);
            ai2[15] = (int)l;
        }
    }

    public static void _mth037A(int ai[], int ai1[])
    {
        Nat._mth02CA(8, ai, 0, ai1);
        if (Nat256._mth02BE(ai1, aqr))
        {
            _mth02BC(ai1);
        }
    }

    public static void _mth141D(int i, int ai[])
    {
        int j = ai[7];
        ai[7] = (0x7fffffff & j) + Nat._mth02CE(7, (i << 1 | j >>> 31) * 19, ai);
        if (Nat256._mth02BE(ai, aqr))
        {
            _mth02BC(ai);
        }
    }

    public static void _mth141D(int ai[], int ai1[])
    {
        Nat._mth141D(8, ai, ai1);
        if (Nat256._mth02BE(ai1, aqr))
        {
            _mth02BC(ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[], int ai2[])
    {
        if (Nat256._mth02BF(ai, ai1, ai2) != 0)
        {
            long l = ((long)ai2[0] & 0xffffffffL) - 19L;
            ai2[0] = (int)l;
            long l1 = l >> 32;
            l = l1;
            if (l1 != 0L)
            {
                l = Nat._mth02CB(7, ai2, 1);
            }
            l += ((long)ai2[7] & 0xffffffffL) + 0x80000000L;
            ai2[7] = (int)l;
        }
    }

}
