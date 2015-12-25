// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class ParametersWithIV
    implements CipherParameters
{

    public CipherParameters axC;
    public byte iv[];

    public ParametersWithIV(CipherParameters cipherparameters, byte abyte0[])
    {
        this(cipherparameters, abyte0, 0, abyte0.length);
    }

    public ParametersWithIV(CipherParameters cipherparameters, byte abyte0[], int i, int j)
    {
        iv = new byte[j];
        axC = cipherparameters;
        System.arraycopy(abyte0, i, iv, 0, j);
    }
}
