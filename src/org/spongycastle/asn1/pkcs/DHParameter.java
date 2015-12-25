// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DHParameter extends ASN1Object
{

    public ASN1Integer Yq;
    public ASN1Integer aaI;
    public ASN1Integer aat;

    public DHParameter(BigInteger biginteger, BigInteger biginteger1, int i)
    {
        Yq = new ASN1Integer(biginteger);
        aat = new ASN1Integer(biginteger1);
        if (i != 0)
        {
            aaI = new ASN1Integer(i);
            return;
        } else
        {
            aaI = null;
            return;
        }
    }

    private DHParameter(ASN1Sequence asn1sequence)
    {
        asn1sequence = asn1sequence._mth0675();
        Yq = ASN1Integer.FB1D(asn1sequence.nextElement());
        aat = ASN1Integer.FB1D(asn1sequence.nextElement());
        if (asn1sequence.hasMoreElements())
        {
            aaI = (ASN1Integer)asn1sequence.nextElement();
            return;
        } else
        {
            aaI = null;
            return;
        }
    }

    public static DHParameter _mth15EE(Object obj)
    {
        if (obj instanceof DHParameter)
        {
            return (DHParameter)obj;
        }
        if (obj != null)
        {
            return new DHParameter(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = Yq;
        asn1encodablevector.VS.addElement(obj);
        obj = aat;
        asn1encodablevector.VS.addElement(obj);
        if (aaI == null)
        {
            obj = null;
        } else
        {
            obj = new BigInteger(1, aaI.bytes);
        }
        if (obj != null)
        {
            ASN1Integer asn1integer = aaI;
            asn1encodablevector.VS.addElement(asn1integer);
        }
        return new DERSequence(asn1encodablevector);
    }
}
