// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.CamelliaEngine;
import org.spongycastle.crypto.engines.CamelliaWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            SymmetricAlgorithmProvider

public final class Camellia
{
    public static class AlgParamGen extends BaseAlgorithmParameterGenerator
    {

        protected AlgorithmParameters engineGenerateParameters()
        {
            byte abyte0[] = new byte[16];
            if (amC == null)
            {
                amC = new SecureRandom();
            }
            amC.nextBytes(abyte0);
            AlgorithmParameters algorithmparameters;
            try
            {
                algorithmparameters = AlgorithmParameters.getInstance("Camellia", "SC");
                algorithmparameters.init(new IvParameterSpec(abyte0));
            }
            catch (Exception exception)
            {
                throw new RuntimeException(exception.getMessage());
            }
            return algorithmparameters;
        }

        protected void engineInit(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
        {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Camellia parameter generation.");
        }

        public AlgParamGen()
        {
        }
    }

    public static class AlgParams extends IvAlgorithmParameters
    {

        protected String engineToString()
        {
            return "Camellia IV";
        }

        public AlgParams()
        {
        }
    }

    public static class CBC extends BaseBlockCipher
    {

        public CBC()
        {
            super(new CBCBlockCipher(new CamelliaEngine()), 128);
        }
    }

    public static class ECB extends BaseBlockCipher
    {

        public ECB()
        {
            class _cls1
                implements BlockCipherProvider
            {

                public final BlockCipher _mth1627()
                {
                    return new CamelliaEngine();
                }

                _cls1()
                {
                }
            }

            super(new _cls1());
        }
    }

    public static class GMAC extends BaseMac
    {

        public GMAC()
        {
            super(new GMac(new GCMBlockCipher(new CamelliaEngine())));
        }
    }

    public static class KeyGen extends BaseKeyGenerator
    {

        public KeyGen()
        {
            this(256);
        }

        public KeyGen(int i)
        {
            super("Camellia", i, new CipherKeyGenerator());
        }
    }

    public static class KeyGen128 extends KeyGen
    {

        public KeyGen128()
        {
            super(128);
        }
    }

    public static class KeyGen192 extends KeyGen
    {

        public KeyGen192()
        {
            super(192);
        }
    }

    public static class KeyGen256 extends KeyGen
    {

        public KeyGen256()
        {
            super(256);
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/Camellia.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("AlgorithmParameters.CAMELLIA", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NTTObjectIdentifiers.aah).toString(), "CAMELLIA");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NTTObjectIdentifiers.aai).toString(), "CAMELLIA");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NTTObjectIdentifiers.aaj).toString(), "CAMELLIA");
            configurableprovider._mth0640("AlgorithmParameterGenerator.CAMELLIA", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NTTObjectIdentifiers.aah).toString(), "CAMELLIA");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NTTObjectIdentifiers.aai).toString(), "CAMELLIA");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NTTObjectIdentifiers.aaj).toString(), "CAMELLIA");
            configurableprovider._mth0640("Cipher.CAMELLIA", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NTTObjectIdentifiers.aah).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NTTObjectIdentifiers.aai).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NTTObjectIdentifiers.aaj).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
            configurableprovider._mth0640("Cipher.CAMELLIARFC3211WRAP", (new StringBuilder()).append(PREFIX).append("$RFC3211Wrap").toString());
            configurableprovider._mth0640("Cipher.CAMELLIAWRAP", (new StringBuilder()).append(PREFIX).append("$Wrap").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NTTObjectIdentifiers.aak).toString(), "CAMELLIAWRAP");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NTTObjectIdentifiers.aal).toString(), "CAMELLIAWRAP");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NTTObjectIdentifiers.aam).toString(), "CAMELLIAWRAP");
            configurableprovider._mth0640("KeyGenerator.CAMELLIA", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aak).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aal).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aam).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aah).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aai).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aaj).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
            _mth02CB(configurableprovider, "CAMELLIA", (new StringBuilder()).append(PREFIX).append("$GMAC").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            _mth02CE(configurableprovider, "CAMELLIA", (new StringBuilder()).append(PREFIX).append("$Poly1305").toString(), (new StringBuilder()).append(PREFIX).append("$Poly1305KeyGen").toString());
        }


        public Mappings()
        {
        }
    }

    public static class Poly1305 extends BaseMac
    {

        public Poly1305()
        {
            super(new org.spongycastle.crypto.macs.Poly1305(new CamelliaEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator
    {

        public Poly1305KeyGen()
        {
            super("Poly1305-Camellia", 256, new Poly1305KeyGenerator());
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher
    {

        public RFC3211Wrap()
        {
            super(new RFC3211WrapEngine(new CamelliaEngine()), 16);
        }
    }

    public static class Wrap extends BaseWrapCipher
    {

        public Wrap()
        {
            super(new CamelliaWrapEngine());
        }
    }


    private Camellia()
    {
    }
}
