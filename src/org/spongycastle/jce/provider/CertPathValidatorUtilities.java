// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.StoreException;
import org.spongycastle.x509.AttributeCertificateIssuer;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509CRLStoreSelector;
import org.spongycastle.x509.X509CertStoreSelector;
import org.spongycastle.x509.X509Store;
import org.spongycastle.x509.X509StoreSpi;

// Referenced classes of package org.spongycastle.jce.provider:
//            PKIXCRLUtil, AnnotatedException, RFC3280CertPathUtilities, PKIXPolicyNode, 
//            X509CRLObject, CertStatus

public class CertPathValidatorUtilities
{

    private static PKIXCRLUtil aHq = new PKIXCRLUtil();
    private static String aHr;
    private static String aHs;

    public CertPathValidatorUtilities()
    {
    }

    protected static X500Principal _mth02BC(X509Certificate x509certificate)
    {
        return x509certificate.getSubjectX500Principal();
    }

    protected static AlgorithmIdentifier _mth02BC(PublicKey publickey)
    {
        try
        {
            publickey = SubjectPublicKeyInfo._mth13A5((new ASN1InputStream(publickey.getEncoded()))._mth04B7()).aaK;
        }
        // Misplaced declaration of an exception variable
        catch (PublicKey publickey)
        {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", publickey);
        }
        return publickey;
    }

    protected static final HashSet _mth02BD(ASN1Sequence asn1sequence)
    {
        HashSet hashset = new HashSet();
        if (asn1sequence == null)
        {
            return hashset;
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ASN1OutputStream asn1outputstream = new ASN1OutputStream(bytearrayoutputstream);
        for (asn1sequence = asn1sequence._mth0675(); asn1sequence.hasMoreElements(); bytearrayoutputstream.reset())
        {
            try
            {
                asn1outputstream._mth02CF((ASN1Encodable)asn1sequence.nextElement());
                hashset.add(new PolicyQualifierInfo(bytearrayoutputstream.toByteArray()));
            }
            // Misplaced declaration of an exception variable
            catch (ASN1Sequence asn1sequence)
            {
                throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", asn1sequence);
            }
        }

        return hashset;
    }

    protected static boolean _mth02BD(X509Certificate x509certificate)
    {
        return x509certificate.getSubjectDN().equals(x509certificate.getIssuerDN());
    }

    protected static PublicKey _mth02CA(List list, int i)
    {
        Object obj = ((Certificate)list.get(i)).getPublicKey();
        if (!(obj instanceof DSAPublicKey))
        {
            return ((PublicKey) (obj));
        }
        obj = (DSAPublicKey)obj;
        if (((DSAPublicKey) (obj)).getParams() != null)
        {
            return ((PublicKey) (obj));
        }
        for (i++; i < list.size(); i++)
        {
            Object obj1 = ((X509Certificate)list.get(i)).getPublicKey();
            if (!(obj1 instanceof DSAPublicKey))
            {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
            obj1 = (DSAPublicKey)obj1;
            if (((DSAPublicKey) (obj1)).getParams() != null)
            {
                list = ((DSAPublicKey) (obj1)).getParams();
                list = new DSAPublicKeySpec(((DSAPublicKey) (obj)).getY(), list.getP(), list.getQ(), list.getG());
                try
                {
                    list = KeyFactory.getInstance("DSA", "SC").generatePublic(list);
                }
                // Misplaced declaration of an exception variable
                catch (List list)
                {
                    throw new RuntimeException(list.getMessage());
                }
                return list;
            }
        }

        throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
    }

    protected static TrustAnchor _mth02CA(X509Certificate x509certificate, Set set, String s)
    {
        PublicKey publickey;
        Set set1;
        Exception exception;
        X509CertSelector x509certselector;
        X500Principal x500principal;
        Iterator iterator;
        set1 = null;
        publickey = null;
        exception = null;
        x509certselector = new X509CertSelector();
        x500principal = _mth1D53(x509certificate);
        try
        {
            x509certselector.setSubject(x500principal.getEncoded());
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            throw new AnnotatedException("Cannot set subject search criteria for trust anchor.", x509certificate);
        }
        iterator = set.iterator();
_L11:
        if (!iterator.hasNext() || set1 != null) goto _L2; else goto _L1
_L1:
        set = (TrustAnchor)iterator.next();
        if (set.getTrustedCert() == null) goto _L4; else goto _L3
_L3:
        PublicKey publickey1;
        if (x509certselector.match(set.getTrustedCert()))
        {
            publickey1 = set.getTrustedCert().getPublicKey();
        } else
        {
            set = null;
            publickey1 = publickey;
        }
          goto _L5
_L4:
        if (set.getCAName() == null || set.getCAPublicKey() == null) goto _L7; else goto _L6
_L6:
        if (!x500principal.equals(new X500Principal(set.getCAName()))) goto _L9; else goto _L8
_L8:
        publickey1 = set.getCAPublicKey();
          goto _L5
_L9:
        set = null;
        publickey1 = publickey;
          goto _L5
_L7:
        set = null;
        publickey1 = publickey;
_L5:
        set1 = set;
        publickey = publickey1;
        if (publickey1 == null) goto _L11; else goto _L10
_L10:
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        x509certificate.verify(publickey1);
        set1 = set;
        publickey = publickey1;
          goto _L11
        x509certificate.verify(publickey1, s);
        set1 = set;
        publickey = publickey1;
          goto _L11
        exception;
        set1 = null;
        publickey = null;
          goto _L11
_L2:
        if (set1 == null && exception != null)
        {
            throw new AnnotatedException("TrustAnchor found but certificate validation failed.", exception);
        } else
        {
            return set1;
        }
        set;
          goto _L7
    }

    protected static Date _mth02CA(ExtendedPKIXParameters extendedpkixparameters)
    {
        Date date = extendedpkixparameters.getDate();
        extendedpkixparameters = date;
        if (date == null)
        {
            extendedpkixparameters = new Date();
        }
        return extendedpkixparameters;
    }

    protected static Date _mth02CA(ExtendedPKIXParameters extendedpkixparameters, CertPath certpath, int i)
    {
        if (extendedpkixparameters.aPR != 1)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        if (i <= 0)
        {
            certpath = extendedpkixparameters.getDate();
            extendedpkixparameters = certpath;
            if (certpath == null)
            {
                extendedpkixparameters = new Date();
            }
            return extendedpkixparameters;
        }
        if (i - 1 != 0)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        extendedpkixparameters = null;
        byte abyte0[];
        try
        {
            abyte0 = ((X509Certificate)certpath.getCertificates().get(i - 1)).getExtensionValue(ISISMTTObjectIdentifiers.Zn.identifier);
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXParameters extendedpkixparameters)
        {
            throw new AnnotatedException("Date of cert gen extension could not be read.");
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXParameters extendedpkixparameters)
        {
            throw new AnnotatedException("Date of cert gen extension could not be read.");
        }
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        extendedpkixparameters = ASN1GeneralizedTime._mth02CB(ASN1Primitive._mth0640(abyte0));
        if (extendedpkixparameters != null)
        {
            try
            {
                extendedpkixparameters = extendedpkixparameters.getDate();
            }
            // Misplaced declaration of an exception variable
            catch (ExtendedPKIXParameters extendedpkixparameters)
            {
                throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", extendedpkixparameters);
            }
            return extendedpkixparameters;
        } else
        {
            return ((X509Certificate)certpath.getCertificates().get(i - 1)).getNotBefore();
        }
        return ((X509Certificate)certpath.getCertificates().get(i - 1)).getNotBefore();
        certpath = extendedpkixparameters.getDate();
        extendedpkixparameters = certpath;
        if (certpath == null)
        {
            extendedpkixparameters = new Date();
        }
        return extendedpkixparameters;
    }

    protected static HashSet _mth02CA(Date date, ExtendedPKIXParameters extendedpkixparameters, X509CRL x509crl)
    {
        BigInteger biginteger;
        X509CRLStoreSelector x509crlstoreselector;
        x509crlstoreselector = new X509CRLStoreSelector();
        try
        {
            x509crlstoreselector.addIssuerName(x509crl.getIssuerX500Principal().getEncoded());
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            throw new AnnotatedException("Cannot extract issuer from CRL.", date);
        }
        biginteger = null;
        Object obj;
        byte abyte1[];
        try
        {
            obj = aHs;
            abyte1 = x509crl.getExtensionValue(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            throw new AnnotatedException("CRL number extension could not be extracted from CRL.", date);
        }
        if (abyte1 == null)
        {
            obj = null;
            break MISSING_BLOCK_LABEL_74;
        }
        obj = _mth02CB(((String) (obj)), abyte1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        biginteger = new BigInteger(1, ASN1Integer.FB1D(obj).bytes);
        byte abyte0[];
        try
        {
            abyte0 = x509crl.getExtensionValue(aHr);
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            throw new AnnotatedException("Issuing distribution point extension value could not be read.", date);
        }
        if (biginteger == null)
        {
            x509crl = null;
        } else
        {
            x509crl = biginteger.add(BigInteger.valueOf(1L));
        }
        x509crlstoreselector.setMinCRLNumber(x509crl);
        x509crlstoreselector.aQe = Arrays._mth1D4C(abyte0);
        x509crlstoreselector.aQf = true;
        x509crlstoreselector.aQd = biginteger;
        extendedpkixparameters = aHq._mth02CA(x509crlstoreselector, extendedpkixparameters, date);
        date = new HashSet();
        extendedpkixparameters = extendedpkixparameters.iterator();
        do
        {
            if (!extendedpkixparameters.hasNext())
            {
                break;
            }
            x509crl = (X509CRL)extendedpkixparameters.next();
            Set set = x509crl.getCriticalExtensionOIDs();
            boolean flag;
            if (set == null)
            {
                flag = false;
            } else
            {
                flag = set.contains(RFC3280CertPathUtilities.aHQ);
            }
            if (flag)
            {
                date.add(x509crl);
            }
        } while (true);
        return date;
    }

    protected static HashSet _mth02CA(X509AttributeCertStoreSelector x509attributecertstoreselector, List list)
    {
        HashSet hashset = new HashSet();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = list.next();
            if (obj instanceof X509Store)
            {
                obj = (X509Store)obj;
                try
                {
                    hashset.addAll(((X509Store) (obj)).aQo._mth02CA(x509attributecertstoreselector));
                }
                // Misplaced declaration of an exception variable
                catch (X509AttributeCertStoreSelector x509attributecertstoreselector)
                {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", x509attributecertstoreselector);
                }
            }
        } while (true);
        return hashset;
    }

    protected static HashSet _mth02CA(X509CertStoreSelector x509certstoreselector, List list)
    {
        HashSet hashset = new HashSet();
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = list.next();
            if (obj instanceof X509Store)
            {
                obj = (X509Store)obj;
                try
                {
                    hashset.addAll(((X509Store) (obj)).aQo._mth02CA(x509certstoreselector));
                }
                // Misplaced declaration of an exception variable
                catch (X509CertStoreSelector x509certstoreselector)
                {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", x509certstoreselector);
                }
            } else
            {
                obj = (CertStore)obj;
                try
                {
                    hashset.addAll(((CertStore) (obj)).getCertificates(x509certstoreselector));
                }
                // Misplaced declaration of an exception variable
                catch (X509CertStoreSelector x509certstoreselector)
                {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", x509certstoreselector);
                }
            }
        }

        return hashset;
    }

    protected static Set _mth02CA(DistributionPoint distributionpoint, X509Extension x509extension, Date date, ExtendedPKIXParameters extendedpkixparameters)
    {
        X509CRLStoreSelector x509crlstoreselector;
        {
            x509crlstoreselector = new X509CRLStoreSelector();
            HashSet hashset;
            try
            {
                hashset = new HashSet();
                if (x509extension instanceof X509AttributeCertificate)
                {
                    hashset.add(((X509AttributeCertificate)x509extension)._mth1FE8().getPrincipals()[0]);
                    break MISSING_BLOCK_LABEL_62;
                }
            }
            // Misplaced declaration of an exception variable
            catch (DistributionPoint distributionpoint)
            {
                throw new AnnotatedException("Could not get issuer information from distribution point.", distributionpoint);
            }
        }
        hashset.add(_mth1D53(x509extension));
        _mth02CA(distributionpoint, hashset, x509crlstoreselector);
        break MISSING_BLOCK_LABEL_86;
        if (x509extension instanceof X509Certificate)
        {
            x509crlstoreselector.setCertificateChecking((X509Certificate)x509extension);
        } else
        if (x509extension instanceof X509AttributeCertificate)
        {
            x509crlstoreselector.aQg = (X509AttributeCertificate)x509extension;
        }
        x509crlstoreselector.aQc = true;
        distributionpoint = aHq._mth02CA(x509crlstoreselector, extendedpkixparameters, date);
        if (distributionpoint.isEmpty())
        {
            if (x509extension instanceof X509AttributeCertificate)
            {
                distributionpoint = (X509AttributeCertificate)x509extension;
                throw new AnnotatedException((new StringBuilder("No CRLs found for issuer \"")).append(distributionpoint._mth1FE8().getPrincipals()[0]).append("\"").toString());
            } else
            {
                distributionpoint = (X509Certificate)x509extension;
                throw new AnnotatedException((new StringBuilder("No CRLs found for issuer \"")).append(distributionpoint.getIssuerX500Principal()).append("\"").toString());
            }
        } else
        {
            return distributionpoint;
        }
    }

    protected static X500Principal _mth02CA(X509CRL x509crl)
    {
        return x509crl.getIssuerX500Principal();
    }

    protected static ASN1Primitive _mth02CA(X509Extension x509extension, String s)
    {
        x509extension = x509extension.getExtensionValue(s);
        if (x509extension == null)
        {
            return null;
        } else
        {
            return _mth02CB(s, x509extension);
        }
    }

    protected static PKIXPolicyNode _mth02CA(PKIXPolicyNode pkixpolicynode, List alist[], PKIXPolicyNode pkixpolicynode1)
    {
        PKIXPolicyNode pkixpolicynode2 = (PKIXPolicyNode)pkixpolicynode1.getParent();
        if (pkixpolicynode == null)
        {
            return null;
        }
        if (pkixpolicynode2 == null)
        {
            for (int i = 0; i < alist.length; i++)
            {
                alist[i] = new ArrayList();
            }

            return null;
        } else
        {
            pkixpolicynode2._mth02CB(pkixpolicynode1);
            _mth02CA(alist, pkixpolicynode1);
            return pkixpolicynode;
        }
    }

    private static void _mth02CA(String s, ExtendedPKIXParameters extendedpkixparameters)
    {
        if (!extendedpkixparameters.aPL)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        Object obj;
        try
        {
            if (!s.startsWith("ldap://"))
            {
                break MISSING_BLOCK_LABEL_212;
            }
            obj = s.substring(7);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("Exception adding X.509 stores.");
        }
        s = null;
        if (((String) (obj)).indexOf("/") != -1)
        {
            s = ((String) (obj)).substring(((String) (obj)).indexOf("/"));
            obj = (new StringBuilder("ldap://")).append(((String) (obj)).substring(0, ((String) (obj)).indexOf("/"))).toString();
            break MISSING_BLOCK_LABEL_99;
        }
        obj = (new StringBuilder("ldap://")).append(((String) (obj))).toString();
        s = (new org.spongycastle.jce.X509LDAPCertStoreParameters.Builder(((String) (obj)), s))._mth1D18();
        obj = X509Store._mth02CA("CERTIFICATE/LDAP", s, "SC");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        extendedpkixparameters.aPM.add(obj);
        obj = X509Store._mth02CA("CRL/LDAP", s, "SC");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        extendedpkixparameters.aPM.add(obj);
        obj = X509Store._mth02CA("ATTRIBUTECERTIFICATE/LDAP", s, "SC");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        extendedpkixparameters.aPM.add(obj);
        s = X509Store._mth02CA("CERTIFICATEPAIR/LDAP", s, "SC");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        extendedpkixparameters.aPM.add(s);
        return;
    }

    protected static void _mth02CA(X509Certificate x509certificate, PublicKey publickey, String s)
    {
        if (s == null)
        {
            x509certificate.verify(publickey);
            return;
        } else
        {
            x509certificate.verify(publickey, s);
            return;
        }
    }

    protected static void _mth02CA(X509Certificate x509certificate, ExtendedPKIXBuilderParameters extendedpkixbuilderparameters)
    {
        if (x509certificate.getIssuerAlternativeNames() != null)
        {
            x509certificate = x509certificate.getIssuerAlternativeNames().iterator();
            do
            {
                if (!x509certificate.hasNext())
                {
                    break;
                }
                List list = (List)x509certificate.next();
                if (list.get(0).equals(Integers.valueOf(6)))
                {
                    _mth02CA((String)list.get(1), ((ExtendedPKIXParameters) (extendedpkixbuilderparameters)));
                }
            } while (true);
        }
    }

    protected static void _mth02CA(Date date, X509CRL x509crl, Object obj, CertStatus certstatus)
    {
        boolean flag;
        try
        {
            flag = X509CRLObject._mth02CB(x509crl);
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            throw new AnnotatedException("Failed check for indirect CRL.", date);
        }
        if (flag)
        {
            Object obj1;
            if (obj instanceof X509Certificate)
            {
                obj1 = ((X509Certificate)obj).getSerialNumber();
            } else
            {
                obj1 = ((X509AttributeCertificate)obj).getSerialNumber();
            }
            X509CRLEntry x509crlentry = x509crl.getRevokedCertificate(((BigInteger) (obj1)));
            if (x509crlentry == null)
            {
                return;
            }
            X500Principal x500principal = x509crlentry.getCertificateIssuer();
            obj1 = x500principal;
            if (x500principal == null)
            {
                obj1 = x509crl.getIssuerX500Principal();
            }
            if (!_mth1D53(obj).equals(obj1))
            {
                return;
            }
            x509crl = x509crlentry;
        } else
        {
            if (!_mth1D53(obj).equals(x509crl.getIssuerX500Principal()))
            {
                return;
            }
            if (obj instanceof X509Certificate)
            {
                obj = ((X509Certificate)obj).getSerialNumber();
            } else
            {
                obj = ((X509AttributeCertificate)obj).getSerialNumber();
            }
            obj = x509crl.getRevokedCertificate(((BigInteger) (obj)));
            x509crl = ((X509CRL) (obj));
            if (obj == null)
            {
                return;
            }
        }
        obj = null;
        if (!x509crl.hasExtensions())
        {
            break MISSING_BLOCK_LABEL_231;
        }
        byte abyte0[];
        try
        {
            obj = org.spongycastle.asn1.x509.X509Extension.aiI.identifier;
            abyte0 = x509crl.getExtensionValue(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", date);
        }
        if (abyte0 == null)
        {
            obj = null;
            break MISSING_BLOCK_LABEL_210;
        }
        obj = _mth02CB(((String) (obj)), abyte0);
        obj = ASN1Enumerated._mth1D63(obj);
        if (date.getTime() >= x509crl.getRevocationDate().getTime() || obj == null || (new BigInteger(((ASN1Enumerated) (obj)).bytes)).intValue() == 0 || (new BigInteger(((ASN1Enumerated) (obj)).bytes)).intValue() == 1 || (new BigInteger(((ASN1Enumerated) (obj)).bytes)).intValue() == 2 || (new BigInteger(((ASN1Enumerated) (obj)).bytes)).intValue() == 8)
        {
            if (obj != null)
            {
                certstatus.aHt = (new BigInteger(((ASN1Enumerated) (obj)).bytes)).intValue();
            } else
            {
                certstatus.aHt = 0;
            }
            certstatus.aHu = x509crl.getRevocationDate();
        }
        return;
    }

    protected static void _mth02CA(CRLDistPoint crldistpoint, ExtendedPKIXParameters extendedpkixparameters)
    {
        if (crldistpoint != null)
        {
            try
            {
                crldistpoint = crldistpoint._mth09BD();
            }
            // Misplaced declaration of an exception variable
            catch (CRLDistPoint crldistpoint)
            {
                throw new AnnotatedException("Distribution points could not be read.", crldistpoint);
            }
            for (int i = 0; i < crldistpoint.length; i++)
            {
                Object obj = ((DistributionPoint) (crldistpoint[i])).aiz;
                if (obj == null || ((DistributionPointName) (obj)).type != 0)
                {
                    continue;
                }
                obj = GeneralNames._mth05D5(((DistributionPointName) (obj)).aiC);
                GeneralName ageneralname[] = new GeneralName[((GeneralNames) (obj)).ajb.length];
                System.arraycopy(((GeneralNames) (obj)).ajb, 0, ageneralname, 0, ((GeneralNames) (obj)).ajb.length);
                for (int j = 0; j < ageneralname.length; j++)
                {
                    if (ageneralname[j].tag == 6)
                    {
                        _mth02CA(DERIA5String._mth02BB(ageneralname[j].Wn).getString(), extendedpkixparameters);
                    }
                }

            }

        }
    }

    private static void _mth02CA(DistributionPoint distributionpoint, HashSet hashset, X509CRLStoreSelector x509crlstoreselector)
    {
        ArrayList arraylist = new ArrayList();
        if (distributionpoint.aiB != null)
        {
            distributionpoint = distributionpoint.aiB;
            hashset = new GeneralName[((GeneralNames) (distributionpoint)).ajb.length];
            System.arraycopy(((GeneralNames) (distributionpoint)).ajb, 0, hashset, 0, ((GeneralNames) (distributionpoint)).ajb.length);
            for (int i = 0; i < hashset.length; i++)
            {
                if (((GeneralName) (hashset[i])).tag == 4)
                {
                    try
                    {
                        arraylist.add(new X500Principal(((GeneralName) (hashset[i])).Wn._mth0427().getEncoded()));
                    }
                    // Misplaced declaration of an exception variable
                    catch (DistributionPoint distributionpoint)
                    {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", distributionpoint);
                    }
                }
            }

        } else
        {
            if (distributionpoint.aiz == null)
            {
                throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.");
            }
            for (distributionpoint = hashset.iterator(); distributionpoint.hasNext(); arraylist.add((X500Principal)distributionpoint.next())) { }
        }
        for (distributionpoint = arraylist.iterator(); distributionpoint.hasNext();)
        {
            try
            {
                x509crlstoreselector.addIssuerName(((X500Principal)distributionpoint.next()).getEncoded());
            }
            // Misplaced declaration of an exception variable
            catch (DistributionPoint distributionpoint)
            {
                throw new AnnotatedException("Cannot decode CRL issuer information.", distributionpoint);
            }
        }

    }

    private static void _mth02CA(List alist[], PKIXPolicyNode pkixpolicynode)
    {
        alist[pkixpolicynode.getDepth()].remove(pkixpolicynode);
        if (pkixpolicynode.hasChildren())
        {
            for (pkixpolicynode = pkixpolicynode.getChildren(); pkixpolicynode.hasNext(); _mth02CA(alist, (PKIXPolicyNode)pkixpolicynode.next())) { }
        }
    }

    protected static boolean _mth02CA(int i, List alist[], ASN1ObjectIdentifier asn1objectidentifier, Set set)
    {
        List list = alist[i - 1];
        for (int j = 0; j < list.size(); j++)
        {
            PKIXPolicyNode pkixpolicynode = (PKIXPolicyNode)list.get(j);
            if (pkixpolicynode.getExpectedPolicies().contains(asn1objectidentifier.identifier))
            {
                HashSet hashset = new HashSet();
                hashset.add(asn1objectidentifier.identifier);
                asn1objectidentifier = new PKIXPolicyNode(new ArrayList(), i, hashset, pkixpolicynode, set, asn1objectidentifier.identifier, false);
                pkixpolicynode._mth02CA(asn1objectidentifier);
                alist[i].add(asn1objectidentifier);
                return true;
            }
        }

        return false;
    }

    protected static HashSet _mth02CB(X509Certificate x509certificate, ExtendedPKIXBuilderParameters extendedpkixbuilderparameters)
    {
        X509CertStoreSelector x509certstoreselector = new X509CertStoreSelector();
        HashSet hashset = new HashSet();
        try
        {
            x509certstoreselector.setSubject(x509certificate.getIssuerX500Principal().getEncoded());
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate could not be set.", x509certificate);
        }
        try
        {
            x509certificate = new ArrayList();
            x509certificate.addAll(_mth02CA(x509certstoreselector, extendedpkixbuilderparameters.getCertStores()));
            x509certificate.addAll(_mth02CA(x509certstoreselector, Collections.unmodifiableList(new ArrayList(((ExtendedPKIXParameters) (extendedpkixbuilderparameters)).aPJ))));
            x509certificate.addAll(_mth02CA(x509certstoreselector, Collections.unmodifiableList(((ExtendedPKIXParameters) (extendedpkixbuilderparameters)).aPM)));
            x509certificate = x509certificate.iterator();
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            throw new AnnotatedException("Issuer certificate cannot be searched.", x509certificate);
        }
        for (; x509certificate.hasNext(); hashset.add((X509Certificate)x509certificate.next())) { }
        return hashset;
    }

    private static ASN1Primitive _mth02CB(String s, byte abyte0[])
    {
        try
        {
            abyte0 = (new ASN1InputStream(((ASN1OctetString)(new ASN1InputStream(abyte0))._mth04B7())._mth0501()))._mth04B7();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AnnotatedException((new StringBuilder("exception processing extension ")).append(s).toString(), abyte0);
        }
        return abyte0;
    }

    protected static void _mth02CB(int i, List alist[], ASN1ObjectIdentifier asn1objectidentifier, Set set)
    {
        List list = alist[i - 1];
        for (int j = 0; j < list.size(); j++)
        {
            PKIXPolicyNode pkixpolicynode = (PKIXPolicyNode)list.get(j);
            if ("2.5.29.32.0".equals(pkixpolicynode.getValidPolicy()))
            {
                HashSet hashset = new HashSet();
                hashset.add(asn1objectidentifier.identifier);
                asn1objectidentifier = new PKIXPolicyNode(new ArrayList(), i, hashset, pkixpolicynode, set, asn1objectidentifier.identifier, false);
                pkixpolicynode._mth02CA(asn1objectidentifier);
                alist[i].add(asn1objectidentifier);
                return;
            }
        }

    }

    protected static boolean _mth02CF(Set set)
    {
        return set == null || set.contains("2.5.29.32.0") || set.isEmpty();
    }

    protected static X500Principal _mth1D53(Object obj)
    {
        if (obj instanceof X509Certificate)
        {
            return ((X509Certificate)obj).getIssuerX500Principal();
        } else
        {
            return (X500Principal)((X509AttributeCertificate)obj)._mth1FE8().getPrincipals()[0];
        }
    }

    static 
    {
        ASN1ObjectIdentifier asn1objectidentifier = Extension.aiO;
        asn1objectidentifier = Extension.aiG;
        asn1objectidentifier = Extension.aiP;
        asn1objectidentifier = Extension.aiE;
        asn1objectidentifier = Extension.aiM;
        asn1objectidentifier = Extension.aiD;
        asn1objectidentifier = Extension.aiU;
        aHr = Extension.aiK.identifier;
        asn1objectidentifier = Extension.aiJ;
        asn1objectidentifier = Extension.aiR;
        asn1objectidentifier = Extension.aiT;
        asn1objectidentifier = Extension.aiN;
        asn1objectidentifier = Extension.aiQ;
        aHs = Extension.aiH.identifier;
    }
}
