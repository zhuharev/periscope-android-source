// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss.util;


public class GMSSUtil
{

    public GMSSUtil()
    {
    }

    public static byte[] _mth02CB(byte abyte0[][])
    {
        byte abyte1[] = new byte[abyte0.length * abyte0[0].length];
        int j = 0;
        for (int i = 0; i < abyte0.length; i++)
        {
            System.arraycopy(abyte0[i], 0, abyte1, j, abyte0[i].length);
            j += abyte0[i].length;
        }

        return abyte1;
    }

    public static int _mth1D54(byte abyte0[], int i)
    {
        int j = i + 1;
        i = abyte0[i];
        int k = j + 1;
        return i & 0xff | (abyte0[j] & 0xff) << 8 | (abyte0[k] & 0xff) << 16 | (abyte0[k + 1] & 0xff) << 24;
    }

    public static byte[] _mth217C(int i)
    {
        return (new byte[] {
            (byte)i, (byte)(i >> 8), (byte)(i >> 16), (byte)(i >>> 24)
        });
    }
}
