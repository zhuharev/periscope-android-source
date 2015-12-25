// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            GeneralNames, IssuerSerial, ObjectDigestInfo

public class V2Form extends ASN1Object
{

    public GeneralNames ajZ;
    public IssuerSerial ajg;
    private ObjectDigestInfo aji;

    private V2Form(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() > 3)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        }
        int i = 0;
        if (!(asn1sequence._mth144B(0) instanceof ASN1TaggedObject))
        {
            i = 0 + 1;
            ajZ = GeneralNames._mth05D5(asn1sequence._mth144B(0));
        }
        for (; i != asn1sequence.size(); i++)
        {
            ASN1TaggedObject asn1taggedobject = ASN1TaggedObject._mth142A(asn1sequence._mth144B(i));
            if (asn1taggedobject.Wk == 0)
            {
                ajg = IssuerSerial._mth02C9(asn1taggedobject, false);
                continue;
            }
            if (asn1taggedobject.Wk == 1)
            {
                aji = ObjectDigestInfo._mth02CC(asn1taggedobject, false);
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("Bad tag number: ")).append(asn1taggedobject.Wk).toString());
            }
        }

    }

    public static V2Form _mth02CD(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = ASN1Sequence._mth141D(asn1taggedobject, false);
        if (asn1taggedobject instanceof V2Form)
        {
            return (V2Form)asn1taggedobject;
        }
        if (asn1taggedobject != null)
        {
            return new V2Form(ASN1Sequence._mth141F(asn1taggedobject));
        } else
        {
            return null;
        }
    }

    public static V2Form _mth15AE(Object obj)
    {
        if (obj instanceof V2Form)
        {
            return (V2Form)obj;
        }
        if (obj != null)
        {
            return new V2Form(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (ajZ != null)
        {
            GeneralNames generalnames = ajZ;
            asn1encodablevector.VS.addElement(generalnames);
        }
        if (ajg != null)
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(false, 0, ajg);
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        if (aji != null)
        {
            DERTaggedObject dertaggedobject1 = new DERTaggedObject(false, 1, aji);
            asn1encodablevector.VS.addElement(dertaggedobject1);
        }
        return new DERSequence(asn1encodablevector);
    }
}
