// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAESOAEPparams;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.util.DigestFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.rsa:
//            AlgorithmParametersSpi

public static class Q extends AlgorithmParametersSpi
{

    private OAEPParameterSpec aDO;

    protected byte[] engineGetEncoded()
    {
        IOException ioexception;
        Object obj = new AlgorithmIdentifier(DigestFactory._mth1422(aDO.getDigestAlgorithm()), DERNull.WL);
        Object obj1 = (MGF1ParameterSpec)aDO.getMGFParameters();
        obj1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.abd, new AlgorithmIdentifier(DigestFactory._mth1422(((MGF1ParameterSpec) (obj1)).getDigestAlgorithm()), DERNull.WL));
        javax.crypto.spec.  = (javax.crypto.spec.Algorithm)aDO.getPSource();
        obj = new RSAESOAEPparams(((AlgorithmIdentifier) (obj)), ((AlgorithmIdentifier) (obj1)), new AlgorithmIdentifier(PKCSObjectIdentifiers.abe, new DEROctetString(.abe())));
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
            aDO = new OAEPParameterSpec((new ASN1ObjectIdentifier(((RSAESOAEPparams) (abyte0)).adb.ahP.identifier)).identifier, (new ASN1ObjectIdentifier(((RSAESOAEPparams) (abyte0)).adc.ahP.identifier)).identifier, new MGF1ParameterSpec((new ASN1ObjectIdentifier(AlgorithmIdentifier._mth01C3(((RSAESOAEPparams) (abyte0)).adc.ahQ).ahP.identifier)).identifier), new javax.crypto.spec.ntifier(ASN1OctetString.FB39(((RSAESOAEPparams) (abyte0)).add.ahQ)._mth0501()));
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

    public Q()
    {
    }
}
