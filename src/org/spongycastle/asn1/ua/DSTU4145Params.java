// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.ua;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.asn1.ua:
//            DSTU4145ECBinary

public class DSTU4145Params extends ASN1Object
{

    private static final byte afU[] = {
        -87, -42, -21, 69, -15, 60, 112, -126, -128, -60, 
        -106, 123, 35, 31, 94, -83, -10, 88, -21, -92, 
        -64, 55, 41, 29, 56, -39, 107, -16, 37, -54, 
        78, 23, -8, -23, 114, 13, -58, 21, -76, 58, 
        40, -105, 95, 11, -63, -34, -93, 100, 56, -75, 
        100, -22, 44, 23, -97, -48, 18, 62, 109, -72, 
        -6, -59, 121, 4
    };
    public ASN1ObjectIdentifier afV;
    public DSTU4145ECBinary afW;
    public byte afX[];

    public DSTU4145Params(ASN1ObjectIdentifier asn1objectidentifier)
    {
        afX = afU;
        afV = asn1objectidentifier;
    }

    private DSTU4145Params(DSTU4145ECBinary dstu4145ecbinary)
    {
        afX = afU;
        afW = dstu4145ecbinary;
    }

    public static byte[] _mth0997()
    {
        return afU;
    }

    public static DSTU4145Params _mth141D(ASN1Sequence asn1sequence)
    {
        if (asn1sequence != null)
        {
            ASN1Sequence asn1sequence1 = ASN1Sequence._mth141F(asn1sequence);
            if (asn1sequence1._mth144B(0) instanceof ASN1ObjectIdentifier)
            {
                asn1sequence = new DSTU4145Params(ASN1ObjectIdentifier._mth02CE(asn1sequence1._mth144B(0)));
            } else
            {
                asn1sequence = new DSTU4145Params(DSTU4145ECBinary.FE73(asn1sequence1._mth144B(0)));
            }
            if (asn1sequence1.size() == 2)
            {
                asn1sequence.afX = ASN1OctetString.FB39(asn1sequence1._mth144B(1))._mth0501();
                if (((DSTU4145Params) (asn1sequence)).afX.length != 64)
                {
                    throw new IllegalArgumentException("object parse error");
                }
            }
            return asn1sequence;
        } else
        {
            throw new IllegalArgumentException("object parse error");
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (afV != null)
        {
            ASN1ObjectIdentifier asn1objectidentifier = afV;
            asn1encodablevector.VS.addElement(asn1objectidentifier);
        } else
        {
            DSTU4145ECBinary dstu4145ecbinary = afW;
            asn1encodablevector.VS.addElement(dstu4145ecbinary);
        }
        if (!Arrays._mth1427(afX, afU))
        {
            DEROctetString deroctetstring = new DEROctetString(afX);
            asn1encodablevector.VS.addElement(deroctetstring);
        }
        return new DERSequence(asn1encodablevector);
    }

}
