// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.CAST6Engine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            SymmetricAlgorithmProvider

public final class CAST6
{
    public static class ECB extends BaseBlockCipher
    {

        public ECB()
        {
            class _cls1
                implements BlockCipherProvider
            {

                public final BlockCipher _mth1627()
                {
                    return new CAST6Engine();
                }

                _cls1()
                {
                }
            }

            super(new _cls1());
        }
    }

    public static class GMAC extends BaseMac
    {

        public GMAC()
        {
            super(new GMac(new GCMBlockCipher(new CAST6Engine())));
        }
    }

    public static class KeyGen extends BaseKeyGenerator
    {

        public KeyGen()
        {
            super("CAST6", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/CAST6.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("Cipher.CAST6", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
            configurableprovider._mth0640("KeyGenerator.CAST6", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            _mth02CB(configurableprovider, "CAST6", (new StringBuilder()).append(PREFIX).append("$GMAC").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            _mth02CE(configurableprovider, "CAST6", (new StringBuilder()).append(PREFIX).append("$Poly1305").toString(), (new StringBuilder()).append(PREFIX).append("$Poly1305KeyGen").toString());
        }


        public Mappings()
        {
        }
    }

    public static class Poly1305 extends BaseMac
    {

        public Poly1305()
        {
            super(new org.spongycastle.crypto.macs.Poly1305(new CAST6Engine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator
    {

        public Poly1305KeyGen()
        {
            super("Poly1305-CAST6", 256, new Poly1305KeyGenerator());
        }
    }


    private CAST6()
    {
    }
}
