// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            SipHash

public static class  extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/SipHash.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("Mac.SIPHASH-2-4", (new StringBuilder()).append(PREFIX).append("$Mac24").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.SIPHASH", "SIPHASH-2-4");
        configurableprovider._mth0640("Mac.SIPHASH-4-8", (new StringBuilder()).append(PREFIX).append("$Mac48").toString());
        configurableprovider._mth0640("KeyGenerator.SIPHASH", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640("Alg.Alias.KeyGenerator.SIPHASH-2-4", "SIPHASH");
        configurableprovider._mth0640("Alg.Alias.KeyGenerator.SIPHASH-4-8", "SIPHASH");
    }


    public ()
    {
    }
}
