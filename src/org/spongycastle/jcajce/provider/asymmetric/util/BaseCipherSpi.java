// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public abstract class BaseCipherSpi extends CipherSpi
{

    private AlgorithmParameters aDC;
    private Class aDN[] = {
        javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec, javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec
    };
    private Wrapper aEn;

    public BaseCipherSpi()
    {
        aDC = null;
        aEn = null;
    }

    public int engineGetBlockSize()
    {
        return 0;
    }

    protected byte[] engineGetIV()
    {
        return null;
    }

    public int engineGetKeySize(Key key)
    {
        return key.getEncoded().length;
    }

    public int engineGetOutputSize(int i)
    {
        return -1;
    }

    public AlgorithmParameters engineGetParameters()
    {
        return null;
    }

    public void engineSetMode(String s)
    {
        throw new NoSuchAlgorithmException((new StringBuilder("can't support mode ")).append(s).toString());
    }

    public void engineSetPadding(String s)
    {
        throw new NoSuchPaddingException((new StringBuilder("Padding ")).append(s).append(" unknown.").toString());
    }

    protected Key engineUnwrap(byte abyte0[], String s, int i)
    {
        try
        {
            abyte0 = engineDoFinal(abyte0, 0, abyte0.length);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException(abyte0.getMessage());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException(abyte0.getMessage());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException(abyte0.getMessage());
        }
        if (i == 3)
        {
            return new SecretKeySpec(abyte0, s);
        }
        if (!s.equals("") || i != 2)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        try
        {
            abyte0 = PrivateKeyInfo._mth1D38(abyte0);
            s = BouncyCastleProvider._mth02CF(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException("Invalid key encoding.");
        }
        if (s != null)
        {
            return s;
        }
        throw new InvalidKeyException((new StringBuilder("algorithm ")).append(new ASN1ObjectIdentifier(((PrivateKeyInfo) (abyte0)).aaK.ahP.identifier)).append(" not supported").toString());
        try
        {
            s = KeyFactory.getInstance(s, "SC");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException((new StringBuilder("Unknown key type ")).append(abyte0.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException((new StringBuilder("Unknown key type ")).append(abyte0.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException((new StringBuilder("Unknown key type ")).append(abyte0.getMessage()).toString());
        }
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        abyte0 = s.generatePublic(new X509EncodedKeySpec(abyte0));
        return abyte0;
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        abyte0 = s.generatePrivate(new PKCS8EncodedKeySpec(abyte0));
        return abyte0;
        throw new InvalidKeyException((new StringBuilder("Unknown key type ")).append(i).toString());
    }

    protected byte[] engineWrap(Key key)
    {
        key = key.getEncoded();
        if (key == null)
        {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
        try
        {
            key = engineDoFinal(key, 0, key.length);
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new IllegalBlockSizeException(key.getMessage());
        }
        return key;
    }
}
