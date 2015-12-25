// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.jce.X509LDAPCertStoreParameters;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.X509CRLStoreSelector;
import org.spongycastle.x509.X509StoreParameters;
import org.spongycastle.x509.X509StoreSpi;
import org.spongycastle.x509.util.LDAPStoreHelper;

public class X509StoreLDAPCRLs extends X509StoreSpi
{

    private LDAPStoreHelper aIi;

    public X509StoreLDAPCRLs()
    {
    }

    public final Collection _mth02CA(Selector selector)
    {
        if (!(selector instanceof X509CRLStoreSelector))
        {
            return Collections.EMPTY_SET;
        }
        selector = (X509CRLStoreSelector)selector;
        HashSet hashset = new HashSet();
        if (((X509CRLStoreSelector) (selector)).aQb)
        {
            hashset.addAll(aIi._mth02CB(selector));
            return hashset;
        }
        hashset.addAll(aIi._mth02CB(selector));
        LDAPStoreHelper ldapstorehelper = aIi;
        String as[] = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGA);
        String as1[] = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGL);
        String as2[] = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGW);
        HashSet hashset1 = LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(selector, as, as1, as2), selector);
        if (hashset1.size() == 0)
        {
            hashset1.addAll(LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(new X509CRLStoreSelector(), as, as1, as2), selector));
        }
        hashset.addAll(hashset1);
        ldapstorehelper = aIi;
        as = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGz);
        as1 = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGK);
        as2 = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGV);
        hashset1 = LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(selector, as, as1, as2), selector);
        if (hashset1.size() == 0)
        {
            hashset1.addAll(LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(new X509CRLStoreSelector(), as, as1, as2), selector));
        }
        hashset.addAll(hashset1);
        ldapstorehelper = aIi;
        as = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGv);
        as1 = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGG);
        as2 = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGR);
        hashset1 = LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(selector, as, as1, as2), selector);
        if (hashset1.size() == 0)
        {
            hashset1.addAll(LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(new X509CRLStoreSelector(), as, as1, as2), selector));
        }
        hashset.addAll(hashset1);
        ldapstorehelper = aIi;
        as = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGt);
        as1 = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGE);
        as2 = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGP);
        hashset1 = LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(selector, as, as1, as2), selector);
        if (hashset1.size() == 0)
        {
            hashset1.addAll(LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(new X509CRLStoreSelector(), as, as1, as2), selector));
        }
        hashset.addAll(hashset1);
        return hashset;
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
