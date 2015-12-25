// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;

public class GOST28147Mac
    implements Mac
{

    private int amw;
    private byte anp[] = {
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
    private int aqU[];
    private byte auC[];
    private int auF;
    private boolean auM;
    private byte buf[];
    private int kY;

    public GOST28147Mac()
    {
        kY = 8;
        auF = 4;
        auM = true;
        aqU = null;
        auC = new byte[kY];
        buf = new byte[kY];
        amw = 0;
    }

    private static int _mth02BE(byte abyte0[], int i)
    {
        return (abyte0[i + 3] << 24 & 0xff000000) + (abyte0[i + 2] << 16 & 0xff0000) + (abyte0[i + 1] << 8 & 0xff00) + (abyte0[i] & 0xff);
    }

    private static byte[] _mth02CA(byte abyte0[], int i, byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length - i];
        System.arraycopy(abyte0, i, abyte2, 0, abyte1.length);
        for (i = 0; i != abyte1.length; i++)
        {
            abyte2[i] = (byte)(abyte2[i] ^ abyte1[i]);
        }

        return abyte2;
    }

    private static void _mth02CE(int i, byte abyte0[], int j)
    {
        abyte0[j + 3] = i >> 24;
        abyte0[j + 2] = (byte)(i >>> 16);
        abyte0[j + 1] = (byte)(i >>> 8);
        abyte0[j] = (byte)i;
    }

    private void _mth02CF(int ai[], byte abyte0[], int i, byte abyte1[], int j)
    {
        i = _mth02BE(abyte0, 0);
        int k = _mth02BE(abyte0, 4);
        for (j = 0; j < 2; j++)
        {
            for (int l = 0; l < 8;)
            {
                int i1 = i + ai[l];
                i1 = anp[(i1 & 0xf) + 0] + (anp[(i1 >> 4 & 0xf) + 16] << 4) + (anp[(i1 >> 8 & 0xf) + 32] << 8) + (anp[(i1 >> 12 & 0xf) + 48] << 12) + (anp[(i1 >> 16 & 0xf) + 64] << 16) + (anp[(i1 >> 20 & 0xf) + 80] << 20) + (anp[(i1 >> 24 & 0xf) + 96] << 24) + (anp[(i1 >> 28 & 0xf) + 112] << 28);
                i1 = k ^ (i1 << 11 | i1 >>> 21);
                l++;
                k = i;
                i = i1;
            }

        }

        _mth02CE(i, abyte1, 0);
        _mth02CE(k, abyte1, 4);
    }

    private int[] _mth02EE(byte abyte0[])
    {
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

    public final int doFinal(byte abyte0[], int i)
    {
        for (; amw < kY; amw = amw + 1)
        {
            buf[amw] = 0;
        }

        byte abyte1[] = new byte[buf.length];
        System.arraycopy(buf, 0, abyte1, 0, auC.length);
        if (auM)
        {
            auM = false;
        } else
        {
            abyte1 = _mth02CA(buf, 0, auC);
        }
        _mth02CF(aqU, abyte1, 0, auC, 0);
        System.arraycopy(auC, auC.length / 2 - auF, abyte0, 0, auF);
        reset();
        return auF;
    }

    public final void reset()
    {
        for (int i = 0; i < buf.length; i++)
        {
            buf[i] = 0;
        }

        amw = 0;
        auM = true;
    }

    public final void update(byte byte0)
    {
        if (amw == buf.length)
        {
            byte abyte0[] = new byte[buf.length];
            System.arraycopy(buf, 0, abyte0, 0, auC.length);
            if (auM)
            {
                auM = false;
            } else
            {
                abyte0 = _mth02CA(buf, 0, auC);
            }
            _mth02CF(aqU, abyte0, 0, auC, 0);
            amw = 0;
        }
        byte abyte1[] = buf;
        int i = amw;
        amw = i + 1;
        abyte1[i] = byte0;
    }

    public final void update(byte abyte0[], int i, int j)
    {
        if (j < 0)
        {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i1 = kY - amw;
        int k = i;
        int l = j;
        if (j > i1)
        {
            System.arraycopy(abyte0, i, buf, amw, i1);
            byte abyte1[] = new byte[buf.length];
            System.arraycopy(buf, 0, abyte1, 0, auC.length);
            if (auM)
            {
                auM = false;
            } else
            {
                abyte1 = _mth02CA(buf, 0, auC);
            }
            _mth02CF(aqU, abyte1, 0, auC, 0);
            amw = 0;
            j -= i1;
            i += i1;
            do
            {
                k = i;
                l = j;
                if (j <= kY)
                {
                    break;
                }
                byte abyte2[] = _mth02CA(abyte0, i, auC);
                _mth02CF(aqU, abyte2, 0, auC, 0);
                j -= kY;
                i += kY;
            } while (true);
        }
        System.arraycopy(abyte0, k, buf, amw, l);
        amw = amw + l;
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        reset();
        buf = new byte[kY];
        if (cipherparameters instanceof ParametersWithSBox)
        {
            cipherparameters = (ParametersWithSBox)cipherparameters;
            System.arraycopy(((ParametersWithSBox) (cipherparameters)).ank, 0, anp, 0, ((ParametersWithSBox) (cipherparameters)).ank.length);
            if (((ParametersWithSBox) (cipherparameters)).axC != null)
            {
                aqU = _mth02EE(((KeyParameter)((ParametersWithSBox) (cipherparameters)).axC).key);
            }
            return;
        }
        if (cipherparameters instanceof KeyParameter)
        {
            aqU = _mth02EE(((KeyParameter)cipherparameters).key);
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to GOST28147 init - ")).append(cipherparameters.getClass().getName()).toString());
        }
    }

    public final String _mth14AC()
    {
        return "GOST28147Mac";
    }

    public final int _mth14B3()
    {
        return auF;
    }
}
