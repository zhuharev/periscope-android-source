// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.field.FiniteFields;

// Referenced classes of package org.spongycastle.math.ec:
//            ECCurve, ECFieldElement, ECPoint

public static abstract class _cls8 extends ECCurve
{

    protected final ECPoint _mth02CB(int i, BigInteger biginteger)
    {
        ECFieldElement ecfieldelement1 = _mth02BB(biginteger);
        ECFieldElement ecfieldelement = ecfieldelement1.FF4C()._mth02CE(aIr)._mth141D(ecfieldelement1)._mth02CE(aIs).FF52();
        if (ecfieldelement == null)
        {
            throw new IllegalArgumentException("Invalid point compression");
        }
        boolean flag1 = ecfieldelement.FF66();
        boolean flag;
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        biginteger = ecfieldelement;
        if (flag1 != flag)
        {
            biginteger = ecfieldelement.FF29();
        }
        return _mth02CA(ecfieldelement1, biginteger, true);
    }

    public (BigInteger biginteger)
    {
        super(FiniteFields._mth02C8(biginteger));
    }
}
