// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.ua;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DSTU4145BinaryField extends ASN1Object
{

    public int afJ;
    public int afK;
    public int afL;
    public int afM;

    private DSTU4145BinaryField(ASN1Sequence asn1sequence)
    {
        afJ = (new BigInteger(1, ASN1Integer.FB1D(asn1sequence._mth144B(0)).bytes)).intValue();
        if (asn1sequence._mth144B(1) instanceof ASN1Integer)
        {
            afK = (new BigInteger(1, ((ASN1Integer)asn1sequence._mth144B(1)).bytes)).intValue();
            return;
        }
        if (asn1sequence._mth144B(1) instanceof ASN1Sequence)
        {
            asn1sequence = ASN1Sequence._mth141F(asn1sequence._mth144B(1));
            afK = (new BigInteger(1, ASN1Integer.FB1D(asn1sequence._mth144B(0)).bytes)).intValue();
            afL = (new BigInteger(1, ASN1Integer.FB1D(asn1sequence._mth144B(1)).bytes)).intValue();
            afM = (new BigInteger(1, ASN1Integer.FB1D(asn1sequence._mth144B(2)).bytes)).intValue();
            return;
        } else
        {
            throw new IllegalArgumentException("object parse error");
        }
    }

    public static DSTU4145BinaryField _mth1428(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof DSTU4145BinaryField)
        {
            return (DSTU4145BinaryField)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new DSTU4145BinaryField(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1Integer asn1integer = new ASN1Integer(afJ);
        asn1encodablevector.VS.addElement(asn1integer);
        if (afL == 0)
        {
            ASN1Integer asn1integer1 = new ASN1Integer(afK);
            asn1encodablevector.VS.addElement(asn1integer1);
        } else
        {
            Object obj = new ASN1EncodableVector();
            ASN1Integer asn1integer2 = new ASN1Integer(afK);
            ((ASN1EncodableVector) (obj)).VS.addElement(asn1integer2);
            asn1integer2 = new ASN1Integer(afL);
            ((ASN1EncodableVector) (obj)).VS.addElement(asn1integer2);
            asn1integer2 = new ASN1Integer(afM);
            ((ASN1EncodableVector) (obj)).VS.addElement(asn1integer2);
            obj = new DERSequence(((ASN1EncodableVector) (obj)));
            asn1encodablevector.VS.addElement(obj);
        }
        return new DERSequence(asn1encodablevector);
    }
}
