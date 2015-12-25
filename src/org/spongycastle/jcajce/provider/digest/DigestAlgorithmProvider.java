// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

abstract class DigestAlgorithmProvider extends AlgorithmProvider
{

    DigestAlgorithmProvider()
    {
    }

    protected static void _mth02CA(ConfigurableProvider configurableprovider, String s, String s1, String s2)
    {
        String s3 = (new StringBuilder("HMAC")).append(s).toString();
        configurableprovider._mth0640((new StringBuilder("Mac.")).append(s3).toString(), s1);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Mac.HMAC-")).append(s).toString(), s3);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Mac.HMAC/")).append(s).toString(), s3);
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(s3).toString(), s2);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyGenerator.HMAC-")).append(s).toString(), s3);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyGenerator.HMAC/")).append(s).toString(), s3);
    }

    protected static void _mth02CA(ConfigurableProvider configurableprovider, String s, ASN1ObjectIdentifier asn1objectidentifier)
    {
        s = (new StringBuilder("HMAC")).append(s).toString();
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Mac.")).append(asn1objectidentifier).toString(), s);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyGenerator.")).append(asn1objectidentifier).toString(), s);
    }
}
