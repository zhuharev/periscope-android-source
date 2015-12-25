// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto.params:
//            CramerShoupKeyParameters, CramerShoupPublicKeyParameters, CramerShoupParameters

public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters
{

    public BigInteger awS;
    public BigInteger awT;
    public BigInteger awU;
    public BigInteger awV;
    public BigInteger awW;
    public CramerShoupPublicKeyParameters awX;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramershoupparameters, BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, BigInteger biginteger3, BigInteger biginteger4)
    {
        super(true, cramershoupparameters);
        awS = biginteger;
        awT = biginteger1;
        awU = biginteger2;
        awV = biginteger3;
        awW = biginteger4;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof CramerShoupPrivateKeyParameters))
        {
            return false;
        }
        CramerShoupPrivateKeyParameters cramershoupprivatekeyparameters = (CramerShoupPrivateKeyParameters)obj;
        return cramershoupprivatekeyparameters.awS.equals(awS) && cramershoupprivatekeyparameters.awT.equals(awT) && cramershoupprivatekeyparameters.awU.equals(awU) && cramershoupprivatekeyparameters.awV.equals(awV) && cramershoupprivatekeyparameters.awW.equals(awW) && super.equals(obj);
    }

    public int hashCode()
    {
        return awS.hashCode() ^ awT.hashCode() ^ awU.hashCode() ^ awV.hashCode() ^ awW.hashCode() ^ super.hashCode();
    }
}
