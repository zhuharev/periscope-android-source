// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            AlgorithmIdentifier

public class ObjectDigestInfo extends ASN1Object
{

    public ASN1Enumerated ajw;
    private ASN1ObjectIdentifier ajx;
    public AlgorithmIdentifier ajy;
    public DERBitString ajz;

    private ObjectDigestInfo(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() > 4 || asn1sequence.size() < 3)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        }
        ajw = ASN1Enumerated._mth1D63(asn1sequence._mth144B(0));
        int i = 0;
        if (asn1sequence.size() == 4)
        {
            ajx = ASN1ObjectIdentifier._mth02CE(asn1sequence._mth144B(1));
            i = 0 + 1;
        }
        ajy = AlgorithmIdentifier._mth01C3(asn1sequence._mth144B(i + 1));
        ajz = DERBitString._mth14BD(asn1sequence._mth144B(i + 2));
    }

    public static ObjectDigestInfo _mth02CC(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = ASN1Sequence._mth141D(asn1taggedobject, false);
        if (asn1taggedobject != null)
        {
            return new ObjectDigestInfo(ASN1Sequence._mth141F(asn1taggedobject));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = ajw;
        asn1encodablevector.VS.addElement(obj);
        if (ajx != null)
        {
            obj = ajx;
            asn1encodablevector.VS.addElement(obj);
        }
        obj = ajy;
        asn1encodablevector.VS.addElement(obj);
        obj = ajz;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
