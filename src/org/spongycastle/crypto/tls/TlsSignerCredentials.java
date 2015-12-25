// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;


// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsCredentials, SignatureAndHashAlgorithm

public interface TlsSignerCredentials
    extends TlsCredentials
{

    public abstract SignatureAndHashAlgorithm _mth050F();

    public abstract byte[] _mth15EE(byte abyte0[]);
}
