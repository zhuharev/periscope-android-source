// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            Certificate

public class CertificatePair extends ASN1Object
{

    public Certificate aiv;
    public Certificate aiw;

    private CertificatePair(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() != 1 && asn1sequence.size() != 2)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        }
        for (asn1sequence = asn1sequence._mth0675(); asn1sequence.hasMoreElements();)
        {
            ASN1TaggedObject asn1taggedobject = ASN1TaggedObject._mth142A(asn1sequence.nextElement());
            if (asn1taggedobject.Wk == 0)
            {
                aiv = Certificate._mth02BF(asn1taggedobject, true);
            } else
            if (asn1taggedobject.Wk == 1)
            {
                aiw = Certificate._mth02BF(asn1taggedobject, true);
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("Bad tag number: ")).append(asn1taggedobject.Wk).toString());
            }
        }

    }

    public CertificatePair(Certificate certificate, Certificate certificate1)
    {
        aiv = certificate;
        aiw = certificate1;
    }

    public static CertificatePair _mth02BF(ASN1Primitive asn1primitive)
    {
        if (asn1primitive == null)
        {
            return (CertificatePair)asn1primitive;
        }
        if (asn1primitive instanceof ASN1Sequence)
        {
            return new CertificatePair((ASN1Sequence)asn1primitive);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("illegal object in getInstance: ")).append(asn1primitive.getClass().getName()).toString());
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (aiv != null)
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(0, aiv);
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        if (aiw != null)
        {
            DERTaggedObject dertaggedobject1 = new DERTaggedObject(1, aiw);
            asn1encodablevector.VS.addElement(dertaggedobject1);
        }
        return new DERSequence(asn1encodablevector);
    }
}
