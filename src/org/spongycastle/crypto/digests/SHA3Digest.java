// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;

public class SHA3Digest
    implements ExtendedDigest
{

    private static long anZ[];
    private static int aoa[];
    private byte aob[];
    private byte aoc[];
    private int aod;
    private int aoe;
    private int aof;
    private boolean aog;
    private int aoh;
    private byte aoi[];
    private byte aoj[];
    private long aok[];
    private long aol[];
    private long aom[];

    public SHA3Digest()
    {
        aob = new byte[200];
        aoc = new byte[192];
        aok = new long[5];
        aol = new long[25];
        aom = new long[5];
        init(0);
    }

    public SHA3Digest(int i)
    {
        aob = new byte[200];
        aoc = new byte[192];
        aok = new long[5];
        aol = new long[25];
        aom = new long[5];
        init(i);
    }

    public SHA3Digest(SHA3Digest sha3digest)
    {
        aob = new byte[200];
        aoc = new byte[192];
        aok = new long[5];
        aol = new long[25];
        aom = new long[5];
        System.arraycopy(sha3digest.aob, 0, aob, 0, sha3digest.aob.length);
        System.arraycopy(sha3digest.aoc, 0, aoc, 0, sha3digest.aoc.length);
        aod = sha3digest.aod;
        aoe = sha3digest.aoe;
        aof = sha3digest.aof;
        aog = sha3digest.aog;
        aoh = sha3digest.aoh;
        aoi = Arrays._mth1D4C(sha3digest.aoi);
        aoj = Arrays._mth1D4C(sha3digest.aoj);
    }

    private void init(int i)
    {
        switch (i)
        {
        case 0: // '\0'
        case 288: 
            FB39(1024, 576);
            return;

        case 224: 
            FB39(1152, 448);
            return;

        case 256: 
            FB39(1088, 512);
            return;

        case 384: 
            FB39(832, 768);
            return;

        case 512: 
            FB39(576, 1024);
            return;
        }
        throw new IllegalArgumentException("bitLength must be one of 224, 256, 384, or 512.");
    }

    private void _mth02BB(long al[])
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                aom[j] = al[i * 5 + j] ^ ~al[(j + 1) % 5 + i * 5] & al[(j + 2) % 5 + i * 5];
            }

            for (int k = 0; k < 5; k++)
            {
                al[i * 5 + k] = aom[k];
            }

        }

    }

    private void _mth02CA(byte abyte0[], int i, long l)
    {
        if (l % 8L == 0L)
        {
            _mth02CB(abyte0, i, l);
            return;
        } else
        {
            _mth02CB(abyte0, i, l - l % 8L);
            _mth02CB(new byte[] {
                (byte)(abyte0[(int)(l / 8L) + i] >> (int)(8L - l % 8L))
            }, i, l % 8L);
            return;
        }
    }

    private static void _mth02CA(byte abyte0[], long al[])
    {
        for (int i = 0; i < 25; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                abyte0[(i << 3) + j] = (byte)(int)(al[i] >>> j * 8 & 255L);
            }

        }

    }

    private static void _mth02CA(long al[], byte abyte0[])
    {
        for (int i = 0; i < 25; i++)
        {
            al[i] = 0L;
            for (int j = 0; j < 8; j++)
            {
                al[i] = al[i] | ((long)abyte0[(i << 3) + j] & 255L) << j * 8;
            }

        }

    }

    private void _mth02CB(byte abyte0[], int i, long l)
    {
        if (aoe % 8 != 0)
        {
            throw new IllegalStateException("attempt to absorb with odd length queue.");
        }
        if (aog)
        {
            throw new IllegalStateException("attempt to absorb while squeezing.");
        }
        long l1 = 0L;
        do
        {
            if (l1 >= l)
            {
                break;
            }
            if (aoe == 0 && l >= (long)aod && l1 <= l - (long)aod)
            {
                long l4 = (l - l1) / (long)aod;
                for (long l2 = 0L; l2 < l4; l2++)
                {
                    System.arraycopy(abyte0, (int)((long)i + l1 / 8L + (long)aoi.length * l2), aoi, 0, aoi.length);
                    _mth02CE(aob, aoi, aoi.length);
                }

                l1 += (long)aod * l4;
            } else
            {
                int k = (int)(l - l1);
                int j = k;
                if (k + aoe > aod)
                {
                    j = aod - aoe;
                }
                k = j % 8;
                j -= k;
                System.arraycopy(abyte0, (int)(l1 / 8L) + i, aoc, aoe / 8, j / 8);
                aoe = aoe + j;
                long l3 = l1 + (long)j;
                if (aoe == aod)
                {
                    _mth14D8();
                }
                l1 = l3;
                if (k > 0)
                {
                    aoc[aoe / 8] = (byte)(abyte0[(int)(l3 / 8L) + i] & (1 << k) - 1);
                    aoe = aoe + k;
                    l1 = l3 + (long)k;
                }
            }
        } while (true);
    }

    private void _mth02CB(byte abyte0[], byte abyte1[], int i)
    {
        for (int j = 0; j < i; j++)
        {
            abyte0[j] = (byte)(abyte0[j] ^ abyte1[j]);
        }

        abyte1 = new long[abyte0.length / 8];
        _mth02CA(abyte1, abyte0);
        _mth02CB(((long []) (abyte1)));
        _mth02CA(abyte0, abyte1);
    }

    private void _mth02CB(long al[])
    {
        for (int i = 0; i < 24; i++)
        {
            _mth02CE(al);
            _mth02CF(al);
            _mth141D(al);
            _mth02BB(al);
            al[0] = al[0] ^ anZ[i];
        }

    }

    private void _mth02CE(byte abyte0[], byte abyte1[], int i)
    {
        _mth02CB(abyte0, abyte1, i);
    }

    private void _mth02CE(long al[])
    {
        for (int i = 0; i < 5; i++)
        {
            aok[i] = 0L;
            for (int k = 0; k < 5; k++)
            {
                long al1[] = aok;
                al1[i] = al1[i] ^ al[k * 5 + i];
            }

        }

        for (int j = 0; j < 5; j++)
        {
            long l1 = aok[(j + 1) % 5];
            long l2 = aok[(j + 1) % 5];
            long l3 = aok[(j + 4) % 5];
            for (int l = 0; l < 5; l++)
            {
                int i1 = l * 5 + j;
                al[i1] = al[i1] ^ (l1 << 1 ^ l2 >>> 63 ^ l3);
            }

        }

    }

    private static void _mth02CF(long al[])
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                int k = i + j * 5;
                long l;
                if (aoa[k] != 0)
                {
                    l = al[k] << aoa[k] ^ al[k] >>> 64 - aoa[k];
                } else
                {
                    l = al[k];
                }
                al[k] = l;
            }

        }

    }

    private void _mth141D(long al[])
    {
        System.arraycopy(al, 0, aol, 0, aol.length);
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                al[((i * 2 + j * 3) % 5) * 5 + j] = aol[j * 5 + i];
            }

        }

    }

    private void _mth14D8()
    {
        _mth02CB(aob, aoc, aod / 8);
        aoe = 0;
    }

    private void _mth1D4E(byte abyte0[])
    {
        long al[] = new long[abyte0.length / 8];
        _mth02CA(al, abyte0);
        _mth02CB(al);
        _mth02CA(abyte0, al);
    }

    private void FB39(int i, int j)
    {
        if (i + j != 1600)
        {
            throw new IllegalStateException("rate + capacity != 1600");
        }
        if (i <= 0 || i >= 1600 || i % 64 != 0)
        {
            throw new IllegalStateException("invalid rate value");
        } else
        {
            aod = i;
            aof = 0;
            Arrays.fill(aob, (byte)0);
            Arrays.fill(aoc, (byte)0);
            aoe = 0;
            aog = false;
            aoh = 0;
            aof = j / 2;
            aoi = new byte[i / 8];
            aoj = new byte[1];
            return;
        }
    }

    public final int doFinal(byte abyte0[], int i)
    {
        long l4 = aof;
        if (!aog)
        {
            if (aoe + 1 == aod)
            {
                byte abyte1[] = aoc;
                int j = aoe / 8;
                abyte1[j] = (byte)(abyte1[j] | 1 << aoe % 8);
                _mth02CB(aob, aoc, aod / 8);
                aoe = 0;
                int l1 = aod / 8;
                for (int k = 0; k != l1 + 0; k++)
                {
                    aoc[k] = 0;
                }

            } else
            {
                int i2 = (aoe + 7) / 8;
                int k2 = aod / 8;
                int l2 = (aoe + 7) / 8;
                for (int l = i2; l != i2 + (k2 - l2); l++)
                {
                    aoc[l] = 0;
                }

                byte abyte2[] = aoc;
                int i1 = aoe / 8;
                abyte2[i1] = (byte)(abyte2[i1] | 1 << aoe % 8);
            }
            byte abyte3[] = aoc;
            int j1 = (aod - 1) / 8;
            abyte3[j1] = (byte)(abyte3[j1] | 1 << (aod - 1) % 8);
            _mth02CB(aob, aoc, aod / 8);
            aoe = 0;
            if (aod == 1024)
            {
                System.arraycopy(aob, 0, aoc, 0, 128);
                aoh = 1024;
            } else
            {
                System.arraycopy(aob, 0, aoc, 0, aod / 64 << 3);
                aoh = aod;
            }
            aog = true;
        }
        if (l4 % 8L != 0L)
        {
            throw new IllegalStateException("outputLength not a multiple of 8");
        }
        int k1;
        for (long l3 = 0L; l3 < l4; l3 += k1)
        {
            if (aoh == 0)
            {
                _mth1D4E(aob);
                if (aod == 1024)
                {
                    System.arraycopy(aob, 0, aoc, 0, 128);
                    aoh = 1024;
                } else
                {
                    System.arraycopy(aob, 0, aoc, 0, aod / 64 << 3);
                    aoh = aod;
                }
            }
            int j2 = aoh;
            k1 = j2;
            if ((long)j2 > l4 - l3)
            {
                k1 = (int)(l4 - l3);
            }
            System.arraycopy(aoc, (aod - aoh) / 8, abyte0, (int)(l3 / 8L) + i, k1 / 8);
            aoh = aoh - k1;
        }

        reset();
        return aof / 8;
    }

    public final void reset()
    {
        init(aof);
    }

    public final void update(byte byte0)
    {
        aoj[0] = byte0;
        _mth02CA(aoj, 0, 8L);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        _mth02CA(abyte0, i, (long)j << 3);
    }

    public final String _mth14AC()
    {
        return (new StringBuilder("SHA3-")).append(aof).toString();
    }

    public final int _mth14AF()
    {
        return aof / 8;
    }

    public final int _mth14B2()
    {
        return aod / 8;
    }

    static 
    {
        long al[] = new long[24];
        byte abyte0[] = new byte[1];
        abyte0[0] = 1;
        for (int i = 0; i < 24; i++)
        {
            al[i] = 0L;
            for (int k = 0; k < 7; k++)
            {
                boolean flag;
                if ((abyte0[0] & 1) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if ((abyte0[0] & 0x80) != 0)
                {
                    abyte0[0] = (byte)(abyte0[0] << 1 ^ 0x71);
                } else
                {
                    abyte0[0] = (byte)(abyte0[0] << 1);
                }
                if (flag)
                {
                    al[i] = al[i] ^ 1L << (1 << k) - 1;
                }
            }

        }

        anZ = al;
        al = new int[25];
        al[0] = 0;
        int j = 1;
        int i1 = 0;
        int l = 0;
        do
        {
            int j1 = j;
            if (l < 24)
            {
                al[j1 % 5 + (i1 % 5) * 5] = (((l + 1) * (l + 2)) / 2) % 64;
                j = (j1 * 0 + i1 * 1) % 5;
                i1 = (j1 * 2 + i1 * 3) % 5;
                l++;
            } else
            {
                aoa = al;
            }
        } while (true);
    }
}
