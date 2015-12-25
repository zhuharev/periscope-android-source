// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import org.spongycastle.asn1.ocsp.OCSPResponse;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils, TlsFatalAlert

public class CertificateStatus
{

    private short azR;
    private Object azS;

    private CertificateStatus(short word0, OCSPResponse ocspresponse)
    {
        boolean flag;
        switch (word0)
        {
        case 1: // '\001'
            flag = ocspresponse instanceof OCSPResponse;
            break;

        default:
            throw new IllegalArgumentException("'statusType' is an unsupported value");
        }
        if (!flag)
        {
            throw new IllegalArgumentException("'response' is not an instance of the correct type");
        } else
        {
            azR = word0;
            azS = ocspresponse;
            return;
        }
    }

    public static CertificateStatus _mth141D(ByteArrayInputStream bytearrayinputstream)
    {
        short word0 = TlsUtils._mth02BD(bytearrayinputstream);
        switch (word0)
        {
        case 1: // '\001'
            bytearrayinputstream = OCSPResponse._mth02CF(TlsUtils._mth1D38(TlsUtils._mth02C9(bytearrayinputstream)));
            break;

        default:
            throw new TlsFatalAlert((short)50);
        }
        return new CertificateStatus(word0, bytearrayinputstream);
    }

    public final void _mth02CA(TlsProtocol.HandshakeMessage handshakemessage)
    {
        TlsUtils._mth02CA(azR, handshakemessage);
        switch (azR)
        {
        case 1: // '\001'
            TlsUtils._mth02CF(((OCSPResponse)azS).getEncoded("DER"), handshakemessage);
            return;
        }
        throw new TlsFatalAlert((short)80);
    }
}
