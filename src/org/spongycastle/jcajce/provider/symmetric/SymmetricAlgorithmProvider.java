// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

abstract class SymmetricAlgorithmProvider extends AlgorithmProvider
{

    SymmetricAlgorithmProvider()
    {
    }

    protected static void _mth02CB(ConfigurableProvider configurableprovider, String s, String s1, String s2)
    {
        configurableprovider._mth0640((new StringBuilder("Mac.")).append(s).append("-GMAC").toString(), s1);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Mac.")).append(s).append("GMAC").toString(), (new StringBuilder()).append(s).append("-GMAC").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(s).append("-GMAC").toString(), s2);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyGenerator.")).append(s).append("GMAC").toString(), (new StringBuilder()).append(s).append("-GMAC").toString());
    }

    protected static void _mth02CE(ConfigurableProvider configurableprovider, String s, String s1, String s2)
    {
        configurableprovider._mth0640((new StringBuilder("Mac.POLY1305-")).append(s).toString(), s1);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Mac.POLY1305")).append(s).toString(), (new StringBuilder("POLY1305-")).append(s).toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.POLY1305-")).append(s).toString(), s2);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyGenerator.POLY1305")).append(s).toString(), (new StringBuilder("POLY1305-")).append(s).toString());
    }
}
