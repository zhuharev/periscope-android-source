// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.Polynomial;
import org.spongycastle.math.field.PolynomialExtensionField;

// Referenced classes of package org.spongycastle.asn1.x9:
//            X9ObjectIdentifiers, X9Curve, X9FieldID, X9ECPoint

public class X9ECParameters extends ASN1Object
    implements X9ObjectIdentifiers
{

    public static final BigInteger ONE = BigInteger.valueOf(1L);
    public ECCurve alm;
    public byte aln[];
    private X9FieldID alp;
    public ECPoint alq;
    public BigInteger alr;
    public BigInteger als;

    private X9ECParameters(ASN1Sequence asn1sequence)
    {
        if (!(asn1sequence._mth144B(0) instanceof ASN1Integer) || !(new BigInteger(((ASN1Integer)asn1sequence._mth144B(0)).bytes)).equals(ONE))
        {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        X9Curve x9curve = new X9Curve(X9FieldID._mth1420(asn1sequence._mth144B(1)), ASN1Sequence._mth141F(asn1sequence._mth144B(2)));
        alm = x9curve.alm;
        org.spongycastle.asn1.ASN1Encodable asn1encodable = asn1sequence._mth144B(3);
        if (asn1encodable instanceof X9ECPoint)
        {
            alq = ((X9ECPoint)asn1encodable).alu;
        } else
        {
            alq = (new X9ECPoint(alm, (ASN1OctetString)asn1encodable)).alu;
        }
        alr = new BigInteger(((ASN1Integer)asn1sequence._mth144B(4)).bytes);
        aln = x9curve.aln;
        if (asn1sequence.size() == 6)
        {
            als = new BigInteger(((ASN1Integer)asn1sequence._mth144B(5)).bytes);
        }
    }

    public X9ECParameters(ECCurve eccurve, ECPoint ecpoint, BigInteger biginteger, BigInteger biginteger1)
    {
        this(eccurve, ecpoint, biginteger, biginteger1, null);
    }

    public X9ECParameters(ECCurve eccurve, ECPoint ecpoint, BigInteger biginteger, BigInteger biginteger1, byte abyte0[])
    {
        alm = eccurve;
        alq = ecpoint._mth0188();
        alr = biginteger;
        als = biginteger1;
        aln = abyte0;
        if (ECAlgorithms._mth141D(eccurve))
        {
            alp = new X9FieldID(eccurve.FB25()._mth0506());
            return;
        }
        if (ECAlgorithms._mth02CF(eccurve))
        {
            eccurve = ((PolynomialExtensionField)eccurve.FB25())._mth057D()._mth0578();
            if (eccurve.length == 3)
            {
                alp = new X9FieldID(eccurve[2], eccurve[1]);
                return;
            }
            if (eccurve.length == 5)
            {
                alp = new X9FieldID(eccurve[4], eccurve[1], eccurve[2], eccurve[3]);
                return;
            } else
            {
                throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
            }
        } else
        {
            throw new IllegalArgumentException("'curve' is of an unsupported type");
        }
    }

    public static X9ECParameters _mth0640(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new X9ECParameters(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = new ASN1Integer(1L);
        asn1encodablevector.VS.addElement(obj);
        obj = alp;
        asn1encodablevector.VS.addElement(obj);
        obj = new X9Curve(alm, aln);
        asn1encodablevector.VS.addElement(obj);
        obj = new X9ECPoint(alq);
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1Integer(alr);
        asn1encodablevector.VS.addElement(obj);
        if (als != null)
        {
            ASN1Integer asn1integer = new ASN1Integer(als);
            asn1encodablevector.VS.addElement(asn1integer);
        }
        return new DERSequence(asn1encodablevector);
    }

}
