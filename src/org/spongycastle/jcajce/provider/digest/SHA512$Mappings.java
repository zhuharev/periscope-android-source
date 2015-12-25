// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, SHA512

public static class ider extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/SHA512.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.SHA-512", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA512", "SHA-512");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(NISTObjectIdentifiers.ZF).toString(), "SHA-512");
        configurableprovider._mth0640("MessageDigest.SHA-512/224", (new StringBuilder()).append(PREFIX).append("$DigestT224").toString());
        configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA512/224", "SHA-512/224");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(NISTObjectIdentifiers.ZH).toString(), "SHA-512/224");
        configurableprovider._mth0640("MessageDigest.SHA-512/256", (new StringBuilder()).append(PREFIX).append("$DigestT256").toString());
        configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA512256", "SHA-512/256");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(NISTObjectIdentifiers.ZI).toString(), "SHA-512/256");
        configurableprovider._mth0640("Mac.OLDHMACSHA512", (new StringBuilder()).append(PREFIX).append("$OldSHA512").toString());
        _mth02CA(configurableprovider, "SHA512", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        _mth02CA(configurableprovider, "SHA512", PKCSObjectIdentifiers.abH);
        _mth02CA(configurableprovider, "SHA512/224", (new StringBuilder()).append(PREFIX).append("$HashMacT224").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGeneratorT224").toString());
        _mth02CA(configurableprovider, "SHA512/256", (new StringBuilder()).append(PREFIX).append("$HashMacT256").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGeneratorT256").toString());
    }


    public ider()
    {
    }
}
