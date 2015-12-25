// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.util.Hashtable;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class GOST28147Engine
    implements BlockCipher
{

    private static byte arA[] = {
        10, 4, 5, 6, 8, 1, 3, 7, 13, 12, 
        14, 0, 9, 2, 11, 15, 5, 15, 4, 0, 
        2, 13, 11, 9, 1, 7, 6, 3, 12, 14, 
        10, 8, 7, 15, 12, 14, 9, 4, 1, 0, 
        3, 11, 5, 2, 6, 10, 8, 13, 4, 10, 
        7, 12, 0, 15, 2, 8, 14, 1, 6, 5, 
        13, 11, 9, 3, 7, 6, 4, 11, 9, 12, 
        2, 10, 1, 8, 0, 14, 15, 13, 3, 5, 
        7, 6, 2, 4, 13, 9, 15, 0, 10, 1, 
        5, 11, 8, 14, 12, 3, 13, 14, 4, 1, 
        7, 0, 5, 10, 3, 12, 8, 15, 6, 2, 
        9, 11, 1, 3, 10, 9, 5, 11, 4, 15, 
        8, 6, 7, 14, 13, 0, 2, 12
    };
    private static Hashtable arB;
    private static byte art[] = {
        4, 10, 9, 2, 13, 8, 0, 14, 6, 11, 
        1, 12, 7, 15, 5, 3, 14, 11, 4, 12, 
        6, 13, 15, 10, 2, 3, 8, 1, 0, 7, 
        5, 9, 5, 8, 1, 13, 10, 3, 4, 2, 
        14, 15, 12, 7, 6, 0, 9, 11, 7, 13, 
        10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 
        11, 2, 5, 3, 6, 12, 7, 1, 5, 15, 
        13, 8, 4, 10, 9, 14, 0, 3, 11, 2, 
        4, 11, 10, 0, 7, 2, 1, 13, 3, 6, 
        8, 5, 9, 12, 15, 14, 13, 11, 4, 1, 
        3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 
        2, 12, 1, 15, 13, 0, 5, 7, 10, 4, 
        9, 2, 3, 14, 6, 11, 8, 12
    };
    private static byte aru[] = {
        4, 2, 15, 5, 9, 1, 0, 8, 14, 3, 
        11, 12, 13, 7, 10, 6, 12, 9, 15, 14, 
        8, 1, 3, 10, 2, 7, 4, 13, 6, 0, 
        11, 5, 13, 8, 14, 12, 7, 3, 9, 10, 
        1, 5, 2, 4, 6, 15, 0, 11, 14, 9, 
        11, 2, 5, 15, 7, 1, 0, 13, 12, 6, 
        10, 4, 3, 8, 3, 14, 5, 9, 6, 8, 
        0, 13, 10, 11, 7, 12, 2, 1, 15, 4, 
        8, 15, 6, 11, 1, 9, 12, 5, 13, 3, 
        7, 10, 0, 14, 2, 4, 9, 11, 12, 0, 
        3, 6, 7, 5, 4, 8, 14, 15, 1, 10, 
        2, 13, 12, 6, 5, 2, 11, 0, 9, 13, 
        3, 14, 7, 10, 15, 4, 1, 8
    };
    private static byte arv[] = {
        9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 
        14, 15, 12, 0, 13, 5, 3, 7, 14, 9, 
        8, 10, 15, 0, 5, 2, 6, 12, 11, 4, 
        13, 1, 14, 4, 6, 2, 11, 3, 13, 8, 
        12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 
        10, 12, 13, 1, 3, 9, 0, 2, 11, 4, 
        15, 8, 5, 6, 11, 5, 1, 9, 8, 13, 
        15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 
        3, 10, 13, 12, 1, 2, 0, 11, 7, 5, 
        9, 4, 8, 15, 14, 6, 1, 13, 2, 9, 
        7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 
        11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 
        6, 2, 3, 9, 1, 7, 13, 4
    };
    private static byte arw[] = {
        8, 4, 11, 1, 3, 5, 0, 9, 2, 14, 
        10, 12, 13, 6, 7, 15, 0, 1, 2, 10, 
        4, 13, 5, 12, 9, 7, 3, 15, 11, 8, 
        6, 14, 14, 12, 0, 10, 9, 2, 13, 11, 
        7, 5, 8, 15, 3, 6, 1, 4, 7, 5, 
        0, 13, 11, 6, 1, 2, 3, 10, 12, 15, 
        4, 14, 9, 8, 2, 7, 12, 15, 9, 5, 
        10, 11, 1, 4, 0, 13, 6, 8, 14, 3, 
        8, 3, 2, 6, 4, 13, 14, 11, 12, 1, 
        7, 15, 10, 0, 9, 5, 5, 2, 10, 11, 
        9, 1, 12, 3, 7, 4, 13, 0, 6, 15, 
        8, 14, 0, 4, 11, 14, 8, 3, 7, 1, 
        10, 2, 9, 6, 15, 13, 5, 12
    };
    private static byte arx[] = {
        1, 11, 12, 2, 9, 13, 0, 15, 4, 5, 
        8, 14, 10, 7, 6, 3, 0, 1, 7, 13, 
        11, 4, 5, 2, 8, 14, 15, 12, 9, 10, 
        6, 3, 8, 2, 5, 0, 4, 9, 15, 10, 
        3, 7, 12, 13, 6, 14, 1, 11, 3, 6, 
        0, 1, 5, 13, 10, 8, 11, 2, 9, 7, 
        14, 15, 12, 4, 8, 13, 11, 0, 4, 5, 
        1, 2, 9, 3, 12, 14, 6, 15, 10, 7, 
        12, 9, 11, 1, 8, 14, 2, 4, 7, 3, 
        6, 5, 10, 0, 15, 13, 10, 9, 6, 8, 
        13, 14, 2, 0, 15, 3, 5, 11, 4, 1, 
        12, 7, 7, 4, 0, 5, 10, 2, 15, 14, 
        12, 6, 1, 11, 13, 9, 3, 8
    };
    private static byte ary[] = {
        15, 12, 2, 10, 6, 4, 5, 0, 7, 9, 
        14, 13, 1, 11, 8, 3, 11, 6, 3, 4, 
        12, 15, 14, 2, 7, 13, 8, 0, 5, 10, 
        9, 1, 1, 12, 11, 0, 15, 14, 6, 5, 
        10, 13, 4, 8, 9, 3, 7, 2, 1, 5, 
        14, 12, 10, 7, 0, 13, 6, 2, 11, 4, 
        9, 3, 15, 8, 0, 12, 8, 9, 13, 2, 
        10, 11, 7, 3, 6, 5, 4, 14, 15, 1, 
        8, 0, 15, 3, 2, 5, 14, 11, 1, 10, 
        4, 7, 12, 9, 13, 6, 3, 0, 6, 15, 
        1, 14, 9, 2, 13, 8, 12, 4, 11, 10, 
        5, 7, 1, 10, 6, 8, 15, 11, 0, 4, 
        12, 3, 5, 9, 7, 13, 2, 14
    };
    private static byte arz[] = {
        4, 10, 9, 2, 13, 8, 0, 14, 6, 11, 
        1, 12, 7, 15, 5, 3, 14, 11, 4, 12, 
        6, 13, 15, 10, 2, 3, 8, 1, 0, 7, 
        5, 9, 5, 8, 1, 13, 10, 3, 4, 2, 
        14, 15, 12, 7, 6, 0, 9, 11, 7, 13, 
        10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 
        11, 2, 5, 3, 6, 12, 7, 1, 5, 15, 
        13, 8, 4, 10, 9, 14, 0, 3, 11, 2, 
        4, 11, 10, 0, 7, 2, 1, 13, 3, 6, 
        8, 5, 9, 12, 15, 14, 13, 11, 4, 1, 
        3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 
        2, 12, 1, 15, 13, 0, 5, 7, 10, 4, 
        9, 2, 3, 14, 6, 11, 8, 12
    };
    private boolean amy;
    private byte anp[];
    private int aqU[];

    public GOST28147Engine()
    {
        aqU = null;
        anp = art;
    }

    private static int _mth02BE(byte abyte0[], int i)
    {
        return (abyte0[i + 3] << 24 & 0xff000000) + (abyte0[i + 2] << 16 & 0xff0000) + (abyte0[i + 1] << 8 & 0xff00) + (abyte0[i] & 0xff);
    }

    private void _mth02CB(int ai[], byte abyte0[], int i, byte abyte1[], int j)
    {
        int k1 = _mth02BE(abyte0, i);
        int k = _mth02BE(abyte0, i + 4);
        int i2;
        if (amy)
        {
            int l = 0;
            i = k1;
            while (l < 3) 
            {
                boolean flag = false;
                k1 = k;
                for (k = ((flag) ? 1 : 0); k < 8;)
                {
                    int l1 = k1 ^ _mth141F(i, ai[k]);
                    k1 = i;
                    k++;
                    i = l1;
                }

                l++;
                k = k1;
            }
            for (int i1 = 7; i1 > 0;)
            {
                k1 = k ^ _mth141F(i, ai[i1]);
                k = i;
                i1--;
                i = k1;
            }

            k1 = i;
            i2 = k;
        } else
        {
            int j1 = 0;
            for (i = k1; j1 < 8; i = k1)
            {
                k1 = k ^ _mth141F(i, ai[j1]);
                k = i;
                j1++;
            }

            j1 = 0;
            do
            {
                k1 = i;
                i2 = k;
                if (j1 >= 3)
                {
                    break;
                }
                i2 = 7;
                k1 = k;
                for (k = i2; k >= 0 && (j1 != 2 || k != 0);)
                {
                    i2 = k1 ^ _mth141F(i, ai[k]);
                    k1 = i;
                    k--;
                    i = i2;
                }

                j1++;
                k = k1;
            } while (true);
        }
        i = _mth141F(k1, ai[0]);
        _mth02CE(k1, abyte1, j);
        _mth02CE(i2 ^ i, abyte1, j + 4);
    }

    private int[] _mth02CB(boolean flag, byte abyte0[])
    {
        amy = flag;
        if (abyte0.length != 32)
        {
            throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
        }
        int ai[] = new int[8];
        for (int i = 0; i != 8; i++)
        {
            ai[i] = _mth02BE(abyte0, i << 2);
        }

        return ai;
    }

    private static void _mth02CE(int i, byte abyte0[], int j)
    {
        abyte0[j + 3] = i >> 24;
        abyte0[j + 2] = (byte)(i >>> 16);
        abyte0[j + 1] = (byte)(i >>> 8);
        abyte0[j] = (byte)i;
    }

    private int _mth141F(int i, int j)
    {
        i += j;
        i = anp[(i & 0xf) + 0] + (anp[(i >> 4 & 0xf) + 16] << 4) + (anp[(i >> 8 & 0xf) + 32] << 8) + (anp[(i >> 12 & 0xf) + 48] << 12) + (anp[(i >> 16 & 0xf) + 64] << 16) + (anp[(i >> 20 & 0xf) + 80] << 20) + (anp[(i >> 24 & 0xf) + 96] << 24) + (anp[(i >> 28 & 0xf) + 112] << 28);
        return i << 11 | i >>> 21;
    }

    public static byte[] _mth1541(String s)
    {
        s = (byte[])arB.get(Strings.FE7C(s));
        if (s == null)
        {
            throw new IllegalArgumentException("Unknown S-Box - possible types: \"Default\", \"E-Test\", \"E-A\", \"E-B\", \"E-C\", \"E-D\", \"D-Test\", \"D-A\".");
        } else
        {
            return Arrays._mth1D4C(s);
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
        if (aqU == null)
        {
            throw new IllegalStateException("GOST28147 engine not initialised");
        }
        if (i + 8 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 8 > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        } else
        {
            _mth02CB(aqU, abyte0, i, abyte1, j);
            return 8;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof ParametersWithSBox)
        {
            cipherparameters = (ParametersWithSBox)cipherparameters;
            byte abyte0[] = ((ParametersWithSBox) (cipherparameters)).ank;
            if (abyte0.length != art.length)
            {
                throw new IllegalArgumentException("invalid S-box passed to GOST28147 init");
            }
            anp = Arrays._mth1D4C(abyte0);
            if (((ParametersWithSBox) (cipherparameters)).axC != null)
            {
                aqU = _mth02CB(flag, ((KeyParameter)((ParametersWithSBox) (cipherparameters)).axC).key);
            }
            return;
        }
        if (cipherparameters instanceof KeyParameter)
        {
            aqU = _mth02CB(flag, ((KeyParameter)cipherparameters).key);
            return;
        }
        if (cipherparameters != null)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to GOST28147 init - ")).append(cipherparameters.getClass().getName()).toString());
        } else
        {
            return;
        }
    }

    public final String _mth14AC()
    {
        return "GOST28147";
    }

    static 
    {
        arB = new Hashtable();
        byte abyte0[] = art;
        arB.put(Strings.FE7C("Default"), abyte0);
        abyte0 = aru;
        arB.put(Strings.FE7C("E-TEST"), abyte0);
        abyte0 = arv;
        arB.put(Strings.FE7C("E-A"), abyte0);
        abyte0 = arw;
        arB.put(Strings.FE7C("E-B"), abyte0);
        abyte0 = arx;
        arB.put(Strings.FE7C("E-C"), abyte0);
        abyte0 = ary;
        arB.put(Strings.FE7C("E-D"), abyte0);
        abyte0 = arz;
        arB.put(Strings.FE7C("D-TEST"), abyte0);
        abyte0 = arA;
        arB.put(Strings.FE7C("D-A"), abyte0);
    }
}
