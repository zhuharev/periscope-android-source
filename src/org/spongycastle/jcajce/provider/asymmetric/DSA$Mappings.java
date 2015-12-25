// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.dsa.DSAUtil;
import org.spongycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric:
//            DSA

public static class der extends AsymmetricAlgorithmProvider
{

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("AlgorithmParameters.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi");
        configurableprovider._mth0640("AlgorithmParameterGenerator.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.AlgorithmParameterGeneratorSpi");
        configurableprovider._mth0640("KeyPairGenerator.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.KeyPairGeneratorSpi");
        configurableprovider._mth0640("KeyFactory.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi");
        configurableprovider._mth0640("Signature.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$stdDSA");
        configurableprovider._mth0640("Signature.NONEWITHDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$noneDSA");
        configurableprovider._mth0640("Alg.Alias.Signature.RAWDSA", "NONEWITHDSA");
        configurableprovider._mth0640("Signature.DETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
        configurableprovider._mth0640("Signature.SHA1WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
        configurableprovider._mth0640("Signature.SHA224WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
        configurableprovider._mth0640("Signature.SHA256WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
        configurableprovider._mth0640("Signature.SHA384WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
        configurableprovider._mth0640("Signature.SHA512WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
        _mth02CA(configurableprovider, "SHA224", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa224", NISTObjectIdentifiers.aad);
        _mth02CA(configurableprovider, "SHA256", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa256", NISTObjectIdentifiers.aae);
        _mth02CA(configurableprovider, "SHA384", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa384", NISTObjectIdentifiers.aaf);
        _mth02CA(configurableprovider, "SHA512", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa512", NISTObjectIdentifiers.aag);
        configurableprovider._mth0640("Alg.Alias.Signature.SHA/DSA", "DSA");
        configurableprovider._mth0640("Alg.Alias.Signature.SHA1withDSA", "DSA");
        configurableprovider._mth0640("Alg.Alias.Signature.SHA1WITHDSA", "DSA");
        configurableprovider._mth0640("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.1", "DSA");
        configurableprovider._mth0640("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.3", "DSA");
        configurableprovider._mth0640("Alg.Alias.Signature.DSAwithSHA1", "DSA");
        configurableprovider._mth0640("Alg.Alias.Signature.DSAWITHSHA1", "DSA");
        configurableprovider._mth0640("Alg.Alias.Signature.SHA1WithDSA", "DSA");
        configurableprovider._mth0640("Alg.Alias.Signature.DSAWithSHA1", "DSA");
        configurableprovider._mth0640("Alg.Alias.Signature.1.2.840.10040.4.3", "DSA");
        KeyFactorySpi keyfactoryspi = new KeyFactorySpi();
        int i = 0;
        do
        {
            org.spongycastle.asn1.ASN1ObjectIdentifier aasn1objectidentifier[] = DSAUtil.aDa;
            if (i != 2)
            {
                configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(DSAUtil.aDa[i]).toString(), "DSA");
                _mth02CA(configurableprovider, DSAUtil.aDa[i], "DSA", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (keyfactoryspi)));
                _mth02CA(configurableprovider, DSAUtil.aDa[i], "DSA");
                i++;
            } else
            {
                return;
            }
        } while (true);
    }

    public der()
    {
    }
}
