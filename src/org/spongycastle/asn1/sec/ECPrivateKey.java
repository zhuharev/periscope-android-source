// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.sec;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.util.BigIntegers;

public class ECPrivateKey extends ASN1Object
{

    public ASN1Sequence adC;

    public ECPrivateKey(BigInteger biginteger, DERBitString derbitstring, ASN1Encodable asn1encodable)
    {
        byte abyte0[] = BigIntegers._mth02D1(biginteger);
        biginteger = new ASN1EncodableVector();
        ASN1Integer asn1integer = new ASN1Integer(1L);
        ((ASN1EncodableVector) (biginteger)).VS.addElement(asn1integer);
        DEROctetString deroctetstring = new DEROctetString(abyte0);
        ((ASN1EncodableVector) (biginteger)).VS.addElement(deroctetstring);
        if (asn1encodable != null)
        {
            asn1encodable = new DERTaggedObject(true, 0, asn1encodable);
            ((ASN1EncodableVector) (biginteger)).VS.addElement(asn1encodable);
        }
        if (derbitstring != null)
        {
            derbitstring = new DERTaggedObject(true, 1, derbitstring);
            ((ASN1EncodableVector) (biginteger)).VS.addElement(derbitstring);
        }
        adC = new DERSequence(biginteger);
    }

    public ECPrivateKey(BigInteger biginteger, X962Parameters x962parameters)
    {
        this(biginteger, null, ((ASN1Encodable) (x962parameters)));
    }

    private ECPrivateKey(ASN1Sequence asn1sequence)
    {
        adC = asn1sequence;
    }

    public static ECPrivateKey _mth1427(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof ECPrivateKey)
        {
            return (ECPrivateKey)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new ECPrivateKey(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return adC;
    }

    public final DERBitString _mth0930()
    {
        Object obj;
label0:
        {
            for (obj = adC._mth0675(); ((Enumeration) (obj)).hasMoreElements();)
            {
                Object obj1 = (ASN1Encodable)((Enumeration) (obj)).nextElement();
                if (obj1 instanceof ASN1TaggedObject)
                {
                    obj1 = (ASN1TaggedObject)obj1;
                    if (((ASN1TaggedObject) (obj1)).Wk == 1)
                    {
                        if (((ASN1TaggedObject) (obj1)).Wn != null)
                        {
                            obj = ((ASN1TaggedObject) (obj1)).Wn._mth0427();
                        } else
                        {
                            obj = null;
                        }
                        obj = ((ASN1Primitive) (obj))._mth0427();
                        break label0;
                    }
                }
            }

            obj = null;
        }
        return (DERBitString)obj;
    }
}
