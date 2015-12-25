// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AttCertValidityPeriod;
import org.spongycastle.asn1.x509.Attribute;
import org.spongycastle.asn1.x509.AttributeCertificate;
import org.spongycastle.asn1.x509.AttributeCertificateInfo;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.x509:
//            X509AttributeCertificate, X509Attribute, AttributeCertificateHolder, AttributeCertificateIssuer

public class X509V2AttributeCertificate
    implements X509AttributeCertificate
{

    private AttributeCertificate aQs;
    private Date aQt;
    private Date aQu;

    private X509V2AttributeCertificate(ByteArrayInputStream bytearrayinputstream)
    {
        this(_mth0640(bytearrayinputstream));
    }

    private X509V2AttributeCertificate(AttributeCertificate attributecertificate)
    {
        aQs = attributecertificate;
        try
        {
            aQu = attributecertificate.ahY.aif.ahV.getDate();
            aQt = attributecertificate.ahY.aif.ahU.getDate();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AttributeCertificate attributecertificate)
        {
            throw new IOException("invalid data structure in certificate!");
        }
    }

    public X509V2AttributeCertificate(byte abyte0[])
    {
        this(new ByteArrayInputStream(abyte0));
    }

    private static AttributeCertificate _mth0640(InputStream inputstream)
    {
        try
        {
            inputstream = AttributeCertificate._mth02BD((new ASN1InputStream(inputstream))._mth04B7());
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IOException((new StringBuilder("exception decoding certificate structure: ")).append(inputstream.toString()).toString());
        }
        return inputstream;
    }

    private HashSet _mth14A1(boolean flag)
    {
        Extensions extensions = aQs.ahY.aii;
        if (extensions != null)
        {
            HashSet hashset = new HashSet();
            Enumeration enumeration = extensions.aiZ.elements();
            do
            {
                if (!enumeration.hasMoreElements())
                {
                    break;
                }
                ASN1ObjectIdentifier asn1objectidentifier = (ASN1ObjectIdentifier)enumeration.nextElement();
                if (((Extension)extensions.aiY.get(asn1objectidentifier)).aiW == flag)
                {
                    hashset.add(asn1objectidentifier.identifier);
                }
            } while (true);
            return hashset;
        } else
        {
            return null;
        }
    }

    public final void checkValidity(Date date)
    {
        if (date.after(aQu))
        {
            throw new CertificateExpiredException((new StringBuilder("certificate expired on ")).append(aQu).toString());
        }
        if (date.before(aQt))
        {
            throw new CertificateNotYetValidException((new StringBuilder("certificate not valid till ")).append(aQt).toString());
        } else
        {
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof X509AttributeCertificate))
        {
            return false;
        }
        obj = (X509AttributeCertificate)obj;
        boolean flag;
        try
        {
            flag = Arrays._mth1427(aQs.getEncoded(), ((X509AttributeCertificate) (obj)).getEncoded());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return flag;
    }

    public Set getCriticalExtensionOIDs()
    {
        return _mth14A1(true);
    }

    public final byte[] getEncoded()
    {
        return aQs.getEncoded();
    }

    public byte[] getExtensionValue(String s)
    {
        Extensions extensions = aQs.ahY.aii;
        if (extensions != null)
        {
            s = new ASN1ObjectIdentifier(s);
            s = (Extension)extensions.aiY.get(s);
            if (s != null)
            {
                try
                {
                    s = ((Extension) (s)).aiX.getEncoded("DER");
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new RuntimeException((new StringBuilder("error encoding ")).append(s.toString()).toString());
                }
                return s;
            }
        }
        return null;
    }

    public Set getNonCriticalExtensionOIDs()
    {
        return _mth14A1(false);
    }

    public final Date getNotAfter()
    {
        return aQu;
    }

    public final BigInteger getSerialNumber()
    {
        return new BigInteger(aQs.ahY.aie.bytes);
    }

    public boolean hasUnsupportedCriticalExtension()
    {
        Set set = getCriticalExtensionOIDs();
        return set != null && !set.isEmpty();
    }

    public int hashCode()
    {
        IOException ioexception;
        int i;
        try
        {
            i = Arrays.hashCode(aQs.getEncoded());
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return 0;
        }
        return i;
    }

    public final X509Attribute[] _mth02BA(String s)
    {
        ASN1Sequence asn1sequence = aQs.ahY.aig;
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i != asn1sequence.size(); i++)
        {
            X509Attribute x509attribute = new X509Attribute(asn1sequence._mth144B(i));
            if ((new ASN1ObjectIdentifier(x509attribute.aPT.ahW.identifier)).identifier.equals(s))
            {
                arraylist.add(x509attribute);
            }
        }

        if (arraylist.size() == 0)
        {
            return null;
        } else
        {
            return (X509Attribute[])arraylist.toArray(new X509Attribute[arraylist.size()]);
        }
    }

    public final AttributeCertificateHolder _mth1F59()
    {
        return new AttributeCertificateHolder((ASN1Sequence)aQs.ahY.aib._mth0427());
    }

    public final AttributeCertificateIssuer _mth1FE8()
    {
        return new AttributeCertificateIssuer(aQs.ahY.aic);
    }
}
