// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class PolicyInformation extends ASN1Object
{

    public ASN1ObjectIdentifier ajA;
    public ASN1Sequence ajB;

    private PolicyInformation(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() <= 0 || asn1sequence.size() > 2)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        }
        ajA = ASN1ObjectIdentifier._mth02CE(asn1sequence._mth144B(0));
        if (asn1sequence.size() > 1)
        {
            ajB = ASN1Sequence._mth141F(asn1sequence._mth144B(1));
        }
    }

    public static PolicyInformation _mth0E40(Object obj)
    {
        if (obj == null || (obj instanceof PolicyInformation))
        {
            return (PolicyInformation)obj;
        } else
        {
            return new PolicyInformation(ASN1Sequence._mth141F(obj));
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1ObjectIdentifier asn1objectidentifier = ajA;
        asn1encodablevector.VS.addElement(asn1objectidentifier);
        if (ajB != null)
        {
            ASN1Sequence asn1sequence = ajB;
            asn1encodablevector.VS.addElement(asn1sequence);
        }
        return new DERSequence(asn1encodablevector);
    }
}
