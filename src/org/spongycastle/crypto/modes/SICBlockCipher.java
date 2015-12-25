// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.SkippingStreamCipher;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;

public class SICBlockCipher extends StreamBlockCipher
    implements SkippingStreamCipher
{

    private final BlockCipher amz;
    private byte arV[];
    private int avR;
    private byte awL[];
    private byte awg[];
    private final int kY;

    public SICBlockCipher(BlockCipher blockcipher)
    {
        super(blockcipher);
        amz = blockcipher;
        kY = amz.getBlockSize();
        arV = new byte[kY];
        awg = new byte[kY];
        awL = new byte[kY];
        avR = 0;
    }

    private void _mth01A8()
    {
        int i = awg.length - 1;
        do
        {
            if (i < 0)
            {
                break;
            }
            byte abyte0[] = awg;
            byte byte0 = (byte)(abyte0[i] + 1);
            abyte0[i] = byte0;
            if (byte0 != 0)
            {
                break;
            }
            i--;
        } while (true);
    }

    public final int getBlockSize()
    {
        return amz.getBlockSize();
    }

    public final void reset()
    {
        System.arraycopy(arV, 0, awg, 0, awg.length);
        amz.reset();
        avR = 0;
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
            System.arraycopy(((ParametersWithIV) (cipherparameters)).iv, 0, arV, 0, arV.length);
            if (((ParametersWithIV) (cipherparameters)).axC != null)
            {
                amz._mth02CA(true, ((ParametersWithIV) (cipherparameters)).axC);
            }
            reset();
            return;
        } else
        {
            throw new IllegalArgumentException("SIC mode requires ParametersWithIV");
        }
    }

    protected final byte _mth02CF(byte byte0)
    {
        if (avR == 0)
        {
            amz._mth02CA(awg, 0, awL, 0);
            byte abyte0[] = awL;
            int i = avR;
            avR = i + 1;
            return (byte)(abyte0[i] ^ byte0);
        }
        byte abyte1[] = awL;
        int j = avR;
        avR = j + 1;
        byte byte1 = (byte)(abyte1[j] ^ byte0);
        if (avR == awg.length)
        {
            avR = 0;
            _mth01A8();
        }
        return byte1;
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(amz._mth14AC()).append("/SIC").toString();
    }
}
