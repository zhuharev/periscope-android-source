// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, SHA1

public static class ovider extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/SHA1.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.SHA-1", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA1", "SHA-1");
        configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA", "SHA-1");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(OIWObjectIdentifiers.aav).toString(), "SHA-1");
        _mth02CA(configurableprovider, "SHA1", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        _mth02CA(configurableprovider, "SHA1", PKCSObjectIdentifiers.abD);
        _mth02CA(configurableprovider, "SHA1", IANAObjectIdentifiers.Zd);
        configurableprovider._mth0640("Mac.PBEWITHHMACSHA", (new StringBuilder()).append(PREFIX).append("$SHA1Mac").toString());
        configurableprovider._mth0640("Mac.PBEWITHHMACSHA1", (new StringBuilder()).append(PREFIX).append("$SHA1Mac").toString());
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBEWITHHMACSHA1");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(OIWObjectIdentifiers.aav).toString(), "PBEWITHHMACSHA1");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Mac.")).append(OIWObjectIdentifiers.aav).toString(), "PBEWITHHMACSHA");
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHHMACSHA1", (new StringBuilder()).append(PREFIX).append("$PBEWithMacKeyFactory").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBKDF2WithHmacSHA1", (new StringBuilder()).append(PREFIX).append("$PBKDF2WithHmacSHA1UTF8").toString());
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBKDF2WithHmacSHA1AndUTF8", "PBKDF2WithHmacSHA1");
        configurableprovider._mth0640("SecretKeyFactory.PBKDF2WithHmacSHA1And8BIT", (new StringBuilder()).append(PREFIX).append("$PBKDF2WithHmacSHA18BIT").toString());
    }


    public ovider()
    {
    }
}
