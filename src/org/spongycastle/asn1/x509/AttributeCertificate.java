// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            AttributeCertificateInfo, AlgorithmIdentifier

public class AttributeCertificate extends ASN1Object
{

    public AttributeCertificateInfo ahY;
    private AlgorithmIdentifier ahZ;
    private DERBitString aia;

    private AttributeCertificate(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() != 3)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        } else
        {
            ahY = AttributeCertificateInfo._mth1D4E(asn1sequence._mth144B(0));
            ahZ = AlgorithmIdentifier._mth01C3(asn1sequence._mth144B(1));
            aia = DERBitString._mth14BD(asn1sequence._mth144B(2));
            return;
        }
    }

    public static AttributeCertificate _mth02BD(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new AttributeCertificate(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = ahY;
        asn1encodablevector.VS.addElement(obj);
        obj = ahZ;
        asn1encodablevector.VS.addElement(obj);
        obj = aia;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
