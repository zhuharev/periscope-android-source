// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.RSAKeyPairGenerator;
import org.spongycastle.crypto.params.RSAKeyGenerationParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.rsa:
//            BCRSAPublicKey, BCRSAPrivateCrtKey

public class KeyPairGeneratorSpi extends KeyPairGenerator
{

    private static BigInteger aEb = BigInteger.valueOf(0x10001L);
    private RSAKeyPairGenerator aEc;
    private RSAKeyGenerationParameters auw;

    public KeyPairGeneratorSpi()
    {
        super("RSA");
        aEc = new RSAKeyPairGenerator();
        auw = new RSAKeyGenerationParameters(aEb, new SecureRandom(), 2048, 12);
        aEc.auw = (RSAKeyGenerationParameters)auw;
    }

    public KeyPair generateKeyPair()
    {
        Object obj = aEc._mth1491();
        RSAKeyParameters rsakeyparameters = (RSAKeyParameters)((AsymmetricCipherKeyPair) (obj)).amu;
        obj = (RSAPrivateCrtKeyParameters)((AsymmetricCipherKeyPair) (obj)).amv;
        return new KeyPair(new BCRSAPublicKey(rsakeyparameters), new BCRSAPrivateCrtKey(((RSAPrivateCrtKeyParameters) (obj))));
    }

    public void initialize(int i, SecureRandom securerandom)
    {
        auw = new RSAKeyGenerationParameters(aEb, securerandom, i, 12);
        aEc.auw = (RSAKeyGenerationParameters)auw;
    }

    public void initialize(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (!(algorithmparameterspec instanceof RSAKeyGenParameterSpec))
        {
            throw new InvalidAlgorithmParameterException("parameter object not a RSAKeyGenParameterSpec");
        } else
        {
            algorithmparameterspec = (RSAKeyGenParameterSpec)algorithmparameterspec;
            auw = new RSAKeyGenerationParameters(algorithmparameterspec.getPublicExponent(), securerandom, algorithmparameterspec.getKeysize(), 12);
            aEc.auw = (RSAKeyGenerationParameters)auw;
            return;
        }
    }

}
