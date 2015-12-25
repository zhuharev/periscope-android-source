// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            GeneralName

public class GeneralNames extends ASN1Object
{

    public final GeneralName ajb[];

    private GeneralNames(ASN1Sequence asn1sequence)
    {
        ajb = new GeneralName[asn1sequence.size()];
        for (int i = 0; i != asn1sequence.size(); i++)
        {
            ajb[i] = GeneralName._mth02E3(asn1sequence._mth144B(i));
        }

    }

    public GeneralNames(GeneralName generalname)
    {
        ajb = (new GeneralName[] {
            generalname
        });
    }

    public static GeneralNames _mth02C8(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = ASN1Sequence._mth141D(asn1taggedobject, flag);
        if (asn1taggedobject instanceof GeneralNames)
        {
            return (GeneralNames)asn1taggedobject;
        }
        if (asn1taggedobject != null)
        {
            return new GeneralNames(ASN1Sequence._mth141F(asn1taggedobject));
        } else
        {
            return null;
        }
    }

    public static GeneralNames _mth05D5(Object obj)
    {
        if (obj instanceof GeneralNames)
        {
            return (GeneralNames)obj;
        }
        if (obj != null)
        {
            return new GeneralNames(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = System.getProperty("line.separator");
        stringbuffer.append("GeneralNames:");
        stringbuffer.append(s);
        for (int i = 0; i != ajb.length; i++)
        {
            stringbuffer.append("    ");
            stringbuffer.append(ajb[i]);
            stringbuffer.append(s);
        }

        return stringbuffer.toString();
    }

    public final ASN1Primitive _mth0427()
    {
        return new DERSequence(ajb);
    }
}
