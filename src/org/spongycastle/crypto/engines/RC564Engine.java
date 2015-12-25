// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.RC5Parameters;

public class RC564Engine
    implements BlockCipher
{

    private boolean amy;
    private int asr;
    private long ast[];

    public RC564Engine()
    {
        asr = 12;
        ast = null;
    }

    private static long _mth02CC(byte abyte0[], int i)
    {
        long l = 0L;
        for (int j = 7; j >= 0; j--)
        {
            l = (l << 8) + (long)(abyte0[j + i] & 0xff);
        }

        return l;
    }

    private void _mth1D54(byte abyte0[])
    {
        long al[] = new long[(abyte0.length + 7) / 8];
        for (int i = 0; i != abyte0.length; i++)
        {
            int l = i / 8;
            al[l] = al[l] + ((long)(abyte0[i] & 0xff) << (i % 8) * 8);
        }

        ast = new long[(asr + 1) * 2];
        ast[0] = 0xb7e151628aed2a6bL;
        for (int j = 1; j < ast.length; j++)
        {
            abyte0 = ast;
            abyte0[j] = abyte0[j - 1] - 0x61c8864680b583ebL;
        }

        int k;
        if (al.length > ast.length)
        {
            k = al.length * 3;
        } else
        {
            k = ast.length * 3;
        }
        long l2 = 0L;
        long l1 = 0L;
        int k1 = 0;
        int j1 = 0;
        for (int i1 = 0; i1 < k; i1++)
        {
            abyte0 = ast;
            l2 = abyte0[k1] + l2 + l1;
            l2 = l2 << 3 | l2 >>> 61;
            abyte0[k1] = l2;
            long l3 = al[j1] + l2 + l1;
            l1 = l2 + l1;
            l1 = l3 << (int)(63L & l1) | l3 >>> (int)(64L - (63L & l1));
            al[j1] = l1;
            k1 = (k1 + 1) % ast.length;
            j1 = (j1 + 1) % al.length;
        }

    }

    public final int getBlockSize()
    {
        return 16;
    }

    public final void reset()
    {
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (amy)
        {
            long l2 = _mth02CC(abyte0, i) + ast[0];
            long l = _mth02CC(abyte0, i + 8) + ast[1];
            for (i = 1; i <= asr; i++)
            {
                l2 ^= l;
                l2 = (l2 << (int)(63L & l) | l2 >>> (int)(64L - (63L & l))) + ast[i * 2];
                l ^= l2;
                l = (l << (int)(63L & l2) | l >>> (int)(64L - (63L & l2))) + ast[i * 2 + 1];
            }

            for (i = 0; i < 8; i++)
            {
                abyte1[i + j] = (byte)(int)l2;
                l2 >>>= 8;
            }

            for (i = 0; i < 8; i++)
            {
                abyte1[i + (j + 8)] = (byte)(int)l;
                l >>>= 8;
            }

            return 16;
        }
        long l3 = _mth02CC(abyte0, i);
        long l1 = _mth02CC(abyte0, i + 8);
        for (i = asr; i > 0; i--)
        {
            l1 -= ast[i * 2 + 1];
            l1 = (l1 >>> (int)(63L & l3) | l1 << (int)(64L - (63L & l3))) ^ l3;
            l3 -= ast[i * 2];
            l3 = (l3 >>> (int)(63L & l1) | l3 << (int)(64L - (63L & l1))) ^ l1;
        }

        l3 -= ast[0];
        for (i = 0; i < 8; i++)
        {
            abyte1[i + j] = (byte)(int)l3;
            l3 >>>= 8;
        }

        l1 -= ast[1];
        for (i = 0; i < 8; i++)
        {
            abyte1[i + (j + 8)] = (byte)(int)l1;
            l1 >>>= 8;
        }

        return 16;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof RC5Parameters))
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to RC564 init - ")).append(cipherparameters.getClass().getName()).toString());
        } else
        {
            cipherparameters = (RC5Parameters)cipherparameters;
            amy = flag;
            asr = ((RC5Parameters) (cipherparameters)).asY;
            _mth1D54(((RC5Parameters) (cipherparameters)).key);
            return;
        }
    }

    public final String _mth14AC()
    {
        return "RC5-64";
    }
}
