// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.util.ASN1Dump;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.CRLNumber;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.asn1.x509.TBSCertList;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.asn1.x509.Time;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.jce.provider:
//            X509SignatureUtil, ExtCRLException, X509CRLEntryObject, RFC3280CertPathUtilities

public class X509CRLObject extends X509CRL
{

    private CertificateList aEL;
    private String aEM;
    private byte aEN[];
    private boolean aEO;
    private int agg;
    private boolean aiu;

    public X509CRLObject(CertificateList certificatelist)
    {
        aiu = false;
        aEL = certificatelist;
        try
        {
            aEM = X509SignatureUtil._mth02CA(certificatelist.aaE);
            if (certificatelist.aaE.ahQ != null)
            {
                aEN = certificatelist.aaE.ahQ._mth0427().getEncoded("DER");
                break MISSING_BLOCK_LABEL_64;
            }
        }
        // Misplaced declaration of an exception variable
        catch (CertificateList certificatelist)
        {
            throw new CRLException((new StringBuilder("CRL contents invalid: ")).append(certificatelist).toString());
        }
        aEN = null;
        aEO = _mth02CB(this);
        return;
    }

    static boolean _mth02CB(X509CRL x509crl)
    {
        boolean flag;
        try
        {
            x509crl = x509crl.getExtensionValue(Extension.aiK.identifier);
        }
        // Misplaced declaration of an exception variable
        catch (X509CRL x509crl)
        {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", x509crl);
        }
        if (x509crl == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        flag = IssuingDistributionPoint._mth06E6(ASN1OctetString.FB39(x509crl)._mth0501()).ajp;
        if (flag)
        {
            return true;
        }
        return false;
    }

    private HashSet _mth14A1(boolean flag)
    {
        if (getVersion() == 2)
        {
            Extensions extensions = aEL.ait.ajI;
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
            }
        }
        return null;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof X509CRL))
        {
            return false;
        }
        if (obj instanceof X509CRLObject)
        {
            obj = (X509CRLObject)obj;
            if (aiu && ((X509CRLObject) (obj)).aiu && ((X509CRLObject) (obj)).agg != agg)
            {
                return false;
            } else
            {
                return aEL.equals(((X509CRLObject) (obj)).aEL);
            }
        } else
        {
            return super.equals(obj);
        }
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
            abyte0 = aEL.getEncoded("DER");
        }
        catch (IOException ioexception)
        {
            throw new CRLException(ioexception.toString());
        }
        return abyte0;
    }

    public byte[] getExtensionValue(String s)
    {
        Extensions extensions = aEL.ait.ajI;
        if (extensions != null)
        {
            s = new ASN1ObjectIdentifier(s);
            s = (Extension)extensions.aiY.get(s);
            if (s != null)
            {
                try
                {
                    s = ((Extension) (s)).aiX.getEncoded();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new IllegalStateException((new StringBuilder("error parsing ")).append(s.toString()).toString());
                }
                return s;
            }
        }
        return null;
    }

    public Principal getIssuerDN()
    {
        return new X509Principal(X500Name._mth0131(aEL.ait.ajE._mth0427()));
    }

    public X500Principal getIssuerX500Principal()
    {
        IOException ioexception;
        X500Principal x500principal;
        try
        {
            x500principal = new X500Principal(aEL.ait.ajE.getEncoded());
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            throw new IllegalStateException("can't encode issuer DN");
        }
        return x500principal;
    }

    public Date getNextUpdate()
    {
        if (aEL.ait.ajG != null)
        {
            return aEL.ait.ajG.getDate();
        } else
        {
            return null;
        }
    }

    public Set getNonCriticalExtensionOIDs()
    {
        return _mth14A1(false);
    }

    public X509CRLEntry getRevokedCertificate(BigInteger biginteger)
    {
        Enumeration enumeration = aEL._mth0E01();
        Object obj1;
        for (Object obj = null; enumeration.hasMoreElements(); obj = obj1)
        {
            Object obj2 = (org.spongycastle.asn1.x509.TBSCertList.CRLEntry)enumeration.nextElement();
            if (biginteger.equals(new BigInteger(ASN1Integer.FB1D(((org.spongycastle.asn1.x509.TBSCertList.CRLEntry) (obj2)).adC._mth144B(0)).bytes)))
            {
                return new X509CRLEntryObject(((org.spongycastle.asn1.x509.TBSCertList.CRLEntry) (obj2)), aEO, ((X500Name) (obj)));
            }
            obj1 = obj;
            if (!aEO)
            {
                continue;
            }
            boolean flag;
            if (((org.spongycastle.asn1.x509.TBSCertList.CRLEntry) (obj2)).adC.size() == 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj1 = obj;
            if (!flag)
            {
                continue;
            }
            obj1 = ((org.spongycastle.asn1.x509.TBSCertList.CRLEntry) (obj2))._mth142F();
            obj2 = Extension.aiL;
            obj2 = (Extension)((Extensions) (obj1)).aiY.get(obj2);
            obj1 = obj;
            if (obj2 != null)
            {
                obj = GeneralNames._mth05D5(Extension._mth02CA(((Extension) (obj2))));
                obj1 = new GeneralName[((GeneralNames) (obj)).ajb.length];
                System.arraycopy(((GeneralNames) (obj)).ajb, 0, obj1, 0, ((GeneralNames) (obj)).ajb.length);
                obj1 = X500Name._mth0131(((GeneralName) (obj1[0])).Wn);
            }
        }

        return null;
    }

    public Set getRevokedCertificates()
    {
        HashSet hashset = new HashSet();
        Enumeration enumeration = aEL._mth0E01();
        Object obj1;
        for (Object obj = null; enumeration.hasMoreElements(); obj = obj1)
        {
            Object obj2 = (org.spongycastle.asn1.x509.TBSCertList.CRLEntry)enumeration.nextElement();
            hashset.add(new X509CRLEntryObject(((org.spongycastle.asn1.x509.TBSCertList.CRLEntry) (obj2)), aEO, ((X500Name) (obj))));
            obj1 = obj;
            if (!aEO)
            {
                continue;
            }
            boolean flag;
            if (((org.spongycastle.asn1.x509.TBSCertList.CRLEntry) (obj2)).adC.size() == 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj1 = obj;
            if (!flag)
            {
                continue;
            }
            obj1 = ((org.spongycastle.asn1.x509.TBSCertList.CRLEntry) (obj2))._mth142F();
            obj2 = Extension.aiL;
            obj2 = (Extension)((Extensions) (obj1)).aiY.get(obj2);
            obj1 = obj;
            if (obj2 != null)
            {
                obj = GeneralNames._mth05D5(Extension._mth02CA(((Extension) (obj2))));
                obj1 = new GeneralName[((GeneralNames) (obj)).ajb.length];
                System.arraycopy(((GeneralNames) (obj)).ajb, 0, obj1, 0, ((GeneralNames) (obj)).ajb.length);
                obj1 = X500Name._mth0131(((GeneralName) (obj1[0])).Wn);
            }
        }

        if (!hashset.isEmpty())
        {
            return Collections.unmodifiableSet(hashset);
        } else
        {
            return null;
        }
    }

    public String getSigAlgName()
    {
        return aEM;
    }

    public String getSigAlgOID()
    {
        return (new ASN1ObjectIdentifier(aEL.aaE.ahP.identifier)).identifier;
    }

    public byte[] getSigAlgParams()
    {
        if (aEN != null)
        {
            byte abyte0[] = new byte[aEN.length];
            System.arraycopy(aEN, 0, abyte0, 0, abyte0.length);
            return abyte0;
        } else
        {
            return null;
        }
    }

    public byte[] getSignature()
    {
        return aEL.ais.getBytes();
    }

    public byte[] getTBSCertList()
    {
        byte abyte0[];
        try
        {
            abyte0 = aEL.ait.getEncoded("DER");
        }
        catch (IOException ioexception)
        {
            throw new CRLException(ioexception.toString());
        }
        return abyte0;
    }

    public Date getThisUpdate()
    {
        return aEL.ait.ajF.getDate();
    }

    public int getVersion()
    {
        return aEL._mth10D9();
    }

    public boolean hasUnsupportedCriticalExtension()
    {
        Set set = getCriticalExtensionOIDs();
        if (set == null)
        {
            return false;
        }
        set.remove(RFC3280CertPathUtilities.aHr);
        set.remove(RFC3280CertPathUtilities.aHQ);
        return !set.isEmpty();
    }

    public int hashCode()
    {
        if (!aiu)
        {
            aiu = true;
            agg = super.hashCode();
        }
        return agg;
    }

    public boolean isRevoked(Certificate certificate)
    {
        if (!certificate.getType().equals("X.509"))
        {
            throw new RuntimeException("X.509 CRL used with non X.509 Cert");
        }
        Enumeration enumeration = aEL._mth0E01();
        Object obj1 = aEL.ait.ajE;
        if (enumeration != null)
        {
            BigInteger biginteger = ((X509Certificate)certificate).getSerialNumber();
            while (enumeration.hasMoreElements()) 
            {
                org.spongycastle.asn1.x509.TBSCertList.CRLEntry crlentry = org.spongycastle.asn1.x509.TBSCertList.CRLEntry._mth1424(enumeration.nextElement());
                Object obj = obj1;
                if (aEO)
                {
                    boolean flag;
                    if (crlentry.adC.size() == 3)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    obj = obj1;
                    if (flag)
                    {
                        obj = crlentry._mth142F();
                        Object obj2 = Extension.aiL;
                        obj2 = (Extension)((Extensions) (obj)).aiY.get(obj2);
                        obj = obj1;
                        if (obj2 != null)
                        {
                            obj = GeneralNames._mth05D5(Extension._mth02CA(((Extension) (obj2))));
                            obj1 = new GeneralName[((GeneralNames) (obj)).ajb.length];
                            System.arraycopy(((GeneralNames) (obj)).ajb, 0, obj1, 0, ((GeneralNames) (obj)).ajb.length);
                            obj = X500Name._mth0131(obj1[0].Wn);
                        }
                    }
                }
                if ((new BigInteger(ASN1Integer.FB1D(crlentry.adC._mth144B(0)).bytes)).equals(biginteger))
                {
                    if (certificate instanceof X509Certificate)
                    {
                        certificate = X500Name._mth0131(((X509Certificate)certificate).getIssuerX500Principal().getEncoded());
                    } else
                    {
                        try
                        {
                            certificate = org.spongycastle.asn1.x509.Certificate._mth02B2(certificate.getEncoded()).air.ajE;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Certificate certificate)
                        {
                            throw new RuntimeException("Cannot process certificate");
                        }
                    }
                    return ((X500Name) (obj)).equals(certificate);
                }
                obj1 = obj;
            }
        }
        return false;
    }

    public String toString()
    {
        StringBuffer stringbuffer;
        String s;
        Extensions extensions;
        stringbuffer = new StringBuffer();
        s = System.getProperty("line.separator");
        stringbuffer.append("              Version: ").append(getVersion()).append(s);
        stringbuffer.append("             IssuerDN: ").append(getIssuerDN()).append(s);
        stringbuffer.append("          This update: ").append(getThisUpdate()).append(s);
        stringbuffer.append("          Next update: ").append(getNextUpdate()).append(s);
        stringbuffer.append("  Signature Algorithm: ").append(getSigAlgName()).append(s);
        byte abyte0[] = getSignature();
        stringbuffer.append("            Signature: ").append(new String(Hex.FF70(abyte0, 0, 20))).append(s);
        for (int i = 20; i < abyte0.length; i += 20)
        {
            if (i < abyte0.length - 20)
            {
                stringbuffer.append("                       ").append(new String(Hex.FF70(abyte0, i, 20))).append(s);
            } else
            {
                stringbuffer.append("                       ").append(new String(Hex.FF70(abyte0, i, abyte0.length - i))).append(s);
            }
        }

        extensions = aEL.ait.ajI;
        if (extensions == null) goto _L2; else goto _L1
_L1:
        Enumeration enumeration;
        enumeration = extensions.aiZ.elements();
        if (enumeration.hasMoreElements())
        {
            stringbuffer.append("           Extensions: ").append(s);
        }
_L3:
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
            break MISSING_BLOCK_LABEL_638;
        }
        asn1inputstream = new ASN1InputStream(extension.aiX._mth0501());
        stringbuffer.append("                       critical(").append(extension.aiW).append(") ");
        if (asn1objectidentifier.equals(Extension.aiH))
        {
            stringbuffer.append(new CRLNumber(new BigInteger(1, ASN1Integer.FB1D(asn1inputstream._mth04B7()).bytes))).append(s);
            continue; /* Loop/switch isn't completed */
        }
        if (asn1objectidentifier.equals(Extension.aiJ))
        {
            stringbuffer.append((new StringBuilder("Base CRL: ")).append(new CRLNumber(new BigInteger(1, ASN1Integer.FB1D(asn1inputstream._mth04B7()).bytes))).toString()).append(s);
            continue; /* Loop/switch isn't completed */
        }
        if (asn1objectidentifier.equals(Extension.aiK))
        {
            stringbuffer.append(IssuingDistributionPoint._mth06E6(asn1inputstream._mth04B7())).append(s);
            continue; /* Loop/switch isn't completed */
        }
        if (asn1objectidentifier.equals(Extension.aiN))
        {
            stringbuffer.append(CRLDistPoint._mth02BE(asn1inputstream._mth04B7())).append(s);
            continue; /* Loop/switch isn't completed */
        }
        if (asn1objectidentifier.equals(Extension.aiT))
        {
            stringbuffer.append(CRLDistPoint._mth02BE(asn1inputstream._mth04B7())).append(s);
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
        if (true) goto _L3; else goto _L2
_L2:
        Exception exception;
        Object obj = getRevokedCertificates();
        if (obj != null)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuffer.append(s))
            {
                stringbuffer.append(((Iterator) (obj)).next());
            }

        }
        return stringbuffer.toString();
    }

    public void verify(PublicKey publickey)
    {
        verify(publickey, "SC");
    }

    public void verify(PublicKey publickey, String s)
    {
        if (!aEL.aaE.equals(aEL.ait.aid))
        {
            throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
        }
        if (s != null)
        {
            s = Signature.getInstance(getSigAlgName(), s);
        } else
        {
            s = Signature.getInstance(getSigAlgName());
        }
        s.initVerify(publickey);
        s.update(getTBSCertList());
        if (!s.verify(getSignature()))
        {
            throw new SignatureException("CRL does not verify with supplied public key.");
        } else
        {
            return;
        }
    }
}
