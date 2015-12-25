// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.pkcs.DHParameter;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi
{

    private DHParameterSpec aCG;

    public AlgorithmParametersSpi()
    {
    }

    protected byte[] engineGetEncoded()
    {
        IOException ioexception;
        DHParameter dhparameter = new DHParameter(aCG.getP(), aCG.getG(), aCG.getL());
        byte abyte0[];
        try
        {
            abyte0 = dhparameter.getEncoded("DER");
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            throw new RuntimeException("Error encoding DHParameters");
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

    protected AlgorithmParameterSpec engineGetParameterSpec(Class class1)
    {
        if (class1 == null)
        {
            throw new NullPointerException("argument to getParameterSpec must not be null");
        }
        if (class1 == javax/crypto/spec/DHParameterSpec)
        {
            return aCG;
        } else
        {
            throw new InvalidParameterSpecException("unknown parameter spec passed to DH parameters object.");
        }
    }

    protected void engineInit(AlgorithmParameterSpec algorithmparameterspec)
    {
        if (!(algorithmparameterspec instanceof DHParameterSpec))
        {
            throw new InvalidParameterSpecException("DHParameterSpec required to initialise a Diffie-Hellman algorithm parameters object");
        } else
        {
            aCG = (DHParameterSpec)algorithmparameterspec;
            return;
        }
    }

    protected void engineInit(byte abyte0[])
    {
        DHParameter dhparameter = DHParameter._mth15EE(abyte0);
        BigInteger biginteger;
        BigInteger biginteger1;
        if (dhparameter.aaI == null)
        {
            abyte0 = null;
        } else
        {
            try
            {
                abyte0 = new BigInteger(1, dhparameter.aaI.bytes);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new IOException("Not a valid DH Parameter encoding.");
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new IOException("Not a valid DH Parameter encoding.");
            }
        }
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        biginteger = new BigInteger(1, dhparameter.Yq.bytes);
        biginteger1 = new BigInteger(1, dhparameter.aat.bytes);
        if (dhparameter.aaI == null)
        {
            abyte0 = null;
            break MISSING_BLOCK_LABEL_98;
        }
        abyte0 = new BigInteger(1, dhparameter.aaI.bytes);
        aCG = new DHParameterSpec(biginteger, biginteger1, abyte0.intValue());
        return;
        aCG = new DHParameterSpec(new BigInteger(1, dhparameter.Yq.bytes), new BigInteger(1, dhparameter.aat.bytes));
        return;
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
            throw new IOException((new StringBuilder("Unknown parameter format ")).append(s).toString());
        }
    }

    protected String engineToString()
    {
        return "Diffie-Hellman Parameters";
    }
}
