// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.util.Vector;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils

public class Certificate
{

    public static final Certificate azN = new Certificate(new org.spongycastle.asn1.x509.Certificate[0]);
    private org.spongycastle.asn1.x509.Certificate azO[];

    private Certificate(org.spongycastle.asn1.x509.Certificate acertificate[])
    {
        azO = acertificate;
    }

    public static Certificate _mth02CF(ByteArrayInputStream bytearrayinputstream)
    {
        int i = TlsUtils._mth1FBE(bytearrayinputstream);
        if (i == 0)
        {
            return azN;
        }
        ByteArrayInputStream bytearrayinputstream1 = new ByteArrayInputStream(TlsUtils._mth02CF(i, bytearrayinputstream));
        bytearrayinputstream = new Vector();
        for (; bytearrayinputstream1.available() > 0; bytearrayinputstream.addElement(org.spongycastle.asn1.x509.Certificate._mth02B2(TlsUtils._mth1D38(TlsUtils._mth02C9(bytearrayinputstream1))))) { }
        org.spongycastle.asn1.x509.Certificate acertificate[] = new org.spongycastle.asn1.x509.Certificate[bytearrayinputstream.size()];
        for (int j = 0; j < bytearrayinputstream.size(); j++)
        {
            acertificate[j] = (org.spongycastle.asn1.x509.Certificate)bytearrayinputstream.elementAt(j);
        }

        return new Certificate(acertificate);
    }

    public final int getLength()
    {
        return azO.length;
    }

    public final boolean isEmpty()
    {
        return azO.length == 0;
    }

    public final org.spongycastle.asn1.x509.Certificate _mth0130(int i)
    {
        return azO[0];
    }

    public final void _mth02CA(TlsProtocol.HandshakeMessage handshakemessage)
    {
        Vector vector = new Vector(azO.length);
        int k = 0;
        for (int i = 0; i < azO.length; i++)
        {
            byte abyte0[] = azO[i].getEncoded("DER");
            vector.addElement(abyte0);
            k += abyte0.length + 3;
        }

        TlsUtils._mth05E0(k);
        TlsUtils._mth141D(k, handshakemessage);
        for (int j = 0; j < vector.size(); j++)
        {
            TlsUtils._mth02CF((byte[])vector.elementAt(j), handshakemessage);
        }

    }

    public final org.spongycastle.asn1.x509.Certificate[] _mth0534()
    {
        org.spongycastle.asn1.x509.Certificate acertificate[] = new org.spongycastle.asn1.x509.Certificate[azO.length];
        System.arraycopy(azO, 0, acertificate, 0, acertificate.length);
        return acertificate;
    }

}
