// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.keystore.pkcs12;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BEROutputStream;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DEROutputStream;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST28147Parameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.AuthenticatedSafe;
import org.spongycastle.asn1.pkcs.CertBag;
import org.spongycastle.asn1.pkcs.ContentInfo;
import org.spongycastle.asn1.pkcs.EncryptedData;
import org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.spongycastle.asn1.pkcs.EncryptionScheme;
import org.spongycastle.asn1.pkcs.KeyDerivationFunc;
import org.spongycastle.asn1.pkcs.MacData;
import org.spongycastle.asn1.pkcs.PBES2Parameters;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCS12PBEParams;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.Pfx;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.pkcs.SafeBag;
import org.spongycastle.asn1.util.ASN1Dump;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.AuthorityKeyIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.SubjectKeyIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.jcajce.provider.config.PKCS12StoreParameter;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;
import org.spongycastle.jce.interfaces.BCKeyStore;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.JDKPKCS12StoreParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class PKCS12KeyStoreSpi extends KeyStoreSpi
    implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore
{
    public static class BCPKCS12KeyStore extends PKCS12KeyStoreSpi
    {

        public BCPKCS12KeyStore()
        {
            super(PKCS12KeyStoreSpi.aFc, acQ, acT);
        }
    }

    public static class BCPKCS12KeyStore3DES extends PKCS12KeyStoreSpi
    {

        public BCPKCS12KeyStore3DES()
        {
            super(PKCS12KeyStoreSpi.aFc, acQ, acQ);
        }
    }

    class CertId
    {

        private byte aFm[];
        private PKCS12KeyStoreSpi aFn;

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof CertId))
            {
                return false;
            } else
            {
                obj = (CertId)obj;
                return Arrays._mth1427(aFm, ((CertId) (obj)).aFm);
            }
        }

        public int hashCode()
        {
            return Arrays.hashCode(aFm);
        }

        CertId(PublicKey publickey)
        {
            aFn = PKCS12KeyStoreSpi.this;
            super();
            aFm = PKCS12KeyStoreSpi._mth02CA(PKCS12KeyStoreSpi.this, publickey).ajC;
        }

        CertId(byte abyte0[])
        {
            aFn = PKCS12KeyStoreSpi.this;
            super();
            aFm = abyte0;
        }
    }

    public static class DefPKCS12KeyStore extends PKCS12KeyStoreSpi
    {

        public DefPKCS12KeyStore()
        {
            super(null, acQ, acT);
        }
    }

    public static class DefPKCS12KeyStore3DES extends PKCS12KeyStoreSpi
    {

        public DefPKCS12KeyStore3DES()
        {
            super(null, acQ, acQ);
        }
    }

    static class DefaultSecretKeyProvider
    {

        final Map aFo;

        DefaultSecretKeyProvider()
        {
            HashMap hashmap = new HashMap();
            hashmap.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.valueOf(128));
            hashmap.put(PKCSObjectIdentifiers.abw.identifier, Integers.valueOf(192));
            hashmap.put(NISTObjectIdentifiers.ZL, Integers.valueOf(128));
            hashmap.put(NISTObjectIdentifiers.ZR, Integers.valueOf(192));
            hashmap.put(NISTObjectIdentifiers.ZX, Integers.valueOf(256));
            hashmap.put(NTTObjectIdentifiers.aah, Integers.valueOf(128));
            hashmap.put(NTTObjectIdentifiers.aai, Integers.valueOf(192));
            hashmap.put(NTTObjectIdentifiers.aaj, Integers.valueOf(256));
            hashmap.put(CryptoProObjectIdentifiers.XQ, Integers.valueOf(256));
            aFo = Collections.unmodifiableMap(hashmap);
        }
    }

    static class IgnoresCaseHashtable
    {

        Hashtable aFp;
        private Hashtable aFq;

        public final Object get(String s)
        {
            Hashtable hashtable = aFq;
            if (s == null)
            {
                s = null;
            } else
            {
                s = Strings.FE91(s);
            }
            s = (String)hashtable.get(s);
            if (s == null)
            {
                return null;
            } else
            {
                return aFp.get(s);
            }
        }

        public final void put(String s, Object obj)
        {
            String s1;
            if (s == null)
            {
                s1 = null;
            } else
            {
                s1 = Strings.FE91(s);
            }
            String s2 = (String)aFq.get(s1);
            if (s2 != null)
            {
                aFp.remove(s2);
            }
            aFq.put(s1, s);
            aFp.put(s, obj);
        }

        public final Object remove(String s)
        {
            Hashtable hashtable = aFq;
            if (s == null)
            {
                s = null;
            } else
            {
                s = Strings.FE91(s);
            }
            s = (String)hashtable.remove(s);
            if (s == null)
            {
                return null;
            } else
            {
                return aFp.remove(s);
            }
        }

        private IgnoresCaseHashtable()
        {
            aFp = new Hashtable();
            aFq = new Hashtable();
        }

        IgnoresCaseHashtable(byte byte0)
        {
            this();
        }
    }


    static final BouncyCastleProvider aFc = new BouncyCastleProvider();
    private static final DefaultSecretKeyProvider aFd = new DefaultSecretKeyProvider();
    private IgnoresCaseHashtable aFe;
    private Hashtable aFf;
    private IgnoresCaseHashtable aFg;
    private Hashtable aFh;
    private Hashtable aFi;
    private CertificateFactory aFj;
    private ASN1ObjectIdentifier aFk;
    private ASN1ObjectIdentifier aFl;
    private SecureRandom amC;

    public PKCS12KeyStoreSpi(Provider provider, ASN1ObjectIdentifier asn1objectidentifier, ASN1ObjectIdentifier asn1objectidentifier1)
    {
        aFe = new IgnoresCaseHashtable((byte)0);
        aFf = new Hashtable();
        aFg = new IgnoresCaseHashtable((byte)0);
        aFh = new Hashtable();
        aFi = new Hashtable();
        amC = new SecureRandom();
        aFk = asn1objectidentifier;
        aFl = asn1objectidentifier1;
        if (provider != null)
        {
            try
            {
                aFj = CertificateFactory.getInstance("X.509", provider);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Provider provider)
            {
                throw new IllegalArgumentException((new StringBuilder("can't create cert factory - ")).append(provider.toString()).toString());
            }
        }
        aFj = CertificateFactory.getInstance("X.509");
        return;
    }

    private static SubjectKeyIdentifier _mth02BB(PublicKey publickey)
    {
        try
        {
            SubjectPublicKeyInfo subjectpublickeyinfo = new SubjectPublicKeyInfo((ASN1Sequence)ASN1Primitive._mth0640(publickey.getEncoded()));
            publickey = new SHA1Digest();
            byte abyte0[] = new byte[publickey._mth14AF()];
            byte abyte1[] = subjectpublickeyinfo.ajD.getBytes();
            publickey.update(abyte1, 0, abyte1.length);
            publickey.doFinal(abyte0, 0);
            publickey = new SubjectKeyIdentifier(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (PublicKey publickey)
        {
            throw new RuntimeException("error creating key");
        }
        return publickey;
    }

    private PrivateKey _mth02CA(AlgorithmIdentifier algorithmidentifier, byte abyte0[], char ac[], boolean flag)
    {
        Object obj = new ASN1ObjectIdentifier(algorithmidentifier.ahP.identifier);
        if (!((ASN1ObjectIdentifier) (obj))._mth02CA(PKCSObjectIdentifiers.acN))
        {
            break MISSING_BLOCK_LABEL_142;
        }
        algorithmidentifier = PKCS12PBEParams._mth02D1(algorithmidentifier.ahQ);
        ac = new PBEKeySpec(ac);
        SecretKeyFactory secretkeyfactory = SecretKeyFactory.getInstance(((ASN1ObjectIdentifier) (obj)).identifier, aFc);
        algorithmidentifier = new PBEParameterSpec(((PKCS12PBEParams) (algorithmidentifier)).Yk._mth0501(), (new BigInteger(((PKCS12PBEParams) (algorithmidentifier)).aaV.bytes)).intValue());
        ac = secretkeyfactory.generateSecret(ac);
        ((BCPBEKey)ac).aFG = flag;
        obj = Cipher.getInstance(((ASN1ObjectIdentifier) (obj)).identifier, aFc);
        ((Cipher) (obj)).init(4, ac, algorithmidentifier);
        algorithmidentifier = (PrivateKey)((Cipher) (obj)).unwrap(abyte0, "", 2);
        return algorithmidentifier;
label0:
        {
            try
            {
                if (!((ASN1ObjectIdentifier) (obj)).equals(PKCSObjectIdentifiers.abt))
                {
                    break label0;
                }
                algorithmidentifier = (PrivateKey)_mth02CA(4, ac, algorithmidentifier).unwrap(abyte0, "", 2);
            }
            // Misplaced declaration of an exception variable
            catch (AlgorithmIdentifier algorithmidentifier)
            {
                throw new IOException((new StringBuilder("exception unwrapping private key - ")).append(algorithmidentifier.toString()).toString());
            }
            return algorithmidentifier;
        }
        throw new IOException((new StringBuilder("exception unwrapping private key - cannot recognise: ")).append(obj).toString());
    }

    private static Cipher _mth02CA(int i, char ac[], AlgorithmIdentifier algorithmidentifier)
    {
        Object obj = PBES2Parameters._mth02CC(algorithmidentifier.ahQ);
        algorithmidentifier = PBKDF2Params._mth02CD(((PBES2Parameters) (obj)).aaP.aaK.ahQ);
        Object obj1 = AlgorithmIdentifier._mth01C3(((PBES2Parameters) (obj)).aaQ);
        SecretKeyFactory secretkeyfactory = SecretKeyFactory.getInstance((new ASN1ObjectIdentifier(((PBES2Parameters) (obj)).aaP.aaK.ahP.identifier)).identifier, aFc);
        boolean flag;
        if (((PBKDF2Params) (algorithmidentifier)).aaU == null || ((PBKDF2Params) (algorithmidentifier)).aaU.equals(PBKDF2Params.aaR))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            byte abyte0[] = ((PBKDF2Params) (algorithmidentifier)).aaS._mth0501();
            int l = (new BigInteger(((PBKDF2Params) (algorithmidentifier)).aaT.bytes)).intValue();
            algorithmidentifier = (Integer)aFd.aFo.get(new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj1)).ahP.identifier));
            int j;
            if (algorithmidentifier != null)
            {
                j = algorithmidentifier.intValue();
            } else
            {
                j = -1;
            }
            ac = secretkeyfactory.generateSecret(new PBEKeySpec(ac, abyte0, l, j));
        } else
        {
            byte abyte1[] = ((PBKDF2Params) (algorithmidentifier)).aaS._mth0501();
            int i1 = (new BigInteger(((PBKDF2Params) (algorithmidentifier)).aaT.bytes)).intValue();
            obj1 = (Integer)aFd.aFo.get(new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj1)).ahP.identifier));
            int k;
            if (obj1 != null)
            {
                k = ((Integer) (obj1)).intValue();
            } else
            {
                k = -1;
            }
            if (((PBKDF2Params) (algorithmidentifier)).aaU != null)
            {
                algorithmidentifier = ((PBKDF2Params) (algorithmidentifier)).aaU;
            } else
            {
                algorithmidentifier = PBKDF2Params.aaR;
            }
            ac = secretkeyfactory.generateSecret(new PBKDF2KeySpec(ac, abyte1, i1, k, algorithmidentifier));
        }
        algorithmidentifier = Cipher.getInstance((new ASN1ObjectIdentifier(((PBES2Parameters) (obj)).aaQ.aaK.ahP.identifier)).identifier);
        AlgorithmIdentifier._mth01C3(((PBES2Parameters) (obj)).aaQ);
        obj = ((PBES2Parameters) (obj)).aaQ.aaK.ahQ;
        if (obj instanceof ASN1OctetString)
        {
            algorithmidentifier.init(i, ac, new IvParameterSpec(ASN1OctetString.FB39(obj)._mth0501()));
            return algorithmidentifier;
        } else
        {
            obj = GOST28147Parameters._mth02BC(((ASN1Encodable) (obj)));
            algorithmidentifier.init(i, ac, new GOST28147ParameterSpec(((GOST28147Parameters) (obj)).Yl, ((GOST28147Parameters) (obj)).Yk._mth0501()));
            return algorithmidentifier;
        }
    }

    static SubjectKeyIdentifier _mth02CA(PKCS12KeyStoreSpi pkcs12keystorespi, PublicKey publickey)
    {
        return _mth02BB(publickey);
    }

    private void _mth02CA(OutputStream outputstream, char ac[], boolean flag)
    {
        Object obj;
        Object obj1;
        Object obj3;
        Hashtable hashtable;
        Enumeration enumeration1;
        if (ac == null)
        {
            throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
        }
        obj = new ASN1EncodableVector();
        Object obj2;
        for (Enumeration enumeration = aFe.aFp.keys(); enumeration.hasMoreElements(); ((ASN1EncodableVector) (obj)).VS.addElement(obj2))
        {
            byte abyte4[] = new byte[20];
            amC.nextBytes(abyte4);
            obj2 = (String)enumeration.nextElement();
            Object obj5 = (PrivateKey)aFe.get(((String) (obj2)));
            Object obj4 = new PKCS12PBEParams(abyte4, 1024);
            byte abyte5[] = _mth02CA(aFk.identifier, ((PrivateKey) (obj5)), ((PKCS12PBEParams) (obj4)), ac);
            obj4 = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(aFk, ((PKCS12PBEParams) (obj4))._mth0427()), abyte5);
            boolean flag1 = false;
            boolean flag4 = false;
            ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
            if (obj5 instanceof PKCS12BagAttributeCarrier)
            {
                obj5 = (PKCS12BagAttributeCarrier)obj5;
                Object obj8 = (DERBMPString)((PKCS12BagAttributeCarrier) (obj5))._mth02BC(abX);
                if (obj8 == null || !((DERBMPString) (obj8)).getString().equals(obj2))
                {
                    ((PKCS12BagAttributeCarrier) (obj5))._mth02CA(abX, new DERBMPString(((String) (obj2))));
                }
                if (((PKCS12BagAttributeCarrier) (obj5))._mth02BC(abY) == null)
                {
                    obj8 = engineGetCertificate(((String) (obj2)));
                    ((PKCS12BagAttributeCarrier) (obj5))._mth02CA(abY, _mth02BB(((Certificate) (obj8)).getPublicKey()));
                }
                obj8 = ((PKCS12BagAttributeCarrier) (obj5))._mth152C();
                flag1 = flag4;
                Object obj12;
                for (; ((Enumeration) (obj8)).hasMoreElements(); asn1encodablevector.VS.addElement(obj12))
                {
                    Object obj14 = (ASN1ObjectIdentifier)((Enumeration) (obj8)).nextElement();
                    obj12 = new ASN1EncodableVector();
                    ((ASN1EncodableVector) (obj12)).VS.addElement(obj14);
                    obj14 = new DERSet(((PKCS12BagAttributeCarrier) (obj5))._mth02BC(((ASN1ObjectIdentifier) (obj14))));
                    ((ASN1EncodableVector) (obj12)).VS.addElement(obj14);
                    flag1 = true;
                    obj12 = new DERSequence(((ASN1EncodableVector) (obj12)));
                }

            }
            if (!flag1)
            {
                Object obj6 = new ASN1EncodableVector();
                Object obj9 = engineGetCertificate(((String) (obj2)));
                ASN1ObjectIdentifier asn1objectidentifier = abY;
                ((ASN1EncodableVector) (obj6)).VS.addElement(asn1objectidentifier);
                obj9 = new DERSet(_mth02BB(((Certificate) (obj9)).getPublicKey()));
                ((ASN1EncodableVector) (obj6)).VS.addElement(obj9);
                obj6 = new DERSequence(((ASN1EncodableVector) (obj6)));
                asn1encodablevector.VS.addElement(obj6);
                obj6 = new ASN1EncodableVector();
                obj9 = abX;
                ((ASN1EncodableVector) (obj6)).VS.addElement(obj9);
                obj2 = new DERSet(new DERBMPString(((String) (obj2))));
                ((ASN1EncodableVector) (obj6)).VS.addElement(obj2);
                obj2 = new DERSequence(((ASN1EncodableVector) (obj6)));
                asn1encodablevector.VS.addElement(obj2);
            }
            obj2 = new SafeBag(acL, ((EncryptedPrivateKeyInfo) (obj4))._mth0427(), new DERSet(asn1encodablevector));
        }

        obj = new BEROctetString((new DERSequence(((ASN1EncodableVector) (obj)))).getEncoded("DER"));
        byte abyte2[] = new byte[20];
        amC.nextBytes(abyte2);
        obj1 = new ASN1EncodableVector();
        obj3 = new PKCS12PBEParams(abyte2, 1024);
        obj3 = new AlgorithmIdentifier(aFl, ((PKCS12PBEParams) (obj3))._mth0427());
        hashtable = new Hashtable();
        enumeration1 = aFe.aFp.keys();
_L5:
        if (!enumeration1.hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        Certificate certificate;
        Object obj10;
        ASN1EncodableVector asn1encodablevector2;
        Object obj15;
        Object obj17;
        Object obj20;
        Object obj23;
        Object obj25;
        boolean flag2;
        boolean flag5;
        try
        {
            obj15 = (String)enumeration1.nextElement();
            certificate = engineGetCertificate(((String) (obj15)));
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw new IOException((new StringBuilder("Error encoding certificate: ")).append(outputstream.toString()).toString());
        }
        flag2 = false;
        flag5 = false;
        obj10 = new CertBag(aca, new DEROctetString(certificate.getEncoded()));
        asn1encodablevector2 = new ASN1EncodableVector();
        if (!(certificate instanceof PKCS12BagAttributeCarrier)) goto _L2; else goto _L1
_L1:
        obj17 = (PKCS12BagAttributeCarrier)certificate;
        obj20 = (DERBMPString)((PKCS12BagAttributeCarrier) (obj17))._mth02BC(abX);
        if (obj20 == null)
        {
            break MISSING_BLOCK_LABEL_790;
        }
        if (((DERBMPString) (obj20)).getString().equals(obj15))
        {
            break MISSING_BLOCK_LABEL_809;
        }
        ((PKCS12BagAttributeCarrier) (obj17))._mth02CA(abX, new DERBMPString(((String) (obj15))));
        if (((PKCS12BagAttributeCarrier) (obj17))._mth02BC(abY) == null)
        {
            ((PKCS12BagAttributeCarrier) (obj17))._mth02CA(abY, _mth02BB(certificate.getPublicKey()));
        }
        obj20 = ((PKCS12BagAttributeCarrier) (obj17))._mth152C();
        flag2 = flag5;
_L3:
        if (!((Enumeration) (obj20)).hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        obj25 = (ASN1ObjectIdentifier)((Enumeration) (obj20)).nextElement();
        obj23 = new ASN1EncodableVector();
        ((ASN1EncodableVector) (obj23)).VS.addElement(obj25);
        obj25 = new DERSet(((PKCS12BagAttributeCarrier) (obj17))._mth02BC(((ASN1ObjectIdentifier) (obj25))));
        ((ASN1EncodableVector) (obj23)).VS.addElement(obj25);
        obj23 = new DERSequence(((ASN1EncodableVector) (obj23)));
        asn1encodablevector2.VS.addElement(obj23);
        flag2 = true;
        if (true) goto _L3; else goto _L2
_L2:
        if (flag2)
        {
            break MISSING_BLOCK_LABEL_1099;
        }
        obj17 = new ASN1EncodableVector();
        obj20 = abY;
        ((ASN1EncodableVector) (obj17)).VS.addElement(obj20);
        obj20 = new DERSet(_mth02BB(certificate.getPublicKey()));
        ((ASN1EncodableVector) (obj17)).VS.addElement(obj20);
        obj17 = new DERSequence(((ASN1EncodableVector) (obj17)));
        asn1encodablevector2.VS.addElement(obj17);
        obj17 = new ASN1EncodableVector();
        obj20 = abX;
        ((ASN1EncodableVector) (obj17)).VS.addElement(obj20);
        obj15 = new DERSet(new DERBMPString(((String) (obj15))));
        ((ASN1EncodableVector) (obj17)).VS.addElement(obj15);
        obj15 = new DERSequence(((ASN1EncodableVector) (obj17)));
        asn1encodablevector2.VS.addElement(obj15);
        obj10 = new SafeBag(acM, ((CertBag) (obj10))._mth0427(), new DERSet(asn1encodablevector2));
        ((ASN1EncodableVector) (obj1)).VS.addElement(obj10);
        hashtable.put(certificate, certificate);
        if (true) goto _L5; else goto _L4
_L4:
        enumeration1 = aFg.aFp.keys();
_L10:
        if (!enumeration1.hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        Certificate certificate1;
        Object obj11;
        ASN1EncodableVector asn1encodablevector3;
        Object obj16;
        Object obj18;
        Object obj21;
        Object obj24;
        Object obj26;
        boolean flag3;
        boolean flag6;
        try
        {
            obj16 = (String)enumeration1.nextElement();
            certificate1 = (Certificate)aFg.get(((String) (obj16)));
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw new IOException((new StringBuilder("Error encoding certificate: ")).append(outputstream.toString()).toString());
        }
        flag6 = false;
        flag3 = false;
        obj11 = aFe.get(((String) (obj16)));
        if (obj11 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj11 = new CertBag(aca, new DEROctetString(certificate1.getEncoded()));
        asn1encodablevector3 = new ASN1EncodableVector();
        if (!(certificate1 instanceof PKCS12BagAttributeCarrier)) goto _L7; else goto _L6
_L6:
        obj18 = (PKCS12BagAttributeCarrier)certificate1;
        obj21 = (DERBMPString)((PKCS12BagAttributeCarrier) (obj18))._mth02BC(abX);
        if (obj21 == null)
        {
            break MISSING_BLOCK_LABEL_1331;
        }
        if (((DERBMPString) (obj21)).getString().equals(obj16))
        {
            break MISSING_BLOCK_LABEL_1350;
        }
        ((PKCS12BagAttributeCarrier) (obj18))._mth02CA(abX, new DERBMPString(((String) (obj16))));
        obj21 = ((PKCS12BagAttributeCarrier) (obj18))._mth152C();
_L8:
        flag6 = flag3;
        if (!((Enumeration) (obj21)).hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        obj26 = (ASN1ObjectIdentifier)((Enumeration) (obj21)).nextElement();
        if (((ASN1ObjectIdentifier) (obj26)).equals(PKCSObjectIdentifiers.abY))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj24 = new ASN1EncodableVector();
        ((ASN1EncodableVector) (obj24)).VS.addElement(obj26);
        obj26 = new DERSet(((PKCS12BagAttributeCarrier) (obj18))._mth02BC(((ASN1ObjectIdentifier) (obj26))));
        ((ASN1EncodableVector) (obj24)).VS.addElement(obj26);
        obj24 = new DERSequence(((ASN1EncodableVector) (obj24)));
        asn1encodablevector3.VS.addElement(obj24);
        flag3 = true;
        if (true) goto _L8; else goto _L7
_L7:
        if (flag6)
        {
            break MISSING_BLOCK_LABEL_1548;
        }
        obj18 = new ASN1EncodableVector();
        obj21 = abX;
        ((ASN1EncodableVector) (obj18)).VS.addElement(obj21);
        obj16 = new DERSet(new DERBMPString(((String) (obj16))));
        ((ASN1EncodableVector) (obj18)).VS.addElement(obj16);
        obj16 = new DERSequence(((ASN1EncodableVector) (obj18)));
        asn1encodablevector3.VS.addElement(obj16);
        obj11 = new SafeBag(acM, ((CertBag) (obj11))._mth0427(), new DERSet(asn1encodablevector3));
        ((ASN1EncodableVector) (obj1)).VS.addElement(obj11);
        hashtable.put(certificate1, certificate1);
        if (true) goto _L10; else goto _L9
_L9:
        enumeration1 = aFh.keys();
_L12:
        if (!enumeration1.hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj7;
        ASN1EncodableVector asn1encodablevector1;
        Object obj13;
        Enumeration enumeration2;
        Object obj19;
        Object obj22;
        try
        {
            obj7 = (CertId)enumeration1.nextElement();
            obj13 = (Certificate)aFh.get(obj7);
            obj7 = hashtable.get(obj13);
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw new IOException((new StringBuilder("Error encoding certificate: ")).append(outputstream.toString()).toString());
        }
        if (obj7 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj7 = new CertBag(aca, new DEROctetString(((Certificate) (obj13)).getEncoded()));
        asn1encodablevector1 = new ASN1EncodableVector();
        if (obj13 instanceof PKCS12BagAttributeCarrier)
        {
            obj13 = (PKCS12BagAttributeCarrier)obj13;
            enumeration2 = ((PKCS12BagAttributeCarrier) (obj13))._mth152C();
            do
            {
                if (!enumeration2.hasMoreElements())
                {
                    break;
                }
                obj22 = (ASN1ObjectIdentifier)enumeration2.nextElement();
                if (!((ASN1ObjectIdentifier) (obj22)).equals(PKCSObjectIdentifiers.abY))
                {
                    obj19 = new ASN1EncodableVector();
                    ((ASN1EncodableVector) (obj19)).VS.addElement(obj22);
                    obj22 = new DERSet(((PKCS12BagAttributeCarrier) (obj13))._mth02BC(((ASN1ObjectIdentifier) (obj22))));
                    ((ASN1EncodableVector) (obj19)).VS.addElement(obj22);
                    obj19 = new DERSequence(((ASN1EncodableVector) (obj19)));
                    asn1encodablevector1.VS.addElement(obj19);
                }
            } while (true);
        }
        obj7 = new SafeBag(acM, ((CertBag) (obj7))._mth0427(), new DERSet(asn1encodablevector1));
        ((ASN1EncodableVector) (obj1)).VS.addElement(obj7);
        if (true) goto _L12; else goto _L11
_L11:
        byte abyte1[] = _mth02CA(true, ((AlgorithmIdentifier) (obj3)), ac, false, (new DERSequence(((ASN1EncodableVector) (obj1)))).getEncoded("DER"));
        abyte1 = new EncryptedData(abI, ((AlgorithmIdentifier) (obj3)), new BEROctetString(abyte1));
        abyte1 = new AuthenticatedSafe(new ContentInfo[] {
            new ContentInfo(abI, ((org.spongycastle.asn1.ASN1Object) (obj))), new ContentInfo(abN, abyte1._mth0427())
        });
        obj3 = new ByteArrayOutputStream();
        if (flag)
        {
            obj = new DEROutputStream(((OutputStream) (obj3)));
        } else
        {
            obj = new BEROutputStream(((OutputStream) (obj3)));
        }
        if (abyte1 != null)
        {
            abyte1._mth0427()._mth0582()._mth02CA(((org.spongycastle.asn1.ASN1OutputStream) (obj)));
        } else
        {
            throw new IOException("null object detected");
        }
        byte abyte0[] = ((ByteArrayOutputStream) (obj3)).toByteArray();
        abyte0 = new ContentInfo(abI, new BEROctetString(abyte0));
        abyte1 = new byte[20];
        amC.nextBytes(abyte1);
        byte abyte3[] = ((ASN1OctetString)((ContentInfo) (abyte0)).aaH)._mth0501();
        try
        {
            ac = _mth02CA(akD, abyte1, 1024, ac, false, abyte3);
            ac = new MacData(new DigestInfo(new AlgorithmIdentifier(akD, DERNull.WL), ac), abyte1, 1024);
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw new IOException((new StringBuilder("error constructing MAC: ")).append(outputstream.toString()).toString());
        }
        ac = new Pfx(abyte0, ac);
        if (flag)
        {
            outputstream = new DEROutputStream(outputstream);
        } else
        {
            outputstream = new BEROutputStream(outputstream);
        }
        if (ac != null)
        {
            ac._mth0427()._mth0582()._mth02CA(outputstream);
            return;
        } else
        {
            throw new IOException("null object detected");
        }
    }

    private static byte[] _mth02CA(String s, PrivateKey privatekey, PKCS12PBEParams pkcs12pbeparams, char ac[])
    {
        ac = new PBEKeySpec(ac);
        try
        {
            SecretKeyFactory secretkeyfactory = SecretKeyFactory.getInstance(s, aFc);
            pkcs12pbeparams = new PBEParameterSpec(pkcs12pbeparams.Yk._mth0501(), (new BigInteger(pkcs12pbeparams.aaV.bytes)).intValue());
            s = Cipher.getInstance(s, aFc);
            s.init(3, secretkeyfactory.generateSecret(ac), pkcs12pbeparams);
            s = s.wrap(privatekey);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IOException((new StringBuilder("exception encrypting data - ")).append(s.toString()).toString());
        }
        return s;
    }

    private static byte[] _mth02CA(ASN1ObjectIdentifier asn1objectidentifier, byte abyte0[], int i, char ac[], boolean flag, byte abyte1[])
    {
        SecretKeyFactory secretkeyfactory = SecretKeyFactory.getInstance(asn1objectidentifier.identifier, aFc);
        abyte0 = new PBEParameterSpec(abyte0, i);
        ac = (BCPBEKey)secretkeyfactory.generateSecret(new PBEKeySpec(ac));
        ac.aFG = flag;
        asn1objectidentifier = Mac.getInstance(asn1objectidentifier.identifier, aFc);
        asn1objectidentifier.init(ac, abyte0);
        asn1objectidentifier.update(abyte1);
        return asn1objectidentifier.doFinal();
    }

    private byte[] _mth02CA(boolean flag, AlgorithmIdentifier algorithmidentifier, char ac[], boolean flag1, byte abyte0[])
    {
        Object obj = new ASN1ObjectIdentifier(algorithmidentifier.ahP.identifier);
        byte byte0;
        if (flag)
        {
            byte0 = 1;
        } else
        {
            byte0 = 2;
        }
        if (((ASN1ObjectIdentifier) (obj))._mth02CA(PKCSObjectIdentifiers.acN))
        {
            algorithmidentifier = PKCS12PBEParams._mth02D1(algorithmidentifier.ahQ);
            ac = new PBEKeySpec(ac);
            try
            {
                SecretKeyFactory secretkeyfactory = SecretKeyFactory.getInstance(((ASN1ObjectIdentifier) (obj)).identifier, aFc);
                algorithmidentifier = new PBEParameterSpec(((PKCS12PBEParams) (algorithmidentifier)).Yk._mth0501(), (new BigInteger(((PKCS12PBEParams) (algorithmidentifier)).aaV.bytes)).intValue());
                ac = (BCPBEKey)secretkeyfactory.generateSecret(ac);
                ac.aFG = flag1;
                obj = Cipher.getInstance(((ASN1ObjectIdentifier) (obj)).identifier, aFc);
                ((Cipher) (obj)).init(byte0, ac, algorithmidentifier);
                algorithmidentifier = ((Cipher) (obj)).doFinal(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch (AlgorithmIdentifier algorithmidentifier)
            {
                throw new IOException((new StringBuilder("exception decrypting data - ")).append(algorithmidentifier.toString()).toString());
            }
            return algorithmidentifier;
        }
        if (((ASN1ObjectIdentifier) (obj)).equals(PKCSObjectIdentifiers.abt))
        {
            try
            {
                algorithmidentifier = _mth02CA(byte0, ac, algorithmidentifier).doFinal(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch (AlgorithmIdentifier algorithmidentifier)
            {
                throw new IOException((new StringBuilder("exception decrypting data - ")).append(algorithmidentifier.toString()).toString());
            }
            return algorithmidentifier;
        } else
        {
            throw new IOException((new StringBuilder("unknown PBE algorithm: ")).append(obj).toString());
        }
    }

    public Enumeration engineAliases()
    {
        Hashtable hashtable = new Hashtable();
        for (Enumeration enumeration = aFg.aFp.keys(); enumeration.hasMoreElements(); hashtable.put(enumeration.nextElement(), "cert")) { }
        Enumeration enumeration1 = aFe.aFp.keys();
        do
        {
            if (!enumeration1.hasMoreElements())
            {
                break;
            }
            String s = (String)enumeration1.nextElement();
            if (hashtable.get(s) == null)
            {
                hashtable.put(s, "key");
            }
        } while (true);
        return hashtable.keys();
    }

    public boolean engineContainsAlias(String s)
    {
        return aFg.get(s) != null || aFe.get(s) != null;
    }

    public void engineDeleteEntry(String s)
    {
        Key key = (Key)aFe.remove(s);
        Certificate certificate = (Certificate)aFg.remove(s);
        if (certificate != null)
        {
            aFh.remove(new CertId(certificate.getPublicKey()));
        }
        if (key != null)
        {
            String s1 = (String)aFf.remove(s);
            s = certificate;
            if (s1 != null)
            {
                s = (Certificate)aFi.remove(s1);
            }
            if (s != null)
            {
                aFh.remove(new CertId(s.getPublicKey()));
            }
        }
    }

    public Certificate engineGetCertificate(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("null alias passed to getCertificate.");
        }
        Certificate certificate = (Certificate)aFg.get(s);
        Object obj = certificate;
        if (certificate == null)
        {
            obj = (String)aFf.get(s);
            if (obj != null)
            {
                return (Certificate)aFi.get(obj);
            }
            obj = (Certificate)aFi.get(s);
        }
        return ((Certificate) (obj));
    }

    public String engineGetCertificateAlias(Certificate certificate)
    {
        Enumeration enumeration = aFg.aFp.elements();
        Enumeration enumeration1 = aFg.aFp.keys();
        while (enumeration.hasMoreElements()) 
        {
            Certificate certificate1 = (Certificate)enumeration.nextElement();
            String s = (String)enumeration1.nextElement();
            if (certificate1.equals(certificate))
            {
                return s;
            }
        }
        enumeration = aFi.elements();
        enumeration1 = aFi.keys();
        while (enumeration.hasMoreElements()) 
        {
            Certificate certificate2 = (Certificate)enumeration.nextElement();
            String s1 = (String)enumeration1.nextElement();
            if (certificate2.equals(certificate))
            {
                return s1;
            }
        }
        return null;
    }

    public Certificate[] engineGetCertificateChain(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("null alias passed to getCertificateChain.");
        }
        if (!engineIsKeyEntry(s))
        {
            return null;
        }
        s = engineGetCertificate(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        Vector vector = new Vector();
_L16:
        if (s == null) goto _L4; else goto _L3
_L3:
        Object obj;
        byte abyte0[];
        Principal principal;
        X509Certificate x509certificate;
        x509certificate = (X509Certificate)s;
        obj = null;
        principal = null;
        abyte0 = x509certificate.getExtensionValue(Extension.aiQ.identifier);
        if (abyte0 == null) goto _L6; else goto _L5
_L5:
        Object obj2 = AuthorityKeyIdentifier._mth037A((new ASN1InputStream(((ASN1OctetString)(new ASN1InputStream(abyte0))._mth04B7())._mth0501()))._mth04B7());
        if (((AuthorityKeyIdentifier) (obj2)).aij == null) goto _L8; else goto _L7
_L7:
        Object obj1 = ((AuthorityKeyIdentifier) (obj2)).aij._mth0501();
_L17:
        obj = principal;
        if (obj1 == null) goto _L6; else goto _L9
_L9:
        obj1 = aFh;
        if (((AuthorityKeyIdentifier) (obj2)).aij == null)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        obj = ((AuthorityKeyIdentifier) (obj2)).aij._mth0501();
_L18:
        try
        {
            obj = (Certificate)((Hashtable) (obj1)).get(new CertId(((byte []) (obj))));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.toString());
        }
_L6:
        obj1 = obj;
        if (obj != null) goto _L11; else goto _L10
_L10:
        principal = x509certificate.getIssuerDN();
        obj1 = obj;
        if (principal.equals(x509certificate.getSubjectDN())) goto _L11; else goto _L12
_L12:
        obj2 = aFh.keys();
_L15:
        obj1 = obj;
        if (!((Enumeration) (obj2)).hasMoreElements()) goto _L11; else goto _L13
_L13:
        obj1 = (X509Certificate)aFh.get(((Enumeration) (obj2)).nextElement());
        if (!((X509Certificate) (obj1)).getSubjectDN().equals(principal)) goto _L15; else goto _L14
_L14:
        x509certificate.verify(((X509Certificate) (obj1)).getPublicKey());
_L11:
        vector.addElement(s);
        if (obj1 != s)
        {
            s = ((String) (obj1));
        } else
        {
            s = null;
        }
          goto _L16
_L4:
        s = new Certificate[vector.size()];
        for (int i = 0; i != s.length; i++)
        {
            s[i] = (Certificate)vector.elementAt(i);
        }

        return s;
_L2:
        return null;
        obj1;
          goto _L15
_L8:
        obj1 = null;
          goto _L17
        obj = null;
          goto _L18
    }

    public Date engineGetCreationDate(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("alias == null");
        }
        if (aFe.get(s) == null && aFg.get(s) == null)
        {
            return null;
        } else
        {
            return new Date();
        }
    }

    public Key engineGetKey(String s, char ac[])
    {
        if (s == null)
        {
            throw new IllegalArgumentException("null alias passed to getKey.");
        } else
        {
            return (Key)aFe.get(s);
        }
    }

    public boolean engineIsCertificateEntry(String s)
    {
        return aFg.get(s) != null && aFe.get(s) == null;
    }

    public boolean engineIsKeyEntry(String s)
    {
        return aFe.get(s) != null;
    }

    public void engineLoad(InputStream inputstream, char ac[])
    {
        Vector vector;
        boolean flag;
        int l;
        boolean flag1;
        if (inputstream == null)
        {
            return;
        }
        if (ac == null)
        {
            throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
        }
        inputstream = new BufferedInputStream(inputstream);
        inputstream.mark(10);
        if (inputstream.read() != 48)
        {
            throw new IOException("stream does not represent a PKCS12 key store");
        }
        inputstream.reset();
        Object obj = Pfx._mth02CE((ASN1Sequence)(new ASN1InputStream(inputstream))._mth04B7());
        inputstream = ((Pfx) (obj)).acW;
        vector = new Vector();
        l = 0;
        flag = false;
        flag1 = false;
        boolean flag2 = false;
        if (((Pfx) (obj)).acX == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        MacData macdata = ((Pfx) (obj)).acX;
        DigestInfo digestinfo = macdata.aaM;
        obj = digestinfo.aaK;
        byte abyte0[] = macdata.aaN;
        int j = macdata.aaO.intValue();
        byte abyte2[] = ((ASN1OctetString)((ContentInfo) (inputstream)).aaH)._mth0501();
        byte abyte1[];
        byte abyte3[];
        try
        {
            abyte3 = _mth02CA(new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj)).ahP.identifier), abyte0, j, ac, false, abyte2);
            abyte1 = digestinfo.aiy;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IOException((new StringBuilder("error constructing MAC: ")).append(inputstream.toString()).toString());
        }
        flag1 = flag2;
        if (Arrays._mth1428(abyte3, abyte1))
        {
            break MISSING_BLOCK_LABEL_304;
        }
        if (ac.length > 0)
        {
            throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
        }
        if (!Arrays._mth1428(_mth02CA(new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj)).ahP.identifier), abyte0, j, ac, true, abyte2), abyte1))
        {
            throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
        }
        flag1 = true;
        aFe = new IgnoresCaseHashtable((byte)0);
        aFf = new Hashtable();
        if (((ContentInfo) (inputstream)).aaG.equals(abI))
        {
            ContentInfo acontentinfo[] = AuthenticatedSafe._mth141D((new ASN1InputStream(((ASN1OctetString)((ContentInfo) (inputstream)).aaH)._mth0501()))._mth04B7()).aaz;
            int k = 0;
            do
            {
                l = ((flag) ? 1 : 0);
                if (k == acontentinfo.length)
                {
                    break;
                }
                if (acontentinfo[k].aaG.equals(abI))
                {
                    ASN1Sequence asn1sequence = (ASN1Sequence)(new ASN1InputStream(((ASN1OctetString)acontentinfo[k].aaH)._mth0501()))._mth04B7();
                    for (l = 0; l != asn1sequence.size(); l++)
                    {
                        Object obj11 = SafeBag._mth0640(asn1sequence._mth144B(l));
                        if (((SafeBag) (obj11)).adv.equals(acL))
                        {
                            inputstream = EncryptedPrivateKeyInfo._mth02C8(((SafeBag) (obj11)).adw);
                            PrivateKey privatekey1 = _mth02CA(((EncryptedPrivateKeyInfo) (inputstream)).aaK, ((EncryptedPrivateKeyInfo) (inputstream)).aaL._mth0501(), ac, flag1);
                            PKCS12BagAttributeCarrier pkcs12bagattributecarrier1 = (PKCS12BagAttributeCarrier)privatekey1;
                            Object obj4 = null;
                            inputstream = null;
                            Object obj7 = null;
                            ASN1OctetString asn1octetstring = null;
                            if (((SafeBag) (obj11)).adx != null)
                            {
                                obj11 = ((SafeBag) (obj11)).adx.Wf.elements();
                                do
                                {
                                    obj4 = inputstream;
                                    obj7 = asn1octetstring;
                                    if (!((Enumeration) (obj11)).hasMoreElements())
                                    {
                                        break;
                                    }
                                    obj4 = (ASN1Sequence)((Enumeration) (obj11)).nextElement();
                                    ASN1ObjectIdentifier asn1objectidentifier1 = (ASN1ObjectIdentifier)((ASN1Sequence) (obj4))._mth144B(0);
                                    obj7 = (ASN1Set)((ASN1Sequence) (obj4))._mth144B(1);
                                    obj4 = null;
                                    if (((ASN1Set) (obj7)).Wf.size() > 0)
                                    {
                                        obj7 = (ASN1Primitive)(ASN1Encodable)((ASN1Set) (obj7)).Wf.elementAt(0);
                                        ASN1Encodable asn1encodable1 = pkcs12bagattributecarrier1._mth02BC(asn1objectidentifier1);
                                        if (asn1encodable1 != null)
                                        {
                                            obj4 = obj7;
                                            if (!asn1encodable1._mth0427().equals(obj7))
                                            {
                                                throw new IOException("attempt to add existing attribute with different value");
                                            }
                                        } else
                                        {
                                            pkcs12bagattributecarrier1._mth02CA(asn1objectidentifier1, ((ASN1Encodable) (obj7)));
                                            obj4 = obj7;
                                        }
                                    }
                                    if (asn1objectidentifier1.equals(abX))
                                    {
                                        inputstream = ((DERBMPString)obj4).getString();
                                        aFe.put(inputstream, privatekey1);
                                    } else
                                    if (asn1objectidentifier1.equals(abY))
                                    {
                                        asn1octetstring = (ASN1OctetString)obj4;
                                    }
                                } while (true);
                            }
                            if (obj7 != null)
                            {
                                inputstream = new String(Hex._mth1D65(((ASN1OctetString) (obj7))._mth0501()));
                                if (obj4 == null)
                                {
                                    aFe.put(inputstream, privatekey1);
                                } else
                                {
                                    aFf.put(obj4, inputstream);
                                }
                            } else
                            {
                                flag = true;
                                aFe.put("unmarked", privatekey1);
                            }
                        } else
                        if (((SafeBag) (obj11)).adv.equals(acM))
                        {
                            vector.addElement(obj11);
                        } else
                        {
                            System.out.println((new StringBuilder("extra in data ")).append(((SafeBag) (obj11)).adv).toString());
                            System.out.println(ASN1Dump.FF9E(((ASN1Encodable) (obj11))));
                        }
                    }

                } else
                if (acontentinfo[k].aaG.equals(abN))
                {
                    inputstream = EncryptedData._mth02BF(acontentinfo[k].aaH);
                    AlgorithmIdentifier algorithmidentifier = AlgorithmIdentifier._mth01C3(((EncryptedData) (inputstream)).aaJ._mth144B(1));
                    if (((EncryptedData) (inputstream)).aaJ.size() == 3)
                    {
                        inputstream = ASN1OctetString._mth02CF(ASN1TaggedObject._mth142A(((EncryptedData) (inputstream)).aaJ._mth144B(2)), false);
                    } else
                    {
                        inputstream = null;
                    }
                    ASN1Sequence asn1sequence1 = (ASN1Sequence)ASN1Primitive._mth0640(_mth02CA(false, algorithmidentifier, ac, flag1, inputstream._mth0501()));
                    for (l = 0; l != asn1sequence1.size(); l++)
                    {
                        Object obj5 = SafeBag._mth0640(asn1sequence1._mth144B(l));
                        if (((SafeBag) (obj5)).adv.equals(acM))
                        {
                            vector.addElement(obj5);
                        } else
                        if (((SafeBag) (obj5)).adv.equals(acL))
                        {
                            inputstream = EncryptedPrivateKeyInfo._mth02C8(((SafeBag) (obj5)).adw);
                            PrivateKey privatekey2 = _mth02CA(((EncryptedPrivateKeyInfo) (inputstream)).aaK, ((EncryptedPrivateKeyInfo) (inputstream)).aaL._mth0501(), ac, flag1);
                            PKCS12BagAttributeCarrier pkcs12bagattributecarrier2 = (PKCS12BagAttributeCarrier)privatekey2;
                            inputstream = null;
                            Object obj1 = null;
                            Enumeration enumeration1 = ((SafeBag) (obj5)).adx.Wf.elements();
                            do
                            {
                                if (!enumeration1.hasMoreElements())
                                {
                                    break;
                                }
                                obj5 = (ASN1Sequence)enumeration1.nextElement();
                                ASN1ObjectIdentifier asn1objectidentifier2 = (ASN1ObjectIdentifier)((ASN1Sequence) (obj5))._mth144B(0);
                                Object obj8 = (ASN1Set)((ASN1Sequence) (obj5))._mth144B(1);
                                obj5 = null;
                                if (((ASN1Set) (obj8)).Wf.size() > 0)
                                {
                                    obj8 = (ASN1Primitive)(ASN1Encodable)((ASN1Set) (obj8)).Wf.elementAt(0);
                                    ASN1Encodable asn1encodable2 = pkcs12bagattributecarrier2._mth02BC(asn1objectidentifier2);
                                    if (asn1encodable2 != null)
                                    {
                                        obj5 = obj8;
                                        if (!asn1encodable2._mth0427().equals(obj8))
                                        {
                                            throw new IOException("attempt to add existing attribute with different value");
                                        }
                                    } else
                                    {
                                        pkcs12bagattributecarrier2._mth02CA(asn1objectidentifier2, ((ASN1Encodable) (obj8)));
                                        obj5 = obj8;
                                    }
                                }
                                if (asn1objectidentifier2.equals(abX))
                                {
                                    inputstream = ((DERBMPString)obj5).getString();
                                    aFe.put(inputstream, privatekey2);
                                } else
                                if (asn1objectidentifier2.equals(abY))
                                {
                                    obj1 = (ASN1OctetString)obj5;
                                }
                            } while (true);
                            obj1 = new String(Hex._mth1D65(((ASN1OctetString) (obj1))._mth0501()));
                            if (inputstream == null)
                            {
                                aFe.put(((String) (obj1)), privatekey2);
                            } else
                            {
                                aFf.put(inputstream, obj1);
                            }
                        } else
                        if (((SafeBag) (obj5)).adv.equals(acK))
                        {
                            PrivateKey privatekey = BouncyCastleProvider._mth02CF(PrivateKeyInfo._mth1D38(((SafeBag) (obj5)).adw));
                            PKCS12BagAttributeCarrier pkcs12bagattributecarrier = (PKCS12BagAttributeCarrier)privatekey;
                            inputstream = null;
                            Object obj2 = null;
                            Enumeration enumeration = ((SafeBag) (obj5)).adx.Wf.elements();
                            do
                            {
                                if (!enumeration.hasMoreElements())
                                {
                                    break;
                                }
                                obj5 = ASN1Sequence._mth141F(enumeration.nextElement());
                                ASN1ObjectIdentifier asn1objectidentifier = ASN1ObjectIdentifier._mth02CE(((ASN1Sequence) (obj5))._mth144B(0));
                                Object obj12 = ASN1Set._mth1421(((ASN1Sequence) (obj5))._mth144B(1));
                                obj5 = obj2;
                                if (((ASN1Set) (obj12)).Wf.size() > 0)
                                {
                                    obj12 = (ASN1Primitive)(ASN1Encodable)((ASN1Set) (obj12)).Wf.elementAt(0);
                                    obj5 = pkcs12bagattributecarrier._mth02BC(asn1objectidentifier);
                                    if (obj5 != null)
                                    {
                                        if (!((ASN1Encodable) (obj5))._mth0427().equals(obj12))
                                        {
                                            throw new IOException("attempt to add existing attribute with different value");
                                        }
                                    } else
                                    {
                                        pkcs12bagattributecarrier._mth02CA(asn1objectidentifier, ((ASN1Encodable) (obj12)));
                                    }
                                    if (asn1objectidentifier.equals(abX))
                                    {
                                        inputstream = ((DERBMPString)obj12).getString();
                                        aFe.put(inputstream, privatekey);
                                        continue;
                                    }
                                    obj5 = obj2;
                                    if (asn1objectidentifier.equals(abY))
                                    {
                                        obj5 = (ASN1OctetString)obj12;
                                    }
                                }
                                obj2 = obj5;
                            } while (true);
                            obj2 = new String(Hex._mth1D65(((ASN1OctetString) (obj2))._mth0501()));
                            if (inputstream == null)
                            {
                                aFe.put(((String) (obj2)), privatekey);
                            } else
                            {
                                aFf.put(inputstream, obj2);
                            }
                        } else
                        {
                            System.out.println((new StringBuilder("extra in encryptedData ")).append(((SafeBag) (obj5)).adv).toString());
                            System.out.println(ASN1Dump.FF9E(((ASN1Encodable) (obj5))));
                        }
                    }

                } else
                {
                    System.out.println((new StringBuilder("extra ")).append(acontentinfo[k].aaG.identifier).toString());
                    System.out.println((new StringBuilder("extra ")).append(ASN1Dump.FF9E(acontentinfo[k].aaH)).toString());
                }
                k++;
            } while (true);
        }
        aFg = new IgnoresCaseHashtable((byte)0);
        aFh = new Hashtable();
        aFi = new Hashtable();
        for (int i = 0; i != vector.size(); i++)
        {
            Object obj9 = (SafeBag)vector.elementAt(i);
            inputstream = CertBag._mth02BE(((SafeBag) (obj9)).adw);
            if (!((CertBag) (inputstream)).aaB.equals(aca))
            {
                throw new RuntimeException((new StringBuilder("Unsupported certificate type: ")).append(((CertBag) (inputstream)).aaB).toString());
            }
            Certificate certificate;
            try
            {
                inputstream = new ByteArrayInputStream(((ASN1OctetString)((CertBag) (inputstream)).aaC)._mth0501());
                certificate = aFj.generateCertificate(inputstream);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw new RuntimeException(inputstream.toString());
            }
            Object obj3 = null;
            ac = null;
            Object obj6 = null;
            inputstream = null;
            if (((SafeBag) (obj9)).adx != null)
            {
                obj9 = ((SafeBag) (obj9)).adx.Wf.elements();
                do
                {
                    obj3 = ac;
                    obj6 = inputstream;
                    if (!((Enumeration) (obj9)).hasMoreElements())
                    {
                        break;
                    }
                    obj3 = ASN1Sequence._mth141F(((Enumeration) (obj9)).nextElement());
                    obj6 = ASN1ObjectIdentifier._mth02CE(((ASN1Sequence) (obj3))._mth144B(0));
                    Object obj10 = ASN1Set._mth1421(((ASN1Sequence) (obj3))._mth144B(1));
                    obj3 = ac;
                    if (((ASN1Set) (obj10)).Wf.size() > 0)
                    {
                        obj10 = (ASN1Primitive)(ASN1Encodable)((ASN1Set) (obj10)).Wf.elementAt(0);
                        if (certificate instanceof PKCS12BagAttributeCarrier)
                        {
                            obj3 = (PKCS12BagAttributeCarrier)certificate;
                            ASN1Encodable asn1encodable = ((PKCS12BagAttributeCarrier) (obj3))._mth02BC(((ASN1ObjectIdentifier) (obj6)));
                            if (asn1encodable != null)
                            {
                                if (!asn1encodable._mth0427().equals(obj10))
                                {
                                    throw new IOException("attempt to add existing attribute with different value");
                                }
                            } else
                            {
                                ((PKCS12BagAttributeCarrier) (obj3))._mth02CA(((ASN1ObjectIdentifier) (obj6)), ((ASN1Encodable) (obj10)));
                            }
                        }
                        if (((ASN1ObjectIdentifier) (obj6)).equals(abX))
                        {
                            inputstream = ((DERBMPString)obj10).getString();
                            continue;
                        }
                        obj3 = ac;
                        if (((ASN1ObjectIdentifier) (obj6)).equals(abY))
                        {
                            obj3 = (ASN1OctetString)obj10;
                        }
                    }
                    ac = ((char []) (obj3));
                } while (true);
            }
            aFh.put(new CertId(certificate.getPublicKey()), certificate);
            if (l != 0)
            {
                if (aFi.isEmpty())
                {
                    inputstream = new String(Hex._mth1D65(_mth02BB(certificate.getPublicKey()).ajC));
                    aFi.put(inputstream, certificate);
                    aFe.put(inputstream, aFe.remove("unmarked"));
                }
                continue;
            }
            if (obj3 != null)
            {
                inputstream = new String(Hex._mth1D65(((ASN1OctetString) (obj3))._mth0501()));
                aFi.put(inputstream, certificate);
            }
            if (obj6 != null)
            {
                aFg.put(((String) (obj6)), certificate);
            }
        }

        return;
    }

    public void engineSetCertificateEntry(String s, Certificate certificate)
    {
        if (aFe.get(s) != null)
        {
            throw new KeyStoreException((new StringBuilder("There is a key entry with the name ")).append(s).append(".").toString());
        } else
        {
            aFg.put(s, certificate);
            aFh.put(new CertId(certificate.getPublicKey()), certificate);
            return;
        }
    }

    public void engineSetKeyEntry(String s, Key key, char ac[], Certificate acertificate[])
    {
        if (!(key instanceof PrivateKey))
        {
            throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
        }
        if ((key instanceof PrivateKey) && acertificate == null)
        {
            throw new KeyStoreException("no certificate chain for private key");
        }
        if (aFe.get(s) != null)
        {
            engineDeleteEntry(s);
        }
        aFe.put(s, key);
        if (acertificate != null)
        {
            aFg.put(s, acertificate[0]);
            for (int i = 0; i != acertificate.length; i++)
            {
                aFh.put(new CertId(acertificate[i].getPublicKey()), acertificate[i]);
            }

        }
    }

    public void engineSetKeyEntry(String s, byte abyte0[], Certificate acertificate[])
    {
        throw new RuntimeException("operation not supported");
    }

    public int engineSize()
    {
        Hashtable hashtable = new Hashtable();
        for (Enumeration enumeration = aFg.aFp.keys(); enumeration.hasMoreElements(); hashtable.put(enumeration.nextElement(), "cert")) { }
        Enumeration enumeration1 = aFe.aFp.keys();
        do
        {
            if (!enumeration1.hasMoreElements())
            {
                break;
            }
            String s = (String)enumeration1.nextElement();
            if (hashtable.get(s) == null)
            {
                hashtable.put(s, "key");
            }
        } while (true);
        return hashtable.size();
    }

    public void engineStore(OutputStream outputstream, char ac[])
    {
        _mth02CA(outputstream, ac, false);
    }

    public void engineStore(java.security.KeyStore.LoadStoreParameter loadstoreparameter)
    {
        if (loadstoreparameter == null)
        {
            throw new IllegalArgumentException("'param' arg cannot be null");
        }
        if (!(loadstoreparameter instanceof PKCS12StoreParameter) && !(loadstoreparameter instanceof JDKPKCS12StoreParameter))
        {
            throw new IllegalArgumentException((new StringBuilder("No support for 'param' of type ")).append(loadstoreparameter.getClass().getName()).toString());
        }
        Object obj;
        if (loadstoreparameter instanceof PKCS12StoreParameter)
        {
            obj = (PKCS12StoreParameter)loadstoreparameter;
        } else
        {
            obj = (JDKPKCS12StoreParameter)loadstoreparameter;
            obj = loadstoreparameter.getProtectionParameter();
            JDKPKCS12StoreParameter jdkpkcs12storeparameter = (JDKPKCS12StoreParameter)loadstoreparameter;
            obj = new PKCS12StoreParameter(null, ((java.security.KeyStore.ProtectionParameter) (obj)), false);
        }
        loadstoreparameter = loadstoreparameter.getProtectionParameter();
        if (loadstoreparameter == null)
        {
            loadstoreparameter = null;
        } else
        if (loadstoreparameter instanceof java.security.KeyStore.PasswordProtection)
        {
            loadstoreparameter = ((java.security.KeyStore.PasswordProtection)loadstoreparameter).getPassword();
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("No support for protection parameter of type ")).append(loadstoreparameter.getClass().getName()).toString());
        }
        _mth02CA(((PKCS12StoreParameter) (obj)).out, loadstoreparameter, ((PKCS12StoreParameter) (obj)).aEV);
    }

}
