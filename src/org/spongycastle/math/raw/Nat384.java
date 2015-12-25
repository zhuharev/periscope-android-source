// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.raw;


// Referenced classes of package org.spongycastle.math.raw:
//            Nat192, Nat

public abstract class Nat384
{

    public Nat384()
    {
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        Nat192._mth02BD(ai, ai1);
        Nat192._mth02CB(ai, 6, ai1, 12);
        int i = Nat192._mth02CA(ai1, 6, ai1, 12);
        int j = Nat192._mth02CA(ai1, 18, ai1, 12, i + Nat192._mth02CA(ai1, 0, ai1, 6, 0));
        int ai2[] = Nat192._mth05E4();
        Nat192._mth02CA(ai, 6, ai, 0, ai2, 0);
        ai = Nat192._mth05E7();
        Nat192._mth02BD(ai2, ai);
        Nat._mth02CA(24, i + j + Nat._mth02BB(12, ai, 0, ai1, 6), ai1, 18);
    }

    public static void _mth1FBE(int ai[], int ai1[], int ai2[])
    {
        Nat192._mth1FBE(ai, ai1, ai2);
        Nat192._mth02CB(ai, 6, ai1, 6, ai2, 12);
        int j = Nat192._mth02CA(ai2, 6, ai2, 12);
        int k = Nat192._mth02CA(ai2, 18, ai2, 12, j + Nat192._mth02CA(ai2, 0, ai2, 6, 0));
        int ai3[] = Nat192._mth05E4();
        int ai4[] = Nat192._mth05E4();
        boolean flag;
        if (Nat192._mth02CA(ai, 6, ai, 0, ai3, 0) != Nat192._mth02CA(ai1, 6, ai1, 0, ai4, 0))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ai = Nat192._mth05E7();
        Nat192._mth1FBE(ai3, ai4, ai);
        int i;
        if (flag)
        {
            i = Nat._mth141D(12, ai, 0, ai2, 6);
        } else
        {
            i = Nat._mth02BB(12, ai, 0, ai2, 6);
        }
        Nat._mth02CA(24, j + k + i, ai2, 18);
    }
}
