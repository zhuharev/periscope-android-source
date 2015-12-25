// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;

public class OpenPGPCFBBlockCipher
    implements BlockCipher
{

    private boolean amy;
    private BlockCipher amz;
    private byte arV[];
    private byte awH[];
    private byte awI[];
    private int count;
    private int kY;

    public OpenPGPCFBBlockCipher(BlockCipher blockcipher)
    {
        amz = blockcipher;
        kY = blockcipher.getBlockSize();
        arV = new byte[kY];
        awH = new byte[kY];
        awI = new byte[kY];
    }

    public final int getBlockSize()
    {
        return amz.getBlockSize();
    }

    public final void reset()
    {
        count = 0;
        System.arraycopy(arV, 0, awH, 0, awH.length);
        amz.reset();
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (amy)
        {
            if (kY + i > abyte0.length)
            {
                throw new DataLengthException("input buffer too short");
            }
            if (kY + j > abyte1.length)
            {
                throw new DataLengthException("output buffer too short");
            }
            if (count > kY)
            {
                byte abyte2[] = awH;
                int k = kY;
                byte byte11 = abyte0[i];
                int j2 = kY;
                byte byte0 = (byte)(awI[j2 - 2] ^ byte11);
                abyte1[j] = byte0;
                abyte2[k - 2] = byte0;
                abyte2 = awH;
                k = kY;
                byte11 = abyte0[i + 1];
                j2 = kY;
                byte0 = (byte)(awI[j2 - 1] ^ byte11);
                abyte1[j + 1] = byte0;
                abyte2[k - 1] = byte0;
                amz._mth02CA(awH, 0, awI, 0);
                for (int l = 2; l < kY; l++)
                {
                    byte abyte3[] = awH;
                    byte byte12 = abyte0[i + l];
                    byte byte1 = (byte)(awI[l - 2] ^ byte12);
                    abyte1[j + l] = byte1;
                    abyte3[l - 2] = byte1;
                }

            } else
            if (count == 0)
            {
                amz._mth02CA(awH, 0, awI, 0);
                for (int i1 = 0; i1 < kY; i1++)
                {
                    byte abyte4[] = awH;
                    byte byte13 = abyte0[i + i1];
                    byte byte2 = (byte)(awI[i1] ^ byte13);
                    abyte1[j + i1] = byte2;
                    abyte4[i1] = byte2;
                }

                count = count + kY;
            } else
            if (count == kY)
            {
                amz._mth02CA(awH, 0, awI, 0);
                byte byte9 = abyte0[i];
                abyte1[j] = (byte)(awI[0] ^ byte9);
                byte9 = abyte0[i + 1];
                abyte1[j + 1] = (byte)(awI[1] ^ byte9);
                System.arraycopy(awH, 2, awH, 0, kY - 2);
                System.arraycopy(abyte1, j, awH, kY - 2, 2);
                amz._mth02CA(awH, 0, awI, 0);
                for (int j1 = 2; j1 < kY; j1++)
                {
                    byte abyte5[] = awH;
                    byte byte14 = abyte0[i + j1];
                    byte byte3 = (byte)(awI[j1 - 2] ^ byte14);
                    abyte1[j + j1] = byte3;
                    abyte5[j1 - 2] = byte3;
                }

                count = count + kY;
            }
            return kY;
        }
        if (kY + i > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (kY + j > abyte1.length)
        {
            throw new DataLengthException("output buffer too short");
        }
        if (count > kY)
        {
            byte byte4 = abyte0[i];
            awH[kY - 2] = byte4;
            int k1 = kY;
            abyte1[j] = (byte)(awI[k1 - 2] ^ byte4);
            byte4 = abyte0[i + 1];
            awH[kY - 1] = byte4;
            k1 = kY;
            abyte1[j + 1] = (byte)(awI[k1 - 1] ^ byte4);
            amz._mth02CA(awH, 0, awI, 0);
            for (int l1 = 2; l1 < kY; l1++)
            {
                byte byte5 = abyte0[i + l1];
                awH[l1 - 2] = byte5;
                abyte1[j + l1] = (byte)(awI[l1 - 2] ^ byte5);
            }

        } else
        if (count == 0)
        {
            amz._mth02CA(awH, 0, awI, 0);
            for (j = 0; j < kY; j++)
            {
                awH[j] = abyte0[i + j];
                byte byte10 = abyte0[i + j];
                abyte1[j] = (byte)(awI[j] ^ byte10);
            }

            count = count + kY;
        } else
        if (count == kY)
        {
            amz._mth02CA(awH, 0, awI, 0);
            byte byte6 = abyte0[i];
            byte byte8 = abyte0[i + 1];
            abyte1[j] = (byte)(awI[0] ^ byte6);
            abyte1[j + 1] = (byte)(awI[1] ^ byte8);
            System.arraycopy(awH, 2, awH, 0, kY - 2);
            awH[kY - 2] = byte6;
            awH[kY - 1] = byte8;
            amz._mth02CA(awH, 0, awI, 0);
            for (int i2 = 2; i2 < kY; i2++)
            {
                byte byte7 = abyte0[i + i2];
                awH[i2 - 2] = byte7;
                abyte1[j + i2] = (byte)(awI[i2 - 2] ^ byte7);
            }

            count = count + kY;
        }
        return kY;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        amy = flag;
        reset();
        amz._mth02CA(true, cipherparameters);
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(amz._mth14AC()).append("/OpenPGPCFB").toString();
    }
}
