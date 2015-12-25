// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.RSAKeyGenerationParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.math.ec.WNafUtil;

public class RSAKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    public RSAKeyGenerationParameters auw;

    public RSAKeyPairGenerator()
    {
    }

    private BigInteger _mth02CA(int i, BigInteger biginteger)
    {
        BigInteger biginteger1;
        do
        {
            biginteger1 = new BigInteger(i, 1, ((KeyGenerationParameters) (auw)).amC);
        } while (biginteger1.mod(biginteger).equals(ONE) || !biginteger1.isProbablePrime(auw.atV) || !biginteger.gcd(biginteger1.subtract(ONE)).equals(ONE));
        return biginteger1;
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        int i = ((KeyGenerationParameters) (auw)).amD;
        int j = i >>> 1;
        int k = i - j;
        int l = i / 3;
        BigInteger biginteger4 = auw.adj;
        BigInteger biginteger = _mth02CA(k, biginteger4);
        BigInteger biginteger3;
        BigInteger biginteger5;
        do
        {
            do
            {
                biginteger3 = _mth02CA(j, biginteger4);
            } while (biginteger3.subtract(biginteger).abs().bitLength() < l);
            biginteger5 = biginteger.multiply(biginteger3);
            if (biginteger5.bitLength() != i)
            {
                biginteger = biginteger.max(biginteger3);
                continue;
            }
            if (WNafUtil._mth1FBE(biginteger5) >= i >>> 2)
            {
                break;
            }
            biginteger = _mth02CA(k, biginteger4);
        } while (true);
        BigInteger biginteger2 = biginteger;
        BigInteger biginteger1 = biginteger3;
        if (biginteger.compareTo(biginteger3) < 0)
        {
            biginteger2 = biginteger3;
            biginteger1 = biginteger;
        }
        biginteger3 = biginteger2.subtract(ONE);
        BigInteger biginteger6 = biginteger1.subtract(ONE);
        biginteger = biginteger4.modInverse(biginteger3.multiply(biginteger6));
        biginteger3 = biginteger.remainder(biginteger3);
        biginteger6 = biginteger.remainder(biginteger6);
        BigInteger biginteger7 = biginteger1.modInverse(biginteger2);
        return new AsymmetricCipherKeyPair(new RSAKeyParameters(false, biginteger5, biginteger4), new RSAPrivateCrtKeyParameters(biginteger5, biginteger4, biginteger, biginteger2, biginteger1, biginteger3, biginteger6, biginteger7));
    }

}
