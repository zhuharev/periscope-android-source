// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.lang.reflect.Array;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class AESLightEngine
    implements BlockCipher
{

    private static final byte anp[] = {
        99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 
        103, 43, -2, -41, -85, 118, -54, -126, -55, 125, 
        -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 
        114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 
        52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 
        35, -61, 24, -106, 5, -102, 7, 18, -128, -30, 
        -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 
        90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 
        83, -47, 0, -19, 32, -4, -79, 91, 106, -53, 
        -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 
        67, 77, 51, -123, 69, -7, 2, 127, 80, 60, 
        -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, 
        -68, -74, -38, 33, 16, -1, -13, -46, -51, 12, 
        19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 
        100, 93, 25, 115, 96, -127, 79, -36, 34, 42, 
        -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, 
        -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, 
        -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, 
        -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, 
        -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, 
        -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, 
        -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, 
        -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, 
        -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, 
        -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 
        45, 15, -80, 84, -69, 22
    };
    private static final byte apX[] = {
        82, 9, 106, -43, 48, 54, -91, 56, -65, 64, 
        -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, 
        -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, 
        -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, 
        -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, 
        -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 
        109, -117, -47, 37, 114, -8, -10, 100, -122, 104, 
        -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 
        108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 
        70, 87, -89, -115, -99, -124, -112, -40, -85, 0, 
        -116, -68, -45, 10, -9, -28, 88, 5, -72, -77, 
        69, 6, -48, 44, 30, -113, -54, 63, 15, 2, 
        -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 
        17, 65, 79, 103, -36, -22, -105, -14, -49, -50, 
        -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 
        53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 
        71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 
        98, 14, -86, 24, -66, 27, -4, 86, 62, 75, 
        -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 
        90, -12, 31, -35, -88, 51, -120, 7, -57, 49, 
        -79, 18, 16, 89, 39, -128, -20, 95, 96, 81, 
        127, -87, 25, -75, 74, 13, 45, -27, 122, -97, 
        -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, 
        -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 
        23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 
        20, 99, 85, 33, 12, 125
    };
    private static final int apY[] = {
        1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 
        108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 
        151, 53, 106, 212, 179, 125, 250, 239, 197, 145
    };
    private boolean amy;
    private int aqb;
    private int aqc[][];
    private int aqd;
    private int aqe;
    private int aqf;
    private int aqg;

    public AESLightEngine()
    {
        aqc = null;
    }

    private void _mth02BC(byte abyte0[], int i)
    {
        int j = i + 1;
        aqd = abyte0[i] & 0xff;
        int k = aqd;
        i = j + 1;
        aqd = k | (abyte0[j] & 0xff) << 8;
        k = aqd;
        j = i + 1;
        aqd = k | (abyte0[i] & 0xff) << 16;
        k = aqd;
        i = j + 1;
        aqd = k | abyte0[j] << 24;
        j = i + 1;
        aqe = abyte0[i] & 0xff;
        k = aqe;
        i = j + 1;
        aqe = k | (abyte0[j] & 0xff) << 8;
        k = aqe;
        j = i + 1;
        aqe = k | (abyte0[i] & 0xff) << 16;
        k = aqe;
        i = j + 1;
        aqe = k | abyte0[j] << 24;
        j = i + 1;
        aqf = abyte0[i] & 0xff;
        k = aqf;
        i = j + 1;
        aqf = k | (abyte0[j] & 0xff) << 8;
        k = aqf;
        j = i + 1;
        aqf = k | (abyte0[i] & 0xff) << 16;
        k = aqf;
        i = j + 1;
        aqf = k | abyte0[j] << 24;
        j = i + 1;
        aqg = abyte0[i] & 0xff;
        i = aqg;
        k = j + 1;
        aqg = i | (abyte0[j] & 0xff) << 8;
        aqg = aqg | (abyte0[k] & 0xff) << 16;
        aqg = aqg | abyte0[k + 1] << 24;
    }

    private void _mth02BD(byte abyte0[], int i)
    {
        int j = i + 1;
        abyte0[i] = (byte)aqd;
        i = j + 1;
        abyte0[j] = (byte)(aqd >> 8);
        j = i + 1;
        abyte0[i] = (byte)(aqd >> 16);
        i = j + 1;
        abyte0[j] = aqd >> 24;
        j = i + 1;
        abyte0[i] = (byte)aqe;
        i = j + 1;
        abyte0[j] = (byte)(aqe >> 8);
        j = i + 1;
        abyte0[i] = (byte)(aqe >> 16);
        i = j + 1;
        abyte0[j] = aqe >> 24;
        j = i + 1;
        abyte0[i] = (byte)aqf;
        i = j + 1;
        abyte0[j] = (byte)(aqf >> 8);
        j = i + 1;
        abyte0[i] = (byte)(aqf >> 16);
        i = j + 1;
        abyte0[j] = aqf >> 24;
        j = i + 1;
        abyte0[i] = (byte)aqg;
        i = j + 1;
        abyte0[j] = (byte)(aqg >> 8);
        abyte0[i] = (byte)(aqg >> 16);
        abyte0[i + 1] = aqg >> 24;
    }

    private void _mth02CA(int ai[][])
    {
        int j = aqd ^ ai[0][0];
        int k = aqe ^ ai[0][1];
        int l = aqf ^ ai[0][2];
        int i = 1;
        int i1;
        int j1;
        for (i1 = aqg ^ ai[0][3]; i < aqb - 1; i1 = j1 ^ ai[i1][3])
        {
            j1 = _mth2160(anp[j & 0xff] & 0xff ^ (anp[k >> 8 & 0xff] & 0xff) << 8 ^ (anp[l >> 16 & 0xff] & 0xff) << 16 ^ anp[i1 >>> 24] << 24) ^ ai[i][0];
            int l1 = _mth2160(anp[k & 0xff] & 0xff ^ (anp[l >> 8 & 0xff] & 0xff) << 8 ^ (anp[i1 >> 16 & 0xff] & 0xff) << 16 ^ anp[j >>> 24] << 24) ^ ai[i][1];
            int j2 = _mth2160(anp[l & 0xff] & 0xff ^ (anp[i1 >> 8 & 0xff] & 0xff) << 8 ^ (anp[j >> 16 & 0xff] & 0xff) << 16 ^ anp[k >>> 24] << 24) ^ ai[i][2];
            j = _mth2160(anp[i1 & 0xff] & 0xff ^ (anp[j >> 8 & 0xff] & 0xff) << 8 ^ (anp[k >> 16 & 0xff] & 0xff) << 16 ^ anp[l >>> 24] << 24);
            i1 = i + 1;
            i = j ^ ai[i][3];
            j = _mth2160(anp[j1 & 0xff] & 0xff ^ (anp[l1 >> 8 & 0xff] & 0xff) << 8 ^ (anp[j2 >> 16 & 0xff] & 0xff) << 16 ^ anp[i >>> 24] << 24) ^ ai[i1][0];
            k = _mth2160(anp[l1 & 0xff] & 0xff ^ (anp[j2 >> 8 & 0xff] & 0xff) << 8 ^ (anp[i >> 16 & 0xff] & 0xff) << 16 ^ anp[j1 >>> 24] << 24) ^ ai[i1][1];
            l = _mth2160(anp[j2 & 0xff] & 0xff ^ (anp[i >> 8 & 0xff] & 0xff) << 8 ^ (anp[j1 >> 16 & 0xff] & 0xff) << 16 ^ anp[l1 >>> 24] << 24) ^ ai[i1][2];
            j1 = _mth2160(anp[i & 0xff] & 0xff ^ (anp[j1 >> 8 & 0xff] & 0xff) << 8 ^ (anp[l1 >> 16 & 0xff] & 0xff) << 16 ^ anp[j2 >>> 24] << 24);
            i = i1 + 1;
        }

        int k1 = _mth2160(anp[j & 0xff] & 0xff ^ (anp[k >> 8 & 0xff] & 0xff) << 8 ^ (anp[l >> 16 & 0xff] & 0xff) << 16 ^ anp[i1 >>> 24] << 24) ^ ai[i][0];
        int i2 = _mth2160(anp[k & 0xff] & 0xff ^ (anp[l >> 8 & 0xff] & 0xff) << 8 ^ (anp[i1 >> 16 & 0xff] & 0xff) << 16 ^ anp[j >>> 24] << 24) ^ ai[i][1];
        int k2 = _mth2160(anp[l & 0xff] & 0xff ^ (anp[i1 >> 8 & 0xff] & 0xff) << 8 ^ (anp[j >> 16 & 0xff] & 0xff) << 16 ^ anp[k >>> 24] << 24) ^ ai[i][2];
        k = _mth2160(anp[i1 & 0xff] & 0xff ^ (anp[j >> 8 & 0xff] & 0xff) << 8 ^ (anp[k >> 16 & 0xff] & 0xff) << 16 ^ anp[l >>> 24] << 24);
        j = i + 1;
        i = k ^ ai[i][3];
        aqd = anp[k1 & 0xff] & 0xff ^ (anp[i2 >> 8 & 0xff] & 0xff) << 8 ^ (anp[k2 >> 16 & 0xff] & 0xff) << 16 ^ anp[i >>> 24] << 24 ^ ai[j][0];
        aqe = anp[i2 & 0xff] & 0xff ^ (anp[k2 >> 8 & 0xff] & 0xff) << 8 ^ (anp[i >> 16 & 0xff] & 0xff) << 16 ^ anp[k1 >>> 24] << 24 ^ ai[j][1];
        aqf = anp[k2 & 0xff] & 0xff ^ (anp[i >> 8 & 0xff] & 0xff) << 8 ^ (anp[k1 >> 16 & 0xff] & 0xff) << 16 ^ anp[i2 >>> 24] << 24 ^ ai[j][2];
        aqg = anp[i & 0xff] & 0xff ^ (anp[k1 >> 8 & 0xff] & 0xff) << 8 ^ (anp[i2 >> 16 & 0xff] & 0xff) << 16 ^ anp[k2 >>> 24] << 24 ^ ai[j][3];
    }

    private void _mth02CB(int ai[][])
    {
        int j = aqd ^ ai[aqb][0];
        int k = aqe ^ ai[aqb][1];
        int l = aqf ^ ai[aqb][2];
        int i = aqb - 1;
        int i1;
        int j1;
        for (i1 = aqg ^ ai[aqb][3]; i > 1; i1 = j1 ^ ai[i1][3])
        {
            j1 = _mth2170(apX[j & 0xff] & 0xff ^ (apX[i1 >> 8 & 0xff] & 0xff) << 8 ^ (apX[l >> 16 & 0xff] & 0xff) << 16 ^ apX[k >>> 24] << 24) ^ ai[i][0];
            int l1 = _mth2170(apX[k & 0xff] & 0xff ^ (apX[j >> 8 & 0xff] & 0xff) << 8 ^ (apX[i1 >> 16 & 0xff] & 0xff) << 16 ^ apX[l >>> 24] << 24) ^ ai[i][1];
            int j2 = _mth2170(apX[l & 0xff] & 0xff ^ (apX[k >> 8 & 0xff] & 0xff) << 8 ^ (apX[j >> 16 & 0xff] & 0xff) << 16 ^ apX[i1 >>> 24] << 24) ^ ai[i][2];
            j = _mth2170(apX[i1 & 0xff] & 0xff ^ (apX[l >> 8 & 0xff] & 0xff) << 8 ^ (apX[k >> 16 & 0xff] & 0xff) << 16 ^ apX[j >>> 24] << 24);
            i1 = i - 1;
            i = j ^ ai[i][3];
            j = _mth2170(apX[j1 & 0xff] & 0xff ^ (apX[i >> 8 & 0xff] & 0xff) << 8 ^ (apX[j2 >> 16 & 0xff] & 0xff) << 16 ^ apX[l1 >>> 24] << 24) ^ ai[i1][0];
            k = _mth2170(apX[l1 & 0xff] & 0xff ^ (apX[j1 >> 8 & 0xff] & 0xff) << 8 ^ (apX[i >> 16 & 0xff] & 0xff) << 16 ^ apX[j2 >>> 24] << 24) ^ ai[i1][1];
            l = _mth2170(apX[j2 & 0xff] & 0xff ^ (apX[l1 >> 8 & 0xff] & 0xff) << 8 ^ (apX[j1 >> 16 & 0xff] & 0xff) << 16 ^ apX[i >>> 24] << 24) ^ ai[i1][2];
            j1 = _mth2170(apX[i & 0xff] & 0xff ^ (apX[j2 >> 8 & 0xff] & 0xff) << 8 ^ (apX[l1 >> 16 & 0xff] & 0xff) << 16 ^ apX[j1 >>> 24] << 24);
            i = i1 - 1;
        }

        int k1 = _mth2170(apX[j & 0xff] & 0xff ^ (apX[i1 >> 8 & 0xff] & 0xff) << 8 ^ (apX[l >> 16 & 0xff] & 0xff) << 16 ^ apX[k >>> 24] << 24) ^ ai[i][0];
        int i2 = _mth2170(apX[k & 0xff] & 0xff ^ (apX[j >> 8 & 0xff] & 0xff) << 8 ^ (apX[i1 >> 16 & 0xff] & 0xff) << 16 ^ apX[l >>> 24] << 24) ^ ai[i][1];
        int k2 = _mth2170(apX[l & 0xff] & 0xff ^ (apX[k >> 8 & 0xff] & 0xff) << 8 ^ (apX[j >> 16 & 0xff] & 0xff) << 16 ^ apX[i1 >>> 24] << 24) ^ ai[i][2];
        i = _mth2170(apX[i1 & 0xff] & 0xff ^ (apX[l >> 8 & 0xff] & 0xff) << 8 ^ (apX[k >> 16 & 0xff] & 0xff) << 16 ^ apX[j >>> 24] << 24) ^ ai[i][3];
        aqd = apX[k1 & 0xff] & 0xff ^ (apX[i >> 8 & 0xff] & 0xff) << 8 ^ (apX[k2 >> 16 & 0xff] & 0xff) << 16 ^ apX[i2 >>> 24] << 24 ^ ai[0][0];
        aqe = apX[i2 & 0xff] & 0xff ^ (apX[k1 >> 8 & 0xff] & 0xff) << 8 ^ (apX[i >> 16 & 0xff] & 0xff) << 16 ^ apX[k2 >>> 24] << 24 ^ ai[0][1];
        aqf = apX[k2 & 0xff] & 0xff ^ (apX[i2 >> 8 & 0xff] & 0xff) << 8 ^ (apX[k1 >> 16 & 0xff] & 0xff) << 16 ^ apX[i >>> 24] << 24 ^ ai[0][2];
        aqg = apX[i & 0xff] & 0xff ^ (apX[k2 >> 8 & 0xff] & 0xff) << 8 ^ (apX[i2 >> 16 & 0xff] & 0xff) << 16 ^ apX[k1 >>> 24] << 24 ^ ai[0][3];
    }

    private static int _mth207F(int i)
    {
        return anp[i & 0xff] & 0xff | (anp[i >> 8 & 0xff] & 0xff) << 8 | (anp[i >> 16 & 0xff] & 0xff) << 16 | anp[i >>> 24] << 24;
    }

    private static int _mth2160(int i)
    {
        int j = (0x7f7f7f7f & i) << 1 ^ ((0x80808080 & i) >>> 7) * 27;
        int k = i ^ j;
        return j ^ (k >>> 8 | k << -8) ^ (i >>> 16 | i << -16) ^ (i >>> 24 | i << -24);
    }

    private static int _mth2170(int i)
    {
        int j = (0x7f7f7f7f & i) << 1 ^ ((0x80808080 & i) >>> 7) * 27;
        int k = (j & 0x7f7f7f7f) << 1 ^ ((0x80808080 & j) >>> 7) * 27;
        int l = (k & 0x7f7f7f7f) << 1 ^ ((0x80808080 & k) >>> 7) * 27;
        i ^= l;
        int i1 = j ^ i;
        int j1 = k ^ i;
        return j ^ k ^ l ^ (i1 >>> 8 | i1 << -8) ^ (j1 >>> 16 | j1 << -16) ^ (i >>> 24 | i << -24);
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
        if (aqc == null)
        {
            throw new IllegalStateException("AES engine not initialised");
        }
        if (i + 16 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 16 > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        if (amy)
        {
            _mth02BC(abyte0, i);
            _mth02CA(aqc);
            _mth02BD(abyte1, j);
        } else
        {
            _mth02BC(abyte0, i);
            _mth02CB(aqc);
            _mth02BD(abyte1, j);
        }
        return 16;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof KeyParameter)
        {
            cipherparameters = ((KeyParameter)cipherparameters).key;
            int k1 = cipherparameters.length / 4;
            if (k1 != 4 && k1 != 6 && k1 != 8 || k1 << 2 != cipherparameters.length)
            {
                throw new IllegalArgumentException("Key length not 128/192/256 bits.");
            }
            aqb = k1 + 6;
            int i = aqb;
            int ai[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
                i + 1, 4
            });
            i = 0;
            for (int l = 0; l < cipherparameters.length;)
            {
                ai[i >> 2][i & 3] = cipherparameters[l] & 0xff | (cipherparameters[l + 1] & 0xff) << 8 | (cipherparameters[l + 2] & 0xff) << 16 | cipherparameters[l + 3] << 24;
                l += 4;
                i++;
            }

            int i2 = aqb;
            for (int i1 = k1; i1 < i2 + 1 << 2; i1++)
            {
                int l1 = ai[i1 - 1 >> 2][i1 - 1 & 3];
                int j;
                if (i1 % k1 == 0)
                {
                    j = _mth207F(l1 >>> 8 | l1 << -8) ^ apY[i1 / k1 - 1];
                } else
                {
                    j = l1;
                    if (k1 > 6)
                    {
                        j = l1;
                        if (i1 % k1 == 4)
                        {
                            j = _mth207F(l1);
                        }
                    }
                }
                ai[i1 >> 2][i1 & 3] = ai[i1 - k1 >> 2][i1 - k1 & 3] ^ j;
            }

            if (!flag)
            {
                for (int k = 1; k < aqb; k++)
                {
                    for (int j1 = 0; j1 < 4; j1++)
                    {
                        ai[k][j1] = _mth2170(ai[k][j1]);
                    }

                }

            }
            aqc = ai;
            amy = flag;
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to AES init - ")).append(cipherparameters.getClass().getName()).toString());
        }
    }

    public final String _mth14AC()
    {
        return "AES";
    }

}
