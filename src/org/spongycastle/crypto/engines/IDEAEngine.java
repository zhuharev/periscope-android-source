// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class IDEAEngine
    implements BlockCipher
{

    private int aqU[];

    public IDEAEngine()
    {
        aqU = null;
    }

    private void _mth02CE(int ai[], byte abyte0[], int i, byte abyte1[], int j)
    {
        int k1 = 0;
        int j1 = (abyte0[i] << 8 & 0xff00) + (abyte0[i + 1] & 0xff);
        int k = i + 2;
        int l = (abyte0[k] << 8 & 0xff00) + (abyte0[k + 1] & 0xff);
        k = i + 4;
        int i1 = (abyte0[k] << 8 & 0xff00) + (abyte0[k + 1] & 0xff);
        i += 6;
        k = (abyte0[i] << 8 & 0xff00) + (abyte0[i + 1] & 0xff);
        for (i = 0; i < 8; i++)
        {
            int l1 = k1 + 1;
            j1 = _mth1421(j1, ai[k1]);
            k1 = l1 + 1;
            l1 = ai[l1] + l & 0xffff;
            int j2 = k1 + 1;
            l = ai[k1] + i1 & 0xffff;
            i1 = j2 + 1;
            k = _mth1421(k, ai[j2]);
            j2 = i1 + 1;
            int k2 = _mth1421(l ^ j1, ai[i1]);
            k1 = j2 + 1;
            i1 = _mth1421((l1 ^ k) + k2 & 0xffff, ai[j2]);
            j2 = k2 + i1 & 0xffff;
            j1 ^= i1;
            k ^= j2;
            l = i1 ^ l;
            i1 = j2 ^ l1;
        }

        int i2 = k1 + 1;
        i = _mth1421(j1, ai[k1]);
        abyte1[j] = (byte)(i >>> 8);
        abyte1[j + 1] = (byte)i;
        i = i2 + 1;
        i1 += ai[i2];
        j1 = j + 2;
        abyte1[j1] = (byte)(i1 >>> 8);
        abyte1[j1 + 1] = (byte)i1;
        l += ai[i];
        i1 = j + 4;
        abyte1[i1] = (byte)(l >>> 8);
        abyte1[i1 + 1] = (byte)l;
        i = _mth1421(k, ai[i + 1]);
        j += 6;
        abyte1[j] = (byte)(i >>> 8);
        abyte1[j + 1] = (byte)i;
    }

    private static int _mth1421(int i, int j)
    {
        if (i == 0)
        {
            i = 0x10001 - j;
        } else
        if (j == 0)
        {
            i = 0x10001 - i;
        } else
        {
            i *= j;
            j = i & 0xffff;
            int k = i >>> 16;
            if (j < k)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            i = (j - k) + i;
        }
        return 0xffff & i;
    }

    private static int FB60(int i)
    {
        if (i < 2)
        {
            return i;
        }
        int k = 1;
        int i1 = 0x10001 / i;
        int j = 0x10001 % i;
        int l = i;
        for (i = i1; j != 1; i = k * i1 + i & 0xffff)
        {
            i1 = l / j;
            l %= j;
            k = i * i1 + k & 0xffff;
            if (l == 1)
            {
                return k;
            }
            i1 = j / l;
            j %= l;
        }

        return 1 - i & 0xffff;
    }

    private int[] FE7A(byte abyte0[])
    {
        int ai[] = new int[52];
        byte abyte1[] = abyte0;
        if (abyte0.length < 16)
        {
            abyte1 = new byte[16];
            System.arraycopy(abyte0, 0, abyte1, 16 - abyte0.length, abyte0.length);
        }
        for (int i = 0; i < 8; i++)
        {
            int k = i << 1;
            ai[i] = (abyte1[k] << 8 & 0xff00) + (abyte1[k + 1] & 0xff);
        }

        for (int j = 8; j < 52; j++)
        {
            if ((j & 7) < 6)
            {
                ai[j] = ((ai[j - 7] & 0x7f) << 9 | ai[j - 6] >> 7) & 0xffff;
                continue;
            }
            if ((j & 7) == 6)
            {
                ai[j] = ((ai[j - 7] & 0x7f) << 9 | ai[j - 14] >> 7) & 0xffff;
            } else
            {
                ai[j] = ((ai[j - 15] & 0x7f) << 9 | ai[j - 14] >> 7) & 0xffff;
            }
        }

        return ai;
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
        if (aqU == null)
        {
            throw new IllegalStateException("IDEA engine not initialised");
        }
        if (i + 8 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 8 > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        } else
        {
            _mth02CE(aqU, abyte0, i, abyte1, j);
            return 8;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof KeyParameter)
        {
            cipherparameters = ((KeyParameter)cipherparameters).key;
            if (flag)
            {
                cipherparameters = FE7A(cipherparameters);
            } else
            {
                int ai[] = FE7A(cipherparameters);
                cipherparameters = new int[52];
                int i = FB60(ai[0]);
                int j = ai[1];
                int l = ai[2];
                int k = 0 + 1 + 1 + 1 + 1;
                cipherparameters[51] = FB60(ai[3]);
                cipherparameters[50] = 0 - l & 0xffff;
                cipherparameters[49] = 0 - j & 0xffff;
                j = 52 - 1 - 1 - 1 - 1;
                cipherparameters[48] = i;
                for (i = 1; i < 8; i++)
                {
                    int i1 = k + 1;
                    l = ai[k];
                    k = i1 + 1;
                    i1 = ai[i1];
                    j--;
                    cipherparameters[j] = i1;
                    j--;
                    cipherparameters[j] = l;
                    i1 = k + 1;
                    l = FB60(ai[k]);
                    k = i1 + 1;
                    i1 = ai[i1];
                    int l1 = k + 1;
                    int k1 = ai[k];
                    k = l1 + 1;
                    l1 = FB60(ai[l1]);
                    j--;
                    cipherparameters[j] = l1;
                    j--;
                    cipherparameters[j] = 0 - i1 & 0xffff;
                    j--;
                    cipherparameters[j] = 0 - k1 & 0xffff;
                    j--;
                    cipherparameters[j] = l;
                }

                l = k + 1;
                k = ai[k];
                i = l + 1;
                l = ai[l];
                j--;
                cipherparameters[j] = l;
                j--;
                cipherparameters[j] = k;
                k = i + 1;
                i = FB60(ai[i]);
                int j1 = k + 1;
                k = ai[k];
                l = ai[j1];
                j1 = FB60(ai[j1 + 1]);
                j--;
                cipherparameters[j] = j1;
                j--;
                cipherparameters[j] = 0 - l & 0xffff;
                j--;
                cipherparameters[j] = 0 - k & 0xffff;
                cipherparameters[j - 1] = i;
            }
            aqU = cipherparameters;
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to IDEA init - ")).append(cipherparameters.getClass().getName()).toString());
        }
    }

    public final String _mth14AC()
    {
        return "IDEA";
    }
}
