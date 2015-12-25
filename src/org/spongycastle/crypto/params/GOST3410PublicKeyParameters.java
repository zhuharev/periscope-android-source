// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto.params:
//            GOST3410KeyParameters, GOST3410Parameters

public class GOST3410PublicKeyParameters extends GOST3410KeyParameters
{

    public BigInteger axe;

    public GOST3410PublicKeyParameters(BigInteger biginteger, GOST3410Parameters gost3410parameters)
    {
        super(false, gost3410parameters);
        axe = biginteger;
    }
}
