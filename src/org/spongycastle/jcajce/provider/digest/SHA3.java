// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SHA3Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, DigestAlgorithmProvider

public class SHA3
{
    public static class Digest224 extends DigestSHA3
    {

        public Digest224()
        {
            super(224);
        }
    }

    public static class Digest256 extends DigestSHA3
    {

        public Digest256()
        {
            super(256);
        }
    }

    public static class Digest384 extends DigestSHA3
    {

        public Digest384()
        {
            super(384);
        }
    }

    public static class Digest512 extends DigestSHA3
    {

        public Digest512()
        {
            super(512);
        }
    }

    public static class DigestSHA3 extends BCMessageDigest
        implements Cloneable
    {

        public Object clone()
        {
            BCMessageDigest bcmessagedigest = (BCMessageDigest)super.clone();
            bcmessagedigest.amS = new SHA3Digest((SHA3Digest)amS);
            return bcmessagedigest;
        }

        public DigestSHA3(int i)
        {
            super(new SHA3Digest(i));
        }
    }

    public static class HashMac224 extends BaseMac
    {

        public HashMac224()
        {
            super(new HMac(new SHA3Digest(224)));
        }
    }

    public static class HashMac256 extends BaseMac
    {

        public HashMac256()
        {
            super(new HMac(new SHA3Digest(256)));
        }
    }

    public static class HashMac384 extends BaseMac
    {

        public HashMac384()
        {
            super(new HMac(new SHA3Digest(384)));
        }
    }

    public static class HashMac512 extends BaseMac
    {

        public HashMac512()
        {
            super(new HMac(new SHA3Digest(512)));
        }
    }

    public static class KeyGenerator224 extends BaseKeyGenerator
    {

        public KeyGenerator224()
        {
            super("HMACSHA3-224", 224, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator256 extends BaseKeyGenerator
    {

        public KeyGenerator256()
        {
            super("HMACSHA3-256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator384 extends BaseKeyGenerator
    {

        public KeyGenerator384()
        {
            super("HMACSHA3-384", 384, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator512 extends BaseKeyGenerator
    {

        public KeyGenerator512()
        {
            super("HMACSHA3-512", 512, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/digest/SHA3.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("MessageDigest.SHA3-224", (new StringBuilder()).append(PREFIX).append("$Digest224").toString());
            configurableprovider._mth0640("MessageDigest.SHA3-256", (new StringBuilder()).append(PREFIX).append("$Digest256").toString());
            configurableprovider._mth0640("MessageDigest.SHA3-384", (new StringBuilder()).append(PREFIX).append("$Digest384").toString());
            configurableprovider._mth0640("MessageDigest.SHA3-512", (new StringBuilder()).append(PREFIX).append("$Digest512").toString());
            _mth02CA(configurableprovider, "SHA3-224", (new StringBuilder()).append(PREFIX).append("$HashMac224").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator224").toString());
            _mth02CA(configurableprovider, "SHA3-256", (new StringBuilder()).append(PREFIX).append("$HashMac256").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator256").toString());
            _mth02CA(configurableprovider, "SHA3-384", (new StringBuilder()).append(PREFIX).append("$HashMac384").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator384").toString());
            _mth02CA(configurableprovider, "SHA3-512", (new StringBuilder()).append(PREFIX).append("$HashMac512").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator512").toString());
        }


        public Mappings()
        {
        }
    }


    private SHA3()
    {
    }
}
