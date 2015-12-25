// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;

// Referenced classes of package org.spongycastle.crypto.generators:
//            DHKeyGeneratorHelper

public class DHBasicKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{

    public DHKeyGenerationParameters atT;

    public DHBasicKeyPairGenerator()
    {
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        Object obj = DHKeyGeneratorHelper.atU;
        obj = atT.axb;
        java.math.BigInteger biginteger = DHKeyGeneratorHelper._mth02CA(((org.spongycastle.crypto.params.DHParameters) (obj)), ((KeyGenerationParameters) (atT)).amC);
        return new AsymmetricCipherKeyPair(new DHPublicKeyParameters(DHKeyGeneratorHelper._mth02CA(((org.spongycastle.crypto.params.DHParameters) (obj)), biginteger), ((org.spongycastle.crypto.params.DHParameters) (obj))), new DHPrivateKeyParameters(biginteger, ((org.spongycastle.crypto.params.DHParameters) (obj))));
    }
}
