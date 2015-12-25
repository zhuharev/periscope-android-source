// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.util.Enumeration;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Sequence, ASN1Encodable, ASN1Primitive, ASN1OutputStream, 
//            StreamUtil, ASN1EncodableVector

public class DLSequence extends ASN1Sequence
{

    private int WO;

    public DLSequence()
    {
        WO = -1;
    }

    public DLSequence(ASN1EncodableVector asn1encodablevector)
    {
        super(asn1encodablevector);
        WO = -1;
    }

    public DLSequence(ASN1Primitive asn1primitive)
    {
        super(asn1primitive);
        WO = -1;
    }

    private int _mth06C2()
    {
        if (WO < 0)
        {
            int i = 0;
            for (Enumeration enumeration = _mth0675(); enumeration.hasMoreElements();)
            {
                i += ((ASN1Encodable)enumeration.nextElement())._mth0427()._mth05D7()._mth03DA();
            }

            WO = i;
        }
        return WO;
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        ASN1OutputStream asn1outputstream1 = asn1outputstream._mth0628();
        int i = _mth06C2();
        asn1outputstream.write(48);
        asn1outputstream._mth1449(i);
        for (asn1outputstream = _mth0675(); asn1outputstream.hasMoreElements(); asn1outputstream1._mth02CF((ASN1Encodable)asn1outputstream.nextElement())) { }
    }

    final int _mth03DA()
    {
        int i = _mth06C2();
        return StreamUtil._mth14BE(i) + 1 + i;
    }
}
