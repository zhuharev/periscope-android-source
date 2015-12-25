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
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.DESedeWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.DESedeKeyGenerator;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class DESede
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
            super(new CBCBlockCipher(new DESedeEngine()), 64);
        }
    }

    public static class CBCMAC extends BaseMac
    {

        public CBCMAC()
        {
            super(new CBCBlockCipherMac(new DESedeEngine()));
        }
    }

    public static class CMAC extends BaseMac
    {

        public CMAC()
        {
            super(new CMac(new DESedeEngine()));
        }
    }

    public static class DESede64 extends BaseMac
    {

        public DESede64()
        {
            super(new CBCBlockCipherMac(new DESedeEngine(), 64));
        }
    }

    public static class DESede64with7816d4 extends BaseMac
    {

        public DESede64with7816d4()
        {
            super(new CBCBlockCipherMac(new DESedeEngine(), 64, new ISO7816d4Padding()));
        }
    }

    public static class DESedeCFB8 extends BaseMac
    {

        public DESedeCFB8()
        {
            super(new CFBBlockCipherMac(new DESedeEngine()));
        }
    }

    public static class ECB extends BaseBlockCipher
    {

        public ECB()
        {
            super(new DESedeEngine());
        }
    }

    public static class KeyFactory extends BaseSecretKeyFactory
    {

        protected SecretKey engineGenerateSecret(KeySpec keyspec)
        {
            if (keyspec instanceof DESedeKeySpec)
            {
                return new SecretKeySpec(((DESedeKeySpec)keyspec).getKey(), "DESede");
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
            if (!javax/crypto/spec/DESedeKeySpec.isAssignableFrom(class1))
            {
                break MISSING_BLOCK_LABEL_137;
            }
            secretkey = secretkey.getEncoded();
            if (secretkey.length != 16)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            class1 = new byte[24];
            System.arraycopy(secretkey, 0, class1, 0, 16);
            System.arraycopy(secretkey, 0, class1, 16, 8);
            secretkey = new DESedeKeySpec(class1);
            return secretkey;
            try
            {
                secretkey = new DESedeKeySpec(secretkey);
            }
            // Misplaced declaration of an exception variable
            catch (SecretKey secretkey)
            {
                throw new InvalidKeySpecException(secretkey.toString());
            }
            return secretkey;
            throw new InvalidKeySpecException("Invalid KeySpec");
        }

        public KeyFactory()
        {
            super("DESede", null);
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator
    {

        private boolean aFx;

        protected SecretKey engineGenerateKey()
        {
            if (aFV)
            {
                aFU._mth02CA(new KeyGenerationParameters(new SecureRandom(), aFT));
                aFV = false;
            }
            if (!aFx)
            {
                byte abyte0[] = aFU._mth14AE();
                System.arraycopy(abyte0, 0, abyte0, 16, 8);
                return new SecretKeySpec(abyte0, aFS);
            } else
            {
                return new SecretKeySpec(aFU._mth14AE(), aFS);
            }
        }

        protected void engineInit(int i, SecureRandom securerandom)
        {
            super.engineInit(i, securerandom);
            aFx = true;
        }

        public KeyGenerator()
        {
            super("DESede", 192, new DESedeKeyGenerator());
            aFx = false;
        }
    }

    public static class KeyGenerator3 extends BaseKeyGenerator
    {

        public KeyGenerator3()
        {
            super("DESede3", 192, new DESedeKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/DESede.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("Cipher.DESEDE", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(PKCSObjectIdentifiers.abw).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
            configurableprovider._mth0640("Cipher.DESEDEWRAP", (new StringBuilder()).append(PREFIX).append("$Wrap").toString());
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(PKCSObjectIdentifiers.acU).toString(), (new StringBuilder()).append(PREFIX).append("$Wrap").toString());
            configurableprovider._mth0640("Cipher.DESEDERFC3211WRAP", (new StringBuilder()).append(PREFIX).append("$RFC3211").toString());
            configurableprovider._mth0640("Alg.Alias.Cipher.TDEA", "DESEDE");
            configurableprovider._mth0640("Alg.Alias.Cipher.TDEAWRAP", "DESEDEWRAP");
            configurableprovider._mth0640("Alg.Alias.KeyGenerator.TDEA", "DESEDE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.TDEA", "DESEDE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.TDEA", "DESEDE");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.TDEA", "DESEDE");
            if (configurableprovider._mth1427("MessageDigest", "SHA-1"))
            {
                configurableprovider._mth0640("Cipher.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndDES3Key").toString());
                configurableprovider._mth0640("Cipher.BROKENPBEWITHSHAAND3-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$BrokePBEWithSHAAndDES3Key").toString());
                configurableprovider._mth0640("Cipher.OLDPBEWITHSHAAND3-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$OldPBEWithSHAAndDES3Key").toString());
                configurableprovider._mth0640("Cipher.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndDES2Key").toString());
                configurableprovider._mth0640("Cipher.BROKENPBEWITHSHAAND2-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$BrokePBEWithSHAAndDES2Key").toString());
                configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.acQ).toString(), "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.acR).toString(), "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYTRIPLEDES-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYTRIPLEDES-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
            }
            configurableprovider._mth0640("KeyGenerator.DESEDE", (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(PKCSObjectIdentifiers.abw).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator3").toString());
            configurableprovider._mth0640("KeyGenerator.DESEDEWRAP", (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
            configurableprovider._mth0640("SecretKeyFactory.DESEDE", (new StringBuilder()).append(PREFIX).append("$KeyFactory").toString());
            configurableprovider._mth0640("Mac.DESEDECMAC", (new StringBuilder()).append(PREFIX).append("$CMAC").toString());
            configurableprovider._mth0640("Mac.DESEDEMAC", (new StringBuilder()).append(PREFIX).append("$CBCMAC").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.DESEDE", "DESEDEMAC");
            configurableprovider._mth0640("Mac.DESEDEMAC/CFB8", (new StringBuilder()).append(PREFIX).append("$DESedeCFB8").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.DESEDE/CFB8", "DESEDEMAC/CFB8");
            configurableprovider._mth0640("Mac.DESEDEMAC64", (new StringBuilder()).append(PREFIX).append("$DESede64").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.DESEDE64", "DESEDEMAC64");
            configurableprovider._mth0640("Mac.DESEDEMAC64WITHISO7816-4PADDING", (new StringBuilder()).append(PREFIX).append("$DESede64with7816d4").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.DESEDE64WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableprovider._mth0640("Alg.Alias.Mac.DESEDEISO9797ALG1MACWITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableprovider._mth0640("Alg.Alias.Mac.DESEDEISO9797ALG1WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableprovider._mth0640("AlgorithmParameters.DESEDE", "org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(PKCSObjectIdentifiers.abw).toString(), "DESEDE");
            configurableprovider._mth0640("AlgorithmParameterGenerator.DESEDE", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(PKCSObjectIdentifiers.abw).toString(), "DESEDE");
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndDES3KeyFactory").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndDES2KeyFactory").toString());
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES3KEY-CBC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES2KEY-CBC", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.3", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.4", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.3", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.4", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        }


        public Mappings()
        {
        }
    }

    public static class PBEWithSHAAndDES2Key extends BaseBlockCipher
    {

        public PBEWithSHAAndDES2Key()
        {
            super(new CBCBlockCipher(new DESedeEngine()));
        }
    }

    public static class PBEWithSHAAndDES2KeyFactory extends DES.DESPBEKeyFactory
    {

        public PBEWithSHAAndDES2KeyFactory()
        {
            super("PBEwithSHAandDES2Key-CBC", PKCSObjectIdentifiers.acR, true, 2, 1, 128, 64);
        }
    }

    public static class PBEWithSHAAndDES3Key extends BaseBlockCipher
    {

        public PBEWithSHAAndDES3Key()
        {
            super(new CBCBlockCipher(new DESedeEngine()));
        }
    }

    public static class PBEWithSHAAndDES3KeyFactory extends DES.DESPBEKeyFactory
    {

        public PBEWithSHAAndDES3KeyFactory()
        {
            super("PBEwithSHAandDES3Key-CBC", PKCSObjectIdentifiers.acQ, true, 2, 1, 192, 64);
        }
    }

    public static class RFC3211 extends BaseWrapCipher
    {

        public RFC3211()
        {
            super(new RFC3211WrapEngine(new DESedeEngine()), 8);
        }
    }

    public static class Wrap extends BaseWrapCipher
    {

        public Wrap()
        {
            super(new DESedeWrapEngine());
        }
    }


    private DESede()
    {
    }
}
