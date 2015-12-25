// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            DERSequence, DERSet, ASN1EncodableVector, DLSequence, 
//            DLSet, ASN1Sequence, ASN1Set

class DERFactory
{

    private static DERSequence WJ = new DERSequence();
    private static DERSet WK = new DERSet();

    DERFactory()
    {
    }

    static ASN1Sequence _mth02CB(ASN1EncodableVector asn1encodablevector)
    {
        if (asn1encodablevector.VS.size() <= 0)
        {
            return WJ;
        } else
        {
            return new DLSequence(asn1encodablevector);
        }
    }

    static ASN1Set _mth02CE(ASN1EncodableVector asn1encodablevector)
    {
        if (asn1encodablevector.VS.size() <= 0)
        {
            return WK;
        } else
        {
            return new DLSet(asn1encodablevector);
        }
    }

}
