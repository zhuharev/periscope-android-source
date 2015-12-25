// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class RC2CBCParameter extends ASN1Object
{

    public ASN1OctetString Yk;
    public ASN1Integer ada;

    public RC2CBCParameter(int i, byte abyte0[])
    {
        ada = new ASN1Integer(i);
        Yk = new DEROctetString(abyte0);
    }

    private RC2CBCParameter(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() == 1)
        {
            ada = null;
            Yk = (ASN1OctetString)asn1sequence._mth144B(0);
            return;
        } else
        {
            ada = (ASN1Integer)asn1sequence._mth144B(0);
            Yk = (ASN1OctetString)asn1sequence._mth144B(1);
            return;
        }
    }

    public RC2CBCParameter(byte abyte0[])
    {
        ada = null;
        Yk = new DEROctetString(abyte0);
    }

    public static RC2CBCParameter _mth02BB(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new RC2CBCParameter(ASN1Sequence._mth141F(asn1primitive));
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
        }
        ASN1OctetString asn1octetstring = Yk;
        asn1encodablevector.VS.addElement(asn1octetstring);
        return new DERSequence(asn1encodablevector);
    }
}
