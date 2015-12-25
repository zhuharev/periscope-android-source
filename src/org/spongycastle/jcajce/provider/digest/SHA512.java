// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.macs.OldHMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, DigestAlgorithmProvider

public class SHA512
{
    public static class Digest extends BCMessageDigest
        implements Cloneable
    {

        public Object clone()
        {
            Digest digest = (Digest)super.clone();
            digest.amS = new SHA512Digest((SHA512Digest)amS);
            return digest;
        }

        public Digest()
        {
            super(new SHA512Digest());
        }
    }

    public static class DigestT extends BCMessageDigest
        implements Cloneable
    {

        public Object clone()
        {
            DigestT digestt = (DigestT)super.clone();
            digestt.amS = new SHA512tDigest((SHA512tDigest)amS);
            return digestt;
        }

        public DigestT(int i)
        {
            super(new SHA512tDigest(i));
        }
    }

    public static class DigestT224 extends DigestT
    {

        public DigestT224()
        {
            super(224);
        }
    }

    public static class DigestT256 extends DigestT
    {

        public DigestT256()
        {
            super(256);
        }
    }

    public static class HashMac extends BaseMac
    {

        public HashMac()
        {
            super(new HMac(new SHA512Digest()));
        }
    }

    public static class HashMacT224 extends BaseMac
    {

        public HashMacT224()
        {
            super(new HMac(new SHA512tDigest(224)));
        }
    }

    public static class HashMacT256 extends BaseMac
    {

        public HashMacT256()
        {
            super(new HMac(new SHA512tDigest(256)));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator
    {

        public KeyGenerator()
        {
            super("HMACSHA512", 512, new CipherKeyGenerator());
        }
    }

    public static class KeyGeneratorT224 extends BaseKeyGenerator
    {

        public KeyGeneratorT224()
        {
            super("HMACSHA512/224", 224, new CipherKeyGenerator());
        }
    }

    public static class KeyGeneratorT256 extends BaseKeyGenerator
    {

        public KeyGeneratorT256()
        {
            super("HMACSHA512/256", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/digest/SHA512.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("MessageDigest.SHA-512", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
            configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA512", "SHA-512");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(NISTObjectIdentifiers.ZF).toString(), "SHA-512");
            configurableprovider._mth0640("MessageDigest.SHA-512/224", (new StringBuilder()).append(PREFIX).append("$DigestT224").toString());
            configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA512/224", "SHA-512/224");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(NISTObjectIdentifiers.ZH).toString(), "SHA-512/224");
            configurableprovider._mth0640("MessageDigest.SHA-512/256", (new StringBuilder()).append(PREFIX).append("$DigestT256").toString());
            configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA512256", "SHA-512/256");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(NISTObjectIdentifiers.ZI).toString(), "SHA-512/256");
            configurableprovider._mth0640("Mac.OLDHMACSHA512", (new StringBuilder()).append(PREFIX).append("$OldSHA512").toString());
            _mth02CA(configurableprovider, "SHA512", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
            _mth02CA(configurableprovider, "SHA512", PKCSObjectIdentifiers.abH);
            _mth02CA(configurableprovider, "SHA512/224", (new StringBuilder()).append(PREFIX).append("$HashMacT224").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGeneratorT224").toString());
            _mth02CA(configurableprovider, "SHA512/256", (new StringBuilder()).append(PREFIX).append("$HashMacT256").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGeneratorT256").toString());
        }


        public Mappings()
        {
        }
    }

    public static class OldSHA512 extends BaseMac
    {

        public OldSHA512()
        {
            super(new OldHMac(new SHA512Digest()));
        }
    }


    private SHA512()
    {
    }
}
