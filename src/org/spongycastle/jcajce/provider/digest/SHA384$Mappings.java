// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, SHA384

public static class ider extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/SHA384.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.SHA-384", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA384", "SHA-384");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(NISTObjectIdentifiers.ZE).toString(), "SHA-384");
        configurableprovider._mth0640("Mac.OLDHMACSHA384", (new StringBuilder()).append(PREFIX).append("$OldSHA384").toString());
        _mth02CA(configurableprovider, "SHA384", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        _mth02CA(configurableprovider, "SHA384", PKCSObjectIdentifiers.abG);
    }


    public ider()
    {
    }
}
