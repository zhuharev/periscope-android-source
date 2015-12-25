// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.generators.DSAParametersGenerator;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;

public class AlgorithmParameterGeneratorSpi extends java.security.AlgorithmParameterGeneratorSpi
{

    private DSAParameterGenerationParameters aCW;
    private SecureRandom amC;
    private int amD;

    public AlgorithmParameterGeneratorSpi()
    {
        amD = 1024;
    }

    protected AlgorithmParameters engineGenerateParameters()
    {
        Object obj;
        if (amD <= 1024)
        {
            obj = new DSAParametersGenerator();
        } else
        {
            obj = new DSAParametersGenerator(new SHA256Digest());
        }
        if (amC == null)
        {
            amC = new SecureRandom();
        }
        if (amD == 1024)
        {
            aCW = new DSAParameterGenerationParameters(1024, 160, 80, amC);
            ((DSAParametersGenerator) (obj))._mth02CA(aCW);
        } else
        if (amD > 1024)
        {
            aCW = new DSAParameterGenerationParameters(amD, 256, 80, amC);
            ((DSAParametersGenerator) (obj))._mth02CA(aCW);
        } else
        {
            ((DSAParametersGenerator) (obj))._mth02CB(amD, 20, amC);
        }
        obj = ((DSAParametersGenerator) (obj)).FEA3();
        AlgorithmParameters algorithmparameters;
        try
        {
            algorithmparameters = AlgorithmParameters.getInstance("DSA", "SC");
            algorithmparameters.init(new DSAParameterSpec(((DSAParameters) (obj)).amM, ((DSAParameters) (obj)).amN, ((DSAParameters) (obj)).amO));
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception.getMessage());
        }
        return algorithmparameters;
    }

    protected void engineInit(int i, SecureRandom securerandom)
    {
        if (i < 512 || i > 3072)
        {
            throw new InvalidParameterException("strength must be from 512 - 3072");
        }
        if (i <= 1024 && i % 64 != 0)
        {
            throw new InvalidParameterException("strength must be a multiple of 64 below 1024 bits.");
        }
        if (i > 1024 && i % 1024 != 0)
        {
            throw new InvalidParameterException("strength must be a multiple of 1024 above 1024 bits.");
        } else
        {
            amD = i;
            amC = securerandom;
            return;
        }
    }

    protected void engineInit(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
    }
}
