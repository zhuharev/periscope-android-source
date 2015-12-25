// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class DH
{
    public static class Mappings extends AsymmetricAlgorithmProvider
    {

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("KeyPairGenerator.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.KeyPairGeneratorSpi");
            configurableprovider._mth0640("Alg.Alias.KeyPairGenerator.DIFFIEHELLMAN", "DH");
            configurableprovider._mth0640("KeyAgreement.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi");
            configurableprovider._mth0640("Alg.Alias.KeyAgreement.DIFFIEHELLMAN", "DH");
            configurableprovider._mth0640("KeyFactory.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi");
            configurableprovider._mth0640("Alg.Alias.KeyFactory.DIFFIEHELLMAN", "DH");
            configurableprovider._mth0640("AlgorithmParameters.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.AlgorithmParametersSpi");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.DIFFIEHELLMAN", "DH");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.DIFFIEHELLMAN", "DH");
            configurableprovider._mth0640("AlgorithmParameterGenerator.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.AlgorithmParameterGeneratorSpi");
            configurableprovider._mth0640("Cipher.DHIES", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$IES");
            configurableprovider._mth0640("Cipher.DHIESwithAES", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAES");
            configurableprovider._mth0640("Cipher.DHIESWITHAES", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAES");
            configurableprovider._mth0640("Cipher.DHIESWITHDESEDE", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESede");
            _mth02CA(configurableprovider, PKCSObjectIdentifiers.abl, "DH", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (new KeyFactorySpi())));
            _mth02CA(configurableprovider, X9ObjectIdentifiers.ams, "DH", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (new KeyFactorySpi())));
        }

        public Mappings()
        {
        }
    }


    public DH()
    {
    }
}
