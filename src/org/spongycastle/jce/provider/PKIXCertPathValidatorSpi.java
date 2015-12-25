// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.ExtendedPKIXParameters;

// Referenced classes of package org.spongycastle.jce.provider:
//            AnnotatedException, CertPathValidatorUtilities, PKIXPolicyNode, PKIXNameConstraintValidator, 
//            RFC3280CertPathUtilities

public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi
{

    public PKIXCertPathValidatorSpi()
    {
    }

    public CertPathValidatorResult engineValidate(CertPath certpath, CertPathParameters certpathparameters)
    {
        Object obj;
        ExtendedPKIXParameters extendedpkixparameters;
        Object obj2;
        PKIXPolicyNode pkixpolicynode;
        TrustAnchor trustanchor;
        Set set;
        ArrayList aarraylist[];
        HashSet hashset1;
        List list;
        PKIXNameConstraintValidator pkixnameconstraintvalidator;
        int j;
        int k;
        int l;
        int l2;
        if (!(certpathparameters instanceof PKIXParameters))
        {
            throw new InvalidAlgorithmParameterException((new StringBuilder("Parameters must be a ")).append(java/security/cert/PKIXParameters.getName()).append(" instance.").toString());
        }
        if (certpathparameters instanceof ExtendedPKIXParameters)
        {
            extendedpkixparameters = (ExtendedPKIXParameters)certpathparameters;
        } else
        {
            extendedpkixparameters = ExtendedPKIXParameters._mth02CE((PKIXParameters)certpathparameters);
        }
        if (extendedpkixparameters.getTrustAnchors() == null)
        {
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
        list = certpath.getCertificates();
        l2 = list.size();
        if (list.isEmpty())
        {
            throw new CertPathValidatorException("Certification path is empty.", null, certpath, 0);
        }
        set = extendedpkixparameters.getInitialPolicies();
        try
        {
            trustanchor = CertPathValidatorUtilities._mth02CA((X509Certificate)list.get(list.size() - 1), extendedpkixparameters.getTrustAnchors(), extendedpkixparameters.getSigProvider());
        }
        // Misplaced declaration of an exception variable
        catch (CertPathParameters certpathparameters)
        {
            throw new CertPathValidatorException(certpathparameters.getMessage(), certpathparameters, certpath, list.size() - 1);
        }
        if (trustanchor == null)
        {
            throw new CertPathValidatorException("Trust anchor for certification path not found.", null, certpath, -1);
        }
        aarraylist = new ArrayList[l2 + 1];
        for (int i = 0; i < aarraylist.length; i++)
        {
            aarraylist[i] = new ArrayList();
        }

        certpathparameters = new HashSet();
        certpathparameters.add("2.5.29.32.0");
        pkixpolicynode = new PKIXPolicyNode(new ArrayList(), 0, certpathparameters, null, new HashSet(), "2.5.29.32.0", false);
        aarraylist[0].add(pkixpolicynode);
        pkixnameconstraintvalidator = new PKIXNameConstraintValidator();
        hashset1 = new HashSet();
        if (extendedpkixparameters.isExplicitPolicyRequired())
        {
            j = 0;
        } else
        {
            j = l2 + 1;
        }
        if (extendedpkixparameters.isAnyPolicyInhibited())
        {
            k = 0;
        } else
        {
            k = l2 + 1;
        }
        if (extendedpkixparameters.isPolicyMappingInhibited())
        {
            l = 0;
        } else
        {
            l = l2 + 1;
        }
        obj2 = trustanchor.getTrustedCert();
        if (obj2 != null)
        {
            try
            {
                obj = CertPathValidatorUtilities._mth02BC(((X509Certificate) (obj2)));
                certpathparameters = ((X509Certificate) (obj2)).getPublicKey();
            }
            // Misplaced declaration of an exception variable
            catch (CertPathParameters certpathparameters)
            {
                throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", certpathparameters, certpath, -1);
            }
            break MISSING_BLOCK_LABEL_447;
        }
        obj = new X500Principal(trustanchor.getCAName());
        certpathparameters = trustanchor.getCAPublicKey();
        Object obj1;
        try
        {
            obj1 = CertPathValidatorUtilities._mth02BC(certpathparameters);
        }
        // Misplaced declaration of an exception variable
        catch (CertPathParameters certpathparameters)
        {
            throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", certpathparameters, certpath, -1);
        }
        new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj1)).ahP.identifier);
        int i1 = l2;
        if (extendedpkixparameters.aPK != null)
        {
            obj1 = (Selector)extendedpkixparameters.aPK.clone();
        } else
        {
            obj1 = null;
        }
        if (obj1 != null)
        {
            if (extendedpkixparameters.aPK != null)
            {
                obj1 = (Selector)extendedpkixparameters.aPK.clone();
            } else
            {
                obj1 = null;
            }
            if (!((Selector) (obj1))._mth1D59((X509Certificate)list.get(0)))
            {
                throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, certpath, 0);
            }
        }
        List list1 = extendedpkixparameters.getCertPathCheckers();
        for (obj1 = list1.iterator(); ((Iterator) (obj1)).hasNext(); ((PKIXCertPathChecker)((Iterator) (obj1)).next()).init(false)) { }
        obj1 = null;
        int j1 = list.size() - 1;
        X500Principal x500principal = ((X500Principal) (obj));
        Object obj3 = certpathparameters;
        int j2 = j;
        certpathparameters = pkixpolicynode;
        for (j = j1; j >= 0;)
        {
            obj = (X509Certificate)list.get(j);
            boolean flag;
            if (j == list.size() - 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            RFC3280CertPathUtilities._mth02CA(certpath, extendedpkixparameters, j, ((java.security.PublicKey) (obj3)), flag, x500principal, ((X509Certificate) (obj2)));
            RFC3280CertPathUtilities._mth02CA(certpath, j, pkixnameconstraintvalidator);
            obj1 = RFC3280CertPathUtilities._mth02CA(certpath, j, RFC3280CertPathUtilities._mth02CA(certpath, j, hashset1, certpathparameters, aarraylist, k));
            RFC3280CertPathUtilities._mth02CA(certpath, j, ((PKIXPolicyNode) (obj1)), j2);
            certpathparameters = ((CertPathParameters) (obj1));
            int k2 = j2;
            int i2 = k;
            int l1 = l;
            int k1 = i1;
            if (l2 - j != l2)
            {
                if (obj != null && ((X509Certificate) (obj)).getVersion() == 1)
                {
                    throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, certpath, j);
                }
                RFC3280CertPathUtilities._mth02CA(certpath, j);
                obj1 = RFC3280CertPathUtilities._mth02CA(certpath, j, aarraylist, ((PKIXPolicyNode) (obj1)), l);
                RFC3280CertPathUtilities._mth02CB(certpath, j, pkixnameconstraintvalidator);
                k1 = RFC3280CertPathUtilities._mth02BB(certpath, j, j2);
                l = RFC3280CertPathUtilities._mth02BC(certpath, j, l);
                k = RFC3280CertPathUtilities._mth02BD(certpath, j, k);
                k2 = RFC3280CertPathUtilities._mth02CA(certpath, j, k1);
                l1 = RFC3280CertPathUtilities._mth02CB(certpath, j, l);
                i2 = RFC3280CertPathUtilities._mth02CE(certpath, j, k);
                RFC3280CertPathUtilities._mth02CB(certpath, j);
                k1 = RFC3280CertPathUtilities._mth141D(certpath, j, RFC3280CertPathUtilities._mth02CF(certpath, j, i1));
                RFC3280CertPathUtilities._mth02CE(certpath, j);
                certpathparameters = ((X509Certificate) (obj)).getCriticalExtensionOIDs();
                if (certpathparameters != null)
                {
                    obj2 = new HashSet(certpathparameters);
                    certpathparameters = ((CertPathParameters) (obj2));
                    ((Set) (obj2)).remove(RFC3280CertPathUtilities.aHX);
                    certpathparameters.remove(RFC3280CertPathUtilities.aHN);
                    certpathparameters.remove(RFC3280CertPathUtilities.aHO);
                    certpathparameters.remove(RFC3280CertPathUtilities.aHP);
                    certpathparameters.remove(RFC3280CertPathUtilities.aHr);
                    certpathparameters.remove(RFC3280CertPathUtilities.aHQ);
                    certpathparameters.remove(RFC3280CertPathUtilities.aHR);
                    certpathparameters.remove(RFC3280CertPathUtilities.aHS);
                    certpathparameters.remove(RFC3280CertPathUtilities.aHU);
                    certpathparameters.remove(RFC3280CertPathUtilities.aHV);
                } else
                {
                    certpathparameters = new HashSet();
                }
                RFC3280CertPathUtilities._mth02CA(certpath, j, certpathparameters, list1);
                obj2 = obj;
                x500principal = CertPathValidatorUtilities._mth02BC(((X509Certificate) (obj)));
                try
                {
                    obj3 = CertPathValidatorUtilities._mth02CA(certpath.getCertificates(), j);
                }
                // Misplaced declaration of an exception variable
                catch (CertPathParameters certpathparameters)
                {
                    throw new CertPathValidatorException("Next working key could not be retrieved.", certpathparameters, certpath, j);
                }
                new ASN1ObjectIdentifier(CertPathValidatorUtilities._mth02BC(((java.security.PublicKey) (obj3))).ahP.identifier);
                certpathparameters = ((CertPathParameters) (obj1));
            }
            j--;
            j2 = k2;
            k = i2;
            l = l1;
            i1 = k1;
            obj1 = obj;
        }

        k = RFC3280CertPathUtilities._mth037A(certpath, j + 1, RFC3280CertPathUtilities._mth02CA(j2, ((X509Certificate) (obj1))));
        obj = ((X509Certificate) (obj1)).getCriticalExtensionOIDs();
        if (obj != null)
        {
            HashSet hashset = new HashSet(((java.util.Collection) (obj)));
            obj = hashset;
            hashset.remove(RFC3280CertPathUtilities.aHX);
            ((Set) (obj)).remove(RFC3280CertPathUtilities.aHN);
            ((Set) (obj)).remove(RFC3280CertPathUtilities.aHO);
            ((Set) (obj)).remove(RFC3280CertPathUtilities.aHP);
            ((Set) (obj)).remove(RFC3280CertPathUtilities.aHr);
            ((Set) (obj)).remove(RFC3280CertPathUtilities.aHQ);
            ((Set) (obj)).remove(RFC3280CertPathUtilities.aHR);
            ((Set) (obj)).remove(RFC3280CertPathUtilities.aHS);
            ((Set) (obj)).remove(RFC3280CertPathUtilities.aHU);
            ((Set) (obj)).remove(RFC3280CertPathUtilities.aHV);
            ((Set) (obj)).remove(RFC3280CertPathUtilities.aHT);
        } else
        {
            obj = new HashSet();
        }
        RFC3280CertPathUtilities._mth02CA(certpath, j + 1, list1, ((HashSet) (obj)));
        certpathparameters = RFC3280CertPathUtilities._mth02CA(certpath, extendedpkixparameters, set, j + 1, aarraylist, certpathparameters, hashset1);
        if (k > 0 || certpathparameters != null)
        {
            return new PKIXCertPathValidatorResult(trustanchor, certpathparameters, ((X509Certificate) (obj1)).getPublicKey());
        } else
        {
            throw new CertPathValidatorException("Path processing failed on policy.", null, certpath, j);
        }
    }
}
