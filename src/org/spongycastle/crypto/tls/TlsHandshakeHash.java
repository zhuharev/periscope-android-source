// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;

public interface TlsHandshakeHash
    extends Digest
{

    public abstract void _mth02CB(short word0);

    public abstract byte[] _mth02CE(short word0);

    public abstract TlsHandshakeHash _mth05E1();

    public abstract void _mth05E3();

    public abstract TlsHandshakeHash _mth062A();

    public abstract Digest _mth067A();
}
