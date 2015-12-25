// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

// Referenced classes of package org.spongycastle.crypto.params:
//            DHValidationParameters

public class DHParameters
    implements CipherParameters
{

    public int afJ;
    public int afM;
    public BigInteger amM;
    public BigInteger amN;
    public BigInteger amO;
    private BigInteger axc;
    private DHValidationParameters axd;

    public DHParameters(BigInteger biginteger, BigInteger biginteger1)
    {
        this(biginteger, biginteger1, null, 0);
    }

    public DHParameters(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        this(biginteger, biginteger1, biginteger2, 0);
    }

    public DHParameters(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, int i)
    {
        int j;
        if (i != 0 && i < 160)
        {
            j = i;
        } else
        {
            j = 160;
        }
        this(biginteger, biginteger1, biginteger2, j, i, null, null);
    }

    private DHParameters(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, int i, int j, BigInteger biginteger3, DHValidationParameters dhvalidationparameters)
    {
        if (j != 0)
        {
            if (BigInteger.valueOf((long)(j - 1) ^ 2L).compareTo(biginteger) == 1)
            {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
            if (j < i)
            {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        amO = biginteger1;
        amM = biginteger;
        amN = biginteger2;
        afJ = i;
        afM = j;
        axc = biginteger3;
        axd = dhvalidationparameters;
    }

    public DHParameters(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, BigInteger biginteger3, DHValidationParameters dhvalidationparameters)
    {
        this(biginteger, biginteger1, biginteger2, 160, 0, biginteger3, dhvalidationparameters);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DHParameters))
        {
            return false;
        }
        obj = (DHParameters)obj;
        if (amN != null)
        {
            if (!amN.equals(((DHParameters) (obj)).amN))
            {
                return false;
            }
        } else
        if (((DHParameters) (obj)).amN != null)
        {
            return false;
        }
        return ((DHParameters) (obj)).amM.equals(amM) && ((DHParameters) (obj)).amO.equals(amO);
    }

    public int hashCode()
    {
        int j = amM.hashCode();
        int k = amO.hashCode();
        int i;
        if (amN != null)
        {
            i = amN.hashCode();
        } else
        {
            i = 0;
        }
        return j ^ k ^ i;
    }
}
