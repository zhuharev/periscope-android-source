// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.RC4Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class ARC4
{
    public static class Base extends BaseStreamCipher
    {

        public Base()
        {
            super(new RC4Engine(), 0);
        }
    }

    public static class KeyGen extends BaseKeyGenerator
    {

        public KeyGen()
        {
            super("RC4", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/ARC4.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("Cipher.ARC4", (new StringBuilder()).append(PREFIX).append("$Base").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.aby).toString(), "ARC4");
            configurableprovider._mth0640("Alg.Alias.Cipher.ARCFOUR", "ARC4");
            configurableprovider._mth0640("Alg.Alias.Cipher.RC4", "ARC4");
            configurableprovider._mth0640("KeyGenerator.ARC4", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
            configurableprovider._mth0640("Alg.Alias.KeyGenerator.RC4", "ARC4");
            configurableprovider._mth0640("Alg.Alias.KeyGenerator.1.2.840.113549.3.4", "ARC4");
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND128BITRC4", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd128BitKeyFactory").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND40BITRC4", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd40BitKeyFactory").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(PKCSObjectIdentifiers.acO).toString(), "PKCS12PBE");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(PKCSObjectIdentifiers.acP).toString(), "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC4", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC4", "PKCS12PBE");
            configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC4", "PKCS12PBE");
            configurableprovider._mth0640("Cipher.PBEWITHSHAAND128BITRC4", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd128Bit").toString());
            configurableprovider._mth0640("Cipher.PBEWITHSHAAND40BITRC4", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd40Bit").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.acO).toString(), "PBEWITHSHAAND128BITRC4");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.acP).toString(), "PBEWITHSHAAND40BITRC4");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC4", "PBEWITHSHAAND128BITRC4");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC4", "PBEWITHSHAAND40BITRC4");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.acO).toString(), "PBEWITHSHAAND128BITRC4");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.acP).toString(), "PBEWITHSHAAND40BITRC4");
        }


        public Mappings()
        {
        }
    }

    public static class PBEWithSHAAnd128Bit extends BaseStreamCipher
    {

        public PBEWithSHAAnd128Bit()
        {
            super(new RC4Engine(), 0);
        }
    }

    public static class PBEWithSHAAnd128BitKeyFactory extends PBESecretKeyFactory
    {

        public PBEWithSHAAnd128BitKeyFactory()
        {
            super("PBEWithSHAAnd128BitRC4", PKCSObjectIdentifiers.acO, true, 2, 1, 128, 0);
        }
    }

    public static class PBEWithSHAAnd40Bit extends BaseStreamCipher
    {

        public PBEWithSHAAnd40Bit()
        {
            super(new RC4Engine(), 0);
        }
    }

    public static class PBEWithSHAAnd40BitKeyFactory extends PBESecretKeyFactory
    {

        public PBEWithSHAAnd40BitKeyFactory()
        {
            super("PBEWithSHAAnd128BitRC4", PKCSObjectIdentifiers.acO, true, 2, 1, 40, 0);
        }
    }


    private ARC4()
    {
    }
}
