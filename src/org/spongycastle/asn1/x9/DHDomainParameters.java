// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x9:
//            DHValidationParms

public class DHDomainParameters extends ASN1Object
{

    public ASN1Integer Yq;
    public ASN1Integer Yr;
    public ASN1Integer aat;
    public ASN1Integer akI;
    public DHValidationParms akJ;

    private DHDomainParameters(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() < 3 || asn1sequence.size() > 5)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        }
        Enumeration enumeration = asn1sequence._mth0675();
        Yq = ASN1Integer.FB1D(enumeration.nextElement());
        aat = ASN1Integer.FB1D(enumeration.nextElement());
        Yr = ASN1Integer.FB1D(enumeration.nextElement());
        if (enumeration.hasMoreElements())
        {
            asn1sequence = (ASN1Encodable)enumeration.nextElement();
        } else
        {
            asn1sequence = null;
        }
        Object obj = asn1sequence;
        if (asn1sequence != null)
        {
            obj = asn1sequence;
            if (asn1sequence instanceof ASN1Integer)
            {
                akI = ASN1Integer.FB1D(asn1sequence);
                if (enumeration.hasMoreElements())
                {
                    obj = (ASN1Encodable)enumeration.nextElement();
                } else
                {
                    obj = null;
                }
            }
        }
        if (obj != null)
        {
            akJ = DHValidationParms._mth02D1(((ASN1Encodable) (obj))._mth0427());
        }
    }

    public static DHDomainParameters _mth02EE(ASN1Encodable asn1encodable)
    {
        if (asn1encodable == null || (asn1encodable instanceof DHDomainParameters))
        {
            return (DHDomainParameters)asn1encodable;
        }
        if (asn1encodable instanceof ASN1Sequence)
        {
            return new DHDomainParameters((ASN1Sequence)asn1encodable);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid DHDomainParameters: ")).append(asn1encodable.getClass().getName()).toString());
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1Integer asn1integer = Yq;
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = aat;
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = Yr;
        asn1encodablevector.VS.addElement(asn1integer);
        if (akI != null)
        {
            ASN1Integer asn1integer1 = akI;
            asn1encodablevector.VS.addElement(asn1integer1);
        }
        if (akJ != null)
        {
            DHValidationParms dhvalidationparms = akJ;
            asn1encodablevector.VS.addElement(dhvalidationparms);
        }
        return new DERSequence(asn1encodablevector);
    }
}
