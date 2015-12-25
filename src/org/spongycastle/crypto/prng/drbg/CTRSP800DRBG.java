// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.crypto.prng.drbg:
//            SP80090DRBG, Utils

public class CTRSP800DRBG
    implements SP80090DRBG
{

    private static final byte ayt[] = Hex._mth1508("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");
    private EntropySource ayl;
    private BlockCipher aym;
    private int ayn;
    private int ayo;
    private byte ayp[];
    private byte ayq[];
    private long ayr;
    private boolean ays;

    public CTRSP800DRBG(BlockCipher blockcipher, int i, int j, EntropySource entropysource, byte abyte0[], byte abyte1[])
    {
        ayr = 0L;
        ays = false;
        ayl = entropysource;
        aym = blockcipher;
        ayn = i;
        ayo = (blockcipher.getBlockSize() << 3) + i;
        ays = _mth02CA(blockcipher);
        if (j > 256)
        {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (_mth02CA(blockcipher) && i == 168)
        {
            i = 112;
        } else
        if (!blockcipher._mth14AC().equals("AES"))
        {
            i = -1;
        }
        if (i < j)
        {
            throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
        }
        if (entropysource._mth021A() < j)
        {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        } else
        {
            blockcipher = FE73(Arrays._mth02CE(entropysource._mth01B3(), abyte1, abyte0), ayo);
            i = aym.getBlockSize();
            ayp = new byte[(ayn + 7) / 8];
            ayq = new byte[i];
            _mth02CB(blockcipher, ayp, ayq);
            ayr = 1L;
            return;
        }
    }

    private static void _mth02BD(byte abyte0[], int i, byte abyte1[], int j)
    {
        abyte1[j] = (byte)(abyte0[i] & 0xfe);
        abyte1[j + 1] = (byte)(abyte0[i] << 7 | (abyte0[i + 1] & 0xfc) >>> 1);
        abyte1[j + 2] = (byte)(abyte0[i + 1] << 6 | (abyte0[i + 2] & 0xf8) >>> 2);
        abyte1[j + 3] = (byte)(abyte0[i + 2] << 5 | (abyte0[i + 3] & 0xf0) >>> 3);
        abyte1[j + 4] = (byte)(abyte0[i + 3] << 4 | (abyte0[i + 4] & 0xe0) >>> 4);
        abyte1[j + 5] = (byte)(abyte0[i + 4] << 3 | (abyte0[i + 5] & 0xc0) >>> 5);
        abyte1[j + 6] = (byte)(abyte0[i + 5] << 2 | (abyte0[i + 6] & 0x80) >>> 6);
        abyte1[j + 7] = (byte)(abyte0[i + 6] << 1);
        for (i = j; i <= j + 7; i++)
        {
            byte byte0 = abyte1[i];
            abyte1[i] = (byte)(byte0 & 0xfe | (byte0 >> 1 ^ byte0 >> 2 ^ byte0 >> 3 ^ byte0 >> 4 ^ byte0 >> 5 ^ byte0 >> 6 ^ byte0 >> 7 ^ 1) & 1);
        }

    }

    private void _mth02CA(EntropySource entropysource, byte abyte0[])
    {
        _mth02CB(FE73(Arrays._mth0640(entropysource._mth01B3(), abyte0), ayo), ayp, ayq);
        ayr = 1L;
    }

    private static void _mth02CA(byte abyte0[], byte abyte1[], byte abyte2[], int i)
    {
        for (int j = 0; j < abyte0.length; j++)
        {
            abyte0[j] = (byte)(abyte1[j] ^ abyte2[j + i]);
        }

    }

    private void _mth02CA(byte abyte0[], byte abyte1[], byte abyte2[], byte abyte3[])
    {
        int j = aym.getBlockSize();
        byte abyte4[] = new byte[j];
        int k = abyte3.length / j;
        byte abyte5[] = new byte[j];
        aym._mth02CA(true, new KeyParameter(_mth1421(abyte1)));
        aym._mth02CA(abyte2, 0, abyte4, 0);
        for (int i = 0; i < k; i++)
        {
            _mth02CA(abyte5, abyte4, abyte3, i * j);
            aym._mth02CA(abyte5, 0, abyte4, 0);
        }

        System.arraycopy(abyte4, 0, abyte0, 0, abyte0.length);
    }

    private static boolean _mth02CA(BlockCipher blockcipher)
    {
        return blockcipher._mth14AC().equals("DESede") || blockcipher._mth14AC().equals("TDEA");
    }

    private void _mth02CB(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        byte abyte3[] = new byte[abyte0.length];
        byte abyte4[] = new byte[aym.getBlockSize()];
        int i = 0;
        int k = aym.getBlockSize();
        aym._mth02CA(true, new KeyParameter(_mth1421(abyte1)));
        for (; i * k < abyte0.length; i++)
        {
            FB39(abyte2);
            aym._mth02CA(abyte2, 0, abyte4, 0);
            int j;
            if (abyte3.length - i * k > k)
            {
                j = k;
            } else
            {
                j = abyte3.length - i * k;
            }
            System.arraycopy(abyte4, 0, abyte3, i * k, j);
        }

        _mth02CA(abyte3, abyte0, abyte3, 0);
        System.arraycopy(abyte3, 0, abyte1, 0, abyte1.length);
        System.arraycopy(abyte3, abyte1.length, abyte2, 0, abyte2.length);
    }

    private static void _mth0559(byte abyte0[], int i, int j)
    {
        abyte0[j] = i >> 24;
        abyte0[j + 1] = (byte)(i >> 16);
        abyte0[j + 2] = (byte)(i >> 8);
        abyte0[j + 3] = (byte)i;
    }

    private byte[] _mth1421(byte abyte0[])
    {
        if (ays)
        {
            byte abyte1[] = new byte[24];
            _mth02BD(abyte0, 0, abyte1, 0);
            _mth02BD(abyte0, 7, abyte1, 8);
            _mth02BD(abyte0, 14, abyte1, 16);
            return abyte1;
        } else
        {
            return abyte0;
        }
    }

    private static void FB39(byte abyte0[])
    {
        int i = 1;
        for (int j = 1; j <= abyte0.length; j++)
        {
            int k = (abyte0[abyte0.length - j] & 0xff) + i;
            if (k > 255)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            abyte0[abyte0.length - j] = (byte)k;
        }

    }

    private byte[] FE73(byte abyte0[], int i)
    {
        int j = aym.getBlockSize();
        int k = abyte0.length;
        int i1 = i / 8;
        byte abyte1[] = new byte[(((k + 8 + 1 + j) - 1) / j) * j];
        _mth0559(abyte1, k, 0);
        _mth0559(abyte1, i1, 4);
        System.arraycopy(abyte0, 0, abyte1, 8, k);
        abyte1[k + 8] = -128;
        byte abyte2[] = new byte[ayn / 8 + j];
        byte abyte3[] = new byte[j];
        byte abyte4[] = new byte[j];
        k = 0;
        abyte0 = new byte[ayn / 8];
        System.arraycopy(ayt, 0, abyte0, 0, abyte0.length);
        for (; k * j << 3 < ayn + (j << 3); k++)
        {
            _mth0559(abyte4, k, 0);
            _mth02CA(abyte3, abyte0, abyte4, abyte1);
            int j1;
            if (abyte2.length - k * j > j)
            {
                j1 = j;
            } else
            {
                j1 = abyte2.length - k * j;
            }
            System.arraycopy(abyte3, 0, abyte2, k * j, j1);
        }

        abyte1 = new byte[j];
        System.arraycopy(abyte2, 0, abyte0, 0, abyte0.length);
        System.arraycopy(abyte2, abyte0.length, abyte1, 0, abyte1.length);
        abyte2 = new byte[i / 2];
        i = 0;
        aym._mth02CA(true, new KeyParameter(_mth1421(abyte0)));
        for (; i * j < abyte2.length; i++)
        {
            aym._mth02CA(abyte1, 0, abyte1, 0);
            int l;
            if (abyte2.length - i * j > j)
            {
                l = j;
            } else
            {
                l = abyte2.length - i * j;
            }
            System.arraycopy(abyte1, 0, abyte2, i * j, l);
        }

        return abyte2;
    }

    public final int _mth02CA(byte abyte0[], byte abyte1[], boolean flag)
    {
        if (ays)
        {
            if (ayr > 0x80000000L)
            {
                return -1;
            }
            if (Utils._mth0559(abyte0, 512))
            {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else
        {
            if (ayr > 0x800000000000L)
            {
                return -1;
            }
            if (Utils._mth0559(abyte0, 32768))
            {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (flag)
        {
            _mth02CA(ayl, null);
        }
        abyte1 = new byte[ayo];
        byte abyte2[] = new byte[ayq.length];
        aym._mth02CA(true, new KeyParameter(_mth1421(ayp)));
        for (int i = 0; i < abyte0.length / abyte2.length; i++)
        {
            FB39(ayq);
            aym._mth02CA(ayq, 0, abyte2, 0);
            int j;
            if (abyte0.length - abyte2.length * i > abyte2.length)
            {
                j = abyte2.length;
            } else
            {
                j = abyte0.length - ayq.length * i;
            }
            System.arraycopy(abyte2, 0, abyte0, abyte2.length * i, j);
        }

        _mth02CB(abyte1, ayp, ayq);
        ayr = ayr + 1L;
        return abyte0.length << 3;
    }

    public final void _mth141F(byte abyte0[])
    {
        _mth02CA(ayl, abyte0);
    }

}
