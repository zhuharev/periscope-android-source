// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider:
//            Rainbow

public static class ovider extends AsymmetricAlgorithmProvider
{

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("KeyFactory.Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi");
        configurableprovider._mth0640("KeyPairGenerator.Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.RainbowKeyPairGeneratorSpi");
        _mth02CA(configurableprovider, "SHA224", "Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha224", PQCObjectIdentifiers.aJV);
        _mth02CA(configurableprovider, "SHA256", "Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha256", PQCObjectIdentifiers.aJW);
        _mth02CA(configurableprovider, "SHA384", "Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha384", PQCObjectIdentifiers.aJX);
        _mth02CA(configurableprovider, "SHA512", "Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha512", PQCObjectIdentifiers.aJY);
        RainbowKeyFactorySpi rainbowkeyfactoryspi = new RainbowKeyFactorySpi();
        _mth02CA(configurableprovider, PQCObjectIdentifiers.aJU, "Rainbow", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (rainbowkeyfactoryspi)));
        _mth02CA(configurableprovider, PQCObjectIdentifiers.aJU, "Rainbow");
    }

    public ovider()
    {
    }
}
