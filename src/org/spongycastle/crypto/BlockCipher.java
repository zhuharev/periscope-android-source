// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;


// Referenced classes of package org.spongycastle.crypto:
//            CipherParameters

public interface BlockCipher
{

    public abstract int getBlockSize();

    public abstract void reset();

    public abstract int _mth02CA(byte abyte0[], int i, byte abyte1[], int j);

    public abstract void _mth02CA(boolean flag, CipherParameters cipherparameters);

    public abstract String _mth14AC();
}
