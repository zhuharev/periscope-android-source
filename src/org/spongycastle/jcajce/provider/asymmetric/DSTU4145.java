// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class DSTU4145
{
    public static class Mappings extends AsymmetricAlgorithmProvider
    {

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("KeyFactory.DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi");
            configurableprovider._mth0640("Alg.Alias.KeyFactory.DSTU-4145-2002", "DSTU4145");
            configurableprovider._mth0640("Alg.Alias.KeyFactory.DSTU4145-3410", "DSTU4145");
            _mth02CA(configurableprovider, UAObjectIdentifiers.afZ, "DSTU4145", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (new KeyFactorySpi())));
            _mth02CA(configurableprovider, UAObjectIdentifiers.afZ, "DSTU4145");
            _mth02CA(configurableprovider, UAObjectIdentifiers.aga, "DSTU4145", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (new KeyFactorySpi())));
            _mth02CA(configurableprovider, UAObjectIdentifiers.aga, "DSTU4145");
            configurableprovider._mth0640("KeyPairGenerator.DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.KeyPairGeneratorSpi");
            configurableprovider._mth0640("Alg.Alias.KeyPairGenerator.DSTU-4145", "DSTU4145");
            configurableprovider._mth0640("Alg.Alias.KeyPairGenerator.DSTU-4145-2002", "DSTU4145");
            configurableprovider._mth0640("Signature.DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpi");
            configurableprovider._mth0640("Alg.Alias.Signature.DSTU-4145", "DSTU4145");
            configurableprovider._mth0640("Alg.Alias.Signature.DSTU-4145-2002", "DSTU4145");
            _mth02CA(configurableprovider, "GOST3411", "DSTU4145LE", "org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpiLe", UAObjectIdentifiers.afZ);
            _mth02CA(configurableprovider, "GOST3411", "DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpi", UAObjectIdentifiers.aga);
        }

        public Mappings()
        {
        }
    }


    public DSTU4145()
    {
    }
}
