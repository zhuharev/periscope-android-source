// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x500;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class AttributeTypeAndValue extends ASN1Object
{

    public ASN1ObjectIdentifier agb;
    public ASN1Encodable agc;

    private AttributeTypeAndValue(ASN1Sequence asn1sequence)
    {
        agb = (ASN1ObjectIdentifier)asn1sequence._mth144B(0);
        agc = asn1sequence._mth144B(1);
    }

    public static AttributeTypeAndValue _mth02B9(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof AttributeTypeAndValue)
        {
            return (AttributeTypeAndValue)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new AttributeTypeAndValue(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            throw new IllegalArgumentException("null value in getInstance()");
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = agb;
        asn1encodablevector.VS.addElement(obj);
        obj = agc;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
