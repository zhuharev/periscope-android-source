// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SkeinDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.macs.SkeinMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, DigestAlgorithmProvider

public class Skein
{
    public static class DigestSkein1024 extends BCMessageDigest
        implements Cloneable
    {

        public Object clone()
        {
            BCMessageDigest bcmessagedigest = (BCMessageDigest)super.clone();
            bcmessagedigest.amS = new SkeinDigest((SkeinDigest)amS);
            return bcmessagedigest;
        }

        public DigestSkein1024(int i)
        {
            super(new SkeinDigest(1024, i));
        }
    }

    public static class DigestSkein256 extends BCMessageDigest
        implements Cloneable
    {

        public Object clone()
        {
            BCMessageDigest bcmessagedigest = (BCMessageDigest)super.clone();
            bcmessagedigest.amS = new SkeinDigest((SkeinDigest)amS);
            return bcmessagedigest;
        }

        public DigestSkein256(int i)
        {
            super(new SkeinDigest(256, i));
        }
    }

    public static class DigestSkein512 extends BCMessageDigest
        implements Cloneable
    {

        public Object clone()
        {
            BCMessageDigest bcmessagedigest = (BCMessageDigest)super.clone();
            bcmessagedigest.amS = new SkeinDigest((SkeinDigest)amS);
            return bcmessagedigest;
        }

        public DigestSkein512(int i)
        {
            super(new SkeinDigest(512, i));
        }
    }

    public static class Digest_1024_1024 extends DigestSkein1024
    {

        public Digest_1024_1024()
        {
            super(1024);
        }
    }

    public static class Digest_1024_384 extends DigestSkein1024
    {

        public Digest_1024_384()
        {
            super(384);
        }
    }

    public static class Digest_1024_512 extends DigestSkein1024
    {

        public Digest_1024_512()
        {
            super(512);
        }
    }

    public static class Digest_256_128 extends DigestSkein256
    {

        public Digest_256_128()
        {
            super(128);
        }
    }

    public static class Digest_256_160 extends DigestSkein256
    {

        public Digest_256_160()
        {
            super(160);
        }
    }

    public static class Digest_256_224 extends DigestSkein256
    {

        public Digest_256_224()
        {
            super(224);
        }
    }

    public static class Digest_256_256 extends DigestSkein256
    {

        public Digest_256_256()
        {
            super(256);
        }
    }

    public static class Digest_512_128 extends DigestSkein512
    {

        public Digest_512_128()
        {
            super(128);
        }
    }

    public static class Digest_512_160 extends DigestSkein512
    {

        public Digest_512_160()
        {
            super(160);
        }
    }

    public static class Digest_512_224 extends DigestSkein512
    {

        public Digest_512_224()
        {
            super(224);
        }
    }

    public static class Digest_512_256 extends DigestSkein512
    {

        public Digest_512_256()
        {
            super(256);
        }
    }

    public static class Digest_512_384 extends DigestSkein512
    {

        public Digest_512_384()
        {
            super(384);
        }
    }

    public static class Digest_512_512 extends DigestSkein512
    {

        public Digest_512_512()
        {
            super(512);
        }
    }

    public static class HMacKeyGenerator_1024_1024 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_1024_1024()
        {
            super("HMACSkein-1024-1024", 1024, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_1024_384 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_1024_384()
        {
            super("HMACSkein-1024-384", 384, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_1024_512 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_1024_512()
        {
            super("HMACSkein-1024-512", 512, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_128 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_256_128()
        {
            super("HMACSkein-256-128", 128, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_160 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_256_160()
        {
            super("HMACSkein-256-160", 160, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_224 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_256_224()
        {
            super("HMACSkein-256-224", 224, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_256 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_256_256()
        {
            super("HMACSkein-256-256", 256, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_128 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_512_128()
        {
            super("HMACSkein-512-128", 128, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_160 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_512_160()
        {
            super("HMACSkein-512-160", 160, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_224 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_512_224()
        {
            super("HMACSkein-512-224", 224, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_256 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_512_256()
        {
            super("HMACSkein-512-256", 256, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_384 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_512_384()
        {
            super("HMACSkein-512-384", 384, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_512 extends BaseKeyGenerator
    {

        public HMacKeyGenerator_512_512()
        {
            super("HMACSkein-512-512", 512, new CipherKeyGenerator());
        }
    }

    public static class HashMac_1024_1024 extends BaseMac
    {

        public HashMac_1024_1024()
        {
            super(new HMac(new SkeinDigest(1024, 1024)));
        }
    }

    public static class HashMac_1024_384 extends BaseMac
    {

        public HashMac_1024_384()
        {
            super(new HMac(new SkeinDigest(1024, 384)));
        }
    }

    public static class HashMac_1024_512 extends BaseMac
    {

        public HashMac_1024_512()
        {
            super(new HMac(new SkeinDigest(1024, 512)));
        }
    }

    public static class HashMac_256_128 extends BaseMac
    {

        public HashMac_256_128()
        {
            super(new HMac(new SkeinDigest(256, 128)));
        }
    }

    public static class HashMac_256_160 extends BaseMac
    {

        public HashMac_256_160()
        {
            super(new HMac(new SkeinDigest(256, 160)));
        }
    }

    public static class HashMac_256_224 extends BaseMac
    {

        public HashMac_256_224()
        {
            super(new HMac(new SkeinDigest(256, 224)));
        }
    }

    public static class HashMac_256_256 extends BaseMac
    {

        public HashMac_256_256()
        {
            super(new HMac(new SkeinDigest(256, 256)));
        }
    }

    public static class HashMac_512_128 extends BaseMac
    {

        public HashMac_512_128()
        {
            super(new HMac(new SkeinDigest(512, 128)));
        }
    }

    public static class HashMac_512_160 extends BaseMac
    {

        public HashMac_512_160()
        {
            super(new HMac(new SkeinDigest(512, 160)));
        }
    }

    public static class HashMac_512_224 extends BaseMac
    {

        public HashMac_512_224()
        {
            super(new HMac(new SkeinDigest(512, 224)));
        }
    }

    public static class HashMac_512_256 extends BaseMac
    {

        public HashMac_512_256()
        {
            super(new HMac(new SkeinDigest(512, 256)));
        }
    }

    public static class HashMac_512_384 extends BaseMac
    {

        public HashMac_512_384()
        {
            super(new HMac(new SkeinDigest(512, 384)));
        }
    }

    public static class HashMac_512_512 extends BaseMac
    {

        public HashMac_512_512()
        {
            super(new HMac(new SkeinDigest(512, 512)));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/digest/Skein.getName();

        private static void _mth02CA(ConfigurableProvider configurableprovider, int i, int j)
        {
            String s = (new StringBuilder("Skein-MAC-")).append(i).append("-").append(j).toString();
            String s1 = (new StringBuilder()).append(PREFIX).append("$SkeinMac_").append(i).append("_").append(j).toString();
            String s2 = (new StringBuilder()).append(PREFIX).append("$SkeinMacKeyGenerator_").append(i).append("_").append(j).toString();
            configurableprovider._mth0640((new StringBuilder("Mac.")).append(s).toString(), s1);
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Mac.Skein-MAC")).append(i).append("/").append(j).toString(), s);
            configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(s).toString(), s2);
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyGenerator.Skein-MAC")).append(i).append("/").append(j).toString(), s);
        }

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("MessageDigest.Skein-256-128", (new StringBuilder()).append(PREFIX).append("$Digest_256_128").toString());
            configurableprovider._mth0640("MessageDigest.Skein-256-160", (new StringBuilder()).append(PREFIX).append("$Digest_256_160").toString());
            configurableprovider._mth0640("MessageDigest.Skein-256-224", (new StringBuilder()).append(PREFIX).append("$Digest_256_224").toString());
            configurableprovider._mth0640("MessageDigest.Skein-256-256", (new StringBuilder()).append(PREFIX).append("$Digest_256_256").toString());
            configurableprovider._mth0640("MessageDigest.Skein-512-128", (new StringBuilder()).append(PREFIX).append("$Digest_512_128").toString());
            configurableprovider._mth0640("MessageDigest.Skein-512-160", (new StringBuilder()).append(PREFIX).append("$Digest_512_160").toString());
            configurableprovider._mth0640("MessageDigest.Skein-512-224", (new StringBuilder()).append(PREFIX).append("$Digest_512_224").toString());
            configurableprovider._mth0640("MessageDigest.Skein-512-256", (new StringBuilder()).append(PREFIX).append("$Digest_512_256").toString());
            configurableprovider._mth0640("MessageDigest.Skein-512-384", (new StringBuilder()).append(PREFIX).append("$Digest_512_384").toString());
            configurableprovider._mth0640("MessageDigest.Skein-512-512", (new StringBuilder()).append(PREFIX).append("$Digest_512_512").toString());
            configurableprovider._mth0640("MessageDigest.Skein-1024-384", (new StringBuilder()).append(PREFIX).append("$Digest_1024_384").toString());
            configurableprovider._mth0640("MessageDigest.Skein-1024-512", (new StringBuilder()).append(PREFIX).append("$Digest_1024_512").toString());
            configurableprovider._mth0640("MessageDigest.Skein-1024-1024", (new StringBuilder()).append(PREFIX).append("$Digest_1024_1024").toString());
            _mth02CA(configurableprovider, "Skein-256-128", (new StringBuilder()).append(PREFIX).append("$HashMac_256_128").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_256_128").toString());
            _mth02CA(configurableprovider, "Skein-256-160", (new StringBuilder()).append(PREFIX).append("$HashMac_256_160").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_256_160").toString());
            _mth02CA(configurableprovider, "Skein-256-224", (new StringBuilder()).append(PREFIX).append("$HashMac_256_224").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_256_224").toString());
            _mth02CA(configurableprovider, "Skein-256-256", (new StringBuilder()).append(PREFIX).append("$HashMac_256_256").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_256_256").toString());
            _mth02CA(configurableprovider, "Skein-512-128", (new StringBuilder()).append(PREFIX).append("$HashMac_512_128").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_128").toString());
            _mth02CA(configurableprovider, "Skein-512-160", (new StringBuilder()).append(PREFIX).append("$HashMac_512_160").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_160").toString());
            _mth02CA(configurableprovider, "Skein-512-224", (new StringBuilder()).append(PREFIX).append("$HashMac_512_224").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_224").toString());
            _mth02CA(configurableprovider, "Skein-512-256", (new StringBuilder()).append(PREFIX).append("$HashMac_512_256").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_256").toString());
            _mth02CA(configurableprovider, "Skein-512-384", (new StringBuilder()).append(PREFIX).append("$HashMac_512_384").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_384").toString());
            _mth02CA(configurableprovider, "Skein-512-512", (new StringBuilder()).append(PREFIX).append("$HashMac_512_512").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_512_512").toString());
            _mth02CA(configurableprovider, "Skein-1024-384", (new StringBuilder()).append(PREFIX).append("$HashMac_1024_384").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_1024_384").toString());
            _mth02CA(configurableprovider, "Skein-1024-512", (new StringBuilder()).append(PREFIX).append("$HashMac_1024_512").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_1024_512").toString());
            _mth02CA(configurableprovider, "Skein-1024-1024", (new StringBuilder()).append(PREFIX).append("$HashMac_1024_1024").toString(), (new StringBuilder()).append(PREFIX).append("$HMacKeyGenerator_1024_1024").toString());
            _mth02CA(configurableprovider, 256, 128);
            _mth02CA(configurableprovider, 256, 160);
            _mth02CA(configurableprovider, 256, 224);
            _mth02CA(configurableprovider, 256, 256);
            _mth02CA(configurableprovider, 512, 128);
            _mth02CA(configurableprovider, 512, 160);
            _mth02CA(configurableprovider, 512, 224);
            _mth02CA(configurableprovider, 512, 256);
            _mth02CA(configurableprovider, 512, 384);
            _mth02CA(configurableprovider, 512, 512);
            _mth02CA(configurableprovider, 1024, 384);
            _mth02CA(configurableprovider, 1024, 512);
            _mth02CA(configurableprovider, 1024, 1024);
        }


        public Mappings()
        {
        }
    }

    public static class SkeinMacKeyGenerator_1024_1024 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_1024_1024()
        {
            super("Skein-MAC-1024-1024", 1024, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_1024_384 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_1024_384()
        {
            super("Skein-MAC-1024-384", 384, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_1024_512 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_1024_512()
        {
            super("Skein-MAC-1024-512", 512, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_128 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_256_128()
        {
            super("Skein-MAC-256-128", 128, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_160 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_256_160()
        {
            super("Skein-MAC-256-160", 160, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_224 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_256_224()
        {
            super("Skein-MAC-256-224", 224, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_256 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_256_256()
        {
            super("Skein-MAC-256-256", 256, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_128 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_512_128()
        {
            super("Skein-MAC-512-128", 128, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_160 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_512_160()
        {
            super("Skein-MAC-512-160", 160, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_224 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_512_224()
        {
            super("Skein-MAC-512-224", 224, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_256 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_512_256()
        {
            super("Skein-MAC-512-256", 256, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_384 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_512_384()
        {
            super("Skein-MAC-512-384", 384, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_512 extends BaseKeyGenerator
    {

        public SkeinMacKeyGenerator_512_512()
        {
            super("Skein-MAC-512-512", 512, new CipherKeyGenerator());
        }
    }

    public static class SkeinMac_1024_1024 extends BaseMac
    {

        public SkeinMac_1024_1024()
        {
            super(new SkeinMac(1024, 1024));
        }
    }

    public static class SkeinMac_1024_384 extends BaseMac
    {

        public SkeinMac_1024_384()
        {
            super(new SkeinMac(1024, 384));
        }
    }

    public static class SkeinMac_1024_512 extends BaseMac
    {

        public SkeinMac_1024_512()
        {
            super(new SkeinMac(1024, 512));
        }
    }

    public static class SkeinMac_256_128 extends BaseMac
    {

        public SkeinMac_256_128()
        {
            super(new SkeinMac(256, 128));
        }
    }

    public static class SkeinMac_256_160 extends BaseMac
    {

        public SkeinMac_256_160()
        {
            super(new SkeinMac(256, 160));
        }
    }

    public static class SkeinMac_256_224 extends BaseMac
    {

        public SkeinMac_256_224()
        {
            super(new SkeinMac(256, 224));
        }
    }

    public static class SkeinMac_256_256 extends BaseMac
    {

        public SkeinMac_256_256()
        {
            super(new SkeinMac(256, 256));
        }
    }

    public static class SkeinMac_512_128 extends BaseMac
    {

        public SkeinMac_512_128()
        {
            super(new SkeinMac(512, 128));
        }
    }

    public static class SkeinMac_512_160 extends BaseMac
    {

        public SkeinMac_512_160()
        {
            super(new SkeinMac(512, 160));
        }
    }

    public static class SkeinMac_512_224 extends BaseMac
    {

        public SkeinMac_512_224()
        {
            super(new SkeinMac(512, 224));
        }
    }

    public static class SkeinMac_512_256 extends BaseMac
    {

        public SkeinMac_512_256()
        {
            super(new SkeinMac(512, 256));
        }
    }

    public static class SkeinMac_512_384 extends BaseMac
    {

        public SkeinMac_512_384()
        {
            super(new SkeinMac(512, 384));
        }
    }

    public static class SkeinMac_512_512 extends BaseMac
    {

        public SkeinMac_512_512()
        {
            super(new SkeinMac(512, 512));
        }
    }


    private Skein()
    {
    }
}
