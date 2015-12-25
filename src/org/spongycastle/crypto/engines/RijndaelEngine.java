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

public class RijndaelEngine
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
    private static final byte asD[] = {
        0, 0, 25, 1, 50, 2, 26, -58, 75, -57, 
        27, 104, 51, -18, -33, 3, 100, 4, -32, 14, 
        52, -115, -127, -17, 76, 113, 8, -56, -8, 105, 
        28, -63, 125, -62, 29, -75, -7, -71, 39, 106, 
        77, -28, -90, 114, -102, -55, 9, 120, 101, 47, 
        -118, 5, 33, 15, -31, 36, 18, -16, -126, 69, 
        53, -109, -38, -114, -106, -113, -37, -67, 54, -48, 
        -50, -108, 19, 92, -46, -15, 64, 70, -125, 56, 
        102, -35, -3, 48, -65, 6, -117, 98, -77, 37, 
        -30, -104, 34, -120, -111, 16, 126, 110, 72, -61, 
        -93, -74, 30, 66, 58, 107, 40, 84, -6, -123, 
        61, -70, 43, 121, 10, 21, -101, -97, 94, -54, 
        78, -44, -84, -27, -13, 115, -89, 87, -81, 88, 
        -88, 80, -12, -22, -42, 116, 79, -82, -23, -43, 
        -25, -26, -83, -24, 44, -41, 117, 122, -21, 22, 
        11, -11, 89, -53, 95, -80, -100, -87, 81, -96, 
        127, 12, -10, 111, 23, -60, 73, -20, -40, 67, 
        31, 45, -92, 118, 123, -73, -52, -69, 62, 90, 
        -5, 96, -79, -122, 59, 82, -95, 108, -86, 85, 
        41, -99, -105, -78, -121, -112, 97, -66, -36, -4, 
        -68, -107, -49, -51, 55, 63, 91, -47, 83, 57, 
        -124, 60, 65, -94, 109, 71, 20, 42, -98, 93, 
        86, -14, -45, -85, 68, 17, -110, -39, 35, 32, 
        46, -119, -76, 124, -72, 38, 119, -103, -29, -91, 
        103, 74, -19, -34, -59, 49, -2, 24, 13, 99, 
        -116, -128, -64, -9, 112, 7
    };
    private static final byte asE[] = {
        0, 3, 5, 15, 17, 51, 85, -1, 26, 46, 
        114, -106, -95, -8, 19, 53, 95, -31, 56, 72, 
        -40, 115, -107, -92, -9, 2, 6, 10, 30, 34, 
        102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 
        106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 
        4, 12, 20, 60, 68, -52, 79, -47, 104, -72, 
        -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 
        77, -41, 98, -90, -15, 8, 24, 40, 120, -120, 
        -125, -98, -71, -48, 107, -67, -36, 127, -127, -104, 
        -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 
        16, 48, 80, -16, 11, 29, 39, 105, -69, -42, 
        97, -93, -2, 25, 43, 125, -121, -110, -83, -20, 
        47, 113, -109, -82, -23, 32, 96, -96, -5, 22, 
        58, 78, -46, 109, -73, -62, 93, -25, 50, 86, 
        -6, 21, 63, 65, -61, 94, -30, 61, 71, -55, 
        64, -64, 91, -19, 44, 116, -100, -65, -38, 117, 
        -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, 
        -68, -33, 122, -114, -119, -128, -101, -74, -63, 88, 
        -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, 
        -59, 84, -4, 31, 33, 99, -91, -12, 7, 9, 
        27, 45, 119, -103, -80, -53, 70, -54, 69, -49, 
        74, -34, 121, -117, -122, -111, -88, -29, 62, 66, 
        -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, 
        -115, -116, -113, -118, -123, -108, -89, -14, 13, 23, 
        57, 75, -35, 124, -124, -105, -94, -3, 28, 36, 
        108, -76, -57, 82, -10, 1, 3, 5, 15, 17, 
        51, 85, -1, 26, 46, 114, -106, -95, -8, 19, 
        53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 
        2, 6, 10, 30, 34, 102, -86, -27, 52, 92, 
        -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, 
        -85, -26, 49, 83, -11, 4, 12, 20, 60, 68, 
        -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, 
        -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 
        8, 24, 40, 120, -120, -125, -98, -71, -48, 107, 
        -67, -36, 127, -127, -104, -77, -50, 73, -37, 118, 
        -102, -75, -60, 87, -7, 16, 48, 80, -16, 11, 
        29, 39, 105, -69, -42, 97, -93, -2, 25, 43, 
        125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 
        32, 96, -96, -5, 22, 58, 78, -46, 109, -73, 
        -62, 93, -25, 50, 86, -6, 21, 63, 65, -61, 
        94, -30, 61, 71, -55, 64, -64, 91, -19, 44, 
        116, -100, -65, -38, 117, -97, -70, -43, 100, -84, 
        -17, 42, 126, -126, -99, -68, -33, 122, -114, -119, 
        -128, -101, -74, -63, 88, -24, 35, 101, -81, -22, 
        37, 111, -79, -56, 67, -59, 84, -4, 31, 33, 
        99, -91, -12, 7, 9, 27, 45, 119, -103, -80, 
        -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, 
        -111, -88, -29, 62, 66, -58, 81, -13, 14, 18, 
        54, 90, -18, 41, 123, -115, -116, -113, -118, -123, 
        -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, 
        -105, -94, -3, 28, 36, 108, -76, -57, 82, -10, 
        1
    };
    private static byte asF[][];
    private static byte asG[][] = {
        {
            0, 24, 16, 8
        }, {
            0, 32, 24, 16
        }, {
            0, 40, 32, 24
        }, {
            0, 48, 40, 24
        }, {
            0, 56, 40, 32
        }
    };
    private int BC;
    private boolean amy;
    private int aqb;
    private long asH;
    private int asI;
    private long asJ[][];
    private long asK;
    private long asL;
    private long asM;
    private long asN;
    private byte asO[];
    private byte asP[];

    public RijndaelEngine()
    {
        this(128);
    }

    private RijndaelEngine(int i)
    {
        BC = 32;
        asH = 0xffffffffL;
        asO = asF[0];
        asP = asG[0];
        asI = 128;
    }

    private void _mth02B3(byte abyte0[])
    {
        asK = _mth02CA(asK, abyte0);
        asL = _mth02CA(asL, abyte0);
        asM = _mth02CA(asM, abyte0);
        asN = _mth02CA(asN, abyte0);
    }

    private void _mth02BC(byte abyte0[], int i)
    {
        int j = i + 1;
        asK = abyte0[i] & 0xff;
        i = j + 1;
        asL = abyte0[j] & 0xff;
        int k = i + 1;
        asM = abyte0[i] & 0xff;
        j = k + 1;
        asN = abyte0[k] & 0xff;
        for (i = 8; i != BC; i += 8)
        {
            long l1 = asK;
            int l = j + 1;
            asK = l1 | (long)(abyte0[j] & 0xff) << i;
            l1 = asL;
            j = l + 1;
            asL = l1 | (long)(abyte0[l] & 0xff) << i;
            l1 = asM;
            l = j + 1;
            asM = l1 | (long)(abyte0[j] & 0xff) << i;
            l1 = asN;
            j = l + 1;
            asN = l1 | (long)(abyte0[l] & 0xff) << i;
        }

    }

    private void _mth02BD(byte abyte0[], int i)
    {
        boolean flag = false;
        int j = i;
        for (i = ((flag) ? 1 : 0); i != BC; i += 8)
        {
            int k = j + 1;
            abyte0[j] = (byte)(int)(asK >> i);
            j = k + 1;
            abyte0[k] = (byte)(int)(asL >> i);
            k = j + 1;
            abyte0[j] = (byte)(int)(asM >> i);
            j = k + 1;
            abyte0[k] = (byte)(int)(asN >> i);
        }

    }

    private long _mth02CA(long l, byte abyte0[])
    {
        long l1 = 0L;
        for (int i = 0; i < BC; i += 8)
        {
            l1 |= (long)(abyte0[(int)(l >> i & 255L)] & 0xff) << i;
        }

        return l1;
    }

    private void _mth02CA(long al[][])
    {
        _mth037A(al[0]);
        for (int i = 1; i < aqb; i++)
        {
            _mth02B3(anp);
            FF70(asO);
            long l1 = 0L;
            long l2 = 0L;
            long l3 = 0L;
            long l4 = 0L;
            for (int j = 0; j < BC; j += 8)
            {
                int i1 = (int)(asK >> j & 255L);
                int k = (int)(asL >> j & 255L);
                int l = (int)(asM >> j & 255L);
                int j1 = (int)(asN >> j & 255L);
                byte byte0;
                if (i1 != 0)
                {
                    byte0 = asE[(asD[i1] & 0xff) + 25];
                } else
                {
                    byte0 = 0;
                }
                byte byte1;
                if (k != 0)
                {
                    byte1 = asE[(asD[k] & 0xff) + 1];
                } else
                {
                    byte1 = 0;
                }
                l4 |= (long)((byte0 ^ byte1 ^ l ^ j1) & 0xff) << j;
                if (k != 0)
                {
                    byte0 = asE[(asD[k] & 0xff) + 25];
                } else
                {
                    byte0 = 0;
                }
                if (l != 0)
                {
                    byte1 = asE[(asD[l] & 0xff) + 1];
                } else
                {
                    byte1 = 0;
                }
                l3 |= (long)((byte0 ^ byte1 ^ j1 ^ i1) & 0xff) << j;
                if (l != 0)
                {
                    byte0 = asE[(asD[l] & 0xff) + 25];
                } else
                {
                    byte0 = 0;
                }
                if (j1 != 0)
                {
                    byte1 = asE[(asD[j1] & 0xff) + 1];
                } else
                {
                    byte1 = 0;
                }
                l2 |= (long)((byte0 ^ byte1 ^ i1 ^ k) & 0xff) << j;
                if (j1 != 0)
                {
                    byte0 = asE[(asD[j1] & 0xff) + 25];
                } else
                {
                    byte0 = 0;
                }
                if (i1 != 0)
                {
                    byte1 = asE[(asD[i1] & 0xff) + 1];
                } else
                {
                    byte1 = 0;
                }
                l1 |= (long)((byte0 ^ byte1 ^ k ^ l) & 0xff) << j;
            }

            asK = l4;
            asL = l3;
            asM = l2;
            asN = l1;
            _mth037A(al[i]);
        }

        _mth02B3(anp);
        FF70(asO);
        _mth037A(al[aqb]);
    }

    private void _mth02CB(long al[][])
    {
        _mth037A(al[aqb]);
        _mth02B3(apX);
        FF70(asP);
        for (int i = aqb - 1; i > 0; i--)
        {
            _mth037A(al[i]);
            long l1 = 0L;
            long l2 = 0L;
            long l3 = 0L;
            long l4 = 0L;
            for (int j = 0; j < BC; j += 8)
            {
                int k = (int)(asK >> j & 255L);
                int l = (int)(asL >> j & 255L);
                int i1 = (int)(asM >> j & 255L);
                int j1 = (int)(asN >> j & 255L);
                if (k != 0)
                {
                    k = asD[k & 0xff] & 0xff;
                } else
                {
                    k = -1;
                }
                if (l != 0)
                {
                    l = asD[l & 0xff] & 0xff;
                } else
                {
                    l = -1;
                }
                if (i1 != 0)
                {
                    i1 = asD[i1 & 0xff] & 0xff;
                } else
                {
                    i1 = -1;
                }
                if (j1 != 0)
                {
                    j1 = asD[j1 & 0xff] & 0xff;
                } else
                {
                    j1 = -1;
                }
                byte byte0;
                if (k >= 0)
                {
                    byte0 = asE[k + 223];
                } else
                {
                    byte0 = 0;
                }
                byte byte1;
                if (l >= 0)
                {
                    byte1 = asE[l + 104];
                } else
                {
                    byte1 = 0;
                }
                byte byte2;
                if (i1 >= 0)
                {
                    byte2 = asE[i1 + 238];
                } else
                {
                    byte2 = 0;
                }
                byte byte3;
                if (j1 >= 0)
                {
                    byte3 = asE[j1 + 199];
                } else
                {
                    byte3 = 0;
                }
                l4 |= (long)((byte0 ^ byte1 ^ byte2 ^ byte3) & 0xff) << j;
                if (l >= 0)
                {
                    byte0 = asE[l + 223];
                } else
                {
                    byte0 = 0;
                }
                if (i1 >= 0)
                {
                    byte1 = asE[i1 + 104];
                } else
                {
                    byte1 = 0;
                }
                if (j1 >= 0)
                {
                    byte2 = asE[j1 + 238];
                } else
                {
                    byte2 = 0;
                }
                if (k >= 0)
                {
                    byte3 = asE[k + 199];
                } else
                {
                    byte3 = 0;
                }
                l3 |= (long)((byte0 ^ byte1 ^ byte2 ^ byte3) & 0xff) << j;
                if (i1 >= 0)
                {
                    byte0 = asE[i1 + 223];
                } else
                {
                    byte0 = 0;
                }
                if (j1 >= 0)
                {
                    byte1 = asE[j1 + 104];
                } else
                {
                    byte1 = 0;
                }
                if (k >= 0)
                {
                    byte2 = asE[k + 238];
                } else
                {
                    byte2 = 0;
                }
                if (l >= 0)
                {
                    byte3 = asE[l + 199];
                } else
                {
                    byte3 = 0;
                }
                l2 |= (long)((byte0 ^ byte1 ^ byte2 ^ byte3) & 0xff) << j;
                if (j1 >= 0)
                {
                    j1 = asE[j1 + 223];
                } else
                {
                    j1 = 0;
                }
                if (k >= 0)
                {
                    k = asE[k + 104];
                } else
                {
                    k = 0;
                }
                if (l >= 0)
                {
                    l = asE[l + 238];
                } else
                {
                    l = 0;
                }
                if (i1 >= 0)
                {
                    i1 = asE[i1 + 199];
                } else
                {
                    i1 = 0;
                }
                l1 |= (long)((j1 ^ k ^ l ^ i1) & 0xff) << j;
            }

            asK = l4;
            asL = l3;
            asM = l2;
            asN = l1;
            _mth02B3(apX);
            FF70(asP);
        }

        _mth037A(al[0]);
    }

    private void _mth037A(long al[])
    {
        asK = asK ^ al[0];
        asL = asL ^ al[1];
        asM = asM ^ al[2];
        asN = asN ^ al[3];
    }

    private void FF70(byte abyte0[])
    {
        long l = asL;
        byte byte0 = abyte0[1];
        asL = (l >>> byte0 | l << BC - byte0) & asH;
        l = asM;
        byte0 = abyte0[2];
        asM = (l >>> byte0 | l << BC - byte0) & asH;
        l = asN;
        byte0 = abyte0[3];
        asN = (l >>> byte0 | l << BC - byte0) & asH;
    }

    public final int getBlockSize()
    {
        return BC / 2;
    }

    public final void reset()
    {
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (asJ == null)
        {
            throw new IllegalStateException("Rijndael engine not initialised");
        }
        if (BC / 2 + i > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (BC / 2 + j > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        if (amy)
        {
            _mth02BC(abyte0, i);
            _mth02CA(asJ);
            _mth02BD(abyte1, j);
        } else
        {
            _mth02BC(abyte0, i);
            _mth02CB(asJ);
            _mth02BD(abyte1, j);
        }
        return BC / 2;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof KeyParameter)
        {
            byte abyte0[] = ((KeyParameter)cipherparameters).key;
            boolean flag1 = false;
            int i = abyte0.length << 3;
            cipherparameters = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
                4, 64
            });
            long al[][] = (long[][])Array.newInstance(Long.TYPE, new int[] {
                15, 4
            });
            byte byte0;
            switch (i)
            {
            case 128: 
                byte0 = 4;
                break;

            case 160: 
                byte0 = 5;
                break;

            case 192: 
                byte0 = 6;
                break;

            case 224: 
                byte0 = 7;
                break;

            case 256: 
                byte0 = 8;
                break;

            default:
                throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
            }
            if (i >= asI)
            {
                aqb = byte0 + 6;
            } else
            {
                aqb = BC / 8 + 6;
            }
            i = 0;
            int i2 = 0;
            do
            {
                int j2 = i;
                if (i2 >= abyte0.length)
                {
                    break;
                }
                Object obj6 = cipherparameters[i2 % 4];
                int l2 = i2 / 4;
                i = j2 + 1;
                obj6[l2] = abyte0[j2];
                i2++;
            } while (true);
            i = 0;
            int i3 = 0;
            int k2;
            do
            {
                k2 = i;
                i2 = ((flag1) ? 1 : 0);
                if (i3 >= byte0)
                {
                    break;
                }
                k2 = i;
                i2 = ((flag1) ? 1 : 0);
                if (i >= (aqb + 1) * (BC / 8))
                {
                    break;
                }
                for (i2 = 0; i2 < 4; i2++)
                {
                    long al1[] = al[i / (BC / 8)];
                    al1[i2] = al1[i2] | (long)(cipherparameters[i2][i3] & 0xff) << (i << 3) % BC;
                }

                i3++;
                i++;
            } while (true);
            while (k2 < (aqb + 1) * (BC / 8)) 
            {
                for (int j = 0; j < 4; j++)
                {
                    Object obj = cipherparameters[j];
                    obj[0] = (byte)(obj[0] ^ anp[cipherparameters[(j + 1) % 4][byte0 - 1] & 0xff]);
                }

                Object obj1 = cipherparameters[0];
                int k = obj1[0];
                int ai[] = apY;
                int j3 = i2 + 1;
                obj1[0] = (byte)(k ^ ai[i2]);
                if (byte0 <= 6)
                {
                    for (int l = 1; l < byte0; l++)
                    {
                        for (i2 = 0; i2 < 4; i2++)
                        {
                            Object obj2 = cipherparameters[i2];
                            obj2[l] = (byte)(obj2[l] ^ cipherparameters[i2][l - 1]);
                        }

                    }

                } else
                {
                    for (int i1 = 1; i1 < 4; i1++)
                    {
                        for (i2 = 0; i2 < 4; i2++)
                        {
                            Object obj3 = cipherparameters[i2];
                            obj3[i1] = (byte)(obj3[i1] ^ cipherparameters[i2][i1 - 1]);
                        }

                    }

                    for (int j1 = 0; j1 < 4; j1++)
                    {
                        Object obj4 = cipherparameters[j1];
                        obj4[4] = (byte)(obj4[4] ^ anp[cipherparameters[j1][3] & 0xff]);
                    }

                    for (int k1 = 5; k1 < byte0; k1++)
                    {
                        for (i2 = 0; i2 < 4; i2++)
                        {
                            Object obj5 = cipherparameters[i2];
                            obj5[k1] = (byte)(obj5[k1] ^ cipherparameters[i2][k1 - 1]);
                        }

                    }

                }
                for (int l1 = 0; l1 < byte0 && k2 < (aqb + 1) * (BC / 8); k2++)
                {
                    for (i2 = 0; i2 < 4; i2++)
                    {
                        long al2[] = al[k2 / (BC / 8)];
                        al2[i2] = al2[i2] | (long)(cipherparameters[i2][l1] & 0xff) << (k2 << 3) % BC;
                    }

                    l1++;
                }

                i2 = j3;
            }
            asJ = al;
            amy = flag;
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to Rijndael init - ")).append(cipherparameters.getClass().getName()).toString());
        }
    }

    public final String _mth14AC()
    {
        return "Rijndael";
    }

    static 
    {
        byte abyte0[] = {
            0, 8, 16, 24
        };
        byte abyte1[] = {
            0, 8, 16, 32
        };
        byte abyte2[] = {
            0, 8, 24, 32
        };
        asF = (new byte[][] {
            new byte[] {
                0, 8, 16, 24
            }, abyte0, new byte[] {
                0, 8, 16, 24
            }, abyte1, abyte2
        });
    }
}
