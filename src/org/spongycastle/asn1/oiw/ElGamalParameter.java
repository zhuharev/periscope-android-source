// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class ElGamalParameter extends ASN1Object
{

    public ASN1Integer Yq;
    public ASN1Integer aat;

    public ElGamalParameter(BigInteger biginteger, BigInteger biginteger1)
    {
        Yq = new ASN1Integer(biginteger);
        aat = new ASN1Integer(biginteger1);
    }

    private ElGamalParameter(ASN1Sequence asn1sequence)
    {
        asn1sequence = asn1sequence._mth0675();
        Yq = (ASN1Integer)asn1sequence.nextElement();
        aat = (ASN1Integer)asn1sequence.nextElement();
    }

    public static ElGamalParameter _mth1FBE(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof ElGamalParameter)
        {
            return (ElGamalParameter)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new ElGamalParameter(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1Integer asn1integer = Yq;
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = aat;
        asn1encodablevector.VS.addElement(asn1integer);
        return new DERSequence(asn1encodablevector);
    }
}
