// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.InputStream;
import java.security.cert.CRL;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.x509.X509StreamParserSpi;
import org.spongycastle.x509.util.StreamParsingException;

// Referenced classes of package org.spongycastle.jce.provider:
//            PEMUtil, X509CRLObject

public class X509CRLParser extends X509StreamParserSpi
{

    private static final PEMUtil aIe = new PEMUtil("CRL");
    public ASN1Set aEu;
    public int aEv;
    public InputStream aEw;

    public X509CRLParser()
    {
        aEu = null;
        aEv = 0;
        aEw = null;
    }

    private X509CRLObject _mth2161()
    {
        if (aEu == null || aEv >= aEu.Wf.size())
        {
            return null;
        } else
        {
            ASN1Set asn1set = aEu;
            int i = aEv;
            aEv = i + 1;
            return new X509CRLObject(CertificateList._mth1D54((ASN1Encodable)asn1set.Wf.elementAt(i)));
        }
    }

    public final CRL _mth2171()
    {
        X509CRLObject x509crlobject;
        if (aEu == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (aEv == aEu.Wf.size())
        {
            break MISSING_BLOCK_LABEL_31;
        }
        x509crlobject = _mth2161();
        return x509crlobject;
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
        obj = new X509CRLObject(CertificateList._mth1D54(((ASN1Encodable) (obj))));
        return ((CRL) (obj));
        return null;
        aEw.reset();
        obj = (ASN1Sequence)(new ASN1InputStream(aEw))._mth04B7();
        if (((ASN1Sequence) (obj)).size() > 1 && (((ASN1Sequence) (obj))._mth144B(0) instanceof ASN1ObjectIdentifier) && ((ASN1Sequence) (obj))._mth144B(0).equals(PKCSObjectIdentifiers.abJ))
        {
            aEu = (new SignedData(ASN1Sequence._mth141D((ASN1TaggedObject)((ASN1Sequence) (obj))._mth144B(1), true))).adA;
            return _mth2161();
        }
        obj = new X509CRLObject(CertificateList._mth1D54(((ASN1Encodable) (obj))));
        return ((CRL) (obj));
    }

}
