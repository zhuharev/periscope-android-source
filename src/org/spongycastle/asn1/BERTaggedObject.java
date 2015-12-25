// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1TaggedObject, ASN1OutputStream, ASN1OctetString, BEROctetString, 
//            ASN1Sequence, ASN1Set, ASN1Encodable, ASN1Primitive, 
//            StreamUtil

public class BERTaggedObject extends ASN1TaggedObject
{

    public BERTaggedObject(boolean flag, int i, ASN1Encodable asn1encodable)
    {
        super(flag, i, asn1encodable);
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        asn1outputstream._mth144A(160, Wk);
        asn1outputstream.write(128);
        if (!Wm)
        {
            Enumeration enumeration;
            if (Wn instanceof ASN1OctetString)
            {
                if (Wn instanceof BEROctetString)
                {
                    enumeration = ((BEROctetString)Wn)._mth0675();
                } else
                {
                    enumeration = (new BEROctetString(((ASN1OctetString)Wn)._mth0501()))._mth0675();
                }
            } else
            if (Wn instanceof ASN1Sequence)
            {
                enumeration = ((ASN1Sequence)Wn)._mth0675();
            } else
            if (Wn instanceof ASN1Set)
            {
                enumeration = ((ASN1Set)Wn).Wf.elements();
            } else
            {
                throw new RuntimeException((new StringBuilder("not implemented: ")).append(Wn.getClass().getName()).toString());
            }
            for (; enumeration.hasMoreElements(); asn1outputstream._mth02CF((ASN1Encodable)enumeration.nextElement())) { }
        } else
        {
            asn1outputstream._mth02CF(Wn);
        }
        asn1outputstream.write(0);
        asn1outputstream.write(0);
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
        int i = Wn._mth0427()._mth03DA();
        if (Wm)
        {
            return StreamUtil._mth14EA(Wk) + StreamUtil._mth14BE(i) + i;
        } else
        {
            return StreamUtil._mth14EA(Wk) + (i - 1);
        }
    }
}
