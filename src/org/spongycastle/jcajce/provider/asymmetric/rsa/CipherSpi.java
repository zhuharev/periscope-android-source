// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.encodings.ISO9796d1Encoding;
import org.spongycastle.crypto.encodings.OAEPEncoding;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.rsa:
//            RSAUtil

public class CipherSpi extends BaseCipherSpi
{
    public static class ISO9796d1Padding extends CipherSpi
    {

        public ISO9796d1Padding()
        {
            super(new ISO9796d1Encoding(new RSABlindedEngine()));
        }
    }

    public static class NoPadding extends CipherSpi
    {

        public NoPadding()
        {
            super(new RSABlindedEngine());
        }
    }

    public static class OAEPPadding extends CipherSpi
    {

        public OAEPPadding()
        {
            super(OAEPParameterSpec.DEFAULT);
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi
    {

        public PKCS1v1_5Padding()
        {
            super(new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PrivateOnly extends CipherSpi
    {

        public PKCS1v1_5Padding_PrivateOnly()
        {
            super(false, true, new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PublicOnly extends CipherSpi
    {

        public PKCS1v1_5Padding_PublicOnly()
        {
            super(true, false, new PKCS1Encoding(new RSABlindedEngine()));
        }
    }


    private AlgorithmParameters aDC;
    private AlgorithmParameterSpec aDX;
    private boolean aDY;
    private boolean aDZ;
    private AsymmetricBlockCipher amx;
    private ByteArrayOutputStream anR;

    public CipherSpi(OAEPParameterSpec oaepparameterspec)
    {
        aDY = false;
        aDZ = false;
        anR = new ByteArrayOutputStream();
        try
        {
            _mth02CA(oaepparameterspec);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OAEPParameterSpec oaepparameterspec)
        {
            throw new IllegalArgumentException(oaepparameterspec.getMessage());
        }
    }

    public CipherSpi(AsymmetricBlockCipher asymmetricblockcipher)
    {
        aDY = false;
        aDZ = false;
        anR = new ByteArrayOutputStream();
        amx = asymmetricblockcipher;
    }

    public CipherSpi(boolean flag, boolean flag1, PKCS1Encoding pkcs1encoding)
    {
        aDY = false;
        aDZ = false;
        anR = new ByteArrayOutputStream();
        aDY = flag;
        aDZ = flag1;
        amx = pkcs1encoding;
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
            amx = new OAEPEncoding(new RSABlindedEngine(), extendeddigest, ((javax.crypto.spec.PSource.PSpecified)oaepparameterspec.getPSource()).getValue());
            aDX = oaepparameterspec;
            return;
        }
    }

    protected int engineDoFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (abyte0 != null)
        {
            anR.write(abyte0, i, j);
        }
        if (amx instanceof RSABlindedEngine)
        {
            if (anR.size() > amx._mth148C() + 1)
            {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else
        if (anR.size() > amx._mth148C())
        {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        abyte0 = anR.toByteArray();
        abyte0 = amx._mth1FBE(abyte0, 0, abyte0.length);
        anR.reset();
        break MISSING_BLOCK_LABEL_139;
        abyte0;
        throw new BadPaddingException(abyte0.getMessage());
        abyte0;
        anR.reset();
        throw abyte0;
        for (i = 0; i != abyte0.length; i++)
        {
            abyte1[k + i] = abyte0[i];
        }

        return abyte0.length;
    }

    protected byte[] engineDoFinal(byte abyte0[], int i, int j)
    {
        if (abyte0 != null)
        {
            anR.write(abyte0, i, j);
        }
        if (amx instanceof RSABlindedEngine)
        {
            if (anR.size() > amx._mth148C() + 1)
            {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else
        if (anR.size() > amx._mth148C())
        {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        try
        {
            abyte0 = anR.toByteArray();
            anR.reset();
            abyte0 = amx._mth1FBE(abyte0, 0, abyte0.length);
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
        NullPointerException nullpointerexception;
        int i;
        try
        {
            i = amx._mth148C();
        }
        // Misplaced declaration of an exception variable
        catch (NullPointerException nullpointerexception)
        {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
        return i;
    }

    protected int engineGetKeySize(Key key)
    {
        if (key instanceof RSAPrivateKey)
        {
            return ((RSAPrivateKey)key).getModulus().bitLength();
        }
        if (key instanceof RSAPublicKey)
        {
            return ((RSAPublicKey)key).getModulus().bitLength();
        } else
        {
            throw new IllegalArgumentException("not an RSA key!");
        }
    }

    protected int engineGetOutputSize(int i)
    {
        NullPointerException nullpointerexception;
        try
        {
            i = amx._mth148E();
        }
        // Misplaced declaration of an exception variable
        catch (NullPointerException nullpointerexception)
        {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
        return i;
    }

    protected AlgorithmParameters engineGetParameters()
    {
        if (aDC == null && aDX != null)
        {
            try
            {
                aDC = AlgorithmParameters.getInstance("OAEP", "SC");
                aDC.init(aDX);
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
        AlgorithmParameterSpec algorithmparameterspec = null;
        if (algorithmparameters != null)
        {
            try
            {
                algorithmparameterspec = algorithmparameters.getParameterSpec(javax/crypto/spec/OAEPParameterSpec);
            }
            // Misplaced declaration of an exception variable
            catch (Key key)
            {
                throw new InvalidAlgorithmParameterException((new StringBuilder("cannot recognise parameters: ")).append(key.toString()).toString(), key);
            }
        }
        aDC = algorithmparameters;
        engineInit(i, key, algorithmparameterspec, securerandom);
    }

    protected void engineInit(int i, Key key, SecureRandom securerandom)
    {
        try
        {
            engineInit(i, key, ((AlgorithmParameterSpec) (null)), securerandom);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new InvalidKeyException((new StringBuilder("Eeeek! ")).append(key.toString()).toString(), key);
        }
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (algorithmparameterspec == null || (algorithmparameterspec instanceof OAEPParameterSpec))
        {
            if (key instanceof RSAPublicKey)
            {
                if (aDZ && i == 1)
                {
                    throw new InvalidKeyException("mode 1 requires RSAPrivateKey");
                }
                key = RSAUtil._mth02CA((RSAPublicKey)key);
            } else
            if (key instanceof RSAPrivateKey)
            {
                if (aDY && i == 1)
                {
                    throw new InvalidKeyException("mode 2 requires RSAPublicKey");
                }
                key = RSAUtil._mth02CA((RSAPrivateKey)key);
            } else
            {
                throw new InvalidKeyException("unknown key type passed to RSA");
            }
            if (algorithmparameterspec != null)
            {
                OAEPParameterSpec oaepparameterspec = (OAEPParameterSpec)algorithmparameterspec;
                aDX = algorithmparameterspec;
                if (!oaepparameterspec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !oaepparameterspec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.abd.identifier))
                {
                    throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
                }
                if (!(oaepparameterspec.getMGFParameters() instanceof MGF1ParameterSpec))
                {
                    throw new InvalidAlgorithmParameterException("unkown MGF parameters");
                }
                algorithmparameterspec = DigestFactory.FB4B(oaepparameterspec.getDigestAlgorithm());
                if (algorithmparameterspec == null)
                {
                    throw new InvalidAlgorithmParameterException((new StringBuilder("no match on digest algorithm: ")).append(oaepparameterspec.getDigestAlgorithm()).toString());
                }
                MGF1ParameterSpec mgf1parameterspec = (MGF1ParameterSpec)oaepparameterspec.getMGFParameters();
                org.spongycastle.crypto.ExtendedDigest extendeddigest = DigestFactory.FB4B(mgf1parameterspec.getDigestAlgorithm());
                if (extendeddigest == null)
                {
                    throw new InvalidAlgorithmParameterException((new StringBuilder("no match on MGF digest algorithm: ")).append(mgf1parameterspec.getDigestAlgorithm()).toString());
                }
                amx = new OAEPEncoding(new RSABlindedEngine(), algorithmparameterspec, extendeddigest, ((javax.crypto.spec.PSource.PSpecified)oaepparameterspec.getPSource()).getValue());
            }
        } else
        {
            throw new InvalidAlgorithmParameterException((new StringBuilder("unknown parameter type: ")).append(algorithmparameterspec.getClass().getName()).toString());
        }
        algorithmparameterspec = key;
        if (!(amx instanceof RSABlindedEngine))
        {
            if (securerandom != null)
            {
                algorithmparameterspec = new ParametersWithRandom(key, securerandom);
            } else
            {
                algorithmparameterspec = new ParametersWithRandom(key, new SecureRandom());
            }
        }
        anR.reset();
        switch (i)
        {
        case 1: // '\001'
        case 3: // '\003'
            amx._mth02CA(true, algorithmparameterspec);
            return;

        case 2: // '\002'
        case 4: // '\004'
            amx._mth02CA(false, algorithmparameterspec);
            return;
        }
        throw new InvalidParameterException((new StringBuilder("unknown opmode ")).append(i).append(" passed to RSA").toString());
    }

    protected void engineSetMode(String s)
    {
        String s1 = Strings.FE7C(s);
        if (s1.equals("NONE") || s1.equals("ECB"))
        {
            return;
        }
        if (s1.equals("1"))
        {
            aDZ = true;
            aDY = false;
            return;
        }
        if (s1.equals("2"))
        {
            aDZ = false;
            aDY = true;
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
            amx = new RSABlindedEngine();
            return;
        }
        if (s1.equals("PKCS1PADDING"))
        {
            amx = new PKCS1Encoding(new RSABlindedEngine());
            return;
        }
        if (s1.equals("ISO9796-1PADDING"))
        {
            amx = new ISO9796d1Encoding(new RSABlindedEngine());
            return;
        }
        if (s1.equals("OAEPWITHMD5ANDMGF1PADDING"))
        {
            _mth02CA(new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return;
        }
        if (s1.equals("OAEPPADDING"))
        {
            _mth02CA(OAEPParameterSpec.DEFAULT);
            return;
        }
        if (s1.equals("OAEPWITHSHA1ANDMGF1PADDING") || s1.equals("OAEPWITHSHA-1ANDMGF1PADDING"))
        {
            _mth02CA(OAEPParameterSpec.DEFAULT);
            return;
        }
        if (s1.equals("OAEPWITHSHA224ANDMGF1PADDING") || s1.equals("OAEPWITHSHA-224ANDMGF1PADDING"))
        {
            _mth02CA(new OAEPParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return;
        }
        if (s1.equals("OAEPWITHSHA256ANDMGF1PADDING") || s1.equals("OAEPWITHSHA-256ANDMGF1PADDING"))
        {
            _mth02CA(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return;
        }
        if (s1.equals("OAEPWITHSHA384ANDMGF1PADDING") || s1.equals("OAEPWITHSHA-384ANDMGF1PADDING"))
        {
            _mth02CA(new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return;
        }
        if (s1.equals("OAEPWITHSHA512ANDMGF1PADDING") || s1.equals("OAEPWITHSHA-512ANDMGF1PADDING"))
        {
            _mth02CA(new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return;
        } else
        {
            throw new NoSuchPaddingException((new StringBuilder()).append(s).append(" unavailable with RSA.").toString());
        }
    }

    protected int engineUpdate(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        anR.write(abyte0, i, j);
        if (amx instanceof RSABlindedEngine)
        {
            if (anR.size() > amx._mth148C() + 1)
            {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else
        if (anR.size() > amx._mth148C())
        {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        return 0;
    }

    protected byte[] engineUpdate(byte abyte0[], int i, int j)
    {
        anR.write(abyte0, i, j);
        if (amx instanceof RSABlindedEngine)
        {
            if (anR.size() > amx._mth148C() + 1)
            {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else
        if (anR.size() > amx._mth148C())
        {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        return null;
    }
}
