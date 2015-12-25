// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

public final class IntegerFunctions
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private static final BigInteger ZERO = BigInteger.valueOf(0L);

    private IntegerFunctions()
    {
    }

    public static int _mth026A(int i)
    {
        if (i == 0)
        {
            return 1;
        }
        int j = i;
        if (i < 0)
        {
            j = -i;
        }
        i = 0;
        for (; j > 0; j >>>= 8)
        {
            i++;
        }

        return i;
    }

    public static BigInteger _mth1D57(int i, int j)
    {
        BigInteger biginteger = ONE;
        if (i == 0)
        {
            if (j == 0)
            {
                return biginteger;
            } else
            {
                return ZERO;
            }
        }
        int k = j;
        if (j > i >>> 1)
        {
            k = i - j;
        }
        for (j = 1; j <= k; j++)
        {
            biginteger = biginteger.multiply(BigInteger.valueOf(i - (j - 1))).divide(BigInteger.valueOf(j));
        }

        return biginteger;
    }

    static 
    {
        BigInteger.valueOf(2L);
        BigInteger.valueOf(4L);
    }
}
