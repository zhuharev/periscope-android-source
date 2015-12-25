// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;


// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsCipherFactory, TlsFatalAlert, TlsClientContext, TlsCipher

public class AbstractTlsCipherFactory
    implements TlsCipherFactory
{

    public AbstractTlsCipherFactory()
    {
    }

    public TlsCipher _mth02CA(TlsClientContext tlsclientcontext, int i, int j)
    {
        throw new TlsFatalAlert((short)80);
    }
}
