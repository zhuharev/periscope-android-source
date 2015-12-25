// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.misc.IDEACBCPar;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            IDEA

public static class thmParameters extends BaseAlgorithmParameters
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

    public thmParameters()
    {
    }
}
