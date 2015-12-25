// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedData extends ASN1Object
{

    public ASN1Sequence aaJ;

    public EncryptedData(ASN1ObjectIdentifier asn1objectidentifier, AlgorithmIdentifier algorithmidentifier, BEROctetString beroctetstring)
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        asn1encodablevector.VS.addElement(asn1objectidentifier);
        asn1objectidentifier = algorithmidentifier._mth0427();
        asn1encodablevector.VS.addElement(asn1objectidentifier);
        asn1objectidentifier = new BERTaggedObject(false, 0, beroctetstring);
        asn1encodablevector.VS.addElement(asn1objectidentifier);
        aaJ = new BERSequence(asn1encodablevector);
    }

    private EncryptedData(ASN1Sequence asn1sequence)
    {
        if ((new BigInteger(((ASN1Integer)asn1sequence._mth144B(0)).bytes)).intValue() != 0)
        {
            throw new IllegalArgumentException("sequence not version 0");
        } else
        {
            aaJ = ASN1Sequence._mth141F(asn1sequence._mth144B(1));
            return;
        }
    }

    public static EncryptedData _mth02BF(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof EncryptedData)
        {
            return (EncryptedData)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new EncryptedData(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = new ASN1Integer(0L);
        asn1encodablevector.VS.addElement(obj);
        obj = aaJ;
        asn1encodablevector.VS.addElement(obj);
        return new BERSequence(asn1encodablevector);
    }
}
