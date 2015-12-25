// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsPeer, ProtocolVersion, TlsKeyExchange, TlsCredentials, 
//            CertificateStatus, CertificateRequest, NewSessionTicket

public interface TlsServer
    extends TlsPeer
{

    public abstract ProtocolVersion _mth0455();

    public abstract TlsKeyExchange _mth0693();

    public abstract int _mth0E44();

    public abstract short _mth10C1();

    public abstract Hashtable _mth10EB();

    public abstract Vector _mth1435();

    public abstract TlsCredentials _mth1448();

    public abstract CertificateStatus _mth148F();

    public abstract CertificateRequest _mth14B0();

    public abstract NewSessionTicket _mth14B1();
}
