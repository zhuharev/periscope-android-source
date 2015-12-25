// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSABlindingParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class PSSSigner
    implements Signer
{

    private byte aaN[];
    private SecureRandom amC;
    private AsymmetricBlockCipher amx;
    public Digest azr;
    private Digest azs;
    private int azt;
    private int azu;
    private int azv;
    private int azw;
    private byte azx[];
    private byte azy;
    private byte kv[];

    public PSSSigner(AsymmetricBlockCipher asymmetricblockcipher, Digest digest, Digest digest1, int i, byte byte0)
    {
        amx = asymmetricblockcipher;
        azr = digest;
        azs = digest1;
        azt = digest._mth14AF();
        azu = digest1._mth14AF();
        azv = i;
        aaN = new byte[i];
        azx = new byte[i + 8 + azt];
        azy = byte0;
    }

    private byte[] _mth02CA(byte abyte0[], int i, int j, int k)
    {
        byte abyte1[] = new byte[k];
        byte abyte2[] = new byte[azu];
        byte abyte3[] = new byte[4];
        int l = 0;
        azs.reset();
        for (; l < k / azu; l++)
        {
            abyte3[0] = l >> 24;
            abyte3[1] = (byte)(l >>> 16);
            abyte3[2] = (byte)(l >>> 8);
            abyte3[3] = (byte)l;
            azs.update(abyte0, i, j);
            azs.update(abyte3, 0, 4);
            azs.doFinal(abyte2, 0);
            System.arraycopy(abyte2, 0, abyte1, azu * l, azu);
        }

        if (azu * l < k)
        {
            abyte3[0] = l >> 24;
            abyte3[1] = (byte)(l >>> 16);
            abyte3[2] = (byte)(l >>> 8);
            abyte3[3] = (byte)l;
            azs.update(abyte0, i, j);
            azs.update(abyte3, 0, 4);
            azs.doFinal(abyte2, 0);
            System.arraycopy(abyte2, 0, abyte1, azu * l, abyte1.length - azu * l);
        }
        return abyte1;
    }

    public final void update(byte byte0)
    {
        azr.update(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        azr.update(abyte0, i, j);
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        CipherParameters cipherparameters1;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters = (ParametersWithRandom)cipherparameters;
            cipherparameters1 = ((ParametersWithRandom) (cipherparameters)).axC;
            amC = ((ParametersWithRandom) (cipherparameters)).amC;
        } else
        {
            cipherparameters1 = cipherparameters;
            if (flag)
            {
                amC = new SecureRandom();
                cipherparameters1 = cipherparameters;
            }
        }
        amx._mth02CA(flag, cipherparameters1);
        if (cipherparameters1 instanceof RSABlindingParameters)
        {
            cipherparameters = (RSABlindingParameters)cipherparameters1;
            cipherparameters = null;
        } else
        {
            cipherparameters = (RSAKeyParameters)cipherparameters1;
        }
        azw = ((RSAKeyParameters) (cipherparameters)).adi.bitLength() - 1;
        if (azw < azt * 8 + azv * 8 + 9)
        {
            throw new IllegalArgumentException("key too small for specified hash and salt lengths");
        } else
        {
            kv = new byte[(azw + 7) / 8];
            azr.reset();
            return;
        }
    }

    public final byte[] _mth14B6()
    {
        azr.doFinal(azx, azx.length - azt - azv);
        if (azv != 0)
        {
            amC.nextBytes(aaN);
            System.arraycopy(aaN, 0, azx, azx.length - azv, azv);
        }
        byte abyte0[] = new byte[azt];
        azr.update(azx, 0, azx.length);
        azr.doFinal(abyte0, 0);
        kv[kv.length - azv - 1 - azt - 1] = 1;
        System.arraycopy(aaN, 0, kv, kv.length - azv - azt - 1, azv);
        byte abyte1[] = _mth02CA(abyte0, 0, abyte0.length, kv.length - azt - 1);
        for (int i = 0; i != abyte1.length; i++)
        {
            byte abyte2[] = kv;
            abyte2[i] = (byte)(abyte2[i] ^ abyte1[i]);
        }

        abyte1 = kv;
        abyte1[0] = (byte)(abyte1[0] & 255 >> (kv.length << 3) - azw);
        System.arraycopy(abyte0, 0, kv, kv.length - azt - 1, azt);
        kv[kv.length - 1] = azy;
        abyte0 = amx._mth1FBE(kv, 0, kv.length);
        abyte1 = kv;
        for (int j = 0; j != abyte1.length; j++)
        {
            abyte1[j] = 0;
        }

        return abyte0;
    }

    public final boolean FE73(byte abyte0[])
    {
        azr.doFinal(azx, azx.length - azt - azv);
        try
        {
            abyte0 = amx._mth1FBE(abyte0, 0, abyte0.length);
            System.arraycopy(abyte0, 0, kv, kv.length - abyte0.length, abyte0.length);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return false;
        }
        if (kv[kv.length - 1] != azy)
        {
            abyte0 = kv;
            for (int i = 0; i != abyte0.length; i++)
            {
                abyte0[i] = 0;
            }

            return false;
        }
        abyte0 = _mth02CA(kv, kv.length - azt - 1, azt, kv.length - azt - 1);
        for (int j = 0; j != abyte0.length; j++)
        {
            byte abyte1[] = kv;
            abyte1[j] = (byte)(abyte1[j] ^ abyte0[j]);
        }

        abyte0 = kv;
        abyte0[0] = (byte)(abyte0[0] & 255 >> (kv.length << 3) - azw);
        for (int k = 0; k != kv.length - azt - azv - 2; k++)
        {
            if (kv[k] != 0)
            {
                abyte0 = kv;
                for (k = 0; k != abyte0.length; k++)
                {
                    abyte0[k] = 0;
                }

                return false;
            }
        }

        if (kv[kv.length - azt - azv - 2] != 1)
        {
            abyte0 = kv;
            for (int l = 0; l != abyte0.length; l++)
            {
                abyte0[l] = 0;
            }

            return false;
        }
        System.arraycopy(kv, kv.length - azv - azt - 1, azx, azx.length - azv, azv);
        azr.update(azx, 0, azx.length);
        azr.doFinal(azx, azx.length - azt);
        int l1 = kv.length - azt - 1;
        for (int i1 = azx.length - azt; i1 != azx.length; i1++)
        {
            if ((kv[l1] ^ azx[i1]) != 0)
            {
                abyte0 = azx;
                for (i1 = 0; i1 != abyte0.length; i1++)
                {
                    abyte0[i1] = 0;
                }

                abyte0 = kv;
                for (i1 = 0; i1 != abyte0.length; i1++)
                {
                    abyte0[i1] = 0;
                }

                return false;
            }
            l1++;
        }

        abyte0 = azx;
        for (int j1 = 0; j1 != abyte0.length; j1++)
        {
            abyte0[j1] = 0;
        }

        abyte0 = kv;
        for (int k1 = 0; k1 != abyte0.length; k1++)
        {
            abyte0[k1] = 0;
        }

        return true;
    }
}
