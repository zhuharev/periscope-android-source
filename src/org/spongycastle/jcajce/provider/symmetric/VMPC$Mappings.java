// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            VMPC

public static class der extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/VMPC.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("Cipher.VMPC", (new StringBuilder()).append(PREFIX).append("$Base").toString());
        configurableprovider._mth0640("KeyGenerator.VMPC", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640("Mac.VMPCMAC", (new StringBuilder()).append(PREFIX).append("$Mac").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.VMPC", "VMPCMAC");
        configurableprovider._mth0640("Alg.Alias.Mac.VMPC-MAC", "VMPCMAC");
    }


    public der()
    {
    }
}
