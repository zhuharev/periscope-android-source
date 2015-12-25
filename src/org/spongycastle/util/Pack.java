// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util;


public abstract class Pack
{

    public Pack()
    {
    }

    public static int _mth02B3(byte abyte0[], int i)
    {
        byte byte0 = abyte0[i];
        int j = i + 1;
        i = abyte0[j];
        j++;
        return byte0 << 24 | (i & 0xff) << 16 | (abyte0[j] & 0xff) << 8 | abyte0[j + 1] & 0xff;
    }

    public static long _mth02B4(byte abyte0[], int i)
    {
        int j = _mth02B3(abyte0, i);
        i = _mth02B3(abyte0, i + 4);
        return ((long)j & 0xffffffffL) << 32 | (long)i & 0xffffffffL;
    }

    public static void _mth02BE(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)i;
        j++;
        abyte0[j] = (byte)(i >>> 8);
        j++;
        abyte0[j] = (byte)(i >>> 16);
        abyte0[j + 1] = i >> 24;
    }

    public static int _mth02C6(byte abyte0[], int i)
    {
        byte byte0 = abyte0[i];
        int j = i + 1;
        i = abyte0[j];
        j++;
        return byte0 & 0xff | (i & 0xff) << 8 | (abyte0[j] & 0xff) << 16 | abyte0[j + 1] << 24;
    }

    public static long _mth02C7(byte abyte0[], int i)
    {
        int j = _mth02C6(abyte0, i);
        return ((long)_mth02C6(abyte0, i + 4) & 0xffffffffL) << 32 | (long)j & 0xffffffffL;
    }

    public static void _mth02CA(byte abyte0[], int i, int ai[])
    {
        boolean flag = false;
        int j = i;
        for (i = ((flag) ? 1 : 0); i < ai.length; i++)
        {
            ai[i] = _mth02B3(abyte0, j);
            j += 4;
        }

    }

    public static void _mth02CB(int ai[], byte abyte0[], int i)
    {
        boolean flag = false;
        int j = i;
        for (i = ((flag) ? 1 : 0); i < ai.length; i++)
        {
            _mth1FBE(ai[i], abyte0, j);
            j += 4;
        }

    }

    public static void _mth02CE(int ai[], byte abyte0[], int i)
    {
        boolean flag = false;
        int j = i;
        for (i = ((flag) ? 1 : 0); i < ai.length; i++)
        {
            _mth02BE(ai[i], abyte0, j);
            j += 4;
        }

    }

    public static void _mth02CF(long l, byte abyte0[], int i)
    {
        _mth1FBE((int)(l >>> 32), abyte0, i);
        _mth1FBE((int)l, abyte0, i + 4);
    }

    public static void _mth141D(long l, byte abyte0[], int i)
    {
        _mth02BE((int)l, abyte0, i);
        _mth02BE((int)(l >>> 32), abyte0, i + 4);
    }

    public static byte[] _mth1D31(int i)
    {
        byte abyte0[] = new byte[4];
        _mth1FBE(i, abyte0, 0);
        return abyte0;
    }

    public static byte[] _mth1D4E(long l)
    {
        byte abyte0[] = new byte[8];
        _mth02BE((int)l, abyte0, 0);
        _mth02BE((int)(l >>> 32), abyte0, 4);
        return abyte0;
    }

    public static void _mth1FBE(int i, byte abyte0[], int j)
    {
        abyte0[j] = i >> 24;
        j++;
        abyte0[j] = (byte)(i >>> 16);
        j++;
        abyte0[j] = (byte)(i >>> 8);
        abyte0[j + 1] = (byte)i;
    }

    public static byte[] FF9E(int ai[])
    {
        byte abyte0[] = new byte[ai.length * 4];
        int j = 0;
        for (int i = 0; i < ai.length; i++)
        {
            _mth1FBE(ai[i], abyte0, j);
            j += 4;
        }

        return abyte0;
    }
}
