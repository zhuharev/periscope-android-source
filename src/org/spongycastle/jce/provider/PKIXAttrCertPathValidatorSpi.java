// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.X509Certificate;
import java.util.List;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509AttributeCertStoreSelector;

// Referenced classes of package org.spongycastle.jce.provider:
//            AnnotatedException, RFC3281CertPathUtilities, CertPathValidatorUtilities

public class PKIXAttrCertPathValidatorSpi extends CertPathValidatorSpi
{

    public PKIXAttrCertPathValidatorSpi()
    {
    }

    public CertPathValidatorResult engineValidate(CertPath certpath, CertPathParameters certpathparameters)
    {
        if (!(certpathparameters instanceof ExtendedPKIXParameters))
        {
            throw new InvalidAlgorithmParameterException((new StringBuilder("Parameters must be a ")).append(org/spongycastle/x509/ExtendedPKIXParameters.getName()).append(" instance.").toString());
        }
        ExtendedPKIXParameters extendedpkixparameters = (ExtendedPKIXParameters)certpathparameters;
        if (extendedpkixparameters.aPK != null)
        {
            certpathparameters = (Selector)extendedpkixparameters.aPK.clone();
        } else
        {
            certpathparameters = null;
        }
        if (!(certpathparameters instanceof X509AttributeCertStoreSelector))
        {
            throw new InvalidAlgorithmParameterException((new StringBuilder("TargetConstraints must be an instance of ")).append(org/spongycastle/x509/X509AttributeCertStoreSelector.getName()).append(" for ").append(getClass().getName()).append(" class.").toString());
        }
        certpathparameters = ((X509AttributeCertStoreSelector)certpathparameters).aPY;
        Object obj = RFC3281CertPathUtilities._mth02CE(certpathparameters, extendedpkixparameters);
        CertPathValidatorResult certpathvalidatorresult = RFC3281CertPathUtilities._mth02CA(certpath, extendedpkixparameters);
        X509Certificate x509certificate = (X509Certificate)certpath.getCertificates().get(0);
        RFC3281CertPathUtilities._mth037A(x509certificate);
        RFC3281CertPathUtilities._mth02CA(x509certificate, extendedpkixparameters);
        RFC3281CertPathUtilities._mth02CB(certpathparameters, extendedpkixparameters);
        RFC3281CertPathUtilities._mth02CA(certpathparameters, certpath, ((CertPath) (obj)), extendedpkixparameters);
        RFC3281CertPathUtilities._mth02CA(certpathparameters, extendedpkixparameters);
        try
        {
            obj = CertPathValidatorUtilities._mth02CA(extendedpkixparameters, null, -1);
        }
        // Misplaced declaration of an exception variable
        catch (CertPath certpath)
        {
            throw new ExtCertPathValidatorException("Could not get validity date from attribute certificate.", certpath);
        }
        RFC3281CertPathUtilities._mth02CA(certpathparameters, extendedpkixparameters, x509certificate, ((java.util.Date) (obj)), certpath.getCertificates());
        return certpathvalidatorresult;
    }
}
