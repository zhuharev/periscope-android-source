// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class RC2Parameters
    implements CipherParameters
{

    public int axD;
    public byte key[];

    public RC2Parameters(byte abyte0[], int i)
    {
        key = new byte[abyte0.length];
        axD = i;
        System.arraycopy(abyte0, 0, key, 0, abyte0.length);
    }
}
