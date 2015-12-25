// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.misc.CAST5CBCParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            CAST5

public static class aFt extends BaseAlgorithmParameters
{

    private int aFt;
    private byte iv[];

    protected byte[] engineGetEncoded()
    {
        byte abyte0[] = new byte[iv.length];
        System.arraycopy(iv, 0, abyte0, 0, iv.length);
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
            return (new CAST5CBCParameters(engineGetEncoded(), aFt)).getEncoded();
        }
        if (s.equals("RAW"))
        {
            return engineGetEncoded();
        } else
        {
            return null;
        }
    }

    protected void engineInit(AlgorithmParameterSpec algorithmparameterspec)
    {
        if (algorithmparameterspec instanceof IvParameterSpec)
        {
            iv = ((IvParameterSpec)algorithmparameterspec).getIV();
            return;
        } else
        {
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a CAST5 parameters algorithm parameters object");
        }
    }

    protected void engineInit(byte abyte0[])
    {
        iv = new byte[abyte0.length];
        System.arraycopy(abyte0, 0, iv, 0, iv.length);
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
            abyte0 = CAST5CBCParameters._mth02CE((new ASN1InputStream(abyte0))._mth04B7());
            aFt = (new BigInteger(((CAST5CBCParameters) (abyte0)).Zt.bytes)).intValue();
            iv = ((CAST5CBCParameters) (abyte0)).Yk._mth0501();
            return;
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

    protected String engineToString()
    {
        return "CAST5 Parameters";
    }

    protected final AlgorithmParameterSpec _mth02C8(Class class1)
    {
        if (class1 == javax/crypto/spec/IvParameterSpec)
        {
            return new IvParameterSpec(iv);
        } else
        {
            throw new InvalidParameterSpecException("unknown parameter spec passed to CAST5 parameters object.");
        }
    }

    public hmParameters()
    {
        aFt = 128;
    }
}
