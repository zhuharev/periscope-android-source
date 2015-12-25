// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CertSelector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.spongycastle.util.Selector;

// Referenced classes of package org.spongycastle.x509:
//            X509CertStoreSelector

public class ExtendedPKIXParameters extends PKIXParameters
{

    public ArrayList aPJ;
    public Selector aPK;
    public boolean aPL;
    public ArrayList aPM;
    public HashSet aPN;
    public HashSet aPO;
    public HashSet aPP;
    public HashSet aPQ;
    public int aPR;
    public boolean aPS;

    public ExtendedPKIXParameters(Set set)
    {
        super(set);
        aPR = 0;
        aPS = false;
        aPJ = new ArrayList();
        aPM = new ArrayList();
        aPN = new HashSet();
        aPO = new HashSet();
        aPP = new HashSet();
        aPQ = new HashSet();
    }

    public static ExtendedPKIXParameters _mth02CE(PKIXParameters pkixparameters)
    {
        ExtendedPKIXParameters extendedpkixparameters;
        try
        {
            extendedpkixparameters = new ExtendedPKIXParameters(pkixparameters.getTrustAnchors());
        }
        // Misplaced declaration of an exception variable
        catch (PKIXParameters pkixparameters)
        {
            throw new RuntimeException(pkixparameters.getMessage());
        }
        extendedpkixparameters._mth02CA(pkixparameters);
        return extendedpkixparameters;
    }

    public Object clone()
    {
        Object obj;
        try
        {
            obj = new ExtendedPKIXParameters(getTrustAnchors());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Exception) (obj)).getMessage());
        }
        ((ExtendedPKIXParameters) (obj))._mth02CA(this);
        return obj;
    }

    public void setCertStores(List list)
    {
        if (list != null)
        {
            for (list = list.iterator(); list.hasNext(); addCertStore((CertStore)list.next())) { }
        }
    }

    public void setTargetCertConstraints(CertSelector certselector)
    {
        super.setTargetCertConstraints(certselector);
        if (certselector != null)
        {
            aPK = X509CertStoreSelector._mth02CA((X509CertSelector)certselector);
            return;
        } else
        {
            aPK = null;
            return;
        }
    }

    protected void _mth02CA(PKIXParameters pkixparameters)
    {
        setDate(pkixparameters.getDate());
        setCertPathCheckers(pkixparameters.getCertPathCheckers());
        setCertStores(pkixparameters.getCertStores());
        setAnyPolicyInhibited(pkixparameters.isAnyPolicyInhibited());
        setExplicitPolicyRequired(pkixparameters.isExplicitPolicyRequired());
        setPolicyMappingInhibited(pkixparameters.isPolicyMappingInhibited());
        setRevocationEnabled(pkixparameters.isRevocationEnabled());
        setInitialPolicies(pkixparameters.getInitialPolicies());
        setPolicyQualifiersRejected(pkixparameters.getPolicyQualifiersRejected());
        setSigProvider(pkixparameters.getSigProvider());
        setTargetCertConstraints(pkixparameters.getTargetCertConstraints());
        try
        {
            setTrustAnchors(pkixparameters.getTrustAnchors());
        }
        // Misplaced declaration of an exception variable
        catch (PKIXParameters pkixparameters)
        {
            throw new RuntimeException(pkixparameters.getMessage());
        }
        if (pkixparameters instanceof ExtendedPKIXParameters)
        {
            ExtendedPKIXParameters extendedpkixparameters = (ExtendedPKIXParameters)pkixparameters;
            aPR = extendedpkixparameters.aPR;
            aPS = extendedpkixparameters.aPS;
            aPL = extendedpkixparameters.aPL;
            if (extendedpkixparameters.aPK == null)
            {
                pkixparameters = null;
            } else
            {
                pkixparameters = (Selector)extendedpkixparameters.aPK.clone();
            }
            aPK = pkixparameters;
            aPJ = new ArrayList(extendedpkixparameters.aPJ);
            aPM = new ArrayList(extendedpkixparameters.aPM);
            aPN = new HashSet(extendedpkixparameters.aPN);
            aPP = new HashSet(extendedpkixparameters.aPP);
            aPO = new HashSet(extendedpkixparameters.aPO);
            aPQ = new HashSet(extendedpkixparameters.aPQ);
        }
    }
}
