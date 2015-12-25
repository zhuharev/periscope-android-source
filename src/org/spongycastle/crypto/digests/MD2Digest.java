// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;

public class MD2Digest
    implements ExtendedDigest, Memoable
{

    private static final byte anp[] = {
        41, 46, 67, -55, -94, -40, 124, 1, 61, 54, 
        84, -95, -20, -16, 6, 19, 98, -89, 5, -13, 
        -64, -57, 115, -116, -104, -109, 43, -39, -68, 76, 
        -126, -54, 30, -101, 87, 60, -3, -44, -32, 22, 
        103, 66, 111, 24, -118, 23, -27, 18, -66, 78, 
        -60, -42, -38, -98, -34, 73, -96, -5, -11, -114, 
        -69, 47, -18, 122, -87, 104, 121, -111, 21, -78, 
        7, 63, -108, -62, 16, -119, 11, 34, 95, 33, 
        -128, 127, 93, -102, 90, -112, 50, 39, 53, 62, 
        -52, -25, -65, -9, -105, 3, -1, 25, 48, -77, 
        72, -91, -75, -47, -41, 94, -110, 42, -84, 86, 
        -86, -58, 79, -72, 56, -46, -106, -92, 125, -74, 
        118, -4, 107, -30, -100, 116, 4, -15, 69, -99, 
        112, 89, 100, 113, -121, 32, -122, 91, -49, 101, 
        -26, 45, -88, 2, 27, 96, 37, -83, -82, -80, 
        -71, -10, 28, 70, 97, 105, 52, 64, 126, 15, 
        85, 71, -93, 35, -35, 81, -81, 58, -61, 92, 
        -7, -50, -70, -59, -22, 38, 44, 83, 13, 110, 
        -123, 40, -124, 9, -45, -33, -51, -12, 65, -127, 
        77, 82, 106, -36, 55, -56, 108, -63, -85, -6, 
        36, -31, 123, 8, 12, -67, -79, 74, 120, -120, 
        -107, -117, -29, 99, -24, 109, -23, -53, -43, -2, 
        59, 0, 29, 57, -14, -17, -73, 14, 102, 88, 
        -48, -28, -90, 119, 114, -8, -21, 117, 75, 10, 
        49, 68, 80, -76, -113, -19, 31, 26, -37, -103, 
        -115, 51, -97, 17, -125, 20
    };
    private byte anH[];
    private int anI;
    private int anJ;
    private byte anK[];
    private int anL;
    private byte ane[];

    public MD2Digest()
    {
        anH = new byte[48];
        ane = new byte[16];
        anK = new byte[16];
        reset();
    }

    public MD2Digest(MD2Digest md2digest)
    {
        anH = new byte[48];
        ane = new byte[16];
        anK = new byte[16];
        _mth02CA(md2digest);
    }

    private void _mth02CA(MD2Digest md2digest)
    {
        System.arraycopy(md2digest.anH, 0, anH, 0, md2digest.anH.length);
        anI = md2digest.anI;
        System.arraycopy(md2digest.ane, 0, ane, 0, md2digest.ane.length);
        anJ = md2digest.anJ;
        System.arraycopy(md2digest.anK, 0, anK, 0, md2digest.anK.length);
        anL = md2digest.anL;
    }

    private void _mth0674(byte abyte0[])
    {
        byte byte0 = anK[15];
        for (int i = 0; i < 16; i++)
        {
            byte abyte1[] = anK;
            abyte1[i] = (byte)(abyte1[i] ^ anp[(abyte0[i] ^ byte0) & 0xff]);
            byte0 = anK[i];
        }

    }

    private void _mth1D35(byte abyte0[])
    {
        for (int i = 0; i < 16; i++)
        {
            anH[i + 16] = abyte0[i];
            anH[i + 32] = (byte)(abyte0[i] ^ anH[i]);
        }

        int j = 0;
        for (int k = 0; k < 18; k++)
        {
            for (int l = 0; l < 48; l++)
            {
                abyte0 = anH;
                byte byte0 = (byte)(abyte0[l] ^ anp[j]);
                abyte0[l] = byte0;
                j = byte0 & 0xff;
            }

            j = (j + k) % 256;
        }

    }

    public final int doFinal(byte abyte0[], int i)
    {
        byte byte0 = (byte)(ane.length - anJ);
        for (int j = anJ; j < ane.length; j++)
        {
            ane[j] = byte0;
        }

        _mth0674(ane);
        _mth1D35(ane);
        _mth1D35(anK);
        System.arraycopy(anH, anI, abyte0, i, 16);
        reset();
        return 16;
    }

    public final void reset()
    {
        anI = 0;
        for (int i = 0; i != anH.length; i++)
        {
            anH[i] = 0;
        }

        anJ = 0;
        for (int j = 0; j != ane.length; j++)
        {
            ane[j] = 0;
        }

        anL = 0;
        for (int k = 0; k != anK.length; k++)
        {
            anK[k] = 0;
        }

    }

    public final void update(byte byte0)
    {
        byte abyte0[] = ane;
        int i = anJ;
        anJ = i + 1;
        abyte0[i] = byte0;
        if (anJ == 16)
        {
            _mth0674(ane);
            _mth1D35(ane);
            anJ = 0;
        }
    }

    public final void update(byte abyte0[], int i, int j)
    {
        int l = i;
        int k;
        do
        {
            i = l;
            k = j;
            if (anJ == 0)
            {
                break;
            }
            i = l;
            k = j;
            if (j <= 0)
            {
                break;
            }
            update(abyte0[l]);
            l++;
            j--;
        } while (true);
        do
        {
            j = i;
            l = k;
            if (k <= 16)
            {
                break;
            }
            System.arraycopy(abyte0, i, ane, 0, 16);
            _mth0674(ane);
            _mth1D35(ane);
            k -= 16;
            i += 16;
        } while (true);
        for (; l > 0; l--)
        {
            update(abyte0[j]);
            j++;
        }

    }

    public final void _mth02CA(Memoable memoable)
    {
        _mth02CA((MD2Digest)memoable);
    }

    public final String _mth14AC()
    {
        return "MD2";
    }

    public final int _mth14AF()
    {
        return 16;
    }

    public final int _mth14B2()
    {
        return 16;
    }

    public final Memoable _mth14B7()
    {
        return new MD2Digest(this);
    }

}
