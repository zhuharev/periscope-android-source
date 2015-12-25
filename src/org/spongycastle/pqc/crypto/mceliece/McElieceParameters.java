// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceParameters
    implements CipherParameters
{

    int aJP;
    int aLS;
    int afJ;
    int axg;

    public McElieceParameters()
    {
        this(11, 50);
    }

    public McElieceParameters(int i, int j)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("m must be positive");
        }
        if (i > 32)
        {
            throw new IllegalArgumentException("m is too large");
        }
        afJ = i;
        axg = 1 << i;
        if (j < 0)
        {
            throw new IllegalArgumentException("t must be positive");
        }
        if (j > axg)
        {
            throw new IllegalArgumentException("t must be less than n = 2^m");
        } else
        {
            aJP = j;
            aLS = PolynomialRingGF2._mth0433(i);
            return;
        }
    }
}
