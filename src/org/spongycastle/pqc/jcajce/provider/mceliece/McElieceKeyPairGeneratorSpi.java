// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyGenerationParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyPairGenerator;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyGenerationParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyPairGenerator;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.ECCKeyGenParameterSpec;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.mceliece:
//            BCMcEliecePublicKey, BCMcEliecePrivateKey, BCMcElieceCCA2PublicKey, BCMcElieceCCA2PrivateKey

public abstract class McElieceKeyPairGeneratorSpi extends KeyPairGenerator
{
    public static class McEliece extends McElieceKeyPairGeneratorSpi
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
            initialize(algorithmparameterspec);
            algorithmparameterspec = (ECCKeyGenParameterSpec)algorithmparameterspec;
            algorithmparameterspec = new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters(((ECCKeyGenParameterSpec) (algorithmparameterspec)).afJ, ((ECCKeyGenParameterSpec) (algorithmparameterspec)).aJP));
            aOh._mth02CB(algorithmparameterspec);
        }

        public McEliece()
        {
            super("McEliece");
        }
    }

    public static class McElieceCCA2 extends McElieceKeyPairGeneratorSpi
    {

        private McElieceCCA2KeyPairGenerator aOi;

        public KeyPair generateKeyPair()
        {
            AsymmetricCipherKeyPair asymmetriccipherkeypair = aOi._mth1491();
            McElieceCCA2PrivateKeyParameters mceliececca2privatekeyparameters = (McElieceCCA2PrivateKeyParameters)asymmetriccipherkeypair.amv;
            return new KeyPair(new BCMcElieceCCA2PublicKey((McElieceCCA2PublicKeyParameters)asymmetriccipherkeypair.amu), new BCMcElieceCCA2PrivateKey(mceliececca2privatekeyparameters));
        }

        public void initialize(int i, SecureRandom securerandom)
        {
            securerandom = new McElieceCCA2ParameterSpec();
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
            aOi = new McElieceCCA2KeyPairGenerator();
            initialize(algorithmparameterspec);
            algorithmparameterspec = (ECCKeyGenParameterSpec)algorithmparameterspec;
            algorithmparameterspec = new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Parameters(((ECCKeyGenParameterSpec) (algorithmparameterspec)).afJ, ((ECCKeyGenParameterSpec) (algorithmparameterspec)).aJP));
            aOi._mth02CA(algorithmparameterspec);
        }

        public McElieceCCA2()
        {
            super("McElieceCCA-2");
        }
    }


    public McElieceKeyPairGeneratorSpi(String s)
    {
        super(s);
    }
}
