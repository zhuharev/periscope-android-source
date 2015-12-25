// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class XTEAEngine
    implements BlockCipher
{

    private boolean asl;
    private boolean asm;
    private int ass[];
    private int atL[];
    private int atM[];

    public XTEAEngine()
    {
        ass = new int[4];
        atL = new int[32];
        atM = new int[32];
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
        for (i = 0; i < 32; i++)
        {
            l += (k << 4 ^ k >>> 5) + k ^ atL[i];
            k += (l << 4 ^ l >>> 5) + l ^ atM[i];
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
        int k = _mth02D1(abyte0, i);
        int l = _mth02D1(abyte0, i + 4);
        for (i = 31; i >= 0; i--)
        {
            l -= (k << 4 ^ k >>> 5) + k ^ atM[i];
            k -= (l << 4 ^ l >>> 5) + l ^ atL[i];
        }

        _mth02BB(k, abyte1, j);
        _mth02BB(l, abyte1, j + 4);
        return 8;
    }

    private void _mth1D54(byte abyte0[])
    {
        if (abyte0.length != 16)
        {
            throw new IllegalArgumentException("Key size must be 128 bits.");
        }
        int i = 0;
        for (int k = 0; k < 4;)
        {
            ass[k] = _mth02D1(abyte0, i);
            k++;
            i += 4;
        }

        int l = 0;
        for (int j = 0; j < 32; j++)
        {
            atL[j] = ass[l & 3] + l;
            l -= 0x61c88647;
            atM[j] = ass[l >>> 11 & 3] + l;
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
        if (!asl)
        {
            throw new IllegalStateException((new StringBuilder()).append("XTEA not initialised").toString());
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
        } else
        {
            asm = flag;
            asl = true;
            _mth1D54(((KeyParameter)cipherparameters).key);
            return;
        }
    }

    public final String _mth14AC()
    {
        return "XTEA";
    }
}
