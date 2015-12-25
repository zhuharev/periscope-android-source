// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.spec;

import java.security.InvalidParameterException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class ECCKeyGenParameterSpec
    implements AlgorithmParameterSpec
{

    public int aJP;
    private int aLS;
    public int afJ;
    private int axg;

    public ECCKeyGenParameterSpec()
    {
        this(11, 50);
    }

    private ECCKeyGenParameterSpec(int i, int j)
    {
        afJ = 11;
        axg = 2048;
        if (50 > axg)
        {
            throw new InvalidParameterException("t must be less than n = 2^m");
        } else
        {
            aJP = 50;
            aLS = PolynomialRingGF2._mth0433(11);
            return;
        }
    }
}
