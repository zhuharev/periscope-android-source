// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERSequence;

public class AlgorithmIdentifier extends ASN1Object
{

    public ASN1ObjectIdentifier ahP;
    public ASN1Encodable ahQ;
    private boolean ahR;

    private AlgorithmIdentifier(String s)
    {
        ahR = false;
        ahP = new ASN1ObjectIdentifier(s);
    }

    public AlgorithmIdentifier(ASN1ObjectIdentifier asn1objectidentifier)
    {
        ahR = false;
        ahP = asn1objectidentifier;
    }

    public AlgorithmIdentifier(ASN1ObjectIdentifier asn1objectidentifier, ASN1Encodable asn1encodable)
    {
        ahR = false;
        ahR = true;
        ahP = asn1objectidentifier;
        ahQ = asn1encodable;
    }

    private AlgorithmIdentifier(ASN1Sequence asn1sequence)
    {
        ahR = false;
        if (asn1sequence.size() <= 0 || asn1sequence.size() > 2)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        }
        ahP = ASN1ObjectIdentifier._mth02CE(asn1sequence._mth144B(0));
        if (asn1sequence.size() == 2)
        {
            ahR = true;
            ahQ = asn1sequence._mth144B(1);
            return;
        } else
        {
            ahQ = null;
            return;
        }
    }

    public static AlgorithmIdentifier _mth01C3(Object obj)
    {
        if (obj == null || (obj instanceof AlgorithmIdentifier))
        {
            return (AlgorithmIdentifier)obj;
        }
        if (obj instanceof ASN1ObjectIdentifier)
        {
            return new AlgorithmIdentifier((ASN1ObjectIdentifier)obj);
        }
        if (obj instanceof String)
        {
            return new AlgorithmIdentifier((String)obj);
        } else
        {
            return new AlgorithmIdentifier(ASN1Sequence._mth141F(obj));
        }
    }

    public static AlgorithmIdentifier _mth02BE(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        return _mth01C3(ASN1Sequence._mth141D(asn1taggedobject, true));
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1ObjectIdentifier asn1objectidentifier = ahP;
        asn1encodablevector.VS.addElement(asn1objectidentifier);
        if (ahR)
        {
            if (ahQ != null)
            {
                ASN1Encodable asn1encodable = ahQ;
                asn1encodablevector.VS.addElement(asn1encodable);
            } else
            {
                DERNull dernull = DERNull.WL;
                asn1encodablevector.VS.addElement(dernull);
            }
        }
        return new DERSequence(asn1encodablevector);
    }

    public ASN1ObjectIdentifier _mth072C()
    {
        return ahP;
    }
}
