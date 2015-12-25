// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.ElGamalKeyPairGenerator;
import org.spongycastle.crypto.generators.ElGamalParametersGenerator;
import org.spongycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.elgamal:
//            BCElGamalPublicKey, BCElGamalPrivateKey

public class KeyPairGeneratorSpi extends KeyPairGenerator
{

    private ElGamalKeyPairGenerator aDD;
    private SecureRandom amC;
    private int amD;
    private boolean aqH;
    private int atV;
    private ElGamalKeyGenerationParameters auc;

    public KeyPairGeneratorSpi()
    {
        super("ElGamal");
        aDD = new ElGamalKeyPairGenerator();
        amD = 1024;
        atV = 20;
        amC = new SecureRandom();
        aqH = false;
    }

    public KeyPair generateKeyPair()
    {
        if (!aqH)
        {
            DHParameterSpec dhparameterspec = BouncyCastleProvider.aGZ._mth06C1(amD);
            if (dhparameterspec != null)
            {
                auc = new ElGamalKeyGenerationParameters(amC, new ElGamalParameters(dhparameterspec.getP(), dhparameterspec.getG(), dhparameterspec.getL()));
            } else
            {
                ElGamalParametersGenerator elgamalparametersgenerator = new ElGamalParametersGenerator();
                int i = amD;
                int j = atV;
                SecureRandom securerandom = amC;
                elgamalparametersgenerator.size = i;
                elgamalparametersgenerator.atV = j;
                elgamalparametersgenerator.amC = securerandom;
                auc = new ElGamalKeyGenerationParameters(amC, elgamalparametersgenerator.FF55());
            }
            aDD.auc = (ElGamalKeyGenerationParameters)auc;
            aqH = true;
        }
        Object obj = aDD._mth1491();
        ElGamalPublicKeyParameters elgamalpublickeyparameters = (ElGamalPublicKeyParameters)((AsymmetricCipherKeyPair) (obj)).amu;
        obj = (ElGamalPrivateKeyParameters)((AsymmetricCipherKeyPair) (obj)).amv;
        return new KeyPair(new BCElGamalPublicKey(elgamalpublickeyparameters), new BCElGamalPrivateKey(((ElGamalPrivateKeyParameters) (obj))));
    }

    public void initialize(int i, SecureRandom securerandom)
    {
        amD = i;
        amC = securerandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (!(algorithmparameterspec instanceof ElGamalParameterSpec) && !(algorithmparameterspec instanceof DHParameterSpec))
        {
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec or an ElGamalParameterSpec");
        }
        if (algorithmparameterspec instanceof ElGamalParameterSpec)
        {
            algorithmparameterspec = (ElGamalParameterSpec)algorithmparameterspec;
            auc = new ElGamalKeyGenerationParameters(securerandom, new ElGamalParameters(((ElGamalParameterSpec) (algorithmparameterspec)).amM, ((ElGamalParameterSpec) (algorithmparameterspec)).amO));
        } else
        {
            algorithmparameterspec = (DHParameterSpec)algorithmparameterspec;
            auc = new ElGamalKeyGenerationParameters(securerandom, new ElGamalParameters(algorithmparameterspec.getP(), algorithmparameterspec.getG(), algorithmparameterspec.getL()));
        }
        aDD.auc = (ElGamalKeyGenerationParameters)auc;
        aqH = true;
    }
}
