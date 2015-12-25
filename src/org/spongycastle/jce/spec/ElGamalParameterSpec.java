// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ElGamalParameterSpec
    implements AlgorithmParameterSpec
{

    public BigInteger amM;
    public BigInteger amO;

    public ElGamalParameterSpec(BigInteger biginteger, BigInteger biginteger1)
    {
        amM = biginteger;
        amO = biginteger1;
    }
}
