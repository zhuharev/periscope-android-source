// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;

public class OFBBlockCipher extends StreamBlockCipher
{

    private final BlockCipher amz;
    private byte arV[];
    private int avR;
    private byte awm[];
    private byte awn[];
    private final int kY;

    public OFBBlockCipher(BlockCipher blockcipher, int i)
    {
        super(blockcipher);
        amz = blockcipher;
        kY = i / 8;
        arV = new byte[blockcipher.getBlockSize()];
        awm = new byte[blockcipher.getBlockSize()];
        awn = new byte[blockcipher.getBlockSize()];
    }

    public final int getBlockSize()
    {
        return kY;
    }

    public final void reset()
    {
        System.arraycopy(arV, 0, awm, 0, arV.length);
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
        if (avR == 0)
        {
            amz._mth02CA(awm, 0, awn, 0);
        }
        byte abyte0[] = awn;
        int i = avR;
        avR = i + 1;
        byte byte1 = (byte)(abyte0[i] ^ byte0);
        if (avR == kY)
        {
            avR = 0;
            System.arraycopy(awm, kY, awm, 0, awm.length - kY);
            System.arraycopy(awn, 0, awm, awm.length - kY, kY);
        }
        return byte1;
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(amz._mth14AC()).append("/OFB").append(kY << 3).toString();
    }
}
