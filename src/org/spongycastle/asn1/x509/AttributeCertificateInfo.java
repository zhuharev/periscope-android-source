// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            Holder, AttCertIssuer, AlgorithmIdentifier, AttCertValidityPeriod, 
//            Extensions

public class AttributeCertificateInfo extends ASN1Object
{

    private ASN1Integer ada;
    public Holder aib;
    public AttCertIssuer aic;
    private AlgorithmIdentifier aid;
    public ASN1Integer aie;
    public AttCertValidityPeriod aif;
    public ASN1Sequence aig;
    private DERBitString aih;
    public Extensions aii;

    private AttributeCertificateInfo(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() < 6 || asn1sequence.size() > 9)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        }
        int i;
        if (asn1sequence._mth144B(0) instanceof ASN1Integer)
        {
            ada = ASN1Integer.FB1D(asn1sequence._mth144B(0));
            i = 1;
        } else
        {
            ada = new ASN1Integer(0L);
            i = 0;
        }
        aib = Holder._mth02B3(asn1sequence._mth144B(i));
        aic = AttCertIssuer._mth05D9(asn1sequence._mth144B(i + 1));
        aid = AlgorithmIdentifier._mth01C3(asn1sequence._mth144B(i + 2));
        aie = ASN1Integer.FB1D(asn1sequence._mth144B(i + 3));
        aif = AttCertValidityPeriod._mth0674(asn1sequence._mth144B(i + 4));
        aig = ASN1Sequence._mth141F(asn1sequence._mth144B(i + 5));
        for (i += 6; i < asn1sequence.size(); i++)
        {
            ASN1Encodable asn1encodable = asn1sequence._mth144B(i);
            if (asn1encodable instanceof DERBitString)
            {
                aih = DERBitString._mth14BD(asn1sequence._mth144B(i));
                continue;
            }
            if ((asn1encodable instanceof ASN1Sequence) || (asn1encodable instanceof Extensions))
            {
                aii = Extensions.FE7A(asn1sequence._mth144B(i));
            }
        }

    }

    public static AttributeCertificateInfo _mth1D4E(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof AttributeCertificateInfo)
        {
            return (AttributeCertificateInfo)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new AttributeCertificateInfo(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if ((new BigInteger(ada.bytes)).intValue() != 0)
        {
            ASN1Integer asn1integer = ada;
            asn1encodablevector.VS.addElement(asn1integer);
        }
        Object obj = aib;
        asn1encodablevector.VS.addElement(obj);
        obj = aic;
        asn1encodablevector.VS.addElement(obj);
        obj = aid;
        asn1encodablevector.VS.addElement(obj);
        obj = aie;
        asn1encodablevector.VS.addElement(obj);
        obj = aif;
        asn1encodablevector.VS.addElement(obj);
        obj = aig;
        asn1encodablevector.VS.addElement(obj);
        if (aih != null)
        {
            DERBitString derbitstring = aih;
            asn1encodablevector.VS.addElement(derbitstring);
        }
        if (aii != null)
        {
            Extensions extensions = aii;
            asn1encodablevector.VS.addElement(extensions);
        }
        return new DERSequence(asn1encodablevector);
    }
}
