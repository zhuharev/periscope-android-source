// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils, SignatureAndHashAlgorithm, TlsContext

public class DigitallySigned
{

    private SignatureAndHashAlgorithm aAA;
    private byte aAB[];

    public DigitallySigned(SignatureAndHashAlgorithm signatureandhashalgorithm, byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("'signature' cannot be null");
        } else
        {
            aAA = signatureandhashalgorithm;
            aAB = abyte0;
            return;
        }
    }

    public static DigitallySigned _mth02CA(TlsContext tlscontext, InputStream inputstream)
    {
        SignatureAndHashAlgorithm signatureandhashalgorithm = null;
        if (TlsUtils._mth02CF(tlscontext))
        {
            signatureandhashalgorithm = SignatureAndHashAlgorithm._mth02BB(inputstream);
        }
        return new DigitallySigned(signatureandhashalgorithm, TlsUtils._mth02C8(inputstream));
    }

    public final byte[] getSignature()
    {
        return aAB;
    }

    public final void _mth02CB(ByteArrayOutputStream bytearrayoutputstream)
    {
        if (aAA != null)
        {
            SignatureAndHashAlgorithm signatureandhashalgorithm = aAA;
            TlsUtils._mth02CA(signatureandhashalgorithm._mth09AA(), bytearrayoutputstream);
            TlsUtils._mth02CA(signatureandhashalgorithm._mth09AF(), bytearrayoutputstream);
        }
        TlsUtils._mth02CE(aAB, bytearrayoutputstream);
    }

    public final SignatureAndHashAlgorithm _mth072B()
    {
        return aAA;
    }
}
