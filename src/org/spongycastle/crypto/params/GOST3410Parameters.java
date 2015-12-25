// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class GOST3410Parameters
    implements CipherParameters
{

    public BigInteger amM;
    public BigInteger amN;
    public BigInteger amW;

    public GOST3410Parameters(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        amM = biginteger;
        amN = biginteger1;
        amW = biginteger2;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof GOST3410Parameters))
        {
            return false;
        }
        obj = (GOST3410Parameters)obj;
        return ((GOST3410Parameters) (obj)).amM.equals(amM) && ((GOST3410Parameters) (obj)).amN.equals(amN) && ((GOST3410Parameters) (obj)).amW.equals(amW);
    }

    public int hashCode()
    {
        return amM.hashCode() ^ amN.hashCode() ^ amW.hashCode();
    }
}
