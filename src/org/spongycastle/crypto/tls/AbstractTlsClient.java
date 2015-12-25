// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsPeer, TlsClient, DefaultTlsCipherFactory, TlsFatalAlert, 
//            ProtocolVersion, TlsUtils, TlsECCUtils, TlsNullCompression, 
//            TlsCipherFactory

public abstract class AbstractTlsClient extends AbstractTlsPeer
    implements TlsClient
{

    protected TlsCipherFactory azB;
    protected short azC[];
    protected int azD;
    private short azE;

    public AbstractTlsClient()
    {
        this(new DefaultTlsCipherFactory());
    }

    private AbstractTlsClient(DefaultTlsCipherFactory defaulttlscipherfactory)
    {
        azB = defaulttlscipherfactory;
    }

    public final void _mth02CA(Vector vector)
    {
        if (vector != null)
        {
            throw new TlsFatalAlert((short)10);
        } else
        {
            return;
        }
    }

    public final void _mth02CA(ProtocolVersion protocolversion)
    {
        if (!ProtocolVersion.aAG._mth02CB(protocolversion))
        {
            throw new TlsFatalAlert((short)70);
        } else
        {
            return;
        }
    }

    public final void _mth037A(Hashtable hashtable)
    {
        if (hashtable != null)
        {
            if (hashtable.containsKey(TlsUtils.aCz))
            {
                throw new TlsFatalAlert((short)47);
            }
            if (TlsECCUtils._mth1FBE(hashtable) != null)
            {
                throw new TlsFatalAlert((short)47);
            }
            azC = TlsECCUtils._mth02BE(hashtable);
            if (azC != null && !TlsECCUtils._mth03CA(azD))
            {
                throw new TlsFatalAlert((short)47);
            }
        }
    }

    public final TlsNullCompression _mth03BB()
    {
        switch (azE)
        {
        case 0: // '\0'
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert((short)80);
    }
}
