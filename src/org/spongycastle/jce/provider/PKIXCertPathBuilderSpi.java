// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

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
import org.spongycastle.jce.exception.ExtCertPathBuilderException;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509CertStoreSelector;

// Referenced classes of package org.spongycastle.jce.provider:
//            AnnotatedException, CertPathValidatorUtilities

public class PKIXCertPathBuilderSpi extends CertPathBuilderSpi
{

    private AnnotatedException aHx;

    public PKIXCertPathBuilderSpi()
    {
    }

    private CertPathBuilderResult _mth02CA(X509Certificate x509certificate, ExtendedPKIXBuilderParameters extendedpkixbuilderparameters, List list)
    {
        Object obj;
        Object obj1;
        java.security.cert.CertPath certpath;
        Object obj2;
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
        obj = null;
        certpath = null;
        try
        {
            certificatefactory = CertificateFactory.getInstance("X.509", "SC");
            obj2 = CertPathValidator.getInstance("PKIX", "SC");
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            throw new RuntimeException("Exception creating support classes.");
        }
        obj1 = obj;
        java.security.cert.TrustAnchor trustanchor = CertPathValidatorUtilities._mth02CA(x509certificate, extendedpkixbuilderparameters.getTrustAnchors(), extendedpkixbuilderparameters.getSigProvider());
        if (trustanchor == null)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        obj1 = obj;
        certpath = certificatefactory.generateCertPath(list);
        break MISSING_BLOCK_LABEL_154;
        extendedpkixbuilderparameters;
          goto _L1
        obj1 = obj;
        extendedpkixbuilderparameters = (PKIXCertPathValidatorResult)((CertPathValidator) (obj2)).validate(certpath, extendedpkixbuilderparameters);
        break MISSING_BLOCK_LABEL_189;
        extendedpkixbuilderparameters;
        obj1 = obj;
        throw new AnnotatedException("Certification path could not be validated.", extendedpkixbuilderparameters);
        obj1 = obj;
        extendedpkixbuilderparameters = new PKIXCertPathBuilderResult(certpath, extendedpkixbuilderparameters.getTrustAnchor(), extendedpkixbuilderparameters.getPolicyTree(), extendedpkixbuilderparameters.getPublicKey());
        return extendedpkixbuilderparameters;
        obj1 = obj;
        CertPathValidatorUtilities._mth02CA(x509certificate, extendedpkixbuilderparameters);
        break MISSING_BLOCK_LABEL_245;
        extendedpkixbuilderparameters;
        obj1 = obj;
        throw new AnnotatedException("No additiontal X.509 stores can be added from certificate locations.", extendedpkixbuilderparameters);
        obj1 = obj;
        obj2 = new HashSet();
        try
        {
            ((Collection) (obj2)).addAll(CertPathValidatorUtilities._mth02CB(x509certificate, extendedpkixbuilderparameters));
            break MISSING_BLOCK_LABEL_290;
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXBuilderParameters extendedpkixbuilderparameters)
        {
            obj1 = obj;
        }
        throw new AnnotatedException("Cannot find issuer certificate for certificate in certification path.", extendedpkixbuilderparameters);
        obj1 = obj;
        if (!((Collection) (obj2)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_318;
        }
        obj1 = obj;
        throw new AnnotatedException("No issuer certificate for certificate in certification path found.");
        obj1 = obj;
        obj2 = ((Collection) (obj2)).iterator();
        obj = certpath;
_L3:
        obj1 = obj;
        if (!((Iterator) (obj2)).hasNext() || obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        obj = _mth02CA((X509Certificate)((Iterator) (obj2)).next(), extendedpkixbuilderparameters, list);
        if (true) goto _L3; else goto _L2
_L1:
        obj1 = obj;
        try
        {
            throw new AnnotatedException("Certification path could not be constructed from certificate list.", extendedpkixbuilderparameters);
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXBuilderParameters extendedpkixbuilderparameters)
        {
            aHx = extendedpkixbuilderparameters;
        }
        obj = obj1;
_L2:
        if (obj == null)
        {
            list.remove(x509certificate);
        }
        return ((CertPathBuilderResult) (obj));
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
        if (!(obj instanceof X509CertStoreSelector))
        {
            throw new CertPathBuilderException((new StringBuilder("TargetConstraints must be an instance of ")).append(org/spongycastle/x509/X509CertStoreSelector.getName()).append(" for ").append(getClass().getName()).append(" class.").toString());
        }
        Object obj1;
        try
        {
            obj1 = CertPathValidatorUtilities._mth02CA((X509CertStoreSelector)obj, Collections.unmodifiableList(new ArrayList(((ExtendedPKIXParameters) (certpathparameters)).aPJ)));
            ((Collection) (obj1)).addAll(CertPathValidatorUtilities._mth02CA((X509CertStoreSelector)obj, certpathparameters.getCertStores()));
        }
        // Misplaced declaration of an exception variable
        catch (CertPathParameters certpathparameters)
        {
            throw new ExtCertPathBuilderException("Error finding target certificate.", certpathparameters);
        }
        if (((Collection) (obj1)).isEmpty())
        {
            throw new CertPathBuilderException("No certificate found matching targetContraints.");
        }
        obj = null;
        for (obj1 = ((Collection) (obj1)).iterator(); ((Iterator) (obj1)).hasNext() && obj == null; obj = _mth02CA((X509Certificate)((Iterator) (obj1)).next(), certpathparameters, arraylist)) { }
        if (obj == null && aHx != null)
        {
            if (aHx instanceof AnnotatedException)
            {
                throw new CertPathBuilderException(aHx.getMessage(), aHx.getCause());
            } else
            {
                throw new CertPathBuilderException("Possible certificate chain could not be validated.", aHx);
            }
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
