// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, DigestAlgorithmProvider

public class GOST3411
{
    public static class Digest extends BCMessageDigest
        implements Cloneable
    {

        public Object clone()
        {
            Digest digest = (Digest)super.clone();
            digest.amS = new GOST3411Digest((GOST3411Digest)amS);
            return digest;
        }

        public Digest()
        {
            super(new GOST3411Digest());
        }
    }

    public static class HashMac extends BaseMac
    {

        public HashMac()
        {
            super(new HMac(new GOST3411Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator
    {

        public KeyGenerator()
        {
            super("HMACGOST3411", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/digest/GOST3411.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("MessageDigest.GOST3411", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
            configurableprovider._mth0640("Alg.Alias.MessageDigest.GOST", "GOST3411");
            configurableprovider._mth0640("Alg.Alias.MessageDigest.GOST-3411", "GOST3411");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(CryptoProObjectIdentifiers.XO).toString(), "GOST3411");
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHHMACGOST3411", (new StringBuilder()).append(PREFIX).append("$PBEWithMacKeyFactory").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(CryptoProObjectIdentifiers.XO).toString(), "PBEWITHHMACGOST3411");
            _mth02CA(configurableprovider, "GOST3411", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
            _mth02CA(configurableprovider, "GOST3411", CryptoProObjectIdentifiers.XO);
        }


        public Mappings()
        {
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory
    {

        public PBEWithMacKeyFactory()
        {
            super("PBEwithHmacGOST3411", null, false, 2, 6, 256, 0);
        }
    }


    private GOST3411()
    {
    }
}
