// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            BERSequence, BERSet, ASN1EncodableVector

class BERFactory
{

    private static BERSequence Wp = new BERSequence();

    BERFactory()
    {
    }

    static BERSequence _mth02CA(ASN1EncodableVector asn1encodablevector)
    {
        if (asn1encodablevector.VS.size() <= 0)
        {
            return Wp;
        } else
        {
            return new BERSequence(asn1encodablevector);
        }
    }

    static 
    {
        new BERSet();
    }
}
