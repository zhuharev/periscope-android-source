// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.bsi.BSIObjectIdentifiers;
import org.spongycastle.asn1.eac.EACObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric:
//            EC

public static class ider extends AsymmetricAlgorithmProvider
{

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("KeyAgreement.ECDH", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DH");
        configurableprovider._mth0640("KeyAgreement.ECDHC", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC");
        configurableprovider._mth0640("KeyAgreement.ECMQV", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQV");
        configurableprovider._mth0640((new StringBuilder("KeyAgreement.")).append(X9ObjectIdentifiers.amp).toString(), "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDF");
        configurableprovider._mth0640((new StringBuilder("KeyAgreement.")).append(X9ObjectIdentifiers.amq).toString(), "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1KDF");
        configurableprovider._mth0640("KeyAgreement.ECDHWITHSHA1KDF", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDF");
        _mth02CA(configurableprovider, X9ObjectIdentifiers.alH, "EC", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (new org.spongycastle.jcajce.provider.asymmetric.ec.i.EC())));
        _mth02CA(configurableprovider, X9ObjectIdentifiers.amp, "EC", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (new org.spongycastle.jcajce.provider.asymmetric.ec.i.EC())));
        _mth02CA(configurableprovider, X9ObjectIdentifiers.amq, "ECMQV", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (new org.spongycastle.jcajce.provider.asymmetric.ec.i.ECMQV())));
        _mth02CA(configurableprovider, X9ObjectIdentifiers.alH, "EC");
        _mth02CA(configurableprovider, X9ObjectIdentifiers.amp, "EC");
        _mth02CA(configurableprovider, X9ObjectIdentifiers.amq, "EC");
        configurableprovider._mth0640("KeyFactory.EC", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$EC");
        configurableprovider._mth0640("KeyFactory.ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDSA");
        configurableprovider._mth0640("KeyFactory.ECDH", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDH");
        configurableprovider._mth0640("KeyFactory.ECDHC", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDHC");
        configurableprovider._mth0640("KeyFactory.ECMQV", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECMQV");
        configurableprovider._mth0640("KeyPairGenerator.EC", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$EC");
        configurableprovider._mth0640("KeyPairGenerator.ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDSA");
        configurableprovider._mth0640("KeyPairGenerator.ECDH", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
        configurableprovider._mth0640("KeyPairGenerator.ECDHWITHSHA1KDF", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
        configurableprovider._mth0640("KeyPairGenerator.ECDHC", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDHC");
        configurableprovider._mth0640("KeyPairGenerator.ECIES", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
        configurableprovider._mth0640("KeyPairGenerator.ECMQV", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECMQV");
        configurableprovider._mth0640("Cipher.ECIES", "org.spongycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIES");
        configurableprovider._mth0640("Cipher.ECIESwithAES", "org.spongycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAES");
        configurableprovider._mth0640("Cipher.ECIESWITHAES", "org.spongycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAES");
        configurableprovider._mth0640("Cipher.ECIESwithDESEDE", "org.spongycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESede");
        configurableprovider._mth0640("Cipher.ECIESWITHDESEDE", "org.spongycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESede");
        configurableprovider._mth0640("Cipher.ECIESwithAES-CBC", "org.spongycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC");
        configurableprovider._mth0640("Cipher.ECIESWITHAES-CBC", "org.spongycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC");
        configurableprovider._mth0640("Cipher.ECIESwithDESEDE-CBC", "org.spongycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC");
        configurableprovider._mth0640("Cipher.ECIESWITHDESEDE-CBC", "org.spongycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC");
        configurableprovider._mth0640("Signature.ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA");
        configurableprovider._mth0640("Signature.NONEwithECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSAnone");
        configurableprovider._mth0640("Alg.Alias.Signature.SHA1withECDSA", "ECDSA");
        configurableprovider._mth0640("Alg.Alias.Signature.ECDSAwithSHA1", "ECDSA");
        configurableprovider._mth0640("Alg.Alias.Signature.SHA1WITHECDSA", "ECDSA");
        configurableprovider._mth0640("Alg.Alias.Signature.ECDSAWITHSHA1", "ECDSA");
        configurableprovider._mth0640("Alg.Alias.Signature.SHA1WithECDSA", "ECDSA");
        configurableprovider._mth0640("Alg.Alias.Signature.ECDSAWithSHA1", "ECDSA");
        configurableprovider._mth0640("Alg.Alias.Signature.1.2.840.10045.4.1", "ECDSA");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(TeleTrusTObjectIdentifiers.afr).toString(), "ECDSA");
        configurableprovider._mth0640("Signature.DETECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA");
        configurableprovider._mth0640("Signature.SHA1WITHDETECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA");
        configurableprovider._mth0640("Signature.SHA224WITHDETECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA224");
        configurableprovider._mth0640("Signature.SHA256WITHDETECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA256");
        configurableprovider._mth0640("Signature.SHA384WITHDETECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA384");
        configurableprovider._mth0640("Signature.SHA512WITHDETECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA512");
        _mth02CA(configurableprovider, "SHA224", "ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA224", X9ObjectIdentifiers.alJ);
        _mth02CA(configurableprovider, "SHA256", "ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA256", X9ObjectIdentifiers.alK);
        _mth02CA(configurableprovider, "SHA384", "ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA384", X9ObjectIdentifiers.alL);
        _mth02CA(configurableprovider, "SHA512", "ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA512", X9ObjectIdentifiers.alM);
        _mth02CA(configurableprovider, "RIPEMD160", "ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSARipeMD160", TeleTrusTObjectIdentifiers.afs);
        configurableprovider._mth0640("Signature.SHA1WITHECNR", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR");
        configurableprovider._mth0640("Signature.SHA224WITHECNR", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR224");
        configurableprovider._mth0640("Signature.SHA256WITHECNR", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR256");
        configurableprovider._mth0640("Signature.SHA384WITHECNR", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR384");
        configurableprovider._mth0640("Signature.SHA512WITHECNR", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR512");
        _mth02CA(configurableprovider, "SHA1", "CVC-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA", EACObjectIdentifiers.YP);
        _mth02CA(configurableprovider, "SHA224", "CVC-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224", EACObjectIdentifiers.YQ);
        _mth02CA(configurableprovider, "SHA256", "CVC-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256", EACObjectIdentifiers.YR);
        _mth02CA(configurableprovider, "SHA384", "CVC-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA384", EACObjectIdentifiers.YS);
        _mth02CA(configurableprovider, "SHA512", "CVC-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA512", EACObjectIdentifiers.YT);
        _mth02CA(configurableprovider, "SHA1", "PLAIN-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA", BSIObjectIdentifiers.Xr);
        _mth02CA(configurableprovider, "SHA224", "PLAIN-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224", BSIObjectIdentifiers.Xs);
        _mth02CA(configurableprovider, "SHA256", "PLAIN-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256", BSIObjectIdentifiers.Xt);
        _mth02CA(configurableprovider, "SHA384", "PLAIN-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA384", BSIObjectIdentifiers.Xu);
        _mth02CA(configurableprovider, "SHA512", "PLAIN-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA512", BSIObjectIdentifiers.Xv);
        _mth02CA(configurableprovider, "RIPEMD160", "PLAIN-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecPlainDSARP160", BSIObjectIdentifiers.Xw);
    }

    public ider()
    {
    }
}
