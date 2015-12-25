// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.OutputStream;

public class FB83
{

    private int lA;
    private boolean lB;
    private int lC;
    private int lD;
    private int lE;
    private int lF;
    private int lG;
    private int lH[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535
    };
    private int lI;
    private byte lJ[];
    int ln;
    int lo;
    private byte lp[];
    int lq;
    int lr;
    int ls;
    private int lt;
    private int lu;
    private int lv;
    private int lw;
    private int lx[];
    private int ly[];
    private int lz;

    public FB83()
    {
    }

    FB83(int i, int j, byte abyte0[], int k)
    {
        lu = 12;
        lw = 4096;
        lx = new int[5003];
        ly = new int[5003];
        lz = 5003;
        lA = 0;
        lB = false;
        lF = 0;
        lG = 0;
        lJ = new byte[256];
        ln = i;
        lo = j;
        lp = abyte0;
        lq = Math.max(2, k);
    }

    private void _mth02CA(byte byte0, OutputStream outputstream)
    {
        byte abyte0[] = lJ;
        int i = lI;
        lI = i + 1;
        abyte0[i] = byte0;
        if (lI >= 254)
        {
            _mth02CB(outputstream);
        }
    }

    private void _mth02CB(int i, OutputStream outputstream)
    {
        lF = lF & lH[lG];
        if (lG > 0)
        {
            lF = lF | i << lG;
        } else
        {
            lF = i;
        }
        for (lG = lG + lt; lG >= 8; lG = lG - 8)
        {
            _mth02CA((byte)lF, outputstream);
            lF = lF >> 8;
        }

        if (lA > lv || lB)
        {
            if (lB)
            {
                int j = lC;
                lt = j;
                lv = (1 << j) - 1;
                lB = false;
            } else
            {
                lt = lt + 1;
                if (lt == lu)
                {
                    lv = lw;
                } else
                {
                    lv = (1 << lt) - 1;
                }
            }
        }
        if (i == lE)
        {
            for (; lG > 0; lG = lG - 8)
            {
                _mth02CA((byte)lF, outputstream);
                lF = lF >> 8;
            }

            _mth02CB(outputstream);
        }
    }

    private void _mth02CB(OutputStream outputstream)
    {
        if (lI > 0)
        {
            outputstream.write(lI);
            outputstream.write(lJ, 0, lI);
            lI = 0;
        }
    }

    private int _mth141E()
    {
        if (lr == 0)
        {
            return -1;
        } else
        {
            lr = lr - 1;
            byte abyte0[] = lp;
            int i = ls;
            ls = i + 1;
            return abyte0[i] & 0xff;
        }
    }

    final void _mth02CA(int i, OutputStream outputstream)
    {
        lC = i;
        lB = false;
        lt = lC;
        lv = (1 << lt) - 1;
        lD = 1 << i - 1;
        lE = lD + 1;
        lA = lD + 2;
        lI = 0;
        int j = _mth141E();
        int j1 = 0;
        for (i = lz; i < 0x10000; i <<= 1)
        {
            j1++;
        }

        int l2 = lz;
        for (i = 0; i < l2; i++)
        {
            lx[i] = -1;
        }

        _mth02CB(lD, outputstream);
        i = j;
label0:
        do
        {
            int j2 = _mth141E();
            if (j2 == -1)
            {
                break;
            }
            int i3 = (j2 << lu) + i;
            int k = j2 << 8 - j1 ^ i;
            if (lx[k] == i3)
            {
                i = ly[k];
                continue;
            }
            int k1 = k;
            if (lx[k] >= 0)
            {
                k1 = l2 - k;
                int i2 = k;
                if (k == 0)
                {
                    k1 = 1;
                    i2 = k;
                }
                do
                {
                    int k2 = i2 - k1;
                    i2 = k2;
                    k = i2;
                    if (k2 < 0)
                    {
                        k = i2 + l2;
                    }
                    if (lx[k] == i3)
                    {
                        i = ly[k];
                        continue label0;
                    }
                    i2 = k;
                } while (lx[k] >= 0);
                k1 = k;
            }
            _mth02CB(i, outputstream);
            i = j2;
            if (lA < lw)
            {
                int ai[] = ly;
                int l = lA;
                lA = l + 1;
                ai[k1] = l;
                lx[k1] = i3;
            } else
            {
                int l1 = lz;
                for (int i1 = 0; i1 < l1; i1++)
                {
                    lx[i1] = -1;
                }

                lA = lD + 2;
                lB = true;
                _mth02CB(lD, outputstream);
            }
        } while (true);
        _mth02CB(i, outputstream);
        _mth02CB(lE, outputstream);
    }
}
