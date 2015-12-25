// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class PKCS12ParametersGenerator extends PBEParametersGenerator
{

    private Digest amS;
    private int aut;
    private int auu;

    public PKCS12ParametersGenerator(ExtendedDigest extendeddigest)
    {
        amS = extendeddigest;
        aut = extendeddigest._mth14AF();
        auu = ((ExtendedDigest)extendeddigest)._mth14B2();
    }

    private byte[] _mth1508(int i, int j)
    {
        byte abyte3[] = new byte[auu];
        byte abyte4[] = new byte[j];
        for (int k = 0; k != abyte3.length; k++)
        {
            abyte3[k] = (byte)i;
        }

        byte abyte0[];
        if (aaN != null && aaN.length != 0)
        {
            abyte0 = new byte[auu * (((aaN.length + auu) - 1) / auu)];
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
            abyte2 = new byte[auu * (((amG.length + auu) - 1) / auu)];
            for (i = 0; i != abyte2.length; i++)
            {
                byte abyte5[] = amG;
                abyte2[i] = abyte5[i % abyte5.length];
            }

        } else
        {
            abyte2 = new byte[0];
        }
        byte abyte6[] = new byte[abyte0.length + abyte2.length];
        System.arraycopy(abyte0, 0, abyte6, 0, abyte0.length);
        System.arraycopy(abyte2, 0, abyte6, abyte0.length, abyte2.length);
        abyte0 = new byte[auu];
        int k1 = ((aut + j) - 1) / aut;
        abyte2 = new byte[aut];
        for (i = 1; i <= k1; i++)
        {
            amS.update(abyte3, 0, abyte3.length);
            amS.update(abyte6, 0, abyte6.length);
            amS.doFinal(abyte2, 0);
            for (j = 1; j < amH; j++)
            {
                amS.update(abyte2, 0, abyte2.length);
                amS.doFinal(abyte2, 0);
            }

            for (j = 0; j != abyte0.length; j++)
            {
                abyte0[j] = abyte2[j % abyte2.length];
            }

            for (j = 0; j != abyte6.length / auu; j++)
            {
                int l1 = j * auu;
                int l = (abyte0[abyte0.length - 1] & 0xff) + (abyte6[(abyte0.length + l1) - 1] & 0xff) + 1;
                abyte6[(abyte0.length + l1) - 1] = (byte)l;
                int j1 = l >>> 8;
                for (int i1 = abyte0.length - 2; i1 >= 0; i1--)
                {
                    j1 += (abyte0[i1] & 0xff) + (abyte6[l1 + i1] & 0xff);
                    abyte6[l1 + i1] = (byte)j1;
                    j1 >>>= 8;
                }

            }

            if (i == k1)
            {
                System.arraycopy(abyte2, 0, abyte4, (i - 1) * aut, abyte4.length - (i - 1) * aut);
            } else
            {
                System.arraycopy(abyte2, 0, abyte4, (i - 1) * aut, abyte2.length);
            }
        }

        return abyte4;
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
