// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.util.Vector;
import org.spongycastle.asn1.x500.X500Name;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils, AbstractTlsContext

public class CertificateRequest
{

    private Vector azI;
    private short azP[];
    private Vector azQ;

    private CertificateRequest(short aword0[], Vector vector, Vector vector1)
    {
        azP = aword0;
        azI = vector;
        azQ = vector1;
    }

    public static CertificateRequest _mth02CA(AbstractTlsContext abstracttlscontext, ByteArrayInputStream bytearrayinputstream)
    {
        short word0 = TlsUtils._mth02BD(bytearrayinputstream);
        short aword0[] = new short[word0];
        for (int i = 0; i < word0; i++)
        {
            aword0[i] = TlsUtils._mth02BD(bytearrayinputstream);
        }

        Vector vector = null;
        if (TlsUtils._mth02CF(abstracttlscontext))
        {
            vector = TlsUtils._mth02CA(false, bytearrayinputstream);
        }
        abstracttlscontext = new Vector();
        for (bytearrayinputstream = new ByteArrayInputStream(TlsUtils._mth02C8(bytearrayinputstream)); bytearrayinputstream.available() > 0; abstracttlscontext.addElement(X500Name._mth0131(TlsUtils._mth1D38(TlsUtils._mth02C8(bytearrayinputstream))))) { }
        return new CertificateRequest(aword0, vector, abstracttlscontext);
    }

    public final void _mth02CA(TlsProtocol.HandshakeMessage handshakemessage)
    {
        if (azP == null || azP.length == 0)
        {
            TlsUtils._mth02CE(0, handshakemessage);
        } else
        {
            TlsUtils._mth02CA(azP, handshakemessage);
        }
        if (azI != null)
        {
            TlsUtils._mth02CA(azI, false, handshakemessage);
        }
        if (azQ == null || azQ.isEmpty())
        {
            TlsUtils._mth02CF(0, handshakemessage);
            return;
        }
        Vector vector = new Vector(azQ.size());
        int k = 0;
        for (int i = 0; i < azQ.size(); i++)
        {
            byte abyte0[] = ((X500Name)azQ.elementAt(i)).getEncoded("DER");
            vector.addElement(abyte0);
            k += abyte0.length + 2;
        }

        TlsUtils._mth05DF(k);
        TlsUtils._mth02CF(k, handshakemessage);
        for (int j = 0; j < vector.size(); j++)
        {
            TlsUtils._mth02CE((byte[])vector.elementAt(j), handshakemessage);
        }

    }

    public final short[] _mth0579()
    {
        return azP;
    }

    public final Vector _mth05D8()
    {
        return azI;
    }
}
