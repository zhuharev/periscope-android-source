// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class RC6Engine
    implements BlockCipher
{

    private boolean amy;
    private int ass[];

    public RC6Engine()
    {
        ass = null;
    }

    private static int _mth02C9(byte abyte0[], int i)
    {
        int k = 0;
        for (int j = 3; j >= 0; j--)
        {
            k = (k << 8) + (abyte0[j + i] & 0xff);
        }

        return k;
    }

    private int _mth02CF(byte abyte0[], int i, byte abyte1[], int j)
    {
        int k1 = _mth02C9(abyte0, i);
        int k = _mth02C9(abyte0, i + 4);
        int l = _mth02C9(abyte0, i + 8);
        i = _mth02C9(abyte0, i + 12);
        k += ass[0];
        i += ass[1];
        for (int i1 = 1; i1 <= 20;)
        {
            int l1 = (k * 2 + 1) * k;
            int j2 = l1 << 5 | l1 >>> -5;
            l1 = (i * 2 + 1) * i;
            l1 = l1 << 5 | l1 >>> -5;
            k1 ^= j2;
            int k2 = -l1;
            int l2 = ass[i1 * 2];
            l ^= l1;
            int i3 = -j2;
            int j3 = ass[i1 * 2 + 1];
            l = (l << j2 | l >>> i3) + j3;
            l1 = (k1 << l1 | k1 >>> k2) + l2;
            i1++;
            k1 = k;
            k = l;
            l = i;
            i = l1;
        }

        int j1 = ass[42];
        int i2 = ass[43];
        k1 += j1;
        for (j1 = 0; j1 < 4; j1++)
        {
            abyte1[j1 + j] = (byte)k1;
            k1 >>>= 8;
        }

        k1 = 0;
        j1 = k;
        for (k = k1; k < 4; k++)
        {
            abyte1[k + (j + 4)] = (byte)j1;
            j1 >>>= 8;
        }

        l += i2;
        for (k = 0; k < 4; k++)
        {
            abyte1[k + (j + 8)] = (byte)l;
            l >>>= 8;
        }

        l = 0;
        k = i;
        for (i = l; i < 4; i++)
        {
            abyte1[i + (j + 12)] = (byte)k;
            k >>>= 8;
        }

        return 16;
    }

    private int _mth141D(byte abyte0[], int i, byte abyte1[], int j)
    {
        int k = _mth02C9(abyte0, i);
        int l = _mth02C9(abyte0, i + 4);
        int j1 = _mth02C9(abyte0, i + 8);
        int i1 = _mth02C9(abyte0, i + 12);
        i = j1 - ass[43];
        k -= ass[42];
        j1 = 20;
        int k1;
        int l1;
        do
        {
            k1 = i1;
            l1 = l;
            if (j1 <= 0)
            {
                break;
            }
            i1 = i;
            l = k;
            i = (l * 2 + 1) * l;
            k = i << 5 | i >>> -5;
            i = (i1 * 2 + 1) * i1;
            int i2 = i << 5 | i >>> -5;
            i = l1 - ass[j1 * 2 + 1];
            i = (i >>> k | i << -k) ^ i2;
            k1 -= ass[j1 * 2];
            k = (k1 >>> i2 | k1 << -i2) ^ k;
            j1--;
        } while (true);
        j1 = ass[1];
        int j2 = ass[0];
        i1 = 0;
        l = k;
        for (k = i1; k < 4; k++)
        {
            abyte1[k + j] = (byte)l;
            l >>>= 8;
        }

        l = l1 - j2;
        for (k = 0; k < 4; k++)
        {
            abyte1[k + (j + 4)] = (byte)l;
            l >>>= 8;
        }

        l = 0;
        k = i;
        for (i = l; i < 4; i++)
        {
            abyte1[i + (j + 8)] = (byte)k;
            k >>>= 8;
        }

        k = k1 - j1;
        for (i = 0; i < 4; i++)
        {
            abyte1[i + (j + 12)] = (byte)k;
            k >>>= 8;
        }

        return 16;
    }

    private void _mth1D54(byte abyte0[])
    {
        int ai[] = new int[((abyte0.length + 4) - 1) / 4];
        for (int i = abyte0.length - 1; i >= 0; i--)
        {
            ai[i / 4] = (ai[i / 4] << 8) + (abyte0[i] & 0xff);
        }

        ass = new int[44];
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
        int l1 = 0;
        int k1 = 0;
        int j1 = 0;
        int i1 = 0;
        for (int l = 0; l < k; l++)
        {
            abyte0 = ass;
            l1 = abyte0[j1] + l1 + k1;
            l1 = l1 << 3 | l1 >>> -3;
            abyte0[j1] = l1;
            int i2 = ai[i1] + l1 + k1;
            k1 = l1 + k1;
            k1 = i2 << k1 | i2 >>> -k1;
            ai[i1] = k1;
            j1 = (j1 + 1) % ass.length;
            i1 = (i1 + 1) % ai.length;
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
        if (ass == null)
        {
            throw new IllegalStateException("RC6 engine not initialised");
        }
        if (i + 16 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 16 > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        if (amy)
        {
            return _mth02CF(abyte0, i, abyte1, j);
        } else
        {
            return _mth141D(abyte0, i, abyte1, j);
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof KeyParameter))
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to RC6 init - ")).append(cipherparameters.getClass().getName()).toString());
        } else
        {
            cipherparameters = (KeyParameter)cipherparameters;
            amy = flag;
            _mth1D54(((KeyParameter) (cipherparameters)).key);
            return;
        }
    }

    public final String _mth14AC()
    {
        return "RC6";
    }
}
