// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PublicKeySpec
    implements KeySpec
{

    public BigInteger amM;
    public BigInteger amN;
    public BigInteger amW;
    public BigInteger axe;

    public GOST3410PublicKeySpec(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, BigInteger biginteger3)
    {
        axe = biginteger;
        amM = biginteger1;
        amN = biginteger2;
        amW = biginteger3;
    }
}
