// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.spongycastle.jce.X509LDAPCertStoreParameters;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.X509CertPairStoreSelector;
import org.spongycastle.x509.X509CertStoreSelector;
import org.spongycastle.x509.X509CertificatePair;
import org.spongycastle.x509.X509StoreParameters;
import org.spongycastle.x509.X509StoreSpi;
import org.spongycastle.x509.util.LDAPStoreHelper;

public class X509StoreLDAPCerts extends X509StoreSpi
{

    private LDAPStoreHelper aIi;

    public X509StoreLDAPCerts()
    {
    }

    private HashSet _mth02CA(X509CertStoreSelector x509certstoreselector)
    {
        HashSet hashset = new HashSet();
        Object obj = new X509CertPairStoreSelector();
        obj.aQh = x509certstoreselector;
        obj.aQi = new X509CertStoreSelector();
        Object obj1 = new HashSet(aIi._mth02CA(((X509CertPairStoreSelector) (obj))));
        x509certstoreselector = new HashSet();
        obj = new HashSet();
        obj1 = ((Set) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            X509CertificatePair x509certificatepair = (X509CertificatePair)((Iterator) (obj1)).next();
            if (x509certificatepair.aQk != null)
            {
                x509certstoreselector.add(x509certificatepair.aQk);
            }
            if (x509certificatepair.aQl != null)
            {
                ((Set) (obj)).add(x509certificatepair.aQl);
            }
        } while (true);
        hashset.addAll(x509certstoreselector);
        hashset.addAll(((Collection) (obj)));
        return hashset;
    }

    public final Collection _mth02CA(Selector selector)
    {
        if (!(selector instanceof X509CertStoreSelector))
        {
            return Collections.EMPTY_SET;
        }
        selector = (X509CertStoreSelector)selector;
        HashSet hashset = new HashSet();
        if (selector.getBasicConstraints() > 0)
        {
            hashset.addAll(aIi._mth02CE(selector));
            hashset.addAll(_mth02CA(((X509CertStoreSelector) (selector))));
            return hashset;
        }
        if (selector.getBasicConstraints() == -2)
        {
            hashset.addAll(aIi._mth02CB(selector));
            return hashset;
        } else
        {
            hashset.addAll(aIi._mth02CB(selector));
            hashset.addAll(aIi._mth02CE(selector));
            hashset.addAll(_mth02CA(((X509CertStoreSelector) (selector))));
            return hashset;
        }
    }

    public final void _mth02CA(X509StoreParameters x509storeparameters)
    {
        if (!(x509storeparameters instanceof X509LDAPCertStoreParameters))
        {
            throw new IllegalArgumentException((new StringBuilder("Initialization parameters must be an instance of ")).append(org/spongycastle/jce/X509LDAPCertStoreParameters.getName()).append(".").toString());
        } else
        {
            aIi = new LDAPStoreHelper((X509LDAPCertStoreParameters)x509storeparameters);
            return;
        }
    }
}
