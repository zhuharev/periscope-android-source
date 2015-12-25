// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreSpi;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.naming.directory.DirContext;
import javax.security.auth.x500.X500Principal;

public class X509LDAPCertStoreSpi extends CertStoreSpi
{

    private static String aIf = "com.sun.jndi.ldap.LdapCtxFactory";
    private static String aIg = "ignore";

    private HashSet _mth02CA(String s, String s1, String as[])
    {
        s1 = (new StringBuilder()).append(s).append("=").append(s1).toString();
        if (s == null)
        {
            s1 = null;
        }
        new HashSet();
        try
        {
            s = new Properties();
            s.setProperty("java.naming.factory.initial", aIf);
            s.setProperty("java.naming.batchsize", "0");
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        finally
        {
            if (true) goto _L0; else goto _L0
        }
        throw new CertStoreException((new StringBuilder("Error getting results from LDAP directory ")).append(s).toString());
        try
        {
            null.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        throw s;
    }

    private HashSet _mth02CA(X509CertSelector x509certselector, String as[], String s, String s1)
    {
        HashSet hashset;
        hashset = new HashSet();
        String s2;
        String s3;
        try
        {
            if (x509certselector.getSubjectAsBytes() == null && x509certselector.getSubjectAsString() == null && x509certselector.getCertificate() == null)
            {
                break MISSING_BLOCK_LABEL_163;
            }
        }
        // Misplaced declaration of an exception variable
        catch (X509CertSelector x509certselector)
        {
            throw new CertStoreException((new StringBuilder("exception processing selector: ")).append(x509certselector).toString());
        }
        s2 = null;
        if (x509certselector.getCertificate() == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        s2 = x509certselector.getCertificate().getSubjectX500Principal().getName("RFC1779");
        s3 = x509certselector.getCertificate().getSerialNumber().toString();
        x509certselector = s2;
        s2 = s3;
        break MISSING_BLOCK_LABEL_108;
        if (x509certselector.getSubjectAsBytes() != null)
        {
            x509certselector = (new X500Principal(x509certselector.getSubjectAsBytes())).getName("RFC1779");
            break MISSING_BLOCK_LABEL_108;
        }
        x509certselector = x509certselector.getSubjectAsString();
        x509certselector = _mth0559(x509certselector, s1);
        hashset.addAll(_mth02CA(s, (new StringBuilder("*")).append(x509certselector).append("*").toString(), as));
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        throw new NullPointerException();
        hashset.addAll(_mth02CA(s, "*", as));
        return hashset;
        return hashset;
    }

    private static String _mth0559(String s, String s1)
    {
        int i = s.toLowerCase().indexOf(s1.toLowerCase());
        s = s.substring(s1.length() + i);
        int j = s.indexOf(',');
        i = j;
        if (j == -1)
        {
            i = s.length();
        }
        do
        {
            if (s.charAt(i - 1) != '\\')
            {
                break;
            }
            int k = s.indexOf(',', i + 1);
            i = k;
            if (k == -1)
            {
                i = s.length();
            }
        } while (true);
        s = s.substring(0, i);
        s1 = s.substring(s.indexOf('=') + 1);
        s = s1;
        if (s1.charAt(0) == ' ')
        {
            s = s1.substring(1);
        }
        s1 = s;
        if (s.startsWith("\""))
        {
            s1 = s.substring(1);
        }
        s = s1;
        if (s1.endsWith("\""))
        {
            s = s1.substring(0, s1.length() - 1);
        }
        return s;
    }

    public Collection engineGetCRLs(CRLSelector crlselector)
    {
        crlselector = new String[1];
        throw new NullPointerException();
    }

    public Collection engineGetCertificates(CertSelector certselector)
    {
        if (!(certselector instanceof X509CertSelector))
        {
            throw new CertStoreException("selector is not a X509CertSelector");
        } else
        {
            certselector = (X509CertSelector)certselector;
            new HashSet();
            certselector = new String[1];
            throw new NullPointerException();
        }
    }

}
