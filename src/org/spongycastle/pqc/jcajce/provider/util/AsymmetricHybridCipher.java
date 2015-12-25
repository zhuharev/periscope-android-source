// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.util;

import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ShortBufferException;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.util:
//            CipherSpiExt

public abstract class AsymmetricHybridCipher extends CipherSpiExt
{

    public AsymmetricHybridCipher()
    {
    }

    public final int doFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        int l = abyte1.length;
        int i1 = aOp;
        if (l < 0)
        {
            throw new ShortBufferException("Output buffer too short.");
        } else
        {
            abyte0 = doFinal(abyte0, i, j);
            System.arraycopy(abyte0, 0, abyte1, k, abyte0.length);
            return abyte0.length;
        }
    }

    public abstract byte[] doFinal(byte abyte0[], int i, int j);

    public final int getBlockSize()
    {
        return 0;
    }

    public final int getOutputSize(int i)
    {
        i = aOp;
        return 0;
    }

    public final int update(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        int l = abyte1.length;
        int i1 = aOp;
        if (l < 0)
        {
            throw new ShortBufferException("output");
        } else
        {
            System.arraycopy(update(abyte0, i, j), 0, abyte1, k, 0);
            return 0;
        }
    }

    public abstract byte[] update(byte abyte0[], int i, int j);

    public abstract void _mth02CA(Key key, SecureRandom securerandom);

    public final void _mth02CA(Key key, AlgorithmParameterSpec algorithmparameterspec)
    {
        aOp = 2;
        _mth02CB(key);
    }

    public final void _mth02CA(Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        aOp = 1;
        _mth02CA(key, securerandom);
    }

    public abstract void _mth02CB(Key key);
}
