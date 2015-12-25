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

public class PKCS5S1ParametersGenerator extends PBEParametersGenerator
{

    private Digest amS;

    public PKCS5S1ParametersGenerator(ExtendedDigest extendeddigest)
    {
        amS = extendeddigest;
    }

    private byte[] FF6E()
    {
        byte abyte0[] = new byte[amS._mth14AF()];
        amS.update(amG, 0, amG.length);
        amS.update(aaN, 0, aaN.length);
        amS.doFinal(abyte0, 0);
        for (int i = 1; i < amH; i++)
        {
            amS.update(abyte0, 0, abyte0.length);
            amS.doFinal(abyte0, 0);
        }

        return abyte0;
    }

    public final KeyParameter _mth155D(int i)
    {
        i /= 8;
        if (i > amS._mth14AF())
        {
            throw new IllegalArgumentException((new StringBuilder("Can't generate a derived key ")).append(i).append(" bytes long.").toString());
        } else
        {
            return new KeyParameter(FF6E(), 0, i);
        }
    }

    public final CipherParameters _mth1D52(int i)
    {
        return _mth155D(i);
    }

    public final ParametersWithIV _mth1D63(int i, int j)
    {
        i /= 8;
        j /= 8;
        if (i + j > amS._mth14AF())
        {
            throw new IllegalArgumentException((new StringBuilder("Can't generate a derived key ")).append(i + j).append(" bytes long.").toString());
        } else
        {
            byte abyte0[] = FF6E();
            return new ParametersWithIV(new KeyParameter(abyte0, 0, i), abyte0, i, j);
        }
    }
}
