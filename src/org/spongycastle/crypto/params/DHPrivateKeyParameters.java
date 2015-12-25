// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto.params:
//            DHKeyParameters, DHParameters

public class DHPrivateKeyParameters extends DHKeyParameters
{

    public BigInteger amZ;

    public DHPrivateKeyParameters(BigInteger biginteger, DHParameters dhparameters)
    {
        super(true, dhparameters);
        amZ = biginteger;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DHPrivateKeyParameters))
        {
            return false;
        }
        return ((DHPrivateKeyParameters)obj).amZ.equals(amZ) && super.equals(obj);
    }

    public int hashCode()
    {
        return amZ.hashCode() ^ super.hashCode();
    }
}
