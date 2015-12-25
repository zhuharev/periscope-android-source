// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;

public interface AEADBlockCipher
{

    public abstract int doFinal(byte abyte0[], int i);

    public abstract int getOutputSize(int i);

    public abstract void _mth02CA(boolean flag, CipherParameters cipherparameters);

    public abstract int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k);

    public abstract void _mth1428(byte abyte0[], int i, int j);

    public abstract BlockCipher _mth14AD();

    public abstract int _mth1550(int i);
}
