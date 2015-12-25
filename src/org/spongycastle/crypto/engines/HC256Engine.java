// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class HC256Engine
    implements StreamCipher
{

    private boolean aqH;
    private int arH[];
    private int arI[];
    private int arJ;
    private int arK;
    private byte buf[];
    private byte iv[];
    private byte key[];

    public HC256Engine()
    {
        arH = new int[1024];
        arI = new int[1024];
        arJ = 0;
        buf = new byte[4];
        arK = 0;
    }

    private void init()
    {
        if (key.length != 32 && key.length != 16)
        {
            throw new IllegalArgumentException("The key must be 128/256 bits long");
        }
        if (iv.length < 16)
        {
            throw new IllegalArgumentException("The IV must be at least 128 bits long");
        }
        if (key.length != 32)
        {
            byte abyte0[] = new byte[32];
            System.arraycopy(key, 0, abyte0, 0, key.length);
            System.arraycopy(key, 0, abyte0, 16, key.length);
            key = abyte0;
        }
        if (iv.length < 32)
        {
            byte abyte1[] = new byte[32];
            System.arraycopy(iv, 0, abyte1, 0, iv.length);
            System.arraycopy(iv, 0, abyte1, iv.length, 32 - iv.length);
            iv = abyte1;
        }
        arK = 0;
        arJ = 0;
        int ai[] = new int[2560];
        for (int i = 0; i < 32; i++)
        {
            int i1 = i >> 2;
            ai[i1] = ai[i1] | (key[i] & 0xff) << (i & 3) * 8;
        }

        for (int j = 0; j < 32; j++)
        {
            int j1 = (j >> 2) + 8;
            ai[j1] = ai[j1] | (iv[j] & 0xff) << (j & 3) * 8;
        }

        for (int k = 16; k < 2560; k++)
        {
            int k1 = ai[k - 2];
            int l1 = ai[k - 15];
            ai[k] = ((k1 >>> 17 | k1 << -17) ^ (k1 >>> 19 | k1 << -19) ^ k1 >>> 10) + ai[k - 7] + ((l1 >>> 7 | l1 << -7) ^ (l1 >>> 18 | l1 << -18) ^ l1 >>> 3) + ai[k - 16] + k;
        }

        System.arraycopy(ai, 512, arH, 0, 1024);
        System.arraycopy(ai, 1536, arI, 0, 1024);
        for (int l = 0; l < 4096; l++)
        {
            _mth1F37();
        }

        arJ = 0;
    }

    private int _mth1F37()
    {
        int i = arJ & 0x3ff;
        if (arJ < 1024)
        {
            int j = arH[i - 3 & 0x3ff];
            int l = arH[i - 1023 & 0x3ff];
            int ai[] = arH;
            ai[i] = ai[i] + (arH[i - 10 & 0x3ff] + ((j >>> 10 | j << -10) ^ (l >>> 23 | l << -23)) + arI[(j ^ l) & 0x3ff]);
            j = arH[i - 12 & 0x3ff];
            i = arI[j & 0xff] + arI[(j >> 8 & 0xff) + 256] + arI[(j >> 16 & 0xff) + 512] + arI[(j >>> 24) + 768] ^ arH[i];
        } else
        {
            int k = arI[i - 3 & 0x3ff];
            int i1 = arI[i - 1023 & 0x3ff];
            int ai1[] = arI;
            ai1[i] = ai1[i] + (arI[i - 10 & 0x3ff] + ((k >>> 10 | k << -10) ^ (i1 >>> 23 | i1 << -23)) + arH[(k ^ i1) & 0x3ff]);
            k = arI[i - 12 & 0x3ff];
            i = arH[k & 0xff] + arH[(k >> 8 & 0xff) + 256] + arH[(k >> 16 & 0xff) + 512] + arH[(k >>> 24) + 768] ^ arI[i];
        }
        arJ = arJ + 1 & 0x7ff;
        return i;
    }

    private byte _mth1FD7()
    {
        if (arK == 0)
        {
            int i = _mth1F37();
            buf[0] = (byte)i;
            i >>= 8;
            buf[1] = (byte)i;
            i >>= 8;
            buf[2] = (byte)i;
            buf[3] = (byte)(i >> 8);
        }
        byte byte0 = buf[arK];
        arK = arK + 1 & 3;
        return byte0;
    }

    public final void reset()
    {
        init();
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        CipherParameters cipherparameters1 = cipherparameters;
        if (cipherparameters instanceof ParametersWithIV)
        {
            iv = ((ParametersWithIV)cipherparameters).iv;
            cipherparameters1 = ((ParametersWithIV)cipherparameters).axC;
        } else
        {
            iv = new byte[0];
        }
        if (cipherparameters1 instanceof KeyParameter)
        {
            key = ((KeyParameter)cipherparameters1).key;
            init();
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid parameter passed to HC256 init - ")).append(cipherparameters.getClass().getName()).toString());
        }
        aqH = true;
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (!aqH)
        {
            throw new IllegalStateException((new StringBuilder()).append("HC-256 not initialised").toString());
        }
        if (i + j > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (k + j > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        for (int l = 0; l < j; l++)
        {
            abyte1[k + l] = (byte)(abyte0[i + l] ^ _mth1FD7());
        }

        return j;
    }

    public final String _mth14AC()
    {
        return "HC-256";
    }
}
