// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

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
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.engines.BlowfishEngine;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.SkipjackEngine;
import org.spongycastle.crypto.engines.TwofishEngine;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;

// Referenced classes of package org.spongycastle.jce.provider:
//            BouncyCastleProvider

public class JCEStreamCipher extends CipherSpi
    implements PBE
{
    public static class Blowfish_CFB8 extends JCEStreamCipher
    {

        public Blowfish_CFB8()
        {
            super(new CFBBlockCipher(new BlowfishEngine(), 8), 64);
        }
    }

    public static class Blowfish_OFB8 extends JCEStreamCipher
    {

        public Blowfish_OFB8()
        {
            super(new OFBBlockCipher(new BlowfishEngine(), 8), 64);
        }
    }

    public static class DES_CFB8 extends JCEStreamCipher
    {

        public DES_CFB8()
        {
            super(new CFBBlockCipher(new DESEngine(), 8), 64);
        }
    }

    public static class DES_OFB8 extends JCEStreamCipher
    {

        public DES_OFB8()
        {
            super(new OFBBlockCipher(new DESEngine(), 8), 64);
        }
    }

    public static class DESede_CFB8 extends JCEStreamCipher
    {

        public DESede_CFB8()
        {
            super(new CFBBlockCipher(new DESedeEngine(), 8), 64);
        }
    }

    public static class DESede_OFB8 extends JCEStreamCipher
    {

        public DESede_OFB8()
        {
            super(new OFBBlockCipher(new DESedeEngine(), 8), 64);
        }
    }

    public static class Skipjack_CFB8 extends JCEStreamCipher
    {

        public Skipjack_CFB8()
        {
            super(new CFBBlockCipher(new SkipjackEngine(), 8), 64);
        }
    }

    public static class Skipjack_OFB8 extends JCEStreamCipher
    {

        public Skipjack_OFB8()
        {
            super(new OFBBlockCipher(new SkipjackEngine(), 8), 64);
        }
    }

    public static class Twofish_CFB8 extends JCEStreamCipher
    {

        public Twofish_CFB8()
        {
            super(new CFBBlockCipher(new TwofishEngine(), 8), 128);
        }
    }

    public static class Twofish_OFB8 extends JCEStreamCipher
    {

        public Twofish_OFB8()
        {
            super(new OFBBlockCipher(new TwofishEngine(), 8), 128);
        }
    }


    private AlgorithmParameters aDC;
    private Class aDN[] = {
        javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec, javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec
    };
    private int aDn;
    private ParametersWithIV aFK;
    private PBEParameterSpec aFN;
    private String aFO;
    private StreamCipher aGa;

    protected JCEStreamCipher(StreamBlockCipher streamblockcipher, int i)
    {
        aDn = 0;
        aFN = null;
        aFO = null;
        aGa = streamblockcipher;
        aDn = i;
    }

    protected int engineDoFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (j != 0)
        {
            aGa._mth02CB(abyte0, i, j, abyte1, k);
        }
        aGa.reset();
        return j;
    }

    protected byte[] engineDoFinal(byte abyte0[], int i, int j)
    {
        if (j != 0)
        {
            abyte0 = engineUpdate(abyte0, i, j);
            aGa.reset();
            return abyte0;
        } else
        {
            aGa.reset();
            return new byte[0];
        }
    }

    protected int engineGetBlockSize()
    {
        return 0;
    }

    protected byte[] engineGetIV()
    {
        if (aFK != null)
        {
            return aFK.iv;
        } else
        {
            return null;
        }
    }

    protected int engineGetKeySize(Key key)
    {
        return key.getEncoded().length << 3;
    }

    protected int engineGetOutputSize(int i)
    {
        return i;
    }

    protected AlgorithmParameters engineGetParameters()
    {
        Exception exception;
        if (aDC == null && aFN != null)
        {
            AlgorithmParameters algorithmparameters;
            try
            {
                algorithmparameters = AlgorithmParameters.getInstance(aFO, "SC");
                algorithmparameters.init(aFN);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                return null;
            }
            return algorithmparameters;
        } else
        {
            return aDC;
        }
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
        engineInit(i, key, algorithmparameterspec1, securerandom);
        aDC = algorithmparameters;
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
            throw new InvalidKeyException(key.getMessage());
        }
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        aFN = null;
        aFO = null;
        aDC = null;
        if (!(key instanceof SecretKey))
        {
            throw new InvalidKeyException((new StringBuilder("Key for algorithm ")).append(key.getAlgorithm()).append(" not suitable for symmetric enryption.").toString());
        }
        if (key instanceof BCPBEKey)
        {
            BCPBEKey bcpbekey = (BCPBEKey)key;
            if (bcpbekey.aFE != null)
            {
                aFO = bcpbekey.aFE.identifier;
            } else
            {
                aFO = bcpbekey.getAlgorithm();
            }
            if (bcpbekey.aso != null)
            {
                key = bcpbekey.aso;
                aFN = new PBEParameterSpec(bcpbekey.getSalt(), bcpbekey.getIterationCount());
            } else
            if (algorithmparameterspec instanceof PBEParameterSpec)
            {
                key = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util._mth02CA(bcpbekey, algorithmparameterspec, aGa._mth14AC());
                aFN = (PBEParameterSpec)algorithmparameterspec;
            } else
            {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
            if (bcpbekey.aFw != 0)
            {
                aFK = (ParametersWithIV)key;
            }
        } else
        if (algorithmparameterspec == null)
        {
            key = new KeyParameter(key.getEncoded());
        } else
        if (algorithmparameterspec instanceof IvParameterSpec)
        {
            key = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec)algorithmparameterspec).getIV());
            aFK = (ParametersWithIV)key;
        } else
        {
            throw new IllegalArgumentException("unknown parameter type.");
        }
        algorithmparameterspec = key;
        if (aDn != 0)
        {
            algorithmparameterspec = key;
            if (!(key instanceof ParametersWithIV))
            {
                algorithmparameterspec = securerandom;
                if (securerandom == null)
                {
                    algorithmparameterspec = new SecureRandom();
                }
                if (i == 1 || i == 3)
                {
                    securerandom = new byte[aDn];
                    algorithmparameterspec.nextBytes(securerandom);
                    algorithmparameterspec = new ParametersWithIV(key, securerandom);
                    aFK = (ParametersWithIV)algorithmparameterspec;
                } else
                {
                    throw new InvalidAlgorithmParameterException("no IV set when one expected");
                }
            }
        }
        switch (i)
        {
        case 1: // '\001'
        case 3: // '\003'
            aGa._mth02CA(true, algorithmparameterspec);
            return;

        case 2: // '\002'
        case 4: // '\004'
            aGa._mth02CA(false, algorithmparameterspec);
            return;
        }
        System.out.println("eeek!");
    }

    protected void engineSetMode(String s)
    {
        if (!s.equalsIgnoreCase("ECB"))
        {
            throw new IllegalArgumentException((new StringBuilder("can't support mode ")).append(s).toString());
        } else
        {
            return;
        }
    }

    protected void engineSetPadding(String s)
    {
        if (!s.equalsIgnoreCase("NoPadding"))
        {
            throw new NoSuchPaddingException((new StringBuilder("Padding ")).append(s).append(" unknown.").toString());
        } else
        {
            return;
        }
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
        if (i == 3)
        {
            return new SecretKeySpec(abyte0, s);
        }
        if (!s.equals("") || i != 2)
        {
            break MISSING_BLOCK_LABEL_142;
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
            break MISSING_BLOCK_LABEL_169;
        }
        abyte0 = s.generatePublic(new X509EncodedKeySpec(abyte0));
        return abyte0;
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        abyte0 = s.generatePrivate(new PKCS8EncodedKeySpec(abyte0));
        return abyte0;
        throw new InvalidKeyException((new StringBuilder("Unknown key type ")).append(i).toString());
    }

    protected int engineUpdate(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        try
        {
            aGa._mth02CB(abyte0, i, j, abyte1, k);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new ShortBufferException(abyte0.getMessage());
        }
        return j;
    }

    protected byte[] engineUpdate(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[j];
        aGa._mth02CB(abyte0, i, j, abyte1, 0);
        return abyte1;
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
