// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class CBCBlockCipher
    implements BlockCipher
{

    public BlockCipher amz;
    private boolean aqs;
    private byte arV[];
    private byte avI[];
    private byte avJ[];
    private int kY;

    public CBCBlockCipher(BlockCipher blockcipher)
    {
        amz = null;
        amz = blockcipher;
        kY = blockcipher.getBlockSize();
        arV = new byte[kY];
        avI = new byte[kY];
        avJ = new byte[kY];
    }

    public final int getBlockSize()
    {
        return amz.getBlockSize();
    }

    public final void reset()
    {
        System.arraycopy(arV, 0, avI, 0, arV.length);
        Arrays.fill(avJ, (byte)0);
        amz.reset();
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (aqs)
        {
            if (kY + i > abyte0.length)
            {
                throw new DataLengthException("input buffer too short");
            }
            for (int k = 0; k < kY; k++)
            {
                byte abyte2[] = avI;
                abyte2[k] = (byte)(abyte2[k] ^ abyte0[i + k]);
            }

            i = amz._mth02CA(avI, 0, abyte1, j);
            System.arraycopy(abyte1, j, avI, 0, avI.length);
            return i;
        }
        if (kY + i > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        System.arraycopy(abyte0, i, avJ, 0, kY);
        int l = amz._mth02CA(abyte0, i, abyte1, j);
        for (i = 0; i < kY; i++)
        {
            int i1 = j + i;
            abyte1[i1] = (byte)(abyte1[i1] ^ avI[i]);
        }

        abyte0 = avI;
        avI = avJ;
        avJ = abyte0;
        return l;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        boolean flag1 = aqs;
        aqs = flag;
        if (cipherparameters instanceof ParametersWithIV)
        {
            cipherparameters = (ParametersWithIV)cipherparameters;
            byte abyte0[] = ((ParametersWithIV) (cipherparameters)).iv;
            if (abyte0.length != kY)
            {
                throw new IllegalArgumentException("initialisation vector must be the same length as block size");
            }
            System.arraycopy(abyte0, 0, arV, 0, abyte0.length);
            reset();
            if (((ParametersWithIV) (cipherparameters)).axC != null)
            {
                amz._mth02CA(flag, ((ParametersWithIV) (cipherparameters)).axC);
                return;
            }
            if (flag1 != flag)
            {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            } else
            {
                return;
            }
        }
        reset();
        if (cipherparameters != null)
        {
            amz._mth02CA(flag, cipherparameters);
            return;
        }
        if (flag1 != flag)
        {
            throw new IllegalArgumentException("cannot change encrypting state without providing key.");
        } else
        {
            return;
        }
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(amz._mth14AC()).append("/CBC").toString();
    }
}
