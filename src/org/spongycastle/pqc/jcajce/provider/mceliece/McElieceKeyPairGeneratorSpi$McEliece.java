// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyGenerationParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyPairGenerator;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.ECCKeyGenParameterSpec;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.mceliece:
//            McElieceKeyPairGeneratorSpi, BCMcEliecePublicKey, BCMcEliecePrivateKey

public static class  extends McElieceKeyPairGeneratorSpi
{

    private McElieceKeyPairGenerator aOh;

    public KeyPair generateKeyPair()
    {
        AsymmetricCipherKeyPair asymmetriccipherkeypair = aOh._mth1491();
        McEliecePrivateKeyParameters mcelieceprivatekeyparameters = (McEliecePrivateKeyParameters)asymmetriccipherkeypair.amv;
        return new KeyPair(new BCMcEliecePublicKey((McEliecePublicKeyParameters)asymmetriccipherkeypair.amu), new BCMcEliecePrivateKey(mcelieceprivatekeyparameters));
    }

    public void initialize(int i, SecureRandom securerandom)
    {
        securerandom = new ECCKeyGenParameterSpec();
        try
        {
            initialize(((AlgorithmParameterSpec) (securerandom)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SecureRandom securerandom)
        {
            return;
        }
    }

    public void initialize(AlgorithmParameterSpec algorithmparameterspec)
    {
        aOh = new McElieceKeyPairGenerator();
        super.initialize(algorithmparameterspec);
        algorithmparameterspec = (ECCKeyGenParameterSpec)algorithmparameterspec;
        algorithmparameterspec = new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters(((ECCKeyGenParameterSpec) (algorithmparameterspec)).afJ, ((ECCKeyGenParameterSpec) (algorithmparameterspec)).aJP));
        aOh._mth02CB(algorithmparameterspec);
    }

    public ()
    {
        super("McEliece");
    }
}
