// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class RSAPublicKey extends ASN1Object
{

    public BigInteger adi;
    public BigInteger adj;

    public RSAPublicKey(BigInteger biginteger, BigInteger biginteger1)
    {
        adi = biginteger;
        adj = biginteger1;
    }

    private RSAPublicKey(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() != 2)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        } else
        {
            asn1sequence = asn1sequence._mth0675();
            adi = new BigInteger(1, ASN1Integer.FB1D(asn1sequence.nextElement()).bytes);
            adj = new BigInteger(1, ASN1Integer.FB1D(asn1sequence.nextElement()).bytes);
            return;
        }
    }

    public static RSAPublicKey _mth02BC(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new RSAPublicKey(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1Integer asn1integer = new ASN1Integer(adi);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = new ASN1Integer(adj);
        asn1encodablevector.VS.addElement(asn1integer);
        return new DERSequence(asn1encodablevector);
    }
}
