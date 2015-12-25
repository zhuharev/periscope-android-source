// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, SHA224

public static class ider extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/SHA224.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.SHA-224", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA224", "SHA-224");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(NISTObjectIdentifiers.ZG).toString(), "SHA-224");
        _mth02CA(configurableprovider, "SHA224", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        _mth02CA(configurableprovider, "SHA224", PKCSObjectIdentifiers.abE);
    }


    public ider()
    {
    }
}
