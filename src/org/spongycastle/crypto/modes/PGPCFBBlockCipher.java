// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;

public class PGPCFBBlockCipher
    implements BlockCipher
{

    private boolean amy;
    private BlockCipher amz;
    private byte arV[];
    private byte awH[];
    private byte awI[];
    private byte awJ[];
    private boolean awK;
    private int count;
    private int kY;

    public PGPCFBBlockCipher(BlockCipher blockcipher, boolean flag)
    {
        amz = blockcipher;
        awK = flag;
        kY = blockcipher.getBlockSize();
        arV = new byte[kY];
        awH = new byte[kY];
        awI = new byte[kY];
        awJ = new byte[kY];
    }

    public final int getBlockSize()
    {
        return amz.getBlockSize();
    }

    public final void reset()
    {
        count = 0;
        for (int i = 0; i != awH.length; i++)
        {
            if (awK)
            {
                awH[i] = 0;
            } else
            {
                awH[i] = arV[i];
            }
        }

        amz.reset();
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (awK)
        {
            if (amy)
            {
                if (kY + i > abyte0.length)
                {
                    throw new DataLengthException("input buffer too short");
                }
                if (count == 0)
                {
                    if (kY * 2 + j + 2 > abyte1.length)
                    {
                        throw new DataLengthException("output buffer too short");
                    }
                    amz._mth02CA(awH, 0, awI, 0);
                    for (int k = 0; k < kY; k++)
                    {
                        byte byte2 = arV[k];
                        abyte1[j + k] = (byte)(awI[k] ^ byte2);
                    }

                    System.arraycopy(abyte1, j, awH, 0, kY);
                    amz._mth02CA(awH, 0, awI, 0);
                    int l = kY;
                    byte byte3 = arV[kY - 2];
                    abyte1[l + j] = (byte)(awI[0] ^ byte3);
                    l = kY;
                    byte3 = arV[kY - 1];
                    abyte1[l + j + 1] = (byte)(awI[1] ^ byte3);
                    System.arraycopy(abyte1, j + 2, awH, 0, kY);
                    amz._mth02CA(awH, 0, awI, 0);
                    for (int i1 = 0; i1 < kY; i1++)
                    {
                        int j2 = kY;
                        byte byte7 = abyte0[i + i1];
                        abyte1[j2 + j + 2 + i1] = (byte)(awI[i1] ^ byte7);
                    }

                    System.arraycopy(abyte1, kY + j + 2, awH, 0, kY);
                    count = count + (kY * 2 + 2);
                    return kY * 2 + 2;
                }
                if (count >= kY + 2)
                {
                    if (kY + j > abyte1.length)
                    {
                        throw new DataLengthException("output buffer too short");
                    }
                    amz._mth02CA(awH, 0, awI, 0);
                    for (int j1 = 0; j1 < kY; j1++)
                    {
                        byte byte4 = abyte0[i + j1];
                        abyte1[j + j1] = (byte)(awI[j1] ^ byte4);
                    }

                    System.arraycopy(abyte1, j, awH, 0, kY);
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
            if (count == 0)
            {
                for (j = 0; j < kY; j++)
                {
                    awH[j] = abyte0[i + j];
                }

                amz._mth02CA(awH, 0, awI, 0);
                count = count + kY;
                return 0;
            }
            if (count == kY)
            {
                System.arraycopy(abyte0, i, awJ, 0, kY);
                System.arraycopy(awH, 2, awH, 0, kY - 2);
                awH[kY - 2] = awJ[0];
                awH[kY - 1] = awJ[1];
                amz._mth02CA(awH, 0, awI, 0);
                for (i = 0; i < kY - 2; i++)
                {
                    byte byte0 = awJ[i + 2];
                    abyte1[j + i] = (byte)(awI[i] ^ byte0);
                }

                System.arraycopy(awJ, 2, awH, 0, kY - 2);
                count = count + 2;
                return kY - 2;
            }
            if (count >= kY + 2)
            {
                System.arraycopy(abyte0, i, awJ, 0, kY);
                i = awJ[0];
                int k1 = kY;
                abyte1[j] = (byte)(awI[k1 - 2] ^ i);
                i = awJ[1];
                k1 = kY;
                abyte1[j + 1] = (byte)(awI[k1 - 1] ^ i);
                System.arraycopy(awJ, 0, awH, kY - 2, 2);
                amz._mth02CA(awH, 0, awI, 0);
                for (i = 0; i < kY - 2; i++)
                {
                    byte byte1 = awJ[i + 2];
                    abyte1[j + i + 2] = (byte)(awI[i] ^ byte1);
                }

                System.arraycopy(awJ, 2, awH, 0, kY - 2);
            }
            return kY;
        }
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
            amz._mth02CA(awH, 0, awI, 0);
            for (int l1 = 0; l1 < kY; l1++)
            {
                byte byte5 = abyte0[i + l1];
                abyte1[j + l1] = (byte)(awI[l1] ^ byte5);
            }

            for (i = 0; i < kY; i++)
            {
                awH[i] = abyte1[j + i];
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
        amz._mth02CA(awH, 0, awI, 0);
        for (int i2 = 0; i2 < kY; i2++)
        {
            byte byte6 = abyte0[i + i2];
            abyte1[j + i2] = (byte)(awI[i2] ^ byte6);
        }

        for (j = 0; j < kY; j++)
        {
            awH[j] = abyte0[i + j];
        }

        return kY;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        amy = flag;
        if (cipherparameters instanceof ParametersWithIV)
        {
            cipherparameters = (ParametersWithIV)cipherparameters;
            byte abyte0[] = ((ParametersWithIV) (cipherparameters)).iv;
            if (abyte0.length < arV.length)
            {
                System.arraycopy(abyte0, 0, arV, arV.length - abyte0.length, abyte0.length);
                for (int i = 0; i < arV.length - abyte0.length; i++)
                {
                    arV[i] = 0;
                }

            } else
            {
                System.arraycopy(abyte0, 0, arV, 0, arV.length);
            }
            reset();
            amz._mth02CA(true, ((ParametersWithIV) (cipherparameters)).axC);
            return;
        } else
        {
            reset();
            amz._mth02CA(true, cipherparameters);
            return;
        }
    }

    public final String _mth14AC()
    {
        if (awK)
        {
            return (new StringBuilder()).append(amz._mth14AC()).append("/PGPCFBwithIV").toString();
        } else
        {
            return (new StringBuilder()).append(amz._mth14AC()).append("/PGPCFB").toString();
        }
    }
}
