// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.encodings;

import java.security.AccessController;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class PKCS1Encoding
    implements AsymmetricBlockCipher
{

    private SecureRandom amC;
    private boolean amy;
    private AsymmetricBlockCipher apO;
    private boolean apS;
    private boolean apT;
    private int apU;
    private byte apV[];

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricblockcipher)
    {
        apU = -1;
        apV = null;
        apO = asymmetricblockcipher;
        apT = _mth1686();
    }

    public PKCS1Encoding(RSABlindedEngine rsablindedengine, byte abyte0[])
    {
        apU = -1;
        apV = null;
        apO = rsablindedengine;
        apT = _mth1686();
        apV = abyte0;
        apU = 48;
    }

    private byte[] _mth02CC(byte abyte0[], int i, int j)
    {
        if (apU != -1)
        {
            if (!apS)
            {
                throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
            }
            byte abyte1[] = apO._mth1FBE(abyte0, i, j);
            if (apV == null)
            {
                abyte0 = new byte[apU];
                amC.nextBytes(abyte0);
            } else
            {
                abyte0 = apV;
            }
            j = abyte1.length;
            i = apO._mth148E();
            if (!amy)
            {
                i -= 10;
            }
            if (j < i)
            {
                throw new InvalidCipherTextException("block truncated");
            }
            if (apT && abyte1.length != apO._mth148E())
            {
                throw new InvalidCipherTextException("block incorrect size");
            }
            int k = apU;
            j = abyte1[0] ^ 2 | 0;
            int l = abyte1.length;
            for (i = 1; i < l - (k + 1); i++)
            {
                int i1 = abyte1[i];
                i1 |= i1 >> 1;
                i1 |= i1 >> 2;
                j |= ((i1 | i1 >> 4) & 1) - 1;
            }

            i = abyte1[abyte1.length - (k + 1)] | j;
            i |= i >> 1;
            i |= i >> 2;
            j = ~(((i | i >> 4) & 1) - 1);
            byte abyte3[] = new byte[apU];
            for (i = 0; i < apU; i++)
            {
                abyte3[i] = (byte)(abyte1[(abyte1.length - apU) + i] & ~j | abyte0[i] & j);
            }

            return abyte3;
        }
        abyte0 = apO._mth1FBE(abyte0, i, j);
        j = abyte0.length;
        i = apO._mth148E();
        if (!amy)
        {
            i -= 10;
        }
        if (j < i)
        {
            throw new InvalidCipherTextException("block truncated");
        }
        j = abyte0[0];
        if (apS)
        {
            if (j != 2)
            {
                throw new InvalidCipherTextException("unknown block type");
            }
        } else
        if (j != 1)
        {
            throw new InvalidCipherTextException("unknown block type");
        }
        if (apT && abyte0.length != apO._mth148E())
        {
            throw new InvalidCipherTextException("block incorrect size");
        }
        i = 1;
        do
        {
            if (i == abyte0.length)
            {
                break;
            }
            byte byte0 = abyte0[i];
            if (byte0 == 0)
            {
                break;
            }
            if (j == 1 && byte0 != -1)
            {
                throw new InvalidCipherTextException("block padding incorrect");
            }
            i++;
        } while (true);
        i++;
        if (i > abyte0.length || i < 10)
        {
            throw new InvalidCipherTextException("no data in block");
        } else
        {
            byte abyte2[] = new byte[abyte0.length - i];
            System.arraycopy(abyte0, i, abyte2, 0, abyte2.length);
            return abyte2;
        }
    }

    private boolean _mth1686()
    {
        String s = (String)AccessController.doPrivileged(new _cls1());
        return s == null || s.equals("true");
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        Object obj;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            obj = (ParametersWithRandom)cipherparameters;
            amC = ((ParametersWithRandom) (obj)).amC;
            obj = (AsymmetricKeyParameter)((ParametersWithRandom) (obj)).axC;
        } else
        {
            amC = new SecureRandom();
            obj = (AsymmetricKeyParameter)cipherparameters;
        }
        apO._mth02CA(flag, cipherparameters);
        apS = ((AsymmetricKeyParameter) (obj)).awQ;
        amy = flag;
    }

    public final int _mth148C()
    {
        int i = apO._mth148C();
        if (amy)
        {
            return i - 10;
        } else
        {
            return i;
        }
    }

    public final int _mth148E()
    {
        int i = apO._mth148E();
        if (amy)
        {
            return i;
        } else
        {
            return i - 10;
        }
    }

    public final byte[] _mth1FBE(byte abyte0[], int i, int j)
    {
        if (amy)
        {
            int k = apO._mth148C();
            if (amy)
            {
                k -= 10;
            }
            if (j > k)
            {
                throw new IllegalArgumentException("input data too large");
            }
            byte abyte1[] = new byte[apO._mth148C()];
            if (apS)
            {
                abyte1[0] = 1;
                for (int l = 1; l != abyte1.length - j - 1; l++)
                {
                    abyte1[l] = -1;
                }

            } else
            {
                amC.nextBytes(abyte1);
                abyte1[0] = 2;
                for (int i1 = 1; i1 != abyte1.length - j - 1; i1++)
                {
                    for (; abyte1[i1] == 0; abyte1[i1] = (byte)amC.nextInt()) { }
                }

            }
            abyte1[abyte1.length - j - 1] = 0;
            System.arraycopy(abyte0, i, abyte1, abyte1.length - j, j);
            return apO._mth1FBE(abyte1, 0, abyte1.length);
        } else
        {
            return _mth02CC(abyte0, i, j);
        }
    }

    private class _cls1
        implements PrivilegedAction
    {

        private PKCS1Encoding apW;

        public Object run()
        {
            return System.getProperty("org.spongycastle.pkcs1.strict");
        }

        _cls1()
        {
            apW = PKCS1Encoding.this;
            super();
        }
    }

}
