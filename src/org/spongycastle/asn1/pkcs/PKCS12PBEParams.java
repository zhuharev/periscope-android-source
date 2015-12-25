// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class PKCS12PBEParams extends ASN1Object
{

    public ASN1OctetString Yk;
    public ASN1Integer aaV;

    private PKCS12PBEParams(ASN1Sequence asn1sequence)
    {
        Yk = (ASN1OctetString)asn1sequence._mth144B(0);
        aaV = ASN1Integer.FB1D(asn1sequence._mth144B(1));
    }

    public PKCS12PBEParams(byte abyte0[], int i)
    {
        Yk = new DEROctetString(abyte0);
        aaV = new ASN1Integer(i);
    }

    public static PKCS12PBEParams _mth02D1(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof PKCS12PBEParams)
        {
            return (PKCS12PBEParams)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new PKCS12PBEParams(ASN1Sequence._mth141F(asn1encodable));
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
        obj = aaV;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
