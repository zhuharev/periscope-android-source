// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.GOST3410Signer;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import org.spongycastle.jce.interfaces.ECKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.interfaces.GOST3410Key;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public class SignatureSpi extends java.security.SignatureSpi
    implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{

    private GOST3410Signer aDJ;
    private GOST3411Digest aDj;
    private SecureRandom amC;

    public SignatureSpi()
    {
        aDj = new GOST3411Digest();
        aDJ = new GOST3410Signer();
    }

    protected Object engineGetParameter(String s)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineInitSign(PrivateKey privatekey)
    {
        if (privatekey instanceof ECKey)
        {
            privatekey = ECUtil._mth02CF(privatekey);
        } else
        {
            privatekey = GOST3410Util._mth141D(privatekey);
        }
        aDj.reset();
        if (amC != null)
        {
            aDJ._mth02CA(true, new ParametersWithRandom(privatekey, amC));
            return;
        } else
        {
            aDJ._mth02CA(true, privatekey);
            return;
        }
    }

    protected void engineInitSign(PrivateKey privatekey, SecureRandom securerandom)
    {
        amC = securerandom;
        engineInitSign(privatekey);
    }

    protected void engineInitVerify(PublicKey publickey)
    {
        if (publickey instanceof ECPublicKey)
        {
            publickey = ECUtil._mth02CF(publickey);
            break MISSING_BLOCK_LABEL_78;
        }
        if (publickey instanceof GOST3410Key)
        {
            publickey = GOST3410Util._mth141D(publickey);
            break MISSING_BLOCK_LABEL_78;
        }
        publickey = BouncyCastleProvider._mth141D(SubjectPublicKeyInfo._mth13A5(publickey.getEncoded()));
        if (publickey instanceof ECPublicKey)
        {
            publickey = ECUtil._mth02CF(publickey);
            break MISSING_BLOCK_LABEL_78;
        } else
        {
            try
            {
                throw new InvalidKeyException("can't recognise key type in DSA based signer");
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                throw new InvalidKeyException("can't recognise key type in DSA based signer");
            }
        }
        aDj.reset();
        aDJ._mth02CA(false, publickey);
        return;
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
        byte abyte1[] = new byte[aDj._mth14AF()];
        aDj.doFinal(abyte1, 0);
        byte abyte0[];
        Object aobj[];
        try
        {
            abyte0 = new byte[64];
            aobj = aDJ._mth1428(abyte1);
            abyte1 = aobj[0].toByteArray();
            aobj = aobj[1].toByteArray();
        }
        catch (Exception exception)
        {
            throw new SignatureException(exception.toString());
        }
        if (aobj[0] == 0)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        System.arraycopy(((Object) (aobj)), 0, abyte0, 32 - aobj.length, aobj.length);
        break MISSING_BLOCK_LABEL_93;
        System.arraycopy(((Object) (aobj)), 1, abyte0, 32 - (aobj.length - 1), aobj.length - 1);
        if (abyte1[0] == 0)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        System.arraycopy(abyte1, 0, abyte0, 64 - abyte1.length, abyte1.length);
        return abyte0;
        System.arraycopy(abyte1, 1, abyte0, 64 - (abyte1.length - 1), abyte1.length - 1);
        return abyte0;
    }

    protected void engineUpdate(byte byte0)
    {
        aDj.update(byte0);
    }

    protected void engineUpdate(byte abyte0[], int i, int j)
    {
        aDj.update(abyte0, i, j);
    }

    protected boolean engineVerify(byte abyte0[])
    {
        byte abyte1[] = new byte[aDj._mth14AF()];
        aDj.doFinal(abyte1, 0);
        try
        {
            byte abyte2[] = new byte[32];
            byte abyte3[] = new byte[32];
            System.arraycopy(abyte0, 0, abyte3, 0, 32);
            System.arraycopy(abyte0, 32, abyte2, 0, 32);
            abyte0 = new BigInteger[2];
            abyte0[0] = new BigInteger(1, abyte2);
            abyte0[1] = new BigInteger(1, abyte3);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new SignatureException("error decoding signature bytes.");
        }
        return aDJ._mth02CA(abyte1, abyte0[0], abyte0[1]);
    }
}
