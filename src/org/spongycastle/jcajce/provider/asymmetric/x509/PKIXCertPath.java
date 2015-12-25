// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.security.NoSuchProviderException;
import java.security.cert.CertPath;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.pkcs.ContentInfo;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.util.io.pem.PemObject;
import org.spongycastle.util.io.pem.PemWriter;

public class PKIXCertPath extends CertPath
{

    static final List aEF;
    private List aEG;

    PKIXCertPath(InputStream inputstream, String s)
    {
        super("X.509");
        if (s.equalsIgnoreCase("PkiPath"))
        {
            inputstream = (new ASN1InputStream(inputstream))._mth04B7();
            if (!(inputstream instanceof ASN1Sequence))
            {
                throw new CertificateException("input stream does not contain a ASN1 SEQUENCE while reading PkiPath encoded data to load CertPath");
            }
            inputstream = ((ASN1Sequence)inputstream)._mth0675();
            aEG = new ArrayList();
            s = CertificateFactory.getInstance("X.509", "SC");
            byte abyte0[];
            for (; inputstream.hasMoreElements(); aEG.add(0, s.generateCertificate(new ByteArrayInputStream(abyte0))))
            {
                abyte0 = ((ASN1Encodable)inputstream.nextElement())._mth0427().getEncoded("DER");
            }

            break MISSING_BLOCK_LABEL_275;
        }
        if (!s.equalsIgnoreCase("PKCS7") && !s.equalsIgnoreCase("PEM"))
        {
            break MISSING_BLOCK_LABEL_195;
        }
        inputstream = new BufferedInputStream(inputstream);
        aEG = new ArrayList();
        s = CertificateFactory.getInstance("X.509", "SC");
_L1:
        java.security.cert.Certificate certificate = s.generateCertificate(inputstream);
        if (certificate == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        try
        {
            aEG.add(certificate);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CertificateException((new StringBuilder("IOException throw while decoding CertPath:\n")).append(inputstream.toString()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CertificateException((new StringBuilder("BouncyCastle provider not found while trying to get a CertificateFactory:\n")).append(inputstream.toString()).toString());
        }
          goto _L1
        throw new CertificateException((new StringBuilder("unsupported encoding: ")).append(s).toString());
        aEG = _mth02CF(aEG);
        return;
    }

    PKIXCertPath(List list)
    {
        super("X.509");
        aEG = _mth02CF(new ArrayList(list));
    }

    private static byte[] _mth02CA(ASN1Object asn1object)
    {
        try
        {
            asn1object = asn1object._mth0427().getEncoded("DER");
        }
        // Misplaced declaration of an exception variable
        catch (ASN1Object asn1object)
        {
            throw new CertificateEncodingException((new StringBuilder("Exception thrown: ")).append(asn1object).toString());
        }
        return asn1object;
    }

    private static List _mth02CF(List list)
    {
        if (list.size() < 2)
        {
            return list;
        }
        Object obj = ((X509Certificate)list.get(0)).getIssuerX500Principal();
        boolean flag1 = true;
        int i = 1;
        boolean flag;
        do
        {
            flag = flag1;
            if (i == list.size())
            {
                break;
            }
            if (((X500Principal) (obj)).equals(((X509Certificate)list.get(i)).getSubjectX500Principal()))
            {
                obj = ((X509Certificate)list.get(i)).getIssuerX500Principal();
            } else
            {
                flag = false;
                break;
            }
            i++;
        } while (true);
        if (flag)
        {
            return list;
        }
        obj = new ArrayList(list.size());
        ArrayList arraylist = new ArrayList(list);
        for (int j = 0; j < list.size(); j++)
        {
            X509Certificate x509certificate = (X509Certificate)list.get(j);
            boolean flag3 = false;
            X500Principal x500principal1 = x509certificate.getSubjectX500Principal();
            int l = 0;
            boolean flag2;
            do
            {
                flag2 = flag3;
                if (l == list.size())
                {
                    break;
                }
                if (((X509Certificate)list.get(l)).getIssuerX500Principal().equals(x500principal1))
                {
                    flag2 = true;
                    break;
                }
                l++;
            } while (true);
            if (!flag2)
            {
                ((List) (obj)).add(x509certificate);
                list.remove(j);
            }
        }

        if (((List) (obj)).size() > 1)
        {
            return arraylist;
        }
label0:
        for (int k = 0; k != ((List) (obj)).size(); k++)
        {
            X500Principal x500principal = ((X509Certificate)((List) (obj)).get(k)).getIssuerX500Principal();
            int i1 = 0;
            do
            {
                if (i1 >= list.size())
                {
                    continue label0;
                }
                X509Certificate x509certificate1 = (X509Certificate)list.get(i1);
                if (x500principal.equals(x509certificate1.getSubjectX500Principal()))
                {
                    ((List) (obj)).add(x509certificate1);
                    list.remove(i1);
                    continue label0;
                }
                i1++;
            } while (true);
        }

        if (list.size() > 0)
        {
            return arraylist;
        } else
        {
            return ((List) (obj));
        }
    }

    private static ASN1Primitive _mth02CF(X509Certificate x509certificate)
    {
        try
        {
            x509certificate = (new ASN1InputStream(x509certificate.getEncoded()))._mth04B7();
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            throw new CertificateEncodingException((new StringBuilder("Exception while encoding certificate: ")).append(x509certificate.toString()).toString());
        }
        return x509certificate;
    }

    public List getCertificates()
    {
        return Collections.unmodifiableList(new ArrayList(aEG));
    }

    public byte[] getEncoded()
    {
        Object obj = getEncodings();
        if (((Iterator) (obj)).hasNext())
        {
            obj = ((Iterator) (obj)).next();
            if (obj instanceof String)
            {
                return getEncoded((String)obj);
            }
        }
        return null;
    }

    public byte[] getEncoded(String s)
    {
        if (s.equalsIgnoreCase("PkiPath"))
        {
            s = new ASN1EncodableVector();
            ASN1Primitive asn1primitive;
            for (ListIterator listiterator = aEG.listIterator(aEG.size()); listiterator.hasPrevious(); ((ASN1EncodableVector) (s)).VS.addElement(asn1primitive))
            {
                asn1primitive = _mth02CF((X509Certificate)listiterator.previous());
            }

            return _mth02CA(new DERSequence(s));
        }
        if (s.equalsIgnoreCase("PKCS7"))
        {
            s = new ContentInfo(PKCSObjectIdentifiers.abI, null);
            ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
            for (int i = 0; i != aEG.size(); i++)
            {
                ASN1Primitive asn1primitive1 = _mth02CF((X509Certificate)aEG.get(i));
                asn1encodablevector.VS.addElement(asn1primitive1);
            }

            s = new SignedData(new ASN1Integer(1L), new DERSet(), s, new DERSet(asn1encodablevector), null, new DERSet());
            return _mth02CA(new ContentInfo(PKCSObjectIdentifiers.abJ, s));
        }
        if (!s.equalsIgnoreCase("PEM"))
        {
            break MISSING_BLOCK_LABEL_330;
        }
        s = new ByteArrayOutputStream();
        PemWriter pemwriter = new PemWriter(new OutputStreamWriter(s));
        int j = 0;
        do
        {
            try
            {
                if (j == aEG.size())
                {
                    break;
                }
                pemwriter._mth02CA(new PemObject("CERTIFICATE", ((X509Certificate)aEG.get(j)).getEncoded()));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new CertificateEncodingException("can't encode certificate for PEM encoded path");
            }
            j++;
        } while (true);
        pemwriter.close();
        return s.toByteArray();
        throw new CertificateEncodingException((new StringBuilder("unsupported encoding: ")).append(s).toString());
    }

    public Iterator getEncodings()
    {
        return aEF.iterator();
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("PkiPath");
        arraylist.add("PEM");
        arraylist.add("PKCS7");
        aEF = Collections.unmodifiableList(arraylist);
    }
}
