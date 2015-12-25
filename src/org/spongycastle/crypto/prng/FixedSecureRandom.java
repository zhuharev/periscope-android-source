// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;

import java.security.SecureRandom;

public class FixedSecureRandom extends SecureRandom
{

    private int axT;
    private int axU;

    public byte[] generateSeed(int i)
    {
        byte abyte0[] = new byte[i];
        nextBytes(abyte0);
        return abyte0;
    }

    public void nextBytes(byte abyte0[])
    {
        System.arraycopy(null, axT, abyte0, 0, abyte0.length);
        axT = axT + abyte0.length;
    }

    public int nextInt()
    {
        axT = axT + 1;
        throw new NullPointerException();
    }

    public long nextLong()
    {
        axT = axT + 1;
        throw new NullPointerException();
    }
}
