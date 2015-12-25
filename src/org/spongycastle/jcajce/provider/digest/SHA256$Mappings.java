// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, SHA256

public static class ider extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/SHA256.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.SHA-256", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA256", "SHA-256");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(NISTObjectIdentifiers.ZD).toString(), "SHA-256");
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHHMACSHA256", (new StringBuilder()).append(PREFIX).append("$PBEWithMacKeyFactory").toString());
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA-256", "PBEWITHHMACSHA256");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(NISTObjectIdentifiers.ZD).toString(), "PBEWITHHMACSHA256");
        _mth02CA(configurableprovider, "SHA256", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        _mth02CA(configurableprovider, "SHA256", PKCSObjectIdentifiers.abF);
        _mth02CA(configurableprovider, "SHA256", NISTObjectIdentifiers.ZD);
    }


    public ider()
    {
    }
}
