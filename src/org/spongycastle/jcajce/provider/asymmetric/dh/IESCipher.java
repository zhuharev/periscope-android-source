// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
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
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.generators.DHKeyPairGenerator;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.parsers.DHIESPublicKeyParser;
import org.spongycastle.jcajce.provider.asymmetric.util.DHUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class IESCipher extends CipherSpi
{
    public static class IES extends IESCipher
    {

        public IES()
        {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class IESwithAES extends IESCipher
    {

        public IESwithAES()
        {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new AESEngine())));
        }
    }

    public static class IESwithDESede extends IESCipher
    {

        public IESwithDESede()
        {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new DESedeEngine())));
        }
    }


    private IESEngine aCL;
    private ByteArrayOutputStream aCM;
    private AlgorithmParameters aCN;
    private IESParameterSpec aCO;
    private AsymmetricKeyParameter aCP;
    private boolean aCQ;
    private AsymmetricKeyParameter aCR;
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
    }

    public int engineDoFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        abyte0 = engineDoFinal(abyte0, i, j);
        System.arraycopy(abyte0, 0, abyte1, k, abyte0.length);
        return abyte0.length;
    }

    public byte[] engineDoFinal(byte abyte0[], int i, int j)
    {
        IESWithCipherParameters ieswithcipherparameters;
        Object obj;
label0:
        {
            if (j != 0)
            {
                aCM.write(abyte0, i, j);
            }
            abyte0 = aCM.toByteArray();
            aCM.reset();
            ieswithcipherparameters = new IESWithCipherParameters(Arrays._mth1D4C(aCO.axp), Arrays._mth1D4C(aCO.axq), aCO.axr, aCO.axs);
            obj = ((DHKeyParameters)aCP).axb;
            if (aCR == null)
            {
                break label0;
            }
            AsymmetricKeyParameter asymmetrickeyparameter1;
            AsymmetricKeyParameter asymmetrickeyparameter4;
            try
            {
                if (state == 1 || state == 3)
                {
                    obj = aCL;
                    AsymmetricKeyParameter asymmetrickeyparameter = aCR;
                    AsymmetricKeyParameter asymmetrickeyparameter3 = aCP;
                    obj.amy = true;
                    obj.arQ = asymmetrickeyparameter;
                    obj.arR = asymmetrickeyparameter3;
                    obj.anr = new byte[0];
                    ((IESEngine) (obj))._mth02CE(ieswithcipherparameters);
                    break MISSING_BLOCK_LABEL_216;
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
        asymmetrickeyparameter4 = aCR;
        obj.amy = false;
        obj.arQ = asymmetrickeyparameter1;
        obj.arR = asymmetrickeyparameter4;
        obj.anr = new byte[0];
        ((IESEngine) (obj))._mth02CE(ieswithcipherparameters);
        abyte0 = aCL._mth1FBE(abyte0, 0, abyte0.length);
        return abyte0;
        if (state == 1 || state == 3)
        {
            DHKeyPairGenerator dhkeypairgenerator = new DHKeyPairGenerator();
            dhkeypairgenerator.atT = (DHKeyGenerationParameters)new DHKeyGenerationParameters(amC, ((DHParameters) (obj)));
            obj = new EphemeralKeyPairGenerator(dhkeypairgenerator, new _cls1());
            try
            {
                IESEngine iesengine1 = aCL;
                AsymmetricKeyParameter asymmetrickeyparameter5 = aCP;
                iesengine1.amy = true;
                iesengine1.arR = asymmetrickeyparameter5;
                iesengine1.arT = ((EphemeralKeyPairGenerator) (obj));
                iesengine1._mth02CE(ieswithcipherparameters);
                abyte0 = aCL._mth1FBE(abyte0, 0, abyte0.length);
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
                IESEngine iesengine = aCL;
                AsymmetricKeyParameter asymmetrickeyparameter2 = aCP;
                DHIESPublicKeyParser dhiespublickeyparser = new DHIESPublicKeyParser(((DHKeyParameters)aCP).axb);
                iesengine.amy = false;
                iesengine.arQ = asymmetrickeyparameter2;
                iesengine.arU = dhiespublickeyparser;
                iesengine._mth02CE(ieswithcipherparameters);
                abyte0 = aCL._mth1FBE(abyte0, 0, abyte0.length);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new BadPaddingException(abyte0.getMessage());
            }
            return abyte0;
        } else
        {
            throw new IllegalStateException("IESCipher not initialised");
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
        if (key instanceof DHKey)
        {
            return ((DHKey)key).getParams().getP().bitLength();
        } else
        {
            throw new IllegalArgumentException("not a DH key");
        }
    }

    public int engineGetOutputSize(int i)
    {
        int j = aCL.arN._mth14B3();
        int k;
        if (aCP != null)
        {
            k = ((DHKey)aCP).getParams().getP().bitLength() / 8 + 1;
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
            throw new IllegalStateException("IESCipher not initialised");
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
        if (i == 1 || i == 3)
        {
            if (key instanceof DHPublicKey)
            {
                aCP = DHUtil._mth02CE((PublicKey)key);
            } else
            if (key instanceof IESKey)
            {
                key = (IESKey)key;
                aCP = DHUtil._mth02CE(key.getPublic());
                aCR = DHUtil._mth02CE(key.getPrivate());
            } else
            {
                throw new InvalidKeyException("must be passed recipient's public DH key for encryption");
            }
        } else
        if (i == 2 || i == 4)
        {
            if (key instanceof DHPrivateKey)
            {
                aCP = DHUtil._mth02CE((PrivateKey)key);
            } else
            if (key instanceof IESKey)
            {
                key = (IESKey)key;
                aCR = DHUtil._mth02CE(key.getPublic());
                aCP = DHUtil._mth02CE(key.getPrivate());
            } else
            {
                throw new InvalidKeyException("must be passed recipient's private DH key for decryption");
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

        private IESCipher aCS;

        public final byte[] _mth02CA(AsymmetricKeyParameter asymmetrickeyparameter)
        {
            byte abyte0[] = new byte[(((DHKeyParameters)asymmetrickeyparameter).axb.amM.bitLength() + 7) / 8];
            asymmetrickeyparameter = BigIntegers._mth02D1(((DHPublicKeyParameters)asymmetrickeyparameter).axe);
            if (asymmetrickeyparameter.length > abyte0.length)
            {
                throw new IllegalArgumentException("Senders's public key longer than expected.");
            } else
            {
                System.arraycopy(asymmetrickeyparameter, 0, abyte0, abyte0.length - asymmetrickeyparameter.length, asymmetrickeyparameter.length);
                return abyte0;
            }
        }

        _cls1()
        {
            aCS = IESCipher.this;
            super();
        }
    }

}
