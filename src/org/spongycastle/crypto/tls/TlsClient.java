// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsPeer, ProtocolVersion, TlsKeyExchange, LegacyTlsAuthentication

public interface TlsClient
    extends TlsPeer
{

    public abstract void _mth02CA(Vector vector);

    public abstract void _mth02CA(ProtocolVersion protocolversion);

    public abstract void _mth037A(Hashtable hashtable);

    public abstract TlsKeyExchange _mth0693();

    public abstract LegacyTlsAuthentication _mth091F();
}
