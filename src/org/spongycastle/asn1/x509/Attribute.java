// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;

public class Attribute extends ASN1Object
{

    public ASN1ObjectIdentifier ahW;
    private ASN1Set ahX;

    private Attribute(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() != 2)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        } else
        {
            ahW = ASN1ObjectIdentifier._mth02CE(asn1sequence._mth144B(0));
            ahX = ASN1Set._mth1421(asn1sequence._mth144B(1));
            return;
        }
    }

    public static Attribute _mth1D35(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof Attribute)
        {
            return (Attribute)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new Attribute(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = ahW;
        asn1encodablevector.VS.addElement(obj);
        obj = ahX;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
