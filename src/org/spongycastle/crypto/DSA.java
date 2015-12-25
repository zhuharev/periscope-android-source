// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto:
//            CipherParameters

public interface DSA
{

    public abstract void _mth02CA(boolean flag, CipherParameters cipherparameters);

    public abstract boolean _mth02CA(byte abyte0[], BigInteger biginteger, BigInteger biginteger1);

    public abstract BigInteger[] _mth1428(byte abyte0[]);
}
