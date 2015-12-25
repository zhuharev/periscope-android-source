// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;

import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.crypto:
//            KeyGenerationParameters

public class CipherKeyGenerator
{

    public SecureRandom amC;
    public int amD;

    public CipherKeyGenerator()
    {
    }

    public void _mth02CA(KeyGenerationParameters keygenerationparameters)
    {
        amC = keygenerationparameters.amC;
        amD = (keygenerationparameters.amD + 7) / 8;
    }

    public byte[] _mth14AE()
    {
        byte abyte0[] = new byte[amD];
        amC.nextBytes(abyte0);
        return abyte0;
    }
}
