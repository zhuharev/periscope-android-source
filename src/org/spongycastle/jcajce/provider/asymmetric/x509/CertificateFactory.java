// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.CertificateList;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.x509:
//            PEMUtil, X509CertificateObject, X509CRLObject, PKIXCertPath

public class CertificateFactory extends CertificateFactorySpi
{
    class ExCertificateException extends CertificateException
    {

        private Throwable VU;
        private CertificateFactory aEA;

        public Throwable getCause()
        {
            return VU;
        }

        public ExCertificateException(Exception exception)
        {
            aEA = CertificateFactory.this;
            super();
            VU = exception;
        }
    }


    private static final PEMUtil aEs = new PEMUtil("CERTIFICATE");
    private static final PEMUtil aEt = new PEMUtil("CRL");
    private ASN1Set aEu;
    private int aEv;
    private InputStream aEw;
    private ASN1Set aEx;
    private int aEy;
    private InputStream aEz;

    public CertificateFactory()
    {
        aEu = null;
        aEv = 0;
        aEw = null;
        aEx = null;
        aEy = 0;
        aEz = null;
    }

    private java.security.cert.Certificate _mth02CA(ASN1InputStream asn1inputstream)
    {
        asn1inputstream = (ASN1Sequence)asn1inputstream._mth04B7();
        if (asn1inputstream.size() > 1 && (asn1inputstream._mth144B(0) instanceof ASN1ObjectIdentifier) && asn1inputstream._mth144B(0).equals(PKCSObjectIdentifiers.abJ))
        {
            aEu = SignedData._mth02CF(ASN1Sequence._mth141D((ASN1TaggedObject)asn1inputstream._mth144B(1), true)).adz;
            return _mth15BF();
        } else
        {
            return new X509CertificateObject(Certificate._mth02B2(asn1inputstream));
        }
    }

    private X509CertificateObject _mth15BF()
    {
        if (aEu != null)
        {
            while (aEv < aEu.Wf.size()) 
            {
                Object obj = aEu;
                int i = aEv;
                aEv = i + 1;
                obj = (ASN1Encodable)((ASN1Set) (obj)).Wf.elementAt(i);
                if (obj instanceof ASN1Sequence)
                {
                    return new X509CertificateObject(Certificate._mth02B2(obj));
                }
            }
        }
        return null;
    }

    private CRL _mth15C1()
    {
        if (aEx == null || aEy >= aEx.Wf.size())
        {
            return null;
        } else
        {
            ASN1Set asn1set = aEx;
            int i = aEy;
            aEy = i + 1;
            return new X509CRLObject(CertificateList._mth1D54((ASN1Encodable)asn1set.Wf.elementAt(i)));
        }
    }

    public CRL engineGenerateCRL(InputStream inputstream)
    {
        if (aEz == null)
        {
            aEz = inputstream;
            aEx = null;
            aEy = 0;
        } else
        if (aEz != inputstream)
        {
            aEz = inputstream;
            aEx = null;
            aEy = 0;
        }
        if (aEx == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (aEy == aEx.Wf.size())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        inputstream = _mth15C1();
        return inputstream;
        int i;
        try
        {
            aEx = null;
            aEy = 0;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CRLException(inputstream.toString());
        }
        return null;
        inputstream = new PushbackInputStream(inputstream);
        i = inputstream.read();
        if (i == -1)
        {
            return null;
        }
        inputstream.unread(i);
        if (i == 48)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        inputstream = aEt._mth02CD(inputstream);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        inputstream = new X509CRLObject(CertificateList._mth1D54(inputstream));
        return inputstream;
        return null;
        inputstream = (ASN1Sequence)(new ASN1InputStream(inputstream, true))._mth04B7();
        if (inputstream.size() > 1 && (inputstream._mth144B(0) instanceof ASN1ObjectIdentifier) && inputstream._mth144B(0).equals(PKCSObjectIdentifiers.abJ))
        {
            aEx = SignedData._mth02CF(ASN1Sequence._mth141D((ASN1TaggedObject)inputstream._mth144B(1), true)).adA;
            return _mth15C1();
        }
        inputstream = new X509CRLObject(CertificateList._mth1D54(inputstream));
        return inputstream;
    }

    public Collection engineGenerateCRLs(InputStream inputstream)
    {
        ArrayList arraylist = new ArrayList();
        do
        {
            CRL crl = engineGenerateCRL(inputstream);
            if (crl != null)
            {
                arraylist.add(crl);
            } else
            {
                return arraylist;
            }
        } while (true);
    }

    public CertPath engineGenerateCertPath(InputStream inputstream)
    {
        return engineGenerateCertPath(inputstream, "PkiPath");
    }

    public CertPath engineGenerateCertPath(InputStream inputstream, String s)
    {
        return new PKIXCertPath(inputstream, s);
    }

    public CertPath engineGenerateCertPath(List list)
    {
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Object obj = iterator.next();
            if (obj != null && !(obj instanceof X509Certificate))
            {
                throw new CertificateException((new StringBuilder("list contains non X509Certificate object while creating CertPath\n")).append(obj.toString()).toString());
            }
        }

        return new PKIXCertPath(list);
    }

    public java.security.cert.Certificate engineGenerateCertificate(InputStream inputstream)
    {
        if (aEw == null)
        {
            aEw = inputstream;
            aEu = null;
            aEv = 0;
        } else
        if (aEw != inputstream)
        {
            aEw = inputstream;
            aEu = null;
            aEv = 0;
        }
        if (aEu == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (aEv == aEu.Wf.size())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        inputstream = _mth15BF();
        return inputstream;
        int i;
        try
        {
            aEu = null;
            aEv = 0;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new ExCertificateException(inputstream);
        }
        return null;
        inputstream = new PushbackInputStream(inputstream);
        i = inputstream.read();
        if (i == -1)
        {
            return null;
        }
        inputstream.unread(i);
        if (i == 48)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        inputstream = aEs._mth02CD(inputstream);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        inputstream = new X509CertificateObject(Certificate._mth02B2(inputstream));
        return inputstream;
        return null;
        inputstream = _mth02CA(new ASN1InputStream(inputstream));
        return inputstream;
    }

    public Collection engineGenerateCertificates(InputStream inputstream)
    {
        ArrayList arraylist = new ArrayList();
        do
        {
            java.security.cert.Certificate certificate = engineGenerateCertificate(inputstream);
            if (certificate != null)
            {
                arraylist.add(certificate);
            } else
            {
                return arraylist;
            }
        } while (true);
    }

    public Iterator engineGetCertPathEncodings()
    {
        return PKIXCertPath.aEF.iterator();
    }

}
