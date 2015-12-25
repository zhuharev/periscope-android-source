// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;

public class PBEPBKDF2
{
    public static class AlgParams extends BaseAlgorithmParameters
    {

        private PBKDF2Params aFy;

        protected byte[] engineGetEncoded()
        {
            byte abyte0[];
            try
            {
                abyte0 = aFy.getEncoded("DER");
            }
            catch (IOException ioexception)
            {
                throw new RuntimeException((new StringBuilder("Oooops! ")).append(ioexception.toString()).toString());
            }
            return abyte0;
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
                return engineGetEncoded();
            } else
            {
                return null;
            }
        }

        protected void engineInit(AlgorithmParameterSpec algorithmparameterspec)
        {
            if (!(algorithmparameterspec instanceof PBEParameterSpec))
            {
                throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF2 PBE parameters algorithm parameters object");
            } else
            {
                algorithmparameterspec = (PBEParameterSpec)algorithmparameterspec;
                aFy = new PBKDF2Params(algorithmparameterspec.getSalt(), algorithmparameterspec.getIterationCount());
                return;
            }
        }

        protected void engineInit(byte abyte0[])
        {
            aFy = PBKDF2Params._mth02CD(ASN1Primitive._mth0640(abyte0));
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
            if (flag)
            {
                engineInit(abyte0);
                return;
            } else
            {
                throw new IOException("Unknown parameters format in PBKDF2 parameters object");
            }
        }

        protected String engineToString()
        {
            return "PBKDF2 Parameters";
        }

        protected final AlgorithmParameterSpec _mth02C8(Class class1)
        {
            if (class1 == javax/crypto/spec/PBEParameterSpec)
            {
                return new PBEParameterSpec(aFy.aaS._mth0501(), (new BigInteger(aFy.aaT.bytes)).intValue());
            } else
            {
                throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF2 PBE parameters object.");
            }
        }

        public AlgParams()
        {
        }
    }

    public static class BasePBKDF2 extends BaseSecretKeyFactory
    {

        private int scheme;

        protected SecretKey engineGenerateSecret(KeySpec keyspec)
        {
            if (keyspec instanceof PBEKeySpec)
            {
                keyspec = (PBEKeySpec)keyspec;
                if (keyspec.getSalt() == null)
                {
                    throw new InvalidKeySpecException("missing required salt");
                }
                if (keyspec.getIterationCount() <= 0)
                {
                    throw new InvalidKeySpecException((new StringBuilder("positive iteration count required: ")).append(keyspec.getIterationCount()).toString());
                }
                if (keyspec.getKeyLength() <= 0)
                {
                    throw new InvalidKeySpecException((new StringBuilder("positive key length required: ")).append(keyspec.getKeyLength()).toString());
                }
                if (keyspec.getPassword().length == 0)
                {
                    throw new IllegalArgumentException("password empty");
                }
                if (keyspec instanceof PBKDF2KeySpec)
                {
                    Object obj = new ASN1ObjectIdentifier(((PBKDF2KeySpec)keyspec).aaU.ahP.identifier);
                    byte byte0;
                    if (((ASN1ObjectIdentifier) (obj)).equals(CryptoProObjectIdentifiers.XP))
                    {
                        byte0 = 6;
                    } else
                    if (((ASN1ObjectIdentifier) (obj)).equals(PKCSObjectIdentifiers.abD))
                    {
                        byte0 = 1;
                    } else
                    {
                        throw new InvalidKeySpecException((new StringBuilder("Invalid KeySpec: unknown PRF algorithm ")).append(obj).toString());
                    }
                    int j = keyspec.getKeyLength();
                    obj = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util._mth02CA(keyspec, scheme, byte0, j);
                    return new BCPBEKey(aFS, aFZ, scheme, byte0, j, -1, keyspec, ((org.spongycastle.crypto.CipherParameters) (obj)));
                } else
                {
                    int i = keyspec.getKeyLength();
                    org.spongycastle.crypto.CipherParameters cipherparameters = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util._mth02CA(keyspec, scheme, 1, i);
                    return new BCPBEKey(aFS, aFZ, scheme, 1, i, -1, keyspec, cipherparameters);
                }
            } else
            {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }

        public BasePBKDF2(String s, int i)
        {
            super(s, PKCSObjectIdentifiers.abu);
            scheme = 5;
        }
    }

    public static class Mappings extends AlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/PBEPBKDF2.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("AlgorithmParameters.PBKDF2", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(PKCSObjectIdentifiers.abu).toString(), "PBKDF2");
            configurableprovider._mth0640("SecretKeyFactory.PBKDF2", (new StringBuilder()).append(PREFIX).append("$PBKDF2withUTF8").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abu).toString(), "PBKDF2");
        }


        public Mappings()
        {
        }
    }

    public static class PBKDF2withUTF8 extends BasePBKDF2
    {

        public PBKDF2withUTF8()
        {
            super("PBKDF2", 5);
        }
    }


    private PBEPBKDF2()
    {
    }
}
