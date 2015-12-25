// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat512;

public class SecP521R1Field
{

    static final int aqr[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, 511
    };

    public SecP521R1Field()
    {
    }

    public static void _mth02BB(int ai[], int ai1[])
    {
        if (Nat._mth02BE(17, ai))
        {
            Nat._mth02C8(17, ai1);
            return;
        } else
        {
            Nat._mth02CE(17, aqr, ai, ai1);
            return;
        }
    }

    private static void _mth02BC(int ai[], int ai1[])
    {
        int j;
label0:
        {
            int i = ai[32];
            j = (Nat._mth02CA(16, ai, 16, 9, i, ai1, 0) >>> 23) + (i >>> 9) + Nat._mth02CB(16, ai, ai1);
            i = j;
            if (j <= 511)
            {
                j = i;
                if (i != 511)
                {
                    break label0;
                }
                j = i;
                if (!Nat._mth02CE(16, ai1, aqr))
                {
                    break label0;
                }
            }
            j = Nat._mth037A(16, ai1) + i & 0x1ff;
        }
        ai1[16] = j;
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        int ai2[] = Nat._mth1D37(33);
        Nat512._mth02BD(ai, ai2);
        int i = ai[16];
        ai2[32] = Nat._mth02CA(16, i << 1, ai, 0, ai2, 16) + i * i;
        _mth02BC(ai2, ai1);
    }

    public static int[] _mth02BE(BigInteger biginteger)
    {
        biginteger = Nat._mth141D(521, biginteger);
        if (Nat._mth02CE(17, biginteger, aqr))
        {
            Nat._mth02C8(17, biginteger);
        }
        return biginteger;
    }

    public static void _mth02CA(int ai[], int i, int ai1[])
    {
        int ai2[] = Nat._mth1D37(33);
        Nat512._mth02BD(ai, ai2);
        int j = ai[16];
        ai2[32] = Nat._mth02CA(16, j << 1, ai, 0, ai2, 16) + j * j;
        _mth02BC(ai2, ai1);
        do
        {
            i--;
            if (i > 0)
            {
                Nat512._mth02BD(ai1, ai2);
                int k = ai1[16];
                ai2[32] = Nat._mth02CA(16, k << 1, ai1, 0, ai2, 16) + k * k;
                _mth02BC(ai2, ai1);
            } else
            {
                return;
            }
        } while (true);
    }

    public static void _mth02CB(int ai[], int ai1[], int ai2[])
    {
        int j;
label0:
        {
            j = Nat._mth02CA(16, ai, ai1, ai2) + ai[16] + ai1[16];
            int i = j;
            if (j <= 511)
            {
                j = i;
                if (i != 511)
                {
                    break label0;
                }
                j = i;
                if (!Nat._mth02CE(16, ai2, aqr))
                {
                    break label0;
                }
            }
            j = Nat._mth037A(16, ai2) + i & 0x1ff;
        }
        ai2[16] = j;
    }

    public static void _mth02CE(int ai[], int ai1[], int ai2[])
    {
        int ai3[] = Nat._mth1D37(33);
        Nat512._mth1FBE(ai, ai1, ai3);
        int i = ai[16];
        int j = ai1[16];
        ai3[32] = Nat._mth02CA(16, i, ai1, j, ai, ai3, 16) + i * j;
        _mth02BC(ai3, ai2);
    }

    public static void _mth037A(int ai[])
    {
        int j;
label0:
        {
            int i = ai[16];
            j = Nat._mth02CE(16, i >>> 9, ai) + (i & 0x1ff);
            i = j;
            if (j <= 511)
            {
                j = i;
                if (i != 511)
                {
                    break label0;
                }
                j = i;
                if (!Nat._mth02CE(16, ai, aqr))
                {
                    break label0;
                }
            }
            j = Nat._mth037A(16, ai) + i & 0x1ff;
        }
        ai[16] = j;
    }

    public static void _mth037A(int ai[], int ai1[])
    {
        int i = ai[16];
        ai1[16] = (Nat._mth02CA(16, ai, i << 23, ai1) | i << 1) & 0x1ff;
    }

    public static void _mth141D(int ai[], int ai1[])
    {
        int j;
label0:
        {
            j = Nat._mth141D(16, ai, ai1) + ai[16];
            int i = j;
            if (j <= 511)
            {
                j = i;
                if (i != 511)
                {
                    break label0;
                }
                j = i;
                if (!Nat._mth02CE(16, ai1, aqr))
                {
                    break label0;
                }
            }
            j = Nat._mth037A(16, ai1) + i & 0x1ff;
        }
        ai1[16] = j;
    }

    public static void _mth141D(int ai[], int ai1[], int ai2[])
    {
        int k = (Nat._mth02CE(16, ai, ai1, ai2) + ai[16]) - ai1[16];
        int i = k;
        int j = i;
        if (k < 0)
        {
            j = Nat._mth02BD(16, ai2) + i & 0x1ff;
        }
        ai2[16] = j;
    }

}
