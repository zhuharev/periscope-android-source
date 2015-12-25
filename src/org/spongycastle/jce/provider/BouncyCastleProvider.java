// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.security.AccessController;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

// Referenced classes of package org.spongycastle.jce.provider:
//            BouncyCastleProviderConfiguration

public final class BouncyCastleProvider extends Provider
    implements ConfigurableProvider
{

    public static final BouncyCastleProviderConfiguration aGZ = new BouncyCastleProviderConfiguration();
    private static final HashMap aHa = new HashMap();
    private static final String aHb[] = {
        "PBEPBKDF2", "PBEPKCS12"
    };
    private static final String aHc[] = {
        "SipHash"
    };
    private static final String aHd[] = {
        "AES", "ARC4", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", 
        "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", 
        "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", 
        "XTEA", "XSalsa20"
    };
    private static final String aHe[] = {
        "X509", "IES"
    };
    private static final String aHf[] = {
        "DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145"
    };
    private static final String aHg[] = {
        "GOST3411", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", 
        "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool"
    };
    private static final String aHh[] = {
        "BC", "PKCS12"
    };
    private static String info = "BouncyCastle Security Provider v1.51";

    public BouncyCastleProvider()
    {
        super("SC", 1.51D, info);
        AccessController.doPrivileged(new _cls1());
    }

    private void _mth02CA(String s, String as[])
    {
        int i = 0;
_L3:
        if (i == as.length) goto _L2; else goto _L1
_L1:
        Class class1 = null;
        Object obj = getClass().getClassLoader();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj = ((ClassLoader) (obj)).loadClass((new StringBuilder()).append(s).append(as[i]).append("$Mappings").toString());
        class1 = ((Class) (obj));
        break MISSING_BLOCK_LABEL_99;
        obj = Class.forName((new StringBuilder()).append(s).append(as[i]).append("$Mappings").toString());
        class1 = ((Class) (obj));
_L4:
        if (class1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            ((AlgorithmProvider)class1.newInstance())._mth02CA(this);
        }
        catch (Exception exception)
        {
            throw new InternalError((new StringBuilder("cannot create instance of ")).append(s).append(as[i]).append("$Mappings : ").append(exception).toString());
        }
        i++;
          goto _L3
_L2:
        return;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
          goto _L4
    }

    static void _mth02CA(BouncyCastleProvider bouncycastleprovider)
    {
        bouncycastleprovider._mth02CA("org.spongycastle.jcajce.provider.digest.", aHg);
        bouncycastleprovider._mth02CA("org.spongycastle.jcajce.provider.symmetric.", aHb);
        bouncycastleprovider._mth02CA("org.spongycastle.jcajce.provider.symmetric.", aHc);
        bouncycastleprovider._mth02CA("org.spongycastle.jcajce.provider.symmetric.", aHd);
        bouncycastleprovider._mth02CA("org.spongycastle.jcajce.provider.asymmetric.", aHe);
        bouncycastleprovider._mth02CA("org.spongycastle.jcajce.provider.asymmetric.", aHf);
        bouncycastleprovider._mth02CA("org.spongycastle.jcajce.provider.keystore.", aHh);
        bouncycastleprovider.put("X509Store.CERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertCollection");
        bouncycastleprovider.put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreAttrCertCollection");
        bouncycastleprovider.put("X509Store.CRL/COLLECTION", "org.spongycastle.jce.provider.X509StoreCRLCollection");
        bouncycastleprovider.put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertPairCollection");
        bouncycastleprovider.put("X509Store.CERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCerts");
        bouncycastleprovider.put("X509Store.CRL/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCRLs");
        bouncycastleprovider.put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPAttrCerts");
        bouncycastleprovider.put("X509Store.CERTIFICATEPAIR/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCertPairs");
        bouncycastleprovider.put("X509StreamParser.CERTIFICATE", "org.spongycastle.jce.provider.X509CertParser");
        bouncycastleprovider.put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.spongycastle.jce.provider.X509AttrCertParser");
        bouncycastleprovider.put("X509StreamParser.CRL", "org.spongycastle.jce.provider.X509CRLParser");
        bouncycastleprovider.put("X509StreamParser.CERTIFICATEPAIR", "org.spongycastle.jce.provider.X509CertPairParser");
        bouncycastleprovider.put("Cipher.BROKENPBEWITHMD5ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        bouncycastleprovider.put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        bouncycastleprovider.put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        bouncycastleprovider.put("CertPathValidator.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        bouncycastleprovider.put("CertPathBuilder.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        bouncycastleprovider.put("CertPathValidator.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
        bouncycastleprovider.put("CertPathBuilder.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
        bouncycastleprovider.put("CertPathValidator.PKIX", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
        bouncycastleprovider.put("CertPathBuilder.PKIX", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
        bouncycastleprovider.put("CertStore.Collection", "org.spongycastle.jce.provider.CertStoreCollectionSpi");
        bouncycastleprovider.put("CertStore.LDAP", "org.spongycastle.jce.provider.X509LDAPCertStoreSpi");
        bouncycastleprovider.put("CertStore.Multi", "org.spongycastle.jce.provider.MultiCertStoreSpi");
        bouncycastleprovider.put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }

    public static PrivateKey _mth02CF(PrivateKeyInfo privatekeyinfo)
    {
        AsymmetricKeyInfoConverter asymmetrickeyinfoconverter = (AsymmetricKeyInfoConverter)aHa.get(new ASN1ObjectIdentifier(privatekeyinfo.aaK.ahP.identifier));
        if (asymmetrickeyinfoconverter == null)
        {
            return null;
        } else
        {
            return asymmetrickeyinfoconverter._mth02CA(privatekeyinfo);
        }
    }

    public static PublicKey _mth141D(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        AsymmetricKeyInfoConverter asymmetrickeyinfoconverter = (AsymmetricKeyInfoConverter)aHa.get(new ASN1ObjectIdentifier(subjectpublickeyinfo.aaK.ahP.identifier));
        if (asymmetrickeyinfoconverter == null)
        {
            return null;
        } else
        {
            return asymmetrickeyinfoconverter._mth02CB(subjectpublickeyinfo);
        }
    }

    public final void _mth02CA(ASN1ObjectIdentifier asn1objectidentifier, AsymmetricKeyInfoConverter asymmetrickeyinfoconverter)
    {
        aHa.put(asn1objectidentifier, asymmetrickeyinfoconverter);
    }

    public final void _mth0640(String s, String s1)
    {
        if (containsKey(s))
        {
            throw new IllegalStateException((new StringBuilder("duplicate provider key (")).append(s).append(") found").toString());
        } else
        {
            put(s, s1);
            return;
        }
    }

    public final boolean _mth1427(String s, String s1)
    {
        return containsKey((new StringBuilder()).append(s).append(".").append(s1).toString()) || containsKey((new StringBuilder("Alg.Alias.")).append(s).append(".").append(s1).toString());
    }


    private class _cls1
        implements PrivilegedAction
    {

        private BouncyCastleProvider aHi;

        public Object run()
        {
            BouncyCastleProvider._mth02CA(aHi);
            return null;
        }

        _cls1()
        {
            aHi = BouncyCastleProvider.this;
            super();
        }
    }

}
