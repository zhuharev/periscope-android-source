// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.endo;

import java.math.BigInteger;

public class GLVTypeBParameters
{

    private BigInteger aJA[];
    private BigInteger aJB;
    private BigInteger aJC;
    private BigInteger aJx;
    private BigInteger aJy;
    private BigInteger aJz[];
    private int axD;

    public GLVTypeBParameters(BigInteger biginteger, BigInteger biginteger1, BigInteger abiginteger[], BigInteger abiginteger1[], BigInteger biginteger2, BigInteger biginteger3, int i)
    {
        aJx = biginteger;
        aJy = biginteger1;
        aJz = abiginteger;
        aJA = abiginteger1;
        aJB = biginteger2;
        aJC = biginteger3;
        axD = i;
    }

    public final BigInteger _mth043F()
    {
        return aJx;
    }

    public final BigInteger[] _mth0475()
    {
        return aJz;
    }

    public final BigInteger[] _mth0492()
    {
        return aJA;
    }

    public final BigInteger _mth04AC()
    {
        return aJB;
    }

    public final BigInteger _mth04DF()
    {
        return aJC;
    }

    public final int _mth04F4()
    {
        return axD;
    }
}
