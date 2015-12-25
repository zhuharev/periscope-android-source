// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto.params:
//            RSAKeyParameters

public class RSAPrivateCrtKeyParameters extends RSAKeyParameters
{

    public BigInteger amM;
    public BigInteger amN;
    public BigInteger axF;
    public BigInteger axG;
    public BigInteger axH;
    public BigInteger axI;

    public RSAPrivateCrtKeyParameters(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, BigInteger biginteger3, BigInteger biginteger4, BigInteger biginteger5, BigInteger biginteger6, 
            BigInteger biginteger7)
    {
        super(true, biginteger, biginteger2);
        axF = biginteger1;
        amM = biginteger3;
        amN = biginteger4;
        axG = biginteger5;
        axH = biginteger6;
        axI = biginteger7;
    }
}
