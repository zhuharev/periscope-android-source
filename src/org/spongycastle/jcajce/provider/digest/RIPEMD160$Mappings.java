// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, RIPEMD160

public static class r extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/RIPEMD160.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.RIPEMD160", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(TeleTrusTObjectIdentifiers.afj).toString(), "RIPEMD160");
        _mth02CA(configurableprovider, "RIPEMD160", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        _mth02CA(configurableprovider, "RIPEMD160", IANAObjectIdentifiers.Zf);
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHHMACRIPEMD160", (new StringBuilder()).append(PREFIX).append("$PBEWithHmacKeyFactory").toString());
        configurableprovider._mth0640("Mac.PBEWITHHMACRIPEMD160", (new StringBuilder()).append(PREFIX).append("$PBEWithHmac").toString());
    }


    public r()
    {
    }
}
