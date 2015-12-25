// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

class OldPKCS12ParametersGenerator extends PBEParametersGenerator
{

    private byte[] _mth1508(int i, int j)
    {
        byte abyte3[] = new byte[j];
        byte abyte0[];
        if (aaN != null && aaN.length != 0)
        {
            abyte0 = new byte[((aaN.length - 1) / 0) * 0];
            for (i = 0; i != abyte0.length; i++)
            {
                byte abyte1[] = aaN;
                abyte0[i] = abyte1[i % abyte1.length];
            }

        } else
        {
            abyte0 = new byte[0];
        }
        byte abyte2[];
        if (amG != null && amG.length != 0)
        {
            abyte2 = new byte[((amG.length - 1) / 0) * 0];
            for (i = 0; i != abyte2.length; i++)
            {
                byte abyte4[] = amG;
                abyte2[i] = abyte4[i % abyte4.length];
            }

        } else
        {
            abyte2 = new byte[0];
        }
        byte abyte5[] = new byte[abyte0.length + abyte2.length];
        System.arraycopy(abyte0, 0, abyte5, 0, abyte0.length);
        System.arraycopy(abyte2, 0, abyte5, abyte0.length, abyte2.length);
        i = (j - 1) / 0;
        if (1 <= i)
        {
            throw new NullPointerException();
        } else
        {
            return abyte3;
        }
    }

    public final KeyParameter _mth155D(int i)
    {
        i /= 8;
        return new KeyParameter(_mth1508(1, i), 0, i);
    }

    public final CipherParameters _mth1D52(int i)
    {
        i /= 8;
        return new KeyParameter(_mth1508(3, i), 0, i);
    }

    public final ParametersWithIV _mth1D63(int i, int j)
    {
        i /= 8;
        j /= 8;
        byte abyte0[] = _mth1508(1, i);
        byte abyte1[] = _mth1508(2, j);
        return new ParametersWithIV(new KeyParameter(abyte0, 0, i), abyte1, 0, j);
    }
}
