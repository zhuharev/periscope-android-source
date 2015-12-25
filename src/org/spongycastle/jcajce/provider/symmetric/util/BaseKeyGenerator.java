// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;

public class BaseKeyGenerator extends KeyGeneratorSpi
{

    private int Yp;
    public String aFS;
    public int aFT;
    public CipherKeyGenerator aFU;
    public boolean aFV;

    public BaseKeyGenerator(String s, int i, CipherKeyGenerator cipherkeygenerator)
    {
        aFV = true;
        aFS = s;
        aFT = i;
        Yp = i;
        aFU = cipherkeygenerator;
    }

    public SecretKey engineGenerateKey()
    {
        if (aFV)
        {
            aFU._mth02CA(new KeyGenerationParameters(new SecureRandom(), aFT));
            aFV = false;
        }
        return new SecretKeySpec(aFU._mth14AE(), aFS);
    }

    public void engineInit(int i, SecureRandom securerandom)
    {
        SecureRandom securerandom1;
        securerandom1 = securerandom;
        if (securerandom != null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        securerandom1 = new SecureRandom();
        aFU._mth02CA(new KeyGenerationParameters(securerandom1, i));
        aFV = false;
        return;
        securerandom;
        throw new InvalidParameterException(securerandom.getMessage());
    }

    protected void engineInit(SecureRandom securerandom)
    {
        if (securerandom != null)
        {
            aFU._mth02CA(new KeyGenerationParameters(securerandom, aFT));
            aFV = false;
        }
    }

    protected void engineInit(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        throw new InvalidAlgorithmParameterException("Not Implemented");
    }
}
