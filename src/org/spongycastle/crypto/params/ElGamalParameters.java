// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class ElGamalParameters
    implements CipherParameters
{

    public int afM;
    public BigInteger amM;
    public BigInteger amO;

    public ElGamalParameters(BigInteger biginteger, BigInteger biginteger1)
    {
        this(biginteger, biginteger1, 0);
    }

    public ElGamalParameters(BigInteger biginteger, BigInteger biginteger1, int i)
    {
        amO = biginteger1;
        amM = biginteger;
        afM = i;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof ElGamalParameters))
        {
            return false;
        }
        obj = (ElGamalParameters)obj;
        return ((ElGamalParameters) (obj)).amM.equals(amM) && ((ElGamalParameters) (obj)).amO.equals(amO) && ((ElGamalParameters) (obj)).afM == afM;
    }

    public int hashCode()
    {
        return (amM.hashCode() ^ amO.hashCode()) + afM;
    }
}
