// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;


// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsPeer, TlsFatalAlert

public abstract class AbstractTlsPeer
    implements TlsPeer
{

    public AbstractTlsPeer()
    {
    }

    public final void _mth0E40(boolean flag)
    {
        if (!flag)
        {
            throw new TlsFatalAlert((short)40);
        } else
        {
            return;
        }
    }
}
