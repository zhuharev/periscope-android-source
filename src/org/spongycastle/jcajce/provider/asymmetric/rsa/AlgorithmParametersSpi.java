// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAESOAEPparams;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.util.DigestFactory;

public abstract class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi
{
    public static class OAEP extends AlgorithmParametersSpi
    {

        private OAEPParameterSpec aDO;

        protected byte[] engineGetEncoded()
        {
            IOException ioexception;
            Object obj = new AlgorithmIdentifier(DigestFactory._mth1422(aDO.getDigestAlgorithm()), DERNull.WL);
            Object obj1 = (MGF1ParameterSpec)aDO.getMGFParameters();
            obj1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.abd, new AlgorithmIdentifier(DigestFactory._mth1422(((MGF1ParameterSpec) (obj1)).getDigestAlgorithm()), DERNull.WL));
            javax.crypto.spec.PSource.PSpecified pspecified = (javax.crypto.spec.PSource.PSpecified)aDO.getPSource();
            obj = new RSAESOAEPparams(((AlgorithmIdentifier) (obj)), ((AlgorithmIdentifier) (obj1)), new AlgorithmIdentifier(PKCSObjectIdentifiers.abe, new DEROctetString(pspecified.getValue())));
            byte abyte0[];
            try
            {
                abyte0 = ((RSAESOAEPparams) (obj)).getEncoded("DER");
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                throw new RuntimeException("Error encoding OAEPParameters");
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
            if (flag || s.equalsIgnoreCase("X.509"))
            {
                return engineGetEncoded();
            } else
            {
                return null;
            }
        }

        protected void engineInit(AlgorithmParameterSpec algorithmparameterspec)
        {
            if (!(algorithmparameterspec instanceof OAEPParameterSpec))
            {
                throw new InvalidParameterSpecException("OAEPParameterSpec required to initialise an OAEP algorithm parameters object");
            } else
            {
                aDO = (OAEPParameterSpec)algorithmparameterspec;
                return;
            }
        }

        protected void engineInit(byte abyte0[])
        {
            try
            {
                abyte0 = RSAESOAEPparams._mth1D40(abyte0);
                aDO = new OAEPParameterSpec((new ASN1ObjectIdentifier(((RSAESOAEPparams) (abyte0)).adb.ahP.identifier)).identifier, (new ASN1ObjectIdentifier(((RSAESOAEPparams) (abyte0)).adc.ahP.identifier)).identifier, new MGF1ParameterSpec((new ASN1ObjectIdentifier(AlgorithmIdentifier._mth01C3(((RSAESOAEPparams) (abyte0)).adc.ahQ).ahP.identifier)).identifier), new javax.crypto.spec.PSource.PSpecified(ASN1OctetString.FB39(((RSAESOAEPparams) (abyte0)).add.ahQ)._mth0501()));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            }
        }

        protected void engineInit(byte abyte0[], String s)
        {
            if (s.equalsIgnoreCase("X.509") || s.equalsIgnoreCase("ASN.1"))
            {
                engineInit(abyte0);
                return;
            } else
            {
                throw new IOException((new StringBuilder("Unknown parameter format ")).append(s).toString());
            }
        }

        protected String engineToString()
        {
            return "OAEP Parameters";
        }

        protected final AlgorithmParameterSpec _mth02C8(Class class1)
        {
            if (class1 == javax/crypto/spec/OAEPParameterSpec && aDO != null)
            {
                return aDO;
            } else
            {
                throw new InvalidParameterSpecException("unknown parameter spec passed to OAEP parameters object.");
            }
        }

        public OAEP()
        {
        }
    }

    public static class PSS extends AlgorithmParametersSpi
    {

        private PSSParameterSpec aDP;

        protected byte[] engineGetEncoded()
        {
            PSSParameterSpec pssparameterspec = aDP;
            AlgorithmIdentifier algorithmidentifier = new AlgorithmIdentifier(DigestFactory._mth1422(pssparameterspec.getDigestAlgorithm()), DERNull.WL);
            MGF1ParameterSpec mgf1parameterspec = (MGF1ParameterSpec)pssparameterspec.getMGFParameters();
            return (new RSASSAPSSparams(algorithmidentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.abd, new AlgorithmIdentifier(DigestFactory._mth1422(mgf1parameterspec.getDigestAlgorithm()), DERNull.WL)), new ASN1Integer(pssparameterspec.getSaltLength()), new ASN1Integer(pssparameterspec.getTrailerField()))).getEncoded("DER");
        }

        protected byte[] engineGetEncoded(String s)
        {
            if (s.equalsIgnoreCase("X.509") || s.equalsIgnoreCase("ASN.1"))
            {
                return engineGetEncoded();
            } else
            {
                return null;
            }
        }

        protected void engineInit(AlgorithmParameterSpec algorithmparameterspec)
        {
            if (!(algorithmparameterspec instanceof PSSParameterSpec))
            {
                throw new InvalidParameterSpecException("PSSParameterSpec required to initialise an PSS algorithm parameters object");
            } else
            {
                aDP = (PSSParameterSpec)algorithmparameterspec;
                return;
            }
        }

        protected void engineInit(byte abyte0[])
        {
            try
            {
                abyte0 = RSASSAPSSparams._mth1D57(abyte0);
                aDP = new PSSParameterSpec((new ASN1ObjectIdentifier(((RSASSAPSSparams) (abyte0)).adb.ahP.identifier)).identifier, (new ASN1ObjectIdentifier(((RSASSAPSSparams) (abyte0)).adc.ahP.identifier)).identifier, new MGF1ParameterSpec((new ASN1ObjectIdentifier(AlgorithmIdentifier._mth01C3(((RSASSAPSSparams) (abyte0)).adc.ahQ).ahP.identifier)).identifier), (new BigInteger(((RSASSAPSSparams) (abyte0)).adr.bytes)).intValue(), (new BigInteger(((RSASSAPSSparams) (abyte0)).ads.bytes)).intValue());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new IOException("Not a valid PSS Parameter encoding.");
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new IOException("Not a valid PSS Parameter encoding.");
            }
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
            if (flag || s.equalsIgnoreCase("X.509"))
            {
                engineInit(abyte0);
                return;
            } else
            {
                throw new IOException((new StringBuilder("Unknown parameter format ")).append(s).toString());
            }
        }

        protected String engineToString()
        {
            return "PSS Parameters";
        }

        protected final AlgorithmParameterSpec _mth02C8(Class class1)
        {
            if (class1 == java/security/spec/PSSParameterSpec && aDP != null)
            {
                return aDP;
            } else
            {
                throw new InvalidParameterSpecException("unknown parameter spec passed to PSS parameters object.");
            }
        }

        public PSS()
        {
        }
    }


    public AlgorithmParametersSpi()
    {
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class class1)
    {
        if (class1 == null)
        {
            throw new NullPointerException("argument to getParameterSpec must not be null");
        } else
        {
            return _mth02C8(class1);
        }
    }

    protected abstract AlgorithmParameterSpec _mth02C8(Class class1);
}
