// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.extension.X509ExtensionUtil;

// Referenced classes of package org.spongycastle.x509:
//            X509AttributeCertificate

public class X509CRLStoreSelector extends X509CRLSelector
    implements Selector
{

    public boolean aQb;
    public boolean aQc;
    public BigInteger aQd;
    public byte aQe[];
    public boolean aQf;
    public X509AttributeCertificate aQg;

    public X509CRLStoreSelector()
    {
        aQb = false;
        aQc = false;
        aQd = null;
        aQe = null;
        aQf = false;
    }

    private static X509CRLStoreSelector _mth02CA(X509CRLStoreSelector x509crlstoreselector)
    {
        if (x509crlstoreselector == null)
        {
            throw new IllegalArgumentException("cannot create from null selector");
        }
        X509CRLStoreSelector x509crlstoreselector1 = new X509CRLStoreSelector();
        x509crlstoreselector1.setCertificateChecking(x509crlstoreselector.getCertificateChecking());
        x509crlstoreselector1.setDateAndTime(x509crlstoreselector.getDateAndTime());
        try
        {
            x509crlstoreselector1.setIssuerNames(x509crlstoreselector.getIssuerNames());
        }
        // Misplaced declaration of an exception variable
        catch (X509CRLStoreSelector x509crlstoreselector)
        {
            throw new IllegalArgumentException(x509crlstoreselector.getMessage());
        }
        x509crlstoreselector1.setIssuers(x509crlstoreselector.getIssuers());
        x509crlstoreselector1.setMaxCRLNumber(x509crlstoreselector.getMaxCRL());
        x509crlstoreselector1.setMinCRLNumber(x509crlstoreselector.getMinCRL());
        return x509crlstoreselector1;
    }

    public Object clone()
    {
        X509CRLStoreSelector x509crlstoreselector = _mth02CA(this);
        x509crlstoreselector.aQb = aQb;
        x509crlstoreselector.aQc = aQc;
        x509crlstoreselector.aQd = aQd;
        x509crlstoreselector.aQg = aQg;
        x509crlstoreselector.aQf = aQf;
        x509crlstoreselector.aQe = Arrays._mth1D4C(aQe);
        return x509crlstoreselector;
    }

    public boolean match(CRL crl)
    {
        return _mth1D59(crl);
    }

    public final boolean _mth1D59(Object obj)
    {
        ASN1Integer asn1integer;
        X509CRL x509crl;
        if (!(obj instanceof X509CRL))
        {
            return false;
        }
        x509crl = (X509CRL)obj;
        asn1integer = null;
        byte abyte1[];
        try
        {
            abyte1 = x509crl.getExtensionValue(X509Extensions.akh.identifier);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (abyte1 == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        asn1integer = ASN1Integer.FB1D(X509ExtensionUtil.FE74(abyte1));
        if (aQb && asn1integer == null)
        {
            return false;
        }
        if (aQc && asn1integer != null)
        {
            return false;
        }
        if (asn1integer != null && aQd != null && (new BigInteger(1, asn1integer.bytes)).compareTo(aQd) == 1)
        {
            return false;
        }
        if (aQf)
        {
            byte abyte0[] = x509crl.getExtensionValue(X509Extensions.aki.identifier);
            if (aQe == null)
            {
                if (abyte0 != null)
                {
                    return false;
                }
            } else
            if (!Arrays._mth1427(abyte0, aQe))
            {
                return false;
            }
        }
        return super.match((X509CRL)obj);
    }
}
