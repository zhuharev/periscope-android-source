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
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509StoreParameters;
import org.spongycastle.x509.X509StoreSpi;
import org.spongycastle.x509.util.LDAPStoreHelper;

public class X509StoreLDAPAttrCerts extends X509StoreSpi
{

    private LDAPStoreHelper aIi;

    public X509StoreLDAPAttrCerts()
    {
    }

    public final Collection _mth02CA(Selector selector)
    {
        if (!(selector instanceof X509AttributeCertStoreSelector))
        {
            return Collections.EMPTY_SET;
        }
        selector = (X509AttributeCertStoreSelector)selector;
        HashSet hashset = new HashSet();
        LDAPStoreHelper ldapstorehelper = aIi;
        String as[] = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGx);
        String as1[] = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGI);
        String as2[] = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGT);
        HashSet hashset1 = LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(selector, as, as1, as2), selector);
        if (hashset1.size() == 0)
        {
            hashset1.addAll(LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(new X509AttributeCertStoreSelector(), as, as1, as2), selector));
        }
        hashset.addAll(hashset1);
        ldapstorehelper = aIi;
        as = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGw);
        as1 = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGH);
        as2 = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGS);
        hashset1 = LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(selector, as, as1, as2), selector);
        if (hashset1.size() == 0)
        {
            hashset1.addAll(LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(new X509AttributeCertStoreSelector(), as, as1, as2), selector));
        }
        hashset.addAll(hashset1);
        ldapstorehelper = aIi;
        as = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGy);
        as1 = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGJ);
        as2 = LDAPStoreHelper._mth0399(ldapstorehelper.aQy.aGU);
        hashset1 = LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(selector, as, as1, as2), selector);
        if (hashset1.size() == 0)
        {
            hashset1.addAll(LDAPStoreHelper._mth02CA(ldapstorehelper._mth02CA(new X509AttributeCertStoreSelector(), as, as1, as2), selector));
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
