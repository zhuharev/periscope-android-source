// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class GOST
{
    public static class Mappings extends AsymmetricAlgorithmProvider
    {

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("KeyPairGenerator.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.KeyPairGeneratorSpi");
            configurableprovider._mth0640("Alg.Alias.KeyPairGenerator.GOST-3410", "GOST3410");
            configurableprovider._mth0640("Alg.Alias.KeyPairGenerator.GOST-3410-94", "GOST3410");
            configurableprovider._mth0640("KeyFactory.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi");
            configurableprovider._mth0640("Alg.Alias.KeyFactory.GOST-3410", "GOST3410");
            configurableprovider._mth0640("Alg.Alias.KeyFactory.GOST-3410-94", "GOST3410");
            configurableprovider._mth0640("AlgorithmParameters.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.AlgorithmParametersSpi");
            configurableprovider._mth0640("AlgorithmParameterGenerator.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.AlgorithmParameterGeneratorSpi");
            _mth02CA(configurableprovider, CryptoProObjectIdentifiers.XV, "GOST3410", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (new KeyFactorySpi())));
            _mth02CA(configurableprovider, CryptoProObjectIdentifiers.XV, "GOST3410");
            configurableprovider._mth0640("Signature.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.SignatureSpi");
            configurableprovider._mth0640("Alg.Alias.Signature.GOST-3410", "GOST3410");
            configurableprovider._mth0640("Alg.Alias.Signature.GOST-3410-94", "GOST3410");
            configurableprovider._mth0640("Alg.Alias.Signature.GOST3411withGOST3410", "GOST3410");
            configurableprovider._mth0640("Alg.Alias.Signature.GOST3411WITHGOST3410", "GOST3410");
            configurableprovider._mth0640("Alg.Alias.Signature.GOST3411WithGOST3410", "GOST3410");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(CryptoProObjectIdentifiers.XX).toString(), "GOST3410");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.GOST-3410", "GOST3410");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.GOST-3410", "GOST3410");
        }

        public Mappings()
        {
        }
    }


    public GOST()
    {
    }
}
