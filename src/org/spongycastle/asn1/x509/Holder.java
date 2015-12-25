// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            IssuerSerial, GeneralNames, ObjectDigestInfo

public class Holder extends ASN1Object
{

    private IssuerSerial ajg;
    private GeneralNames ajh;
    private ObjectDigestInfo aji;
    private int version;

    private Holder(ASN1Sequence asn1sequence)
    {
        version = 1;
        if (asn1sequence.size() > 3)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        }
        for (int i = 0; i != asn1sequence.size(); i++)
        {
            ASN1TaggedObject asn1taggedobject = ASN1TaggedObject._mth142A(asn1sequence._mth144B(i));
            switch (asn1taggedobject.Wk)
            {
            case 0: // '\0'
                ajg = IssuerSerial._mth02C9(asn1taggedobject, false);
                break;

            case 1: // '\001'
                ajh = GeneralNames._mth02C8(asn1taggedobject, false);
                break;

            case 2: // '\002'
                aji = ObjectDigestInfo._mth02CC(asn1taggedobject, false);
                break;

            default:
                throw new IllegalArgumentException("unknown tag in Holder");
            }
        }

        version = 1;
    }

    private Holder(ASN1TaggedObject asn1taggedobject)
    {
        version = 1;
        switch (asn1taggedobject.Wk)
        {
        case 0: // '\0'
            ajg = IssuerSerial._mth02C9(asn1taggedobject, true);
            break;

        case 1: // '\001'
            ajh = GeneralNames._mth02C8(asn1taggedobject, true);
            break;

        default:
            throw new IllegalArgumentException("unknown tag in Holder");
        }
        version = 0;
    }

    public static Holder _mth02B3(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof Holder)
        {
            return (Holder)asn1encodable;
        }
        if (asn1encodable instanceof ASN1TaggedObject)
        {
            return new Holder(ASN1TaggedObject._mth142A(asn1encodable));
        }
        if (asn1encodable != null)
        {
            return new Holder(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public IssuerSerial getBaseCertificateID()
    {
        return ajg;
    }

    public GeneralNames getEntityName()
    {
        return ajh;
    }

    public ObjectDigestInfo getObjectDigestInfo()
    {
        return aji;
    }

    public int getVersion()
    {
        return version;
    }

    public final ASN1Primitive _mth0427()
    {
        if (version == 1)
        {
            ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
            if (ajg != null)
            {
                DERTaggedObject dertaggedobject = new DERTaggedObject(false, 0, ajg);
                asn1encodablevector.VS.addElement(dertaggedobject);
            }
            if (ajh != null)
            {
                DERTaggedObject dertaggedobject1 = new DERTaggedObject(false, 1, ajh);
                asn1encodablevector.VS.addElement(dertaggedobject1);
            }
            if (aji != null)
            {
                DERTaggedObject dertaggedobject2 = new DERTaggedObject(false, 2, aji);
                asn1encodablevector.VS.addElement(dertaggedobject2);
            }
            return new DERSequence(asn1encodablevector);
        }
        if (ajh != null)
        {
            return new DERTaggedObject(true, 1, ajh);
        } else
        {
            return new DERTaggedObject(true, 0, ajg);
        }
    }
}
