// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class ECGOST
{
    public static class Mappings extends AsymmetricAlgorithmProvider
    {

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("KeyFactory.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyFactorySpi");
            configurableprovider._mth0640("Alg.Alias.KeyFactory.GOST-3410-2001", "ECGOST3410");
            configurableprovider._mth0640("Alg.Alias.KeyFactory.ECGOST-3410", "ECGOST3410");
            _mth02CA(configurableprovider, CryptoProObjectIdentifiers.XW, "ECGOST3410", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (new KeyFactorySpi())));
            _mth02CA(configurableprovider, CryptoProObjectIdentifiers.XW, "ECGOST3410");
            configurableprovider._mth0640("KeyPairGenerator.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyPairGeneratorSpi");
            configurableprovider._mth0640("Alg.Alias.KeyPairGenerator.ECGOST-3410", "ECGOST3410");
            configurableprovider._mth0640("Alg.Alias.KeyPairGenerator.GOST-3410-2001", "ECGOST3410");
            configurableprovider._mth0640("Signature.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi");
            configurableprovider._mth0640("Alg.Alias.Signature.ECGOST-3410", "ECGOST3410");
            configurableprovider._mth0640("Alg.Alias.Signature.GOST-3410-2001", "ECGOST3410");
            _mth02CA(configurableprovider, "GOST3411", "ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi", CryptoProObjectIdentifiers.XY);
        }

        public Mappings()
        {
        }
    }


    public ECGOST()
    {
    }
}
