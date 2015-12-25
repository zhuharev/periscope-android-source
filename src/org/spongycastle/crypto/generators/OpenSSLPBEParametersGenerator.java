// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator
{

    private MD5Digest aus;

    public OpenSSLPBEParametersGenerator()
    {
        aus = new MD5Digest();
    }

    private byte[] FEF3(int i)
    {
        byte abyte0[] = new byte[aus._mth14AF()];
        byte abyte1[] = new byte[i];
        int j = 0;
        do
        {
            aus.update(amG, 0, amG.length);
            aus.update(aaN, 0, aaN.length);
            aus.doFinal(abyte0, 0);
            int k;
            if (i > abyte0.length)
            {
                k = abyte0.length;
            } else
            {
                k = i;
            }
            System.arraycopy(abyte0, 0, abyte1, j, k);
            j += k;
            k = i - k;
            i = k;
            if (k != 0)
            {
                aus.reset();
                aus.update(abyte0, 0, abyte0.length);
            } else
            {
                return abyte1;
            }
        } while (true);
    }

    public final KeyParameter _mth155D(int i)
    {
        i /= 8;
        return new KeyParameter(FEF3(i), 0, i);
    }

    public final CipherParameters _mth1D52(int i)
    {
        i /= 8;
        return new KeyParameter(FEF3(i), 0, i);
    }

    public final ParametersWithIV _mth1D63(int i, int j)
    {
        i /= 8;
        j /= 8;
        byte abyte0[] = FEF3(i + j);
        return new ParametersWithIV(new KeyParameter(abyte0, 0, i), abyte0, i, j);
    }
}
