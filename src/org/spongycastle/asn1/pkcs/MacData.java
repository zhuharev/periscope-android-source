// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
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
import org.spongycastle.asn1.x509.DigestInfo;

public class MacData extends ASN1Object
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    public DigestInfo aaM;
    public byte aaN[];
    public BigInteger aaO;

    private MacData(ASN1Sequence asn1sequence)
    {
        aaM = DigestInfo._mth2071(asn1sequence._mth144B(0));
        aaN = ((ASN1OctetString)asn1sequence._mth144B(1))._mth0501();
        if (asn1sequence.size() == 3)
        {
            aaO = new BigInteger(((ASN1Integer)asn1sequence._mth144B(2)).bytes);
            return;
        } else
        {
            aaO = ONE;
            return;
        }
    }

    public MacData(DigestInfo digestinfo, byte abyte0[], int i)
    {
        aaM = digestinfo;
        aaN = abyte0;
        aaO = BigInteger.valueOf(1024L);
    }

    public static MacData _mth02C9(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof MacData)
        {
            return (MacData)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new MacData(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aaM;
        asn1encodablevector.VS.addElement(obj);
        obj = new DEROctetString(aaN);
        asn1encodablevector.VS.addElement(obj);
        if (!aaO.equals(ONE))
        {
            ASN1Integer asn1integer = new ASN1Integer(aaO);
            asn1encodablevector.VS.addElement(asn1integer);
        }
        return new DERSequence(asn1encodablevector);
    }

}
