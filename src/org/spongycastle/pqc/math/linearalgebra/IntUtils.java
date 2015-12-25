// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


public final class IntUtils
{

    private IntUtils()
    {
    }

    public static boolean equals(int ai[], int ai1[])
    {
        if (ai.length != ai1.length)
        {
            return false;
        }
        boolean flag1 = true;
        for (int i = ai.length - 1; i >= 0; i--)
        {
            boolean flag;
            if (ai[i] == ai1[i])
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 &= flag;
        }

        return flag1;
    }

    public static int[] _mth02D1(int ai[])
    {
        int ai1[] = new int[ai.length];
        System.arraycopy(ai, 0, ai1, 0, ai.length);
        return ai1;
    }
}
