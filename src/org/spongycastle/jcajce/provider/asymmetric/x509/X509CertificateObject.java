// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.asn1.misc.NetscapeCertType;
import org.spongycastle.asn1.misc.NetscapeRevocationURL;
import org.spongycastle.asn1.misc.VerisignCzagExtension;
import org.spongycastle.asn1.util.ASN1Dump;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.style.RFC4519Style;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.KeyUsage;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.asn1.x509.Time;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.RFC3280CertPathUtilities;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.x509:
//            X509SignatureUtil

class X509CertificateObject extends X509Certificate
    implements PKCS12BagAttributeCarrier
{

    private PKCS12BagAttributeCarrierImpl aDG;
    private int aEJ;
    private Certificate aEP;
    private BasicConstraints aEQ;
    private boolean aER[];
    private boolean aES;

    public X509CertificateObject(Certificate certificate)
    {
        aDG = new PKCS12BagAttributeCarrierImpl();
        aEP = certificate;
        try
        {
            certificate = _mth1601("2.5.29.19");
        }
        // Misplaced declaration of an exception variable
        catch (Certificate certificate)
        {
            throw new CertificateParsingException((new StringBuilder("cannot construct BasicConstraints: ")).append(certificate).toString());
        }
        if (certificate == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        aEQ = BasicConstraints._mth1FBE(ASN1Primitive._mth0640(certificate));
        boolean aflag[];
        int i;
        int j;
        try
        {
            certificate = _mth1601("2.5.29.15");
        }
        // Misplaced declaration of an exception variable
        catch (Certificate certificate)
        {
            throw new CertificateParsingException((new StringBuilder("cannot construct KeyUsage: ")).append(certificate).toString());
        }
        if (certificate == null) goto _L2; else goto _L1
_L1:
        DERBitString derbitstring = DERBitString._mth14BD(ASN1Primitive._mth0640(certificate));
        certificate = derbitstring.getBytes();
        j = (certificate.length << 3) - derbitstring._mth06B9();
        if (j < 9)
        {
            i = 9;
        } else
        {
            i = j;
        }
        aER = new boolean[i];
        i = 0;
_L4:
        if (i == j)
        {
            break; /* Loop/switch isn't completed */
        }
        aflag = aER;
        break MISSING_BLOCK_LABEL_138;
_L2:
        aER = null;
        return;
        boolean flag;
        if ((certificate[i / 8] & 128 >>> i % 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aflag[i] = flag;
        i++;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void _mth02CA(PublicKey publickey, Signature signature)
    {
        if (!_mth02CA(aEP.aaE, aEP.air.aid))
        {
            throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
        }
        X509SignatureUtil._mth02CA(signature, aEP.aaE.ahQ);
        signature.initVerify(publickey);
        signature.update(getTBSCertificate());
        if (!signature.verify(getSignature()))
        {
            throw new SignatureException("certificate does not verify with supplied key");
        } else
        {
            return;
        }
    }

    private static boolean _mth02CA(AlgorithmIdentifier algorithmidentifier, AlgorithmIdentifier algorithmidentifier1)
    {
        if (!(new ASN1ObjectIdentifier(algorithmidentifier.ahP.identifier)).equals(new ASN1ObjectIdentifier(algorithmidentifier1.ahP.identifier)))
        {
            return false;
        }
        if (algorithmidentifier.ahQ == null)
        {
            return algorithmidentifier1.ahQ == null || algorithmidentifier1.ahQ.equals(DERNull.WL);
        }
        if (algorithmidentifier1.ahQ == null)
        {
            return algorithmidentifier.ahQ == null || algorithmidentifier.ahQ.equals(DERNull.WL);
        } else
        {
            return algorithmidentifier.ahQ.equals(algorithmidentifier1.ahQ);
        }
    }

    private byte[] _mth1601(String s)
    {
        Extensions extensions = aEP.air.aii;
        if (extensions != null)
        {
            s = new ASN1ObjectIdentifier(s);
            s = (Extension)extensions.aiY.get(s);
            if (s != null)
            {
                return ((Extension) (s)).aiX._mth0501();
            }
        }
        return null;
    }

    private int _mth1605()
    {
        int j = 0;
        byte abyte0[];
        int i;
        byte byte0;
        try
        {
            abyte0 = getEncoded();
        }
        // Misplaced declaration of an exception variable
        catch (CertificateEncodingException certificateencodingexception)
        {
            return 0;
        }
        i = 1;
        CertificateEncodingException certificateencodingexception;
        while (i < abyte0.length) 
        {
            byte0 = abyte0[i];
            j += byte0 * i;
            i++;
        }
        return j;
    }

    private static Collection FF9F(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        ArrayList arraylist;
        arraylist = new ArrayList();
        abyte0 = ASN1Sequence._mth141F(abyte0)._mth0675();
_L10:
        if (!abyte0.hasMoreElements()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist1;
        Object obj;
        obj = GeneralName._mth02E3(abyte0.nextElement());
        arraylist1 = new ArrayList();
        arraylist1.add(Integers.valueOf(((GeneralName) (obj)).tag));
        ((GeneralName) (obj)).tag;
        JVM INSTR tableswitch 0 8: default 312
    //                   0 116
    //                   1 153
    //                   2 153
    //                   3 116
    //                   4 130
    //                   5 116
    //                   6 153
    //                   7 195
    //                   8 175;
           goto _L3 _L4 _L5 _L5 _L4 _L6 _L4 _L5 _L7 _L8
_L4:
        arraylist1.add(((GeneralName) (obj)).getEncoded());
        break; /* Loop/switch isn't completed */
_L6:
        int i;
        try
        {
            arraylist1.add(X500Name._mth02CA(RFC4519Style.ahO, ((GeneralName) (obj)).Wn).toString());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new CertificateParsingException(abyte0.getMessage());
        }
        break; /* Loop/switch isn't completed */
_L5:
        arraylist1.add(((ASN1String)((GeneralName) (obj)).Wn).getString());
        break; /* Loop/switch isn't completed */
_L8:
        arraylist1.add(ASN1ObjectIdentifier._mth02CE(((GeneralName) (obj)).Wn).identifier);
        break; /* Loop/switch isn't completed */
_L7:
        obj = DEROctetString.FB39(((GeneralName) (obj)).Wn)._mth0501();
        obj = InetAddress.getByAddress(((byte []) (obj))).getHostAddress();
        arraylist1.add(obj);
        break; /* Loop/switch isn't completed */
_L3:
        throw new IOException((new StringBuilder("Bad tag number: ")).append(((GeneralName) (obj)).tag).toString());
        arraylist.add(Collections.unmodifiableList(arraylist1));
        continue; /* Loop/switch isn't completed */
_L2:
        i = arraylist.size();
        if (i == 0)
        {
            return null;
        }
        abyte0 = Collections.unmodifiableCollection(arraylist);
        return abyte0;
        UnknownHostException unknownhostexception;
        unknownhostexception;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void checkValidity()
    {
        checkValidity(new Date());
    }

    public void checkValidity(Date date)
    {
        if (date.getTime() > getNotAfter().getTime())
        {
            StringBuilder stringbuilder = new StringBuilder("certificate expired on ");
            date = aEP.air.ajN;
            if (((Time) (date)).ajW instanceof ASN1UTCTime)
            {
                date = ((ASN1UTCTime)((Time) (date)).ajW)._mth0695();
            } else
            {
                date = ((ASN1GeneralizedTime)((Time) (date)).ajW)._mth0437();
            }
            throw new CertificateExpiredException(stringbuilder.append(date).toString());
        }
        if (date.getTime() < getNotBefore().getTime())
        {
            StringBuilder stringbuilder1 = new StringBuilder("certificate not valid till ");
            date = aEP.air.ajM;
            if (((Time) (date)).ajW instanceof ASN1UTCTime)
            {
                date = ((ASN1UTCTime)((Time) (date)).ajW)._mth0695();
            } else
            {
                date = ((ASN1GeneralizedTime)((Time) (date)).ajW)._mth0437();
            }
            throw new CertificateNotYetValidException(stringbuilder1.append(date).toString());
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
        if (!(obj instanceof java.security.cert.Certificate))
        {
            return false;
        }
        obj = (java.security.cert.Certificate)obj;
        boolean flag;
        try
        {
            flag = Arrays._mth1427(getEncoded(), ((java.security.cert.Certificate) (obj)).getEncoded());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return flag;
    }

    public int getBasicConstraints()
    {
        if (aEQ != null)
        {
            if (aEQ._mth09B6())
            {
                Object obj = aEQ;
                if (((BasicConstraints) (obj)).ain != null)
                {
                    obj = new BigInteger(((BasicConstraints) (obj)).ain.bytes);
                } else
                {
                    obj = null;
                }
                if (obj == null)
                {
                    return 0x7fffffff;
                }
                obj = aEQ;
                if (((BasicConstraints) (obj)).ain != null)
                {
                    obj = new BigInteger(((BasicConstraints) (obj)).ain.bytes);
                } else
                {
                    obj = null;
                }
                return ((BigInteger) (obj)).intValue();
            } else
            {
                return -1;
            }
        } else
        {
            return -1;
        }
    }

    public Set getCriticalExtensionOIDs()
    {
        if (getVersion() == 3)
        {
            HashSet hashset = new HashSet();
            Extensions extensions = aEP.air.aii;
            if (extensions != null)
            {
                Enumeration enumeration = extensions.aiZ.elements();
                do
                {
                    if (!enumeration.hasMoreElements())
                    {
                        break;
                    }
                    ASN1ObjectIdentifier asn1objectidentifier = (ASN1ObjectIdentifier)enumeration.nextElement();
                    if (((Extension)extensions.aiY.get(asn1objectidentifier)).aiW)
                    {
                        hashset.add(asn1objectidentifier.identifier);
                    }
                } while (true);
                return hashset;
            }
        }
        return null;
    }

    public byte[] getEncoded()
    {
        byte abyte0[];
        try
        {
            abyte0 = aEP.getEncoded("DER");
        }
        catch (IOException ioexception)
        {
            throw new CertificateEncodingException(ioexception.toString());
        }
        return abyte0;
    }

    public List getExtendedKeyUsage()
    {
        byte abyte0[] = _mth1601("2.5.29.37");
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        Object obj;
        ArrayList arraylist;
        int i;
        try
        {
            obj = (ASN1Sequence)(new ASN1InputStream(abyte0))._mth04B7();
            arraylist = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            throw new CertificateParsingException("error processing extended key usage extension");
        }
        i = 0;
        if (i == ((ASN1Sequence) (obj)).size())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(((ASN1ObjectIdentifier)((ASN1Sequence) (obj))._mth144B(i)).identifier);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_37;
_L1:
        obj = Collections.unmodifiableList(arraylist);
        return ((List) (obj));
        Exception exception;
        return null;
    }

    public byte[] getExtensionValue(String s)
    {
        Extensions extensions = aEP.air.aii;
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

    public Collection getIssuerAlternativeNames()
    {
        return FF9F(_mth1601(Extension.aiF.identifier));
    }

    public Principal getIssuerDN()
    {
        IOException ioexception;
        X509Principal x509principal;
        try
        {
            x509principal = new X509Principal(X500Name._mth0131(aEP.air.ajE.getEncoded()));
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return null;
        }
        return x509principal;
    }

    public boolean[] getIssuerUniqueID()
    {
        DERBitString derbitstring = aEP.air.ajQ;
        if (derbitstring != null)
        {
            byte abyte0[] = derbitstring.getBytes();
            boolean aflag[] = new boolean[(abyte0.length << 3) - derbitstring._mth06B9()];
            for (int i = 0; i != aflag.length; i++)
            {
                boolean flag;
                if ((abyte0[i / 8] & 128 >>> i % 8) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                aflag[i] = flag;
            }

            return aflag;
        } else
        {
            return null;
        }
    }

    public X500Principal getIssuerX500Principal()
    {
        IOException ioexception;
        Object obj;
        try
        {
            obj = new ByteArrayOutputStream();
            (new ASN1OutputStream(((java.io.OutputStream) (obj))))._mth02CF(aEP.air.ajE);
            obj = new X500Principal(((ByteArrayOutputStream) (obj)).toByteArray());
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            throw new IllegalStateException("can't encode issuer DN");
        }
        return ((X500Principal) (obj));
    }

    public boolean[] getKeyUsage()
    {
        return aER;
    }

    public Set getNonCriticalExtensionOIDs()
    {
        if (getVersion() == 3)
        {
            HashSet hashset = new HashSet();
            Extensions extensions = aEP.air.aii;
            if (extensions != null)
            {
                Enumeration enumeration = extensions.aiZ.elements();
                do
                {
                    if (!enumeration.hasMoreElements())
                    {
                        break;
                    }
                    ASN1ObjectIdentifier asn1objectidentifier = (ASN1ObjectIdentifier)enumeration.nextElement();
                    if (!((Extension)extensions.aiY.get(asn1objectidentifier)).aiW)
                    {
                        hashset.add(asn1objectidentifier.identifier);
                    }
                } while (true);
                return hashset;
            }
        }
        return null;
    }

    public Date getNotAfter()
    {
        return aEP.air.ajN.getDate();
    }

    public Date getNotBefore()
    {
        return aEP.air.ajM.getDate();
    }

    public PublicKey getPublicKey()
    {
        IOException ioexception;
        PublicKey publickey;
        try
        {
            publickey = BouncyCastleProvider._mth141D(aEP.air.ajP);
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return null;
        }
        return publickey;
    }

    public BigInteger getSerialNumber()
    {
        return new BigInteger(aEP.air.aie.bytes);
    }

    public String getSigAlgName()
    {
        Object obj = Security.getProvider("SC");
        if (obj != null)
        {
            obj = ((Provider) (obj)).getProperty((new StringBuilder("Alg.Alias.Signature.")).append(getSigAlgOID()).toString());
            if (obj != null)
            {
                return ((String) (obj));
            }
        }
        Provider aprovider[] = Security.getProviders();
        for (int i = 0; i != aprovider.length; i++)
        {
            String s = aprovider[i].getProperty((new StringBuilder("Alg.Alias.Signature.")).append(getSigAlgOID()).toString());
            if (s != null)
            {
                return s;
            }
        }

        return getSigAlgOID();
    }

    public String getSigAlgOID()
    {
        return (new ASN1ObjectIdentifier(aEP.aaE.ahP.identifier)).identifier;
    }

    public byte[] getSigAlgParams()
    {
        IOException ioexception;
        if (aEP.aaE.ahQ != null)
        {
            byte abyte0[];
            try
            {
                abyte0 = aEP.aaE.ahQ._mth0427().getEncoded("DER");
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                return null;
            }
            return abyte0;
        } else
        {
            return null;
        }
    }

    public byte[] getSignature()
    {
        return aEP.ais.getBytes();
    }

    public Collection getSubjectAlternativeNames()
    {
        return FF9F(_mth1601(Extension.aiE.identifier));
    }

    public Principal getSubjectDN()
    {
        return new X509Principal(X500Name._mth0131(aEP.air.ajO._mth0427()));
    }

    public boolean[] getSubjectUniqueID()
    {
        DERBitString derbitstring = aEP.air.ajR;
        if (derbitstring != null)
        {
            byte abyte0[] = derbitstring.getBytes();
            boolean aflag[] = new boolean[(abyte0.length << 3) - derbitstring._mth06B9()];
            for (int i = 0; i != aflag.length; i++)
            {
                boolean flag;
                if ((abyte0[i / 8] & 128 >>> i % 8) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                aflag[i] = flag;
            }

            return aflag;
        } else
        {
            return null;
        }
    }

    public X500Principal getSubjectX500Principal()
    {
        IOException ioexception;
        Object obj;
        try
        {
            obj = new ByteArrayOutputStream();
            (new ASN1OutputStream(((java.io.OutputStream) (obj))))._mth02CF(aEP.air.ajO);
            obj = new X500Principal(((ByteArrayOutputStream) (obj)).toByteArray());
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            throw new IllegalStateException("can't encode issuer DN");
        }
        return ((X500Principal) (obj));
    }

    public byte[] getTBSCertificate()
    {
        byte abyte0[];
        try
        {
            abyte0 = aEP.air.getEncoded("DER");
        }
        catch (IOException ioexception)
        {
            throw new CertificateEncodingException(ioexception.toString());
        }
        return abyte0;
    }

    public int getVersion()
    {
        return (new BigInteger(aEP.air.ada.bytes)).intValue() + 1;
    }

    public boolean hasUnsupportedCriticalExtension()
    {
label0:
        {
            if (getVersion() != 3)
            {
                break label0;
            }
            Extensions extensions = aEP.air.aii;
            if (extensions == null)
            {
                break label0;
            }
            Enumeration enumeration = extensions.aiZ.elements();
            ASN1ObjectIdentifier asn1objectidentifier;
            String s;
            do
            {
                if (!enumeration.hasMoreElements())
                {
                    break label0;
                }
                asn1objectidentifier = (ASN1ObjectIdentifier)enumeration.nextElement();
                s = asn1objectidentifier.identifier;
            } while (s.equals(RFC3280CertPathUtilities.aHX) || s.equals(RFC3280CertPathUtilities.aHN) || s.equals(RFC3280CertPathUtilities.aHO) || s.equals(RFC3280CertPathUtilities.aHP) || s.equals(RFC3280CertPathUtilities.aHT) || s.equals(RFC3280CertPathUtilities.aHr) || s.equals(RFC3280CertPathUtilities.aHQ) || s.equals(RFC3280CertPathUtilities.aHR) || s.equals(RFC3280CertPathUtilities.aHS) || s.equals(RFC3280CertPathUtilities.aHU) || s.equals(RFC3280CertPathUtilities.aHV) || !((Extension)extensions.aiY.get(asn1objectidentifier)).aiW);
            return true;
        }
        return false;
    }

    public int hashCode()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        if (!aES)
        {
            aEJ = _mth1605();
            aES = true;
        }
        i = aEJ;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        StringBuffer stringbuffer;
        String s;
        Extensions extensions;
        stringbuffer = new StringBuffer();
        s = System.getProperty("line.separator");
        stringbuffer.append("  [0]         Version: ").append(getVersion()).append(s);
        stringbuffer.append("         SerialNumber: ").append(getSerialNumber()).append(s);
        stringbuffer.append("             IssuerDN: ").append(getIssuerDN()).append(s);
        stringbuffer.append("           Start Date: ").append(getNotBefore()).append(s);
        stringbuffer.append("           Final Date: ").append(getNotAfter()).append(s);
        stringbuffer.append("            SubjectDN: ").append(getSubjectDN()).append(s);
        stringbuffer.append("           Public Key: ").append(getPublicKey()).append(s);
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

        extensions = aEP.air.aii;
        if (extensions == null) goto _L2; else goto _L1
_L1:
        Enumeration enumeration;
        enumeration = extensions.aiZ.elements();
        if (enumeration.hasMoreElements())
        {
            stringbuffer.append("       Extensions: \n");
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
            break MISSING_BLOCK_LABEL_660;
        }
        asn1inputstream = new ASN1InputStream(extension.aiX._mth0501());
        stringbuffer.append("                       critical(").append(extension.aiW).append(") ");
        if (asn1objectidentifier.equals(Extension.aiG))
        {
            stringbuffer.append(BasicConstraints._mth1FBE(asn1inputstream._mth04B7())).append(s);
            continue; /* Loop/switch isn't completed */
        }
        if (asn1objectidentifier.equals(Extension.aiD))
        {
            stringbuffer.append(KeyUsage._mth02B4(asn1inputstream._mth04B7())).append(s);
            continue; /* Loop/switch isn't completed */
        }
        if (asn1objectidentifier.equals(MiscObjectIdentifiers.Zv))
        {
            stringbuffer.append(new NetscapeCertType((DERBitString)asn1inputstream._mth04B7())).append(s);
            continue; /* Loop/switch isn't completed */
        }
        if (asn1objectidentifier.equals(MiscObjectIdentifiers.Zw))
        {
            stringbuffer.append(new NetscapeRevocationURL((DERIA5String)asn1inputstream._mth04B7())).append(s);
            continue; /* Loop/switch isn't completed */
        }
        if (asn1objectidentifier.equals(MiscObjectIdentifiers.Zy))
        {
            stringbuffer.append(new VerisignCzagExtension((DERIA5String)asn1inputstream._mth04B7())).append(s);
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
        return stringbuffer.toString();
    }

    public final void verify(PublicKey publickey)
    {
        Exception exception;
        String s = X509SignatureUtil._mth02CA(aEP.aaE);
        Signature signature;
        try
        {
            signature = Signature.getInstance(s, "SC");
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            signature = Signature.getInstance(s);
        }
        _mth02CA(publickey, signature);
    }

    public final void verify(PublicKey publickey, String s)
    {
        _mth02CA(publickey, Signature.getInstance(X509SignatureUtil._mth02CA(aEP.aaE), s));
    }

    public final ASN1Encodable _mth02BC(ASN1ObjectIdentifier asn1objectidentifier)
    {
        return aDG._mth02BC(asn1objectidentifier);
    }

    public final void _mth02CA(ASN1ObjectIdentifier asn1objectidentifier, ASN1Encodable asn1encodable)
    {
        aDG._mth02CA(asn1objectidentifier, asn1encodable);
    }

    public final Enumeration _mth152C()
    {
        return aDG._mth152C();
    }
}
