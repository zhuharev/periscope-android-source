// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, DigestAlgorithmProvider

public class SM3
{
    public static class Digest extends BCMessageDigest
        implements Cloneable
    {

        public Object clone()
        {
            Digest digest = (Digest)super.clone();
            digest.amS = new SM3Digest((SM3Digest)amS);
            return digest;
        }

        public Digest()
        {
            super(new SM3Digest());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider
    {

        private static final String PREFIX = org/spongycastle/jcajce/provider/digest/SM3.getName();

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("MessageDigest.SM3", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
            configurableprovider._mth0640("Alg.Alias.MessageDigest.SM3", "SM3");
            configurableprovider._mth0640("Alg.Alias.MessageDigest.1.2.156.197.1.401", "SM3");
        }


        public Mappings()
        {
        }
    }


    private SM3()
    {
    }
}
