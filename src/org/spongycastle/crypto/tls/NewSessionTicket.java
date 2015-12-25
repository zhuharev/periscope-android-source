// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils

public class NewSessionTicket
{

    private long aAD;
    private byte aAE[];

    private NewSessionTicket(long l, byte abyte0[])
    {
        aAD = l;
        aAE = abyte0;
    }

    public static NewSessionTicket _mth02BB(ByteArrayInputStream bytearrayinputstream)
    {
        return new NewSessionTicket(TlsUtils._mth02BE(bytearrayinputstream), TlsUtils._mth02C8(bytearrayinputstream));
    }

    public final void _mth02CA(TlsProtocol.HandshakeMessage handshakemessage)
    {
        TlsUtils._mth02CA(aAD, handshakemessage);
        TlsUtils._mth02CE(aAE, handshakemessage);
    }
}
