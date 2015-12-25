// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            CAST5

public static class er extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/CAST5.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("AlgorithmParameters.CAST5", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.1.2.840.113533.7.66.10", "CAST5");
        configurableprovider._mth0640("AlgorithmParameterGenerator.CAST5", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.1.2.840.113533.7.66.10", "CAST5");
        configurableprovider._mth0640("Cipher.CAST5", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640("Cipher.1.2.840.113533.7.66.10", (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640("KeyGenerator.CAST5", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640("Alg.Alias.KeyGenerator.1.2.840.113533.7.66.10", "CAST5");
    }


    public er()
    {
    }
}
