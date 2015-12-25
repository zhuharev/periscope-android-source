// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, SHA3

public static class ovider extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/SHA3.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.SHA3-224", (new StringBuilder()).append(PREFIX).append("$Digest224").toString());
        configurableprovider._mth0640("MessageDigest.SHA3-256", (new StringBuilder()).append(PREFIX).append("$Digest256").toString());
        configurableprovider._mth0640("MessageDigest.SHA3-384", (new StringBuilder()).append(PREFIX).append("$Digest384").toString());
        configurableprovider._mth0640("MessageDigest.SHA3-512", (new StringBuilder()).append(PREFIX).append("$Digest512").toString());
        _mth02CA(configurableprovider, "SHA3-224", (new StringBuilder()).append(PREFIX).append("$HashMac224").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator224").toString());
        _mth02CA(configurableprovider, "SHA3-256", (new StringBuilder()).append(PREFIX).append("$HashMac256").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator256").toString());
        _mth02CA(configurableprovider, "SHA3-384", (new StringBuilder()).append(PREFIX).append("$HashMac384").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator384").toString());
        _mth02CA(configurableprovider, "SHA3-512", (new StringBuilder()).append(PREFIX).append("$HashMac512").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator512").toString());
    }


    public ovider()
    {
    }
}
