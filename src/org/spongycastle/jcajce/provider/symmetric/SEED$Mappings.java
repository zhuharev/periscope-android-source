// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.kisa.KISAObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            SymmetricAlgorithmProvider, SEED

public static class der extends SymmetricAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/SEED.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("AlgorithmParameters.SEED", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(KISAObjectIdentifiers.Zq).toString(), "SEED");
        configurableprovider._mth0640("AlgorithmParameterGenerator.SEED", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(KISAObjectIdentifiers.Zq).toString(), "SEED");
        configurableprovider._mth0640("Cipher.SEED", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(KISAObjectIdentifiers.Zq).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640("Cipher.SEEDWRAP", (new StringBuilder()).append(PREFIX).append("$Wrap").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(KISAObjectIdentifiers.Zr).toString(), "SEEDWRAP");
        configurableprovider._mth0640("KeyGenerator.SEED", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(KISAObjectIdentifiers.Zq).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(KISAObjectIdentifiers.Zr).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        _mth02CB(configurableprovider, "SEED", (new StringBuilder()).append(PREFIX).append("$GMAC").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        _mth02CE(configurableprovider, "SEED", (new StringBuilder()).append(PREFIX).append("$Poly1305").toString(), (new StringBuilder()).append(PREFIX).append("$Poly1305KeyGen").toString());
    }


    public der()
    {
    }
}
