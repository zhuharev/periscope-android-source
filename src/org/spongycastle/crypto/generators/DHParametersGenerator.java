// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.DHParameters;

// Referenced classes of package org.spongycastle.crypto.generators:
//            DHParametersHelper

public class DHParametersGenerator
{

    private static final BigInteger ars = BigInteger.valueOf(2L);
    public SecureRandom amC;
    public int atV;
    public int size;

    public DHParametersGenerator()
    {
    }

    public final DHParameters FE94()
    {
        BigInteger abiginteger[] = DHParametersHelper._mth02CA(size, atV, amC);
        BigInteger biginteger = abiginteger[0];
        BigInteger biginteger1 = abiginteger[1];
        return new DHParameters(biginteger, DHParametersHelper._mth02CB(biginteger, amC), biginteger1, ars, null);
    }

}
