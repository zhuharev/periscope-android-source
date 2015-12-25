// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.ocsp;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

public class ResponseBytes extends ASN1Object
{

    private ASN1ObjectIdentifier aaq;
    private ASN1OctetString aar;

    private ResponseBytes(ASN1Sequence asn1sequence)
    {
        aaq = (ASN1ObjectIdentifier)asn1sequence._mth144B(0);
        aar = (ASN1OctetString)asn1sequence._mth144B(1);
    }

    public static ResponseBytes _mth1FBE(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = ASN1Sequence._mth141D(asn1taggedobject, true);
        if (asn1taggedobject == null)
        {
            return (ResponseBytes)asn1taggedobject;
        }
        if (asn1taggedobject instanceof ASN1Sequence)
        {
            return new ResponseBytes((ASN1Sequence)asn1taggedobject);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown object in factory: ")).append(asn1taggedobject.getClass().getName()).toString());
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aaq;
        asn1encodablevector.VS.addElement(obj);
        obj = aar;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
