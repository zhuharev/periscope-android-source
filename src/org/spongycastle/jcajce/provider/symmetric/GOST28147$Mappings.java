// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            GOST28147

public static class  extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/GOST28147.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("Cipher.GOST28147", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640("Alg.Alias.Cipher.GOST", "GOST28147");
        configurableprovider._mth0640("Alg.Alias.Cipher.GOST-28147", "GOST28147");
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(CryptoProObjectIdentifiers.XQ).toString(), (new StringBuilder()).append(PREFIX).append("$GCFB").toString());
        configurableprovider._mth0640("KeyGenerator.GOST28147", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640("Alg.Alias.KeyGenerator.GOST", "GOST28147");
        configurableprovider._mth0640("Alg.Alias.KeyGenerator.GOST-28147", "GOST28147");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyGenerator.")).append(CryptoProObjectIdentifiers.XQ).toString(), "GOST28147");
        configurableprovider._mth0640("Mac.GOST28147MAC", (new StringBuilder()).append(PREFIX).append("$Mac").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.GOST28147", "GOST28147MAC");
    }


    public ()
    {
    }
}
