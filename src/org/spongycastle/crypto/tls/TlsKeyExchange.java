// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;

// Referenced classes of package org.spongycastle.crypto.tls:
//            Certificate, CertificateRequest, TlsContext, TlsCredentials

public interface TlsKeyExchange
{

    public abstract void _mth02CA(Certificate certificate);

    public abstract void _mth02CA(CertificateRequest certificaterequest);

    public abstract void _mth02CA(TlsContext tlscontext);

    public abstract void _mth02CA(TlsCredentials tlscredentials);

    public abstract void _mth02CB(ByteArrayInputStream bytearrayinputstream);

    public abstract void _mth02CB(TlsProtocol.HandshakeMessage handshakemessage);

    public abstract void _mth02CE(ByteArrayInputStream bytearrayinputstream);

    public abstract byte[] _mth04ED();

    public abstract void _mth04F1();

    public abstract void _mth09F0();

    public abstract byte[] _mth0E04();
}
