// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.rainbow.RainbowSigner;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.rainbow:
//            RainbowKeysToParams

public class SignatureSpi extends java.security.SignatureSpi
{
    public static class withSha224 extends SignatureSpi
    {

        public withSha224()
        {
            super(new SHA224Digest(), new RainbowSigner());
        }
    }

    public static class withSha256 extends SignatureSpi
    {

        public withSha256()
        {
            super(new SHA256Digest(), new RainbowSigner());
        }
    }

    public static class withSha384 extends SignatureSpi
    {

        public withSha384()
        {
            super(new SHA384Digest(), new RainbowSigner());
        }
    }

    public static class withSha512 extends SignatureSpi
    {

        public withSha512()
        {
            super(new SHA512Digest(), new RainbowSigner());
        }
    }


    private RainbowSigner aOo;
    private SecureRandom amC;
    private Digest amS;

    protected SignatureSpi(ExtendedDigest extendeddigest, RainbowSigner rainbowsigner)
    {
        amS = extendeddigest;
        aOo = rainbowsigner;
    }

    protected Object engineGetParameter(String s)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineInitSign(PrivateKey privatekey)
    {
        org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters rainbowprivatekeyparameters = RainbowKeysToParams._mth02BD(privatekey);
        privatekey = rainbowprivatekeyparameters;
        if (amC != null)
        {
            privatekey = new ParametersWithRandom(rainbowprivatekeyparameters, amC);
        }
        amS.reset();
        aOo._mth02CA(true, privatekey);
    }

    protected void engineInitSign(PrivateKey privatekey, SecureRandom securerandom)
    {
        amC = securerandom;
        engineInitSign(privatekey);
    }

    protected void engineInitVerify(PublicKey publickey)
    {
        publickey = RainbowKeysToParams._mth1FBE(publickey);
        amS.reset();
        aOo._mth02CA(false, publickey);
    }

    protected void engineSetParameter(String s, Object obj)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineSetParameter(AlgorithmParameterSpec algorithmparameterspec)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected byte[] engineSign()
    {
        byte abyte0[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte0, 0);
        try
        {
            abyte0 = aOo._mth02B2(abyte0);
        }
        catch (Exception exception)
        {
            throw new SignatureException(exception.toString());
        }
        return abyte0;
    }

    protected void engineUpdate(byte byte0)
    {
        amS.update(byte0);
    }

    protected void engineUpdate(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }

    protected boolean engineVerify(byte abyte0[])
    {
        byte abyte1[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte1, 0);
        return aOo._mth02C9(abyte1, abyte0);
    }
}
