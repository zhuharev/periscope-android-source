// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, GOST3411

public static class er extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/GOST3411.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.GOST3411", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        configurableprovider._mth0640("Alg.Alias.MessageDigest.GOST", "GOST3411");
        configurableprovider._mth0640("Alg.Alias.MessageDigest.GOST-3411", "GOST3411");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(CryptoProObjectIdentifiers.XO).toString(), "GOST3411");
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHHMACGOST3411", (new StringBuilder()).append(PREFIX).append("$PBEWithMacKeyFactory").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(CryptoProObjectIdentifiers.XO).toString(), "PBEWITHHMACGOST3411");
        _mth02CA(configurableprovider, "GOST3411", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        _mth02CA(configurableprovider, "GOST3411", CryptoProObjectIdentifiers.XO);
    }


    public er()
    {
    }
}
