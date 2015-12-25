// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto.params:
//            CramerShoupKeyParameters, CramerShoupParameters

public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters
{

    private BigInteger als;
    private BigInteger awY;
    private BigInteger awZ;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramershoupparameters, BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        super(false, cramershoupparameters);
        awY = biginteger;
        awZ = biginteger1;
        als = biginteger2;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof CramerShoupPublicKeyParameters))
        {
            return false;
        }
        CramerShoupPublicKeyParameters cramershouppublickeyparameters = (CramerShoupPublicKeyParameters)obj;
        return cramershouppublickeyparameters.awY.equals(awY) && cramershouppublickeyparameters.awZ.equals(awZ) && cramershouppublickeyparameters.als.equals(als) && super.equals(obj);
    }

    public int hashCode()
    {
        return awY.hashCode() ^ awZ.hashCode() ^ als.hashCode() ^ super.hashCode();
    }
}
