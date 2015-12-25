// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, Skein

public static class vider extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/digest/Skein.getName();

    private static void _mth02CA(ConfigurableProvider configurableprovider, int i, int j)
    {
        String s = (new StringBuilder("Skein-MAC-")).append(i).append("-").append(j).toString();
        String s1 = (new StringBuilder()).append(PREFIX).append("$SkeinMac_").append(i).append("_").append(j).toString();
        String s2 = (new StringBuilder()).append(PREFIX).append("$SkeinMacKeyGenerator_").append(i).append("_").append(j).toString();
        configurableprovider._mth0640((new StringBuilder("Mac.")).append(s).toString(), s1);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Mac.Skein-MAC")).append(i).append("/").append(j).toString(), s);
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(s).toString(), s2);
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyGenerator.Skein-MAC")).append(i).append("/").append(j).toString(), s);
    }

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("MessageDigest.Skein-256-128", (new StringBuilder()).append(PREFIX).append("$Digest_256_128").toString());
        configurableprovider._mth0640("MessageDigest.Skein-256-160", (new StringBuilder()).append(PREFIX).append("$Digest_256_160").toString());
        configurableprovider._mth0640("MessageDigest.Skein-256-224", (new StringBuilder()).append(PREFIX).append("$Digest_256_224").toString());
        configurableprovider._mth0640("MessageDigest.Skein-256-256", (new StringBuilder()).append(PREFIX).append("$Digest_256_256").toString());
        configurableprovider._mth0640("MessageDigest.Skein-512-128", (new StringBuilder()).append(PREFIX).append("$Digest_512_128").toString());
        configurableprovider._mth0640("MessageDigest.Skein-512-160", (new StringBuilder()).append(PREFIX).append("$Digest_512_160").toString());
        configurableprovider._mth0640("MessageDigest.Skein-512-224", (new StringBuilder()).append(PREFIX).append("$Digest_512_224").toString());
        configurableprovider._mth0640("MessageDigest.Skein-512-256", (new StringBuilder()).append(PREFIX).append("$Digest_512_256").toString());
        configurableprovider._mth0640("MessageDigest.Skein-512-384", (new StringBuilder()).append(PREFIX).append("$Digest_512_384").toString());
        configurableprovider._mth0640("MessageDigest.Skein-512-512", (new StringBuilder()).append(PREFIX).append("$Digest_512_512").toString());
        configurableprovider._mth0640("MessageDigest.Skein-1024-384", (new StringBuilder()).append(PREFIX).append("$Digest_1024_384").toString());
        configurableprovider._mth0640("MessageDigest.Skein-1024-512", (new StringBuilder()).append(PREFIX).append("$Digest_1024_512").toString());
        configurableprovider._mth0640("MessageDigest.Skein-1024-1024", (new StringBuilder()).append(PREFIX).append("$Digest_1024_1024").toString());
        _mth02CA(configurableprovider, "Skein-256-128", (new StringBuilder()).append(PREFIX).append("$HashMac_256_128").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_256_128").toString());
        _mth02CA(configurableprovider, "Skein-256-160", (new StringBuilder()).append(PREFIX).append("$HashMac_256_160").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_256_160").toString());
        _mth02CA(configurableprovider, "Skein-256-224", (new StringBuilder()).append(PREFIX).append("$HashMac_256_224").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_256_224").toString());
        _mth02CA(configurableprovider, "Skein-256-256", (new StringBuilder()).append(PREFIX).append("$HashMac_256_256").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_256_256").toString());
        _mth02CA(configurableprovider, "Skein-512-128", (new StringBuilder()).append(PREFIX).append("$HashMac_512_128").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_128").toString());
        _mth02CA(configurableprovider, "Skein-512-160", (new StringBuilder()).append(PREFIX).append("$HashMac_512_160").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_160").toString());
        _mth02CA(configurableprovider, "Skein-512-224", (new StringBuilder()).append(PREFIX).append("$HashMac_512_224").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_224").toString());
        _mth02CA(configurableprovider, "Skein-512-256", (new StringBuilder()).append(PREFIX).append("$HashMac_512_256").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_256").toString());
        _mth02CA(configurableprovider, "Skein-512-384", (new StringBuilder()).append(PREFIX).append("$HashMac_512_384").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_384").toString());
        _mth02CA(configurableprovider, "Skein-512-512", (new StringBuilder()).append(PREFIX).append("$HashMac_512_512").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_512").toString());
        _mth02CA(configurableprovider, "Skein-1024-384", (new StringBuilder()).append(PREFIX).append("$HashMac_1024_384").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_1024_384").toString());
        _mth02CA(configurableprovider, "Skein-1024-512", (new StringBuilder()).append(PREFIX).append("$HashMac_1024_512").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_1024_512").toString());
        _mth02CA(configurableprovider, "Skein-1024-1024", (new StringBuilder()).append(PREFIX).append("$HashMac_1024_1024").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_1024_1024").toString());
        _mth02CA(configurableprovider, 256, 128);
        _mth02CA(configurableprovider, 256, 160);
        _mth02CA(configurableprovider, 256, 224);
        _mth02CA(configurableprovider, 256, 256);
        _mth02CA(configurableprovider, 512, 128);
        _mth02CA(configurableprovider, 512, 160);
        _mth02CA(configurableprovider, 512, 224);
        _mth02CA(configurableprovider, 512, 256);
        _mth02CA(configurableprovider, 512, 384);
        _mth02CA(configurableprovider, 512, 512);
        _mth02CA(configurableprovider, 1024, 384);
        _mth02CA(configurableprovider, 1024, 512);
        _mth02CA(configurableprovider, 1024, 1024);
    }


    public vider()
    {
    }
}
