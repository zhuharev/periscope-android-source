// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class TEAEngine
    implements BlockCipher
{

    private boolean asl;
    private boolean asm;
    private int atm;
    private int atn;
    private int ato;
    private int atp;

    public TEAEngine()
    {
        asl = false;
    }

    private static void _mth02BB(int i, byte abyte0[], int j)
    {
        int k = j + 1;
        abyte0[j] = i >> 24;
        j = k + 1;
        abyte0[k] = (byte)(i >>> 16);
        abyte0[j] = (byte)(i >>> 8);
        abyte0[j + 1] = (byte)i;
    }

    private int _mth02CF(byte abyte0[], int i, byte abyte1[], int j)
    {
        int l = _mth02D1(abyte0, i);
        int k = _mth02D1(abyte0, i + 4);
        int i1 = 0;
        for (i = 0; i != 32; i++)
        {
            i1 -= 0x61c88647;
            l += (k << 4) + atm ^ k + i1 ^ (k >>> 5) + atn;
            k += (l << 4) + ato ^ l + i1 ^ (l >>> 5) + atp;
        }

        _mth02BB(l, abyte1, j);
        _mth02BB(k, abyte1, j + 4);
        return 8;
    }

    private static int _mth02D1(byte abyte0[], int i)
    {
        int j = i + 1;
        i = abyte0[i];
        int k = j + 1;
        return i << 24 | (abyte0[j] & 0xff) << 16 | (abyte0[k] & 0xff) << 8 | abyte0[k + 1] & 0xff;
    }

    private int _mth141D(byte abyte0[], int i, byte abyte1[], int j)
    {
        int l = _mth02D1(abyte0, i);
        int i1 = _mth02D1(abyte0, i + 4);
        i = 0xc6ef3720;
        for (int k = 0; k != 32; k++)
        {
            i1 -= (l << 4) + ato ^ l + i ^ (l >>> 5) + atp;
            l -= (i1 << 4) + atm ^ i1 + i ^ (i1 >>> 5) + atn;
            i += 0x61c88647;
        }

        _mth02BB(l, abyte1, j);
        _mth02BB(i1, abyte1, j + 4);
        return 8;
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
        if (!asl)
        {
            throw new IllegalStateException((new StringBuilder()).append("TEA not initialised").toString());
        }
        if (i + 8 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 8 > abyte1.length)
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
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to TEA init - ")).append(cipherparameters.getClass().getName()).toString());
        }
        asm = flag;
        asl = true;
        cipherparameters = ((KeyParameter)cipherparameters).key;
        if (cipherparameters.length != 16)
        {
            throw new IllegalArgumentException("Key size must be 128 bits.");
        } else
        {
            atm = _mth02D1(cipherparameters, 0);
            atn = _mth02D1(cipherparameters, 4);
            ato = _mth02D1(cipherparameters, 8);
            atp = _mth02D1(cipherparameters, 12);
            return;
        }
    }

    public final String _mth14AC()
    {
        return "TEA";
    }
}
