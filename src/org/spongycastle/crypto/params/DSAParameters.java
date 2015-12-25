// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

// Referenced classes of package org.spongycastle.crypto.params:
//            DSAValidationParameters

public class DSAParameters
    implements CipherParameters
{

    public BigInteger amM;
    public BigInteger amN;
    public BigInteger amO;
    private DSAValidationParameters axh;

    public DSAParameters(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        amO = biginteger2;
        amM = biginteger;
        amN = biginteger1;
    }

    public DSAParameters(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, DSAValidationParameters dsavalidationparameters)
    {
        amO = biginteger2;
        amM = biginteger;
        amN = biginteger1;
        axh = dsavalidationparameters;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DSAParameters))
        {
            return false;
        }
        obj = (DSAParameters)obj;
        return ((DSAParameters) (obj)).amM.equals(amM) && ((DSAParameters) (obj)).amN.equals(amN) && ((DSAParameters) (obj)).amO.equals(amO);
    }

    public int hashCode()
    {
        return amM.hashCode() ^ amN.hashCode() ^ amO.hashCode();
    }
}
