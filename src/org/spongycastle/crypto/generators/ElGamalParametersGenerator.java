// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.security.SecureRandom;
import org.spongycastle.crypto.params.ElGamalParameters;

// Referenced classes of package org.spongycastle.crypto.generators:
//            DHParametersHelper

public class ElGamalParametersGenerator
{

    public SecureRandom amC;
    public int atV;
    public int size;

    public ElGamalParametersGenerator()
    {
    }

    public final ElGamalParameters FF55()
    {
        java.math.BigInteger biginteger = DHParametersHelper._mth02CA(size, atV, amC)[0];
        return new ElGamalParameters(biginteger, DHParametersHelper._mth02CB(biginteger, amC));
    }
}
