// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class AttCertValidityPeriod extends ASN1Object
{

    public ASN1GeneralizedTime ahU;
    public ASN1GeneralizedTime ahV;

    private AttCertValidityPeriod(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() != 2)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        } else
        {
            ahU = ASN1GeneralizedTime._mth02CB(asn1sequence._mth144B(0));
            ahV = ASN1GeneralizedTime._mth02CB(asn1sequence._mth144B(1));
            return;
        }
    }

    public static AttCertValidityPeriod _mth0674(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof AttCertValidityPeriod)
        {
            return (AttCertValidityPeriod)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new AttCertValidityPeriod(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1GeneralizedTime asn1generalizedtime = ahU;
        asn1encodablevector.VS.addElement(asn1generalizedtime);
        asn1generalizedtime = ahV;
        asn1encodablevector.VS.addElement(asn1generalizedtime);
        return new DERSequence(asn1encodablevector);
    }
}
