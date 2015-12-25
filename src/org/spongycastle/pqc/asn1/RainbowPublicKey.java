// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.asn1;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;

public class RainbowPublicKey extends ASN1Object
{

    private ASN1ObjectIdentifier aFE;
    public ASN1Integer aKl;
    public byte aKm[][];
    public byte aKn[][];
    public byte aKo[];
    private ASN1Integer ada;

    public RainbowPublicKey(int i, short aword0[][], short aword1[][], short aword2[])
    {
        ada = new ASN1Integer(0L);
        aKl = new ASN1Integer(i);
        aKm = RainbowUtil._mth02CB(aword0);
        aKn = RainbowUtil._mth02CB(aword1);
        aKo = RainbowUtil._mth02CA(aword2);
    }

    private RainbowPublicKey(ASN1Sequence asn1sequence)
    {
        if (asn1sequence._mth144B(0) instanceof ASN1Integer)
        {
            ada = ASN1Integer.FB1D(asn1sequence._mth144B(0));
        } else
        {
            aFE = ASN1ObjectIdentifier._mth02CE(asn1sequence._mth144B(0));
        }
        aKl = ASN1Integer.FB1D(asn1sequence._mth144B(1));
        ASN1Sequence asn1sequence1 = ASN1Sequence._mth141F(asn1sequence._mth144B(2));
        aKm = new byte[asn1sequence1.size()][];
        for (int i = 0; i < asn1sequence1.size(); i++)
        {
            aKm[i] = ASN1OctetString.FB39(asn1sequence1._mth144B(i))._mth0501();
        }

        asn1sequence1 = (ASN1Sequence)asn1sequence._mth144B(3);
        aKn = new byte[asn1sequence1.size()][];
        for (int j = 0; j < asn1sequence1.size(); j++)
        {
            aKn[j] = ASN1OctetString.FB39(asn1sequence1._mth144B(j))._mth0501();
        }

        aKo = ASN1OctetString.FB39(((ASN1Sequence)asn1sequence._mth144B(4))._mth144B(0))._mth0501();
    }

    public static RainbowPublicKey _mth1427(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new RainbowPublicKey(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (ada != null)
        {
            ASN1Integer asn1integer = ada;
            asn1encodablevector.VS.addElement(asn1integer);
        } else
        {
            ASN1ObjectIdentifier asn1objectidentifier = aFE;
            asn1encodablevector.VS.addElement(asn1objectidentifier);
        }
        Object obj = aKl;
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1EncodableVector();
        for (int i = 0; i < aKm.length; i++)
        {
            DEROctetString deroctetstring = new DEROctetString(aKm[i]);
            ((ASN1EncodableVector) (obj)).VS.addElement(deroctetstring);
        }

        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1EncodableVector();
        for (int j = 0; j < aKn.length; j++)
        {
            DEROctetString deroctetstring1 = new DEROctetString(aKn[j]);
            ((ASN1EncodableVector) (obj)).VS.addElement(deroctetstring1);
        }

        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1EncodableVector();
        DEROctetString deroctetstring2 = new DEROctetString(aKo);
        ((ASN1EncodableVector) (obj)).VS.addElement(deroctetstring2);
        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
