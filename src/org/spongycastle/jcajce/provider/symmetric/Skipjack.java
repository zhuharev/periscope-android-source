// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.SkipjackEngine;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class Skipjack
{
    public static class AlgParams extends IvAlgorithmParameters
    {

        protected String engineToString()
        {
            return "Skipjack IV";
        }

        public AlgParams()
        {
        }
    }

    public static class ECB extends BaseBlockCipher
    {

        public ECB()
        {
            super(new SkipjackEngine());
        }
    }

    public static class KeyGen extends BaseKeyGenerator
    {

        public KeyGen()
        {
            super("Skipjack", 80, new CipherKeyGenerator());
        }
    }

    public static class Mac extends BaseMac
    {

        public Mac()
        {
            super(new CBCBlockCipherMac(new SkipjackEngine()));
        }
    }

    public static class MacCFB8 extends BaseMac
    {

        public MacCFB8()
        {
            super(new CFBBlockCipherMac(new SkipjackEngine()));
        }
    }

    public static class Mappings extends AlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/Skipjack.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("Cipher.SKIPJACK", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
            configurableprovider._mth0640("KeyGenerator.SKIPJACK", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            configurableprovider._mth0640("AlgorithmParameters.SKIPJACK", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
            configurableprovider._mth0640("Mac.SKIPJACKMAC", (new StringBuilder()).append(PREFIX).append("$Mac").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.SKIPJACK", "SKIPJACKMAC");
            configurableprovider._mth0640("Mac.SKIPJACKMAC/CFB8", (new StringBuilder()).append(PREFIX).append("$MacCFB8").toString());
            configurableprovider._mth0640("Alg.Alias.Mac.SKIPJACK/CFB8", "SKIPJACKMAC/CFB8");
        }


        public Mappings()
        {
        }
    }


    private Skipjack()
    {
    }
}
