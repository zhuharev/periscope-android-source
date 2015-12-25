// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

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

public class DSAParameter extends ASN1Object
{

    public ASN1Integer Yq;
    public ASN1Integer Yr;
    public ASN1Integer aat;

    public DSAParameter(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        Yq = new ASN1Integer(biginteger);
        Yr = new ASN1Integer(biginteger1);
        aat = new ASN1Integer(biginteger2);
    }

    private DSAParameter(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() != 3)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        } else
        {
            asn1sequence = asn1sequence._mth0675();
            Yq = ASN1Integer.FB1D(asn1sequence.nextElement());
            Yr = ASN1Integer.FB1D(asn1sequence.nextElement());
            aat = ASN1Integer.FB1D(asn1sequence.nextElement());
            return;
        }
    }

    public static DSAParameter _mth1D62(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof DSAParameter)
        {
            return (DSAParameter)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new DSAParameter(ASN1Sequence._mth141F(asn1encodable));
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
        asn1integer = Yr;
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = aat;
        asn1encodablevector.VS.addElement(asn1integer);
        return new DERSequence(asn1encodablevector);
    }
}
