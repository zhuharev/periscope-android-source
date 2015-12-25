// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.security.SecureRandom;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.generators.DESedeKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            DESede

public static class aFx extends BaseKeyGenerator
{

    private boolean aFx;

    protected SecretKey engineGenerateKey()
    {
        if (aFV)
        {
            aFU._mth02CA(new KeyGenerationParameters(new SecureRandom(), aFT));
            aFV = false;
        }
        if (!aFx)
        {
            byte abyte0[] = aFU._mth14AE();
            System.arraycopy(abyte0, 0, abyte0, 16, 8);
            return new SecretKeySpec(abyte0, aFS);
        } else
        {
            return new SecretKeySpec(aFU._mth14AE(), aFS);
        }
    }

    protected void engineInit(int i, SecureRandom securerandom)
    {
        super.engineInit(i, securerandom);
        aFx = true;
    }

    public r()
    {
        super("DESede", 192, new DESedeKeyGenerator());
        aFx = false;
    }
}
