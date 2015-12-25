// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            BaseWrapCipher, PBE, BCPBEKey

public class BaseStreamCipher extends BaseWrapCipher
    implements PBE
{

    private Class aDN[] = {
        javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec, javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec
    };
    private int aDn;
    private ParametersWithIV aFK;
    private PBEParameterSpec aFN;
    private String aFO;
    private StreamCipher aGa;

    public BaseStreamCipher(StreamCipher streamcipher, int i)
    {
        aDn = 0;
        aFN = null;
        aFO = null;
        aGa = streamcipher;
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
                key = PBE.Util._mth02CA(bcpbekey, algorithmparameterspec, aGa._mth14AC());
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
            throw new InvalidAlgorithmParameterException("unknown parameter type.");
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
        i;
        JVM INSTR tableswitch 1 4: default 400
    //                   1 403
    //                   2 415
    //                   3 403
    //                   4 415;
           goto _L1 _L2 _L3 _L2 _L3
_L2:
        try
        {
            aGa._mth02CA(true, algorithmparameterspec);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new InvalidKeyException(key.getMessage());
        }
_L3:
        aGa._mth02CA(false, algorithmparameterspec);
        return;
_L1:
        throw new InvalidParameterException((new StringBuilder("unknown opmode ")).append(i).append(" passed").toString());
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
}
