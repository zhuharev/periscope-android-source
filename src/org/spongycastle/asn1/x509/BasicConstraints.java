// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class BasicConstraints extends ASN1Object
{

    private ASN1Boolean aim;
    public ASN1Integer ain;

    private BasicConstraints(ASN1Sequence asn1sequence)
    {
        aim = ASN1Boolean._mth02E3(false);
        ain = null;
        if (asn1sequence.size() == 0)
        {
            aim = null;
            ain = null;
            return;
        }
        if (asn1sequence._mth144B(0) instanceof ASN1Boolean)
        {
            aim = ASN1Boolean._mth02CA(asn1sequence._mth144B(0));
        } else
        {
            aim = null;
            ain = ASN1Integer.FB1D(asn1sequence._mth144B(0));
        }
        if (asn1sequence.size() > 1)
        {
            if (aim != null)
            {
                ain = ASN1Integer.FB1D(asn1sequence._mth144B(1));
                return;
            } else
            {
                throw new IllegalArgumentException("wrong sequence in constructor");
            }
        } else
        {
            return;
        }
    }

    public static BasicConstraints _mth1FBE(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new BasicConstraints(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        if (ain == null)
        {
            if (aim == null)
            {
                return "BasicConstraints: isCa(false)";
            } else
            {
                return (new StringBuilder("BasicConstraints: isCa(")).append(_mth09B6()).append(")").toString();
            }
        } else
        {
            return (new StringBuilder("BasicConstraints: isCa(")).append(_mth09B6()).append("), pathLenConstraint = ").append(new BigInteger(ain.bytes)).toString();
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (aim != null)
        {
            ASN1Boolean asn1boolean = aim;
            asn1encodablevector.VS.addElement(asn1boolean);
        }
        if (ain != null)
        {
            ASN1Integer asn1integer = ain;
            asn1encodablevector.VS.addElement(asn1integer);
        }
        return new DERSequence(asn1encodablevector);
    }

    public final boolean _mth09B6()
    {
        if (aim != null)
        {
            boolean flag;
            if (aim.VP[0] != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }
}
