// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.ec.ECFieldElement;

// Referenced classes of package org.spongycastle.asn1.x9:
//            X9IntegerConverter

public class X9FieldElement extends ASN1Object
{

    private static X9IntegerConverter alw = new X9IntegerConverter();
    private ECFieldElement alv;

    public X9FieldElement(int i, int j, int k, int l, ASN1OctetString asn1octetstring)
    {
        this(((ECFieldElement) (new org.spongycastle.math.ec.ECFieldElement.F2m(i, j, k, l, new BigInteger(1, asn1octetstring._mth0501())))));
    }

    public X9FieldElement(BigInteger biginteger, ASN1OctetString asn1octetstring)
    {
        this(((ECFieldElement) (new org.spongycastle.math.ec.ECFieldElement.Fp(biginteger, new BigInteger(1, asn1octetstring._mth0501())))));
    }

    public X9FieldElement(ECFieldElement ecfieldelement)
    {
        alv = ecfieldelement;
    }

    public final ASN1Primitive _mth0427()
    {
        int i = X9IntegerConverter._mth02CB(alv);
        return new DEROctetString(X9IntegerConverter._mth02CA(alv.toBigInteger(), i));
    }

    public final ECFieldElement _mth1439()
    {
        return alv;
    }

}
