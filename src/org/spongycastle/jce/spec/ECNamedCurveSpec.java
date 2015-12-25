// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.FiniteField;

public class ECNamedCurveSpec extends ECParameterSpec
{

    public String name;

    public ECNamedCurveSpec(String s, EllipticCurve ellipticcurve, java.security.spec.ECPoint ecpoint, BigInteger biginteger, BigInteger biginteger1)
    {
        super(ellipticcurve, ecpoint, biginteger, biginteger1.intValue());
        name = s;
    }

    public ECNamedCurveSpec(String s, ECCurve eccurve, ECPoint ecpoint, BigInteger biginteger, BigInteger biginteger1, byte abyte0[])
    {
        if (ECAlgorithms._mth141D(eccurve))
        {
            eccurve = new EllipticCurve(new ECFieldFp(eccurve.FB25()._mth0506()), eccurve.FB46().toBigInteger(), eccurve.FB4C().toBigInteger(), abyte0);
        } else
        {
            org.spongycastle.math.ec.ECCurve.F2m f2m = (org.spongycastle.math.ec.ECCurve.F2m)eccurve;
            boolean flag;
            if (f2m.avk == 0 && f2m.avl == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                int i = f2m.avj;
                eccurve = new EllipticCurve(new ECFieldF2m(f2m.afJ, new int[] {
                    i
                }), eccurve.FB46().toBigInteger(), eccurve.FB4C().toBigInteger(), abyte0);
            } else
            {
                int j = f2m.avl;
                int k = f2m.avk;
                int l = f2m.avj;
                eccurve = new EllipticCurve(new ECFieldF2m(f2m.afJ, new int[] {
                    j, k, l
                }), eccurve.FB46().toBigInteger(), eccurve.FB4C().toBigInteger(), abyte0);
            }
        }
        ecpoint = ecpoint._mth0188();
        super(eccurve, new java.security.spec.ECPoint(ecpoint.FF8A().toBigInteger(), ecpoint.FF93().toBigInteger()), biginteger, biginteger1.intValue());
        name = s;
    }
}
