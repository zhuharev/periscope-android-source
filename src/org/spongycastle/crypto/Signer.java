// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;


// Referenced classes of package org.spongycastle.crypto:
//            CipherParameters

public interface Signer
{

    public abstract void update(byte byte0);

    public abstract void update(byte abyte0[], int i, int j);

    public abstract void _mth02CA(boolean flag, CipherParameters cipherparameters);

    public abstract byte[] _mth14B6();

    public abstract boolean FE73(byte abyte0[]);
}
