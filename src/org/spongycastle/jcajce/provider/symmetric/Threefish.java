// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.ThreefishEngine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class Threefish
{
    public static class AlgParams_1024 extends IvAlgorithmParameters
    {

        protected String engineToString()
        {
            return "Threefish-1024 IV";
        }

        public AlgParams_1024()
        {
        }
    }

    public static class AlgParams_256 extends IvAlgorithmParameters
    {

        protected String engineToString()
        {
            return "Threefish-256 IV";
        }

        public AlgParams_256()
        {
        }
    }

    public static class AlgParams_512 extends IvAlgorithmParameters
    {

        protected String engineToString()
        {
            return "Threefish-512 IV";
        }

        public AlgParams_512()
        {
        }
    }

    public static class ECB_1024 extends BaseBlockCipher
    {

        public ECB_1024()
        {
            super(new ThreefishEngine(1024));
        }
    }

    public static class ECB_256 extends BaseBlockCipher
    {

        public ECB_256()
        {
            super(new ThreefishEngine(256));
        }
    }

    public static class ECB_512 extends BaseBlockCipher
    {

        public ECB_512()
        {
            super(new ThreefishEngine(512));
        }
    }

    public static class KeyGen_1024 extends BaseKeyGenerator
    {

        public KeyGen_1024()
        {
            super("Threefish-1024", 1024, new CipherKeyGenerator());
        }
    }

    public static class KeyGen_256 extends BaseKeyGenerator
    {

        public KeyGen_256()
        {
            super("Threefish-256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGen_512 extends BaseKeyGenerator
    {

        public KeyGen_512()
        {
            super("Threefish-512", 512, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/Threefish.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("Cipher.Threefish-256", (new StringBuilder()).append(PREFIX).append("$ECB_256").toString());
            configurableprovider._mth0640("Cipher.Threefish-512", (new StringBuilder()).append(PREFIX).append("$ECB_512").toString());
            configurableprovider._mth0640("Cipher.Threefish-1024", (new StringBuilder()).append(PREFIX).append("$ECB_1024").toString());
            configurableprovider._mth0640("KeyGenerator.Threefish-256", (new StringBuilder()).append(PREFIX).append("$KeyGen_256").toString());
            configurableprovider._mth0640("KeyGenerator.Threefish-512", (new StringBuilder()).append(PREFIX).append("$KeyGen_512").toString());
            configurableprovider._mth0640("KeyGenerator.Threefish-1024", (new StringBuilder()).append(PREFIX).append("$KeyGen_1024").toString());
            configurableprovider._mth0640("AlgorithmParameters.Threefish-256", (new StringBuilder()).append(PREFIX).append("$AlgParams_256").toString());
            configurableprovider._mth0640("AlgorithmParameters.Threefish-512", (new StringBuilder()).append(PREFIX).append("$AlgParams_512").toString());
            configurableprovider._mth0640("AlgorithmParameters.Threefish-1024", (new StringBuilder()).append(PREFIX).append("$AlgParams_1024").toString());
        }


        public Mappings()
        {
        }
    }


    private Threefish()
    {
    }
}
