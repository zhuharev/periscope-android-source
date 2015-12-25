// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public final class TwofishEngine
    implements BlockCipher
{

    private static final byte atA[][] = {
        {
            -87, 103, -77, -24, 4, -3, -93, 118, -102, -110, 
            -128, 120, -28, -35, -47, 56, 13, -58, 53, -104, 
            24, -9, -20, 108, 67, 117, 55, 38, -6, 19, 
            -108, 72, -14, -48, -117, 48, -124, 84, -33, 35, 
            25, 91, 61, 89, -13, -82, -94, -126, 99, 1, 
            -125, 46, -39, 81, -101, 124, -90, -21, -91, -66, 
            22, 12, -29, 97, -64, -116, 58, -11, 115, 44, 
            37, 11, -69, 78, -119, 107, 83, 106, -76, -15, 
            -31, -26, -67, 69, -30, -12, -74, 102, -52, -107, 
            3, 86, -44, 28, 30, -41, -5, -61, -114, -75, 
            -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, 
            98, 113, -127, 121, 9, -83, 36, -51, -7, -40, 
            -27, -59, -71, 77, 68, 8, -122, -25, -95, 29, 
            -86, -19, 6, 112, -78, -46, 65, 123, -96, 17, 
            49, -62, 39, -112, 32, -10, 96, -1, -106, 92, 
            -79, -85, -98, -100, 82, 27, 95, -109, 10, -17, 
            -111, -123, 73, -18, 45, 79, -113, 59, 71, -121, 
            109, 70, -42, 62, 105, 100, 42, -50, -53, 47, 
            -4, -105, 5, 122, -84, 127, -43, 26, 75, 14, 
            -89, 90, 40, 20, 63, 41, -120, 60, 76, 2, 
            -72, -38, -80, 23, 85, 31, -118, 125, 87, -57, 
            -115, 116, -73, -60, -97, 114, 126, 21, 34, 18, 
            88, 7, -103, 52, 110, 80, -34, 104, 101, -68, 
            -37, -8, -56, -88, 43, 64, -36, -2, 50, -92, 
            -54, 16, 33, -16, -45, 93, 15, 0, 111, -99, 
            54, 66, 74, 94, -63, -32
        }, {
            117, -13, -58, -12, -37, 123, -5, -56, 74, -45, 
            -26, 107, 69, 125, -24, 75, -42, 50, -40, -3, 
            55, 113, -15, -31, 48, 15, -8, 27, -121, -6, 
            6, 63, 94, -70, -82, 91, -118, 0, -68, -99, 
            109, -63, -79, 14, -128, 93, -46, -43, -96, -124, 
            7, 20, -75, -112, 44, -93, -78, 115, 76, 84, 
            -110, 116, 54, 81, 56, -80, -67, 90, -4, 96, 
            98, -106, 108, 66, -9, 16, 124, 40, 39, -116, 
            19, -107, -100, -57, 36, 70, 59, 112, -54, -29, 
            -123, -53, 17, -48, -109, -72, -90, -125, 32, -1, 
            -97, 119, -61, -52, 3, 111, 8, -65, 64, -25, 
            43, -30, 121, 12, -86, -126, 65, 58, -22, -71, 
            -28, -102, -92, -105, 126, -38, 122, 23, 102, -108, 
            -95, 29, 61, -16, -34, -77, 11, 114, -89, 28, 
            -17, -47, 83, 62, -113, 51, 38, 95, -20, 118, 
            42, 73, -127, -120, -18, 33, -60, 26, -21, -39, 
            -59, 57, -103, -51, -83, 49, -117, 1, 24, 35, 
            -35, 31, 78, 45, -7, 72, 79, -14, 101, -114, 
            120, 92, 88, 25, -115, -27, -104, 87, 103, 127, 
            5, 100, -81, 99, -74, -2, -11, -73, 60, -91, 
            -50, -23, 104, 68, -32, 77, 67, 105, 41, 46, 
            -84, 21, 89, -88, 10, -98, 110, 71, -33, 52, 
            53, 106, -49, -36, 34, -55, -64, -101, -119, -44, 
            -19, -85, 18, -94, 13, 82, -69, 2, 47, -87, 
            -41, 97, 30, -76, 80, 4, -10, -62, 22, 37, 
            -122, 86, 85, 9, -66, -111
        }
    };
    private boolean aqs;
    private byte aqt[];
    private int atB[];
    private int atC[];
    private int atD[];
    private int atE[];
    private int atF[];
    private int atG[];
    private int atH;

    public TwofishEngine()
    {
        aqs = false;
        atB = new int[256];
        atC = new int[256];
        atD = new int[256];
        atE = new int[256];
        atH = 0;
        aqt = null;
        int ai[] = new int[2];
        int ai1[] = new int[2];
        int ai2[] = new int[2];
        for (int i = 0; i < 256; i++)
        {
            int j = atA[0][i] & 0xff;
            ai[0] = j;
            char c;
            if ((j & 2) != 0)
            {
                c = '\264';
            } else
            {
                c = '\0';
            }
            char c1;
            if ((j & 1) != 0)
            {
                c1 = 'Z';
            } else
            {
                c1 = '\0';
            }
            ai1[0] = (j >> 2 ^ c ^ c1 ^ j) & 0xff;
            if ((j & 1) != 0)
            {
                c = '\264';
            } else
            {
                c = '\0';
            }
            if ((j & 2) != 0)
            {
                c1 = '\264';
            } else
            {
                c1 = '\0';
            }
            byte byte0;
            if ((j & 1) != 0)
            {
                byte0 = 90;
            } else
            {
                byte0 = 0;
            }
            ai2[0] = (j >> 1 ^ c ^ j ^ (j >> 2 ^ c1 ^ byte0)) & 0xff;
            j = atA[1][i] & 0xff;
            ai[1] = j;
            if ((j & 2) != 0)
            {
                c = '\264';
            } else
            {
                c = '\0';
            }
            if ((j & 1) != 0)
            {
                c1 = 'Z';
            } else
            {
                c1 = '\0';
            }
            ai1[1] = (j >> 2 ^ c ^ c1 ^ j) & 0xff;
            if ((j & 1) != 0)
            {
                c = '\264';
            } else
            {
                c = '\0';
            }
            if ((j & 2) != 0)
            {
                c1 = '\264';
            } else
            {
                c1 = '\0';
            }
            if ((j & 1) != 0)
            {
                byte0 = 90;
            } else
            {
                byte0 = 0;
            }
            ai2[1] = (j >> 1 ^ c ^ j ^ (j >> 2 ^ c1 ^ byte0)) & 0xff;
            atB[i] = ai[1] | ai1[1] << 8 | ai2[1] << 16 | ai2[1] << 24;
            atC[i] = ai2[0] | ai2[0] << 8 | ai1[0] << 16 | ai[0] << 24;
            atD[i] = ai1[1] | ai2[1] << 8 | ai[1] << 16 | ai2[1] << 24;
            atE[i] = ai1[0] | ai[0] << 8 | ai2[0] << 16 | ai1[0] << 24;
        }

    }

    private int _mth02CA(int i, int ai[])
    {
        int i2 = i & 0xff;
        int j1 = i >>> 8 & 0xff;
        int k = i >>> 16 & 0xff;
        int l = i >>> 24;
        int i3 = ai[0];
        int j3 = ai[1];
        int k3 = ai[2];
        int l3 = ai[3];
        int k2 = i2;
        int k1 = j1;
        int j = k;
        i = l;
        int l2 = i2;
        int j2 = j1;
        int l1 = k;
        int i1 = l;
        switch (atH & 3)
        {
        default:
            return 0;

        case 1: // '\001'
            return atB[atA[0][i2] & 0xff ^ i3 & 0xff] ^ atC[atA[0][j1] & 0xff ^ i3 >>> 8 & 0xff] ^ atD[atA[1][k] & 0xff ^ i3 >>> 16 & 0xff] ^ atE[atA[1][l] & 0xff ^ i3 >>> 24];

        case 0: // '\0'
            k2 = atA[1][i2] & 0xff ^ l3 & 0xff;
            k1 = atA[0][j1] & 0xff ^ l3 >>> 8 & 0xff;
            j = atA[0][k] & 0xff ^ l3 >>> 16 & 0xff;
            i = atA[1][l] & 0xff ^ l3 >>> 24;
            // fall through

        case 3: // '\003'
            l2 = atA[1][k2] & 0xff ^ k3 & 0xff;
            j2 = atA[1][k1] & 0xff ^ k3 >>> 8 & 0xff;
            l1 = atA[0][j] & 0xff ^ k3 >>> 16 & 0xff;
            i1 = atA[0][i] & 0xff ^ k3 >>> 24;
            // fall through

        case 2: // '\002'
            return atB[atA[0][atA[0][l2] & 0xff ^ j3 & 0xff] & 0xff ^ i3 & 0xff] ^ atC[atA[0][atA[1][j2] & 0xff ^ j3 >>> 8 & 0xff] & 0xff ^ i3 >>> 8 & 0xff] ^ atD[atA[1][atA[0][l1] & 0xff ^ j3 >>> 16 & 0xff] & 0xff ^ i3 >>> 16 & 0xff] ^ atE[atA[1][atA[1][i1] & 0xff ^ j3 >>> 24] & 0xff ^ i3 >>> 24];
        }
    }

    private static void _mth02CB(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)i;
        abyte0[j + 1] = (byte)(i >> 8);
        abyte0[j + 2] = (byte)(i >> 16);
        abyte0[j + 3] = i >> 24;
    }

    private void _mth02CB(byte abyte0[], int i, byte abyte1[], int j)
    {
        int l = _mth0640(abyte0, i) ^ atF[0];
        int k = _mth0640(abyte0, i + 4) ^ atF[1];
        int j1 = _mth0640(abyte0, i + 8) ^ atF[2];
        int i1 = _mth0640(abyte0, i + 12) ^ atF[3];
        int k1 = 8;
        for (i = 0; i < 16; i += 2)
        {
            int l1 = FBFE(l);
            int i2 = FE70(k);
            abyte0 = atF;
            int j2 = k1 + 1;
            j1 = l1 + i2 + abyte0[k1] ^ j1;
            j1 = j1 >>> 1 | j1 << 31;
            abyte0 = atF;
            k1 = j2 + 1;
            i1 = (i1 << 1 | i1 >>> 31) ^ i2 * 2 + l1 + abyte0[j2];
            l1 = FBFE(j1);
            i2 = FE70(i1);
            abyte0 = atF;
            j2 = k1 + 1;
            l = l1 + i2 + abyte0[k1] ^ l;
            l = l >>> 1 | l << 31;
            abyte0 = atF;
            k1 = j2 + 1;
            k = (k << 1 | k >>> 31) ^ i2 * 2 + l1 + abyte0[j2];
        }

        _mth02CB(atF[4] ^ j1, abyte1, j);
        _mth02CB(atF[5] ^ i1, abyte1, j + 4);
        _mth02CB(atF[6] ^ l, abyte1, j + 8);
        _mth02CB(atF[7] ^ k, abyte1, j + 12);
    }

    private void _mth02CE(byte abyte0[], int i, byte abyte1[], int j)
    {
        int k = _mth0640(abyte0, i) ^ atF[4];
        int l = _mth0640(abyte0, i + 4) ^ atF[5];
        int i1 = _mth0640(abyte0, i + 8) ^ atF[6];
        int j1 = _mth0640(abyte0, i + 12) ^ atF[7];
        int k1 = 39;
        for (i = 0; i < 16; i += 2)
        {
            int l1 = FBFE(k);
            int i2 = FE70(l);
            abyte0 = atF;
            int j2 = k1 - 1;
            j1 ^= i2 * 2 + l1 + abyte0[k1];
            abyte0 = atF;
            k1 = j2 - 1;
            i1 = (i1 << 1 | i1 >>> 31) ^ l1 + i2 + abyte0[j2];
            j1 = j1 >>> 1 | j1 << 31;
            l1 = FBFE(i1);
            i2 = FE70(j1);
            abyte0 = atF;
            j2 = k1 - 1;
            l ^= i2 * 2 + l1 + abyte0[k1];
            abyte0 = atF;
            k1 = j2 - 1;
            k = (k << 1 | k >>> 31) ^ l1 + i2 + abyte0[j2];
            l = l >>> 1 | l << 31;
        }

        _mth02CB(atF[0] ^ i1, abyte1, j);
        _mth02CB(atF[1] ^ j1, abyte1, j + 4);
        _mth02CB(atF[2] ^ k, abyte1, j + 8);
        _mth02CB(atF[3] ^ l, abyte1, j + 12);
    }

    private static int _mth0640(byte abyte0[], int i)
    {
        return abyte0[i] & 0xff | (abyte0[i + 1] & 0xff) << 8 | (abyte0[i + 2] & 0xff) << 16 | (abyte0[i + 3] & 0xff) << 24;
    }

    private int _mth1507(int i, int j)
    {
        boolean flag = false;
        int k = j;
        for (j = ((flag) ? 1 : 0); j < 4; j++)
        {
            k = FBE9(k);
        }

        j = k ^ i;
        for (i = 0; i < 4; i++)
        {
            j = FBE9(j);
        }

        return j;
    }

    private void _mth1D54(byte abyte0[])
    {
        int ai[] = new int[4];
        int ai1[] = new int[4];
        int ai2[] = new int[4];
        atF = new int[40];
        if (atH <= 0)
        {
            throw new IllegalArgumentException("Key size less than 64 bits");
        }
        if (atH > 4)
        {
            throw new IllegalArgumentException("Key size larger than 256 bits");
        }
        for (int i = 0; i < atH; i++)
        {
            int l = i << 3;
            ai[i] = _mth0640(abyte0, l);
            ai1[i] = _mth0640(abyte0, l + 4);
            ai2[atH - 1 - i] = _mth1507(ai[i], ai1[i]);
        }

        for (int j = 0; j < 20; j++)
        {
            int k1 = j * 0x2020202;
            int i1 = _mth02CA(k1, ai);
            k1 = _mth02CA(0x1010101 + k1, ai1);
            k1 = k1 << 8 | k1 >>> 24;
            i1 += k1;
            atF[j << 1] = i1;
            i1 += k1;
            atF[(j << 1) + 1] = i1 << 9 | i1 >>> 23;
        }

        int k4 = ai2[0];
        int l4 = ai2[1];
        int i5 = ai2[2];
        int j5 = ai2[3];
        atG = new int[1024];
        for (int k = 0; k < 256; k++)
        {
            int j1 = k;
            int l1 = k;
            int i2 = k;
            int j2 = k;
            int i4 = j2;
            int j3 = i2;
            int l2 = l1;
            int k2 = j1;
            int j4 = j2;
            int l3 = i2;
            int k3 = l1;
            int i3 = j1;
            switch (atH & 3)
            {
            case 1: // '\001'
                atG[k << 1] = atB[atA[0][j2] & 0xff ^ k4 & 0xff];
                atG[(k << 1) + 1] = atC[atA[0][i2] & 0xff ^ k4 >>> 8 & 0xff];
                atG[(k << 1) + 512] = atD[atA[1][l1] & 0xff ^ k4 >>> 16 & 0xff];
                atG[(k << 1) + 513] = atE[atA[1][j1] & 0xff ^ k4 >>> 24];
                break;

            case 0: // '\0'
                i4 = atA[1][j2] & 0xff ^ j5 & 0xff;
                j3 = atA[0][i2] & 0xff ^ j5 >>> 8 & 0xff;
                l2 = atA[0][l1] & 0xff ^ j5 >>> 16 & 0xff;
                k2 = atA[1][j1] & 0xff ^ j5 >>> 24;
                // fall through

            case 3: // '\003'
                j4 = atA[1][i4] & 0xff ^ i5 & 0xff;
                l3 = atA[1][j3] & 0xff ^ i5 >>> 8 & 0xff;
                k3 = atA[0][l2] & 0xff ^ i5 >>> 16 & 0xff;
                i3 = atA[0][k2] & 0xff ^ i5 >>> 24;
                // fall through

            case 2: // '\002'
                atG[k << 1] = atB[atA[0][atA[0][j4] & 0xff ^ l4 & 0xff] & 0xff ^ k4 & 0xff];
                atG[(k << 1) + 1] = atC[atA[0][atA[1][l3] & 0xff ^ l4 >>> 8 & 0xff] & 0xff ^ k4 >>> 8 & 0xff];
                atG[(k << 1) + 512] = atD[atA[1][atA[0][k3] & 0xff ^ l4 >>> 16 & 0xff] & 0xff ^ k4 >>> 16 & 0xff];
                atG[(k << 1) + 513] = atE[atA[1][atA[1][i3] & 0xff ^ l4 >>> 24] & 0xff ^ k4 >>> 24];
                break;
            }
        }

    }

    private static int FBE9(int i)
    {
        int k = i >>> 24;
        int j;
        if ((k & 0x80) != 0)
        {
            j = 333;
        } else
        {
            j = 0;
        }
        int l = (k << 1 ^ j) & 0xff;
        if ((k & 1) != 0)
        {
            j = 166;
        } else
        {
            j = 0;
        }
        j = k >>> 1 ^ j ^ l;
        return i << 8 ^ j << 24 ^ l << 16 ^ j << 8 ^ k;
    }

    private int FBFE(int i)
    {
        return atG[(i & 0xff) * 2 + 0] ^ atG[(i >>> 8 & 0xff) * 2 + 1] ^ atG[(i >>> 16 & 0xff) * 2 + 512] ^ atG[(i >>> 24) * 2 + 513];
    }

    private int FE70(int i)
    {
        return atG[(i >>> 24) * 2 + 0] ^ atG[(i & 0xff) * 2 + 1] ^ atG[(i >>> 8 & 0xff) * 2 + 512] ^ atG[(i >>> 16 & 0xff) * 2 + 513];
    }

    public final int getBlockSize()
    {
        return 16;
    }

    public final void reset()
    {
        if (aqt != null)
        {
            _mth1D54(aqt);
        }
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (aqt == null)
        {
            throw new IllegalStateException("Twofish not initialised");
        }
        if (i + 16 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 16 > abyte1.length)
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
        return 16;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof KeyParameter)
        {
            aqs = flag;
            aqt = ((KeyParameter)cipherparameters).key;
            atH = aqt.length / 8;
            _mth1D54(aqt);
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to Twofish init - ")).append(cipherparameters.getClass().getName()).toString());
        }
    }

    public final String _mth14AC()
    {
        return "Twofish";
    }

}
