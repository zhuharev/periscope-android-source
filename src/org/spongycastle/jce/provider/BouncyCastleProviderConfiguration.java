// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.config.ProviderConfigurationPermission;
import org.spongycastle.jce.spec.ECParameterSpec;

class BouncyCastleProviderConfiguration
    implements ProviderConfiguration
{

    private ThreadLocal aHj;
    private ThreadLocal aHk;
    private volatile ECParameterSpec aHl;
    private volatile Object aHm;

    BouncyCastleProviderConfiguration()
    {
        aHj = new ThreadLocal();
        aHk = new ThreadLocal();
    }

    public final DHParameterSpec _mth06C1(int i)
    {
        Object obj1 = aHk.get();
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = aHm;
        }
        if (obj instanceof DHParameterSpec)
        {
            obj = (DHParameterSpec)obj;
            if (((DHParameterSpec) (obj)).getP().bitLength() == i)
            {
                return ((DHParameterSpec) (obj));
            }
        } else
        if (obj instanceof DHParameterSpec[])
        {
            DHParameterSpec adhparameterspec[] = (DHParameterSpec[])obj;
            for (int j = 0; j != adhparameterspec.length; j++)
            {
                if (adhparameterspec[j].getP().bitLength() == i)
                {
                    return adhparameterspec[j];
                }
            }

        }
        return null;
    }

    public final ECParameterSpec _mth1623()
    {
        ECParameterSpec ecparameterspec = (ECParameterSpec)aHj.get();
        if (ecparameterspec != null)
        {
            return ecparameterspec;
        } else
        {
            return aHl;
        }
    }

    static 
    {
        new ProviderConfigurationPermission("SC", "threadLocalEcImplicitlyCa");
        new ProviderConfigurationPermission("SC", "ecImplicitlyCa");
        new ProviderConfigurationPermission("SC", "threadLocalDhDefaultParams");
        new ProviderConfigurationPermission("SC", "DhDefaultParams");
    }
}
