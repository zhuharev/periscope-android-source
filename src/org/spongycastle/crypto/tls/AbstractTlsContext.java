// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.security.SecureRandom;
import org.spongycastle.crypto.prng.RandomGenerator;
import org.spongycastle.util.Times;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsContext, ProtocolVersion, SecurityParameters

abstract class AbstractTlsContext
    implements TlsContext
{

    ProtocolVersion azF;
    ProtocolVersion azG;

    public final RandomGenerator _mth03CB()
    {
        return null;
    }

    public final SecureRandom _mth03D2()
    {
        return null;
    }

    public final SecurityParameters _mth03DC()
    {
        return null;
    }

    public final ProtocolVersion _mth043A()
    {
        return azF;
    }

    public final ProtocolVersion _mth0455()
    {
        return azG;
    }

    static 
    {
        Times.nanoTime();
    }
}
