// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CertSelector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.util.Selector;

// Referenced classes of package org.spongycastle.x509:
//            ExtendedPKIXParameters, X509CertStoreSelector

public class ExtendedPKIXBuilderParameters extends ExtendedPKIXParameters
{

    public int aPH;
    public Set aPI;

    private ExtendedPKIXBuilderParameters(Set set, Selector selector)
    {
        super(set);
        aPH = 5;
        aPI = Collections.EMPTY_SET;
        if (selector != null)
        {
            super.aPK = (Selector)selector.clone();
            return;
        } else
        {
            super.aPK = null;
            return;
        }
    }

    public static ExtendedPKIXBuilderParameters _mth02CB(PKIXParameters pkixparameters)
    {
        ExtendedPKIXBuilderParameters extendedpkixbuilderparameters;
        try
        {
            extendedpkixbuilderparameters = new ExtendedPKIXBuilderParameters(pkixparameters.getTrustAnchors(), X509CertStoreSelector._mth02CA((X509CertSelector)pkixparameters.getTargetCertConstraints()));
        }
        // Misplaced declaration of an exception variable
        catch (PKIXParameters pkixparameters)
        {
            throw new RuntimeException(pkixparameters.getMessage());
        }
        extendedpkixbuilderparameters._mth02CA(pkixparameters);
        return extendedpkixbuilderparameters;
    }

    public Object clone()
    {
        Set set = getTrustAnchors();
        if (super.aPK == null) goto _L2; else goto _L1
_L1:
        Object obj = (Selector)super.aPK.clone();
_L4:
        try
        {
            obj = new ExtendedPKIXBuilderParameters(set, ((Selector) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Exception) (obj)).getMessage());
        }
        ((ExtendedPKIXBuilderParameters) (obj))._mth02CA(this);
        return obj;
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void _mth02CA(PKIXParameters pkixparameters)
    {
        super._mth02CA(pkixparameters);
        if (pkixparameters instanceof ExtendedPKIXBuilderParameters)
        {
            ExtendedPKIXBuilderParameters extendedpkixbuilderparameters = (ExtendedPKIXBuilderParameters)pkixparameters;
            aPH = extendedpkixbuilderparameters.aPH;
            aPI = new HashSet(extendedpkixbuilderparameters.aPI);
        }
        if (pkixparameters instanceof PKIXBuilderParameters)
        {
            aPH = ((PKIXBuilderParameters)pkixparameters).getMaxPathLength();
        }
    }
}
