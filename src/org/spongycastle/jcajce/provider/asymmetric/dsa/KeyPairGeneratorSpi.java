// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.DSAKeyPairGenerator;
import org.spongycastle.crypto.generators.DSAParametersGenerator;
import org.spongycastle.crypto.params.DSAKeyGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.dsa:
//            BCDSAPublicKey, BCDSAPrivateKey

public class KeyPairGeneratorSpi extends KeyPairGenerator
{

    private DSAKeyPairGenerator aDb;
    private SecureRandom amC;
    private int amD;
    private boolean aqH;
    private int atV;
    private DSAKeyGenerationParameters atW;

    public KeyPairGeneratorSpi()
    {
        super("DSA");
        aDb = new DSAKeyPairGenerator();
        amD = 1024;
        atV = 20;
        amC = new SecureRandom();
        aqH = false;
    }

    public KeyPair generateKeyPair()
    {
        if (!aqH)
        {
            DSAParametersGenerator dsaparametersgenerator = new DSAParametersGenerator();
            dsaparametersgenerator._mth02CB(amD, atV, amC);
            atW = new DSAKeyGenerationParameters(amC, dsaparametersgenerator.FEA3());
            aDb.atW = (DSAKeyGenerationParameters)atW;
            aqH = true;
        }
        Object obj = aDb._mth1491();
        DSAPublicKeyParameters dsapublickeyparameters = (DSAPublicKeyParameters)((AsymmetricCipherKeyPair) (obj)).amu;
        obj = (DSAPrivateKeyParameters)((AsymmetricCipherKeyPair) (obj)).amv;
        return new KeyPair(new BCDSAPublicKey(dsapublickeyparameters), new BCDSAPrivateKey(((DSAPrivateKeyParameters) (obj))));
    }

    public void initialize(int i, SecureRandom securerandom)
    {
        if (i < 512 || i > 4096 || i < 1024 && i % 64 != 0 || i >= 1024 && i % 1024 != 0)
        {
            throw new InvalidParameterException("strength must be from 512 - 4096 and a multiple of 1024 above 1024");
        } else
        {
            amD = i;
            amC = securerandom;
            return;
        }
    }

    public void initialize(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (!(algorithmparameterspec instanceof DSAParameterSpec))
        {
            throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
        } else
        {
            algorithmparameterspec = (DSAParameterSpec)algorithmparameterspec;
            atW = new DSAKeyGenerationParameters(securerandom, new DSAParameters(algorithmparameterspec.getP(), algorithmparameterspec.getQ(), algorithmparameterspec.getG()));
            aDb.atW = (DSAKeyGenerationParameters)atW;
            aqH = true;
            return;
        }
    }
}
