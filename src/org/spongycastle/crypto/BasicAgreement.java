// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto:
//            CipherParameters

public interface BasicAgreement
{

    public abstract int getFieldSize();

    public abstract void _mth02CA(CipherParameters cipherparameters);

    public abstract BigInteger _mth02CB(CipherParameters cipherparameters);
}
