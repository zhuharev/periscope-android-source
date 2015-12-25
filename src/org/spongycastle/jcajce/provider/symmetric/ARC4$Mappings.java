// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            ARC4

public static class der extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/ARC4.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("Cipher.ARC4", (new StringBuilder()).append(PREFIX).append("$Base").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.aby).toString(), "ARC4");
        configurableprovider._mth0640("Alg.Alias.Cipher.ARCFOUR", "ARC4");
        configurableprovider._mth0640("Alg.Alias.Cipher.RC4", "ARC4");
        configurableprovider._mth0640("KeyGenerator.ARC4", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640("Alg.Alias.KeyGenerator.RC4", "ARC4");
        configurableprovider._mth0640("Alg.Alias.KeyGenerator.1.2.840.113549.3.4", "ARC4");
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND128BITRC4", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd128BitKeyFactory").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND40BITRC4", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd40BitKeyFactory").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(PKCSObjectIdentifiers.acO).toString(), "PKCS12PBE");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(PKCSObjectIdentifiers.acP).toString(), "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC4", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC4", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC4", "PKCS12PBE");
        configurableprovider._mth0640("Cipher.PBEWITHSHAAND128BITRC4", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd128Bit").toString());
        configurableprovider._mth0640("Cipher.PBEWITHSHAAND40BITRC4", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd40Bit").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.acO).toString(), "PBEWITHSHAAND128BITRC4");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.acP).toString(), "PBEWITHSHAAND40BITRC4");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC4", "PBEWITHSHAAND128BITRC4");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC4", "PBEWITHSHAAND40BITRC4");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.acO).toString(), "PBEWITHSHAAND128BITRC4");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.acP).toString(), "PBEWITHSHAAND40BITRC4");
    }


    public der()
    {
    }
}
