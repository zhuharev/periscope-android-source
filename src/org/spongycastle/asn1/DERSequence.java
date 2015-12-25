// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.util.Enumeration;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Sequence, ASN1Encodable, ASN1Primitive, ASN1OutputStream, 
//            StreamUtil, ASN1EncodableVector, ASN1Object

public class DERSequence extends ASN1Sequence
{

    private int WO;

    public DERSequence()
    {
        WO = -1;
    }

    public DERSequence(ASN1EncodableVector asn1encodablevector)
    {
        super(asn1encodablevector);
        WO = -1;
    }

    public DERSequence(ASN1Sequence asn1sequence)
    {
        super(asn1sequence);
        WO = -1;
    }

    public DERSequence(ASN1Object aasn1object[])
    {
        super(aasn1object);
        WO = -1;
    }

    private int _mth06C2()
    {
        if (WO < 0)
        {
            int i = 0;
            for (Enumeration enumeration = _mth0675(); enumeration.hasMoreElements();)
            {
                i += ((ASN1Encodable)enumeration.nextElement())._mth0427()._mth0582()._mth03DA();
            }

            WO = i;
        }
        return WO;
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        DEROutputStream deroutputstream = asn1outputstream._mth05E6();
        int i = _mth06C2();
        asn1outputstream.write(48);
        asn1outputstream._mth1449(i);
        for (asn1outputstream = _mth0675(); asn1outputstream.hasMoreElements(); deroutputstream._mth02CF((ASN1Encodable)asn1outputstream.nextElement())) { }
    }

    final int _mth03DA()
    {
        int i = _mth06C2();
        return StreamUtil._mth14BE(i) + 1 + i;
    }
}
