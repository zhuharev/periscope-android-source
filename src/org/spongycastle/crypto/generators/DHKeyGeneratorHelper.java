// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;

class DHKeyGeneratorHelper
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private static final BigInteger ars = BigInteger.valueOf(2L);
    static final DHKeyGeneratorHelper atU = new DHKeyGeneratorHelper();

    private DHKeyGeneratorHelper()
    {
    }

    static BigInteger _mth02CA(DHParameters dhparameters, BigInteger biginteger)
    {
        return dhparameters.amO.modPow(biginteger, dhparameters.amM);
    }

    static BigInteger _mth02CA(DHParameters dhparameters, SecureRandom securerandom)
    {
        int i = dhparameters.afM;
        if (i != 0)
        {
            do
            {
                dhparameters = (new BigInteger(i, securerandom)).setBit(i - 1);
            } while (WNafUtil._mth1FBE(dhparameters) < i >>> 2);
            return dhparameters;
        }
        BigInteger biginteger = ars;
        i = dhparameters.afJ;
        if (i != 0)
        {
            biginteger = ONE.shiftLeft(i - 1);
        }
        BigInteger biginteger2 = dhparameters.amN;
        BigInteger biginteger1 = biginteger2;
        if (biginteger2 == null)
        {
            biginteger1 = dhparameters.amM;
        }
        dhparameters = biginteger1.subtract(ars);
        i = dhparameters.bitLength();
        do
        {
            biginteger1 = BigIntegers._mth02CB(biginteger, dhparameters, securerandom);
        } while (WNafUtil._mth1FBE(biginteger1) < i >>> 2);
        return biginteger1;
    }

}
