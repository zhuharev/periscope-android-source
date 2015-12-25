// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;

public class SecP192R1Field
{

    private static int aJj[] = {
        1, 0, 2, 0, 1, 0, -2, -1, -3, -1, 
        -1, -1
    };
    private static final int aJn[] = {
        -1, -1, -3, -1, -2, -1, 1, 0, 2
    };
    static final int aqr[] = {
        -1, -1, -2, -1, -1, -1
    };

    public SecP192R1Field()
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
                l1 = l >> 32;
            }
            l = l1 + (((long)ai[2] & 0xffffffffL) + l3);
            ai[2] = (int)l;
            l >>= 32;
        }
        if (l != 0L && Nat._mth02CE(6, ai, 3) != 0 || ai[5] == -1 && Nat192._mth02BE(ai, aqr))
        {
            _mth02BD(ai);
        }
    }

    public static void _mth02BB(int ai[], int ai1[])
    {
        if (Nat192._mth02C8(ai))
        {
            Nat192._mth02CC(ai1);
            return;
        } else
        {
            Nat192._mth02BF(aqr, ai, ai1);
            return;
        }
    }

    public static void _mth02BC(int ai[], int ai1[])
    {
        long l1 = (long)ai[6] & 0xffffffffL;
        long l = (long)ai[7] & 0xffffffffL;
        long l3 = ai[8];
        long l2 = ai[9];
        long l4 = ai[10];
        long l5 = ai[11];
        l4 = l1 + (l4 & 0xffffffffL);
        l5 = l + (l5 & 0xffffffffL);
        long l6 = ((long)ai[0] & 0xffffffffL) + l4 + 0L;
        int i = (int)l6;
        l6 = (l6 >> 32) + (((long)ai[1] & 0xffffffffL) + l5);
        ai1[1] = (int)l6;
        l3 = l4 + (l3 & 0xffffffffL);
        l4 = l5 + (l2 & 0xffffffffL);
        l2 = ((long)ai[2] & 0xffffffffL) + l3 + (l6 >> 32);
        l5 = (l2 >> 32) + (((long)ai[3] & 0xffffffffL) + l4);
        ai1[3] = (int)l5;
        l1 = (l5 >> 32) + (((long)ai[4] & 0xffffffffL) + (l3 - l1));
        ai1[4] = (int)l1;
        l = (l1 >> 32) + (((long)ai[5] & 0xffffffffL) + (l4 - l));
        ai1[5] = (int)l;
        l >>= 32;
        l1 = (l2 & 0xffffffffL) + l;
        l += (long)i & 0xffffffffL;
        ai1[0] = (int)l;
        l2 = l >> 32;
        l = l1;
        if (l2 != 0L)
        {
            l = l2 + ((long)ai1[1] & 0xffffffffL);
            ai1[1] = (int)l;
            l = l1 + (l >> 32);
        }
        ai1[2] = (int)l;
        if (l >> 32 != 0L && Nat._mth02CE(6, ai1, 3) != 0 || ai1[5] == -1 && Nat192._mth02BE(ai1, aqr))
        {
            _mth02BD(ai1);
        }
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
            l1 = l >> 32;
        }
        l = l1 + (((long)ai[2] & 0xffffffffL) + 1L);
        ai[2] = (int)l;
        if (l >> 32 != 0L)
        {
            Nat._mth02CE(6, ai, 3);
        }
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        int ai2[] = Nat192._mth05E7();
        Nat192._mth02BD(ai, ai2);
        _mth02BC(ai2, ai1);
    }

    public static int[] _mth02BE(BigInteger biginteger)
    {
        biginteger = Nat192._mth02BE(biginteger);
        if (biginteger[5] == -1 && Nat192._mth02BE(biginteger, aqr))
        {
            Nat192._mth02BF(aqr, biginteger);
        }
        return biginteger;
    }

    public static void _mth02CA(int ai[], int i, int ai1[])
    {
        int ai2[] = Nat192._mth05E7();
        Nat192._mth02BD(ai, ai2);
        _mth02BC(ai2, ai1);
        do
        {
            i--;
            if (i > 0)
            {
                Nat192._mth02BD(ai1, ai2);
                _mth02BC(ai2, ai1);
            } else
            {
                return;
            }
        } while (true);
    }

    public static void _mth02CB(int ai[], int ai1[], int ai2[])
    {
        if (Nat192._mth02BD(ai, ai1, ai2) != 0 || ai2[5] == -1 && Nat192._mth02BE(ai2, aqr))
        {
            _mth02BD(ai2);
        }
    }

    public static void _mth02CE(int ai[], int ai1[], int ai2[])
    {
        int ai3[] = Nat192._mth05E7();
        Nat192._mth1FBE(ai, ai1, ai3);
        _mth02BC(ai3, ai2);
    }

    public static void _mth02CF(int ai[], int ai1[], int ai2[])
    {
        if ((Nat192._mth02BE(ai, ai1, ai2) != 0 || ai2[11] == -1 && Nat._mth02CF(12, ai2, aJj)) && Nat._mth02CB(9, aJn, ai2) != 0)
        {
            Nat._mth02CE(12, ai2, 9);
        }
    }

    public static void _mth037A(int ai[], int ai1[])
    {
        if (Nat._mth02CA(6, ai, 0, ai1) != 0 || ai1[5] == -1 && Nat192._mth02BE(ai1, aqr))
        {
            _mth02BD(ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[])
    {
        if (Nat._mth141D(6, ai, ai1) != 0 || ai1[5] == -1 && Nat192._mth02BE(ai1, aqr))
        {
            _mth02BD(ai1);
        }
    }

    public static void _mth141D(int ai[], int ai1[], int ai2[])
    {
        if (Nat192._mth02BF(ai, ai1, ai2) != 0)
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
                l1 = l >> 32;
            }
            l = l1 + (((long)ai2[2] & 0xffffffffL) - 1L);
            ai2[2] = (int)l;
            if (l >> 32 != 0L)
            {
                Nat._mth02CB(6, ai2, 3);
            }
        }
    }

}
