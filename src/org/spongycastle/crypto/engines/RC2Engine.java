// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RC2Parameters;

public class RC2Engine
    implements BlockCipher
{

    private static byte asn[] = {
        -39, 120, -7, -60, 25, -35, -75, -19, 40, -23, 
        -3, 121, 74, -96, -40, -99, -58, 126, 55, -125, 
        43, 118, 83, -114, 98, 76, 100, -120, 68, -117, 
        -5, -94, 23, -102, 89, -11, -121, -77, 79, 19, 
        97, 69, 109, -115, 9, -127, 125, 50, -67, -113, 
        64, -21, -122, -73, 123, 11, -16, -107, 33, 34, 
        92, 107, 78, -126, 84, -42, 101, -109, -50, 96, 
        -78, 28, 115, 86, -64, 20, -89, -116, -15, -36, 
        18, 117, -54, 31, 59, -66, -28, -47, 66, 61, 
        -44, 48, -93, 60, -74, 38, 111, -65, 14, -38, 
        70, 105, 7, 87, 39, -14, 29, -101, -68, -108, 
        67, 3, -8, 17, -57, -10, -112, -17, 62, -25, 
        6, -61, -43, 47, -56, 102, 30, -41, 8, -24, 
        -22, -34, -128, 82, -18, -9, -124, -86, 114, -84, 
        53, 77, 106, 42, -106, 26, -46, 113, 90, 21, 
        73, 116, 75, -97, -48, 94, 4, 24, -92, -20, 
        -62, -32, 65, 110, 15, 81, -53, -52, 36, -111, 
        -81, 80, -95, -12, 112, 57, -103, 124, 58, -123, 
        35, -72, -76, 122, -4, 2, 54, 91, 37, 85, 
        -105, 49, 45, 93, -6, -104, -29, -118, -110, -82, 
        5, -33, 41, 16, 103, 108, -70, -55, -45, 0, 
        -26, -49, -31, -98, -88, 44, 99, 22, 1, 63, 
        88, -30, -119, -87, 13, 56, 52, 27, -85, 51, 
        -1, -80, -69, 72, 12, 95, -71, -79, -51, 46, 
        -59, -13, -37, 71, -27, -91, -100, 119, 10, -90, 
        32, 104, -2, 127, -63, -83
    };
    private int aqU[];
    private boolean aqs;

    public RC2Engine()
    {
    }

    private static int[] _mth02C8(byte abyte0[], int i)
    {
        int ai[] = new int[128];
        for (int j = 0; j != abyte0.length; j++)
        {
            ai[j] = abyte0[j] & 0xff;
        }

        int l = abyte0.length;
        int k = l;
        if (l < 128)
        {
            l = 0;
            int i1 = ai[k - 1];
            int j1;
            do
            {
                j1 = l;
                abyte0 = asn;
                l = j1 + 1;
                i1 = abyte0[ai[j1] + i1 & 0xff] & 0xff;
                j1 = k + 1;
                ai[k] = i1;
                k = j1;
            } while (j1 < 128);
        }
        l = i + 7 >> 3;
        k = asn[ai[128 - l] & 255 >> (-i & 7)] & 0xff;
        ai[128 - l] = k;
        for (i = 128 - l - 1; i >= 0; i--)
        {
            k = asn[ai[i + l] ^ k] & 0xff;
            ai[i] = k;
        }

        abyte0 = new int[64];
        for (i = 0; i != 64; i++)
        {
            abyte0[i] = ai[i * 2] + (ai[i * 2 + 1] << 8);
        }

        return abyte0;
    }

    private void _mth02CB(byte abyte0[], int i, byte abyte1[], int j)
    {
        int k = ((abyte0[i + 7] & 0xff) << 8) + (abyte0[i + 6] & 0xff);
        int l = ((abyte0[i + 5] & 0xff) << 8) + (abyte0[i + 4] & 0xff);
        int i1 = ((abyte0[i + 3] & 0xff) << 8) + (abyte0[i + 2] & 0xff);
        int j1 = ((abyte0[i + 1] & 0xff) << 8) + (abyte0[i] & 0xff);
        for (i = 0; i <= 16; i += 4)
        {
            j1 = (~k & i1) + j1 + (l & k) + aqU[i] & 0xffff;
            j1 = j1 << 1 | j1 >> 15;
            i1 = (~j1 & l) + i1 + (k & j1) + aqU[i + 1] & 0xffff;
            i1 = i1 << 2 | i1 >> 14;
            l = (~i1 & k) + l + (j1 & i1) + aqU[i + 2] & 0xffff;
            l = l << 3 | l >> 13;
            k = (~l & j1) + k + (i1 & l) + aqU[i + 3] & 0xffff;
            k = k << 5 | k >> 11;
        }

        j1 += aqU[k & 0x3f];
        i1 += aqU[j1 & 0x3f];
        l += aqU[i1 & 0x3f];
        k += aqU[l & 0x3f];
        for (i = 20; i <= 40; i += 4)
        {
            j1 = (~k & i1) + j1 + (l & k) + aqU[i] & 0xffff;
            j1 = j1 << 1 | j1 >> 15;
            i1 = (~j1 & l) + i1 + (k & j1) + aqU[i + 1] & 0xffff;
            i1 = i1 << 2 | i1 >> 14;
            l = (~i1 & k) + l + (j1 & i1) + aqU[i + 2] & 0xffff;
            l = l << 3 | l >> 13;
            k = (~l & j1) + k + (i1 & l) + aqU[i + 3] & 0xffff;
            k = k << 5 | k >> 11;
        }

        j1 += aqU[k & 0x3f];
        i1 += aqU[j1 & 0x3f];
        l += aqU[i1 & 0x3f];
        k += aqU[l & 0x3f];
        for (i = 44; i < 64; i += 4)
        {
            j1 = (~k & i1) + j1 + (l & k) + aqU[i] & 0xffff;
            j1 = j1 << 1 | j1 >> 15;
            i1 = (~j1 & l) + i1 + (k & j1) + aqU[i + 1] & 0xffff;
            i1 = i1 << 2 | i1 >> 14;
            l = (~i1 & k) + l + (j1 & i1) + aqU[i + 2] & 0xffff;
            l = l << 3 | l >> 13;
            k = (~l & j1) + k + (i1 & l) + aqU[i + 3] & 0xffff;
            k = k << 5 | k >> 11;
        }

        abyte1[j] = (byte)j1;
        abyte1[j + 1] = (byte)(j1 >> 8);
        abyte1[j + 2] = (byte)i1;
        abyte1[j + 3] = (byte)(i1 >> 8);
        abyte1[j + 4] = (byte)l;
        abyte1[j + 5] = (byte)(l >> 8);
        abyte1[j + 6] = (byte)k;
        abyte1[j + 7] = (byte)(k >> 8);
    }

    private void _mth02CE(byte abyte0[], int i, byte abyte1[], int j)
    {
        int l1 = ((abyte0[i + 7] & 0xff) << 8) + (abyte0[i + 6] & 0xff);
        int k1 = ((abyte0[i + 5] & 0xff) << 8) + (abyte0[i + 4] & 0xff);
        int j1 = ((abyte0[i + 3] & 0xff) << 8) + (abyte0[i + 2] & 0xff);
        i = ((abyte0[i + 1] & 0xff) << 8) + (abyte0[i] & 0xff);
        for (int k = 60; k >= 44; k -= 4)
        {
            l1 = 0xffff & l1;
            l1 = (l1 << 11 | l1 >> 5) - ((~k1 & i) + (j1 & k1) + aqU[k + 3]);
            k1 = 0xffff & k1;
            k1 = (k1 << 13 | k1 >> 3) - ((~j1 & l1) + (i & j1) + aqU[k + 2]);
            j1 = 0xffff & j1;
            j1 = (j1 << 14 | j1 >> 2) - ((~i & k1) + (l1 & i) + aqU[k + 1]);
            i = 0xffff & i;
            i = (i << 15 | i >> 1) - ((~l1 & j1) + (k1 & l1) + aqU[k]);
        }

        l1 -= aqU[k1 & 0x3f];
        k1 -= aqU[j1 & 0x3f];
        j1 -= aqU[i & 0x3f];
        i -= aqU[l1 & 0x3f];
        for (int l = 40; l >= 20; l -= 4)
        {
            l1 = 0xffff & l1;
            l1 = (l1 << 11 | l1 >> 5) - ((~k1 & i) + (j1 & k1) + aqU[l + 3]);
            k1 = 0xffff & k1;
            k1 = (k1 << 13 | k1 >> 3) - ((~j1 & l1) + (i & j1) + aqU[l + 2]);
            j1 = 0xffff & j1;
            j1 = (j1 << 14 | j1 >> 2) - ((~i & k1) + (l1 & i) + aqU[l + 1]);
            i = 0xffff & i;
            i = (i << 15 | i >> 1) - ((~l1 & j1) + (k1 & l1) + aqU[l]);
        }

        l1 -= aqU[k1 & 0x3f];
        k1 -= aqU[j1 & 0x3f];
        j1 -= aqU[i & 0x3f];
        int i1 = i - aqU[l1 & 0x3f];
        for (i = 16; i >= 0; i -= 4)
        {
            l1 = 0xffff & l1;
            l1 = (l1 << 11 | l1 >> 5) - ((~k1 & i1) + (j1 & k1) + aqU[i + 3]);
            k1 = 0xffff & k1;
            k1 = (k1 << 13 | k1 >> 3) - ((~j1 & l1) + (i1 & j1) + aqU[i + 2]);
            j1 = 0xffff & j1;
            j1 = (j1 << 14 | j1 >> 2) - ((~i1 & k1) + (l1 & i1) + aqU[i + 1]);
            i1 = 0xffff & i1;
            i1 = (i1 << 15 | i1 >> 1) - ((~l1 & j1) + (k1 & l1) + aqU[i]);
        }

        abyte1[j] = (byte)i1;
        abyte1[j + 1] = (byte)(i1 >> 8);
        abyte1[j + 2] = (byte)j1;
        abyte1[j + 3] = (byte)(j1 >> 8);
        abyte1[j + 4] = (byte)k1;
        abyte1[j + 5] = (byte)(k1 >> 8);
        abyte1[j + 6] = (byte)l1;
        abyte1[j + 7] = (byte)(l1 >> 8);
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
            throw new IllegalStateException("RC2 engine not initialised");
        }
        if (i + 8 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 8 > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        if (aqs)
        {
            _mth02CB(abyte0, i, abyte1, j);
        } else
        {
            _mth02CE(abyte0, i, abyte1, j);
        }
        return 8;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        aqs = flag;
        if (cipherparameters instanceof RC2Parameters)
        {
            cipherparameters = (RC2Parameters)cipherparameters;
            aqU = _mth02C8(((RC2Parameters) (cipherparameters)).key, ((RC2Parameters) (cipherparameters)).axD);
            return;
        }
        if (cipherparameters instanceof KeyParameter)
        {
            cipherparameters = ((KeyParameter)cipherparameters).key;
            aqU = _mth02C8(cipherparameters, cipherparameters.length << 3);
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to RC2 init - ")).append(cipherparameters.getClass().getName()).toString());
        }
    }

    public final String _mth14AC()
    {
        return "RC2";
    }

}
