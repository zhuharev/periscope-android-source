// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            BaseAlgorithmParameters

public class IvAlgorithmParameters extends BaseAlgorithmParameters
{

    private byte iv[];

    public IvAlgorithmParameters()
    {
    }

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
            return (new DEROctetString(engineGetEncoded("RAW"))).getEncoded();
        }
        if (s.equals("RAW"))
        {
            return Arrays._mth1D4C(iv);
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
        byte abyte1[] = abyte0;
        if (abyte0.length % 8 != 0)
        {
            abyte1 = abyte0;
            if (abyte0[0] == 4)
            {
                abyte1 = abyte0;
                if (abyte0[1] == abyte0.length - 2)
                {
                    abyte1 = ((ASN1OctetString)ASN1Primitive._mth0640(abyte0))._mth0501();
                }
            }
        }
        iv = Arrays._mth1D4C(abyte1);
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
            try
            {
                engineInit(((ASN1OctetString)ASN1Primitive._mth0640(abyte0))._mth0501());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new IOException((new StringBuilder("Exception decoding: ")).append(abyte0).toString());
            }
        }
        if (s.equals("RAW"))
        {
            engineInit(abyte0);
            return;
        } else
        {
            throw new IOException("Unknown parameters format in IV parameters object");
        }
    }

    public String engineToString()
    {
        return "IV Parameters";
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
}
