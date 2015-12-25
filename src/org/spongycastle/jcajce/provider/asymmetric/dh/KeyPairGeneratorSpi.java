// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.spongycastle.crypto.generators.DHParametersGenerator;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.dh:
//            BCDHPublicKey, BCDHPrivateKey

public class KeyPairGeneratorSpi extends KeyPairGenerator
{

    private static Hashtable Ma = new Hashtable();
    private static Object lock = new Object();
    private DHBasicKeyPairGenerator aCV;
    private SecureRandom amC;
    private int amD;
    private boolean aqH;
    private DHKeyGenerationParameters atT;
    private int atV;

    public KeyPairGeneratorSpi()
    {
        super("DH");
        aCV = new DHBasicKeyPairGenerator();
        amD = 1024;
        atV = 20;
        amC = new SecureRandom();
        aqH = false;
    }

    public KeyPair generateKeyPair()
    {
        Integer integer;
        if (aqH)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        integer = Integers.valueOf(amD);
        if (Ma.containsKey(integer))
        {
            atT = (DHKeyGenerationParameters)Ma.get(integer);
            break MISSING_BLOCK_LABEL_215;
        }
        DHParameterSpec dhparameterspec = BouncyCastleProvider.aGZ._mth06C1(amD);
        if (dhparameterspec != null)
        {
            atT = new DHKeyGenerationParameters(amC, new DHParameters(dhparameterspec.getP(), dhparameterspec.getG(), null, dhparameterspec.getL()));
            break MISSING_BLOCK_LABEL_215;
        }
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (Ma.containsKey(integer))
        {
            atT = (DHKeyGenerationParameters)Ma.get(integer);
            break MISSING_BLOCK_LABEL_205;
        }
        DHParametersGenerator dhparametersgenerator = new DHParametersGenerator();
        int i = amD;
        int j = atV;
        SecureRandom securerandom = amC;
        dhparametersgenerator.size = i;
        dhparametersgenerator.atV = j;
        dhparametersgenerator.amC = securerandom;
        atT = new DHKeyGenerationParameters(amC, dhparametersgenerator.FE94());
        Ma.put(integer, atT);
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_215;
        Exception exception;
        exception;
        throw exception;
        aCV.atT = (DHKeyGenerationParameters)atT;
        aqH = true;
        Object obj1 = aCV._mth1491();
        DHPublicKeyParameters dhpublickeyparameters = (DHPublicKeyParameters)((AsymmetricCipherKeyPair) (obj1)).amu;
        obj1 = (DHPrivateKeyParameters)((AsymmetricCipherKeyPair) (obj1)).amv;
        return new KeyPair(new BCDHPublicKey(dhpublickeyparameters), new BCDHPrivateKey(((DHPrivateKeyParameters) (obj1))));
    }

    public void initialize(int i, SecureRandom securerandom)
    {
        amD = i;
        amC = securerandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (!(algorithmparameterspec instanceof DHParameterSpec))
        {
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
        } else
        {
            algorithmparameterspec = (DHParameterSpec)algorithmparameterspec;
            atT = new DHKeyGenerationParameters(securerandom, new DHParameters(algorithmparameterspec.getP(), algorithmparameterspec.getG(), null, algorithmparameterspec.getL()));
            aCV.atT = (DHKeyGenerationParameters)atT;
            aqH = true;
            return;
        }
    }

}
