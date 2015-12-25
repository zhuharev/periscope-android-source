// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            SymmetricAlgorithmProvider, Noekeon

public static class  extends SymmetricAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/Noekeon.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("AlgorithmParameters.NOEKEON", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640("AlgorithmParameterGenerator.NOEKEON", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640("Cipher.NOEKEON", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640("KeyGenerator.NOEKEON", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        _mth02CB(configurableprovider, "NOEKEON", (new StringBuilder()).append(PREFIX).append("$GMAC").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        _mth02CE(configurableprovider, "NOEKEON", (new StringBuilder()).append(PREFIX).append("$Poly1305").toString(), (new StringBuilder()).append(PREFIX).append("$Poly1305KeyGen").toString());
    }


    public ()
    {
    }
}
