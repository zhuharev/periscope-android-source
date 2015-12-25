// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DESParameters;

public class DESKeyGenerator extends CipherKeyGenerator
{

    public DESKeyGenerator()
    {
    }

    public void _mth02CA(KeyGenerationParameters keygenerationparameters)
    {
        super._mth02CA(keygenerationparameters);
        if (amD == 0 || amD == 7)
        {
            amD = 8;
            return;
        }
        if (amD != 8)
        {
            throw new IllegalArgumentException("DES key must be 64 bits long.");
        } else
        {
            return;
        }
    }

    public byte[] _mth14AE()
    {
        byte abyte0[] = new byte[8];
        do
        {
            amC.nextBytes(abyte0);
            DESParameters._mth1D55(abyte0);
        } while (DESParameters._mth1428(abyte0, 0));
        return abyte0;
    }
}
