// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;

class DHParametersHelper
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private static final BigInteger ars = BigInteger.valueOf(2L);

    DHParametersHelper()
    {
    }

    static BigInteger[] _mth02CA(int i, int j, SecureRandom securerandom)
    {
        BigInteger biginteger;
        BigInteger biginteger1;
        do
        {
            biginteger = new BigInteger(i - 1, 2, securerandom);
            biginteger1 = biginteger.shiftLeft(1).add(ONE);
        } while (!biginteger1.isProbablePrime(j) || j > 2 && !biginteger.isProbablePrime(j - 2) || WNafUtil._mth1FBE(biginteger1) < i >>> 2);
        return (new BigInteger[] {
            biginteger1, biginteger
        });
    }

    static BigInteger _mth02CB(BigInteger biginteger, SecureRandom securerandom)
    {
        BigInteger biginteger1 = biginteger.subtract(ars);
        BigInteger biginteger2;
        do
        {
            biginteger2 = BigIntegers._mth02CB(ars, biginteger1, securerandom).modPow(ars, biginteger);
        } while (biginteger2.equals(ONE));
        return biginteger2;
    }

}
