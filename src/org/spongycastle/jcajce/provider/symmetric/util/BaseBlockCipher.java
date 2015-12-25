// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.CTSBlockCipher;
import org.spongycastle.crypto.modes.EAXBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.GOFBBlockCipher;
import org.spongycastle.crypto.modes.OCBBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.spongycastle.crypto.modes.PGPCFBBlockCipher;
import org.spongycastle.crypto.modes.SICBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.ISO10126d2Padding;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.paddings.TBCPadding;
import org.spongycastle.crypto.paddings.X923Padding;
import org.spongycastle.crypto.paddings.ZeroBytePadding;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.crypto.params.RC2Parameters;
import org.spongycastle.crypto.params.RC5Parameters;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.jcajce.spec.RepeatedSecretKeySpec;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            BaseWrapCipher, PBE, BlockCipherProvider, BCPBEKey

public class BaseBlockCipher extends BaseWrapCipher
    implements PBE
{
    static class AEADGenericBlockCipher
        implements GenericBlockCipher
    {

        private static final Constructor aFQ;
        private AEADBlockCipher aFR;

        private static Constructor _mth02C9(Class class1)
        {
            try
            {
                class1 = class1.getConstructor(new Class[] {
                    java/lang/String
                });
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                return null;
            }
            return class1;
        }

        public final int doFinal(byte abyte0[], int i)
        {
            i = aFR.doFinal(abyte0, i);
            return i;
            InvalidCipherTextException invalidciphertextexception;
            invalidciphertextexception;
            if (aFQ == null) goto _L2; else goto _L1
_L1:
            abyte0 = null;
            BadPaddingException badpaddingexception = (BadPaddingException)aFQ.newInstance(new Object[] {
                invalidciphertextexception.getMessage()
            });
            abyte0 = badpaddingexception;
_L4:
            if (abyte0 != null)
            {
                throw abyte0;
            }
_L2:
            throw new BadPaddingException(invalidciphertextexception.getMessage());
            Exception exception;
            exception;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final int getOutputSize(int i)
        {
            return aFR.getOutputSize(i);
        }

        public final void updateAAD(byte abyte0[], int i, int j)
        {
            aFR._mth1428(abyte0, i, j);
        }

        public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
        {
            aFR._mth02CA(flag, cipherparameters);
        }

        public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
        {
            return aFR._mth02CB(abyte0, i, j, abyte1, k);
        }

        public final BlockCipher _mth14AD()
        {
            return aFR._mth14AD();
        }

        public final int _mth1550(int i)
        {
            return aFR._mth1550(i);
        }

        public final boolean _mth1D09()
        {
            return false;
        }

        static 
        {
            Class class1 = BaseBlockCipher.FB35("javax.crypto.AEADBadTagException");
            if (class1 != null)
            {
                aFQ = _mth02C9(class1);
            } else
            {
                aFQ = null;
            }
        }

        AEADGenericBlockCipher(AEADBlockCipher aeadblockcipher)
        {
            aFR = aeadblockcipher;
        }
    }

    static class BufferedGenericBlockCipher
        implements GenericBlockCipher
    {

        private BufferedBlockCipher arO;

        public final int doFinal(byte abyte0[], int i)
        {
            try
            {
                i = arO.doFinal(abyte0, i);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new BadPaddingException(abyte0.getMessage());
            }
            return i;
        }

        public final int getOutputSize(int i)
        {
            return arO.getOutputSize(i);
        }

        public final void updateAAD(byte abyte0[], int i, int j)
        {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
        {
            arO._mth02CA(flag, cipherparameters);
        }

        public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
        {
            return arO._mth02CB(abyte0, i, j, abyte1, k);
        }

        public final BlockCipher _mth14AD()
        {
            return arO._mth14AD();
        }

        public final int _mth1550(int i)
        {
            return arO._mth1550(i);
        }

        public final boolean _mth1D09()
        {
            return !(arO instanceof CTSBlockCipher);
        }

        BufferedGenericBlockCipher(BlockCipher blockcipher)
        {
            arO = new PaddedBufferedBlockCipher(blockcipher);
        }

        BufferedGenericBlockCipher(BlockCipher blockcipher, BlockCipherPadding blockcipherpadding)
        {
            arO = new PaddedBufferedBlockCipher(blockcipher, blockcipherpadding);
        }

        BufferedGenericBlockCipher(BufferedBlockCipher bufferedblockcipher)
        {
            arO = bufferedblockcipher;
        }
    }

    static interface GenericBlockCipher
    {

        public abstract int doFinal(byte abyte0[], int i);

        public abstract int getOutputSize(int i);

        public abstract void updateAAD(byte abyte0[], int i, int j);

        public abstract void _mth02CA(boolean flag, CipherParameters cipherparameters);

        public abstract int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k);

        public abstract BlockCipher _mth14AD();

        public abstract int _mth1550(int i);

        public abstract boolean _mth1D09();
    }


    private static final Class aFr = _mth1D5E("javax.crypto.spec.GCMParameterSpec");
    private Class aDN[];
    private int aDn;
    private BlockCipher aFH;
    private BlockCipherProvider aFI;
    private GenericBlockCipher aFJ;
    private ParametersWithIV aFK;
    private AEADParameters aFL;
    private boolean aFM;
    private PBEParameterSpec aFN;
    private String aFO;
    private String aFP;

    public BaseBlockCipher(BlockCipher blockcipher)
    {
        aDN = (new Class[] {
            javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec, javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec, org/spongycastle/jcajce/spec/GOST28147ParameterSpec, aFr
        });
        aDn = 0;
        aFN = null;
        aFO = null;
        aFP = null;
        aFH = blockcipher;
        aFJ = new BufferedGenericBlockCipher(blockcipher);
    }

    public BaseBlockCipher(BufferedBlockCipher bufferedblockcipher, int i)
    {
        aDN = (new Class[] {
            javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec, javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec, org/spongycastle/jcajce/spec/GOST28147ParameterSpec, aFr
        });
        aDn = 0;
        aFN = null;
        aFO = null;
        aFP = null;
        aFH = bufferedblockcipher._mth14AD();
        aFJ = new BufferedGenericBlockCipher(bufferedblockcipher);
        aDn = i / 8;
    }

    public BaseBlockCipher(CBCBlockCipher cbcblockcipher, int i)
    {
        aDN = (new Class[] {
            javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec, javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec, org/spongycastle/jcajce/spec/GOST28147ParameterSpec, aFr
        });
        aDn = 0;
        aFN = null;
        aFO = null;
        aFP = null;
        aFH = cbcblockcipher;
        aFJ = new BufferedGenericBlockCipher(cbcblockcipher);
        aDn = i / 8;
    }

    public BaseBlockCipher(GCMBlockCipher gcmblockcipher)
    {
        aDN = (new Class[] {
            javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec, javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec, org/spongycastle/jcajce/spec/GOST28147ParameterSpec, aFr
        });
        aDn = 0;
        aFN = null;
        aFO = null;
        aFP = null;
        aFH = gcmblockcipher._mth14AD();
        aDn = aFH.getBlockSize();
        aFJ = new AEADGenericBlockCipher(gcmblockcipher);
    }

    public BaseBlockCipher(BlockCipherProvider blockcipherprovider)
    {
        aDN = (new Class[] {
            javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec, javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec, org/spongycastle/jcajce/spec/GOST28147ParameterSpec, aFr
        });
        aDn = 0;
        aFN = null;
        aFO = null;
        aFP = null;
        aFH = blockcipherprovider._mth1627();
        aFI = blockcipherprovider;
        aFJ = new BufferedGenericBlockCipher(blockcipherprovider._mth1627());
    }

    private static Class _mth1D5E(String s)
    {
        try
        {
            s = org/spongycastle/jcajce/provider/symmetric/util/BaseBlockCipher.getClassLoader().loadClass(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private static boolean _mth1D67(String s)
    {
        return "CCM".equals(s) || "EAX".equals(s) || "GCM".equals(s) || "OCB".equals(s);
    }

    static Class FB35(String s)
    {
        return _mth1D5E(s);
    }

    protected int engineDoFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        int l;
        l = 0;
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        l = aFJ._mth02CB(abyte0, i, j, abyte1, k);
        i = aFJ.doFinal(abyte1, k + l);
        return i + l;
        abyte0;
        throw new ShortBufferException(abyte0.getMessage());
        abyte0;
        throw new IllegalBlockSizeException(abyte0.getMessage());
    }

    protected byte[] engineDoFinal(byte abyte0[], int i, int j)
    {
        int k = 0;
        byte abyte1[] = new byte[engineGetOutputSize(j)];
        if (j != 0)
        {
            k = aFJ._mth02CB(abyte0, i, j, abyte1, 0);
        }
        try
        {
            i = aFJ.doFinal(abyte1, k);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalBlockSizeException(abyte0.getMessage());
        }
        i = k + i;
        if (i == abyte1.length)
        {
            return abyte1;
        } else
        {
            abyte0 = new byte[i];
            System.arraycopy(abyte1, 0, abyte0, 0, i);
            return abyte0;
        }
    }

    protected int engineGetBlockSize()
    {
        return aFH.getBlockSize();
    }

    protected byte[] engineGetIV()
    {
        if (aFL != null)
        {
            return aFL.XD;
        }
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
        return aFJ.getOutputSize(i);
    }

    protected AlgorithmParameters engineGetParameters()
    {
        Exception exception2;
        if (aDC == null)
        {
            if (aFN != null)
            {
                try
                {
                    aDC = AlgorithmParameters.getInstance(aFO, "SC");
                    aDC.init(aFN);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception2)
                {
                    return null;
                }
            } else
            if (aFK != null)
            {
                String s1 = aFJ._mth14AD()._mth14AC();
                String s = s1;
                if (s1.indexOf('/') >= 0)
                {
                    s = s1.substring(0, s1.indexOf('/'));
                }
                try
                {
                    aDC = AlgorithmParameters.getInstance(s, "SC");
                    aDC.init(aFK.iv);
                }
                catch (Exception exception)
                {
                    throw new RuntimeException(exception.toString());
                }
            } else
            if (aFL != null)
            {
                try
                {
                    aDC = AlgorithmParameters.getInstance("GCM", "SC");
                    aDC.init((new GCMParameters(aFL.XD, aFL.auF)).getEncoded());
                }
                catch (Exception exception1)
                {
                    throw new RuntimeException(exception1.toString());
                }
            }
        }
        return aDC;
    }

    protected void engineInit(int i, Key key, AlgorithmParameters algorithmparameters, SecureRandom securerandom)
    {
        AlgorithmParameterSpec algorithmparameterspec1 = null;
        Object obj = null;
        if (algorithmparameters != null)
        {
            int j = 0;
            do
            {
                AlgorithmParameterSpec algorithmparameterspec = obj;
                if (j == aDN.length)
                {
                    break;
                }
                if (aDN[j] != null)
                {
                    try
                    {
                        algorithmparameterspec = algorithmparameters.getParameterSpec(aDN[j]);
                        break;
                    }
                    catch (Exception exception) { }
                }
                j++;
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
        aFL = null;
        if (!(key instanceof SecretKey))
        {
            throw new InvalidKeyException((new StringBuilder("Key for algorithm ")).append(key.getAlgorithm()).append(" not suitable for symmetric enryption.").toString());
        }
        if (algorithmparameterspec == null && aFH._mth14AC().startsWith("RC5-64"))
        {
            throw new InvalidAlgorithmParameterException("RC5 requires an RC5ParametersSpec to be passed in.");
        }
        if (key instanceof BCPBEKey)
        {
            key = (BCPBEKey)key;
            if (((BCPBEKey) (key)).aFE != null)
            {
                aFO = ((BCPBEKey) (key)).aFE.identifier;
            } else
            {
                aFO = key.getAlgorithm();
            }
            if (((BCPBEKey) (key)).aso != null)
            {
                Object obj = ((BCPBEKey) (key)).aso;
                if (algorithmparameterspec instanceof IvParameterSpec)
                {
                    key = new ParametersWithIV(((CipherParameters) (obj)), ((IvParameterSpec)algorithmparameterspec).getIV());
                } else
                {
                    key = ((Key) (obj));
                    if (algorithmparameterspec instanceof GOST28147ParameterSpec)
                    {
                        GOST28147ParameterSpec gost28147parameterspec = (GOST28147ParameterSpec)algorithmparameterspec;
                        obj = new ParametersWithSBox(((CipherParameters) (obj)), gost28147parameterspec.ank);
                        if (gost28147parameterspec.iv == null)
                        {
                            algorithmparameterspec = null;
                        } else
                        {
                            algorithmparameterspec = new byte[gost28147parameterspec.iv.length];
                            System.arraycopy(gost28147parameterspec.iv, 0, algorithmparameterspec, 0, algorithmparameterspec.length);
                        }
                        key = ((Key) (obj));
                        if (algorithmparameterspec != null)
                        {
                            key = ((Key) (obj));
                            if (aDn != 0)
                            {
                                if (gost28147parameterspec.iv == null)
                                {
                                    key = null;
                                } else
                                {
                                    key = new byte[gost28147parameterspec.iv.length];
                                    System.arraycopy(gost28147parameterspec.iv, 0, key, 0, key.length);
                                }
                                key = new ParametersWithIV(((CipherParameters) (obj)), key);
                            }
                        }
                    }
                }
            } else
            if (algorithmparameterspec instanceof PBEParameterSpec)
            {
                aFN = (PBEParameterSpec)algorithmparameterspec;
                key = PBE.Util._mth02CA(key, algorithmparameterspec, aFJ._mth14AD()._mth14AC());
            } else
            {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
            if (key instanceof ParametersWithIV)
            {
                aFK = (ParametersWithIV)key;
            }
            break MISSING_BLOCK_LABEL_1260;
        }
        if (algorithmparameterspec == null)
        {
            key = new KeyParameter(key.getEncoded());
            break MISSING_BLOCK_LABEL_1260;
        }
        if (algorithmparameterspec instanceof IvParameterSpec)
        {
            if (aDn != 0)
            {
                algorithmparameterspec = (IvParameterSpec)algorithmparameterspec;
                if (algorithmparameterspec.getIV().length != aDn && !_mth1D67(aFP))
                {
                    throw new InvalidAlgorithmParameterException((new StringBuilder("IV must be ")).append(aDn).append(" bytes long.").toString());
                }
                if (key instanceof RepeatedSecretKeySpec)
                {
                    key = new ParametersWithIV(null, algorithmparameterspec.getIV());
                    aFK = (ParametersWithIV)key;
                } else
                {
                    key = new ParametersWithIV(new KeyParameter(key.getEncoded()), algorithmparameterspec.getIV());
                    aFK = (ParametersWithIV)key;
                }
            } else
            {
                if (aFP != null && aFP.equals("ECB"))
                {
                    throw new InvalidAlgorithmParameterException("ECB mode does not use an IV");
                }
                key = new KeyParameter(key.getEncoded());
            }
            break MISSING_BLOCK_LABEL_1260;
        }
        if (algorithmparameterspec instanceof GOST28147ParameterSpec)
        {
            GOST28147ParameterSpec gost28147parameterspec1 = (GOST28147ParameterSpec)algorithmparameterspec;
            ParametersWithSBox parameterswithsbox = new ParametersWithSBox(new KeyParameter(key.getEncoded()), ((GOST28147ParameterSpec)algorithmparameterspec).ank);
            if (gost28147parameterspec1.iv == null)
            {
                algorithmparameterspec = null;
            } else
            {
                algorithmparameterspec = new byte[gost28147parameterspec1.iv.length];
                System.arraycopy(gost28147parameterspec1.iv, 0, algorithmparameterspec, 0, algorithmparameterspec.length);
            }
            key = parameterswithsbox;
            if (algorithmparameterspec != null)
            {
                key = parameterswithsbox;
                if (aDn != 0)
                {
                    if (gost28147parameterspec1.iv == null)
                    {
                        key = null;
                    } else
                    {
                        key = new byte[gost28147parameterspec1.iv.length];
                        System.arraycopy(gost28147parameterspec1.iv, 0, key, 0, key.length);
                    }
                    key = new ParametersWithIV(parameterswithsbox, key);
                    aFK = (ParametersWithIV)key;
                }
            }
            break MISSING_BLOCK_LABEL_1260;
        }
        if (algorithmparameterspec instanceof RC2ParameterSpec)
        {
            RC2ParameterSpec rc2parameterspec = (RC2ParameterSpec)algorithmparameterspec;
            algorithmparameterspec = new RC2Parameters(key.getEncoded(), ((RC2ParameterSpec)algorithmparameterspec).getEffectiveKeyBits());
            key = algorithmparameterspec;
            if (rc2parameterspec.getIV() != null)
            {
                key = algorithmparameterspec;
                if (aDn != 0)
                {
                    key = new ParametersWithIV(algorithmparameterspec, rc2parameterspec.getIV());
                    aFK = (ParametersWithIV)key;
                }
            }
            break MISSING_BLOCK_LABEL_1260;
        }
        if (algorithmparameterspec instanceof RC5ParameterSpec)
        {
            RC5ParameterSpec rc5parameterspec = (RC5ParameterSpec)algorithmparameterspec;
            algorithmparameterspec = new RC5Parameters(key.getEncoded(), ((RC5ParameterSpec)algorithmparameterspec).getRounds());
            if (aFH._mth14AC().startsWith("RC5"))
            {
                if (aFH._mth14AC().equals("RC5-32"))
                {
                    if (rc5parameterspec.getWordSize() != 32)
                    {
                        throw new InvalidAlgorithmParameterException((new StringBuilder("RC5 already set up for a word size of 32 not ")).append(rc5parameterspec.getWordSize()).append(".").toString());
                    }
                } else
                if (aFH._mth14AC().equals("RC5-64") && rc5parameterspec.getWordSize() != 64)
                {
                    throw new InvalidAlgorithmParameterException((new StringBuilder("RC5 already set up for a word size of 64 not ")).append(rc5parameterspec.getWordSize()).append(".").toString());
                }
            } else
            {
                throw new InvalidAlgorithmParameterException("RC5 parameters passed to a cipher that is not RC5.");
            }
            key = algorithmparameterspec;
            if (rc5parameterspec.getIV() != null)
            {
                key = algorithmparameterspec;
                if (aDn != 0)
                {
                    key = new ParametersWithIV(algorithmparameterspec, rc5parameterspec.getIV());
                    aFK = (ParametersWithIV)key;
                }
            }
            break MISSING_BLOCK_LABEL_1260;
        }
        if (aFr == null || !aFr.isInstance(algorithmparameterspec))
        {
            break MISSING_BLOCK_LABEL_1249;
        }
        if (!_mth1D67(aFP) && !(aFJ instanceof AEADGenericBlockCipher))
        {
            throw new InvalidAlgorithmParameterException("GCMParameterSpec can only be used with AEAD modes.");
        }
        Method method = aFr.getDeclaredMethod("getTLen", new Class[0]);
        Method method1 = aFr.getDeclaredMethod("getIV", new Class[0]);
        if (key instanceof RepeatedSecretKeySpec)
        {
            key = new AEADParameters(null, ((Integer)method.invoke(algorithmparameterspec, new Object[0])).intValue(), (byte[])method1.invoke(algorithmparameterspec, new Object[0]));
            aFL = key;
            break MISSING_BLOCK_LABEL_1260;
        }
        try
        {
            key = new AEADParameters(new KeyParameter(key.getEncoded()), ((Integer)method.invoke(algorithmparameterspec, new Object[0])).intValue(), (byte[])method1.invoke(algorithmparameterspec, new Object[0]));
            aFL = key;
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new InvalidAlgorithmParameterException("Cannot process GCMParameterSpec.");
        }
        break MISSING_BLOCK_LABEL_1260;
        throw new InvalidAlgorithmParameterException("unknown parameter type.");
        algorithmparameterspec = key;
        if (aDn != 0)
        {
            algorithmparameterspec = key;
            if (!(key instanceof ParametersWithIV))
            {
                algorithmparameterspec = key;
                if (!(key instanceof AEADParameters))
                {
                    algorithmparameterspec = securerandom;
                    if (securerandom == null)
                    {
                        algorithmparameterspec = new SecureRandom();
                    }
                    if (i == 1 || i == 3)
                    {
                        byte abyte0[] = new byte[aDn];
                        algorithmparameterspec.nextBytes(abyte0);
                        algorithmparameterspec = new ParametersWithIV(key, abyte0);
                        aFK = (ParametersWithIV)algorithmparameterspec;
                    } else
                    {
                        algorithmparameterspec = key;
                        if (aFJ._mth14AD()._mth14AC().indexOf("PGPCFB") < 0)
                        {
                            throw new InvalidAlgorithmParameterException("no IV set when one expected");
                        }
                    }
                }
            }
        }
        key = algorithmparameterspec;
        if (securerandom != null)
        {
            key = algorithmparameterspec;
            if (aFM)
            {
                key = new ParametersWithRandom(algorithmparameterspec, securerandom);
            }
        }
        i;
        JVM INSTR tableswitch 1 4: default 1444
    //                   1 1447
    //                   2 1459
    //                   3 1447
    //                   4 1459;
           goto _L1 _L2 _L3 _L2 _L3
_L2:
        try
        {
            aFJ._mth02CA(true, key);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new InvalidKeyException(key.getMessage());
        }
_L3:
        aFJ._mth02CA(false, key);
        return;
_L1:
        throw new InvalidParameterException((new StringBuilder("unknown opmode ")).append(i).append(" passed").toString());
    }

    protected void engineSetMode(String s)
    {
        aFP = Strings.FE7C(s);
        if (aFP.equals("ECB"))
        {
            aDn = 0;
            aFJ = new BufferedGenericBlockCipher(aFH);
            return;
        }
        if (aFP.equals("CBC"))
        {
            aDn = aFH.getBlockSize();
            aFJ = new BufferedGenericBlockCipher(new CBCBlockCipher(aFH));
            return;
        }
        if (aFP.startsWith("OFB"))
        {
            aDn = aFH.getBlockSize();
            if (aFP.length() != 3)
            {
                int i = Integer.parseInt(aFP.substring(3));
                aFJ = new BufferedGenericBlockCipher(new OFBBlockCipher(aFH, i));
                return;
            } else
            {
                aFJ = new BufferedGenericBlockCipher(new OFBBlockCipher(aFH, aFH.getBlockSize() * 8));
                return;
            }
        }
        if (aFP.startsWith("CFB"))
        {
            aDn = aFH.getBlockSize();
            if (aFP.length() != 3)
            {
                int j = Integer.parseInt(aFP.substring(3));
                aFJ = new BufferedGenericBlockCipher(new CFBBlockCipher(aFH, j));
                return;
            } else
            {
                aFJ = new BufferedGenericBlockCipher(new CFBBlockCipher(aFH, aFH.getBlockSize() * 8));
                return;
            }
        }
        if (aFP.startsWith("PGP"))
        {
            boolean flag = aFP.equalsIgnoreCase("PGPCFBwithIV");
            aDn = aFH.getBlockSize();
            aFJ = new BufferedGenericBlockCipher(new PGPCFBBlockCipher(aFH, flag));
            return;
        }
        if (aFP.equalsIgnoreCase("OpenPGPCFB"))
        {
            aDn = 0;
            aFJ = new BufferedGenericBlockCipher(new OpenPGPCFBBlockCipher(aFH));
            return;
        }
        if (aFP.startsWith("SIC"))
        {
            aDn = aFH.getBlockSize();
            if (aDn < 16)
            {
                throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
            } else
            {
                aFJ = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(aFH)));
                return;
            }
        }
        if (aFP.startsWith("CTR"))
        {
            aDn = aFH.getBlockSize();
            aFJ = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(aFH)));
            return;
        }
        if (aFP.startsWith("GOFB"))
        {
            aDn = aFH.getBlockSize();
            aFJ = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(aFH)));
            return;
        }
        if (aFP.startsWith("GCFB"))
        {
            aDn = aFH.getBlockSize();
            aFJ = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(aFH)));
            return;
        }
        if (aFP.startsWith("CTS"))
        {
            aDn = aFH.getBlockSize();
            aFJ = new BufferedGenericBlockCipher(new CTSBlockCipher(new CBCBlockCipher(aFH)));
            return;
        }
        if (aFP.startsWith("CCM"))
        {
            aDn = 13;
            aFJ = new AEADGenericBlockCipher(new CCMBlockCipher(aFH));
            return;
        }
        if (aFP.startsWith("OCB"))
        {
            if (aFI != null)
            {
                aDn = 15;
                aFJ = new AEADGenericBlockCipher(new OCBBlockCipher(aFH, aFI._mth1627()));
                return;
            } else
            {
                throw new NoSuchAlgorithmException((new StringBuilder("can't support mode ")).append(s).toString());
            }
        }
        if (aFP.startsWith("EAX"))
        {
            aDn = aFH.getBlockSize();
            aFJ = new AEADGenericBlockCipher(new EAXBlockCipher(aFH));
            return;
        }
        if (aFP.startsWith("GCM"))
        {
            aDn = aFH.getBlockSize();
            aFJ = new AEADGenericBlockCipher(new GCMBlockCipher(aFH));
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
            if (aFJ._mth1D09())
            {
                aFJ = new BufferedGenericBlockCipher(new BufferedBlockCipher(aFJ._mth14AD()));
                return;
            } else
            {
                return;
            }
        }
        if (s1.equals("WITHCTS"))
        {
            aFJ = new BufferedGenericBlockCipher(new CTSBlockCipher(aFJ._mth14AD()));
            return;
        }
        aFM = true;
        if (_mth1D67(aFP))
        {
            throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
        }
        if (s1.equals("PKCS5PADDING") || s1.equals("PKCS7PADDING"))
        {
            aFJ = new BufferedGenericBlockCipher(aFJ._mth14AD());
            return;
        }
        if (s1.equals("ZEROBYTEPADDING"))
        {
            aFJ = new BufferedGenericBlockCipher(aFJ._mth14AD(), new ZeroBytePadding());
            return;
        }
        if (s1.equals("ISO10126PADDING") || s1.equals("ISO10126-2PADDING"))
        {
            aFJ = new BufferedGenericBlockCipher(aFJ._mth14AD(), new ISO10126d2Padding());
            return;
        }
        if (s1.equals("X9.23PADDING") || s1.equals("X923PADDING"))
        {
            aFJ = new BufferedGenericBlockCipher(aFJ._mth14AD(), new X923Padding());
            return;
        }
        if (s1.equals("ISO7816-4PADDING") || s1.equals("ISO9797-1PADDING"))
        {
            aFJ = new BufferedGenericBlockCipher(aFJ._mth14AD(), new ISO7816d4Padding());
            return;
        }
        if (s1.equals("TBCPADDING"))
        {
            aFJ = new BufferedGenericBlockCipher(aFJ._mth14AD(), new TBCPadding());
            return;
        } else
        {
            throw new NoSuchPaddingException((new StringBuilder("Padding ")).append(s).append(" unknown.").toString());
        }
    }

    protected int engineUpdate(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        try
        {
            i = aFJ._mth02CB(abyte0, i, j, abyte1, k);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new ShortBufferException(abyte0.getMessage());
        }
        return i;
    }

    protected byte[] engineUpdate(byte abyte0[], int i, int j)
    {
        int k = aFJ._mth1550(j);
        if (k > 0)
        {
            byte abyte1[] = new byte[k];
            i = aFJ._mth02CB(abyte0, i, j, abyte1, 0);
            if (i == 0)
            {
                return null;
            }
            if (i != abyte1.length)
            {
                abyte0 = new byte[i];
                System.arraycopy(abyte1, 0, abyte0, 0, i);
                return abyte0;
            } else
            {
                return abyte1;
            }
        } else
        {
            aFJ._mth02CB(abyte0, i, j, null, 0);
            return null;
        }
    }

    protected void engineUpdateAAD(ByteBuffer bytebuffer)
    {
        int i = bytebuffer.arrayOffset();
        int j = bytebuffer.position();
        int k = bytebuffer.limit();
        int l = bytebuffer.position();
        engineUpdateAAD(bytebuffer.array(), i + j, k - l);
    }

    protected void engineUpdateAAD(byte abyte0[], int i, int j)
    {
        aFJ.updateAAD(abyte0, i, j);
    }

}
