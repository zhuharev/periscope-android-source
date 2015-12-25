// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            GeneralSubtree

public class NameConstraints extends ASN1Object
{

    public GeneralSubtree aju[];
    public GeneralSubtree ajv[];

    private NameConstraints(ASN1Sequence asn1sequence)
    {
        asn1sequence = asn1sequence._mth0675();
        do
        {
            if (!asn1sequence.hasMoreElements())
            {
                break;
            }
            ASN1TaggedObject asn1taggedobject = ASN1TaggedObject._mth142A(asn1sequence.nextElement());
            switch (asn1taggedobject.Wk)
            {
            case 0: // '\0'
                aju = _mth02BC(ASN1Sequence._mth141D(asn1taggedobject, false));
                break;

            case 1: // '\001'
                ajv = _mth02BC(ASN1Sequence._mth141D(asn1taggedobject, false));
                break;
            }
        } while (true);
    }

    public static NameConstraints _mth02BB(ASN1Sequence asn1sequence)
    {
        if (asn1sequence != null)
        {
            return new NameConstraints(ASN1Sequence._mth141F(asn1sequence));
        } else
        {
            return null;
        }
    }

    private static GeneralSubtree[] _mth02BC(ASN1Sequence asn1sequence)
    {
        GeneralSubtree ageneralsubtree[] = new GeneralSubtree[asn1sequence.size()];
        for (int i = 0; i != ageneralsubtree.length; i++)
        {
            ageneralsubtree[i] = GeneralSubtree.FF70(asn1sequence._mth144B(i));
        }

        return ageneralsubtree;
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (aju != null)
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(false, 0, new DERSequence(aju));
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        if (ajv != null)
        {
            DERTaggedObject dertaggedobject1 = new DERTaggedObject(false, 1, new DERSequence(ajv));
            asn1encodablevector.VS.addElement(dertaggedobject1);
        }
        return new DERSequence(asn1encodablevector);
    }
}
