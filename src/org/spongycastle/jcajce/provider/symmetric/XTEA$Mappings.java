// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            XTEA

public static class der extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/XTEA.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("Cipher.XTEA", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640("KeyGenerator.XTEA", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640("AlgorithmParameters.XTEA", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
    }


    public der()
    {
    }
}
