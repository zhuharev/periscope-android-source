// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsSigner, TlsContext

public abstract class AbstractTlsSigner
    implements TlsSigner
{

    protected TlsContext azJ;

    public AbstractTlsSigner()
    {
    }

    public final void _mth02CA(TlsContext tlscontext)
    {
        azJ = tlscontext;
    }

    public final byte[] _mth02CA(AsymmetricKeyParameter asymmetrickeyparameter, byte abyte0[])
    {
        return _mth02CA(null, asymmetrickeyparameter, abyte0);
    }
}
