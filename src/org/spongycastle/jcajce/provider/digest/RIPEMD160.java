// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, DigestAlgorithmProvider

public class RIPEMD160
{
    public static class Digest extends BCMessageDigest
        implements Cloneable
    {

        public Object clone()
        {
            Digest digest = (Digest)super.clone();
            digest.amS = new RIPEMD160Digest((RIPEMD160Digest)amS);
            return digest;
        }

        public Digest()
        {
            super(new RIPEMD160Digest());
        }
    }

    public static class HashMac extends BaseMac
    {

        public HashMac()
        {
            super(new HMac(new RIPEMD160Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator
    {

        public KeyGenerator()
        {
            super("HMACRIPEMD160", 160, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/digest/RIPEMD160.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("MessageDigest.RIPEMD160", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(TeleTrusTObjectIdentifiers.afj).toString(), "RIPEMD160");
            _mth02CA(configurableprovider, "RIPEMD160", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
            _mth02CA(configurableprovider, "RIPEMD160", IANAObjectIdentifiers.Zf);
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHHMACRIPEMD160", (new StringBuilder()).append(PREFIX).append("$PBEWithHmacKeyFactory").toString());
            configurableprovider._mth0640("Mac.PBEWITHHMACRIPEMD160", (new StringBuilder()).append(PREFIX).append("$PBEWithHmac").toString());
        }


        public Mappings()
        {
        }
    }

    public static class PBEWithHmac extends BaseMac
    {

        public PBEWithHmac()
        {
            super(new HMac(new RIPEMD160Digest()), 2, 2, 160);
        }
    }

    public static class PBEWithHmacKeyFactory extends PBESecretKeyFactory
    {

        public PBEWithHmacKeyFactory()
        {
            super("PBEwithHmacRIPEMD160", null, false, 2, 2, 160, 0);
        }
    }


    private RIPEMD160()
    {
    }
}
