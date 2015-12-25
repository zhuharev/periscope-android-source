// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class CFBBlockCipher extends StreamBlockCipher
{

    private BlockCipher amz;
    private boolean aqs;
    private byte arV[];
    byte auW[];
    private byte auX[];
    private byte avQ[];
    private int avR;
    int kY;

    public CFBBlockCipher(BlockCipher blockcipher, int i)
    {
        super(blockcipher);
        amz = null;
        amz = blockcipher;
        kY = i / 8;
        arV = new byte[blockcipher.getBlockSize()];
        auW = new byte[blockcipher.getBlockSize()];
        auX = new byte[blockcipher.getBlockSize()];
        avQ = new byte[kY];
    }

    public final int getBlockSize()
    {
        return kY;
    }

    public final void reset()
    {
        System.arraycopy(arV, 0, auW, 0, arV.length);
        Arrays.fill(avQ, (byte)0);
        avR = 0;
        amz.reset();
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        _mth02CB(abyte0, i, kY, abyte1, j);
        return kY;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        aqs = flag;
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
            if (((ParametersWithIV) (cipherparameters)).axC != null)
            {
                amz._mth02CA(true, ((ParametersWithIV) (cipherparameters)).axC);
            }
            return;
        }
        reset();
        if (cipherparameters != null)
        {
            amz._mth02CA(true, cipherparameters);
        }
    }

    protected final byte _mth02CF(byte byte0)
    {
        if (aqs)
        {
            if (avR == 0)
            {
                amz._mth02CA(auW, 0, auX, 0);
            }
            byte0 = (byte)(auX[avR] ^ byte0);
            byte abyte0[] = avQ;
            int i = avR;
            avR = i + 1;
            abyte0[i] = byte0;
            if (avR == kY)
            {
                avR = 0;
                System.arraycopy(auW, kY, auW, 0, auW.length - kY);
                System.arraycopy(avQ, 0, auW, auW.length - kY, kY);
            }
            return byte0;
        }
        if (avR == 0)
        {
            amz._mth02CA(auW, 0, auX, 0);
        }
        avQ[avR] = byte0;
        byte abyte1[] = auX;
        int j = avR;
        avR = j + 1;
        byte0 = (byte)(abyte1[j] ^ byte0);
        if (avR == kY)
        {
            avR = 0;
            System.arraycopy(auW, kY, auW, 0, auW.length - kY);
            System.arraycopy(avQ, 0, auW, auW.length - kY, kY);
        }
        return byte0;
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(amz._mth14AC()).append("/CFB").append(kY << 3).toString();
    }
}
