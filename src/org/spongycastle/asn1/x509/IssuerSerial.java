// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            GeneralNames

public class IssuerSerial extends ASN1Object
{

    public GeneralNames ajj;
    public ASN1Integer ajk;
    private DERBitString ajl;

    private IssuerSerial(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() != 2 && asn1sequence.size() != 3)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        }
        ajj = GeneralNames._mth05D5(asn1sequence._mth144B(0));
        ajk = ASN1Integer.FB1D(asn1sequence._mth144B(1));
        if (asn1sequence.size() == 3)
        {
            ajl = DERBitString._mth14BD(asn1sequence._mth144B(2));
        }
    }

    public static IssuerSerial _mth02C9(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = ASN1Sequence._mth141D(asn1taggedobject, flag);
        if (asn1taggedobject != null)
        {
            return new IssuerSerial(ASN1Sequence._mth141F(asn1taggedobject));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = ajj;
        asn1encodablevector.VS.addElement(obj);
        obj = ajk;
        asn1encodablevector.VS.addElement(obj);
        if (ajl != null)
        {
            DERBitString derbitstring = ajl;
            asn1encodablevector.VS.addElement(derbitstring);
        }
        return new DERSequence(asn1encodablevector);
    }
}
