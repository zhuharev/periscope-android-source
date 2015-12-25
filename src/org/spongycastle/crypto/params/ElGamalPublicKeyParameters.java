// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto.params:
//            ElGamalKeyParameters, ElGamalParameters

public class ElGamalPublicKeyParameters extends ElGamalKeyParameters
{

    public BigInteger axe;

    public ElGamalPublicKeyParameters(BigInteger biginteger, ElGamalParameters elgamalparameters)
    {
        super(false, elgamalparameters);
        axe = biginteger;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof ElGamalPublicKeyParameters))
        {
            return false;
        }
        return ((ElGamalPublicKeyParameters)obj).axe.equals(axe) && super.equals(obj);
    }

    public int hashCode()
    {
        return axe.hashCode() ^ super.hashCode();
    }
}
