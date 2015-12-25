// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            DistributionPointName, ReasonFlags, GeneralNames

public class DistributionPoint extends ASN1Object
{

    public ReasonFlags aiA;
    public GeneralNames aiB;
    public DistributionPointName aiz;

    private DistributionPoint(ASN1Sequence asn1sequence)
    {
        for (int i = 0; i != asn1sequence.size(); i++)
        {
            ASN1TaggedObject asn1taggedobject = ASN1TaggedObject._mth142A(asn1sequence._mth144B(i));
            switch (asn1taggedobject.Wk)
            {
            case 0: // '\0'
                aiz = DistributionPointName._mth02CB(asn1taggedobject);
                break;

            case 1: // '\001'
                aiA = new ReasonFlags(DERBitString._mth02BD(asn1taggedobject, false));
                break;

            case 2: // '\002'
                aiB = GeneralNames._mth02C8(asn1taggedobject, false);
                break;
            }
        }

    }

    public DistributionPoint(DistributionPointName distributionpointname, ReasonFlags reasonflags, GeneralNames generalnames)
    {
        aiz = distributionpointname;
        aiA = null;
        aiB = null;
    }

    private static void _mth02CA(StringBuffer stringbuffer, String s, String s1, String s2)
    {
        stringbuffer.append("    ");
        stringbuffer.append(s1);
        stringbuffer.append(":");
        stringbuffer.append(s);
        stringbuffer.append("    ");
        stringbuffer.append("    ");
        stringbuffer.append(s2);
        stringbuffer.append(s);
    }

    public static DistributionPoint FE76(ASN1Encodable asn1encodable)
    {
        if (asn1encodable == null || (asn1encodable instanceof DistributionPoint))
        {
            return (DistributionPoint)asn1encodable;
        }
        if (asn1encodable instanceof ASN1Sequence)
        {
            return new DistributionPoint((ASN1Sequence)asn1encodable);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid DistributionPoint: ")).append(asn1encodable.getClass().getName()).toString());
        }
    }

    public String toString()
    {
        String s = System.getProperty("line.separator");
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("DistributionPoint: [");
        stringbuffer.append(s);
        if (aiz != null)
        {
            _mth02CA(stringbuffer, s, "distributionPoint", aiz.toString());
        }
        if (aiA != null)
        {
            _mth02CA(stringbuffer, s, "reasons", aiA.toString());
        }
        if (aiB != null)
        {
            _mth02CA(stringbuffer, s, "cRLIssuer", aiB.toString());
        }
        stringbuffer.append("]");
        stringbuffer.append(s);
        return stringbuffer.toString();
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (aiz != null)
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(0, aiz);
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        if (aiA != null)
        {
            DERTaggedObject dertaggedobject1 = new DERTaggedObject(false, 1, aiA);
            asn1encodablevector.VS.addElement(dertaggedobject1);
        }
        if (aiB != null)
        {
            DERTaggedObject dertaggedobject2 = new DERTaggedObject(false, 2, aiB);
            asn1encodablevector.VS.addElement(dertaggedobject2);
        }
        return new DERSequence(asn1encodablevector);
    }
}
