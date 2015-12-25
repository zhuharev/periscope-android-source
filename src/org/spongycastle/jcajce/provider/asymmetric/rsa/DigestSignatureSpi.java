// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.digests.MD4Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.digests.RIPEMD128Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.RIPEMD256Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.rsa:
//            RSAUtil

public class DigestSignatureSpi extends SignatureSpi
{
    public static class MD2 extends DigestSignatureSpi
    {

        public MD2()
        {
            super(PKCSObjectIdentifiers.abA, new MD2Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class MD4 extends DigestSignatureSpi
    {

        public MD4()
        {
            super(PKCSObjectIdentifiers.abB, new MD4Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class MD5 extends DigestSignatureSpi
    {

        public MD5()
        {
            super(PKCSObjectIdentifiers.abC, new MD5Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD128 extends DigestSignatureSpi
    {

        public RIPEMD128()
        {
            super(TeleTrusTObjectIdentifiers.afk, new RIPEMD128Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD160 extends DigestSignatureSpi
    {

        public RIPEMD160()
        {
            super(TeleTrusTObjectIdentifiers.afj, new RIPEMD160Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD256 extends DigestSignatureSpi
    {

        public RIPEMD256()
        {
            super(TeleTrusTObjectIdentifiers.afl, new RIPEMD256Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA1 extends DigestSignatureSpi
    {

        public SHA1()
        {
            super(OIWObjectIdentifiers.aav, new SHA1Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA224 extends DigestSignatureSpi
    {

        public SHA224()
        {
            super(NISTObjectIdentifiers.ZG, new SHA224Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA256 extends DigestSignatureSpi
    {

        public SHA256()
        {
            super(NISTObjectIdentifiers.ZD, new SHA256Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA384 extends DigestSignatureSpi
    {

        public SHA384()
        {
            super(NISTObjectIdentifiers.ZE, new SHA384Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA512 extends DigestSignatureSpi
    {

        public SHA512()
        {
            super(NISTObjectIdentifiers.ZF, new SHA512Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class noneRSA extends DigestSignatureSpi
    {

        public noneRSA()
        {
            super(new NullDigest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }


    private AlgorithmIdentifier aaK;
    private Digest amS;
    private AsymmetricBlockCipher amx;

    protected DigestSignatureSpi(ASN1ObjectIdentifier asn1objectidentifier, ExtendedDigest extendeddigest, PKCS1Encoding pkcs1encoding)
    {
        amS = extendeddigest;
        amx = pkcs1encoding;
        aaK = new AlgorithmIdentifier(asn1objectidentifier, DERNull.WL);
    }

    protected DigestSignatureSpi(NullDigest nulldigest, PKCS1Encoding pkcs1encoding)
    {
        amS = nulldigest;
        amx = pkcs1encoding;
        aaK = null;
    }

    protected Object engineGetParameter(String s)
    {
        return null;
    }

    protected AlgorithmParameters engineGetParameters()
    {
        return null;
    }

    protected void engineInitSign(PrivateKey privatekey)
    {
        if (!(privatekey instanceof RSAPrivateKey))
        {
            StringBuilder stringbuilder = new StringBuilder("Supplied key (");
            if (privatekey == null)
            {
                privatekey = null;
            } else
            {
                privatekey = privatekey.getClass().getName();
            }
            throw new InvalidKeyException(stringbuilder.append(privatekey).append(") is not a RSAPrivateKey instance").toString());
        } else
        {
            privatekey = RSAUtil._mth02CA((RSAPrivateKey)privatekey);
            amS.reset();
            amx._mth02CA(true, privatekey);
            return;
        }
    }

    protected void engineInitVerify(PublicKey publickey)
    {
        if (!(publickey instanceof RSAPublicKey))
        {
            StringBuilder stringbuilder = new StringBuilder("Supplied key (");
            if (publickey == null)
            {
                publickey = null;
            } else
            {
                publickey = publickey.getClass().getName();
            }
            throw new InvalidKeyException(stringbuilder.append(publickey).append(") is not a RSAPublicKey instance").toString());
        } else
        {
            publickey = RSAUtil._mth02CA((RSAPublicKey)publickey);
            amS.reset();
            amx._mth02CA(false, publickey);
            return;
        }
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
            if (aaK == null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
        }
        // Misplaced declaration of an exception variable
        catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
        {
            throw new SignatureException("key too small for signature type");
        }
        catch (Exception exception)
        {
            throw new SignatureException(exception.toString());
        }
        abyte0 = (new DigestInfo(aaK, abyte0)).getEncoded("DER");
        abyte0 = amx._mth1FBE(abyte0, 0, abyte0.length);
        ArrayIndexOutOfBoundsException arrayindexoutofboundsexception;
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
        byte abyte1[];
        abyte1 = new byte[amS._mth14AF()];
        amS.doFinal(abyte1, 0);
        byte abyte2[] = amx._mth1FBE(abyte0, 0, abyte0.length);
        if (aaK == null)
        {
            abyte0 = abyte1;
        } else
        {
            try
            {
                abyte0 = (new DigestInfo(aaK, abyte1)).getEncoded("DER");
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                return false;
            }
        }
        if (abyte2.length == abyte0.length)
        {
            for (int i = 0; i < abyte2.length; i++)
            {
                if (abyte2[i] != abyte0[i])
                {
                    return false;
                }
            }

        } else
        if (abyte2.length == abyte0.length - 2)
        {
            int l = abyte2.length - abyte1.length - 2;
            int i1 = abyte0.length;
            int j1 = abyte1.length;
            abyte0[1] = (byte)(abyte0[1] - 2);
            abyte0[3] = (byte)(abyte0[3] - 2);
            for (int j = 0; j < abyte1.length; j++)
            {
                if (abyte2[l + j] != abyte0[(i1 - j1 - 2) + j])
                {
                    return false;
                }
            }

            for (int k = 0; k < l; k++)
            {
                if (abyte2[k] != abyte0[k])
                {
                    return false;
                }
            }

        } else
        {
            return false;
        }
        return true;
    }
}
