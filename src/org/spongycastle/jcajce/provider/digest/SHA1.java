// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, DigestAlgorithmProvider

public class SHA1
{
    public static class BasePBKDF2WithHmacSHA1 extends BaseSecretKeyFactory
    {

        private int scheme;

        protected SecretKey engineGenerateSecret(KeySpec keyspec)
        {
            if (keyspec instanceof PBEKeySpec)
            {
                keyspec = (PBEKeySpec)keyspec;
                if (keyspec.getSalt() == null)
                {
                    throw new InvalidKeySpecException("missing required salt");
                }
                if (keyspec.getIterationCount() <= 0)
                {
                    throw new InvalidKeySpecException((new StringBuilder("positive iteration count required: ")).append(keyspec.getIterationCount()).toString());
                }
                if (keyspec.getKeyLength() <= 0)
                {
                    throw new InvalidKeySpecException((new StringBuilder("positive key length required: ")).append(keyspec.getKeyLength()).toString());
                }
                if (keyspec.getPassword().length == 0)
                {
                    throw new IllegalArgumentException("password empty");
                } else
                {
                    int i = keyspec.getKeyLength();
                    org.spongycastle.crypto.CipherParameters cipherparameters = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util._mth02CA(keyspec, scheme, 1, i);
                    return new BCPBEKey(aFS, aFZ, scheme, 1, i, -1, keyspec, cipherparameters);
                }
            } else
            {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }

        public BasePBKDF2WithHmacSHA1(String s, int i)
        {
            super(s, PKCSObjectIdentifiers.abu);
            scheme = i;
        }
    }

    public static class Digest extends BCMessageDigest
        implements Cloneable
    {

        public Object clone()
        {
            Digest digest = (Digest)super.clone();
            digest.amS = new SHA1Digest((SHA1Digest)amS);
            return digest;
        }

        public Digest()
        {
            super(new SHA1Digest());
        }
    }

    public static class HashMac extends BaseMac
    {

        public HashMac()
        {
            super(new HMac(new SHA1Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator
    {

        public KeyGenerator()
        {
            super("HMACSHA1", 160, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/digest/SHA1.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("MessageDigest.SHA-1", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
            configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA1", "SHA-1");
            configurableprovider._mth0640("Alg.Alias.MessageDigest.SHA", "SHA-1");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.MessageDigest.")).append(OIWObjectIdentifiers.aav).toString(), "SHA-1");
            _mth02CA(configurableprovider, "SHA1", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
            _mth02CA(configurableprovider, "SHA1", PKCSObjectIdentifiers.abD);
            _mth02CA(configurableprovider, "SHA1", IANAObjectIdentifiers.Zd);
            configurableprovider._mth0640("Mac.PBEWITHHMACSHA", (new StringBuilder()).append(PREFIX).append("$SHA1Mac").toString());
            configurableprovider._mth0640("Mac.PBEWITHHMACSHA1", (new StringBuilder()).append(PREFIX).append("$SHA1Mac").toString());
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBEWITHHMACSHA1");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(OIWObjectIdentifiers.aav).toString(), "PBEWITHHMACSHA1");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Mac.")).append(OIWObjectIdentifiers.aav).toString(), "PBEWITHHMACSHA");
            configurableprovider._mth0640("SecretKeyFactory.PBEWITHHMACSHA1", (new StringBuilder()).append(PREFIX).append("$PBEWithMacKeyFactory").toString());
            configurableprovider._mth0640("SecretKeyFactory.PBKDF2WithHmacSHA1", (new StringBuilder()).append(PREFIX).append("$PBKDF2WithHmacSHA1UTF8").toString());
            configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBKDF2WithHmacSHA1AndUTF8", "PBKDF2WithHmacSHA1");
            configurableprovider._mth0640("SecretKeyFactory.PBKDF2WithHmacSHA1And8BIT", (new StringBuilder()).append(PREFIX).append("$PBKDF2WithHmacSHA18BIT").toString());
        }


        public Mappings()
        {
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory
    {

        public PBEWithMacKeyFactory()
        {
            super("PBEwithHmacSHA", null, false, 2, 1, 160, 0);
        }
    }

    public static class PBKDF2WithHmacSHA18BIT extends BasePBKDF2WithHmacSHA1
    {

        public PBKDF2WithHmacSHA18BIT()
        {
            super("PBKDF2WithHmacSHA1And8bit", 1);
        }
    }

    public static class PBKDF2WithHmacSHA1UTF8 extends BasePBKDF2WithHmacSHA1
    {

        public PBKDF2WithHmacSHA1UTF8()
        {
            super("PBKDF2WithHmacSHA1", 5);
        }
    }

    public static class SHA1Mac extends BaseMac
    {

        public SHA1Mac()
        {
            super(new HMac(new SHA1Digest()));
        }
    }


    private SHA1()
    {
    }
}
