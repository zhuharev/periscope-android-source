// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, MD2

public static class rovider extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/MD2.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.MD2", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(PKCSObjectIdentifiers.abA).toString(), "MD2");
        _mth02CA(configurableprovider, "MD2", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
    }


    public rovider()
    {
    }
}
