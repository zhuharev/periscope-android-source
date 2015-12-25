// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class SipHash
{
    public static class KeyGen extends BaseKeyGenerator
    {

        public KeyGen()
        {
            super("SipHash", 128, new CipherKeyGenerator());
        }
    }

    public static class Mac24 extends BaseMac
    {

        public Mac24()
        {
            super(new org.spongycastle.crypto.macs.SipHash());
        }
    }

    public static class Mac48 extends BaseMac
    {

        public Mac48()
        {
            super(new org.spongycastle.crypto.macs.SipHash(4, 8));
        }
    }

    public static class Mappings extends AlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/SipHash.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("Mac.SIPHASH-2-4", (new StringBuilder()).append(PREFIX).append("$Mac24").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.SIPHASH", "SIPHASH-2-4");
            configurableprovider._mth0640("Mac.SIPHASH-4-8", (new StringBuilder()).append(PREFIX).append("$Mac48").toString());
            configurableprovider._mth0640("KeyGenerator.SIPHASH", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            configurableprovider._mth0640("Alg.Alias.KeyGenerator.SIPHASH-2-4", "SIPHASH");
            configurableprovider._mth0640("Alg.Alias.KeyGenerator.SIPHASH-4-8", "SIPHASH");
        }


        public Mappings()
        {
        }
    }


    private SipHash()
    {
    }
}
