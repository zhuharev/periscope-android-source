// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            BaseBlockCipher

static interface 
{

    public abstract int doFinal(byte abyte0[], int i);

    public abstract int getOutputSize(int i);

    public abstract void updateAAD(byte abyte0[], int i, int j);

    public abstract void _mth02CA(boolean flag, CipherParameters cipherparameters);

    public abstract int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k);

    public abstract BlockCipher _mth14AD();

    public abstract int _mth1550(int i);

    public abstract boolean _mth1D09();
}
