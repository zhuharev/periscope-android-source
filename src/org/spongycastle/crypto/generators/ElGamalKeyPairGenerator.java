// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;

// Referenced classes of package org.spongycastle.crypto.generators:
//            DHKeyGeneratorHelper

public class ElGamalKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{

    public ElGamalKeyGenerationParameters auc;

    public ElGamalKeyPairGenerator()
    {
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        Object obj = DHKeyGeneratorHelper.atU;
        obj = auc.axl;
        DHParameters dhparameters = new DHParameters(((ElGamalParameters) (obj)).amM, ((ElGamalParameters) (obj)).amO, null, ((ElGamalParameters) (obj)).afM);
        java.math.BigInteger biginteger = DHKeyGeneratorHelper._mth02CA(dhparameters, ((KeyGenerationParameters) (auc)).amC);
        return new AsymmetricCipherKeyPair(new ElGamalPublicKeyParameters(DHKeyGeneratorHelper._mth02CA(dhparameters, biginteger), ((ElGamalParameters) (obj))), new ElGamalPrivateKeyParameters(biginteger, ((ElGamalParameters) (obj))));
    }
}
