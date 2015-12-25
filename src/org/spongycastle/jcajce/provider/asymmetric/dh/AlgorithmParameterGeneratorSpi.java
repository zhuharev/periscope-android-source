// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.generators.DHParametersGenerator;
import org.spongycastle.crypto.params.DHParameters;

public class AlgorithmParameterGeneratorSpi extends java.security.AlgorithmParameterGeneratorSpi
{

    private int afM;
    private SecureRandom amC;
    private int amD;

    public AlgorithmParameterGeneratorSpi()
    {
        amD = 1024;
        afM = 0;
    }

    protected AlgorithmParameters engineGenerateParameters()
    {
        Object obj = new DHParametersGenerator();
        if (amC != null)
        {
            int i = amD;
            SecureRandom securerandom = amC;
            obj.size = i;
            obj.atV = 20;
            obj.amC = securerandom;
        } else
        {
            int j = amD;
            SecureRandom securerandom1 = new SecureRandom();
            obj.size = j;
            obj.atV = 20;
            obj.amC = securerandom1;
        }
        obj = ((DHParametersGenerator) (obj)).FE94();
        AlgorithmParameters algorithmparameters;
        try
        {
            algorithmparameters = AlgorithmParameters.getInstance("DH", "SC");
            algorithmparameters.init(new DHParameterSpec(((DHParameters) (obj)).amM, ((DHParameters) (obj)).amO, afM));
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception.getMessage());
        }
        return algorithmparameters;
    }

    protected void engineInit(int i, SecureRandom securerandom)
    {
        amD = i;
        amC = securerandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (!(algorithmparameterspec instanceof DHGenParameterSpec))
        {
            throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
        } else
        {
            algorithmparameterspec = (DHGenParameterSpec)algorithmparameterspec;
            amD = algorithmparameterspec.getPrimeSize();
            afM = algorithmparameterspec.getExponentSize();
            amC = securerandom;
            return;
        }
    }
}
