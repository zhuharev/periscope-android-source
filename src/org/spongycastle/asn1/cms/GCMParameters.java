// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cms;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;

public class GCMParameters extends ASN1Object
{

    public byte XD[];
    public int XE;

    private GCMParameters(ASN1Sequence asn1sequence)
    {
        XD = ASN1OctetString.FB39(asn1sequence._mth144B(0))._mth0501();
        if (asn1sequence.size() == 2)
        {
            XE = (new BigInteger(ASN1Integer.FB1D(asn1sequence._mth144B(1)).bytes)).intValue();
            return;
        } else
        {
            XE = 12;
            return;
        }
    }

    public GCMParameters(byte abyte0[], int i)
    {
        XD = Arrays._mth1D4C(abyte0);
        XE = i;
    }

    public static GCMParameters _mth1507(Object obj)
    {
        if (obj != null)
        {
            return new GCMParameters(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        DEROctetString deroctetstring = new DEROctetString(XD);
        asn1encodablevector.VS.addElement(deroctetstring);
        if (XE != 12)
        {
            ASN1Integer asn1integer = new ASN1Integer(XE);
            asn1encodablevector.VS.addElement(asn1integer);
        }
        return new DERSequence(asn1encodablevector);
    }
}
