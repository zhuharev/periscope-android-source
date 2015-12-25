// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.bc.BCObjectIdentifiers;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.AESFastEngine;
import org.spongycastle.crypto.engines.AESWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.engines.RFC5649WrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            SymmetricAlgorithmProvider

public final class AES
{
    public static class AESCMAC extends BaseMac
    {

        public AESCMAC()
        {
            super(new CMac(new AESFastEngine()));
        }
    }

    public static class AESGMAC extends BaseMac
    {

        public AESGMAC()
        {
            super(new GMac(new GCMBlockCipher(new AESFastEngine())));
        }
    }

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
                algorithmparameters = AlgorithmParameters.getInstance("AES", "SC");
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
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }

        public AlgParamGen()
        {
        }
    }

    public static class AlgParams extends IvAlgorithmParameters
    {

        protected String engineToString()
        {
            return "AES IV";
        }

        public AlgParams()
        {
        }
    }

    public static class AlgParamsGCM extends BaseAlgorithmParameters
    {

        private GCMParameters aFs;

        protected byte[] engineGetEncoded()
        {
            return aFs.getEncoded();
        }

        protected byte[] engineGetEncoded(String s)
        {
            boolean flag;
            if (s == null || s.equals("ASN.1"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                throw new IOException("unknown format specified");
            } else
            {
                return aFs.getEncoded();
            }
        }

        protected void engineInit(AlgorithmParameterSpec algorithmparameterspec)
        {
            if (AES._mth1626() != null)
            {
                try
                {
                    Method method = AES._mth1626().getDeclaredMethod("getTLen", new Class[0]);
                    aFs = new GCMParameters((byte[])AES._mth1626().getDeclaredMethod("getIV", new Class[0]).invoke(algorithmparameterspec, new Object[0]), ((Integer)method.invoke(algorithmparameterspec, new Object[0])).intValue());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (AlgorithmParameterSpec algorithmparameterspec)
                {
                    throw new InvalidParameterSpecException("Cannot process GCMParameterSpec.");
                }
            } else
            {
                return;
            }
        }

        protected void engineInit(byte abyte0[])
        {
            aFs = GCMParameters._mth1507(abyte0);
        }

        protected void engineInit(byte abyte0[], String s)
        {
            boolean flag;
            if (s == null || s.equals("ASN.1"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                throw new IOException("unknown format specified");
            } else
            {
                aFs = GCMParameters._mth1507(abyte0);
                return;
            }
        }

        protected String engineToString()
        {
            return "GCM";
        }

        protected final AlgorithmParameterSpec _mth02C8(Class class1)
        {
            if (AES._mth1626() != null)
            {
                try
                {
                    class1 = (AlgorithmParameterSpec)AES._mth1626().getConstructor(new Class[] {
                        Integer.TYPE, [B
                    }).newInstance(new Object[] {
                        Integers.valueOf(aFs.XE), Arrays._mth1D4C(aFs.XD)
                    });
                }
                // Misplaced declaration of an exception variable
                catch (Class class1)
                {
                    throw new InvalidParameterSpecException("no constructor found!");
                }
                // Misplaced declaration of an exception variable
                catch (Class class1)
                {
                    throw new InvalidParameterSpecException((new StringBuilder("construction failed: ")).append(class1.getMessage()).toString());
                }
                return class1;
            } else
            {
                throw new InvalidParameterSpecException((new StringBuilder("unknown parameter spec: ")).append(class1.getName()).toString());
            }
        }

        public AlgParamsGCM()
        {
        }
    }

    public static class CBC extends BaseBlockCipher
    {

        public CBC()
        {
            super(new CBCBlockCipher(new AESFastEngine()), 128);
        }
    }

    public static class CFB extends BaseBlockCipher
    {

        public CFB()
        {
            super(new BufferedBlockCipher(new CFBBlockCipher(new AESFastEngine(), 128)), 128);
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
                    return new AESFastEngine();
                }

                _cls1()
                {
                }
            }

            super(new _cls1());
        }
    }

    public static class GCM extends BaseBlockCipher
    {

        public GCM()
        {
            super(new GCMBlockCipher(new AESFastEngine()));
        }
    }

    public static class KeyGen extends BaseKeyGenerator
    {

        public KeyGen()
        {
            this(192);
        }

        public KeyGen(int i)
        {
            super("AES", i, new CipherKeyGenerator());
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

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/AES.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("AlgorithmParameters.AES", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", "AES");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", "AES");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", "AES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.ZL).toString(), "AES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.ZR).toString(), "AES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.ZX).toString(), "AES");
            configurableprovider._mth0640("AlgorithmParameters.GCM", (new StringBuilder()).append(PREFIX).append("$AlgParamsGCM").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.ZP).toString(), "GCM");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.ZV).toString(), "GCM");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.aab).toString(), "GCM");
            configurableprovider._mth0640("AlgorithmParameterGenerator.AES", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", "AES");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", "AES");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", "AES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NISTObjectIdentifiers.ZL).toString(), "AES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NISTObjectIdentifiers.ZR).toString(), "AES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NISTObjectIdentifiers.ZX).toString(), "AES");
            configurableprovider._mth0640("Cipher.AES", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
            configurableprovider._mth0640("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", "AES");
            configurableprovider._mth0640("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", "AES");
            configurableprovider._mth0640("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", "AES");
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZK).toString(), (new StringBuilder()).append(PREFIX).append("$ECB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZQ).toString(), (new StringBuilder()).append(PREFIX).append("$ECB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZW).toString(), (new StringBuilder()).append(PREFIX).append("$ECB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZL).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZR).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZX).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZM).toString(), (new StringBuilder()).append(PREFIX).append("$OFB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZS).toString(), (new StringBuilder()).append(PREFIX).append("$OFB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZY).toString(), (new StringBuilder()).append(PREFIX).append("$OFB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZN).toString(), (new StringBuilder()).append(PREFIX).append("$CFB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZT).toString(), (new StringBuilder()).append(PREFIX).append("$CFB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZZ).toString(), (new StringBuilder()).append(PREFIX).append("$CFB").toString());
            configurableprovider._mth0640("Cipher.AESWRAP", (new StringBuilder()).append(PREFIX).append("$Wrap").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.ZO).toString(), "AESWRAP");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.ZU).toString(), "AESWRAP");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.aaa).toString(), "AESWRAP");
            configurableprovider._mth0640("Cipher.AESRFC3211WRAP", (new StringBuilder()).append(PREFIX).append("$RFC3211Wrap").toString());
            configurableprovider._mth0640("Cipher.AESRFC5649WRAP", (new StringBuilder()).append(PREFIX).append("$RFC5649Wrap").toString());
            configurableprovider._mth0640("Cipher.GCM", (new StringBuilder()).append(PREFIX).append("$GCM").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.ZP).toString(), "GCM");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.ZV).toString(), "GCM");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.aab).toString(), "GCM");
            configurableprovider._mth0640("KeyGenerator.AES", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            configurableprovider._mth0640("KeyGenerator.2.16.840.1.101.3.4.2", (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
            configurableprovider._mth0640("KeyGenerator.2.16.840.1.101.3.4.22", (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
            configurableprovider._mth0640("KeyGenerator.2.16.840.1.101.3.4.42", (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZK).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZL).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZM).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZN).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZQ).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZR).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZS).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZT).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZW).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZX).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZY).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZZ).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
            configurableprovider._mth0640("KeyGenerator.AESWRAP", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZO).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZU).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.aaa).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
            configurableprovider._mth0640("Mac.AESCMAC", (new StringBuilder()).append(PREFIX).append("$AESCMAC").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xi.identifier).toString(), "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xj.identifier).toString(), "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xk.identifier).toString(), "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xl.identifier).toString(), "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xm.identifier).toString(), "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xn.identifier).toString(), "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableprovider._mth0640("Cipher.PBEWITHSHAAND128BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
            configurableprovider._mth0640("Cipher.PBEWITHSHAAND192BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
            configurableprovider._mth0640("Cipher.PBEWITHSHAAND256BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
            configurableprovider._mth0640("Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
            configurableprovider._mth0640("Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
            configurableprovider._mth0640("Cipher.PBEWITHSHA256AND256BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableprovider._mth0640("Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
            configurableprovider._mth0640("Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
            configurableprovider._mth0640("Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5And128BitAESCBCOpenSSL").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5And192BitAESCBCOpenSSL").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5And256BitAESCBCOpenSSL").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd128BitAESBC").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd192BitAESBC").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd256BitAESBC").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA256And128BitAESBC").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA256And192BitAESBC").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA256And256BitAESBC").toString());
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xi.identifier).toString(), "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xj.identifier).toString(), "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xk.identifier).toString(), "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xl.identifier).toString(), "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xm.identifier).toString(), "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xn.identifier).toString(), "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xi.identifier).toString(), "PKCS12PBE");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xj.identifier).toString(), "PKCS12PBE");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xk.identifier).toString(), "PKCS12PBE");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xl.identifier).toString(), "PKCS12PBE");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xm.identifier).toString(), "PKCS12PBE");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xn.identifier).toString(), "PKCS12PBE");
            _mth02CB(configurableprovider, "AES", (new StringBuilder()).append(PREFIX).append("$AESGMAC").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
            _mth02CE(configurableprovider, "AES", (new StringBuilder()).append(PREFIX).append("$Poly1305").toString(), (new StringBuilder()).append(PREFIX).append("$Poly1305KeyGen").toString());
        }


        public Mappings()
        {
        }
    }

    public static class OFB extends BaseBlockCipher
    {

        public OFB()
        {
            super(new BufferedBlockCipher(new OFBBlockCipher(new AESFastEngine(), 128)), 128);
        }
    }

    public static class PBEWithAESCBC extends BaseBlockCipher
    {

        public PBEWithAESCBC()
        {
            super(new CBCBlockCipher(new AESFastEngine()));
        }
    }

    public static class PBEWithMD5And128BitAESCBCOpenSSL extends PBESecretKeyFactory
    {

        public PBEWithMD5And128BitAESCBCOpenSSL()
        {
            super("PBEWithMD5And128BitAES-CBC-OpenSSL", null, true, 3, 0, 128, 128);
        }
    }

    public static class PBEWithMD5And192BitAESCBCOpenSSL extends PBESecretKeyFactory
    {

        public PBEWithMD5And192BitAESCBCOpenSSL()
        {
            super("PBEWithMD5And192BitAES-CBC-OpenSSL", null, true, 3, 0, 192, 128);
        }
    }

    public static class PBEWithMD5And256BitAESCBCOpenSSL extends PBESecretKeyFactory
    {

        public PBEWithMD5And256BitAESCBCOpenSSL()
        {
            super("PBEWithMD5And256BitAES-CBC-OpenSSL", null, true, 3, 0, 256, 128);
        }
    }

    public static class PBEWithSHA256And128BitAESBC extends PBESecretKeyFactory
    {

        public PBEWithSHA256And128BitAESBC()
        {
            super("PBEWithSHA256And128BitAES-CBC-BC", null, true, 2, 4, 128, 128);
        }
    }

    public static class PBEWithSHA256And192BitAESBC extends PBESecretKeyFactory
    {

        public PBEWithSHA256And192BitAESBC()
        {
            super("PBEWithSHA256And192BitAES-CBC-BC", null, true, 2, 4, 192, 128);
        }
    }

    public static class PBEWithSHA256And256BitAESBC extends PBESecretKeyFactory
    {

        public PBEWithSHA256And256BitAESBC()
        {
            super("PBEWithSHA256And256BitAES-CBC-BC", null, true, 2, 4, 256, 128);
        }
    }

    public static class PBEWithSHAAnd128BitAESBC extends PBESecretKeyFactory
    {

        public PBEWithSHAAnd128BitAESBC()
        {
            super("PBEWithSHA1And128BitAES-CBC-BC", null, true, 2, 1, 128, 128);
        }
    }

    public static class PBEWithSHAAnd192BitAESBC extends PBESecretKeyFactory
    {

        public PBEWithSHAAnd192BitAESBC()
        {
            super("PBEWithSHA1And192BitAES-CBC-BC", null, true, 2, 1, 192, 128);
        }
    }

    public static class PBEWithSHAAnd256BitAESBC extends PBESecretKeyFactory
    {

        public PBEWithSHAAnd256BitAESBC()
        {
            super("PBEWithSHA1And256BitAES-CBC-BC", null, true, 2, 1, 256, 128);
        }
    }

    public static class Poly1305 extends BaseMac
    {

        public Poly1305()
        {
            super(new org.spongycastle.crypto.macs.Poly1305(new AESFastEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator
    {

        public Poly1305KeyGen()
        {
            super("Poly1305-AES", 256, new Poly1305KeyGenerator());
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher
    {

        public RFC3211Wrap()
        {
            super(new RFC3211WrapEngine(new AESFastEngine()), 16);
        }
    }

    public static class RFC5649Wrap extends BaseWrapCipher
    {

        public RFC5649Wrap()
        {
            super(new RFC5649WrapEngine(new AESFastEngine()));
        }
    }

    public static class Wrap extends BaseWrapCipher
    {

        public Wrap()
        {
            super(new AESWrapEngine());
        }
    }


    private static final Class aFr = _mth1D5E("javax.crypto.spec.GCMParameterSpec");

    private AES()
    {
    }

    static Class _mth1626()
    {
        return aFr;
    }

    private static Class _mth1D5E(String s)
    {
        try
        {
            s = org/spongycastle/jcajce/provider/symmetric/AES.getClassLoader().loadClass(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

}
