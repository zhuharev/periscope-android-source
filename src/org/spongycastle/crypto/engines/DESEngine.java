// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class DESEngine
    implements BlockCipher
{

    private static final short aqV[] = {
        128, 64, 32, 16, 8, 4, 2, 1
    };
    private static final int aqW[] = {
        0x800000, 0x400000, 0x200000, 0x100000, 0x80000, 0x40000, 0x20000, 0x10000, 32768, 16384, 
        8192, 4096, 2048, 1024, 512, 256, 128, 64, 32, 16, 
        8, 4, 2, 1
    };
    private static final byte aqX[] = {
        56, 48, 40, 32, 24, 16, 8, 0, 57, 49, 
        41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 
        26, 18, 10, 2, 59, 51, 43, 35, 62, 54, 
        46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 
        29, 21, 13, 5, 60, 52, 44, 36, 28, 20, 
        12, 4, 27, 19, 11, 3
    };
    private static final byte aqY[] = {
        1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 
        19, 21, 23, 25, 27, 28
    };
    private static final byte aqZ[] = {
        13, 16, 10, 23, 0, 4, 2, 27, 14, 5, 
        20, 9, 22, 18, 11, 3, 25, 7, 15, 6, 
        26, 19, 12, 1, 40, 51, 30, 36, 46, 54, 
        29, 39, 50, 44, 32, 47, 43, 48, 38, 55, 
        33, 52, 45, 41, 49, 35, 28, 31
    };
    private static final int ara[] = {
        0x1010400, 0, 0x10000, 0x1010404, 0x1010004, 0x10404, 4, 0x10000, 1024, 0x1010400, 
        0x1010404, 1024, 0x1000404, 0x1010004, 0x1000000, 4, 1028, 0x1000400, 0x1000400, 0x10400, 
        0x10400, 0x1010000, 0x1010000, 0x1000404, 0x10004, 0x1000004, 0x1000004, 0x10004, 0, 1028, 
        0x10404, 0x1000000, 0x10000, 0x1010404, 4, 0x1010000, 0x1010400, 0x1000000, 0x1000000, 1024, 
        0x1010004, 0x10000, 0x10400, 0x1000004, 1024, 4, 0x1000404, 0x10404, 0x1010404, 0x10004, 
        0x1010000, 0x1000404, 0x1000004, 1028, 0x10404, 0x1010400, 1028, 0x1000400, 0x1000400, 0, 
        0x10004, 0x10400, 0, 0x1010004
    };
    private static final int arb[] = {
        0x80108020, 0x80008000, 32768, 0x108020, 0x100000, 32, 0x80100020, 0x80008020, 0x80000020, 0x80108020, 
        0x80108000, 0x80000000, 0x80008000, 0x100000, 32, 0x80100020, 0x108000, 0x100020, 0x80008020, 0, 
        0x80000000, 32768, 0x108020, 0x80100000, 0x100020, 0x80000020, 0, 0x108000, 32800, 0x80108000, 
        0x80100000, 32800, 0, 0x108020, 0x80100020, 0x100000, 0x80008020, 0x80100000, 0x80108000, 32768, 
        0x80100000, 0x80008000, 32, 0x80108020, 0x108020, 32, 32768, 0x80000000, 32800, 0x80108000, 
        0x100000, 0x80000020, 0x100020, 0x80008020, 0x80000020, 0x100020, 0x108000, 0, 0x80008000, 32800, 
        0x80000000, 0x80100020, 0x80108020, 0x108000
    };
    private static final int arc[] = {
        520, 0x8020200, 0, 0x8020008, 0x8000200, 0, 0x20208, 0x8000200, 0x20008, 0x8000008, 
        0x8000008, 0x20000, 0x8020208, 0x20008, 0x8020000, 520, 0x8000000, 8, 0x8020200, 512, 
        0x20200, 0x8020000, 0x8020008, 0x20208, 0x8000208, 0x20200, 0x20000, 0x8000208, 8, 0x8020208, 
        512, 0x8000000, 0x8020200, 0x8000000, 0x20008, 520, 0x20000, 0x8020200, 0x8000200, 0, 
        512, 0x20008, 0x8020208, 0x8000200, 0x8000008, 512, 0, 0x8020008, 0x8000208, 0x20000, 
        0x8000000, 0x8020208, 8, 0x20208, 0x20200, 0x8000008, 0x8020000, 0x8000208, 520, 0x8020000, 
        0x20208, 8, 0x8020008, 0x20200
    };
    private static final int ard[] = {
        0x802001, 8321, 8321, 128, 0x802080, 0x800081, 0x800001, 8193, 0, 0x802000, 
        0x802000, 0x802081, 129, 0, 0x800080, 0x800001, 1, 8192, 0x800000, 0x802001, 
        128, 0x800000, 8193, 8320, 0x800081, 1, 8320, 0x800080, 8192, 0x802080, 
        0x802081, 129, 0x800080, 0x800001, 0x802000, 0x802081, 129, 0, 0, 0x802000, 
        8320, 0x800080, 0x800081, 1, 0x802001, 8321, 8321, 128, 0x802081, 129, 
        1, 8192, 0x800001, 8193, 0x802080, 0x800081, 8193, 8320, 0x800000, 0x802001, 
        128, 0x800000, 8192, 0x802080
    };
    private static final int are[] = {
        256, 0x2080100, 0x2080000, 0x42000100, 0x80000, 256, 0x40000000, 0x2080000, 0x40080100, 0x80000, 
        0x2000100, 0x40080100, 0x42000100, 0x42080000, 0x80100, 0x40000000, 0x2000000, 0x40080000, 0x40080000, 0, 
        0x40000100, 0x42080100, 0x42080100, 0x2000100, 0x42080000, 0x40000100, 0, 0x42000000, 0x2080100, 0x2000000, 
        0x42000000, 0x80100, 0x80000, 0x42000100, 256, 0x2000000, 0x40000000, 0x2080000, 0x42000100, 0x40080100, 
        0x2000100, 0x40000000, 0x42080000, 0x2080100, 0x40080100, 256, 0x2000000, 0x42080000, 0x42080100, 0x80100, 
        0x42000000, 0x42080100, 0x2080000, 0, 0x40080000, 0x42000000, 0x80100, 0x2000100, 0x40000100, 0x80000, 
        0, 0x40080000, 0x2080100, 0x40000100
    };
    private static final int arf[] = {
        0x20000010, 0x20400000, 16384, 0x20404010, 0x20400000, 16, 0x20404010, 0x400000, 0x20004000, 0x404010, 
        0x400000, 0x20000010, 0x400010, 0x20004000, 0x20000000, 16400, 0, 0x400010, 0x20004010, 16384, 
        0x404000, 0x20004010, 16, 0x20400010, 0x20400010, 0, 0x404010, 0x20404000, 16400, 0x404000, 
        0x20404000, 0x20000000, 0x20004000, 16, 0x20400010, 0x404000, 0x20404010, 0x400000, 16400, 0x20000010, 
        0x400000, 0x20004000, 0x20000000, 16400, 0x20000010, 0x20404010, 0x404000, 0x20400000, 0x404010, 0x20404000, 
        0, 0x20400010, 16, 16384, 0x20400000, 0x404010, 16384, 0x400010, 0x20004010, 0, 
        0x20404000, 0x20000000, 0x400010, 0x20004010
    };
    private static final int arg[] = {
        0x200000, 0x4200002, 0x4000802, 0, 2048, 0x4000802, 0x200802, 0x4200800, 0x4200802, 0x200000, 
        0, 0x4000002, 2, 0x4000000, 0x4200002, 2050, 0x4000800, 0x200802, 0x200002, 0x4000800, 
        0x4000002, 0x4200000, 0x4200800, 0x200002, 0x4200000, 2048, 2050, 0x4200802, 0x200800, 2, 
        0x4000000, 0x200800, 0x4000000, 0x200800, 0x200000, 0x4000802, 0x4000802, 0x4200002, 0x4200002, 2, 
        0x200002, 0x4000000, 0x4000800, 0x200000, 0x4200800, 2050, 0x200802, 0x4200800, 2050, 0x4000002, 
        0x4200802, 0x4200000, 0x200800, 0, 2, 0x4200802, 0, 0x200802, 0x4200000, 2048, 
        0x4000002, 0x4000800, 2048, 0x200002
    };
    private static final int arh[] = {
        0x10001040, 4096, 0x40000, 0x10041040, 0x10000000, 0x10001040, 64, 0x10000000, 0x40040, 0x10040000, 
        0x10041040, 0x41000, 0x10041000, 0x41040, 4096, 64, 0x10040000, 0x10000040, 0x10001000, 4160, 
        0x41000, 0x40040, 0x10040040, 0x10041000, 4160, 0, 0, 0x10040040, 0x10000040, 0x10001000, 
        0x41040, 0x40000, 0x41040, 0x40000, 0x10041000, 4096, 64, 0x10040040, 4096, 0x41040, 
        0x10001000, 64, 0x10000040, 0x10040000, 0x10040040, 0x10000000, 0x40000, 0x10001040, 0, 0x10041040, 
        0x40040, 0x10000040, 0x10040000, 0x10001000, 0x10001040, 0, 0x10041040, 0x41000, 0x41000, 4160, 
        4160, 0x40040, 0x10000000, 0x10041000
    };
    private int aqU[];

    public DESEngine()
    {
        aqU = null;
    }

    protected static void _mth02CA(int ai[], byte abyte0[], int i, byte abyte1[], int j)
    {
        int k = (abyte0[i] & 0xff) << 24 | (abyte0[i + 1] & 0xff) << 16 | (abyte0[i + 2] & 0xff) << 8 | abyte0[i + 3] & 0xff;
        i = (abyte0[i + 4] & 0xff) << 24 | (abyte0[i + 5] & 0xff) << 16 | (abyte0[i + 6] & 0xff) << 8 | abyte0[i + 7] & 0xff;
        int l = (k >>> 4 ^ i) & 0xf0f0f0f;
        i ^= l;
        k = l << 4 ^ k;
        l = (k >>> 16 ^ i) & 0xffff;
        i ^= l;
        k ^= l << 16;
        l = (i >>> 2 ^ k) & 0x33333333;
        k ^= l;
        l = l << 2 ^ i;
        int i1 = (l >>> 8 ^ k) & 0xff00ff;
        i = k ^ i1;
        k = i1 << 8 ^ l;
        k = k << 1 | k >>> 31 & 1;
        l = (i ^ k) & 0xaaaaaaaa;
        i ^= l;
        k ^= l;
        l = i << 1 | i >>> 31 & 1;
        for (i = 0; i < 8; i++)
        {
            int i2 = (k << 28 | k >>> 4) ^ ai[i << 2];
            int j1 = arg[i2 & 0x3f];
            int k1 = are[i2 >>> 8 & 0x3f];
            int l1 = arc[i2 >>> 16 & 0x3f];
            i2 = ara[i2 >>> 24 & 0x3f];
            int j2 = k ^ ai[(i << 2) + 1];
            j1 = l ^ (arh[j2 & 0x3f] | (j1 | k1 | l1 | i2) | arf[j2 >>> 8 & 0x3f] | ard[j2 >>> 16 & 0x3f] | arb[j2 >>> 24 & 0x3f]);
            l = j1;
            i2 = (j1 << 28 | l >>> 4) ^ ai[(i << 2) + 2];
            j1 = arg[i2 & 0x3f];
            k1 = are[i2 >>> 8 & 0x3f];
            l1 = arc[i2 >>> 16 & 0x3f];
            i2 = ara[i2 >>> 24 & 0x3f];
            j2 = l ^ ai[(i << 2) + 3];
            k ^= arh[j2 & 0x3f] | (j1 | k1 | l1 | i2) | arf[j2 >>> 8 & 0x3f] | ard[j2 >>> 16 & 0x3f] | arb[j2 >>> 24 & 0x3f];
        }

        i = k << 31 | k >>> 1;
        k = (l ^ i) & 0xaaaaaaaa;
        l ^= k;
        i ^= k;
        k = l << 31 | l >>> 1;
        l = (k >>> 8 ^ i) & 0xff00ff;
        i ^= l;
        k = l << 8 ^ k;
        l = (k >>> 2 ^ i) & 0x33333333;
        i ^= l;
        k ^= l << 2;
        l = (i >>> 16 ^ k) & 0xffff;
        k ^= l;
        i = l << 16 ^ i;
        l = (i >>> 4 ^ k) & 0xf0f0f0f;
        k ^= l;
        i ^= l << 4;
        abyte1[j] = (byte)(i >>> 24);
        abyte1[j + 1] = (byte)(i >>> 16);
        abyte1[j + 2] = (byte)(i >>> 8);
        abyte1[j + 3] = (byte)i;
        abyte1[j + 4] = (byte)(k >>> 24);
        abyte1[j + 5] = (byte)(k >>> 16);
        abyte1[j + 6] = (byte)(k >>> 8);
        abyte1[j + 7] = (byte)k;
    }

    protected static int[] _mth02CB(boolean flag, byte abyte0[])
    {
        int ai[] = new int[32];
        boolean aflag[] = new boolean[56];
        boolean aflag1[] = new boolean[56];
        for (int i = 0; i < 56; i++)
        {
            byte byte0 = aqX[i];
            boolean flag1;
            if ((abyte0[byte0 >>> 3] & aqV[byte0 & 7]) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            aflag[i] = flag1;
        }

        for (int j = 0; j < 16; j++)
        {
            int l;
            if (flag)
            {
                l = j << 1;
            } else
            {
                l = 15 - j << 1;
            }
            int j2 = l + 1;
            ai[j2] = 0;
            ai[l] = 0;
            for (int j1 = 0; j1 < 28; j1++)
            {
                int k2 = aqY[j] + j1;
                if (k2 < 28)
                {
                    aflag1[j1] = aflag[k2];
                } else
                {
                    aflag1[j1] = aflag[k2 - 28];
                }
            }

            for (int k1 = 28; k1 < 56; k1++)
            {
                int l2 = aqY[j] + k1;
                if (l2 < 56)
                {
                    aflag1[k1] = aflag[l2];
                } else
                {
                    aflag1[k1] = aflag[l2 - 28];
                }
            }

            for (int l1 = 0; l1 < 24; l1++)
            {
                if (aflag1[aqZ[l1]])
                {
                    ai[l] = ai[l] | aqW[l1];
                }
                if (aflag1[aqZ[l1 + 24]])
                {
                    ai[j2] = ai[j2] | aqW[l1];
                }
            }

        }

        for (int k = 0; k != 32; k += 2)
        {
            int i1 = ai[k];
            int i2 = ai[k + 1];
            ai[k] = (0xfc0000 & i1) << 6 | (i1 & 0xfc0) << 10 | (0xfc0000 & i2) >>> 10 | (i2 & 0xfc0) >>> 6;
            ai[k + 1] = (0x3f000 & i1) << 12 | (i1 & 0x3f) << 16 | (0x3f000 & i2) >>> 4 | i2 & 0x3f;
        }

        return ai;
    }

    public int getBlockSize()
    {
        return 8;
    }

    public void reset()
    {
    }

    public int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (aqU == null)
        {
            throw new IllegalStateException("DES engine not initialised");
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
            _mth02CA(aqU, abyte0, i, abyte1, j);
            return 8;
        }
    }

    public void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof KeyParameter)
        {
            if (((KeyParameter)cipherparameters).key.length > 8)
            {
                throw new IllegalArgumentException("DES key too long - should be 8 bytes");
            } else
            {
                aqU = _mth02CB(flag, ((KeyParameter)cipherparameters).key);
                return;
            }
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to DES init - ")).append(cipherparameters.getClass().getName()).toString());
        }
    }

    public String _mth14AC()
    {
        return "DES";
    }

}
