// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            GeneralName

public class GeneralSubtree extends ASN1Object
{

    private static final BigInteger ZERO = BigInteger.valueOf(0L);
    public GeneralName ajd;
    private ASN1Integer aje;
    private ASN1Integer ajf;

    private GeneralSubtree(ASN1Sequence asn1sequence)
    {
        ajd = GeneralName._mth02E3(asn1sequence._mth144B(0));
        switch (asn1sequence.size())
        {
        case 1: // '\001'
            return;

        case 2: // '\002'
            asn1sequence = ASN1TaggedObject._mth142A(asn1sequence._mth144B(1));
            switch (((ASN1TaggedObject) (asn1sequence)).Wk)
            {
            case 0: // '\0'
                aje = ASN1Integer._mth02CB(asn1sequence, false);
                return;

            case 1: // '\001'
                ajf = ASN1Integer._mth02CB(asn1sequence, false);
                return;
            }
            throw new IllegalArgumentException((new StringBuilder("Bad tag number: ")).append(((ASN1TaggedObject) (asn1sequence)).Wk).toString());

        case 3: // '\003'
            ASN1TaggedObject asn1taggedobject = ASN1TaggedObject._mth142A(asn1sequence._mth144B(1));
            if (asn1taggedobject.Wk != 0)
            {
                throw new IllegalArgumentException((new StringBuilder("Bad tag number for 'minimum': ")).append(asn1taggedobject.Wk).toString());
            }
            aje = ASN1Integer._mth02CB(asn1taggedobject, false);
            asn1sequence = ASN1TaggedObject._mth142A(asn1sequence._mth144B(2));
            if (((ASN1TaggedObject) (asn1sequence)).Wk != 1)
            {
                throw new IllegalArgumentException((new StringBuilder("Bad tag number for 'maximum': ")).append(((ASN1TaggedObject) (asn1sequence)).Wk).toString());
            } else
            {
                ajf = ASN1Integer._mth02CB(asn1sequence, false);
                return;
            }
        }
        throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
    }

    public static GeneralSubtree FF70(ASN1Encodable asn1encodable)
    {
        if (asn1encodable == null)
        {
            return null;
        }
        if (asn1encodable instanceof GeneralSubtree)
        {
            return (GeneralSubtree)asn1encodable;
        } else
        {
            return new GeneralSubtree(ASN1Sequence._mth141F(asn1encodable));
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        GeneralName generalname = ajd;
        asn1encodablevector.VS.addElement(generalname);
        if (aje != null && !(new BigInteger(aje.bytes)).equals(ZERO))
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(false, 0, aje);
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        if (ajf != null)
        {
            DERTaggedObject dertaggedobject1 = new DERTaggedObject(false, 1, ajf);
            asn1encodablevector.VS.addElement(dertaggedobject1);
        }
        return new DERSequence(asn1encodablevector);
    }

}
