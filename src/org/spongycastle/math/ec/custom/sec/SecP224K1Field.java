// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;

public class SecP224K1Field
{

    private static int aJj[] = {
        0x2c23069, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, 
        -1, -1, -1, -1
    };
    private static final int aJn[] = {
        0xfd3dcf97, -13607, -2, -1, -1, -1, -1, 13605, 2
    };
    static final int aqr[] = {
        -6803, -2, -1, -1, -1, -1, -1
    };

    public SecP224K1Field()
    {
    }

    public static void _mth02BB(int i, int ai[])
    {
        if (i != 0 && Nat224._mth02CB(6803, i, ai, 0) != 0 || ai[6] == -1 && Nat224._mth02BE(ai, aqr))
        {
            Nat._mth02CB(7, 6803, ai);
        }
    }

    public static void _mth02BB(int ai[], int ai1[])
    {
        if (Nat224._mth02C8(ai))
        {
            Nat224._mth02CC(ai1);
            return;
        } else
        {
            Nat224._mth02BF(aqr, ai, ai1);
            return;
        }
    }

    public static void _mth02BC(int ai[], int ai1[])
    {
        if (Nat224._mth02CA(6803, Nat224._mth02CA(6803, ai, 7, ai, 0, ai1, 0), ai1, 0) != 0 || ai1[6] == -1 && Nat224._mth02BE(ai1, aqr))
        {
            Nat._mth02CB(7, 6803, ai1);
        }
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        int ai2[] = Nat224._mth05E7();
        Nat224._mth02BD(ai, ai2);
        _mth02BC(ai2, ai1);
    }

    public static int[] _mth02BE(BigInteger biginteger)
    {
        biginteger = Nat224._mth02BE(biginteger);
        if (biginteger[6] == -1 && Nat224._mth02BE(biginteger, aqr))
        {
            Nat._mth02CB(7, 6803, biginteger);
        }
        return biginteger;
    }

    public static void _mth02CA(int ai[], int i, int ai1[])
    {
        int ai2[] = Nat224._mth05E7();
        Nat224._mth02BD(ai, ai2);
        _mth02BC(ai2, ai1);
        do
        {
            i--;
            if (i > 0)
            {
                Nat224._mth02BD(ai1, ai2);
                _mth02BC(ai2, ai1);
            } else
            {
                return;
            }
        } while (true);
    }

    public static void _mth02CB(int ai[], int ai1[], int ai2[])
    {
        if (Nat224._mth02BD(ai, ai1, ai2) != 0 || ai2[6] == -1 && Nat224._mth02BE(ai2, aqr))
        {
            Nat._mth02CB(7, 6803, ai2);
        }
    }

    public static void _mth02CE(int ai[], int ai1[], int ai2[])
    {
        int ai3[] = Nat224._mth05E7();
        Nat224._mth1FBE(ai, ai1, ai3);
        _mth02BC(ai3, ai2);
    }

    public static void _mth02CF(int ai[], int ai1[], int ai2[])
    {
        if ((Nat224._mth02BE(ai, ai1, ai2) != 0 || ai2[13] == -1 && Nat._mth02CF(14, ai2, aJj)) && Nat._mth02CB(9, aJn, ai2) != 0)
        {
            Nat._mth02CE(14, ai2, 9);
        }
    }

    public static void _mth037A(int ai[], int ai1[])
    {
        if (Nat._mth02CA(7, ai, 0, ai1) != 0 || ai1[6] == -1 && Nat224._mth02BE(ai1, aqr))
        {
            Nat._mth02CB(7, 6803, ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[])
    {
        if (Nat._mth141D(7, ai, ai1) != 0 || ai1[6] == -1 && Nat224._mth02BE(ai1, aqr))
        {
            Nat._mth02CB(7, 6803, ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[], int ai2[])
    {
        if (Nat224._mth02BF(ai, ai1, ai2) != 0)
        {
            Nat._mth02CF(7, 6803, ai2);
        }
    }

}
