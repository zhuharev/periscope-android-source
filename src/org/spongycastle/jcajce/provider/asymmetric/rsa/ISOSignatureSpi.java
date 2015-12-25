// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.digests.GeneralDigest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.signers.ISO9796d2Signer;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.rsa:
//            RSAUtil

public class ISOSignatureSpi extends SignatureSpi
{
    public static class MD5WithRSAEncryption extends ISOSignatureSpi
    {

        public MD5WithRSAEncryption()
        {
            super(new MD5Digest(), new RSABlindedEngine());
        }
    }

    public static class RIPEMD160WithRSAEncryption extends ISOSignatureSpi
    {

        public RIPEMD160WithRSAEncryption()
        {
            super(new RIPEMD160Digest(), new RSABlindedEngine());
        }
    }

    public static class SHA1WithRSAEncryption extends ISOSignatureSpi
    {

        public SHA1WithRSAEncryption()
        {
            super(new SHA1Digest(), new RSABlindedEngine());
        }
    }


    private ISO9796d2Signer aEa;

    protected ISOSignatureSpi(GeneralDigest generaldigest, RSABlindedEngine rsablindedengine)
    {
        aEa = new ISO9796d2Signer(rsablindedengine, generaldigest, true);
    }

    protected Object engineGetParameter(String s)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineInitSign(PrivateKey privatekey)
    {
        privatekey = RSAUtil._mth02CA((RSAPrivateKey)privatekey);
        aEa._mth02CA(true, privatekey);
    }

    protected void engineInitVerify(PublicKey publickey)
    {
        publickey = RSAUtil._mth02CA((RSAPublicKey)publickey);
        aEa._mth02CA(false, publickey);
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
        byte abyte0[];
        try
        {
            abyte0 = aEa._mth14B6();
        }
        catch (Exception exception)
        {
            throw new SignatureException(exception.toString());
        }
        return abyte0;
    }

    protected void engineUpdate(byte byte0)
    {
        aEa.update(byte0);
    }

    protected void engineUpdate(byte abyte0[], int i, int j)
    {
        aEa.update(abyte0, i, j);
    }

    protected boolean engineVerify(byte abyte0[])
    {
        return aEa.FE73(abyte0);
    }
}
