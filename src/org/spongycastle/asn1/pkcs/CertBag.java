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
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class CertBag extends ASN1Object
{

    public ASN1ObjectIdentifier aaB;
    public ASN1Encodable aaC;

    public CertBag(ASN1ObjectIdentifier asn1objectidentifier, DEROctetString deroctetstring)
    {
        aaB = asn1objectidentifier;
        aaC = deroctetstring;
    }

    private CertBag(ASN1Sequence asn1sequence)
    {
        aaB = (ASN1ObjectIdentifier)asn1sequence._mth144B(0);
        asn1sequence = (DERTaggedObject)asn1sequence._mth144B(1);
        if (((ASN1TaggedObject) (asn1sequence)).Wn != null)
        {
            asn1sequence = ((ASN1TaggedObject) (asn1sequence)).Wn._mth0427();
        } else
        {
            asn1sequence = null;
        }
        aaC = asn1sequence;
    }

    public static CertBag _mth02BE(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof CertBag)
        {
            return (CertBag)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new CertBag(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aaB;
        asn1encodablevector.VS.addElement(obj);
        obj = new DERTaggedObject(0, aaC);
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
