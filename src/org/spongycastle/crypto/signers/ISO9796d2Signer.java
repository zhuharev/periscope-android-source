// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.SignerWithRecovery;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.Integers;

public class ISO9796d2Signer
    implements SignerWithRecovery
{

    private static Hashtable azf;
    private Digest amS;
    private AsymmetricBlockCipher amx;
    private int azh;
    private byte azi[];
    private int azj;
    private boolean azk;
    private byte azl[];
    private int azq;
    private byte kv[];

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricblockcipher, Digest digest, boolean flag)
    {
        amx = asymmetricblockcipher;
        amS = digest;
        azq = 188;
    }

    private boolean _mth037A(byte abyte0[], byte abyte1[])
    {
        boolean flag1 = true;
        boolean flag = true;
        if (azj > azi.length)
        {
            if (azi.length > abyte1.length)
            {
                flag = false;
            }
            for (int i = 0; i != azi.length; i++)
            {
                if (abyte0[i] != abyte1[i])
                {
                    flag = false;
                }
            }

            return flag;
        }
        flag = flag1;
        if (azj != abyte1.length)
        {
            flag = false;
        }
        for (int j = 0; j != abyte1.length; j++)
        {
            if (abyte0[j] != abyte1[j])
            {
                flag = false;
            }
        }

        return flag;
    }

    private static void _mth14BD(byte abyte0[])
    {
        for (int i = 0; i != abyte0.length; i++)
        {
            abyte0[i] = 0;
        }

    }

    private boolean _mth1507(byte abyte0[])
    {
        byte abyte1[] = azi;
        for (int i = 0; i != abyte1.length; i++)
        {
            abyte1[i] = 0;
        }

        for (int j = 0; j != abyte0.length; j++)
        {
            abyte0[j] = 0;
        }

        return false;
    }

    public final void update(byte byte0)
    {
        amS.update(byte0);
        if (azj < azi.length)
        {
            azi[azj] = byte0;
        }
        azj = azj + 1;
    }

    public final void update(byte abyte0[], int i, int j)
    {
        for (; j > 0 && azj < azi.length; j--)
        {
            update(abyte0[i]);
            i++;
        }

        amS.update(abyte0, i, j);
        azj = azj + j;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        cipherparameters = (RSAKeyParameters)cipherparameters;
        amx._mth02CA(flag, cipherparameters);
        azh = ((RSAKeyParameters) (cipherparameters)).adi.bitLength();
        kv = new byte[(azh + 7) / 8];
        if (azq == 188)
        {
            azi = new byte[kv.length - amS._mth14AF() - 2];
        } else
        {
            azi = new byte[kv.length - amS._mth14AF() - 3];
        }
        amS.reset();
        azj = 0;
        cipherparameters = azi;
        for (int i = 0; i != cipherparameters.length; i++)
        {
            cipherparameters[i] = 0;
        }

        if (azl != null)
        {
            cipherparameters = azl;
            for (int j = 0; j != cipherparameters.length; j++)
            {
                cipherparameters[j] = 0;
            }

        }
        azl = null;
        azk = false;
    }

    public final byte[] _mth14B6()
    {
        int i1 = amS._mth14AF();
        int i;
        int l;
        if (azq == 188)
        {
            l = 8;
            i = kv.length - i1 - 1;
            amS.doFinal(kv, i);
            kv[kv.length - 1] = -68;
        } else
        {
            l = 16;
            i = kv.length - i1 - 2;
            amS.doFinal(kv, i);
            kv[kv.length - 2] = (byte)(azq >>> 8);
            kv[kv.length - 1] = (byte)azq;
        }
        l = ((azj + i1 << 3) + l + 4) - azh;
        if (l > 0)
        {
            int l1 = azj - (l + 7) / 8;
            l = 96;
            int j1 = i - l1;
            System.arraycopy(azi, 0, kv, j1, l1);
            i = l;
            l = j1;
        } else
        {
            byte byte0 = 64;
            l = i - azj;
            System.arraycopy(azi, 0, kv, l, azj);
            i = byte0;
        }
        if (l - 1 > 0)
        {
            for (int k1 = l - 1; k1 != 0; k1--)
            {
                kv[k1] = -69;
            }

            byte abyte0[] = kv;
            l--;
            abyte0[l] = (byte)(abyte0[l] ^ 1);
            kv[0] = 11;
            abyte0 = kv;
            abyte0[0] = (byte)(abyte0[0] | i);
        } else
        {
            kv[0] = 10;
            byte abyte1[] = kv;
            abyte1[0] = (byte)(abyte1[0] | i);
        }
        byte abyte2[] = amx._mth1FBE(kv, 0, kv.length);
        byte abyte3[] = azi;
        for (int j = 0; j != abyte3.length; j++)
        {
            abyte3[j] = 0;
        }

        abyte3 = kv;
        for (int k = 0; k != abyte3.length; k++)
        {
            abyte3[k] = 0;
        }

        return abyte2;
    }

    public final boolean FE73(byte abyte0[])
    {
        try
        {
            abyte0 = amx._mth1FBE(abyte0, 0, abyte0.length);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return false;
        }
        if ((abyte0[0] & 0xc0 ^ 0x40) != 0)
        {
            byte abyte1[] = azi;
            for (int i = 0; i != abyte1.length; i++)
            {
                abyte1[i] = 0;
            }

            for (int j = 0; j != abyte0.length; j++)
            {
                abyte0[j] = 0;
            }

            return false;
        }
        if ((abyte0[abyte0.length - 1] & 0xf ^ 0xc) != 0)
        {
            byte abyte2[] = azi;
            for (int k = 0; k != abyte2.length; k++)
            {
                abyte2[k] = 0;
            }

            for (int l = 0; l != abyte0.length; l++)
            {
                abyte0[l] = 0;
            }

            return false;
        }
        int i1;
        if ((abyte0[abyte0.length - 1] & 0xff ^ 0xbc) == 0)
        {
            i1 = 1;
        } else
        {
            i1 = (abyte0[abyte0.length - 2] & 0xff) << 8 | abyte0[abyte0.length - 1] & 0xff;
            Integer integer = (Integer)azf.get(amS._mth14AC());
            if (integer != null)
            {
                if (i1 != integer.intValue())
                {
                    throw new IllegalStateException((new StringBuilder("signer initialised with wrong digest for trailer ")).append(i1).toString());
                }
            } else
            {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
            i1 = 2;
        }
        int l1;
        for (l1 = 0; l1 != abyte0.length && (abyte0[l1] & 0xf ^ 0xa) != 0; l1++) { }
        int i2 = l1 + 1;
        byte abyte3[] = new byte[amS._mth14AF()];
        int j2 = abyte0.length - i1 - abyte3.length;
        if (j2 - i2 <= 0)
        {
            return _mth1507(abyte0);
        }
        if ((abyte0[0] & 0x20) == 0)
        {
            azk = true;
            if (azj > j2 - i2)
            {
                return _mth1507(abyte0);
            }
            amS.reset();
            amS.update(abyte0, i2, j2 - i2);
            amS.doFinal(abyte3, 0);
            boolean flag = true;
            for (int j1 = 0; j1 != abyte3.length; j1++)
            {
                int k2 = j2 + j1;
                abyte0[k2] = (byte)(abyte0[k2] ^ abyte3[j1]);
                if (abyte0[j2 + j1] != 0)
                {
                    flag = false;
                }
            }

            if (!flag)
            {
                return _mth1507(abyte0);
            }
            azl = new byte[j2 - i2];
            System.arraycopy(abyte0, i2, azl, 0, azl.length);
        } else
        {
            azk = false;
            amS.doFinal(abyte3, 0);
            boolean flag1 = true;
            for (int k1 = 0; k1 != abyte3.length; k1++)
            {
                int l2 = j2 + k1;
                abyte0[l2] = (byte)(abyte0[l2] ^ abyte3[k1]);
                if (abyte0[j2 + k1] != 0)
                {
                    flag1 = false;
                }
            }

            if (!flag1)
            {
                return _mth1507(abyte0);
            }
            azl = new byte[j2 - i2];
            System.arraycopy(abyte0, i2, azl, 0, azl.length);
        }
        if (azj != 0 && !_mth037A(azi, azl))
        {
            return _mth1507(abyte0);
        } else
        {
            _mth14BD(azi);
            _mth14BD(abyte0);
            return true;
        }
    }

    static 
    {
        Hashtable hashtable = new Hashtable();
        azf = hashtable;
        hashtable.put("RIPEMD128", Integers.valueOf(13004));
        azf.put("RIPEMD160", Integers.valueOf(12748));
        azf.put("SHA-1", Integers.valueOf(13260));
        azf.put("SHA-256", Integers.valueOf(13516));
        azf.put("SHA-384", Integers.valueOf(14028));
        azf.put("SHA-512", Integers.valueOf(13772));
        azf.put("Whirlpool", Integers.valueOf(14284));
    }
}
