// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
import org.spongycastle.pqc.math.linearalgebra.BigIntUtils;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.IntegerFunctions;

final class Conversions
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private static final BigInteger ZERO = BigInteger.valueOf(0L);

    private Conversions()
    {
    }

    public static byte[] _mth02CA(int i, int j, GF2Vector gf2vector)
    {
label0:
        {
            if (gf2vector.getLength() == i)
            {
                int l1 = 0;
                for (int k = 0; k < gf2vector.aOy.length; k++)
                {
                    int j2 = gf2vector.aOy[k];
                    for (int i1 = 0; i1 < 32;)
                    {
                        int k2 = l1;
                        if ((j2 & 1) != 0)
                        {
                            k2 = l1 + 1;
                        }
                        j2 >>>= 1;
                        i1++;
                        l1 = k2;
                    }

                }

                if (l1 == j)
                {
                    break label0;
                }
            }
            throw new IllegalArgumentException("vector has wrong length or hamming weight");
        }
        int ai[] = gf2vector.aOy;
        gf2vector = IntegerFunctions._mth1D57(i, j);
        BigInteger biginteger = ZERO;
        int j1 = i;
        int i2 = 0;
        int l = j;
        j = i2;
        i2 = j1;
        while (j < i) 
        {
            BigInteger biginteger2 = gf2vector.multiply(BigInteger.valueOf(i2 - l)).divide(BigInteger.valueOf(i2));
            i2--;
            gf2vector = biginteger2;
            BigInteger biginteger1 = biginteger;
            int k1 = l;
            if ((ai[j >> 5] & 1 << (j & 0x1f)) != 0)
            {
                biginteger1 = biginteger.add(biginteger2);
                k1 = l - 1;
                if (i2 == k1)
                {
                    gf2vector = ONE;
                } else
                {
                    gf2vector = biginteger2.multiply(BigInteger.valueOf(k1 + 1)).divide(BigInteger.valueOf(i2 - k1));
                }
            }
            j++;
            biginteger = biginteger1;
            l = k1;
        }
        return BigIntUtils._mth02C9(biginteger);
    }

    public static GF2Vector _mth02CB(int i, int j, byte abyte0[])
    {
        if (i < j)
        {
            throw new IllegalArgumentException("n < t");
        }
        BigInteger biginteger = IntegerFunctions._mth1D57(i, j);
        abyte0 = new BigInteger(1, abyte0);
        Object obj = abyte0;
        if (abyte0.compareTo(biginteger) >= 0)
        {
            throw new IllegalArgumentException("Encoded number too large.");
        }
        GF2Vector gf2vector = new GF2Vector(i);
        int l = i;
        int j1 = 0;
        int k = j;
        j = j1;
        j1 = l;
        abyte0 = biginteger;
        while (j < i) 
        {
            BigInteger biginteger1 = abyte0.multiply(BigInteger.valueOf(j1 - k)).divide(BigInteger.valueOf(j1));
            j1--;
            abyte0 = biginteger1;
            int i1 = k;
            Object obj1 = obj;
            if (biginteger1.compareTo(((BigInteger) (obj))) <= 0)
            {
                gf2vector.FE9B(j);
                obj1 = ((BigInteger) (obj)).subtract(biginteger1);
                i1 = k - 1;
                if (j1 == i1)
                {
                    abyte0 = ONE;
                } else
                {
                    abyte0 = biginteger1.multiply(BigInteger.valueOf(i1 + 1)).divide(BigInteger.valueOf(j1 - i1));
                }
            }
            j++;
            k = i1;
            obj = obj1;
        }
        return gf2vector;
    }

}
