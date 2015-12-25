// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.NoSuchPaddingException;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.parsers.ECIESPublicKeyParser;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.spongycastle.jce.interfaces.ECKey;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class IESCipher extends CipherSpi
{
    public static class ECIES extends IESCipher
    {

        public ECIES()
        {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class ECIESwithAES extends IESCipher
    {

        public ECIESwithAES()
        {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new AESEngine())));
        }
    }

    public static class ECIESwithAESCBC extends IESCipher
    {

        public ECIESwithAESCBC()
        {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()))), 16);
        }
    }

    public static class ECIESwithDESede extends IESCipher
    {

        public ECIESwithDESede()
        {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new DESedeEngine())));
        }
    }

    public static class ECIESwithDESedeCBC extends IESCipher
    {

        public ECIESwithDESedeCBC()
        {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new CBCBlockCipher(new DESedeEngine()))), 8);
        }
    }


    private IESEngine aCL;
    private ByteArrayOutputStream aCM;
    private AlgorithmParameters aCN;
    private IESParameterSpec aCO;
    private AsymmetricKeyParameter aCP;
    private boolean aCQ;
    private AsymmetricKeyParameter aCR;
    private int aDn;
    private SecureRandom amC;
    private int state;

    public IESCipher(IESEngine iesengine)
    {
        state = -1;
        aCM = new ByteArrayOutputStream();
        aCN = null;
        aCO = null;
        aCQ = false;
        aCR = null;
        aCL = iesengine;
        aDn = 0;
    }

    public IESCipher(IESEngine iesengine, int i)
    {
        state = -1;
        aCM = new ByteArrayOutputStream();
        aCN = null;
        aCO = null;
        aCQ = false;
        aCR = null;
        aCL = iesengine;
        aDn = i;
    }

    public int engineDoFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        abyte0 = engineDoFinal(abyte0, i, j);
        System.arraycopy(abyte0, 0, abyte1, k, abyte0.length);
        return abyte0.length;
    }

    public byte[] engineDoFinal(byte abyte0[], int i, int j)
    {
        Object obj;
        byte abyte1[];
label0:
        {
            if (j != 0)
            {
                aCM.write(abyte0, i, j);
            }
            abyte1 = aCM.toByteArray();
            aCM.reset();
            obj = new IESWithCipherParameters(Arrays._mth1D4C(aCO.axp), Arrays._mth1D4C(aCO.axq), aCO.axr, aCO.axs);
            abyte0 = ((byte []) (obj));
            if (Arrays._mth1D4C(aCO.XD) != null)
            {
                abyte0 = new ParametersWithIV(((org.spongycastle.crypto.CipherParameters) (obj)), Arrays._mth1D4C(aCO.XD));
            }
            obj = ((ECKeyParameters)aCP).aub;
            if (aCR == null)
            {
                break label0;
            }
            AsymmetricKeyParameter asymmetrickeyparameter1;
            AsymmetricKeyParameter asymmetrickeyparameter3;
            try
            {
                if (state == 1 || state == 3)
                {
                    obj = aCL;
                    AsymmetricKeyParameter asymmetrickeyparameter = aCR;
                    AsymmetricKeyParameter asymmetrickeyparameter2 = aCP;
                    obj.amy = true;
                    obj.arQ = asymmetrickeyparameter;
                    obj.arR = asymmetrickeyparameter2;
                    obj.anr = new byte[0];
                    ((IESEngine) (obj))._mth02CE(abyte0);
                    break MISSING_BLOCK_LABEL_251;
                }
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new BadPaddingException(abyte0.getMessage());
            }
        }
        obj = aCL;
        asymmetrickeyparameter1 = aCP;
        asymmetrickeyparameter3 = aCR;
        obj.amy = false;
        obj.arQ = asymmetrickeyparameter1;
        obj.arR = asymmetrickeyparameter3;
        obj.anr = new byte[0];
        ((IESEngine) (obj))._mth02CE(abyte0);
        abyte0 = aCL._mth1FBE(abyte1, 0, abyte1.length);
        return abyte0;
        if (state == 1 || state == 3)
        {
            ECKeyPairGenerator eckeypairgenerator = new ECKeyPairGenerator();
            eckeypairgenerator._mth02CA(new ECKeyGenerationParameters(((org.spongycastle.crypto.params.ECDomainParameters) (obj)), amC));
            obj = new EphemeralKeyPairGenerator(eckeypairgenerator, new _cls1());
            try
            {
                IESEngine iesengine = aCL;
                AsymmetricKeyParameter asymmetrickeyparameter4 = aCP;
                iesengine.amy = true;
                iesengine.arR = asymmetrickeyparameter4;
                iesengine.arT = ((EphemeralKeyPairGenerator) (obj));
                iesengine._mth02CE(abyte0);
                abyte0 = aCL._mth1FBE(abyte1, 0, abyte1.length);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new BadPaddingException(abyte0.getMessage());
            }
            return abyte0;
        }
        if (state == 2 || state == 4)
        {
            try
            {
                IESEngine iesengine1 = aCL;
                AsymmetricKeyParameter asymmetrickeyparameter5 = aCP;
                obj = new ECIESPublicKeyParser(((org.spongycastle.crypto.params.ECDomainParameters) (obj)));
                iesengine1.amy = false;
                iesengine1.arQ = asymmetrickeyparameter5;
                iesengine1.arU = ((org.spongycastle.crypto.KeyParser) (obj));
                iesengine1._mth02CE(abyte0);
                abyte0 = aCL._mth1FBE(abyte1, 0, abyte1.length);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new BadPaddingException(abyte0.getMessage());
            }
            return abyte0;
        } else
        {
            throw new IllegalStateException("cipher not initialised");
        }
    }

    public int engineGetBlockSize()
    {
        if (aCL.arO != null)
        {
            return aCL.arO.getBlockSize();
        } else
        {
            return 0;
        }
    }

    public byte[] engineGetIV()
    {
        return null;
    }

    public int engineGetKeySize(Key key)
    {
        if (key instanceof ECKey)
        {
            return ((ECKey)key)._mth15A7().alm.getFieldSize();
        } else
        {
            throw new IllegalArgumentException("not an EC key");
        }
    }

    public int engineGetOutputSize(int i)
    {
        int j = aCL.arN._mth14B3();
        int k;
        if (aCP != null)
        {
            k = ((((ECKey)aCP)._mth15A7().alm.getFieldSize() + 7) * 2) / 8 + 1;
        } else
        {
            throw new IllegalStateException("cipher not initialised");
        }
        if (aCL.arO != null)
        {
            if (state == 1 || state == 3)
            {
                i = aCL.arO.getOutputSize(i);
            } else
            if (state == 2 || state == 4)
            {
                i = aCL.arO.getOutputSize(i - j - k);
            } else
            {
                throw new IllegalStateException("cipher not initialised");
            }
        }
        if (state == 1 || state == 3)
        {
            return aCM.size() + j + k + i;
        }
        if (state == 2 || state == 4)
        {
            return (aCM.size() - j - k) + i;
        } else
        {
            throw new IllegalStateException("cipher not initialised");
        }
    }

    public AlgorithmParameters engineGetParameters()
    {
        if (aCN == null && aCO != null)
        {
            try
            {
                aCN = AlgorithmParameters.getInstance("IES", "SC");
                aCN.init(aCO);
            }
            catch (Exception exception)
            {
                throw new RuntimeException(exception.toString());
            }
        }
        return aCN;
    }

    public void engineInit(int i, Key key, AlgorithmParameters algorithmparameters, SecureRandom securerandom)
    {
        AlgorithmParameterSpec algorithmparameterspec = null;
        if (algorithmparameters != null)
        {
            try
            {
                algorithmparameterspec = algorithmparameters.getParameterSpec(org/spongycastle/jce/spec/IESParameterSpec);
            }
            // Misplaced declaration of an exception variable
            catch (Key key)
            {
                throw new InvalidAlgorithmParameterException((new StringBuilder("cannot recognise parameters: ")).append(key.toString()).toString());
            }
        }
        aCN = algorithmparameters;
        engineInit(i, key, algorithmparameterspec, securerandom);
    }

    public void engineInit(int i, Key key, SecureRandom securerandom)
    {
        try
        {
            engineInit(i, key, ((AlgorithmParameterSpec) (null)), securerandom);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new IllegalArgumentException("can't handle supplied parameter spec");
        }
    }

    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        aCR = null;
        if (algorithmparameterspec == null)
        {
            aCO = IESUtil._mth02CA(aCL);
        } else
        if (algorithmparameterspec instanceof IESParameterSpec)
        {
            aCO = (IESParameterSpec)algorithmparameterspec;
        } else
        {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        algorithmparameterspec = Arrays._mth1D4C(aCO.XD);
        if (algorithmparameterspec != null)
        {
            if (aDn == 0)
            {
                throw new InvalidAlgorithmParameterException("NONCE present in IES Parameters when none required");
            }
            if (algorithmparameterspec.length != aDn)
            {
                throw new InvalidAlgorithmParameterException((new StringBuilder("NONCE in IES Parameters needs to be ")).append(aDn).append(" bytes long").toString());
            }
        }
        if (i == 1 || i == 3)
        {
            if (key instanceof ECPublicKey)
            {
                aCP = ECUtil._mth02CF((PublicKey)key);
            } else
            if (key instanceof IESKey)
            {
                key = (IESKey)key;
                aCP = ECUtil._mth02CF(key.getPublic());
                aCR = ECUtil._mth02CF(key.getPrivate());
            } else
            {
                throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
            }
        } else
        if (i == 2 || i == 4)
        {
            if (key instanceof ECPrivateKey)
            {
                aCP = ECUtil._mth02CF((PrivateKey)key);
            } else
            if (key instanceof IESKey)
            {
                key = (IESKey)key;
                aCR = ECUtil._mth02CF(key.getPublic());
                aCP = ECUtil._mth02CF(key.getPrivate());
            } else
            {
                throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
            }
        } else
        {
            throw new InvalidKeyException("must be passed EC key");
        }
        amC = securerandom;
        state = i;
        aCM.reset();
    }

    public void engineSetMode(String s)
    {
        String s1 = Strings.FE7C(s);
        if (s1.equals("NONE"))
        {
            aCQ = false;
            return;
        }
        if (s1.equals("DHAES"))
        {
            aCQ = true;
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("can't support mode ")).append(s).toString());
        }
    }

    public void engineSetPadding(String s)
    {
        s = Strings.FE7C(s);
        if (!s.equals("NOPADDING") && !s.equals("PKCS5PADDING") && !s.equals("PKCS7PADDING"))
        {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        } else
        {
            return;
        }
    }

    public int engineUpdate(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        aCM.write(abyte0, i, j);
        return 0;
    }

    public byte[] engineUpdate(byte abyte0[], int i, int j)
    {
        aCM.write(abyte0, i, j);
        return null;
    }

    private class _cls1
        implements KeyEncoder
    {

        private IESCipher aDo;

        public final byte[] _mth02CA(AsymmetricKeyParameter asymmetrickeyparameter)
        {
            return ((ECPublicKeyParameters)asymmetrickeyparameter).axk.getEncoded();
        }

        _cls1()
        {
            aDo = IESCipher.this;
            super();
        }
    }

}
