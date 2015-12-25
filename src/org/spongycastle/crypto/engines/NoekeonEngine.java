// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class NoekeonEngine
    implements BlockCipher
{

    private static final int ash[] = {
        0, 0, 0, 0
    };
    private static final int asi[] = {
        128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 
        188, 99, 198, 151, 53, 106, 212
    };
    private int aqM[];
    private int asj[];
    private int ask[];
    private boolean asl;
    private boolean asm;

    public NoekeonEngine()
    {
        aqM = new int[4];
        asj = new int[4];
        ask = new int[4];
        asl = false;
    }

    private static int _mth02BF(byte abyte0[], int i)
    {
        int j = i + 1;
        i = abyte0[i];
        int k = j + 1;
        return i << 24 | (abyte0[j] & 0xff) << 16 | (abyte0[k] & 0xff) << 8 | abyte0[k + 1] & 0xff;
    }

    private void _mth02CA(int ai[], int ai1[])
    {
        int i = ai[0] ^ ai[2];
        i ^= (i << 8 | i >>> 24) ^ (i << 24 | i >>> 8);
        ai[1] = ai[1] ^ i;
        ai[3] = ai[3] ^ i;
        for (i = 0; i < 4; i++)
        {
            ai[i] = ai[i] ^ ai1[i];
        }

        i = ai[1] ^ ai[3];
        i ^= (i << 8 | i >>> 24) ^ (i << 24 | i >>> 8);
        ai[0] = ai[0] ^ i;
        ai[2] = ai[2] ^ i;
    }

    private int _mth02CF(byte abyte0[], int i, byte abyte1[], int j)
    {
        aqM[0] = _mth02BF(abyte0, i);
        aqM[1] = _mth02BF(abyte0, i + 4);
        aqM[2] = _mth02BF(abyte0, i + 8);
        aqM[3] = _mth02BF(abyte0, i + 12);
        for (i = 0; i < 16; i++)
        {
            abyte0 = aqM;
            abyte0[0] = abyte0[0] ^ asi[i];
            _mth02CA(aqM, asj);
            abyte0 = aqM;
            byte byte0 = abyte0[1];
            abyte0[1] = byte0 << 1 | byte0 >>> 31;
            byte0 = abyte0[2];
            abyte0[2] = byte0 << 5 | byte0 >>> 27;
            byte0 = abyte0[3];
            abyte0[3] = byte0 << 2 | byte0 >>> 30;
            _mth02CF(aqM);
            _mth141D(aqM);
        }

        abyte0 = aqM;
        abyte0[0] = abyte0[0] ^ asi[i];
        _mth02CA(aqM, asj);
        _mth02CF(aqM[0], abyte1, j);
        _mth02CF(aqM[1], abyte1, j + 4);
        _mth02CF(aqM[2], abyte1, j + 8);
        _mth02CF(aqM[3], abyte1, j + 12);
        return 16;
    }

    private static void _mth02CF(int i, byte abyte0[], int j)
    {
        int k = j + 1;
        abyte0[j] = i >> 24;
        j = k + 1;
        abyte0[k] = (byte)(i >>> 16);
        abyte0[j] = (byte)(i >>> 8);
        abyte0[j + 1] = (byte)i;
    }

    private static void _mth02CF(int ai[])
    {
        ai[1] = ai[1] ^ ~ai[3] & ~ai[2];
        ai[0] = ai[0] ^ ai[2] & ai[1];
        int i = ai[3];
        ai[3] = ai[0];
        ai[0] = i;
        ai[2] = ai[2] ^ (ai[0] ^ ai[1] ^ ai[3]);
        ai[1] = ai[1] ^ ~ai[3] & ~ai[2];
        ai[0] = ai[0] ^ ai[2] & ai[1];
    }

    private int _mth141D(byte abyte0[], int i, byte abyte1[], int j)
    {
        aqM[0] = _mth02BF(abyte0, i);
        aqM[1] = _mth02BF(abyte0, i + 4);
        aqM[2] = _mth02BF(abyte0, i + 8);
        aqM[3] = _mth02BF(abyte0, i + 12);
        System.arraycopy(asj, 0, ask, 0, asj.length);
        _mth02CA(ask, ash);
        for (i = 16; i > 0; i--)
        {
            _mth02CA(aqM, ask);
            abyte0 = aqM;
            abyte0[0] = abyte0[0] ^ asi[i];
            abyte0 = aqM;
            byte byte0 = abyte0[1];
            abyte0[1] = byte0 << 1 | byte0 >>> 31;
            byte0 = abyte0[2];
            abyte0[2] = byte0 << 5 | byte0 >>> 27;
            byte0 = abyte0[3];
            abyte0[3] = byte0 << 2 | byte0 >>> 30;
            _mth02CF(aqM);
            _mth141D(aqM);
        }

        _mth02CA(aqM, ask);
        abyte0 = aqM;
        abyte0[0] = abyte0[0] ^ asi[i];
        _mth02CF(aqM[0], abyte1, j);
        _mth02CF(aqM[1], abyte1, j + 4);
        _mth02CF(aqM[2], abyte1, j + 8);
        _mth02CF(aqM[3], abyte1, j + 12);
        return 16;
    }

    private void _mth141D(int ai[])
    {
        int i = ai[1];
        ai[1] = i << 31 | i >>> 1;
        i = ai[2];
        ai[2] = i << 27 | i >>> 5;
        i = ai[3];
        ai[3] = i << 30 | i >>> 2;
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
        if (!asl)
        {
            throw new IllegalStateException((new StringBuilder()).append("Noekeon not initialised").toString());
        }
        if (i + 16 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 16 > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        if (asm)
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
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to Noekeon init - ")).append(cipherparameters.getClass().getName()).toString());
        } else
        {
            asm = flag;
            asl = true;
            cipherparameters = ((KeyParameter)cipherparameters).key;
            asj[0] = _mth02BF(cipherparameters, 0);
            asj[1] = _mth02BF(cipherparameters, 4);
            asj[2] = _mth02BF(cipherparameters, 8);
            asj[3] = _mth02BF(cipherparameters, 12);
            return;
        }
    }

    public final String _mth14AC()
    {
        return "Noekeon";
    }

}
