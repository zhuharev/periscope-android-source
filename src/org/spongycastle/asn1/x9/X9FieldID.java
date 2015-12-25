// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x9:
//            X9ObjectIdentifiers

public class X9FieldID extends ASN1Object
    implements X9ObjectIdentifiers
{

    ASN1ObjectIdentifier ajs;
    ASN1Primitive alx;

    public X9FieldID(int i, int j)
    {
        this(i, j, 0, 0);
    }

    public X9FieldID(int i, int j, int k, int l)
    {
        ajs = alB;
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1Integer asn1integer = new ASN1Integer(i);
        asn1encodablevector.VS.addElement(asn1integer);
        if (k == 0)
        {
            if (l != 0)
            {
                throw new IllegalArgumentException("inconsistent k values");
            }
            Object obj = alC;
            asn1encodablevector.VS.addElement(obj);
            obj = new ASN1Integer(j);
            asn1encodablevector.VS.addElement(obj);
        } else
        {
            if (k <= j || l <= k)
            {
                throw new IllegalArgumentException("inconsistent k values");
            }
            Object obj1 = alD;
            asn1encodablevector.VS.addElement(obj1);
            obj1 = new ASN1EncodableVector();
            ASN1Integer asn1integer1 = new ASN1Integer(j);
            ((ASN1EncodableVector) (obj1)).VS.addElement(asn1integer1);
            asn1integer1 = new ASN1Integer(k);
            ((ASN1EncodableVector) (obj1)).VS.addElement(asn1integer1);
            asn1integer1 = new ASN1Integer(l);
            ((ASN1EncodableVector) (obj1)).VS.addElement(asn1integer1);
            obj1 = new DERSequence(((ASN1EncodableVector) (obj1)));
            asn1encodablevector.VS.addElement(obj1);
        }
        alx = new DERSequence(asn1encodablevector);
    }

    public X9FieldID(BigInteger biginteger)
    {
        ajs = alA;
        alx = new ASN1Integer(biginteger);
    }

    private X9FieldID(ASN1Sequence asn1sequence)
    {
        ajs = ASN1ObjectIdentifier._mth02CE(asn1sequence._mth144B(0));
        alx = asn1sequence._mth144B(1)._mth0427();
    }

    public static X9FieldID _mth1420(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof X9FieldID)
        {
            return (X9FieldID)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new X9FieldID(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = ajs;
        asn1encodablevector.VS.addElement(obj);
        obj = alx;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
