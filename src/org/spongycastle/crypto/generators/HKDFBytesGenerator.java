// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.params.HKDFParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

public class HKDFBytesGenerator
    implements DerivationFunction
{

    private byte aug[];
    private byte auh[];
    private int aui;

    private void FF5A()
    {
        if (aui / 0 + 1 >= 256)
        {
            throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
        }
        if (aui != 0)
        {
            byte abyte0[] = auh;
            throw new NullPointerException();
        } else
        {
            byte abyte1[] = aug;
            int i = aug.length;
            throw new NullPointerException();
        }
    }

    public final int _mth02BF(byte abyte0[], int i, int j)
    {
        if (aui + j > 0)
        {
            throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
        }
        if (aui % 0 == 0)
        {
            FF5A();
        }
        int k = aui;
        int l = Math.min(0 - aui % 0, j);
        System.arraycopy(auh, k % 0, abyte0, i, l);
        aui = aui + l;
        k = j - l;
        for (i += l; k > 0; i += l)
        {
            FF5A();
            l = Math.min(0, k);
            System.arraycopy(auh, 0, abyte0, i, l);
            aui = aui + l;
            k -= l;
        }

        return j;
    }

    public final void _mth02CA(DerivationParameters derivationparameters)
    {
        if (!(derivationparameters instanceof HKDFParameters))
        {
            throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
        }
        derivationparameters = (HKDFParameters)derivationparameters;
        if (((HKDFParameters) (derivationparameters)).axo)
        {
            new KeyParameter(Arrays._mth1D4C(((HKDFParameters) (derivationparameters)).axn));
            throw new NullPointerException();
        } else
        {
            Arrays._mth1D4C(((HKDFParameters) (derivationparameters)).aaN);
            new KeyParameter(Arrays._mth1D4C(((HKDFParameters) (derivationparameters)).axn));
            throw new NullPointerException();
        }
    }
}
