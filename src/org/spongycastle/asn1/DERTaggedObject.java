// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;


// Referenced classes of package org.spongycastle.asn1:
//            ASN1TaggedObject, ASN1Encodable, ASN1Primitive, ASN1OutputStream, 
//            StreamUtil

public class DERTaggedObject extends ASN1TaggedObject
{

    private static final byte WP[] = new byte[0];

    public DERTaggedObject(int i, ASN1Encodable asn1encodable)
    {
        super(true, i, asn1encodable);
    }

    public DERTaggedObject(boolean flag, int i, ASN1Encodable asn1encodable)
    {
        super(flag, i, asn1encodable);
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        ASN1Primitive asn1primitive = Wn._mth0427()._mth0582();
        if (Wm)
        {
            asn1outputstream._mth144A(160, Wk);
            asn1outputstream._mth1449(asn1primitive._mth03DA());
            asn1outputstream._mth02CF(asn1primitive);
            return;
        }
        char c;
        if (asn1primitive._mth03BD())
        {
            c = '\240';
        } else
        {
            c = '\200';
        }
        asn1outputstream._mth144A(c, Wk);
        asn1outputstream._mth02CB(asn1primitive);
    }

    final boolean _mth03BD()
    {
        if (Wm)
        {
            return true;
        } else
        {
            return Wn._mth0427()._mth0582()._mth03BD();
        }
    }

    final int _mth03DA()
    {
        int i = Wn._mth0427()._mth0582()._mth03DA();
        if (Wm)
        {
            return StreamUtil._mth14EA(Wk) + StreamUtil._mth14BE(i) + i;
        } else
        {
            return StreamUtil._mth14EA(Wk) + (i - 1);
        }
    }

}
