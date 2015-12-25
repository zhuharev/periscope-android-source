// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class SecP256K1Field
{

    private static int aJj[] = {
        0xe90a1, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, 
        -1, -1, -1, -1, -1, -1
    };
    private static final int aJn[] = {
        0xfff16f5f, -1955, -2, -1, -1, -1, -1, -1, 1953, 2
    };
    static final int aqr[] = {
        -977, -2, -1, -1, -1, -1, -1, -1
    };

    public SecP256K1Field()
    {
    }

    public static void _mth02BB(int i, int ai[])
    {
        if (i != 0 && Nat256._mth02CB(977, i, ai, 0) != 0 || ai[7] == -1 && Nat256._mth02BE(ai, aqr))
        {
            Nat._mth02CB(8, 977, ai);
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
        if (Nat256._mth02CA(977, Nat256._mth02CA(977, ai, 8, ai, 0, ai1, 0), ai1, 0) != 0 || ai1[7] == -1 && Nat256._mth02BE(ai1, aqr))
        {
            Nat._mth02CB(8, 977, ai1);
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
            Nat._mth02CB(8, 977, ai2);
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
        if ((Nat256._mth02BE(ai, ai1, ai2) != 0 || ai2[15] == -1 && Nat._mth02CF(16, ai2, aJj)) && Nat._mth02CB(10, aJn, ai2) != 0)
        {
            Nat._mth02CE(16, ai2, 10);
        }
    }

    public static void _mth037A(int ai[], int ai1[])
    {
        if (Nat._mth02CA(8, ai, 0, ai1) != 0 || ai1[7] == -1 && Nat256._mth02BE(ai1, aqr))
        {
            Nat._mth02CB(8, 977, ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[])
    {
        if (Nat._mth141D(8, ai, ai1) != 0 || ai1[7] == -1 && Nat256._mth02BE(ai1, aqr))
        {
            Nat._mth02CB(8, 977, ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[], int ai2[])
    {
        if (Nat256._mth02BF(ai, ai1, ai2) != 0)
        {
            Nat._mth02CF(8, 977, ai2);
        }
    }

}
