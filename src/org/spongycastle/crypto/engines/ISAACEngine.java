// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class ISAACEngine
    implements StreamCipher
{

    private boolean aqH;
    private byte aqt[];
    private final int arW = 8;
    private final int arX = 256;
    private int arY[];
    private int arZ[];
    private int asa;
    private int asb;
    private int asc;
    private byte asd[];
    private int index;

    public ISAACEngine()
    {
        arY = null;
        arZ = null;
        asa = 0;
        asb = 0;
        asc = 0;
        index = 0;
        asd = new byte[1024];
        aqt = null;
        aqH = false;
    }

    private static void _mth02CE(int ai[])
    {
        ai[0] = ai[0] ^ ai[1] << 11;
        ai[3] = ai[3] + ai[0];
        ai[1] = ai[1] + ai[2];
        ai[1] = ai[1] ^ ai[2] >>> 2;
        ai[4] = ai[4] + ai[1];
        ai[2] = ai[2] + ai[3];
        ai[2] = ai[2] ^ ai[3] << 8;
        ai[5] = ai[5] + ai[2];
        ai[3] = ai[3] + ai[4];
        ai[3] = ai[3] ^ ai[4] >>> 16;
        ai[6] = ai[6] + ai[3];
        ai[4] = ai[4] + ai[5];
        ai[4] = ai[4] ^ ai[5] << 10;
        ai[7] = ai[7] + ai[4];
        ai[5] = ai[5] + ai[6];
        ai[5] = ai[5] ^ ai[6] >>> 4;
        ai[0] = ai[0] + ai[5];
        ai[6] = ai[6] + ai[7];
        ai[6] = ai[6] ^ ai[7] << 8;
        ai[1] = ai[1] + ai[6];
        ai[7] = ai[7] + ai[0];
        ai[7] = ai[7] ^ ai[0] >>> 9;
        ai[2] = ai[2] + ai[7];
        ai[0] = ai[0] + ai[1];
    }

    private void _mth1D54(byte abyte0[])
    {
        aqt = abyte0;
        if (arY == null)
        {
            arY = new int[256];
        }
        if (arZ == null)
        {
            arZ = new int[256];
        }
        for (int i = 0; i < 256; i++)
        {
            int ai[] = arY;
            arZ[i] = 0;
            ai[i] = 0;
        }

        asc = 0;
        asb = 0;
        asa = 0;
        index = 0;
        byte abyte1[] = new byte[abyte0.length + (abyte0.length & 3)];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        for (int j = 0; j < abyte1.length; j += 4)
        {
            arZ[j >>> 2] = Pack._mth02C6(abyte1, j);
        }

        abyte0 = new int[8];
        for (int k = 0; k < 8; k++)
        {
            abyte0[k] = 0x9e3779b9;
        }

        for (int l = 0; l < 4; l++)
        {
            _mth02CE(abyte0);
        }

        for (int i1 = 0; i1 < 2; i1++)
        {
            for (int j1 = 0; j1 < 256; j1 += 8)
            {
                for (int k1 = 0; k1 < 8; k1++)
                {
                    byte byte0 = abyte0[k1];
                    int i2;
                    if (i1 <= 0)
                    {
                        i2 = arZ[j1 + k1];
                    } else
                    {
                        i2 = arY[j1 + k1];
                    }
                    abyte0[k1] = byte0 + i2;
                }

                _mth02CE(abyte0);
                for (int l1 = 0; l1 < 8; l1++)
                {
                    arY[j1 + l1] = abyte0[l1];
                }

            }

        }

        _mth2113();
        aqH = true;
    }

    private void _mth2113()
    {
        int i = asb;
        int k = asc + 1;
        asc = k;
        asb = i + k;
        for (int j = 0; j < 256; j++)
        {
            int l = arY[j];
            switch (j & 3)
            {
            case 0: // '\0'
                asa = asa ^ asa << 13;
                break;

            case 1: // '\001'
                asa = asa ^ asa >>> 6;
                break;

            case 2: // '\002'
                asa = asa ^ asa << 2;
                break;

            case 3: // '\003'
                asa = asa ^ asa >>> 16;
                break;
            }
            asa = asa + arY[j + 128 & 0xff];
            int ai[] = arY;
            int i1 = ai[l >>> 2 & 0xff] + asa + asb;
            ai[j] = i1;
            ai = arZ;
            l = arY[i1 >>> 10 & 0xff] + l;
            asb = l;
            ai[j] = l;
        }

    }

    public final void reset()
    {
        _mth1D54(aqt);
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof KeyParameter))
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to ISAAC init - ")).append(cipherparameters.getClass().getName()).toString());
        } else
        {
            _mth1D54(((KeyParameter)cipherparameters).key);
            return;
        }
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (!aqH)
        {
            throw new IllegalStateException((new StringBuilder()).append("ISAAC not initialised").toString());
        }
        if (i + j > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (k + j > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        for (int l = 0; l < j; l++)
        {
            if (index == 0)
            {
                _mth2113();
                asd = Pack.FF9E(arZ);
            }
            abyte1[l + k] = (byte)(asd[index] ^ abyte0[l + i]);
            index = index + 1 & 0x3ff;
        }

        return j;
    }

    public final String _mth14AC()
    {
        return "ISAAC";
    }
}
