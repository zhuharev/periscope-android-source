// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.TargetInformation;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.AttributeCertificateHolder;
import org.spongycastle.x509.AttributeCertificateIssuer;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509CertStoreSelector;

// Referenced classes of package org.spongycastle.jce.provider:
//            AnnotatedException, CertPathValidatorUtilities, CertStatus, ReasonsMask, 
//            RFC3280CertPathUtilities

class RFC3281CertPathUtilities
{

    private static final String aHT;
    private static final String aHZ;
    private static final String aIa;
    private static final String aIb;

    RFC3281CertPathUtilities()
    {
    }

    protected static CertPathValidatorResult _mth02CA(CertPath certpath, ExtendedPKIXParameters extendedpkixparameters)
    {
        CertPathValidator certpathvalidator;
        try
        {
            certpathvalidator = CertPathValidator.getInstance("PKIX", "SC");
        }
        // Misplaced declaration of an exception variable
        catch (CertPath certpath)
        {
            throw new ExtCertPathValidatorException("Support class could not be created.", certpath);
        }
        // Misplaced declaration of an exception variable
        catch (CertPath certpath)
        {
            throw new ExtCertPathValidatorException("Support class could not be created.", certpath);
        }
        try
        {
            certpath = certpathvalidator.validate(certpath, extendedpkixparameters);
        }
        // Misplaced declaration of an exception variable
        catch (CertPath certpath)
        {
            throw new ExtCertPathValidatorException("Certification path for issuer certificate of attribute certificate could not be validated.", certpath);
        }
        // Misplaced declaration of an exception variable
        catch (CertPath certpath)
        {
            throw new RuntimeException(certpath.getMessage());
        }
        return certpath;
    }

    protected static void _mth02CA(X509Certificate x509certificate, ExtendedPKIXParameters extendedpkixparameters)
    {
        extendedpkixparameters = Collections.unmodifiableSet(extendedpkixparameters.aPN);
        boolean flag = false;
        extendedpkixparameters = extendedpkixparameters.iterator();
        do
        {
            if (!extendedpkixparameters.hasNext())
            {
                break;
            }
            TrustAnchor trustanchor = (TrustAnchor)extendedpkixparameters.next();
            if (x509certificate.getSubjectX500Principal().getName("RFC2253").equals(trustanchor.getCAName()) || x509certificate.equals(trustanchor.getTrustedCert()))
            {
                flag = true;
            }
        } while (true);
        if (!flag)
        {
            throw new CertPathValidatorException("Attribute certificate issuer is not directly trusted.");
        } else
        {
            return;
        }
    }

    private static void _mth02CA(DistributionPoint distributionpoint, X509AttributeCertificate x509attributecertificate, ExtendedPKIXParameters extendedpkixparameters, Date date, CertStatus certstatus, ReasonsMask reasonsmask, List list)
    {
        AnnotatedException annotatedexception;
        Date date1;
        Iterator iterator;
        boolean flag;
        if (x509attributecertificate.getExtensionValue(X509Extensions.akt.identifier) != null)
        {
            return;
        }
        date1 = new Date(System.currentTimeMillis());
        if (date.getTime() > date1.getTime())
        {
            throw new AnnotatedException("Validation time is in future.");
        }
        Set set = CertPathValidatorUtilities._mth02CA(distributionpoint, x509attributecertificate, date1, extendedpkixparameters);
        flag = false;
        annotatedexception = null;
        iterator = set.iterator();
_L2:
        if (!iterator.hasNext() || certstatus.aHt != 11)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag1;
        if (reasonsmask.aIc == ReasonsMask.aId.aIc)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        X509CRL x509crl1;
        ReasonsMask reasonsmask1;
        int i;
        int j;
        int k;
        x509crl1 = (X509CRL)iterator.next();
        reasonsmask1 = RFC3280CertPathUtilities._mth02CA(x509crl1, distributionpoint);
        i = reasonsmask1.aIc;
        j = reasonsmask.aIc;
        k = reasonsmask1.aIc;
        boolean flag2;
        if ((i | j ^ k) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag2)
        {
            continue; /* Loop/switch isn't completed */
        }
        java.security.PublicKey publickey = RFC3280CertPathUtilities._mth02CA(x509crl1, RFC3280CertPathUtilities._mth02CA(x509crl1, null, null, extendedpkixparameters, list));
        X509CRL x509crl = null;
        if (extendedpkixparameters.aPS)
        {
            x509crl = RFC3280CertPathUtilities._mth02CA(CertPathValidatorUtilities._mth02CA(date1, extendedpkixparameters, x509crl1), publickey);
        }
        if (extendedpkixparameters.aPR != 1 && x509attributecertificate.getNotAfter().getTime() < x509crl1.getThisUpdate().getTime())
        {
            throw new AnnotatedException("No valid CRL for current time found.");
        }
        RFC3280CertPathUtilities._mth02CB(distributionpoint, x509attributecertificate, x509crl1);
        RFC3280CertPathUtilities._mth02CA(distributionpoint, x509attributecertificate, x509crl1);
        RFC3280CertPathUtilities._mth02CA(x509crl, x509crl1, extendedpkixparameters);
        RFC3280CertPathUtilities._mth02CA(date, x509crl, x509attributecertificate, certstatus, extendedpkixparameters);
        RFC3280CertPathUtilities._mth02CA(date, x509crl1, x509attributecertificate, certstatus);
        if (certstatus.aHt == 8)
        {
            certstatus.aHt = 11;
        }
        reasonsmask.aIc = reasonsmask.aIc | reasonsmask1.aIc;
        flag = true;
        continue; /* Loop/switch isn't completed */
        annotatedexception;
        if (true) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            throw annotatedexception;
        } else
        {
            return;
        }
    }

    protected static void _mth02CA(X509AttributeCertificate x509attributecertificate, CertPath certpath, CertPath certpath1, ExtendedPKIXParameters extendedpkixparameters)
    {
        certpath = x509attributecertificate.getCriticalExtensionOIDs();
        if (certpath.contains(aHZ))
        {
            try
            {
                TargetInformation._mth02C9(CertPathValidatorUtilities._mth02CA(x509attributecertificate, aHZ));
            }
            // Misplaced declaration of an exception variable
            catch (X509AttributeCertificate x509attributecertificate)
            {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", x509attributecertificate);
            }
            // Misplaced declaration of an exception variable
            catch (X509AttributeCertificate x509attributecertificate)
            {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", x509attributecertificate);
            }
        }
        certpath.remove(aHZ);
        for (x509attributecertificate = Collections.unmodifiableSet(extendedpkixparameters.aPQ).iterator(); x509attributecertificate.hasNext(); x509attributecertificate.next()) { }
        if (!certpath.isEmpty())
        {
            throw new CertPathValidatorException((new StringBuilder("Attribute certificate contains unsupported critical extensions: ")).append(certpath).toString());
        } else
        {
            return;
        }
    }

    protected static void _mth02CA(X509AttributeCertificate x509attributecertificate, ExtendedPKIXParameters extendedpkixparameters)
    {
        for (Iterator iterator = Collections.unmodifiableSet(extendedpkixparameters.aPP).iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            if (x509attributecertificate._mth02BA(s1) != null)
            {
                throw new CertPathValidatorException((new StringBuilder("Attribute certificate contains prohibited attribute: ")).append(s1).append(".").toString());
            }
        }

        for (extendedpkixparameters = Collections.unmodifiableSet(extendedpkixparameters.aPO).iterator(); extendedpkixparameters.hasNext();)
        {
            String s = (String)extendedpkixparameters.next();
            if (x509attributecertificate._mth02BA(s) == null)
            {
                throw new CertPathValidatorException((new StringBuilder("Attribute certificate does not contain necessary attribute: ")).append(s).append(".").toString());
            }
        }

    }

    protected static void _mth02CA(X509AttributeCertificate x509attributecertificate, ExtendedPKIXParameters extendedpkixparameters, X509Certificate x509certificate, Date date, List list)
    {
        Object obj;
        CertStatus certstatus;
        ReasonsMask reasonsmask;
        boolean flag;
        int i;
        if (!extendedpkixparameters.isRevocationEnabled())
        {
            break MISSING_BLOCK_LABEL_600;
        }
        if (x509attributecertificate.getExtensionValue(aIa) != null)
        {
            break MISSING_BLOCK_LABEL_565;
        }
        CRLDistPoint crldistpoint;
        try
        {
            crldistpoint = CRLDistPoint._mth02BE(CertPathValidatorUtilities._mth02CA(x509attributecertificate, aHT));
        }
        // Misplaced declaration of an exception variable
        catch (X509AttributeCertificate x509attributecertificate)
        {
            throw new CertPathValidatorException("CRL distribution point extension could not be read.", x509attributecertificate);
        }
        try
        {
            CertPathValidatorUtilities._mth02CA(crldistpoint, extendedpkixparameters);
        }
        // Misplaced declaration of an exception variable
        catch (X509AttributeCertificate x509attributecertificate)
        {
            throw new CertPathValidatorException("No additional CRL locations could be decoded from CRL distribution point extension.", x509attributecertificate);
        }
        certstatus = new CertStatus();
        reasonsmask = new ReasonsMask();
        obj = null;
        flag = false;
        boolean flag2 = false;
        x509certificate = ((X509Certificate) (obj));
        if (crldistpoint == null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        try
        {
            x509certificate = crldistpoint._mth09BD();
        }
        // Misplaced declaration of an exception variable
        catch (X509AttributeCertificate x509attributecertificate)
        {
            throw new ExtCertPathValidatorException("Distribution points could not be read.", x509attributecertificate);
        }
        i = 0;
        flag = flag2;
_L2:
        if (i >= x509certificate.length || certstatus.aHt != 11)
        {
            break; /* Loop/switch isn't completed */
        }
        ExtendedPKIXParameters extendedpkixparameters1;
        boolean flag1;
        boolean flag3;
        if (reasonsmask.aIc == ReasonsMask.aId.aIc)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag3)
        {
            break; /* Loop/switch isn't completed */
        }
        extendedpkixparameters1 = (ExtendedPKIXParameters)extendedpkixparameters.clone();
        _mth02CA(x509certificate[i], x509attributecertificate, extendedpkixparameters1, date, certstatus, reasonsmask, list);
        flag = true;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        x509certificate = ((X509Certificate) (obj));
        break MISSING_BLOCK_LABEL_232;
        x509certificate;
        x509certificate = new AnnotatedException("No valid CRL for distribution point found.", x509certificate);
        obj = x509certificate;
        flag3 = flag;
        if (certstatus.aHt != 11)
        {
            break MISSING_BLOCK_LABEL_408;
        }
        if (reasonsmask.aIc == ReasonsMask.aId.aIc)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj = x509certificate;
        flag3 = flag;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_408;
        }
        obj = (new ASN1InputStream(((X500Principal)x509attributecertificate._mth1FE8().getPrincipals()[0]).getEncoded()))._mth04B7();
        break MISSING_BLOCK_LABEL_329;
        x509attributecertificate;
        throw new AnnotatedException("Issuer from certificate for CRL could not be reencoded.", x509attributecertificate);
        _mth02CA(new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, ((org.spongycastle.asn1.ASN1Object) (obj))))), null, null), x509attributecertificate, (ExtendedPKIXParameters)extendedpkixparameters.clone(), date, certstatus, reasonsmask, list);
        flag3 = true;
        obj = x509certificate;
        break MISSING_BLOCK_LABEL_408;
        x509attributecertificate;
        obj = new AnnotatedException("No valid CRL for distribution point found.", x509attributecertificate);
        flag3 = flag;
        if (!flag3)
        {
            throw new ExtCertPathValidatorException("No valid CRL found.", ((Exception) (obj)));
        }
        if (certstatus.aHt != 11)
        {
            x509attributecertificate = (new StringBuilder("Attribute certificate revocation after ")).append(certstatus.aHu).toString();
            throw new CertPathValidatorException((new StringBuilder()).append(x509attributecertificate).append(", reason: ").append(RFC3280CertPathUtilities.aHY[certstatus.aHt]).toString());
        }
        if (reasonsmask.aIc == ReasonsMask.aId.aIc)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && certstatus.aHt == 11)
        {
            certstatus.aHt = 12;
        }
        if (certstatus.aHt == 12)
        {
            throw new CertPathValidatorException("Attribute certificate status could not be determined.");
        } else
        {
            return;
        }
        if (x509attributecertificate.getExtensionValue(aHT) != null || x509attributecertificate.getExtensionValue(aIb) != null)
        {
            throw new CertPathValidatorException("No rev avail extension is set, but also an AC revocation pointer.");
        }
    }

    protected static void _mth02CB(X509AttributeCertificate x509attributecertificate, ExtendedPKIXParameters extendedpkixparameters)
    {
        try
        {
            x509attributecertificate.checkValidity(CertPathValidatorUtilities._mth02CA(extendedpkixparameters));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (X509AttributeCertificate x509attributecertificate)
        {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", x509attributecertificate);
        }
        // Misplaced declaration of an exception variable
        catch (X509AttributeCertificate x509attributecertificate)
        {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", x509attributecertificate);
        }
    }

    protected static CertPath _mth02CE(X509AttributeCertificate x509attributecertificate, ExtendedPKIXParameters extendedpkixparameters)
    {
        Object obj = null;
        Object obj2 = new HashSet();
        if (x509attributecertificate._mth1F59().getIssuer() != null)
        {
            X509CertStoreSelector x509certstoreselector = new X509CertStoreSelector();
            x509certstoreselector.setSerialNumber(x509attributecertificate._mth1F59().getSerialNumber());
            java.security.Principal aprincipal[] = x509attributecertificate._mth1F59().getIssuer();
            for (int i = 0; i < aprincipal.length; i++)
            {
                try
                {
                    if (aprincipal[i] instanceof X500Principal)
                    {
                        x509certstoreselector.setIssuer(((X500Principal)aprincipal[i]).getEncoded());
                    }
                    ((Set) (obj2)).addAll(CertPathValidatorUtilities._mth02CA(x509certstoreselector, Collections.unmodifiableList(new ArrayList(extendedpkixparameters.aPJ))));
                }
                // Misplaced declaration of an exception variable
                catch (X509AttributeCertificate x509attributecertificate)
                {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", x509attributecertificate);
                }
                // Misplaced declaration of an exception variable
                catch (X509AttributeCertificate x509attributecertificate)
                {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", x509attributecertificate);
                }
            }

            if (((Set) (obj2)).isEmpty())
            {
                throw new CertPathValidatorException("Public key certificate specified in base certificate ID for attribute certificate cannot be found.");
            }
        }
        if (x509attributecertificate._mth1F59().getEntityNames() != null)
        {
            X509CertStoreSelector x509certstoreselector1 = new X509CertStoreSelector();
            x509attributecertificate = x509attributecertificate._mth1F59().getEntityNames();
            for (int j = 0; j < x509attributecertificate.length; j++)
            {
                try
                {
                    if (x509attributecertificate[j] instanceof X500Principal)
                    {
                        x509certstoreselector1.setIssuer(((X500Principal)x509attributecertificate[j]).getEncoded());
                    }
                    ((Set) (obj2)).addAll(CertPathValidatorUtilities._mth02CA(x509certstoreselector1, Collections.unmodifiableList(new ArrayList(extendedpkixparameters.aPJ))));
                }
                // Misplaced declaration of an exception variable
                catch (X509AttributeCertificate x509attributecertificate)
                {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", x509attributecertificate);
                }
                // Misplaced declaration of an exception variable
                catch (X509AttributeCertificate x509attributecertificate)
                {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", x509attributecertificate);
                }
            }

            if (((Set) (obj2)).isEmpty())
            {
                throw new CertPathValidatorException("Public key certificate specified in entity name for attribute certificate cannot be found.");
            }
        }
        ExtendedPKIXBuilderParameters extendedpkixbuilderparameters = (ExtendedPKIXBuilderParameters)ExtendedPKIXBuilderParameters._mth02CB(extendedpkixparameters);
        extendedpkixparameters = null;
        obj2 = ((Set) (obj2)).iterator();
        x509attributecertificate = obj;
        do
        {
            if (((Iterator) (obj2)).hasNext())
            {
                Object obj1 = new X509CertStoreSelector();
                ((X509CertStoreSelector) (obj1)).setCertificate((X509Certificate)((Iterator) (obj2)).next());
                if (obj1 != null)
                {
                    extendedpkixbuilderparameters.aPK = (Selector)((Selector) (obj1)).clone();
                } else
                {
                    extendedpkixbuilderparameters.aPK = null;
                }
                try
                {
                    obj1 = CertPathBuilder.getInstance("PKIX", "SC");
                }
                // Misplaced declaration of an exception variable
                catch (X509AttributeCertificate x509attributecertificate)
                {
                    throw new ExtCertPathValidatorException("Support class could not be created.", x509attributecertificate);
                }
                // Misplaced declaration of an exception variable
                catch (X509AttributeCertificate x509attributecertificate)
                {
                    throw new ExtCertPathValidatorException("Support class could not be created.", x509attributecertificate);
                }
                try
                {
                    obj1 = ((CertPathBuilder) (obj1)).build(ExtendedPKIXBuilderParameters._mth02CB(extendedpkixbuilderparameters));
                }
                // Misplaced declaration of an exception variable
                catch (ExtendedPKIXParameters extendedpkixparameters)
                {
                    extendedpkixparameters = new ExtCertPathValidatorException("Certification path for public key certificate of attribute certificate could not be build.", extendedpkixparameters);
                    continue;
                }
                // Misplaced declaration of an exception variable
                catch (X509AttributeCertificate x509attributecertificate)
                {
                    throw new RuntimeException(x509attributecertificate.getMessage());
                }
                x509attributecertificate = ((X509AttributeCertificate) (obj1));
                continue;
            }
            if (extendedpkixparameters != null)
            {
                throw extendedpkixparameters;
            }
            return x509attributecertificate.getCertPath();
        } while (true);
    }

    protected static void _mth037A(X509Certificate x509certificate)
    {
        if (x509certificate.getKeyUsage() != null && !x509certificate.getKeyUsage()[0] && !x509certificate.getKeyUsage()[1])
        {
            throw new CertPathValidatorException("Attribute certificate issuer public key cannot be used to validate digital signatures.");
        }
        if (x509certificate.getBasicConstraints() != -1)
        {
            throw new CertPathValidatorException("Attribute certificate issuer is also a public key certificate issuer.");
        } else
        {
            return;
        }
    }

    static 
    {
        aHZ = X509Extensions.aku.identifier;
        aIa = X509Extensions.akt.identifier;
        aHT = X509Extensions.akk.identifier;
        aIb = X509Extensions.akr.identifier;
    }
}
