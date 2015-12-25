// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DESedeParameters;

// Referenced classes of package org.spongycastle.crypto.generators:
//            DESKeyGenerator

public class DESedeKeyGenerator extends DESKeyGenerator
{

    public DESedeKeyGenerator()
    {
    }

    public final void _mth02CA(KeyGenerationParameters keygenerationparameters)
    {
        amC = keygenerationparameters.amC;
        amD = (keygenerationparameters.amD + 7) / 8;
        if (amD == 0 || amD == 21)
        {
            amD = 24;
            return;
        }
        if (amD == 14)
        {
            amD = 16;
            return;
        }
        if (amD != 24 && amD != 16)
        {
            throw new IllegalArgumentException("DESede key must be 192 or 128 bits long.");
        } else
        {
            return;
        }
    }

    public final byte[] _mth14AE()
    {
        byte abyte0[] = new byte[amD];
        do
        {
            amC.nextBytes(abyte0);
            DESedeParameters._mth1D55(abyte0);
        } while (DESedeParameters.FE73(abyte0, 0, abyte0.length));
        return abyte0;
    }
}
