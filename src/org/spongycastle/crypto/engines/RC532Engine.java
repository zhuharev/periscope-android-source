// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RC5Parameters;

public class RC532Engine
    implements BlockCipher
{

    private boolean amy;
    private int asr;
    private int ass[];

    public RC532Engine()
    {
        asr = 12;
        ass = null;
    }

    private static int _mth02C9(byte abyte0[], int i)
    {
        return abyte0[i] & 0xff | (abyte0[i + 1] & 0xff) << 8 | (abyte0[i + 2] & 0xff) << 16 | (abyte0[i + 3] & 0xff) << 24;
    }

    private static void _mth141D(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)i;
        abyte0[j + 1] = (byte)(i >> 8);
        abyte0[j + 2] = (byte)(i >> 16);
        abyte0[j + 3] = i >> 24;
    }

    private void _mth1D54(byte abyte0[])
    {
        int ai[] = new int[(abyte0.length + 3) / 4];
        for (int i = 0; i != abyte0.length; i++)
        {
            int l = i / 4;
            ai[l] = ai[l] + ((abyte0[i] & 0xff) << (i % 4) * 8);
        }

        ass = new int[(asr + 1) * 2];
        ass[0] = 0xb7e15163;
        for (int j = 1; j < ass.length; j++)
        {
            abyte0 = ass;
            abyte0[j] = abyte0[j - 1] - 0x61c88647;
        }

        int k;
        if (ai.length > ass.length)
        {
            k = ai.length * 3;
        } else
        {
            k = ass.length * 3;
        }
        int i2 = 0;
        int l1 = 0;
        int k1 = 0;
        int j1 = 0;
        for (int i1 = 0; i1 < k; i1++)
        {
            abyte0 = ass;
            i2 = abyte0[k1] + i2 + l1;
            i2 = i2 << 3 | i2 >>> 29;
            abyte0[k1] = i2;
            int j2 = ai[j1] + i2 + l1;
            l1 = i2 + l1;
            l1 = j2 << (l1 & 0x1f) | j2 >>> 32 - (l1 & 0x1f);
            ai[j1] = l1;
            k1 = (k1 + 1) % ass.length;
            j1 = (j1 + 1) % ai.length;
        }

    }

    public final int getBlockSize()
    {
        return 8;
    }

    public final void reset()
    {
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (amy)
        {
            int i1 = _mth02C9(abyte0, i) + ass[0];
            int k = _mth02C9(abyte0, i + 4) + ass[1];
            for (i = 1; i <= asr; i++)
            {
                i1 ^= k;
                i1 = (i1 << (k & 0x1f) | i1 >>> 32 - (k & 0x1f)) + ass[i * 2];
                k ^= i1;
                k = (k << (i1 & 0x1f) | k >>> 32 - (i1 & 0x1f)) + ass[i * 2 + 1];
            }

            _mth141D(i1, abyte1, j);
            _mth141D(k, abyte1, j + 4);
            return 8;
        }
        int l = _mth02C9(abyte0, i);
        int j1 = _mth02C9(abyte0, i + 4);
        for (i = asr; i > 0; i--)
        {
            j1 -= ass[i * 2 + 1];
            j1 = (j1 >>> (l & 0x1f) | j1 << 32 - (l & 0x1f)) ^ l;
            l -= ass[i * 2];
            l = (l >>> (j1 & 0x1f) | l << 32 - (j1 & 0x1f)) ^ j1;
        }

        _mth141D(l - ass[0], abyte1, j);
        _mth141D(j1 - ass[1], abyte1, j + 4);
        return 8;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof RC5Parameters)
        {
            cipherparameters = (RC5Parameters)cipherparameters;
            asr = ((RC5Parameters) (cipherparameters)).asY;
            _mth1D54(((RC5Parameters) (cipherparameters)).key);
        } else
        if (cipherparameters instanceof KeyParameter)
        {
            _mth1D54(((KeyParameter)cipherparameters).key);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to RC532 init - ")).append(cipherparameters.getClass().getName()).toString());
        }
        amy = flag;
    }

    public final String _mth14AC()
    {
        return "RC5-32";
    }
}
