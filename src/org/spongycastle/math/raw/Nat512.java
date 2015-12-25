// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.raw;


// Referenced classes of package org.spongycastle.math.raw:
//            Nat256, Nat

public abstract class Nat512
{

    public Nat512()
    {
    }

    public static void _mth02BD(int ai[], int ai1[])
    {
        Nat256._mth02BD(ai, ai1);
        Nat256._mth02CB(ai, 8, ai1, 16);
        int i = Nat256._mth02CA(ai1, 8, ai1, 16);
        int j = Nat256._mth02CA(ai1, 24, ai1, 16, i + Nat256._mth02CA(ai1, 0, ai1, 8, 0));
        int ai2[] = Nat256._mth05E4();
        Nat256._mth02CA(ai, 8, ai, 0, ai2, 0);
        ai = Nat256._mth05E7();
        Nat256._mth02BD(ai2, ai);
        Nat._mth02CA(32, i + j + Nat._mth02BB(16, ai, 0, ai1, 8), ai1, 24);
    }

    public static void _mth1FBE(int ai[], int ai1[], int ai2[])
    {
        Nat256._mth1FBE(ai, ai1, ai2);
        Nat256._mth02CB(ai, 8, ai1, 8, ai2, 16);
        int j = Nat256._mth02CA(ai2, 8, ai2, 16);
        int k = Nat256._mth02CA(ai2, 24, ai2, 16, j + Nat256._mth02CA(ai2, 0, ai2, 8, 0));
        int ai3[] = Nat256._mth05E4();
        int ai4[] = Nat256._mth05E4();
        boolean flag;
        if (Nat256._mth02CA(ai, 8, ai, 0, ai3, 0) != Nat256._mth02CA(ai1, 8, ai1, 0, ai4, 0))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ai = Nat256._mth05E7();
        Nat256._mth1FBE(ai3, ai4, ai);
        int i;
        if (flag)
        {
            i = Nat._mth141D(16, ai, 0, ai2, 8);
        } else
        {
            i = Nat._mth02BB(16, ai, 0, ai2, 8);
        }
        Nat._mth02CA(32, j + k + i, ai2, 24);
    }
}
