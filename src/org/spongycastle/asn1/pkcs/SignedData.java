// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.pkcs:
//            PKCSObjectIdentifiers, ContentInfo

public class SignedData extends ASN1Object
    implements PKCSObjectIdentifiers
{

    private ContentInfo acW;
    public ASN1Set adA;
    private ASN1Set adB;
    private ASN1Integer ada;
    private ASN1Set ady;
    public ASN1Set adz;

    public SignedData(ASN1Integer asn1integer, DERSet derset, ContentInfo contentinfo, DERSet derset1, ASN1Set asn1set, DERSet derset2)
    {
        ada = asn1integer;
        ady = derset;
        acW = contentinfo;
        adz = derset1;
        adA = null;
        adB = derset2;
    }

    public SignedData(ASN1Sequence asn1sequence)
    {
        asn1sequence = asn1sequence._mth0675();
        ada = (ASN1Integer)asn1sequence.nextElement();
        ady = (ASN1Set)asn1sequence.nextElement();
        acW = ContentInfo._mth1508(asn1sequence.nextElement());
        do
        {
            while (asn1sequence.hasMoreElements()) 
            {
                Object obj = (ASN1Primitive)asn1sequence.nextElement();
                if (obj instanceof ASN1TaggedObject)
                {
                    obj = (ASN1TaggedObject)obj;
                    switch (((ASN1TaggedObject) (obj)).Wk)
                    {
                    case 0: // '\0'
                        adz = ASN1Set._mth02BB(((ASN1TaggedObject) (obj)), false);
                        break;

                    case 1: // '\001'
                        adA = ASN1Set._mth02BB(((ASN1TaggedObject) (obj)), false);
                        break;

                    default:
                        throw new IllegalArgumentException((new StringBuilder("unknown tag value ")).append(((ASN1TaggedObject) (obj)).Wk).toString());
                    }
                } else
                {
                    adB = (ASN1Set)obj;
                }
            }
            return;
        } while (true);
    }

    public static SignedData _mth02CF(ASN1Sequence asn1sequence)
    {
        if (asn1sequence != null)
        {
            return new SignedData(ASN1Sequence._mth141F(asn1sequence));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = ada;
        asn1encodablevector.VS.addElement(obj);
        obj = ady;
        asn1encodablevector.VS.addElement(obj);
        obj = acW;
        asn1encodablevector.VS.addElement(obj);
        if (adz != null)
        {
            obj = new DERTaggedObject(false, 0, adz);
            asn1encodablevector.VS.addElement(obj);
        }
        if (adA != null)
        {
            obj = new DERTaggedObject(false, 1, adA);
            asn1encodablevector.VS.addElement(obj);
        }
        obj = adB;
        asn1encodablevector.VS.addElement(obj);
        return new BERSequence(asn1encodablevector);
    }
}
