// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsProtocol, TlsUtils

class count extends ByteArrayOutputStream
{

    private TlsProtocol aCr;

    final void _mth0E42()
    {
        int i = count - 4;
        TlsUtils._mth05E0(i);
        TlsUtils._mth02BD(i, buf, 1);
        aCr._mth1D54(buf, 0, count);
        buf = null;
    }

    (TlsProtocol tlsprotocol, short word0)
    {
        this(tlsprotocol, word0, 60);
    }

    <init>(TlsProtocol tlsprotocol, short word0, int i)
    {
        aCr = tlsprotocol;
        super(i + 4);
        TlsUtils._mth02CA(word0, this);
        count = count + 3;
    }
}
