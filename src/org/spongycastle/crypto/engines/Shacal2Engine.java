// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class Shacal2Engine
    implements BlockCipher
{

    private static final int anY[] = {
        0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5, 0xd807aa98, 0x12835b01, 
        0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174, 0xe49b69c1, 0xefbe4786, 0xfc19dc6, 0x240ca1cc, 
        0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da, 0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 
        0x6ca6351, 0x14292967, 0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85, 
        0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070, 0x19a4c116, 0x1e376c08, 
        0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3, 0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 
        0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2
    };
    private boolean amy;
    private int aqU[];

    public Shacal2Engine()
    {
        amy = false;
        aqU = null;
    }

    private static void _mth02CA(byte abyte0[], int ai[], int i, int j)
    {
        for (j = 0; j < abyte0.length / 4; j++)
        {
            int k = i + 1;
            byte byte0 = abyte0[i];
            i = k + 1;
            k = abyte0[k];
            int l = i + 1;
            byte byte1 = abyte0[i];
            i = l + 1;
            ai[j] = (byte0 & 0xff) << 24 | (k & 0xff) << 16 | (byte1 & 0xff) << 8 | abyte0[l] & 0xff;
        }

    }

    private static void _mth02CA(int ai[], byte abyte0[], int i)
    {
        boolean flag = false;
        int j = i;
        for (i = ((flag) ? 1 : 0); i < 8; i++)
        {
            int k = j + 1;
            abyte0[j] = ai[i] >> 24;
            j = k + 1;
            abyte0[k] = (byte)(ai[i] >>> 16);
            k = j + 1;
            abyte0[j] = (byte)(ai[i] >>> 8);
            j = k + 1;
            abyte0[k] = (byte)ai[i];
        }

    }

    private void _mth02CB(byte abyte0[], int i, byte abyte1[], int j)
    {
        int ai[] = new int[8];
        _mth02CA(abyte0, ai, i, 0);
        for (i = 0; i < 64; i++)
        {
            int k = ((ai[4] >>> 6 | ai[4] << -6) ^ (ai[4] >>> 11 | ai[4] << -11) ^ (ai[4] >>> 25 | ai[4] << -25)) + (ai[4] & ai[5] ^ ~ai[4] & ai[6]) + ai[7] + anY[i] + aqU[i];
            ai[7] = ai[6];
            ai[6] = ai[5];
            ai[5] = ai[4];
            ai[4] = ai[3] + k;
            ai[3] = ai[2];
            ai[2] = ai[1];
            ai[1] = ai[0];
            ai[0] = ((ai[0] >>> 2 | ai[0] << -2) ^ (ai[0] >>> 13 | ai[0] << -13) ^ (ai[0] >>> 22 | ai[0] << -22)) + k + (ai[0] & ai[2] ^ ai[0] & ai[3] ^ ai[2] & ai[3]);
        }

        _mth02CA(ai, abyte1, j);
    }

    private void _mth02CE(byte abyte0[], int i, byte abyte1[], int j)
    {
        int ai[] = new int[8];
        _mth02CA(abyte0, ai, i, 0);
        for (i = 63; i >= 0; i--)
        {
            int k = ai[0] - ((ai[1] >>> 2 | ai[1] << -2) ^ (ai[1] >>> 13 | ai[1] << -13) ^ (ai[1] >>> 22 | ai[1] << -22)) - (ai[1] & ai[2] ^ ai[1] & ai[3] ^ ai[2] & ai[3]);
            ai[0] = ai[1];
            ai[1] = ai[2];
            ai[2] = ai[3];
            ai[3] = ai[4] - k;
            ai[4] = ai[5];
            ai[5] = ai[6];
            ai[6] = ai[7];
            ai[7] = k - anY[i] - aqU[i] - ((ai[4] >>> 6 | ai[4] << -6) ^ (ai[4] >>> 11 | ai[4] << -11) ^ (ai[4] >>> 25 | ai[4] << -25)) - (ai[4] & ai[5] ^ ~ai[4] & ai[6]);
        }

        _mth02CA(ai, abyte1, j);
    }

    private void _mth1D54(byte abyte0[])
    {
        if (abyte0.length == 0 || abyte0.length > 64 || abyte0.length < 16 || abyte0.length % 8 != 0)
        {
            throw new IllegalArgumentException("Shacal2-key must be 16 - 64 bytes and multiple of 8");
        }
        _mth02CA(abyte0, aqU, 0, 0);
        for (int i = 16; i < 64; i++)
        {
            abyte0 = aqU;
            abyte0[i] = ((abyte0[i - 2] >>> 17 | aqU[i - 2] << -17) ^ (aqU[i - 2] >>> 19 | aqU[i - 2] << -19) ^ aqU[i - 2] >>> 10) + aqU[i - 7] + ((aqU[i - 15] >>> 7 | aqU[i - 15] << -7) ^ (aqU[i - 15] >>> 18 | aqU[i - 15] << -18) ^ aqU[i - 15] >>> 3) + aqU[i - 16];
        }

    }

    public final int getBlockSize()
    {
        return 32;
    }

    public final void reset()
    {
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (aqU == null)
        {
            throw new IllegalStateException("Shacal2 not initialised");
        }
        if (i + 32 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 32 > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        if (amy)
        {
            _mth02CB(abyte0, i, abyte1, j);
        } else
        {
            _mth02CE(abyte0, i, abyte1, j);
        }
        return 32;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof KeyParameter))
        {
            throw new IllegalArgumentException("only simple KeyParameter expected.");
        } else
        {
            amy = flag;
            aqU = new int[64];
            _mth1D54(((KeyParameter)cipherparameters).key);
            return;
        }
    }

    public final String _mth14AC()
    {
        return "Shacal2";
    }

}
