// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.DataLengthException;

class MacCFBBlockCipher
{

    BlockCipher amz;
    byte arV[];
    byte auW[];
    private byte auX[];
    int kY;

    public MacCFBBlockCipher(BlockCipher blockcipher, int i)
    {
        amz = null;
        amz = blockcipher;
        kY = i / 8;
        arV = new byte[blockcipher.getBlockSize()];
        auW = new byte[blockcipher.getBlockSize()];
        auX = new byte[blockcipher.getBlockSize()];
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (kY + i > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (kY + 0 > abyte1.length)
        {
            throw new DataLengthException("output buffer too short");
        }
        amz._mth02CA(auW, 0, auX, 0);
        for (j = 0; j < kY; j++)
        {
            abyte1[j + 0] = (byte)(auX[j] ^ abyte0[i + j]);
        }

        System.arraycopy(auW, kY, auW, 0, auW.length - kY);
        System.arraycopy(abyte1, 0, auW, auW.length - kY, kY);
        return kY;
    }
}
