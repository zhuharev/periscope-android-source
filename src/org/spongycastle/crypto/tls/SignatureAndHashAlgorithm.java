// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils

public class SignatureAndHashAlgorithm
{

    private short aBq;
    private short aBr;

    public SignatureAndHashAlgorithm(short word0, short word1)
    {
        if (!TlsUtils._mth02BC(word0))
        {
            throw new IllegalArgumentException("'hash' should be a uint8");
        }
        if (!TlsUtils._mth02BC(word1))
        {
            throw new IllegalArgumentException("'signature' should be a uint8");
        }
        if (word1 == 0)
        {
            throw new IllegalArgumentException("'signature' MUST NOT be \"anonymous\"");
        } else
        {
            aBq = word0;
            aBr = word1;
            return;
        }
    }

    public static SignatureAndHashAlgorithm _mth02BB(InputStream inputstream)
    {
        return new SignatureAndHashAlgorithm(TlsUtils._mth02BD(inputstream), TlsUtils._mth02BD(inputstream));
    }

    public final void encode(OutputStream outputstream)
    {
        TlsUtils._mth02CA(aBq, outputstream);
        TlsUtils._mth02CA(aBr, outputstream);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof SignatureAndHashAlgorithm))
        {
            return false;
        }
        obj = (SignatureAndHashAlgorithm)obj;
        return ((SignatureAndHashAlgorithm) (obj)).aBq == aBq && ((SignatureAndHashAlgorithm) (obj)).aBr == aBr;
    }

    public int hashCode()
    {
        return aBq << 16 | aBr;
    }

    public final short _mth09AA()
    {
        return aBq;
    }

    public final short _mth09AF()
    {
        return aBr;
    }
}
