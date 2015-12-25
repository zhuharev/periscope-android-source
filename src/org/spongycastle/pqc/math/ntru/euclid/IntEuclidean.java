// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.euclid;


public class IntEuclidean
{

    private int aOR;
    public int x;
    private int y;

    private IntEuclidean()
    {
    }

    public static IntEuclidean _mth0131(int i, int j)
    {
        boolean flag = false;
        int j1 = 1;
        int k = 1;
        int i1 = 0;
        int l = i;
        i = ((flag) ? 1 : 0);
        do
        {
            int k1 = l;
            if (j != 0)
            {
                int l1 = k1 / j;
                l = j;
                j = k1 % j;
                k1 = j1 - l1 * i;
                j1 = i;
                l1 = i1 - l1 * k;
                i1 = k;
                i = k1;
                k = l1;
            } else
            {
                IntEuclidean inteuclidean = new IntEuclidean();
                inteuclidean.x = j1;
                inteuclidean.y = i1;
                inteuclidean.aOR = k1;
                return inteuclidean;
            }
        } while (true);
    }
}
