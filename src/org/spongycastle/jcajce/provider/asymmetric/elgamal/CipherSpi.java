// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.BufferedAsymmetricBlockCipher;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.encodings.ISO9796d1Encoding;
import org.spongycastle.crypto.encodings.OAEPEncoding;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.ElGamalEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.jce.interfaces.ElGamalKey;
import org.spongycastle.jce.interfaces.ElGamalPrivateKey;
import org.spongycastle.jce.interfaces.ElGamalPublicKey;
import org.spongycastle.jce.spec.ElGamalParameterSpec;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.elgamal:
//            ElGamalUtil

public class CipherSpi extends BaseCipherSpi
{
    public static class NoPadding extends CipherSpi
    {

        public NoPadding()
        {
            super(new ElGamalEngine());
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi
    {

        public PKCS1v1_5Padding()
        {
            super(new PKCS1Encoding(new ElGamalEngine()));
        }
    }


    private BufferedAsymmetricBlockCipher aDA;
    private OAEPParameterSpec aDB;
    private AlgorithmParameters aDC;

    public CipherSpi(AsymmetricBlockCipher asymmetricblockcipher)
    {
        aDA = new BufferedAsymmetricBlockCipher(asymmetricblockcipher);
    }

    private void _mth02CA(OAEPParameterSpec oaepparameterspec)
    {
        MGF1ParameterSpec mgf1parameterspec = (MGF1ParameterSpec)oaepparameterspec.getMGFParameters();
        org.spongycastle.crypto.ExtendedDigest extendeddigest = DigestFactory.FB4B(mgf1parameterspec.getDigestAlgorithm());
        if (extendeddigest == null)
        {
            throw new NoSuchPaddingException((new StringBuilder("no match on OAEP constructor for digest algorithm: ")).append(mgf1parameterspec.getDigestAlgorithm()).toString());
        } else
        {
            aDA = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine(), extendeddigest, ((javax.crypto.spec.PSource.PSpecified)oaepparameterspec.getPSource()).getValue()));
            aDB = oaepparameterspec;
            return;
        }
    }

    protected int engineDoFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        aDA._mth02BE(abyte0, i, j);
        try
        {
            abyte0 = aDA.doFinal();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new BadPaddingException(abyte0.getMessage());
        }
        for (i = 0; i != abyte0.length; i++)
        {
            abyte1[k + i] = abyte0[i];
        }

        return abyte0.length;
    }

    protected byte[] engineDoFinal(byte abyte0[], int i, int j)
    {
        aDA._mth02BE(abyte0, i, j);
        try
        {
            abyte0 = aDA.doFinal();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new BadPaddingException(abyte0.getMessage());
        }
        return abyte0;
    }

    protected int engineGetBlockSize()
    {
        return aDA.amx._mth148C();
    }

    protected int engineGetKeySize(Key key)
    {
        if (key instanceof ElGamalKey)
        {
            return ((ElGamalKey)key)._mth15AC().amM.bitLength();
        }
        if (key instanceof DHKey)
        {
            return ((DHKey)key).getParams().getP().bitLength();
        } else
        {
            throw new IllegalArgumentException("not an ElGamal key!");
        }
    }

    protected int engineGetOutputSize(int i)
    {
        return aDA.amx._mth148E();
    }

    protected AlgorithmParameters engineGetParameters()
    {
        if (aDC == null && aDB != null)
        {
            try
            {
                aDC = AlgorithmParameters.getInstance("OAEP", "SC");
                aDC.init(aDB);
            }
            catch (Exception exception)
            {
                throw new RuntimeException(exception.toString());
            }
        }
        return aDC;
    }

    protected void engineInit(int i, Key key, AlgorithmParameters algorithmparameters, SecureRandom securerandom)
    {
        throw new InvalidAlgorithmParameterException("can't handle parameters in ElGamal");
    }

    protected void engineInit(int i, Key key, SecureRandom securerandom)
    {
        engineInit(i, key, ((AlgorithmParameterSpec) (null)), securerandom);
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (algorithmparameterspec == null)
        {
            if (key instanceof ElGamalPublicKey)
            {
                key = ElGamalUtil._mth02CB((PublicKey)key);
            } else
            if (key instanceof ElGamalPrivateKey)
            {
                key = ElGamalUtil._mth02CB((PrivateKey)key);
            } else
            {
                throw new InvalidKeyException("unknown key type passed to ElGamal");
            }
        } else
        {
            throw new IllegalArgumentException("unknown parameter type.");
        }
        algorithmparameterspec = key;
        if (securerandom != null)
        {
            algorithmparameterspec = new ParametersWithRandom(key, securerandom);
        }
        switch (i)
        {
        case 1: // '\001'
        case 3: // '\003'
            aDA._mth02CA(true, algorithmparameterspec);
            return;

        case 2: // '\002'
        case 4: // '\004'
            aDA._mth02CA(false, algorithmparameterspec);
            return;
        }
        throw new InvalidParameterException((new StringBuilder("unknown opmode ")).append(i).append(" passed to ElGamal").toString());
    }

    protected void engineSetMode(String s)
    {
        String s1 = Strings.FE7C(s);
        if (s1.equals("NONE") || s1.equals("ECB"))
        {
            return;
        } else
        {
            throw new NoSuchAlgorithmException((new StringBuilder("can't support mode ")).append(s).toString());
        }
    }

    protected void engineSetPadding(String s)
    {
        String s1 = Strings.FE7C(s);
        if (s1.equals("NOPADDING"))
        {
            aDA = new BufferedAsymmetricBlockCipher(new ElGamalEngine());
            return;
        }
        if (s1.equals("PKCS1PADDING"))
        {
            aDA = new BufferedAsymmetricBlockCipher(new PKCS1Encoding(new ElGamalEngine()));
            return;
        }
        if (s1.equals("ISO9796-1PADDING"))
        {
            aDA = new BufferedAsymmetricBlockCipher(new ISO9796d1Encoding(new ElGamalEngine()));
            return;
        }
        if (s1.equals("OAEPPADDING"))
        {
            _mth02CA(OAEPParameterSpec.DEFAULT);
            return;
        }
        if (s1.equals("OAEPWITHMD5ANDMGF1PADDING"))
        {
            _mth02CA(new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return;
        }
        if (s1.equals("OAEPWITHSHA1ANDMGF1PADDING"))
        {
            _mth02CA(OAEPParameterSpec.DEFAULT);
            return;
        }
        if (s1.equals("OAEPWITHSHA224ANDMGF1PADDING"))
        {
            _mth02CA(new OAEPParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return;
        }
        if (s1.equals("OAEPWITHSHA256ANDMGF1PADDING"))
        {
            _mth02CA(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return;
        }
        if (s1.equals("OAEPWITHSHA384ANDMGF1PADDING"))
        {
            _mth02CA(new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return;
        }
        if (s1.equals("OAEPWITHSHA512ANDMGF1PADDING"))
        {
            _mth02CA(new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return;
        } else
        {
            throw new NoSuchPaddingException((new StringBuilder()).append(s).append(" unavailable with ElGamal.").toString());
        }
    }

    protected int engineUpdate(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        aDA._mth02BE(abyte0, i, j);
        return 0;
    }

    protected byte[] engineUpdate(byte abyte0[], int i, int j)
    {
        aDA._mth02BE(abyte0, i, j);
        return null;
    }
}
