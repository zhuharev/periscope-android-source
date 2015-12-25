// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.endo.GLVEndomorphism;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, ECCurve, ECPoint, ECAlgorithms

public class GLVMultiplier extends AbstractECMultiplier
{

    private GLVEndomorphism aIN;
    private ECCurve alm;

    public GLVMultiplier(ECCurve eccurve, GLVEndomorphism glvendomorphism)
    {
        if (eccurve == null || eccurve.getOrder() == null)
        {
            throw new IllegalArgumentException("Need curve with known group order");
        } else
        {
            alm = eccurve;
            aIN = glvendomorphism;
            return;
        }
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        if (!alm._mth02BB(ecpoint.FF79()))
        {
            throw new IllegalStateException();
        } else
        {
            BigInteger biginteger1 = ecpoint.FF79().getOrder();
            BigInteger abiginteger[] = aIN._mth02BF(biginteger.mod(biginteger1));
            biginteger = abiginteger[0];
            abiginteger = abiginteger[1];
            return ECAlgorithms._mth02CA(ecpoint, biginteger, aIN._mth043D(), abiginteger);
        }
    }
}
