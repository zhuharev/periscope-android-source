// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;
import java.util.Vector;

// Referenced classes of package org.spongycastle.crypto.params:
//            NaccacheSternKeyParameters

public class NaccacheSternPrivateKeyParameters extends NaccacheSternKeyParameters
{

    public BigInteger axA;
    public Vector axB;

    public NaccacheSternPrivateKeyParameters(BigInteger biginteger, BigInteger biginteger1, int i, Vector vector, BigInteger biginteger2)
    {
        super(true, biginteger, biginteger1, i);
        axB = vector;
        axA = biginteger2;
    }
}
