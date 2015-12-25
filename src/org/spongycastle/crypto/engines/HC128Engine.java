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

public class HC128Engine
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

    public HC128Engine()
    {
        arH = new int[512];
        arI = new int[512];
        arJ = 0;
        buf = new byte[4];
        arK = 0;
    }

    private void init()
    {
        if (key.length != 16)
        {
            throw new IllegalArgumentException("The key must be 128 bits long");
        }
        arK = 0;
        arJ = 0;
        int ai[] = new int[1280];
        for (int i = 0; i < 16; i++)
        {
            int j1 = i >> 2;
            ai[j1] = ai[j1] | (key[i] & 0xff) << (i & 3) * 8;
        }

        System.arraycopy(ai, 0, ai, 4, 4);
        for (int j = 0; j < iv.length && j < 16; j++)
        {
            int k1 = (j >> 2) + 8;
            ai[k1] = ai[k1] | (iv[j] & 0xff) << (j & 3) * 8;
        }

        System.arraycopy(ai, 8, ai, 12, 4);
        for (int k = 16; k < 1280; k++)
        {
            int l1 = ai[k - 2];
            int i2 = ai[k - 7];
            int j2 = ai[k - 15];
            ai[k] = ((l1 >>> 17 | l1 << -17) ^ (l1 >>> 19 | l1 << -19) ^ l1 >>> 10) + i2 + ((j2 >>> 7 | j2 << -7) ^ (j2 >>> 18 | j2 << -18) ^ j2 >>> 3) + ai[k - 16] + k;
        }

        System.arraycopy(ai, 256, arH, 0, 512);
        System.arraycopy(ai, 768, arI, 0, 512);
        for (int l = 0; l < 512; l++)
        {
            arH[l] = _mth1F37();
        }

        for (int i1 = 0; i1 < 512; i1++)
        {
            arI[i1] = _mth1F37();
        }

        arJ = 0;
    }

    private int _mth1F37()
    {
        int i = arJ & 0x1ff;
        if (arJ < 512)
        {
            int ai[] = arH;
            int j = ai[i];
            int l = arH[i - 3 & 0x1ff];
            int j1 = arH[i - 10 & 0x1ff];
            int l1 = arH[i - 511 & 0x1ff];
            ai[i] = j + (((l >>> 10 | l << -10) ^ (l1 >>> 23 | l1 << -23)) + (j1 >>> 8 | j1 << -8));
            j = arH[i - 12 & 0x1ff];
            i = arI[j & 0xff] + arI[(j >> 16 & 0xff) + 256] ^ arH[i];
        } else
        {
            int ai1[] = arI;
            int k = ai1[i];
            int i1 = arI[i - 3 & 0x1ff];
            int k1 = arI[i - 10 & 0x1ff];
            int i2 = arI[i - 511 & 0x1ff];
            ai1[i] = k + (((i1 << 10 | i1 >>> -10) ^ (i2 << 23 | i2 >>> -23)) + (k1 << 8 | k1 >>> -8));
            k = arI[i - 12 & 0x1ff];
            i = arH[k & 0xff] + arH[(k >> 16 & 0xff) + 256] ^ arI[i];
        }
        arJ = arJ + 1 & 0x3ff;
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
            throw new IllegalArgumentException((new StringBuilder("Invalid parameter passed to HC128 init - ")).append(cipherparameters.getClass().getName()).toString());
        }
        aqH = true;
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (!aqH)
        {
            throw new IllegalStateException((new StringBuilder()).append("HC-128 not initialised").toString());
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
        return "HC-128";
    }
}
