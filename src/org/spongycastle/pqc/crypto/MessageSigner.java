// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto;

import org.spongycastle.crypto.CipherParameters;

public interface MessageSigner
{

    public abstract byte[] _mth02B2(byte abyte0[]);

    public abstract boolean _mth02C9(byte abyte0[], byte abyte1[]);

    public abstract void _mth02CA(boolean flag, CipherParameters cipherparameters);
}
