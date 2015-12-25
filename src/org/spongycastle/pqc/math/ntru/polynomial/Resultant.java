// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            BigIntPolynomial

public class Resultant
{

    public BigIntPolynomial aPi;
    public BigInteger aPj;

    Resultant(BigIntPolynomial bigintpolynomial, BigInteger biginteger)
    {
        aPi = bigintpolynomial;
        aPj = biginteger;
    }
}
