// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            Threefish

public static class  extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/Threefish.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("Cipher.Threefish-256", (new StringBuilder()).append(PREFIX).append("$ECB_256").toString());
        configurableprovider._mth0640("Cipher.Threefish-512", (new StringBuilder()).append(PREFIX).append("$ECB_512").toString());
        configurableprovider._mth0640("Cipher.Threefish-1024", (new StringBuilder()).append(PREFIX).append("$ECB_1024").toString());
        configurableprovider._mth0640("KeyGenerator.Threefish-256", (new StringBuilder()).append(PREFIX).append("$KeyGen_256").toString());
        configurableprovider._mth0640("KeyGenerator.Threefish-512", (new StringBuilder()).append(PREFIX).append("$KeyGen_512").toString());
        configurableprovider._mth0640("KeyGenerator.Threefish-1024", (new StringBuilder()).append(PREFIX).append("$KeyGen_1024").toString());
        configurableprovider._mth0640("AlgorithmParameters.Threefish-256", (new StringBuilder()).append(PREFIX).append("$AlgParams_256").toString());
        configurableprovider._mth0640("AlgorithmParameters.Threefish-512", (new StringBuilder()).append(PREFIX).append("$AlgParams_512").toString());
        configurableprovider._mth0640("AlgorithmParameters.Threefish-1024", (new StringBuilder()).append(PREFIX).append("$AlgParams_1024").toString());
    }


    public ()
    {
    }
}
