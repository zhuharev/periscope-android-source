// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.misc.IDEACBCPar;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.IDEAEngine;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class IDEA
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
                algorithmparameters = AlgorithmParameters.getInstance("IDEA", "SC");
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
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for IDEA parameter generation.");
        }

        public AlgParamGen()
        {
        }
    }

    public static class AlgParams extends BaseAlgorithmParameters
    {

        private byte iv[];

        protected byte[] engineGetEncoded()
        {
            return engineGetEncoded("ASN.1");
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
            if (flag)
            {
                return (new IDEACBCPar(engineGetEncoded("RAW"))).getEncoded();
            }
            if (s.equals("RAW"))
            {
                s = new byte[iv.length];
                System.arraycopy(iv, 0, s, 0, iv.length);
                return s;
            } else
            {
                return null;
            }
        }

        protected void engineInit(AlgorithmParameterSpec algorithmparameterspec)
        {
            if (!(algorithmparameterspec instanceof IvParameterSpec))
            {
                throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
            } else
            {
                iv = ((IvParameterSpec)algorithmparameterspec).getIV();
                return;
            }
        }

        protected void engineInit(byte abyte0[])
        {
            iv = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, iv, 0, iv.length);
        }

        protected void engineInit(byte abyte0[], String s)
        {
            if (s.equals("RAW"))
            {
                engineInit(abyte0);
                return;
            }
            if (s.equals("ASN.1"))
            {
                abyte0 = new IDEACBCPar((ASN1Sequence)(new ASN1InputStream(abyte0))._mth04B7());
                if (((IDEACBCPar) (abyte0)).Yk != null)
                {
                    abyte0 = ((IDEACBCPar) (abyte0)).Yk._mth0501();
                } else
                {
                    abyte0 = null;
                }
                engineInit(abyte0);
                return;
            } else
            {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }

        protected String engineToString()
        {
            return "IDEA Parameters";
        }

        protected final AlgorithmParameterSpec _mth02C8(Class class1)
        {
            if (class1 == javax/crypto/spec/IvParameterSpec)
            {
                return new IvParameterSpec(iv);
            } else
            {
                throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
            }
        }

        public AlgParams()
        {
        }
    }

    public static class CBC extends BaseBlockCipher
    {

        public CBC()
        {
            super(new CBCBlockCipher(new IDEAEngine()), 64);
        }
    }

    public static class CFB8Mac extends BaseMac
    {

        public CFB8Mac()
        {
            super(new CFBBlockCipherMac(new IDEAEngine()));
        }
    }

    public static class ECB extends BaseBlockCipher
    {

        public ECB()
        {
            super(new IDEAEngine());
        }
    }

    public static class KeyGen extends BaseKeyGenerator
    {

        public KeyGen()
        {
            super("IDEA", 128, new CipherKeyGenerator());
        }
    }

    public static class Mac extends BaseMac
    {

        public Mac()
        {
            super(new CBCBlockCipherMac(new IDEAEngine()));
        }
    }

    public static class Mappings extends AlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/IDEA.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("AlgorithmParameterGenerator.IDEA", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
            configurableprovider._mth0640("AlgorithmParameterGenerator.1.3.6.1.4.1.188.7.1.1.2", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
            configurableprovider._mth0640("AlgorithmParameters.IDEA", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
            configurableprovider._mth0640("AlgorithmParameters.1.3.6.1.4.1.188.7.1.1.2", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA-CBC", "PKCS12PBE");
            configurableprovider._mth0640("Cipher.IDEA", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
            configurableprovider._mth0640("Cipher.1.3.6.1.4.1.188.7.1.1.2", (new StringBuilder()).append(PREFIX).append("$CBC").toString());
            configurableprovider._mth0640("Cipher.PBEWITHSHAANDIDEA-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndIDEA").toString());
            configurableprovider._mth0640("KeyGenerator.IDEA", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            configurableprovider._mth0640("KeyGenerator.1.3.6.1.4.1.188.7.1.1.2", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAANDIDEA-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndIDEAKeyGen").toString());
            configurableprovider._mth0640("Mac.IDEAMAC", (new StringBuilder()).append(PREFIX).append("$Mac").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.IDEA", "IDEAMAC");
            configurableprovider._mth0640("Mac.IDEAMAC/CFB8", (new StringBuilder()).append(PREFIX).append("$CFB8Mac").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.IDEA/CFB8", "IDEAMAC/CFB8");
        }


        public Mappings()
        {
        }
    }

    public static class PBEWithSHAAndIDEA extends BaseBlockCipher
    {

        public PBEWithSHAAndIDEA()
        {
            super(new CBCBlockCipher(new IDEAEngine()));
        }
    }

    public static class PBEWithSHAAndIDEAKeyGen extends PBESecretKeyFactory
    {

        public PBEWithSHAAndIDEAKeyGen()
        {
            super("PBEwithSHAandIDEA-CBC", null, true, 2, 1, 128, 64);
        }
    }


    private IDEA()
    {
    }
}
