// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsSession, SessionParameters

class TlsSessionImpl
    implements TlsSession
{

    private SessionParameters aAa;
    private byte aCv[];

    TlsSessionImpl(byte abyte0[], SessionParameters sessionparameters)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("'sessionID' cannot be null");
        }
        if (abyte0.length <= 0 || abyte0.length > 32)
        {
            throw new IllegalArgumentException("'sessionID' must have length between 1 and 32 bytes, inclusive");
        } else
        {
            aCv = Arrays._mth1D4C(abyte0);
            aAa = null;
            return;
        }
    }

    public final void invalidate()
    {
        this;
        JVM INSTR monitorenter ;
        if (aAa != null)
        {
            SessionParameters sessionparameters = aAa;
            aAa = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final byte[] _mth14B4()
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[] = aCv;
        this;
        JVM INSTR monitorexit ;
        return abyte0;
        Exception exception;
        exception;
        throw exception;
    }
}
