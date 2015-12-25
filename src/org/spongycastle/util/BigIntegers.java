// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class BigIntegers
{

    private static final BigInteger ZERO = BigInteger.valueOf(0L);

    public BigIntegers()
    {
    }

    public static byte[] _mth02BB(int i, BigInteger biginteger)
    {
        biginteger = biginteger.toByteArray();
        if (biginteger.length == i)
        {
            return biginteger;
        }
        int j;
        if (biginteger[0] == 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        int k = biginteger.length - j;
        if (k > i)
        {
            throw new IllegalArgumentException("standard length exceeded for value");
        } else
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(biginteger, j, abyte0, abyte0.length - k, k);
            return abyte0;
        }
    }

    public static BigInteger _mth02CB(BigInteger biginteger, BigInteger biginteger1, SecureRandom securerandom)
    {
        int i = biginteger.compareTo(biginteger1);
        if (i >= 0)
        {
            if (i > 0)
            {
                throw new IllegalArgumentException("'min' may not be greater than 'max'");
            } else
            {
                return biginteger;
            }
        }
        if (biginteger.bitLength() > biginteger1.bitLength() / 2)
        {
            return _mth02CB(ZERO, biginteger1.subtract(biginteger), securerandom).add(biginteger);
        }
        for (int j = 0; j < 1000; j++)
        {
            BigInteger biginteger2 = new BigInteger(biginteger1.bitLength(), securerandom);
            if (biginteger2.compareTo(biginteger) >= 0 && biginteger2.compareTo(biginteger1) <= 0)
            {
                return biginteger2;
            }
        }

        return (new BigInteger(biginteger1.subtract(biginteger).bitLength() - 1, securerandom)).add(biginteger);
    }

    public static byte[] _mth02D1(BigInteger biginteger)
    {
        biginteger = biginteger.toByteArray();
        if (biginteger[0] == 0)
        {
            byte abyte0[] = new byte[biginteger.length - 1];
            System.arraycopy(biginteger, 1, abyte0, 0, abyte0.length);
            return abyte0;
        } else
        {
            return biginteger;
        }
    }

    public static BigInteger FE7A(byte abyte0[], int i, int j)
    {
        byte abyte1[] = abyte0;
        if (i != 0 || j != abyte0.length)
        {
            abyte1 = new byte[j];
            System.arraycopy(abyte0, i, abyte1, 0, j);
        }
        return new BigInteger(1, abyte1);
    }

}
