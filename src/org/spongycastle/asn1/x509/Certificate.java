// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;

// Referenced classes of package org.spongycastle.asn1.x509:
//            TBSCertificate, AlgorithmIdentifier

public class Certificate extends ASN1Object
{

    public AlgorithmIdentifier aaE;
    private ASN1Sequence adC;
    public TBSCertificate air;
    public DERBitString ais;

    private Certificate(ASN1Sequence asn1sequence)
    {
        adC = asn1sequence;
        if (asn1sequence.size() == 3)
        {
            air = TBSCertificate._mth02C7(asn1sequence._mth144B(0));
            aaE = AlgorithmIdentifier._mth01C3(asn1sequence._mth144B(1));
            ais = DERBitString._mth14BD(asn1sequence._mth144B(2));
            return;
        } else
        {
            throw new IllegalArgumentException("sequence wrong size for a certificate");
        }
    }

    public static Certificate _mth02B2(Object obj)
    {
        if (obj instanceof Certificate)
        {
            return (Certificate)obj;
        }
        if (obj != null)
        {
            return new Certificate(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public static Certificate _mth02BF(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = ASN1Sequence._mth141D(asn1taggedobject, true);
        if (asn1taggedobject instanceof Certificate)
        {
            return (Certificate)asn1taggedobject;
        }
        if (asn1taggedobject != null)
        {
            return new Certificate(ASN1Sequence._mth141F(asn1taggedobject));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return adC;
    }
}
