// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class CamelliaLightEngine
    implements BlockCipher
{

    private static final int aqN[] = {
        0xa09e667f, 0x3bcc908b, 0xb67ae858, 0x4caa73b2, 0xc6ef372f, 0xe94f82be, 0x54ff53a5, 0xf1d36f1c, 0x10e527fa, 0xde682d1d, 
        0xb05688c2, 0xb3e6c1fd
    };
    private static final byte aqT[] = {
        112, -126, 44, -20, -77, 39, -64, -27, -28, -123, 
        87, 53, -22, 12, -82, 65, 35, -17, 107, -109, 
        69, 25, -91, 33, -19, 14, 79, 78, 29, 101, 
        -110, -67, -122, -72, -81, -113, 124, -21, 31, -50, 
        62, 48, -36, 95, 94, -59, 11, 26, -90, -31, 
        57, -54, -43, 71, 93, 61, -39, 1, 90, -42, 
        81, 86, 108, 77, -117, 13, -102, 102, -5, -52, 
        -80, 45, 116, 18, 43, 32, -16, -79, -124, -103, 
        -33, 76, -53, -62, 52, 126, 118, 5, 109, -73, 
        -87, 49, -47, 23, 4, -41, 20, 88, 58, 97, 
        -34, 27, 17, 28, 50, 15, -100, 22, 83, 24, 
        -14, 34, -2, 68, -49, -78, -61, -75, 122, -111, 
        36, 8, -24, -88, 96, -4, 105, 80, -86, -48, 
        -96, 125, -95, -119, 98, -105, 84, 91, 30, -107, 
        -32, -1, 100, -46, 16, -60, 0, 72, -93, -9, 
        117, -37, -118, 3, -26, -38, 9, 63, -35, -108, 
        -121, 92, -125, 2, -51, 74, -112, 51, 115, 103, 
        -10, -13, -99, 127, -65, -30, 82, -101, -40, 38, 
        -56, 55, -58, 59, -127, -106, 111, 75, 19, -66, 
        99, 46, -23, 121, -89, -116, -97, 110, -68, -114, 
        41, -11, -7, -74, 47, -3, -76, 89, 120, -104, 
        6, 106, -25, 70, 113, -70, -44, 37, -85, 66, 
        -120, -94, -115, -6, 114, 7, -71, 85, -8, -18, 
        -84, 10, 54, 73, 42, 104, 60, 56, -15, -92, 
        64, 40, -45, 123, -69, -55, 67, -63, 21, -29, 
        -83, -12, 119, -57, -128, -98
    };
    private int aqJ[];
    private int aqK[];
    private int aqL[];
    private int aqM[];
    private boolean aqS;
    private boolean initialized;

    public CamelliaLightEngine()
    {
        aqJ = new int[96];
        aqK = new int[8];
        aqL = new int[12];
        aqM = new int[4];
    }

    private int _mth02BB(byte abyte0[], int i, byte abyte1[], int j)
    {
        for (int k = 0; k < 4; k++)
        {
            aqM[k] = _mth1FBE(abyte0, (k << 2) + i);
            int ai[] = aqM;
            ai[k] = ai[k] ^ aqK[k];
        }

        _mth02CA(aqM, aqJ, 0);
        _mth02CA(aqM, aqJ, 4);
        _mth02CA(aqM, aqJ, 8);
        _mth02CB(aqM, aqL, 0);
        _mth02CA(aqM, aqJ, 12);
        _mth02CA(aqM, aqJ, 16);
        _mth02CA(aqM, aqJ, 20);
        _mth02CB(aqM, aqL, 4);
        _mth02CA(aqM, aqJ, 24);
        _mth02CA(aqM, aqJ, 28);
        _mth02CA(aqM, aqJ, 32);
        abyte0 = aqM;
        abyte0[2] = abyte0[2] ^ aqK[4];
        abyte0 = aqM;
        abyte0[3] = abyte0[3] ^ aqK[5];
        abyte0 = aqM;
        abyte0[0] = abyte0[0] ^ aqK[6];
        abyte0 = aqM;
        abyte0[1] = abyte0[1] ^ aqK[7];
        int l = aqM[2];
        for (i = 0; i < 4; i++)
        {
            abyte1[(3 - i) + j] = (byte)l;
            l >>>= 8;
        }

        l = aqM[3];
        for (i = 0; i < 4; i++)
        {
            abyte1[(3 - i) + (j + 4)] = (byte)l;
            l >>>= 8;
        }

        l = aqM[0];
        for (i = 0; i < 4; i++)
        {
            abyte1[(3 - i) + (j + 8)] = (byte)l;
            l >>>= 8;
        }

        l = aqM[1];
        for (i = 0; i < 4; i++)
        {
            abyte1[(3 - i) + (j + 12)] = (byte)l;
            l >>>= 8;
        }

        return 16;
    }

    private int _mth02BC(byte abyte0[], int i, byte abyte1[], int j)
    {
        for (int k = 0; k < 4; k++)
        {
            aqM[k] = _mth1FBE(abyte0, (k << 2) + i);
            int ai[] = aqM;
            ai[k] = ai[k] ^ aqK[k];
        }

        _mth02CA(aqM, aqJ, 0);
        _mth02CA(aqM, aqJ, 4);
        _mth02CA(aqM, aqJ, 8);
        _mth02CB(aqM, aqL, 0);
        _mth02CA(aqM, aqJ, 12);
        _mth02CA(aqM, aqJ, 16);
        _mth02CA(aqM, aqJ, 20);
        _mth02CB(aqM, aqL, 4);
        _mth02CA(aqM, aqJ, 24);
        _mth02CA(aqM, aqJ, 28);
        _mth02CA(aqM, aqJ, 32);
        _mth02CB(aqM, aqL, 8);
        _mth02CA(aqM, aqJ, 36);
        _mth02CA(aqM, aqJ, 40);
        _mth02CA(aqM, aqJ, 44);
        abyte0 = aqM;
        abyte0[2] = abyte0[2] ^ aqK[4];
        abyte0 = aqM;
        abyte0[3] = abyte0[3] ^ aqK[5];
        abyte0 = aqM;
        abyte0[0] = abyte0[0] ^ aqK[6];
        abyte0 = aqM;
        abyte0[1] = abyte0[1] ^ aqK[7];
        int l = aqM[2];
        for (i = 0; i < 4; i++)
        {
            abyte1[(3 - i) + j] = (byte)l;
            l >>>= 8;
        }

        l = aqM[3];
        for (i = 0; i < 4; i++)
        {
            abyte1[(3 - i) + (j + 4)] = (byte)l;
            l >>>= 8;
        }

        l = aqM[0];
        for (i = 0; i < 4; i++)
        {
            abyte1[(3 - i) + (j + 8)] = (byte)l;
            l >>>= 8;
        }

        l = aqM[1];
        for (i = 0; i < 4; i++)
        {
            abyte1[(3 - i) + (j + 12)] = (byte)l;
            l >>>= 8;
        }

        return 16;
    }

    private static void _mth02CA(int i, int ai[], int j, int ai1[], int k)
    {
        ai1[k + 0] = ai[j + 0] << i | ai[j + 1] >>> 32 - i;
        ai1[k + 1] = ai[j + 1] << i | ai[j + 2] >>> 32 - i;
        ai1[k + 2] = ai[j + 2] << i | ai[j + 3] >>> 32 - i;
        ai1[k + 3] = ai[j + 3] << i | ai[j + 0] >>> 32 - i;
        ai[j + 0] = ai1[k + 0];
        ai[j + 1] = ai1[k + 1];
        ai[j + 2] = ai1[k + 2];
        ai[j + 3] = ai1[k + 3];
    }

    private void _mth02CA(boolean flag, byte abyte0[])
    {
        int ai[] = new int[8];
        int ai1[] = new int[4];
        int ai2[] = new int[4];
        int ai3[] = new int[4];
        switch (abyte0.length)
        {
        case 16: // '\020'
            aqS = true;
            ai[0] = _mth1FBE(abyte0, 0);
            ai[1] = _mth1FBE(abyte0, 4);
            ai[2] = _mth1FBE(abyte0, 8);
            ai[3] = _mth1FBE(abyte0, 12);
            ai[7] = 0;
            ai[6] = 0;
            ai[5] = 0;
            ai[4] = 0;
            break;

        case 24: // '\030'
            ai[0] = _mth1FBE(abyte0, 0);
            ai[1] = _mth1FBE(abyte0, 4);
            ai[2] = _mth1FBE(abyte0, 8);
            ai[3] = _mth1FBE(abyte0, 12);
            ai[4] = _mth1FBE(abyte0, 16);
            ai[5] = _mth1FBE(abyte0, 20);
            ai[6] = ~ai[4];
            ai[7] = ~ai[5];
            aqS = false;
            break;

        case 32: // ' '
            ai[0] = _mth1FBE(abyte0, 0);
            ai[1] = _mth1FBE(abyte0, 4);
            ai[2] = _mth1FBE(abyte0, 8);
            ai[3] = _mth1FBE(abyte0, 12);
            ai[4] = _mth1FBE(abyte0, 16);
            ai[5] = _mth1FBE(abyte0, 20);
            ai[6] = _mth1FBE(abyte0, 24);
            ai[7] = _mth1FBE(abyte0, 28);
            aqS = false;
            break;

        default:
            throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
        }
        for (int i = 0; i < 4; i++)
        {
            ai1[i] = ai[i] ^ ai[i + 4];
        }

        _mth02CA(ai1, aqN, 0);
        for (int j = 0; j < 4; j++)
        {
            ai1[j] = ai1[j] ^ ai[j];
        }

        _mth02CA(ai1, aqN, 4);
        if (aqS)
        {
            if (flag)
            {
                aqK[0] = ai[0];
                aqK[1] = ai[1];
                aqK[2] = ai[2];
                aqK[3] = ai[3];
                _mth02CA(15, ai, 0, aqJ, 4);
                _mth02CA(30, ai, 0, aqJ, 12);
                _mth02CA(15, ai, 0, ai3, 0);
                aqJ[18] = ai3[2];
                aqJ[19] = ai3[3];
                _mth02CA(17, ai, 0, aqL, 4);
                _mth02CA(17, ai, 0, aqJ, 24);
                _mth02CA(17, ai, 0, aqJ, 32);
                aqJ[0] = ai1[0];
                aqJ[1] = ai1[1];
                aqJ[2] = ai1[2];
                aqJ[3] = ai1[3];
                _mth02CA(15, ai1, 0, aqJ, 8);
                _mth02CA(15, ai1, 0, aqL, 0);
                _mth02CA(15, ai1, 0, ai3, 0);
                aqJ[16] = ai3[0];
                aqJ[17] = ai3[1];
                _mth02CA(15, ai1, 0, aqJ, 20);
                _mth02CE(34, ai1, 0, aqJ, 28);
                _mth02CA(17, ai1, 0, aqK, 4);
                return;
            } else
            {
                aqK[4] = ai[0];
                aqK[5] = ai[1];
                aqK[6] = ai[2];
                aqK[7] = ai[3];
                _mth02CB(15, ai, 0, aqJ, 28);
                _mth02CB(30, ai, 0, aqJ, 20);
                _mth02CB(15, ai, 0, ai3, 0);
                aqJ[16] = ai3[0];
                aqJ[17] = ai3[1];
                _mth02CB(17, ai, 0, aqL, 0);
                _mth02CB(17, ai, 0, aqJ, 8);
                _mth02CB(17, ai, 0, aqJ, 0);
                aqJ[34] = ai1[0];
                aqJ[35] = ai1[1];
                aqJ[32] = ai1[2];
                aqJ[33] = ai1[3];
                _mth02CB(15, ai1, 0, aqJ, 24);
                _mth02CB(15, ai1, 0, aqL, 4);
                _mth02CB(15, ai1, 0, ai3, 0);
                aqJ[18] = ai3[2];
                aqJ[19] = ai3[3];
                _mth02CB(15, ai1, 0, aqJ, 12);
                _mth02CF(34, ai1, 0, aqJ, 4);
                _mth02CA(17, ai1, 0, aqK, 0);
                return;
            }
        }
        for (int k = 0; k < 4; k++)
        {
            ai2[k] = ai1[k] ^ ai[k + 4];
        }

        _mth02CA(ai2, aqN, 8);
        if (flag)
        {
            aqK[0] = ai[0];
            aqK[1] = ai[1];
            aqK[2] = ai[2];
            aqK[3] = ai[3];
            _mth02CE(45, ai, 0, aqJ, 16);
            _mth02CA(15, ai, 0, aqL, 4);
            _mth02CA(17, ai, 0, aqJ, 32);
            _mth02CE(34, ai, 0, aqJ, 44);
            _mth02CA(15, ai, 4, aqJ, 4);
            _mth02CA(15, ai, 4, aqL, 0);
            _mth02CA(30, ai, 4, aqJ, 24);
            _mth02CE(34, ai, 4, aqJ, 36);
            _mth02CA(15, ai1, 0, aqJ, 8);
            _mth02CA(30, ai1, 0, aqJ, 20);
            aqL[8] = ai1[1];
            aqL[9] = ai1[2];
            aqL[10] = ai1[3];
            aqL[11] = ai1[0];
            _mth02CE(49, ai1, 0, aqJ, 40);
            aqJ[0] = ai2[0];
            aqJ[1] = ai2[1];
            aqJ[2] = ai2[2];
            aqJ[3] = ai2[3];
            _mth02CA(30, ai2, 0, aqJ, 12);
            _mth02CA(30, ai2, 0, aqJ, 28);
            _mth02CE(51, ai2, 0, aqK, 4);
            return;
        } else
        {
            aqK[4] = ai[0];
            aqK[5] = ai[1];
            aqK[6] = ai[2];
            aqK[7] = ai[3];
            _mth02CF(45, ai, 0, aqJ, 28);
            _mth02CB(15, ai, 0, aqL, 4);
            _mth02CB(17, ai, 0, aqJ, 12);
            _mth02CF(34, ai, 0, aqJ, 0);
            _mth02CB(15, ai, 4, aqJ, 40);
            _mth02CB(15, ai, 4, aqL, 8);
            _mth02CB(30, ai, 4, aqJ, 20);
            _mth02CF(34, ai, 4, aqJ, 8);
            _mth02CB(15, ai1, 0, aqJ, 36);
            _mth02CB(30, ai1, 0, aqJ, 24);
            aqL[2] = ai1[1];
            aqL[3] = ai1[2];
            aqL[0] = ai1[3];
            aqL[1] = ai1[0];
            _mth02CF(49, ai1, 0, aqJ, 4);
            aqJ[46] = ai2[0];
            aqJ[47] = ai2[1];
            aqJ[44] = ai2[2];
            aqJ[45] = ai2[3];
            _mth02CB(30, ai2, 0, aqJ, 32);
            _mth02CB(30, ai2, 0, aqJ, 16);
            _mth02CE(51, ai2, 0, aqK, 0);
            return;
        }
    }

    private void _mth02CA(int ai[], int ai1[], int i)
    {
        int l = ai[0] ^ ai1[i + 0];
        int j = FB54(l & 0xff);
        int k = aqT[l >>> 8 & 0xff];
        k = (byte)(k << 7 | (k & 0xff) >>> 1);
        byte byte0 = aqT[l >>> 16 & 0xff];
        byte0 = (byte)(byte0 << 1 | (byte0 & 0xff) >>> 7);
        l = aqT[l >>> 24];
        int k1 = ai[1] ^ ai1[i + 1];
        int i1 = aqT[k1 & 0xff];
        int j1 = FB54(k1 >>> 8 & 0xff);
        byte byte1 = aqT[k1 >>> 16 & 0xff];
        byte1 = (byte)(byte1 << 7 | (byte1 & 0xff) >>> 1);
        k1 = aqT[k1 >>> 24];
        i1 = i1 & 0xff | j1 << 8 | (byte1 & 0xff) << 16 | ((byte)(k1 << 1 | (k1 & 0xff) >>> 7) & 0xff) << 24;
        i1 = (i1 << 8) + (i1 >>> 24);
        j = (j | (k & 0xff) << 8 | (byte0 & 0xff) << 16 | (l & 0xff) << 24) ^ i1;
        k = (i1 << 8) + (i1 >>> 24) ^ j;
        j = (j >>> 8) + (j << 24) ^ k;
        ai[2] = ai[2] ^ ((k << 16) + (k >>> 16) ^ j);
        ai[3] = ai[3] ^ (j << 8) + (j >>> 24);
        l = ai[2] ^ ai1[i + 2];
        j = FB54(l & 0xff);
        k = aqT[l >>> 8 & 0xff];
        k = (byte)(k << 7 | (k & 0xff) >>> 1);
        byte0 = aqT[l >>> 16 & 0xff];
        byte0 = (byte)(byte0 << 1 | (byte0 & 0xff) >>> 7);
        l = aqT[l >>> 24];
        j1 = ai[3] ^ ai1[i + 3];
        i = aqT[j1 & 0xff];
        i1 = FB54(j1 >>> 8 & 0xff);
        k1 = aqT[j1 >>> 16 & 0xff];
        k1 = (byte)(k1 << 7 | (k1 & 0xff) >>> 1);
        j1 = aqT[j1 >>> 24];
        i = i & 0xff | i1 << 8 | (k1 & 0xff) << 16 | ((byte)(j1 << 1 | (j1 & 0xff) >>> 7) & 0xff) << 24;
        i = (i << 8) + (i >>> 24);
        j = (j | (k & 0xff) << 8 | (byte0 & 0xff) << 16 | (l & 0xff) << 24) ^ i;
        i = (i << 8) + (i >>> 24) ^ j;
        j = (j >>> 8) + (j << 24) ^ i;
        ai[0] = ai[0] ^ ((i << 16) + (i >>> 16) ^ j);
        ai[1] = ai[1] ^ (j << 8) + (j >>> 24);
    }

    private static void _mth02CB(int i, int ai[], int j, int ai1[], int k)
    {
        ai1[k + 2] = ai[j + 0] << i | ai[j + 1] >>> 32 - i;
        ai1[k + 3] = ai[j + 1] << i | ai[j + 2] >>> 32 - i;
        ai1[k + 0] = ai[j + 2] << i | ai[j + 3] >>> 32 - i;
        ai1[k + 1] = ai[j + 3] << i | ai[j + 0] >>> 32 - i;
        ai[j + 0] = ai1[k + 2];
        ai[j + 1] = ai1[k + 3];
        ai[j + 2] = ai1[k + 0];
        ai[j + 3] = ai1[k + 1];
    }

    private static void _mth02CB(int ai[], int ai1[], int i)
    {
        int j = ai[1];
        int k = ai[0] & ai1[i + 0];
        ai[1] = j ^ (k << 1) + (k >>> 31);
        ai[0] = ai[0] ^ (ai1[i + 1] | ai[1]);
        ai[2] = ai[2] ^ (ai1[i + 3] | ai[3]);
        j = ai[3];
        i = ai1[i + 2] & ai[2];
        ai[3] = j ^ (i << 1) + (i >>> 31);
    }

    private static void _mth02CE(int i, int ai[], int j, int ai1[], int k)
    {
        ai1[k + 0] = ai[j + 1] << i - 32 | ai[j + 2] >>> 64 - i;
        ai1[k + 1] = ai[j + 2] << i - 32 | ai[j + 3] >>> 64 - i;
        ai1[k + 2] = ai[j + 3] << i - 32 | ai[j + 0] >>> 64 - i;
        ai1[k + 3] = ai[j + 0] << i - 32 | ai[j + 1] >>> 64 - i;
        ai[j + 0] = ai1[k + 0];
        ai[j + 1] = ai1[k + 1];
        ai[j + 2] = ai1[k + 2];
        ai[j + 3] = ai1[k + 3];
    }

    private static void _mth02CF(int i, int ai[], int j, int ai1[], int k)
    {
        ai1[k + 2] = ai[j + 1] << i - 32 | ai[j + 2] >>> 64 - i;
        ai1[k + 3] = ai[j + 2] << i - 32 | ai[j + 3] >>> 64 - i;
        ai1[k + 0] = ai[j + 3] << i - 32 | ai[j + 0] >>> 64 - i;
        ai1[k + 1] = ai[j + 0] << i - 32 | ai[j + 1] >>> 64 - i;
        ai[j + 0] = ai1[k + 2];
        ai[j + 1] = ai1[k + 3];
        ai[j + 2] = ai1[k + 0];
        ai[j + 3] = ai1[k + 1];
    }

    private static int _mth1FBE(byte abyte0[], int i)
    {
        int k = 0;
        for (int j = 0; j < 4; j++)
        {
            k = (k << 8) + (abyte0[j + i] & 0xff);
        }

        return k;
    }

    private int FB54(int i)
    {
        byte abyte0[] = aqT;
        i = (byte)i;
        return abyte0[(byte)(i << 1 | (i & 0xff) >>> 7) & 0xff] & 0xff;
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
        if (!initialized)
        {
            throw new IllegalStateException("Camellia is not initialized");
        }
        if (i + 16 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 16 > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        if (aqS)
        {
            return _mth02BB(abyte0, i, abyte1, j);
        } else
        {
            return _mth02BC(abyte0, i, abyte1, j);
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof KeyParameter))
        {
            throw new IllegalArgumentException("only simple KeyParameter expected.");
        } else
        {
            _mth02CA(flag, ((KeyParameter)cipherparameters).key);
            initialized = true;
            return;
        }
    }

    public final String _mth14AC()
    {
        return "Camellia";
    }

}
