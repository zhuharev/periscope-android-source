// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.jce.exception.ExtCertPathBuilderException;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.AttributeCertificateIssuer;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509CertStoreSelector;

// Referenced classes of package org.spongycastle.jce.provider:
//            AnnotatedException, CertPathValidatorUtilities

public class PKIXAttrCertPathBuilderSpi extends CertPathBuilderSpi
{

    private AnnotatedException aHx;

    public PKIXAttrCertPathBuilderSpi()
    {
    }

    private CertPathBuilderResult _mth02CA(X509AttributeCertificate x509attributecertificate, X509Certificate x509certificate, ExtendedPKIXBuilderParameters extendedpkixbuilderparameters, List list)
    {
        CertPathBuilderResult certpathbuilderresult;
        CertPathBuilderResult certpathbuilderresult1;
        X509Certificate x509certificate1;
        Object obj;
        CertificateFactory certificatefactory;
        if (list.contains(x509certificate))
        {
            return null;
        }
        if (Collections.unmodifiableSet(extendedpkixbuilderparameters.aPI).contains(x509certificate))
        {
            return null;
        }
        if (extendedpkixbuilderparameters.aPH != -1 && list.size() - 1 > extendedpkixbuilderparameters.aPH)
        {
            return null;
        }
        list.add(x509certificate);
        certpathbuilderresult = null;
        x509certificate1 = null;
        try
        {
            certificatefactory = CertificateFactory.getInstance("X.509", "SC");
            obj = CertPathValidator.getInstance("RFC3281", "SC");
        }
        // Misplaced declaration of an exception variable
        catch (X509AttributeCertificate x509attributecertificate)
        {
            throw new RuntimeException("Exception creating support classes.");
        }
        certpathbuilderresult1 = certpathbuilderresult;
        java.security.cert.TrustAnchor trustanchor = CertPathValidatorUtilities._mth02CA(x509certificate, extendedpkixbuilderparameters.getTrustAnchors(), extendedpkixbuilderparameters.getSigProvider());
        if (trustanchor == null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        certpathbuilderresult1 = certpathbuilderresult;
        x509attributecertificate = certificatefactory.generateCertPath(list);
        break MISSING_BLOCK_LABEL_157;
        x509attributecertificate;
          goto _L1
        certpathbuilderresult1 = certpathbuilderresult;
        extendedpkixbuilderparameters = (PKIXCertPathValidatorResult)((CertPathValidator) (obj)).validate(x509attributecertificate, extendedpkixbuilderparameters);
        break MISSING_BLOCK_LABEL_191;
        x509attributecertificate;
        certpathbuilderresult1 = certpathbuilderresult;
        throw new AnnotatedException("Certification path could not be validated.", x509attributecertificate);
        certpathbuilderresult1 = certpathbuilderresult;
        x509attributecertificate = new PKIXCertPathBuilderResult(x509attributecertificate, extendedpkixbuilderparameters.getTrustAnchor(), extendedpkixbuilderparameters.getPolicyTree(), extendedpkixbuilderparameters.getPublicKey());
        return x509attributecertificate;
        certpathbuilderresult1 = certpathbuilderresult;
        CertPathValidatorUtilities._mth02CA(x509certificate, extendedpkixbuilderparameters);
        break MISSING_BLOCK_LABEL_246;
        x509attributecertificate;
        certpathbuilderresult1 = certpathbuilderresult;
        throw new AnnotatedException("No additional X.509 stores can be added from certificate locations.", x509attributecertificate);
        certpathbuilderresult1 = certpathbuilderresult;
        obj = new HashSet();
        try
        {
            ((Collection) (obj)).addAll(CertPathValidatorUtilities._mth02CB(x509certificate, extendedpkixbuilderparameters));
            break MISSING_BLOCK_LABEL_291;
        }
        // Misplaced declaration of an exception variable
        catch (X509AttributeCertificate x509attributecertificate)
        {
            certpathbuilderresult1 = certpathbuilderresult;
        }
        throw new AnnotatedException("Cannot find issuer certificate for certificate in certification path.", x509attributecertificate);
        certpathbuilderresult1 = certpathbuilderresult;
        if (!((Collection) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_319;
        }
        certpathbuilderresult1 = certpathbuilderresult;
        throw new AnnotatedException("No issuer certificate for certificate in certification path found.");
        certpathbuilderresult1 = certpathbuilderresult;
        obj = ((Collection) (obj)).iterator();
        certpathbuilderresult = x509certificate1;
_L3:
        certpathbuilderresult1 = certpathbuilderresult;
        if (!((Iterator) (obj)).hasNext() || certpathbuilderresult != null)
        {
            break; /* Loop/switch isn't completed */
        }
        certpathbuilderresult1 = certpathbuilderresult;
        x509certificate1 = (X509Certificate)((Iterator) (obj)).next();
        certpathbuilderresult1 = certpathbuilderresult;
        if (x509certificate1.getIssuerX500Principal().equals(x509certificate1.getSubjectX500Principal()))
        {
            continue; /* Loop/switch isn't completed */
        }
        certpathbuilderresult1 = certpathbuilderresult;
        certpathbuilderresult = _mth02CA(x509attributecertificate, x509certificate1, extendedpkixbuilderparameters, list);
        if (true) goto _L3; else goto _L2
_L1:
        certpathbuilderresult1 = certpathbuilderresult;
        try
        {
            throw new AnnotatedException("Certification path could not be constructed from certificate list.", x509attributecertificate);
        }
        // Misplaced declaration of an exception variable
        catch (X509AttributeCertificate x509attributecertificate)
        {
            aHx = new AnnotatedException("No valid certification path could be build.", x509attributecertificate);
        }
        certpathbuilderresult = certpathbuilderresult1;
_L2:
        if (certpathbuilderresult == null)
        {
            list.remove(x509certificate);
        }
        return certpathbuilderresult;
    }

    public CertPathBuilderResult engineBuild(CertPathParameters certpathparameters)
    {
        if (!(certpathparameters instanceof PKIXBuilderParameters) && !(certpathparameters instanceof ExtendedPKIXBuilderParameters))
        {
            throw new InvalidAlgorithmParameterException((new StringBuilder("Parameters must be an instance of ")).append(java/security/cert/PKIXBuilderParameters.getName()).append(" or ").append(org/spongycastle/x509/ExtendedPKIXBuilderParameters.getName()).append(".").toString());
        }
        if (certpathparameters instanceof ExtendedPKIXBuilderParameters)
        {
            certpathparameters = (ExtendedPKIXBuilderParameters)certpathparameters;
        } else
        {
            certpathparameters = (ExtendedPKIXBuilderParameters)ExtendedPKIXBuilderParameters._mth02CB((PKIXBuilderParameters)certpathparameters);
        }
        ArrayList arraylist = new ArrayList();
        Object obj;
        if (((ExtendedPKIXParameters) (certpathparameters)).aPK != null)
        {
            obj = (Selector)((ExtendedPKIXParameters) (certpathparameters)).aPK.clone();
        } else
        {
            obj = null;
        }
        if (!(obj instanceof X509AttributeCertStoreSelector))
        {
            throw new CertPathBuilderException((new StringBuilder("TargetConstraints must be an instance of ")).append(org/spongycastle/x509/X509AttributeCertStoreSelector.getName()).append(" for ").append(getClass().getName()).append(" class.").toString());
        }
        Object obj1;
        try
        {
            obj1 = CertPathValidatorUtilities._mth02CA((X509AttributeCertStoreSelector)obj, Collections.unmodifiableList(new ArrayList(((ExtendedPKIXParameters) (certpathparameters)).aPJ)));
        }
        // Misplaced declaration of an exception variable
        catch (CertPathParameters certpathparameters)
        {
            throw new ExtCertPathBuilderException("Error finding target attribute certificate.", certpathparameters);
        }
        if (((Collection) (obj1)).isEmpty())
        {
            throw new CertPathBuilderException("No attribute certificate found matching targetContraints.");
        }
        obj = null;
        for (obj1 = ((Collection) (obj1)).iterator(); ((Iterator) (obj1)).hasNext() && obj == null;)
        {
            X509AttributeCertificate x509attributecertificate = (X509AttributeCertificate)((Iterator) (obj1)).next();
            Object obj2 = new X509CertStoreSelector();
            java.security.Principal aprincipal[] = x509attributecertificate._mth1FE8().getPrincipals();
            HashSet hashset = new HashSet();
            for (int i = 0; i < aprincipal.length; i++)
            {
                try
                {
                    if (aprincipal[i] instanceof X500Principal)
                    {
                        ((X509CertStoreSelector) (obj2)).setSubject(((X500Principal)aprincipal[i]).getEncoded());
                    }
                    hashset.addAll(CertPathValidatorUtilities._mth02CA(((X509CertStoreSelector) (obj2)), Collections.unmodifiableList(new ArrayList(((ExtendedPKIXParameters) (certpathparameters)).aPJ))));
                    hashset.addAll(CertPathValidatorUtilities._mth02CA(((X509CertStoreSelector) (obj2)), certpathparameters.getCertStores()));
                }
                // Misplaced declaration of an exception variable
                catch (CertPathParameters certpathparameters)
                {
                    throw new ExtCertPathBuilderException("Public key certificate for attribute certificate cannot be searched.", certpathparameters);
                }
                // Misplaced declaration of an exception variable
                catch (CertPathParameters certpathparameters)
                {
                    throw new ExtCertPathBuilderException("cannot encode X500Principal.", certpathparameters);
                }
            }

            if (hashset.isEmpty())
            {
                throw new CertPathBuilderException("Public key certificate for attribute certificate cannot be found.");
            }
            obj2 = hashset.iterator();
            while (((Iterator) (obj2)).hasNext() && obj == null) 
            {
                obj = _mth02CA(x509attributecertificate, (X509Certificate)((Iterator) (obj2)).next(), certpathparameters, arraylist);
            }
        }

        if (obj == null && aHx != null)
        {
            throw new ExtCertPathBuilderException("Possible certificate chain could not be validated.", aHx);
        }
        if (obj == null && aHx == null)
        {
            throw new CertPathBuilderException("Unable to find certificate chain.");
        } else
        {
            return ((CertPathBuilderResult) (obj));
        }
    }
}
