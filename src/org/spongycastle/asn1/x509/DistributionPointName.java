// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            GeneralNames

public class DistributionPointName extends ASN1Object
    implements ASN1Choice
{

    public ASN1Encodable aiC;
    public int type;

    public DistributionPointName(int i, GeneralNames generalnames)
    {
        type = 0;
        aiC = generalnames;
    }

    private DistributionPointName(ASN1TaggedObject asn1taggedobject)
    {
        type = asn1taggedobject.Wk;
        if (type == 0)
        {
            aiC = GeneralNames._mth02C8(asn1taggedobject, false);
            return;
        } else
        {
            aiC = ASN1Set._mth02BB(asn1taggedobject, false);
            return;
        }
    }

    private static void _mth02CA(StringBuffer stringbuffer, String s, String s1, String s2)
    {
        stringbuffer.append("    ");
        stringbuffer.append(s1);
        stringbuffer.append(":");
        stringbuffer.append(s);
        stringbuffer.append("    ");
        stringbuffer.append("    ");
        stringbuffer.append(s2);
        stringbuffer.append(s);
    }

    public static DistributionPointName _mth02CB(ASN1TaggedObject asn1taggedobject)
    {
        asn1taggedobject = ASN1TaggedObject._mth02BC(asn1taggedobject, true);
        if (asn1taggedobject == null)
        {
            return (DistributionPointName)asn1taggedobject;
        }
        if (asn1taggedobject instanceof ASN1TaggedObject)
        {
            return new DistributionPointName((ASN1TaggedObject)asn1taggedobject);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown object in factory: ")).append(asn1taggedobject.getClass().getName()).toString());
        }
    }

    public String toString()
    {
        String s = System.getProperty("line.separator");
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("DistributionPointName: [");
        stringbuffer.append(s);
        if (type == 0)
        {
            _mth02CA(stringbuffer, s, "fullName", aiC.toString());
        } else
        {
            _mth02CA(stringbuffer, s, "nameRelativeToCRLIssuer", aiC.toString());
        }
        stringbuffer.append("]");
        stringbuffer.append(s);
        return stringbuffer.toString();
    }

    public final ASN1Primitive _mth0427()
    {
        return new DERTaggedObject(false, type, aiC);
    }
}
