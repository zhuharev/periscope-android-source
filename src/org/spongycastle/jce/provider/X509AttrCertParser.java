// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.InputStream;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509StreamParserSpi;
import org.spongycastle.x509.X509V2AttributeCertificate;
import org.spongycastle.x509.util.StreamParsingException;

// Referenced classes of package org.spongycastle.jce.provider:
//            PEMUtil

public class X509AttrCertParser extends X509StreamParserSpi
{

    private static final PEMUtil aIe = new PEMUtil("ATTRIBUTE CERTIFICATE");
    public ASN1Set aEu;
    public int aEv;
    public InputStream aEw;

    public X509AttrCertParser()
    {
        aEu = null;
        aEv = 0;
        aEw = null;
    }

    private X509V2AttributeCertificate _mth1F3F()
    {
        if (aEu != null)
        {
            while (aEv < aEu.Wf.size()) 
            {
                Object obj = aEu;
                int i = aEv;
                aEv = i + 1;
                obj = (ASN1Encodable)((ASN1Set) (obj)).Wf.elementAt(i);
                if ((obj instanceof ASN1TaggedObject) && ((ASN1TaggedObject)obj).Wk == 2)
                {
                    return new X509V2AttributeCertificate(ASN1Sequence._mth141D((ASN1TaggedObject)obj, false).getEncoded());
                }
            }
        }
        return null;
    }

    public final X509AttributeCertificate _mth2137()
    {
        X509V2AttributeCertificate x509v2attributecertificate;
        if (aEu == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (aEv == aEu.Wf.size())
        {
            break MISSING_BLOCK_LABEL_31;
        }
        x509v2attributecertificate = _mth1F3F();
        return x509v2attributecertificate;
        Object obj;
        int i;
        try
        {
            aEu = null;
            aEv = 0;
        }
        catch (Exception exception)
        {
            throw new StreamParsingException(exception.toString(), exception);
        }
        return null;
        aEw.mark(10);
        i = aEw.read();
        if (i == -1)
        {
            return null;
        }
        if (i == 48)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        aEw.reset();
        obj = aEw;
        obj = aIe._mth02CD(((InputStream) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        obj = new X509V2AttributeCertificate(((ASN1Sequence) (obj)).getEncoded());
        return ((X509AttributeCertificate) (obj));
        return null;
        aEw.reset();
        obj = (ASN1Sequence)(new ASN1InputStream(aEw))._mth04B7();
        if (((ASN1Sequence) (obj)).size() > 1 && (((ASN1Sequence) (obj))._mth144B(0) instanceof ASN1ObjectIdentifier) && ((ASN1Sequence) (obj))._mth144B(0).equals(PKCSObjectIdentifiers.abJ))
        {
            aEu = (new SignedData(ASN1Sequence._mth141D((ASN1TaggedObject)((ASN1Sequence) (obj))._mth144B(1), true))).adz;
            return _mth1F3F();
        }
        obj = new X509V2AttributeCertificate(((ASN1Sequence) (obj)).getEncoded());
        return ((X509AttributeCertificate) (obj));
    }

}
