// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class RSA
{
    public static class Mappings extends AsymmetricAlgorithmProvider
    {

        private static void _mth02CA(ConfigurableProvider configurableprovider, String s, String s1, ASN1ObjectIdentifier asn1objectidentifier)
        {
            String s2 = (new StringBuilder()).append(s).append("WITHRSA").toString();
            String s3 = (new StringBuilder()).append(s).append("withRSA").toString();
            String s4 = (new StringBuilder()).append(s).append("WithRSA").toString();
            String s5 = (new StringBuilder()).append(s).append("/RSA").toString();
            String s6 = (new StringBuilder()).append(s).append("WITHRSAENCRYPTION").toString();
            String s7 = (new StringBuilder()).append(s).append("withRSAEncryption").toString();
            s = (new StringBuilder()).append(s).append("WithRSAEncryption").toString();
            configurableprovider._mth0640((new StringBuilder("Signature.")).append(s2).toString(), s1);
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(s3).toString(), s2);
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(s4).toString(), s2);
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(s6).toString(), s2);
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(s7).toString(), s2);
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(s).toString(), s2);
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(s5).toString(), s2);
            if (asn1objectidentifier != null)
            {
                configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(asn1objectidentifier).toString(), s2);
                configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.OID.")).append(asn1objectidentifier).toString(), s2);
            }
        }

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("AlgorithmParameters.OAEP", "org.spongycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$OAEP");
            configurableprovider._mth0640("AlgorithmParameters.PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.RSAPSS", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.RSASSA-PSS", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.SHA224withRSA/PSS", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.SHA256withRSA/PSS", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.SHA384withRSA/PSS", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.SHA512withRSA/PSS", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.SHA224WITHRSAANDMGF1", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.SHA256WITHRSAANDMGF1", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.SHA384WITHRSAANDMGF1", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.SHA512WITHRSAANDMGF1", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.RAWRSAPSS", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.NONEWITHRSAPSS", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.NONEWITHRSASSA-PSS", "PSS");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.NONEWITHRSAANDMGF1", "PSS");
            configurableprovider._mth0640("Cipher.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            configurableprovider._mth0640("Cipher.RSA/RAW", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            configurableprovider._mth0640("Cipher.RSA/PKCS1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            configurableprovider._mth0640("Cipher.1.2.840.113549.1.1.1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            configurableprovider._mth0640("Cipher.2.5.8.1.1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            configurableprovider._mth0640("Cipher.RSA/1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PrivateOnly");
            configurableprovider._mth0640("Cipher.RSA/2", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PublicOnly");
            configurableprovider._mth0640("Cipher.RSA/OAEP", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            configurableprovider._mth0640((new StringBuilder("Cipher.")).append(PKCSObjectIdentifiers.abc).toString(), "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            configurableprovider._mth0640("Cipher.RSA/ISO9796-1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$ISO9796d1Padding");
            configurableprovider._mth0640("Alg.Alias.Cipher.RSA//RAW", "RSA");
            configurableprovider._mth0640("Alg.Alias.Cipher.RSA//NOPADDING", "RSA");
            configurableprovider._mth0640("Alg.Alias.Cipher.RSA//PKCS1PADDING", "RSA/PKCS1");
            configurableprovider._mth0640("Alg.Alias.Cipher.RSA//OAEPPADDING", "RSA/OAEP");
            configurableprovider._mth0640("Alg.Alias.Cipher.RSA//ISO9796-1PADDING", "RSA/ISO9796-1");
            configurableprovider._mth0640("KeyFactory.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi");
            configurableprovider._mth0640("KeyPairGenerator.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi");
            KeyFactorySpi keyfactoryspi = new KeyFactorySpi();
            _mth02CA(configurableprovider, PKCSObjectIdentifiers.aaX, "RSA", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (keyfactoryspi)));
            _mth02CA(configurableprovider, X509ObjectIdentifiers.akE, "RSA", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (keyfactoryspi)));
            _mth02CA(configurableprovider, PKCSObjectIdentifiers.abc, "RSA", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (keyfactoryspi)));
            _mth02CA(configurableprovider, PKCSObjectIdentifiers.abf, "RSA", ((org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter) (keyfactoryspi)));
            _mth02CA(configurableprovider, PKCSObjectIdentifiers.aaX, "RSA");
            _mth02CA(configurableprovider, X509ObjectIdentifiers.akE, "RSA");
            _mth02CA(configurableprovider, PKCSObjectIdentifiers.abc, "OAEP");
            _mth02CA(configurableprovider, PKCSObjectIdentifiers.abf, "PSS");
            configurableprovider._mth0640("Signature.RSASSA-PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            configurableprovider._mth0640((new StringBuilder("Signature.")).append(PKCSObjectIdentifiers.abf).toString(), "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            configurableprovider._mth0640((new StringBuilder("Signature.OID.")).append(PKCSObjectIdentifiers.abf).toString(), "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            configurableprovider._mth0640("Signature.SHA224WITHRSAANDMGF1", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSA");
            configurableprovider._mth0640("Signature.SHA256WITHRSAANDMGF1", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSA");
            configurableprovider._mth0640("Signature.SHA384WITHRSAANDMGF1", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSA");
            configurableprovider._mth0640("Signature.SHA512WITHRSAANDMGF1", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSA");
            configurableprovider._mth0640("Signature.SHA224withRSA/PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSA");
            configurableprovider._mth0640("Signature.SHA256withRSA/PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSA");
            configurableprovider._mth0640("Signature.SHA384withRSA/PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSA");
            configurableprovider._mth0640("Signature.SHA512withRSA/PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSA");
            configurableprovider._mth0640("Signature.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$noneRSA");
            configurableprovider._mth0640("Signature.RAWRSASSA-PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$nonePSS");
            configurableprovider._mth0640("Alg.Alias.Signature.RAWRSA", "RSA");
            configurableprovider._mth0640("Alg.Alias.Signature.NONEWITHRSA", "RSA");
            configurableprovider._mth0640("Alg.Alias.Signature.RAWRSAPSS", "RAWRSASSA-PSS");
            configurableprovider._mth0640("Alg.Alias.Signature.NONEWITHRSAPSS", "RAWRSASSA-PSS");
            configurableprovider._mth0640("Alg.Alias.Signature.NONEWITHRSASSA-PSS", "RAWRSASSA-PSS");
            configurableprovider._mth0640("Alg.Alias.Signature.NONEWITHRSAANDMGF1", "RAWRSASSA-PSS");
            configurableprovider._mth0640("Alg.Alias.Signature.RSAPSS", "RSASSA-PSS");
            configurableprovider._mth0640("Alg.Alias.Signature.SHA224withRSAandMGF1", "SHA224withRSA/PSS");
            configurableprovider._mth0640("Alg.Alias.Signature.SHA256withRSAandMGF1", "SHA256withRSA/PSS");
            configurableprovider._mth0640("Alg.Alias.Signature.SHA384withRSAandMGF1", "SHA384withRSA/PSS");
            configurableprovider._mth0640("Alg.Alias.Signature.SHA512withRSAandMGF1", "SHA512withRSA/PSS");
            if (configurableprovider._mth1427("MessageDigest", "MD2"))
            {
                _mth02CA(configurableprovider, "MD2", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD2", PKCSObjectIdentifiers.aaY);
            }
            if (configurableprovider._mth1427("MessageDigest", "MD4"))
            {
                _mth02CA(configurableprovider, "MD4", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD4", PKCSObjectIdentifiers.aaZ);
            }
            if (configurableprovider._mth1427("MessageDigest", "MD5"))
            {
                _mth02CA(configurableprovider, "MD5", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD5", PKCSObjectIdentifiers.aba);
                configurableprovider._mth0640("Signature.MD5withRSA/ISO9796-2", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$MD5WithRSAEncryption");
                configurableprovider._mth0640("Alg.Alias.Signature.MD5WithRSA/ISO9796-2", "MD5withRSA/ISO9796-2");
            }
            if (configurableprovider._mth1427("MessageDigest", "SHA1"))
            {
                configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.SHA1withRSA/PSS", "PSS");
                configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.SHA1WITHRSAANDMGF1", "PSS");
                configurableprovider._mth0640("Signature.SHA1withRSA/PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSA");
                configurableprovider._mth0640("Alg.Alias.Signature.SHA1withRSAandMGF1", "SHA1withRSA/PSS");
                configurableprovider._mth0640("Alg.Alias.Signature.SHA1WITHRSAANDMGF1", "SHA1withRSA/PSS");
                _mth02CA(configurableprovider, "SHA1", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA1", PKCSObjectIdentifiers.abb);
                configurableprovider._mth0640("Alg.Alias.Signature.SHA1WithRSA/ISO9796-2", "SHA1withRSA/ISO9796-2");
                configurableprovider._mth0640("Signature.SHA1withRSA/ISO9796-2", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA1WithRSAEncryption");
                configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.")).append(OIWObjectIdentifiers.aax).toString(), "SHA1WITHRSA");
                configurableprovider._mth0640((new StringBuilder("Alg.Alias.Signature.OID.")).append(OIWObjectIdentifiers.aax).toString(), "SHA1WITHRSA");
            }
            _mth02CA(configurableprovider, "SHA224", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA224", PKCSObjectIdentifiers.abj);
            _mth02CA(configurableprovider, "SHA256", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA256", PKCSObjectIdentifiers.abg);
            _mth02CA(configurableprovider, "SHA384", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA384", PKCSObjectIdentifiers.abh);
            _mth02CA(configurableprovider, "SHA512", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512", PKCSObjectIdentifiers.abi);
            if (configurableprovider._mth1427("MessageDigest", "RIPEMD128"))
            {
                _mth02CA(configurableprovider, "RIPEMD128", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", TeleTrusTObjectIdentifiers.afo);
                _mth02CA(configurableprovider, "RMD128", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", null);
            }
            if (configurableprovider._mth1427("MessageDigest", "RIPEMD160"))
            {
                _mth02CA(configurableprovider, "RIPEMD160", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", TeleTrusTObjectIdentifiers.afn);
                _mth02CA(configurableprovider, "RMD160", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", null);
                configurableprovider._mth0640("Alg.Alias.Signature.RIPEMD160WithRSA/ISO9796-2", "RIPEMD160withRSA/ISO9796-2");
                configurableprovider._mth0640("Signature.RIPEMD160withRSA/ISO9796-2", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$RIPEMD160WithRSAEncryption");
            }
            if (configurableprovider._mth1427("MessageDigest", "RIPEMD256"))
            {
                _mth02CA(configurableprovider, "RIPEMD256", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", TeleTrusTObjectIdentifiers.afp);
                _mth02CA(configurableprovider, "RMD256", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", null);
            }
        }

        public Mappings()
        {
        }
    }


    public RSA()
    {
    }
}
