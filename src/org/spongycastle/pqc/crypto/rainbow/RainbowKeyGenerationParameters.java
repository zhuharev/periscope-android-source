// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

// Referenced classes of package org.spongycastle.pqc.crypto.rainbow:
//            RainbowParameters

public class RainbowKeyGenerationParameters extends KeyGenerationParameters
{

    RainbowParameters aNA;

    public RainbowKeyGenerationParameters(SecureRandom securerandom, RainbowParameters rainbowparameters)
    {
        super(securerandom, rainbowparameters.aNI[rainbowparameters.aNI.length - 1] - rainbowparameters.aNI[0]);
        aNA = rainbowparameters;
    }
}
