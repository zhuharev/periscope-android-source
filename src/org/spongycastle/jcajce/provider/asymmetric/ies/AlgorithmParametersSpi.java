// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ies;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.Arrays;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi
{

    private IESParameterSpec aDK;

    public AlgorithmParametersSpi()
    {
    }

    protected byte[] engineGetEncoded()
    {
        IOException ioexception;
        byte abyte0[];
        try
        {
            ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
            Object obj = new DEROctetString(Arrays._mth1D4C(aDK.axp));
            asn1encodablevector.VS.addElement(obj);
            obj = new DEROctetString(Arrays._mth1D4C(aDK.axq));
            asn1encodablevector.VS.addElement(obj);
            obj = new ASN1Integer(aDK.axr);
            asn1encodablevector.VS.addElement(obj);
            abyte0 = (new DERSequence(asn1encodablevector)).getEncoded("DER");
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            throw new RuntimeException("Error encoding IESParameters");
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

    protected AlgorithmParameterSpec engineGetParameterSpec(Class class1)
    {
        if (class1 == null)
        {
            throw new NullPointerException("argument to getParameterSpec must not be null");
        }
        if (class1 == org/spongycastle/jce/spec/IESParameterSpec)
        {
            return aDK;
        } else
        {
            throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
        }
    }

    protected void engineInit(AlgorithmParameterSpec algorithmparameterspec)
    {
        if (!(algorithmparameterspec instanceof IESParameterSpec))
        {
            throw new InvalidParameterSpecException("IESParameterSpec required to initialise a IES algorithm parameters object");
        } else
        {
            aDK = (IESParameterSpec)algorithmparameterspec;
            return;
        }
    }

    protected void engineInit(byte abyte0[])
    {
        try
        {
            abyte0 = (ASN1Sequence)ASN1Primitive._mth0640(abyte0);
            aDK = new IESParameterSpec(((ASN1OctetString)abyte0._mth144B(0))._mth0501(), ((ASN1OctetString)abyte0._mth144B(0))._mth0501(), (new BigInteger(((ASN1Integer)abyte0._mth144B(0)).bytes)).intValue());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IOException("Not a valid IES Parameter encoding.");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IOException("Not a valid IES Parameter encoding.");
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
        return "IES Parameters";
    }
}
