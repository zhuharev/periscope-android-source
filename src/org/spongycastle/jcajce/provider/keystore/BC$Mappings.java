// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.keystore;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.keystore:
//            BC

public static class ovider extends AsymmetricAlgorithmProvider
{

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("KeyStore.BKS", "org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$Std");
        configurableprovider._mth0640("KeyStore.BKS-V1", "org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$Version1");
        configurableprovider._mth0640("KeyStore.BouncyCastle", "org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$BouncyCastleStore");
        configurableprovider._mth0640("Alg.Alias.KeyStore.UBER", "BouncyCastle");
        configurableprovider._mth0640("Alg.Alias.KeyStore.BOUNCYCASTLE", "BouncyCastle");
        configurableprovider._mth0640("Alg.Alias.KeyStore.spongycastle", "BouncyCastle");
    }

    public ovider()
    {
    }
}
