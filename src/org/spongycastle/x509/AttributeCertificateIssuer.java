// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.AttCertIssuer;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuerSerial;
import org.spongycastle.asn1.x509.V2Form;
import org.spongycastle.util.Selector;

public class AttributeCertificateIssuer
    implements CertSelector, Selector
{

    private ASN1Encodable aPG;

    public AttributeCertificateIssuer(AttCertIssuer attcertissuer)
    {
        aPG = attcertissuer.ahS;
    }

    private static boolean _mth02CA(X500Principal x500principal, GeneralNames generalnames)
    {
        GeneralName ageneralname[];
        int i;
        ageneralname = new GeneralName[generalnames.ajb.length];
        System.arraycopy(generalnames.ajb, 0, ageneralname, 0, generalnames.ajb.length);
        i = 0;
_L2:
        if (i == ageneralname.length)
        {
            break; /* Loop/switch isn't completed */
        }
        generalnames = ageneralname[i];
        if (((GeneralName) (generalnames)).tag != 4)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        boolean flag = (new X500Principal(((GeneralName) (generalnames)).Wn._mth0427().getEncoded())).equals(x500principal);
        if (flag)
        {
            return true;
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return false;
        generalnames;
          goto _L3
    }

    private Object[] _mth1E7E()
    {
        IOException ioexception;
        Object obj;
        if (aPG instanceof V2Form)
        {
            obj = ((V2Form)aPG).ajZ;
        } else
        {
            obj = (GeneralNames)aPG;
        }
        GeneralName ageneralname[] = new GeneralName[((GeneralNames) (obj)).ajb.length];
        System.arraycopy(((GeneralNames) (obj)).ajb, 0, ageneralname, 0, ((GeneralNames) (obj)).ajb.length);
        obj = new ArrayList(ageneralname.length);
        for (int i = 0; i != ageneralname.length; i++)
        {
            if (ageneralname[i].tag != 4)
            {
                continue;
            }
            try
            {
                ((List) (obj)).add(new X500Principal(ageneralname[i].Wn._mth0427().getEncoded()));
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                throw new RuntimeException("badly formed Name object");
            }
        }

        return ((List) (obj)).toArray(new Object[((List) (obj)).size()]);
    }

    public Object clone()
    {
        return new AttributeCertificateIssuer(AttCertIssuer._mth05D9(aPG));
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof AttributeCertificateIssuer))
        {
            return false;
        } else
        {
            obj = (AttributeCertificateIssuer)obj;
            return aPG.equals(((AttributeCertificateIssuer) (obj)).aPG);
        }
    }

    public final Principal[] getPrincipals()
    {
        Object aobj[] = _mth1E7E();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i != aobj.length; i++)
        {
            if (aobj[i] instanceof Principal)
            {
                arraylist.add(aobj[i]);
            }
        }

        return (Principal[])arraylist.toArray(new Principal[arraylist.size()]);
    }

    public int hashCode()
    {
        return aPG.hashCode();
    }

    public boolean match(Certificate certificate)
    {
        if (!(certificate instanceof X509Certificate))
        {
            return false;
        }
        certificate = (X509Certificate)certificate;
        if (aPG instanceof V2Form)
        {
            Object obj = (V2Form)aPG;
            if (((V2Form) (obj)).ajg != null)
            {
                return (new BigInteger(((V2Form) (obj)).ajg.ajk.bytes)).equals(certificate.getSerialNumber()) && _mth02CA(certificate.getIssuerX500Principal(), ((V2Form) (obj)).ajg.ajj);
            }
            obj = ((V2Form) (obj)).ajZ;
            if (_mth02CA(certificate.getSubjectX500Principal(), ((GeneralNames) (obj))))
            {
                return true;
            }
        } else
        {
            GeneralNames generalnames = (GeneralNames)aPG;
            if (_mth02CA(certificate.getSubjectX500Principal(), generalnames))
            {
                return true;
            }
        }
        return false;
    }

    public final boolean _mth1D59(Object obj)
    {
        if (!(obj instanceof X509Certificate))
        {
            return false;
        } else
        {
            return match((Certificate)obj);
        }
    }
}
