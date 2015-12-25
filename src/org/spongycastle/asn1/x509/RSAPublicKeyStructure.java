// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class RSAPublicKeyStructure extends ASN1Object
{

    private BigInteger adi;
    private BigInteger adj;

    public RSAPublicKeyStructure(BigInteger biginteger, BigInteger biginteger1)
    {
        adi = biginteger;
        adj = biginteger1;
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
