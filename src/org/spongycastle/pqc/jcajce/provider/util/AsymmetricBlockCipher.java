// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.util;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.util:
//            CipherSpiExt

public abstract class AsymmetricBlockCipher extends CipherSpiExt
{

    public int aMe;
    public int aMf;
    private ByteArrayOutputStream aOg;

    public AsymmetricBlockCipher()
    {
        aOg = new ByteArrayOutputStream();
    }

    public final int doFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (abyte1.length < getOutputSize(j))
        {
            throw new ShortBufferException("Output buffer too short.");
        } else
        {
            abyte0 = doFinal(abyte0, i, j);
            System.arraycopy(abyte0, 0, abyte1, k, abyte0.length);
            return abyte0.length;
        }
    }

    public final byte[] doFinal(byte abyte0[], int i, int j)
    {
        int k = j + aOg.size();
        if (aOp == 1)
        {
            if (k > aMe)
            {
                throw new IllegalBlockSizeException((new StringBuilder("The length of the plaintext (")).append(k).append(" bytes) is not supported by the cipher (max. ").append(aMe).append(" bytes).").toString());
            }
        } else
        if (aOp == 2 && k != aMf)
        {
            throw new IllegalBlockSizeException((new StringBuilder("Illegal ciphertext length (expected ")).append(aMf).append(" bytes, was ").append(k).append(" bytes).").toString());
        }
        if (j != 0)
        {
            aOg.write(abyte0, i, j);
        }
        abyte0 = aOg.toByteArray();
        aOg.reset();
        switch (aOp)
        {
        case 1: // '\001'
            return _mth06E6(abyte0);

        case 2: // '\002'
            return _mth0E40(abyte0);
        }
        return null;
    }

    public final int getBlockSize()
    {
        if (aOp == 1)
        {
            return aMe;
        } else
        {
            return aMf;
        }
    }

    public final int getOutputSize(int i)
    {
        int k = aOg.size();
        int j;
        if (aOp == 1)
        {
            j = aMe;
        } else
        {
            j = aMf;
        }
        if (i + k > j)
        {
            return 0;
        } else
        {
            return j;
        }
    }

    public final int update(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (j != 0)
        {
            aOg.write(abyte0, i, j);
        }
        return 0;
    }

    public final byte[] update(byte abyte0[], int i, int j)
    {
        if (j != 0)
        {
            aOg.write(abyte0, i, j);
        }
        return new byte[0];
    }

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

    public abstract byte[] _mth06E6(byte abyte0[]);

    public abstract byte[] _mth0E40(byte abyte0[]);
}
