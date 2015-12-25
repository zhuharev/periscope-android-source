// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto.params:
//            DSAKeyParameters, DSAParameters

public class DSAPublicKeyParameters extends DSAKeyParameters
{

    public BigInteger axe;

    public DSAPublicKeyParameters(BigInteger biginteger, DSAParameters dsaparameters)
    {
        super(false, dsaparameters);
        axe = biginteger;
    }
}
