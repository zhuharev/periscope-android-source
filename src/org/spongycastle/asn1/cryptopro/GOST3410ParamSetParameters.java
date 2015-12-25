// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class GOST3410ParamSetParameters extends ASN1Object
{

    private int Yp;
    public ASN1Integer Yq;
    public ASN1Integer Yr;
    public ASN1Integer Ys;

    public GOST3410ParamSetParameters(int i, BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        Yp = 1024;
        Yq = new ASN1Integer(biginteger);
        Yr = new ASN1Integer(biginteger1);
        Ys = new ASN1Integer(biginteger2);
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1Integer asn1integer = new ASN1Integer(Yp);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = Yq;
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = Yr;
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = Ys;
        asn1encodablevector.VS.addElement(asn1integer);
        return new DERSequence(asn1encodablevector);
    }
}
