// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, Tiger

public static class vider extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/Tiger.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.TIGER", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        configurableprovider._mth0640("MessageDigest.Tiger", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        _mth02CA(configurableprovider, "TIGER", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        _mth02CA(configurableprovider, "TIGER", IANAObjectIdentifiers.Ze);
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHHMACTIGER", (new StringBuilder()).append(PREFIX).append("$PBEWithMacKeyFactory").toString());
    }


    public vider()
    {
    }
}
