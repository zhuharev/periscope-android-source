// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;


// Referenced classes of package org.spongycastle.crypto:
//            CipherParameters

public interface Mac
{

    public abstract int doFinal(byte abyte0[], int i);

    public abstract void reset();

    public abstract void update(byte byte0);

    public abstract void update(byte abyte0[], int i, int j);

    public abstract void _mth02CA(CipherParameters cipherparameters);

    public abstract String _mth14AC();

    public abstract int _mth14B3();
}
