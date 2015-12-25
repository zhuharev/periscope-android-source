// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Set, ASN1OutputStream, ASN1Encodable, ASN1Primitive, 
//            ASN1EncodableVector

public class BERSet extends ASN1Set
{

    public BERSet()
    {
    }

    public BERSet(ASN1EncodableVector asn1encodablevector)
    {
        super(asn1encodablevector, false);
    }

    public BERSet(ASN1Primitive asn1primitive)
    {
        super(asn1primitive);
    }

    public BERSet(ASN1Encodable aasn1encodable[])
    {
        super(aasn1encodable, false);
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        asn1outputstream.write(49);
        asn1outputstream.write(128);
        for (Enumeration enumeration = super.Wf.elements(); enumeration.hasMoreElements(); asn1outputstream._mth02CF((ASN1Encodable)enumeration.nextElement())) { }
        asn1outputstream.write(0);
        asn1outputstream.write(0);
    }

    final int _mth03DA()
    {
        int i = 0;
        for (Enumeration enumeration = super.Wf.elements(); enumeration.hasMoreElements();)
        {
            i += ((ASN1Encodable)enumeration.nextElement())._mth0427()._mth03DA();
        }

        return i + 2 + 2;
    }
}
