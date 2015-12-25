// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            PBEPBKDF2

public static class  extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/PBEPBKDF2.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("AlgorithmParameters.PBKDF2", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(PKCSObjectIdentifiers.abu).toString(), "PBKDF2");
        configurableprovider._mth0640("SecretKeyFactory.PBKDF2", (new StringBuilder()).append(PREFIX).append("$PBKDF2withUTF8").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abu).toString(), "PBKDF2");
    }


    public ()
    {
    }
}
