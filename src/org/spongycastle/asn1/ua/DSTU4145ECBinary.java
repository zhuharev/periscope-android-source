// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.ua;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.ua:
//            DSTU4145BinaryField

public class DSTU4145ECBinary extends ASN1Object
{

    public ASN1Integer Ys;
    private BigInteger adh;
    public DSTU4145BinaryField afN;
    public ASN1OctetString afO;
    public ASN1Integer afP;
    public ASN1OctetString afQ;

    private DSTU4145ECBinary(ASN1Sequence asn1sequence)
    {
        adh = BigInteger.valueOf(0L);
        int i = 0;
        if (asn1sequence._mth144B(0) instanceof ASN1TaggedObject)
        {
            ASN1TaggedObject asn1taggedobject = (ASN1TaggedObject)asn1sequence._mth144B(0);
            if (asn1taggedobject.Wm && asn1taggedobject.Wk == 0)
            {
                adh = new BigInteger(ASN1Integer.FB1D(asn1taggedobject._mth0505()).bytes);
                i = 0 + 1;
            } else
            {
                throw new IllegalArgumentException("object parse error");
            }
        }
        afN = DSTU4145BinaryField._mth1428(asn1sequence._mth144B(i));
        i++;
        Ys = ASN1Integer.FB1D(asn1sequence._mth144B(i));
        i++;
        afO = ASN1OctetString.FB39(asn1sequence._mth144B(i));
        i++;
        afP = ASN1Integer.FB1D(asn1sequence._mth144B(i));
        afQ = ASN1OctetString.FB39(asn1sequence._mth144B(i + 1));
    }

    public static DSTU4145ECBinary FE73(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof DSTU4145ECBinary)
        {
            return (DSTU4145ECBinary)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new DSTU4145ECBinary(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (adh.compareTo(BigInteger.valueOf(0L)) != 0)
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(true, 0, new ASN1Integer(adh));
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        Object obj = afN;
        asn1encodablevector.VS.addElement(obj);
        obj = Ys;
        asn1encodablevector.VS.addElement(obj);
        obj = afO;
        asn1encodablevector.VS.addElement(obj);
        obj = afP;
        asn1encodablevector.VS.addElement(obj);
        obj = afQ;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
