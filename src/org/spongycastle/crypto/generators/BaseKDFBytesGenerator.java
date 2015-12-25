// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.DigestDerivationFunction;
import org.spongycastle.crypto.params.ISO18033KDFParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.util.Pack;

public class BaseKDFBytesGenerator
    implements DigestDerivationFunction
{

    private Digest amS;
    private int atR;
    private byte atS[];
    private byte iv[];

    protected BaseKDFBytesGenerator(int i, Digest digest)
    {
        atR = 1;
        amS = digest;
    }

    public final int _mth02BF(byte abyte0[], int i, int j)
    {
        if (abyte0.length - j < i)
        {
            throw new DataLengthException("output buffer too small");
        }
        long l2 = j;
        int k1 = amS._mth14AF();
        if (l2 > 0x1ffffffffL)
        {
            throw new IllegalArgumentException("Output length too large");
        }
        int l1 = (int)((((long)k1 + l2) - 1L) / (long)k1);
        byte abyte1[] = new byte[amS._mth14AF()];
        byte abyte2[] = new byte[4];
        Pack._mth1FBE(atR, abyte2, 0);
        int l = atR & 0xffffff00;
        boolean flag = false;
        int k = j;
        int j1 = i;
        i = ((flag) ? 1 : 0);
        j = l;
        while (i < l1) 
        {
            amS.update(atS, 0, atS.length);
            amS.update(abyte2, 0, 4);
            if (iv != null)
            {
                amS.update(iv, 0, iv.length);
            }
            amS.doFinal(abyte1, 0);
            int i1;
            if (k > k1)
            {
                System.arraycopy(abyte1, 0, abyte0, j1, k1);
                i1 = j1 + k1;
                j1 = k - k1;
                k = i1;
                i1 = j1;
            } else
            {
                System.arraycopy(abyte1, 0, abyte0, j1, k);
                i1 = k;
                k = j1;
            }
            byte byte0 = (byte)(abyte2[3] + 1);
            abyte2[3] = byte0;
            j1 = j;
            if (byte0 == 0)
            {
                j1 = j + 256;
                Pack._mth1FBE(j1, abyte2, 0);
            }
            i++;
            j = j1;
            j1 = k;
            k = i1;
        }
        amS.reset();
        return (int)l2;
    }

    public final void _mth02CA(DerivationParameters derivationparameters)
    {
        if (derivationparameters instanceof KDFParameters)
        {
            derivationparameters = (KDFParameters)derivationparameters;
            atS = ((KDFParameters) (derivationparameters)).atS;
            iv = ((KDFParameters) (derivationparameters)).iv;
            return;
        }
        if (derivationparameters instanceof ISO18033KDFParameters)
        {
            derivationparameters = (ISO18033KDFParameters)derivationparameters;
            atS = null;
            iv = null;
            return;
        } else
        {
            throw new IllegalArgumentException("KDF parameters required for KDF2Generator");
        }
    }
}
