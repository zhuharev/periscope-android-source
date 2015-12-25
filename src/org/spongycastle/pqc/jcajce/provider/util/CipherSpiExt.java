// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.CipherSpi;

public abstract class CipherSpiExt extends CipherSpi
{

    public int aOp;

    public CipherSpiExt()
    {
    }

    public abstract int doFinal(byte abyte0[], int i, int j, byte abyte1[], int k);

    public abstract byte[] doFinal(byte abyte0[], int i, int j);

    protected final int engineDoFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        return doFinal(abyte0, i, j, abyte1, k);
    }

    protected final byte[] engineDoFinal(byte abyte0[], int i, int j)
    {
        return doFinal(abyte0, i, j);
    }

    protected final int engineGetBlockSize()
    {
        return getBlockSize();
    }

    protected final byte[] engineGetIV()
    {
        return null;
    }

    protected final int engineGetKeySize(Key key)
    {
        if (!(key instanceof Key))
        {
            throw new InvalidKeyException("Unsupported key.");
        } else
        {
            return _mth02CE(key);
        }
    }

    protected final int engineGetOutputSize(int i)
    {
        return getOutputSize(i);
    }

    protected final AlgorithmParameters engineGetParameters()
    {
        return null;
    }

    protected final void engineInit(int i, Key key, AlgorithmParameters algorithmparameters, SecureRandom securerandom)
    {
        if (algorithmparameters == null)
        {
            engineInit(i, key, securerandom);
            return;
        } else
        {
            engineInit(i, key, ((AlgorithmParameterSpec) (null)), securerandom);
            return;
        }
    }

    protected final void engineInit(int i, Key key, SecureRandom securerandom)
    {
        try
        {
            engineInit(i, key, ((AlgorithmParameterSpec) (null)), securerandom);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new InvalidParameterException(key.getMessage());
        }
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (algorithmparameterspec != null && !(algorithmparameterspec instanceof AlgorithmParameterSpec))
        {
            throw new InvalidAlgorithmParameterException();
        }
        if (key == null || !(key instanceof Key))
        {
            throw new InvalidKeyException();
        }
        aOp = i;
        if (i == 1)
        {
            _mth02CA(key, algorithmparameterspec, securerandom);
            return;
        }
        if (i == 2)
        {
            _mth02CA(key, algorithmparameterspec);
        }
    }

    protected final void engineSetMode(String s)
    {
    }

    protected final void engineSetPadding(String s)
    {
    }

    protected final int engineUpdate(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        return update(abyte0, i, j, abyte1, k);
    }

    protected final byte[] engineUpdate(byte abyte0[], int i, int j)
    {
        return update(abyte0, i, j);
    }

    public abstract int getBlockSize();

    public abstract int getOutputSize(int i);

    public abstract int update(byte abyte0[], int i, int j, byte abyte1[], int k);

    public abstract byte[] update(byte abyte0[], int i, int j);

    public abstract void _mth02CA(Key key, AlgorithmParameterSpec algorithmparameterspec);

    public abstract void _mth02CA(Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom);

    public abstract int _mth02CE(Key key);
}
