// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.misc;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class CAST5CBCParameters extends ASN1Object
{

    public ASN1OctetString Yk;
    public ASN1Integer Zt;

    private CAST5CBCParameters(ASN1Sequence asn1sequence)
    {
        Yk = (ASN1OctetString)asn1sequence._mth144B(0);
        Zt = (ASN1Integer)asn1sequence._mth144B(1);
    }

    public CAST5CBCParameters(byte abyte0[], int i)
    {
        Yk = new DEROctetString(abyte0);
        Zt = new ASN1Integer(i);
    }

    public static CAST5CBCParameters _mth02CE(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new CAST5CBCParameters(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = Yk;
        asn1encodablevector.VS.addElement(obj);
        obj = Zt;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
