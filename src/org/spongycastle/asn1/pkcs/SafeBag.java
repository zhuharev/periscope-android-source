// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DLSequence;
import org.spongycastle.asn1.DLTaggedObject;

public class SafeBag extends ASN1Object
{

    public ASN1ObjectIdentifier adv;
    public ASN1Encodable adw;
    public ASN1Set adx;

    public SafeBag(ASN1ObjectIdentifier asn1objectidentifier, ASN1Primitive asn1primitive, DERSet derset)
    {
        adv = asn1objectidentifier;
        adw = asn1primitive;
        adx = derset;
    }

    private SafeBag(ASN1Sequence asn1sequence)
    {
        adv = (ASN1ObjectIdentifier)asn1sequence._mth144B(0);
        Object obj = (ASN1TaggedObject)asn1sequence._mth144B(1);
        if (((ASN1TaggedObject) (obj)).Wn != null)
        {
            obj = ((ASN1TaggedObject) (obj)).Wn._mth0427();
        } else
        {
            obj = null;
        }
        adw = ((ASN1Encodable) (obj));
        if (asn1sequence.size() == 3)
        {
            adx = (ASN1Set)asn1sequence._mth144B(2);
        }
    }

    public static SafeBag _mth0640(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof SafeBag)
        {
            return (SafeBag)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new SafeBag(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = adv;
        asn1encodablevector.VS.addElement(obj);
        obj = new DLTaggedObject(true, 0, adw);
        asn1encodablevector.VS.addElement(obj);
        if (adx != null)
        {
            ASN1Set asn1set = adx;
            asn1encodablevector.VS.addElement(asn1set);
        }
        return new DLSequence(asn1encodablevector);
    }
}
