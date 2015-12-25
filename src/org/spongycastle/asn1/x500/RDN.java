// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x500;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;

// Referenced classes of package org.spongycastle.asn1.x500:
//            AttributeTypeAndValue

public class RDN extends ASN1Object
{

    public ASN1Set agd;

    private RDN(ASN1Set asn1set)
    {
        agd = asn1set;
    }

    public static RDN FF9F(Object obj)
    {
        if (obj instanceof RDN)
        {
            return (RDN)obj;
        }
        if (obj != null)
        {
            return new RDN(ASN1Set._mth1421(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return agd;
    }

    public final AttributeTypeAndValue _mth09A2()
    {
        if (agd.Wf.size() == 0)
        {
            return null;
        } else
        {
            return AttributeTypeAndValue._mth02B9((ASN1Encodable)agd.Wf.elementAt(0));
        }
    }

    public final AttributeTypeAndValue[] _mth09AC()
    {
        AttributeTypeAndValue aattributetypeandvalue[] = new AttributeTypeAndValue[agd.Wf.size()];
        for (int i = 0; i != aattributetypeandvalue.length; i++)
        {
            aattributetypeandvalue[i] = AttributeTypeAndValue._mth02B9((ASN1Encodable)agd.Wf.elementAt(i));
        }

        return aattributetypeandvalue;
    }
}
