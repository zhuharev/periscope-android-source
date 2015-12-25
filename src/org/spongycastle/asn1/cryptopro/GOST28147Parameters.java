// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cryptopro;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class GOST28147Parameters extends ASN1Object
{

    public ASN1OctetString Yk;
    public ASN1ObjectIdentifier Yl;

    private GOST28147Parameters(ASN1Sequence asn1sequence)
    {
        asn1sequence = asn1sequence._mth0675();
        Yk = (ASN1OctetString)asn1sequence.nextElement();
        Yl = (ASN1ObjectIdentifier)asn1sequence.nextElement();
    }

    public static GOST28147Parameters _mth02BC(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof GOST28147Parameters)
        {
            return (GOST28147Parameters)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new GOST28147Parameters(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = Yk;
        asn1encodablevector.VS.addElement(obj);
        obj = Yl;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
