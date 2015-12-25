// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.util.Enumeration;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Sequence, ASN1OutputStream, ASN1Encodable, ASN1Primitive, 
//            ASN1EncodableVector

public class BERSequence extends ASN1Sequence
{

    public BERSequence()
    {
    }

    public BERSequence(ASN1EncodableVector asn1encodablevector)
    {
        super(asn1encodablevector);
    }

    public BERSequence(ASN1Primitive asn1primitive)
    {
        super(asn1primitive);
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        asn1outputstream.write(48);
        asn1outputstream.write(128);
        for (Enumeration enumeration = _mth0675(); enumeration.hasMoreElements(); asn1outputstream._mth02CF((ASN1Encodable)enumeration.nextElement())) { }
        asn1outputstream.write(0);
        asn1outputstream.write(0);
    }

    final int _mth03DA()
    {
        int i = 0;
        for (Enumeration enumeration = _mth0675(); enumeration.hasMoreElements();)
        {
            i += ((ASN1Encodable)enumeration.nextElement())._mth0427()._mth03DA();
        }

        return i + 2 + 2;
    }
}
