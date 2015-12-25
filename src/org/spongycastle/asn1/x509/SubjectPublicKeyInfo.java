// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            AlgorithmIdentifier

public class SubjectPublicKeyInfo extends ASN1Object
{

    public AlgorithmIdentifier aaK;
    public DERBitString ajD;

    public SubjectPublicKeyInfo(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() != 2)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        } else
        {
            asn1sequence = asn1sequence._mth0675();
            aaK = AlgorithmIdentifier._mth01C3(asn1sequence.nextElement());
            ajD = DERBitString._mth14BD(asn1sequence.nextElement());
            return;
        }
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmidentifier, ASN1Encodable asn1encodable)
    {
        ajD = new DERBitString(asn1encodable);
        aaK = algorithmidentifier;
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmidentifier, byte abyte0[])
    {
        ajD = new DERBitString(abyte0);
        aaK = algorithmidentifier;
    }

    public static SubjectPublicKeyInfo _mth13A5(Object obj)
    {
        if (obj instanceof SubjectPublicKeyInfo)
        {
            return (SubjectPublicKeyInfo)obj;
        }
        if (obj != null)
        {
            return new SubjectPublicKeyInfo(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aaK;
        asn1encodablevector.VS.addElement(obj);
        obj = ajD;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
