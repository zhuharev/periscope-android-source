// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import java.io.PrintStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
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
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.jce.provider.BouncyCastleProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            PBE, BCPBEKey

public abstract class BaseWrapCipher extends CipherSpi
    implements PBE
{

    protected AlgorithmParameters aDC;
    private Class aDN[] = {
        javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec, javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec
    };
    private Wrapper aEn;
    private int aFX;
    private int aFY;
    private int aFw;
    private byte iv[];

    protected BaseWrapCipher()
    {
        aFX = 2;
        aFY = 1;
        aDC = null;
        aEn = null;
    }

    public BaseWrapCipher(Wrapper wrapper)
    {
        this(wrapper, 0);
    }

    public BaseWrapCipher(Wrapper wrapper, int i)
    {
        aFX = 2;
        aFY = 1;
        aDC = null;
        aEn = null;
        aEn = wrapper;
        aFw = i;
    }

    protected int engineDoFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        return 0;
    }

    protected byte[] engineDoFinal(byte abyte0[], int i, int j)
    {
        return null;
    }

    protected int engineGetBlockSize()
    {
        return 0;
    }

    protected byte[] engineGetIV()
    {
        return (byte[])iv.clone();
    }

    protected int engineGetKeySize(Key key)
    {
        return key.getEncoded().length;
    }

    protected int engineGetOutputSize(int i)
    {
        return -1;
    }

    protected AlgorithmParameters engineGetParameters()
    {
        return null;
    }

    protected void engineInit(int i, Key key, AlgorithmParameters algorithmparameters, SecureRandom securerandom)
    {
        Exception exception;
        AlgorithmParameterSpec algorithmparameterspec1 = null;
        Object obj = null;
        if (algorithmparameters != null)
        {
            int j = 0;
            AlgorithmParameterSpec algorithmparameterspec;
            do
            {
                algorithmparameterspec = obj;
                if (j == aDN.length)
                {
                    break;
                }
                try
                {
                    algorithmparameterspec = algorithmparameters.getParameterSpec(aDN[j]);
                    break;
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    j++;
                }
            } while (true);
            algorithmparameterspec1 = algorithmparameterspec;
            if (algorithmparameterspec == null)
            {
                throw new InvalidAlgorithmParameterException((new StringBuilder("can't handle parameter ")).append(algorithmparameters.toString()).toString());
            }
        }
        aDC = algorithmparameters;
        engineInit(i, key, algorithmparameterspec1, securerandom);
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
            throw new IllegalArgumentException(key.getMessage());
        }
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (key instanceof BCPBEKey)
        {
            key = (BCPBEKey)key;
            if (algorithmparameterspec instanceof PBEParameterSpec)
            {
                key = PBE.Util._mth02CA(key, algorithmparameterspec, aEn._mth14AC());
            } else
            if (((BCPBEKey) (key)).aso != null)
            {
                key = ((BCPBEKey) (key)).aso;
            } else
            {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
        } else
        {
            key = new KeyParameter(key.getEncoded());
        }
        Object obj = key;
        if (algorithmparameterspec instanceof IvParameterSpec)
        {
            obj = new ParametersWithIV(key, ((IvParameterSpec)algorithmparameterspec).getIV());
        }
        key = ((Key) (obj));
        if (obj instanceof KeyParameter)
        {
            key = ((Key) (obj));
            if (aFw != 0)
            {
                iv = new byte[aFw];
                securerandom.nextBytes(iv);
                key = new ParametersWithIV(((org.spongycastle.crypto.CipherParameters) (obj)), iv);
            }
        }
        algorithmparameterspec = key;
        if (securerandom != null)
        {
            algorithmparameterspec = new ParametersWithRandom(key, securerandom);
        }
        switch (i)
        {
        case 3: // '\003'
            aEn._mth02CA(true, algorithmparameterspec);
            return;

        case 4: // '\004'
            aEn._mth02CA(false, algorithmparameterspec);
            return;

        case 1: // '\001'
        case 2: // '\002'
            throw new IllegalArgumentException("engine only valid for wrapping");
        }
        System.out.println("eeek!");
    }

    protected void engineSetMode(String s)
    {
        throw new NoSuchAlgorithmException((new StringBuilder("can't support mode ")).append(s).toString());
    }

    protected void engineSetPadding(String s)
    {
        throw new NoSuchPaddingException((new StringBuilder("Padding ")).append(s).append(" unknown.").toString());
    }

    protected Key engineUnwrap(byte abyte0[], String s, int i)
    {
label0:
        {
            if (aEn == null)
            {
                abyte0 = engineDoFinal(abyte0, 0, abyte0.length);
                break label0;
            }
            try
            {
                abyte0 = aEn._mth02C9(abyte0, 0, abyte0.length);
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
        }
        if (i == 3)
        {
            return new SecretKeySpec(abyte0, s);
        }
        if (!s.equals("") || i != 2)
        {
            break MISSING_BLOCK_LABEL_177;
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
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        abyte0 = s.generatePublic(new X509EncodedKeySpec(abyte0));
        return abyte0;
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        abyte0 = s.generatePrivate(new PKCS8EncodedKeySpec(abyte0));
        return abyte0;
        throw new InvalidKeyException((new StringBuilder("Unknown key type ")).append(i).toString());
    }

    protected int engineUpdate(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        throw new RuntimeException("not supported for wrapping");
    }

    protected byte[] engineUpdate(byte abyte0[], int i, int j)
    {
        throw new RuntimeException("not supported for wrapping");
    }

    protected byte[] engineWrap(Key key)
    {
        key = key.getEncoded();
        if (key == null)
        {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
        if (aEn != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        key = engineDoFinal(key, 0, key.length);
        return key;
        try
        {
            key = aEn._mth02C8(key, 0, key.length);
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new IllegalBlockSizeException(key.getMessage());
        }
        return key;
    }
}
