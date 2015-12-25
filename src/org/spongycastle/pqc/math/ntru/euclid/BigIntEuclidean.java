// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.euclid;

import java.math.BigInteger;

public class BigIntEuclidean
{

    public BigInteger aOQ;
    public BigInteger amZ;
    public BigInteger axe;

    private BigIntEuclidean()
    {
    }

    public static BigIntEuclidean _mth141D(BigInteger biginteger, BigInteger biginteger1)
    {
        BigInteger biginteger5 = BigInteger.ZERO;
        BigInteger biginteger4 = BigInteger.ONE;
        BigInteger biginteger2 = BigInteger.ONE;
        BigInteger biginteger3 = BigInteger.ZERO;
        Object obj = biginteger;
        biginteger = biginteger5;
        Object obj1;
        for (; !biginteger1.equals(BigInteger.ZERO); biginteger1 = obj1)
        {
            obj = ((BigInteger) (obj)).divideAndRemainder(biginteger1);
            BigInteger biginteger6 = obj[0];
            obj1 = obj[1];
            obj = biginteger4.subtract(biginteger6.multiply(biginteger));
            biginteger4 = biginteger;
            biginteger6 = biginteger3.subtract(biginteger6.multiply(biginteger2));
            biginteger3 = biginteger2;
            biginteger = ((BigInteger) (obj));
            biginteger2 = biginteger6;
            obj = biginteger1;
        }

        biginteger = new BigIntEuclidean();
        biginteger.amZ = biginteger4;
        biginteger.axe = biginteger3;
        biginteger.aOQ = ((BigInteger) (obj));
        return biginteger;
    }
}
