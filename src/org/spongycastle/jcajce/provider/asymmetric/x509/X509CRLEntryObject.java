// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.util.ASN1Dump;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.CRLReason;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.Time;
import org.spongycastle.asn1.x509.X509Extension;

public class X509CRLEntryObject extends X509CRLEntry
{

    private org.spongycastle.asn1.x509.TBSCertList.CRLEntry aEH;
    private X500Name aEI;
    private int aEJ;
    private boolean aEK;

    protected X509CRLEntryObject(org.spongycastle.asn1.x509.TBSCertList.CRLEntry crlentry, boolean flag, X500Name x500name)
    {
        aEH = crlentry;
        aEI = _mth02CA(flag, x500name);
    }

    private X500Name _mth02CA(boolean flag, X500Name x500name)
    {
        if (!flag)
        {
            return null;
        }
        Object obj = Extension.aiL;
        Extensions extensions = aEH._mth142F();
        if (extensions != null)
        {
            obj = (Extension)extensions.aiY.get(obj);
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            return x500name;
        }
        GeneralName ageneralname[];
        int i;
        try
        {
            x500name = GeneralNames._mth05D5(Extension._mth02CA(((Extension) (obj))));
            ageneralname = new GeneralName[((GeneralNames) (x500name)).ajb.length];
            System.arraycopy(((GeneralNames) (x500name)).ajb, 0, ageneralname, 0, ((GeneralNames) (x500name)).ajb.length);
        }
        // Misplaced declaration of an exception variable
        catch (X500Name x500name)
        {
            return null;
        }
        i = 0;
        if (i >= ageneralname.length)
        {
            break;
        }
        if (ageneralname[i].tag != 4)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        x500name = X500Name._mth0131(ageneralname[i].Wn);
        return x500name;
        for (i++; true;)
        {
            break MISSING_BLOCK_LABEL_83;
        }

        return null;
    }

    private HashSet _mth14A1(boolean flag)
    {
        Extensions extensions = aEH._mth142F();
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
                if (flag == ((Extension)extensions.aiY.get(asn1objectidentifier)).aiW)
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

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof X509CRLEntryObject)
        {
            obj = (X509CRLEntryObject)obj;
            return aEH.equals(((X509CRLEntryObject) (obj)).aEH);
        } else
        {
            return super.equals(this);
        }
    }

    public X500Principal getCertificateIssuer()
    {
        IOException ioexception;
        if (aEI == null)
        {
            return null;
        }
        X500Principal x500principal;
        try
        {
            x500principal = new X500Principal(aEI.getEncoded());
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return null;
        }
        return x500principal;
    }

    public Set getCriticalExtensionOIDs()
    {
        return _mth14A1(true);
    }

    public byte[] getEncoded()
    {
        byte abyte0[];
        try
        {
            abyte0 = aEH.getEncoded("DER");
        }
        catch (IOException ioexception)
        {
            throw new CRLException(ioexception.toString());
        }
        return abyte0;
    }

    public byte[] getExtensionValue(String s)
    {
        s = new ASN1ObjectIdentifier(s);
        Extensions extensions = aEH._mth142F();
        if (extensions != null)
        {
            s = (Extension)extensions.aiY.get(s);
        } else
        {
            s = null;
        }
        if (s != null)
        {
            try
            {
                s = ((Extension) (s)).aiX.getEncoded();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException((new StringBuilder("error encoding ")).append(s.toString()).toString());
            }
            return s;
        } else
        {
            return null;
        }
    }

    public Set getNonCriticalExtensionOIDs()
    {
        return _mth14A1(false);
    }

    public Date getRevocationDate()
    {
        return Time._mth02E1(aEH.adC._mth144B(1)).getDate();
    }

    public BigInteger getSerialNumber()
    {
        return new BigInteger(ASN1Integer.FB1D(aEH.adC._mth144B(0)).bytes);
    }

    public boolean hasExtensions()
    {
        return aEH._mth142F() != null;
    }

    public boolean hasUnsupportedCriticalExtension()
    {
        Set set = getCriticalExtensionOIDs();
        return set != null && !set.isEmpty();
    }

    public int hashCode()
    {
        if (!aEK)
        {
            aEJ = super.hashCode();
            aEK = true;
        }
        return aEJ;
    }

    public String toString()
    {
        StringBuffer stringbuffer;
        String s;
        Extensions extensions;
        stringbuffer = new StringBuffer();
        s = System.getProperty("line.separator");
        stringbuffer.append("      userCertificate: ").append(getSerialNumber()).append(s);
        stringbuffer.append("       revocationDate: ").append(getRevocationDate()).append(s);
        stringbuffer.append("       certificateIssuer: ").append(getCertificateIssuer()).append(s);
        extensions = aEH._mth142F();
        if (extensions == null) goto _L2; else goto _L1
_L1:
        Enumeration enumeration = extensions.aiZ.elements();
        if (!enumeration.hasMoreElements()) goto _L2; else goto _L3
_L3:
        stringbuffer.append("   crlEntryExtensions:").append(s);
_L4:
        ASN1ObjectIdentifier asn1objectidentifier;
        ASN1InputStream asn1inputstream;
        if (!enumeration.hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        asn1objectidentifier = (ASN1ObjectIdentifier)enumeration.nextElement();
        Extension extension = (Extension)extensions.aiY.get(asn1objectidentifier);
        if (extension.aiX == null)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        asn1inputstream = new ASN1InputStream(extension.aiX._mth0501());
        stringbuffer.append("                       critical(").append(extension.aiW).append(") ");
        if (asn1objectidentifier.equals(X509Extension.aiI))
        {
            stringbuffer.append(CRLReason._mth02CA(ASN1Enumerated._mth1D63(asn1inputstream._mth04B7()))).append(s);
            continue; /* Loop/switch isn't completed */
        }
        if (asn1objectidentifier.equals(X509Extension.aiL))
        {
            stringbuffer.append("Certificate issuer: ").append(GeneralNames._mth05D5(asn1inputstream._mth04B7())).append(s);
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            stringbuffer.append(asn1objectidentifier.identifier);
            stringbuffer.append(" value = ").append(ASN1Dump.FF9E(asn1inputstream._mth04B7())).append(s);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            stringbuffer.append(asn1objectidentifier.identifier);
            stringbuffer.append(" value = *****").append(s);
        }
        continue; /* Loop/switch isn't completed */
        stringbuffer.append(s);
        if (true) goto _L4; else goto _L2
_L2:
        Exception exception;
        return stringbuffer.toString();
    }
}
