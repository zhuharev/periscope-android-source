// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, ECAlgorithms, ECPoint

public class ReferenceMultiplier extends AbstractECMultiplier
{

    public ReferenceMultiplier()
    {
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        return ECAlgorithms._mth02CE(ecpoint, biginteger);
    }
}
