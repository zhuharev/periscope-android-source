// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.rainbow.RainbowKeyGenerationParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowKeyPairGenerator;
import org.spongycastle.pqc.crypto.rainbow.RainbowParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.RainbowParameterSpec;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.rainbow:
//            BCRainbowPublicKey, BCRainbowPrivateKey

public class RainbowKeyPairGeneratorSpi extends KeyPairGenerator
{

    private RainbowKeyGenerationParameters aOm;
    private RainbowKeyPairGenerator aOn;
    private SecureRandom amC;
    private int amD;
    private boolean aqH;

    public RainbowKeyPairGeneratorSpi()
    {
        super("Rainbow");
        aOn = new RainbowKeyPairGenerator();
        amD = 1024;
        amC = new SecureRandom();
        aqH = false;
    }

    public KeyPair generateKeyPair()
    {
        if (!aqH)
        {
            aOm = new RainbowKeyGenerationParameters(amC, new RainbowParameters(Arrays._mth02D1((new RainbowParameterSpec()).aNI)));
            aOn._mth02CB(aOm);
            aqH = true;
        }
        Object obj = aOn._mth1491();
        RainbowPublicKeyParameters rainbowpublickeyparameters = (RainbowPublicKeyParameters)((AsymmetricCipherKeyPair) (obj)).amu;
        obj = (RainbowPrivateKeyParameters)((AsymmetricCipherKeyPair) (obj)).amv;
        return new KeyPair(new BCRainbowPublicKey(rainbowpublickeyparameters), new BCRainbowPrivateKey(((RainbowPrivateKeyParameters) (obj))));
    }

    public void initialize(int i, SecureRandom securerandom)
    {
        amD = i;
        amC = securerandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (!(algorithmparameterspec instanceof RainbowParameterSpec))
        {
            throw new InvalidAlgorithmParameterException("parameter object not a RainbowParameterSpec");
        } else
        {
            aOm = new RainbowKeyGenerationParameters(securerandom, new RainbowParameters(Arrays._mth02D1(((RainbowParameterSpec)algorithmparameterspec).aNI)));
            aOn._mth02CB(aOm);
            aqH = true;
            return;
        }
    }
}
