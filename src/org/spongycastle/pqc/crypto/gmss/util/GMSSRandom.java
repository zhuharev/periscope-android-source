// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss.util;

import org.spongycastle.crypto.Digest;

public class GMSSRandom
{

    private Digest aLs;

    public GMSSRandom(Digest digest)
    {
        aLs = digest;
    }

    private static void _mth02CD(byte abyte0[], byte abyte1[])
    {
        int j = 0;
        for (int i = 0; i < abyte0.length; i++)
        {
            j += (abyte0[i] & 0xff) + (abyte1[i] & 0xff);
            abyte0[i] = (byte)j;
            j = (byte)(j >> 8);
        }

    }

    private static void _mth02E3(byte abyte0[])
    {
        int j = 1;
        for (int i = 0; i < abyte0.length; i++)
        {
            j += abyte0[i] & 0xff;
            abyte0[i] = (byte)j;
            j = (byte)(j >> 8);
        }

    }

    public final byte[] _mth02D0(byte abyte0[])
    {
        aLs.update(abyte0, 0, abyte0.length);
        byte abyte1[] = new byte[aLs._mth14AF()];
        aLs.doFinal(abyte1, 0);
        _mth02CD(abyte0, abyte1);
        _mth02E3(abyte0);
        return abyte1;
    }
}
