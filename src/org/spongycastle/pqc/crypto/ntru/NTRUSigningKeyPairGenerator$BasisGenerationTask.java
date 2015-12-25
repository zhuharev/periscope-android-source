// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import java.util.concurrent.Callable;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUSigningKeyPairGenerator

class <init>
    implements Callable
{

    private NTRUSigningKeyPairGenerator aNk;

    public Object call()
    {
        NTRUSigningKeyPairGenerator ntrusigningkeypairgenerator = aNk;
        throw new NullPointerException();
    }

    private (NTRUSigningKeyPairGenerator ntrusigningkeypairgenerator)
    {
        aNk = ntrusigningkeypairgenerator;
        super();
    }

    aNk(NTRUSigningKeyPairGenerator ntrusigningkeypairgenerator, byte byte0)
    {
        this(ntrusigningkeypairgenerator);
    }
}
