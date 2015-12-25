// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto.params:
//            AsymmetricKeyParameter

public class NaccacheSternKeyParameters extends AsymmetricKeyParameter
{

    public BigInteger alr;
    public BigInteger amO;
    public int axz;

    public NaccacheSternKeyParameters(boolean flag, BigInteger biginteger, BigInteger biginteger1, int i)
    {
        super(flag);
        amO = biginteger;
        alr = biginteger1;
        axz = i;
    }
}
