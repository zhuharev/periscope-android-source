// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.DESKeyGenerator;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.ISO9797Alg3Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class DES
{
    public static class AlgParamGen extends BaseAlgorithmParameterGenerator
    {

        protected AlgorithmParameters engineGenerateParameters()
        {
            byte abyte0[] = new byte[8];
            if (amC == null)
            {
                amC = new SecureRandom();
            }
            amC.nextBytes(abyte0);
            AlgorithmParameters algorithmparameters;
            try
            {
                algorithmparameters = AlgorithmParameters.getInstance("DES", "SC");
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
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DES parameter generation.");
        }

        public AlgParamGen()
        {
        }
    }

    public static class CBC extends BaseBlockCipher
    {

        public CBC()
        {
            super(new CBCBlockCipher(new DESEngine()), 64);
        }
    }

    public static class CBCMAC extends BaseMac
    {

        public CBCMAC()
        {
            super(new CBCBlockCipherMac(new DESEngine()));
        }
    }

    public static class CMAC extends BaseMac
    {

        public CMAC()
        {
            super(new CMac(new DESEngine()));
        }
    }

    public static class DES64 extends BaseMac
    {

        public DES64()
        {
            super(new CBCBlockCipherMac(new DESEngine(), 64));
        }
    }

    public static class DES64with7816d4 extends BaseMac
    {

        public DES64with7816d4()
        {
            super(new CBCBlockCipherMac(new DESEngine(), 64, new ISO7816d4Padding()));
        }
    }

    public static class DES9797Alg3 extends BaseMac
    {

        public DES9797Alg3()
        {
            super(new ISO9797Alg3Mac(new DESEngine()));
        }
    }

    public static class DES9797Alg3with7816d4 extends BaseMac
    {

        public DES9797Alg3with7816d4()
        {
            super(new ISO9797Alg3Mac(new DESEngine(), new ISO7816d4Padding()));
        }
    }

    public static class DESCFB8 extends BaseMac
    {

        public DESCFB8()
        {
            super(new CFBBlockCipherMac(new DESEngine()));
        }
    }

    public static class DESPBEKeyFactory extends BaseSecretKeyFactory
    {

        private int Yp;
        private boolean aFu;
        private int aFv;
        private int aFw;
        private int scheme;

        protected SecretKey engineGenerateSecret(KeySpec keyspec)
        {
            if (keyspec instanceof PBEKeySpec)
            {
                PBEKeySpec pbekeyspec = (PBEKeySpec)keyspec;
                if (pbekeyspec.getSalt() == null)
                {
                    return new BCPBEKey(aFS, aFZ, scheme, aFv, Yp, aFw, pbekeyspec, null);
                }
                if (aFu)
                {
                    keyspec = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util._mth02CA(pbekeyspec, scheme, aFv, Yp, aFw);
                } else
                {
                    keyspec = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util._mth02CA(pbekeyspec, scheme, aFv, Yp);
                }
                KeyParameter keyparameter;
                if (keyspec instanceof ParametersWithIV)
                {
                    keyparameter = (KeyParameter)((ParametersWithIV)keyspec).axC;
                } else
                {
                    keyparameter = (KeyParameter)keyspec;
                }
                DESParameters._mth1D55(keyparameter.key);
                return new BCPBEKey(aFS, aFZ, scheme, aFv, Yp, aFw, pbekeyspec, keyspec);
            } else
            {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }

        public DESPBEKeyFactory(String s, ASN1ObjectIdentifier asn1objectidentifier, boolean flag, int i, int j, int k, int l)
        {
            super(s, asn1objectidentifier);
            aFu = true;
            scheme = i;
            aFv = j;
            Yp = k;
            aFw = 64;
        }
    }

    public static class ECB extends BaseBlockCipher
    {

        public ECB()
        {
            super(new DESEngine());
        }
    }

    public static class KeyFactory extends BaseSecretKeyFactory
    {

        protected SecretKey engineGenerateSecret(KeySpec keyspec)
        {
            if (keyspec instanceof DESKeySpec)
            {
                return new SecretKeySpec(((DESKeySpec)keyspec).getKey(), "DES");
            } else
            {
                return super.engineGenerateSecret(keyspec);
            }
        }

        protected KeySpec engineGetKeySpec(SecretKey secretkey, Class class1)
        {
            if (class1 == null)
            {
                throw new InvalidKeySpecException("keySpec parameter is null");
            }
            if (secretkey == null)
            {
                throw new InvalidKeySpecException("key parameter is null");
            }
            if (javax/crypto/spec/SecretKeySpec.isAssignableFrom(class1))
            {
                return new SecretKeySpec(secretkey.getEncoded(), aFS);
            }
            if (javax/crypto/spec/DESKeySpec.isAssignableFrom(class1))
            {
                secretkey = secretkey.getEncoded();
                try
                {
                    secretkey = new DESKeySpec(secretkey);
                }
                // Misplaced declaration of an exception variable
                catch (SecretKey secretkey)
                {
                    throw new InvalidKeySpecException(secretkey.toString());
                }
                return secretkey;
            } else
            {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }

        public KeyFactory()
        {
            super("DES", null);
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator
    {

        protected SecretKey engineGenerateKey()
        {
            if (aFV)
            {
                aFU._mth02CA(new KeyGenerationParameters(new SecureRandom(), aFT));
                aFV = false;
            }
            return new SecretKeySpec(aFU._mth14AE(), aFS);
        }

        protected void engineInit(int i, SecureRandom securerandom)
        {
            super.engineInit(i, securerandom);
        }

        public KeyGenerator()
        {
            super("DES", 64, new DESKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/DES.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("Cipher.DES", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(OIWObjectIdentifiers.aau).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
            ASN1ObjectIdentifier asn1objectidentifier = OIWObjectIdentifiers.aau;
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyGenerator.")).append(asn1objectidentifier.identifier).toString(), "DES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyFactory.")).append(asn1objectidentifier.identifier).toString(), "DES");
            configurableprovider._mth0640("Cipher.DESRFC3211WRAP", (new StringBuilder()).append(PREFIX).append("$RFC3211").toString());
            configurableprovider._mth0640("KeyGenerator.DES", (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
            configurableprovider._mth0640("SecretKeyFactory.DES", (new StringBuilder()).append(PREFIX).append("$KeyFactory").toString());
            configurableprovider._mth0640("Mac.DESCMAC", (new StringBuilder()).append(PREFIX).append("$CMAC").toString());
            configurableprovider._mth0640("Mac.DESMAC", (new StringBuilder()).append(PREFIX).append("$CBCMAC").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.DES", "DESMAC");
            configurableprovider._mth0640("Mac.DESMAC/CFB8", (new StringBuilder()).append(PREFIX).append("$DESCFB8").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.DES/CFB8", "DESMAC/CFB8");
            configurableprovider._mth0640("Mac.DESMAC64", (new StringBuilder()).append(PREFIX).append("$DES64").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.DES64", "DESMAC64");
            configurableprovider._mth0640("Mac.DESMAC64WITHISO7816-4PADDING", (new StringBuilder()).append(PREFIX).append("$DES64with7816d4").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.DES64WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            configurableprovider._mth0640("Alg.Alias.Mac.DESISO9797ALG1MACWITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            configurableprovider._mth0640("Alg.Alias.Mac.DESISO9797ALG1WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            configurableprovider._mth0640("Mac.DESWITHISO9797", (new StringBuilder()).append(PREFIX).append("$DES9797Alg3").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.DESISO9797MAC", "DESWITHISO9797");
            configurableprovider._mth0640("Mac.ISO9797ALG3MAC", (new StringBuilder()).append(PREFIX).append("$DES9797Alg3").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.ISO9797ALG3", "ISO9797ALG3MAC");
            configurableprovider._mth0640("Mac.ISO9797ALG3WITHISO7816-4PADDING", (new StringBuilder()).append(PREFIX).append("$DES9797Alg3with7816d4").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.ISO9797ALG3MACWITHISO7816-4PADDING", "ISO9797ALG3WITHISO7816-4PADDING");
            configurableprovider._mth0640("AlgorithmParameters.DES", "org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(OIWObjectIdentifiers.aau).toString(), "DES");
            configurableprovider._mth0640("AlgorithmParameterGenerator.DES", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(OIWObjectIdentifiers.aau).toString(), "DES");
            configurableprovider._mth0640("Cipher.PBEWITHMD2ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithMD2").toString());
            configurableprovider._mth0640("Cipher.PBEWITHMD5ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5").toString());
            configurableprovider._mth0640("Cipher.PBEWITHSHA1ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA1").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.abn).toString(), "PBEWITHMD2ANDDES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.abp).toString(), "PBEWITHMD5ANDDES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.abr).toString(), "PBEWITHSHA1ANDDES");
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD2ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithMD2KeyFactory").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD5ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5KeyFactory").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHA1ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA1KeyFactory").toString());
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abn).toString(), "PBEWITHMD2ANDDES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abp).toString(), "PBEWITHMD5ANDDES");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abr).toString(), "PBEWITHSHA1ANDDES");
        }


        public Mappings()
        {
        }
    }

    public static class PBEWithMD2 extends BaseBlockCipher
    {

        public PBEWithMD2()
        {
            super(new CBCBlockCipher(new DESEngine()));
        }
    }

    public static class PBEWithMD2KeyFactory extends DESPBEKeyFactory
    {

        public PBEWithMD2KeyFactory()
        {
            super("PBEwithMD2andDES", PKCSObjectIdentifiers.abn, true, 0, 5, 64, 64);
        }
    }

    public static class PBEWithMD5 extends BaseBlockCipher
    {

        public PBEWithMD5()
        {
            super(new CBCBlockCipher(new DESEngine()));
        }
    }

    public static class PBEWithMD5KeyFactory extends DESPBEKeyFactory
    {

        public PBEWithMD5KeyFactory()
        {
            super("PBEwithMD5andDES", PKCSObjectIdentifiers.abp, true, 0, 0, 64, 64);
        }
    }

    public static class PBEWithSHA1 extends BaseBlockCipher
    {

        public PBEWithSHA1()
        {
            super(new CBCBlockCipher(new DESEngine()));
        }
    }

    public static class PBEWithSHA1KeyFactory extends DESPBEKeyFactory
    {

        public PBEWithSHA1KeyFactory()
        {
            super("PBEwithSHA1andDES", PKCSObjectIdentifiers.abr, true, 0, 1, 64, 64);
        }
    }

    public static class RFC3211 extends BaseWrapCipher
    {

        public RFC3211()
        {
            super(new RFC3211WrapEngine(new DESEngine()), 8);
        }
    }


    private DES()
    {
    }
}
